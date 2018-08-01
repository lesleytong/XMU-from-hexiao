package edu.ustb.sei.mde.bxcore;

import java.util.HashSet;
import java.util.Set;

import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.graph.typedGraph.IndexSystem;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;

public class ParallelComposition extends XmuCore {
	
	private XmuCore[] bodies;

	public ParallelComposition(Object key, ContextType sourceDef, ContextType viewDef, XmuCore[] bodies) throws BidirectionalTransformationDefinitionException {
		super(key, sourceDef, viewDef);
		this.bodies = bodies;
		
		checkWellDefinedness();
	}
	
	@Override
	protected void checkWellDefinedness() throws BidirectionalTransformationDefinitionException {
		// FIXME
		
		Set<FieldDef<?>> viewFields = new HashSet<>();
		
		for(XmuCore fork : bodies) {
			
			for(FieldDef<?> m : fork.getSourceDef().fields()) {
				FieldDef<?> up = this.getSourceDef().getField(m.getName());
				if(up==null)
					throw new BidirectionalTransformationDefinitionException("Invalid upstream field "+m);
			}
			
			for(FieldDef<?> m : fork.getViewDef().fields()) {
				FieldDef<?> up = this.getViewDef().getField(m.getName());
				if(up==null)
					throw new BidirectionalTransformationDefinitionException("Invalid upstream field "+m);
				viewFields.add(up);
			}
		}
		
		if(!viewFields.containsAll(this.getViewDef().fields()))
			throw new BidirectionalTransformationDefinitionException("Not all view fields are converted! "+viewFields);
	}

	@Override
	public ViewType forward(SourceType s) throws NothingReturnedException {
		ViewType[] result = new ViewType[this.bodies.length];
		Context[] newSources = new Context[this.bodies.length];
		for(int i=0;i<this.bodies.length;i++) {
			Context newSource = s.second.createDownstreamContext(getSourceDef());
//			newSource.initWith(s.second);
			newSource.setUpstream(s.second);
			newSources[i] = newSource;
			result[i] = bodies[i].forward(SourceType.makeSource(s.first, newSource, s.third));
		}
		
		ContextType vt = this.getViewDef();
		Context finalViewContext = this.createViewContext();
		
		for(FieldDef<?> vk : vt.fields()) {
			if(vk.isElementType()) {
				try {
					finalViewContext.setValue(vk, summarize(result,vk));
				} catch (Exception e) {
					Object common = IndexSystem.generateUUID();
					finalViewContext.setValue(vk, common);
					for(ViewType v : result) {
						try {
							// in principle, we should reset downstream values
							v.first.addIndex(common, v.first.getElementByIndexObject(v.second.getIndexValue(vk)));
						} catch (UninitializedException e1) {
							return nothing(e1);
						}
					}
				}
				
			} else {
				try {
					finalViewContext.setValue(vk, summarize(result,vk));
				} catch (Exception e) {
					// not confluent
					return nothing(e);
				}
			}
		}
		
		TypedGraph finalView = null;
		for(ViewType v : result) {
			v.second.setUpstream(finalViewContext);
			v.second.submit();
			if(finalView==null)
				finalView = v.first;
			else 
				finalView = finalView.additiveMerge(v.first);
		}
		
		this.submit(newSources);
		
		finalView.setConstraint(getConsistencyConstraint());
		
		return ViewType.makeView(finalView, finalViewContext);
	}

	private Object summarize(ViewType[] result, FieldDef<?> vk) throws NothingReturnedException {
		Object value = null;
		for(ViewType v : result) {
			try {
				if(value==null)
					value = v.second.getValue(vk);
				else if(value.equals(v.second.getValue(vk))==false)
					return nothing();
			}catch (UninitializedException e) {
				return nothing();
			}
		}
		return value;
	}

	@Override
	public SourceType backward(SourceType s, ViewType v) throws NothingReturnedException {
		Context[] newSources = new Context[this.bodies.length];
		Context[] newViews = new Context[this.bodies.length];
		SourceType[] results = new SourceType[this.bodies.length];
		TypedGraph[] interSources = new TypedGraph[this.bodies.length];
		TraceSystem[] interTraces = new TraceSystem[this.bodies.length];
		
		for(int i=0;i<this.bodies.length;i++) {
			newSources[i] = s.second.createDownstreamContext(getSourceDef());
//			newSources[i].initWith(s.second);
			
			newViews[i] = v.second.createDownstreamContext(getViewDef());
//			newViews[i].initWith(v.second);
			
			newSources[i].setUpstream(s.second);
			newViews[i].setUpstream(v.second);
			
			results[i] = this.bodies[i].backward(SourceType.makeSource(s.first, newSources[i], s.third), ViewType.makeView(v.first, newViews[i]));
			interSources[i] = results[i].first;
			interTraces[i] = results[i].third;
		}
		
		
		if(v.second.horizontalCorrnectness(newViews, interTraces)==false) {
			XmuCoreUtils.warning("Shared node issue in view detected");
		}
		
		Context finalSourcePost = this.createSourceContext();
		finalSourcePost.initWith(s.second);
		
		ContextType st = this.getSourceDef();
		for(FieldDef<?> sk : st.fields()) {
			if(sk.isElementType()) {
				try {
					finalSourcePost.setValue(sk, summarize(results, sk));
				} catch (Exception e) {
					Object value = IndexSystem.generateUUID();
					finalSourcePost.setValue(sk, value);
					
					for(SourceType r : results) {
						try {
							r.first.addIndex(value, r.first.getElementByIndexObject(r.second.getIndexValue(sk)));
						} catch (UninitializedException e1) {
							return nothing(e1);
						}
					}
				}
			} else {
				try {
					finalSourcePost.setValue(sk, summarize(results, sk));
				} catch (Exception e) {
					return nothing(e);
				}
			}
		}
		
		
		
		TypedGraph finalSource = s.first.merge(interSources);
		TraceSystem finalTrace = TraceSystem.merge(interTraces);
		
		
		submit(newSources);
		submit(newViews);
		for(SourceType r : results) {
			r.second.setUpstream(finalSourcePost);
			r.second.submit();
		}
		
		finalTrace.trace(this.getSerializationKey(), s.second, v.second, finalSourcePost);
		
		finalSource.setConstraint(getConsistencyConstraint());
		
		return SourceType.makeSource(finalSource, finalSourcePost, finalTrace);
	}

	private Object summarize(SourceType[] results, FieldDef<?> sk) throws NothingReturnedException {
		Object value = null;
		for(SourceType v : results) {
			try {
				if(value==null)
					value = v.second.getValue(sk);
				else if(value.equals(v.second.getValue(sk))==false)
					return nothing();
			}catch (UninitializedException e) {
				return nothing();
			}
		}
		return value;
	}

	@Override
	protected GraphConstraint generateConsistencyConstraint() {
		GraphConstraint[] cons = new GraphConstraint[bodies.length];
		for(int i=0;i<bodies.length;i++) {
			cons[i] = bodies[i].getConsistencyConstraint();
		}
		return GraphConstraint.and(cons);
	}

}
