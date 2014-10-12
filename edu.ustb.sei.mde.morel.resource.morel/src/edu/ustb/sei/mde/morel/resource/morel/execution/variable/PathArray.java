package edu.ustb.sei.mde.morel.resource.morel.execution.variable;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.commonutil.util.UniqueArrayList;
import edu.ustb.sei.mde.emg.graph.EIdentifiable;
import edu.ustb.sei.mde.emg.graph.ModelUniverse;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.datatype.OclCollection;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSequence;
import edu.ustb.sei.mde.morel.MorelFactory;
import edu.ustb.sei.mde.morel.SequenceType;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.PropLinkS_T;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.ReferenceChangeListener;
import solver.Solver;
import solver.constraints.Constraint;
import solver.constraints.ICF;
import solver.constraints.LCF;
import solver.variables.IntVar;
import solver.variables.VF;

public class PathArray {
	private IntVar source;
	private IntVar target;
	public IntVar[] path;
	private int maxLength;
	private Variable variable;
	
	public PathArray(IntVar source, IntVar target, Variable var, int maxPath) {
		this.source = source;
		this.target = target;
		this.variable = var;
		//path = new IntVar[maxPath];
		this.maxLength = maxPath;
	}
		
	public void post(Solver solver, List<EReference> references, List<EClass> types, Environment environment) {
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		int max = 0;
		candidates.add(EIdentifiable.NULL_ID);
		for(int s = source.getLB();s<source.getUB();s=source.nextValue(s)) {
			EObject so = environment.getModelUniverse().getElementByID(s);
			List<EObject> objs = environment.getModelUniverse().collectEnclosureReachable(so, references, types,false,-1, ReferenceChangeListener.class);
			if(max<objs.size()) max = objs.size();
			for(EObject co : objs) {
				int c = environment.getModelUniverse().getElementID(co);
				if(c>0&&candidates.contains(c)==false)
					candidates.add(c);
			}
			System.out.println(so);
			System.out.println(objs);
		}
		
		
		int[] VALUES = new int[candidates.size()];
		for(int i = 0;i<VALUES.length;i++) {
			VALUES[i] = candidates.get(i);
		}
		
		if(maxLength<=0) maxLength = max;
		path = new IntVar[maxLength];
		
		for(int i=0;i<path.length;i++) {
			path[i] = VF.enumerated(variable.getName()+"_"+i, VALUES, solver);
		}
		
		for(int i = 0;i<path.length-1;i++) {
			solver.post(LCF.ifThen(ICF.arithm(path[i], "=", EIdentifiable.NULL_ID), ICF.arithm(path[i+1], "=", EIdentifiable.NULL_ID)));
		}
		
		solver.post(LCF.ifThenElse(ICF.arithm(path[0], "=", EIdentifiable.NULL_ID), 
				new Constraint("SimpleLinkConstraint", new PropLinkS_T(source,target,references,environment)),
				new Constraint("SimpleLinkConstraint", new PropLinkS_T(source,path[0],references,environment))));
		solver.post(LCF.ifThen(ICF.arithm(path[path.length-1], ">", EIdentifiable.NULL_ID), new Constraint("SimpleLinkConstraint", new PropLinkS_T(path[path.length-1],target,references,environment))));
		
		for(int i = 0;i<path.length-1;i++) {
			solver.post(
					LCF.ifThen(ICF.arithm(path[i], ">", EIdentifiable.NULL_ID), 
							LCF.ifThenElse(ICF.arithm(path[i+1], "=", EIdentifiable.NULL_ID),
									new Constraint("SimpleLinkConstraint", new PropLinkS_T(path[i],target,references,environment)),
									new Constraint("SimpleLinkConstraint", new PropLinkS_T(path[i],path[i+1],references,environment)) 
							)));
		}
	}

	static final private SequenceType SEQ_TYPE;
	static {
		SEQ_TYPE = MorelFactory.eINSTANCE.createSequenceType();
		SEQ_TYPE.setElementType(EcorePackage.eINSTANCE.getEObject());
	}

	public Object collectPath(Environment env) {
		// TODO Auto-generated method stub
		OclSequence seq = new OclSequence();
		seq.setType(SEQ_TYPE);
		for(int i = 0 ; i<path.length ; i++) {
			if(path[i].getValue()==0) break;
			seq.add(env.getModelUniverse().getElementByID(path[i].getValue()));
		}
		return seq;
	}
}
