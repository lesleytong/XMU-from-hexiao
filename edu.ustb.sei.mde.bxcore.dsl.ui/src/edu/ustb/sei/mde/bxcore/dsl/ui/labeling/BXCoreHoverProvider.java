package edu.ustb.sei.mde.bxcore.dsl.ui.labeling;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXFunctionDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferData;
import edu.ustb.sei.mde.bxcore.dsl.infer.InferManager;
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType;

public class BXCoreHoverProvider extends XbaseHoverProvider {

	@Override
	protected boolean hasHover(EObject o) {
		if(o instanceof XmuCoreStatement) return true;
		else return super.hasHover(o);
	}
	
	@Override
	protected String getDocumentation(EObject o) {
		String parentInfo = super.getDocumentation(o);
		if(o instanceof XmuCoreStatement || o instanceof BXFunctionDefinition) {
			String eClassName = o.eClass().getName();
			String syntaxInfo = getSyntaxInfo().getOrDefault(eClassName,"");

			XmuCoreStatement stmt = o instanceof BXFunctionDefinition ? ((BXFunctionDefinition)o).getStatement() : (XmuCoreStatement) o;
			try {
				InferData data = InferManager.getInferredTypeModel(o.eResource());
				TupleType st = data.getSourceInfer().getType(stmt);
				TupleType vt = data.getViewInfer().getType(stmt);
				return parentInfo + "<p><b>Source type</b>: "+st.toString() + "</p><p><b>View type</b>: "+vt.toString()+"</p>"+syntaxInfo;
			} catch (Exception e) {
				return parentInfo + "<p>Type inference is currently unavaiable!</p>"+syntaxInfo;
			}
		}
		else return parentInfo;
	}
	
	static private Map<String, String> syntaxInfo;
	static private Map<String, String> getSyntaxInfo() {
		if(syntaxInfo==null) {
			syntaxInfo = new HashMap<String, String>();
			
			syntaxInfo.put("XmuCoreParallelComposition", 
					"<p><b>Syntax</b>: <i>stmt-type</i>? { <i>stmt1</i> | <i>stmt2</i> | ... }</p>");
			
			syntaxInfo.put("XmuCoreMatchSource", 
					"<p><b>Syntax</b>: <b>matchS</b> <i>stmt-type</i>? <i>pattern</i> <i>body-stmt</i></p>");
			syntaxInfo.put("XmuCoreMatchView", 
					"<p><b>Syntax</b>: <b>matchV</b> <i>stmt-type</i>? <i>pattern</i> <i>body-stmt</i></p>");
			
			syntaxInfo.put("XmuCoreExpandSource", 
					"<p><b>Syntax</b>: <b>expandS</b> <i>stmt-type</i>? <i>pattern</i> (<i>tv</i>&lt;-<i>sv</i>,...) -&gt; <i>body-stmt</i></p>");
			syntaxInfo.put("XmuCoreExpandView", 
					"<p><b>Syntax</b>: <b>expandV</b> <i>stmt-type</i>? <i>pattern</i> (<i>tv</i>&lt;-<i>sv</i>,...) -&gt; <i>body-stmt</i></p>");
			
			syntaxInfo.put("XmuCoreGraphReplace", 
					"<p><b>Syntax</b>: <b>replace</b> <i>stmt-type</i>? <i>patS</i> <i>patV</i> {<i>conversions</i>}?</p>");
			
			syntaxInfo.put("XmuCoreSwitch", 
					"<p><b>Syntax</b>: <b>switch</b> <i>stmt-type</i>? [<i>cases</i> <i>adaptions</i>?]</p>");
			
			syntaxInfo.put("XmuCoreAlign", 
					"<p><b>Syntax</b>: <b>align</b> <i>stmt-type</i>? <i>patS</i> <i>patV</i> <b>with</b> <i>condition</i> <b>match</b> -&gt; <i>stmt</i> <b>unmatchS</b> -&gt; {<i>uni-stmt</i>} <b>unmatchV</b> -&gt; {<i>uni-stmt</i>} </p>");
			
		}
		
		return syntaxInfo;
	}
}
