/*
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.jvmmodel

import com.google.inject.Inject
import edu.ustb.sei.mde.bxcore.Align
import edu.ustb.sei.mde.bxcore.ExpandSource
import edu.ustb.sei.mde.bxcore.ExpandView
import edu.ustb.sei.mde.bxcore.Fork
import edu.ustb.sei.mde.bxcore.GraphReplace
import edu.ustb.sei.mde.bxcore.IndexSignature
import edu.ustb.sei.mde.bxcore.Indexing
import edu.ustb.sei.mde.bxcore.Invocation
import edu.ustb.sei.mde.bxcore.MatchSource
import edu.ustb.sei.mde.bxcore.MatchView
import edu.ustb.sei.mde.bxcore.ParallelComposition
import edu.ustb.sei.mde.bxcore.SourceType
import edu.ustb.sei.mde.bxcore.Switch
import edu.ustb.sei.mde.bxcore.TraceSystem
import edu.ustb.sei.mde.bxcore.ViewType
import edu.ustb.sei.mde.bxcore.XmuCore
import edu.ustb.sei.mde.bxcore.bigul.Replace
import edu.ustb.sei.mde.bxcore.bigul.Skip
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXFunctionDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BiGULReplace
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BiGULSkip
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BiGULStatement
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareCondition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareUnidirectionalAction
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextTypeRef
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DefinedContextTypeRef
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EcoreTypeRef
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection
import edu.ustb.sei.mde.bxcore.dsl.bXCore.IndexDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinitionReference
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternEdge
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNodeRef
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TupleTypeLiteral
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeLiteral
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandSource
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandView
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreFork
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreFunctionCall
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreGraphReplace
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreIndex
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreMatchSource
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreMatchView
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreParallelComposition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreSwitch
import edu.ustb.sei.mde.bxcore.dsl.structure.TupleType
import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException
import edu.ustb.sei.mde.bxcore.exceptions.NothingReturnedException
import edu.ustb.sei.mde.bxcore.structures.Context
import edu.ustb.sei.mde.bxcore.structures.ContextType
import edu.ustb.sei.mde.bxcore.util.EcoreModelUtil
import edu.ustb.sei.mde.graph.pattern.Pattern
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge
import edu.ustb.sei.mde.graph.type.ITypeNode
import edu.ustb.sei.mde.graph.type.TypeGraph
import edu.ustb.sei.mde.graph.type.TypeNode
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph
import edu.ustb.sei.mde.structure.Tuple2
import edu.ustb.sei.mde.structure.Tuple3
import java.util.ArrayList
import java.util.Arrays
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.Set
import java.util.function.BiFunction
import java.util.function.Function
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class BXCoreJvmModelInferrer extends AbstractModelInferrer {

	/**
	 * convenience API to build and initialize JVM types and their members.
	 */
	@Inject extension JvmTypesBuilder
	@Inject extension JvmModelGenerator

	/**
	 * The dispatch method {@code infer} is called for each instance of the
	 * given element's type that is contained in a resource.
	 * 
	 * @param element
	 *            the model to create one or more
	 *            {@link JvmDeclaredType declared
	 *            types} from.
	 * @param acceptor
	 *            each created
	 *            {@link JvmDeclaredType type}
	 *            without a container should be passed to the acceptor in order
	 *            get attached to the current resource. The acceptor's
	 *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
	 *            accept(..)} method takes the constructed empty type for the
	 *            pre-indexing phase. This one is further initialized in the
	 *            indexing phase using the lambda you pass as the last argument.
	 * @param isPreIndexingPhase
	 *            whether the method is called in a pre-indexing phase, i.e.
	 *            when the global index is not yet fully updated. You must not
	 *            rely on linking using the index if isPreIndexingPhase is
	 *            <code>true</code>.
	 */
	def dispatch void infer(BXProgram element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		val sourceURI = element.eResource.URI.trimFileExtension.toJavaClassName;

		acceptor.accept(element.toClass(sourceURI) [
			element.imports.forEach [ i | i.generateImportSection(it);];
			
			members += element.toMethod('execute', ViewType.typeRef) [
				parameters += element.toParameter('bx', XmuCore.typeRef);
				parameters += element.toParameter('graph', TypedGraph.typeRef);
				parameters += element.toParameter('inits', Tuple2.typeRef(String.typeRef, Object.typeRef).addArrayTypeDimension);
				
				exceptions += NothingReturnedException.typeRef;
				
				body = '''
				«Context.typeRef.qualifiedName» sourceContext = bx.getSourceDef().createInstance();
				for(«Tuple2.typeRef(String.typeRef, Object.typeRef).qualifiedName» tuple : inits) {
					sourceContext.setValue(tuple.first, tuple.second);
				}
				return bx.forward(«SourceType.typeRef.qualifiedName».makeSource(graph, sourceContext, new «TraceSystem.typeRef.qualifiedName»()));
				'''
			];
			
			members += element.toMethod('execute', SourceType.typeRef) [
				parameters += element.toParameter('bx', XmuCore.typeRef);
				parameters += element.toParameter('source', TypedGraph.typeRef);
				parameters += element.toParameter('sourceInits', Tuple2.typeRef(String.typeRef, Object.typeRef).addArrayTypeDimension);
				parameters += element.toParameter('view', TypedGraph.typeRef);
				parameters += element.toParameter('viewInits', Tuple2.typeRef(String.typeRef, Object.typeRef).addArrayTypeDimension);
				
				exceptions += NothingReturnedException.typeRef;
				
				body = '''
				«Context.typeRef.qualifiedName» sourceContext = bx.getSourceDef().createInstance();
				for(«Tuple2.typeRef(String.typeRef, Object.typeRef).qualifiedName» tuple : sourceInits) {
					sourceContext.setValue(tuple.first, tuple.second);
				}
				«Context.typeRef.qualifiedName» viewContext = bx.getViewDef().createInstance();
				for(«Tuple2.typeRef(String.typeRef, Object.typeRef).qualifiedName» tuple : viewInits) {
					viewContext.setValue(tuple.first, tuple.second);
				}
				
				return bx.backward(«SourceType.typeRef.qualifiedName».makeSource(source, sourceContext, new «TraceSystem.typeRef.qualifiedName»()), «ViewType.typeRef.qualifiedName».makeView(view, viewContext));
				'''
			];
			
			val conditions = element.eAllContents.filter[e| e instanceof ContextAwareCondition].map[it as ContextAwareCondition].toList;
			conditions.forEach[cond, id| cond.generateCondition(id, it)];
			
			val actions = element.eAllContents.filter[e| e instanceof ContextAwareUnidirectionalAction].map[it as ContextAwareUnidirectionalAction].toList;
			actions.forEach[act, id|act.generateAction(id, it)];
			
			val statements = element.eAllContents.filter[it instanceof XmuCoreStatement].map[it as XmuCoreStatement].indexed.toList;
			
			val typeLiteralMap = element.groupTypeLiterals;
			typeLiteralMap.values.toSet.forEach[pair|generateTypeLiteral(it, pair.first, pair.second, element);];
			
			val patternLiterals = element.eAllContents.filter[it instanceof PatternTypeLiteral].map[it as PatternTypeLiteral].indexed.toList;
			patternLiterals.forEach[p|generatePatternLiteral(it, p.value, p.key, typeLiteralMap, element);];
			
			element.definitions.forEach [ def |
				if (def instanceof TypeDefinition) {
					generateTypeDefinition(it, def, typeLiteralMap, patternLiterals, element);
				} else if(def instanceof IndexDefinition) {
					members += def.toField('index_'+def.name, IndexSignature.typeRef) [
						visibility = JvmVisibility.PRIVATE
					];
					
					members += def.toMethod('getIndex_'+def.name.toFirstUpper, IndexSignature.typeRef) [
						visibility = JvmVisibility.PUBLIC;
						body='''
						if(index_«def.name»==null) {
							index_«def.name» = new «IndexSignature.typeRef.qualifiedName»("«(def as IndexDefinition).name»", «(def as IndexDefinition).sourceType.typeAccessor(typeLiteralMap)», «(def as IndexDefinition).viewType.typeAccessor(typeLiteralMap)»);
						}
						return index_«def.name»;
						'''
					];
					
				} else if(def instanceof BXFunctionDefinition) {
					members += def.toField('xmu_'+def.name, XmuCore.typeRef)[
						visibility = JvmVisibility.PRIVATE
					];
					
					members += def.toMethod('getXmu_'+def.name.toFirstUpper, XmuCore.typeRef) [
						visibility = JvmVisibility.PUBLIC;
						exceptions += BidirectionalTransformationDefinitionException.typeRef;
						
						body=[appendable|
							appendable
								.append('''if(xmu_«def.name»==null) {''').newLine
								.append('''xmu_«def.name» = ''')
								.generateXmuCode((def as BXFunctionDefinition).statement, statements, typeLiteralMap, patternLiterals, conditions, actions, element).append(';').newLine
								.append('}').newLine
								.append('''return xmu_«def.name»;''')
						]
					]
				}
			];
		]);
	}
		
	protected def generatePatternLiteral(JvmGenericType owner, PatternTypeLiteral literal, Integer id, Map<EObject, Tuple2<TupleType, Integer>> typeLiteralMap, BXProgram program) {
		owner.members += literal.toField('pattern_' + id, Pattern.typeRef) [
			visibility = JvmVisibility.PRIVATE;
		];
		
		val nodes = literal.eAllContents.filter[it instanceof PatternNode].map[it as PatternNode].toList;
		val edges = literal.eAllContents.filter[it instanceof PatternEdge].map[it as PatternEdge].toList;
		val typeGraph = literal.source;
		val patternTypeId = typeLiteralMap.get(literal).second;
		
		owner.members += literal.toMethod('getPattern_'+id, Pattern.typeRef)[
			visibility = JvmVisibility.PUBLIC;
			body = '''
				if(pattern_«id»==null) {
					«TypeGraph.typeRef.qualifiedName» typeGraph = getTypeGraph_«typeGraph.shortName.toFirstUpper»();
					pattern_«id» = new «Pattern.typeRef.qualifiedName»(typeGraph);
					«FOR node : nodes»
						«ITypeNode.typeRef.qualifiedName» «node.name»_type = typeGraph.«IF node.type instanceof EClass»getTypeNode«ELSE»getDataTypeNode«ENDIF»("«node.type.name»");
						pattern_«id».appendPatternNode("«node.name»", «node.name»_type);
					«ENDFOR»
					«FOR edge : edges»
						«val tarNode = if(edge.value instanceof PatternNode) edge.value as PatternNode else if(edge.value instanceof PatternNodeRef) (edge.value as PatternNodeRef).node else null»
						«val edgeName = if(edge.name!==null) edge.name else ((edge.eContainer as PatternNode).name+'_'+edge.feature.name+'_'+(if(tarNode!==null) tarNode.name else '?'))»
						«IStructuralFeatureEdge.typeRef.qualifiedName» «edgeName»_type = typeGraph.«IF edge.feature instanceof EReference»getTypeEdge«ELSE»getPropertyEdge«ENDIF»((«TypeNode.typeRef.qualifiedName») «(edge.eContainer as PatternNode).name»_type,"«edge.feature.name»");
						pattern_«id».appendPatternEdge("«edgeName»", "«(edge.eContainer as PatternNode).name»", "«tarNode.name»", «edgeName»_type);
					«ENDFOR»
					
					pattern_«id».setType(getType_«patternTypeId»());
				}
				return pattern_«id»;
			'''
		]
	}
	
	protected def void generateAction(ContextAwareUnidirectionalAction act, Integer id, JvmGenericType type) {
		type.members += act.toClass('UnidirectionalAction'+id)[
			superTypes += BiFunction.typeRef(SourceType.typeRef, ViewType.typeRef, SourceType.typeRef);
			members += act.toMethod('apply', SourceType.typeRef) [
				parameters += act.toParameter('source', SourceType.typeRef);
				parameters += act.toParameter('view', ViewType.typeRef);
				body = act.action;
			]
			 
		]
	}
	
	protected def void generateCondition(ContextAwareCondition cond, Integer id, JvmGenericType type) {
		type.members += cond.toClass('Condition'+id)[
			if (cond.eContainer instanceof XmuCoreAlign) {
				superTypes += BiFunction.typeRef(Context.typeRef, Context.typeRef, Boolean.typeRef);
				members += cond.toMethod('apply', Boolean.typeRef) [
					parameters += cond.toParameter('source', Context.typeRef);
					parameters += cond.toParameter('view', Context.typeRef);
					body = cond.condition;
				]
			} else {
				superTypes += BiFunction.typeRef(SourceType.typeRef, ViewType.typeRef, Boolean.typeRef);
				members += cond.toMethod('apply', Boolean.typeRef) [
					parameters += cond.toParameter('source', SourceType.typeRef);
					parameters += cond.toParameter('view', ViewType.typeRef);
					body = cond.condition;
				]
			}
		]
	}
	
	protected def void generateImportSection(ImportSection i, JvmGenericType type) {
		type.members += i.toField('typeGraph_' + i.shortName, TypeGraph.typeRef) [
			visibility = JvmVisibility.PRIVATE
		];
		type.members += i.toMethod('getTypeGraph_' + i.shortName.toFirstUpper, TypeGraph.typeRef) [
			visibility = JvmVisibility.PUBLIC;
			
			val eClasses = i.metamodel.eAllContents.filter[o | o instanceof EClass || o instanceof EReference].map[o| if(o instanceof EClass) o as EClass else (o as EReference).EReferenceType].toSet;
			val eDataTypes = i.metamodel.eAllContents.filter[o | o instanceof EDataType || o instanceof EAttribute].map[o| if(o instanceof EDataType) o as EDataType else (o as EAttribute).EAttributeType].toSet;
			val eReferences = i.metamodel.eAllContents.filter[o | o instanceof EReference].map[it as EReference].toSet;
			val eAttributes = i.metamodel.eAllContents.filter[o | o instanceof EAttribute].map[it as EAttribute].toSet;
			
			val ordered = <EClass>newArrayList;
			
			for(o : eClasses) {
				insertInOrder(ordered, o, eClasses);
			}
			
			body = '''
				if(typeGraph_«i.shortName»==null) {
					typeGraph_«i.shortName» = new «TypeGraph.typeRef.qualifiedName»();
					«FOR t : ordered»
						typeGraph_«i.shortName».declare("«IF t.abstract»@«ENDIF»«t.name»«FOR s : t.ESuperTypes»«IF eClasses.contains(s)»,«s.name»«ENDIF»«ENDFOR»");
					«ENDFOR»
					«FOR d : eDataTypes»
						«IF d instanceof EEnum»
							typeGraph_«i.shortName».declare("«d.name»:java.lang.String");
						«ELSE»
							typeGraph_«i.shortName».declare("«d.name»:«d.instanceClass.typeRef.qualifiedName»");
						«ENDIF»
					«ENDFOR»
					«FOR a : eAttributes»
						typeGraph_«i.shortName».declare("«a.name»:«(a.eContainer as EClass).name»->«a.EAttributeType.name»«IF a.many»«IF a.unique»*«ELSE»#«ENDIF»«ENDIF»");
					«ENDFOR»
					«FOR a : eReferences»
						typeGraph_«i.shortName».declare("«IF a.isContainment»@«ENDIF»«a.name»:«(a.eContainer as EClass).name»->«a.EReferenceType.name»«IF a.many»«IF a.unique»*«ELSE»#«ENDIF»«ENDIF»");
					«ENDFOR»
				}
				return typeGraph_«i.shortName»;
			'''
		];
		
		type.members += i.toMethod('''load«i.shortName.toFirstUpper»Model''', TypedGraph.typeRef) [
			parameters += i.toParameter('modelUri', URI.typeRef);
			parameters += i.toParameter('metamodelUri', URI.typeRef);
			body = '''
				«EPackage.typeRef.qualifiedName» pack = «EcoreModelUtil.typeRef.qualifiedName».loadPacakge(metamodelUri);
				«EObject.typeRef.qualifiedName» root = «EcoreModelUtil.typeRef.qualifiedName».load(modelUri);
				«TypedGraph.typeRef.qualifiedName» graph = «EcoreModelUtil.typeRef.qualifiedName».load(root, getTypeGraph_«i.shortName.toFirstUpper»());
				return graph;
			'''
		]
	}
		
	protected def String toJavaClassName(URI uri) {
		val root = ResourcesPlugin.getWorkspace().getRoot();
		val java = JavaCore.create(root);
		val projects = java.javaProjects;
		
		val srcFolders = new ArrayList;
		
		projects.forEach[p|
			p.allPackageFragmentRoots.forEach[r|
				val path = ((if(uri.scheme===null) '/' else (uri.scheme +':/'+uri.segment(0)+'/')) + p.elementName + '/' + r.elementName)+'/'
				srcFolders.add(path);
			]
		];
		
		val filePath = uri.toString;
		
		val matched = srcFolders.findFirst[f|filePath.startsWith(f)];
		
		if(matched===null) return uri.lastSegment
		else filePath.substring(matched.length).replace('/', '.');
		
	}
		
	def void insertInOrder(ArrayList<EClass> objects, EClass o, Set<EClass> classes) {
		if(objects.contains(o)) return
		else {
			if(!classes.contains(o)) return;
			for(EClass c : o.ESuperTypes) insertInOrder(objects, c, classes);
			objects.add(o);
		}
	}
	
	def ITreeAppendable generateXmuCode(ITreeAppendable appendable, XmuCoreStatement statement, List<Pair<Integer, XmuCoreStatement>> indexedStatements, Map<EObject, Tuple2<TupleType, Integer>> typeLiteralMap, List<Pair<Integer, PatternTypeLiteral>> patternLiterals, List<ContextAwareCondition> conditions, List<ContextAwareUnidirectionalAction> actions, BXProgram program) {
		val key = 'xmu'+indexedStatements.findFirst[it.value===statement].key
		
		switch statement {
			XmuCoreMatchSource : {
				val srcType = (statement as XmuCoreMatchSource).sourceType.typeAccessor(typeLiteralMap);
				val pattern = (statement as XmuCoreMatchSource).pattern;
				val body = (statement as XmuCoreMatchSource).body;
				return appendable.append('''new «MatchSource.typeRef.qualifiedName»("«key»", «srcType», «pattern.patternAccessor(patternLiterals)»,''')
					.newLine.increaseIndentation
					.generateXmuCode(body, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program)
					.newLine.decreaseIndentation.append(')')
			}
			XmuCoreMatchView : {
				val viwType = (statement as XmuCoreMatchView).viewType.typeAccessor(typeLiteralMap);
				val pattern = (statement as XmuCoreMatchView).pattern;
				val body = (statement as XmuCoreMatchView).body;
				return appendable.append('''new «MatchView.typeRef.qualifiedName»("«key»", «viwType», «pattern.patternAccessor(patternLiterals)»,''')
					.newLine.increaseIndentation
					.generateXmuCode(body, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program)
					.newLine.decreaseIndentation.append(')')
			}
			XmuCoreExpandSource : {
				val pattern = (statement as XmuCoreExpandSource).pattern;
				val valMappings =  (statement as XmuCoreExpandSource).mappings;
				val body =  (statement as XmuCoreExpandSource).body;
				
				return appendable.append('''new «ExpandSource.typeRef.qualifiedName»("«key»", «pattern.patternAccessor(patternLiterals)», ''')
					.newLine.increaseIndentation
					.generateXmuCode(body, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program).append(''',''')
					.newLine.append('''new «Tuple2.typeRef.qualifiedName»[] {«FOR mapping : valMappings SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«mapping.from»", "«mapping.to»")«ENDFOR»}''')
					.newLine.decreaseIndentation.append(")")
			}
			XmuCoreExpandView : {
				val pattern = (statement as XmuCoreExpandView).pattern;
				val valMappings =  (statement as XmuCoreExpandView).mappings;
				val body =  (statement as XmuCoreExpandView).body;
				
				return appendable.append('''new «ExpandView.typeRef.qualifiedName»("«key»", «pattern.patternAccessor(patternLiterals)», ''')
					.newLine.increaseIndentation
					.generateXmuCode(body, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program).append(''',''')
					.newLine.append('''new «Tuple2.typeRef.qualifiedName»[] {«FOR mapping : valMappings SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«mapping.from»", "«mapping.to»")«ENDFOR»}''')
					.newLine.decreaseIndentation.append(")")
			}
			XmuCoreParallelComposition : {
				val srcType = (statement as XmuCoreParallelComposition).sourceType.typeAccessor(typeLiteralMap);
				val viwType = (statement as XmuCoreParallelComposition).viewType.typeAccessor(typeLiteralMap);
				val bodies = (statement as XmuCoreParallelComposition).bodies;
				var scope = appendable.append('''new «ParallelComposition.typeRef.qualifiedName»("«key»", «srcType», «viwType», new «XmuCore.typeRef.qualifiedName»[] {''')
					.newLine.increaseIndentation;
				for(b : bodies) {
					scope = (if(bodies.indexOf(b)!==0) scope.append(',').newLine else scope).generateXmuCode(b, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program);
				}
				return scope.newLine.decreaseIndentation.append("})")
			}
			XmuCoreFork : {
				val srcType = (statement as XmuCoreFork).sourceType.typeAccessor(typeLiteralMap);
				val viwType = (statement as XmuCoreFork).viewType.typeAccessor(typeLiteralMap);
				val forks = (statement as XmuCoreFork).forks;
				var scope = appendable.append('''new «Fork.typeRef.qualifiedName»("«key»", «srcType», «viwType», new «Tuple3.typeRef.qualifiedName»[] {''')
					.newLine.increaseIndentation;
				for(f : forks) {
					scope = (if(forks.indexOf(f)!==0) scope.append(',').newLine else scope)
						.append('''«Tuple3.typeRef.qualifiedName».make(''')
						.append('''new «Tuple2.typeRef.qualifiedName»[] {«FOR m : f.sourceMappings SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«m.from»","«m.to»")«ENDFOR»}, ''')
						.append('''new «Tuple2.typeRef.qualifiedName»[] {«FOR m : f.viewMappings SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«m.from»","«m.to»")«ENDFOR»}, ''')
						.generateXmuCode(f.body, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program).append(')');
				}
				return scope.newLine.decreaseIndentation.append("})")
			}
			XmuCoreSwitch: {
				val srcType = (statement as XmuCoreSwitch).sourceType.typeAccessor(typeLiteralMap);
				val viwType = (statement as XmuCoreSwitch).viewType.typeAccessor(typeLiteralMap);
				val branches = (statement as XmuCoreSwitch).branches;
				val adaptions = (statement as XmuCoreSwitch).adaptions;
								
				var scope = appendable.append('''new «Switch.typeRef.qualifiedName»("«key»", «srcType», «viwType», ''')
					.newLine.increaseIndentation;
			
				scope = scope.append('''«Arrays.typeRef.qualifiedName».asList(''').newLine.increaseIndentation;
				for(b : branches) {
					if(branches.get(0)!==b) scope = scope.append(', ');
					scope = scope.append('''«Tuple3.typeRef.qualifiedName».make(new Condition«conditions.indexOf(b.condition)»(), ''').newLine.increaseIndentation
							.generateXmuCode(b.action, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program).append(''', («Function.typeRef(SourceType.typeRef, Boolean.typeRef).qualifiedName») null)''').newLine.decreaseIndentation;
				}
				scope = scope.append('),').newLine.decreaseIndentation
					.append('''«Arrays.typeRef.qualifiedName».asList(''');
				for(a : adaptions) {
					if(adaptions.get(0)!==a) scope = scope.append(', ');
					scope = scope.append('''«Tuple2.typeRef.qualifiedName».make(new Condition«conditions.indexOf(a.condition)»(), ''').newLine.increaseIndentation
							.append('''new UnidirectionalAction«actions.indexOf(a.action)»())''').newLine.decreaseIndentation;
				}
				scope = scope.append('))').newLine.decreaseIndentation;
				return scope;
				
			}
			XmuCoreGraphReplace : {
				val srcPat = (statement as XmuCoreGraphReplace).source.patternAccessor(patternLiterals);
				val viwPat = (statement as XmuCoreGraphReplace).view.patternAccessor(patternLiterals);
				val conversions = (statement as XmuCoreGraphReplace).conversions;
				appendable.append('''new «GraphReplace.typeRef.qualifiedName»("«key»", «srcPat», «viwPat», new «Tuple3.typeRef.qualifiedName»[]{«FOR conv : conversions SEPARATOR ','»«Tuple3.typeRef.qualifiedName».make(new String[]{«FOR sk : conv.source SEPARATOR ','»"«sk»"«ENDFOR»}, new String[]{«FOR vk : conv.view SEPARATOR ','»"«vk»"«ENDFOR»}, «conv.bigul.generateBiGuLCode»)«ENDFOR»})''').newLine
			}
			XmuCoreAlign : {
				val srcType = (statement as XmuCoreAlign).sourceType.typeAccessor(typeLiteralMap);
				val viwType = (statement as XmuCoreAlign).viewType.typeAccessor(typeLiteralMap);
				val srcPat = (statement as XmuCoreAlign).sourcePattern.patternAccessor(patternLiterals);
				val viwPat = (statement as XmuCoreAlign).viewPattern.patternAccessor(patternLiterals);
				val cond = (statement as XmuCoreAlign).alignment;
				val match = (statement as XmuCoreAlign).match;
				val unmatchS = (statement as XmuCoreAlign).unmatchS;
				val unmatchV = (statement as XmuCoreAlign).unmatchV;
				
				appendable.append('''new «Align.typeRef.qualifiedName»("«key»", «srcType», «viwType», «srcPat», «viwPat», new Condition«conditions.indexOf(cond)»(), ''').newLine.increaseIndentation
					.generateXmuCode(match, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program)
					.append(''', new UnidirectionalAction«actions.indexOf(unmatchS)»(), new UnidirectionalAction«actions.indexOf(unmatchV)»())''')
			}
			XmuCoreFunctionCall : {
				val st = (statement as XmuCoreFunctionCall).target.sourceType.typeAccessor(typeLiteralMap);
				val vt = (statement as XmuCoreFunctionCall).target.viewType.typeAccessor(typeLiteralMap);
				val sk = (statement as XmuCoreFunctionCall).sourceMappings;
				val vk = (statement as XmuCoreFunctionCall).viewMappings;
				appendable.append('''new «Invocation.typeRef.qualifiedName»("«key»", «st», «vt», new «Tuple2.typeRef.qualifiedName»[]{«FOR m:sk SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«m.from»","«m.to»")«ENDFOR»}, new «Tuple2.typeRef.qualifiedName»[]{«FOR m:vk SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«m.from»","«m.to»")«ENDFOR»},()->{try {return getXmu_«(statement as XmuCoreFunctionCall).target.name.toFirstUpper»();} catch(Exception e){return null;}})''')
			}
			XmuCoreIndex : {
				val parts = (statement as XmuCoreIndex).parts;
				val body = (statement as XmuCoreIndex).body;
				
				var scope = appendable.append('''«FOR part : parts»new «Indexing.typeRef.qualifiedName»(getIndex_«part.signature.name.toFirstUpper»(), new String[]{«FOR sk:part.sourceKeys SEPARATOR ','»"«sk»"«ENDFOR»}, new String[]{«FOR vk:part.viewKeys SEPARATOR ','»"«vk»"«ENDFOR»}, «ENDFOR»''');
				scope = scope.generateXmuCode(body, indexedStatements, typeLiteralMap, patternLiterals, conditions, actions, program);
				return scope.append('''«FOR part:parts»)«ENDFOR»''')
			}
			default:
				appendable.append('''/* undefined */''')
		}
	}
		
	def CharSequence generateBiGuLCode(BiGULStatement statement) {
		switch statement {
			BiGULReplace : '''new «Replace.typeRef(Object.typeRef.addArrayTypeDimension).qualifiedName»()'''
			BiGULSkip : '''new «Skip.typeRef(Object.typeRef.addArrayTypeDimension).qualifiedName»()'''
		}
	}
	
	protected def CharSequence patternAccessor(edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern pattern, List<Pair<Integer, PatternTypeLiteral>> pairs) {
		if(pattern instanceof PatternTypeLiteral) 'getPattern_'+pairs.findFirst[p|p.value===pattern].key+'()'
		else (pattern as PatternDefinitionReference).pattern.name+'()'
	}
	
	protected def CharSequence typeAccessor(Pattern pat, Map<EObject, Pair<TupleType, Integer>> typeLiteralMap) {
		if(pat instanceof PatternTypeLiteral) {
			'''getType_«typeLiteralMap.get(pat).value»()'''
		} else {// for a named pattern, we may use its type function
			'''getType_«(pat as PatternDefinitionReference).pattern.name.toFirstUpper»()'''
		}
	}
	
	protected def CharSequence typeAccessor(ContextTypeRef type, Map<EObject, Tuple2<TupleType, Integer>> typeLiteralMap) {
		if(type instanceof DefinedContextTypeRef) {
			'''getType_«type.type.name.toFirstUpper»()'''
		} else if(type instanceof TupleTypeLiteral) {
			'''getType_«typeLiteralMap.get(type).second»()'''
		}
	}
	
	protected def generateTypeLiteral(JvmGenericType owner, TupleType tuple, int id, BXProgram program) {
		owner.members += program.toField('type_' + id, ContextType.typeRef) [
			visibility = JvmVisibility.PRIVATE
		];
		
		val typeGraph =tuple.importSection;
		
		owner.members += program.toMethod('getType_' + id, ContextType.typeRef) [
			visibility = JvmVisibility.PUBLIC;
			val elements = tuple.tuples;
		
			body = '''
				if(type_«id»==null) {
					«IF elements.empty»
						type_«id» = «ContextType.typeRef.qualifiedName».EMPTY_TYPE;
					«ELSE»
						«TypeGraph.typeRef.qualifiedName» typeGraph = getTypeGraph_«typeGraph.shortName.toFirstUpper»();
						type_«id» = new «ContextType.typeRef.qualifiedName»();
						«FOR v : elements»
						Object «v.first»_type = typeGraph.«IF v.second instanceof EClassifier»«IF v.second instanceof EClass»getTypeNode«ELSE»getDataTypeNode«ENDIF»("«(v.second as EClassifier).name»")«ELSEIF v.second instanceof EStructuralFeature»«IF v.second instanceof EReference»getTypeEdge«ELSE»getPropertyEdge«ENDIF»(typeGraph.getTypeNode("«(v.second as EStructuralFeature).EContainingClass.name»"),"«(v.second as EStructuralFeature).name»")«ELSE»/* ERROR «v.second» */«ENDIF»;
						type_«id».addField("«v.first»", «v.first»_type);
					«ENDFOR»
					«ENDIF»
				}
				return type_«id»;
			'''
		
		]
	}
	
	protected def void generateTypeDefinition(JvmGenericType owner, TypeDefinition typeDef, Map<EObject, Tuple2<TupleType, Integer>> typeLiteralMap, List<Pair<Integer, PatternTypeLiteral>> patternLiterals, BXProgram program) {
		val literal = typeDef.literal;
		owner.members += typeDef.toMethod('getType_' + typeDef.name.toFirstUpper, ContextType.typeRef) [
			visibility = JvmVisibility.PUBLIC;
			body = '''return getType_«typeLiteralMap.get(literal).second»();'''
		];
		
		if(typeDef.literal instanceof PatternTypeLiteral) {
			owner.members += typeDef.toMethod(typeDef.name, Pattern.typeRef) [
				body = '''return getPattern_«patternLiterals.findFirst[it.value===typeDef.literal].key»();'''
			];
		}
	}
	
	protected def groupTypeLiterals(BXProgram program) {
		val literals = program.eAllContents.filter[e|e instanceof TypeLiteral].map[return it->TupleType.make(it as TypeLiteral)].toList;
		val groups = literals.groupBy[it.value];
		val result = new HashMap;
		
		groups.forEach[k,v,id|
			val pair = Tuple2.make(k,id);
			v.forEach[p|result.put(p.key, pair);];
		];
		
		return result;
	}
}
