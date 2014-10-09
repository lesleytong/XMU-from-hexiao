package edu.ustb.sei.mde.morel.resource.morel.execution.primitives;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.commonutil.util.PairHashMap;
import edu.ustb.sei.commonutil.util.UniqueArrayList;
import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.PredefinedBindExp;
import edu.ustb.sei.mde.morel.Rule;
import edu.ustb.sei.mde.morel.SectionType;
import edu.ustb.sei.mde.morel.SimpleLinkConstraint;
import edu.ustb.sei.mde.morel.Statement;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.resource.morel.execution.OclInterpreter;

public class Apply {
	public static final Apply instance = new Apply();


	@SuppressWarnings("unchecked")
	public boolean apply(List<Pattern> rhs, List<Pattern> lhs, Context context, OclInterpreter interpreter,  Environment env) {
		List<ObjectVariable> variablesToBeCreated = getVariables(rhs,lhs);
		for(ObjectVariable v : variablesToBeCreated) {
			if(context.getValue(v)==OclUndefined.INVALIDED) {
				EObject obj = EcoreUtil.create(v.getType());
				context.putValue(v, obj);
				env.getModelSpaces().get(v.getModel()).addElement(obj);
			}
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
		
		for(Pattern p : rhs) {
			for(Statement s : p.getStatements()) {
				interpreter.interprete(s, context);
			}
		}
		
		List<SimpleLinkConstraint> linksToBeDeleted = getLinks(lhs,rhs);
		for(SimpleLinkConstraint l : linksToBeDeleted) {
			EObject src = (EObject) context.getValue(l.getSource());
			EObject tar = (EObject) context.getValue(l.getTarget());
			ModelSpace modelSpace = env.getModelSpaces().get(l.getSource().getModel());
			modelSpace.deleteRelationship(src, tar, l.getReference());
		}

		List<ObjectVariable> variablesToBeDeleted = getVariables(lhs,rhs);
		for(ObjectVariable v : variablesToBeDeleted) {
			if(context.getValue(v)!=OclUndefined.INVALIDED) {
				EObject obj = EcoreUtil.create(v.getType());
				env.getModelSpaces().get(v.getModel()).deleteElementFromModel(obj);
			}
		}
		
		
		
		
		return true;
	}
	
	static protected PairHashMap<Rule,SectionType,List<Pattern>> ruleTypePatternMap = new PairHashMap<Rule,SectionType,List<Pattern>>();
	static protected PairHashMap<List<Pattern>,List<Pattern>,List<ObjectVariable>> execlusiveVariableMap = new PairHashMap<List<Pattern>,List<Pattern>,List<ObjectVariable>>();
	static protected PairHashMap<List<Pattern>,List<Pattern>,List<SimpleLinkConstraint>> execlusiveLinkMap = new PairHashMap<List<Pattern>,List<Pattern>,List<SimpleLinkConstraint>>();
	
	
	static public void resetCache() {
		ruleTypePatternMap.reset();
		execlusiveVariableMap.reset();
		execlusiveLinkMap.reset();
	}
	
	static public List<Pattern> getPatterns(Rule rule,SectionType type) {
		List<Pattern> patterns = ruleTypePatternMap.get(rule, type);
		
		if(patterns==null) {
			patterns = 	new ArrayList<Pattern>();
			ruleTypePatternMap.put(rule, type, patterns);
			for(Pattern p : rule.getPatterns()) {
				if(p.getType()==type)
					patterns.add(p);
			}
			
		}
		
		return patterns;
	}
	
	static public List<ObjectVariable> getVariables(List<Pattern> includes, List<Pattern> excludes) {
		List<ObjectVariable> variables = execlusiveVariableMap.get(includes, excludes);
		
		if(variables==null){
			variables = new UniqueArrayList<ObjectVariable>();
			execlusiveVariableMap.put(includes, excludes, variables);
			for(Pattern p : includes) {
				for(Variable v : p.getVariables()) {
					if(v instanceof ObjectVariable) {
						if(checkExisting((ObjectVariable)v,excludes)==false) {
							variables.add((ObjectVariable) v);
						}
					}
				}
			}
		}
		
		return variables;
	}
	
	static public List<SimpleLinkConstraint> getLinks(List<Pattern> includes, List<Pattern> excludes) {
		List<SimpleLinkConstraint> links = execlusiveLinkMap.get(includes, excludes);
		
		if(links==null){
			links = new UniqueArrayList<SimpleLinkConstraint>();
			execlusiveLinkMap.put(includes, excludes, links);
			for(Pattern p : includes) {
				for(LinkConstraint l : p.getLinkConstraints()) {
					if(l instanceof SimpleLinkConstraint) {
						if(checkExisting((SimpleLinkConstraint)l,excludes)==false) {
							links.add((SimpleLinkConstraint) l);
						}
					}
				}
			}
		}
		
		return links;
	}

	private static boolean checkExisting(ObjectVariable v,
			List<Pattern> excludes) {
		for(Pattern p : excludes) {
			for(Variable vr : p.getVariables()) {
				if(vr.equals(v)) return true;
			}
		}
		return false;
	}
	
	private static boolean checkExisting(SimpleLinkConstraint l,
			List<Pattern> excludes) {
		for(Pattern p : excludes) {
			for(LinkConstraint lr :p.getLinkConstraints()) {
				if(lr.equals(l)) return true;
			}
		}
		return false;
	}

}
