package edu.ustb.sei.mde.emg.graph;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ObjectAdapter implements Adapter {
	private ModelSpace space = null;
	
	public ObjectAdapter(ModelSpace space) {
		super();
		this.space = space;
	}

	@Override
	public void notifyChanged(Notification notification) {
		EObject source = (EObject) notification.getNotifier();
		EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
		
		if(feature instanceof EReference) {
			int eventType = notification.getEventType();
			if(eventType==Notification.REMOVING_ADAPTER || eventType==Notification.RESOLVE)
				return;
			System.out.println("remove relationship "+feature.getName()+" for "+eventType);
			space.resetElementRelationshipMap(source,(EReference)feature);
		}
		
		if(notification.isTouch()) return;
		
		space.pushNotification(notification);
		
//		Object lv = notification.getOldValue();
//		Object rv = notification.getNewValue();
//		
//		if(lv==rv) return;
//		else if(lv==null && rv!=null) space.onChange();
//		else if(lv!=null && rv==null) space.onChange();
//		else if(lv.equals(rv)==false) space.onChange();
		
		space.onChange();
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
