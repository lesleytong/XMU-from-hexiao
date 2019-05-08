package edu.ustb.sei.chocoex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.chocosolver.memory.IStorage;
import org.chocosolver.memory.trailing.EnvironmentTrailing;

public abstract class AbstractEnvironmentEx extends EnvironmentTrailing {
	
	public abstract <T> AbstractStoredElementTrail<T> getTrail(Class<?> clazz);
	public abstract void setTrail(Class<?> clazz, AbstractStoredElementTrail<?> trail);
	
	protected void appendTrail(AbstractStoredElementTrail<?> trail) {
		try {
			Method increaseTrailOp = EnvironmentTrailing.class.getDeclaredMethod("increaseTrail");
			increaseTrailOp.setAccessible(true);
			increaseTrailOp.invoke(this);
			increaseTrailOp.setAccessible(false);
			
			Field trailsField = EnvironmentTrailing.class.getDeclaredField("trails");
			trailsField.setAccessible(true);
			IStorage[] trails = (IStorage[]) trailsField.get(this);
			trailsField.setAccessible(false);
			
			Field trailSizeField = EnvironmentTrailing.class.getDeclaredField("trailSize");
			trailSizeField.setAccessible(true);
			Integer trailSize = (Integer) trailSizeField.get(this);
			trails[trailSize++] = trail;
			trailSizeField.set(this, trailSize);
			trailSizeField.setAccessible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
