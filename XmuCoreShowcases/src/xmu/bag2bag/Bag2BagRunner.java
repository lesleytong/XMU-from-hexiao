package xmu.bag2bag;

import org.eclipse.emf.common.util.URI;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;
import xmu.uml2rdbms.UML2RDBMS;

@SuppressWarnings("all")
public class Bag2BagRunner {

	public static void main(String[] args) throws Exception {
		/* please change the basePath to the actual path of the workspace */
		final String basePath =  "/Volumes/Macintosh HD Data/Eclipse Projects/git/morel";
		
		final String bag1MetamodelPath = basePath+"/XmuCoreShowcases/metamodel/Bag1.ecore";
		final String bag2MetamodelPath = basePath+"/XmuCoreShowcases/metamodel/Bag2.ecore";
		
		/* use your own models */
		final String bag1ModelPath = basePath+"/XmuCoreShowcases/src/xmu/bag2bag/bag1.xmi";
		final String bag2ModelPath = basePath+"/XmuCoreShowcases/src/xmu/bag2bag/bag2.xmi";
		final String updatedBag1ModelPath = basePath+"/XmuCoreShowcases/src/xmu/bag2bag/bag1-updated.xmi";
		
		/* 
		 * test forward execution 
		 * please comment the backward execution before doing forward
		 */
//		testForward(bag1MetamodelPath, bag2MetamodelPath, bag1ModelPath, bag2ModelPath);
		
		/* 
		 * test backward execution 
		 * if you execute the forward execution, please change the rdbms model to examine the backward behavior
		 * please comment the forward execution before doing backward 
		 */
		testBackward(bag1MetamodelPath, bag2MetamodelPath, bag1ModelPath, bag2ModelPath, updatedBag1ModelPath);
	}

	static public void testForward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath) throws Exception {
		Bag2Bag bx = new Bag2Bag();
		bx.registerBag1Package(URI.createFileURI(sourceMetamodelPath));
		bx.registerBag2Package(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadBag1Model(URI.createFileURI(sourceModelPath));
		TypedNode bagNode = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("Bag"))[0];
		
		ViewType view = bx.execute(bx.getXmu_Bag2Bag(), sourceModel, new Tuple2[] {Tuple2.make("b", bagNode)});
		bx.saveBag2Model(URI.createFileURI(viewModelPath), view);
	}
	
	@SuppressWarnings("unchecked")
	static public void testBackward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath, String updatedSourcePath) throws Exception {
		Bag2Bag bx = new Bag2Bag();
		bx.registerBag1Package(URI.createFileURI(sourceMetamodelPath));
		bx.registerBag2Package(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadBag1Model(URI.createFileURI(sourceModelPath));
		TypedNode bag1Node = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("Bag"))[0];
		
		TypedGraph viewModel = bx.loadBag2Model(URI.createFileURI(viewModelPath));
		TypedNode bag2 = viewModel.getTypedNodesOf(viewModel.getTypeGraph().getTypeNode("Bag"))[0];
		
		
		SourceType updatedSource = bx.execute(bx.getXmu_Bag2Bag(), 
				sourceModel, new Tuple2[] {Tuple2.make("b", bag1Node)},
				viewModel, new Tuple2[] {Tuple2.make("b", bag2)});
		
		bx.saveBag1Model(URI.createFileURI(updatedSourcePath), updatedSource, sourceModel);
	}
}
