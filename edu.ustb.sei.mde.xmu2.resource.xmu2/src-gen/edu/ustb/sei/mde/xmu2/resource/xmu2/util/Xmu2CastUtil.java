/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.util;

/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class Xmu2CastUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
