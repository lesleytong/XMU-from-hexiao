/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("NUMBER".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x00, 0xff, 0x00}, null, false, false, false, false);
		}
		if ("BOOLEAN".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0xff, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("PRIMITIVE".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0xff, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("SL_COMMENT".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("OBJ_URI".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x40, 0x80, 0xC0}, null, false, false, false, false);
		}
		if ("URI".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x40, 0x80, 0xC0}, null, true, false, false, false);
		}
		if ("import".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("mapping".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("start".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("source".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("view".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("context".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("rule".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("using".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("update".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("with".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("by".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("match".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("unmatchv".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("unmatchs".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("where".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("select".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("forAll".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("exists".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("null".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("nil".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("switch".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("case".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("otherwise".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("enforce".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("delete".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("or".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("and".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("not".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("print".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("skip".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("fail".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_39_39_92".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
