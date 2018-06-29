package edu.ustb.sei.mde.graph.type;

import edu.ustb.sei.mde.graph.Nullable;

public class DataTypeNode implements ITypeNode {
	@Nullable(false) private Class<?> dataType;
	@Nullable(false) private String name;
	

	@Override
	public String getName() {
		return name;
	}

	public Class<?> getDataType() {
		return dataType;
	}

	void setDataType(String name, Class<?> dataType) {
		this.name = name;
		this.dataType = normalizeDateType(dataType);
	}
	
	static public Class<?> normalizeDateType(Class<?> clazz) {
		if(clazz==int.class 
				|| clazz==short.class
				|| clazz==byte.class
				|| clazz==long.class)
			return java.lang.Long.class;
		else if(clazz==float.class
				|| clazz==double.class)
			return java.lang.Double.class;
		else if(clazz==char.class)
			return Character.class;
		else if(clazz==boolean.class)
			return Boolean.class;
		return clazz;
	}
	
	public String toString() {
		return "("+"name:"+name+", javaType:"+dataType.getTypeName()+")";
	}
	
	
	static public final DataTypeNode NULL_TYPE;
	
	static {
		NULL_TYPE = new DataTypeNode();
		NULL_TYPE.setDataType("BOTTOM", null);
	}
	
}
