package edu.ustb.sei.mde.emg.graph.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.mde.emg.graph.ModelSpace;

public class DeleteRelationshipCommand extends ModelCommand {
	
	private EObject source;
	private EObject target;
	private EReference reference;
	private int index;

	
	public DeleteRelationshipCommand(ModelSpace space, EObject source, EObject target,
			EReference reference, int index) {
		super();
		this.space = space;
		this.source = source;
		this.target = target;
		this.reference = reference;
		this.index = index;
	}

	@Override
	public boolean redo() {
		space.deleteRelationship(source, target, reference);
		return true;
	}

	@Override
	public boolean undo() {
		if(index==-1){
			space.addRelationship(source, target, reference);
		} else {
			space.addRelationship(source, target, reference, index);
		}
		return true;
	}

}
