/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A FuzzyResolveResult is an implementation of the IXmu2ReferenceResolveResult
 * interface that delegates all method calls to a given
 * IXmu2ReferenceResolveResult with ReferenceType EObject. It is used by reference
 * resolver switches to collect results from different reference resolvers in a
 * type safe manner.
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class Xmu2FuzzyResolveResult<ReferenceType extends org.eclipse.emf.ecore.EObject> implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<ReferenceType> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate;
	
	public Xmu2FuzzyResolveResult(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceMapping<ReferenceType>> getMappings() {
		return null;
	}
	
	public boolean wasResolved() {
		return delegate.wasResolved();
	}
	
	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}
	
	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}
	
	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target, warning);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
