/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelProblem implements edu.ustb.sei.mde.morel.resource.morel.IMorelProblem {
	
	private String message;
	private edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType type;
	private edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity severity;
	private java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelQuickFix> quickFixes;
	
	public MorelProblem(String message, edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType type, edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<edu.ustb.sei.mde.morel.resource.morel.IMorelQuickFix>emptySet());
	}
	
	public MorelProblem(String message, edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType type, edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity severity, edu.ustb.sei.mde.morel.resource.morel.IMorelQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public MorelProblem(String message, edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType type, edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity severity, java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<edu.ustb.sei.mde.morel.resource.morel.IMorelQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType getType() {
		return type;
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
