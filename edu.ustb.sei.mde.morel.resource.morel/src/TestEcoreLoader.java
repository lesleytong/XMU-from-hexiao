import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;


public class TestEcoreLoader {

	public static void main(String[] args) {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		// Register the default resource factory -- only needed for stand-alone!
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
//		
		URI uri = URI.createURI("/Users/hexiao/Documents/java/morel/edu.ustb.sei.mde.morel/metamodel/morel.ecore");
		Resource res = resourceSet.getResource(uri, true);
		System.out.println(res);
	}

}
