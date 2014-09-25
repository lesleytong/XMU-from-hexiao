package edu.ustb.sei.mde.emg;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.ustb.sei.mde.emg.graph.ModelSpace;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		 ResourceSet resourceSet = new ResourceSetImpl();
//
//		  // Register the default resource factory -- only needed for stand-alone!
//		  resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//		    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
//		  
//		  URI metamodelURI = URI.createFileURI("D:/项目/morel/edu.ustb.sei.mde.emg/Test.ecore");
//		  URI modelURI = URI.createFileURI("D:/项目/morel/edu.ustb.sei.mde.emg/A.xmi");
//		  
//		  Resource metamodel = resourceSet.getResource(metamodelURI, true);
//		  EPackage pkg = (EPackage)metamodel.getContents().get(0);
//		  
//		  resourceSet.getPackageRegistry().put(pkg.getNsURI(), pkg);
//		  
//		  Resource model = resourceSet.getResource(modelURI, true);
//		  
//		  ModelSpace space = new ModelSpace();
//		  space.initWithResource(model);
//		  
//		  //EObject root = model.getContents().get(0);
//		  //space.deleteObjectFromModel(root);
//		  
//		  EClass A = (EClass) pkg.getEClassifiers().get(0);
//		  
//		  EObject o = EcoreUtil.create(A);
//		  space.addElementToModel(o);
//		  
//		  for(int i : space.getAllElementIDByType(A)) {
//			  System.out.println(i);
//		  }
		
		System.out.println(argSize());
	}
	
	public static int argSize(Object...objects) {
		return objects.length;
	}

}
