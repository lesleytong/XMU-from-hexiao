package edu.ustb.sei.mde.xmuxtext.ui.customize;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

import edu.ustb.sei.mde.xmu2.util.Constants;

public class Xmu2AntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	public Xmu2AntlrTokenToAttributeIdMapper() {
		// TODO Auto-generated constructor stub
	}
	
	final public static String PRIMITIVE_TYPE_ID = "Primitive Type";
	final public static String PATH_NAME_ID = "Complex Type";

	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
//		if(isPrimitiveTypes(tokenName)) {
//			return PRIMITIVE_TYPE_ID;
//		} else if(isReservedTypes(tokenName)) {
//			return RESERVED_TYPE_ID;
//		}
//		else
		
		if(tokenName.equals("RULE_PRIMITIVE_TYPE"))
			return PRIMITIVE_TYPE_ID;
		else if(tokenName.equals("RULE_PATH_NAME"))
			return PATH_NAME_ID;
		else
			return super.calculateId(tokenName, tokenType);
	}

}
