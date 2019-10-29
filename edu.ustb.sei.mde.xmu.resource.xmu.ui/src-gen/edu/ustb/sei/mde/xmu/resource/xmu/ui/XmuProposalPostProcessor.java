/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class XmuProposalPostProcessor {
	
	public java.util.List<edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuCompletionProposal> process(java.util.List<edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
