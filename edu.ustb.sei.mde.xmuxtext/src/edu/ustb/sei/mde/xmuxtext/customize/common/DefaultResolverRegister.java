package edu.ustb.sei.mde.xmuxtext.customize.common;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;

public class DefaultResolverRegister implements IResolverRegister {
	
	public void init() {
		
	}
	
	protected Map<EReference, IReferenceResolver> referenceResolverForLinkingService;
	protected Map<EReference, IReferenceResolver> referenceResolverForScopingService;

	public DefaultResolverRegister() {
		this.referenceResolverForLinkingService = new HashMap<EReference, IReferenceResolver>();
		this.referenceResolverForScopingService = new HashMap<EReference, IReferenceResolver>();
		init();
	}

	@Override
	public IReferenceResolver getReferenceResolverForLinkingService(EReference ref) {
		return this.referenceResolverForLinkingService.get(ref);
	}

	@Override
	public IReferenceResolver getReferenceResolverForScopingService(EReference ref) {
		return this.referenceResolverForScopingService.get(ref);
	}

}
