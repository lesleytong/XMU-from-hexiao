/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("DATA_TYPE".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0xFF, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("true".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0xFF, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("false".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0xff, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("null".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0xff, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("invalid".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0xff, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("@this".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x00, 0x00, 0xff}, null, false, false, false, false);
		}
		if ("@id".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x00, 0x00, 0xff}, null, false, false, false, false);
		}
		if ("SL_COMMENT".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, true, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, true, false, false);
		}
		if ("querymodel".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("type".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("readOnly".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("transient".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("view".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("active".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("passive".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("query".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("lhs".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("rhs".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("nac".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("pac".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("pre".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("post".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("match".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("where".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("in".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("findOne".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("doAll".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("forAll".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("exists".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("select".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("reject".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("collect".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("closure".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("let".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("if".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("then".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("else".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("endif".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("implies".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("or".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("and".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("not".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("for".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("transformation".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("rule".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_39_39_92".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
