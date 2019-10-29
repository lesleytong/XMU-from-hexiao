package xmu.insAddressBook;

import org.eclipse.emf.common.util.URI;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;
import xmu.uml2rdbms.UML2RDBMS;

@SuppressWarnings("all")
public class InsAddressBookRunner {

	public static void main(String[] args) throws Exception {
		/* please change the basePath to the actual path of the workspace */
		final String basePath =  "E:/git/morel";
		
		final String sabMetamodelPath = basePath+"/XmuCoreShowcases/metamodel/SimpleAddressBook.ecore";
		final String niiMetamodelPath = basePath+"/XmuCoreShowcases/metamodel/NIIAddressBook.ecore";
		
		/* use your own models */
		final String sabModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/sab.xmi";
		final String niiModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/nii.xmi";
		final String updatedSabModelPath = basePath+"/XmuCoreShowcases/src/xmu/insAddressBook/sab-updated.xmi";
		
		/* 
		 * test forward execution 
		 * please comment the backward execution before doing forward
		 */
		testForward(sabMetamodelPath, niiMetamodelPath, sabModelPath, niiModelPath);
		
		/* 
		 * test backward execution 
		 * if you execute the forward execution, please change the rdbms model to examine the backward behavior
		 * please comment the forward execution before doing backward 
		 */
//		testBackward(sabMetamodelPath, niiMetamodelPath, sabModelPath, niiModelPath, updatedSabModelPath);
	}

	static public void testForward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath) throws Exception {
		InsAddressBook bx = new InsAddressBook();
		bx.registerSabPackage(URI.createFileURI(sourceMetamodelPath));
		bx.registerNiiPackage(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadSabModel(URI.createFileURI(sourceModelPath));
		TypedNode sabBookNode = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("AddressBook"))[0];
		
		ViewType view = bx.execute(bx.getXmu_SabBook2NiiBook(), sourceModel, new Tuple2[] {Tuple2.make("b", sabBookNode)});
		bx.saveNiiModel(URI.createFileURI(viewModelPath), view);
	}
	
	@SuppressWarnings("unchecked")
	static public void testBackward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath, String updatedSourcePath) throws Exception {
		InsAddressBook bx = new InsAddressBook();
		bx.registerSabPackage(URI.createFileURI(sourceMetamodelPath));
		bx.registerNiiPackage(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadSabModel(URI.createFileURI(sourceModelPath));
		TypedNode sabBookNode = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("AddressBook"))[0];
		
		TypedGraph viewModel = bx.loadNiiModel(URI.createFileURI(viewModelPath));
		TypedNode niiBookNode = viewModel.getTypedNodesOf(viewModel.getTypeGraph().getTypeNode("NIIBook"))[0];
		
		
		SourceType updatedSource = bx.execute(bx.getXmu_SabBook2NiiBook(), 
				sourceModel, new Tuple2[] {Tuple2.make("b", sabBookNode)},
				viewModel, new Tuple2[] {Tuple2.make("b", niiBookNode)});
		
		bx.saveSabModel(URI.createFileURI(updatedSourcePath), updatedSource, sourceModel);
	}
}
