/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.debug;

public class Xmu2DebugVariable extends edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugElement implements org.eclipse.debug.core.model.IVariable {
	
	private String name;
	private org.eclipse.debug.core.model.IValue value;
	private String referenceTypeName;
	
	public Xmu2DebugVariable(org.eclipse.debug.core.model.IDebugTarget debugTarget, String name, org.eclipse.debug.core.model.IValue value, String referenceTypeName) {
		super(debugTarget);
		this.name = name;
		this.value = value;
		this.referenceTypeName = referenceTypeName;
	}
	
	public boolean supportsValueModification() {
		return false;
	}
	
	public void setValue(org.eclipse.debug.core.model.IValue value) throws org.eclipse.debug.core.DebugException {
		throw new org.eclipse.debug.core.DebugException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Plugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public void setValue(String expression) throws org.eclipse.debug.core.DebugException {
		throw new org.eclipse.debug.core.DebugException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Plugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public boolean verifyValue(org.eclipse.debug.core.model.IValue value) throws org.eclipse.debug.core.DebugException {
		throw new org.eclipse.debug.core.DebugException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Plugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public boolean verifyValue(String expression) throws org.eclipse.debug.core.DebugException {
		throw new org.eclipse.debug.core.DebugException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Plugin.PLUGIN_ID, "Can't set variable."));
	}
	
	public org.eclipse.debug.core.model.IValue getValue() throws org.eclipse.debug.core.DebugException {
		return value;
	}
	
	public String getName() throws org.eclipse.debug.core.DebugException {
		return name;
	}
	
	public String getReferenceTypeName() throws org.eclipse.debug.core.DebugException {
		return referenceTypeName;
	}
	
	public boolean hasValueChanged() throws org.eclipse.debug.core.DebugException {
		return true;
	}
	
}
