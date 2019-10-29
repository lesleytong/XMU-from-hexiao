package edu.ustb.sei.mde.emg.graph.command;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.graph.ModelSpace;

public class DeleteValueCommand extends ModelCommand {
	private EObject object;
	private Object value;
	private EAttribute feature;
	private int index;
	

	

	public DeleteValueCommand(ModelSpace space, EObject object, Object value, EAttribute feature,
			int index) {
		super();
		this.space = space;
		this.object = object;
		this.value = value;
		this.feature = feature;
		this.index = index;
	}

	@Override
	public boolean redo() {
		if(feature.isMany()) {
			((List)object.eGet(feature)).remove(value);
		} else {
			object.eUnset(feature);
		}
		return true;
	}

	@Override
	public boolean undo() {
		if(feature.isMany()) {
			if(index==-1) {
				((List)object.eGet(feature)).add(value);
			} else {
				((List)object.eGet(feature)).add(index, value);
			}
		} else {
			object.eSet(feature, value);
		}
		return true;
	}

}
