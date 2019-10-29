/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel;

public interface IMorelProblem {
	public String getMessage();
	public edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity getSeverity();
	public edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType getType();
	public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelQuickFix> getQuickFixes();
}
