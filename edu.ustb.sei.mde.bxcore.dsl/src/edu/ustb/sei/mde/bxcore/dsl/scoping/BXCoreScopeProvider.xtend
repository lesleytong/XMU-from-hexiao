/*
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.scoping

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXFunctionDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram
import edu.ustb.sei.mde.bxcore.dsl.bXCore.FeatureTypeRef
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection
import edu.ustb.sei.mde.bxcore.dsl.bXCore.OrderedTupleTypeLiteral
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.UnorderedTupleTypeLiteral
import java.util.ArrayList
import java.util.HashSet
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.scoping.impl.FilteringScope
import edu.ustb.sei.mde.bxcore.dsl.bXCore.AnnotatedType
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternPathEdge
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DashedPathType
import java.util.List
import org.eclipse.emf.ecore.EStructuralFeature
import edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class BXCoreScopeProvider extends AbstractBXCoreScopeProvider {
	
	def featureScope(EClass type) {
		if (type === null) {
			return SimpleScope.NULLSCOPE
		} else {
			if (!type.eIsProxy) {
				val objects = new ArrayList;
				type.EAllStructuralFeatures.forEach [ i |
					objects.add(EObjectDescription.create(i.name, i));
				];
				return new SimpleScope(objects);
			} else {
				return SimpleScope.NULLSCOPE
			}
		}
	}
	
	def featureScope(List<EStructuralFeature> prevFeatures) {
		val objects = new ArrayList;
		prevFeatures.forEach[e|
			val type = e.EType;
			if(type instanceof EClass) {
				type.EAllStructuralFeatures.forEach [ i |
					objects.add(EObjectDescription.create(i.name, i));
				];
			} 
		];
		return new SimpleScope(objects);
	}

	override getScope(EObject context, EReference reference) {
		try{
			if(reference===BXCorePackage.Literals.UNORDERED_TUPLE_TYPE_LITERAL__SOURCE || 
				reference===BXCorePackage.Literals.ORDERED_TUPLE_TYPE_LITERAL__SOURCE ||
				reference===BXCorePackage.Literals.PATTERN_TYPE_LITERAL__SOURCE
			) {
				return new SimpleScope(context.root.imports.map[EObjectDescription.create(it.shortName, it)].toList);
			} else if(reference===BXCorePackage.Literals.TYPE_REF__TYPE) {
				val importSection = context.importSection;
				return importSection.metamodel.collectTypes
			} else if(reference===BXCorePackage.Literals.FEATURE_TYPE_REF__FEATURE) {
				val type = (context as FeatureTypeRef).type as EClass;
				return type.featureScope;
			} else if(reference===BXCorePackage.Literals.PATTERN_NODE__TYPE) {
				val importSection = context.importSection;
				return importSection.metamodel.collectTypes;
			} else if(reference===BXCorePackage.Literals.PATTERN_EDGE__FEATURE) {
				val node = context.patternNode;
				if(node.type instanceof EClass) {
					return (node.type as EClass).featureScope;
				} else return IScope.NULLSCOPE;
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
				val namedPatterns = program.definitions.filter[it instanceof PatternDefinition];
				val patterns = if(function===null) null else function.eAllContents.filter[it instanceof PatternDefinition];
				
				val objects = new ArrayList;
				types.forEach[t| objects+=EObjectDescription.create(t.name, t)];
				
				namedPatterns.forEach[p| objects += EObjectDescription.create((p as PatternDefinition).name, p)];
				if(patterns!==null) patterns.forEach[p| objects += EObjectDescription.create((p as PatternDefinition).name, p)];
				
				return new SimpleScope(objects);
			} else if(reference===BXCorePackage.Literals.EXPRESSION_CONVERSION__METAMODEL||
				reference===BXCorePackage.Literals.ANNOTATED_TYPE__METAMODEL
			) {
				return new SimpleScope(context.program.imports.map[EObjectDescription.create(it.shortName, it)]);
			} else if(reference===BXCorePackage.Literals.EXPRESSION_CONVERSION__TYPE
			) {
				val pkg = (context as ExpressionConversion).metamodel.metamodel;
				return new FilteringScope(pkg.collectTypes, [d|d.EObjectOrProxy instanceof EClass]);
			} else if(reference===BXCorePackage.Literals.ANNOTATED_TYPE__TYPE) {
				val pkg = (context as AnnotatedType).metamodel.metamodel;
				return new FilteringScope(pkg.collectTypes, [d|d.EObjectOrProxy instanceof EClass]);
			} else if(reference===BXCorePackage.Literals.ANNOTATED_TYPE__FEATURE) {
				val type = (context as AnnotatedType).type;
				return type.featureScope;
			} else if(reference==BXCorePackage.Literals.DASHED_PATH_TYPE_SEGMENT__TYPES) {
				val dashedPathType = context.eContainer; // context must be DashedPathTypeSegment
				val typeContainer = dashedPathType.eContainer;
				if(typeContainer instanceof PatternPathEdge) {
					val node = typeContainer.patternNode;
					if (node.type instanceof EClass) {
						return (node.type as EClass).featureScope;
					} else
						return IScope.NULLSCOPE;
				} else if(typeContainer instanceof DashedPathType) {
					val prevSeg = (typeContainer as DashedPathType).segment;
					return prevSeg.types.featureScope
				}
				
			}
		} catch(Exception e) {
		}
		
		super.getScope(context, reference)
	}
	
	protected def IScope collectTypes(EPackage metamodel) {
		val objects = new ArrayList;
		if (metamodel === null)
			SimpleScope.NULLSCOPE
		else {
			val visited = new HashSet;
			val itr = metamodel.eAllContents;
			itr.forEach [ c |
				if (c instanceof EClassifier) {
					objects.add(EObjectDescription.create(c.name, c));
					visited.add(c);
				}
			];
		
			val itr2 = metamodel.eAllContents;
			itr2.forEach [ c |
				if (c instanceof EClass) {
					c.EAllStructuralFeatures.forEach [ f |
						val t = f.EType;
						if (visited.contains(t) === false) {
							objects.add(EObjectDescription.create(t.name, t));
							visited.add(t);
						}
					]
				}
			];
			new SimpleScope(objects)
		}
	}
		
    def ImportSection getImportSection(EObject object) {
    	if(object===null) null
    	else if(object instanceof OrderedTupleTypeLiteral) object.source
    	else if(object instanceof UnorderedTupleTypeLiteral) object.source
    	else if(object instanceof PatternTypeLiteral) object.source
    	else object.eContainer.importSection;
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
	
	def Pattern getPattern(EObject object) {
		if(object===null) return null
		else if(object instanceof Pattern) object as Pattern
		else object.eContainer.pattern
	}
	
	
	
}
