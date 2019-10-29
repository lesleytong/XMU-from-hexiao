/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class XmuRule extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public XmuRule(org.eclipse.emf.ecore.EClass metaclass, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuChoice choice, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality) {
		super(cardinality, new edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuChoice getDefinition() {
		return (edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuChoice) getChildren()[0];
	}
	
}

