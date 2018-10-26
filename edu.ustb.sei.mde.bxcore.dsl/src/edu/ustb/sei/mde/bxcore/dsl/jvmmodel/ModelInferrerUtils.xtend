package edu.ustb.sei.mde.bxcore.dsl.jvmmodel

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral
import java.util.HashMap
import edu.ustb.sei.mde.structure.Tuple2
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType
import java.util.ArrayList
import edu.ustb.sei.mde.bxcore.dsl.infer.TypeInferenceException
import org.eclipse.emf.ecore.EObject
import edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern
import edu.ustb.sei.mde.bxcore.dsl.infer.InferManager
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinitionReference
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareCondition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareUnidirectionalAction
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign
import org.eclipse.emf.ecore.EClassifier
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression
import org.eclipse.emf.ecore.EClass

class ModelInferrerUtils {
	static def groupTypeLiterals(BXProgram program) {
		val literals = new ArrayList;
		val itr = program.eAllContents;
		while(itr.hasNext()) {
			val e = itr.next;
			if(e.eIsProxy) {
				throw new TypeInferenceException(e,null,null,null);
			} else {
				if(e instanceof TypeLiteral) {
					literals.add((e as TypeLiteral)->TupleType.make(e as TypeLiteral));
				}
			}
		}
		
		val groups = literals.groupBy[it.value];
		val result = new HashMap;
		
		groups.forEach[k,v,id|
			val pair = Tuple2.make(k,id);
			v.forEach[p|result.put(p.key, pair);];
		];
		
		return result;
	}
	
	static def TupleType context(EObject e, boolean inSource) {
    	try {
    		if (e === null) null
			else if (e instanceof Pattern) {
	    		val inferData = InferManager.getInferredTypeModel(e.eResource);
				if (e instanceof PatternDefinitionReference) {
					inferData.literalMap.get(e.pattern.literal).first
				} else if(e instanceof PatternTypeLiteral) {
					inferData.literalMap.get(e).first
				} else null
			} else if(e instanceof ContextAwareCondition) {
				if(e.eContainingFeature===BXCorePackage.Literals.XMU_CORE_ALIGN__ALIGNMENT) {
					if(inSource) (e.eContainer as XmuCoreAlign).sourcePattern.context(true)
					else (e.eContainer as XmuCoreAlign).viewPattern.context(false)
				} else e.eContainer.context(inSource)
			} else if(e instanceof ContextAwareUnidirectionalAction) {
				if(e.eContainingFeature===BXCorePackage.Literals.XMU_CORE_ALIGN__UNMATCH_S) {
					if(inSource) (e.eContainer as XmuCoreAlign).sourcePattern.context(true)
					else (e.eContainer as XmuCoreAlign).context(false)
				} else if(e.eContainingFeature===BXCorePackage.Literals.XMU_CORE_ALIGN__UNMATCH_V) {
					if(inSource) (e.eContainer as XmuCoreAlign).context(true)
					else (e.eContainer as XmuCoreAlign).viewPattern.context(false)
				} else e.eContainer.context(inSource)
			} else if (e instanceof XmuCoreStatement) {
				val inferData = InferManager.getInferredTypeModel(e.eResource);
				if(inSource) inferData.sourceInfer.unsolvedTupleTypeMap.get(e)
				else inferData.viewInfer.unsolvedTupleTypeMap.get(e)
			} else e.eContainer.context(inSource)
    		
    	} catch(Exception exp) {
    		return null;
    	}
    }
    
    static def boolean isContextOnly(EObject e) {
		if(e===null) false
		else if(e instanceof ContextAwareCondition) {
			e.eContainingFeature===BXCorePackage.Literals.PATTERN_TYPE_LITERAL__FILTER 
			|| e.eContainingFeature===BXCorePackage.Literals.XMU_CORE_ALIGN__ALIGNMENT
		} else if(e instanceof ContextAwareUnidirectionalAction) false
		else e.eContainer.isContextOnly
	}
	
	static def Pair<EClassifier, Boolean> navEcoreType(ContextExpression e) {
    	if(e instanceof ContextVarExpression) {
    		val side = e.side;
			val varName = e.name;
			try {
				val tupleType = ModelInferrerUtils.context(e, side.equals("source"));
				if (tupleType === null)
					null
				else {
					val typeDef = tupleType.tuples.findFirst[it.first.equals(varName)];
					if(typeDef === null) null 
					else {
						if(typeDef.second instanceof EClass) typeDef.second as EClass -> false
						else null
					}
				}
			} catch (Exception x) {
				null
			}
    	} else if(e instanceof NavigationExpression) {
    		val hostType = e.host.navEcoreType;
    		val path = e.pathName;
    		if(hostType===null) null
    		else {
    			if(hostType.key instanceof EClass) {
    				val pathType = (hostType.key as EClass).getEStructuralFeature(path);
    				if(pathType===null) null
    				else pathType.EType -> (hostType.value || pathType.isMany)
    			} else null
    		}
    	}
    }
}