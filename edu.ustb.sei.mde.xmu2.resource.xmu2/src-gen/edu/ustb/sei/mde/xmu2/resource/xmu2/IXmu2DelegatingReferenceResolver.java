/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

/**
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * 
 * @see edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options
 */
public interface IXmu2DelegatingReferenceResolver<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> extends edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
