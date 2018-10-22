package edu.ustb.sei.mde.bxcore.dsl.infer

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram
import edu.ustb.sei.mde.bxcore.dsl.jvmmodel.ModelInferrerUtils
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.resource.Resource

class InferManager {
	static public Map<Resource, InferData> inferredDataMap = new HashMap;
	
	static def getInferredTypeModel(Resource resource) throws Exception {
		val data = inferredDataMap.get(resource);
		if(data===null) {
			return createInfer(resource);
		} else {
			if(resource.modified) { // incremental
				resource.modified=false;
				println(resource.modified);
				return createInfer(resource);
			} else return data;
		}
	}
	
	static def safeGetInferredTypeModel(Resource resource) throws Exception {
		inferredDataMap.get(resource);
	}
	
	protected def static createInfer(Resource resource) throws Exception {
		if(resource.trackingModification===false) 
			resource.trackingModification=true;
		inferredDataMap.remove(resource);
		val program = resource.contents.get(0) as BXProgram;
		val literalMap = ModelInferrerUtils.groupTypeLiterals(program);
		val infer = TypeModel.buildTypeInfers(program, literalMap);
		infer.first.solveNames;
		infer.first.solveTypes;
		infer.second.solveNames;
		infer.second.solveTypes;
		
		val data = new InferData();
		data.setLiteralMap(literalMap);
		data.setSourceInfer(infer.first);
		data.setViewInfer(infer.second);
		
		inferredDataMap.put(resource,data);
		println('create infer');		
		return data;
	}
}