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
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.ArithmeticRule.class) {
				return parse_edu_ustb_sei_mde_xmu2_ArithmeticRule();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.ConcreteVariableDeclaration.class) {
				return parse_edu_ustb_sei_mde_xmu2_ConcreteVariableDeclaration();
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
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.ConcreteDeleteLinkStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement();
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
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.Fail.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_Fail();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.AssignStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.ReflectiveVariableDeclaration.class) {
				return parse_edu_ustb_sei_mde_xmu2_ReflectiveVariableDeclaration();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode.class) {
				return parse_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression.class) {
				return parse_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement.class) {
				return parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement();
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
		int followSetID = 253;
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
	a0 = 'rule' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[46]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[47]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[49]);
	}
	
	(
		(
			(
				a3_0 = parse_edu_ustb_sei_mde_xmu2_Parameter				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[50]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[51]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[52]);
					}
					
					(
						a5_0 = parse_edu_ustb_sei_mde_xmu2_Parameter						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_3_0_0_1_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[53]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[54]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[55]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[56]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[57]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[58]);
	}
	
	a7 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[59]);
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
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[72]);
	}
	
	(
		(
			(
				a8_0 = parse_edu_ustb_sei_mde_xmu2_ConcreteVariableDeclaration				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
						startIncompleteElement(element);
					}
					if (a8_0 != null) {
						if (a8_0 != null) {
							Object value = a8_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__VARIABLE_DECLARATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_6_0_0_0, a8_0, true);
						copyLocalizationInfos(a8_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[73]);
			}
			
			a9 = ';' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_6_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[74]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[75]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[77]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[78]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[79]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[81]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[82]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[83]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[84]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[85]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[86]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[87]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[96]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[97]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[101]);
	}
	
	(
		(
			a10_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_0 != null) {
					if (a10_0 != null) {
						Object value = a10_0;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_0, true);
					copyLocalizationInfos(a10_0, element);
				}
			}
			|			a10_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_1 != null) {
					if (a10_1 != null) {
						Object value = a10_1;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_1, true);
					copyLocalizationInfos(a10_1, element);
				}
			}
			|			a10_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_2 != null) {
					if (a10_2 != null) {
						Object value = a10_2;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_2, true);
					copyLocalizationInfos(a10_2, element);
				}
			}
			|			a10_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_3 != null) {
					if (a10_3 != null) {
						Object value = a10_3;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_3, true);
					copyLocalizationInfos(a10_3, element);
				}
			}
			|			a10_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_4 != null) {
					if (a10_4 != null) {
						Object value = a10_4;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_4, true);
					copyLocalizationInfos(a10_4, element);
				}
			}
			|			a10_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_5 != null) {
					if (a10_5 != null) {
						Object value = a10_5;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_5, true);
					copyLocalizationInfos(a10_5, element);
				}
			}
			|			a10_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_6 != null) {
					if (a10_6 != null) {
						Object value = a10_6;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_6, true);
					copyLocalizationInfos(a10_6, element);
				}
			}
			|			a10_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_7 != null) {
					if (a10_7 != null) {
						Object value = a10_7;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_7, true);
					copyLocalizationInfos(a10_7, element);
				}
			}
			|			a10_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_8 != null) {
					if (a10_8 != null) {
						Object value = a10_8;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_8, true);
					copyLocalizationInfos(a10_8, element);
				}
			}
			|			a10_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_9 != null) {
					if (a10_9 != null) {
						Object value = a10_9;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_9, true);
					copyLocalizationInfos(a10_9, element);
				}
			}
			|			a10_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_10 != null) {
					if (a10_10 != null) {
						Object value = a10_10;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_10, true);
					copyLocalizationInfos(a10_10, element);
				}
			}
			|			a10_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
					startIncompleteElement(element);
				}
				if (a10_11 != null) {
					if (a10_11 != null) {
						Object value = a10_11;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.MODEL_RULE__STATEMENT), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_7, a10_11, true);
					copyLocalizationInfos(a10_11, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[102]);
	}
	
	a11 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createModelRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_3_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[104]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_ArithmeticRule returns [edu.ustb.sei.mde.xmu2.ArithmeticRule element = null]
@init{
}
:
	a0 = 'function' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[105]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[106]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[108]);
	}
	
	(
		(
			(
				a3_0 = parse_edu_ustb_sei_mde_xmu2_Parameter				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[109]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[110]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[111]);
					}
					
					(
						a5_0 = parse_edu_ustb_sei_mde_xmu2_Parameter						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_3_0_0_1_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[112]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[113]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[114]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[115]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[116]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[117]);
	}
	
	a7 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[118]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[130]);
	}
	
	(
		(
			a8_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_0 != null) {
					if (a8_0 != null) {
						Object value = a8_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_0, true);
					copyLocalizationInfos(a8_0, element);
				}
			}
			|			a8_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_1 != null) {
					if (a8_1 != null) {
						Object value = a8_1;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_1, true);
					copyLocalizationInfos(a8_1, element);
				}
			}
			|			a8_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_2 != null) {
					if (a8_2 != null) {
						Object value = a8_2;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_2, true);
					copyLocalizationInfos(a8_2, element);
				}
			}
			|			a8_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_3 != null) {
					if (a8_3 != null) {
						Object value = a8_3;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_3, true);
					copyLocalizationInfos(a8_3, element);
				}
			}
			|			a8_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_4 != null) {
					if (a8_4 != null) {
						Object value = a8_4;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_4, true);
					copyLocalizationInfos(a8_4, element);
				}
			}
			|			a8_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_5 != null) {
					if (a8_5 != null) {
						Object value = a8_5;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_5, true);
					copyLocalizationInfos(a8_5, element);
				}
			}
			|			a8_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_6 != null) {
					if (a8_6 != null) {
						Object value = a8_6;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_6, true);
					copyLocalizationInfos(a8_6, element);
				}
			}
			|			a8_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_7 != null) {
					if (a8_7 != null) {
						Object value = a8_7;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_7, true);
					copyLocalizationInfos(a8_7, element);
				}
			}
			|			a8_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_8 != null) {
					if (a8_8 != null) {
						Object value = a8_8;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_8, true);
					copyLocalizationInfos(a8_8, element);
				}
			}
			|			a8_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_9 != null) {
					if (a8_9 != null) {
						Object value = a8_9;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_9, true);
					copyLocalizationInfos(a8_9, element);
				}
			}
			|			a8_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_10 != null) {
					if (a8_10 != null) {
						Object value = a8_10;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_10, true);
					copyLocalizationInfos(a8_10, element);
				}
			}
			|			a8_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
					startIncompleteElement(element);
				}
				if (a8_11 != null) {
					if (a8_11 != null) {
						Object value = a8_11;
						addObjectToList(element, edu.ustb.sei.mde.xmu2.Xmu2Package.ARITHMETIC_RULE__STATEMENTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_6, a8_11, true);
					copyLocalizationInfos(a8_11, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[133]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[135]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[136]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[137]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[139]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[140]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[143]);
	}
	
	a9 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createArithmeticRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_4_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[144]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[145]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_ConcreteVariableDeclaration returns [edu.ustb.sei.mde.xmu2.ConcreteVariableDeclaration element = null]
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
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createConcreteVariableDeclaration();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_5_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[146]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createConcreteVariableDeclaration();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[147]);
	}
	
	(
		a2 = TYPE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createConcreteVariableDeclaration();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TYPE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EClassifier proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTypedElementTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.CONCRETE_VARIABLE_DECLARATION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_5_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[153]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[154]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[167]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[168]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[169]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[170]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[172]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[173]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[174]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_0, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu2common.Xmu2commonPackage.eINSTANCE.getDomainTag().getEEnumLiteral(edu.ustb.sei.mde.xmu2common.DomainTag.VIEW_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.PARAMETER__TAG), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[175]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[176]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[177]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_6_0_0_3, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[178]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[179]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[180]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[181]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[184]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[195]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[197]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[198]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[199]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[203]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[204]);
	}
	
	(
		(
			a1 = '[' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[205]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[206]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[207]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[208]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[209]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[210]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[211]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[212]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[213]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1, a2_0, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1, a2_1, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1, a2_2, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1, a2_3, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1, a2_4, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1, a2_5, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1, a2_6, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_1, a2_7, true);
						copyLocalizationInfos(a2_7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[214]);
			}
			
			a3 = ']' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_7_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[215]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[216]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[217]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[218]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[219]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[220]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[221]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[222]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[223]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[224]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[225]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[226]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[227]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[228]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[229]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[230]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[231]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[232]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[233]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[234]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[235]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[236]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[238]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[240]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[241]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[242]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[243]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[244]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[245]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[246]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[247]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[248]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[249]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[250]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[251]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[252]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[253]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[254]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[255]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[256]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[257]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[258]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_PatternNode returns [edu.ustb.sei.mde.xmu2.pattern.PatternNode element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_ConcreteVariableDeclaration		{
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[260]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[261]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[262]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[264]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[268]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[270]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[271]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[272]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[273]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[274]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[275]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[276]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[277]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[278]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[279]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[280]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[281]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[282]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[283]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[284]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[285]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[286]);
	}
	
	(
		(
			a1 = '{' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[287]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[288]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[289]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[290]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[291]);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_1_0_0_1_0_0_0, a2_0, true);
								copyLocalizationInfos(a2_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[292]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[293]);
					}
					
					(
						(
							a3 = ',' {
								if (element == null) {
									element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
									startIncompleteElement(element);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_1_0_0_1_0_0_1_0_0_0, null, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
							}
							{
								// expected elements (follow set)
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[294]);
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[295]);
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[296]);
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[297]);
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
										retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_1_0_0_1_0_0_1_0_0_1, a4_0, true);
										copyLocalizationInfos(a4_0, element);
									}
								}
							)
							{
								// expected elements (follow set)
								addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[298]);
								addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[299]);
							}
							
						)
						
					)*					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[300]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[301]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[302]);
			}
			
			a5 = '}' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPatternNode();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_8_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[303]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[304]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[305]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[306]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[307]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[308]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[309]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[310]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[311]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[312]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[313]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[314]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[315]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[316]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[317]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[318]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[319]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[320]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[321]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[322]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[323]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[324]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[325]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[326]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[327]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[328]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[329]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[330]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[331]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[332]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[333]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[334]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[335]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[336]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[337]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[338]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[339]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[340]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[341]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[342]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[343]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[344]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[345]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[346]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[347]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[348]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[349]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[350]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[351]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[352]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[353]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[354]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[355]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[356]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode{ element = c0; /* this is a subclass or primitive expression choice */ }
	
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
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				}
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[357]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[358]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[359]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_LoopPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
						}
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__SELECTOR), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[360]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[361]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[362]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[363]);
	}
	
	(
		(
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_PositionPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
						}
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__POSITION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_2_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[364]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[365]);
	}
	
	a3 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[366]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[367]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[368]);
	}
	
	(
		(
			a4 = '?' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_4, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[369]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[370]);
	}
	
	(
		a7_0 = parse_edu_ustb_sei_mde_xmu2_pattern_PatternNode		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createObjectPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_0 != null) {
				if (a7_0 != null) {
					Object value = a7_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_9_0_0_5, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[371]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[372]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[373]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[374]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
	
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
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[375]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[376]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[377]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_LoopPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
						}
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__SELECTOR), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[378]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[379]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[380]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[381]);
	}
	
	(
		(
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_PositionPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
						}
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__POSITION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_2_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[382]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[383]);
	}
	
	a3 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[384]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[385]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[386]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[387]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[388]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[389]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[390]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[391]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[392]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[393]);
	}
	
	(
		(
			a4 = '?' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_4, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[394]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[395]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[396]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[397]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[398]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[399]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[400]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[401]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[402]);
	}
	
	(
		a7_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_0 != null) {
				if (a7_0 != null) {
					Object value = a7_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
		|		a7_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_1 != null) {
				if (a7_1 != null) {
					Object value = a7_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a7_1, true);
				copyLocalizationInfos(a7_1, element);
			}
		}
		|		a7_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_2 != null) {
				if (a7_2 != null) {
					Object value = a7_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a7_2, true);
				copyLocalizationInfos(a7_2, element);
			}
		}
		|		a7_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_3 != null) {
				if (a7_3 != null) {
					Object value = a7_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a7_3, true);
				copyLocalizationInfos(a7_3, element);
			}
		}
		|		a7_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_4 != null) {
				if (a7_4 != null) {
					Object value = a7_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a7_4, true);
				copyLocalizationInfos(a7_4, element);
			}
		}
		|		a7_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_5 != null) {
				if (a7_5 != null) {
					Object value = a7_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a7_5, true);
				copyLocalizationInfos(a7_5, element);
			}
		}
		|		a7_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_6 != null) {
				if (a7_6 != null) {
					Object value = a7_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a7_6, true);
				copyLocalizationInfos(a7_6, element);
			}
		}
		|		a7_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createPropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a7_7 != null) {
				if (a7_7 != null) {
					Object value = a7_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_10_0_0_5, a7_7, true);
				copyLocalizationInfos(a7_7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[403]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[404]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[405]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[406]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
	
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[407]);
	}
	
	(
		(
			a1 = 'select' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_1, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_1, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_1, null, true);
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
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[408]);
	}
	
	a6 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[409]);
	}
	
	(
		a7_0 = parse_edu_ustb_sei_mde_xmu2_ConcreteVariableDeclaration		{
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_3, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[410]);
	}
	
	a8 = '|' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[411]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[412]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[413]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[414]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[415]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[416]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[417]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[418]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[419]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_5, a9_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_5, a9_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_5, a9_2, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_5, a9_3, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_5, a9_4, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_5, a9_5, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_5, a9_6, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_5, a9_7, true);
				copyLocalizationInfos(a9_7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[420]);
	}
	
	a10 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_11_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[421]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[422]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[423]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[424]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[425]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[426]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[427]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[428]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[429]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[430]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[431]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[432]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[433]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[434]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[435]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[436]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[437]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[438]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[439]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[440]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[441]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[442]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[443]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[444]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[445]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[446]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[447]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[448]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[449]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[450]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[451]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[452]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[453]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[454]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[455]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[456]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[457]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[458]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[459]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[460]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[461]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[462]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[463]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[464]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[465]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[466]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_12_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[467]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[468]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[469]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[470]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[471]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[472]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[473]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[474]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[475]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[476]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[477]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[478]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[479]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[480]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[481]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[482]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[483]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[484]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[485]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[486]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[487]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[488]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[489]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[490]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[491]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[492]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[493]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[494]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[495]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[496]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[497]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[498]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[499]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[500]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[501]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[502]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[503]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[504]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[505]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[506]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[507]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[508]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[509]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[510]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[511]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[512]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[513]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[514]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[515]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[516]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[517]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[518]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[519]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[520]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[521]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[522]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[523]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[524]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_0, a3_0, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_0, a3_1, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_0, a3_2, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_0, a3_3, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_0, a3_4, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_0, a3_5, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_0, a3_6, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_0, a3_7, true);
						copyLocalizationInfos(a3_7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[525]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[526]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[527]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[528]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[529]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[530]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[531]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[532]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[533]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[534]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[535]);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_1, a5_0, true);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_1, a5_1, true);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_1, a5_2, true);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_1, a5_3, true);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_1, a5_4, true);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_1, a5_5, true);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_1, a5_6, true);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_3_0_0_1_0_0_1, a5_7, true);
								copyLocalizationInfos(a5_7, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[536]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[537]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[538]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[539]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[540]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createOperationPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_13_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[541]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[542]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[543]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[544]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[545]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[546]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[547]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[548]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[549]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[550]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[551]);
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
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[562]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[563]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[564]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[565]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[566]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[567]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[568]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[569]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[570]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[571]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[572]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[573]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[574]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[575]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[576]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[577]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[578]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[579]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[580]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[581]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[582]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[583]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[584]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[585]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[586]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[587]);
	}
	
	(
		(
			a1 = 'first' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_1, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_1, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_1, null, true);
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
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[588]);
	}
	
	a6 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[589]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[590]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[591]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[592]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[593]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[594]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[595]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[596]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[597]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[598]);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_3, a7_0, true);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_3, a7_1, true);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_3, a7_2, true);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_3, a7_3, true);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_3, a7_4, true);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_3, a7_5, true);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_3, a7_6, true);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_3, a7_7, true);
					copyLocalizationInfos(a7_7, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[599]);
	}
	
	a8 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createPositionPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_14_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[600]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[601]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[602]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[603]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[604]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[605]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[606]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[607]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[608]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[609]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[610]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[611]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[612]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[613]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[614]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[615]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[616]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[617]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[618]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[619]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[620]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[621]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[622]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[623]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[624]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[625]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[626]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[627]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[628]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[629]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[630]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[631]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[632]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[633]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[634]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[635]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[636]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[637]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[638]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[639]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[640]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[641]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[642]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[643]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[644]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_15_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[645]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[646]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[647]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[648]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[649]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[650]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[651]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[652]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[653]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[654]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[655]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[656]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[657]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[658]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[659]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[660]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[661]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[662]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[663]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[664]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[665]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[666]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[667]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[668]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[669]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[670]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[671]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[672]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[673]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[674]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[675]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[676]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[677]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[678]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[679]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[680]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[681]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[682]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[683]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[684]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[685]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[686]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[687]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[688]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[689]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[690]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_16_0_0_0, a0_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_16_0_0_0, a0_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_16_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[691]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[692]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[693]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[694]);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_16_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[695]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[696]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[697]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[698]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[699]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[700]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[701]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[702]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[703]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[704]);
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
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[716]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[717]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[718]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[719]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[720]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[721]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[722]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[723]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[724]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[725]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[726]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[727]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[728]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[729]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[730]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[731]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[732]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[733]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[734]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[735]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[736]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[737]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[738]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[739]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[740]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_17_0_0_0, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_17_0_0_0, null, true);
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
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[741]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[742]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[743]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[744]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[745]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[746]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[747]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[748]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[749]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[750]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[751]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[752]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[753]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[754]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[755]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[756]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[757]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[758]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[759]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[760]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[761]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[762]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[763]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[764]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[765]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[766]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[767]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[768]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[769]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[770]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[771]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[772]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[773]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[774]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[775]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[776]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[777]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[778]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[779]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[780]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[781]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[782]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[783]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[784]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[785]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[786]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_18_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[787]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[788]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[789]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[790]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[791]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[792]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[793]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[794]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[795]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[796]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[797]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[798]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[799]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[800]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[801]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[802]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[803]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[804]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[805]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[806]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[807]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[808]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[809]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[810]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[811]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[812]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[813]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[814]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[815]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[816]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[817]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[818]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[819]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[820]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[821]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[822]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[823]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[824]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[825]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[826]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[827]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[828]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[829]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[830]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[831]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[832]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_19_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[833]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[834]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[835]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[836]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[837]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[838]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[839]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[840]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[841]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[842]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[843]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[844]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[845]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[846]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[847]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[848]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[849]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[850]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[851]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[852]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[853]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[854]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[855]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[856]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[857]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[858]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[859]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[860]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[861]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[862]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[863]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[864]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[865]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[866]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[867]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[868]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[869]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[870]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[871]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[872]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[873]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[874]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[875]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[876]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[877]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[878]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_20_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[879]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[880]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[881]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[882]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[883]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[884]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[885]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[886]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[887]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[888]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[889]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[890]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[891]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[892]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[893]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[894]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[895]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[896]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[897]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[898]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[899]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[900]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[901]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[902]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[903]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[904]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[905]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[906]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[907]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[908]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[909]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[910]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[911]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[912]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[913]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[914]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[915]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[916]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[917]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[918]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[919]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[920]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[921]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[922]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[923]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[924]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_21_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[925]);
	}
	
	a1 = '::' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createEnumLiteralExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_21_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[926]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_21_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[927]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[928]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[929]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[930]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[931]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[932]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[933]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[934]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[935]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[936]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[937]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[938]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[939]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[940]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[941]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[942]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[943]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[944]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[945]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[946]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[947]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[948]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[949]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[950]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[951]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[952]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[953]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[954]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[955]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[956]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[957]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[958]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[959]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[960]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[961]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[962]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[963]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[964]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[965]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[966]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[967]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[968]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[969]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[970]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[971]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[972]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_22_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[973]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[974]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[975]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[976]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[977]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[978]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[979]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[980]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[981]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[982]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[983]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[984]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[985]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[986]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[987]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[988]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[989]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[990]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[991]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[992]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[993]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[994]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[995]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[996]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[997]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[998]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[999]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1000]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1001]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1002]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1003]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1004]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1005]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1006]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1007]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1008]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1009]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1010]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1011]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1012]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1013]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1014]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1015]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1016]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1017]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1018]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1019]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1020]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1021]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1022]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1023]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1024]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1025]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1026]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1027]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression		{
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
		|		a1_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
				startIncompleteElement(element);
			}
			if (a1_1 != null) {
				if (a1_1 != null) {
					Object value = a1_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a1_1, true);
				copyLocalizationInfos(a1_1, element);
			}
		}
		|		a1_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
				startIncompleteElement(element);
			}
			if (a1_2 != null) {
				if (a1_2 != null) {
					Object value = a1_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a1_2, true);
				copyLocalizationInfos(a1_2, element);
			}
		}
		|		a1_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
				startIncompleteElement(element);
			}
			if (a1_3 != null) {
				if (a1_3 != null) {
					Object value = a1_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a1_3, true);
				copyLocalizationInfos(a1_3, element);
			}
		}
		|		a1_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
				startIncompleteElement(element);
			}
			if (a1_4 != null) {
				if (a1_4 != null) {
					Object value = a1_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a1_4, true);
				copyLocalizationInfos(a1_4, element);
			}
		}
		|		a1_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
				startIncompleteElement(element);
			}
			if (a1_5 != null) {
				if (a1_5 != null) {
					Object value = a1_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a1_5, true);
				copyLocalizationInfos(a1_5, element);
			}
		}
		|		a1_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
				startIncompleteElement(element);
			}
			if (a1_6 != null) {
				if (a1_6 != null) {
					Object value = a1_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a1_6, true);
				copyLocalizationInfos(a1_6, element);
			}
		}
		|		a1_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
				startIncompleteElement(element);
			}
			if (a1_7 != null) {
				if (a1_7 != null) {
					Object value = a1_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.PAREN_EXPRESSION__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_1, a1_7, true);
				copyLocalizationInfos(a1_7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1028]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createParenExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_23_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1029]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1030]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1031]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1032]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1033]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1034]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1035]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1036]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1037]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1038]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1039]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1040]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1041]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1042]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1043]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1044]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1045]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1046]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1047]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1048]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1049]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1050]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1051]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1052]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1053]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1054]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1055]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1056]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1057]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1058]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1059]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1060]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1061]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1062]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1063]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1064]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1065]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1066]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1067]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1068]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1069]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1070]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1071]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1072]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1073]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1074]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_0, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_0, null, true);
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
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1075]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1076]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1077]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1078]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1079]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1080]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1081]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1082]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_1, a4_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_24_0_0_1, a4_1, true);
				copyLocalizationInfos(a4_1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1083]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1084]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1085]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1086]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1087]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1088]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1089]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1090]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1091]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1092]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1093]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1094]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1095]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1096]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1097]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1098]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1099]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1100]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1101]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1102]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1103]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1104]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1105]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1106]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1107]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1108]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1109]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1110]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1111]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1112]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1113]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1114]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1115]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1116]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1117]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1118]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1119]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1120]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1121]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1122]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_0, a0_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_0, a0_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1123]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_0, null, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_0, null, true);
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
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1124]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1125]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1126]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1127]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1128]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1129]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1130]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1131]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1132]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_1, a5_0, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_1, a5_1, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_25_0_0_1_0_0_1, a5_2, true);
						copyLocalizationInfos(a5_2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1133]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1134]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1135]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1136]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1137]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1138]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1139]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1140]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1141]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1142]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1143]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1144]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1145]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1146]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1147]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1148]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1149]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1150]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1151]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1152]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1153]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1154]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1155]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1156]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1157]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1158]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1159]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1160]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1161]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1162]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1163]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1164]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1165]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1166]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1167]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1168]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1169]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1170]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1171]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1172]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1173]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1174]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1175]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1176]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1177]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1178]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1179]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1180]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1181]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1182]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1183]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1184]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1185]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1186]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1187]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1188]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1189]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1190]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1191]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1192]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1193]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1194]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1195]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1196]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1197]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1198]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1199]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1200]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1201]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1202]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1203]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1204]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1205]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1206]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1207]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1208]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1209]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1210]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_2, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1211]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1_0_0_0, null, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1_0_0_0, null, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1_0_0_0, null, true);
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
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1212]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1213]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1214]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1215]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1216]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1217]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1218]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1219]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1220]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1_0_0_1, a6_0, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1_0_0_1, a6_1, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1_0_0_1, a6_2, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_26_0_0_1_0_0_1, a6_3, true);
						copyLocalizationInfos(a6_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1221]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1222]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1223]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1224]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1225]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1226]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1227]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1228]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1229]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1230]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1231]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1232]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1233]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1234]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1235]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1236]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1237]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1238]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1239]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1240]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1241]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1242]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1243]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1244]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1245]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1246]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1247]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1248]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1249]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1250]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1251]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1252]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1253]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1254]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1255]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1256]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1257]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1258]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1259]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1260]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1261]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1262]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1263]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1264]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1265]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1266]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1267]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1268]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1269]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1270]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1271]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1272]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1273]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1274]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1275]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1276]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1277]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1278]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1279]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1280]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1281]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1282]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1283]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1284]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1285]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1286]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1287]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1288]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1289]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1290]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1291]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1292]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1293]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1294]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1295]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1296]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_2, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_3, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_0, a0_4, true);
				copyLocalizationInfos(a0_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1297]);
	}
	
	(
		(
			a1 = '=' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createRelationalExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_1, null, true);
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
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1298]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1299]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1300]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1301]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1302]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1303]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1304]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1305]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1306]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_2, a8_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_2, a8_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_2, a8_2, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_2, a8_3, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_27_0_0_2, a8_4, true);
				copyLocalizationInfos(a8_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1307]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1308]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1309]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1310]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1311]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1312]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1313]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1314]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1315]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1316]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1317]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1318]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1319]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1320]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1321]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1322]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1323]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1324]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1325]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1326]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1327]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1328]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1329]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1330]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1331]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1332]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1333]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1334]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1335]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1336]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1337]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1338]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1339]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1340]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_2, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_3, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_4, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_0, a0_5, true);
				copyLocalizationInfos(a0_5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1341]);
	}
	
	(
		(
			a1 = 'and' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanAndExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1342]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1343]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1344]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1345]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1346]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1347]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1348]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1349]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1350]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_0, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_1, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_2, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_3, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_4, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_28_0_0_1_0_0_1, a2_5, true);
						copyLocalizationInfos(a2_5, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1351]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1352]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1353]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1354]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1355]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1356]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1357]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1358]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1359]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1360]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1361]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1362]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1363]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1364]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1365]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1366]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1367]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1368]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1369]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1370]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1371]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1372]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1373]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1374]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1375]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1376]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1377]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1378]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1379]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1380]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1381]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1382]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1383]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1384]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1385]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1386]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1387]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1388]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1389]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1390]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1391]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1392]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1393]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1394]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1395]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1396]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1397]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1398]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1399]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1400]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1401]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1402]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1403]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1404]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1405]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1406]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1407]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1408]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1409]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1410]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1411]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1412]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1413]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1414]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1415]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1416]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1417]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1418]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_0, a0_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_0, a0_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_0, a0_2, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_0, a0_3, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_0, a0_4, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_0, a0_5, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_0, a0_6, true);
				copyLocalizationInfos(a0_6, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1419]);
	}
	
	(
		(
			a1 = 'or' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.expression.ExpressionFactory.eINSTANCE.createBooleanOrExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1420]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1421]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1422]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1423]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1424]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1425]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1426]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1427]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1428]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1, a2_0, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1, a2_1, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1, a2_2, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1, a2_3, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1, a2_4, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1, a2_5, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_29_0_0_1_0_0_1, a2_6, true);
						copyLocalizationInfos(a2_6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1429]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1430]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1431]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1432]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1433]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1434]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1435]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1436]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1437]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1438]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1439]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1440]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1441]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1442]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1443]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1444]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1445]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1446]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1447]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1448]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1449]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1450]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1451]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1452]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1453]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1454]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1455]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1456]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1457]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1458]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1459]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1460]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1461]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1462]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1463]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1464]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1465]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1466]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1467]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1468]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1469]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1470]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1471]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1472]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1473]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1474]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1475]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1476]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1477]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1478]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1479]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1480]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1481]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1482]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1483]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1484]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1485]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1486]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1487]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1488]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1489]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1490]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1491]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1492]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1493]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1494]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1495]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1496]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1497]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1498]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1499]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1500]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1501]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1502]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1503]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1504]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1505]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1506]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1507]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement				{
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
				|				a1_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_1 != null) {
						if (a1_1 != null) {
							Object value = a1_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_1, true);
						copyLocalizationInfos(a1_1, element);
					}
				}
				|				a1_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_2 != null) {
						if (a1_2 != null) {
							Object value = a1_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_2, true);
						copyLocalizationInfos(a1_2, element);
					}
				}
				|				a1_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_3 != null) {
						if (a1_3 != null) {
							Object value = a1_3;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_3, true);
						copyLocalizationInfos(a1_3, element);
					}
				}
				|				a1_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_4 != null) {
						if (a1_4 != null) {
							Object value = a1_4;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_4, true);
						copyLocalizationInfos(a1_4, element);
					}
				}
				|				a1_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_5 != null) {
						if (a1_5 != null) {
							Object value = a1_5;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_5, true);
						copyLocalizationInfos(a1_5, element);
					}
				}
				|				a1_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_6 != null) {
						if (a1_6 != null) {
							Object value = a1_6;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_6, true);
						copyLocalizationInfos(a1_6, element);
					}
				}
				|				a1_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_7 != null) {
						if (a1_7 != null) {
							Object value = a1_7;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_7, true);
						copyLocalizationInfos(a1_7, element);
					}
				}
				|				a1_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_8 != null) {
						if (a1_8 != null) {
							Object value = a1_8;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_8, true);
						copyLocalizationInfos(a1_8, element);
					}
				}
				|				a1_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_9 != null) {
						if (a1_9 != null) {
							Object value = a1_9;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_9, true);
						copyLocalizationInfos(a1_9, element);
					}
				}
				|				a1_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_10 != null) {
						if (a1_10 != null) {
							Object value = a1_10;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_10, true);
						copyLocalizationInfos(a1_10, element);
					}
				}
				|				a1_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_11 != null) {
						if (a1_11 != null) {
							Object value = a1_11;
							addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_0, a1_11, true);
						copyLocalizationInfos(a1_11, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1508]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1509]);
			}
			
			(
				(
					a2 = ';' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1510]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1511]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1512]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1513]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1514]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1515]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1516]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1517]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1518]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1519]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1520]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1521]);
					}
					
					(
						a3_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement						{
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_0, true);
								copyLocalizationInfos(a3_0, element);
							}
						}
						|						a3_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_1 != null) {
								if (a3_1 != null) {
									Object value = a3_1;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_1, true);
								copyLocalizationInfos(a3_1, element);
							}
						}
						|						a3_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_2 != null) {
								if (a3_2 != null) {
									Object value = a3_2;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_2, true);
								copyLocalizationInfos(a3_2, element);
							}
						}
						|						a3_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_3 != null) {
								if (a3_3 != null) {
									Object value = a3_3;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_3, true);
								copyLocalizationInfos(a3_3, element);
							}
						}
						|						a3_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_4 != null) {
								if (a3_4 != null) {
									Object value = a3_4;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_4, true);
								copyLocalizationInfos(a3_4, element);
							}
						}
						|						a3_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_5 != null) {
								if (a3_5 != null) {
									Object value = a3_5;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_5, true);
								copyLocalizationInfos(a3_5, element);
							}
						}
						|						a3_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_6 != null) {
								if (a3_6 != null) {
									Object value = a3_6;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_6, true);
								copyLocalizationInfos(a3_6, element);
							}
						}
						|						a3_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_7 != null) {
								if (a3_7 != null) {
									Object value = a3_7;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_7, true);
								copyLocalizationInfos(a3_7, element);
							}
						}
						|						a3_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_8 != null) {
								if (a3_8 != null) {
									Object value = a3_8;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_8, true);
								copyLocalizationInfos(a3_8, element);
							}
						}
						|						a3_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_9 != null) {
								if (a3_9 != null) {
									Object value = a3_9;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_9, true);
								copyLocalizationInfos(a3_9, element);
							}
						}
						|						a3_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_10 != null) {
								if (a3_10 != null) {
									Object value = a3_10;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_10, true);
								copyLocalizationInfos(a3_10, element);
							}
						}
						|						a3_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_11 != null) {
								if (a3_11 != null) {
									Object value = a3_11;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.statement.StatementPackage.BLOCK_STATEMENT__BODY, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_1_0_0_1_0_0_1, a3_11, true);
								copyLocalizationInfos(a3_11, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1522]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1523]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1524]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1525]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1526]);
	}
	
	a4 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createBlockStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_30_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1527]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1528]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1529]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1530]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1531]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1532]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1533]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1534]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1535]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1536]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1537]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1538]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1539]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1540]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1541]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1542]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1543]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1544]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1545]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1546]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1547]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1548]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1549]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1550]);
	}
	
	a2 = 'with' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1551]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1552]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1553]);
	}
	
	a4 = 'by' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1554]);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_31_0_0_5, a5_0, true);
					copyLocalizationInfos(a5_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1555]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1556]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1557]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1558]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1559]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1560]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1561]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1562]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1563]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1564]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1565]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1566]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1567]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1568]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1569]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1570]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1571]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1572]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1573]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1574]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1575]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1576]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1577]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1578]);
	}
	
	a3 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1579]);
	}
	
	a4 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1580]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1581]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1582]);
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
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_5, a5_0, true);
					copyLocalizationInfos(a5_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1583]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1584]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1585]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1586]);
	}
	
	a6 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_32_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1587]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1588]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1589]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1590]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1591]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1592]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1593]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1594]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1595]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1596]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1597]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1598]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1599]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1600]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1601]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1602]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1603]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1604]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1605]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1606]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1607]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_0, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_0, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_0, null, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_0, null, true);
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
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1608]);
	}
	
	a6 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1609]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1610]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1611]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1612]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1613]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1614]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1615]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1616]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1617]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1618]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1619]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1620]);
	}
	
	(
		a7_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement		{
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
		|		a7_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_1 != null) {
				if (a7_1 != null) {
					Object value = a7_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_1, true);
				copyLocalizationInfos(a7_1, element);
			}
		}
		|		a7_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_2 != null) {
				if (a7_2 != null) {
					Object value = a7_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_2, true);
				copyLocalizationInfos(a7_2, element);
			}
		}
		|		a7_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_3 != null) {
				if (a7_3 != null) {
					Object value = a7_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_3, true);
				copyLocalizationInfos(a7_3, element);
			}
		}
		|		a7_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_4 != null) {
				if (a7_4 != null) {
					Object value = a7_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_4, true);
				copyLocalizationInfos(a7_4, element);
			}
		}
		|		a7_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_5 != null) {
				if (a7_5 != null) {
					Object value = a7_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_5, true);
				copyLocalizationInfos(a7_5, element);
			}
		}
		|		a7_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_6 != null) {
				if (a7_6 != null) {
					Object value = a7_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_6, true);
				copyLocalizationInfos(a7_6, element);
			}
		}
		|		a7_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_7 != null) {
				if (a7_7 != null) {
					Object value = a7_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_7, true);
				copyLocalizationInfos(a7_7, element);
			}
		}
		|		a7_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_8 != null) {
				if (a7_8 != null) {
					Object value = a7_8;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_8, true);
				copyLocalizationInfos(a7_8, element);
			}
		}
		|		a7_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_9 != null) {
				if (a7_9 != null) {
					Object value = a7_9;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_9, true);
				copyLocalizationInfos(a7_9, element);
			}
		}
		|		a7_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_10 != null) {
				if (a7_10 != null) {
					Object value = a7_10;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_10, true);
				copyLocalizationInfos(a7_10, element);
			}
		}
		|		a7_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createUpdateClause();
				startIncompleteElement(element);
			}
			if (a7_11 != null) {
				if (a7_11 != null) {
					Object value = a7_11;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.UPDATE_CLAUSE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_33_0_0_2, a7_11, true);
				copyLocalizationInfos(a7_11, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1621]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1622]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1623]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1624]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1625]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1626]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1627]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1628]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1629]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1630]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1631]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1632]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1633]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1634]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1635]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1636]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1637]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1638]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1639]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1640]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1641]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1642]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1643]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1644]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1645]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1646]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1647]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1648]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1649]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1650]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1651]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1652]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1653]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1654]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1655]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1656]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement		{
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
		|		a3_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_1 != null) {
				if (a3_1 != null) {
					Object value = a3_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_1, true);
				copyLocalizationInfos(a3_1, element);
			}
		}
		|		a3_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_2 != null) {
				if (a3_2 != null) {
					Object value = a3_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_2, true);
				copyLocalizationInfos(a3_2, element);
			}
		}
		|		a3_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_3 != null) {
				if (a3_3 != null) {
					Object value = a3_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_3, true);
				copyLocalizationInfos(a3_3, element);
			}
		}
		|		a3_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_4 != null) {
				if (a3_4 != null) {
					Object value = a3_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_4, true);
				copyLocalizationInfos(a3_4, element);
			}
		}
		|		a3_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_5 != null) {
				if (a3_5 != null) {
					Object value = a3_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_5, true);
				copyLocalizationInfos(a3_5, element);
			}
		}
		|		a3_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_6 != null) {
				if (a3_6 != null) {
					Object value = a3_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_6, true);
				copyLocalizationInfos(a3_6, element);
			}
		}
		|		a3_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_7 != null) {
				if (a3_7 != null) {
					Object value = a3_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_7, true);
				copyLocalizationInfos(a3_7, element);
			}
		}
		|		a3_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_8 != null) {
				if (a3_8 != null) {
					Object value = a3_8;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_8, true);
				copyLocalizationInfos(a3_8, element);
			}
		}
		|		a3_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_9 != null) {
				if (a3_9 != null) {
					Object value = a3_9;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_9, true);
				copyLocalizationInfos(a3_9, element);
			}
		}
		|		a3_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_10 != null) {
				if (a3_10 != null) {
					Object value = a3_10;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_10, true);
				copyLocalizationInfos(a3_10, element);
			}
		}
		|		a3_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createPatternCaseClause();
				startIncompleteElement(element);
			}
			if (a3_11 != null) {
				if (a3_11 != null) {
					Object value = a3_11;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.PATTERN_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_34_0_0_3, a3_11, true);
				copyLocalizationInfos(a3_11, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1657]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1658]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1659]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1660]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1661]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1662]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1663]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1664]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1665]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1666]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1667]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1668]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1669]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_1, a1_0, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_1, a1_1, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_1, a1_2, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_1, a1_3, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_1, a1_4, true);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_1, a1_5, true);
				copyLocalizationInfos(a1_5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1670]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1671]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1672]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1673]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1674]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1675]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1676]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1677]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1678]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1679]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1680]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1681]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1682]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement		{
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
		|		a3_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_1 != null) {
				if (a3_1 != null) {
					Object value = a3_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_1, true);
				copyLocalizationInfos(a3_1, element);
			}
		}
		|		a3_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_2 != null) {
				if (a3_2 != null) {
					Object value = a3_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_2, true);
				copyLocalizationInfos(a3_2, element);
			}
		}
		|		a3_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_3 != null) {
				if (a3_3 != null) {
					Object value = a3_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_3, true);
				copyLocalizationInfos(a3_3, element);
			}
		}
		|		a3_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_4 != null) {
				if (a3_4 != null) {
					Object value = a3_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_4, true);
				copyLocalizationInfos(a3_4, element);
			}
		}
		|		a3_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_5 != null) {
				if (a3_5 != null) {
					Object value = a3_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_5, true);
				copyLocalizationInfos(a3_5, element);
			}
		}
		|		a3_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_6 != null) {
				if (a3_6 != null) {
					Object value = a3_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_6, true);
				copyLocalizationInfos(a3_6, element);
			}
		}
		|		a3_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_7 != null) {
				if (a3_7 != null) {
					Object value = a3_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_7, true);
				copyLocalizationInfos(a3_7, element);
			}
		}
		|		a3_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_8 != null) {
				if (a3_8 != null) {
					Object value = a3_8;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_8, true);
				copyLocalizationInfos(a3_8, element);
			}
		}
		|		a3_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_9 != null) {
				if (a3_9 != null) {
					Object value = a3_9;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_9, true);
				copyLocalizationInfos(a3_9, element);
			}
		}
		|		a3_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_10 != null) {
				if (a3_10 != null) {
					Object value = a3_10;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_10, true);
				copyLocalizationInfos(a3_10, element);
			}
		}
		|		a3_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createExpressionCaseClause();
				startIncompleteElement(element);
			}
			if (a3_11 != null) {
				if (a3_11 != null) {
					Object value = a3_11;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.EXPRESSION_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_35_0_0_3, a3_11, true);
				copyLocalizationInfos(a3_11, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1683]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1684]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1685]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1686]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteNodeStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1687]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_36_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1688]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1689]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1690]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1691]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1692]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1693]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1694]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1695]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1696]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1697]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1698]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1699]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1700]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1701]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1702]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1703]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1704]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1705]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1706]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1707]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1708]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement returns [edu.ustb.sei.mde.xmu2.statement.ConcreteDeleteLinkStatement element = null]
@init{
}
:
	a0 = 'delete' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createConcreteDeleteLinkStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1709]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createConcreteDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__SOURCE), value);
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
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1710]);
	}
	
	a2 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createConcreteDeleteLinkStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1711]);
	}
	
	(
		a3 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createConcreteDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1712]);
	}
	
	a4 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createConcreteDeleteLinkStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1713]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1714]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1715]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1716]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1717]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1718]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1719]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1720]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1721]);
	}
	
	(
		a5_0 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createConcreteDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_5, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
		|		a5_1 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createConcreteDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a5_1 != null) {
				if (a5_1 != null) {
					Object value = a5_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_5, a5_1, true);
				copyLocalizationInfos(a5_1, element);
			}
		}
		|		a5_2 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createConcreteDeleteLinkStatement();
				startIncompleteElement(element);
			}
			if (a5_2 != null) {
				if (a5_2 != null) {
					Object value = a5_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.CONCRETE_DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_37_0_0_5, a5_2, true);
				copyLocalizationInfos(a5_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1722]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1723]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1724]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1725]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1726]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1727]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1728]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1729]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1730]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1731]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1732]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1733]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1734]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1735]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1736]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1737]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1738]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1739]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1740]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1741]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1742]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_38_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getEnforcePatternStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1743]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getEnforcePatternStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1744]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_38_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1745]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1746]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1747]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1748]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1749]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1750]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1751]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1752]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1753]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1754]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1755]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1756]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1757]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1758]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1759]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1760]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1761]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1762]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1763]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1764]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1765]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1766]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1767]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1768]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1769]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1770]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1771]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1772]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1773]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1774]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1775]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1776]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1777]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1778]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1779]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1780]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement		{
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
		|		a3_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_1 != null) {
				if (a3_1 != null) {
					Object value = a3_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_1, true);
				copyLocalizationInfos(a3_1, element);
			}
		}
		|		a3_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_2 != null) {
				if (a3_2 != null) {
					Object value = a3_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_2, true);
				copyLocalizationInfos(a3_2, element);
			}
		}
		|		a3_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_3 != null) {
				if (a3_3 != null) {
					Object value = a3_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_3, true);
				copyLocalizationInfos(a3_3, element);
			}
		}
		|		a3_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_4 != null) {
				if (a3_4 != null) {
					Object value = a3_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_4, true);
				copyLocalizationInfos(a3_4, element);
			}
		}
		|		a3_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_5 != null) {
				if (a3_5 != null) {
					Object value = a3_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_5, true);
				copyLocalizationInfos(a3_5, element);
			}
		}
		|		a3_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_6 != null) {
				if (a3_6 != null) {
					Object value = a3_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_6, true);
				copyLocalizationInfos(a3_6, element);
			}
		}
		|		a3_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_7 != null) {
				if (a3_7 != null) {
					Object value = a3_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_7, true);
				copyLocalizationInfos(a3_7, element);
			}
		}
		|		a3_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_8 != null) {
				if (a3_8 != null) {
					Object value = a3_8;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_8, true);
				copyLocalizationInfos(a3_8, element);
			}
		}
		|		a3_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_9 != null) {
				if (a3_9 != null) {
					Object value = a3_9;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_9, true);
				copyLocalizationInfos(a3_9, element);
			}
		}
		|		a3_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_10 != null) {
				if (a3_10 != null) {
					Object value = a3_10;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_10, true);
				copyLocalizationInfos(a3_10, element);
			}
		}
		|		a3_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createForEachStatement();
				startIncompleteElement(element);
			}
			if (a3_11 != null) {
				if (a3_11 != null) {
					Object value = a3_11;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FOR_EACH_STATEMENT__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_39_0_0_3, a3_11, true);
				copyLocalizationInfos(a3_11, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1781]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1782]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1783]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1784]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1785]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1786]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1787]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1788]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1789]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1790]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1791]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1792]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1793]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1794]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1795]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1796]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1797]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1798]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1799]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1800]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1801]);
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1802]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1803]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1804]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1805]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1806]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1807]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1808]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1809]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1810]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1811]);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_2_0_0_0, a2_0, true);
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
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_2_0_0_0, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1812]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1813]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1814]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1815]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1816]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1817]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1818]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1819]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1820]);
						addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1821]);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_2_0_0_1_0_0_1, a4_0, true);
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
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_2_0_0_1_0_0_1, a4_1, true);
								copyLocalizationInfos(a4_1, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1822]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1823]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1824]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1825]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1826]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createRuleCallStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_40_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1827]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1828]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1829]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1830]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1831]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1832]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1833]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1834]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1835]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1836]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1837]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1838]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1839]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1840]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1841]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1842]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1843]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1844]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1845]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1846]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1847]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_41_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1848]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1849]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1850]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1851]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1852]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1853]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1854]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1855]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1856]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1857]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1858]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1859]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1860]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1861]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1862]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1863]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1864]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1865]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1866]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1867]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1868]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_Fail returns [edu.ustb.sei.mde.xmu2.statement.Fail element = null]
@init{
}
:
	a0 = 'fail' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createFail();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_42_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1869]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1870]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1871]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1872]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1873]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1874]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1875]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1876]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1877]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1878]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1879]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1880]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1881]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1882]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1883]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1884]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1885]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1886]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1887]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1888]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1889]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1890]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1891]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1892]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1893]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1894]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1895]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1896]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1897]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createFail();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__EXPRESSION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_42_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
				|				a1_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createFail();
						startIncompleteElement(element);
					}
					if (a1_1 != null) {
						if (a1_1 != null) {
							Object value = a1_1;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__EXPRESSION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_42_0_0_1_0_0_0, a1_1, true);
						copyLocalizationInfos(a1_1, element);
					}
				}
				|				a1_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createFail();
						startIncompleteElement(element);
					}
					if (a1_2 != null) {
						if (a1_2 != null) {
							Object value = a1_2;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__EXPRESSION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_42_0_0_1_0_0_0, a1_2, true);
						copyLocalizationInfos(a1_2, element);
					}
				}
				|				a1_3 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createFail();
						startIncompleteElement(element);
					}
					if (a1_3 != null) {
						if (a1_3 != null) {
							Object value = a1_3;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__EXPRESSION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_42_0_0_1_0_0_0, a1_3, true);
						copyLocalizationInfos(a1_3, element);
					}
				}
				|				a1_4 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createFail();
						startIncompleteElement(element);
					}
					if (a1_4 != null) {
						if (a1_4 != null) {
							Object value = a1_4;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__EXPRESSION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_42_0_0_1_0_0_0, a1_4, true);
						copyLocalizationInfos(a1_4, element);
					}
				}
				|				a1_5 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createFail();
						startIncompleteElement(element);
					}
					if (a1_5 != null) {
						if (a1_5 != null) {
							Object value = a1_5;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.FAIL__EXPRESSION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_42_0_0_1_0_0_0, a1_5, true);
						copyLocalizationInfos(a1_5, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1898]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1899]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1900]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1901]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1902]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1903]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1904]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1905]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1906]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1907]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1908]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1909]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1910]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1911]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1912]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1913]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1914]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1915]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1916]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1917]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1918]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1919]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1920]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1921]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1922]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1923]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1924]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1925]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1926]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1927]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1928]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1929]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1930]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1931]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1932]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1933]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1934]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1935]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1936]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1937]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1938]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1939]);
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
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1940]);
	}
	
	a1 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1941]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1942]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1943]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1944]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1945]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1946]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1947]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1948]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1949]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1950]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1951]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1952]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_xmu2_statement_BlockStatement		{
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
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
		|		a2_1 = parse_edu_ustb_sei_mde_xmu2_statement_UpdateStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_1 != null) {
				if (a2_1 != null) {
					Object value = a2_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_1, true);
				copyLocalizationInfos(a2_1, element);
			}
		}
		|		a2_2 = parse_edu_ustb_sei_mde_xmu2_statement_SwitchStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_2 != null) {
				if (a2_2 != null) {
					Object value = a2_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_2, true);
				copyLocalizationInfos(a2_2, element);
			}
		}
		|		a2_3 = parse_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_3 != null) {
				if (a2_3 != null) {
					Object value = a2_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_3, true);
				copyLocalizationInfos(a2_3, element);
			}
		}
		|		a2_4 = parse_edu_ustb_sei_mde_xmu2_statement_ConcreteDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_4 != null) {
				if (a2_4 != null) {
					Object value = a2_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_4, true);
				copyLocalizationInfos(a2_4, element);
			}
		}
		|		a2_5 = parse_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_5 != null) {
				if (a2_5 != null) {
					Object value = a2_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_5, true);
				copyLocalizationInfos(a2_5, element);
			}
		}
		|		a2_6 = parse_edu_ustb_sei_mde_xmu2_statement_ForEachStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_6 != null) {
				if (a2_6 != null) {
					Object value = a2_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_6, true);
				copyLocalizationInfos(a2_6, element);
			}
		}
		|		a2_7 = parse_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_7 != null) {
				if (a2_7 != null) {
					Object value = a2_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_7, true);
				copyLocalizationInfos(a2_7, element);
			}
		}
		|		a2_8 = parse_edu_ustb_sei_mde_xmu2_statement_Skip		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_8 != null) {
				if (a2_8 != null) {
					Object value = a2_8;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_8, true);
				copyLocalizationInfos(a2_8, element);
			}
		}
		|		a2_9 = parse_edu_ustb_sei_mde_xmu2_statement_Fail		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_9 != null) {
				if (a2_9 != null) {
					Object value = a2_9;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_9, true);
				copyLocalizationInfos(a2_9, element);
			}
		}
		|		a2_10 = parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_10 != null) {
				if (a2_10 != null) {
					Object value = a2_10;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_10, true);
				copyLocalizationInfos(a2_10, element);
			}
		}
		|		a2_11 = parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createDefaultCaseClause();
				startIncompleteElement(element);
			}
			if (a2_11 != null) {
				if (a2_11 != null) {
					Object value = a2_11;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.DEFAULT_CASE_CLAUSE__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_43_0_0_2, a2_11, true);
				copyLocalizationInfos(a2_11, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1953]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1954]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1955]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1956]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_AssignStatement returns [edu.ustb.sei.mde.xmu2.statement.AssignStatement element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__UPDATED_VARIABLE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1957]);
	}
	
	a1 = '::=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1958]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1959]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1960]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1961]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1962]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1963]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1964]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1965]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1966]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
		|		a2_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a2_1 != null) {
				if (a2_1 != null) {
					Object value = a2_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_2, a2_1, true);
				copyLocalizationInfos(a2_1, element);
			}
		}
		|		a2_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a2_2 != null) {
				if (a2_2 != null) {
					Object value = a2_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_2, a2_2, true);
				copyLocalizationInfos(a2_2, element);
			}
		}
		|		a2_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a2_3 != null) {
				if (a2_3 != null) {
					Object value = a2_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_2, a2_3, true);
				copyLocalizationInfos(a2_3, element);
			}
		}
		|		a2_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a2_4 != null) {
				if (a2_4 != null) {
					Object value = a2_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_2, a2_4, true);
				copyLocalizationInfos(a2_4, element);
			}
		}
		|		a2_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a2_5 != null) {
				if (a2_5 != null) {
					Object value = a2_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_2, a2_5, true);
				copyLocalizationInfos(a2_5, element);
			}
		}
		|		a2_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a2_6 != null) {
				if (a2_6 != null) {
					Object value = a2_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_2, a2_6, true);
				copyLocalizationInfos(a2_6, element);
			}
		}
		|		a2_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createAssignStatement();
				startIncompleteElement(element);
			}
			if (a2_7 != null) {
				if (a2_7 != null) {
					Object value = a2_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.ASSIGN_STATEMENT__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_44_0_0_2, a2_7, true);
				copyLocalizationInfos(a2_7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1967]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1968]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1969]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1970]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1971]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1972]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1973]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1974]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1975]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1976]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1977]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1978]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1979]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1980]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1981]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1982]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1983]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1984]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1985]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1986]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1987]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_ReflectiveVariableDeclaration returns [edu.ustb.sei.mde.xmu2.ReflectiveVariableDeclaration element = null]
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
				element = edu.ustb.sei.mde.xmu2.Xmu2Factory.eINSTANCE.createReflectiveVariableDeclaration();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.REFLECTIVE_VARIABLE_DECLARATION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.Xmu2Package.REFLECTIVE_VARIABLE_DECLARATION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_45_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1988]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_ReflectivePatternNode returns [edu.ustb.sei.mde.xmu2.pattern.ReflectivePatternNode element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu2_ReflectiveVariableDeclaration		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
				}
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__VARIABLE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1989]);
	}
	
	a1 = '[' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1990]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1991]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1992]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1993]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1994]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1995]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1996]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1997]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1998]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[1999]);
	}
	
	(
		(
			a2 = '#' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_2, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2000]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2001]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2002]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2003]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2004]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2005]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2006]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2007]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2008]);
	}
	
	(
		a5_0 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
				}
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_3, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
		|		a5_1 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
				}
			}
			if (a5_1 != null) {
				if (a5_1 != null) {
					Object value = a5_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_3, a5_1, true);
				copyLocalizationInfos(a5_1, element);
			}
		}
		|		a5_2 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
				}
			}
			if (a5_2 != null) {
				if (a5_2 != null) {
					Object value = a5_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_3, a5_2, true);
				copyLocalizationInfos(a5_2, element);
			}
		}
		|		a5_3 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
				}
			}
			if (a5_3 != null) {
				if (a5_3 != null) {
					Object value = a5_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_3, a5_3, true);
				copyLocalizationInfos(a5_3, element);
			}
		}
		|		a5_4 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
				}
			}
			if (a5_4 != null) {
				if (a5_4 != null) {
					Object value = a5_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_3, a5_4, true);
				copyLocalizationInfos(a5_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2009]);
	}
	
	a6 = ']' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2010]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2011]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2012]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2013]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2014]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2015]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2016]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2017]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2018]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2019]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2020]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2021]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2022]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2023]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2024]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2025]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2026]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2027]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2028]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2029]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2030]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2031]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2032]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2033]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2034]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2035]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2036]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2037]);
	}
	
	(
		(
			a7 = '{' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2038]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2039]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2040]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2041]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2042]);
			}
			
			(
				(
					(
						a8_0 = parse_edu_ustb_sei_mde_xmu2_pattern_PatternExpression						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
								startIncompleteElement(element);
								// initialize boolean attribute
								{
									Object value = false;
									element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
								}
							}
							if (a8_0 != null) {
								if (a8_0 != null) {
									Object value = a8_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__EXPRESSIONS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_5_0_0_1_0_0_0, a8_0, true);
								copyLocalizationInfos(a8_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2043]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2044]);
					}
					
					(
						(
							a9 = ',' {
								if (element == null) {
									element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
									startIncompleteElement(element);
									// initialize boolean attribute
									{
										Object value = false;
										element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
									}
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_5_0_0_1_0_0_1_0_0_0, null, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
							}
							{
								// expected elements (follow set)
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2045]);
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2046]);
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2047]);
								addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2048]);
							}
							
							(
								a10_0 = parse_edu_ustb_sei_mde_xmu2_pattern_PatternExpression								{
									if (terminateParsing) {
										throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
									}
									if (element == null) {
										element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
										startIncompleteElement(element);
										// initialize boolean attribute
										{
											Object value = false;
											element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
										}
									}
									if (a10_0 != null) {
										if (a10_0 != null) {
											Object value = a10_0;
											addObjectToList(element, edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__EXPRESSIONS, value);
											completedElement(value, true);
										}
										collectHiddenTokens(element);
										retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_5_0_0_1_0_0_1_0_0_1, a10_0, true);
										copyLocalizationInfos(a10_0, element);
									}
								}
							)
							{
								// expected elements (follow set)
								addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2049]);
								addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2050]);
							}
							
						)
						
					)*					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2051]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2052]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2053]);
			}
			
			a11 = '}' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePatternNode();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PATTERN_NODE__RESOLVE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_46_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2054]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2055]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2056]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2057]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2058]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2059]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2060]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2061]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2062]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2063]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2064]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2065]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2066]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2067]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2068]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2069]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2070]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2071]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2072]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2073]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2074]);
				addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2075]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2076]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2077]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2078]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2079]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2080]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2081]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2082]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2083]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2084]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2085]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2086]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2087]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2088]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2089]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2090]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2091]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2092]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2093]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2094]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2095]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2096]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2097]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2098]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2099]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2100]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2101]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2102]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2103]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2104]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2105]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2106]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2107]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression returns [edu.ustb.sei.mde.xmu2.pattern.ReflectiveObjectPatternExpression element = null]
@init{
}
:
	a0 = '[' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
			}
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2108]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2109]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2110]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2111]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2112]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2113]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2114]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2115]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2116]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2117]);
	}
	
	(
		(
			a1 = '#' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
					}
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_1, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2118]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2119]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2120]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2121]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2122]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2123]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2124]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2125]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2126]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_2, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
		|		a4_1 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_1 != null) {
				if (a4_1 != null) {
					Object value = a4_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_2, a4_1, true);
				copyLocalizationInfos(a4_1, element);
			}
		}
		|		a4_2 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_2 != null) {
				if (a4_2 != null) {
					Object value = a4_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_2, a4_2, true);
				copyLocalizationInfos(a4_2, element);
			}
		}
		|		a4_3 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_3 != null) {
				if (a4_3 != null) {
					Object value = a4_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_2, a4_3, true);
				copyLocalizationInfos(a4_3, element);
			}
		}
		|		a4_4 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_4 != null) {
				if (a4_4 != null) {
					Object value = a4_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_2, a4_4, true);
				copyLocalizationInfos(a4_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2127]);
	}
	
	a5 = ']' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
			}
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2128]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2129]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2130]);
	}
	
	(
		(
			(
				a6_0 = parse_edu_ustb_sei_mde_xmu2_expression_LoopPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
						}
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
						}
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__SELECTOR), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_4_0_0_0, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2131]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2132]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2133]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2134]);
	}
	
	(
		(
			(
				a7_0 = parse_edu_ustb_sei_mde_xmu2_expression_PositionPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
						}
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
						}
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__POSITION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_5_0_0_0, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2135]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2136]);
	}
	
	a8 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
			}
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2137]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2138]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2139]);
	}
	
	(
		(
			a9 = '?' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
					}
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_7, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2140]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2141]);
	}
	
	(
		a12_0 = parse_edu_ustb_sei_mde_xmu2_pattern_PatternNode		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectiveObjectPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_0 != null) {
				if (a12_0 != null) {
					Object value = a12_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION__TARGET_NODE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_47_0_0_8, a12_0, true);
				copyLocalizationInfos(a12_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2142]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2143]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2144]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2145]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression returns [edu.ustb.sei.mde.xmu2.pattern.ReflectivePropertyPatternExpression element = null]
@init{
}
:
	a0 = '[' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
			}
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2146]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2147]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2148]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2149]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2150]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2151]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2152]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2153]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2154]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2155]);
	}
	
	(
		(
			a1 = '#' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
					}
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_1, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2156]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2157]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2158]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2159]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2160]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2161]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2162]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2163]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2164]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_2, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
		|		a4_1 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_1 != null) {
				if (a4_1 != null) {
					Object value = a4_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_2, a4_1, true);
				copyLocalizationInfos(a4_1, element);
			}
		}
		|		a4_2 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_2 != null) {
				if (a4_2 != null) {
					Object value = a4_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_2, a4_2, true);
				copyLocalizationInfos(a4_2, element);
			}
		}
		|		a4_3 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_3 != null) {
				if (a4_3 != null) {
					Object value = a4_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_2, a4_3, true);
				copyLocalizationInfos(a4_3, element);
			}
		}
		|		a4_4 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a4_4 != null) {
				if (a4_4 != null) {
					Object value = a4_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_2, a4_4, true);
				copyLocalizationInfos(a4_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2165]);
	}
	
	a5 = ']' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
			}
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2166]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2167]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2168]);
	}
	
	(
		(
			(
				a6_0 = parse_edu_ustb_sei_mde_xmu2_expression_LoopPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
						}
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
						}
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__SELECTOR), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_4_0_0_0, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2169]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2170]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2171]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2172]);
	}
	
	(
		(
			(
				a7_0 = parse_edu_ustb_sei_mde_xmu2_expression_PositionPath				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
						}
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
						}
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__POSITION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_5_0_0_0, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2173]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2174]);
	}
	
	a8 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
			}
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2175]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2176]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2177]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2178]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2179]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2180]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2181]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2182]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2183]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2184]);
	}
	
	(
		(
			a9 = '?' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
					}
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_7, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2185]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2186]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2187]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2188]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2189]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2190]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2191]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2192]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2193]);
	}
	
	(
		a12_0 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_0 != null) {
				if (a12_0 != null) {
					Object value = a12_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_8, a12_0, true);
				copyLocalizationInfos(a12_0, element);
			}
		}
		|		a12_1 = parse_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_1 != null) {
				if (a12_1 != null) {
					Object value = a12_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_8, a12_1, true);
				copyLocalizationInfos(a12_1, element);
			}
		}
		|		a12_2 = parse_edu_ustb_sei_mde_xmu2_expression_RelationalExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_2 != null) {
				if (a12_2 != null) {
					Object value = a12_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_8, a12_2, true);
				copyLocalizationInfos(a12_2, element);
			}
		}
		|		a12_3 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_3 != null) {
				if (a12_3 != null) {
					Object value = a12_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_8, a12_3, true);
				copyLocalizationInfos(a12_3, element);
			}
		}
		|		a12_4 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_4 != null) {
				if (a12_4 != null) {
					Object value = a12_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_8, a12_4, true);
				copyLocalizationInfos(a12_4, element);
			}
		}
		|		a12_5 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_5 != null) {
				if (a12_5 != null) {
					Object value = a12_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_8, a12_5, true);
				copyLocalizationInfos(a12_5, element);
			}
		}
		|		a12_6 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_6 != null) {
				if (a12_6 != null) {
					Object value = a12_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_8, a12_6, true);
				copyLocalizationInfos(a12_6, element);
			}
		}
		|		a12_7 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.pattern.PatternFactory.eINSTANCE.createReflectivePropertyPatternExpression();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__RESOLVE), value);
				}
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__NULLABLE), value);
				}
			}
			if (a12_7 != null) {
				if (a12_7 != null) {
					Object value = a12_7;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_48_0_0_8, a12_7, true);
				copyLocalizationInfos(a12_7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2194]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2195]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2196]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2197]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_statement_ReflectiveDeleteLinkStatement returns [edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement element = null]
@init{
}
:
	a0 = 'delete' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2198]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu2_expression_VariableExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__SOURCE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2199]);
	}
	
	a2 = '[' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2200]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2201]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2202]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2203]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2204]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2205]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2206]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2207]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2208]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2209]);
	}
	
	(
		(
			a3 = '#' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_3, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2210]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2211]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2212]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2213]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2214]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2215]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2216]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2217]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2218]);
	}
	
	(
		a6_0 = parse_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a6_0 != null) {
				if (a6_0 != null) {
					Object value = a6_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_4, a6_0, true);
				copyLocalizationInfos(a6_0, element);
			}
		}
		|		a6_1 = parse_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a6_1 != null) {
				if (a6_1 != null) {
					Object value = a6_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_4, a6_1, true);
				copyLocalizationInfos(a6_1, element);
			}
		}
		|		a6_2 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a6_2 != null) {
				if (a6_2 != null) {
					Object value = a6_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_4, a6_2, true);
				copyLocalizationInfos(a6_2, element);
			}
		}
		|		a6_3 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a6_3 != null) {
				if (a6_3 != null) {
					Object value = a6_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_4, a6_3, true);
				copyLocalizationInfos(a6_3, element);
			}
		}
		|		a6_4 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a6_4 != null) {
				if (a6_4 != null) {
					Object value = a6_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_4, a6_4, true);
				copyLocalizationInfos(a6_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2219]);
	}
	
	a7 = ']' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2220]);
	}
	
	a8 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2221]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2222]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2223]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2224]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2225]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2226]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2227]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2228]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2229]);
	}
	
	(
		a9_0 = parse_edu_ustb_sei_mde_xmu2_expression_UnaryExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a9_0 != null) {
				if (a9_0 != null) {
					Object value = a9_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_7, a9_0, true);
				copyLocalizationInfos(a9_0, element);
			}
		}
		|		a9_1 = parse_edu_ustb_sei_mde_xmu2_expression_PathExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a9_1 != null) {
				if (a9_1 != null) {
					Object value = a9_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_7, a9_1, true);
				copyLocalizationInfos(a9_1, element);
			}
		}
		|		a9_2 = parse_edu_ustb_sei_mde_xmu2_expression_AtomicExpression		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu2.statement.StatementFactory.eINSTANCE.createReflectiveDeleteLinkStatement();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE), value);
				}
			}
			if (a9_2 != null) {
				if (a9_2 != null) {
					Object value = a9_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu2.statement.StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2GrammarInformationProvider.XMU2_49_0_0_7, a9_2, true);
				copyLocalizationInfos(a9_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2230]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2231]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2232]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2233]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2234]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2235]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2236]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2237]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2238]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2239]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2240]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2241]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2242]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2243]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2244]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2245]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2246]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2247]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2248]);
		addExpectedElement(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2249]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ExpectationConstants.EXPECTATIONS[2250]);
	}
	
;

parse_edu_ustb_sei_mde_xmu2_AbstractRule returns [edu.ustb.sei.mde.xmu2.AbstractRule element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_ModelRule{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_ArithmeticRule{ element = c1; /* this is a subclass or primitive expression choice */ }
	
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
	|	c2 = parse_edu_ustb_sei_mde_xmu2_pattern_ReflectiveObjectPatternExpression{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu2_pattern_ReflectivePropertyPatternExpression{ element = c3; /* this is a subclass or primitive expression choice */ }
	
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

parse_edu_ustb_sei_mde_xmu2_statement_CaseClause returns [edu.ustb.sei.mde.xmu2.statement.CaseClause element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu2_statement_PatternCaseClause{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu2_statement_ExpressionCaseClause{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

TYPE:
	('String'|'Boolean'|'Integer'|'OclAny'|'Resource'|'OclObject'|(('a'..'z'|'A'..'Z'|'0'..'9'|'_')+'!'('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*))
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

