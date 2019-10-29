package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;

import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;

class ReorderedAlignBranch implements Cloneable{
	List<Variable> enforcedVars = new UniqueEList<Variable>();
	
	List<Object> precondition = new ArrayList<Object>();
	
	List<Statement> match = new ArrayList<Statement>();
	List<Statement> enforce = new ArrayList<Statement>();
	List<Statement> lazy = new ArrayList<Statement>();
	List<Statement> tail = new ArrayList<Statement>();
	List<Statement> finalOrder = null;
	
	public ReorderedAlignBranch clone() {
		ReorderedAlignBranch nb = new ReorderedAlignBranch();
		
		nb.enforcedVars.addAll(this.enforcedVars);
		nb.precondition.addAll(this.precondition);
		nb.match.addAll(this.match);
		nb.enforce.addAll(this.enforce);
		nb.lazy.addAll(this.lazy);
		nb.tail.addAll(this.tail);
		
		return nb;
	}
}
