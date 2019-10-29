package edu.ustb.sei.mde.xmu2.runtime.structures;

import java.util.HashMap;
import java.util.List;

import edu.ustb.sei.commonutil.util.PairHashMap;
import edu.ustb.sei.mde.xmu2core.CallStatement;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;

public class CacheSystem {

	public CacheSystem() {
		orderCache = new PairHashMap<List<Variable>, Statement, Object>();
	}

	public Object getFromOrderCache(List<Variable> f, Statement s) {
		return orderCache.get(f, s);
	}

	public void putIntoOrderCache(List<Variable> f, Statement s, Object t) {
		orderCache.put(f, s, t);
	}

	public List<CallStatement> getFromProcedureCallCache(List<? extends Object> f) {
		return procedureCallCache.get(f);
	}

	public void putIntoProcedureCallCache(List<? extends Object> f, List<CallStatement> s) {
		procedureCallCache.put(f, s);
	}

	private HashMap<List<? extends Object>, List<CallStatement>> procedureCallCache = new HashMap<List<? extends Object>, List<CallStatement>>();

	private PairHashMap<List<Variable>, Statement, Object> orderCache = null;

}
