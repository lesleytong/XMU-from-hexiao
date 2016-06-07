package edu.ustb.sei.mde.xmu2.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import edu.ustb.sei.commonutil.util.Pair;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidModificationException;
import edu.ustb.sei.mde.xmu2.runtime.structures.TransformationCommandStack;

public class CommandBasedModelModificationEngine extends ModelModificationEngine {
	
	protected EditingDomain domain;
	public CommandBasedModelModificationEngine(EditingDomain domain) {
		super();
		this.domain = domain;
	}
	
	public void undoAll() {
		TransformationCommandStack commandStack = (TransformationCommandStack) domain.getCommandStack();
		if(!commandStack.undoAll()) {
			throw new InvalidModificationException("cannot undo all");
		}
	}
	
	public void redoAll() {
		TransformationCommandStack commandStack = (TransformationCommandStack) domain.getCommandStack();
		if(!commandStack.redoAll()) {
			throw new InvalidModificationException("cannot redo all");
		}
	}

	@Override
	protected void interalReplaceObject(EObject host, EStructuralFeature feature, EObject oldObj, EObject newObj) {
		Command cmd;
		
		if(host==null || feature==null) {
			host = oldObj.eContainer();
			if(host!=null)
				feature = oldObj.eContainmentFeature();
		}
		
		if (host != null && feature != null) {
			if(feature.isMany()) {
				if(feature instanceof EReference) {
					Pair<EObject,EReference> brokenLink = this.computeBrokenLink((EReference)feature, newObj);
					if(brokenLink==null) {
						cmd = ReplaceCommand.create(domain, host, feature, oldObj, Collections.singletonList(newObj));
					} else {
						Command del = RemoveCommand.create(domain, brokenLink.getFirst(), brokenLink.getSecond(), newObj);
						Command rep = ReplaceCommand.create(domain, host, feature, oldObj, Collections.singletonList(newObj));
						cmd = new CompoundCommand(Arrays.asList(del,rep));
					}
				} else {
					cmd = ReplaceCommand.create(domain, host, feature, oldObj, Collections.singletonList(newObj));
				}
			} else {
				if(feature instanceof EReference) {
					Pair<EObject,EReference> brokenLink = this.computeBrokenLink((EReference)feature, newObj);
					if(brokenLink==null) {
						cmd = SetCommand.create(domain, host, feature, newObj);
					} else {
						Command del = RemoveCommand.create(domain, brokenLink.getFirst(), brokenLink.getSecond(), newObj);
						Command set = SetCommand.create(domain, host, feature, newObj);
						cmd = new CompoundCommand(Arrays.asList(del,set));
					}
				} else {
					cmd = SetCommand.create(domain, host, feature, newObj);
				}
				
			}
		} else {
			Resource resource = ((InternalEObject) oldObj).eDirectResource();
			if (resource != null) {
				EList<EObject> list = resource.getContents();
				cmd = new ReplaceCommand(domain, list, oldObj, Collections.singletonList(newObj));
			} else {
				cmd = null;
			}
		}
		postCommand(cmd);
	}
	
	private Pair<EObject, EReference> computeBrokenLink(EReference newRef, EObject newTarget) {
		if(newRef.isContainment()) {
			if(newTarget.eContainer()!=null)
				return new Pair<EObject,EReference>(newTarget.eContainer(), newTarget.eContainmentFeature());
			else 
				return null;
		}
		
		EReference eOpposite = newRef.getEOpposite();
		if(eOpposite!=null) {
			Object oppositeObj = newTarget.eGet(eOpposite);
			if(!eOpposite.isMany() && oppositeObj!=null) {
				return new Pair<EObject,EReference>((EObject)oppositeObj,newRef);
			}
		}
		
		return null;
	}

	protected void postCommand(Command cmd) {
		if(cmd.canExecute())
			domain.getCommandStack().execute(cmd);
		else
			throw new InvalidModificationException("the command cannot be executed "+cmd);
	}

	@Override
	protected void internalAddFeature(EObject host, EStructuralFeature feature, Object value) {
		Command cmd;
		if(feature instanceof EReference) {
			Pair<EObject,EReference> brokenLink = this.computeBrokenLink((EReference)feature, (EObject)value);
			if(brokenLink==null) {
				cmd = AddCommand.create(domain, host, feature, value);
			} else {
				Command del = RemoveCommand.create(domain, brokenLink.getFirst(), brokenLink.getSecond(), (EObject)value);
				Command add = AddCommand.create(domain, host, feature, value);
				cmd = new CompoundCommand(Arrays.asList(del,add));
			}
		} else {
			cmd = AddCommand.create(domain, host, feature, value);
		}
		
		postCommand(cmd);
	}

	@Override
	protected void internalInsertAtFeature(EObject host, EStructuralFeature feature, Object value, int index) {
		Command cmd;
		
		if(feature instanceof EReference) {
			Pair<EObject,EReference> brokenLink = this.computeBrokenLink((EReference)feature, (EObject)value);
			if(brokenLink==null) {
				cmd = AddCommand.create(domain, host, feature, value, index);
			} else {
				Command del = RemoveCommand.create(domain, brokenLink.getFirst(), brokenLink.getSecond(), (EObject)value);
				Command set = AddCommand.create(domain, host, feature, value, index);
				cmd = new CompoundCommand(Arrays.asList(del,set));
			}
		} else {
			cmd = AddCommand.create(domain, host, feature, value, index);
		}
		
		postCommand(cmd);
	}

	@Override
	protected void internalMoveFeature(EObject oldObj, EObject newObj, EStructuralFeature feature) {
		Command cmd;
		if(feature.isMany()) {
			List<?> values = (List<?>) oldObj.eGet(feature);
			Command del = RemoveCommand.create(domain, oldObj, feature, values);
			Command add = AddCommand.create(domain, newObj, feature, values);
			cmd = new CompoundCommand(Arrays.asList(del,add));
		} else {
			Object value = oldObj.eGet(feature);
			Command del = RemoveCommand.create(domain, oldObj, feature, value);
			Command set = SetCommand.create(domain, newObj, feature, value);
			cmd = new CompoundCommand(Arrays.asList(del,set));
		}
		
		postCommand(cmd);
	}

	@Override
	protected void internalRemoveAttributeValue(EObject host, EAttribute attribute, Object value) {
		if(attribute.isMany()) {
			Command del = RemoveCommand.create(domain, host, attribute, value);
			postCommand(del);
		} else {
			Command del = SetCommand.create(domain, host, attribute, null);
			postCommand(del);
		}
	}

	@Override
	protected void internalRemoveObject(EObject host, EReference feature, EObject oldObj) {
		if(feature.isMany()) {
			Command del = RemoveCommand.create(domain, host, feature, oldObj);
			postCommand(del);
		} else {
			Command del = SetCommand.create(domain, host, feature, null);
			postCommand(del);
		}
	}

	@Override
	protected void internalReplaceAtFeature(EObject host, EStructuralFeature feature, Object value, int index) {
		Command cmd;
		if(feature.isMany()) {
			if(feature instanceof EReference) {
				Pair<EObject,EReference> brokenLink = this.computeBrokenLink((EReference)feature, (EObject)value);
				if(brokenLink==null) {
					cmd = SetCommand.create(domain, host, feature, value);
				} else {
					Command del = RemoveCommand.create(domain, brokenLink.getFirst(), brokenLink.getSecond(), value);
					Command set = SetCommand.create(domain, host, feature, value, index);
					cmd = new CompoundCommand(Arrays.asList(del,set));
				}
			} else {
				cmd = SetCommand.create(domain, host, feature, value, index);
			}
		} else {
			if(feature instanceof EReference) {
				Pair<EObject,EReference> brokenLink = this.computeBrokenLink((EReference)feature, (EObject)value);
				if(brokenLink==null) {
					cmd = SetCommand.create(domain, host, feature, value);
				} else {
					Command del = RemoveCommand.create(domain, brokenLink.getFirst(), brokenLink.getSecond(), value);
					Command set = SetCommand.create(domain, host, feature, value);
					cmd = new CompoundCommand(Arrays.asList(del,set));
				}
			} else {
				cmd = SetCommand.create(domain, host, feature, value);
			}
		}
		postCommand(cmd);
	}

	@Override
	protected void internalSetFeature(EObject host, EStructuralFeature feature, Object value) {
		Command cmd;
		if(feature instanceof EReference) {
			Pair<EObject,EReference> brokenLink = this.computeBrokenLink((EReference)feature, (EObject)value);
			if(brokenLink==null) {
				cmd = SetCommand.create(domain, host, feature, value);
			} else {
				Command del = RemoveCommand.create(domain, brokenLink.getFirst(), brokenLink.getSecond(), value);
				Command set = SetCommand.create(domain, host, feature, value);
				cmd = new CompoundCommand(Arrays.asList(del,set));
			}
		} else {
			cmd = SetCommand.create(domain, host, feature, value);
		}
		
		postCommand(cmd);
	}

	@Override
	public void deleteObjectFromModel(EObject eo, ResourceSet resourceSet) {
		Command cmd;
		
		cmd = DeleteCommand.create(domain, eo);
		
		postCommand(cmd);
	}
	
	

}
