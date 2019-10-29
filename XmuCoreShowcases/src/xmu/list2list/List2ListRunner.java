package xmu.list2list;

import org.eclipse.emf.common.util.URI;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;
import xmu.uml2rdbms.UML2RDBMS;

@SuppressWarnings("all")
public class List2ListRunner {

	public static void main(String[] args) throws Exception {
		/* please change the basePath to the actual path of the workspace */
		final String basePath =  "/Volumes/Macintosh HD Data/Eclipse Projects/git/morel";
		
		final String l1MetamodelPath = basePath+"/XmuCoreShowcases/metamodel/List1.ecore";
		final String l2MetamodelPath = basePath+"/XmuCoreShowcases/metamodel/List2.ecore";
		
		/* use your own models */
		final String l1ModelPath = basePath+"/XmuCoreShowcases/src/xmu/list2list/List1.xmi";
		final String l2ModelPath = basePath+"/XmuCoreShowcases/src/xmu/list2list/List2.xmi";
		final String updatedL1ModelPath = basePath+"/XmuCoreShowcases/src/xmu/list2list/List1-updated.xmi";
		
		/* 
		 * test forward execution 
		 * please comment the backward execution before doing forward
		 */
//		testForward(l1MetamodelPath, l2MetamodelPath, l1ModelPath, l2ModelPath);
		
		/* 
		 * test backward execution 
		 * if you execute the forward execution, please change the rdbms model to examine the backward behavior
		 * please comment the forward execution before doing backward 
		 */
		testBackward(l1MetamodelPath, l2MetamodelPath, l1ModelPath, l2ModelPath, updatedL1ModelPath);
	}

	static public void testForward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath) throws Exception {
		List2List bx = new List2List();
		bx.registerL1Package(URI.createFileURI(sourceMetamodelPath));
		bx.registerL2Package(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadL1Model(URI.createFileURI(sourceModelPath));
		TypedNode list1Node = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("List"))[0];
		
		ViewType view = bx.execute(bx.getXmu_List2List(), sourceModel, new Tuple2[] {Tuple2.make("l", list1Node)});
		bx.saveL2Model(URI.createFileURI(viewModelPath), view);
	}
	
	@SuppressWarnings("unchecked")
	static public void testBackward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath, String updatedSourcePath) throws Exception {
		List2List bx = new List2List();
		bx.registerL1Package(URI.createFileURI(sourceMetamodelPath));
		bx.registerL2Package(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadL1Model(URI.createFileURI(sourceModelPath));
		TypedNode list1Node = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("List"))[0];
		
		TypedGraph viewModel = bx.loadL2Model(URI.createFileURI(viewModelPath));
		TypedNode list2Node = viewModel.getTypedNodesOf(viewModel.getTypeGraph().getTypeNode("List"))[0];
		
		
		SourceType updatedSource = bx.execute(bx.getXmu_List2List(), 
				sourceModel, new Tuple2[] {Tuple2.make("l", list1Node)},
				viewModel, new Tuple2[] {Tuple2.make("l", list2Node)});
		
		bx.saveL1Model(URI.createFileURI(updatedSourcePath), updatedSource, sourceModel);
	}
}
