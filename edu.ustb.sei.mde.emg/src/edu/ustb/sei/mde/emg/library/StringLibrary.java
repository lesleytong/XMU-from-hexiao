package edu.ustb.sei.mde.emg.library;

import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;

public class StringLibrary extends AnyLibrary {

	public StringLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean adaptFor(Object type) {
		return type==EcorePackage.eINSTANCE.getEString();
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		switch(operation) {
		case "+":
		case "concat":
			return this.concat(self,params[0]);
		case "size":
			return this.size(self);
		case "substring":
			return this.substring(self,params[0], params[1]);
		case "toInteger":
			return this.toInteger(self);
		case "toReal":
			return this.toReal(self);
		case "toBoolean":
			return this.toBoolean(self);
		case "toUpperCase":
			return this.toUpperCase(self);
		case "toLowerCase":
			return this.toLowerCase(self);
		case "indexOf":
			return this.indexOf(self,params[0]);
		case "equalsIgnoreCase":
			return this.equalsIgnoreCase(self,params[0]);
		case "at":
			return this.at(self,params[0]);
		case "characters":
			return this.characters(self);
		case ">":
		case "<":
		case ">=":
		case "<=":
		case "=":
			return this.compare(operation,self,params[0]);
		default:
			return super.execute(operation, self, params);
		}
	}
	
	public Object concat(Object self, Object str) {
		try {
			return self.toString()+str.toString();
		} catch (Exception e) {
			return  OclUndefined.INVALIDED;
		}
	}
	
	public Object size(Object self) {
		try {
			return self.toString().length();
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object substring(Object self, Object lower, Object upper) {
		try {
			Integer l = (Integer)lower;
			Integer u = (Integer)upper;
			String str = self.toString();
			
			if(1<=l&&l<=u&&u<=str.length()) {
				return str.substring(l-1, u);
			}
			else 
				return OclUndefined.INVALIDED;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object toInteger(Object self) {
		try {
			return Integer.parseInt(self.toString());
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}

	public Object toReal(Object self) {
		try {
			return Double.parseDouble(self.toString());
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object toBoolean(Object self) {
		try {
			return Boolean.parseBoolean(self.toString());
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object toUpperCase(Object self) {
		try {
			return self.toString().toUpperCase();
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object toLowerCase(Object self) {
		try {
			return self.toString().toLowerCase();
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object indexOf(Object self, Object str) {
		try {
			return self.toString().indexOf(str.toString());
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object equalsIgnoreCase(Object self, Object str) {
		try {
			return self.toString().equalsIgnoreCase(str.toString());
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object at(Object self, Object index) {
		try {
			return this.substring(self, index, index);
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object characters(Object self) {
		throw new UnsupportedOperationException();
	}
	
	public Object compare(Object self, Object str) {
		try{
			return self.toString().compareTo(str.toString());
		} catch(Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object compare(String op, Object self, Object str) {
		try {
			Object result = compare(self,str);
			Integer r = (Integer)result;
			if(op=="=") return r==0;
			else if(op=="<") return r<0;
			else if(op==">") return r>0;
			else if(op=="<=") return r<=0;
			else if(op==">=") return r>=0;
			else return OclUndefined.INVALIDED;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
}
