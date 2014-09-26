package edu.ustb.sei.mde.emg.library;

import java.util.Collection;
import java.util.Iterator;

import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.OrderedSetType;

public class OrderedSetLibrary extends CollectionLibrary {

	public OrderedSetLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
	}

	@Override
	public boolean adaptFor(Object type) {
		return type instanceof OrderedSetType;
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		switch(operation) {
		case "append":
			return including(self, params[0]);
		case "prepend":
			return prepend(self, params[0]);
		case "insertAt":
			return insertAt(self, this.getLibrarySpace().execute("toInteger", params[0]), params[1]);
		case "subOrderedSet":
			return subCollection(self, this.getLibrarySpace().execute("toInteger", params[0]), this.getLibrarySpace().execute("toInteger", params[1]));
		case "at":
			return at(self, this.getLibrarySpace().execute("toInteger", params[0]));
		case "indexOf":
			return at(self, params[0]);
		case "first":
			return first(self);
		case "last":
			return last(self);
		case "reverse":
			return reverse(self);
		}
		return super.execute(operation, self, params);
	}
	
	public Object equal(Object self, Object right) {
		try {
			if(self==null && right==null) return true;
			else if(self==OclUndefined.INVALIDED || right==OclUndefined.INVALIDED) return OclUndefined.INVALIDED;
			else if(self==null || right==null) return false;
			else {
				Collection<?> col = (Collection<?>)self;
				Collection<?> rightCol = (Collection<?>)right;
				Iterator<?> fIter = col.iterator();
				Iterator<?> sIter = rightCol.iterator();
				while(fIter.hasNext()&&sIter.hasNext()) {
					Object o1 = fIter.next();
					Object o2 = sIter.next();
					Boolean f = (Boolean)this.getLibrarySpace().execute("=", o1, o2);
					if(!f) return false;
				}
				if((fIter.hasNext()&&!sIter.hasNext())||(!fIter.hasNext()&&sIter.hasNext())) {
					return false;
				} else return true;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
