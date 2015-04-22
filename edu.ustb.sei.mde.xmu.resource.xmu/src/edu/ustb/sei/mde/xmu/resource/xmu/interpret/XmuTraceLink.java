package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import org.eclipse.emf.ecore.EObject;

public class XmuTraceLink {
	private EObject source;
	public EObject getSource() {
		return source;
	}

	public EObject getView() {
		return view;
	}

	public EObject getSourcePost() {
		return sourcePost;
	}

	private EObject view;
	private EObject sourcePost;

	public XmuTraceLink(EObject source, EObject sourcePost) {
		this.source = source;
		this.sourcePost = sourcePost;
		this.view = null;
	}
	
	public XmuTraceLink(EObject source, EObject view, EObject sourcePost) {
		this.source = source;
		this.sourcePost = sourcePost;
		this.view = view;
	}
	
	public void setSourcePost(EObject view, EObject sourcePost) {
		this.view = view;
		this.sourcePost = sourcePost;
	}
	
	public boolean isSolid() {
		return view != null;
	}
	
	public boolean isCreated() {
		return source == null && sourcePost != null;
	}
	
	public boolean isDeleted() {
		return source != null && sourcePost == null;
	}
	
	public boolean isReplaced() {
		return source !=null && sourcePost != null;
	}
}
