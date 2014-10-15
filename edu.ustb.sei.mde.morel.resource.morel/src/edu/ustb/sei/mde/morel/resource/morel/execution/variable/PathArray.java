package edu.ustb.sei.mde.morel.resource.morel.execution.variable;

import java.util.ArrayList;
import java.util.HashSet;
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
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.CustomConstraint;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.PropLinkS_T;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.ReferenceChangeListener;
import solver.Solver;
import solver.constraints.Constraint;
import solver.constraints.ICF;
import solver.constraints.LCF;
import solver.constraints.extension.Tuples;
import solver.variables.IntVar;
import solver.variables.VF;

public class PathArray {
	private IntVar source;
	private IntVar target;
	private IntVar size;
	private IntVar[] path;
	private int maxLength;
	private Variable variable;
	
	public PathArray(IntVar source, IntVar target, Variable var, int maxPath) {
		this.source = source;
		this.target = target;
		this.variable = var;
		//path = new IntVar[maxPath];
		this.maxLength = maxPath;
	}
	
	private void fillTuple(int s, List<EReference> references, List<EClass> types, Tuples tuple, HashSet<Integer> visited, Environment environment) {
		if(visited.contains(s)) return;
		if(EIdentifiable.isValid(s)==false) return;
		
		visited.add(s);
		EObject o = environment.getModelUniverse().getElementByID(s);
		for(EReference ref : references) {
			int[] targets = environment.getModelUniverse().getElementRelationship(o, ref);
			for(int t : targets) {
				if(EIdentifiable.isValid(t)==false) continue;
				EObject to = environment.getModelUniverse().getElementByID(t);
				if(checkTypes(to,types)==false) continue;
				tuple.add(s,t);
				fillTuple(t,references,types,tuple,visited,environment);
			}
			
		}
	}
		
	private boolean checkTypes(EObject to, List<EClass> types) {
		if(types.size()==0) return true;
		for(EClass t : types) {
			if(t.isSuperTypeOf(to.eClass())) return true;
		}
		return false;
	}

	public void post(Solver solver, List<EReference> references, List<EClass> types, Environment environment) {
		
		HashSet<Integer> reachables = new HashSet<Integer>();
		Tuples tuples = new Tuples(true);
		for(int s = source.getLB();s<=source.getUB();s=source.nextValue(s)){
			EObject so = environment.getModelUniverse().getElementByID(s);
			if(checkTypes(so,types)==false) continue;
			fillTuple(s,references,types,tuples,reachables,environment);
		}
		
		int[] VALUES = new int[reachables.size()];
		int id = 0;
		for(Integer i : reachables) {
			VALUES[id] = i;
			id++;
		}
		
//		if(maxLength<=0) maxLength = max;

		size = VF.bounded(variable.getName()+"_size", 0, maxLength, solver);
		path = new IntVar[maxLength];
		
		for(int i=0;i<path.length;i++) {
			path[i] = VF.enumerated(variable.getName()+"_"+i, VALUES, solver);
		}
		
//		solver.post(CustomConstraint.table(source, path[0], tuples, "FC"));
//		
//		solver.post(CustomConstraint.table(path[0], target, tuples, "FC"));

		
		
		solver.post(LCF.ifThen(ICF.arithm(size, "=", 0), 
				CustomConstraint.table(source, target, tuples, "FC")));
		solver.post(LCF.ifThen(ICF.arithm(size, ">", 0), 
				CustomConstraint.table(source, path[0], tuples, "FC")));
//		solver.post(LCF.ifThen(ICF.arithm(size, "=", 0), 
//				ICF.arithm(path[0], "=", VALUES[0])));
//		solver.post(LCF.ifThen(ICF.arithm(size, "=", 1), 
//				CustomConstraint.table(source, path[0], tuples, "FC")));
//		solver.post(LCF.ifThen(ICF.arithm(size, "=", 1), 
//				CustomConstraint.table(path[0], target, tuples, "FC")));

		
		for(int i=0;i<path.length;i++) {
			solver.post(LCF.ifThen(ICF.arithm(size, "=", i+1), CustomConstraint.table(path[i], target, tuples, "FC")));
			solver.post(LCF.ifThen(ICF.arithm(size, "<", i+1), ICF.arithm(path[i], "=", VALUES[0])));
			if(i>=1) {
				solver.post(LCF.ifThen(ICF.arithm(size, ">=", i+1), CustomConstraint.table(path[i-1], path[i], tuples, "FC")));
			}
		}

//		solver.post(LCF.ifThen(ICF.arithm(size, "=", maxLength), 
//				CustomConstraint.table(path[path.length-1], target, tuples, "FC")));
//		solver.post(ICF.table(source, path[0], tuples, "AC3"));
//		solver.post(ICF.table(path[0], target, tuples, "AC3"));
		
		

		
//		
		
//		for(int i = 0;i<path.length-1;i++) {
//			solver.post(LCF.ifThen(ICF.arithm(path[i], "=", EIdentifiable.NULL_ID), ICF.arithm(path[i+1], "=", EIdentifiable.NULL_ID)));
//		}
//		
//		solver.post(LCF.ifThenElse(ICF.arithm(path[0], "=", EIdentifiable.NULL_ID), 
//				new Constraint("SimpleLinkConstraint", new PropLinkS_T(source,target,references,environment)),
//				new Constraint("SimpleLinkConstraint", new PropLinkS_T(source,path[0],references,environment))));
//		solver.post(LCF.ifThen(ICF.arithm(path[path.length-1], ">", EIdentifiable.NULL_ID), new Constraint("SimpleLinkConstraint", new PropLinkS_T(path[path.length-1],target,references,environment))));
//		
//		for(int i = 0;i<path.length-1;i++) {
//			solver.post(
//					LCF.ifThen(ICF.arithm(path[i], ">", EIdentifiable.NULL_ID), 
//							LCF.ifThenElse(ICF.arithm(path[i+1], "=", EIdentifiable.NULL_ID),
//									new Constraint("SimpleLinkConstraint", new PropLinkS_T(path[i],target,references,environment)),
//									new Constraint("SimpleLinkConstraint", new PropLinkS_T(path[i],path[i+1],references,environment)) 
//							)));
//		}
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
		for(int i = 0 ; i<size.getValue() ; i++) {
			seq.add(env.getModelUniverse().getElementByID(path[i].getValue()));
		}
		return seq;
	}
}
