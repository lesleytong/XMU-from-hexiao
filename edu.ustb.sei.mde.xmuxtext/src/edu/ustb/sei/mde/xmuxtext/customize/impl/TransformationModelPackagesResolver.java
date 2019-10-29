package edu.ustb.sei.mde.xmuxtext.customize.impl;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.IQualifiedNameConverter;

import edu.ustb.sei.mde.xmuxtext.customize.common.IReferenceResolver;

public class TransformationModelPackagesResolver implements IReferenceResolver {

	public TransformationModelPackagesResolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public EObject resolve(EObject context, EReference reference, String name, IQualifiedNameConverter qnc) {
		String uri = name;
		Resource res = context.eResource();
		ResourceSet set = res.getResourceSet();
		try {
			Map<String, URI> map = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
			for(Entry<String,URI> uriEntry : map.entrySet()) {
				if(uriEntry.getKey().indexOf(uri)!=-1) {	
					if(uri.equals(uriEntry.getKey())) {
						URI u = URI.createURI(uriEntry.getKey());
						Resource loaded = set.getResource(u, true);
						EObject target = loaded.getContents().get(0);
						return (EPackage) target;
					}
				}
			}
			
			URI u = URI.createURI(uri);
			
			if(u.isRelative())
				u = u.resolve(res.getURI());
			
			Resource loaded = set.getResource(u, true);
			EObject target = loaded.getContents().get(0);
			return (EPackage)target;
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public String desolve(EObject context, EReference reference, EObject target, IQualifiedNameConverter qnc) {
		String str= target.eResource().getURI().toString();
		return str;
	}
}
