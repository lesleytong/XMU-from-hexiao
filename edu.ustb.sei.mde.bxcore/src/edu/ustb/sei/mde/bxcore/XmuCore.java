package edu.ustb.sei.mde.bxcore;


import java.util.List;

import edu.ustb.sei.mde.bxcore.bigul.BidirectionalTransformation;
import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException;
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException;
import edu.ustb.sei.mde.bxcore.exceptions.UninitializedException;
import edu.ustb.sei.mde.bxcore.structures.Context;
import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.structures.Environment;
import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.graph.typedGraph.constraint.GraphConstraint;
import edu.ustb.sei.mde.structure.Tuple2;



public abstract class XmuCore extends BidirectionalTransformation<SourceType, ViewType> {
	
	private Environment environment;
	
	protected void checkWellDefinedness() throws BidirectionalTransformationDefinitionException {
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	
	public XmuCore(Object key, ContextType sourceDef, ContextType viewDef) throws BidirectionalTransformationDefinitionException{
		this.key = key;
		this.sourceDef = sourceDef;
		this.viewDef = viewDef;
	}
	
	private Object key;
	
	public Object getSerializationKey() {
		return key;
	}
	
	public ContextType getSourceDef() {
		return sourceDef;
	}

	public ContextType getViewDef() {
		return viewDef;
	}

	private ContextType sourceDef;
	
	private ContextType viewDef;
	
	
	public boolean checkSourceContextStructure(Context c) {
		return sourceDef.isTypeOf(c);
	}
	public boolean checkViewContextStructure(Context c) {
		return viewDef.isTypeOf(c);
	}
	
	public Context createSourceContext() {
		return sourceDef.createInstance();
	}
	
	public Context createViewContext() {
		return viewDef.createInstance();
	}
	
	public Context createUpstreamSourceContext(Tuple2<String,String>[] mappings, Context downstreamContext) {
		Context context = createSourceContext();
		
		for(Tuple2<String,String> m : mappings) {
			try {
				context.setValue(m.first, downstreamContext.getValue(m.second));
			} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
			}
		}
		
		return context;
	}
	
	public Context createUpstreamSourceContext(Context downstreamContext) {
		Context context = createSourceContext();
		
		for(FieldDef<?> k : sourceDef.fields()) {
			try {
				context.setValue(k, downstreamContext.getValue(k.getName()));
			} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
			}
		}
		
		return context;
	}
	
	public Context createDownstreamSourceContext(Tuple2<String,String>[] mappings, Context upstreamContext, ContextType downstreamType) {
		Context context = downstreamType.createInstance();
		
		for(Tuple2<String,String> m : mappings) {
			try {
				context.setValue(m.second, upstreamContext.getValue(m.first));
			} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
			}
		}
		
		return context;
	}
	
	public Context createDownstreamSourceContext(Context upstreamContext, ContextType downstreamType) {
		Context context = downstreamType.createInstance();
		
		for(FieldDef<?> k : sourceDef.fields()) {
			try {
				context.setValue(k.getName(), upstreamContext.getValue(k));
			} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
			}
		}
		
		return context;
	}
	
	public Context createUpstreamViewContext(Tuple2<String,String>[] mappings, Context downstreamContext) {
		Context context = createViewContext();
		
		for(Tuple2<String,String> m : mappings) {
			try {
				context.setValue(m.first, downstreamContext.getValue(m.second));
			} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
			}
		}
		
		return context;
	}
	
	public Context createUpstreamViewContext(Context downstreamContext) {
		Context context = createViewContext();
		
		for(FieldDef<?> k : viewDef.fields()) {
			try {
				context.setValue(k, downstreamContext.getValue(k.getName()));
			} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
			}
		}
		
		return context;
	}
	
	public Context createDownstreamViewContext(Tuple2<String,String>[] mappings, Context upstreamContext, ContextType downstreamType) {
		Context context = downstreamType.createInstance();
		
		for(Tuple2<String,String> m : mappings) {
			try {
				context.setValue(m.second, upstreamContext.getValue(m.first));
			} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
			}
		}
		
		return context;
	}
	
	public Context createDownstreamViewContext(Context upstreamContext, ContextType downstreamType) {
		Context context = downstreamType.createInstance();
		
		for(FieldDef<?> k : viewDef.fields()) {
			try {
				context.setValue(k.getName(), upstreamContext.getValue(k));
			} catch (NullPointerException|UninitializedException|NothingReturnedException e) {
			}
		}
		
		return context;
	}
	
	public Context createDownstreamContext(Tuple2<String,String>[] mappings,Context upstream, ContextType downstreamType, boolean ignore) throws NothingReturnedException {
		Context downstream = downstreamType.createInstance();
		
		for(Tuple2<String, String> m : mappings) {
			try {
				downstream.setValue(m.second, upstream.getValue(m.first));
			} catch (UninitializedException|NothingReturnedException e) {
				if(ignore) continue;
				else throw new NothingReturnedException(e);
			}
		}
		return downstream;
	}
	
//	public Context createUpstreamContext(Tuple2<String,String>[] mappings, Context downstream, ContextType ut) {
//		Context upstream = ut.createInstance();
//		
//		for(Tuple2<String, String> m : mappings) {
//			try {
//				upstream.setValue(m.first, this.getValue(m.second));
//			} catch (UninitializedException|NothingReturnedException e) {
//			}
//		}
//		return upstream;
//	}
	
	public void submit(Context... contexts) {
		for(Context c : contexts) 
			c.submit();
	}
	
	public void submit(List<Context> contexts) {
		for(Context c : contexts) 
			c.submit();
	}
	
	
	private GraphConstraint constraint; 
	public GraphConstraint getConsistencyConstraint() {
		if(constraint==null)
			constraint = generateConsistencyConstraint();
		return constraint;
	}
	
	abstract protected GraphConstraint generateConsistencyConstraint();
}
