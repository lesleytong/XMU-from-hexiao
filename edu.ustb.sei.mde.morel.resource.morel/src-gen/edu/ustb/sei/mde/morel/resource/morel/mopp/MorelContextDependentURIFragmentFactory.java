/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class MorelContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements edu.ustb.sei.mde.morel.resource.morel.IMorelContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public MorelContextDependentURIFragmentFactory(edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
