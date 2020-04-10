package edu.ustb.sei.mde.graph.type;

public interface ITypeGraphItem extends IElementType {
	TypeGraph getTypeGraph();
	void setTypeGraph(TypeGraph g);
	
	// lyt
	ConcurrentTypeGraph getConcurrentTypeGraph();
	void setConcurrentTypeGraph(ConcurrentTypeGraph g);	
}
