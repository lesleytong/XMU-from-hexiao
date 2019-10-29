/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2CompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ResourceProvider resourceProvider;
	private edu.ustb.sei.mde.xmu2.resource.xmu2.ui.IXmu2BracketHandlerProvider bracketHandlerProvider;
	
	public Xmu2CompletionProcessor(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ResourceProvider resourceProvider, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.IXmu2BracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CodeCompletionHelper helper = new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CodeCompletionHelper();
		edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ProposalPostProcessor proposalPostProcessor = new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ProposalPostProcessor();
		java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal> finalProposalList = new java.util.ArrayList<edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal>();
		for (edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CompletionProposal proposal : finalProposalList) {
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
			edu.ustb.sei.mde.xmu2.resource.xmu2.ui.IXmu2BracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
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
