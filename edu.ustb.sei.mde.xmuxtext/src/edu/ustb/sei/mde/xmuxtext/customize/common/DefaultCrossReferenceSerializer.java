package edu.ustb.sei.mde.xmuxtext.customize.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;

import com.google.inject.Inject;

public class DefaultCrossReferenceSerializer extends CrossReferenceSerializer {
	
	@Inject
	IResolverRegister resolverRegister;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private IValueConverterService valueConverter;

	public DefaultCrossReferenceSerializer() {
		super();
	}
	
	@Override
	public String serializeCrossRef(EObject context, CrossReference crossref, EObject target, INode node,
			Acceptor errorAcceptor) {
		final EReference ref = GrammarUtil.getReference(crossref, context.eClass());
		String ruleName = ((RuleCall)crossref.getTerminal()).getRule().getName();
		IReferenceResolver resolver = resolverRegister.getReferenceResolverForLinkingService(ref);
		if(resolver!=null) {
			String str = resolver.desolve(context, ref, target, qualifiedNameConverter);
			return valueConverter.toString(str, ruleName);
		}  else 
			return super.serializeCrossRef(context, crossref, target, node, errorAcceptor);
	}

}
