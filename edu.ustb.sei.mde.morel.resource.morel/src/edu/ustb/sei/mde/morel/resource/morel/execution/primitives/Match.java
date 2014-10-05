package edu.ustb.sei.mde.morel.resource.morel.execution.primitives;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.Statement;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.resource.morel.execution.OclInterpreter;
import edu.ustb.sei.mde.morel.resource.morel.util.AbstractMorelInterpreter;
import solver.Solver;
import solver.constraints.ICF;
import solver.constraints.extension.Tuples;
import solver.variables.IntVar;
import solver.variables.VF;

public class Match {
	private Pair<BidirectionalMap<ObjectVariable, IntVar>,Solver> makeModel(Pattern pattern, Context context, Environment env) {
		BidirectionalMap<ObjectVariable, IntVar> varMap = new BidirectionalMap<ObjectVariable, IntVar>();
		
		Solver solver = new Solver();
		for(Variable v : pattern.getVariables()) {
			if(v instanceof ObjectVariable) {
				if(varMap.forward((ObjectVariable)v)!=null) continue;				
				ModelSpace space = (ModelSpace)env.getModelSpaces().get(((ObjectVariable) v).getModel());
				
				if(context.getValue(v)!=OclUndefined.INVALIDED) {
					int id = ModelSpace.getElementID((EObject)context.getValue(v));
					IntVar iv = VF.fixed(id, solver);
					varMap.put((ObjectVariable)v, iv);
				} else {
					IntVar iv = VF.enumerated(v.getName(), space.getAllElementIDByType(((ObjectVariable) v).getType()), solver);
					varMap.put((ObjectVariable)v, iv);				
				}
			}
		}
		
		for(LinkConstraint l : pattern.getLinkConstraints()) {
			IntVar s = varMap.forward(l.getSource());
			IntVar t = varMap.forward(l.getTarget());
			
			ModelSpace space = (ModelSpace)env.getModelSpaces().get(l.getSource().getModel());
			List<int[]> arcs = space.getAllTupleIDByReference(l.getReference(), true);
			Tuples tuple = new Tuples(true);
			for(int[] arc : arcs) {
				tuple.add(arc);
			}
			solver.post(ICF.table(s, t, tuple, "AC3"));
		}
		
		return new Pair<BidirectionalMap<ObjectVariable, IntVar>,Solver>(varMap,solver);
	}
	
	public List<Context> match(Pattern pattern, Context context, OclInterpreter interpreter, Environment env) {
		Pair<BidirectionalMap<ObjectVariable, IntVar>,Solver> pair = makeModel(pattern,context,env);
		
		boolean flag = pair.getSecond().findSolution();
		List<Context> result = new ArrayList<Context>();
		
		while(flag) {
			Context newContext = env.createContext();
			context.getCopy(newContext);
			
			for(Variable v : pattern.getVariables()) {
				if(v instanceof ObjectVariable) {
					ObjectVariable ov = (ObjectVariable)v;
					
					if(newContext.getValue(v)==OclUndefined.INVALIDED){
						newContext.putValue(v, ModelSpace.getElementByID(pair.getFirst().forward(ov).getValue()));
					}
				}
			}
			
			
			if(checkCondition(pattern,newContext,interpreter,false))
				result.add(newContext);
			
			flag = pair.getSecond().nextSolution();
		}
		
		return result;
	}

	private boolean checkCondition(Pattern pattern, Context newContext,OclInterpreter interpreter, boolean partial) {
		for(Statement statement : pattern.getStatements()){
			Object v = interpreter.interprete(statement, newContext);
			if(partial==false) {
				if(v!=Boolean.TRUE) return false;
			} else {
				if(v==Boolean.FALSE) return false;
			}
		}
		return true;
	}

}
