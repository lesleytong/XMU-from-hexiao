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
import edu.ustb.sei.mde.bxcore.dsl.bXCore.FeatureTypeRef
import edu.ustb.sei.mde.bxcore.dsl.bXCore.IndexDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinition
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinitionReference
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternEdge
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNodeRef
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PrimitiveTypeRef
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeDefinition
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
import edu.ustb.sei.mde.bxcore.exceptions.BidirectionalTransformationDefinitionException
import edu.ustb.sei.mde.bxcore.structures.Context
import edu.ustb.sei.mde.bxcore.structures.ContextType
import edu.ustb.sei.mde.graph.pattern.Pattern
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge
import edu.ustb.sei.mde.graph.type.ITypeNode
import edu.ustb.sei.mde.graph.type.TypeGraph
import edu.ustb.sei.mde.graph.type.TypeNode
import edu.ustb.sei.mde.structure.Tuple2
import edu.ustb.sei.mde.structure.Tuple3
import java.util.ArrayList
import java.util.Arrays
import java.util.List
import java.util.Set
import java.util.function.BiFunction
import java.util.function.Function
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EReference
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend2.lib.StringConcatenationClient
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
			element.imports.forEach [ i |
				members += i.toField('typeGraph_' + i.shortName, TypeGraph.typeRef) [
					visibility = JvmVisibility.PRIVATE
				];
				members += i.toMethod('getTypeGraph_' + i.shortName.toFirstUpper, TypeGraph.typeRef) [
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
								typeGraph_«i.shortName».declare("«a.name»:«(a.eContainer as EClass).name»->«a.EReferenceType.name»«IF a.many»«IF a.unique»*«ELSE»#«ENDIF»«ENDIF»");
							«ENDFOR»
						}
						return typeGraph_«i.shortName»;
					'''
				];
			];
			
			val conditions = element.eAllContents.filter[e| e instanceof ContextAwareCondition].map[it as ContextAwareCondition].toList;
			
			conditions.forEach[cond, id|
//				val context = cond.computeContext;
				members += cond.toClass('Condition'+id)[
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
				];

			];
			
			val actions = element.eAllContents.filter[e| e instanceof ContextAwareUnidirectionalAction].map[it as ContextAwareUnidirectionalAction].toList;
			actions.forEach[act, id|
				members += act.toClass('UnidirectionalAction'+id)[
					superTypes += BiFunction.typeRef(SourceType.typeRef, ViewType.typeRef, SourceType.typeRef);
					members += act.toMethod('apply', SourceType.typeRef) [
						parameters += act.toParameter('source', SourceType.typeRef);
						parameters += act.toParameter('view', ViewType.typeRef);
						body = act.action;
					]
					 
				];
			];
			
			val statements = element.eAllContents.filter[it instanceof XmuCoreStatement].map[it as XmuCoreStatement].indexed.toList;

			element.definitions.forEach [ def |
				if (def instanceof TypeDefinition) {
					generateTypeDefinition(it, def, element);
				} else if (def instanceof PatternDefinition) {
					generatePatternDefinition(it, def, element);
				} else if(def instanceof IndexDefinition) {
					members += def.toField('index_'+def.name, IndexSignature.typeRef) [
						visibility = JvmVisibility.PRIVATE
					];
					
					members += def.toMethod('getIndex_'+def.name.toFirstUpper, IndexSignature.typeRef) [
						visibility = JvmVisibility.PUBLIC;
						body='''
						if(index_«def.name»==null) {
							index_«def.name» = new «IndexSignature.typeRef.qualifiedName»("«(def as IndexDefinition).name»", «(def as IndexDefinition).sourceType.typeAccessor», «(def as IndexDefinition).viewType.typeAccessor»);
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
						
						val privatePatterns = def.eAllContents.filter[e| e instanceof PatternDefinition].map[it as PatternDefinition].indexed.toList;
						
						body=[appendable|
							appendable
								.append('''if(xmu_«def.name»==null) {''').newLine
								.append('''
								«FOR Pair<Integer, PatternDefinition> pair : privatePatterns»
								«Pattern.typeRef.qualifiedName» pattern__internal«pair.key»;
								{
									«pair.value.generatePatternConstructionCode('_internal'+pair.key, element)»
								}
								«IF pair.value.type!==null && !element.definitions.exists[d| d instanceof TypeDefinition && d.name.equals(pair.value.type)]»
								«ContextType.typeRef.qualifiedName» type__internal«pair.value.type.toFirstUpper» = pattern__internal«pair.key».getType();
								«ENDIF»
								«ENDFOR»
								
								''')
								.append('''xmu_«def.name» = ''')
								.generateXmuCode((def as BXFunctionDefinition).statement, statements, privatePatterns, conditions, actions, element).append(';').newLine
								.append('}').newLine
								.append('''return xmu_«def.name»;''')
						]
					]
				}
			];
		]);
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
		
//	def computeContext(ContextAwareCondition condition) {
//		val container = condition.eContainer;
//		if(container instanceof XmuCoreSwitchBranch || container instanceof XmuCoreSwitchAdaption) {
//			val switchStmt = container.eContainer as XmuCoreSwitch;
//			val sourceType = switchStmt.sourceType;
//			val viewType = switchStmt.viewType;
//			
//			
//		} else  {
//			
//		}
//	}
	
	def ITreeAppendable generateXmuCode(ITreeAppendable appendable, XmuCoreStatement statement, List<Pair<Integer, XmuCoreStatement>> indexed, List<Pair<Integer, PatternDefinition>> pairs, List<ContextAwareCondition> conditions, List<ContextAwareUnidirectionalAction> actions, BXProgram program) {
		val key = 'xmu'+indexed.findFirst[it.value===statement].key
		
		switch statement {
			XmuCoreMatchSource : {
				val srcType = (statement as XmuCoreMatchSource).sourceType.typeAccessor;
				val pattern = (statement as XmuCoreMatchSource).pattern;
				val body = (statement as XmuCoreMatchSource).body;
				return appendable.append('''new «MatchSource.typeRef.qualifiedName»("«key»", «srcType», «pattern.patternAccessor(pairs)»,''')
					.newLine.increaseIndentation
					.generateXmuCode(body, indexed, pairs, conditions, actions, program)
					.newLine.decreaseIndentation.append(')')
			}
			XmuCoreMatchView : {
				val viwType = (statement as XmuCoreMatchView).viewType.typeAccessor;
				val pattern = (statement as XmuCoreMatchView).pattern;
				val body = (statement as XmuCoreMatchView).body;
				return appendable.append('''new «MatchView.typeRef.qualifiedName»("«key»", «viwType», «pattern.patternAccessor(pairs)»,''')
					.newLine.increaseIndentation
					.generateXmuCode(body, indexed, pairs, conditions, actions, program)
					.newLine.decreaseIndentation.append(')')
			}
			XmuCoreExpandSource : {
				val pattern = (statement as XmuCoreExpandSource).pattern;
				val valMappings =  (statement as XmuCoreExpandSource).mappings;
				val body =  (statement as XmuCoreExpandSource).body;
				
				return appendable.append('''new «ExpandSource.typeRef.qualifiedName»("«key»", «pattern.patternAccessor(pairs)», ''')
					.newLine.increaseIndentation
					.generateXmuCode(body, indexed, pairs, conditions, actions, program).append(''',''')
					.newLine.append('''new «Tuple2.typeRef.qualifiedName»[] {«FOR mapping : valMappings SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«mapping.from»", "«mapping.to»")«ENDFOR»}''')
					.newLine.decreaseIndentation.append(")")
			}
			XmuCoreExpandView : {
				val pattern = (statement as XmuCoreExpandView).pattern;
				val valMappings =  (statement as XmuCoreExpandView).mappings;
				val body =  (statement as XmuCoreExpandView).body;
				
				return appendable.append('''new «ExpandView.typeRef.qualifiedName»("«key»", «pattern.patternAccessor(pairs)», ''')
					.newLine.increaseIndentation
					.generateXmuCode(body, indexed, pairs, conditions, actions, program).append(''',''')
					.newLine.append('''new «Tuple2.typeRef.qualifiedName»[] {«FOR mapping : valMappings SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«mapping.from»", "«mapping.to»")«ENDFOR»}''')
					.newLine.decreaseIndentation.append(")")
			}
			XmuCoreParallelComposition : {
				val srcType = (statement as XmuCoreParallelComposition).sourceType.typeAccessor;
				val viwType = (statement as XmuCoreParallelComposition).viewType.typeAccessor;
				val bodies = (statement as XmuCoreParallelComposition).bodies;
				var scope = appendable.append('''new «ParallelComposition.typeRef.qualifiedName»("«key»", «srcType», «viwType», new «XmuCore.typeRef.qualifiedName»[] {''')
					.newLine.increaseIndentation;
				for(b : bodies) {
					scope = (if(bodies.indexOf(b)!==0) scope.append(',').newLine else scope).generateXmuCode(b, indexed, pairs, conditions, actions, program);
				}
				return scope.newLine.decreaseIndentation.append("})")
			}
			XmuCoreFork : {
				val srcType = (statement as XmuCoreFork).sourceType.typeAccessor;
				val viwType = (statement as XmuCoreFork).viewType.typeAccessor;
				val forks = (statement as XmuCoreFork).forks;
				var scope = appendable.append('''new «Fork.typeRef.qualifiedName»("«key»", «srcType», «viwType», new «Tuple3.typeRef.qualifiedName»[] {''')
					.newLine.increaseIndentation;
				for(f : forks) {
					scope = (if(forks.indexOf(f)!==0) scope.append(',').newLine else scope)
						.append('''«Tuple3.typeRef.qualifiedName».make(''')
						.append('''new «Tuple2.typeRef.qualifiedName»[] {«FOR m : f.sourceMappings SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«m.from»","«m.to»")«ENDFOR»}, ''')
						.append('''new «Tuple2.typeRef.qualifiedName»[] {«FOR m : f.viewMappings SEPARATOR ','»«Tuple2.typeRef.qualifiedName».make("«m.from»","«m.to»")«ENDFOR»}, ''')
						.generateXmuCode(f.body, indexed, pairs, conditions, actions, program).append(')');
				}
				return scope.newLine.decreaseIndentation.append("})")
			}
			XmuCoreSwitch: {
				val srcType = (statement as XmuCoreSwitch).sourceType.typeAccessor;
				val viwType = (statement as XmuCoreSwitch).viewType.typeAccessor;
				val branches = (statement as XmuCoreSwitch).branches;
				val adaptions = (statement as XmuCoreSwitch).adaptions;
				
				//Tuple3<BiFunction<SourceType,ViewType,Boolean>,XmuCore,Function<SourceType,Boolean>
//				val branchType = Tuple3.typeRef(BiFunction.typeRef(SourceType.typeRef, ViewType.typeRef, Boolean.typeRef), XmuCore.typeRef, Function.typeRef(SourceType.typeRef, Boolean.typeRef));
				
				var scope = appendable.append('''new «Switch.typeRef.qualifiedName»("«key»", «srcType», «viwType», ''')
					.newLine.increaseIndentation;
			
				scope = scope.append('''«Arrays.typeRef.qualifiedName».asList(''').newLine.increaseIndentation;
				for(b : branches) {
					if(branches.get(0)!==b) scope = scope.append(', ');
					scope = scope.append('''«Tuple3.typeRef.qualifiedName».make(new Condition«conditions.indexOf(b.condition)»(), ''').newLine.increaseIndentation
							.generateXmuCode(b.action, indexed, pairs, conditions, actions, program).append(''', («Function.typeRef(SourceType.typeRef, Boolean.typeRef).qualifiedName») null)''').newLine.decreaseIndentation;
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
				val srcPat = (statement as XmuCoreGraphReplace).source.patternAccessor(pairs);
				val viwPat = (statement as XmuCoreGraphReplace).view.patternAccessor(pairs);
				val conversions = (statement as XmuCoreGraphReplace).conversions;
				appendable.append('''new «GraphReplace.typeRef.qualifiedName»("«key»", «srcPat», «viwPat», new «Tuple3.typeRef.qualifiedName»[]{«FOR conv : conversions SEPARATOR ','»«Tuple3.typeRef.qualifiedName».make(new String[]{«FOR sk : conv.source SEPARATOR ','»"«sk»"«ENDFOR»}, new String[]{«FOR vk : conv.view SEPARATOR ','»"«vk»"«ENDFOR»}, «conv.bigul.generateBiGuLCode»)«ENDFOR»})''').newLine
			}
			XmuCoreAlign : {
				val srcType = (statement as XmuCoreAlign).sourceType.typeAccessor;
				val viwType = (statement as XmuCoreAlign).viewType.typeAccessor;
				val srcPat = (statement as XmuCoreAlign).sourcePattern.patternAccessor(pairs);
				val viwPat = (statement as XmuCoreAlign).viewPattern.patternAccessor(pairs);
				val cond = (statement as XmuCoreAlign).alignment;
				val match = (statement as XmuCoreAlign).match;
				val unmatchS = (statement as XmuCoreAlign).unmatchS;
				val unmatchV = (statement as XmuCoreAlign).unmatchV;
				
				appendable.append('''new «Align.typeRef.qualifiedName»("«key»", «srcType», «viwType», «srcPat», «viwPat», new Condition«conditions.indexOf(cond)»(), ''').newLine.increaseIndentation
					.generateXmuCode(match, indexed, pairs, conditions, actions, program)
					.append(''', new UnidirectionalAction«actions.indexOf(unmatchS)»(), new UnidirectionalAction«actions.indexOf(unmatchV)»())''')
			}
			XmuCoreFunctionCall : {
				val st = (statement as XmuCoreFunctionCall).target.sourceType.typeAccessor;
				val vt = (statement as XmuCoreFunctionCall).target.viewType.typeAccessor;
				appendable.append('''new «Invocation.typeRef.qualifiedName»("«key»", «st», «vt», ()->getXmu_«(statement as XmuCoreFunctionCall).target.name.toFirstUpper»())''')
			}
			XmuCoreIndex : {
				val parts = (statement as XmuCoreIndex).parts;
				val body = (statement as XmuCoreIndex).body;
				
				var scope = appendable.append('''«FOR part : parts»new «Indexing.typeRef.qualifiedName»(getIndex_«part.signature.name.toFirstUpper»(), new String[]{«FOR sk:part.sourceKeys SEPARATOR ','»"«sk»"«ENDFOR»}, new String[]{«FOR vk:part.viewKeys SEPARATOR ','»"«vk»"«ENDFOR»}, «ENDFOR»''');
				scope = scope.generateXmuCode(body, indexed, pairs, conditions, actions, program);
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
	
	protected def CharSequence patternAccessor(edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern pattern, List<Pair<Integer, PatternDefinition>> pairs) {
		if(pattern instanceof PatternDefinition) 'pattern__internal'+pairs.findFirst[p|p.value===pattern].key
		else 'getPattern_'+(pattern as PatternDefinitionReference).pattern.name.toFirstUpper+'()'
	}
	
	protected def CharSequence typeAccessor(Pattern pat) {
		if(pat instanceof PatternDefinitionReference) {
			'''getType_«(pat as PatternDefinition).type.toFirstUpper»()'''
		} else {
			'''type__internal«(pat as PatternDefinition).type.toFirstUpper»()'''
		}
	}
	
	protected def CharSequence typeAccessor(ContextTypeRef type) {
		if(type instanceof DefinedContextTypeRef) {
			if(type.type instanceof TypeDefinition) '''getType_«(type.type as TypeDefinition).name.toFirstUpper»()'''
			else if(type.type instanceof PatternDefinition) {
				if((type.type as PatternDefinition).name===null) '''type__internal«(type.type as PatternDefinition).type.toFirstUpper»'''
				else '''getType_«(type.type as PatternDefinition).type.toFirstUpper»()'''
			}
		} else '''«ContextType.typeRef.qualifiedName».EMPTY_TYPE'''
	}
	
//	protected def CharSequence collectTypeVar(ContextTypeRef type) {
//		if(type instanceof DefinedContextTypeRef) {
//			if(type.type instanceof TypeDefinition) '''getType_«(type.type as TypeDefinition).name.toFirstUpper»'''
//			else if(type.type instanceof PatternDefinition) {
//				if((type.type as PatternDefinition).name===null) '''type__internal«(type.type as PatternDefinition).type.toFirstUpper»'''
//				else '''getType_«(type.type as PatternDefinition).type.toFirstUpper»'''
//			}
//		} else '''«ContextType.typeRef.qualifiedName».EMPTY_TYPE'''
//	}
	
		
//	def String computeSourceType(XmuCoreStatement statement, List<Pair<Integer, PatternDefinition>> pairs, BXProgram program) {
//		val parent = statement.eContainer;
//		switch parent {
//			BXFunctionDefinition : ContextType.typeRef.qualifiedName+'.EMPTY_TYPE'
//		}
//	}
	
	protected def void generatePatternDefinition(JvmGenericType owner, PatternDefinition patternDefinition, BXProgram program) {
		owner.members += patternDefinition.toField('pattern_' + patternDefinition.name, Pattern.typeRef) [
			visibility = JvmVisibility.PRIVATE
		];
		owner.members +=
			patternDefinition.toMethod('getPattern_' + patternDefinition.name.toFirstUpper,
				Pattern.typeRef) [
				visibility = JvmVisibility.PUBLIC;
				body = patternDefinition. generatePatternDefinitionCode(program)
			];

		if(patternDefinition.type !== null) {
			val patternType = if(patternDefinition.type!==null) program.definitions.findFirst[d|d instanceof TypeDefinition && d.name.equals(patternDefinition.type)] as TypeDefinition else null;
			if(patternType===null) {
				owner.members +=
					patternDefinition.toMethod('getType_' + patternDefinition.name.toFirstUpper,
						ContextType.typeRef) [
						visibility = JvmVisibility.PUBLIC;
						body = '''
							return getPattern_«patternDefinition.name.toFirstUpper»().getType();
						'''
					];
			}
		}
	}
	
	protected def StringConcatenationClient generatePatternDefinitionCode(PatternDefinition patternDefinition, BXProgram program) {		
		'''
			if(pattern_«patternDefinition.name»==null) {
				«patternDefinition.generatePatternConstructionCode(patternDefinition.name, program)»
			}
			return pattern_«patternDefinition.name»;
		'''
	}
	
	protected def CharSequence generatePatternConstructionCode(PatternDefinition patternDefinition, String patternName, BXProgram program) {
		val nodes = patternDefinition.eAllContents.filter[it instanceof PatternNode].map[it as PatternNode].
			toList;
		val edges = patternDefinition.eAllContents.filter[it instanceof PatternEdge].map[it as PatternEdge].
			toList;
				
		val typeGraphs = nodes.map [ n |
			val t = (n as PatternNode).type;
			if (t instanceof PrimitiveTypeRef) {
				null
			} else {
				(t as EcoreTypeRef).type.EPackage
			}
		].filter[it !== null].map[p|program.imports.findFirst[it.metamodel === p]].toSet
				
		val typeGraph = if (typeGraphs.size === 0) {
				null
			} else if (typeGraphs.size >= 1) {
				typeGraphs.findFirst[true]
			}
			 
		val patternType = if(patternDefinition.type!==null) program.definitions.findFirst[d|d instanceof TypeDefinition && d.name.equals(patternDefinition.type)] as TypeDefinition else null;
			
		return '''
		«TypeGraph.typeRef.qualifiedName» typeGraph = getTypeGraph_«typeGraph.shortName.toFirstUpper»();
		pattern_«patternName» = new «Pattern.typeRef.qualifiedName»(typeGraph);
		«FOR node : nodes»
		«ITypeNode.typeRef.qualifiedName» type_«node.name» = typeGraph.«IF node.type instanceof EcoreTypeRef»«IF (node.type as EcoreTypeRef).type instanceof EClass»getTypeNode«ELSE»getDataTypeNode«ENDIF»("«(node.type as EcoreTypeRef).type.name»")«ELSE»getDataTypeNode("«(node.type as PrimitiveTypeRef).type»")«ENDIF»;
		pattern_«patternName».appendPatternNode("«node.name»", type_«node.name»);
		«ENDFOR»
		«FOR edge : edges»
		«val tarNode = if(edge.value instanceof PatternNode) edge.value as PatternNode else if(edge.value instanceof PatternNodeRef) (edge.value as PatternNodeRef).node else null»
		«val edgeName = if(edge.name!==null) edge.name else ((edge.eContainer as PatternNode).name+'_'+edge.feature.name+'_'+(if(tarNode!==null) tarNode.name else '?'))»
		«IStructuralFeatureEdge.typeRef.qualifiedName» type_«edgeName» = typeGraph.«IF edge.feature instanceof EReference»getTypeEdge«ELSE»getPropertyEdge«ENDIF»((«TypeNode.typeRef.qualifiedName») type_«(edge.eContainer as PatternNode).name»,"«edge.feature.name»");
		pattern_«patternName».appendPatternEdge("«edgeName»", "«(edge.eContainer as PatternNode).name»", "«tarNode.name»", type_«edgeName»);
		«ENDFOR»
		«IF patternDefinition.type!==null»
			«IF patternType!==null»
				pattern_«patternName».setType(getType_«patternDefinition.type»());
			«ENDIF»
		«ENDIF»
		'''
	}
	
	protected def boolean generateTypeDefinition(JvmGenericType owner, TypeDefinition typeDef, BXProgram program) {
		owner.members += typeDef.toField('type_' + typeDef.name, ContextType.typeRef) [
			visibility = JvmVisibility.PRIVATE
		];
		owner.members += typeDef.toMethod('getType_' + typeDef.name.toFirstUpper, ContextType.typeRef) [
			visibility = JvmVisibility.PUBLIC;
			val elements = typeDef.typeVars;
			val typeGraphs = elements.map [ n |
				val t = n.type;
				if (t instanceof PrimitiveTypeRef) {
					null
				} else if(t instanceof EcoreTypeRef) {
					(t as EcoreTypeRef).type.EPackage
				} else {
					(t as FeatureTypeRef).type.EPackage
				}
			].filter[it !== null].map[p|program.imports.findFirst[it.metamodel === p]].toSet;
			val typeGraph = if (typeGraphs.size === 0) {
					null
				} else if (typeGraphs.size >= 1) {
					typeGraphs.findFirst[true]
				}
		
			body = '''
				if(type_«typeDef.name»==null) {
					«IF elements.empty»
						type_«typeDef.name» = «ContextType.typeRef.qualifiedName».EMPTY_TYPE;
					«ELSE»
						«TypeGraph.typeRef.qualifiedName» typeGraph = getTypeGraph_«typeGraph.shortName.toFirstUpper»();
						type_«typeDef.name» = new «ContextType.typeRef.qualifiedName»();
						«FOR v : elements»
						Object «v.name»_type = typeGraph.«IF v.type instanceof EcoreTypeRef»«IF (v.type as EcoreTypeRef).type instanceof EClass»getTypeNode«ELSE»getDataTypeNode«ENDIF»("«(v.type as EcoreTypeRef).type.name»")«ELSEIF v.type instanceof FeatureTypeRef»«IF (v.type as FeatureTypeRef).feature instanceof EReference»getTypeEdge«ELSE»getPropertyEdge«ENDIF»(typeGraph.getTypeNode("«(v.type as FeatureTypeRef).type.name»"),"«(v.type as FeatureTypeRef).feature.name»")«ELSE»getDataTypeNode("«(v.type as PrimitiveTypeRef).type»")«ENDIF»;
						type_«typeDef.name».addField("«v.name»", «v.name»_type);
					«ENDFOR»
					«ENDIF»
				}
				return type_«typeDef.name»;
			'''
		
		]
	}
}
