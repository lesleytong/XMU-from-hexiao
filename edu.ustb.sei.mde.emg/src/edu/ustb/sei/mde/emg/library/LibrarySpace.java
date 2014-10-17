package edu.ustb.sei.mde.emg.library;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.sei.mde.morel.ExecutionMode;

public abstract class LibrarySpace extends AnyLibrary {

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
		Object type = super.oclType(self);
		try {
			for(Library l : this.getLibraries()) {
				if(l.adaptFor(type)){
					return l.execute(operation, self, params);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		throw new UnsupportedOperationException(operation+" for "+type);
	}
	
	
	
	@Override
	public Object execute(String operation, ExecutionMode mode, Object self,
			Object... params) {
		Object type = super.oclType(self);
		try {
			for(Library l : this.getLibraries()) {
				if(l.adaptFor(type)){
					return l.execute(operation, mode, self, params);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		throw new UnsupportedOperationException(operation+" for "+type);
	}

	public boolean adaptFor(Object type) {
		for(Library l : this.getLibraries()) {
			if(l.adaptFor(type)) return true;
		}
		return false;
	}
}
