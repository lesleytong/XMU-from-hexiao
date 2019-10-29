/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

public class MorelCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private edu.ustb.sei.mde.morel.resource.morel.IMorelResourceProvider resourceProvider;
	private edu.ustb.sei.mde.morel.resource.morel.ui.IMorelBracketHandlerProvider bracketHandlerProvider;
	
	public MorelCompletionProcessor(edu.ustb.sei.mde.morel.resource.morel.IMorelResourceProvider resourceProvider, edu.ustb.sei.mde.morel.resource.morel.ui.IMorelBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		edu.ustb.sei.mde.morel.resource.morel.ui.MorelCodeCompletionHelper helper = new edu.ustb.sei.mde.morel.resource.morel.ui.MorelCodeCompletionHelper();
		edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		edu.ustb.sei.mde.morel.resource.morel.ui.MorelProposalPostProcessor proposalPostProcessor = new edu.ustb.sei.mde.morel.resource.morel.ui.MorelProposalPostProcessor();
		java.util.List<edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal> finalProposalList = new java.util.ArrayList<edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal>();
		for (edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (edu.ustb.sei.mde.morel.resource.morel.ui.MorelCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			edu.ustb.sei.mde.morel.resource.morel.ui.IMorelBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
