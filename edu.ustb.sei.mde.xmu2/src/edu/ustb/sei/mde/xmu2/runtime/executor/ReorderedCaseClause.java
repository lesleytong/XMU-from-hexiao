package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;

import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;

class ReorderedCaseClause implements Cloneable{
	List<Variable> enforcedVariables = new UniqueEList<Variable>();;
	List<Object> preCondition = new ArrayList<Object>();
	List<Object> action = new ArrayList<Object>();
	List<Statement> postCondition = new ArrayList<Statement>();
	
	public ReorderedCaseClause clone() {
		ReorderedCaseClause n = new ReorderedCaseClause();
		n.preCondition.addAll(preCondition);
		n.action.addAll(action);
		n.postCondition.addAll(postCondition);
		n.enforcedVariables.addAll(enforcedVariables);
		return n;
	}
}