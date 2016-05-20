/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2Printer implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextPrinter {
	
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolverFactory tokenResolverFactory = new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public Xmu2Printer(java.io.OutputStream outputStream, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof edu.ustb.sei.mde.xmu2.TransformationModel) {
			print_edu_ustb_sei_mde_xmu2_TransformationModel((edu.ustb.sei.mde.xmu2.TransformationModel) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.EntryPoint) {
			print_edu_ustb_sei_mde_xmu2_EntryPoint((edu.ustb.sei.mde.xmu2.EntryPoint) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.EntryData) {
			print_edu_ustb_sei_mde_xmu2_EntryData((edu.ustb.sei.mde.xmu2.EntryData) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.ModelRule) {
			print_edu_ustb_sei_mde_xmu2_ModelRule((edu.ustb.sei.mde.xmu2.ModelRule) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.ArithmeticRule) {
			print_edu_ustb_sei_mde_xmu2_ArithmeticRule((edu.ustb.sei.mde.xmu2.ArithmeticRule) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.ConcreteVariableDeclaration) {
			print_edu_ustb_sei_mde_xmu2_ConcreteVariableDeclaration((edu.ustb.sei.mde.xmu2.ConcreteVariableDeclaration) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.Parameter) {
			print_edu_ustb_sei_mde_xmu2_Parameter((edu.ustb.sei.mde.xmu2.Parameter) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.pattern.Pattern) {
			print_edu_ustb_sei_mde_xmu2_pattern_Pattern((edu.ustb.sei.mde.xmu2.pattern.Pattern) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.LoopPath) {
			print_edu_ustb_sei_mde_xmu2_expression_LoopPath((edu.ustb.sei.mde.xmu2.expression.LoopPath) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.FeaturePath) {
			print_edu_ustb_sei_mde_xmu2_expression_FeaturePath((edu.ustb.sei.mde.xmu2.expression.FeaturePath) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.OperationPath) {
			print_edu_ustb_sei_mde_xmu2_expression_OperationPath((edu.ustb.sei.mde.xmu2.expression.OperationPath) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.PositionPath) {
			print_edu_ustb_sei_mde_xmu2_expression_PositionPath((edu.ustb.sei.mde.xmu2.expression.PositionPath) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.VariableExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_VariableExpression((edu.ustb.sei.mde.xmu2.expression.VariableExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.PathExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_PathExpression((edu.ustb.sei.mde.xmu2.expression.PathExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.EmptyExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_EmptyExpression((edu.ustb.sei.mde.xmu2.expression.EmptyExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression((edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression((edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression((edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression((edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression((edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.ParenExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_ParenExpression((edu.ustb.sei.mde.xmu2.expression.ParenExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.UnaryExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_UnaryExpression((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression((edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression((edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.RelationalExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_RelationalExpression((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression((edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) {
			print_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression((edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.BlockStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_BlockStatement((edu.ustb.sei.mde.xmu2.statement.BlockStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.UpdateStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_UpdateStatement((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.SwitchStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_SwitchStatement((edu.ustb.sei.mde.xmu2.statement.SwitchStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.UpdateClause) {
			print_edu_ustb_sei_mde_xmu2_statement_UpdateClause((edu.ustb.sei.mde.xmu2.statement.UpdateClause) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) {
			print_edu_ustb_sei_mde_xmu2_statement_PatternCaseClause((edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause) {
			print_edu_ustb_sei_mde_xmu2_statement_ExpressionCaseClause((edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement((edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.ConcreteDeleteLinkStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement((edu.ustb.sei.mde.xmu2.statement.ConcreteDeleteLinkStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement((edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.ForEachStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_ForEachStatement((edu.ustb.sei.mde.xmu2.statement.ForEachStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.RuleCallStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement((edu.ustb.sei.mde.xmu2.statement.RuleCallStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.Skip) {
			print_edu_ustb_sei_mde_xmu2_statement_Skip((edu.ustb.sei.mde.xmu2.statement.Skip) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.Fail) {
			print_edu_ustb_sei_mde_xmu2_statement_Fail((edu.ustb.sei.mde.xmu2.statement.Fail) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause) {
			print_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause((edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.AssignStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_AssignStatement((edu.ustb.sei.mde.xmu2.statement.AssignStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.ReflectiveVariableDeclaration) {
			print_edu_ustb_sei_mde_xmu2_ReflectiveVariableDeclaration((edu.ustb.sei.mde.xmu2.ReflectiveVariableDeclaration) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode) {
			print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode((edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression) {
			print_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression((edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression) {
			print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression((edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement) {
			print_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement((edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.pattern.PatternNode) {
			print_edu_ustb_sei_mde_xmu2_pattern_PatternNode((edu.ustb.sei.mde.xmu2.pattern.PatternNode) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression) {
			print_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression((edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression) {
			print_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression((edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ReferenceResolverSwitch getReferenceResolverSwitch() {
		return (edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ReferenceResolverSwitch) new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2MetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Problem(errorMessage, edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType.PRINT_PROBLEM, edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_edu_ustb_sei_mde_xmu2_TransformationModel(edu.ustb.sei.mde.xmu2.TransformationModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__PACKAGES));
		printCountingMap.put("packages", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS));
		printCountingMap.put("entryPoints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__RULES));
		printCountingMap.put("rules", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("module");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__NAME));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_TransformationModel_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_TransformationModel_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_TransformationModel_2(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_TransformationModel_0(edu.ustb.sei.mde.xmu2.TransformationModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("import");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("packages");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__PACKAGES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62_92");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTransformationModelPackagesReferenceResolver().deResolve((org.eclipse.emf.ecore.EPackage) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__PACKAGES)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__PACKAGES), element));
				out.print(" ");
			}
			printCountingMap.put("packages", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_TransformationModel_1(edu.ustb.sei.mde.xmu2.TransformationModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("entryPoints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("entryPoints", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_TransformationModel_2(edu.ustb.sei.mde.xmu2.TransformationModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rules");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__RULES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rules", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_EntryPoint(edu.ustb.sei.mde.xmu2.EntryPoint element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__RULE));
		printCountingMap.put("rule", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("entry");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("rule");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__RULE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEntryPointRuleReferenceResolver().deResolve((edu.ustb.sei.mde.xmu2.ModelRule) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__RULE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__RULE), element));
				out.print(" ");
			}
			printCountingMap.put("rule", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_EntryPoint_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_EntryPoint_0(edu.ustb.sei.mde.xmu2.EntryPoint element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_EntryData(edu.ustb.sei.mde.xmu2.EntryData element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__TAG));
		printCountingMap.put("tag", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__INDEX));
		printCountingMap.put("index", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__FRAGMENT));
		printCountingMap.put("fragment", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("tag");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__TAG));
			if (o != null) {
			}
			printCountingMap.put("tag", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("index");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__INDEX));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NUMBER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__INDEX), element));
				out.print(" ");
			}
			printCountingMap.put("index", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_EntryData_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_EntryData_0(edu.ustb.sei.mde.xmu2.EntryData element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("fragment");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__FRAGMENT));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("OBJ_URI");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__FRAGMENT), element));
				out.print(" ");
			}
			printCountingMap.put("fragment", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_ModelRule(edu.ustb.sei.mde.xmu2.ModelRule element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__VARIABLE_DECLARATIONS));
		printCountingMap.put("variableDeclarations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT));
		printCountingMap.put("statement", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("rule");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__NAME));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_ModelRule_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_ModelRule_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("statement");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("statement", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_ModelRule_0(edu.ustb.sei.mde.xmu2.ModelRule element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_ModelRule_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_ModelRule_0_0(edu.ustb.sei.mde.xmu2.ModelRule element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_ModelRule_1(edu.ustb.sei.mde.xmu2.ModelRule element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variableDeclarations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__VARIABLE_DECLARATIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variableDeclarations", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_ArithmeticRule(edu.ustb.sei.mde.xmu2.ArithmeticRule element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS));
		printCountingMap.put("statements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("function");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__NAME));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_ArithmeticRule_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("statements");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("statements", 0);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_ArithmeticRule_0(edu.ustb.sei.mde.xmu2.ArithmeticRule element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_ArithmeticRule_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_ArithmeticRule_0_0(edu.ustb.sei.mde.xmu2.ArithmeticRule element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_ConcreteVariableDeclaration(edu.ustb.sei.mde.xmu2.ConcreteVariableDeclaration element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__NAME));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__TYPE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("TYPE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypedElementTypeReferenceResolver().deResolve((org.eclipse.emf.ecore.EClassifier) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__TYPE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_Parameter(edu.ustb.sei.mde.xmu2.Parameter element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG));
		printCountingMap.put("tag", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("tag");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG));
			if (o != null) {
			}
			printCountingMap.put("tag", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__NAME));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TYPE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("TYPE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypedElementTypeReferenceResolver().deResolve((org.eclipse.emf.ecore.EClassifier) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TYPE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_Pattern(edu.ustb.sei.mde.xmu2.pattern.Pattern element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__ROOT));
		printCountingMap.put("root", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD));
		printCountingMap.put("guard", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("root");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__ROOT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("root", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_Pattern_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_Pattern_0(edu.ustb.sei.mde.xmu2.pattern.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("guard");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("guard", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_PatternNode(edu.ustb.sei.mde.xmu2.pattern.PatternNode element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN_NODE__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN_NODE__EXPRESSIONS));
		printCountingMap.put("expressions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN_NODE__VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_PatternNode_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_PatternNode_0(edu.ustb.sei.mde.xmu2.pattern.PatternNode element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_PatternNode_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_PatternNode_0_0(edu.ustb.sei.mde.xmu2.pattern.PatternNode element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN_NODE__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expressions", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_pattern_PatternNode_0_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_PatternNode_0_0_0(edu.ustb.sei.mde.xmu2.pattern.PatternNode element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN_NODE__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expressions", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression(edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__OWNER_NODE));
		printCountingMap.put("ownerNode", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__SELECTOR));
		printCountingMap.put("selector", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__POSITION));
		printCountingMap.put("position", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE));
		printCountingMap.put("nullable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE));
		printCountingMap.put("targetNode", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__FEATURE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternExpressionFeatureReferenceResolver().deResolve((org.eclipse.emf.ecore.EStructuralFeature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__FEATURE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("feature", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("nullable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE));
			if (o != null) {
			}
			printCountingMap.put("nullable", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("targetNode");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("targetNode", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression_0(edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("selector");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__SELECTOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("selector", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression_1(edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("position");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__POSITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("position", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression(edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__OWNER_NODE));
		printCountingMap.put("ownerNode", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__SELECTOR));
		printCountingMap.put("selector", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__POSITION));
		printCountingMap.put("position", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE));
		printCountingMap.put("nullable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION));
		printCountingMap.put("targetExpression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__FEATURE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternExpressionFeatureReferenceResolver().deResolve((org.eclipse.emf.ecore.EStructuralFeature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__FEATURE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("feature", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("nullable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE));
			if (o != null) {
			}
			printCountingMap.put("nullable", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("targetExpression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("targetExpression", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression_0(edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("selector");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__SELECTOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("selector", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression_1(edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("position");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__POSITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("position", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_LoopPath(edu.ustb.sei.mde.xmu2.expression.LoopPath element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY));
		printCountingMap.put("body", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__OPERATOR));
			if (o != null) {
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("|");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("body");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("body", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_FeaturePath(edu.ustb.sei.mde.xmu2.expression.FeaturePath element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.FEATURE_PATH__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.FEATURE_PATH__FEATURE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.FEATURE_PATH__FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("feature", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_OperationPath(edu.ustb.sei.mde.xmu2.expression.OperationPath element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__OPERATION));
		printCountingMap.put("operation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("operation");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__OPERATION));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__OPERATION), element));
				out.print(" ");
			}
			printCountingMap.put("operation", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_expression_OperationPath_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_expression_OperationPath_0(edu.ustb.sei.mde.xmu2.expression.OperationPath element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_expression_OperationPath_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_expression_OperationPath_0_0(edu.ustb.sei.mde.xmu2.expression.OperationPath element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_PositionPath(edu.ustb.sei.mde.xmu2.expression.PositionPath element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("value", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_VariableExpression(edu.ustb.sei.mde.xmu2.expression.VariableExpression element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.VARIABLE_EXPRESSION__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.VARIABLE_EXPRESSION__VARIABLE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.VARIABLE_EXPRESSION__VARIABLE), element));
				out.print(" ");
			}
			printCountingMap.put("variable", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_PathExpression(edu.ustb.sei.mde.xmu2.expression.PathExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PATH_EXPRESSION__PATH));
		printCountingMap.put("path", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PATH_EXPRESSION__HOST));
		printCountingMap.put("host", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("host");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PATH_EXPRESSION__HOST));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("host", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PATH_EXPRESSION__PATH));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", 0);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_EmptyExpression(edu.ustb.sei.mde.xmu2.expression.EmptyExpression element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.EMPTY_EXPRESSION__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.EMPTY_EXPRESSION__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression(edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.STRING_LITERAL_EXPRESSION__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.STRING_LITERAL_EXPRESSION__VALUE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.STRING_LITERAL_EXPRESSION__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression(edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.INTEGER_LITERAL_EXPRESSION__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.INTEGER_LITERAL_EXPRESSION__VALUE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NUMBER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.INTEGER_LITERAL_EXPRESSION__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression(edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_LITERAL_EXPRESSION__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_LITERAL_EXPRESSION__VALUE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("BOOLEAN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_LITERAL_EXPRESSION__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression(edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("TYPE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralExpressionTypeReferenceResolver().deResolve((org.eclipse.emf.ecore.EEnum) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("::");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralExpressionValueReferenceResolver().deResolve((org.eclipse.emf.ecore.EEnumLiteral) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression(edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OBJECT_URI_EXPRESSION__OBJECT));
		printCountingMap.put("object", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("object");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OBJECT_URI_EXPRESSION__OBJECT));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("OBJ_URI");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectURIExpressionObjectReferenceResolver().deResolve((org.eclipse.emf.ecore.EObject) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OBJECT_URI_EXPRESSION__OBJECT)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OBJECT_URI_EXPRESSION__OBJECT), element));
				out.print(" ");
			}
			printCountingMap.put("object", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_ParenExpression(edu.ustb.sei.mde.xmu2.expression.ParenExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY));
		printCountingMap.put("body", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("body");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("body", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_UnaryExpression(edu.ustb.sei.mde.xmu2.expression.UnaryExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.UNARY_EXPRESSION__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.UNARY_EXPRESSION__BODY));
		printCountingMap.put("body", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.UNARY_EXPRESSION__OPERATOR));
			if (o != null) {
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("body");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.UNARY_EXPRESSION__BODY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("body", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression(edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERATORS));
		printCountingMap.put("operators", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS));
		printCountingMap.put("operands", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operands");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operands", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression_0(edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operators");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERATORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
			}
			printCountingMap.put("operators", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operands");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operands", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression(edu.ustb.sei.mde.xmu2.expression.AdditiveExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS));
		printCountingMap.put("operators", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS));
		printCountingMap.put("operands", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operands");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operands", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression_0(edu.ustb.sei.mde.xmu2.expression.AdditiveExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operators");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
			}
			printCountingMap.put("operators", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operands");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operands", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_RelationalExpression(edu.ustb.sei.mde.xmu2.expression.RelationalExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__LEFT));
		printCountingMap.put("left", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__RIGHT));
		printCountingMap.put("right", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("left");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__LEFT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("left", count - 1);
		}
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__OPERATOR));
			if (o != null) {
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("right");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__RIGHT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("right", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression(edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS));
		printCountingMap.put("operands", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operands");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operands", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression_0(edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operands");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operands", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression(edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS));
		printCountingMap.put("operands", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operands");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operands", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression_0(edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("or");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operands");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operands", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_BlockStatement(edu.ustb.sei.mde.xmu2.statement.BlockStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY));
		printCountingMap.put("body", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_statement_BlockStatement_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_statement_BlockStatement_0(edu.ustb.sei.mde.xmu2.statement.BlockStatement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("body");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("body", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_statement_BlockStatement_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_statement_BlockStatement_0_0(edu.ustb.sei.mde.xmu2.statement.BlockStatement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("body");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("body", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_UpdateStatement(edu.ustb.sei.mde.xmu2.statement.UpdateStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__VIEW));
		printCountingMap.put("view", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__CLAUSES));
		printCountingMap.put("clauses", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("update");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__SOURCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("with");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("view");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__VIEW));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("view", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("by");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("clauses");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__CLAUSES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("clauses", 0);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_SwitchStatement(edu.ustb.sei.mde.xmu2.statement.SwitchStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.SWITCH_STATEMENT__ROOT));
		printCountingMap.put("root", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.SWITCH_STATEMENT__CASES));
		printCountingMap.put("cases", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("switch");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("root");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.SWITCH_STATEMENT__ROOT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("root", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("cases");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.SWITCH_STATEMENT__CASES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("cases", 0);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_UpdateClause(edu.ustb.sei.mde.xmu2.statement.UpdateClause element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT));
		printCountingMap.put("statement", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("statement");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("statement", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_PatternCaseClause(edu.ustb.sei.mde.xmu2.statement.PatternCaseClause element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("case");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__CONDITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("action");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_ExpressionCaseClause(edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("case");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__CONDITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("action");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement(edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_NODE_STATEMENT__NODE));
		printCountingMap.put("node", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("delete");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("node");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_NODE_STATEMENT__NODE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("node", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement(edu.ustb.sei.mde.xmu2.statement.ConcreteDeleteLinkStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("delete");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__SOURCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__FEATURE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("feature", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement(edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ENFORCE_PATTERN_STATEMENT__PATTERN));
		printCountingMap.put("pattern", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("enforce");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("pattern");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ENFORCE_PATTERN_STATEMENT__PATTERN));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("pattern", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_ForEachStatement(edu.ustb.sei.mde.xmu2.statement.ForEachStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__PATTERN));
		printCountingMap.put("pattern", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("foreach");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("pattern");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__PATTERN));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("pattern", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("action");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement(edu.ustb.sei.mde.xmu2.statement.RuleCallStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__RULE));
		printCountingMap.put("rule", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("rule");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__RULE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleCallStatementRuleReferenceResolver().deResolve((edu.ustb.sei.mde.xmu2.AbstractRule) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__RULE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__RULE), element));
				out.print(" ");
			}
			printCountingMap.put("rule", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement_0(edu.ustb.sei.mde.xmu2.statement.RuleCallStatement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement_0_0(edu.ustb.sei.mde.xmu2.statement.RuleCallStatement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_Skip(edu.ustb.sei.mde.xmu2.statement.Skip element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("skip");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_Fail(edu.ustb.sei.mde.xmu2.statement.Fail element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__MESSAGE));
		printCountingMap.put("message", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("fail");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("message");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__MESSAGE));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__MESSAGE), element));
				out.print(" ");
			}
			printCountingMap.put("message", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause(edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("otherwise");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("action");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_AssignStatement(edu.ustb.sei.mde.xmu2.statement.AssignStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__UPDATED_VARIABLE));
		printCountingMap.put("updatedVariable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("updatedVariable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__UPDATED_VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("updatedVariable", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("::=");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_ReflectiveVariableDeclaration(edu.ustb.sei.mde.xmu2.ReflectiveVariableDeclaration element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.REFLECTIVE_VARIABLE_DECLARATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.REFLECTIVE_VARIABLE_DECLARATION__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.REFLECTIVE_VARIABLE_DECLARATION__NAME));
			if (o != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver = tokenResolverFactory.createTokenResolver("NAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.REFLECTIVE_VARIABLE_DECLARATION__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode(edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__EXPRESSIONS));
		printCountingMap.put("expressions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__REFLECTIVE_IDENTIFIER));
		printCountingMap.put("reflectiveIdentifier", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE));
		printCountingMap.put("resolve", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__VARIABLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("variable", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("resolve");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE));
			if (o != null) {
			}
			printCountingMap.put("resolve", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("reflectiveIdentifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__REFLECTIVE_IDENTIFIER));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("reflectiveIdentifier", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode_0(edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode_0_0(edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expressions", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode_0_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode_0_0_0(edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expressions", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression(edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__OWNER_NODE));
		printCountingMap.put("ownerNode", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__SELECTOR));
		printCountingMap.put("selector", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__POSITION));
		printCountingMap.put("position", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE));
		printCountingMap.put("nullable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__TARGET_NODE));
		printCountingMap.put("targetNode", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER));
		printCountingMap.put("reflectiveIdentifier", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE));
		printCountingMap.put("resolve", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("resolve");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE));
			if (o != null) {
			}
			printCountingMap.put("resolve", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("reflectiveIdentifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("reflectiveIdentifier", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("nullable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE));
			if (o != null) {
			}
			printCountingMap.put("nullable", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("targetNode");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__TARGET_NODE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("targetNode", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression_0(edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("selector");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__SELECTOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("selector", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression_1(edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("position");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__POSITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("position", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression(edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__OWNER_NODE));
		printCountingMap.put("ownerNode", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__SELECTOR));
		printCountingMap.put("selector", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__POSITION));
		printCountingMap.put("position", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE));
		printCountingMap.put("nullable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION));
		printCountingMap.put("targetExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER));
		printCountingMap.put("reflectiveIdentifier", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE));
		printCountingMap.put("resolve", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("resolve");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE));
			if (o != null) {
			}
			printCountingMap.put("resolve", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("reflectiveIdentifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("reflectiveIdentifier", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("nullable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE));
			if (o != null) {
			}
			printCountingMap.put("nullable", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("targetExpression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("targetExpression", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression_0(edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("selector");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__SELECTOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("selector", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression_1(edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("position");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__POSITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("position", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement(edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER));
		printCountingMap.put("reflectiveIdentifier", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE));
		printCountingMap.put("resolve", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("delete");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__SOURCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("resolve");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE));
			if (o != null) {
			}
			printCountingMap.put("resolve", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("reflectiveIdentifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("reflectiveIdentifier", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
	}
	
	
}
