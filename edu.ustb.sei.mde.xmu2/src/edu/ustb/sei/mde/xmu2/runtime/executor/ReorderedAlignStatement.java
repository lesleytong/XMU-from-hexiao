package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;

class ReorderedAlignStatement {
	List<Variable> enforcedVars = null;
	List<Statement> enforce = new ArrayList<Statement>();
	List<Statement> lazy = new ArrayList<Statement>();
	List<Statement> tail = new ArrayList<Statement>();
	List<Statement> finalOrder = new ArrayList<Statement>();
}