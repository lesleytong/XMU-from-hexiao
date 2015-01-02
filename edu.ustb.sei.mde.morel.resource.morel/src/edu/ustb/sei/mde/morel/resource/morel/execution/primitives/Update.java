package edu.ustb.sei.mde.morel.resource.morel.execution.primitives;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.commonutil.util.UniqueArrayList;
import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.Clause;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.MorelFactory;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.PredefinedBindExp;
import edu.ustb.sei.mde.morel.PrimitiveVariable;
import edu.ustb.sei.mde.morel.SimpleLinkConstraint;
import edu.ustb.sei.mde.morel.Statement;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.resource.morel.execution.BXUpdateInterpreter;

public class Update {
	static public final PrimitiveVariable DIRECTION;
	static {
		DIRECTION = MorelFactory.eINSTANCE.createPrimitiveVariable();
		DIRECTION.setName("****DIRECTION****");
	}
	static public final Update instance = new Update();
	
	public void updateClauses(Pattern direction, Context context, BXUpdateInterpreter interpreter,Clause... clauses) {
		context.registerVariable(DIRECTION);
		context.putValue(DIRECTION, direction);
		
		for(Clause clause : clauses) {
			for(Statement s : clause.getStatements()) {
				interpreter.updateStatement(s,context);
			}
		}
	}
	
	public void updatePattern(Pattern pattern, Context context, BXUpdateInterpreter interpreter) {
		context.registerVariable(DIRECTION);
		context.putValue(DIRECTION, pattern);
		
		//for(Clause clause : clauses) {
			for(Statement s : pattern.getStatements()) {
				interpreter.updateStatement(s,context);
			}
		//}
	}
	
	public void delete(Pattern lhs, EList<String> parameters, Context context,
			Environment env, BXUpdateInterpreter bxUpdateInterpreter) {
		// TODO Auto-generated method stub
		List<Variable> variablesToBeDeleted = lhs.getVariables();
		for(Variable v : variablesToBeDeleted) {
			if(!(v instanceof ObjectVariable)) continue;
			if(parameters.contains(v.getName())) continue;
			if(context.getValue(v)!=OclUndefined.INVALIDED) {
				EObject obj = (EObject) context.getValue(v);
				System.out.println("delete "+v.getName()+" = "+obj);
				env.getModelSpaces().get(((ObjectVariable)v).getModel()).deleteElementFromModel(obj);
			}
		}
	}
	

	public void create(Pattern rhs, EList<String> parameters, Context context,
			Environment env, BXUpdateInterpreter interpreter) {
		List<Variable> variablesToBeCreated = rhs.getVariables();
		for(Variable v : variablesToBeCreated) {
			if(!(v instanceof ObjectVariable)) continue;
			ObjectVariable ov = (ObjectVariable)v;			
			if(context.getValue(v)==OclUndefined.INVALIDED) {
				if(parameters.contains(v.getName())) continue;
				EObject obj = EcoreUtil.create(ov.getType());
				context.putValue(v, obj);
				env.getModelSpaces().get(ov.getModel()).addElement(obj);
				env.getModelUniverse().onChange();
			}
		}
		
		List<LinkConstraint> linksToBeCreated = rhs.getLinkConstraints();
		for(LinkConstraint l : linksToBeCreated) {
			if(!(l instanceof SimpleLinkConstraint)) continue;
			SimpleLinkConstraint sl = (SimpleLinkConstraint)l;
			
			if(sl.getId()!=null && sl.getId() instanceof PredefinedBindExp) {
				interpreter.interprete(sl.getId(), context);
			} else {
				EObject src = (EObject) context.getValue(l.getSource());
				EObject tar = (EObject) context.getValue(l.getTarget());
				ModelSpace modelSpace = env.getModelSpaces().get(l.getSource().getModel());
				modelSpace.addRelationship(src, tar, sl.getReference());
			}
		}
		
		updatePattern(rhs,context,interpreter);
	}

	public void update(Pattern rhs, Pattern lhs, Context context, Environment env, BXUpdateInterpreter interpreter) {
		List<ObjectVariable> variablesToBeCreated = getVariables(rhs,lhs);
		for(ObjectVariable v : variablesToBeCreated) {
			if(context.getValue(v)==OclUndefined.INVALIDED) {
				EObject obj = EcoreUtil.create(v.getType());
				context.putValue(v, obj);
				env.getModelSpaces().get(v.getModel()).addElement(obj);
				env.getModelUniverse().onChange();
			}
		}

		List<SimpleLinkConstraint> linksToBeDeleted = getLinks(lhs,rhs);
		for(SimpleLinkConstraint l : linksToBeDeleted) {
			EObject src = (EObject) context.getValue(l.getSource());
			EObject tar = (EObject) context.getValue(l.getTarget());
			ModelSpace modelSpace = env.getModelSpaces().get(l.getSource().getModel());
			modelSpace.deleteRelationship(src, tar, l.getReference());
		}
		
		List<SimpleLinkConstraint> linksToBeCreated = getLinks(rhs,lhs);
		for(SimpleLinkConstraint l : linksToBeCreated) {
			if(l.getId()!=null && l.getId() instanceof PredefinedBindExp) {
				interpreter.interprete(l.getId(), context);
			} else {
				EObject src = (EObject) context.getValue(l.getSource());
				EObject tar = (EObject) context.getValue(l.getTarget());
				ModelSpace modelSpace = env.getModelSpaces().get(l.getSource().getModel());
				modelSpace.addRelationship(src, tar, l.getReference());
			}
		}

		List<ObjectVariable> variablesToBeDeleted = getVariables(lhs,rhs);
		for(ObjectVariable v : variablesToBeDeleted) {
			if(context.getValue(v)!=OclUndefined.INVALIDED) {
				EObject obj = (EObject) context.getValue(v);
				System.out.println("delete "+v.getName()+" = "+obj);
				env.getModelSpaces().get(v.getModel()).deleteElementFromModel(obj);
			}
		}
		
		updatePattern(rhs,context,interpreter);
		//for(Pattern p : rhs) {
//			for(Statement s : rhs.getStatements()) {
//				interpreter.
//			}
		//}
		
		return;
	}
	
	static public List<ObjectVariable> getVariables(Pattern includes, Pattern excludes) {
		List<ObjectVariable> variables = new UniqueArrayList<ObjectVariable>();
		//execlusiveVariableMap.put(includes, excludes, variables);
		//for(Pattern p : includes) {
			for(Variable v : includes.getVariables()) {
				if(v instanceof ObjectVariable) {
					if(checkExisting((ObjectVariable)v,excludes)==false) {
						variables.add((ObjectVariable) v);
					}
				}
			}
		//}
		
		return variables;
	}
	
	static public List<SimpleLinkConstraint> getLinks(Pattern includes, Pattern excludes) {
		List<SimpleLinkConstraint> links =new UniqueArrayList<SimpleLinkConstraint>();
		//execlusiveLinkMap.put(includes, excludes, links);
		//for(Pattern p : includes) {
			for(LinkConstraint l : includes.getLinkConstraints()) {
				if(l instanceof SimpleLinkConstraint) {
					if(checkExisting((SimpleLinkConstraint)l,excludes)==false) {
						links.add((SimpleLinkConstraint) l);
					}
				}
			}
		//}
		return links;
	}

	private static boolean checkExisting(ObjectVariable v,
			Pattern excludes) {
		//for(Pattern p : excludes) {
			for(Variable vr : excludes.getVariables()) {
				if(vr.equals(v)) return true;
			}
		//}
		return false;
	}
	
	private static boolean checkExisting(SimpleLinkConstraint l,
			Pattern excludes) {
		//for(Pattern p : excludes) {
		for(LinkConstraint lr :excludes.getLinkConstraints()) {
			if(lr.equals(l)) return true;
		}
		//}
		return false;
	}



}
