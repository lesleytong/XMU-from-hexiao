package edu.ustb.sei.mde.emg.library;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.commonutil.util.PairHashMap;
import edu.ustb.sei.commonutil.util.TripleHashMap;

public abstract class ReflectiveLibrary extends Library {
	/*
	 * currently, we distinct the methods of the same name according to the count of parameters 
	 */
	static private TripleHashMap<Class<?>,String, Integer, Method> methodMap = new TripleHashMap<Class<?>,String, Integer, Method>();

	public ReflectiveLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		Class<?> cls = self.getClass();
		Method m = getMethod(cls, operation, params);
		
		try {
			Object r = m.invoke(self, params);
			return r;
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	static private Method getMethod(Class<?> cls, String operation, Object... params) {
		Method m = methodMap.get(cls, operation, params.length);
		if(m==null) {
			m = findMethod(cls,operation,params.length);
			if(m==null) {
				throw new UnsupportedOperationException(operation+" for "+cls);
			} else 
				methodMap.put(cls, operation, params.length, m);
		}
		return m;
	}
	
	static private Method findMethod(Class<?> cls, String operation, Object... params) {
		Method[] methods = cls.getMethods();
		for(Method m : methods) {
			//JAVA API发生了迁移，原来是getParameters，现在是getParameterTypes
			if(m.getName().equals(operation) && m.getParameterTypes().length==params.length) {
				return m;
			}
		}
		return null;
	}

}
