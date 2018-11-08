package edu.ustb.sei.mde.bxcore.dsl.jvmmodel

import edu.ustb.sei.mde.bxcore.SourceType
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DeleteElementExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EnforcementExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpressionBlock
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression
import edu.ustb.sei.mde.bxcore.structures.ContextGraph.GraphModification
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
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.validation.IssueCodes
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NewInstanceExpression

class XmuCoreTypeComputer extends XbaseTypeComputer {
	
	def dispatch void computeTypes(ExpressionConversion cvar, ITypeComputationState state) {
		val valueTypeResult = state.withNonVoidExpectation.computeTypes(cvar.expression);
		state.acceptActualType(valueTypeResult.actualExpressionType);
	}
	
	
	def dispatch void computeTypes(ContextVarExpression cvar, ITypeComputationState state) {
		val side = cvar.side;
		val varName = cvar.name;
		
		val tupleType = ModelInferrerUtils.context(cvar, side);
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
				val isList = typeDef.third;
				
				state.acceptActualType(actualType(contextOnly, type, state, isList))
			}
		}
    }
				
	protected def LightweightTypeReference actualType(boolean contextOnly, Object type,
		ITypeComputationState state, boolean isList) {

		val elementType = if (contextOnly) {
				if (type instanceof EClass)
					getRawTypeForName(Index, state)
				else if (type instanceof EEnum)
					getRawTypeForName(String, state)
				else if (type instanceof EDataType)
					getRawTypeForName(type.instanceClass, state)
				else if (type instanceof EReference)
					getRawTypeForName(Index, state)
				else if(type instanceof EAttribute) getRawTypeForName(Index, state) else getRawTypeForName(Object,
					state)
			} else {
				if (type instanceof EClass)
					getRawTypeForName(TypedNode, state)
				else if (type instanceof EEnum)
					getRawTypeForName(String, state)
				else if (type instanceof EDataType)
					getRawTypeForName(type.instanceClass, state)
				else if (type instanceof EReference)
					getRawTypeForName(TypedEdge, state)
				else if(type instanceof EAttribute) getRawTypeForName(ValueEdge, state) else getRawTypeForName(Object,
					state)
			}

		if (isList) {
			val owner = state.getReferenceOwner();
			val array = owner.newParameterizedTypeReference(owner.newReferenceTo(List).type);
			array.addTypeArgument(elementType);
			array
		} else
			elementType
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
    	modification.expressions.forEach[e| state.withoutExpectation.computeTypes(e)];
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
    
    def dispatch void computeTypes(NewInstanceExpression instance, ITypeComputationState state) {
    	if(instance.size!==null)
    		state.withExpectation(getRawTypeForName(int,state)).computeTypes(instance.size);
    		
    	val elementType = if (instance.feature === null) {
				getRawTypeForName(TypedNode, state)
			} else {
				if(instance.feature instanceof EAttribute) getRawTypeForName(ValueEdge, state) 
				else getRawTypeForName(TypedEdge, state)
			}
		
		if(instance.size!==null) {
			val owner = state.getReferenceOwner();
			val array = owner.newParameterizedTypeReference(owner.newReferenceTo(List).type);
			array.addTypeArgument(elementType);
			state.acceptActualType(array)
		} else {
			state.acceptActualType(elementType)
		}
    }
    
}