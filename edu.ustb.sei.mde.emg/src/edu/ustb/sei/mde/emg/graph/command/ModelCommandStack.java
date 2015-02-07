package edu.ustb.sei.mde.emg.graph.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModelCommandStack{
	private List<ModelCommand> commands = new ArrayList<ModelCommand>();
	private HashMap<Object,Integer> scope = new HashMap<Object,Integer>();
	
	public boolean rollBack(Object until) {
		int untilId = scope.get(scope);
		
		int i = commands.size()-1;
		for(;i>=untilId;i--) {
			ModelCommand cmd = commands.get(i);
			cmd.undo();
			pop();
		}
		return true;
	}

//	public boolean redo(Object from) {
//		int fromId = scope.get(scope);
//		
//		for(int i=fromId;i<commands.size();i++) {
//			ModelCommand cmd = commands.get(i);
//			cmd.redo();
//		}
//		return true;
//	}
	
	public int putScope(Object obj) {
		int index = commands.size();
		scope.put(obj, index);
		return index;
	}
	
	public void push(ModelCommand cmd) {
		commands.add(cmd);
	}
	
	public void pop() {
		if(commands.isEmpty()) return;
		commands.remove(commands.size()-1);
	}
}
