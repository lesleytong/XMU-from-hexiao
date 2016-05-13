package edu.ustb.sei.mde.emg.library;

import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;

public class IntegerLibrary extends AnyLibrary {

	public IntegerLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		
	}

	@Override
	public boolean adaptFor(Object type) {
		return type==EcorePackage.eINSTANCE.getEIntegerObject();
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		switch(operation) {
		case "+":
			return add(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "-":
			return sub(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "*":
			return mul(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "/":
			return div(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "div":
			return idiv(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "mod":
			return mod(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "max":
			return max(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "min":
			return min(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "<":
			return less(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "<=":
			return lessOrEqual(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case ">":
			return greater(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case ">=":
			return greaterOrEqual(self,this.getLibrarySpace().execute("toInteger", params[0]));
		case "minus":
			return minus(self);
		case "abs":
			return abs(self);
		case "toString":
			return toString(self);
		case "toReal":
			return toReal(self);
		case "toInteger":
			return self;
		default:
			return super.execute(operation, self, params);
		}
	}

	public Object add(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a+b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object sub(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a-b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object mul(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a*b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object div(Object self, Object right) {
		try {
			int a = (Integer)self;
			int b = (Integer)right;
			return ((double)a)/((double)b);
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object idiv(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a/b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object mod(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a%b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object max(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a>b?a:b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object min(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a>b?b:a;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object toString(Object self) {
		try {
			Integer a = (Integer)self;
			return a.toString();
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object toInteger(Object self) {
		return self;
	}
	
	public Object toReal(Object self) {
		try {
			int a = (Integer)self;
			return (double)a;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object less(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a<b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object lessOrEqual(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a<=b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object greater(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a>b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object greaterOrEqual(Object self, Object right) {
		try {
			Integer a = (Integer)self;
			Integer b = (Integer)right;
			return a>=b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object minus(Object self) {
		try {
			Integer i = (Integer)self;
			return -i;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object abs(Object self) {
		try {
			Double v = (Double)self;
			return Math.abs(v);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
}
