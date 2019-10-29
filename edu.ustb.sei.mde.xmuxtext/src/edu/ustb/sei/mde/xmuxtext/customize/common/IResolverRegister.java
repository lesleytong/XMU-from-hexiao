package edu.ustb.sei.mde.xmuxtext.customize.common;

import org.eclipse.emf.ecore.EReference;

public interface IResolverRegister {
	IReferenceResolver getReferenceResolverForLinkingService(EReference ref);
	IReferenceResolver getReferenceResolverForScopingService(EReference ref);
}
