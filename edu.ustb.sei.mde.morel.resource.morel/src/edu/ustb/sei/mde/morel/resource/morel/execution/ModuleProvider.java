package edu.ustb.sei.mde.morel.resource.morel.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.library.IModuleProvider;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
//import edu.ustb.sei.mde.morel.BXRewritingModel;
//import edu.ustb.sei.mde.morel.BXRewritingRule;
//import edu.ustb.sei.mde.morel.BxMorelModel;
//import edu.ustb.sei.mde.morel.BxMorelRule;
import edu.ustb.sei.mde.morel.Executable;
import edu.ustb.sei.mde.morel.PredefinedVariable;
import edu.ustb.sei.mde.morel.Query;
import edu.ustb.sei.mde.morel.QueryModel;
import edu.ustb.sei.mde.morel.Rule;
import edu.ustb.sei.mde.morel.RuleElement;
import edu.ustb.sei.mde.morel.RuleGroup;
import edu.ustb.sei.mde.morel.TransformationModel;
import edu.ustb.sei.mde.morel.Unit;
import edu.ustb.sei.mde.morel.Variable;

public class ModuleProvider implements IModuleProvider {
	
	private Unit model;
	private OclInterpreter interpreter;
	private Stack<Context> contextStack;

	public ModuleProvider(Unit model, OclInterpreter interpreter) {
		super();
		this.model = model;
		this.interpreter = interpreter;
		interpreter.setModule(this);
		
		contextStack = new Stack<Context>();
	}

	@Override
	public Executable find(String name) {
		if(model instanceof QueryModel)
			return find(name,(QueryModel)model);
		else if(model instanceof TransformationModel)
			return find(name,(TransformationModel)model);
//		else if(model instanceof BXRewritingModel)
//			return find(name,(BXRewritingModel)model);
//		else if(model instanceof BxMorelModel)
//			return find(name,(BxMorelModel)model);
		return null;
	}
	
//	private Executable find(String name, BxMorelModel model) {
//		for(RuleElement r : model.getRules()) {
//			if(r instanceof BxMorelRule) {
//				if(((BxMorelRule)r).getName().equals(name))
//					return (Executable)r;
//			} else if(r instanceof RuleGroup) {
//				if(((RuleGroup)r).getName().equals(name))
//					return (Executable)r;
//			}
//		}
//		return null;
//	}
//	
//	private Executable find(String name, BXRewritingModel model) {
//		for(RuleElement r : model.getRules()) {
//			if(r instanceof BXRewritingRule) {
//				if(((BXRewritingRule)r).getName().equals(name))
//					return (Executable)r;
//			} else if(r instanceof RuleGroup) {
//				if(((RuleGroup)r).getName().equals(name))
//					return (Executable)r;
//			}
//		}
//		return null;
//	}

	private Executable find(String name, QueryModel model) {
		for(Query q : model.getQueries()) {
			if(q.getName().equals(name))
				return q;
		}
		return null;
	}
	
	private Executable find(String name, TransformationModel model) {
		for(RuleElement r : model.getRules()) {
			if(r instanceof Rule) {
				if(((Rule)r).getName().equals(name))
					return (Executable)r;
			} else if(r instanceof RuleGroup) {
				if(((RuleGroup)r).getName().equals(name))
					return (Executable)r;
			}
		}
		return null;
	}

//	@Override
//	public Object execute(String name, ExecutionMode mode, Object... parameters) {
//		
//		try {
//			Executable unit = find(name);
//			if(unit==null) return null;
//			
//			Context parent = contextStack.peek();
//			Context c = parent.getEnviroment().createContext();
//			
//			c.setParentContext(parent);
//			Variable thisVar = parent.findVariable(PredefinedVariable.THIS.getLiteral());
//			c.registerVariable(thisVar);
//			c.putValue(thisVar, parent.getValue(thisVar));
//			
//			initParameter(unit, c,parameters);
//			
//			if(unit instanceof Query) {
//				if(mode==ExecutionMode.DO_ALL)
//					return interpreter.interprete_edu_ustb_sei_mde_morel_Query((Query) unit, c);
//				else 
//					return interpreter.doQuery((Query) unit, c, mode);
//			} else if(unit instanceof Rule) {
//				return interpreter.interprete_edu_ustb_sei_mde_morel_Rule((Rule) unit, c);
//			}
//		} catch (Exception e) {
//			return OclUndefined.INVALIDED;
//		}
//		
//		return OclUndefined.INVALIDED;
//	}
	
	

	private void initParameter(Executable unit, Context c, Object[] parameters) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(allTuples(parameters)) {
			for(Object o : parameters) {
				Object[] arr = (Object[])o;
				map.put((String) arr[0], arr[1]);
			}			
		} else {
			for(int i = 0 ; i< parameters.length;i++) {
				String pn = unit.getParameters().get(i);
				Object o = parameters[i];
				map.put(pn, o);
			}
		}

		c.registerValueMap(map);
	}

	private boolean allTuples(Object[] parameters) {
		for(Object o : parameters) {
			if(!(o instanceof Object[]))
				return false;
		}
		return true;
	}

	@Override
	public void pushParentContext(Context context) {
		// TODO Auto-generated method stub
		contextStack.push(context);
	}

	@Override
	public Context popParentContext() {
		return contextStack.pop();
	}

	@Override
	public Object execute(String name, Object... parameters) {
		try {
		Executable unit = find(name);
		if(unit==null) return null;
		
		Context parent = contextStack.peek();
		Context c = parent.getEnviroment().createContext();
		
		
		c.setParentContext(parent);
		c.setGlobal(parent.getGlobal());
//		Variable thisVar = parent.findVariable(PredefinedVariable.THIS.getLiteral());
//		c.registerVariable(thisVar);
//		c.putValue(thisVar, parent.getValue(thisVar));
		
		initParameter(unit, c,parameters);
		
		if(unit instanceof Query) {
			return interpreter.interprete_edu_ustb_sei_mde_morel_Query((Query) unit, c);
		} else if(unit instanceof Rule) {
			return interpreter.interprete_edu_ustb_sei_mde_morel_Rule((Rule) unit, c);
		} else if(unit instanceof RuleGroup) {
			return interpreter.interprete_edu_ustb_sei_mde_morel_RuleGroup((RuleGroup) unit, c);
		} 
//		else if(unit instanceof BXRewritingRule) {
//			return interpreter.interprete_edu_ustb_sei_mde_morel_BXRewritingRule((BXRewritingRule) unit, c);
//		} else if(unit instanceof BxMorelRule) {
//			return interpreter.interprete_edu_ustb_sei_mde_morel_BxMorelRule((BxMorelRule) unit, c);
//		}
	} catch (Exception e) {
		return OclUndefined.INVALIDED;
	}
	
	return OclUndefined.INVALIDED;
	}

}
