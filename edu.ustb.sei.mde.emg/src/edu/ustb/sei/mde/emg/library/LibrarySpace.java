package edu.ustb.sei.mde.emg.library;

import java.util.ArrayList;
import java.util.List;

public abstract class LibrarySpace extends Library {

	public LibrarySpace(LibrarySpace librarySpace) {
		super(librarySpace);
		libraries = new ArrayList<Library>();
	}
	
	protected List<Library> libraries;

	public List<Library> getLibraries() {
		return libraries;
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
