package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidForwardEnforcementException;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.CallStatement;
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
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;

public class ReorderUtil {

	static public List<ReorderedAlignBranch> reorderStatementsForAlignStatement(List<Statement> statements, ReorderedAlignBranch branch) {
		
		List<ReorderedAlignBranch> start = new ArrayList<ReorderedAlignBranch>();
		List<ReorderedAlignBranch> result =  new ArrayList<ReorderedAlignBranch>();
		result.add(branch);
		
		for(Statement s : statements) {
			start.clear();
			
			start.addAll(result);
			
			result.clear();
			
			for(ReorderedAlignBranch rcc : start) {
				result.addAll(ReorderUtil.reorderStatementForAlignStatement(s, rcc));
			}
		}
		
		return result;
	}

	private static Collection<? extends ReorderedAlignBranch> reorderStatementForAlignStatement(Statement st,
			ReorderedAlignBranch rcc) {
		if (st instanceof CallStatement && ((CallStatement) st).getCallable() instanceof Procedure) {
			rcc.tail.add(st);
			return Collections.singletonList(rcc);
		} else if (st instanceof EnforceNodeStatement) {
			if (ReorderUtil.isEnforceNodeStatementExecutable((EnforceNodeStatement) st, rcc.enforcedVars)) {
				rcc.enforce.add(st);
			} else
				rcc.lazy.add(st);
			return Collections.singletonList(rcc);
		} else if (st instanceof EnforceLinkStatement) {
			if (ReorderUtil.isEnforceLinkStatementExecutable((EnforceLinkStatement) st, rcc.enforcedVars)) {
				rcc.enforce.add(st);
			} else
				rcc.lazy.add(st);
			return Collections.singletonList(rcc);
		} else if (st instanceof MatchPattern) {
			rcc.match.add(st);
			return Collections.singletonList(rcc);
		} else if (st instanceof CaseStatement) {
			List<ReorderedAlignBranch> results = new ArrayList<ReorderedAlignBranch>();

			if (((CaseStatement) st).getTag() == DomainTag.VIEW) {
				for (CaseClause cc : ((CaseStatement) st).getClauses()) {
					if (cc instanceof CaseStatementClause) {
						ReorderedAlignBranch newBranch = rcc.clone();
						newBranch.precondition.addAll(((CaseStatementClause) cc).getCondition());
						results.addAll(reorderStatementsForAlignStatement(cc.getAction(), newBranch));
					} else
						throw new InvalidForwardEnforcementException(
								"I met an invalid case clause in the forward direction");
				}
				return results;
			} else {
				for (CaseClause cc : ((CaseStatement) st).getClauses()) {
					ReorderedAlignBranch newBranch = rcc.clone();
					if (cc instanceof CasePatternClause) {
						newBranch.precondition.add(((CasePatternClause) cc).getCondition());
					} else if (cc instanceof CaseExpressionClause) {
						newBranch.precondition.add(((CaseExpressionClause) cc).getCondition());
					} else {
						System.out.println("unhandled branch");
					}
					results.addAll(reorderStatementsForAlignStatement(cc.getAction(), newBranch));
				}

				return results;
			}
		} else if (st instanceof ForEachStatement) {
			rcc.lazy.add(st);
			return Collections.singletonList(rcc);
		} else {
			rcc.enforce.add(st);
			return Collections.singletonList(rcc);
		}
	}

	@Deprecated
	static public ReorderedAlignStatement reorderAlignStatement(AlignStatement align, Context context) {
		//FIXME: ideally, I should calculate the order according to the variable dependencies
		//To achieve this goal, I should calculate the "source-view" variables for each statement
		
		List<Variable> enforcedVars = ReorderUtil.initEnforcedVariables(context);
		
		ReorderedAlignStatement reorder = (ReorderedAlignStatement) context.getEnvironment().getFromOrderCache(enforcedVars, align);
		
		if(reorder==null) {
			ReorderedAlignBranch rcc = new ReorderedAlignBranch();
			rcc.enforcedVars = enforcedVars;
			reorder = new ReorderedAlignStatement();
			
			reorder.branches = reorderStatementsForAlignStatement(align.getMatch(), rcc);
			
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
			ReorderedAlignBranch rcc = new ReorderedAlignBranch();
			rcc.enforcedVars = enforcedVars;
			reorder = new ReorderedAlignStatement();
			
			
			reorder.branches = reorderStatementsForAlignStatement(foreach.getAction(), rcc);
			
//			reorder.finalOrder.addAll(reorder.match);
//			reorder.finalOrder.addAll(reorder.enforce);
//			reorder.finalOrder.addAll(reorder.lazy);
//			reorder.finalOrder.addAll(reorder.tail);
			
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
		if(stmt.getTag()==DomainTag.UPDATED_SOURCE) {
			System.out.println("enforce updated source in the forward mode");
			return true;
		}
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
		if(stmt.getTag()==DomainTag.UPDATED_SOURCE) {
			System.out.println("enforce updated source in the forward mode");
			return true;
		}
		try{
			if(enforcedVars.contains(stmt.getNode())) return true;
			else {
				EClass type = (EClass) stmt.getType();
				if (stmt.isReflective()==false && type.isAbstract()) {
					if (checkExpressionExecutable(stmt.getCandidate(), enforcedVars)) {
						enforcedVars.add(stmt.getNode());
						return true;
					} else
						return false;
				} else {
					// !!! reflective node enforcement must be always executable
					enforcedVars.add(stmt.getNode());
					return true;
				}
			}
		} catch(Exception e) {
			return false;
		}
	}

	static public List<ReorderedCaseBranch> reorderStatementsForCaseStatement(List<Statement> action, ReorderedCaseBranch branch) {
		
		List<ReorderedCaseBranch> start = new ArrayList<ReorderedCaseBranch>();
		List<ReorderedCaseBranch> result =  new ArrayList<ReorderedCaseBranch>();
		result.add(branch);
		
		for(Statement s : action) {
			start.clear();
			start.addAll(result);
			result.clear();
			for(ReorderedCaseBranch rcc : start) {
				result.addAll(ReorderUtil.reorderStatementForCaseStatement(s, rcc));
			}
		}
		
		return result;
	}

	static public List<ReorderedCaseBranch> reorderStatementForCaseStatement(Statement statement, ReorderedCaseBranch branch) {
		if(statement instanceof CaseStatement) {
			if(((CaseStatement) statement).getTag()==DomainTag.VIEW) {
				// try to select a branch according to this content
				
				List<ReorderedCaseBranch> branches = new ArrayList<ReorderedCaseBranch>();
				
				for(CaseClause cc : ((CaseStatement) statement).getClauses()) {
					ReorderedCaseBranch nb = branch.clone();
					
					if(cc instanceof CaseStatementClause) {
						nb.preCondition.addAll(((CaseStatementClause) cc).getCondition());
						List<ReorderedCaseBranch> newBranches = reorderStatementsForCaseStatement(((CaseStatementClause) cc).getAction(), nb);
						branches.addAll(newBranches);
					} else {
//						List<ReorderedCaseClause> newBranches = reorderStatementsForCaseStatement(
//								cc.getSourceCheckStatements(), nb);
//						for (ReorderedCaseClause newBranch : newBranches) {
//							if (cc instanceof CasePatternClause) {
//								for (Statement ac : cc.getViewCreationStatements()) {
//									if (ac instanceof EnforceNodeStatement) {
//										if (isEnforceNodeStatementExecutable((EnforceNodeStatement) ac,
//												newBranch.enforcedVariables)) {
//											newBranch.action.add(ac);
//										} else {
//											newBranch.postCondition.add(ac);
//										}
//									} else if (ac instanceof EnforceLinkStatement) {
//										if (isEnforceLinkStatementExecutable((EnforceLinkStatement) ac,
//												newBranch.enforcedVariables)) {
//											newBranch.action.add(ac);
//										} else {
//											newBranch.postCondition.add(ac);
//										}
//									}
//								}
//							} else if (cc instanceof CaseExpressionClause) {
//								newBranch.action.add(((CaseExpressionClause) cc).getCondition());
//							} else {
//								System.out.println("unhandled branch");
//							}
//						}
//
//						branches.addAll(newBranches);
					}
				}
				return  branches;
				
			} else {
				List<ReorderedCaseBranch> branches = new ArrayList<ReorderedCaseBranch>();
				
				for(CaseClause cc : ((CaseStatement) statement).getClauses()) {
					ReorderedCaseBranch newBranch = branch.clone();
					
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
		} else if(statement instanceof CallStatement) {
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
			ReorderedCaseBranch rcc = new ReorderedCaseBranch();
			rcc.enforcedVariables = enforced;
			reorder.branches = reorderStatementForCaseStatement(statement,rcc);
			
			for(ReorderedCaseBranch cc : reorder.branches) {
				reorderMatchCondition(cc);
			}
			
			context.getEnvironment().putIntoOrderCache(enforced, statement, reorder);
		}
		
		return reorder;
	}

	private static void reorderMatchCondition(ReorderedCaseBranch cc) {
		
		
		List<Object> nodeCheck = new ArrayList<Object>();
		for(Object cond : cc.preCondition) {
			if(cond instanceof EnforceNodeStatement) {
				nodeCheck.add(cond);
			}
		}
		//reorder
		cc.preCondition.removeAll(nodeCheck);
		cc.preCondition.addAll(nodeCheck);
		
		List<Statement> forStmt = new ArrayList<Statement>();
		List<Statement> proc = new ArrayList<Statement>();
		for(Statement act : cc.action) {
			if(act instanceof CallStatement) {
				proc.add((Statement)act);
			} else if(act instanceof ForEachStatement)
				forStmt.add((Statement)act);
		}
		//reorder
		cc.action.removeAll(forStmt);
		cc.action.removeAll(proc);
		cc.action.addAll(forStmt);
		cc.action.addAll(proc);
		
		
	}
}
