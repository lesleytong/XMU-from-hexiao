/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2Problem implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Problem {
	
	private String message;
	private edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType type;
	private edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity severity;
	private java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix> quickFixes;
	
	public Xmu2Problem(String message, edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType type, edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix>emptySet());
	}
	
	public Xmu2Problem(String message, edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType type, edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity severity, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public Xmu2Problem(String message, edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType type, edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity severity, java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType getType() {
		return type;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
