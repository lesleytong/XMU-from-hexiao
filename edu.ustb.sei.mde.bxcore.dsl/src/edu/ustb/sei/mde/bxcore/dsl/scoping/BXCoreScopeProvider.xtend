/*
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage
import org.eclipse.emf.ecore.util.EcoreUtil
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram
import java.util.ArrayList
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.impl.SimpleScope
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EcoreTypeRef
import org.eclipse.emf.ecore.EClass
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXFunctionDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeDefinition

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class BXCoreScopeProvider extends AbstractBXCoreScopeProvider {

	override getScope(EObject context, EReference reference) {
		if(reference===BXCorePackage.Literals.ECORE_TYPE_REF__TYPE) {
			val program = context.root;
			val objects = new ArrayList;
			program.imports.forEach[i|
				val itr = i.metamodel.eAllContents;
				itr.forEach[c|
					if(c instanceof EClassifier) {
						objects.add(EObjectDescription.create(QualifiedName.create(i.shortName, c.name), c));
					}
				];
			];
			return new SimpleScope(objects);
		} else if(reference===BXCorePackage.Literals.PATTERN_EDGE__FEATURE) {
			val node = context.patternNode;
			if(node.type instanceof EcoreTypeRef) {
				val type = (node.type as EcoreTypeRef).type;
				if(type instanceof EClass) {
					return new SimpleScope(type.EAllStructuralFeatures.map[f|EObjectDescription.create(f.name, f)].toList);
				}
			}
		} else if(reference===BXCorePackage.Literals.PATTERN_NODE_REF__NODE) {
			val pattern = context.pattern;
			val objects = new ArrayList;
			pattern.eAllContents.forEach[e|
				if(e instanceof PatternNode) {
					objects+=EObjectDescription.create(e.name,e);
				}
			];
			return new SimpleScope(objects);
		} else if(reference===BXCorePackage.Literals.DEFINED_CONTEXT_TYPE_REF__TYPE) {
			val function = context.eContainer.getFunction(); // skip the context object, because it may be the function definition now
			val program = context.getProgram();
			val types = program.definitions.filter[it instanceof TypeDefinition];
			val namedPatterns = program.definitions.filter[
				it instanceof PatternDefinition 
				&& (it as PatternDefinition).name!==null 
				&& (it as PatternDefinition).type!==null
				&& !types.exists[t|t.name.equals((it as PatternDefinition).type)]];
			val patterns = if(function===null) null else function.eAllContents.filter[
				it instanceof PatternDefinition 
				&& (it as PatternDefinition).name===null 
				&& (it as PatternDefinition).type!==null
				&& !types.exists[t|t.name.equals((it as PatternDefinition).type)]];
			
			val objects = new ArrayList;
			types.forEach[t| objects+=EObjectDescription.create(t.name, t)];
			namedPatterns.forEach[p| objects += EObjectDescription.create((p as PatternDefinition).type, p)];
			if(patterns!==null) patterns.forEach[p| objects += EObjectDescription.create((p as PatternDefinition).type, p)];
			
			return new SimpleScope(objects);
		}
		
		super.getScope(context, reference)
	}
		
	def BXProgram getProgram(EObject object) {
		if(object===null) return null
		else if(object instanceof BXProgram) object as BXProgram
		else object.eContainer.getProgram
	}
		
	def BXFunctionDefinition getFunction(EObject object) {
		if(object===null) return null
		else if(object instanceof BXFunctionDefinition) object as BXFunctionDefinition
		else object.eContainer.getFunction
	}
	
	def getRoot(EObject object) {
		EcoreUtil.getRootContainer(object) as BXProgram
	}
	
	def PatternNode getPatternNode(EObject object) {
		if(object===null) return null
		else if(object instanceof PatternNode) object as PatternNode
		else object.eContainer.patternNode
	}
	
	def PatternDefinition getPattern(EObject object) {
		if(object===null) return null
		else if(object instanceof PatternDefinition) object as PatternDefinition
		else object.eContainer.pattern
	}
	
	
	
}
