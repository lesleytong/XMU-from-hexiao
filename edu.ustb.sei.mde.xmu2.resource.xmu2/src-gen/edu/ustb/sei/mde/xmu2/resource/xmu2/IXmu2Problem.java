/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

public interface IXmu2Problem {
	public String getMessage();
	public edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity getSeverity();
	public edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType getType();
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix> getQuickFixes();
}
