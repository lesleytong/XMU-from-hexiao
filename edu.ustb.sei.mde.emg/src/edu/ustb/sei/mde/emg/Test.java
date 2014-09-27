package edu.ustb.sei.mde.emg;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.emg.library.OclStandardLibrary;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSequence;
import edu.ustb.sei.mde.morel.CollectionType;
import edu.ustb.sei.mde.morel.MorelFactory;

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
//		  URI metamodelURI = URI.createFileURI("D:/��Ŀ/morel/edu.ustb.sei.mde.emg/Test.ecore");
//		  URI modelURI = URI.createFileURI("D:/��Ŀ/morel/edu.ustb.sei.mde.emg/A.xmi");
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
		
		OclStandardLibrary ocl = new OclStandardLibrary(null);
		
		
		System.out.println(ocl.execute("+", 9, 10.0));
		System.out.println(ocl.execute("/", 9, 2));
		System.out.println(ocl.execute(">", 9, 8));
		System.out.println(ocl.execute("<=", 9, 2));
		System.out.println(ocl.execute("xor", true,"true"));

		
		OclSequence seq = new OclSequence();
		CollectionType type = MorelFactory.eINSTANCE.createSequenceType();
		type.setElementType(EcorePackage.eINSTANCE.getEIntegerObject());
		seq.setType(type);
		seq.add(1);
		seq.add(2);
		seq.add(3);
		seq.add(3);
		seq.add(5);
		
		System.out.println(ocl.execute("first", seq));
		System.out.println(ocl.execute("size", seq));
		System.out.println(ocl.execute("includes", seq, 4));
		System.out.println(ocl.execute("add", seq, 77));
		System.out.println(seq);
	}
	
	public static int argSize(Object...objects) {
		return objects.length;
	}

}
