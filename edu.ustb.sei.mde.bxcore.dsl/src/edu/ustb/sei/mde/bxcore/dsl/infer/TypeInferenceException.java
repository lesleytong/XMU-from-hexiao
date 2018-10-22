package edu.ustb.sei.mde.bxcore.dsl.infer;

import org.chocosolver.solver.exception.ContradictionException;
import org.eclipse.emf.ecore.EObject;

public class TypeInferenceException extends RuntimeException {
	public TypeInferenceException(EObject reason, ContradictionException e) {
		super("Error in type inference",e);
		this.reason = reason;
	}

	private static final long serialVersionUID = -6560701499665265312L;
	private EObject reason;
	
	public EObject getReason() {
		return reason;
	}
}
