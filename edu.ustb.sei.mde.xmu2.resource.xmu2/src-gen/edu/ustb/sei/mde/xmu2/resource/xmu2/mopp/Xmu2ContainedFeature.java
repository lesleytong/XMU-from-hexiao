/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A Xmu2ContainedFeature represents a path element of a
 * edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2ContainmentTrace
 */
public class Xmu2ContainedFeature {
	
	/**
	 * The class to which the feature points.
	 */
	private org.eclipse.emf.ecore.EClass containerClass;
	
	/**
	 * The feature that points to the container class.
	 */
	private org.eclipse.emf.ecore.EStructuralFeature feature;
	
	public Xmu2ContainedFeature(org.eclipse.emf.ecore.EClass containerClass, org.eclipse.emf.ecore.EStructuralFeature feature) {
		super();
		this.containerClass = containerClass;
		this.feature = feature;
	}
	
	public org.eclipse.emf.ecore.EClass getContainerClass() {
		return containerClass;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public String toString() {
		return (feature == null ? "null" : feature.getName()) + "->" + (containerClass == null ? "null" : containerClass.getName());
	}
	
}
