package edu.ustb.sei.mde.bxcore.dsl.ui.labeling;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXFunctionDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferData;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferManager;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;

public class BXCoreHoverProvider extends XbaseHoverProvider {

	@Override
	protected String getDocumentation(EObject o) {
		String parentInfo = super.getDocumentation(o);
		if(o instanceof XmuCoreStatement || o instanceof BXFunctionDefinition) {
			XmuCoreStatement stmt = o instanceof BXFunctionDefinition ? ((BXFunctionDefinition)o).getStatement() : (XmuCoreStatement) o;
			try {
				InferData data = InferManager.getInferredTypeModel(o.eResource());
				TupleType st = data.getSourceInfer().getType(stmt);
				TupleType vt = data.getViewInfer().getType(stmt);
				return parentInfo + "<p><b>Source type</b>: "+st.toString() + "</p><p><b>View type</b>: "+vt.toString()+"</p>";
			} catch (Exception e) {
				return parentInfo + "<p>Type inference is currently unaviable!</p>";
			}
		}
		else return parentInfo;
	}
}
