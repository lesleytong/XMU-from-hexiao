package edu.ustb.sei.mde.emg.graph.command;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.graph.ModelSpace;

public class AddValuesCommand extends ModelCommand {
	private EObject object;
	private Collection values;
	private EAttribute feature;	

	public AddValuesCommand(ModelSpace space, EObject object, Collection values, EAttribute feature) {
		super();
		this.space = space;
		this.object = object;
		this.values = values;
		this.feature = feature;
	}

	@Override
	public boolean undo() {
		((List)object.eGet(feature)).removeAll(values);
		return true;
	}

	@Override
	public boolean redo() {
		((List)object.eGet(feature)).addAll(values);
		return true;
	}

}
