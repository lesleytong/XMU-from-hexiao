/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * A basic implementation of the
 * edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult interface that
 * collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class XmuReferenceResolveResult<ReferenceType> implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix> quickFixes;
	
	public XmuReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
