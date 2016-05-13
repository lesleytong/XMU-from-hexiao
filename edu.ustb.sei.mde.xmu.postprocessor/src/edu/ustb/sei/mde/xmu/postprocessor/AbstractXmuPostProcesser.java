package edu.ustb.sei.mde.xmu.postprocessor;

import java.util.Collections;
import java.util.Map;

import edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptionProvider;
import edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptions;
import edu.ustb.sei.mde.xmu.resource.xmu.IXmuResourcePostProcessor;
import edu.ustb.sei.mde.xmu.resource.xmu.IXmuResourcePostProcessorProvider;

public abstract class AbstractXmuPostProcesser  implements IXmuOptionProvider, 
	IXmuResourcePostProcessorProvider, 
	IXmuResourcePostProcessor {
	
	private boolean flag;
	@Override
	public void terminate() {
		
		setFlag(false);
	}

	@Override
	public IXmuResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap( 
			      IXmuOptions.RESOURCE_POSTPROCESSOR_PROVIDER, 
			      this);
	}

	protected boolean isFlag() {
		return flag;
	}

	protected void setFlag(boolean flag) {
		this.flag = flag;
	}
}
