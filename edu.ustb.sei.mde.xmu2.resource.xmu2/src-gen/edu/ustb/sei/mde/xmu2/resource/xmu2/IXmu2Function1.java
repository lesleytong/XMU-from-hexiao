/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

/**
 * A simple interface for generic functions with one argument.
 */
public interface IXmu2Function1<ReturnType, ArgumentType1> {
	
	public ReturnType execute(ArgumentType1 argument1);
}
