package edu.ustb.sei.mde.bxcore;

import java.util.Arrays;

import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint.ConstraintStatus;
import edu.ustb.sei.mde.structure.Tuple2;

// unclear
public class ContextView extends XmuCore {
	private XmuCore body;
	private Tuple2<FieldDef<?>, FieldDef<?>>[] varMappings;

	public ContextView(Object key, ContextType sourceDef, XmuCore body, Tuple2<FieldDef<?>, FieldDef<?>>[] varMappings)
			throws BidirectionalTransformationDefinitionException {
		super(key, sourceDef, body.getViewDef());
		this.body = body;
		this.varMappings = varMappings;
		
		this.checkWellDefinedness();
	}
	
	@Override
	protected void checkWellDefinedness() throws BidirectionalTransformationDefinitionException {
		for(Tuple2<FieldDef<?>, FieldDef<?>> mapping : varMappings) {
			if(this.getSourceDef().fields().contains(mapping.first)) 
				throw new BidirectionalTransformationDefinitionException("The source variable should not be defined in the parent source context");
			
			if(!this.getViewDef().fields().contains(mapping.second))
				throw new BidirectionalTransformationDefinitionException("The view variable should be defined the parent view context");
			
			if(!this.body.getSourceDef().fields().contains(mapping.second))
				throw new BidirectionalTransformationDefinitionException("The parent variable should be defined the child source context");
		}
		
		if(!this.body.getSourceDef().fields().containsAll(this.getSourceDef().fields()))
			new BidirectionalTransformationDefinitionException("The parent source variables should be included by the child source");
		
		if(!this.body.getSourceDef().fields().stream().allMatch(bv->{
			return this.getSourceDef().fields().contains(bv) 
					|| Arrays.stream(this.varMappings).anyMatch(m->m.first.equals(bv));
		})) 
			new BidirectionalTransformationDefinitionException("The child source variables should be defined in the parent source or registered by the statement");
	}

	@Override
	protected GraphConstraint generateConsistencyConstraint() {
		GraphConstraint bc = this.body.getConsistencyConstraint();
		return (gs,cs, gv, cv) ->{
			Context newS = cs.createDownstreamContext(body.getSourceDef());
			for(Tuple2<FieldDef<?>, FieldDef<?>> mapping : varMappings) {
				try {
					newS.setValue(mapping.first, cv.getValue(mapping.second));
				} catch (UninitializedException | NothingReturnedException e) {
					return ConstraintStatus.unenforceable;
				}
			}
			return bc.check(gs, newS, gv, cv);
		};
	}

	@Override
	public ViewType forward(SourceType s) throws NothingReturnedException {
		return null;
	}

	@Override
	public SourceType backward(SourceType s, ViewType v) throws NothingReturnedException {
		return null;
	}

}
