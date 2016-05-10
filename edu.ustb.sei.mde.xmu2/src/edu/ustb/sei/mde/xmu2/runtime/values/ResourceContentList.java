package edu.ustb.sei.mde.xmu2.runtime.values;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class ResourceContentList extends ModelList<EObject> {
	private Resource resource = null;

	public ResourceContentList(Resource resource) {
		super();
		this.resource = resource;
	}

	@Override
	public int size() {
		return resource.getContents().size();
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public boolean contains(Object o) {
		return resource.getContents().contains(o);
	}

	@Override
	public Iterator<EObject> iterator() {
		return resource.getContents().iterator();
	}

	@Override
	public boolean add(EObject e) {
		return resource.getContents().add(e);
	}

	@Override
	public boolean remove(Object o) {
		return resource.getContents().remove(o);
	}

	@Override
	public boolean addAll(Collection<? extends EObject> c) {
		return resource.getContents().addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return resource.getContents().removeAll(c);
	}

	@Override
	public void clear() {
		resource.getContents().clear();
	}

	@Override
	public EObject get(int index) {
		return resource.getContents().get(index);
	}

	@Override
	public EObject set(int index, EObject element) {
		return resource.getContents().set(index, element);
	}

	@Override
	public void add(int index, EObject element) {
		resource.getContents().add(index,element);
	}

	@Override
	public EObject remove(int index) {
		return resource.getContents().remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return resource.getContents().indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return resource.getContents().lastIndexOf(o);
	}

	
	
}
