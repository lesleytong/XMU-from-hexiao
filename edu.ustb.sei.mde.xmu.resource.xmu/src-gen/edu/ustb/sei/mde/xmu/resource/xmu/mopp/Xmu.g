grammar Xmu;

options {
	superClass = XmuANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package edu.ustb.sei.mde.xmu.resource.xmu.mopp;
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
	package edu.ustb.sei.mde.xmu.resource.xmu.mopp;
}

@members{
	private edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolverFactory tokenResolverFactory = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenResolverFactory();
	
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
	private java.util.List<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal> expectedElements = new java.util.ArrayList<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal>();
	
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
		postParseCommands.add(new edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>() {
			public boolean execute(edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new edu.ustb.sei.mde.xmu.resource.xmu.IXmuProblem() {
					public edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemSeverity getSeverity() {
						return edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemSeverity.ERROR;
					}
					public edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType getType() {
						return edu.ustb.sei.mde.xmu.resource.xmu.XmuEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuQuickFix> getQuickFixes() {
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
		edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement terminal = edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuFollowSetProvider.TERMINALS[terminalID];
		edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[] containmentFeatures = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuFollowSetProvider.LINKS[ids[i]];
		}
		edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuContainmentTrace containmentTrace = new edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal expectedElement = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		postParseCommands.add(new edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>() {
			public boolean execute(edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource resource) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>() {
			public boolean execute(edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource resource) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>() {
			public boolean execute(edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource resource) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuLocationMap locationMap = resource.getLocationMap();
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
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new XmuParser(new org.antlr.runtime3_4_0.CommonTokenStream(new XmuLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new XmuParser(new org.antlr.runtime3_4_0.CommonTokenStream(new XmuLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new edu.ustb.sei.mde.xmu.resource.xmu.util.XmuRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public XmuParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((XmuLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((XmuLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.XMUModel.class) {
				return parse_edu_ustb_sei_mde_xmu_XMUModel();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.StartStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_StartStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.StartRoot.class) {
				return parse_edu_ustb_sei_mde_xmu_StartRoot();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.Rule.class) {
				return parse_edu_ustb_sei_mde_xmu_Rule();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.Parameter.class) {
				return parse_edu_ustb_sei_mde_xmu_Parameter();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.PrimitiveVariable.class) {
				return parse_edu_ustb_sei_mde_xmu_PrimitiveVariable();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.ForStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_ForStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.UpdatedStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_UpdatedStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.VStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_VStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.Pattern.class) {
				return parse_edu_ustb_sei_mde_xmu_Pattern();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.PatternNode.class) {
				return parse_edu_ustb_sei_mde_xmu_PatternNode();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.PatternReferenceExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.PatternEqualExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_PatternEqualExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.VariableExp.class) {
				return parse_edu_ustb_sei_mde_xmu_VariableExp();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.FeaturePath.class) {
				return parse_edu_ustb_sei_mde_xmu_FeaturePath();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.LoopPath.class) {
				return parse_edu_ustb_sei_mde_xmu_LoopPath();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.OperationPath.class) {
				return parse_edu_ustb_sei_mde_xmu_OperationPath();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.StringLiteral.class) {
				return parse_edu_ustb_sei_mde_xmu_StringLiteral();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.EmptyLiteral.class) {
				return parse_edu_ustb_sei_mde_xmu_EmptyLiteral();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.IntegerLiteral.class) {
				return parse_edu_ustb_sei_mde_xmu_IntegerLiteral();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.BooleanLiteral.class) {
				return parse_edu_ustb_sei_mde_xmu_BooleanLiteral();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.EnumLiteral.class) {
				return parse_edu_ustb_sei_mde_xmu_EnumLiteral();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.BlockStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_BlockStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.SwitchStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_SwitchStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.CasePatternStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_CasePatternStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.CaseValueStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_CaseValueStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.RuleCallStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_RuleCallStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.UpdatePattern.class) {
				return parse_edu_ustb_sei_mde_xmu_UpdatePattern();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.DeleteNode.class) {
				return parse_edu_ustb_sei_mde_xmu_DeleteNode();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.DeleteLink.class) {
				return parse_edu_ustb_sei_mde_xmu_DeleteLink();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.BooleanOrExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.BooleanAndExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.RelationalExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_RelationalExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.AdditiveExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_AdditiveExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.MultiplicativeExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.ParenExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_ParenExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.UnaryExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_UnaryExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.PrintStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_PrintStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.AllInstanceExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_AllInstanceExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.InitialMappingStatement.class) {
				return parse_edu_ustb_sei_mde_xmu_InitialMappingStatement();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.ObjectPathExpr.class) {
				return parse_edu_ustb_sei_mde_xmu_ObjectPathExpr();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.HelperMapping.class) {
				return parse_edu_ustb_sei_mde_xmu_HelperMapping();
			}
			if (type.getInstanceClass() == edu.ustb.sei.mde.xmu.HelperPath.class) {
				return parse_edu_ustb_sei_mde_xmu_HelperPath();
			}
		}
		throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>>();
		edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuParseResult parseResult = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuParseResult();
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
	
	public java.util.List<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		edu.ustb.sei.mde.xmu.resource.xmu.IXmuParseResult result = parse();
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
			for (edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal>();
		java.util.List<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal> newFollowSet = new java.util.ArrayList<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 222;
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
				for (edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.util.XmuPair<edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (edu.ustb.sei.mde.xmu.resource.xmu.util.XmuPair<edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[]> newFollowerPair : newFollowers) {
							edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuContainmentTrace containmentTrace = new edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuContainmentTrace(null, newFollowerPair.getRight());
							edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal newFollowTerminal = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[3]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_edu_ustb_sei_mde_xmu_XMUModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_edu_ustb_sei_mde_xmu_XMUModel returns [edu.ustb.sei.mde.xmu.XMUModel element = null]
@init{
}
:
	(
		(
			a0 = 'import' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_0_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[4]);
			}
			
			(
				a1 = URI				
				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
						startIncompleteElement(element);
					}
					if (a1 != null) {
						edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("URI");
						tokenResolver.setOptions(getOptions());
						edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__PACKAGES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.ecore.EPackage proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEPackage();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.XMUModel, org.eclipse.emf.ecore.EPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getXMUModelPackagesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__PACKAGES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__PACKAGES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_0_0_0_1, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[5]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[6]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[7]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[8]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[12]);
	}
	
	(
		(
			a2 = 'mapping' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[13]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[14]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[15]);
			}
			
			(
				a3_0 = parse_edu_ustb_sei_mde_xmu_InitialMappingStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__INITIAL_MAPPINGS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_1_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[17]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[18]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[21]);
	}
	
	(
		(
			a4 = 'mapping' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[22]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_xmu_HelperMapping				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__HELPER_MAPPINGS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_2_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[23]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[24]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[26]);
	}
	
	(
		(
			a6_0 = parse_edu_ustb_sei_mde_xmu_StartStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
					startIncompleteElement(element);
				}
				if (a6_0 != null) {
					if (a6_0 != null) {
						Object value = a6_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__START, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_3, a6_0, true);
					copyLocalizationInfos(a6_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[28]);
	}
	
	(
		(
			a7_0 = parse_edu_ustb_sei_mde_xmu_Rule			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
					startIncompleteElement(element);
				}
				if (a7_0 != null) {
					if (a7_0 != null) {
						Object value = a7_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__RULES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_4, a7_0, true);
					copyLocalizationInfos(a7_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[29]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_StartStatement returns [edu.ustb.sei.mde.xmu.StartStatement element = null]
@init{
}
:
	a0 = 'start' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[30]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.START_STATEMENT__RULE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.Rule proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.StartStatement, edu.ustb.sei.mde.xmu.Rule>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getStartStatementRuleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.START_STATEMENT__RULE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.START_STATEMENT__RULE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[31]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[32]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu_StartRoot		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.START_STATEMENT__ROOT, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[34]);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[35]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_xmu_StartRoot				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.START_STATEMENT__ROOT, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_4_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[36]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[37]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[39]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[40]);
	}
	
	a7 = ';' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[41]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[42]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_StartRoot returns [edu.ustb.sei.mde.xmu.StartRoot element = null]
@init{
}
:
	(
		(
			a0 = 'source' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartRoot();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.SOURCE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.START_ROOT__TAG), value);
				completedElement(value, false);
			}
			|			a1 = 'view' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartRoot();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.VIEW_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.START_ROOT__TAG), value);
				completedElement(value, false);
			}
			|			a2 = 'context' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartRoot();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.CONTEXT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.START_ROOT__TAG), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[43]);
	}
	
	a5 = '[' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartRoot();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[44]);
	}
	
	(
		a6 = NUMBER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartRoot();
				startIncompleteElement(element);
			}
			if (a6 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.START_ROOT__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.START_ROOT__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_2_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[45]);
	}
	
	a7 = ']' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartRoot();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_2_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[48]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_Rule returns [edu.ustb.sei.mde.xmu.Rule element = null]
@init{
}
:
	a0 = 'rule' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[49]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RULE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RULE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[50]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[51]);
	}
	
	(
		(
			a2 = '(' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[52]);
			}
			
			(
				a3_0 = parse_edu_ustb_sei_mde_xmu_Parameter				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.RULE__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_2_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[53]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[54]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_2_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[55]);
					}
					
					(
						a5_0 = parse_edu_ustb_sei_mde_xmu_Parameter						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.RULE__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_2_0_0_2_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[56]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[57]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[58]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[59]);
			}
			
			a6 = ')' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_2_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[60]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[61]);
	}
	
	a7 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[71]);
	}
	
	(
		(
			a8 = 'using' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[72]);
			}
			
			(
				a9_0 = parse_edu_ustb_sei_mde_xmu_PrimitiveVariable				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
						startIncompleteElement(element);
					}
					if (a9_0 != null) {
						if (a9_0 != null) {
							Object value = a9_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.RULE__NVARS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_4_0_0_1, a9_0, true);
						copyLocalizationInfos(a9_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[73]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[74]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[75]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[77]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[78]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[79]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[81]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[82]);
			}
			
			(
				(
					a10 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_4_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[83]);
					}
					
					(
						a11_0 = parse_edu_ustb_sei_mde_xmu_PrimitiveVariable						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
								startIncompleteElement(element);
							}
							if (a11_0 != null) {
								if (a11_0 != null) {
									Object value = a11_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.RULE__NVARS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_4_0_0_2_0_0_1, a11_0, true);
								copyLocalizationInfos(a11_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[84]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[85]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[86]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[87]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[88]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[89]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[90]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[91]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[92]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[93]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[94]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[95]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[96]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[97]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[98]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[99]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[100]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[101]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[102]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[103]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[110]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[111]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[112]);
	}
	
	(
		a12_0 = parse_edu_ustb_sei_mde_xmu_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
				startIncompleteElement(element);
			}
			if (a12_0 != null) {
				if (a12_0 != null) {
					Object value = a12_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RULE__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_5, a12_0, true);
				copyLocalizationInfos(a12_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[113]);
	}
	
	a13 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[114]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_Parameter returns [edu.ustb.sei.mde.xmu.Parameter element = null]
@init{
}
:
	(
		(
			a0 = 'source' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParameter();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.NORMAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__TAG), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.SOURCE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__TAG), value);
				completedElement(value, false);
			}
			|			a1 = 'view' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParameter();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.NORMAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__TAG), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.VIEW_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__TAG), value);
				completedElement(value, false);
			}
			|			a2 = 'context' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParameter();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.NORMAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__TAG), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.CONTEXT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__TAG), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[115]);
	}
	
	(
		a5 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParameter();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableFlag().getEEnumLiteral(edu.ustb.sei.mde.xmu.VariableFlag.NORMAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__TAG), value);
			}
			if (a5 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__VARIABLE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.Variable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.Parameter, edu.ustb.sei.mde.xmu.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getParameterVariableReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__VARIABLE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PARAMETER__VARIABLE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_4_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[117]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_PrimitiveVariable returns [edu.ustb.sei.mde.xmu.PrimitiveVariable element = null]
@init{
}
:
	(
		a0 = PRIMITIVE		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrimitiveVariable();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("PRIMITIVE");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRIMITIVE_VARIABLE__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EDataType proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEDataType();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.PrimitiveVariable, org.eclipse.emf.ecore.EDataType>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPrimitiveVariableTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRIMITIVE_VARIABLE__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRIMITIVE_VARIABLE__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_5_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[118]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrimitiveVariable();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRIMITIVE_VARIABLE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRIMITIVE_VARIABLE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_5_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[129]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_ForStatement returns [edu.ustb.sei.mde.xmu.ForStatement element = null]
@init{
}
:
	a0 = 'update' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[131]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu_Pattern		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.FOR_STATEMENT__SPATTERN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[133]);
	}
	
	(
		(
			a2 = 'with' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[134]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[135]);
			}
			
			(
				a3_0 = parse_edu_ustb_sei_mde_xmu_Pattern				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.FOR_STATEMENT__VPATTERN), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[136]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[137]);
			}
			
			(
				(
					a4 = 'when' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[138]);
					}
					
					(
						a5_0 = parse_edu_ustb_sei_mde_xmu_UpdatedStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.FOR_STATEMENT__WHEN, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_2_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[139]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[140]);
					}
					
					(
						(
							a6 = ';' {
								if (element == null) {
									element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
									startIncompleteElement(element);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_2_0_0_2_0_0_0, null, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
							}
							{
								// expected elements (follow set)
								addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[141]);
							}
							
							(
								a7_0 = parse_edu_ustb_sei_mde_xmu_UpdatedStatement								{
									if (terminateParsing) {
										throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
									}
									if (element == null) {
										element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
										startIncompleteElement(element);
									}
									if (a7_0 != null) {
										if (a7_0 != null) {
											Object value = a7_0;
											addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.FOR_STATEMENT__WHEN, value);
											completedElement(value, true);
										}
										collectHiddenTokens(element);
										retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_2_0_0_2_0_0_1, a7_0, true);
										copyLocalizationInfos(a7_0, element);
									}
								}
							)
							{
								// expected elements (follow set)
								addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[142]);
								addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[143]);
							}
							
						)
						
					)*					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[144]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[145]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[146]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[147]);
	}
	
	a8 = 'by' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[148]);
	}
	
	(
		(
			a9_0 = parse_edu_ustb_sei_mde_xmu_VStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
					startIncompleteElement(element);
				}
				if (a9_0 != null) {
					if (a9_0 != null) {
						Object value = a9_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.FOR_STATEMENT__ACTIONS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_4_0_0_0, a9_0, true);
					copyLocalizationInfos(a9_0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[149]);
			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[150]);
			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[151]);
			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[152]);
			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[153]);
			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[154]);
			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[155]);
		}
		
		(
			(
				(
					a10_0 = parse_edu_ustb_sei_mde_xmu_VStatement					{
						if (terminateParsing) {
							throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
						}
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
							startIncompleteElement(element);
						}
						if (a10_0 != null) {
							if (a10_0 != null) {
								Object value = a10_0;
								addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.FOR_STATEMENT__ACTIONS, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_4_0_0_1_0_0_0, a10_0, true);
							copyLocalizationInfos(a10_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[156]);
					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[157]);
					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[158]);
					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[159]);
					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[160]);
					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[161]);
					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[162]);
				}
				
				(
					(
						(
							a11_0 = parse_edu_ustb_sei_mde_xmu_VStatement							{
								if (terminateParsing) {
									throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
								}
								if (element == null) {
									element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
									startIncompleteElement(element);
								}
								if (a11_0 != null) {
									if (a11_0 != null) {
										Object value = a11_0;
										addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.FOR_STATEMENT__ACTIONS, value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_4_0_0_1_0_0_1_0_0_0, a11_0, true);
									copyLocalizationInfos(a11_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[163]);
							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[164]);
							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[165]);
							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[166]);
							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[167]);
							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[168]);
							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[169]);
						}
						
					)
					
				)?				{
					// expected elements (follow set)
					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[170]);
					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[171]);
					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[172]);
					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[173]);
					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[174]);
					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[175]);
					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[176]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[177]);
			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[178]);
			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[179]);
			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[180]);
			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[181]);
			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[182]);
			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[183]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[184]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[190]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_UpdatedStatement returns [edu.ustb.sei.mde.xmu.UpdatedStatement element = null]
@init{
}
:
	a0 = 'updated' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[191]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[192]);
	}
	
	(
		(
			a2 = NAME			
			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
					tokenResolver.setOptions(getOptions());
					edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__SVAR), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					edu.ustb.sei.mde.xmu.Variable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
					collectHiddenTokens(element);
					registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUpdatedStatementSVarReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__SVAR), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__SVAR, value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_2, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[194]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[195]);
	}
	
	(
		(
			a4 = NAME			
			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
					startIncompleteElement(element);
				}
				if (a4 != null) {
					edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
					tokenResolver.setOptions(getOptions());
					edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__VVAR), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					edu.ustb.sei.mde.xmu.ObjectVariable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
					collectHiddenTokens(element);
					registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUpdatedStatementVVarReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__VVAR), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__VVAR, value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_4, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[197]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[198]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[199]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[203]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[204]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_VStatement returns [edu.ustb.sei.mde.xmu.VStatement element = null]
@init{
}
:
	(
		(
			a0 = 'match' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVStatement();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStmtType().getEEnumLiteral(edu.ustb.sei.mde.xmu.VStmtType.MATCH_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.VSTATEMENT__TAG), value);
				completedElement(value, false);
			}
			|			a1 = 'unmatchv' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVStatement();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStmtType().getEEnumLiteral(edu.ustb.sei.mde.xmu.VStmtType.UNMATCHV_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.VSTATEMENT__TAG), value);
				completedElement(value, false);
			}
			|			a2 = 'unmatchs' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVStatement();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStmtType().getEEnumLiteral(edu.ustb.sei.mde.xmu.VStmtType.UNMATCHS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.VSTATEMENT__TAG), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[205]);
	}
	
	a5 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[206]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[207]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[212]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[213]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[214]);
	}
	
	(
		a6_0 = parse_edu_ustb_sei_mde_xmu_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVStatement();
				startIncompleteElement(element);
			}
			if (a6_0 != null) {
				if (a6_0 != null) {
					Object value = a6_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.VSTATEMENT__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_8_0_0_2, a6_0, true);
				copyLocalizationInfos(a6_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[215]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[216]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[217]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[218]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[219]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[220]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[221]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_Pattern returns [edu.ustb.sei.mde.xmu.Pattern element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu_PatternNode		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN__ROOT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[222]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[223]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[224]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[225]);
	}
	
	(
		(
			a1 = '[' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[226]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[227]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[228]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[229]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[230]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[231]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[232]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[233]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu_BooleanOrExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_edu_ustb_sei_mde_xmu_BooleanAndExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_1, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_edu_ustb_sei_mde_xmu_RelationalExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_1, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_1, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
				|				a2_4 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_4 != null) {
						if (a2_4 != null) {
							Object value = a2_4;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_1, a2_4, true);
						copyLocalizationInfos(a2_4, element);
					}
				}
				|				a2_5 = parse_edu_ustb_sei_mde_xmu_UnaryExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_5 != null) {
						if (a2_5 != null) {
							Object value = a2_5;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_1, a2_5, true);
						copyLocalizationInfos(a2_5, element);
					}
				}
				|				a2_6 = parse_edu_ustb_sei_mde_xmu_AtomicExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
						startIncompleteElement(element);
					}
					if (a2_6 != null) {
						if (a2_6 != null) {
							Object value = a2_6;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_1, a2_6, true);
						copyLocalizationInfos(a2_6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[234]);
			}
			
			a3 = ']' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[235]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[236]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[237]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[238]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[240]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edu_ustb_sei_mde_xmu_UpdatePattern{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu_PatternNode returns [edu.ustb.sei.mde.xmu.PatternNode element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_NODE__VARIABLE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.Variable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.PatternNode, edu.ustb.sei.mde.xmu.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternNodeVariableReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_NODE__VARIABLE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_NODE__VARIABLE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[241]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[242]);
	}
	
	(
		a2 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_NODE__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.PatternNode, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternNodeTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_NODE__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_NODE__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[243]);
	}
	
	a3 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[244]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[245]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[246]);
	}
	
	(
		(
			(
				a4_0 = parse_edu_ustb_sei_mde_xmu_PatternExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_NODE__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_4_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[247]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[248]);
			}
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_4_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[249]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[250]);
					}
					
					(
						a6_0 = parse_edu_ustb_sei_mde_xmu_PatternExpr						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
								startIncompleteElement(element);
							}
							if (a6_0 != null) {
								if (a6_0 != null) {
									Object value = a6_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_NODE__EXPR, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_4_0_0_1_0_0_1, a6_0, true);
								copyLocalizationInfos(a6_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[251]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[252]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[253]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[254]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[255]);
	}
	
	a7 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[256]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[257]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[258]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[260]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[261]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[262]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[264]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[267]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr returns [edu.ustb.sei.mde.xmu.PatternReferenceExpr element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.PatternReferenceExpr, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternReferenceExprReferenceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[268]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[269]);
	}
	
	(
		(
			a1 = '[' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[270]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[271]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[272]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[273]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[274]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[275]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[276]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu_AtomicExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_REFERENCE_EXPR__POS), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[277]);
			}
			
			a3 = ']' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[278]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[279]);
	}
	
	a4 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[280]);
	}
	
	(
		a5_0 = parse_edu_ustb_sei_mde_xmu_PatternNode		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_REFERENCE_EXPR__NODE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_3, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[281]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[282]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_PatternEqualExpr returns [edu.ustb.sei.mde.xmu.PatternEqualExpr element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_EQUAL_EXPR__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EStructuralFeature proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.PatternEqualExpr, org.eclipse.emf.ecore.EStructuralFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternEqualExprFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_EQUAL_EXPR__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_EQUAL_EXPR__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[283]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[284]);
	}
	
	(
		(
			a1 = '[' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[285]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[286]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[287]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[288]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[289]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[290]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[291]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu_AtomicExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_EQUAL_EXPR__POS), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[292]);
			}
			
			a3 = ']' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[293]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[294]);
	}
	
	a4 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[295]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[296]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[297]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[298]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[299]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[300]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[301]);
	}
	
	(
		a5_0 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PATTERN_EQUAL_EXPR__VALUE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_3, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[302]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[303]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_VariableExp returns [edu.ustb.sei.mde.xmu.VariableExp element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVariableExp();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.VARIABLE_EXP__VAR), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.Variable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.VariableExp, edu.ustb.sei.mde.xmu.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getVariableExpVarReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.VARIABLE_EXP__VAR), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.VARIABLE_EXP__VAR), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_13_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[304]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[305]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[306]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[307]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[308]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[309]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[310]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[311]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[312]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[313]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[314]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[315]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[316]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[317]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[318]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[319]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[320]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[321]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[322]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[323]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[324]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[325]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[326]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[327]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[328]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[329]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu_Path				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVariableExp();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.VARIABLE_EXP__PATH, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_13_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[330]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[331]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[332]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[333]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[334]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[335]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[336]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[337]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[338]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[339]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[340]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[341]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[342]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[343]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[344]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[345]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[346]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[347]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[348]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[349]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[350]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[351]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[352]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[353]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[354]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[355]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[356]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[357]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[358]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[359]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[360]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[361]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[362]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[363]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[364]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[365]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[366]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[367]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[368]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[369]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[370]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[371]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[372]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[373]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[374]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[375]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[376]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[377]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[378]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[379]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[380]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[381]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_FeaturePath returns [edu.ustb.sei.mde.xmu.FeaturePath element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createFeaturePath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_14_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[382]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createFeaturePath();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.FEATURE_PATH__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.FEATURE_PATH__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_14_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[383]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[384]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[385]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[386]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[387]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[388]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[389]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[390]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[391]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[392]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[393]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[394]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[395]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[396]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[397]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[398]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[399]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[400]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[401]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[402]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[403]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[404]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[405]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[406]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[407]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[408]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[409]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[410]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[411]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[412]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[413]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_LoopPath returns [edu.ustb.sei.mde.xmu.LoopPath element = null]
@init{
}
:
	a0 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[414]);
	}
	
	(
		(
			a1 = 'select' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.LoopOperator.SELECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = 'forAll' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.LoopOperator.FOR_ALL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = 'exists' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.LoopOperator.EXISTS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[415]);
	}
	
	a6 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[416]);
	}
	
	(
		a7_0 = parse_edu_ustb_sei_mde_xmu_Variable		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a7_0 != null) {
				if (a7_0 != null) {
					Object value = a7_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__VARIABLE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_3, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[417]);
	}
	
	a8 = '|' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[418]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[419]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[420]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[421]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[422]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[423]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[424]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[425]);
	}
	
	(
		a9_0 = parse_edu_ustb_sei_mde_xmu_BooleanOrExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_0 != null) {
				if (a9_0 != null) {
					Object value = a9_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_5, a9_0, true);
				copyLocalizationInfos(a9_0, element);
			}
		}
		|		a9_1 = parse_edu_ustb_sei_mde_xmu_BooleanAndExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_1 != null) {
				if (a9_1 != null) {
					Object value = a9_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_5, a9_1, true);
				copyLocalizationInfos(a9_1, element);
			}
		}
		|		a9_2 = parse_edu_ustb_sei_mde_xmu_RelationalExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_2 != null) {
				if (a9_2 != null) {
					Object value = a9_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_5, a9_2, true);
				copyLocalizationInfos(a9_2, element);
			}
		}
		|		a9_3 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_3 != null) {
				if (a9_3 != null) {
					Object value = a9_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_5, a9_3, true);
				copyLocalizationInfos(a9_3, element);
			}
		}
		|		a9_4 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_4 != null) {
				if (a9_4 != null) {
					Object value = a9_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_5, a9_4, true);
				copyLocalizationInfos(a9_4, element);
			}
		}
		|		a9_5 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_5 != null) {
				if (a9_5 != null) {
					Object value = a9_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_5, a9_5, true);
				copyLocalizationInfos(a9_5, element);
			}
		}
		|		a9_6 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
				startIncompleteElement(element);
			}
			if (a9_6 != null) {
				if (a9_6 != null) {
					Object value = a9_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.LOOP_PATH__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_5, a9_6, true);
				copyLocalizationInfos(a9_6, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[426]);
	}
	
	a10 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[427]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[428]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[429]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[430]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[431]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[432]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[433]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[434]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[435]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[436]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[437]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[438]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[439]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[440]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[441]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[442]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[443]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[444]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[445]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[446]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[447]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[448]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[449]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[450]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[451]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[452]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[453]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[454]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[455]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[456]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[457]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_OperationPath returns [edu.ustb.sei.mde.xmu.OperationPath element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[458]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.OPERATION_PATH__OPERATION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.OPERATION_PATH__OPERATION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[459]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[460]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[461]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[462]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[463]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[464]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[465]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[466]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[467]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[468]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[469]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[470]);
	}
	
	(
		(
			(
				a3_0 = parse_edu_ustb_sei_mde_xmu_Expr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.OPERATION_PATH__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[471]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[472]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[473]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[474]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[475]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[476]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[477]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[478]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[479]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[480]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[481]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[482]);
					}
					
					(
						a5_0 = parse_edu_ustb_sei_mde_xmu_Expr						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.OPERATION_PATH__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_3_0_0_1_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[483]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[484]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[485]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[486]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[487]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[488]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[489]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[490]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[491]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[492]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[493]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[494]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[495]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[496]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[497]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[498]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[499]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[500]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[501]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[502]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[503]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[504]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[505]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[506]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[507]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[508]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[509]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[510]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[511]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[512]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[513]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[514]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[515]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[516]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[517]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[518]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_StringLiteral returns [edu.ustb.sei.mde.xmu.StringLiteral element = null]
@init{
}
:
	(
		a0 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStringLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.STRING_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.STRING_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_17_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[519]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[520]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[521]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[522]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[523]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[524]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[525]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[526]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[527]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[528]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[529]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[530]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[531]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[532]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[533]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[534]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[535]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[536]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[537]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[538]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[539]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[540]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[541]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[542]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[543]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[544]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[545]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[546]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[547]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[548]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[549]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu_Path				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStringLiteral();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.STRING_LITERAL__PATH, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_17_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[550]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[551]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[552]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[553]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[554]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[555]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[556]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[557]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[558]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[559]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[560]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[561]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[562]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[563]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[564]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[565]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[566]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[567]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[568]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[569]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[570]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[571]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[572]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[573]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[574]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[575]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[576]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[577]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[578]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[579]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[580]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[581]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[582]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[583]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[584]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[585]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[586]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[587]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[588]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[589]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[590]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[591]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[592]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[593]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[594]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[595]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[596]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[597]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[598]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[599]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[600]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[601]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[602]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[603]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[604]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[605]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[606]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[607]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[608]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[609]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[610]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[611]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_EmptyLiteral returns [edu.ustb.sei.mde.xmu.EmptyLiteral element = null]
@init{
}
:
	(
		(
			a0 = 'null' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEmptyLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_18_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEmptyType().getEEnumLiteral(edu.ustb.sei.mde.xmu.EmptyType.NULL_VALUE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.EMPTY_LITERAL__VALUE), value);
				completedElement(value, false);
			}
			|			a1 = 'nil' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEmptyLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_18_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEmptyType().getEEnumLiteral(edu.ustb.sei.mde.xmu.EmptyType.EMPTY_VALUE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.EMPTY_LITERAL__VALUE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[612]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[613]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[614]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[615]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[616]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[617]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[618]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[619]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[620]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[621]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[622]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[623]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[624]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[625]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[626]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[627]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[628]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[629]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[630]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[631]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[632]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[633]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_IntegerLiteral returns [edu.ustb.sei.mde.xmu.IntegerLiteral element = null]
@init{
}
:
	(
		a0 = NUMBER		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createIntegerLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.INTEGER_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.INTEGER_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_19_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[634]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[635]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[636]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[637]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[638]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[639]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[640]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[641]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[642]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[643]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[644]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[645]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[646]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[647]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[648]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[649]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[650]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[651]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[652]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[653]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[654]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[655]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[656]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[657]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[658]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[659]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[660]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[661]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[662]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[663]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[664]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu_Path				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createIntegerLiteral();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.INTEGER_LITERAL__PATH, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_19_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[665]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[666]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[667]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[668]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[669]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[670]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[671]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[672]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[673]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[674]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[675]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[676]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[677]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[678]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[679]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[680]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[681]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[682]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[683]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[684]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[685]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[686]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[687]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[688]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[689]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[690]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[691]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[692]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[693]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[694]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[695]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[696]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[697]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[698]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[699]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[700]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[701]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[702]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[703]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[704]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[705]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[706]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[707]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[708]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[709]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[710]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[711]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[712]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[713]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[714]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[715]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[716]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[717]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[718]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[719]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[720]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[721]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[722]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[723]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[724]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[725]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[726]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_BooleanLiteral returns [edu.ustb.sei.mde.xmu.BooleanLiteral element = null]
@init{
}
:
	(
		a0 = BOOLEAN		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Boolean resolved = (java.lang.Boolean) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_20_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[727]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[728]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[729]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[730]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[731]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[732]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[733]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[734]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[735]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[736]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[737]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[738]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[739]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[740]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[741]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[742]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[743]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[744]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[745]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[746]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[747]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[748]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_EnumLiteral returns [edu.ustb.sei.mde.xmu.EnumLiteral element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEnumLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ENUM_LITERAL__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EEnum proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnum();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ENUM_LITERAL__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ENUM_LITERAL__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[749]);
	}
	
	a1 = '::' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[750]);
	}
	
	(
		a2 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEnumLiteral();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ENUM_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EEnumLiteral proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnumLiteral();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralValueReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ENUM_LITERAL__VALUE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ENUM_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[751]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[752]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[753]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[754]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[755]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[756]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[757]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[758]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[759]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[760]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[761]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[762]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[763]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[764]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[765]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[766]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[767]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[768]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[769]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[770]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[771]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[772]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_BlockStatement returns [edu.ustb.sei.mde.xmu.BlockStatement element = null]
@init{
}
:
	a0 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[773]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[774]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[775]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[776]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[777]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[778]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[779]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[780]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[781]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[782]);
	}
	
	(
		(
			(
				a1_0 = parse_edu_ustb_sei_mde_xmu_Statement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BLOCK_STATEMENT__STATEMENTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_1_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[783]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[784]);
			}
			
			(
				(
					a2 = ';' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_1_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[785]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[786]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[787]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[788]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[789]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[790]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[791]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[792]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[793]);
					}
					
					(
						a3_0 = parse_edu_ustb_sei_mde_xmu_Statement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
								startIncompleteElement(element);
							}
							if (a3_0 != null) {
								if (a3_0 != null) {
									Object value = a3_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BLOCK_STATEMENT__STATEMENTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_1_0_0_1_0_0_1, a3_0, true);
								copyLocalizationInfos(a3_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[794]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[795]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[796]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[797]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[798]);
	}
	
	a4 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[799]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[800]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[801]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[802]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[803]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[804]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[805]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_SwitchStatement returns [edu.ustb.sei.mde.xmu.SwitchStatement element = null]
@init{
}
:
	a0 = 'switch' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[806]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.SWITCH_STATEMENT__VAR), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.Variable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.SwitchStatement, edu.ustb.sei.mde.xmu.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSwitchStatementVarReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.SWITCH_STATEMENT__VAR), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.SWITCH_STATEMENT__VAR), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[807]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[808]);
	}
	
	(
		(
			a2 = 'when' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[809]);
			}
			
			(
				a3_0 = parse_edu_ustb_sei_mde_xmu_UpdatedStatement				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.SWITCH_STATEMENT__WHEN, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[810]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[811]);
			}
			
			(
				(
					a4 = ';' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[812]);
					}
					
					(
						a5_0 = parse_edu_ustb_sei_mde_xmu_UpdatedStatement						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.SWITCH_STATEMENT__WHEN, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2_0_0_2_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[813]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[814]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[815]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[816]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[817]);
	}
	
	a6 = '{' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[818]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[819]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[820]);
	}
	
	(
		(
			a7_0 = parse_edu_ustb_sei_mde_xmu_CaseSubStatement			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
					startIncompleteElement(element);
				}
				if (a7_0 != null) {
					if (a7_0 != null) {
						Object value = a7_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.SWITCH_STATEMENT__CASES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_4, a7_0, true);
					copyLocalizationInfos(a7_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[821]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[822]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[823]);
	}
	
	a8 = '}' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[824]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[825]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[826]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[827]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[828]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[829]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[830]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_CasePatternStatement returns [edu.ustb.sei.mde.xmu.CasePatternStatement element = null]
@init{
}
:
	a0 = 'case' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCasePatternStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[831]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[832]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu_Pattern		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCasePatternStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.CASE_PATTERN_STATEMENT__PATTERN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[833]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCasePatternStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[834]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[835]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[836]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[837]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[838]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[839]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[840]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[841]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[842]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCasePatternStatement();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.CASE_PATTERN_STATEMENT__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[843]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[844]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[845]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_CaseValueStatement returns [edu.ustb.sei.mde.xmu.CaseValueStatement element = null]
@init{
}
:
	a0 = 'case' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCaseValueStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[846]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[847]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[848]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[849]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[850]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[851]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[852]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[853]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[854]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[855]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu_Expr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCaseValueStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.CASE_VALUE_STATEMENT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[856]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCaseValueStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[857]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[858]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[859]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[860]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[861]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[862]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[863]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[864]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[865]);
	}
	
	(
		a3_0 = parse_edu_ustb_sei_mde_xmu_Statement		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCaseValueStatement();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.CASE_VALUE_STATEMENT__STATEMENT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[866]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[867]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[868]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_RuleCallStatement returns [edu.ustb.sei.mde.xmu.RuleCallStatement element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RULE_CALL_STATEMENT__RULE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.Rule proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.RuleCallStatement, edu.ustb.sei.mde.xmu.Rule>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleCallStatementRuleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RULE_CALL_STATEMENT__RULE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RULE_CALL_STATEMENT__RULE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[869]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[870]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[871]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[872]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[873]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[874]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[875]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[876]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[877]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[878]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[879]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[880]);
	}
	
	(
		(
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu_Expr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.RULE_CALL_STATEMENT__ACTUAL_PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_2_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[881]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[882]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[883]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[884]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[885]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[886]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[887]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[888]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[889]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[890]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[891]);
						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[892]);
					}
					
					(
						a4_0 = parse_edu_ustb_sei_mde_xmu_Expr						{
							if (terminateParsing) {
								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
							}
							if (element == null) {
								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
								startIncompleteElement(element);
							}
							if (a4_0 != null) {
								if (a4_0 != null) {
									Object value = a4_0;
									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.RULE_CALL_STATEMENT__ACTUAL_PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_2_0_0_1_0_0_1, a4_0, true);
								copyLocalizationInfos(a4_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[893]);
						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[894]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[895]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[896]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[897]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[898]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[899]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[900]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[901]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[902]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[903]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[904]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_UpdatePattern returns [edu.ustb.sei.mde.xmu.UpdatePattern element = null]
@init{
}
:
	a0 = 'enforce' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatePattern();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_27_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatePattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[905]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu_PatternNode		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatePattern();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UPDATE_PATTERN__ROOT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_27_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[906]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[907]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[908]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[909]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[910]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[911]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[912]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[913]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[914]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_DeleteNode returns [edu.ustb.sei.mde.xmu.DeleteNode element = null]
@init{
}
:
	a0 = 'delete' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[915]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteNode();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_NODE__VARIABLE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.ObjectVariable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.DeleteNode, edu.ustb.sei.mde.xmu.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getDeleteNodeVariableReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_NODE__VARIABLE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_NODE__VARIABLE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[916]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[917]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[918]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[919]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[920]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[921]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[922]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_DeleteLink returns [edu.ustb.sei.mde.xmu.DeleteLink element = null]
@init{
}
:
	a0 = 'delete' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[923]);
	}
	
	(
		a1 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__SOURCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.ObjectVariable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getDeleteLinkSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__SOURCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__SOURCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[924]);
	}
	
	a2 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[925]);
	}
	
	(
		a3 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EStructuralFeature proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.DeleteLink, org.eclipse.emf.ecore.EStructuralFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getDeleteLinkFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_3, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[926]);
	}
	
	a4 = '=' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[927]);
	}
	
	(
		a5 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
				startIncompleteElement(element);
			}
			if (a5 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__TARGET), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.Variable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.Variable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getDeleteLinkTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__TARGET), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.DELETE_LINK__TARGET), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_5, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[928]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[929]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[930]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[931]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[932]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[933]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[934]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_BooleanOrExpr returns [edu.ustb.sei.mde.xmu.BooleanOrExpr element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu_BooleanAndExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_OR_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu_RelationalExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_OR_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_OR_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_OR_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[935]);
	}
	
	(
		(
			a1 = 'or' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[936]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[937]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[938]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[939]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[940]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[941]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[942]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[943]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu_BooleanAndExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_OR_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_edu_ustb_sei_mde_xmu_RelationalExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_OR_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_edu_ustb_sei_mde_xmu_UnaryExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_OR_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_edu_ustb_sei_mde_xmu_AtomicExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_OR_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[944]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[945]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[946]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[947]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[948]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[949]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[950]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[951]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[952]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[953]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[954]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[955]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[956]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[957]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[958]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[959]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[960]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[961]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[962]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[963]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[964]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[965]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[966]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[967]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[968]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[969]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[970]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[971]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[972]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[973]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[974]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[975]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_BooleanAndExpr returns [edu.ustb.sei.mde.xmu.BooleanAndExpr element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu_RelationalExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
		|		a0_4 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
				startIncompleteElement(element);
			}
			if (a0_4 != null) {
				if (a0_4 != null) {
					Object value = a0_4;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_4, true);
				copyLocalizationInfos(a0_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[976]);
	}
	
	(
		(
			a1 = 'and' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[977]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[978]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[979]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[980]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[981]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[982]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[983]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[984]);
			}
			
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu_RelationalExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_edu_ustb_sei_mde_xmu_UnaryExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
				|				a2_4 = parse_edu_ustb_sei_mde_xmu_AtomicExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
						startIncompleteElement(element);
					}
					if (a2_4 != null) {
						if (a2_4 != null) {
							Object value = a2_4;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.BOOLEAN_AND_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_4, true);
						copyLocalizationInfos(a2_4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[985]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[986]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[987]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[988]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[989]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[990]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[991]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[992]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[993]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[994]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[995]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[996]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[997]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[998]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[999]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1000]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1001]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1002]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1003]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1004]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1005]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1006]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1007]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1008]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1009]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1010]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1011]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1012]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1013]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1014]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1015]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1016]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1017]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1018]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_RelationalExpr returns [edu.ustb.sei.mde.xmu.RelationalExpr element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1019]);
	}
	
	(
		(
			a1 = '=' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = '<' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.LESS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = '<=' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.LESS_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = '>' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.GREATER_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = '>=' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.GREATER_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1020]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1021]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1022]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1023]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1024]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1025]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1026]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1027]);
	}
	
	(
		a8_0 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
				startIncompleteElement(element);
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					Object value = a8_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_2, a8_0, true);
				copyLocalizationInfos(a8_0, element);
			}
		}
		|		a8_1 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
				startIncompleteElement(element);
			}
			if (a8_1 != null) {
				if (a8_1 != null) {
					Object value = a8_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_2, a8_1, true);
				copyLocalizationInfos(a8_1, element);
			}
		}
		|		a8_2 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
				startIncompleteElement(element);
			}
			if (a8_2 != null) {
				if (a8_2 != null) {
					Object value = a8_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_2, a8_2, true);
				copyLocalizationInfos(a8_2, element);
			}
		}
		|		a8_3 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
				startIncompleteElement(element);
			}
			if (a8_3 != null) {
				if (a8_3 != null) {
					Object value = a8_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__RIGHT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_2, a8_3, true);
				copyLocalizationInfos(a8_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1028]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1029]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1030]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1031]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1032]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1033]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1034]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1035]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1036]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1037]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1038]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1039]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1040]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1041]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1042]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1043]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1044]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_AdditiveExpr returns [edu.ustb.sei.mde.xmu.AdditiveExpr element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1045]);
	}
	
	(
		(
			(
				(
					a1 = '+' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.AdditiveOperator.ADD_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERATORS, value);
						completedElement(value, false);
					}
					|					a2 = '-' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.AdditiveOperator.SUB_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERATORS, value);
						completedElement(value, false);
					}
					|					a3 = '++' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.AdditiveOperator.APPEND_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERATORS, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1046]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1047]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1048]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1049]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1050]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1051]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1052]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1053]);
			}
			
			(
				a6_0 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
						startIncompleteElement(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_1, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
				|				a6_1 = parse_edu_ustb_sei_mde_xmu_UnaryExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
						startIncompleteElement(element);
					}
					if (a6_1 != null) {
						if (a6_1 != null) {
							Object value = a6_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_1, a6_1, true);
						copyLocalizationInfos(a6_1, element);
					}
				}
				|				a6_2 = parse_edu_ustb_sei_mde_xmu_AtomicExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
						startIncompleteElement(element);
					}
					if (a6_2 != null) {
						if (a6_2 != null) {
							Object value = a6_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_1, a6_2, true);
						copyLocalizationInfos(a6_2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1054]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1055]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1056]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1057]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1058]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1059]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1060]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1061]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1062]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1063]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1064]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1065]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1066]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1067]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1068]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1069]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1070]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1071]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1072]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1073]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1074]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1075]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1076]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1077]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1078]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1079]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1080]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1081]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1082]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1083]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1084]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1085]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1086]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1087]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1088]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1089]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr returns [edu.ustb.sei.mde.xmu.MultiplicativeExpr element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createMultiplicativeExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.MULTIPLICATIVE_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createMultiplicativeExpr();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.MULTIPLICATIVE_EXPR__OPERANDS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1090]);
	}
	
	(
		(
			(
				(
					a1 = '*' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.MultiplicativeOperator.MUL_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.MULTIPLICATIVE_EXPR__OPERATORS, value);
						completedElement(value, false);
					}
					|					a2 = '/' {
						if (element == null) {
							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.MultiplicativeOperator.DIV_VALUE).getInstance();
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.MULTIPLICATIVE_EXPR__OPERATORS, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1091]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1092]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1093]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1094]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1095]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1096]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1097]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1098]);
			}
			
			(
				a5_0 = parse_edu_ustb_sei_mde_xmu_UnaryExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createMultiplicativeExpr();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.MULTIPLICATIVE_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
				|				a5_1 = parse_edu_ustb_sei_mde_xmu_AtomicExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createMultiplicativeExpr();
						startIncompleteElement(element);
					}
					if (a5_1 != null) {
						if (a5_1 != null) {
							Object value = a5_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.MULTIPLICATIVE_EXPR__OPERANDS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1_0_0_1, a5_1, true);
						copyLocalizationInfos(a5_1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1099]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1100]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1101]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1102]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1103]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1104]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1105]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1106]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1107]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1108]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1109]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1110]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1111]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1112]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1113]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1114]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1115]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1116]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1117]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1118]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1119]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1120]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1121]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1122]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1123]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1124]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1125]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1126]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1127]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1128]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1129]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1130]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1131]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1132]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1133]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1134]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1135]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1136]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_ParenExpr returns [edu.ustb.sei.mde.xmu.ParenExpr element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1137]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1138]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1139]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1140]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1141]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1142]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1143]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1144]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu_BooleanOrExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PAREN_EXPR__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
		|		a1_1 = parse_edu_ustb_sei_mde_xmu_BooleanAndExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
				startIncompleteElement(element);
			}
			if (a1_1 != null) {
				if (a1_1 != null) {
					Object value = a1_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PAREN_EXPR__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_1, true);
				copyLocalizationInfos(a1_1, element);
			}
		}
		|		a1_2 = parse_edu_ustb_sei_mde_xmu_RelationalExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
				startIncompleteElement(element);
			}
			if (a1_2 != null) {
				if (a1_2 != null) {
					Object value = a1_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PAREN_EXPR__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_2, true);
				copyLocalizationInfos(a1_2, element);
			}
		}
		|		a1_3 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
				startIncompleteElement(element);
			}
			if (a1_3 != null) {
				if (a1_3 != null) {
					Object value = a1_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PAREN_EXPR__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_3, true);
				copyLocalizationInfos(a1_3, element);
			}
		}
		|		a1_4 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
				startIncompleteElement(element);
			}
			if (a1_4 != null) {
				if (a1_4 != null) {
					Object value = a1_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PAREN_EXPR__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_4, true);
				copyLocalizationInfos(a1_4, element);
			}
		}
		|		a1_5 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
				startIncompleteElement(element);
			}
			if (a1_5 != null) {
				if (a1_5 != null) {
					Object value = a1_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PAREN_EXPR__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_5, true);
				copyLocalizationInfos(a1_5, element);
			}
		}
		|		a1_6 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
				startIncompleteElement(element);
			}
			if (a1_6 != null) {
				if (a1_6 != null) {
					Object value = a1_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PAREN_EXPR__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_6, true);
				copyLocalizationInfos(a1_6, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1145]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1146]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1147]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1148]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1149]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1150]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1151]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1152]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1153]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1154]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1155]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1156]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1157]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1158]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1159]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1160]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1161]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1162]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1163]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1164]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1165]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1166]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1167]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_UnaryExpr returns [edu.ustb.sei.mde.xmu.UnaryExpr element = null]
@init{
}
:
	(
		(
			a0 = 'not' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUnaryExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.UnaryOperator.NOT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UNARY_EXPR__OPERATOR), value);
				completedElement(value, false);
			}
			|			a1 = '-' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUnaryExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.UnaryOperator.MINUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UNARY_EXPR__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1168]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1169]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1170]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1171]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1172]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1173]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1174]);
	}
	
	(
		a4_0 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUnaryExpr();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UNARY_EXPR__BODY), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1175]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1176]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1177]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1178]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1179]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1180]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1181]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1182]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1183]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1184]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1185]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1186]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1187]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1188]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1189]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1190]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1191]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1192]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1193]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1194]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_PrintStatement returns [edu.ustb.sei.mde.xmu.PrintStatement element = null]
@init{
}
:
	a0 = 'print' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1195]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1196]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1197]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1198]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1199]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1200]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1201]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1202]);
	}
	
	(
		a1_0 = parse_edu_ustb_sei_mde_xmu_BooleanOrExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRINT_STATEMENT__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
		|		a1_1 = parse_edu_ustb_sei_mde_xmu_BooleanAndExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
				startIncompleteElement(element);
			}
			if (a1_1 != null) {
				if (a1_1 != null) {
					Object value = a1_1;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRINT_STATEMENT__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_1, true);
				copyLocalizationInfos(a1_1, element);
			}
		}
		|		a1_2 = parse_edu_ustb_sei_mde_xmu_RelationalExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
				startIncompleteElement(element);
			}
			if (a1_2 != null) {
				if (a1_2 != null) {
					Object value = a1_2;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRINT_STATEMENT__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_2, true);
				copyLocalizationInfos(a1_2, element);
			}
		}
		|		a1_3 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
				startIncompleteElement(element);
			}
			if (a1_3 != null) {
				if (a1_3 != null) {
					Object value = a1_3;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRINT_STATEMENT__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_3, true);
				copyLocalizationInfos(a1_3, element);
			}
		}
		|		a1_4 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
				startIncompleteElement(element);
			}
			if (a1_4 != null) {
				if (a1_4 != null) {
					Object value = a1_4;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRINT_STATEMENT__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_4, true);
				copyLocalizationInfos(a1_4, element);
			}
		}
		|		a1_5 = parse_edu_ustb_sei_mde_xmu_UnaryExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
				startIncompleteElement(element);
			}
			if (a1_5 != null) {
				if (a1_5 != null) {
					Object value = a1_5;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRINT_STATEMENT__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_5, true);
				copyLocalizationInfos(a1_5, element);
			}
		}
		|		a1_6 = parse_edu_ustb_sei_mde_xmu_AtomicExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
				startIncompleteElement(element);
			}
			if (a1_6 != null) {
				if (a1_6 != null) {
					Object value = a1_6;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.PRINT_STATEMENT__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_6, true);
				copyLocalizationInfos(a1_6, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1203]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1204]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1205]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1206]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1207]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1208]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1209]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_AllInstanceExpr returns [edu.ustb.sei.mde.xmu.AllInstanceExpr element = null]
@init{
}
:
	(
		a0_0 = parse_edu_ustb_sei_mde_xmu_StartRoot		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAllInstanceExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ALL_INSTANCE_EXPR__ROOT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_38_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1210]);
	}
	
	a1 = '//' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAllInstanceExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_38_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1211]);
	}
	
	(
		a2 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAllInstanceExpr();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ALL_INSTANCE_EXPR__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EClass proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.AllInstanceExpr, org.eclipse.emf.ecore.EClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAllInstanceExprTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ALL_INSTANCE_EXPR__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.ALL_INSTANCE_EXPR__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_38_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1212]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1213]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1214]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1215]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1216]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_InitialMappingStatement returns [edu.ustb.sei.mde.xmu.InitialMappingStatement element = null]
@init{
}
:
	(
		(
			a0_0 = parse_edu_ustb_sei_mde_xmu_StringLiteral			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createInitialMappingStatement();
					startIncompleteElement(element);
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						Object value = a0_0;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.INITIAL_MAPPING_STATEMENT__SOURCE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_39_0_0_0, a0_0, true);
					copyLocalizationInfos(a0_0, element);
				}
			}
			|			a0_1 = parse_edu_ustb_sei_mde_xmu_IntegerLiteral			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createInitialMappingStatement();
					startIncompleteElement(element);
				}
				if (a0_1 != null) {
					if (a0_1 != null) {
						Object value = a0_1;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.INITIAL_MAPPING_STATEMENT__SOURCE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_39_0_0_0, a0_1, true);
					copyLocalizationInfos(a0_1, element);
				}
			}
			|			a0_2 = parse_edu_ustb_sei_mde_xmu_ObjectPathExpr			{
				if (terminateParsing) {
					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
				}
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createInitialMappingStatement();
					startIncompleteElement(element);
				}
				if (a0_2 != null) {
					if (a0_2 != null) {
						Object value = a0_2;
						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.INITIAL_MAPPING_STATEMENT__SOURCE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_39_0_0_0, a0_2, true);
					copyLocalizationInfos(a0_2, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1217]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1218]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1219]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1220]);
	}
	
	a1 = '<->' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createInitialMappingStatement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_39_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1221]);
	}
	
	(
		a2_0 = parse_edu_ustb_sei_mde_xmu_ObjectPathExpr		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createInitialMappingStatement();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.INITIAL_MAPPING_STATEMENT__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_39_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1222]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1223]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1224]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_ObjectPathExpr returns [edu.ustb.sei.mde.xmu.ObjectPathExpr element = null]
@init{
}
:
	(
		a0 = OBJ_URI		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectPathExpr();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("OBJ_URI");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.OBJECT_PATH_EXPR__OBJECT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EObject proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.ObjectPathExpr, org.eclipse.emf.ecore.EObject>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getObjectPathExprObjectReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.OBJECT_PATH_EXPR__OBJECT), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.OBJECT_PATH_EXPR__OBJECT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_40_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1225]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1226]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1227]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1228]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1229]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1230]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1231]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1232]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1233]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1234]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_HelperMapping returns [edu.ustb.sei.mde.xmu.HelperMapping element = null]
@init{
}
:
	(
		a0 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.HELPER_MAPPING__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.HELPER_MAPPING__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1235]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1236]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1237]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1238]);
	}
	
	(
		(
			(
				a2_0 = parse_edu_ustb_sei_mde_xmu_StringLiteral				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.HELPER_MAPPING__LEFT, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_2_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_edu_ustb_sei_mde_xmu_IntegerLiteral				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.HELPER_MAPPING__LEFT, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_2_0_0_0, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_edu_ustb_sei_mde_xmu_ObjectPathExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.HELPER_MAPPING__LEFT, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_2_0_0_0, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1239]);
			}
			
			a3 = '=' {
				if (element == null) {
					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1240]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1241]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1242]);
			}
			
			(
				a4_0 = parse_edu_ustb_sei_mde_xmu_StringLiteral				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.HELPER_MAPPING__RIGHT, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_2_0_0_2, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
				|				a4_1 = parse_edu_ustb_sei_mde_xmu_IntegerLiteral				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
						startIncompleteElement(element);
					}
					if (a4_1 != null) {
						if (a4_1 != null) {
							Object value = a4_1;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.HELPER_MAPPING__RIGHT, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_2_0_0_2, a4_1, true);
						copyLocalizationInfos(a4_1, element);
					}
				}
				|				a4_2 = parse_edu_ustb_sei_mde_xmu_ObjectPathExpr				{
					if (terminateParsing) {
						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
					}
					if (element == null) {
						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
						startIncompleteElement(element);
					}
					if (a4_2 != null) {
						if (a4_2 != null) {
							Object value = a4_2;
							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.HELPER_MAPPING__RIGHT, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_2_0_0_2, a4_2, true);
						copyLocalizationInfos(a4_2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1243]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1244]);
				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1245]);
				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1246]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1247]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1248]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperMapping(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1249]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1250]);
	}
	
	a5 = ';' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_41_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1251]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1252]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_HelperPath returns [edu.ustb.sei.mde.xmu.HelperPath element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_42_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1253]);
	}
	
	a1 = '#' {
		if (element == null) {
			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperPath();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_42_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1254]);
	}
	
	(
		a2 = NAME		
		{
			if (terminateParsing) {
				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
			}
			if (element == null) {
				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperPath();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
				tokenResolver.setOptions(getOptions());
				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.HELPER_PATH__HELPER), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edu.ustb.sei.mde.xmu.HelperMapping proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createHelperMapping();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.HelperPath, edu.ustb.sei.mde.xmu.HelperMapping>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHelperPathHelperReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.HELPER_PATH__HELPER), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.HELPER_PATH__HELPER), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_42_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1255]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1256]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1257]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1258]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1259]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1260]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1261]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1262]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1263]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1264]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1265]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1266]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1267]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1268]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1269]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1270]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1271]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1272]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1273]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1274]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1275]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1276]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1277]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1278]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1279]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1280]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1281]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1282]);
		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getInitialMappingStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1283]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1284]);
		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1285]);
	}
	
;

parse_edu_ustb_sei_mde_xmu_Statement returns [edu.ustb.sei.mde.xmu.Statement element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu_ForStatement{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu_UpdatedStatement{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu_BlockStatement{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu_SwitchStatement{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_xmu_RuleCallStatement{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_xmu_UpdatePattern{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_xmu_DeleteNode{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_edu_ustb_sei_mde_xmu_DeleteLink{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_edu_ustb_sei_mde_xmu_PrintStatement{ element = c8; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu_AtomicExpr returns [edu.ustb.sei.mde.xmu.AtomicExpr element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu_VariableExp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu_StringLiteral{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu_EmptyLiteral{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu_IntegerLiteral{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_xmu_BooleanLiteral{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_xmu_EnumLiteral{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_xmu_ParenExpr{ element = c6; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu_PatternExpr returns [edu.ustb.sei.mde.xmu.PatternExpr element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu_PatternEqualExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu_Path returns [edu.ustb.sei.mde.xmu.Path element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu_FeaturePath{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu_LoopPath{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu_OperationPath{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu_HelperPath{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu_Variable returns [edu.ustb.sei.mde.xmu.Variable element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu_PrimitiveVariable{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu_Expr returns [edu.ustb.sei.mde.xmu.Expr element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu_VariableExp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu_StringLiteral{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edu_ustb_sei_mde_xmu_EmptyLiteral{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edu_ustb_sei_mde_xmu_IntegerLiteral{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edu_ustb_sei_mde_xmu_BooleanLiteral{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edu_ustb_sei_mde_xmu_EnumLiteral{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_edu_ustb_sei_mde_xmu_BooleanOrExpr{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_edu_ustb_sei_mde_xmu_BooleanAndExpr{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_edu_ustb_sei_mde_xmu_RelationalExpr{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_edu_ustb_sei_mde_xmu_AdditiveExpr{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_edu_ustb_sei_mde_xmu_ParenExpr{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_edu_ustb_sei_mde_xmu_UnaryExpr{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_edu_ustb_sei_mde_xmu_AllInstanceExpr{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_edu_ustb_sei_mde_xmu_ObjectPathExpr{ element = c14; /* this is a subclass or primitive expression choice */ }
	
;

parse_edu_ustb_sei_mde_xmu_CaseSubStatement returns [edu.ustb.sei.mde.xmu.CaseSubStatement element = null]
:
	c0 = parse_edu_ustb_sei_mde_xmu_CasePatternStatement{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edu_ustb_sei_mde_xmu_CaseValueStatement{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

URI:
	('<'('0'..'9'|'a'..'z'|'A'..'Z'|'_'|'-'|'/'|'\\'|'\.'|':')+'>')
;
PRIMITIVE:
	('String'|'Boolean'|'Integer')
;
BOOLEAN:
	('true'|'false')
;
NAME:
	((('a'..'z'|'A'..'Z'|'0'..'9'|'_')+'!')?('a'..'z'|'A'..'Z'|'_')('0'..'9'|'a'..'z'|'A'..'Z'|'_')*('@post')?)
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
	('@'('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-'|'/'|'\\'|'\.'|':'|'#')*)
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
QUOTED_39_39_92:
	(('\'')(('\\''\'')|('\\''\\')|(~('\''|'\\')))*('\''))
;

