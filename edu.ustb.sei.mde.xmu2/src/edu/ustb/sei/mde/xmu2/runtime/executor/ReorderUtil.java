package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.CaseClause;
import edu.ustb.sei.mde.xmu2core.CaseExpressionClause;
import edu.ustb.sei.mde.xmu2core.CasePatternClause;
import edu.ustb.sei.mde.xmu2core.CaseStatement;
import edu.ustb.sei.mde.xmu2core.CaseStatementClause;
import edu.ustb.sei.mde.xmu2core.DeleteLinkStatement;
import edu.ustb.sei.mde.xmu2core.DeleteNodeStatement;
import edu.ustb.sei.mde.xmu2core.EnforceLinkStatement;
import edu.ustb.sei.mde.xmu2core.EnforceNodeStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.ForEachStatement;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.MatchPattern;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.ProcedureCallStatement;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;

public class ReorderUtil {

	static public void reorderStatementsForAlignStatement(List<Statement> statements, ReorderedAlignStatement reorder) {
		for(Statement st : statements) {
			if(st instanceof ProcedureCallStatement) {
				reorder.tail.add(st);
			} else if(st instanceof EnforceNodeStatement) {
				if(ReorderUtil.isEnforceNodeStatementExecutable((EnforceNodeStatement)st, reorder.enforcedVars)) {
					reorder.enforce.add(st);
				} else reorder.lazy.add(st);
			} else if(st instanceof EnforceLinkStatement) {
				if(ReorderUtil.isEnforceLinkStatementExecutable((EnforceLinkStatement)st, reorder.enforcedVars)) {
					reorder.enforce.add(st);
				} else reorder.lazy.add(st);
			} else {
				reorder.enforce.add(st);
			}
		}
	}

	static public ReorderedAlignStatement reorderAlignStatement(AlignStatement align, Context context) {
		//FIXME: ideally, I should calculate the order according to the variable dependencies
		//To achieve this goal, I should calculate the "source-view" variables for each statement
		
		List<Variable> enforcedVars = ReorderUtil.initEnforcedVariables(context);
		
		ReorderedAlignStatement reorder = (ReorderedAlignStatement) context.getEnvironment().getFromOrderCache(enforcedVars, align);
		
		if(reorder==null) {
			reorder = new ReorderedAlignStatement();
			reorder.enforcedVars = enforcedVars;
			
			reorderStatementsForAlignStatement(align.getMatch(), reorder);
			reorderStatementsForAlignStatement(align.getViewCreationStatements(), reorder);
			
			reorder.finalOrder.addAll(reorder.enforce);
			reorder.finalOrder.addAll(reorder.lazy);
			reorder.finalOrder.addAll(reorder.tail);
			
			context.getEnvironment().putIntoOrderCache(enforcedVars, align, reorder);
		}
		return reorder;
	}
	
	static public ReorderedAlignStatement reorderForEachStatement(ForEachStatement foreach, Context context) {
		//FIXME: ideally, I should calculate the order according to the variable dependencies
		//To achieve this goal, I should calculate the "source-view" variables for each statement
		
		List<Variable> enforcedVars = ReorderUtil.initEnforcedVariables(context);
		
		ReorderedAlignStatement reorder = (ReorderedAlignStatement) context.getEnvironment().getFromOrderCache(enforcedVars, foreach);
		
		if(reorder==null) {
			reorder = new ReorderedAlignStatement();
			reorder.enforcedVars = enforcedVars;
			
			reorderStatementsForAlignStatement(foreach.getAction(), reorder);
			
			reorder.finalOrder.addAll(reorder.enforce);
			reorder.finalOrder.addAll(reorder.lazy);
			reorder.finalOrder.addAll(reorder.tail);
			
			context.getEnvironment().putIntoOrderCache(enforcedVars, foreach, reorder);
		}
		return reorder;
	}

	static public List<Variable> initEnforcedVariables(Context context) {
		UniqueEList<Variable> list = new UniqueEList<Variable>();
		
		for(Entry<Variable,SafeType> e : context) {
			if(e.getValue().isUndefined()==false)
				list.add(e.getKey());
		}
		
		return list;
	}

	static public boolean isEnforceLinkStatementExecutable(EnforceLinkStatement stmt, List<Variable> enforcedVars) {
		if(stmt.getTag()==DomainTag.UPDATED_SOURCE) return true;
		try {
			Variable source = stmt.getSource();
			LoopPath selector = stmt.getSelector();
			PositionPath position = stmt.getPosition();
			Expression target = stmt.getTarget();
			
			if(enforcedVars.contains(source)) {
				if(selector!=null) {
					enforcedVars.add(selector.getIterator());
					boolean ret = ReorderUtil.checkExpressionExecutable(selector.getBody(), enforcedVars);
					enforcedVars.remove(selector.getIterator());
					if(ret==false)
						return false;
				}
				
				if(position!=null && position.getValue()!=null) {
					if(ReorderUtil.checkExpressionExecutable(position.getValue(), enforcedVars)==false)
						return false;
				}
				
				return ReorderUtil.checkExpressionExecutable(target, enforcedVars);
			} else
				return false;
	
		} catch(Exception e) {
			return false;
		}
	}

	static public boolean checkExpressionExecutable(Expression target, List<Variable> enforcedVars) {
		TreeIterator<EObject> it = target.eAllContents();
		while(it.hasNext()) {
			EObject o = it.next();
			if(o instanceof VariableExpression) {
				Variable v = ((VariableExpression) o).getVariable();
				if(enforcedVars.contains(v)==false) {
					return false;
				}
			}
		}
		return true;
	}

	static public boolean isEnforceNodeStatementExecutable(EnforceNodeStatement stmt, List<Variable> enforcedVars) {
		if(stmt.getTag()==DomainTag.UPDATED_SOURCE) return true;
		try{
			if(enforcedVars.contains(stmt.getNode())) return true;
			else {
				EClass type = (EClass) stmt.getType();
				if (type.isAbstract()) {
					if (checkExpressionExecutable(stmt.getCandidate(), enforcedVars)) {
						enforcedVars.add(stmt.getNode());
						return true;
					} else
						return false;
				} else {
					enforcedVars.add(stmt.getNode());
					return true;
				}
			}
		} catch(Exception e) {
			return false;
		}
	}

	static public List<ReorderedCaseClause> reorderStatementsForCaseStatement(List<Statement> action, ReorderedCaseClause branch) {
		
		List<ReorderedCaseClause> start = new ArrayList<ReorderedCaseClause>();
		List<ReorderedCaseClause> result =  new ArrayList<ReorderedCaseClause>();
		result.add(branch);
		
		for(Statement s : action) {
			start.clear();
			start.addAll(result);
			result.clear();
			for(ReorderedCaseClause rcc : start) {
				result.addAll(ReorderUtil.reorderStatementForCaseStatement(s, rcc));
			}
		}
		
		return result;
	}

	static public List<ReorderedCaseClause> reorderStatementForCaseStatement(Statement statement, ReorderedCaseClause branch) {
		if(statement instanceof CaseStatement) {
			if(((CaseStatement) statement).getTag()==DomainTag.VIEW) {
				// try to select a branch according to this content
				
				List<ReorderedCaseClause> branches = new ArrayList<ReorderedCaseClause>();
				
				for(CaseClause cc : ((CaseStatement) statement).getClauses()) {
					ReorderedCaseClause nb = branch.clone();
					
					if(cc instanceof CaseStatementClause) {
						nb.preCondition.addAll(((CaseStatementClause) cc).getCondition());
						List<ReorderedCaseClause> newBranches = reorderStatementsForCaseStatement(((CaseStatementClause) cc).getAction(), nb);
						branches.addAll(newBranches);
					} else {
						List<ReorderedCaseClause> newBranches = reorderStatementsForCaseStatement(
								cc.getSourceCheckStatements(), nb);
						for (ReorderedCaseClause newBranch : newBranches) {
							if (cc instanceof CasePatternClause) {
								for (Statement ac : cc.getViewCreationStatements()) {
									if (ac instanceof EnforceNodeStatement) {
										if (isEnforceNodeStatementExecutable((EnforceNodeStatement) ac,
												newBranch.enforcedVariables)) {
											newBranch.action.add(ac);
										} else {
											newBranch.postCondition.add(ac);
										}
									} else if (ac instanceof EnforceLinkStatement) {
										if (isEnforceLinkStatementExecutable((EnforceLinkStatement) ac,
												newBranch.enforcedVariables)) {
											newBranch.action.add(ac);
										} else {
											newBranch.postCondition.add(ac);
										}
									}
								}
							} else if (cc instanceof CaseExpressionClause) {
								newBranch.action.add(((CaseExpressionClause) cc).getCondition());
							} else {
								System.out.println("unhandled branch");
							}
						}

						branches.addAll(newBranches);
					}
				}
				return  branches;
				
			} else {
				List<ReorderedCaseClause> branches = new ArrayList<ReorderedCaseClause>();
				
				for(CaseClause cc : ((CaseStatement) statement).getClauses()) {
					ReorderedCaseClause newBranch = branch.clone();
					
					if(cc instanceof CasePatternClause) {
						newBranch.preCondition.add(((CasePatternClause) cc).getCondition());
					} else if(cc instanceof CaseExpressionClause) {
						newBranch.preCondition.add(((CaseExpressionClause) cc).getCondition());
					} else {
						System.out.println("unhandled branch");
					}
					
					branches.addAll(reorderStatementsForCaseStatement(cc.getAction(), newBranch));
				}
				
				return branches;
			}
		} else if(statement instanceof AlignStatement) {
			branch.action.add(statement);
			return Collections.singletonList(branch);
		} else if(statement instanceof DeleteNodeStatement) {
			branch.preCondition.add(statement);
			return Collections.singletonList(branch);
		} else if(statement instanceof DeleteLinkStatement) {
			branch.preCondition.add(statement);
			return Collections.singletonList(branch);
		} else if(statement instanceof EnforceNodeStatement) {
			if(((EnforceNodeStatement) statement).getTag()==DomainTag.UPDATED_SOURCE) {
				branch.preCondition.add(statement);
				return Collections.singletonList(branch);
			} else {
				if(isEnforceNodeStatementExecutable((EnforceNodeStatement)statement, branch.enforcedVariables)) {
					branch.action.add(statement);
				} else {
					branch.postCondition.add(statement);
				}
				return Collections.singletonList(branch);
			}
		} else if(statement instanceof EnforceLinkStatement) {
			if(((EnforceLinkStatement) statement).getTag()==DomainTag.UPDATED_SOURCE) {
				branch.preCondition.add(statement);
				return Collections.singletonList(branch);
			} else {
				if(isEnforceLinkStatementExecutable((EnforceLinkStatement)statement, branch.enforcedVariables)) {
					branch.action.add(statement);
				} else {
					branch.postCondition.add(statement);
				}
				return Collections.singletonList(branch);
			}
		} else if(statement instanceof ProcedureCallStatement) {
			branch.action.add(statement);
			return Collections.singletonList(branch);
		} else if(statement instanceof ForEachStatement) {
			if(((ForEachStatement) statement).isDerived())
				branch.action.add(statement);
			else
				branch.preCondition.add(statement);
			return Collections.singletonList(branch);
		} else if(statement instanceof MatchPattern) {
			branch.preCondition.add(statement);
			return Collections.singletonList(branch);
		} else {
			branch.action.add(statement);
			return Collections.singletonList(branch);
		}
	}

	static public ReorderedCaseStatement reorderCaseStatement(CaseStatement statement, Context context) {
		List<Variable> enforced = initEnforcedVariables(context);
		ReorderedCaseStatement reorder = (ReorderedCaseStatement)context.getEnvironment().getFromOrderCache(enforced, statement);
		
		if(reorder==null) {
			reorder = new ReorderedCaseStatement();
			ReorderedCaseClause rcc = new ReorderedCaseClause();
			rcc.enforcedVariables = enforced;
			reorder.branches = reorderStatementForCaseStatement(statement,rcc);
			
			for(ReorderedCaseClause cc : reorder.branches) {
				reorderMatchCondition(cc);
			}
			
			context.getEnvironment().putIntoOrderCache(enforced, statement, reorder);
		}
		
		return reorder;
	}

	private static void reorderMatchCondition(ReorderedCaseClause cc) {
		
		
		List<Object> nodeCheck = new ArrayList<Object>();
		for(Object cond : cc.preCondition) {
			if(cond instanceof EnforceNodeStatement) {
				nodeCheck.add(cond);
			}
		}
		cc.preCondition.removeAll(nodeCheck);
		cc.preCondition.addAll(nodeCheck);
		
		List<Object> proc = new ArrayList<Object>();
		for(Object act : cc.action) {
			if(act instanceof ProcedureCallStatement) {
				proc.add(act);
			}
		}
		cc.action.removeAll(proc);
		cc.action.addAll(proc);
		
		
	}

}
