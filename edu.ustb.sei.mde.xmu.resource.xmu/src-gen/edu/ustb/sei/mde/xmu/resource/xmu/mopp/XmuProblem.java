/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuProblem implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuProblem {
	
	private String message;
	private edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType type;
	private edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemSeverity severity;
	private java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix> quickFixes;
	
	public XmuProblem(String message, edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType type, edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix>emptySet());
	}
	
	public XmuProblem(String message, edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType type, edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemSeverity severity, edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public XmuProblem(String message, edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType type, edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemSeverity severity, java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType getType() {
		return type;
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
