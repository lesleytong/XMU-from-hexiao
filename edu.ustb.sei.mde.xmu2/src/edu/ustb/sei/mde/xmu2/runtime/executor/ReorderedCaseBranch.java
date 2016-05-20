package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;

import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;

class ReorderedCaseBranch implements Cloneable{
	List<Variable> enforcedVariables = null;
	
	List<Object> preCondition = new ArrayList<Object>();
	List<Statement> action = new ArrayList<Statement>();
	List<Statement> postCondition = new ArrayList<Statement>();
	
	public ReorderedCaseBranch clone() {
		ReorderedCaseBranch n = new ReorderedCaseBranch();
		n.preCondition.addAll(preCondition);
		n.action.addAll(action);
		n.postCondition.addAll(postCondition);
		n.enforcedVariables.addAll(enforcedVariables);
		return n;
	}
}