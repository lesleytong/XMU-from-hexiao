package edu.ustb.sei.mde.emg.primitives;

import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.runtime.Context;
import edu.ustb.sei.mde.morel.runtime.Environment;
import solver.Solver;
import solver.variables.VF;

public class Match {
	public Solver makeModel(Pattern pattern, Context context, Environment env) {
		Solver solver = new Solver();
		for(Variable v : pattern.getVariables()) {
			if(v instanceof ObjectVariable) {
				ModelSpace space = (ModelSpace)env.getModelSpaces().get(((ObjectVariable) v).getModel());
				VF.enumerated(v.getName(), space.getAllElementIDByType(((ObjectVariable) v).getType()), solver);
			}
		}
		
		return solver;
	}

}
