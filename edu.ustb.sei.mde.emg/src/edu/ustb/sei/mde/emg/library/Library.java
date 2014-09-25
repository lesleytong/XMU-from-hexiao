package edu.ustb.sei.mde.emg.library;

public abstract class Library {
	abstract public boolean adaptFor(Object type);
	abstract public Object execute(String operation,Object self, Object... params);
	
	protected LibrarySpace librarySpace;

	public LibrarySpace getLibrarySpace() {
		return librarySpace;
	}
	public Library(LibrarySpace librarySpace) {
		super();
		this.librarySpace = librarySpace;
	}
}
