package edu.ustb.sei.mde.emg.library;

public class ModuleLibrary extends AnyLibrary {

	public ModuleLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean adaptFor(Object type) {
		return type==IModuleProvider.class;
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
//		// TODO Auto-generated method stub
//		return super.execute(operation, self, params);
		IModuleProvider module = (IModuleProvider)self;
		return module.execute(operation, params);
	}

}
