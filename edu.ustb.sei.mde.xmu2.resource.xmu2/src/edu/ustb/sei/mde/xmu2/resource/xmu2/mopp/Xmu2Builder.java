/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

import java.io.IOException;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.runtime.build.BXCodeGenerator;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;

public class Xmu2Builder implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Builder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	
	public org.eclipse.core.runtime.IStatus build(edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Resource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		if(resource.getErrors().isEmpty()==false) {
			this.handleDeletion(resource.getURI(), monitor);
			return Status.CANCEL_STATUS;
		}
		
		ResourceSet set = new ResourceSetImpl();
		AnalysisUtil.initializeResourceSet(set);
		
		URI uri = getBuildFileURI(resource.getURI());
		Resource res = set.createResource(uri);
		
		try {
			BXCodeGenerator bxcg = new BXCodeGenerator();
			TransformationModel tm = (TransformationModel)resource.getContents().get(0);
			res.getContents().add(bxcg.build(tm));
			res.save(null);
		} catch(Exception e) {
			e.printStackTrace();
			ConsoleUtil.printToConsole(e.toString(), "XMU2", true);
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		
		
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
	/**
	 * Handles the deletion of the given resource.
	 */
	public org.eclipse.core.runtime.IStatus handleDeletion(org.eclipse.emf.common.util.URI uri, org.eclipse.core.runtime.IProgressMonitor monitor) {
		// by default nothing is done when a resource is deleted
		URI build = getBuildFileURI(uri);
		ResourceSet set = new ResourceSetImpl();
		AnalysisUtil.initializeResourceSet(set);
		Resource res = set.getResource(build, false);
		if(res!=null) {
			try {
				res.delete(null);
			} catch (IOException e) {
			}
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
	
	
	static public URI getBuildFileURI(URI uri) {
		return uri.trimFileExtension().appendFileExtension(AnalysisUtil.CORE_EXTENSION);
	}
	
}
