package edu.ustb.sei.mde.bxcore;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.ustb.sei.mde.bxcore.structures.ContextType;
import edu.ustb.sei.mde.bxcore.structures.FieldDef;
import edu.ustb.sei.mde.structure.Tuple2;

public final class XmuCoreUtils {
	final public static String COMPONENT_NAME = "edu.ustb.sei.mde.bxcore";
	final public static String ANY_INDEX = "*";
	
	final public static Logger logger = java.util.logging.Logger.getLogger(XmuCoreUtils.COMPONENT_NAME);

	static public Set<FieldDef<?>> findDownKeys(FieldDef<?> uk, Tuple2<String,String>[] mappings, ContextType downType) {
		Set<FieldDef<?>> dks = new HashSet<>();
		for(Tuple2<String, String> m : mappings) {
			if(m.first.equals(uk.getName())) dks.add(downType.getField(m.second));
		}
		return dks;
	}
	
	static public FieldDef<?> findUpKey(FieldDef<?> dk, Tuple2<String, String>[] mappings, ContextType upType) {
		for(Tuple2<String, String> m : mappings) {
			if(m.second.equals(dk.getName())) 
				return upType.getField(m.first);
		}
		return null;
	}
	
	static public void log(Level level, String message, Throwable e) {
		if(e==null)
			logger.log(level, message);
		else 
			logger.log(level, message, e);
	}
	
	static public void warning(String message, Throwable e) {
		log(Level.WARNING, message, e);
	}
	
	static public void warning(String message) {
		warning(message,null);
	}
	
	static public void failure(String message, Throwable e) {
		log(Level.SEVERE, message, e);
	}
	
	static public void failure(String message) {
		failure(message,null);
	}
	
	static public void info(String message, Throwable e) {
		log(Level.INFO, message, e);
	}
	
	static public void info(String message) {
		failure(message,null);
	}

	public static boolean traceSetDisjoint(List<Trace> leftTrace, List<Trace> rightTrace) {
		return Collections.disjoint(leftTrace, rightTrace);
	}

	static public <T> void addUnique(List<T> col, T e) {
		for(T c : col) {
			if(c.equals(e)) return;
		}
		col.add(e);
	}

	static public <T> void addAllUnique(List<T> col, List<T> app) {
		for(T a : app)
			addUnique(col,a);
	}
}
