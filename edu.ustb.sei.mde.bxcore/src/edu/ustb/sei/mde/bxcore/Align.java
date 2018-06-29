package edu.ustb.sei.mde.bxcore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.graph.pattern.Pattern;
import edu.ustb.sei.mde.graph.typedGraph.IndexSystem;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.Tuple2;

public class Align extends XmuCore {
	private Pattern patS;
	public Align(Object key, ContextType sourceDef, ContextType viewDef, Pattern patS, Pattern patV,
			BiFunction<Context, Context, Boolean> alignment, XmuCore match,
			BiFunction<SourceType, ViewType, SourceType> unmatchedSource,
			BiFunction<SourceType, ViewType, SourceType> unmatchedView) throws BidirectionalTransformationDefinitionException {
		super(key, sourceDef, viewDef);
		this.patS = patS;
		this.patV = patV;
		this.alignment = alignment;
		this.match = match;
		this.unmatchedSource = unmatchedSource;
		this.unmatchedView = unmatchedView;
		this.isOrdered = false;
		
		checkWellDefinedness();
	}

	private Pattern patV;
	private BiFunction<Context,Context,Boolean> alignment;
	private XmuCore match;
	private BiFunction<SourceType, ViewType, SourceType> unmatchedSource;
	private BiFunction<SourceType, ViewType, SourceType> unmatchedView;
	
	private boolean isOrdered;
	
	public Align(Object key, ContextType sourceDef, ContextType viewDef, Pattern patS, Pattern patV, XmuCore match,
			BiFunction<SourceType, ViewType, SourceType> unmatchedSource,
			BiFunction<SourceType, ViewType, SourceType> unmatchedView) throws BidirectionalTransformationDefinitionException {
		super(key, sourceDef, viewDef);
		this.patS = patS;
		this.patV = patV;
		this.alignment = (s,v)->true;
		this.match = match;
		this.unmatchedSource = unmatchedSource;
		this.unmatchedView = unmatchedView;
		this.isOrdered = true;
		
		checkWellDefinedness();
	}
	
	@Override
	protected void checkWellDefinedness() throws BidirectionalTransformationDefinitionException {
		if(patS.getType()!=match.getSourceDef() || patV.getType()!=match.getViewDef())
			throw new BidirectionalTransformationDefinitionException("Type inconsistent");
	}

	@Override
	protected GraphConstraint generateConsistencyConstraint() {
		GraphConstraint innerCons = match.getConsistencyConstraint();
		
		return (gs,cs,gv,cv) -> {
			List<Context> sources = patS.match(gs, cs);
			List<Context> views = patV.match(gv, cv);
			
			if(sources.size()!=views.size()) return false;
			
			// construct one-to-one mapping 
			List<Tuple2<Context,Context>> alignments = new ArrayList<>();
			try {
				if(checkAndConstructAlignment(sources, views, alignments)==false)
					return false;
			}catch (Exception e) {
				return false;
			}
			
			// check match condition for each alignment
			for(Tuple2<Context, Context> a : alignments) {
				if(innerCons.check(gs, a.first, gv, a.second)==false)
					return false;
			}
			
			return true;
		};
	}
	
	protected boolean checkAndConstructAlignment(List<Context> s, List<Context> v, List<Tuple2<Context,Context>> alignments) throws NothingReturnedException {
		boolean isAligned = true;
		
		int sizeOfS = s.size();
		int sizeOfV = v.size();
		
		if(sizeOfS!=sizeOfV) 
			isAligned = false;
		
		if(isOrdered) {
			for(int si=0,vi=0 ; si<sizeOfS || vi<sizeOfV; ) {
				Context sc = null;
				Context vc = null;
				
				if(si<sizeOfS)
					sc = s.get(si);
				if(vi<sizeOfV)
					vc = v.get(vi);
				
				if(sc==null) {
					isAligned = false;
					alignments.add(new Tuple2<Context, Context>(null, vc));
					vi++;
				} else if(vc==null) {
					isAligned = false;
					alignments.add(new Tuple2<Context, Context>(sc, null));
					si++;
				} else {
					if(this.alignment.apply(sc, vc)) {
						alignments.add(new Tuple2<Context, Context>(sc, vc));
						si++;
						vi++;
					} else {
						isAligned = false;
						alignments.add(new Tuple2<Context, Context>(sc, null));
						si++;
					}
				}
			}
		} else {
			Set<Context> aligned = new HashSet<>();
			
			for(Context vc : v) {
				Context matched = null;
				for(Context sc : s) {
					if(alignment.apply(sc, vc)) {
						if(matched!=null) {// multiple alignment
							throw new NothingReturnedException();
						}
						if(aligned.contains(sc)) // multiple alignment
							throw new NothingReturnedException();
						matched = sc;
						aligned.add(sc);
					}
				}
				
				if(matched!=null) {
					alignments.add(new Tuple2<Context, Context>(matched, vc));
				} else {
					alignments.add(new Tuple2<Context, Context>(null, vc));
					isAligned = false;
				}
			}
			
			for(Context sc : s) {
				if(aligned.contains(sc)==false) {
					alignments.add(new Tuple2<Context, Context>(sc, null));
					isAligned = false;
				}
			}
			
		}
		
		return isAligned;
				
	}

	@Override
	public ViewType forward(SourceType s) throws NothingReturnedException {
		List<Context> sourceMatches = patS.match(s.first, s.second);
		List<ViewType> views = new ArrayList<>();
		
		for(Context sc : sourceMatches) {
			sc.setUpstream(s.second);
			ViewType v = match.forward(SourceType.makeSource(s.first, sc, s.third));
			views.add(v);
		}
		
		ContextType vt = this.getViewDef();
		Context upstreamView = this.createViewContext();
		for(FieldDef<?> vk : vt.fields()) {
			if(vk.isElementType()) {
				try {
					upstreamView.setValue(vk, summarize(views,vk));
				} catch (Exception e) {
					Object common = IndexSystem.generateUUID();
					upstreamView.setValue(vk, common);
					for(ViewType v : views) {
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
					upstreamView.setValue(vk, summarize(views,vk));
				} catch (Exception e) {
					// not confluent
					return nothing(e);
				}
			}
		}
		
		TypedGraph finalView = null;
		for(ViewType v : views) {
			v.second.setUpstream(upstreamView);
			v.second.submit();
			if(finalView==null)
				finalView = v.first;
			else 
				finalView = finalView.additiveMerge(v.first);
		}
		
		this.submit(sourceMatches);
		
		finalView.setConstraint(getConsistencyConstraint());
		
		return ViewType.makeView(finalView, upstreamView);
	}
	
	private Object summarize(List<ViewType> result, FieldDef<?> vk) throws NothingReturnedException {
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
		return plainBackward(s, v, true);
	}

	protected SourceType plainBackward(SourceType s, ViewType v, boolean adaption) throws NothingReturnedException {
		List<Context> sourceMatches = patS.match(s.first, s.second);
		List<Context> viewMatches = patV.match(v.first, v.second);
		List<Tuple2<Context,Context>> alignments = new ArrayList<>();
		
		boolean aligned = checkAndConstructAlignment(sourceMatches, viewMatches, alignments);
		
		if(!aligned) {
			if(adaption) {
				TypedGraph ma = adaption(s,v,alignments);
				return plainBackward(SourceType.makeSource(ma, s.second, s.third), v, false);
			} else return nothing();
		} else {
			sourceMatches.forEach(sm->sm.setUpstream(s.second));
			viewMatches.forEach(vm->vm.setUpstream(v.second));
			
			Context upstreamSourcePost = this.createUpstreamSourceContext(s.second);
			
			List<SourceType> updatedSources = new ArrayList<>();
			for(Tuple2<Context, Context> alignment : alignments) {
				SourceType sp = match.backward(SourceType.makeSource(s.first, alignment.first, s.third), ViewType.makeView(v.first, alignment.second));
				sp.second.setUpstream(upstreamSourcePost);
				updatedSources.add(sp);
			}
			
			TraceSystem[] interTraces = updatedSources.stream().map(us->us.third).toArray(size->new TraceSystem[size]);

			if(v.second.horizontalCorrnectness(viewMatches.toArray(new Context[viewMatches.size()]), interTraces)) {
				XmuCoreUtils.failure("Shared node issue in view detected");
			}
			
			TypedGraph finalSourcePost = s.first.merge(updatedSources.stream().map(us->us.first).toArray(size->new TypedGraph[size]));
			TraceSystem finalTs = TraceSystem.merge(interTraces);
			
			finalSourcePost.setConstraint(getConsistencyConstraint());
			
			this.submit(sourceMatches);
			this.submit(viewMatches);
			this.submit(updatedSources.stream().map(us->us.second).toArray(size->new Context[size]));
			
			return SourceType.makeSource(finalSourcePost, upstreamSourcePost, finalTs);
		}
	}

	private TypedGraph adaption(SourceType s, ViewType v, List<Tuple2<Context, Context>> alignments) throws NothingReturnedException {
		List<SourceType> delta = new ArrayList<>();
		
		for(Tuple2<Context, Context> alignment : alignments) {
			if(alignment.first!=null&&alignment.second!=null) continue;
			else if(alignment.first==null) { // unmatchV
				SourceType sp = this.unmatchedView.apply(s,v);
				delta.add(sp);
			} else if(alignment.second==null) { // unmatchS
				SourceType sp = this.unmatchedSource.apply(s,v);
				delta.add(sp);
			}
		}
		
		TypedGraph finalSource = s.first.merge(delta.toArray(new TypedGraph[delta.size()]));
		return finalSource;
	}

}


