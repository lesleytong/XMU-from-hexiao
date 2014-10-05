/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelPrinter implements edu.ustb.sei.mde.morel.resource.morel.IMorelTextPrinter {
	
	protected edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolverFactory tokenResolverFactory = new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public MorelPrinter(java.io.OutputStream outputStream, edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource) {
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
		
		if (element instanceof edu.ustb.sei.mde.morel.QueryModel) {
			print_edu_ustb_sei_mde_morel_QueryModel((edu.ustb.sei.mde.morel.QueryModel) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.TypedModel) {
			print_edu_ustb_sei_mde_morel_TypedModel((edu.ustb.sei.mde.morel.TypedModel) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.Query) {
			print_edu_ustb_sei_mde_morel_Query((edu.ustb.sei.mde.morel.Query) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.ObjectVariableWithInit) {
			print_edu_ustb_sei_mde_morel_ObjectVariableWithInit((edu.ustb.sei.mde.morel.ObjectVariableWithInit) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.PrimitiveVariableWithInit) {
			print_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit((edu.ustb.sei.mde.morel.PrimitiveVariableWithInit) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.LinkConstraint) {
			print_edu_ustb_sei_mde_morel_LinkConstraint((edu.ustb.sei.mde.morel.LinkConstraint) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.VariableExp) {
			print_edu_ustb_sei_mde_morel_VariableExp((edu.ustb.sei.mde.morel.VariableExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.NestedExp) {
			print_edu_ustb_sei_mde_morel_NestedExp((edu.ustb.sei.mde.morel.NestedExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.IntegerLiteralExp) {
			print_edu_ustb_sei_mde_morel_IntegerLiteralExp((edu.ustb.sei.mde.morel.IntegerLiteralExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.RealLiteralExp) {
			print_edu_ustb_sei_mde_morel_RealLiteralExp((edu.ustb.sei.mde.morel.RealLiteralExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.StringLiteralExp) {
			print_edu_ustb_sei_mde_morel_StringLiteralExp((edu.ustb.sei.mde.morel.StringLiteralExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.BooleanLiteralExp) {
			print_edu_ustb_sei_mde_morel_BooleanLiteralExp((edu.ustb.sei.mde.morel.BooleanLiteralExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.UndefinedLiteralExp) {
			print_edu_ustb_sei_mde_morel_UndefinedLiteralExp((edu.ustb.sei.mde.morel.UndefinedLiteralExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.TypeLiteralExp) {
			print_edu_ustb_sei_mde_morel_TypeLiteralExp((edu.ustb.sei.mde.morel.TypeLiteralExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.FeaturePathExp) {
			print_edu_ustb_sei_mde_morel_FeaturePathExp((edu.ustb.sei.mde.morel.FeaturePathExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.OperationPathExp) {
			print_edu_ustb_sei_mde_morel_OperationPathExp((edu.ustb.sei.mde.morel.OperationPathExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.IteratorPathExp) {
			print_edu_ustb_sei_mde_morel_IteratorPathExp((edu.ustb.sei.mde.morel.IteratorPathExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.LetExp) {
			print_edu_ustb_sei_mde_morel_LetExp((edu.ustb.sei.mde.morel.LetExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.ConditionExp) {
			print_edu_ustb_sei_mde_morel_ConditionExp((edu.ustb.sei.mde.morel.ConditionExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.BooleanImpliesExp) {
			print_edu_ustb_sei_mde_morel_BooleanImpliesExp((edu.ustb.sei.mde.morel.BooleanImpliesExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.BooleanOrExp) {
			print_edu_ustb_sei_mde_morel_BooleanOrExp((edu.ustb.sei.mde.morel.BooleanOrExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.BooleanAndExp) {
			print_edu_ustb_sei_mde_morel_BooleanAndExp((edu.ustb.sei.mde.morel.BooleanAndExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.RelationalExp) {
			print_edu_ustb_sei_mde_morel_RelationalExp((edu.ustb.sei.mde.morel.RelationalExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.AdditiveExp) {
			print_edu_ustb_sei_mde_morel_AdditiveExp((edu.ustb.sei.mde.morel.AdditiveExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.MultiplicativeExp) {
			print_edu_ustb_sei_mde_morel_MultiplicativeExp((edu.ustb.sei.mde.morel.MultiplicativeExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.UnaryExp) {
			print_edu_ustb_sei_mde_morel_UnaryExp((edu.ustb.sei.mde.morel.UnaryExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.BindExp) {
			print_edu_ustb_sei_mde_morel_BindExp((edu.ustb.sei.mde.morel.BindExp) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.DeclarativeStatement) {
			print_edu_ustb_sei_mde_morel_DeclarativeStatement((edu.ustb.sei.mde.morel.DeclarativeStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.IfStatement) {
			print_edu_ustb_sei_mde_morel_IfStatement((edu.ustb.sei.mde.morel.IfStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.ForStatement) {
			print_edu_ustb_sei_mde_morel_ForStatement((edu.ustb.sei.mde.morel.ForStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.BlockStatement) {
			print_edu_ustb_sei_mde_morel_BlockStatement((edu.ustb.sei.mde.morel.BlockStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.TransformationModel) {
			print_edu_ustb_sei_mde_morel_TransformationModel((edu.ustb.sei.mde.morel.TransformationModel) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.Rule) {
			print_edu_ustb_sei_mde_morel_Rule((edu.ustb.sei.mde.morel.Rule) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.Pattern) {
			print_edu_ustb_sei_mde_morel_Pattern((edu.ustb.sei.mde.morel.Pattern) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.ObjectVariable) {
			print_edu_ustb_sei_mde_morel_ObjectVariable((edu.ustb.sei.mde.morel.ObjectVariable) element, globaltab, out);
			return;
		}
		if (element instanceof edu.ustb.sei.mde.morel.PrimitiveVariable) {
			print_edu_ustb_sei_mde_morel_PrimitiveVariable((edu.ustb.sei.mde.morel.PrimitiveVariable) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected edu.ustb.sei.mde.morel.resource.morel.mopp.MorelReferenceResolverSwitch getReferenceResolverSwitch() {
		return (edu.ustb.sei.mde.morel.resource.morel.mopp.MorelReferenceResolverSwitch) new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelProblem(errorMessage, edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType.PRINT_PROBLEM, edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity.WARNING), cause);
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
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource getResource() {
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
	
	public void print_edu_ustb_sei_mde_morel_QueryModel(edu.ustb.sei.mde.morel.QueryModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY_MODEL__MODELS));
		printCountingMap.put("models", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY_MODEL__DATA_TYPES));
		printCountingMap.put("dataTypes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY_MODEL__QUERIES));
		printCountingMap.put("queries", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("querymodel");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("models");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY_MODEL__MODELS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("models", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("queries");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY_MODEL__QUERIES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("queries", 0);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_TypedModel(edu.ustb.sei.mde.morel.TypedModel element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__PACKAGE));
		printCountingMap.put("package", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("type");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__NAME));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("<-");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("package");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__PACKAGE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("URINS");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypedModelPackageReferenceResolver().deResolve((org.eclipse.emf.ecore.EPackage) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__PACKAGE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__PACKAGE), element));
				out.print(" ");
			}
			printCountingMap.put("package", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_Query(edu.ustb.sei.mde.morel.Query element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__VARIABLES));
		printCountingMap.put("variables", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__LINK_CONSTRAINTS));
		printCountingMap.put("linkConstraints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__STATEMENTS));
		printCountingMap.put("statements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("query");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__NAME));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("match");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_Query_0(element, localtab, out1, printCountingMap1);
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
		print_edu_ustb_sei_mde_morel_Query_1(element, localtab, out1, printCountingMap1);
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
		print_edu_ustb_sei_mde_morel_Query_2(element, localtab, out1, printCountingMap1);
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
	
	public void print_edu_ustb_sei_mde_morel_Query_0(edu.ustb.sei.mde.morel.Query element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variables");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__VARIABLES));
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
			printCountingMap.put("variables", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_Query_0_0(element, localtab, out1, printCountingMap1);
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
		out.print(";");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_morel_Query_0_0(edu.ustb.sei.mde.morel.Query element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variables");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__VARIABLES));
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
			printCountingMap.put("variables", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_Query_1(edu.ustb.sei.mde.morel.Query element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("linkConstraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__LINK_CONSTRAINTS));
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
			printCountingMap.put("linkConstraints", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_Query_1_0(element, localtab, out1, printCountingMap1);
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
		out.print(";");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_morel_Query_1_0(edu.ustb.sei.mde.morel.Query element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("linkConstraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__LINK_CONSTRAINTS));
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
			printCountingMap.put("linkConstraints", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_Query_2(edu.ustb.sei.mde.morel.Query element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("when");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edu_ustb_sei_mde_morel_Query_2_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_Query_2_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edu_ustb_sei_mde_morel_Query_2_0(edu.ustb.sei.mde.morel.Query element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("statements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__STATEMENTS));
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
			printCountingMap.put("statements", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_ObjectVariable(edu.ustb.sei.mde.morel.ObjectVariable element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__MODEL));
		printCountingMap.put("model", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__NAME));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_ObjectVariable_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__TYPE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectVariableTypeReferenceResolver().deResolve((org.eclipse.emf.ecore.EClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__TYPE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_ObjectVariable_0(edu.ustb.sei.mde.morel.ObjectVariable element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("model");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__MODEL));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectVariableModelReferenceResolver().deResolve((edu.ustb.sei.mde.morel.TypedModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__MODEL)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("model", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("!");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_morel_PrimitiveVariable(edu.ustb.sei.mde.morel.PrimitiveVariable element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__NAME));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__NAME), element));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__TYPE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATA_TYPE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPrimitiveVariableTypeReferenceResolver().deResolve((org.eclipse.emf.ecore.EDataType) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__TYPE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_ObjectVariableWithInit(edu.ustb.sei.mde.morel.ObjectVariableWithInit element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__MODEL));
		printCountingMap.put("model", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP));
		printCountingMap.put("initExp", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__NAME));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_ObjectVariableWithInit_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__TYPE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectVariableTypeReferenceResolver().deResolve((org.eclipse.emf.ecore.EClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__TYPE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("initExp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("initExp", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_ObjectVariableWithInit_0(edu.ustb.sei.mde.morel.ObjectVariableWithInit element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("model");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__MODEL));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectVariableModelReferenceResolver().deResolve((edu.ustb.sei.mde.morel.TypedModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__MODEL)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("model", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("!");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit(edu.ustb.sei.mde.morel.PrimitiveVariableWithInit element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__INIT_EXP));
		printCountingMap.put("initExp", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__NAME));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__NAME), element));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__TYPE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATA_TYPE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPrimitiveVariableTypeReferenceResolver().deResolve((org.eclipse.emf.ecore.EDataType) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__TYPE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("initExp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__INIT_EXP));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("initExp", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_LinkConstraint(edu.ustb.sei.mde.morel.LinkConstraint element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__REFERENCE));
		printCountingMap.put("reference", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__SOURCE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintSourceReferenceResolver().deResolve((edu.ustb.sei.mde.morel.ObjectVariable) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__SOURCE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__SOURCE), element));
				out.print(" ");
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("reference");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__REFERENCE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintReferenceReferenceResolver().deResolve((org.eclipse.emf.ecore.EReference) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__REFERENCE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__REFERENCE), element));
				out.print(" ");
			}
			printCountingMap.put("reference", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__TARGET));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintTargetReferenceResolver().deResolve((edu.ustb.sei.mde.morel.ObjectVariable) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__TARGET)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__TARGET), element));
				out.print(" ");
			}
			printCountingMap.put("target", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_VariableExp(edu.ustb.sei.mde.morel.VariableExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__REFERRED_VARIABLE));
		printCountingMap.put("referredVariable", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("referredVariable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__REFERRED_VARIABLE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableExpReferredVariableReferenceResolver().deResolve((edu.ustb.sei.mde.morel.Variable) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__REFERRED_VARIABLE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__REFERRED_VARIABLE), element));
				out.print(" ");
			}
			printCountingMap.put("referredVariable", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_VariableExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_VariableExp_0(edu.ustb.sei.mde.morel.VariableExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__PATH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_NestedExp(edu.ustb.sei.mde.morel.NestedExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.NESTED_EXP__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.NESTED_EXP__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.NESTED_EXP__EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expression", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_NestedExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_NestedExp_0(edu.ustb.sei.mde.morel.NestedExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.NESTED_EXP__PATH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_IntegerLiteralExp(edu.ustb.sei.mde.morel.IntegerLiteralExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.INTEGER_LITERAL_EXP__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL));
		printCountingMap.put("integerSymbol", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("integerSymbol");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("INUMBER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL), element));
				out.print(" ");
			}
			printCountingMap.put("integerSymbol", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_IntegerLiteralExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_IntegerLiteralExp_0(edu.ustb.sei.mde.morel.IntegerLiteralExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.INTEGER_LITERAL_EXP__PATH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_RealLiteralExp(edu.ustb.sei.mde.morel.RealLiteralExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REAL_LITERAL_EXP__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REAL_LITERAL_EXP__REAL_SYMBOL));
		printCountingMap.put("realSymbol", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("realSymbol");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REAL_LITERAL_EXP__REAL_SYMBOL));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("RNUMBER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REAL_LITERAL_EXP__REAL_SYMBOL), element));
				out.print(" ");
			}
			printCountingMap.put("realSymbol", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_RealLiteralExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_RealLiteralExp_0(edu.ustb.sei.mde.morel.RealLiteralExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REAL_LITERAL_EXP__PATH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_StringLiteralExp(edu.ustb.sei.mde.morel.StringLiteralExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.STRING_LITERAL_EXP__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.STRING_LITERAL_EXP__STRING_SYMBOL));
		printCountingMap.put("stringSymbol", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("stringSymbol");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.STRING_LITERAL_EXP__STRING_SYMBOL));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.STRING_LITERAL_EXP__STRING_SYMBOL), element));
				out.print(" ");
			}
			printCountingMap.put("stringSymbol", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_StringLiteralExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_StringLiteralExp_0(edu.ustb.sei.mde.morel.StringLiteralExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.STRING_LITERAL_EXP__PATH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_BooleanLiteralExp(edu.ustb.sei.mde.morel.BooleanLiteralExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__BOOL_SYMBOL));
		printCountingMap.put("boolSymbol", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("boolSymbol");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__BOOL_SYMBOL));
			if (o != null) {
			}
			printCountingMap.put("boolSymbol", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_BooleanLiteralExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_BooleanLiteralExp_0(edu.ustb.sei.mde.morel.BooleanLiteralExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__PATH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_UndefinedLiteralExp(edu.ustb.sei.mde.morel.UndefinedLiteralExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__VALUE));
			if (o != null) {
			}
			printCountingMap.put("value", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_UndefinedLiteralExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_UndefinedLiteralExp_0(edu.ustb.sei.mde.morel.UndefinedLiteralExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__PATH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_TypeLiteralExp(edu.ustb.sei.mde.morel.TypeLiteralExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__PATH));
		printCountingMap.put("path", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__VALUE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATA_TYPE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypeLiteralExpValueReferenceResolver().deResolve((org.eclipse.emf.ecore.EClassifier) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__VALUE)), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_TypeLiteralExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_TypeLiteralExp_0(edu.ustb.sei.mde.morel.TypeLiteralExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("path");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__PATH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("path", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_FeaturePathExp(edu.ustb.sei.mde.morel.FeaturePathExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FEATURE_PATH_EXP__NEXT));
		printCountingMap.put("next", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FEATURE_PATH_EXP__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FEATURE_PATH_EXP__FEATURE));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FEATURE_PATH_EXP__FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("feature", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("next");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FEATURE_PATH_EXP__NEXT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("next", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_OperationPathExp(edu.ustb.sei.mde.morel.OperationPathExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__NEXT));
		printCountingMap.put("next", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__SEPARATOR));
		printCountingMap.put("separator", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__OPERATION));
		printCountingMap.put("operation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("separator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__SEPARATOR));
			if (o != null) {
			}
			printCountingMap.put("separator", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("operation");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__OPERATION));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__OPERATION), element));
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
		print_edu_ustb_sei_mde_morel_OperationPathExp_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("next");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__NEXT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("next", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_OperationPathExp_0(edu.ustb.sei.mde.morel.OperationPathExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS));
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
			print_edu_ustb_sei_mde_morel_OperationPathExp_0_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edu_ustb_sei_mde_morel_OperationPathExp_0_0(edu.ustb.sei.mde.morel.OperationPathExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS));
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
	
	
	public void print_edu_ustb_sei_mde_morel_IteratorPathExp(edu.ustb.sei.mde.morel.IteratorPathExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__NEXT));
		printCountingMap.put("next", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR));
		printCountingMap.put("firstVar", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR));
		printCountingMap.put("secondVar", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__BODY_EXP));
		printCountingMap.put("bodyExp", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("firstVar");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("firstVar", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_IteratorPathExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("|");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("bodyExp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__BODY_EXP));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("bodyExp", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_IteratorPathExp_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_IteratorPathExp_0(edu.ustb.sei.mde.morel.IteratorPathExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("secondVar");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("secondVar", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_IteratorPathExp_1(edu.ustb.sei.mde.morel.IteratorPathExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("next");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__NEXT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("next", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_LetExp(edu.ustb.sei.mde.morel.LetExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__VARIABLES));
		printCountingMap.put("variables", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__IN_EXP));
		printCountingMap.put("inExp", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("let");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variables");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__VARIABLES));
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
			printCountingMap.put("variables", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_LetExp_0(element, localtab, out1, printCountingMap1);
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
		out.print("in");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("inExp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__IN_EXP));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("inExp", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_LetExp_0(edu.ustb.sei.mde.morel.LetExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variables");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__VARIABLES));
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
			printCountingMap.put("variables", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_ConditionExp(edu.ustb.sei.mde.morel.ConditionExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__THEN_BRANCH));
		printCountingMap.put("thenBranch", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__ELSE_BRANCH));
		printCountingMap.put("elseBranch", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("if");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__CONDITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("then");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("thenBranch");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__THEN_BRANCH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("thenBranch", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("else");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("elseBranch");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__ELSE_BRANCH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("elseBranch", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("endif");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_morel_BooleanImpliesExp(edu.ustb.sei.mde.morel.BooleanImpliesExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__LEFT));
		printCountingMap.put("left", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__RIGHT));
		printCountingMap.put("right", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("left");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__LEFT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("left", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_BooleanImpliesExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_BooleanImpliesExp_0(edu.ustb.sei.mde.morel.BooleanImpliesExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__OPERATOR));
			if (o != null) {
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("right");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__RIGHT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("right", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_BooleanOrExp(edu.ustb.sei.mde.morel.BooleanOrExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__CHILDREN));
		printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__OPERATORS));
		printCountingMap.put("operators", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_BooleanOrExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_BooleanOrExp_0(edu.ustb.sei.mde.morel.BooleanOrExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operators");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__OPERATORS));
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
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_BooleanAndExp(edu.ustb.sei.mde.morel.BooleanAndExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__CHILDREN));
		printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__OPERATORS));
		printCountingMap.put("operators", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_BooleanAndExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_BooleanAndExp_0(edu.ustb.sei.mde.morel.BooleanAndExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operators");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__OPERATORS));
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
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_RelationalExp(edu.ustb.sei.mde.morel.RelationalExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__LEFT));
		printCountingMap.put("left", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__RIGHT));
		printCountingMap.put("right", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("left");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__LEFT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("left", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_RelationalExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_RelationalExp_0(edu.ustb.sei.mde.morel.RelationalExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR));
			if (o != null) {
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("right");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__RIGHT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("right", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_AdditiveExp(edu.ustb.sei.mde.morel.AdditiveExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__CHILDREN));
		printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__OPERATORS));
		printCountingMap.put("operators", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_AdditiveExp_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edu_ustb_sei_mde_morel_AdditiveExp_0(edu.ustb.sei.mde.morel.AdditiveExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operators");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__OPERATORS));
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
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_MultiplicativeExp(edu.ustb.sei.mde.morel.MultiplicativeExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__CHILDREN));
		printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__OPERATORS));
		printCountingMap.put("operators", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_MultiplicativeExp_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edu_ustb_sei_mde_morel_MultiplicativeExp_0(edu.ustb.sei.mde.morel.MultiplicativeExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operators");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__OPERATORS));
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
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_UnaryExp(edu.ustb.sei.mde.morel.UnaryExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__CHILD));
		printCountingMap.put("child", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR));
			if (o != null) {
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("child");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__CHILD));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("child", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_BindExp(edu.ustb.sei.mde.morel.BindExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BIND_EXP__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BIND_EXP__VALUE_EXP));
		printCountingMap.put("valueExp", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BIND_EXP__SOURCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("<-");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("valueExp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BIND_EXP__VALUE_EXP));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("valueExp", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_DeclarativeStatement(edu.ustb.sei.mde.morel.DeclarativeStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.DECLARATIVE_STATEMENT__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.DECLARATIVE_STATEMENT__EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expression", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_edu_ustb_sei_mde_morel_IfStatement(edu.ustb.sei.mde.morel.IfStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__THEN_STATEMENT));
		printCountingMap.put("thenStatement", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__ELSE_STATEMENT));
		printCountingMap.put("elseStatement", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("if");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__CONDITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("thenStatement");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__THEN_STATEMENT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("thenStatement", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_IfStatement_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_IfStatement_0(edu.ustb.sei.mde.morel.IfStatement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("else");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("elseStatement");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__ELSE_STATEMENT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("elseStatement", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_ForStatement(edu.ustb.sei.mde.morel.ForStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__ITERATOR));
		printCountingMap.put("iterator", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__TERMINATION_EXP));
		printCountingMap.put("terminationExp", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__STEP_EXP));
		printCountingMap.put("stepExp", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__BODY_STATEMENT));
		printCountingMap.put("bodyStatement", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("for");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("iterator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__ITERATOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("iterator", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("terminationExp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__TERMINATION_EXP));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("terminationExp", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_ForStatement_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("bodyStatement");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__BODY_STATEMENT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("bodyStatement", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_ForStatement_0(edu.ustb.sei.mde.morel.ForStatement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("stepExp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__STEP_EXP));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("stepExp", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_BlockStatement(edu.ustb.sei.mde.morel.BlockStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BLOCK_STATEMENT__STATEMENTS));
		printCountingMap.put("statements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("statements");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BLOCK_STATEMENT__STATEMENTS));
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
	
	
	public void print_edu_ustb_sei_mde_morel_TransformationModel(edu.ustb.sei.mde.morel.TransformationModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__MODELS));
		printCountingMap.put("models", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__DATA_TYPES));
		printCountingMap.put("dataTypes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__RULES));
		printCountingMap.put("rules", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("transformation");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__NAME));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("models");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__MODELS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("models", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rules");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__RULES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rules", 0);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_Rule(edu.ustb.sei.mde.morel.Rule element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__PATTERNS));
		printCountingMap.put("patterns", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__NAME));
			if (o != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_Rule_0(element, localtab, out1, printCountingMap1);
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
		out.print("}");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_morel_Rule_0(edu.ustb.sei.mde.morel.Rule element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("patterns");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__PATTERNS));
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
			printCountingMap.put("patterns", count - 1);
		}
	}
	
	
	public void print_edu_ustb_sei_mde_morel_Pattern(edu.ustb.sei.mde.morel.Pattern element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__VARIABLES));
		printCountingMap.put("variables", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__LINK_CONSTRAINTS));
		printCountingMap.put("linkConstraints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__STATEMENTS));
		printCountingMap.put("statements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("match");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edu_ustb_sei_mde_morel_Pattern_0(element, localtab, out1, printCountingMap1);
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
		print_edu_ustb_sei_mde_morel_Pattern_1(element, localtab, out1, printCountingMap1);
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
		print_edu_ustb_sei_mde_morel_Pattern_2(element, localtab, out1, printCountingMap1);
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
	
	public void print_edu_ustb_sei_mde_morel_Pattern_0(edu.ustb.sei.mde.morel.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variables");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__VARIABLES));
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
			printCountingMap.put("variables", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_Pattern_0_0(element, localtab, out1, printCountingMap1);
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
		out.print(";");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_morel_Pattern_0_0(edu.ustb.sei.mde.morel.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variables");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__VARIABLES));
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
			printCountingMap.put("variables", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_Pattern_1(edu.ustb.sei.mde.morel.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("linkConstraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__LINK_CONSTRAINTS));
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
			printCountingMap.put("linkConstraints", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_Pattern_1_0(element, localtab, out1, printCountingMap1);
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
		out.print(";");
		out.print(" ");
	}
	
	public void print_edu_ustb_sei_mde_morel_Pattern_1_0(edu.ustb.sei.mde.morel.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("linkConstraints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__LINK_CONSTRAINTS));
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
			printCountingMap.put("linkConstraints", count - 1);
		}
	}
	
	public void print_edu_ustb_sei_mde_morel_Pattern_2(edu.ustb.sei.mde.morel.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("when");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edu_ustb_sei_mde_morel_Pattern_2_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edu_ustb_sei_mde_morel_Pattern_2_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edu_ustb_sei_mde_morel_Pattern_2_0(edu.ustb.sei.mde.morel.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("statements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__STATEMENTS));
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
			printCountingMap.put("statements", count - 1);
		}
	}
	
	
}
