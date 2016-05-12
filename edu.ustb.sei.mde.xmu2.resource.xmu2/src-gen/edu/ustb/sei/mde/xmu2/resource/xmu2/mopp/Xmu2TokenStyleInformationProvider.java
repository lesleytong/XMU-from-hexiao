/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2TokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenStyle getDefaultTokenStyle(String tokenName) {
		if ("NUMBER".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x00, 0xff, 0x00}, null, false, false, false, false);
		}
		if ("BOOLEAN".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0xff, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("SL_COMMENT".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("OBJ_URI".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x40, 0x80, 0xC0}, null, false, false, false, false);
		}
		if ("module".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("import".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("entry".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("source".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("view".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("top".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("rule".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("function".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("select".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("forAll".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("exists".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("first".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("last".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("at".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("null".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("undefined".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("not".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("and".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("or".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("update".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("with".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("by".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("switch".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("match".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("unmatchs".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("unmatchv".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("default".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("case".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("delete".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("enforce".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("foreach".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("skip".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("otherwise".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_60_62_92".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_39_39_92".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
