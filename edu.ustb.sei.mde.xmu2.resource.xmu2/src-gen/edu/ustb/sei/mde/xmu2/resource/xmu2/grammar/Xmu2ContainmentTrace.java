/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

/**
 * A Xmu2ContainmentTrace represents a specific path to a structural feature by
 * navigating over a set of a structural feature from a start class.
 * Xmu2ContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class Xmu2ContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private org.eclipse.emf.ecore.EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[] path;
	
	public Xmu2ContainmentTrace(org.eclipse.emf.ecore.EClass startClass, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[] path) {
		super();
		// Verify arguments
		if (startClass != null) {
			if (path.length > 0) {
				org.eclipse.emf.ecore.EStructuralFeature feature = path[path.length - 1].getFeature();
				if (!startClass.getEAllStructuralFeatures().contains(feature)) {
					throw new RuntimeException("Metaclass " + startClass.getName() + " must contain feature " + feature.getName());
				}
			}
		}
		this.startClass = startClass;
		this.path = path;
	}
	
	public org.eclipse.emf.ecore.EClass getStartClass() {
		return startClass;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2StringUtil.explode(path, "->");
	}
	
}
