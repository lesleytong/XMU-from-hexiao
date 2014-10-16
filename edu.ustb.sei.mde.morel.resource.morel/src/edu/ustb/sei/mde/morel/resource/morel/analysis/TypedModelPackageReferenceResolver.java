/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;


public class TypedModelPackageReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.TypedModel, org.eclipse.emf.ecore.EPackage> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.TypedModel, org.eclipse.emf.ecore.EPackage> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.TypedModel, org.eclipse.emf.ecore.EPackage>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.TypedModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		if(resolveFuzzy){
//			try {
//				Resource resource = container.eResource();
//				if(resource==null) return;
//				ResourceSet set = resource.getResourceSet();
//				
//				
//				String uri = null;
//				
//				if(identifier.charAt(identifier.length()-1)=='#')
//					uri = identifier.substring(1,identifier.length()-1);
//				else uri = identifier.substring(1);
//				
//				 Map<String, URI> map = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
//				 for(Entry<String,URI> uriEntry : map.entrySet()) {
//					 if(uriEntry.getKey().indexOf(uri)!=-1) {
//						URI u = URI.createURI(uriEntry.getKey());
//						Resource res = set.getResource(u, true);
//						EObject target = res.getContents().get(0);
//						
//						result.addQuickFix(new edu.ustb.sei.mde.morel.resource.morel.mopp.SetPackageReferenceQuickFix("Replace with " + uri, 
//								 "IMG_TOOL_FORWARD", container, reference, target));
//					 }
//				 }
//			} catch (Exception e) {
//				
//			}
		} else {
			String uri = identifier.substring(1, identifier.length()-1);
			delegate.resolve(uri, container, reference, position, resolveFuzzy, result);
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EPackage element, edu.ustb.sei.mde.morel.TypedModel container, org.eclipse.emf.ecore.EReference reference) {
		return "#"+element.getNsURI()+"#";
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
