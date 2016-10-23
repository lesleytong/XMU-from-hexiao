/**
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext.ui.contentassist;

import edu.ustb.sei.mde.xmuxtext.ui.contentassist.AbstractXmu2ProposalProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class Xmu2ProposalProvider extends AbstractXmu2ProposalProvider {
  @Override
  public void complete_EntryPoint(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_EntryPoint(model, ruleCall, context, acceptor);
    final String proposal = "entry rule_name (source[0], view[0])";
    ICompletionProposal _createCompletionProposal = this.createCompletionProposal(proposal, context);
    acceptor.accept(_createCompletionProposal);
  }
  
  @Override
  public void complete_ModelRule(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_ModelRule(model, ruleCall, context, acceptor);
    final String proposal = "rule rulename (source s : OclAny, view v : OclAny) {\n}";
    ICompletionProposal _createCompletionProposal = this.createCompletionProposal(proposal, context);
    acceptor.accept(_createCompletionProposal);
  }
  
  @Override
  public void complete_UpdateStatement(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.complete_UpdateStatement(model, ruleCall, context, acceptor);
    final String proposal = "update s:OclObject{} with v:OclObject{} by match -> {} unmatchs -> {} unmatchv -> {}";
    ICompletionProposal _createCompletionProposal = this.createCompletionProposal(proposal, context);
    acceptor.accept(_createCompletionProposal);
  }
}
