package edu.ustb.sei.mde.bxcore.dsl.jvmmodel

import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.emf.ecore.EObject
import edu.ustb.sei.mde.bxcore.dsl.structure.ExceptionSafeInferface
import edu.ustb.sei.mde.bxcore.dsl.bXCore.NavigationExpression
import org.eclipse.emf.ecore.EClass
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextExpression
import java.util.List
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpressionBlock
import edu.ustb.sei.mde.bxcore.structures.ContextGraph.GraphModification
import edu.ustb.sei.mde.bxcore.dsl.bXCore.EnforcementExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.DeleteElementExpression
import edu.ustb.sei.mde.structure.Tuple2
import edu.ustb.sei.mde.bxcore.SourceType
import edu.ustb.sei.mde.bxcore.dsl.infer.InferManager
import edu.ustb.sei.mde.bxcore.dsl.bXCore.Pattern
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternTypeLiteral
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinitionReference
import edu.ustb.sei.mde.bxcore.dsl.bXCore.SideEnum
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XIfExpression
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ModificationExpression

class XmuCoreCompiler extends XbaseCompiler {
	def patternAccessor(Pattern p) {
		try {
			val data = InferManager.getInferredTypeModel(p.eResource);
			if (p instanceof PatternTypeLiteral)
				'getPattern_' + data.literalMap.get(data).second
			else if(p instanceof PatternDefinitionReference)
				p.pattern.name.toFirstUpper
			else '/* ERROR */'
		} catch (Exception e) {
			'/* ERROR */'
		}
	}
	
	override protected doInternalToJavaStatement(XExpression e, ITreeAppendable a, boolean isReferenced) {
		if (e instanceof ContextVarExpression) {
			val expectedType = getType(e);
			if (isReferenced) {
				val name = a.declareSyntheticVariable(e, "_contextValue");
				a.newLine.append('''«expectedType.qualifiedName» «name» = ''');
				a.append('''((«expectedType.qualifiedName») «ExceptionSafeInferface.canonicalName».getValue(«e.side.literal»,"«e.name»"))''')
				a.append(";")
			} else {
				a.append('''((«expectedType.qualifiedName») «ExceptionSafeInferface.canonicalName».getValue(«e.side.literal»,"«e.name»"))''')
				a.append(";")
			}
		} else if(e instanceof ExpressionConversion) {
			val expectedType = getType(e);
			e.expression.doInternalToJavaStatement(a,true);
			
			if (isReferenced) {
				val name = a.declareSyntheticVariable(e, "_expValue");
				a.newLine.append('''«expectedType.qualifiedName» «name» = ''');
				e.expression.internalToJavaExpression(a);
				a.append(";")
			} else {
				e.expression.internalToJavaExpression(a);
				a.append(";")
			}
		} else if(e instanceof NavigationExpression) {
			e.host.doInternalToJavaStatement(a,true);
			a.newLine;
			val expectedType = getType(e);
			val ecoreType = ModelInferrerUtils.navEcoreType(e);
			
			if(isReferenced) {
				val name = a.declareSyntheticVariable(e, "_navExp");
				a.newLine.append('''«expectedType.qualifiedName» «name» = «ExceptionSafeInferface.canonicalName».navigate(«e.side.literal», ''');
				e.host.internalToJavaExpression(a);
				a.append(''', "«e.pathName»", «ecoreType.key instanceof EClass», «ecoreType.value»);''');
			} else {
				a.newLine.append('''«ExceptionSafeInferface.canonicalName».navigate(«e.side.literal», ''');
				e.host.internalToJavaExpression(a);
				a.append(''', "«e.pathName»", «ecoreType.key instanceof EClass», «ecoreType.value»);''');
			}
		} else if(e instanceof ModificationExpressionBlock) {
			a.newLine;
			val mo = a.declareSyntheticVariable(e, '_modStart');
			a.append('''«GraphModification.canonicalName» «mo» = source.modification();''');
			
			e.expressions.forEach[me|
				me.internalToJavaStatement(a, true);
			];
			if(isReferenced) {
//				val v = a.declareSyntheticVariable(e, '_modRes');
//				a.append('''«SourceType.canonicalName» «v» = ''');
//				e.internalToJavaExpression(a);
//				a.append(''';''');
			} else {
				a.append('''return ''');
				e.internalToJavaExpression(a);
				a.append(''';''');
			}
		} else if(e instanceof ModificationExpression) {
			val block = e.block;
			val blockVar = getVarName(block, a);
			val cur = a.declareSyntheticVariable(e, '_mod');
				
			if(e instanceof EnforcementExpression) {
				e.valueMappings.forEach[it.expression.internalToJavaStatement(a,true)];
				a.newLine.append('''«GraphModification.canonicalName» «cur» = «blockVar».enforce(«e.pattern.patternAccessor»(), new edu.ustb.sei.mde.structure.Tuple2[] {''');
				e.valueMappings.forEach [ m, id |
					if(id > 0) a.append(',');
					a.append('''edu.ustb.sei.mde.structure.Tuple2.make("«m.varName»",''');
					m.expression.internalToJavaExpression(a);
					a.append(''')''');
				];
				a.append('''});''').newLine;
				a.append('''«blockVar» = «cur»;'''); // new scope, we must reset
			} else if(e instanceof DeleteElementExpression) {
				e.element.internalToJavaStatement(a, true);
				a.newLine.append('''«GraphModification.canonicalName» «cur» = «blockVar».remove(''');
				e.element.internalToJavaExpression(a);
				a.append(''');''').newLine;
			}
			
		} else
			super.doInternalToJavaStatement(e, a, isReferenced)
	}
	
	def SideEnum side(ContextExpression expression) {
		if(expression instanceof ContextVarExpression) expression.getSide
		else if(expression instanceof ExpressionConversion) expression.getSide
		else if(expression instanceof NavigationExpression) expression.host.side
		else null;
	}
	
	override protected internalToConvertedExpression(XExpression e, ITreeAppendable a) {
		if (e instanceof ContextVarExpression) {
			a.append(getVarName(e, a))	
		} else if (e instanceof ExpressionConversion) {
			a.append(getVarName(e, a))	
		} else if(e instanceof NavigationExpression) {
			a.append(getVarName(e, a))
		}  else if(e instanceof ModificationExpression) {
			a.append(getVarName(e, a))
		} else if(e instanceof ModificationExpressionBlock) {
			val lastResult = getVarName(e, a);
			a.append('''«lastResult».get()''')
		}
		else
			super.internalToConvertedExpression(e, a)
	}
	
	def ModificationExpressionBlock block(XExpression e) {
		if(e===null) null
		else if(e instanceof ModificationExpressionBlock) e
		else (e.eContainer as XExpression).block
	}

	
}