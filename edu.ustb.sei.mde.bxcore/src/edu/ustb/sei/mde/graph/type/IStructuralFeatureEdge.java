package edu.ustb.sei.mde.graph.type;

import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.INamedElement;

public interface IStructuralFeatureEdge extends IEdge, INamedElement {
	boolean isMany();
	boolean isUnique();
}
