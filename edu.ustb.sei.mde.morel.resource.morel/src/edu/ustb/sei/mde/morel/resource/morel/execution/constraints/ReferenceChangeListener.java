package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.emg.graph.ModelUniverse;

public class ReferenceChangeListener implements Adapter {
	
	private ModelUniverse modelUniverse;
	
	
	public ReferenceChangeListener(ModelUniverse modelUniverse) {
		super();
		this.modelUniverse = modelUniverse;
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		EObject source = (EObject) notification.getNotifier();
		EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
		if(feature instanceof EReference) {
			int eventType = notification.getEventType();
			if(eventType==Notification.REMOVING_ADAPTER || eventType==Notification.RESOLVE)
				return;
			modelUniverse.getObjectReachableList().remove(source);
			visited.clear();
			clearPrefix(source);
		}
	}
	
	private HashSet<EObject> visited = new HashSet<EObject>();
	private void clearPrefix(EObject o) {
		if(visited.contains(o)) return;
		visited.add(o);
		
		Collection<EObject> col = modelUniverse.getPrefixObjects().get(o);
		for(EObject no : col) {
			modelUniverse.getObjectReachableList().remove(no);
			clearPrefix(no);
		}
	}
	
	@Override
	public Notifier getTarget() {
		return null;
	}
	
	@Override
	public void setTarget(Notifier newTarget) {
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		if(type instanceof EObject)
			return true;
		else return false;
	}
	
}