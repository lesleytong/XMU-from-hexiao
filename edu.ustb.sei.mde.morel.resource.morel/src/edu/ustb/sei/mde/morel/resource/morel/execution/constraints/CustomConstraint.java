package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import solver.constraints.Constraint;
import solver.constraints.Propagator;
import solver.constraints.extension.Tuples;
import solver.constraints.extension.binary.PropBinAC2001;
import solver.constraints.extension.binary.PropBinAC3;
import solver.constraints.extension.binary.PropBinAC3bitrm;
import solver.constraints.extension.binary.PropBinAC3rm;
import solver.constraints.extension.binary.PropBinFC;
import solver.variables.IntVar;
import util.ESat;

public class CustomConstraint extends Constraint {
	
	public static Constraint table(IntVar VAR1, IntVar VAR2, Tuples TUPLES, String ALGORITHM) {
        Propagator p;
        switch (ALGORITHM) {
            case "AC2001":
                p = new PropBinAC2001(VAR1, VAR2, TUPLES);
                break;
            case "FC":
                p = new PropBinFC(VAR1, VAR2, TUPLES);
                break;
            case "AC3":
                p = new PropBinAC3(VAR1, VAR2, TUPLES);
                break;
            case "AC3rm":
                p = new PropBinAC3rm(VAR1, VAR2, TUPLES);
                break;
            default:
            case "AC3bit+rm":
                p = new PropBinAC3bitrm(VAR1, VAR2, TUPLES);
                break;
        }

        return new CustomConstraint("TableBin(" + ALGORITHM + ")", p);
    }

	public CustomConstraint(String name, Propagator... propagators) {
		super(name, propagators);
		
	}

	@Override
	public ESat isSatisfied() {
		int sat = 0;
        for (int i = 0; i < propagators.length; i++) {
            ESat entail = propagators[i].isEntailed();
            if(entail==null) {
            	System.out.println("detect a null");
            	return ESat.FALSE;
            }
            if (entail.equals(ESat.FALSE)) {
                return entail;
            } else if (entail.equals(ESat.TRUE)) {
                sat++;
            }
        }
        if (sat == propagators.length) {
            return ESat.TRUE;
        } else {// No need to check if FALSE, must have been returned before
            return ESat.UNDEFINED;
        }
	}

}
