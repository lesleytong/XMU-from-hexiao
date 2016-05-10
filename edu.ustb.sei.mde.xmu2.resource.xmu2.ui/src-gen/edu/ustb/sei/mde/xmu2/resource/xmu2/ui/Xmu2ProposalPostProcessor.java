/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class Xmu2ProposalPostProcessor {
	
	public java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal> process(java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
