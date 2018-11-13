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

/**
 * turn source variables into view variables
 * @author hexiao
 *
 */
public class ContextSource extends XmuCore {
	private XmuCore body;
	private Tuple2<FieldDef<?>, FieldDef<?>>[] varMappings;

	public ContextSource(Object key, ContextType viewDef, XmuCore body, Tuple2<FieldDef<?>, FieldDef<?>>[] varMappings)
			throws BidirectionalTransformationDefinitionException {
		super(key, body.getSourceDef(), viewDef);
		this.body = body;
		this.varMappings = varMappings;
		
		this.checkWellDefinedness();
	}
	
	@Override
	protected void checkWellDefinedness() throws BidirectionalTransformationDefinitionException {
		for(Tuple2<FieldDef<?>, FieldDef<?>> mapping : varMappings) {
			if(!this.getSourceDef().fields().contains(mapping.first)) 
				throw new BidirectionalTransformationDefinitionException("The source variable is undefined in the source context");
			
			if(this.getViewDef().fields().contains(mapping.second))
				throw new BidirectionalTransformationDefinitionException("The view variable should not be defined the parent view context");
			
			if(!this.body.getViewDef().fields().contains(mapping.second))
				throw new BidirectionalTransformationDefinitionException("The view variable should be defined the child view context");
		}
		
		if(!this.body.getViewDef().fields().containsAll(this.getViewDef().fields()))
			new BidirectionalTransformationDefinitionException("The parent view variables should be included by the child view");
		
		if(!this.body.getViewDef().fields().stream().allMatch(bv->{
			return this.getViewDef().fields().contains(bv) 
					|| Arrays.stream(this.varMappings).anyMatch(m->m.second.equals(bv));
		})) 
			new BidirectionalTransformationDefinitionException("The child view variables should be defined in the parent view or registered by the statement");
	}

	@Override
	protected GraphConstraint generateConsistencyConstraint() {
		GraphConstraint bc = this.body.getConsistencyConstraint();
		return (gs,cs, gv, cv) ->{
			Context newV = cv.createDownstreamContext(body.getViewDef());
			for(Tuple2<FieldDef<?>, FieldDef<?>> mapping : varMappings) {
				try {
					newV.setValue(mapping.second, cs.getValue(mapping.first));
				} catch (UninitializedException | NothingReturnedException e) {
					return ConstraintStatus.unenforceable;
				}
			}
			return bc.check(gs, cs, gv, newV);
		};
	}

	@Override
	public ViewType forward(SourceType s) throws NothingReturnedException {
		ViewType downstreamViewResult = this.body.forward(s);
		
		if(downstreamViewResult==null 
				|| downstreamViewResult==ViewType.empty()) 
			return ViewType.empty();
		
		
		Context upstreamView = downstreamViewResult.second.createUpstreamContext(this.getViewDef());
		
		downstreamViewResult.second.setUpstream(upstreamView);
		submit(downstreamViewResult.second);
		
		downstreamViewResult.first.setConstraint(getConsistencyConstraint());
		return downstreamViewResult.replaceSecond(upstreamView);
	}

	@Override
	public SourceType backward(SourceType s, ViewType v) throws NothingReturnedException {
		Context downstreamView = v.second.createDownstreamContext(body.getViewDef());
		for(Tuple2<FieldDef<?>, FieldDef<?>> mapping : varMappings) {
			try {
				downstreamView.setValue(mapping.second, s.second.getValue(mapping.first));
			} catch (UninitializedException | NothingReturnedException e) {
				return nothing(e);
			}
		}
		
		downstreamView.setUpstream(v.second);
		SourceType sourcePost = this.body.backward(s, v.replaceSecond(downstreamView));
		
		for(Tuple2<FieldDef<?>, FieldDef<?>> mapping : varMappings) {
			try {
			Object prev = s.second.getValue(mapping.first);
			Object later = sourcePost.second.getValue(mapping.first);
			if(prev==later || (prev!=null && prev.equals(later))) continue;
			else nothing();
			} catch (UninitializedException|NothingReturnedException e) {
				return nothing(e);
			}
		}
		
		submit(downstreamView);
		
		sourcePost.third.trace(this.getSerializationKey(), s.second, v.second, sourcePost.second);
		sourcePost.first.setConstraint(getConsistencyConstraint());
		
		return sourcePost;
	}

}
