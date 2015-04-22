/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class XmuContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public XmuContextDependentURIFragmentFactory(edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
