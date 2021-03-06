package edu.ustb.sei.mde.morel.resource.morel.execution.primitives;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import solver.Solver;
import solver.constraints.Constraint;
import solver.constraints.ICF;
import solver.variables.IntVar;
import solver.variables.VF;
import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.commonutil.util.PairHashSet;
import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.emg.library.BooleanLibrary;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.AdditionalConstraint;
import edu.ustb.sei.mde.morel.AllDifferentConstraint;
import edu.ustb.sei.mde.morel.EnclosureLinkConstraint;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.MorelFactory;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.OrderConstraint;
import edu.ustb.sei.mde.morel.PathConstraint;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.PredefinedVariable;
import edu.ustb.sei.mde.morel.PrimitiveVariable;
import edu.ustb.sei.mde.morel.SimpleLinkConstraint;
import edu.ustb.sei.mde.morel.Statement;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.resource.morel.execution.OclInterpreter;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.AdditionalConstraintExecutor;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.OrderConstraintExecutor;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.PropEnclosureLinkS_T;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.PropTableConstraint;
import edu.ustb.sei.mde.morel.resource.morel.execution.variable.PathArray;

public class Match {
	public final static Match instance = new Match();
	
	static private HashMap<AdditionalConstraint, AdditionalConstraintExecutor<?>> additionalConstraintExecutorMap = new HashMap<AdditionalConstraint, AdditionalConstraintExecutor<?>>();
	
	public static  AdditionalConstraintExecutor<?> getExecutor(AdditionalConstraint cons) {
		AdditionalConstraintExecutor<?> exec = additionalConstraintExecutorMap.get(cons);
		if(exec==null) {
			if(cons instanceof OrderConstraint) {
				exec = new OrderConstraintExecutor((OrderConstraint) cons);
			}
		}
		
		return exec;
	}

	static public void resetCache() {
		additionalConstraintExecutorMap.clear();
	}
	
	private Pair<BidirectionalMap<Variable, Object>,Solver> makeModel(List<Pattern> patterns, Context context, Environment env) {
		BidirectionalMap<Variable, Object> varMap = new BidirectionalMap<Variable, Object>();
		HashSet<LinkConstraint> linkSet = new HashSet<LinkConstraint>();
		
		Solver solver = new Solver();
		for(Pattern pattern : patterns) {
			for(Variable v : pattern.getVariables()) {
				if(v instanceof ObjectVariable) {
					if(varMap.forward((ObjectVariable)v)!=null) continue;				
					ModelSpace space = (ModelSpace)env.getModelSpaces().get(((ObjectVariable) v).getModel());
					
					if(context.getValue(v)!=OclUndefined.INVALIDED) {
						int id = env.getModelUniverse().getElementID((EObject)context.getValue(v));
						IntVar iv = VF.fixed(id, solver);
						varMap.put((ObjectVariable)v, iv);
					} else {
						int[] elemID = space.getAllElementIDByType(((ObjectVariable) v).getType());
						if(elemID.length==0) return null;
						
						IntVar iv = VF.enumerated(v.getName(), elemID, solver);
						varMap.put((ObjectVariable)v, iv);
					}
				}
			}
			
			for(LinkConstraint l : pattern.getLinkConstraints()) {
				if(linkSet.contains(l)) continue;
				linkSet.add(l);
				
				IntVar s = (IntVar)varMap.forward(l.getSource());
				IntVar t = (IntVar)varMap.forward(l.getTarget());
				
				if(l instanceof SimpleLinkConstraint) {
					ModelSpace space = (ModelSpace)env.getModelSpaces().get(l.getSource().getModel());
					List<int[]> arcs = space.getAllTupleIDByReference(((SimpleLinkConstraint)l).getReference(), true);
					if(arcs.size()==0) return null;
					PairHashSet<Integer,Integer> tuple = new PairHashSet<Integer,Integer>();
					for(int[] arc : arcs) {
						tuple.add(arc[0],arc[1]);
					}
					Constraint c = new Constraint("PropTableConstraint",new PropTableConstraint(s,t,tuple));
					solver.post(c);
					//solver.post(new Constraint("LinkConstraint", new PropLinkS_T(s,t,((SimpleLinkConstraint)l).getReference(),env)));				
				} else if(l instanceof EnclosureLinkConstraint) {
					solver.post(new Constraint("EnclosureLinkConstraint", new PropEnclosureLinkS_T(s,t,((EnclosureLinkConstraint)l).getForward(), ((EnclosureLinkConstraint)l).getTypes(),env)));
				} else if(l instanceof PathConstraint) {
					PathConstraint pathConstraint = (PathConstraint)l;
					PathArray pArray = new PathArray(s,t,pathConstraint.getPathVariable(),pathConstraint.getMinLength(),pathConstraint.getMaxLength());
					Constraint c = pArray.post(solver, pathConstraint.getReferences(), pathConstraint.getTypes(), env);
					if(c==null) return null;
					solver.post(c);
					varMap.put(pathConstraint.getPathVariable(), pArray);
				}
			}
			
			for(AdditionalConstraint ac : pattern.getAdditionalConstraints()) {
				if(ac instanceof AllDifferentConstraint) {
					IntVar[] arr = new IntVar[ac.getVariables().size()];
					for(int i = 0;i<arr.length;i++) {
						arr[i] = (IntVar) varMap.forward(ac.getVariables().get(i));
					}
					solver.post(ICF.alldifferent(arr));
				}
			}
		}
		
		return new Pair<BidirectionalMap<Variable, Object>,Solver>(varMap,solver);
	}
	
	private Pair<BidirectionalMap<Variable, Object>,Solver> makeModel(Pattern pattern, Context context, Environment env) {
//		BidirectionalMap<ObjectVariable, IntVar> varMap = new BidirectionalMap<ObjectVariable, IntVar>();
//		
//		Solver solver = new Solver();
//		for(Variable v : pattern.getVariables()) {
//			if(v instanceof ObjectVariable) {
//				if(varMap.forward((ObjectVariable)v)!=null) continue;				
//				ModelSpace space = (ModelSpace)env.getModelSpaces().get(((ObjectVariable) v).getModel());
//				
//				if(context.getValue(v)!=OclUndefined.INVALIDED) {
//					int id = ModelSpace.getElementID((EObject)context.getValue(v));
//					IntVar iv = VF.fixed(id, solver);
//					varMap.put((ObjectVariable)v, iv);
//				} else {
//					IntVar iv = VF.enumerated(v.getName(), space.getAllElementIDByType(((ObjectVariable) v).getType()), solver);
//					varMap.put((ObjectVariable)v, iv);				
//				}
//			}
//		}
//		
//		for(LinkConstraint l : pattern.getLinkConstraints()) {
//			IntVar s = varMap.forward(l.getSource());
//			IntVar t = varMap.forward(l.getTarget());
//			
//			if(l instanceof SimpleLinkConstraint) {
//				ModelSpace space = (ModelSpace)env.getModelSpaces().get(l.getSource().getModel());
//				List<int[]> arcs = space.getAllTupleIDByReference(((SimpleLinkConstraint)l).getReference(), true);
//				Tuples tuple = new Tuples(true);
//				for(int[] arc : arcs) {
//					tuple.add(arc);
//				}
//				solver.post(ICF.table(s, t, tuple, "AC3"));
//				//solver.post(new Constraint("LinkConstraint", new PropLinkS_T(s,t,((SimpleLinkConstraint)l).getReference(),env)));				
//			} else if(l instanceof EnclosureLinkConstraint) {
//				solver.post(new Constraint("EnclosureLinkConstraint", new PropEnclosureLinkS_T(s,t,((EnclosureLinkConstraint)l).getForward(), ((EnclosureLinkConstraint)l).getTypes(),env)));
//			}
//		}
//		
//		return new Pair<BidirectionalMap<ObjectVariable, IntVar>,Solver>(varMap,solver);
		List<Pattern> patterns = new ArrayList<Pattern>();
		patterns.add(pattern);
		return makeModel(patterns, context, env);
	}
	
	public List<Context> match(List<Pattern> patterns, Context context, OclInterpreter interpreter, Environment env) {
		return match(patterns,context,interpreter,env,false);
	}
	
	public List<Context> match(List<Pattern> patterns, Context context, OclInterpreter interpreter, Environment env, boolean justCheck) {
		Pair<BidirectionalMap<Variable, Object>,Solver> pair = makeModel(patterns,context,env);
		if(pair==null) return Collections.emptyList();
		
		boolean flag = pair.getSecond().findSolution();
		List<Context> result = new ArrayList<Context>();
		
		while(flag) {
			Context newContext = context.getCopy();
			
			for(Pattern pattern : patterns) {
				for(Variable v : pattern.getVariables()) {
					if(v instanceof ObjectVariable) {
						ObjectVariable ov = (ObjectVariable)v;
						
						int value = ((IntVar) pair.getFirst().forward(ov)).getValue();
						newContext.putValue(v, env.getModelUniverse().getElementByID(value));
//						if(newContext.getValue(v)==OclUndefined.INVALIDED){
//						}
					} else {
						Object o =pair.getFirst().forward(v);
						if(o!=null&&o instanceof PathArray) {
							PathArray p = (PathArray)o;
							newContext.putValue(v, p.collectPath(env));
						}
					}
				}
			}
			
			
			if(checkLinkOrderCondition(patterns,newContext,interpreter,false) 
					&& checkAdditionalConstraint(patterns,newContext)
					&& checkCondition(patterns,newContext,interpreter,false)) {
				result.add(newContext);
				if(justCheck) break;
			}
			
			flag = pair.getSecond().nextSolution();
		}
		
		return result;
	}
	
	private boolean checkAdditionalConstraint(List<Pattern> patterns,
			Context newContext) {
		for(Pattern pattern : patterns) {
			for(AdditionalConstraint ac : pattern.getAdditionalConstraints()) {
				if(ac instanceof OrderConstraint) {
					AdditionalConstraintExecutor<?> exec = Match.getExecutor(ac);
					if(exec.evaluate(newContext)==false) 
						return false;
				}
			}
		}
		return true;
	}

	public List<Context> match(Pattern pattern, Context context, OclInterpreter interpreter, Environment env){
		return match(pattern,context,interpreter,env,false);
	}
	
	public List<Context> match(Pattern pattern, Context context, OclInterpreter interpreter, Environment env,boolean justCheck) {
//		Pair<BidirectionalMap<ObjectVariable, IntVar>,Solver> pair = makeModel(pattern,context,env);
//		
//		boolean flag = pair.getSecond().findSolution();
//		List<Context> result = new ArrayList<Context>();
//		
//		while(flag) {
//			Context newContext = env.createContext();
//			context.getCopy(newContext);
//			
//			for(Variable v : pattern.getVariables()) {
//				if(v instanceof ObjectVariable) {
//					ObjectVariable ov = (ObjectVariable)v;
//					
//					if(newContext.getValue(v)==OclUndefined.INVALIDED){
//						newContext.putValue(v, ModelSpace.getElementByID(pair.getFirst().forward(ov).getValue()));
//					}
//				}
//			}
//			
//			
//			if(checkLinkOrderCondition(pattern,newContext,interpreter,false) 
//					&& checkCondition(pattern,newContext,interpreter,false))
//				result.add(newContext);
//			
//			flag = pair.getSecond().nextSolution();
//		}
//		
//		return result;
		List<Pattern> patterns = new ArrayList<Pattern>();
		patterns.add(pattern);
		return match(patterns,context,interpreter,env,justCheck);
	}
	
	public boolean checkCondition(List<Pattern> patterns, Context context,OclInterpreter interpreter, boolean partial) {
		for(Pattern p : patterns) {
			if(!checkCondition(p,context,interpreter,partial))
				return false;
		}
		return true;
	}
	
	private boolean checkLinkOrderCondition(List<Pattern> patterns, Context context,OclInterpreter interpreter, boolean partial) {
		for(Pattern p : patterns) {
			if(!checkLinkOrderCondition(p,context,interpreter,partial))
				return false;
		}
		return true;
	}

	private boolean checkCondition(Pattern pattern, Context newContext,OclInterpreter interpreter, boolean partial) {
		for(Statement statement : pattern.getStatements()){
			Object v = interpreter.interprete(statement, newContext);
			if(partial==false) {
				if(!BooleanLibrary.isTrue(v)) return false;
			} else {
				if(BooleanLibrary.isFalse(v)) return false;
			}
		}
		return true;
	}
	
	private boolean checkLinkOrderCondition(Pattern pattern, Context context,OclInterpreter interpreter, boolean partial) {
		Context innerCont = context.newScope();
		PrimitiveVariable var = MorelFactory.eINSTANCE.createPrimitiveVariable();
		var.setName(PredefinedVariable.ID.getLiteral());
		var.setType(EcorePackage.eINSTANCE.getEIntegerObject());
		innerCont.getBindingMap().put(var, OclUndefined.INVALIDED);

		for(LinkConstraint l : pattern.getLinkConstraints()) {
			if(l instanceof SimpleLinkConstraint) {
				SimpleLinkConstraint sl = (SimpleLinkConstraint)l;
				if(sl.getId()==null) continue;
				
				try {
					EObject src = (EObject)innerCont.getValue(l.getSource());
					EObject tar = (EObject)innerCont.getValue(l.getTarget());
					
					if(sl.getReference().isMany()) {
						List<?> col = (List<?>) src.eGet(sl.getReference());
						innerCont.putValue(var, (Integer)col.indexOf(tar)+1);// 1-based
					} else {
						innerCont.putValue(var, 1);
					}
					
					Object v = interpreter.interprete(sl.getId(), innerCont);
					if(partial==false) {
						if(!BooleanLibrary.isTrue(v)) return false;
					} else {
						if(BooleanLibrary.isFalse(v)) return false;
					}
				} catch (Exception e) {
					if(partial) continue;
					else return false;
				}
			}
		}
		return true;
	}

}
