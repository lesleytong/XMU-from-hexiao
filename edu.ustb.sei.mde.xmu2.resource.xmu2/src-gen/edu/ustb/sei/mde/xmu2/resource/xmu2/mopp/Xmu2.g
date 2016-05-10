grammar Xmu2;

options {
	superClass = Xmu2ANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;
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
	package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;
}

@members{
	private edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolverFactory tokenResolverFactory = new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenResolverFactory();
	
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
	private java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal> expectedElements = new java.util.ArrayList<edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal>();
	
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
		postParseCommands.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>() {
			public boolean execute(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Problem() {
					public edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity getSeverity() {
						return edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemSeverity.ERROR;
					}
					public edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType getType() {
						return edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2QuickFix> getQuickFixes() {
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
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement terminal = edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2FollowSetProvider.TERMINALS[terminalID];
		edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[] containmentFeatures = new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2FollowSetProvider.LINKS[ids[i]];
		}
		edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2ContainmentTrace containmentTrace = new edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2ContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal expectedElement = new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		postParseCommands.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>() {
			public boolean execute(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2LocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>() {
			public boolean execute(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2LocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>() {
			public boolean execute(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2LocationMap locationMap = resource.getLocationMap();
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
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new Xmu2Parser(new org.antlr.runtime3_4_0.CommonTokenStream(new Xmu2Lexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new Xmu2Parser(new org.antlr.runtime3_4_0.CommonTokenStream(new Xmu2Lexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2RuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public Xmu2Parser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((Xmu2Lexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((Xmu2Lexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.TransformationModel.class) {
				return parse_edu_ustb_sei_mde_xmu2_TransformationModel();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.EntryPoint.class) {
				return parse_edu_ustb_sei_mde_xmu2_EntryPoint();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.EntryData.class) {
				return parse_edu_ustb_sei_mde_xmu2_EntryData();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.ModelRule.class) {
				return parse_edu_ustb_sei_mde_xmu2_ModelRule();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.VariableDeclaration.class) {
				return parse_edu_ustb_sei_mde_xmu2_VariableDeclaration();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.Parameter.class) {
				return parse_edu_ustb_sei_mde_xmu2_Parameter();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.pattern.Pattern.class) {
				return parse_edu_ustb_sei_mde_xmu2_pattern_Pattern();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.pattern.PatternNode.class) {
				return parse_edu_ustb_sei_mde_xmu2_pattern_PatternNode();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.LoopPath.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_LoopPath();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.FeaturePath.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_FeaturePath();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.OperationPath.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_OperationPath();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.PositionPath.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_PositionPath();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.VariableExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.PathExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_PathExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.EmptyExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_EmptyExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.ParenExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_ParenExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.UnaryExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.AdditiveExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.RelationalExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.BlockStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.UpdateStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.SwitchStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.UpdateClause.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_UpdateClause();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.PatternCaseClause.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_PatternCaseClause();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_ExpressionCaseClause();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_DeleteLinkStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.ForEachStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.RuleCallStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.Skip.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_Skip();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause();
			}
		}
		throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2UnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>>();
		edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ParseResult parseResult = new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ParseResult();
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
	
	public java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ParseResult result = parse();
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
			for (edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal>();
		java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal> newFollowSet = new java.util.ArrayList<edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 190;
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
				for (edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2Pair<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2Pair<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[]> newFollowerPair : newFollowers) {
							edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2ContainmentTrace containmentTrace = new edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2ContainmentTrace(null, newFollowerPair.getRight());
							edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal newFollowTerminal = new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_edu_ustb_sei_mde_xmu2_TransformationModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_TransformationModel returns [edu.ustb.sei.mde.xmu2.TransformationModel element = null]
@init{
}
:
	a0 = 'module' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createTransformationModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createTransformationModel();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_0_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[5]);
	}
	
	(
		(
			a2 = 'import' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createTransformationModel();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_0_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[6]);
			}
			
			(
				a3 = QUOTED_60_62_92				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createTransformationModel();
						startIncompleteElement(element);
					}
					if (a3 != null) {
						edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62_92");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__PACKAGES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.ecore.EPackage proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEPackage();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.TransformationModel, org.eclipse.emf.ecore.EPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTransformationModelPackagesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__PACKAGES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__PACKAGES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_0_0_0_2_0_0_1, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[7]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[8]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[9]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[10]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[14]);
	}
	
	(
		(
			(
				a4_0 = parse_edu_ustb_sei_mde_xmu2_EntryPoint				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createTransformationModel();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_0_0_0_3_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[17]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[20]);
	}
	
	(
		(
			(
				a5_0 = parse_edu_ustb_sei_mde_xmu2_AbstractRule				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createTransformationModel();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.TRANSFORMATION_MODEL__RULES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_0_0_0_4_0_0_0, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[21]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[22]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[24]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_EntryPoint returns [edu.ustb.sei.mde.xmu2.EntryPoint element = null]
@init{
}
:
	a0 = 'entry' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryPoint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[25]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryPoint();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__RULE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu2.ModelRule proxy = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.EntryPoint, edu.ustb.sei.mde.xmu2.ModelRule>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEntryPointRuleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__RULE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__RULE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_1_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[26]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryPoint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_1_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getEntryPoint(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[27]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu2_EntryData		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryPoint();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__PARAMETERS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_1_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[29]);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryPoint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_1_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getEntryPoint(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[30]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_xmu2_EntryData				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryPoint();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_POINT__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_1_0_0_4_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[31]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[32]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[34]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryPoint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_1_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[37]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_EntryData returns [edu.ustb.sei.mde.xmu2.EntryData element = null]
@init{
}
:
	(
		(
			a0 = 'source' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryData();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.SOURCE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__TAG), value);
				completedElement(value, false);
			}
			|			a1 = 'view' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryData();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.VIEW_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__TAG), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[38]);
	}
	
	a4 = '[' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryData();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[39]);
	}
	
	(
		a5 = NUMBER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryData();
				startIncompleteElement(element);
			}
			if (a5 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__INDEX), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__INDEX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_2_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[40]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[41]);
	}
	
	(
		(
			(
				a6 = OBJ_URI				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryData();
						startIncompleteElement(element);
					}
					if (a6 != null) {
						edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("OBJ_URI");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__FRAGMENT), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ENTRY_DATA__FRAGMENT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_2_0_0_3_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[42]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[43]);
	}
	
	a7 = ']' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createEntryData();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_2_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[44]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[45]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_ModelRule returns [edu.ustb.sei.mde.xmu2.ModelRule element = null]
@init{
}
:
	(
		(
			a0 = 'top' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_0, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[46]);
	}
	
	a3 = 'rule' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[47]);
	}
	
	(
		a4 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
				}
			}
			if (a4 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[48]);
	}
	
	a5 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[50]);
	}
	
	(
		(
			(
				a6_0 = parse_edu_ustb_sei_mde_xmu2_Parameter				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
						}
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_4_0_0_0, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[51]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[52]);
			}
			
			(
				(
					a7 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
							startIncompleteElement(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_4_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[53]);
					}
					
					(
						a8_0 = parse_edu_ustb_sei_mde_xmu2_Parameter						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
								startIncompleteElement(element);
								// initialize boolean attribute
								{
									Object value = false;
									element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
								}
							}
							if (a8_0 != null) {
								if (a8_0 != null) {
									Object value = a8_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_4_0_0_1_0_0_1, a8_0, true);
								copyLocalizationInfos(a8_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[54]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[55]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[56]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[57]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[58]);
	}
	
	a9 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[59]);
	}
	
	a10 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[70]);
	}
	
	(
		(
			(
				a11_0 = parse_edu_ustb_sei_mde_xmu2_VariableDeclaration				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
						}
					}
					if (a11_0 != null) {
						if (a11_0 != null) {
							Object value = a11_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__VARIABLE_DECLARATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7_0_0_0, a11_0, true);
						copyLocalizationInfos(a11_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[71]);
			}
			
			a12 = ';' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[72]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[73]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[74]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[75]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[77]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[78]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[79]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[81]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[82]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[84]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[87]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[93]);
	}
	
	(
		(
			a13_0 = parse_edu_ustb_sei_mde_xmu2_statement_Statement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
					}
				}
				if (a13_0 != null) {
					if (a13_0 != null) {
						Object value = a13_0;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_8, a13_0, true);
					copyLocalizationInfos(a13_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[94]);
	}
	
	a14 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__ACTIVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[96]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_VariableDeclaration returns [edu.ustb.sei.mde.xmu2.VariableDeclaration element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createVariableDeclaration();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.VARIABLE_DECLARATION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.VARIABLE_DECLARATION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[97]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createVariableDeclaration();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[98]);
	}
	
	(
		a2 = TYPE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createVariableDeclaration();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TYPE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.VARIABLE_DECLARATION__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EClassifier proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypedElementTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.VARIABLE_DECLARATION__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.VARIABLE_DECLARATION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[110]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_Parameter returns [edu.ustb.sei.mde.xmu2.Parameter element = null]
@init{
}
:
	(
		(
			a0 = 'source' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createParameter();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.NORMAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.SOURCE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG), value);
				completedElement(value, false);
			}
			|			a1 = 'view' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createParameter();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.NORMAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.VIEW_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[111]);
	}
	
	(
		a4 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createParameter();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.NORMAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG), value);
			}
			if (a4 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_5_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[112]);
	}
	
	a5 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createParameter();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.NORMAL_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_5_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[113]);
	}
	
	(
		a6 = TYPE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createParameter();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.NORMAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG), value);
			}
			if (a6 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TYPE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EClassifier proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypedElementTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_5_0_0_3, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[115]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_Pattern returns [edu.ustb.sei.mde.xmu2.pattern.Pattern element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_pattern_PatternNode		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__ROOT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[117]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[118]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[125]);
	}
	
	(
		(
			a1 = '[' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[126]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[127]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[128]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[129]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[130]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[131]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[132]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[133]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[134]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_1, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_1, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_1, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
				|				a2_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_4 != null) {
						if (a2_4 != null) {
							Object value = a2_4;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_1, a2_4, true);
						copyLocalizationInfos(a2_4, element);
					}
				}
				|				a2_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_5 != null) {
						if (a2_5 != null) {
							Object value = a2_5;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_1, a2_5, true);
						copyLocalizationInfos(a2_5, element);
					}
				}
				|				a2_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_6 != null) {
						if (a2_6 != null) {
							Object value = a2_6;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_1, a2_6, true);
						copyLocalizationInfos(a2_6, element);
					}
				}
				|				a2_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_7 != null) {
						if (a2_7 != null) {
							Object value = a2_7;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_1, a2_7, true);
						copyLocalizationInfos(a2_7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[135]);
			}
			
			a3 = ']' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[136]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[137]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[138]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[139]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[140]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[141]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[142]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[143]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[144]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[145]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[146]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[147]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[153]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_PatternNode returns [edu.ustb.sei.mde.xmu2.pattern.PatternNode element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_VariableDeclaration		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN_NODE__VARIABLE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[154]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[166]);
	}
	
	(
		(
			a1 = '{' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[167]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[168]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[169]);
			}
			
			(
				(
					(
						a2_0 = parse_edu_ustb_sei_mde_xmu2_pattern_PatternExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
								startIncompleteElement(element);
							}
							if (a2_0 != null) {
								if (a2_0 != null) {
									Object value = a2_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN_NODE__EXPRESSIONS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1_0_0_0, a2_0, true);
								copyLocalizationInfos(a2_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[170]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[171]);
					}
					
					(
						(
							a3 = ',' {
								if (element == null) {
									element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
									startIncompleteElement(element);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1_0_0_1_0_0_0, null, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
							}
							{
								// expected elements (follow set)
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[172]);
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[173]);
							}
							
							(
								a4_0 = parse_edu_ustb_sei_mde_xmu2_pattern_PatternExpression								{
									if (terminateParsing) {
										throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
									}
									if (element == null) {
										element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
										startIncompleteElement(element);
									}
									if (a4_0 != null) {
										if (a4_0 != null) {
											Object value = a4_0;
											addObjectToList(element, edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PATTERN_NODE__EXPRESSIONS, value);
											completedElement(value, true);
										}
										collectHiddenTokens(element);
										retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1_0_0_1_0_0_1, a4_0, true);
										copyLocalizationInfos(a4_0, element);
									}
								}
							)
							{
								// expected elements (follow set)
								addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[174]);
								addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[175]);
							}
							
						)
						
					)*					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[176]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[177]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[178]);
			}
			
			a5 = '}' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[179]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[180]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[181]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[182]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[183]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[184]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[185]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[186]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[187]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[188]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[189]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[190]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[195]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[197]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[198]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[199]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[202]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression returns [edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EStructuralFeature proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.pattern.PatternExpression, org.eclipse.emf.ecore.EStructuralFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternExpressionFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[203]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[204]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[205]);
	}
	
	(
		(
			(
				(
					(
						a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_LoopPath						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
								startIncompleteElement(element);
							}
							if (a1_0 != null) {
								if (a1_0 != null) {
									Object value = a1_0;
									element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__SELECTOR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_1_0_0_0_0_0_0, a1_0, true);
								copyLocalizationInfos(a1_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[206]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[207]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_PositionPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__POSITION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[208]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[209]);
	}
	
	a3 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[210]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_xmu2_pattern_PatternNode		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_3, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[212]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression returns [edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EStructuralFeature proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.pattern.PatternExpression, org.eclipse.emf.ecore.EStructuralFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternExpressionFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[213]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[214]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[215]);
	}
	
	(
		(
			(
				(
					(
						a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_LoopPath						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
								startIncompleteElement(element);
							}
							if (a1_0 != null) {
								if (a1_0 != null) {
									Object value = a1_0;
									element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__SELECTOR), value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_1_0_0_0_0_0_0, a1_0, true);
								copyLocalizationInfos(a1_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[216]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[217]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_PositionPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__POSITION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[218]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[219]);
	}
	
	a3 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[220]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[221]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[222]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[223]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[224]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[225]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[226]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[227]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[228]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
		|		a4_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_1 != null) {
				if (a4_1 != null) {
					Object value = a4_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, a4_1, true);
				copyLocalizationInfos(a4_1, element);
			}
		}
		|		a4_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_2 != null) {
				if (a4_2 != null) {
					Object value = a4_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, a4_2, true);
				copyLocalizationInfos(a4_2, element);
			}
		}
		|		a4_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_3 != null) {
				if (a4_3 != null) {
					Object value = a4_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, a4_3, true);
				copyLocalizationInfos(a4_3, element);
			}
		}
		|		a4_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_4 != null) {
				if (a4_4 != null) {
					Object value = a4_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, a4_4, true);
				copyLocalizationInfos(a4_4, element);
			}
		}
		|		a4_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_5 != null) {
				if (a4_5 != null) {
					Object value = a4_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, a4_5, true);
				copyLocalizationInfos(a4_5, element);
			}
		}
		|		a4_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_6 != null) {
				if (a4_6 != null) {
					Object value = a4_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, a4_6, true);
				copyLocalizationInfos(a4_6, element);
			}
		}
		|		a4_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
			}
			if (a4_7 != null) {
				if (a4_7 != null) {
					Object value = a4_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, a4_7, true);
				copyLocalizationInfos(a4_7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[229]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[230]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_LoopPath returns [edu.ustb.sei.mde.xmu2.expression.LoopPath element = null]
@init{
}
:
	a0 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[231]);
	}
	
	(
		(
			a1 = 'select' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getLoopOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.LoopOperator.SELECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = 'forAll' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getLoopOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.LoopOperator.FOR_ALL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = 'exists' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getLoopOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.LoopOperator.EXISTS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[232]);
	}
	
	a6 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[233]);
	}
	
	(
		a7_0 = parse_edu_ustb_sei_mde_xmu2_VariableDeclaration		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a7_0 != null) {
				if (a7_0 != null) {
					Object value = a7_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__VARIABLE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_3, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[234]);
	}
	
	a8 = '|' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[235]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[236]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[238]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[240]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[241]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[242]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[243]);
	}
	
	(
		a9_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_0 != null) {
				if (a9_0 != null) {
					Object value = a9_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a9_0, true);
				copyLocalizationInfos(a9_0, element);
			}
		}
		|		a9_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_1 != null) {
				if (a9_1 != null) {
					Object value = a9_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a9_1, true);
				copyLocalizationInfos(a9_1, element);
			}
		}
		|		a9_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_2 != null) {
				if (a9_2 != null) {
					Object value = a9_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a9_2, true);
				copyLocalizationInfos(a9_2, element);
			}
		}
		|		a9_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_3 != null) {
				if (a9_3 != null) {
					Object value = a9_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a9_3, true);
				copyLocalizationInfos(a9_3, element);
			}
		}
		|		a9_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_4 != null) {
				if (a9_4 != null) {
					Object value = a9_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a9_4, true);
				copyLocalizationInfos(a9_4, element);
			}
		}
		|		a9_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_5 != null) {
				if (a9_5 != null) {
					Object value = a9_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a9_5, true);
				copyLocalizationInfos(a9_5, element);
			}
		}
		|		a9_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_6 != null) {
				if (a9_6 != null) {
					Object value = a9_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a9_6, true);
				copyLocalizationInfos(a9_6, element);
			}
		}
		|		a9_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_7 != null) {
				if (a9_7 != null) {
					Object value = a9_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a9_7, true);
				copyLocalizationInfos(a9_7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[244]);
	}
	
	a10 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[245]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[246]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[247]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[248]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[249]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[250]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[251]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[252]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[253]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[254]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[255]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[256]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[257]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[258]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[260]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[261]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[262]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[264]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[268]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[270]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_FeaturePath returns [edu.ustb.sei.mde.xmu2.expression.FeaturePath element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createFeaturePath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[271]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createFeaturePath();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.FEATURE_PATH__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.FEATURE_PATH__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[272]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[273]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[274]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[275]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[276]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[277]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[278]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[279]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[280]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[281]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[282]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[283]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[284]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[285]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[286]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[287]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[288]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[289]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[290]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[291]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[292]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[293]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[294]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[295]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[296]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[297]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[298]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[299]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_OperationPath returns [edu.ustb.sei.mde.xmu2.expression.OperationPath element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[300]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__OPERATION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__OPERATION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[301]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[302]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[303]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[304]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[305]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[306]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[307]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[308]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[309]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[310]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[311]);
	}
	
	(
		(
			(
				a3_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
				|				a3_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_1 != null) {
						if (a3_1 != null) {
							Object value = a3_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_0, a3_1, true);
						copyLocalizationInfos(a3_1, element);
					}
				}
				|				a3_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_2 != null) {
						if (a3_2 != null) {
							Object value = a3_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_0, a3_2, true);
						copyLocalizationInfos(a3_2, element);
					}
				}
				|				a3_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_3 != null) {
						if (a3_3 != null) {
							Object value = a3_3;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_0, a3_3, true);
						copyLocalizationInfos(a3_3, element);
					}
				}
				|				a3_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_4 != null) {
						if (a3_4 != null) {
							Object value = a3_4;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_0, a3_4, true);
						copyLocalizationInfos(a3_4, element);
					}
				}
				|				a3_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_5 != null) {
						if (a3_5 != null) {
							Object value = a3_5;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_0, a3_5, true);
						copyLocalizationInfos(a3_5, element);
					}
				}
				|				a3_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_6 != null) {
						if (a3_6 != null) {
							Object value = a3_6;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_0, a3_6, true);
						copyLocalizationInfos(a3_6, element);
					}
				}
				|				a3_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_7 != null) {
						if (a3_7 != null) {
							Object value = a3_7;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_0, a3_7, true);
						copyLocalizationInfos(a3_7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[312]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[313]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[314]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[315]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[316]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[317]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[318]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[319]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[320]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[321]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[322]);
					}
					
					(
						a5_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
						|						a5_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_1 != null) {
								if (a5_1 != null) {
									Object value = a5_1;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_1, a5_1, true);
								copyLocalizationInfos(a5_1, element);
							}
						}
						|						a5_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_2 != null) {
								if (a5_2 != null) {
									Object value = a5_2;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_1, a5_2, true);
								copyLocalizationInfos(a5_2, element);
							}
						}
						|						a5_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_3 != null) {
								if (a5_3 != null) {
									Object value = a5_3;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_1, a5_3, true);
								copyLocalizationInfos(a5_3, element);
							}
						}
						|						a5_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_4 != null) {
								if (a5_4 != null) {
									Object value = a5_4;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_1, a5_4, true);
								copyLocalizationInfos(a5_4, element);
							}
						}
						|						a5_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_5 != null) {
								if (a5_5 != null) {
									Object value = a5_5;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_1, a5_5, true);
								copyLocalizationInfos(a5_5, element);
							}
						}
						|						a5_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_6 != null) {
								if (a5_6 != null) {
									Object value = a5_6;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_1, a5_6, true);
								copyLocalizationInfos(a5_6, element);
							}
						}
						|						a5_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_7 != null) {
								if (a5_7 != null) {
									Object value = a5_7;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_3_0_0_1_0_0_1, a5_7, true);
								copyLocalizationInfos(a5_7, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[323]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[324]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[325]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[326]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[327]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[328]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[329]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[330]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[331]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[332]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[333]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[334]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[335]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[336]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[337]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[338]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[339]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[340]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[341]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[342]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[343]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[344]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[345]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[346]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[347]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[348]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[349]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[350]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[351]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[352]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[353]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[354]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[355]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_PositionPath returns [edu.ustb.sei.mde.xmu2.expression.PositionPath element = null]
@init{
}
:
	a0 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[356]);
	}
	
	(
		(
			a1 = 'first' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getPositionOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.PositionOperator.FIRST_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__TYPE), value);
				completedElement(value, false);
			}
			|			a2 = 'last' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getPositionOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.PositionOperator.LAST_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__TYPE), value);
				completedElement(value, false);
			}
			|			a3 = 'at' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getPositionOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.PositionOperator.AT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__TYPE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[357]);
	}
	
	a6 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[358]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[359]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[360]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[361]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[362]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[363]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[364]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[365]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[366]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[367]);
	}
	
	(
		(
			a7_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				if (a7_0 != null) {
					if (a7_0 != null) {
						Object value = a7_0;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3, a7_0, true);
					copyLocalizationInfos(a7_0, element);
				}
			}
			|			a7_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				if (a7_1 != null) {
					if (a7_1 != null) {
						Object value = a7_1;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3, a7_1, true);
					copyLocalizationInfos(a7_1, element);
				}
			}
			|			a7_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				if (a7_2 != null) {
					if (a7_2 != null) {
						Object value = a7_2;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3, a7_2, true);
					copyLocalizationInfos(a7_2, element);
				}
			}
			|			a7_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				if (a7_3 != null) {
					if (a7_3 != null) {
						Object value = a7_3;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3, a7_3, true);
					copyLocalizationInfos(a7_3, element);
				}
			}
			|			a7_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				if (a7_4 != null) {
					if (a7_4 != null) {
						Object value = a7_4;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3, a7_4, true);
					copyLocalizationInfos(a7_4, element);
				}
			}
			|			a7_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				if (a7_5 != null) {
					if (a7_5 != null) {
						Object value = a7_5;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3, a7_5, true);
					copyLocalizationInfos(a7_5, element);
				}
			}
			|			a7_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				if (a7_6 != null) {
					if (a7_6 != null) {
						Object value = a7_6;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3, a7_6, true);
					copyLocalizationInfos(a7_6, element);
				}
			}
			|			a7_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				if (a7_7 != null) {
					if (a7_7 != null) {
						Object value = a7_7;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.POSITION_PATH__VALUE), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3, a7_7, true);
					copyLocalizationInfos(a7_7, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[368]);
	}
	
	a8 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[369]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[370]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[371]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[372]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[373]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[374]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[375]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[376]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[377]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[378]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[379]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[380]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[381]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[382]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[383]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[384]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[385]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[386]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[387]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[388]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[389]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[390]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[391]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[392]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[393]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[394]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[395]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[396]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression returns [edu.ustb.sei.mde.xmu2.expression.VariableExpression element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createVariableExpression();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.VARIABLE_EXPRESSION__VARIABLE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.VARIABLE_EXPRESSION__VARIABLE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[397]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[398]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[399]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[400]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[401]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[402]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[403]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[404]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[405]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[406]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[407]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[408]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[409]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[410]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[411]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[412]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[413]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[414]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[415]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[416]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[417]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[418]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[419]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[420]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[421]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[422]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[423]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[424]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_PathExpression returns [edu.ustb.sei.mde.xmu2.expression.PathExpression element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPathExpression();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PATH_EXPRESSION__HOST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_15_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu2_expression_ConstantExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPathExpression();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PATH_EXPRESSION__HOST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_15_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu2_expression_ParenExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPathExpression();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PATH_EXPRESSION__HOST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_15_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[425]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[426]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[427]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[428]);
	}
	
	(
		(
			a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_Path			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPathExpression();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PATH_EXPRESSION__PATH, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_15_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[429]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[430]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[431]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[432]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[433]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[434]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[435]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[436]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[437]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[438]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[439]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[440]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[441]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[442]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[443]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[444]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[445]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[446]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[447]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[448]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[449]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[450]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[451]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[452]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[453]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[454]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[455]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[456]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_EmptyExpression returns [edu.ustb.sei.mde.xmu2.expression.EmptyExpression element = null]
@init{
}
:
	(
		(
			a0 = 'null' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createEmptyExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_16_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEmptyValueType().getEEnumLiteral(edu.ustb.sei.mde.xmu2.expression.EmptyValueType.NULL_VALUE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.EMPTY_EXPRESSION__TYPE), value);
				completedElement(value, false);
			}
			|			a1 = 'undefined' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createEmptyExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_16_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEmptyValueType().getEEnumLiteral(edu.ustb.sei.mde.xmu2.expression.EmptyValueType.EMPTY_VALUE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.EMPTY_EXPRESSION__TYPE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[457]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[458]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[459]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[460]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[461]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[462]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[463]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[464]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[465]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[466]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[467]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[468]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[469]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[470]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[471]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[472]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[473]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[474]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[475]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[476]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[477]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[478]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[479]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[480]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[481]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[482]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[483]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[484]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression returns [edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression element = null]
@init{
}
:
	(
		a0 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createStringLiteralExpression();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.STRING_LITERAL_EXPRESSION__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.STRING_LITERAL_EXPRESSION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_17_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[485]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[486]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[487]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[488]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[489]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[490]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[491]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[492]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[493]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[494]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[495]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[496]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[497]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[498]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[499]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[500]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[501]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[502]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[503]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[504]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[505]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[506]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[507]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[508]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[509]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[510]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[511]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[512]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression returns [edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression element = null]
@init{
}
:
	(
		a0 = NUMBER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createIntegerLiteralExpression();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.INTEGER_LITERAL_EXPRESSION__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.INTEGER_LITERAL_EXPRESSION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_18_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[513]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[514]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[515]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[516]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[517]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[518]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[519]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[520]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[521]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[522]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[523]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[524]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[525]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[526]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[527]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[528]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[529]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[530]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[531]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[532]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[533]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[534]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[535]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[536]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[537]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[538]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[539]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[540]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression returns [edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression element = null]
@init{
}
:
	(
		a0 = BOOLEAN		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanLiteralExpression();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_LITERAL_EXPRESSION__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Boolean resolved = (java.lang.Boolean) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_LITERAL_EXPRESSION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_19_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[541]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[542]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[543]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[544]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[545]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[546]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[547]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[548]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[549]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[550]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[551]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[552]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[553]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[554]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[555]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[556]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[557]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[558]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[559]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[560]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[561]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[562]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[563]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[564]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[565]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[566]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[567]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[568]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression returns [edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression element = null]
@init{
}
:
	(
		a0 = TYPE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createEnumLiteralExpression();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TYPE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EEnum proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnum();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralExpressionTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_20_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[569]);
	}
	
	a1 = '::' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createEnumLiteralExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_20_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[570]);
	}
	
	(
		a2 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createEnumLiteralExpression();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EEnumLiteral proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnumLiteral();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralExpressionValueReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_20_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[571]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[572]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[573]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[574]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[575]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[576]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[577]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[578]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[579]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[580]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[581]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[582]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[583]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[584]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[585]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[586]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[587]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[588]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[589]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[590]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[591]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[592]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[593]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[594]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[595]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[596]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[597]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[598]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression returns [edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression element = null]
@init{
}
:
	(
		a0 = OBJ_URI		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createObjectURIExpression();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("OBJ_URI");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OBJECT_URI_EXPRESSION__OBJECT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EObject proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression, org.eclipse.emf.ecore.EObject>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectURIExpressionObjectReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OBJECT_URI_EXPRESSION__OBJECT), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.OBJECT_URI_EXPRESSION__OBJECT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_21_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[599]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[600]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[601]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[602]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[603]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[604]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[605]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[606]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[607]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[608]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[609]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[610]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[611]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[612]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[613]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[614]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[615]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[616]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[617]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[618]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[619]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[620]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[621]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[622]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[623]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[624]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[625]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[626]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_ParenExpression returns [edu.ustb.sei.mde.xmu2.expression.ParenExpression element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_22_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[627]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[628]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[629]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[630]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[631]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[632]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[633]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[634]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[635]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_Expression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_22_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[636]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_22_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[637]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[638]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[639]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[640]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[641]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[642]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[643]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[644]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[645]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[646]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[647]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[648]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[649]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[650]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[651]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[652]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[653]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[654]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[655]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[656]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[657]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[658]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[659]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[660]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[661]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[662]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[663]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[664]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression returns [edu.ustb.sei.mde.xmu2.expression.UnaryExpression element = null]
@init{
}
:
	(
		(
			a0 = 'not' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createUnaryExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.UnaryOperator.NOT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.UNARY_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a1 = '-' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createUnaryExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.UnaryOperator.MINUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.UNARY_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[665]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[666]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[667]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[668]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[669]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[670]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[671]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[672]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createUnaryExpression();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.UNARY_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
		|		a4_1 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createUnaryExpression();
				startIncompleteElement(element);
			}
			if (a4_1 != null) {
				if (a4_1 != null) {
					Object value = a4_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.UNARY_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a4_1, true);
				copyLocalizationInfos(a4_1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[673]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[674]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[675]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[676]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[677]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[678]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[679]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[680]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[681]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[682]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[683]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[684]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[685]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[686]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[687]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[688]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[689]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[690]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[691]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[692]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[693]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[694]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression returns [edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createMultiplicativeExpression();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createMultiplicativeExpression();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createMultiplicativeExpression();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[695]);
	}
	
	(
		(
			(
				(
					a1 = '*' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createMultiplicativeExpression();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.MultiplicativeOperator.MUL_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERATORS, value);
						completedElement(value, false);
					}
					|					a2 = '/' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createMultiplicativeExpression();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.MultiplicativeOperator.DIV_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERATORS, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[696]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[697]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[698]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[699]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[700]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[701]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[702]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[703]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[704]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createMultiplicativeExpression();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_1_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
				|				a5_1 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createMultiplicativeExpression();
						startIncompleteElement(element);
					}
					if (a5_1 != null) {
						if (a5_1 != null) {
							Object value = a5_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_1_0_0_1, a5_1, true);
						copyLocalizationInfos(a5_1, element);
					}
				}
				|				a5_2 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createMultiplicativeExpression();
						startIncompleteElement(element);
					}
					if (a5_2 != null) {
						if (a5_2 != null) {
							Object value = a5_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.MULTIPLICATIVE_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_1_0_0_1, a5_2, true);
						copyLocalizationInfos(a5_2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[705]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[706]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[707]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[708]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[709]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[710]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[711]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[712]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[713]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[714]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[715]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[716]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[717]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[718]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[719]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[720]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[721]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[722]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[723]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[724]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[725]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[726]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[727]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[728]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[729]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[730]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression returns [edu.ustb.sei.mde.xmu2.expression.AdditiveExpression element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[731]);
	}
	
	(
		(
			(
				(
					a1 = '+' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.AdditiveOperator.ADD_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS, value);
						completedElement(value, false);
					}
					|					a2 = '-' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.AdditiveOperator.SUB_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS, value);
						completedElement(value, false);
					}
					|					a3 = '++' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.AdditiveOperator.APPEND_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[732]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[733]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[734]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[735]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[736]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[737]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[738]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[739]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[740]);
			}
			
			(
				a6_0 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
						startIncompleteElement(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_1, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
				|				a6_1 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
						startIncompleteElement(element);
					}
					if (a6_1 != null) {
						if (a6_1 != null) {
							Object value = a6_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_1, a6_1, true);
						copyLocalizationInfos(a6_1, element);
					}
				}
				|				a6_2 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
						startIncompleteElement(element);
					}
					if (a6_2 != null) {
						if (a6_2 != null) {
							Object value = a6_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_1, a6_2, true);
						copyLocalizationInfos(a6_2, element);
					}
				}
				|				a6_3 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createAdditiveExpression();
						startIncompleteElement(element);
					}
					if (a6_3 != null) {
						if (a6_3 != null) {
							Object value = a6_3;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_1, a6_3, true);
						copyLocalizationInfos(a6_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[741]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[742]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[743]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[744]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[745]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[746]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[747]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[748]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[749]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[750]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[751]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[752]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[753]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[754]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[755]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[756]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[757]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[758]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[759]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[760]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[761]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[762]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[763]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[764]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression returns [edu.ustb.sei.mde.xmu2.expression.RelationalExpression element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
		|		a0_4 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a0_4 != null) {
				if (a0_4 != null) {
					Object value = a0_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_4, true);
				copyLocalizationInfos(a0_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[765]);
	}
	
	(
		(
			a1 = '=' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.RelationalOperator.EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = '<' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.RelationalOperator.LESS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = '<=' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.RelationalOperator.LESS_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = '>' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.RelationalOperator.GREATER_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = '>=' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.RelationalOperator.GREATER_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[766]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[767]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[768]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[769]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[770]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[771]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[772]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[773]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[774]);
	}
	
	(
		a8_0 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					Object value = a8_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_2, a8_0, true);
				copyLocalizationInfos(a8_0, element);
			}
		}
		|		a8_1 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a8_1 != null) {
				if (a8_1 != null) {
					Object value = a8_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_2, a8_1, true);
				copyLocalizationInfos(a8_1, element);
			}
		}
		|		a8_2 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a8_2 != null) {
				if (a8_2 != null) {
					Object value = a8_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_2, a8_2, true);
				copyLocalizationInfos(a8_2, element);
			}
		}
		|		a8_3 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a8_3 != null) {
				if (a8_3 != null) {
					Object value = a8_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_2, a8_3, true);
				copyLocalizationInfos(a8_3, element);
			}
		}
		|		a8_4 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
				startIncompleteElement(element);
			}
			if (a8_4 != null) {
				if (a8_4 != null) {
					Object value = a8_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.RELATIONAL_EXPRESSION__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_2, a8_4, true);
				copyLocalizationInfos(a8_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[775]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[776]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[777]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[778]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[779]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[780]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[781]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[782]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[783]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[784]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[785]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression returns [edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
		|		a0_4 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
				startIncompleteElement(element);
			}
			if (a0_4 != null) {
				if (a0_4 != null) {
					Object value = a0_4;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_4, true);
				copyLocalizationInfos(a0_4, element);
			}
		}
		|		a0_5 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
				startIncompleteElement(element);
			}
			if (a0_5 != null) {
				if (a0_5 != null) {
					Object value = a0_5;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_5, true);
				copyLocalizationInfos(a0_5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[786]);
	}
	
	(
		(
			a1 = 'and' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[787]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[788]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[789]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[790]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[791]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[792]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[793]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[794]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[795]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1_0_0_1, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1_0_0_1, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1_0_0_1, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
				|				a2_4 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
						startIncompleteElement(element);
					}
					if (a2_4 != null) {
						if (a2_4 != null) {
							Object value = a2_4;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1_0_0_1, a2_4, true);
						copyLocalizationInfos(a2_4, element);
					}
				}
				|				a2_5 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
						startIncompleteElement(element);
					}
					if (a2_5 != null) {
						if (a2_5 != null) {
							Object value = a2_5;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1_0_0_1, a2_5, true);
						copyLocalizationInfos(a2_5, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[796]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[797]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[798]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[799]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[800]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[801]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[802]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[803]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[804]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[805]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[806]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[807]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[808]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[809]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[810]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[811]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[812]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[813]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[814]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[815]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[816]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[817]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression returns [edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
		|		a0_4 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
				startIncompleteElement(element);
			}
			if (a0_4 != null) {
				if (a0_4 != null) {
					Object value = a0_4;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_4, true);
				copyLocalizationInfos(a0_4, element);
			}
		}
		|		a0_5 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
				startIncompleteElement(element);
			}
			if (a0_5 != null) {
				if (a0_5 != null) {
					Object value = a0_5;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_5, true);
				copyLocalizationInfos(a0_5, element);
			}
		}
		|		a0_6 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
				startIncompleteElement(element);
			}
			if (a0_6 != null) {
				if (a0_6 != null) {
					Object value = a0_6;
					addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_6, true);
				copyLocalizationInfos(a0_6, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[818]);
	}
	
	(
		(
			a1 = 'or' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[819]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[820]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[821]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[822]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[823]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[824]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[825]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[826]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[827]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
				|				a2_4 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
						startIncompleteElement(element);
					}
					if (a2_4 != null) {
						if (a2_4 != null) {
							Object value = a2_4;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_4, true);
						copyLocalizationInfos(a2_4, element);
					}
				}
				|				a2_5 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
						startIncompleteElement(element);
					}
					if (a2_5 != null) {
						if (a2_5 != null) {
							Object value = a2_5;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_5, true);
						copyLocalizationInfos(a2_5, element);
					}
				}
				|				a2_6 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
						startIncompleteElement(element);
					}
					if (a2_6 != null) {
						if (a2_6 != null) {
							Object value = a2_6;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.BOOLEAN_OR_EXPRESSION__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_6, true);
						copyLocalizationInfos(a2_6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[828]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[829]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[830]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[831]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[832]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[833]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[834]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[835]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[836]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[837]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[838]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[839]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[840]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[841]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[842]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[843]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[844]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[845]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[846]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[847]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement returns [edu.ustb.sei.mde.xmu2.statement.BlockStatement element = null]
@init{
}
:
	a0 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[848]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[849]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[850]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[851]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[852]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[853]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[854]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[855]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[856]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[857]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu2_statement_Statement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[858]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[859]);
			}
			
			(
				(
					a2 = ';' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[860]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[861]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[862]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[863]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[864]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[865]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[866]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[867]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[868]);
					}
					
					(
						a3_0 = parse_edu_ustb_sei_mde_xmu2_statement_Statement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_0 != null) {
								if (a3_0 != null) {
									Object value = a3_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1_0_0_1, a3_0, true);
								copyLocalizationInfos(a3_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[869]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[870]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[871]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[872]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[873]);
	}
	
	a4 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[874]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[875]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[876]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[877]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[878]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[879]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[880]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[881]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement returns [edu.ustb.sei.mde.xmu2.statement.UpdateStatement element = null]
@init{
}
:
	a0 = 'update' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[882]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_pattern_Pattern		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__SOURCE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[883]);
	}
	
	a2 = 'with' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[884]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu2_pattern_Pattern		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateStatement();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__VIEW), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[885]);
	}
	
	a4 = 'by' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[886]);
	}
	
	(
		(
			a5_0 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateClause			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateStatement();
					startIncompleteElement(element);
				}
				if (a5_0 != null) {
					if (a5_0 != null) {
						Object value = a5_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_STATEMENT__CLAUSES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_5, a5_0, true);
					copyLocalizationInfos(a5_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[887]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[888]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[889]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[890]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[891]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[892]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[893]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[894]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement returns [edu.ustb.sei.mde.xmu2.statement.SwitchStatement element = null]
@init{
}
:
	a0 = 'switch' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[895]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[896]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.SWITCH_STATEMENT__ROOT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[897]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[898]);
	}
	
	a4 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[899]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[900]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[901]);
	}
	
	(
		(
			a5_0 = parse_edu_ustb_sei_mde_xmu2_statement_CaseClause			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
					startIncompleteElement(element);
				}
				if (a5_0 != null) {
					if (a5_0 != null) {
						Object value = a5_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.SWITCH_STATEMENT__CASES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_5, a5_0, true);
					copyLocalizationInfos(a5_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[902]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[903]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[904]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[905]);
	}
	
	a6 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[906]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[907]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[908]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[909]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[910]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[911]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[912]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[913]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_UpdateClause returns [edu.ustb.sei.mde.xmu2.statement.UpdateClause element = null]
@init{
}
:
	(
		(
			a0 = 'match' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getActionType().getEEnumLiteral(edu.ustb.sei.mde.xmu2.statement.ActionType.MATCH_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__TYPE), value);
				completedElement(value, false);
			}
			|			a1 = 'unmatchs' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getActionType().getEEnumLiteral(edu.ustb.sei.mde.xmu2.statement.ActionType.UNMATCHS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__TYPE), value);
				completedElement(value, false);
			}
			|			a2 = 'unmatchv' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getActionType().getEEnumLiteral(edu.ustb.sei.mde.xmu2.statement.ActionType.UNMATCHV_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__TYPE), value);
				completedElement(value, false);
			}
			|			a3 = 'default' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getActionType().getEEnumLiteral(edu.ustb.sei.mde.xmu2.statement.ActionType.DEFAULT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__TYPE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[914]);
	}
	
	a6 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[915]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[916]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[917]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[918]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[919]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[920]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[921]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[922]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[923]);
	}
	
	(
		a7_0 = parse_edu_ustb_sei_mde_xmu2_statement_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_0 != null) {
				if (a7_0 != null) {
					Object value = a7_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_2, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[924]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[925]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[926]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[927]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[928]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[929]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[930]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[931]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_PatternCaseClause returns [edu.ustb.sei.mde.xmu2.statement.PatternCaseClause element = null]
@init{
}
:
	a0 = 'case' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[932]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_pattern_Pattern		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[933]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[934]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[935]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[936]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[937]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[938]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[939]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[940]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[941]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[942]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu2_statement_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[943]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[944]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[945]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[946]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_ExpressionCaseClause returns [edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause element = null]
@init{
}
:
	a0 = 'case' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[947]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[948]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[949]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[950]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[951]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[952]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[953]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[954]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[955]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
		|		a1_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a1_1 != null) {
				if (a1_1 != null) {
					Object value = a1_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_1, a1_1, true);
				copyLocalizationInfos(a1_1, element);
			}
		}
		|		a1_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a1_2 != null) {
				if (a1_2 != null) {
					Object value = a1_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_1, a1_2, true);
				copyLocalizationInfos(a1_2, element);
			}
		}
		|		a1_3 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a1_3 != null) {
				if (a1_3 != null) {
					Object value = a1_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_1, a1_3, true);
				copyLocalizationInfos(a1_3, element);
			}
		}
		|		a1_4 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a1_4 != null) {
				if (a1_4 != null) {
					Object value = a1_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_1, a1_4, true);
				copyLocalizationInfos(a1_4, element);
			}
		}
		|		a1_5 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a1_5 != null) {
				if (a1_5 != null) {
					Object value = a1_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_1, a1_5, true);
				copyLocalizationInfos(a1_5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[956]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[957]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[958]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[959]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[960]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[961]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[962]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[963]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[964]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[965]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu2_statement_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[966]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[967]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[968]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[969]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement returns [edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement element = null]
@init{
}
:
	a0 = 'delete' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteNodeStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteNodeStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[970]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteNodeStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_NODE_STATEMENT__NODE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[971]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[972]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[973]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[974]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[975]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[976]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[977]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[978]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_DeleteLinkStatement returns [edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement element = null]
@init{
}
:
	a0 = 'delete' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteLinkStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[979]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_LINK_STATEMENT__SOURCE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[980]);
	}
	
	a2 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteLinkStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[981]);
	}
	
	(
		a3 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_LINK_STATEMENT__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_LINK_STATEMENT__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[982]);
	}
	
	a4 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteLinkStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[983]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[984]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[985]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[986]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[987]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[988]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[989]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[990]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[991]);
	}
	
	(
		a5_0 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_5, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
		|		a5_1 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a5_1 != null) {
				if (a5_1 != null) {
					Object value = a5_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_5, a5_1, true);
				copyLocalizationInfos(a5_1, element);
			}
		}
		|		a5_2 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a5_2 != null) {
				if (a5_2 != null) {
					Object value = a5_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_5, a5_2, true);
				copyLocalizationInfos(a5_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[992]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[993]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[994]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[995]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[996]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[997]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[998]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[999]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement returns [edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement element = null]
@init{
}
:
	a0 = 'enforce' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createEnforcePatternStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getEnforcePatternStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1000]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_pattern_Pattern		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createEnforcePatternStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ENFORCE_PATTERN_STATEMENT__PATTERN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1001]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1002]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1003]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1004]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1005]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1006]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1007]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1008]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement returns [edu.ustb.sei.mde.xmu2.statement.ForEachStatement element = null]
@init{
}
:
	a0 = 'foreach' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_38_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1009]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_pattern_Pattern		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__PATTERN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_38_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1010]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_38_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1011]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1012]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1013]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1014]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1015]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1016]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1017]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1018]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1019]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu2_statement_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_38_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1020]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1021]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1022]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1023]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1024]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1025]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1026]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1027]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement returns [edu.ustb.sei.mde.xmu2.statement.RuleCallStatement element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__RULE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu2.AbstractRule proxy = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.statement.RuleCallStatement, edu.ustb.sei.mde.xmu2.AbstractRule>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleCallStatementRuleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__RULE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__RULE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1028]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1029]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1030]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1031]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1032]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1033]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1034]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1035]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1036]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1037]);
	}
	
	(
		(
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_2_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_2_0_0_0, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1038]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1039]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1040]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1041]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1042]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1043]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1044]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1045]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1046]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1047]);
					}
					
					(
						a4_0 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
								startIncompleteElement(element);
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									Object value = a4_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_2_0_0_1_0_0_1, a4_0, true);
								copyLocalizationInfos(a4_0, element);
							}
						}
						|						a4_1 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
								startIncompleteElement(element);
							}
							if (a4_1 != null) {
								if (a4_1 != null) {
									Object value = a4_1;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.RULE_CALL_STATEMENT__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_2_0_0_1_0_0_1, a4_1, true);
								copyLocalizationInfos(a4_1, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1048]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1049]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1050]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1051]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1052]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1053]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1054]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1055]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1056]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1057]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1058]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1059]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1060]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_Skip returns [edu.ustb.sei.mde.xmu2.statement.Skip element = null]
@init{
}
:
	a0 = 'skip' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSkip();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1061]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1062]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1063]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1064]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1065]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1066]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1067]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1068]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause returns [edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause element = null]
@init{
}
:
	a0 = 'otherwise' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_41_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1069]);
	}
	
	a1 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_41_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1070]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1071]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1072]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1073]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1074]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1075]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1076]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1077]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1078]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_xmu2_statement_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_41_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1079]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1080]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1081]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1082]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_AbstractRule returns [edu.ustb.sei.mde.xmu2.AbstractRule element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_ModelRule{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu2_statement_Statement returns [edu.ustb.sei.mde.xmu2.statement.Statement element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteLinkStatement{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip{ element = c8; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression returns [edu.ustb.sei.mde.xmu2.expression.AtomicExpression element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_expression_EmptyExpression{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_edu_ustb_sei_mde_xmu2_expression_ParenExpression{ element = c7; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_PatternExpression returns [edu.ustb.sei.mde.xmu2.pattern.PatternExpression element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu2_expression_ConstantExpression returns [edu.ustb.sei.mde.xmu2.expression.ConstantExpression element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_expression_EmptyExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression{ element = c5; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu2_expression_Path returns [edu.ustb.sei.mde.xmu2.expression.Path element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_expression_LoopPath{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_expression_FeaturePath{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu2_expression_OperationPath{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu2_expression_PositionPath{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu2_expression_Expression returns [edu.ustb.sei.mde.xmu2.expression.Expression element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu2_expression_EmptyExpression{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_edu_ustb_sei_mde_xmu2_expression_ParenExpression{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression{ element = c14; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu2_statement_CaseClause returns [edu.ustb.sei.mde.xmu2.statement.CaseClause element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_statement_PatternCaseClause{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_statement_ExpressionCaseClause{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

TYPE:
	('String'|'Boolean'|'Integer'|'Resource'|(('a'..'z'|'A'..'Z'|'0'..'9'|'_')+'!'('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*))
;
BOOLEAN:
	('true'|'false')
;
NAME:
	(('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*('@post')?)
;
NUMBER:
	(('0'..'9')+)
;
SL_COMMENT:
	( '//'(~('\n'|'\r'|'\uffff'))* )
	{ _channel = 99; }
;
ML_COMMENT:
	( '/*'.*'*/')
	{ _channel = 99; }
;
OBJ_URI:
	('@'('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/'|'\\'|'\.'|':'|'#')*)
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
	{ _channel = 99; }
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_60_62_92:
	(('<')(('\\''>')|('\\''\\')|(~('>'|'\\')))*('>'))
;
QUOTED_39_39_92:
	(('\'')(('\\''\'')|('\\''\\')|(~('\''|'\\')))*('\''))
;

