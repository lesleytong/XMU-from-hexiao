package edu.ustb.sei.mde.emg.library;

import edu.ustb.sei.mde.morel.ExecutionMode;

public abstract class Library {
	abstract public boolean adaptFor(Object type);
	abstract public Object execute(String operation,Object self, Object... params);
	
	public Object execute(String operation, ExecutionMode mode, Object self, Object... params) {
		return execute(operation,self,params);
	}
	
	protected LibrarySpace librarySpace;

	public LibrarySpace getLibrarySpace() {
		return librarySpace;
	}
	public Library(LibrarySpace librarySpace) {
		super();
		this.librarySpace = librarySpace;
	}
}
