/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class Xmu2Rule extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public Xmu2Rule(org.eclipse.emf.ecore.EClass metaclass, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Choice choice, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality) {
		super(cardinality, new edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Choice getDefinition() {
		return (edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Choice) getChildren()[0];
	}
	
}

