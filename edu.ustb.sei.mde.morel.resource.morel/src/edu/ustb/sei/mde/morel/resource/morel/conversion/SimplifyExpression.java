package edu.ustb.sei.mde.morel.resource.morel.conversion;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.morel.AdditiveExp;
import edu.ustb.sei.mde.morel.BooleanAndExp;
import edu.ustb.sei.mde.morel.BooleanImpliesExp;
import edu.ustb.sei.mde.morel.BooleanOrExp;
import edu.ustb.sei.mde.morel.MultiplicativeExp;
import edu.ustb.sei.mde.morel.RelationalExp;
import edu.ustb.sei.mde.morel.UnaryExp;
import edu.ustb.sei.mde.morel.UnaryOperator;
import edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource;

public class SimplifyExpression {
	static public void process ( MorelResource resource) {
		process(resource.getContents(),resource);
	}
	
	static private void process (List<EObject> objs, MorelResource resource) {
		for(EObject o : objs) {
			EObject no = SimplifyExpression.simplify(o);
			
			if(no!=o) {
				EObject container = o.eContainer();
				EReference ref = o.eContainmentFeature();
				if(ref.getEReferenceType().isSuperTypeOf(no.eClass()))
					EcoreUtil.replace(container, ref, o, no);
				else no = o;
			}
			process(no.eContents(),resource);
		}
	}
	
	static public EObject simplify(EObject o) {
		if(o instanceof BooleanImpliesExp) {
			if(((BooleanImpliesExp) o).getRight()==null) {
				return simplify(((BooleanImpliesExp) o).getLeft());
			}
		} else if(o instanceof BooleanOrExp) {
			if(((BooleanOrExp) o).getChildren().size()==1) {
				return simplify(((BooleanOrExp) o).getChildren().get(0));
			}
		} else if(o instanceof BooleanAndExp) {
			if(((BooleanAndExp) o).getChildren().size()==1) {
				return simplify(((BooleanAndExp) o).getChildren().get(0));
			}
		} else if(o instanceof RelationalExp) {
			if(((RelationalExp) o).getRight()==null) {
				return simplify(((RelationalExp) o).getLeft());
			}
		} else if(o instanceof AdditiveExp) {
			if(((AdditiveExp) o).getChildren().size()==1) {
				return simplify(((AdditiveExp) o).getChildren().get(0));
			}
		} else if(o instanceof MultiplicativeExp) {
			if(((MultiplicativeExp) o).getChildren().size()==1) {
				return simplify(((MultiplicativeExp) o).getChildren().get(0));
			}
		} else if(o instanceof UnaryExp) {
			if(((UnaryExp) o).getOperator()==UnaryOperator.PLUS) {
				return simplify(((UnaryExp) o).getChild());
			}
		}
		
		return o;
	}
}
