package edu.ustb.sei.mde.emg.graph.command;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.graph.ModelSpace;

public class AddElementCommand extends ModelCommand {
	public AddElementCommand(ModelSpace space, EObject object) {
		super();
		this.space = space;
		this.object = object;
	}

	protected EObject object;

	@Override
	public boolean undo() {
		
		space.addElement(object);
		return false;
	}

	@Override
	public boolean redo() {
		
		space.deleteElement(object);
		return false;
	}

}
