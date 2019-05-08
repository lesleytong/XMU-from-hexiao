package edu.ustb.sei.chocoex;

import java.lang.reflect.Array;
import java.util.stream.Stream;

import org.chocosolver.memory.IEnvironment;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Settings;

public abstract class AbstractModelEx extends Model {
	protected AbstractModelEx(IEnvironment environment, String name, Settings settings) {
		super(environment, name, settings);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T[] retrieveVariables(Class<? super T> superClass) {
		return Stream.of(this.getVars()).filter(v->superClass.isInstance(v)).toArray(size->(T[]) Array.newInstance(superClass, size));
	}

}
