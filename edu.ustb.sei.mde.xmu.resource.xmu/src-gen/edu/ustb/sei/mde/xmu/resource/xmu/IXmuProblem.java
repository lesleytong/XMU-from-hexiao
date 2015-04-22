/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu;

public interface IXmuProblem {
	public String getMessage();
	public edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemSeverity getSeverity();
	public edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType getType();
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix> getQuickFixes();
}
