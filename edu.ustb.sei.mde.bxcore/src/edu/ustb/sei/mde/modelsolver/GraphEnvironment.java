package edu.ustb.sei.mde.modelsolver;

import edu.ustb.sei.chocoex.AbstractEnvironmentEx;
import edu.ustb.sei.chocoex.AbstractStoredElementTrail;

public class GraphEnvironment extends AbstractEnvironmentEx {

	public GraphEnvironment() {
		super();
	}

	@Override
	public <T> AbstractStoredElementTrail<T> getTrail(Class<?> clazz) {
		return null;
	}

	@Override
	public void setTrail(Class<?> clazz, AbstractStoredElementTrail<?> trail) {
	}

}
