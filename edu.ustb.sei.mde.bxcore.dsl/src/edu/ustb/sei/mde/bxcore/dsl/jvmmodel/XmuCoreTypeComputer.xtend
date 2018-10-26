package edu.ustb.sei.mde.bxcore.dsl.jvmmodel

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression
import edu.ustb.sei.mde.bxcore.structures.Index
import edu.ustb.sei.mde.graph.typedGraph.TypedEdge
import edu.ustb.sei.mde.graph.typedGraph.TypedNode
import edu.ustb.sei.mde.graph.typedGraph.ValueEdge
import java.util.List
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.eclipse.xtext.xbase.XExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpressionBlock
import edu.ustb.sei.mde.bxcore.SourceType
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EnforcementExpression
import edu.ustb.sei.mde.bxcore.structures.ContextGraph.GraphModification
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DeleteElementExpression

class XmuCoreTypeComputer extends XbaseTypeComputer {
	
	def dispatch void computeTypes(ContextVarExpression cvar, ITypeComputationState state) {
		val side = cvar.side;
		val varName = cvar.name;
		
		val tupleType = ModelInferrerUtils.context(cvar, side.equals("source"));
		if(tupleType===null) {
			state.acceptActualType(getRawTypeForName(Object, state))
		} else {
			val typeDef = tupleType.tuples.findFirst[it.first.equals(varName)];
			if(typeDef===null) {
				state.addDiagnostic(
					new EObjectDiagnosticImpl(Severity.ERROR,
						IssueCodes.INVALID_IDENTIFIER, varName+" is undefined in the "+side,
						cvar, BXCorePackage.Literals.CONTEXT_VAR_EXPRESSION__NAME, -1, #[EcoreUtil.getURI(cvar).toString()]))
			}
			else {
				val type = typeDef.second;
				val contextOnly = ModelInferrerUtils.isContextOnly(cvar);
				if (contextOnly) {
					if (type instanceof EClass)
						state.acceptActualType(getRawTypeForName(Index, state))
					else if (type instanceof EEnum)
						state.acceptActualType(getRawTypeForName(String, state))
					else if (type instanceof EDataType)
						state.acceptActualType(getRawTypeForName(type.instanceClass, state))
					else if (type instanceof EReference)
						state.acceptActualType(getRawTypeForName(Index, state))
					else if(type instanceof EAttribute) state.acceptActualType(
						getRawTypeForName(Index, state)) 
					else state.acceptActualType(getRawTypeForName(Object, state))
				} else {
					if (type instanceof EClass)
						state.acceptActualType(getRawTypeForName(TypedNode, state))
					else if (type instanceof EEnum)
						state.acceptActualType(getRawTypeForName(String, state))
					else if (type instanceof EDataType)
						state.acceptActualType(getRawTypeForName(type.instanceClass, state))
					else if (type instanceof EReference)
						state.acceptActualType(getRawTypeForName(TypedEdge, state))
					else if(type instanceof EAttribute) state.acceptActualType(
						getRawTypeForName(ValueEdge, state)) 
					else state.acceptActualType(getRawTypeForName(Object, state))
				}
			}
		}
    }
    
    def dispatch void computeTypes(NavigationExpression pathExp, ITypeComputationState state) {
    	val host = pathExp.host;
    	val path = pathExp.pathName;
    	
    	val hostType = state.withNonVoidExpectation.computeTypes(host);
    	
    	val ecoreType = ModelInferrerUtils.navEcoreType(pathExp)
    	if(ecoreType===null) {
    		state.addDiagnostic(
				new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INVALID_IDENTIFIER, "cannot navigate to " + path,
					pathExp, BXCorePackage.Literals.NAVIGATION_EXPRESSION__PATH_NAME, -1,
					#[EcoreUtil.getURI(pathExp).toString()]))
    	} else {
    		val owner = state.getReferenceOwner();
			val componmentType = if (ecoreType.key instanceof EClass)
					getRawTypeForName(TypedNode, state)
				else if (ecoreType.key instanceof EEnum)
					getRawTypeForName(String, state)
				else if (ecoreType.key instanceof EDataType)
					getRawTypeForName(ecoreType.key.instanceClass, state) 
				else getRawTypeForName(Object, state);
    		val type = if(ecoreType.value) {
    			val array = owner.newParameterizedTypeReference(owner.newReferenceTo(List).type);
    			array.addTypeArgument(componmentType);
    			array
    		} else {
    			componmentType
    		}
    		state.acceptActualType(type);
    	}
    }
    
    def dispatch void computeTypes(ModificationExpressionBlock modification, ITypeComputationState state) {
    	val type = getRawTypeForName(GraphModification, state);
    	modification.expressions.forEach[e| state.withExpectation(type).computeTypes(e)];
    	state.acceptActualType(getRawTypeForName(SourceType, state),ConformanceFlags.NO_IMPLICIT_RETURN);
    }
    
    def dispatch void computeTypes(EnforcementExpression modification, ITypeComputationState state) {
    	modification.valueMappings.forEach[e|state.withNonVoidExpectation.computeTypes(e.expression)];
    	state.acceptActualType(getRawTypeForName(GraphModification, state));
    }
    
    def dispatch void computeTypes(DeleteElementExpression modification, ITypeComputationState state) {
    	state.withNonVoidExpectation.computeTypes(modification.element);
    	state.acceptActualType(getRawTypeForName(GraphModification, state));
    }
    
}