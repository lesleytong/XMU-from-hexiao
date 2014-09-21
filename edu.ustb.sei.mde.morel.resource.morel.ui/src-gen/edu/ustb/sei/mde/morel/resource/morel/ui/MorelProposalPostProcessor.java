/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class MorelProposalPostProcessor {
	
	public java.util.List<edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal> process(java.util.List<edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
