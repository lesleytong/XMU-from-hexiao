grammar Morel;

options {
	superClass = MorelANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package edu.ustb.sei.mde.morel.resource.morel.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package edu.ustb.sei.mde.morel.resource.morel.mopp;
}

@members{
	private edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolverFactory tokenResolverFactory = new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal> expectedElements = new java.util.ArrayList<edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>() {
			public boolean execute(edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new edu.ustb.sei.mde.morel.resource.morel.IMorelProblem() {
					public edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity getSeverity() {
						return edu.ustb.sei.mde.morel.resource.morel.MorelEProblemSeverity.ERROR;
					}
					public edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType getType() {
						return edu.ustb.sei.mde.morel.resource.morel.MorelEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement terminal = edu.ustb.sei.mde.morel.resource.morel.grammar.MorelFollowSetProvider.TERMINALS[terminalID];
		edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[] containmentFeatures = new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = edu.ustb.sei.mde.morel.resource.morel.grammar.MorelFollowSetProvider.LINKS[ids[i]];
		}
		edu.ustb.sei.mde.morel.resource.morel.grammar.MorelContainmentTrace containmentTrace = new edu.ustb.sei.mde.morel.resource.morel.grammar.MorelContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal expectedElement = new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal(container, terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
			this.expectedElementsIndexOfLastCompleteElement = 0;
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>() {
			public boolean execute(edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>() {
			public boolean execute(edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>() {
			public boolean execute(edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new MorelParser(new org.antlr.runtime3_4_0.CommonTokenStream(new MorelLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new MorelParser(new org.antlr.runtime3_4_0.CommonTokenStream(new MorelLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new edu.ustb.sei.mde.morel.resource.morel.util.MorelRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public MorelParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((MorelLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((MorelLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.QueryModel.class) {
				return parse_edu_ustb_sei_mde_morel_QueryModel();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.TypedModel.class) {
				return parse_edu_ustb_sei_mde_morel_TypedModel();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.Query.class) {
				return parse_edu_ustb_sei_mde_morel_Query();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.ObjectVariable.class) {
				return parse_edu_ustb_sei_mde_morel_ObjectVariable();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.PrimitiveVariable.class) {
				return parse_edu_ustb_sei_mde_morel_PrimitiveVariable();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.ObjectVariableWithInit.class) {
				return parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.PrimitiveVariableWithInit.class) {
				return parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.SimpleLinkConstraint.class) {
				return parse_edu_ustb_sei_mde_morel_SimpleLinkConstraint();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.EnclosureLinkConstraint.class) {
				return parse_edu_ustb_sei_mde_morel_EnclosureLinkConstraint();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.PathConstraint.class) {
				return parse_edu_ustb_sei_mde_morel_PathConstraint();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.VariableExp.class) {
				return parse_edu_ustb_sei_mde_morel_VariableExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.NestedExp.class) {
				return parse_edu_ustb_sei_mde_morel_NestedExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.IntegerLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.RealLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_RealLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.StringLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_StringLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.BooleanLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.UndefinedLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.TypeLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_TypeLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.CollectionLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_CollectionLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.EnumLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_EnumLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.ArrayLiteralExp.class) {
				return parse_edu_ustb_sei_mde_morel_ArrayLiteralExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.FeaturePathExp.class) {
				return parse_edu_ustb_sei_mde_morel_FeaturePathExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.OperationPathExp.class) {
				return parse_edu_ustb_sei_mde_morel_OperationPathExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.IteratorPathExp.class) {
				return parse_edu_ustb_sei_mde_morel_IteratorPathExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.LetExp.class) {
				return parse_edu_ustb_sei_mde_morel_LetExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.ConditionExp.class) {
				return parse_edu_ustb_sei_mde_morel_ConditionExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.BooleanImpliesExp.class) {
				return parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.BooleanOrExp.class) {
				return parse_edu_ustb_sei_mde_morel_BooleanOrExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.BooleanAndExp.class) {
				return parse_edu_ustb_sei_mde_morel_BooleanAndExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.RelationalExp.class) {
				return parse_edu_ustb_sei_mde_morel_RelationalExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.AdditiveExp.class) {
				return parse_edu_ustb_sei_mde_morel_AdditiveExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.MultiplicativeExp.class) {
				return parse_edu_ustb_sei_mde_morel_MultiplicativeExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.UnaryExp.class) {
				return parse_edu_ustb_sei_mde_morel_UnaryExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.BindExp.class) {
				return parse_edu_ustb_sei_mde_morel_BindExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.PredefinedBindExp.class) {
				return parse_edu_ustb_sei_mde_morel_PredefinedBindExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.DeclarativeStatement.class) {
				return parse_edu_ustb_sei_mde_morel_DeclarativeStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.IfStatement.class) {
				return parse_edu_ustb_sei_mde_morel_IfStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.ForStatement.class) {
				return parse_edu_ustb_sei_mde_morel_ForStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.BlockStatement.class) {
				return parse_edu_ustb_sei_mde_morel_BlockStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.TransformationModel.class) {
				return parse_edu_ustb_sei_mde_morel_TransformationModel();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.Rule.class) {
				return parse_edu_ustb_sei_mde_morel_Rule();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.Pattern.class) {
				return parse_edu_ustb_sei_mde_morel_Pattern();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.PredefinedVariableExp.class) {
				return parse_edu_ustb_sei_mde_morel_PredefinedVariableExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.ReflectiveVariableExp.class) {
				return parse_edu_ustb_sei_mde_morel_ReflectiveVariableExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.OrderConstraint.class) {
				return parse_edu_ustb_sei_mde_morel_OrderConstraint();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.AllDifferentConstraint.class) {
				return parse_edu_ustb_sei_mde_morel_AllDifferentConstraint();
			}
		}
		throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelUnexpectedContentTypeException(typeObject);
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(edu.ustb.sei.mde.morel.resource.morel.IMorelOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public edu.ustb.sei.mde.morel.resource.morel.IMorelParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>>();
		edu.ustb.sei.mde.morel.resource.morel.mopp.MorelParseResult parseResult = new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		edu.ustb.sei.mde.morel.resource.morel.IMorelParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal>();
		java.util.List<edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal> newFollowSet = new java.util.ArrayList<edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 337;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.util.MorelPair<edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (edu.ustb.sei.mde.morel.resource.morel.util.MorelPair<edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[]> newFollowerPair : newFollowers) {
							edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							edu.ustb.sei.mde.morel.resource.morel.grammar.MorelContainmentTrace containmentTrace = new edu.ustb.sei.mde.morel.resource.morel.grammar.MorelContainmentTrace(null, newFollowerPair.getRight());
							edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal newFollowTerminal = new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal(container, newFollower, followSetID, containmentTrace);
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
		for (edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			boolean exists = this.incompleteObjects.remove(object);
			if (!exists) {
			}
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_edu_ustb_sei_mde_morel_QueryModel{ element = c0; }
		|  		c1 = parse_edu_ustb_sei_mde_morel_TransformationModel{ element = c1; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_edu_ustb_sei_mde_morel_QueryModel returns [edu.ustb.sei.mde.morel.QueryModel element = null]
@init{
}
:
	a0 = 'querymodel' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQueryModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2]);
	}
	
	(
		(
			a1_0 = parse_edu_ustb_sei_mde_morel_TypedModel			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQueryModel();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY_MODEL__MODELS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_0_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[5]);
	}
	
	(
		(
			a2_0 = parse_edu_ustb_sei_mde_morel_Query			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQueryModel();
					startIncompleteElement(element);
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						Object value = a2_0;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY_MODEL__QUERIES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_0_0_0_2, a2_0, true);
					copyLocalizationInfos(a2_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[7]);
	}
	
;

parse_edu_ustb_sei_mde_morel_TypedModel returns [edu.ustb.sei.mde.morel.TypedModel element = null]
@init{
}
:
	a0 = 'type' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.NORMAL_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[8]);
	}
	
	(
		(
			a1 = 'readOnly' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.NORMAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.READ_ONLY_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
				completedElement(value, false);
			}
			|			a2 = 'transient' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.NORMAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.TRANSIENT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
				completedElement(value, false);
			}
			|			a3 = 'view' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.NORMAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.VIEW_ONLY_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[9]);
	}
	
	(
		a6 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.NORMAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
			}
			if (a6 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[10]);
	}
	
	a7 = '<-' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.NORMAL_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[11]);
	}
	
	(
		a8 = URINS		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModelAction().getEEnumLiteral(edu.ustb.sei.mde.morel.TypedModelAction.NORMAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__TYPE), value);
			}
			if (a8 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("URINS");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__PACKAGE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EPackage proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.TypedModel, org.eclipse.emf.ecore.EPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypedModelPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__PACKAGE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__PACKAGE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[15]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[16]);
	}
	
;

parse_edu_ustb_sei_mde_morel_Query returns [edu.ustb.sei.mde.morel.Query element = null]
@init{
}
:
	(
		(
			(
				(
					a0 = 'active' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_0_0_0_0, true, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
						// set value of boolean attribute
						Object value = true;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__ACTIVE), value);
						completedElement(value, false);
					}
					|					a1 = 'passive' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_0_0_0_0, false, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of boolean attribute
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__ACTIVE), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[17]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[18]);
	}
	
	a3 = 'query' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[19]);
	}
	
	(
		(
			a4 = 'lhs' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				completedElement(value, false);
			}
			|			a5 = 'rhs' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.RHS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				completedElement(value, false);
			}
			|			a6 = 'nac' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.NAC_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				completedElement(value, false);
			}
			|			a7 = 'pac' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PAC_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				completedElement(value, false);
			}
			|			a8 = 'pre' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PRE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				completedElement(value, false);
			}
			|			a9 = 'post' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.POST_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[20]);
	}
	
	(
		a12 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
			}
			if (a12 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[22]);
	}
	
	(
		(
			a13 = '(' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[23]);
			}
			
			(
				a14 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
					}
					if (a14 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__PARAMETERS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__PARAMETERS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_4_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[24]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[25]);
			}
			
			(
				(
					a15 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_4_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[26]);
					}
					
					(
						a16 = IDENTIFIER						
						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
							}
							if (a16 != null) {
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
								tokenResolver.setOptions(getOptions());
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__PARAMETERS), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a16).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__PARAMETERS, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_4_0_0_2_0_0_1, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[27]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[28]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[29]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[30]);
			}
			
			a17 = ')' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_4_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[31]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[32]);
	}
	
	a18 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[33]);
	}
	
	a19 = 'match' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a19, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[39]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[40]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[41]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[42]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[43]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[44]);
	}
	
	(
		(
			(
				a20_0 = parse_edu_ustb_sei_mde_morel_Variable				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
					}
					if (a20_0 != null) {
						if (a20_0 != null) {
							Object value = a20_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__VARIABLES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_7_0_0_0, a20_0, true);
						copyLocalizationInfos(a20_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[45]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[46]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[47]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[48]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[50]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[51]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[52]);
			}
			
			(
				(
					a21 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_7_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[53]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[54]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[55]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[56]);
					}
					
					(
						a22_0 = parse_edu_ustb_sei_mde_morel_Variable						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
							}
							if (a22_0 != null) {
								if (a22_0 != null) {
									Object value = a22_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__VARIABLES, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_7_0_0_1_0_0_1, a22_0, true);
								copyLocalizationInfos(a22_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[57]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[58]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[59]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[60]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[61]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[62]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[63]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[64]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[65]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[66]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[67]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[68]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[69]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[70]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[71]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[72]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[76]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[77]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[79]);
	}
	
	(
		(
			(
				a23_0 = parse_edu_ustb_sei_mde_morel_LinkConstraint				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
					}
					if (a23_0 != null) {
						if (a23_0 != null) {
							Object value = a23_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__LINK_CONSTRAINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_8_0_0_0, a23_0, true);
						copyLocalizationInfos(a23_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[81]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[82]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[83]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[84]);
			}
			
			(
				(
					a24 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_8_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[85]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[86]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[87]);
					}
					
					(
						a25_0 = parse_edu_ustb_sei_mde_morel_LinkConstraint						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
							}
							if (a25_0 != null) {
								if (a25_0 != null) {
									Object value = a25_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__LINK_CONSTRAINTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_8_0_0_1_0_0_1, a25_0, true);
								copyLocalizationInfos(a25_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[88]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[89]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[90]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[91]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[92]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[93]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[94]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[95]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[96]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[97]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[101]);
	}
	
	(
		(
			(
				a26_0 = parse_edu_ustb_sei_mde_morel_AdditionalConstraint				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
					}
					if (a26_0 != null) {
						if (a26_0 != null) {
							Object value = a26_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__ADDITIONAL_CONSTRAINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_9_0_0_0, a26_0, true);
						copyLocalizationInfos(a26_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[102]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[103]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[104]);
			}
			
			(
				(
					a27 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_9_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a27, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[105]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[106]);
					}
					
					(
						a28_0 = parse_edu_ustb_sei_mde_morel_AdditionalConstraint						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
							}
							if (a28_0 != null) {
								if (a28_0 != null) {
									Object value = a28_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__ADDITIONAL_CONSTRAINTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_9_0_0_1_0_0_1, a28_0, true);
								copyLocalizationInfos(a28_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[107]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[108]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[109]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[110]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[111]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[112]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[114]);
	}
	
	(
		(
			a29 = 'where' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_10_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a29, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[115]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[116]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[117]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[118]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[119]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[120]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[121]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[122]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[123]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[124]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[125]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[126]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[127]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[128]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[129]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[130]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[131]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[132]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[133]);
			}
			
			(
				(
					(
						a30_0 = parse_edu_ustb_sei_mde_morel_Statement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
							}
							if (a30_0 != null) {
								if (a30_0 != null) {
									Object value = a30_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__STATEMENTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_10_0_0_1_0_0_0, a30_0, true);
								copyLocalizationInfos(a30_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[134]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[135]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[136]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[137]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[138]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[139]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[140]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[141]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[142]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[143]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[144]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[145]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[146]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[147]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[148]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[149]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[150]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[151]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[152]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[153]);
					}
					
				)
				
			)+			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[154]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[155]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[156]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[157]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[158]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[159]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[160]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[161]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[162]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[163]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[164]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[165]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[166]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[167]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[168]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[169]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[170]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[171]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[172]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[173]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[174]);
	}
	
	a31 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a31, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[177]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[178]);
	}
	
;

parse_edu_ustb_sei_mde_morel_ObjectVariable returns [edu.ustb.sei.mde.morel.ObjectVariable element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_3_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[179]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[180]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[181]);
	}
	
	(
		(
			(
				a2 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__MODEL), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edu.ustb.sei.mde.morel.TypedModel proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.ObjectVariable, edu.ustb.sei.mde.morel.TypedModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectVariableModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__MODEL), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__MODEL), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_3_0_0_2_0_0_0, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[182]);
			}
			
			a3 = '!' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_3_0_0_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[183]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[184]);
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.ObjectVariable, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectVariableTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_3_0_0_3, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[195]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[197]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_PrimitiveVariable returns [edu.ustb.sei.mde.morel.PrimitiveVariable element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariable();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_4_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[198]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_4_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[199]);
	}
	
	(
		a2 = DATA_TYPE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariable();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATA_TYPE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EDataType proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEDataType();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.PrimitiveVariable, org.eclipse.emf.ecore.EDataType>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPrimitiveVariableTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_4_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[203]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[204]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[205]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[206]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[207]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[212]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit returns [edu.ustb.sei.mde.morel.ObjectVariableWithInit element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[213]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[214]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[215]);
	}
	
	(
		(
			(
				a2 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__MODEL), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edu.ustb.sei.mde.morel.TypedModel proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.ObjectVariable, edu.ustb.sei.mde.morel.TypedModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectVariableModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__MODEL), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__MODEL), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_2_0_0_0, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[216]);
			}
			
			a3 = '!' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[217]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[218]);
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.ObjectVariable, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectVariableTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_3, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[219]);
	}
	
	a5 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[220]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[221]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[222]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[223]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[224]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[225]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[226]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[227]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[228]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[229]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[230]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[231]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[232]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[233]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[234]);
	}
	
	(
		a6_0 = parse_edu_ustb_sei_mde_morel_LetExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
				startIncompleteElement(element);
			}
			if (a6_0 != null) {
				if (a6_0 != null) {
					Object value = a6_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_5, a6_0, true);
				copyLocalizationInfos(a6_0, element);
			}
		}
		|		a6_1 = parse_edu_ustb_sei_mde_morel_ConditionExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
				startIncompleteElement(element);
			}
			if (a6_1 != null) {
				if (a6_1 != null) {
					Object value = a6_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_5, a6_1, true);
				copyLocalizationInfos(a6_1, element);
			}
		}
		|		a6_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
				startIncompleteElement(element);
			}
			if (a6_2 != null) {
				if (a6_2 != null) {
					Object value = a6_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_5, a6_2, true);
				copyLocalizationInfos(a6_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[235]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[236]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[238]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[240]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[241]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[242]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[243]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[244]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[245]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[246]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[247]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[248]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[249]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[250]);
	}
	
;

parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit returns [edu.ustb.sei.mde.morel.PrimitiveVariableWithInit element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[251]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[252]);
	}
	
	(
		a2 = DATA_TYPE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATA_TYPE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EDataType proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEDataType();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.PrimitiveVariable, org.eclipse.emf.ecore.EDataType>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPrimitiveVariableTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[253]);
	}
	
	a3 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[254]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[255]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[256]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[257]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[258]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[260]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[261]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[262]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[264]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[268]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_morel_LetExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__INIT_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_4, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
		|		a4_1 = parse_edu_ustb_sei_mde_morel_ConditionExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
				startIncompleteElement(element);
			}
			if (a4_1 != null) {
				if (a4_1 != null) {
					Object value = a4_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__INIT_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_4, a4_1, true);
				copyLocalizationInfos(a4_1, element);
			}
		}
		|		a4_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
				startIncompleteElement(element);
			}
			if (a4_2 != null) {
				if (a4_2 != null) {
					Object value = a4_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT__INIT_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_4, a4_2, true);
				copyLocalizationInfos(a4_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[270]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[271]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[272]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[273]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[274]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[275]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[276]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[277]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[278]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[279]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[280]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[281]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[282]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[283]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[284]);
	}
	
;

parse_edu_ustb_sei_mde_morel_SimpleLinkConstraint returns [edu.ustb.sei.mde.morel.SimpleLinkConstraint element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__SOURCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__SOURCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__SOURCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[285]);
	}
	
	a1 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[286]);
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.SimpleLinkConstraint, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSimpleLinkConstraintReferenceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__REFERENCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[287]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[288]);
	}
	
	(
		(
			a3 = '[' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[289]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[290]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[291]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[292]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[293]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[294]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[295]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[296]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[297]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[298]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[299]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[300]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[301]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[302]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[303]);
			}
			
			(
				a4_0 = parse_edu_ustb_sei_mde_morel_PredefinedBindExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__ID), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_3_0_0_1, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
				|				a4_1 = parse_edu_ustb_sei_mde_morel_BindExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
						startIncompleteElement(element);
					}
					if (a4_1 != null) {
						if (a4_1 != null) {
							Object value = a4_1;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__ID), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_3_0_0_1, a4_1, true);
						copyLocalizationInfos(a4_1, element);
					}
				}
				|				a4_2 = parse_edu_ustb_sei_mde_morel_LetExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
						startIncompleteElement(element);
					}
					if (a4_2 != null) {
						if (a4_2 != null) {
							Object value = a4_2;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__ID), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_3_0_0_1, a4_2, true);
						copyLocalizationInfos(a4_2, element);
					}
				}
				|				a4_3 = parse_edu_ustb_sei_mde_morel_ConditionExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
						startIncompleteElement(element);
					}
					if (a4_3 != null) {
						if (a4_3 != null) {
							Object value = a4_3;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__ID), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_3_0_0_1, a4_3, true);
						copyLocalizationInfos(a4_3, element);
					}
				}
				|				a4_4 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
						startIncompleteElement(element);
					}
					if (a4_4 != null) {
						if (a4_4 != null) {
							Object value = a4_4;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__ID), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_3_0_0_1, a4_4, true);
						copyLocalizationInfos(a4_4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[304]);
			}
			
			a5 = ']' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_3_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[305]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[306]);
	}
	
	a6 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[307]);
	}
	
	(
		a7 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createSimpleLinkConstraint();
				startIncompleteElement(element);
			}
			if (a7 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__TARGET), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__TARGET), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.SIMPLE_LINK_CONSTRAINT__TARGET), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_5, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[308]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[309]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[310]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[311]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[312]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[313]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[314]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[315]);
	}
	
;

parse_edu_ustb_sei_mde_morel_EnclosureLinkConstraint returns [edu.ustb.sei.mde.morel.EnclosureLinkConstraint element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__SOURCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__SOURCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__SOURCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[316]);
	}
	
	a1 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[317]);
	}
	
	(
		(
			a2 = IDENTIFIER			
			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
					collectHiddenTokens(element);
					registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnclosureLinkConstraintForwardReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD, value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_2_0_0_0, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[318]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[319]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[320]);
		}
		
		(
			(
				a3 = '|' {
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_2_0_0_1_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[321]);
				}
				
				(
					a4 = IDENTIFIER					
					{
						if (terminateParsing) {
							throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
						}
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
							startIncompleteElement(element);
						}
						if (a4 != null) {
							edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
							tokenResolver.setOptions(getOptions());
							edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
							}
							String resolved = (String) resolvedObject;
							org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
							collectHiddenTokens(element);
							registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnclosureLinkConstraintForwardReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD), resolved, proxy);
							if (proxy != null) {
								Object value = proxy;
								addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__FORWARD, value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_2_0_0_1_0_0_1, proxy, true);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[322]);
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[323]);
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[324]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[325]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[326]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[327]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[328]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[329]);
	}
	
	(
		(
			a5 = ':' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[330]);
			}
			
			(
				a6 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
						startIncompleteElement(element);
					}
					if (a6 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnclosureLinkConstraintTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_3_0_0_1, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[331]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[332]);
			}
			
			(
				(
					a7 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_3_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[333]);
					}
					
					(
						a8 = IDENTIFIER						
						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
								startIncompleteElement(element);
							}
							if (a8 != null) {
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
								tokenResolver.setOptions(getOptions());
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnclosureLinkConstraintTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TYPES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_3_0_0_2_0_0_1, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[334]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[335]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[336]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[337]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[338]);
	}
	
	a9 = '*' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[339]);
	}
	
	a10 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[340]);
	}
	
	(
		a11 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnclosureLinkConstraint();
				startIncompleteElement(element);
			}
			if (a11 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TARGET), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TARGET), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENCLOSURE_LINK_CONSTRAINT__TARGET), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_6, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[341]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[342]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[343]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[344]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[345]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[346]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[347]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[348]);
	}
	
;

parse_edu_ustb_sei_mde_morel_PathConstraint returns [edu.ustb.sei.mde.morel.PathConstraint element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__SOURCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__SOURCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__SOURCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[349]);
	}
	
	a1 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[350]);
	}
	
	(
		(
			a2 = IDENTIFIER			
			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__REFERENCES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
					collectHiddenTokens(element);
					registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPathConstraintReferencesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__REFERENCES), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__REFERENCES, value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_2_0_0_0, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[351]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[352]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[353]);
		}
		
		(
			(
				a3 = '|' {
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_2_0_0_1_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[354]);
				}
				
				(
					a4 = IDENTIFIER					
					{
						if (terminateParsing) {
							throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
						}
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
							startIncompleteElement(element);
						}
						if (a4 != null) {
							edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
							tokenResolver.setOptions(getOptions());
							edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__REFERENCES), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
							}
							String resolved = (String) resolvedObject;
							org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
							collectHiddenTokens(element);
							registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPathConstraintReferencesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__REFERENCES), resolved, proxy);
							if (proxy != null) {
								Object value = proxy;
								addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__REFERENCES, value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_2_0_0_1_0_0_1, proxy, true);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[355]);
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[356]);
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[357]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[358]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[359]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[360]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[361]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[362]);
	}
	
	(
		(
			a5 = ':' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[363]);
			}
			
			(
				a6 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
						startIncompleteElement(element);
					}
					if (a6 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TYPES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPathConstraintTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TYPES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TYPES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_3_0_0_1, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[364]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[365]);
			}
			
			(
				(
					a7 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_3_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[366]);
					}
					
					(
						a8 = IDENTIFIER						
						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
								startIncompleteElement(element);
							}
							if (a8 != null) {
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
								tokenResolver.setOptions(getOptions());
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TYPES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPathConstraintTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TYPES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TYPES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_3_0_0_2_0_0_1, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[367]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[368]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[369]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[370]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[371]);
	}
	
	a9 = 'in' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[372]);
	}
	
	(
		a10 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
				startIncompleteElement(element);
			}
			if (a10 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.Variable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.PathConstraint, edu.ustb.sei.mde.morel.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPathConstraintPathVariableReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__PATH_VARIABLE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_5, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[373]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[374]);
	}
	
	(
		(
			a11 = '[' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[375]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[376]);
			}
			
			(
				(
					(
						a12 = INUMBER						
						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
								startIncompleteElement(element);
							}
							if (a12 != null) {
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INUMBER");
								tokenResolver.setOptions(getOptions());
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__MIN_LENGTH), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
								}
								java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__MIN_LENGTH), value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_6_0_0_1_0_0_0, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[377]);
					}
					
					a13 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_6_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[378]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[379]);
			}
			
			(
				a14 = INUMBER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
						startIncompleteElement(element);
					}
					if (a14 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INUMBER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__MAX_LENGTH), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__MAX_LENGTH), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_6_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[380]);
			}
			
			a15 = ']' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_6_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[381]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[382]);
	}
	
	a16 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[383]);
	}
	
	(
		a17 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPathConstraint();
				startIncompleteElement(element);
			}
			if (a17 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a17.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TARGET), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a17).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a17).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a17).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a17).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TARGET), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATH_CONSTRAINT__TARGET), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_8, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a17, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a17, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[384]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[385]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[386]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[387]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[388]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[389]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[390]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[391]);
	}
	
;

parse_edu_ustb_sei_mde_morel_VariableExp returns [edu.ustb.sei.mde.morel.VariableExp element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createVariableExp();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__REFERRED_VARIABLE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.Variable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.VariableExp, edu.ustb.sei.mde.morel.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableExpReferredVariableReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__REFERRED_VARIABLE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__REFERRED_VARIABLE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_10_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[392]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[393]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[394]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[395]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[396]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[397]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[398]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[399]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[400]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[401]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[402]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[403]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[404]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[405]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[406]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[407]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[408]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[409]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[410]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[411]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[412]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[413]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[414]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[415]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[416]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[417]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[418]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[419]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[420]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[421]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[422]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[423]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[424]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[425]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[426]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[427]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createVariableExp();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.VARIABLE_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_10_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[428]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[429]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[430]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[431]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[432]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[433]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[434]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[435]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[436]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[437]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[438]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[439]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[440]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[441]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[442]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[443]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[444]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[445]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[446]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[447]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[448]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[449]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[450]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[451]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[452]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[453]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[454]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[455]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[456]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[457]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[458]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[459]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[460]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[461]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[462]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[463]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[464]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[465]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[466]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[467]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[468]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[469]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[470]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[471]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[472]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[473]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[474]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[475]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[476]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[477]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[478]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[479]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[480]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[481]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[482]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[483]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[484]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[485]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[486]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[487]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[488]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[489]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[490]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[491]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[492]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[493]);
	}
	
;

parse_edu_ustb_sei_mde_morel_NestedExp returns [edu.ustb.sei.mde.morel.NestedExp element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createNestedExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_11_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[494]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[495]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[496]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[497]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[498]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[499]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[500]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[501]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[502]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[503]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[504]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[505]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[506]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[507]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[508]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_morel_LetExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createNestedExp();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.NESTED_EXP__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_11_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
		|		a1_1 = parse_edu_ustb_sei_mde_morel_ConditionExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createNestedExp();
				startIncompleteElement(element);
			}
			if (a1_1 != null) {
				if (a1_1 != null) {
					Object value = a1_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.NESTED_EXP__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_11_0_0_1, a1_1, true);
				copyLocalizationInfos(a1_1, element);
			}
		}
		|		a1_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createNestedExp();
				startIncompleteElement(element);
			}
			if (a1_2 != null) {
				if (a1_2 != null) {
					Object value = a1_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.NESTED_EXP__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_11_0_0_1, a1_2, true);
				copyLocalizationInfos(a1_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[509]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createNestedExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_11_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[510]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[511]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[512]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[513]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[514]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[515]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[516]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[517]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[518]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[519]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[520]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[521]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[522]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[523]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[524]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[525]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[526]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[527]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[528]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[529]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[530]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[531]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[532]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[533]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[534]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[535]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[536]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[537]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[538]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[539]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[540]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[541]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[542]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[543]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[544]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[545]);
	}
	
	(
		(
			(
				a3_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createNestedExp();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.NESTED_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_11_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[546]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[547]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[548]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[549]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[550]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[551]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[552]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[553]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[554]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[555]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[556]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[557]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[558]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[559]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[560]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[561]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[562]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[563]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[564]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[565]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[566]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[567]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[568]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[569]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[570]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[571]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[572]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[573]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[574]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[575]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[576]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[577]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[578]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[579]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[580]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[581]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[582]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[583]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[584]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[585]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[586]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[587]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[588]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[589]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[590]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[591]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[592]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[593]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[594]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[595]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[596]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[597]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[598]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[599]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[600]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[601]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[602]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[603]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[604]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[605]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[606]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[607]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[608]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[609]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[610]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[611]);
	}
	
;

parse_edu_ustb_sei_mde_morel_IntegerLiteralExp returns [edu.ustb.sei.mde.morel.IntegerLiteralExp element = null]
@init{
}
:
	(
		a0 = INUMBER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIntegerLiteralExp();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INUMBER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_12_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[612]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[613]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[614]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[615]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[616]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[617]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[618]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[619]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[620]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[621]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[622]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[623]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[624]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[625]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[626]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[627]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[628]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[629]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[630]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[631]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[632]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[633]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[634]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[635]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[636]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[637]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[638]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[639]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[640]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[641]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[642]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[643]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[644]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[645]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[646]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[647]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIntegerLiteralExp();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.INTEGER_LITERAL_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_12_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[648]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[649]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[650]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[651]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[652]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[653]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[654]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[655]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[656]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[657]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[658]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[659]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[660]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[661]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[662]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[663]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[664]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[665]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[666]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[667]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[668]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[669]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[670]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[671]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[672]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[673]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[674]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[675]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[676]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[677]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[678]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[679]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[680]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[681]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[682]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[683]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[684]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[685]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[686]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[687]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[688]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[689]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[690]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[691]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[692]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[693]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[694]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[695]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[696]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[697]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[698]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[699]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[700]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[701]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[702]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[703]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[704]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[705]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[706]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[707]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[708]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[709]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[710]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[711]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[712]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[713]);
	}
	
;

parse_edu_ustb_sei_mde_morel_RealLiteralExp returns [edu.ustb.sei.mde.morel.RealLiteralExp element = null]
@init{
}
:
	(
		a0 = RNUMBER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRealLiteralExp();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("RNUMBER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REAL_LITERAL_EXP__REAL_SYMBOL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Double resolved = (java.lang.Double) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REAL_LITERAL_EXP__REAL_SYMBOL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_13_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[714]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[715]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[716]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[717]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[718]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[719]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[720]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[721]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[722]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[723]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[724]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[725]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[726]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[727]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[728]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[729]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[730]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[731]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[732]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[733]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[734]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[735]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[736]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[737]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[738]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[739]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[740]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[741]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[742]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[743]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[744]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[745]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[746]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[747]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[748]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[749]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRealLiteralExp();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REAL_LITERAL_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_13_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[750]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[751]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[752]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[753]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[754]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[755]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[756]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[757]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[758]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[759]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[760]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[761]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[762]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[763]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[764]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[765]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[766]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[767]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[768]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[769]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[770]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[771]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[772]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[773]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[774]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[775]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[776]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[777]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[778]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[779]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[780]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[781]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[782]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[783]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[784]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[785]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[786]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[787]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[788]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[789]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[790]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[791]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[792]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[793]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[794]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[795]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[796]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[797]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[798]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[799]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[800]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[801]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[802]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[803]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[804]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[805]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[806]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[807]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[808]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[809]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[810]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[811]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[812]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[813]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[814]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[815]);
	}
	
;

parse_edu_ustb_sei_mde_morel_StringLiteralExp returns [edu.ustb.sei.mde.morel.StringLiteralExp element = null]
@init{
}
:
	(
		a0 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createStringLiteralExp();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.STRING_LITERAL_EXP__STRING_SYMBOL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.STRING_LITERAL_EXP__STRING_SYMBOL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_14_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[816]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[817]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[818]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[819]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[820]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[821]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[822]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[823]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[824]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[825]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[826]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[827]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[828]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[829]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[830]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[831]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[832]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[833]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[834]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[835]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[836]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[837]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[838]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[839]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[840]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[841]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[842]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[843]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[844]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[845]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[846]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[847]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[848]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[849]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[850]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[851]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createStringLiteralExp();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.STRING_LITERAL_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_14_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[852]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[853]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[854]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[855]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[856]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[857]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[858]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[859]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[860]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[861]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[862]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[863]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[864]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[865]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[866]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[867]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[868]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[869]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[870]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[871]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[872]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[873]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[874]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[875]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[876]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[877]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[878]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[879]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[880]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[881]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[882]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[883]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[884]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[885]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[886]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[887]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[888]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[889]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[890]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[891]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[892]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[893]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[894]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[895]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[896]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[897]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[898]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[899]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[900]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[901]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[902]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[903]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[904]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[905]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[906]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[907]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[908]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[909]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[910]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[911]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[912]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[913]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[914]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[915]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[916]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[917]);
	}
	
;

parse_edu_ustb_sei_mde_morel_BooleanLiteralExp returns [edu.ustb.sei.mde.morel.BooleanLiteralExp element = null]
@init{
}
:
	(
		(
			a0 = 'true' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanLiteralExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_0, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__BOOL_SYMBOL), value);
				completedElement(value, false);
			}
			|			a1 = 'false' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanLiteralExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_0, false, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__BOOL_SYMBOL), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[918]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[919]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[920]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[921]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[922]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[923]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[924]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[925]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[926]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[927]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[928]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[929]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[930]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[931]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[932]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[933]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[934]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[935]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[936]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[937]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[938]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[939]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[940]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[941]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[942]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[943]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[944]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[945]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[946]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[947]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[948]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[949]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[950]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[951]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[952]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[953]);
	}
	
	(
		(
			(
				a3_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanLiteralExp();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_1_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[954]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[955]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[956]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[957]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[958]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[959]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[960]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[961]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[962]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[963]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[964]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[965]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[966]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[967]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[968]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[969]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[970]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[971]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[972]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[973]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[974]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[975]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[976]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[977]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[978]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[979]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[980]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[981]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[982]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[983]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[984]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[985]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[986]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[987]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[988]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[989]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[990]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[991]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[992]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[993]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[994]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[995]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[996]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[997]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[998]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[999]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1000]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1001]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1002]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1003]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1004]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1005]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1006]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1007]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1008]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1009]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1010]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1011]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1012]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1013]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1014]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1015]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1016]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1017]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1018]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1019]);
	}
	
;

parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp returns [edu.ustb.sei.mde.morel.UndefinedLiteralExp element = null]
@init{
}
:
	(
		(
			a0 = 'null' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUndefinedLiteralExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteral().getEEnumLiteral(edu.ustb.sei.mde.morel.UndefinedLiteral.NULL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__VALUE), value);
				completedElement(value, false);
			}
			|			a1 = 'invalid' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUndefinedLiteralExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteral().getEEnumLiteral(edu.ustb.sei.mde.morel.UndefinedLiteral.INVALID_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__VALUE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1020]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1021]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1022]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1023]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1024]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1025]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1026]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1027]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1028]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1029]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1030]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1031]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1032]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1033]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1034]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1035]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1036]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1037]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1038]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1039]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1040]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1041]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1042]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1043]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1044]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1045]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1046]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1047]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1048]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1049]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1050]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1051]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1052]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1053]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1054]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1055]);
	}
	
	(
		(
			(
				a4_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUndefinedLiteralExp();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_1_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1056]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1057]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1058]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1059]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1060]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1061]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1062]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1063]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1064]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1065]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1066]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1067]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1068]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1069]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1070]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1071]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1072]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1073]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1074]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1075]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1076]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1077]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1078]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1079]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1080]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1081]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1082]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1083]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1084]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1085]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1086]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1087]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1088]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1089]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1090]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1091]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1092]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1093]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1094]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1095]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1096]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1097]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1098]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1099]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1100]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1101]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1102]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1103]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1104]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1105]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1106]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1107]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1108]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1109]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1110]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1111]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1112]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1113]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1114]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1115]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1116]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1117]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1118]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1119]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1120]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1121]);
	}
	
;

parse_edu_ustb_sei_mde_morel_TypeLiteralExp returns [edu.ustb.sei.mde.morel.TypeLiteralExp element = null]
@init{
}
:
	(
		a0 = DATA_TYPE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypeLiteralExp();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATA_TYPE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EClassifier proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderedSetType();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.TypeLiteralExp, org.eclipse.emf.ecore.EClassifier>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypeLiteralExpValueReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__VALUE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1122]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1123]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1124]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1125]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1126]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1127]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1128]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1129]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1130]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1131]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1132]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1133]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1134]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1135]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1136]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1137]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1138]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1139]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1140]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1141]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1142]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1143]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1144]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1145]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1146]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1147]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1148]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1149]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1150]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1151]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1152]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1153]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1154]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1155]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1156]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1157]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypeLiteralExp();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPE_LITERAL_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1158]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1159]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1160]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1161]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1162]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1163]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1164]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1165]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1166]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1167]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1168]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1169]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1170]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1171]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1172]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1173]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1174]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1175]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1176]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1177]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1178]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1179]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1180]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1181]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1182]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1183]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1184]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1185]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1186]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1187]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1188]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1189]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1190]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1191]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1192]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1193]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1194]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1195]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1196]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1197]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1198]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1199]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1200]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1201]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1202]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1203]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1204]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1205]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1206]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1207]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1208]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1209]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1210]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1211]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1212]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1213]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1214]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1215]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1216]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1217]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1218]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1219]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1220]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1221]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1222]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1223]);
	}
	
;

parse_edu_ustb_sei_mde_morel_CollectionLiteralExp returns [edu.ustb.sei.mde.morel.CollectionLiteralExp element = null]
@init{
}
:
	(
		a0 = COLLECTION		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("COLLECTION");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1224]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1225]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1226]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1227]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1228]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1229]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1230]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1231]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1232]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1233]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1234]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1235]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1236]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1237]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1238]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1239]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1240]);
	}
	
	(
		(
			(
				(
					a2_0 = parse_edu_ustb_sei_mde_morel_LetExp					{
						if (terminateParsing) {
							throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
						}
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
							startIncompleteElement(element);
						}
						if (a2_0 != null) {
							if (a2_0 != null) {
								Object value = a2_0;
								addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__LITERALS, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2_0_0_0_0_0_0, a2_0, true);
							copyLocalizationInfos(a2_0, element);
						}
					}
					|					a2_1 = parse_edu_ustb_sei_mde_morel_ConditionExp					{
						if (terminateParsing) {
							throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
						}
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
							startIncompleteElement(element);
						}
						if (a2_1 != null) {
							if (a2_1 != null) {
								Object value = a2_1;
								addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__LITERALS, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2_0_0_0_0_0_0, a2_1, true);
							copyLocalizationInfos(a2_1, element);
						}
					}
					|					a2_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp					{
						if (terminateParsing) {
							throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
						}
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
							startIncompleteElement(element);
						}
						if (a2_2 != null) {
							if (a2_2 != null) {
								Object value = a2_2;
								addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__LITERALS, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2_0_0_0_0_0_0, a2_2, true);
							copyLocalizationInfos(a2_2, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1241]);
					addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1242]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1243]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1244]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1245]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1246]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1247]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1248]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1249]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1250]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1251]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1252]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1253]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1254]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1255]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1256]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1257]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1258]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1259]);
					}
					
					(
						a4_0 = parse_edu_ustb_sei_mde_morel_LetExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
								startIncompleteElement(element);
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									Object value = a4_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__LITERALS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2_0_0_1_0_0_1, a4_0, true);
								copyLocalizationInfos(a4_0, element);
							}
						}
						|						a4_1 = parse_edu_ustb_sei_mde_morel_ConditionExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
								startIncompleteElement(element);
							}
							if (a4_1 != null) {
								if (a4_1 != null) {
									Object value = a4_1;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__LITERALS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2_0_0_1_0_0_1, a4_1, true);
								copyLocalizationInfos(a4_1, element);
							}
						}
						|						a4_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
								startIncompleteElement(element);
							}
							if (a4_2 != null) {
								if (a4_2 != null) {
									Object value = a4_2;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__LITERALS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2_0_0_1_0_0_1, a4_2, true);
								copyLocalizationInfos(a4_2, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1260]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1261]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1262]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1263]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1264]);
	}
	
	a5 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1265]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1266]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1267]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1268]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1269]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1270]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1271]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1272]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1273]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1274]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1275]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1276]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1277]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1278]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1279]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1280]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1281]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1282]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1283]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1284]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1285]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1286]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1287]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1288]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1289]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1290]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1291]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1292]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1293]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1294]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1295]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1296]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1297]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1298]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1299]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1300]);
	}
	
	(
		(
			(
				a6_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createCollectionLiteralExp();
						startIncompleteElement(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.COLLECTION_LITERAL_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_4_0_0_0, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1301]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1302]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1303]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1304]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1305]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1306]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1307]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1308]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1309]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1310]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1311]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1312]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1313]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1314]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1315]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1316]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1317]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1318]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1319]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1320]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1321]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1322]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1323]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1324]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1325]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1326]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1327]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1328]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1329]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1330]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1331]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1332]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1333]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1334]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1335]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1336]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1337]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1338]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1339]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1340]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1341]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1342]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1343]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1344]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1345]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1346]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1347]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1348]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1349]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1350]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1351]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1352]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1353]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1354]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1355]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1356]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1357]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1358]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1359]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1360]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1361]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1362]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1363]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1364]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1365]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1366]);
	}
	
;

parse_edu_ustb_sei_mde_morel_EnumLiteralExp returns [edu.ustb.sei.mde.morel.EnumLiteralExp element = null]
@init{
}
:
	(
		a0 = DATA_TYPE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnumLiteralExp();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATA_TYPE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EEnum proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnum();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralExpEnumTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1367]);
	}
	
	a1 = '::' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnumLiteralExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1368]);
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnumLiteralExp();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EEnumLiteral proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnumLiteral();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralExpEnumSymbolReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1369]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1370]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1371]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1372]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1373]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1374]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1375]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1376]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1377]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1378]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1379]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1380]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1381]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1382]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1383]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1384]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1385]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1386]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1387]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1388]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1389]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1390]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1391]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1392]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1393]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1394]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1395]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1396]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1397]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1398]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1399]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1400]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1401]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1402]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1403]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1404]);
	}
	
	(
		(
			(
				a3_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createEnumLiteralExp();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ENUM_LITERAL_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1405]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1406]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1407]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1408]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1409]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1410]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1411]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1412]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1413]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1414]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1415]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1416]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1417]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1418]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1419]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1420]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1421]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1422]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1423]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1424]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1425]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1426]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1427]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1428]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1429]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1430]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1431]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1432]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1433]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1434]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1435]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1436]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1437]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1438]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1439]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1440]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1441]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1442]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1443]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1444]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1445]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1446]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1447]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1448]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1449]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1450]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1451]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1452]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1453]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1454]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1455]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1456]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1457]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1458]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1459]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1460]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1461]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1462]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1463]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1464]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1465]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1466]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1467]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1468]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1469]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1470]);
	}
	
;

parse_edu_ustb_sei_mde_morel_ArrayLiteralExp returns [edu.ustb.sei.mde.morel.ArrayLiteralExp element = null]
@init{
}
:
	a0 = '<' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1471]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1472]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1473]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1474]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1475]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1476]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1477]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1478]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1479]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1480]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1481]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1482]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1483]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1484]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1485]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1486]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1487]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_morel_LetExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ARRAY_LITERAL_EXP__ELEMENTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
				|				a1_1 = parse_edu_ustb_sei_mde_morel_ConditionExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
						startIncompleteElement(element);
					}
					if (a1_1 != null) {
						if (a1_1 != null) {
							Object value = a1_1;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ARRAY_LITERAL_EXP__ELEMENTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_0, a1_1, true);
						copyLocalizationInfos(a1_1, element);
					}
				}
				|				a1_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
						startIncompleteElement(element);
					}
					if (a1_2 != null) {
						if (a1_2 != null) {
							Object value = a1_2;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ARRAY_LITERAL_EXP__ELEMENTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_0, a1_2, true);
						copyLocalizationInfos(a1_2, element);
					}
				}
				|				a1_3 = parse_edu_ustb_sei_mde_morel_ReflectiveVariableExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
						startIncompleteElement(element);
					}
					if (a1_3 != null) {
						if (a1_3 != null) {
							Object value = a1_3;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ARRAY_LITERAL_EXP__ELEMENTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_0, a1_3, true);
						copyLocalizationInfos(a1_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1488]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1489]);
			}
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1490]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1491]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1492]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1493]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1494]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1495]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1496]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1497]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1498]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1499]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1500]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1501]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1502]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1503]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1504]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1505]);
					}
					
					(
						a3_0 = parse_edu_ustb_sei_mde_morel_LetExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
								startIncompleteElement(element);
							}
							if (a3_0 != null) {
								if (a3_0 != null) {
									Object value = a3_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ARRAY_LITERAL_EXP__ELEMENTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_1_0_0_1, a3_0, true);
								copyLocalizationInfos(a3_0, element);
							}
						}
						|						a3_1 = parse_edu_ustb_sei_mde_morel_ConditionExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
								startIncompleteElement(element);
							}
							if (a3_1 != null) {
								if (a3_1 != null) {
									Object value = a3_1;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ARRAY_LITERAL_EXP__ELEMENTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_1_0_0_1, a3_1, true);
								copyLocalizationInfos(a3_1, element);
							}
						}
						|						a3_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
								startIncompleteElement(element);
							}
							if (a3_2 != null) {
								if (a3_2 != null) {
									Object value = a3_2;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ARRAY_LITERAL_EXP__ELEMENTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_1_0_0_1, a3_2, true);
								copyLocalizationInfos(a3_2, element);
							}
						}
						|						a3_3 = parse_edu_ustb_sei_mde_morel_ReflectiveVariableExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
								startIncompleteElement(element);
							}
							if (a3_3 != null) {
								if (a3_3 != null) {
									Object value = a3_3;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ARRAY_LITERAL_EXP__ELEMENTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_1_0_0_1, a3_3, true);
								copyLocalizationInfos(a3_3, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1506]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1507]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1508]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1509]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1510]);
	}
	
	a4 = '>' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createArrayLiteralExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1511]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1512]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1513]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1514]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1515]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1516]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1517]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1518]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1519]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1520]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1521]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1522]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1523]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1524]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1525]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1526]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1527]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1528]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1529]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1530]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1531]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1532]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1533]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1534]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1535]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1536]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1537]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1538]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1539]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1540]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1541]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1542]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1543]);
	}
	
;

parse_edu_ustb_sei_mde_morel_FeaturePathExp returns [edu.ustb.sei.mde.morel.FeaturePathExp element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createFeaturePathExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1544]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createFeaturePathExp();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FEATURE_PATH_EXP__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FEATURE_PATH_EXP__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1545]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1546]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1547]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1548]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1549]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1550]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1551]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1552]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1553]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1554]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1555]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1556]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1557]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1558]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1559]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1560]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1561]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1562]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1563]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1564]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1565]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1566]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1567]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1568]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1569]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1570]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1571]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1572]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1573]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1574]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1575]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1576]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1577]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1578]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1579]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1580]);
	}
	
	(
		(
			a2_0 = parse_edu_ustb_sei_mde_morel_CallPathExp			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createFeaturePathExp();
					startIncompleteElement(element);
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						Object value = a2_0;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FEATURE_PATH_EXP__NEXT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_2, a2_0, true);
					copyLocalizationInfos(a2_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1581]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1582]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1583]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1584]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1585]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1586]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1587]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1588]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1589]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1590]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1591]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1592]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1593]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1594]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1595]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1596]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1597]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1598]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1599]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1600]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1601]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1602]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1603]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1604]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1605]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1606]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1607]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1608]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1609]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1610]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1611]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1612]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1613]);
	}
	
;

parse_edu_ustb_sei_mde_morel_OperationPathExp returns [edu.ustb.sei.mde.morel.OperationPathExp element = null]
@init{
}
:
	(
		(
			a0 = '.' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationSeparator().getEEnumLiteral(edu.ustb.sei.mde.morel.OperationSeparator.DOT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__SEPARATOR), value);
				completedElement(value, false);
			}
			|			a1 = '->' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationSeparator().getEEnumLiteral(edu.ustb.sei.mde.morel.OperationSeparator.ARROW_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__SEPARATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1614]);
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
			}
			if (a4 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__OPERATION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__OPERATION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1615]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1616]);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1617]);
			}
			
			(
				(
					a6 = 'findOne' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_2_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.FIND_ONE_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
						completedElement(value, false);
					}
					|					a7 = 'doAll' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_2_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DO_ALL_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1618]);
			}
			
			a10 = ']' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_2_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1619]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1620]);
	}
	
	a11 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1621]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1622]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1623]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1624]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1625]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1626]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1627]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1628]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1629]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1630]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1631]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1632]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1633]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1634]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1635]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1636]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1637]);
	}
	
	(
		(
			(
				a12_0 = parse_edu_ustb_sei_mde_morel_ReflectiveVariableExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
					}
					if (a12_0 != null) {
						if (a12_0 != null) {
							Object value = a12_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_0, a12_0, true);
						copyLocalizationInfos(a12_0, element);
					}
				}
				|				a12_1 = parse_edu_ustb_sei_mde_morel_LetExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
					}
					if (a12_1 != null) {
						if (a12_1 != null) {
							Object value = a12_1;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_0, a12_1, true);
						copyLocalizationInfos(a12_1, element);
					}
				}
				|				a12_2 = parse_edu_ustb_sei_mde_morel_ConditionExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
					}
					if (a12_2 != null) {
						if (a12_2 != null) {
							Object value = a12_2;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_0, a12_2, true);
						copyLocalizationInfos(a12_2, element);
					}
				}
				|				a12_3 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
					}
					if (a12_3 != null) {
						if (a12_3 != null) {
							Object value = a12_3;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_0, a12_3, true);
						copyLocalizationInfos(a12_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1638]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1639]);
			}
			
			(
				(
					a13 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1640]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1641]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1642]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1643]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1644]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1645]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1646]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1647]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1648]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1649]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1650]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1651]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1652]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1653]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1654]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1655]);
					}
					
					(
						a14_0 = parse_edu_ustb_sei_mde_morel_ReflectiveVariableExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
							}
							if (a14_0 != null) {
								if (a14_0 != null) {
									Object value = a14_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_1_0_0_1, a14_0, true);
								copyLocalizationInfos(a14_0, element);
							}
						}
						|						a14_1 = parse_edu_ustb_sei_mde_morel_LetExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
							}
							if (a14_1 != null) {
								if (a14_1 != null) {
									Object value = a14_1;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_1_0_0_1, a14_1, true);
								copyLocalizationInfos(a14_1, element);
							}
						}
						|						a14_2 = parse_edu_ustb_sei_mde_morel_ConditionExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
							}
							if (a14_2 != null) {
								if (a14_2 != null) {
									Object value = a14_2;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_1_0_0_1, a14_2, true);
								copyLocalizationInfos(a14_2, element);
							}
						}
						|						a14_3 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
							}
							if (a14_3 != null) {
								if (a14_3 != null) {
									Object value = a14_3;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_4_0_0_1_0_0_1, a14_3, true);
								copyLocalizationInfos(a14_3, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1656]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1657]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1658]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1659]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1660]);
	}
	
	a15 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1661]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1662]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1663]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1664]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1665]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1666]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1667]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1668]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1669]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1670]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1671]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1672]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1673]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1674]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1675]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1676]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1677]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1678]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1679]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1680]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1681]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1682]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1683]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1684]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1685]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1686]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1687]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1688]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1689]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1690]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1691]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1692]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1693]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1694]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1695]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1696]);
	}
	
	(
		(
			a16_0 = parse_edu_ustb_sei_mde_morel_CallPathExp			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getExecutionMode().getEEnumLiteral(edu.ustb.sei.mde.morel.ExecutionMode.DEFAULT_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__MODE), value);
				}
				if (a16_0 != null) {
					if (a16_0 != null) {
						Object value = a16_0;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__NEXT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_6, a16_0, true);
					copyLocalizationInfos(a16_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1697]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1698]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1699]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1700]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1701]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1702]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1703]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1704]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1705]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1706]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1707]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1708]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1709]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1710]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1711]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1712]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1713]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1714]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1715]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1716]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1717]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1718]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1719]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1720]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1721]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1722]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1723]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1724]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1725]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1726]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1727]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1728]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1729]);
	}
	
;

parse_edu_ustb_sei_mde_morel_IteratorPathExp returns [edu.ustb.sei.mde.morel.IteratorPathExp element = null]
@init{
}
:
	a0 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1730]);
	}
	
	(
		(
			a1 = 'forAll' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.FOR_ALL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
				completedElement(value, false);
			}
			|			a2 = 'exists' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.EXISTS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
				completedElement(value, false);
			}
			|			a3 = 'select' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.SELECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
				completedElement(value, false);
			}
			|			a4 = 'reject' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.REJECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
				completedElement(value, false);
			}
			|			a5 = 'collect' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.COLLECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
				completedElement(value, false);
			}
			|			a6 = 'closure' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.CLOSURE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1731]);
	}
	
	a9 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1732]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1733]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1734]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1735]);
	}
	
	(
		a10_0 = parse_edu_ustb_sei_mde_morel_Variable		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
				startIncompleteElement(element);
			}
			if (a10_0 != null) {
				if (a10_0 != null) {
					Object value = a10_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_3, a10_0, true);
				copyLocalizationInfos(a10_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1736]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1737]);
	}
	
	(
		(
			a11 = ',' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1738]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1739]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1740]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1741]);
			}
			
			(
				a12_0 = parse_edu_ustb_sei_mde_morel_Variable				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
						startIncompleteElement(element);
					}
					if (a12_0 != null) {
						if (a12_0 != null) {
							Object value = a12_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_4_0_0_1, a12_0, true);
						copyLocalizationInfos(a12_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1742]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1743]);
	}
	
	a13 = '|' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1744]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1745]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1746]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1747]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1748]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1749]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1750]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1751]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1752]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1753]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1754]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1755]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1756]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1757]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1758]);
	}
	
	(
		a14_0 = parse_edu_ustb_sei_mde_morel_LetExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
				startIncompleteElement(element);
			}
			if (a14_0 != null) {
				if (a14_0 != null) {
					Object value = a14_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__BODY_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_6, a14_0, true);
				copyLocalizationInfos(a14_0, element);
			}
		}
		|		a14_1 = parse_edu_ustb_sei_mde_morel_ConditionExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
				startIncompleteElement(element);
			}
			if (a14_1 != null) {
				if (a14_1 != null) {
					Object value = a14_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__BODY_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_6, a14_1, true);
				copyLocalizationInfos(a14_1, element);
			}
		}
		|		a14_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
				startIncompleteElement(element);
			}
			if (a14_2 != null) {
				if (a14_2 != null) {
					Object value = a14_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__BODY_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_6, a14_2, true);
				copyLocalizationInfos(a14_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1759]);
	}
	
	a15 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1760]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1761]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1762]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1763]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1764]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1765]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1766]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1767]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1768]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1769]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1770]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1771]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1772]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1773]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1774]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1775]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1776]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1777]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1778]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1779]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1780]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1781]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1782]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1783]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1784]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1785]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1786]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1787]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1788]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1789]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1790]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1791]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1792]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1793]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1794]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1795]);
	}
	
	(
		(
			(
				a16_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
						startIncompleteElement(element);
					}
					if (a16_0 != null) {
						if (a16_0 != null) {
							Object value = a16_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__NEXT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_8_0_0_0, a16_0, true);
						copyLocalizationInfos(a16_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1796]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1797]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1798]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1799]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1800]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1801]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1802]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1803]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1804]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1805]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1806]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1807]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1808]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1809]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1810]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1811]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1812]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1813]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1814]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1815]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1816]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1817]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1818]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1819]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1820]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1821]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1822]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1823]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1824]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1825]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1826]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1827]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1828]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1829]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1830]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1831]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1832]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1833]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1834]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1835]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1836]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1837]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1838]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1839]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1840]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1841]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1842]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1843]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1844]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1845]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1846]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1847]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1848]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1849]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1850]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1851]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1852]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1853]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1854]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1855]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1856]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1857]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1858]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1859]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1860]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1861]);
	}
	
;

parse_edu_ustb_sei_mde_morel_LetExp returns [edu.ustb.sei.mde.morel.LetExp element = null]
@init{
}
:
	a0 = 'let' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1862]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1863]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_morel_VariableWithInit		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__VARIABLES, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1864]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1865]);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1866]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1867]);
			}
			
			(
				a3_0 = parse_edu_ustb_sei_mde_morel_VariableWithInit				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__VARIABLES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_2_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1868]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1869]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1870]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1871]);
	}
	
	a4 = 'in' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1872]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1873]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1874]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1875]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1876]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1877]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1878]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1879]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1880]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1881]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1882]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1883]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1884]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1885]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1886]);
	}
	
	(
		a5_0 = parse_edu_ustb_sei_mde_morel_LetExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__IN_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_4, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
		|		a5_1 = parse_edu_ustb_sei_mde_morel_ConditionExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
				startIncompleteElement(element);
			}
			if (a5_1 != null) {
				if (a5_1 != null) {
					Object value = a5_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__IN_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_4, a5_1, true);
				copyLocalizationInfos(a5_1, element);
			}
		}
		|		a5_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
				startIncompleteElement(element);
			}
			if (a5_2 != null) {
				if (a5_2 != null) {
					Object value = a5_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LET_EXP__IN_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_4, a5_2, true);
				copyLocalizationInfos(a5_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1887]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1888]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1889]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1890]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1891]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1892]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1893]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1894]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1895]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1896]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1897]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1898]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1899]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1900]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1901]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1902]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1903]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1904]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1905]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1906]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1907]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1908]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1909]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1910]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1911]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1912]);
	}
	
;

parse_edu_ustb_sei_mde_morel_ConditionExp returns [edu.ustb.sei.mde.morel.ConditionExp element = null]
@init{
}
:
	a0 = 'if' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1913]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1914]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1915]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1916]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1917]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1918]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1919]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1920]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1921]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1922]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1923]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1924]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1925]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1926]);
	}
	
	a2 = 'then' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1927]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1928]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1929]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1930]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1931]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1932]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1933]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1934]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1935]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1936]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1937]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1938]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1939]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1940]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1941]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1942]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_morel_Expression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__THEN_BRANCH), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1943]);
	}
	
	a4 = 'else' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1944]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1945]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1946]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1947]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1948]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1949]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1950]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1951]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1952]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1953]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1954]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1955]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1956]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1957]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1958]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1959]);
	}
	
	(
		a5_0 = parse_edu_ustb_sei_mde_morel_Expression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.CONDITION_EXP__ELSE_BRANCH), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_5, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1960]);
	}
	
	a6 = 'endif' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1961]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1962]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1963]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1964]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1965]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1966]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1967]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1968]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1969]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1970]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1971]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1972]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1973]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1974]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1975]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1976]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1977]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1978]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1979]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1980]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1981]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1982]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1983]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1984]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1985]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1986]);
	}
	
;

parse_edu_ustb_sei_mde_morel_BooleanImpliesExp returns [edu.ustb.sei.mde.morel.BooleanImpliesExp element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_BooleanOrExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanImpliesExp();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1987]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1988]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1989]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1990]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1991]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1992]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1993]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1994]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1995]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1996]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1997]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1998]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1999]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2000]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2001]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2002]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2003]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2004]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2005]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2006]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2007]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2008]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2009]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2010]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2011]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2012]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2013]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2014]);
	}
	
	(
		(
			(
				(
					a1 = 'implies' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanImpliesExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.IMPLIES_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__OPERATOR), value);
						completedElement(value, false);
					}
					|					a2 = '=>' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanImpliesExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.IMPLIES_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__OPERATOR), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2015]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2016]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2017]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2018]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2019]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2020]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2021]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2022]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2023]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2024]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2025]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2026]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2027]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_morel_BooleanOrExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanImpliesExp();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__RIGHT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_1_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2028]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2029]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2030]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2031]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2032]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2033]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2034]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2035]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2036]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2037]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2038]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2039]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2040]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2041]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2042]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2043]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2044]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2045]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2046]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2047]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2048]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2049]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2050]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2051]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2052]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2053]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2054]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2055]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2056]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2057]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2058]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2059]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2060]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2061]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2062]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2063]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2064]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2065]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2066]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2067]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2068]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2069]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2070]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2071]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2072]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2073]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2074]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2075]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2076]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2077]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2078]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2079]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2080]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2081]);
	}
	
;

parse_edu_ustb_sei_mde_morel_BooleanOrExp returns [edu.ustb.sei.mde.morel.BooleanOrExp element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_BooleanAndExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanOrExp();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__CHILDREN, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2082]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2083]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2084]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2085]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2086]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2087]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2088]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2089]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2090]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2091]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2092]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2093]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2094]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2095]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2096]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2097]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2098]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2099]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2100]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2101]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2102]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2103]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2104]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2105]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2106]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2107]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2108]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2109]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2110]);
	}
	
	(
		(
			(
				(
					a1 = 'or' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanOrExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.OR_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__OPERATORS, value);
						completedElement(value, false);
					}
					|					a2 = '||' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanOrExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.OR_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__OPERATORS, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2111]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2112]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2113]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2114]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2115]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2116]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2117]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2118]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2119]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2120]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2121]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2122]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2123]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_morel_BooleanAndExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanOrExp();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__CHILDREN, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_1_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2124]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2125]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2126]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2127]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2128]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2129]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2130]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2131]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2132]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2133]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2134]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2135]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2136]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2137]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2138]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2139]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2140]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2141]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2142]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2143]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2144]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2145]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2146]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2147]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2148]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2149]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2150]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2151]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2152]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2153]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2154]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2155]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2156]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2157]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2158]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2159]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2160]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2161]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2162]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2163]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2164]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2165]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2166]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2167]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2168]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2169]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2170]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2171]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2172]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2173]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2174]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2175]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2176]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2177]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2178]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2179]);
	}
	
;

parse_edu_ustb_sei_mde_morel_BooleanAndExp returns [edu.ustb.sei.mde.morel.BooleanAndExp element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_RelationalExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanAndExp();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__CHILDREN, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2180]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2181]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2182]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2183]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2184]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2185]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2186]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2187]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2188]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2189]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2190]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2191]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2192]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2193]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2194]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2195]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2196]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2197]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2198]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2199]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2200]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2201]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2202]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2203]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2204]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2205]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2206]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2207]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2208]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2209]);
	}
	
	(
		(
			(
				(
					a1 = 'and' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanAndExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.AND_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__OPERATORS, value);
						completedElement(value, false);
					}
					|					a2 = '&&' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanAndExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.AND_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__OPERATORS, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2210]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2211]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2212]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2213]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2214]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2215]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2216]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2217]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2218]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2219]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2220]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2221]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2222]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_morel_RelationalExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanAndExp();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__CHILDREN, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_1_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2223]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2224]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2225]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2226]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2227]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2228]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2229]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2230]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2231]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2232]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2233]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2234]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2235]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2236]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2237]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2238]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2239]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2240]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2241]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2242]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2243]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2244]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2245]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2246]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2247]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2248]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2249]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2250]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2251]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2252]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2253]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2254]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2255]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2256]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2257]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2258]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2259]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2260]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2261]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2262]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2263]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2264]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2265]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2266]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2267]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2268]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2269]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2270]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2271]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2272]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2273]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2274]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2275]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2276]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2277]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2278]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2279]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2280]);
	}
	
;

parse_edu_ustb_sei_mde_morel_RelationalExp returns [edu.ustb.sei.mde.morel.RelationalExp element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_AdditiveExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2281]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2282]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2283]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2284]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2285]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2286]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2287]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2288]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2289]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2290]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2291]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2292]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2293]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2294]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2295]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2296]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2297]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2298]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2299]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2300]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2301]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2302]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2303]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2304]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2305]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2306]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2307]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2308]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2309]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2310]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2311]);
	}
	
	(
		(
			(
				(
					a1 = '=' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.EQUAL_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
						completedElement(value, false);
					}
					|					a2 = '<>' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.NOT_EQUAL_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
						completedElement(value, false);
					}
					|					a3 = '!=' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.NOT_EQUAL_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
						completedElement(value, false);
					}
					|					a4 = '<' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.LESS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
						completedElement(value, false);
					}
					|					a5 = '<=' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.LESS_OR_EQ_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
						completedElement(value, false);
					}
					|					a6 = '>' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.GREATER_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
						completedElement(value, false);
					}
					|					a7 = '>=' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.GREATER_OR_EQ_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2312]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2313]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2314]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2315]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2316]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2317]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2318]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2319]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2320]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2321]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2322]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2323]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2324]);
			}
			
			(
				a10_0 = parse_edu_ustb_sei_mde_morel_AdditiveExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
						startIncompleteElement(element);
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							Object value = a10_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__RIGHT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1_0_0_1, a10_0, true);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2325]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2326]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2327]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2328]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2329]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2330]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2331]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2332]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2333]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2334]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2335]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2336]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2337]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2338]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2339]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2340]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2341]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2342]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2343]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2344]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2345]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2346]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2347]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2348]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2349]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2350]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2351]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2352]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2353]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2354]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2355]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2356]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2357]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2358]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2359]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2360]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2361]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2362]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2363]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2364]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2365]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2366]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2367]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2368]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2369]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2370]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2371]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2372]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2373]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2374]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2375]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2376]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2377]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2378]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2379]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2380]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2381]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2382]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2383]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2384]);
	}
	
;

parse_edu_ustb_sei_mde_morel_AdditiveExp returns [edu.ustb.sei.mde.morel.AdditiveExp element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_MultiplicativeExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAdditiveExp();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__CHILDREN, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2385]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2386]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2387]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2388]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2389]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2390]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2391]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2392]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2393]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2394]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2395]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2396]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2397]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2398]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2399]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2400]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2401]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2402]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2403]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2404]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2405]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2406]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2407]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2408]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2409]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2410]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2411]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2412]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2413]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2414]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2415]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2416]);
	}
	
	(
		(
			(
				(
					a1 = '+' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAdditiveExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.AdditiveOperator.PLUS_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__OPERATORS, value);
						completedElement(value, false);
					}
					|					a2 = '-' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAdditiveExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.AdditiveOperator.MINUS_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__OPERATORS, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2417]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2418]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2419]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2420]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2421]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2422]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2423]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2424]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2425]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2426]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2427]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2428]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2429]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_morel_MultiplicativeExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAdditiveExp();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__CHILDREN, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_1_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2430]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2431]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2432]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2433]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2434]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2435]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2436]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2437]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2438]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2439]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2440]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2441]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2442]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2443]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2444]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2445]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2446]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2447]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2448]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2449]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2450]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2451]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2452]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2453]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2454]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2455]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2456]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2457]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2458]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2459]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2460]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2461]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2462]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2463]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2464]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2465]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2466]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2467]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2468]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2469]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2470]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2471]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2472]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2473]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2474]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2475]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2476]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2477]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2478]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2479]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2480]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2481]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2482]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2483]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2484]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2485]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2486]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2487]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2488]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2489]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2490]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2491]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2492]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2493]);
	}
	
;

parse_edu_ustb_sei_mde_morel_MultiplicativeExp returns [edu.ustb.sei.mde.morel.MultiplicativeExp element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createMultiplicativeExp();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__CHILDREN, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2494]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2495]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2496]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2497]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2498]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2499]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2500]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2501]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2502]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2503]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2504]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2505]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2506]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2507]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2508]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2509]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2510]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2511]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2512]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2513]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2514]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2515]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2516]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2517]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2518]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2519]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2520]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2521]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2522]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2523]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2524]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2525]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2526]);
	}
	
	(
		(
			(
				(
					a1 = '*' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createMultiplicativeExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.MultiplicativeOperator.MULTI_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__OPERATORS, value);
						completedElement(value, false);
					}
					|					a2 = '/' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createMultiplicativeExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.MultiplicativeOperator.DIV_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__OPERATORS, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2527]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2528]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2529]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2530]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2531]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2532]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2533]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2534]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2535]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2536]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2537]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2538]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2539]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createMultiplicativeExp();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__CHILDREN, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_1_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2540]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2541]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2542]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2543]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2544]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2545]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2546]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2547]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2548]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2549]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2550]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2551]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2552]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2553]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2554]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2555]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2556]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2557]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2558]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2559]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2560]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2561]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2562]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2563]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2564]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2565]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2566]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2567]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2568]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2569]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2570]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2571]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2572]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2573]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2574]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2575]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2576]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2577]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2578]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2579]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2580]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2581]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2582]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2583]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2584]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2585]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2586]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2587]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2588]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2589]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2590]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2591]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2592]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2593]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2594]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2595]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2596]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2597]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2598]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2599]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2600]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2601]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2602]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2603]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2604]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2605]);
	}
	
;

parse_edu_ustb_sei_mde_morel_UnaryExp returns [edu.ustb.sei.mde.morel.UnaryExp element = null]
@init{
}
:
	(
		(
			(
				a0 = '+' {
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
					// set value of enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.PLUS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
					completedElement(value, false);
				}
				|				a1 = '-' {
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
					// set value of enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.MINUS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
					completedElement(value, false);
				}
				|				a2 = 'not' {
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					// set value of enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.NOT_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
					completedElement(value, false);
				}
				|				a3 = '!' {
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					// set value of enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.NOT_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
					completedElement(value, false);
				}
			)
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2606]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2607]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2608]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2609]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2610]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2611]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2612]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2613]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2614]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2615]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2616]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2617]);
	}
	
	(
		a6_0 = parse_edu_ustb_sei_mde_morel_AtomicExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
				startIncompleteElement(element);
			}
			if (a6_0 != null) {
				if (a6_0 != null) {
					Object value = a6_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__CHILD), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_1, a6_0, true);
				copyLocalizationInfos(a6_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2618]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2619]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2620]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2621]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2622]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2623]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2624]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2625]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2626]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2627]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2628]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2629]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2630]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2631]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2632]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2633]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2634]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2635]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2636]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2637]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2638]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2639]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2640]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2641]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2642]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2643]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2644]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2645]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2646]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2647]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2648]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2649]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2650]);
	}
	
;

parse_edu_ustb_sei_mde_morel_BindExp returns [edu.ustb.sei.mde.morel.BindExp element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_VariableExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBindExp();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BIND_EXP__SOURCE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2651]);
	}
	
	a1 = '<-' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBindExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2652]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2653]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2654]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2655]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2656]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2657]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2658]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2659]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2660]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2661]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2662]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2663]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2664]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2665]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2666]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_morel_LetExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBindExp();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BIND_EXP__VALUE_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
		|		a2_1 = parse_edu_ustb_sei_mde_morel_ConditionExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBindExp();
				startIncompleteElement(element);
			}
			if (a2_1 != null) {
				if (a2_1 != null) {
					Object value = a2_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BIND_EXP__VALUE_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_2, a2_1, true);
				copyLocalizationInfos(a2_1, element);
			}
		}
		|		a2_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBindExp();
				startIncompleteElement(element);
			}
			if (a2_2 != null) {
				if (a2_2 != null) {
					Object value = a2_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BIND_EXP__VALUE_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_2, a2_2, true);
				copyLocalizationInfos(a2_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2667]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2668]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2669]);
	}
	
;

parse_edu_ustb_sei_mde_morel_PredefinedBindExp returns [edu.ustb.sei.mde.morel.PredefinedBindExp element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_PredefinedVariableExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPredefinedBindExp();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PREDEFINED_BIND_EXP__SOURCE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2670]);
	}
	
	a1 = '<-' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPredefinedBindExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2671]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2672]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2673]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2674]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2675]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2676]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2677]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2678]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2679]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2680]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2681]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2682]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2683]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2684]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2685]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_morel_LetExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPredefinedBindExp();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
		|		a2_1 = parse_edu_ustb_sei_mde_morel_ConditionExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPredefinedBindExp();
				startIncompleteElement(element);
			}
			if (a2_1 != null) {
				if (a2_1 != null) {
					Object value = a2_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_2, a2_1, true);
				copyLocalizationInfos(a2_1, element);
			}
		}
		|		a2_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPredefinedBindExp();
				startIncompleteElement(element);
			}
			if (a2_2 != null) {
				if (a2_2 != null) {
					Object value = a2_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_2, a2_2, true);
				copyLocalizationInfos(a2_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2686]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2687]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2688]);
	}
	
;

parse_edu_ustb_sei_mde_morel_DeclarativeStatement returns [edu.ustb.sei.mde.morel.DeclarativeStatement element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_morel_PredefinedBindExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.DECLARATIVE_STATEMENT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_morel_BindExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.DECLARATIVE_STATEMENT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_morel_LetExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.DECLARATIVE_STATEMENT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_edu_ustb_sei_mde_morel_ConditionExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.DECLARATIVE_STATEMENT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
		|		a0_4 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
				startIncompleteElement(element);
			}
			if (a0_4 != null) {
				if (a0_4 != null) {
					Object value = a0_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.DECLARATIVE_STATEMENT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, a0_4, true);
				copyLocalizationInfos(a0_4, element);
			}
		}
		|		a0_5 = parse_edu_ustb_sei_mde_morel_ReflectiveVariableExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
				startIncompleteElement(element);
			}
			if (a0_5 != null) {
				if (a0_5 != null) {
					Object value = a0_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.DECLARATIVE_STATEMENT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, a0_5, true);
				copyLocalizationInfos(a0_5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2689]);
	}
	
	a1 = ';' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2690]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2691]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2692]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2693]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2694]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2695]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2696]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2697]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2698]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2699]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2700]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2701]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2702]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2703]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2704]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2705]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2706]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2707]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2708]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2709]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2710]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2711]);
	}
	
;

parse_edu_ustb_sei_mde_morel_IfStatement returns [edu.ustb.sei.mde.morel.IfStatement element = null]
@init{
}
:
	a0 = 'if' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_36_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2712]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_36_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2713]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2714]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2715]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2716]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2717]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2718]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2719]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2720]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2721]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2722]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2723]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2724]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2725]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_36_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2726]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_36_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2727]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2728]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2729]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_morel_ImperativeStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__THEN_STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_36_0_0_4, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2730]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2731]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2732]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2733]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2734]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2735]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2736]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2737]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2738]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2739]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2740]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2741]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2742]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2743]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2744]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2745]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2746]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2747]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2748]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2749]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2750]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2751]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2752]);
	}
	
	(
		(
			a5 = 'else' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_36_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2753]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2754]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2755]);
			}
			
			(
				a6_0 = parse_edu_ustb_sei_mde_morel_ImperativeStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
						startIncompleteElement(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.IF_STATEMENT__ELSE_STATEMENT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_36_0_0_5_0_0_1, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2756]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2757]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2758]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2759]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2760]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2761]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2762]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2763]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2764]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2765]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2766]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2767]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2768]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2769]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2770]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2771]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2772]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2773]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2774]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2775]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2776]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2777]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2778]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2779]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2780]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2781]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2782]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2783]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2784]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2785]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2786]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2787]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2788]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2789]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2790]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2791]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2792]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2793]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2794]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2795]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2796]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2797]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2798]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2799]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2800]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2801]);
	}
	
;

parse_edu_ustb_sei_mde_morel_ForStatement returns [edu.ustb.sei.mde.morel.ForStatement element = null]
@init{
}
:
	a0 = 'for' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2802]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2803]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2804]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_morel_VariableWithInit		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__ITERATOR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2805]);
	}
	
	a3 = ';' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2806]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2807]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2808]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2809]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2810]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2811]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2812]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2813]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2814]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2815]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2816]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2817]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2818]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__TERMINATION_EXP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_4, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2819]);
	}
	
	a5 = ';' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2820]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2821]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2822]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2823]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2824]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2825]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2826]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2827]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2828]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2829]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2830]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2831]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2832]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2833]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2834]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2835]);
	}
	
	(
		(
			(
				a6_0 = parse_edu_ustb_sei_mde_morel_LetExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
						startIncompleteElement(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__STEP_EXP), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_6_0_0_0, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
				|				a6_1 = parse_edu_ustb_sei_mde_morel_ConditionExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
						startIncompleteElement(element);
					}
					if (a6_1 != null) {
						if (a6_1 != null) {
							Object value = a6_1;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__STEP_EXP), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_6_0_0_0, a6_1, true);
						copyLocalizationInfos(a6_1, element);
					}
				}
				|				a6_2 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
						startIncompleteElement(element);
					}
					if (a6_2 != null) {
						if (a6_2 != null) {
							Object value = a6_2;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__STEP_EXP), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_6_0_0_0, a6_2, true);
						copyLocalizationInfos(a6_2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2836]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2837]);
	}
	
	a7 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2838]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2839]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2840]);
	}
	
	(
		a8_0 = parse_edu_ustb_sei_mde_morel_ImperativeStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
				startIncompleteElement(element);
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					Object value = a8_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.FOR_STATEMENT__BODY_STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_37_0_0_8, a8_0, true);
				copyLocalizationInfos(a8_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2841]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2842]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2843]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2844]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2845]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2846]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2847]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2848]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2849]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2850]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2851]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2852]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2853]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2854]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2855]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2856]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2857]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2858]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2859]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2860]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2861]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2862]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2863]);
	}
	
;

parse_edu_ustb_sei_mde_morel_BlockStatement returns [edu.ustb.sei.mde.morel.BlockStatement element = null]
@init{
}
:
	a0 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBlockStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_38_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2864]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2865]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2866]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2867]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2868]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2869]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2870]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2871]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2872]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2873]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2874]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2875]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2876]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2877]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2878]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2879]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2880]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2881]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2882]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2883]);
	}
	
	(
		(
			a1_0 = parse_edu_ustb_sei_mde_morel_Statement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBlockStatement();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BLOCK_STATEMENT__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_38_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2884]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2885]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2886]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2887]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2888]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2889]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2890]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2891]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2892]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2893]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2894]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2895]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2896]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2897]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2898]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2899]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2900]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2901]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2902]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2903]);
	}
	
	a2 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBlockStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_38_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2904]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2905]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2906]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2907]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2908]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2909]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2910]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2911]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2912]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2913]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2914]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2915]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2916]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2917]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2918]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2919]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2920]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2921]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2922]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2923]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2924]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2925]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2926]);
	}
	
;

parse_edu_ustb_sei_mde_morel_TransformationModel returns [edu.ustb.sei.mde.morel.TransformationModel element = null]
@init{
}
:
	a0 = 'transformation' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTransformationModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_39_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2927]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTransformationModel();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_39_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2928]);
	}
	
	(
		(
			a2_0 = parse_edu_ustb_sei_mde_morel_TypedModel			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTransformationModel();
					startIncompleteElement(element);
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						Object value = a2_0;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__MODELS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_39_0_0_2, a2_0, true);
					copyLocalizationInfos(a2_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2929]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2930]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2931]);
	}
	
	(
		(
			a3_0 = parse_edu_ustb_sei_mde_morel_Rule			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTransformationModel();
					startIncompleteElement(element);
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						Object value = a3_0;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.TRANSFORMATION_MODEL__RULES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_39_0_0_3, a3_0, true);
					copyLocalizationInfos(a3_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2932]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2933]);
	}
	
;

parse_edu_ustb_sei_mde_morel_Rule returns [edu.ustb.sei.mde.morel.Rule element = null]
@init{
}
:
	(
		(
			(
				(
					a0 = 'active' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_0_0_0_0, true, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
						// set value of boolean attribute
						Object value = true;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__ACTIVE), value);
						completedElement(value, false);
					}
					|					a1 = 'passive' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_0_0_0_0, false, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of boolean attribute
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__ACTIVE), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2934]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2935]);
	}
	
	a3 = 'rule' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2936]);
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2937]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2938]);
	}
	
	(
		(
			a5 = '(' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2939]);
			}
			
			(
				a6 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
						startIncompleteElement(element);
					}
					if (a6 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__PARAMETERS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.RULE__PARAMETERS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_3_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2940]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2941]);
			}
			
			(
				(
					a7 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_3_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2942]);
					}
					
					(
						a8 = IDENTIFIER						
						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
								startIncompleteElement(element);
							}
							if (a8 != null) {
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
								tokenResolver.setOptions(getOptions());
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__PARAMETERS), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.RULE__PARAMETERS, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_3_0_0_2_0_0_1, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2943]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2944]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2945]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2946]);
			}
			
			a9 = ')' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_3_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2947]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2948]);
	}
	
	a10 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2949]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2950]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2951]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2952]);
	}
	
	(
		(
			(
				a11_0 = parse_edu_ustb_sei_mde_morel_Pattern				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
						startIncompleteElement(element);
					}
					if (a11_0 != null) {
						if (a11_0 != null) {
							Object value = a11_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.RULE__PATTERNS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_5_0_0_0, a11_0, true);
						copyLocalizationInfos(a11_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2953]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2954]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2955]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2956]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2957]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2958]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2959]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2960]);
	}
	
	a12 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_40_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2961]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2962]);
	}
	
;

parse_edu_ustb_sei_mde_morel_Pattern returns [edu.ustb.sei.mde.morel.Pattern element = null]
@init{
}
:
	(
		(
			a0 = 'lhs' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				completedElement(value, false);
			}
			|			a1 = 'rhs' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.RHS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				completedElement(value, false);
			}
			|			a2 = 'nac' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.NAC_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				completedElement(value, false);
			}
			|			a3 = 'pac' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PAC_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				completedElement(value, false);
			}
			|			a4 = 'pre' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PRE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				completedElement(value, false);
			}
			|			a5 = 'post' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.POST_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2963]);
	}
	
	a8 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2964]);
	}
	
	a9 = 'match' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2965]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2966]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2967]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2968]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2969]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2970]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2971]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2972]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2973]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2974]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2975]);
	}
	
	(
		(
			(
				a10_0 = parse_edu_ustb_sei_mde_morel_Variable				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							Object value = a10_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__VARIABLES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_3_0_0_0, a10_0, true);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2976]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2977]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2978]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2979]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2980]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2981]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2982]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2983]);
			}
			
			(
				(
					a11 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2984]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2985]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2986]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2987]);
					}
					
					(
						a12_0 = parse_edu_ustb_sei_mde_morel_Variable						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
							}
							if (a12_0 != null) {
								if (a12_0 != null) {
									Object value = a12_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__VARIABLES, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_3_0_0_1_0_0_1, a12_0, true);
								copyLocalizationInfos(a12_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2988]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2989]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2990]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2991]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2992]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2993]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2994]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2995]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2996]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2997]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2998]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2999]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3000]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3001]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3002]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3003]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3004]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3005]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3006]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3007]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3008]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3009]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3010]);
	}
	
	(
		(
			(
				a13_0 = parse_edu_ustb_sei_mde_morel_LinkConstraint				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
					}
					if (a13_0 != null) {
						if (a13_0 != null) {
							Object value = a13_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__LINK_CONSTRAINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_4_0_0_0, a13_0, true);
						copyLocalizationInfos(a13_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3011]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3012]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3013]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3014]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3015]);
			}
			
			(
				(
					a14 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_4_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3016]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3017]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3018]);
					}
					
					(
						a15_0 = parse_edu_ustb_sei_mde_morel_LinkConstraint						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
							}
							if (a15_0 != null) {
								if (a15_0 != null) {
									Object value = a15_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__LINK_CONSTRAINTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_4_0_0_1_0_0_1, a15_0, true);
								copyLocalizationInfos(a15_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3019]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3020]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3021]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3022]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3023]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3024]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3025]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3026]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3027]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3028]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3029]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3030]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3031]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3032]);
	}
	
	(
		(
			(
				a16_0 = parse_edu_ustb_sei_mde_morel_AdditionalConstraint				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
					}
					if (a16_0 != null) {
						if (a16_0 != null) {
							Object value = a16_0;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__ADDITIONAL_CONSTRAINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_5_0_0_0, a16_0, true);
						copyLocalizationInfos(a16_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3033]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3034]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3035]);
			}
			
			(
				(
					a17 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_5_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3036]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3037]);
					}
					
					(
						a18_0 = parse_edu_ustb_sei_mde_morel_AdditionalConstraint						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
							}
							if (a18_0 != null) {
								if (a18_0 != null) {
									Object value = a18_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__ADDITIONAL_CONSTRAINTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_5_0_0_1_0_0_1, a18_0, true);
								copyLocalizationInfos(a18_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3038]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3039]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3040]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3041]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3042]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3043]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3044]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3045]);
	}
	
	(
		(
			a19 = 'where' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a19, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3046]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3047]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3048]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3049]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3050]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3051]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3052]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3053]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3054]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3055]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3056]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3057]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3058]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3059]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3060]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3061]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3062]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3063]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3064]);
			}
			
			(
				(
					(
						a20_0 = parse_edu_ustb_sei_mde_morel_Statement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
							}
							if (a20_0 != null) {
								if (a20_0 != null) {
									Object value = a20_0;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__STATEMENTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_6_0_0_1_0_0_0, a20_0, true);
								copyLocalizationInfos(a20_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3065]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3066]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3067]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3068]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3069]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3070]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3071]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3072]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3073]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3074]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3075]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3076]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3077]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3078]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3079]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3080]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3081]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3082]);
						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3083]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3084]);
					}
					
				)
				
			)+			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3085]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3086]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3087]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3088]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3089]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3090]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3091]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3092]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3093]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3094]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3095]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3096]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3097]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3098]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3099]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3100]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3101]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3102]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3103]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3104]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3105]);
	}
	
	a21 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_41_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3106]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3107]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3108]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3109]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edu_ustb_sei_mde_morel_Query{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_PredefinedVariableExp returns [edu.ustb.sei.mde.morel.PredefinedVariableExp element = null]
@init{
}
:
	(
		(
			a0 = '@this' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPredefinedVariableExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_42_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedVariable().getEEnumLiteral(edu.ustb.sei.mde.morel.PredefinedVariable.THIS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PREDEFINED_VARIABLE_EXP__VARIABLE), value);
				completedElement(value, false);
			}
			|			a1 = '@id' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPredefinedVariableExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_42_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedVariable().getEEnumLiteral(edu.ustb.sei.mde.morel.PredefinedVariable.ID_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PREDEFINED_VARIABLE_EXP__VARIABLE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3110]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3111]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3112]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3113]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3114]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3115]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3116]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3117]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3118]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3119]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3120]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3121]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3122]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3123]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3124]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3125]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3126]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3127]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3128]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3129]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3130]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3131]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3132]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3133]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3134]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3135]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3136]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3137]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3138]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3139]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3140]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3141]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3142]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3143]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3144]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3145]);
	}
	
	(
		(
			(
				a4_0 = parse_edu_ustb_sei_mde_morel_CallPathExp				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPredefinedVariableExp();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PREDEFINED_VARIABLE_EXP__PATH), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_42_0_0_1_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3146]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3147]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3148]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3149]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3150]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3151]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3152]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3153]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3154]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3155]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3156]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3157]);
				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3158]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3159]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3160]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3161]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3162]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3163]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3164]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3165]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3166]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3167]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3168]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3169]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3170]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3171]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3172]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3173]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3174]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3175]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3176]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3177]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3178]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3179]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3180]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3181]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3182]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3183]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3184]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3185]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3186]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3187]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3188]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3189]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3190]);
		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3191]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3192]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3193]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3194]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3195]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3196]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3197]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3198]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3199]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3200]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3201]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3202]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3203]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3204]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3205]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3206]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3207]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3208]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3209]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3210]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3211]);
	}
	
;

parse_edu_ustb_sei_mde_morel_ReflectiveVariableExp returns [edu.ustb.sei.mde.morel.ReflectiveVariableExp element = null]
@init{
}
:
	a0 = '&' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createReflectiveVariableExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_43_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3212]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createReflectiveVariableExp();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REFLECTIVE_VARIABLE_EXP__VARIABLE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.Variable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.ReflectiveVariableExp, edu.ustb.sei.mde.morel.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getReflectiveVariableExpVariableReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REFLECTIVE_VARIABLE_EXP__VARIABLE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.REFLECTIVE_VARIABLE_EXP__VARIABLE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_43_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3213]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3214]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3215]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3216]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3217]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3218]);
	}
	
;

parse_edu_ustb_sei_mde_morel_OrderConstraint returns [edu.ustb.sei.mde.morel.OrderConstraint element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__BASE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.OrderConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getOrderConstraintBaseReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__BASE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__BASE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3219]);
	}
	
	a1 = '^' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3220]);
	}
	
	a2 = '<' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3221]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3222]);
	}
	
	(
		(
			(
				a3 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
						startIncompleteElement(element);
					}
					if (a3 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__VARIABLES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edu.ustb.sei.mde.morel.Variable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.AdditionalConstraint, edu.ustb.sei.mde.morel.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAdditionalConstraintVariablesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__VARIABLES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__VARIABLES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_3_0_0_0, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3223]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3224]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3225]);
					}
					
					(
						a5 = IDENTIFIER						
						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
								startIncompleteElement(element);
							}
							if (a5 != null) {
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
								tokenResolver.setOptions(getOptions());
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__VARIABLES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edu.ustb.sei.mde.morel.Variable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.AdditionalConstraint, edu.ustb.sei.mde.morel.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAdditionalConstraintVariablesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__VARIABLES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__VARIABLES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_3_0_0_1_0_0_1, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3226]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3227]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3228]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3229]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3230]);
	}
	
	a6 = '>' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3231]);
	}
	
	a7 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3232]);
	}
	
	a8 = '<' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3233]);
	}
	
	(
		(
			a9 = IDENTIFIER			
			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
					startIncompleteElement(element);
				}
				if (a9 != null) {
					edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__TYPES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
					collectHiddenTokens(element);
					registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.OrderConstraint, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getOrderConstraintTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__TYPES), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__TYPES, value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_7_0_0_0, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3234]);
		}
		
		a10 = '.' {
			if (element == null) {
				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_7_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3235]);
		}
		
		(
			a11 = IDENTIFIER			
			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
					startIncompleteElement(element);
				}
				if (a11 != null) {
					edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__REFERENCES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
					collectHiddenTokens(element);
					registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.OrderConstraint, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getOrderConstraintReferencesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__REFERENCES), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__REFERENCES, value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_7_0_0_2, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3236]);
			addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3237]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3238]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3239]);
	}
	
	(
		(
			a12 = ',' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3240]);
			}
			
			(
				a13 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
						startIncompleteElement(element);
					}
					if (a13 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__TYPES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.OrderConstraint, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getOrderConstraintTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__TYPES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__TYPES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_8_0_0_1, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3241]);
			}
			
			a14 = '.' {
				if (element == null) {
					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_8_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3242]);
			}
			
			(
				a15 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
						startIncompleteElement(element);
					}
					if (a15 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__REFERENCES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a15).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.OrderConstraint, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getOrderConstraintReferencesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__REFERENCES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ORDER_CONSTRAINT__REFERENCES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_8_0_0_3, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a15, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a15, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3243]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3244]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3245]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3246]);
	}
	
	a16 = '>' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOrderConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_44_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3247]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3248]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3249]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3250]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3251]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3252]);
	}
	
;

parse_edu_ustb_sei_mde_morel_AllDifferentConstraint returns [edu.ustb.sei.mde.morel.AllDifferentConstraint element = null]
@init{
}
:
	a0 = '<>' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAllDifferentConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_45_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3253]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAllDifferentConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_45_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3254]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3255]);
	}
	
	(
		(
			(
				a2 = IDENTIFIER				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAllDifferentConstraint();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ALL_DIFFERENT_CONSTRAINT__VARIABLES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edu.ustb.sei.mde.morel.Variable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.AdditionalConstraint, edu.ustb.sei.mde.morel.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAdditionalConstraintVariablesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ALL_DIFFERENT_CONSTRAINT__VARIABLES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ALL_DIFFERENT_CONSTRAINT__VARIABLES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_45_0_0_2_0_0_0, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3256]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3257]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAllDifferentConstraint();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_45_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3258]);
					}
					
					(
						a4 = IDENTIFIER						
						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAllDifferentConstraint();
								startIncompleteElement(element);
							}
							if (a4 != null) {
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
								tokenResolver.setOptions(getOptions());
								edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ALL_DIFFERENT_CONSTRAINT__VARIABLES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edu.ustb.sei.mde.morel.Variable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.AdditionalConstraint, edu.ustb.sei.mde.morel.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAdditionalConstraintVariablesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ALL_DIFFERENT_CONSTRAINT__VARIABLES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ALL_DIFFERENT_CONSTRAINT__VARIABLES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_45_0_0_2_0_0_1_0_0_1, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3259]);
						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3260]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3261]);
				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3262]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3263]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAllDifferentConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_45_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3264]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3265]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3266]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3267]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3268]);
		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3269]);
	}
	
;

parse_edu_ustb_sei_mde_morel_Variable returns [edu.ustb.sei.mde.morel.Variable element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_ObjectVariable{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_PrimitiveVariable{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_LinkConstraint returns [edu.ustb.sei.mde.morel.LinkConstraint element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_SimpleLinkConstraint{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_EnclosureLinkConstraint{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_morel_PathConstraint{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_AdditionalConstraint returns [edu.ustb.sei.mde.morel.AdditionalConstraint element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_OrderConstraint{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_AllDifferentConstraint{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_Statement returns [edu.ustb.sei.mde.morel.Statement element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_DeclarativeStatement{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_IfStatement{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_morel_ForStatement{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_morel_BlockStatement{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_CallPathExp returns [edu.ustb.sei.mde.morel.CallPathExp element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_FeaturePathExp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_OperationPathExp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_morel_IteratorPathExp{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_VariableWithInit returns [edu.ustb.sei.mde.morel.VariableWithInit element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_Expression returns [edu.ustb.sei.mde.morel.Expression element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_VariableExp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_NestedExp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_morel_IntegerLiteralExp{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_morel_RealLiteralExp{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_morel_StringLiteralExp{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_morel_BooleanLiteralExp{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_edu_ustb_sei_mde_morel_TypeLiteralExp{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_edu_ustb_sei_mde_morel_CollectionLiteralExp{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_edu_ustb_sei_mde_morel_EnumLiteralExp{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_edu_ustb_sei_mde_morel_ArrayLiteralExp{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_edu_ustb_sei_mde_morel_LetExp{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_edu_ustb_sei_mde_morel_ConditionExp{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_edu_ustb_sei_mde_morel_BooleanImpliesExp{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_edu_ustb_sei_mde_morel_BooleanOrExp{ element = c14; /* this is a subclass or primitive expression choice */ }
	|	c15 = parse_edu_ustb_sei_mde_morel_BooleanAndExp{ element = c15; /* this is a subclass or primitive expression choice */ }
	|	c16 = parse_edu_ustb_sei_mde_morel_RelationalExp{ element = c16; /* this is a subclass or primitive expression choice */ }
	|	c17 = parse_edu_ustb_sei_mde_morel_AdditiveExp{ element = c17; /* this is a subclass or primitive expression choice */ }
	|	c18 = parse_edu_ustb_sei_mde_morel_MultiplicativeExp{ element = c18; /* this is a subclass or primitive expression choice */ }
	|	c19 = parse_edu_ustb_sei_mde_morel_UnaryExp{ element = c19; /* this is a subclass or primitive expression choice */ }
	|	c20 = parse_edu_ustb_sei_mde_morel_BindExp{ element = c20; /* this is a subclass or primitive expression choice */ }
	|	c21 = parse_edu_ustb_sei_mde_morel_PredefinedBindExp{ element = c21; /* this is a subclass or primitive expression choice */ }
	|	c22 = parse_edu_ustb_sei_mde_morel_PredefinedVariableExp{ element = c22; /* this is a subclass or primitive expression choice */ }
	|	c23 = parse_edu_ustb_sei_mde_morel_ReflectiveVariableExp{ element = c23; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild returns [edu.ustb.sei.mde.morel.MultiplicativeExpChild element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_VariableExp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_NestedExp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_morel_IntegerLiteralExp{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_morel_RealLiteralExp{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_morel_StringLiteralExp{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_morel_BooleanLiteralExp{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_edu_ustb_sei_mde_morel_TypeLiteralExp{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_edu_ustb_sei_mde_morel_CollectionLiteralExp{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_edu_ustb_sei_mde_morel_EnumLiteralExp{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_edu_ustb_sei_mde_morel_ArrayLiteralExp{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_edu_ustb_sei_mde_morel_UnaryExp{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_edu_ustb_sei_mde_morel_PredefinedVariableExp{ element = c12; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_AtomicExp returns [edu.ustb.sei.mde.morel.AtomicExp element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_VariableExp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_NestedExp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_morel_IntegerLiteralExp{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_morel_RealLiteralExp{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_morel_StringLiteralExp{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_morel_BooleanLiteralExp{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_edu_ustb_sei_mde_morel_TypeLiteralExp{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_edu_ustb_sei_mde_morel_CollectionLiteralExp{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_edu_ustb_sei_mde_morel_EnumLiteralExp{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_edu_ustb_sei_mde_morel_ArrayLiteralExp{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_edu_ustb_sei_mde_morel_PredefinedVariableExp{ element = c11; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_morel_ImperativeStatement returns [edu.ustb.sei.mde.morel.ImperativeStatement element = null]
:
	c0 = parse_edu_ustb_sei_mde_morel_IfStatement{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_morel_ForStatement{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_morel_BlockStatement{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

LINEBREAK:
	(('\r\n'|'\r'|'\n'))
	{ _channel = 99; }
;
SL_COMMENT:
	( '--'(~('\n'|'\r'|'\uffff'))* )
	{ _channel = 99; }
;
ML_COMMENT:
	( '/*'.*'*/')
	{ _channel = 99; }
;
WHITESPACE:
	((' '|'\t'|'\f'))
	{ _channel = 99; }
;
COLLECTION:
	(('Sequence'|'Set'|'Bag'|'OrderedSet'))
;
DATA_TYPE:
	((('Sequence'|'Set'|'Bag'|'OrderedSet')'(')*('String'|'Integer'|'Boolean'|'Real'|'Char'|'Any')')'*|(('Sequence'|'Set'|'Bag'|'OrderedSet')'(')+(('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*)')'+)
;
IDENTIFIER:
	(('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*)
;
URINS:
	('@'('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-'|'/'|':'|'\.')+)
;
INUMBER:
	(('0'..'9')('0'..'1')*)
;
RNUMBER:
	(('0'..'9')+'\.'('0'..'9')+)
;
QUOTED_39_39_92:
	(('\'')(('\\''\'')|('\\''\\')|(~('\''|'\\')))*('\''))
;

