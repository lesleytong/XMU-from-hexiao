package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.OrderConstraint;
import edu.ustb.sei.mde.morel.Variable;

public class OrderConstraintExecutor extends AdditionalConstraintExecutor<OrderConstraint> {
	private HashMap<EObject,HashMap<EObject,Integer>> visited;

	public OrderConstraintExecutor(OrderConstraint constraint) {
		super(constraint);
		visited = new HashMap<EObject,HashMap<EObject,Integer>>();
	}

	@Override
	public void reset() {
		
		visited.clear();
	}

	@Override
	public boolean evaluate(Context c) {
		try {
			ObjectVariable var = constraint.getBase();
			EObject o = (EObject) c.getValue(var);
			
			HashMap<EObject, Integer> map = visited.get(o);
			
			if(map==null || map.isEmpty()) {
				if(map==null) {
					map = new HashMap<EObject,Integer>();
					visited.put(o, map);
				}
				
				travel(o,0, map);			
			}
			return check(c);
		} catch (Exception e) {
			return true;
		}
	}
	
	private boolean check(Context c) {
		EObject base = (EObject) c.getValue(constraint.getBase());
		HashMap<EObject, Integer> map = visited.get(base);
		
		int last = 0;
		for(Variable v : constraint.getVariables()) {
			ObjectVariable ov = (ObjectVariable)v;
			EObject value = (EObject) c.getValue(ov);
			
			Integer cur = map.get(value);
			
			if(cur==null) return false;
			if(last>cur) return false;
			last = cur;
		}
		return true;
	}
	
	private int travel(EObject o, int ord, HashMap<EObject, Integer> map) {
		if(map.get(o)!=null) return ord;
		map.put(o, ord);
		ord ++;
		
		int size = constraint.getTypes().size();
		for(int index = 0; index < size ; index++) {
			EClass cls = constraint.getTypes().get(index);
			if(cls.isSuperTypeOf(o.eClass())) {
				EReference ref = constraint.getReferences().get(index);
				if(ref.isMany()) {
					@SuppressWarnings("unchecked")
					List<EObject> list = (List<EObject>) o.eGet(ref);
					for(EObject no : list)
						ord = travel(no,ord,map);
				} else {
					EObject no = (EObject) o.eGet(ref);
					if(no!=null)
						ord = travel(no, ord, map);
				}
			}
		}
		
		return ord;
	}

}
