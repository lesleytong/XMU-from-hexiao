package edu.ustb.sei.mde.bxcore.structures;

public interface Maybe { 
	@SuppressWarnings("unchecked")
	default public <T> T getValue()  {
		return (T) getValue(Just.class);
	};
	public Object getValue(Class<?> clazz);
	
	static public Maybe just(Object v) {
		return new Just(v);
	}
	
	static public Maybe nothing() {
		return Nothing.nothing;
	}
}

class Just implements Maybe {
	private Object value;
	
	public Just(Object value) {
		super();
		this.value = value;
	}

	@Override
	public  Object getValue(Class<?> clazz) {
		if(clazz==Maybe.class)
			return this;
		else 
			return value;
	}
	
}

class Nothing implements Maybe {
	@Override
	public Object getValue(Class<?> clazz) {
		return null;
	}
	
	static public final Nothing nothing = new Nothing();
}