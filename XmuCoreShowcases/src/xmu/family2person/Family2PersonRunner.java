package xmu.family2person;

import org.eclipse.emf.common.util.URI;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;

@SuppressWarnings("all")
public class Family2PersonRunner {

	public static void main(String[] args) throws Exception {
		/* please change the basePath to the actual path of the workspace */
		final String basePath =  "/Volumes/Macintosh HD Data/Eclipse Projects/git/morel";
		
		final String familyMetamodelPath = basePath+"/XmuCoreShowcases/metamodel/FamilyRegister.ecore";
		final String personsMetamodelPath = basePath+"/XmuCoreShowcases/metamodel/PersonsRegister.ecore";
		
		/* use your own models */
		final String familyModelPath = basePath+"/XmuCoreShowcases/src/xmu/family2person/Family.xmi";
		final String personModelPath = basePath+"/XmuCoreShowcases/src/xmu/family2person/Person.xmi";
		final String updatedFamilyModelPath = basePath+"/XmuCoreShowcases/src/xmu/family2person/family-updated.xmi";
		
		/* 
		 * test forward execution 
		 * please comment the backward execution before doing forward
		 */
		testForward(familyMetamodelPath, personsMetamodelPath, familyModelPath, personModelPath);
		
		/* 
		 * test backward execution 
		 * if you execute the forward execution, please change the rdbms model to examine the backward behavior
		 * please comment the forward execution before doing backward 
		 */
//		testBackward(familyMetamodelPath, personsMetamodelPath, familyModelPath, personModelPath, updatedFamilyModelPath);
	}

	static public void testForward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath) throws Exception {
		Family2Persons bx = new Family2Persons();
		bx.registerFRPackage(URI.createFileURI(sourceMetamodelPath));
		bx.registerPRPackage(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadFRModel(URI.createFileURI(sourceModelPath));
		TypedNode sRootNode = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("FamilyRegister"))[0];
		
		ViewType view = bx.execute(bx.getXmu_Father2Person(), sourceModel, new Tuple2[] {Tuple2.make("x", sRootNode)});
		bx.savePRModel(URI.createFileURI(viewModelPath), view);
	}
	
	@SuppressWarnings("unchecked")
	static public void testBackward(String sourceMetamodelPath, String viewMetamodelPath, String sourceModelPath, String viewModelPath, String updatedSourcePath) throws Exception {
		Family2Persons bx = new Family2Persons();
		bx.registerFRPackage(URI.createFileURI(sourceMetamodelPath));
		bx.registerPRPackage(URI.createFileURI(viewMetamodelPath));
		
		TypedGraph sourceModel = bx.loadFRModel(URI.createFileURI(sourceModelPath));
		TypedNode sRoot = sourceModel.getTypedNodesOf(sourceModel.getTypeGraph().getTypeNode("FamilyRegister"))[0];
		
		TypedGraph viewModel = bx.loadPRModel(URI.createFileURI(viewModelPath));
		TypedNode vRoot = viewModel.getTypedNodesOf(viewModel.getTypeGraph().getTypeNode("PersonsRegister"))[0];
		
		
		SourceType updatedSource = bx.execute(bx.getXmu_Father2Person(), 
				sourceModel, new Tuple2[] {Tuple2.make("x", sRoot)},
				viewModel, new Tuple2[] {Tuple2.make("y", vRoot)});
		
		bx.saveFRModel(URI.createFileURI(updatedSourcePath), updatedSource, sourceModel);
	}
}
