package xmu.bag2bag;

import org.eclipse.emf.common.util.URI;

import edu.ustb.sei.mde.bxcore.SourceType;
import edu.ustb.sei.mde.bxcore.ViewType;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;
import edu.ustb.sei.mde.structure.Tuple2;
import xmu.uml2rdbms.UML2RDBMS;

@SuppressWarnings("all")
public class Bag2BagRunner2 {

	public static void main(String[] args) throws Exception {
		/* please change the basePath to the actual path of the workspace */
		final String basePath =  "E:/git/morel";
		
		final String bag1MetamodelPath = basePath+"/XmuCoreShowcases/metamodel/Bag1.ecore";
		
		/* use your own models */
		final String baseModelPath = basePath+"/XmuCoreShowcases/src/xmu/bag2bag/base.xmi";
		final String bag1ModelPath = basePath+"/XmuCoreShowcases/src/xmu/bag2bag/a.xmi";
		final String bag2ModelPath = basePath+"/XmuCoreShowcases/src/xmu/bag2bag/b.xmi";
		final String updatedBag1ModelPath = basePath+"/XmuCoreShowcases/src/xmu/bag2bag/merge.xmi";
		
		testBackward(bag1MetamodelPath, bag1ModelPath, bag2ModelPath, updatedBag1ModelPath);
	}
	
	@SuppressWarnings("unchecked")
	static public void testBackward(String sourceMetamodelPath, String sourceModelPath, String viewModelPath, String updatedSourcePath) throws Exception {
		Bag2Bag bx = new Bag2Bag();
		bx.registerBag1Package(URI.createFileURI(sourceMetamodelPath));
		
		
		
		TypedGraph sourceModel = bx.loadBag1Model(URI.createFileURI(sourceModelPath));
		TypedGraph viewModel = bx.loadBag2Model(URI.createFileURI(viewModelPath));
		
//		TypedGraph mergeModel = sourceModel.getCopy();
//		bx.saveMergeModel(URI.createFileURI(updatedSourcePath), mergeModel, sourceModel);
		
	}
}
