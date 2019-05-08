package edu.ustb.sei.mde.graph.type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListType implements ICollectionType {
	
	private IElementType elementType;

	@Override
	public IType getElementType() {
		return elementType;
	}
	
	public void setElementType(IElementType t) {
		elementType = t;
	}

	private String cachedName = null;
	@Override
	public String getName() {
		if(cachedName==null)
			cachedName = "["+elementType.getName()+"]";
		return cachedName;
	}
	
	@Override
	public Class<?> getJavaType() {
		return ArrayList.class; // ??
	}
	
	@Override
	public boolean isInstance(Object value) {
		if(value instanceof List) {
			return ((List<?>) value).stream().allMatch(v->this.getElementType().isInstance(v));
		} else if(value instanceof Stream<?>) {
			return ((Stream<?>) value).allMatch(v->this.getElementType().isInstance(v));
		}
		return false;
	}

}
