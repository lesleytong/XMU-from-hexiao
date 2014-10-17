/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelBracketInformationProvider {
	
	public class BracketPair implements edu.ustb.sei.mde.morel.resource.morel.IMorelBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelBracketPair> getBracketPairs() {
		java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelBracketPair> result = new java.util.ArrayList<edu.ustb.sei.mde.morel.resource.morel.IMorelBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("[", "]", true));
		result.add(new BracketPair("<", ">", true));
		result.add(new BracketPair("'", "'", false));
		return result;
	}
	
}
