package edu.ustb.sei.mde.xmu2.runtime.structures;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.OverrideableCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class TransformationEditingDomain implements EditingDomain {

	public TransformationEditingDomain(Environment env) {
		environment = env;
		commandStack = new TransformationCommandStack();
	}

	private Environment environment;
	private CommandStack commandStack;

	@Override
	public Resource createResource(String fileNameURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Resource loadResource(String fileNameURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ResourceSet getResourceSet() {
		return environment.getResourceSet();
	}

	@Override
	public Command createCommand(Class<? extends Command> commandClass, CommandParameter commandParameter) {
		Object owner = commandParameter.getOwner();

		if (commandClass == DeleteCommand.class) {
			return new DeleteCommand(this, commandParameter.getCollection());
		} else if (owner != null) {
			// IEditingDomainItemProvider editingDomainItemProvider =
			// (IEditingDomainItemProvider) adapterFactory
			// .adapt(owner, IEditingDomainItemProvider.class);

			return createCommand(owner, this, commandClass, commandParameter);
		} else {
			// If command has no owner specified
			//
			if (commandClass == RemoveCommand.class) {
				// For RemoveCommand, we will find the owner by calling
				// EditingDomain.getParent() on the object(s) being removed.
				//
				CompoundCommand removeCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);

				List<Object> objects = new ArrayList<Object>(commandParameter.getCollection());
				while (!objects.isEmpty()) {
					// We will iterate over the whole collection, removing some
					// as we go.
					//
					ListIterator<Object> remainingObjects = objects.listIterator();

					// Take the first object, and remove it.
					//
					Object object = remainingObjects.next();
					remainingObjects.remove();

					// Determine the object's parent.
					//
					Object parent = getParent(object);

					if (parent != null) {
						// Now we want to find all the other objects with this
						// same parent.
						// So we can collection siblings together and give the
						// parent control over their removal.
						//
						List<Object> siblings = new ArrayList<Object>();
						siblings.add(object);

						while (remainingObjects.hasNext()) {
							// Get the next object and check if it has the same
							// parent.
							//
							Object otherObject = remainingObjects.next();
							Object otherParent = getParent(otherObject);
							if (otherParent == parent) {
								// Remove the object and add it as a sibling.
								//
								remainingObjects.remove();
								siblings.add(otherObject);
							}
						}

						// We will now create a command with this implied parent
						//
						removeCommand.append(
								createCommand(RemoveCommand.class, new CommandParameter(parent, null, siblings)));
					} else if (object != null) {
						// The parent is null, which implies a top-level
						// removal, so create a self-removing command.
						//
						removeCommand.append(createCommand(RemoveCommand.class,
								new CommandParameter(object, null, Collections.singleton(object))));
					}
				}

				return removeCommand.unwrap();
			} else if (commandClass == ReplaceCommand.class) {
				Object obj = commandParameter.getValue();
				Object parent = (obj == null) ? null : getParent(obj);
				if (parent == null)
					parent = obj;
				return createCommand(ReplaceCommand.class,
						new CommandParameter(parent, null, obj, commandParameter.getCollection()));
			} else if (commandClass == CreateChildCommand.class) {
				// For CreateChildCommand, we will find the owner by calling
				// EditingDomain.getParent() on the first selected object
				Collection<?> sel = commandParameter.getCollection();
				Object parent = sel == null ? null : getParent(sel.iterator().next());
				if (parent == null) {
					return UnexecutableCommand.INSTANCE;
				}
				return createCommand(CreateChildCommand.class,
						new CommandParameter(parent, commandParameter.getFeature(), commandParameter.getValue(),
								commandParameter.getCollection(), commandParameter.getIndex()));
			}
		}

		try {
			Constructor<? extends Command> constructor = commandClass.getConstructor(EditingDomain.class,
					CommandParameter.class);
			Command command = constructor.newInstance(new Object[] { this, commandParameter });
			return command;
		} catch (IllegalAccessException exception) {
			// Ignore.
		} catch (InstantiationException exception) {
			// Ignore.
		} catch (NoSuchMethodException exception) {
			// Ignore.
		} catch (InvocationTargetException exception) {
			// Ignore.
		}

		return UnexecutableCommand.INSTANCE;
	}

	private Command createCommand(Object owner, TransformationEditingDomain transformationEditingthis,
			Class<? extends Command> commandClass, CommandParameter commandParameter) {
		Command result = UnexecutableCommand.INSTANCE;

		if (commandClass == SetCommand.class) {
			result = createSetCommand(this, commandParameter.getEOwner(), commandParameter.getEStructuralFeature(),
					commandParameter.getValue(), commandParameter.getIndex());
		} else if (commandClass == RemoveCommand.class) {
			if (commandParameter.getEStructuralFeature() != null) {
				result = createRemoveCommand(this, commandParameter.getEOwner(),
						commandParameter.getEStructuralFeature(), commandParameter.getCollection());
			} else {
				result = factorRemoveCommand(this, commandParameter);
			}
		} else if (commandClass == AddCommand.class) {
			if (commandParameter.getEStructuralFeature() != null) {
				result = createAddCommand(this, commandParameter.getEOwner(), commandParameter.getEStructuralFeature(),
						commandParameter.getCollection(), commandParameter.getIndex());
			} else {
				result = factorAddCommand(this, commandParameter);
			}
		} else if (commandClass == MoveCommand.class) {
			if (commandParameter.getEStructuralFeature() != null) {
				result = createMoveCommand(this, commandParameter.getEOwner(), commandParameter.getEStructuralFeature(),
						commandParameter.getValue(), commandParameter.getIndex());
			} else {
				result = factorMoveCommand(this, commandParameter);
			}
		} else if (commandClass == ReplaceCommand.class) {
			result = createReplaceCommand(this, commandParameter.getEOwner(), commandParameter.getEStructuralFeature(),
					commandParameter.getValue(), commandParameter.getCollection());
		}

		return result;
	}

	protected Command createSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value,
			int index) {
		if (index == CommandParameter.NO_INDEX) {
			return createSetCommand(domain, owner, feature, value);
		}
		return new SetCommand(domain, owner, feature, value, index);
	}

	private Command createSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {
		return new SetCommand(domain, owner, feature, value);
	}

	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {
		if (feature instanceof EReference) {
			return createRemoveCommand(domain, owner, (EReference) feature, collection);
		}
		return new RemoveCommand(domain, owner, feature, collection);
	}

	private Command createRemoveCommand(EditingDomain domain, EObject owner, EReference feature,
			Collection<?> collection) {
		return new RemoveCommand(domain, owner, feature, collection);
	}

	protected Command factorRemoveCommand(EditingDomain domain, CommandParameter commandParameter) {
		if (commandParameter.getCollection() == null || commandParameter.getCollection().isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		final EObject eObject = commandParameter.getEOwner();
		final List<Object> list = new ArrayList<Object>(commandParameter.getCollection());

		CompoundCommand removeCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);

		// Iterator over all the child references to factor each child to the
		// right reference.

		for (EStructuralFeature feature : eObject.eClass().getEAllContainments()) {
			// If it is a list type value...
			//
			if (feature.isMany()) {
				List<?> value = (List<?>) eObject.eGet(feature);

				// These will be the children belonging to this feature.
				//
				Collection<Object> childrenOfThisFeature = new ArrayList<Object>();
				for (ListIterator<Object> objects = list.listIterator(); objects.hasNext();) {
					Object o = objects.next();

					// Is this object in this feature...
					//
					if (value.contains(o)) {
						// Add it to the list and remove it from the other list.
						//
						childrenOfThisFeature.add(o);
						objects.remove();
					}
				}

				// If we have children to remove for this feature, create a
				// command for it.
				//
				if (!childrenOfThisFeature.isEmpty()) {
					removeCommand.append(createRemoveCommand(domain, eObject, feature, childrenOfThisFeature));
				}
			} else {
				// It's just a single value
				//
				final Object value = eObject.eGet(feature);
				for (ListIterator<Object> objects = list.listIterator(); objects.hasNext();) {
					Object o = objects.next();

					// Is this object in this feature...
					//
					if (o == value) {
						// Create a command to unset this and remove the object
						// from the other list.
						//
						Command setCommand = createSetCommand(domain, eObject, feature, SetCommand.UNSET_VALUE);
						removeCommand.append(new CommandWrapper(setCommand) {
							protected Collection<?> affected;

							@Override
							public void execute() {
								super.execute();
								affected = Collections.singleton(eObject);
							}

							@Override
							public void undo() {
								super.undo();
								affected = Collections.singleton(value);
							}

							@Override
							public void redo() {
								super.redo();
								affected = Collections.singleton(eObject);
							}

							@Override
							public Collection<?> getResult() {
								return Collections.singleton(value);
							}

							@Override
							public Collection<?> getAffectedObjects() {
								return affected;
							}
						});
						objects.remove();
						break;
					}
				}
			}
		}

		// If all the objects are used up by the above, then we can't do the
		// command.
		//
		if (list.isEmpty()) {
			return removeCommand.unwrap();
		} else {
			removeCommand.dispose();
			return UnexecutableCommand.INSTANCE;
		}
	}

	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {
		if (feature instanceof EReference) {
			return createAddCommand(domain, owner, (EReference) feature, collection, index);
		}
		return new AddCommand(domain, owner, feature, collection, index);
	}

	private Command createAddCommand(EditingDomain domain, EObject owner, EReference feature, Collection<?> collection,
			int index) {
		return new AddCommand(domain, owner, feature, collection, index);
	}

	protected Command factorAddCommand(EditingDomain domain, CommandParameter commandParameter) {
		if (commandParameter.getCollection() == null || commandParameter.getCollection().isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		final EObject eObject = commandParameter.getEOwner();
		final List<Object> list = new ArrayList<Object>(commandParameter.getCollection());
		int index = commandParameter.getIndex();

		CompoundCommand addCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);

		while (!list.isEmpty()) {
			Iterator<Object> children = list.listIterator();
			final Object firstChild = children.next();
			EStructuralFeature childFeature = getChildFeature(eObject, firstChild);

			if (childFeature == null) {
				break;
			}
			// If it is a list type value...
			//
			else if (childFeature.isMany()) {
				// Correct the index, if necessary.
				//
				if (index != CommandParameter.NO_INDEX) {
					for (EStructuralFeature feature : eObject.eClass().getEAllContainments()) {
						if (feature == childFeature) {
							break;
						}

						if (feature.isMany()) {
							index -= ((List<?>) eObject.eGet(feature)).size();
						} else if (eObject.eGet(feature) != null) {
							index -= 1;
						}
					}
					if (index < 0) {
						break;
					}
				}

				// These will be the children belonging to this feature.
				//
				Collection<Object> childrenOfThisFeature = new ArrayList<Object>();
				childrenOfThisFeature.add(firstChild);
				children.remove();

				// Consume the rest of the appropriate children.
				//
				while (children.hasNext()) {
					Object child = children.next();

					// Is this child in this feature...
					//
					if (getChildFeature(eObject, child) == childFeature) {
						// Add it to the list and remove it from the other list.
						//
						childrenOfThisFeature.add(child);
						children.remove();
					}
				}

				// Create a command for this feature,
				//
				addCommand.append(createAddCommand(domain, eObject, childFeature, childrenOfThisFeature, index));

				if (index >= childrenOfThisFeature.size()) {
					index -= childrenOfThisFeature.size();
				} else {
					index = CommandParameter.NO_INDEX;
				}
			} else if (eObject.eGet(childFeature) == null) {
				Command setCommand = createSetCommand(domain, eObject, childFeature, firstChild);
				addCommand.append(new CommandWrapper(setCommand) {
					protected Collection<?> affected;

					@Override
					public void execute() {
						super.execute();
						affected = Collections.singleton(firstChild);
					}

					@Override
					public void undo() {
						super.undo();
						affected = Collections.singleton(eObject);
					}

					@Override
					public void redo() {
						super.redo();
						affected = Collections.singleton(firstChild);
					}

					@Override
					public Collection<?> getResult() {
						return Collections.singleton(firstChild);
					}

					@Override
					public Collection<?> getAffectedObjects() {
						return affected;
					}
				});
				children.remove();
			} else {
				break;
			}
		}

		// If all the objects aren't used up by the above, then we can't do the
		// command.
		//
		if (list.isEmpty()) {
			return addCommand.unwrap();
		} else {
			addCommand.dispose();
			return UnexecutableCommand.INSTANCE;
		}
	}

	protected EStructuralFeature getChildFeature(Object object, Object child) {
		for (EStructuralFeature feature : ((EObject) object).eClass().getEAllContainments()) {
			if (isValidValue(object, child, feature)) {
				return feature;
			}
		}
		return null;
	}

	protected Command createMoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value,
			int index) {
		if (feature instanceof EReference && value instanceof EObject) {
			return createMoveCommand(domain, owner, (EReference) feature, (EObject) value, index);
		}
		return new MoveCommand(domain, owner, feature, value, index);
	}

	private Command createMoveCommand(EditingDomain domain, EObject owner, EReference feature, EObject value,
			int index) {
		return new MoveCommand(domain, owner, feature, value, index);
	}

	protected Command factorMoveCommand(EditingDomain domain, CommandParameter commandParameter) {
		final EObject eObject = commandParameter.getEOwner();
		final Object value = commandParameter.getValue();
		int index = commandParameter.getIndex();

		EStructuralFeature childFeature = getChildFeature(eObject, value);

		if (childFeature != null && childFeature.isMany()) {
			// Compute the relative index as best as possible.
			//
			for (EStructuralFeature feature : eObject.eClass().getEAllContainments()) {
				if (feature == childFeature) {
					break;
				}

				if (feature.isMany()) {
					index -= ((List<?>) eObject.eGet(feature)).size();
				} else if (eObject.eGet(feature) != null) {
					index -= 1;
				}
			}

			// Create a command for this feature,
			//
			return createMoveCommand(domain, eObject, childFeature, value, index);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * This creates a primitive
	 * {@link org.eclipse.emf.edit.command.ReplaceCommand}.
	 * 
	 * @since 2.10
	 */
	protected Command createReplaceCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, Collection<?> collection) {
		if (value instanceof EObject) {
			return createReplaceCommand(domain, owner, feature, (EObject) value, collection);
		}
		return new ReplaceCommand(domain, owner, feature, value, collection);
	}

	private Command createReplaceCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, EObject value,
			Collection<?> collection) {
		if (feature instanceof EReference) {
			return createReplaceCommand(domain, owner, (EReference) feature, value, collection);
		}
		return new ReplaceCommand(domain, owner, feature, value, collection);
	}

	private Command createReplaceCommand(EditingDomain domain, EObject owner, EReference feature, EObject value,
			Collection<?> collection) {
		return new ReplaceCommand(domain, owner, feature, value, collection);
	}

	protected boolean isValidValue(Object object, Object value, EStructuralFeature feature) {
		if (feature.getEType().isInstance(value)) {
			if (FeatureMapUtil.isFeatureMap(feature)) {
				return FeatureMapUtil.getValidator(
						object instanceof EObject ? ((EObject) object).eClass() : feature.getEContainingClass(),
						feature).isValid(((FeatureMap.Entry) value).getEStructuralFeature());
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public Command createOverrideCommand(OverrideableCommand command) {
		return null;
	}

	@Override
	public CommandStack getCommandStack() {
		return commandStack;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		if (object instanceof EObject)
			return ((EObject) object).eContents();
		else
			return Collections.emptyList();
	}

	@Override
	public Object getParent(Object object) {
		if (object instanceof EObject)
			return ((EObject) object).eContainer();
		else
			return null;
	}

	@Override
	public Object getRoot(Object object) {
		Object result = object;
		for (Object parent = getParent(object); parent != null; parent = getParent(parent)) {
			result = parent;
		}
		return result;
	}

	@Override
	public Collection<?> getNewChildDescriptors(Object object, Object sibling) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public TreeIterator<?> treeIterator(Object object) {
		if (object instanceof EObject)
			return ((EObject) object).eAllContents();
		else
			return null;
	}

	@Override
	public List<?> getTreePath(Object object) {
		LinkedList<Object> result = new LinkedList<Object>();
		result.addFirst(object);
		while ((object = getParent(object)) != null) {
			result.addFirst(object);
		}

		return result;
	}

	@Override
	public Collection<Object> getClipboard() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setClipboard(Collection<Object> clipboard) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean getOptimizeCopy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReadOnly(Resource resource) {
		if(resource==null)
			return false;
		
		if (environment.getTransformation().eResource() == resource)
			return true;

		if (environment.isForward()) {
			return !environment.getViews().contains(resource);
		} else {
			return !environment.getUpdatedSources().contains(resource);
		}
	}

	@Override
	public boolean isControllable(Object object) {
		if (!(object instanceof EObject))
			return false;
		EObject eObject = (EObject) object;
		EObject container = eObject.eContainer();
		return container != null && eObject.eContainmentFeature().isResolveProxies() && !isReadOnly(eObject.eResource())
				&& !isReadOnly(container.eResource());
	}

}
