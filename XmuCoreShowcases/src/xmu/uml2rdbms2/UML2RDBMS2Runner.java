package xmu.uml2rdbms2;

import org.eclipse.emf.common.util.URI;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;

@SuppressWarnings("all")
public class UML2RDBMS2Runner {


	public static void main(String[] args) throws Exception {
		/* please change the basePath to the actual path of the workspace */
		final String basePath =  "/Volumes/Macintosh HD Data/Eclipse Projects/git/morel";
		
		final String umlMetamodelPath = basePath+"/XmuCoreShowcases/metamodel/SimpleClass.ecore";
		final String rdbmsMetamodelPath = basePath+"/XmuCoreShowcases/metamodel/SimpleRDBMS.ecore";
		
		/* use your own models */
		final String umlModelPath = basePath+"/XmuCoreShowcases/src/xmu/uml2rdbms2/uml.xmi";
		final String rdbmsModelPath = basePath+"/XmuCoreShowcases/src/xmu/uml2rdbms2/rdbms.xmi";
		final String updatedUmlModelPath = basePath+"/XmuCoreShowcases/src/xmu/uml2rdbms2/uml-updated.xmi";
		
		/* 
		 * test forward execution 
		 * please comment the backward execution before doing forward
		 */
//		testForward(umlMetamodelPath, rdbmsMetamodelPath, umlModelPath, rdbmsModelPath);
		
		/* 
		 * test backward execution 
		 * if you execute the forward execution, please change the rdbms model to examine the backward behavior
		 * please comment the forward execution before doing backward 
		 */
		testBackward(umlMetamodelPath, rdbmsMetamodelPath, umlModelPath, rdbmsModelPath, updatedUmlModelPath);
	}
	
	static public void testForward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath) throws Exception {
		UML2RDBMS2 bx = new UML2RDBMS2();
		bx.registerUmlPackage(URI.createFileURI(sourceMetamodelPath));
		bx.registerRdbmsPackage(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadUmlModel(URI.createFileURI(sourceModelPath));
		TypedNode classModelNode = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("ClassModel"))[0];
		
		ViewType view = bx.execute(bx.getXmu_ClassModelToRdbmsModel(), sourceModel, new Tuple2[] {Tuple2.make("m", classModelNode)});
		bx.saveRdbmsModel(URI.createFileURI(viewModelPath), view);
	}
	
	@SuppressWarnings("unchecked")
	static public void testBackward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath, String updatedSourcePath) throws Exception {
		UML2RDBMS2 bx = new UML2RDBMS2();
		bx.registerUmlPackage(URI.createFileURI(sourceMetamodelPath));
		bx.registerRdbmsPackage(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadUmlModel(URI.createFileURI(sourceModelPath));
		TypedNode classModelNode = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("ClassModel"))[0];
		
		TypedGraph viewModel = bx.loadRdbmsModel(URI.createFileURI(viewModelPath));
		TypedNode rdbmsModelNode = viewModel.getTypedNodesOf(viewModel.getTypeGraph().getTypeNode("RDBMSModel"))[0];
		
		
		SourceType updatedSource = bx.execute(bx.getXmu_ClassModelToRdbmsModel(), 
				sourceModel, new Tuple2[] {Tuple2.make("m", classModelNode)},
				viewModel, new Tuple2[] {Tuple2.make("m", rdbmsModelNode)});
		
		bx.saveUmlModel(URI.createFileURI(updatedSourcePath), updatedSource, sourceModel);
	}

}
