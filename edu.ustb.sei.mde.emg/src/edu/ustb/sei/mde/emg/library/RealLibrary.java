package edu.ustb.sei.mde.emg.library;

import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;

public class RealLibrary extends AnyLibrary {

	public RealLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		
	}

	@Override
	public boolean adaptFor(Object type) {
		return type==EcorePackage.eINSTANCE.getEDoubleObject();
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		switch(operation) {
		case "+":
			return add(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "-":
			return sub(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "*":
			return mul(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "/":
			return div(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "mod":
			return mod(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "max":
			return max(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "min":
			return min(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "<":
			return less(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "<=":
			return lessOrEqual(self,this.getLibrarySpace().execute("toReal", params[0]));
		case ">":
			return greater(self,this.getLibrarySpace().execute("toReal", params[0]));
		case ">=":
			return greaterOrEqual(self,this.getLibrarySpace().execute("toReal", params[0]));
		case "minus":
			return minus(self);
		case "abs":
			return abs(self);
		case "floor":
			return floor(self);
		case "round":
			return round(self);
		case "toString":
			return toString(self);
		case "toInteger":
			return toInteger(self);
		case "toReal":
			return self;
		default:
			return super.execute(operation, self, params);
		}
	}
	
	public Object add(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a+b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object sub(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a-b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object mul(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a*b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object div(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a/b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object mod(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a%b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object max(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a>b?a:b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object min(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a>b?b:a;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object toString(Object self) {
		try {
			Double a = (Double)self;
			return a.toString();
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object toInteger(Object self) {
		try {
			double a = (Double)self;
			return (int)a;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object less(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a<b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object lessOrEqual(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a<=b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object greater(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a>b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object greaterOrEqual(Object self, Object right) {
		try {
			Double a = (Double)self;
			Double b = (Double)right;
			return a>=b;
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object minus(Object self) {
		try {
			Double i = (Double)self;
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
	
	public Object floor(Object self) {
		try {
			Double v = (Double)self;
			return Math.floor(v);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object round(Object self) {
		try {
			Double v = (Double)self;
			return Math.round(v);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
}
