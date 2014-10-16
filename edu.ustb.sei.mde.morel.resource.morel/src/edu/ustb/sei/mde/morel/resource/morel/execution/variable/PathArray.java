package edu.ustb.sei.mde.morel.resource.morel.execution.variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.commonutil.util.PairHashSet;
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
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.PropPathS_C_T;
import edu.ustb.sei.mde.morel.resource.morel.execution.constraints.ReferenceChangeListener;
import solver.Solver;
import solver.constraints.Constraint;
import solver.constraints.ICF;
import solver.constraints.LCF;
import solver.constraints.PropagatorPriority;
import solver.constraints.extension.Tuples;
import solver.variables.IntVar;
import solver.variables.VF;

public class PathArray {
	private IntVar source;
	private IntVar target;
	
	private IntVar size;
	private IntVar start;
	private IntVar[] path;
	private IntVar end;
	
	private int maxLength;
	private int minLength;
	
	private Variable seqVariable;
	
	public PathArray(IntVar source, IntVar target, Variable var, int minPath, int maxPath) {
		this.source = source;
		this.target = target;
		this.seqVariable = var;
		//path = new IntVar[maxPath];
		this.minLength = minPath;
		this.maxLength = maxPath;
	}
	
//	private void fillTuple(int s, List<EReference> references, List<EClass> types, Tuples tuple, HashSet<Integer> visited, Environment environment) {
//		if(visited.contains(s)) return;
//		if(EIdentifiable.isValid(s)==false) return;
//		
//		visited.add(s);
//		EObject o = environment.getModelUniverse().getElementByID(s);
//		for(EReference ref : references) {
//			int[] targets = environment.getModelUniverse().getElementRelationship(o, ref);
//			for(int t : targets) {
//				if(EIdentifiable.isValid(t)==false) continue;
//				EObject to = environment.getModelUniverse().getElementByID(t);
//				if(checkTypes(to,types)==false) continue;
//				tuple.add(s,t);
//				fillTuple(t,references,types,tuple,visited,environment);
//			}
//			
//		}
//	}
	
	private int fillTuple(int s, List<EReference> references, List<EClass> types, PairHashSet<Integer,Integer> table, HashSet<Integer> visited, Environment environment) {
		if(visited.contains(s)) return 0;
		if(EIdentifiable.isValid(s)==false) return 0;
		
		int maxPath = 1;
		
		visited.add(s);
		EObject o = environment.getModelUniverse().getElementByID(s);
		for(EReference ref : references) {
			int[] targets = environment.getModelUniverse().getElementRelationship(o, ref);
			for(int t : targets) {
				if(EIdentifiable.isValid(t)==false) continue;
				EObject to = environment.getModelUniverse().getElementByID(t);
				if(checkTypes(to,types)==false) continue;
				table.add(s,t);
				int cMax = fillTuple(t,references,types,table,visited,environment);
				if(maxPath<cMax+1)
					maxPath = cMax+1;
			}	
		}
		
		return maxPath;
	}
	
//	private void fillVars(int s, List<EReference> references, List<EClass> types, HashSet<Integer> visited, HashMap<Integer,Integer> objIdToVarId, List<IntVar> vars, Environment environment, Solver solver) {
//		if(visited.contains(s)) return;
//		if(EIdentifiable.isValid(s)==false) return;
//		visited.add(s);
//		
//		int vid = vars.size();
//		objIdToVarId.put(s, vid);
//		vars.add(VF.zero(solver));//place holder
//		
////		objIdToVars.put(s, )
//		EObject o = environment.getModelUniverse().getElementByID(s);
//		List<Integer> succ = new ArrayList<Integer>();
//		for(EReference ref : references) {
//			int[] targets = environment.getModelUniverse().getElementRelationship(o, ref);
//			for(int t : targets) {
//				if(EIdentifiable.isValid(t)==false) continue;
//				EObject to = environment.getModelUniverse().getElementByID(t);
//				if(checkTypes(to,types)==false) continue;
//				fillVars(t,references,types,visited,objIdToVarId,vars,environment,solver);
//				succ.add(objIdToVarId.get(t));
//			}			
//		}
//		int[] succArr = new int[succ.size()];
//		for(int i=0;i<succArr.length;i++) {
//			succArr[i] = succ.get(i);
//		}
//		IntVar var = VF.enumerated(seqVariable.getName()+"_"+vid, succArr, solver);
//		vars.set(vid, var);
//	}
		
	private boolean checkTypes(EObject to, List<EClass> types) {
		if(types.size()==0) return true;
		for(EClass t : types) {
			if(t.isSuperTypeOf(to.eClass())) return true;
		}
		return false;
	}

	public Constraint post(Solver solver, List<EReference> references, List<EClass> types, Environment environment) {
		
		PairHashSet<Integer,Integer> table = new PairHashSet<Integer,Integer>();
		HashSet<Integer> reachables = new HashSet<Integer>();
		int max = 0;
		for(int s = source.getLB();s<=source.getUB();s=source.nextValue(s)){
			EObject so = environment.getModelUniverse().getElementByID(s);
			if(checkTypes(so,types)==false) continue;
			int cMax = fillTuple(s,references,types,table,reachables,environment);
			if(max<cMax) max = cMax;
		}
		
		if(table.isEmpty()) return null;
		
		int[] VALUES = new int[reachables.size()+1];
		VALUES[0] = 0;
		int id = 1;
		for(Integer i : reachables) {
			VALUES[id] = i;
			id++;
		}
		
		if(maxLength<0) maxLength = max;
		if(minLength<0) minLength = 0;
		if(minLength>maxLength) minLength = maxLength;

		size = VF.bounded(seqVariable.getName()+"_size", minLength, maxLength, solver);
		path = new IntVar[maxLength];
		
		for(int i=0;i<path.length;i++) {
			path[i] = VF.enumerated(seqVariable.getName()+"_"+i, VALUES, solver);
		}
		
		return new Constraint("PropPathS_C_T",new PropPathS_C_T(source,target,size,path,table,PropagatorPriority.BINARY,true));
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
