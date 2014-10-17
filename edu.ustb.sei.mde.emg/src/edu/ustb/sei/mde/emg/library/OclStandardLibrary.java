package edu.ustb.sei.mde.emg.library;

public class OclStandardLibrary extends LibrarySpace {

	public OclStandardLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		// TODO Auto-generated constructor stub
		this.getLibraries().add(new StringLibrary(this));
		this.getLibraries().add(new IntegerLibrary(this));
		this.getLibraries().add(new RealLibrary(this));
		this.getLibraries().add(new BooleanLibrary(this));
		this.getLibraries().add(new SetLibrary(this));
		this.getLibraries().add(new OrderedSetLibrary(this));
		this.getLibraries().add(new BagLibrary(this));
		this.getLibraries().add(new SequenceLibrary(this));
		this.getLibraries().add(new ModuleLibrary(this));
		this.getLibraries().add(new AnyLibrary(this));
	}

	@Override
	public boolean adaptFor(Object type) {
		for(Library l : this.getLibraries()) {
			if(l.adaptFor(type)) return true;
		}
		return false;
	}
	
	

}
