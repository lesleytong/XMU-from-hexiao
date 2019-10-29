package edu.ustb.sei.mde.emg.graph.command;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.mde.emg.graph.ModelSpace;

public class AddRelationshipsCommand extends ModelCommand {
	
	private EObject source;
	@SuppressWarnings("rawtypes")
	private Collection relationships;
	private EReference reference;

	
	@SuppressWarnings("rawtypes")
	public AddRelationshipsCommand(ModelSpace space, EObject source, Collection relationships,
			EReference reference) {
		super();
		this.space = space;
		this.source = source;
		this.relationships = relationships;
		this.reference = reference;
	}

	@Override
	public boolean undo() {
		((Collection<?>)source.eGet(reference)).removeAll(relationships);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean redo() {
		((Collection<?>)source.eGet(reference)).addAll(relationships);
		return true;
	}

}
