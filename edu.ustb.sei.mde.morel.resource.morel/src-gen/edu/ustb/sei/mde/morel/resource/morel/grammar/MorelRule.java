/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class MorelRule extends edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public MorelRule(org.eclipse.emf.ecore.EClass metaclass, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelChoice choice, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality) {
		super(cardinality, new edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.grammar.MorelChoice getDefinition() {
		return (edu.ustb.sei.mde.morel.resource.morel.grammar.MorelChoice) getChildren()[0];
	}
	
}

