package edu.ustb.sei.mde.xmuxtext.customize.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;


public abstract class AbstractLinkingService extends DefaultLinkingService {
	
	@Inject
	protected IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	protected IResolverRegister register;
	
	public AbstractLinkingService() {
		super();
		
	}
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		IReferenceResolver resolver = this.register.getReferenceResolverForLinkingService(ref);
		if(resolver != null) {
			String str = getCrossRefNodeAsString(node);
			try {
				EObject obj = resolver.resolve(context, ref, str, this.qualifiedNameConverter);
				if(obj!=null)
					return Collections.singletonList(obj);
			} catch(Exception e) {}
			
			return Collections.emptyList();
		}
		else 
			return super.getLinkedObjects(context, ref, node);
	}
	

}
