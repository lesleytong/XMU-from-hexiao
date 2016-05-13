package edu.ustb.sei.mde.emg.library;

import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;

public class BooleanLibrary extends AnyLibrary {

	public BooleanLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		
	}

	@Override
	public boolean adaptFor(Object type) {
		return type==EcorePackage.eINSTANCE.getEBooleanObject();
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		switch(operation) {
		case "or":
			return or(self,this.getLibrarySpace().execute("toBoolean", params[0]));
		case "xor":
			return xor(self,this.getLibrarySpace().execute("toBoolean", params[0]));
		case "and":
			return and(self,this.getLibrarySpace().execute("toBoolean", params[0]));
		case "implies":
			return implies(self,this.getLibrarySpace().execute("toBoolean", params[0]));
		case "not":
			return not(self);
		case "toBoolean":
			return self;
		default:
			return super.execute(operation, self, params);
		}
	}

	public Object or(Object self, Object right) {
		Boolean l = null;
		Boolean r = null;
		try{
			l = (Boolean)self;
			if(l==true) return true;
		}catch(Exception e) {
			try {
				r = (Boolean)right;
				if(r==true) return true;
				else return OclUndefined.INVALIDED;
			} catch (Exception e1) {
				return OclUndefined.INVALIDED;
			}
		}
		try {
			r = (Boolean)right;
			if(r==true) return true;
			else return false;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object and(Object self, Object right) {
		Boolean l = null;
		Boolean r = null;
		try{
			l = (Boolean)self;
			if(l==false) return false;
		}catch(Exception e) {
			try {
				r = (Boolean)right;
				if(r==false) return false;
				else return OclUndefined.INVALIDED;
			} catch (Exception e1) {
				return OclUndefined.INVALIDED;
			}
		}
		try {
			r = (Boolean)right;
			if(r==false) return false;
			else return true;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object not(Object self) {
		Boolean l = null;
		try{
			l = (Boolean)self;
			return !l;
		}catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object implies(Object self, Object right) {
		return or(not(self),right);
	}
	
	public Object xor(Object self, Object right) {
		Boolean l = null;
		Boolean r = null;
		try{
			l = (Boolean)self;
			r = (Boolean)right;
			return (l&&!r) || (!l&&r);
		}catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	static public boolean isTrue(Object self) {
		return Boolean.TRUE.equals(self);
	}
	
	static public boolean isFalse(Object self) {
		return Boolean.FALSE.equals(self);
	}
}
