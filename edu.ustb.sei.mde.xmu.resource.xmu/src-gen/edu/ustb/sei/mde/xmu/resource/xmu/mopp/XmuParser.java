// $ANTLR 3.4

	package edu.ustb.sei.mde.xmu.resource.xmu.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class XmuParser extends XmuANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "LINEBREAK", "ML_COMMENT", "NAME", "NUMBER", "PRIMITIVE", "QUOTED_39_39_92", "SL_COMMENT", "TEXT", "URI", "WHITESPACE", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "':'", "'::'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'['", "']'", "'and'", "'by'", "'case'", "'context'", "'delete'", "'enforce'", "'import'", "'match'", "'nil'", "'not'", "'null'", "'or'", "'print'", "'rule'", "'source'", "'start'", "'switch'", "'unmatchs'", "'unmatchv'", "'update'", "'updated'", "'using'", "'view'", "'when'", "'with'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int BOOLEAN=4;
    public static final int LINEBREAK=5;
    public static final int ML_COMMENT=6;
    public static final int NAME=7;
    public static final int NUMBER=8;
    public static final int PRIMITIVE=9;
    public static final int QUOTED_39_39_92=10;
    public static final int SL_COMMENT=11;
    public static final int TEXT=12;
    public static final int URI=13;
    public static final int WHITESPACE=14;

    // delegates
    public XmuANTLRParserBase[] getDelegates() {
        return new XmuANTLRParserBase[] {};
    }

    // delegators


    public XmuParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public XmuParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(165 + 1);
         

    }

    public String[] getTokenNames() { return XmuParser.tokenNames; }
    public String getGrammarFileName() { return "Xmu.g"; }


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
    		int followSetID = 187;
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
    	



    // $ANTLR start "start"
    // Xmu.g:607:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_edu_ustb_sei_mde_xmu_XMUModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.XMUModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Xmu.g:608:2: ( (c0= parse_edu_ustb_sei_mde_xmu_XMUModel ) EOF )
            // Xmu.g:609:2: (c0= parse_edu_ustb_sei_mde_xmu_XMUModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Xmu.g:615:2: (c0= parse_edu_ustb_sei_mde_xmu_XMUModel )
            // Xmu.g:616:3: c0= parse_edu_ustb_sei_mde_xmu_XMUModel
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_XMUModel_in_start82);
            c0=parse_edu_ustb_sei_mde_xmu_XMUModel();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_XMUModel"
    // Xmu.g:624:1: parse_edu_ustb_sei_mde_xmu_XMUModel returns [edu.ustb.sei.mde.xmu.XMUModel element = null] : ( (a0= 'import' (a1= URI ) ) )* ( (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement ) )+ ( (a3_0= parse_edu_ustb_sei_mde_xmu_Rule ) )* ;
    public final edu.ustb.sei.mde.xmu.XMUModel parse_edu_ustb_sei_mde_xmu_XMUModel() throws RecognitionException {
        edu.ustb.sei.mde.xmu.XMUModel element =  null;

        int parse_edu_ustb_sei_mde_xmu_XMUModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.xmu.StartStatement a2_0 =null;

        edu.ustb.sei.mde.xmu.Rule a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Xmu.g:627:2: ( ( (a0= 'import' (a1= URI ) ) )* ( (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement ) )+ ( (a3_0= parse_edu_ustb_sei_mde_xmu_Rule ) )* )
            // Xmu.g:628:2: ( (a0= 'import' (a1= URI ) ) )* ( (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement ) )+ ( (a3_0= parse_edu_ustb_sei_mde_xmu_Rule ) )*
            {
            // Xmu.g:628:2: ( (a0= 'import' (a1= URI ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==40) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Xmu.g:629:3: (a0= 'import' (a1= URI ) )
            	    {
            	    // Xmu.g:629:3: (a0= 'import' (a1= URI ) )
            	    // Xmu.g:630:4: a0= 'import' (a1= URI )
            	    {
            	    a0=(Token)match(input,40,FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_XMUModel124); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_0_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[2]);
            	    			}

            	    // Xmu.g:644:4: (a1= URI )
            	    // Xmu.g:645:5: a1= URI
            	    {
            	    a1=(Token)match(input,URI,FOLLOW_URI_in_parse_edu_ustb_sei_mde_xmu_XMUModel150); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[3]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[4]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[6]);
            	}

            // Xmu.g:693:2: ( (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==49) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Xmu.g:694:3: (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement )
            	    {
            	    // Xmu.g:694:3: (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement )
            	    // Xmu.g:695:4: a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StartStatement_in_parse_edu_ustb_sei_mde_xmu_XMUModel205);
            	    a2_0=parse_edu_ustb_sei_mde_xmu_StartStatement();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createXMUModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a2_0 != null) {
            	    					if (a2_0 != null) {
            	    						Object value = a2_0;
            	    						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__START, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_1, a2_0, true);
            	    					copyLocalizationInfos(a2_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[8]);
            	}

            // Xmu.g:722:2: ( (a3_0= parse_edu_ustb_sei_mde_xmu_Rule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==47) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Xmu.g:723:3: (a3_0= parse_edu_ustb_sei_mde_xmu_Rule )
            	    {
            	    // Xmu.g:723:3: (a3_0= parse_edu_ustb_sei_mde_xmu_Rule )
            	    // Xmu.g:724:4: a3_0= parse_edu_ustb_sei_mde_xmu_Rule
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Rule_in_parse_edu_ustb_sei_mde_xmu_XMUModel240);
            	    a3_0=parse_edu_ustb_sei_mde_xmu_Rule();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            	    						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.XMU_MODEL__RULES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_0_0_0_2, a3_0, true);
            	    					copyLocalizationInfos(a3_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[9]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_edu_ustb_sei_mde_xmu_XMUModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_XMUModel"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_StartStatement"
    // Xmu.g:752:1: parse_edu_ustb_sei_mde_xmu_StartStatement returns [edu.ustb.sei.mde.xmu.StartStatement element = null] : a0= 'start' (a1= NAME ) a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ) )* a6= ')' a7= ';' ;
    public final edu.ustb.sei.mde.xmu.StartStatement parse_edu_ustb_sei_mde_xmu_StartStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.StartStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_StartStatement_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        edu.ustb.sei.mde.xmu.StartRoot a3_0 =null;

        edu.ustb.sei.mde.xmu.StartRoot a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Xmu.g:755:2: (a0= 'start' (a1= NAME ) a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ) )* a6= ')' a7= ';' )
            // Xmu.g:756:2: a0= 'start' (a1= NAME ) a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ) )* a6= ')' a7= ';'
            {
            a0=(Token)match(input,49,FOLLOW_49_in_parse_edu_ustb_sei_mde_xmu_StartStatement281); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[10]);
            	}

            // Xmu.g:770:2: (a1= NAME )
            // Xmu.g:771:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_StartStatement299); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[11]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_StartStatement320); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[12]);
            	}

            // Xmu.g:824:2: (a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot )
            // Xmu.g:825:3: a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_StartStatement338);
            a3_0=parse_edu_ustb_sei_mde_xmu_StartRoot();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[14]);
            	}

            // Xmu.g:851:2: ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Xmu.g:852:3: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) )
            	    {
            	    // Xmu.g:852:3: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) )
            	    // Xmu.g:853:4: a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot )
            	    {
            	    a4=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_StartStatement365); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_4_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[15]);
            	    			}

            	    // Xmu.g:867:4: (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot )
            	    // Xmu.g:868:5: a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_StartStatement391);
            	    a5_0=parse_edu_ustb_sei_mde_xmu_StartRoot();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[16]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[17]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[19]);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_StartStatement432); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[20]);
            	}

            a7=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_StartStatement446); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_1_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[22]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_edu_ustb_sei_mde_xmu_StartStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_StartStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_StartRoot"
    // Xmu.g:933:1: parse_edu_ustb_sei_mde_xmu_StartRoot returns [edu.ustb.sei.mde.xmu.StartRoot element = null] : ( (a0= 'source' |a1= 'view' |a2= 'context' ) ) a5= '[' (a6= NUMBER ) a7= ']' ;
    public final edu.ustb.sei.mde.xmu.StartRoot parse_edu_ustb_sei_mde_xmu_StartRoot() throws RecognitionException {
        edu.ustb.sei.mde.xmu.StartRoot element =  null;

        int parse_edu_ustb_sei_mde_xmu_StartRoot_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Xmu.g:936:2: ( ( (a0= 'source' |a1= 'view' |a2= 'context' ) ) a5= '[' (a6= NUMBER ) a7= ']' )
            // Xmu.g:937:2: ( (a0= 'source' |a1= 'view' |a2= 'context' ) ) a5= '[' (a6= NUMBER ) a7= ']'
            {
            // Xmu.g:937:2: ( (a0= 'source' |a1= 'view' |a2= 'context' ) )
            // Xmu.g:938:3: (a0= 'source' |a1= 'view' |a2= 'context' )
            {
            // Xmu.g:938:3: (a0= 'source' |a1= 'view' |a2= 'context' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt5=1;
                }
                break;
            case 56:
                {
                alt5=2;
                }
                break;
            case 37:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // Xmu.g:939:4: a0= 'source'
                    {
                    a0=(Token)match(input,48,FOLLOW_48_in_parse_edu_ustb_sei_mde_xmu_StartRoot484); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Xmu.g:952:8: a1= 'view'
                    {
                    a1=(Token)match(input,56,FOLLOW_56_in_parse_edu_ustb_sei_mde_xmu_StartRoot499); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Xmu.g:965:8: a2= 'context'
                    {
                    a2=(Token)match(input,37,FOLLOW_37_in_parse_edu_ustb_sei_mde_xmu_StartRoot514); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[23]);
            	}

            a5=(Token)match(input,32,FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_StartRoot535); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartRoot();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[24]);
            	}

            // Xmu.g:999:2: (a6= NUMBER )
            // Xmu.g:1000:3: a6= NUMBER
            {
            a6=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_StartRoot553); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[25]);
            	}

            a7=(Token)match(input,33,FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_StartRoot574); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createStartRoot();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[27]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_edu_ustb_sei_mde_xmu_StartRoot_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_StartRoot"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Rule"
    // Xmu.g:1052:1: parse_edu_ustb_sei_mde_xmu_Rule returns [edu.ustb.sei.mde.xmu.Rule element = null] : a0= 'rule' (a1= NAME ) ( (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' ) )? a7= '{' ( (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* ) )? (a12_0= parse_edu_ustb_sei_mde_xmu_Statement ) a13= '}' ;
    public final edu.ustb.sei.mde.xmu.Rule parse_edu_ustb_sei_mde_xmu_Rule() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Rule element =  null;

        int parse_edu_ustb_sei_mde_xmu_Rule_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a10=null;
        Token a13=null;
        edu.ustb.sei.mde.xmu.Parameter a3_0 =null;

        edu.ustb.sei.mde.xmu.Parameter a5_0 =null;

        edu.ustb.sei.mde.xmu.PrimitiveVariable a9_0 =null;

        edu.ustb.sei.mde.xmu.PrimitiveVariable a11_0 =null;

        edu.ustb.sei.mde.xmu.Statement a12_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Xmu.g:1055:2: (a0= 'rule' (a1= NAME ) ( (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' ) )? a7= '{' ( (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* ) )? (a12_0= parse_edu_ustb_sei_mde_xmu_Statement ) a13= '}' )
            // Xmu.g:1056:2: a0= 'rule' (a1= NAME ) ( (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' ) )? a7= '{' ( (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* ) )? (a12_0= parse_edu_ustb_sei_mde_xmu_Statement ) a13= '}'
            {
            a0=(Token)match(input,47,FOLLOW_47_in_parse_edu_ustb_sei_mde_xmu_Rule603); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[28]);
            	}

            // Xmu.g:1070:2: (a1= NAME )
            // Xmu.g:1071:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_Rule621); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[30]);
            	}

            // Xmu.g:1107:2: ( (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Xmu.g:1108:3: (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' )
                    {
                    // Xmu.g:1108:3: (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' )
                    // Xmu.g:1109:4: a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')'
                    {
                    a2=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_Rule651); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[31]);
                    			}

                    // Xmu.g:1123:4: (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter )
                    // Xmu.g:1124:5: a3_0= parse_edu_ustb_sei_mde_xmu_Parameter
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Parameter_in_parse_edu_ustb_sei_mde_xmu_Rule677);
                    a3_0=parse_edu_ustb_sei_mde_xmu_Parameter();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[32]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[33]);
                    			}

                    // Xmu.g:1150:4: ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==19) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Xmu.g:1151:5: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) )
                    	    {
                    	    // Xmu.g:1151:5: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) )
                    	    // Xmu.g:1152:6: a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter )
                    	    {
                    	    a4=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_Rule718); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_2_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[34]);
                    	    					}

                    	    // Xmu.g:1166:6: (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter )
                    	    // Xmu.g:1167:7: a5_0= parse_edu_ustb_sei_mde_xmu_Parameter
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Parameter_in_parse_edu_ustb_sei_mde_xmu_Rule752);
                    	    a5_0=parse_edu_ustb_sei_mde_xmu_Parameter();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[35]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[36]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[37]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[38]);
                    			}

                    a6=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_Rule813); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_2_0_0_3, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[39]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[40]);
            	}

            a7=(Token)match(input,59,FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_Rule846); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[42]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[50]);
            	}

            // Xmu.g:1245:2: ( (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==55) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Xmu.g:1246:3: (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* )
                    {
                    // Xmu.g:1246:3: (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* )
                    // Xmu.g:1247:4: a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )*
                    {
                    a8=(Token)match(input,55,FOLLOW_55_in_parse_edu_ustb_sei_mde_xmu_Rule869); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_4_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[51]);
                    			}

                    // Xmu.g:1261:4: (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable )
                    // Xmu.g:1262:5: a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Rule895);
                    a9_0=parse_edu_ustb_sei_mde_xmu_PrimitiveVariable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[52]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[53]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[54]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[55]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[56]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[57]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[58]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[59]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[60]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[61]);
                    			}

                    // Xmu.g:1296:4: ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==19) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Xmu.g:1297:5: (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) )
                    	    {
                    	    // Xmu.g:1297:5: (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) )
                    	    // Xmu.g:1298:6: a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable )
                    	    {
                    	    a10=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_Rule936); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_4_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[62]);
                    	    					}

                    	    // Xmu.g:1312:6: (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable )
                    	    // Xmu.g:1313:7: a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Rule970);
                    	    a11_0=parse_edu_ustb_sei_mde_xmu_PrimitiveVariable();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[63]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[64]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[65]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[66]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[67]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[68]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[69]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[70]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[71]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[72]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
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

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[83]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[91]);
            	}

            // Xmu.g:1378:2: (a12_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:1379:3: a12_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_Rule1048);
            a12_0=parse_edu_ustb_sei_mde_xmu_Statement();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[92]);
            	}

            a13=(Token)match(input,60,FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_Rule1066); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_3_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[93]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_edu_ustb_sei_mde_xmu_Rule_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Rule"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Parameter"
    // Xmu.g:1420:1: parse_edu_ustb_sei_mde_xmu_Parameter returns [edu.ustb.sei.mde.xmu.Parameter element = null] : ( (a0= 'source' |a1= 'view' |a2= 'context' )? ) (a5= NAME ) ;
    public final edu.ustb.sei.mde.xmu.Parameter parse_edu_ustb_sei_mde_xmu_Parameter() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Parameter element =  null;

        int parse_edu_ustb_sei_mde_xmu_Parameter_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Xmu.g:1423:2: ( ( (a0= 'source' |a1= 'view' |a2= 'context' )? ) (a5= NAME ) )
            // Xmu.g:1424:2: ( (a0= 'source' |a1= 'view' |a2= 'context' )? ) (a5= NAME )
            {
            // Xmu.g:1424:2: ( (a0= 'source' |a1= 'view' |a2= 'context' )? )
            // Xmu.g:1425:3: (a0= 'source' |a1= 'view' |a2= 'context' )?
            {
            // Xmu.g:1425:3: (a0= 'source' |a1= 'view' |a2= 'context' )?
            int alt10=4;
            switch ( input.LA(1) ) {
                case 48:
                    {
                    alt10=1;
                    }
                    break;
                case 56:
                    {
                    alt10=2;
                    }
                    break;
                case 37:
                    {
                    alt10=3;
                    }
                    break;
            }

            switch (alt10) {
                case 1 :
                    // Xmu.g:1426:4: a0= 'source'
                    {
                    a0=(Token)match(input,48,FOLLOW_48_in_parse_edu_ustb_sei_mde_xmu_Parameter1104); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Xmu.g:1442:8: a1= 'view'
                    {
                    a1=(Token)match(input,56,FOLLOW_56_in_parse_edu_ustb_sei_mde_xmu_Parameter1119); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Xmu.g:1458:8: a2= 'context'
                    {
                    a2=(Token)match(input,37,FOLLOW_37_in_parse_edu_ustb_sei_mde_xmu_Parameter1134); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[94]);
            	}

            // Xmu.g:1480:2: (a5= NAME )
            // Xmu.g:1481:3: a5= NAME
            {
            a5=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_Parameter1159); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[96]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_edu_ustb_sei_mde_xmu_Parameter_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Parameter"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_PrimitiveVariable"
    // Xmu.g:1526:1: parse_edu_ustb_sei_mde_xmu_PrimitiveVariable returns [edu.ustb.sei.mde.xmu.PrimitiveVariable element = null] : (a0= PRIMITIVE ) (a1= NAME ) ;
    public final edu.ustb.sei.mde.xmu.PrimitiveVariable parse_edu_ustb_sei_mde_xmu_PrimitiveVariable() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PrimitiveVariable element =  null;

        int parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Xmu.g:1529:2: ( (a0= PRIMITIVE ) (a1= NAME ) )
            // Xmu.g:1530:2: (a0= PRIMITIVE ) (a1= NAME )
            {
            // Xmu.g:1530:2: (a0= PRIMITIVE )
            // Xmu.g:1531:3: a0= PRIMITIVE
            {
            a0=(Token)match(input,PRIMITIVE,FOLLOW_PRIMITIVE_in_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable1199); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[97]);
            	}

            // Xmu.g:1570:2: (a1= NAME )
            // Xmu.g:1571:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable1224); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[101]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[102]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[103]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[107]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_PrimitiveVariable"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_ForStatement"
    // Xmu.g:1617:1: parse_edu_ustb_sei_mde_xmu_ForStatement returns [edu.ustb.sei.mde.xmu.ForStatement element = null] : a0= 'update' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? ) )? a8= 'by' ( (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )? ) ;
    public final edu.ustb.sei.mde.xmu.ForStatement parse_edu_ustb_sei_mde_xmu_ForStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.ForStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_ForStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a8=null;
        edu.ustb.sei.mde.xmu.Pattern a1_0 =null;

        edu.ustb.sei.mde.xmu.Pattern a3_0 =null;

        edu.ustb.sei.mde.xmu.UpdatedStatement a5_0 =null;

        edu.ustb.sei.mde.xmu.UpdatedStatement a7_0 =null;

        edu.ustb.sei.mde.xmu.VStatement a9_0 =null;

        edu.ustb.sei.mde.xmu.VStatement a10_0 =null;

        edu.ustb.sei.mde.xmu.VStatement a11_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Xmu.g:1620:2: (a0= 'update' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? ) )? a8= 'by' ( (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )? ) )
            // Xmu.g:1621:2: a0= 'update' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? ) )? a8= 'by' ( (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )? )
            {
            a0=(Token)match(input,53,FOLLOW_53_in_parse_edu_ustb_sei_mde_xmu_ForStatement1260); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[109]);
            	}

            // Xmu.g:1636:2: (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern )
            // Xmu.g:1637:3: a1_0= parse_edu_ustb_sei_mde_xmu_Pattern
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_ForStatement1278);
            a1_0=parse_edu_ustb_sei_mde_xmu_Pattern();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[110]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[111]);
            	}

            // Xmu.g:1663:2: ( (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==58) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Xmu.g:1664:3: (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? )
                    {
                    // Xmu.g:1664:3: (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? )
                    // Xmu.g:1665:4: a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )?
                    {
                    a2=(Token)match(input,58,FOLLOW_58_in_parse_edu_ustb_sei_mde_xmu_ForStatement1305); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[112]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[113]);
                    			}

                    // Xmu.g:1680:4: (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern )
                    // Xmu.g:1681:5: a3_0= parse_edu_ustb_sei_mde_xmu_Pattern
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_ForStatement1331);
                    a3_0=parse_edu_ustb_sei_mde_xmu_Pattern();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[114]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[115]);
                    			}

                    // Xmu.g:1707:4: ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==57) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // Xmu.g:1708:5: (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                            {
                            // Xmu.g:1708:5: (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                            // Xmu.g:1709:6: a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                            {
                            a4=(Token)match(input,57,FOLLOW_57_in_parse_edu_ustb_sei_mde_xmu_ForStatement1372); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_2_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                            					}

                            if ( state.backtracking==0 ) {
                            						// expected elements (follow set)
                            						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[116]);
                            					}

                            // Xmu.g:1723:6: (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                            // Xmu.g:1724:7: a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1406);
                            a5_0=parse_edu_ustb_sei_mde_xmu_UpdatedStatement();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }


                            if ( state.backtracking==0 ) {
                            						// expected elements (follow set)
                            						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[117]);
                            						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[118]);
                            					}

                            // Xmu.g:1750:6: ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==26) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // Xmu.g:1751:7: (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                            	    {
                            	    // Xmu.g:1751:7: (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                            	    // Xmu.g:1752:8: a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                            	    {
                            	    a6=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_ForStatement1461); if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    								if (element == null) {
                            	    									element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
                            	    									startIncompleteElement(element);
                            	    								}
                            	    								collectHiddenTokens(element);
                            	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_2_0_0_2_0_0_2_0_0_0, null, true);
                            	    								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                            	    							}

                            	    if ( state.backtracking==0 ) {
                            	    								// expected elements (follow set)
                            	    								addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[119]);
                            	    							}

                            	    // Xmu.g:1766:8: (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                            	    // Xmu.g:1767:9: a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                            	    {
                            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1503);
                            	    a7_0=parse_edu_ustb_sei_mde_xmu_UpdatedStatement();

                            	    state._fsp--;
                            	    if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
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

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    								// expected elements (follow set)
                            	    								addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[120]);
                            	    								addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[121]);
                            	    							}

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            if ( state.backtracking==0 ) {
                            						// expected elements (follow set)
                            						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[122]);
                            						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[123]);
                            					}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[124]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[125]);
            	}

            a8=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_ForStatement1620); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_6_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[126]);
            	}

            // Xmu.g:1829:2: ( (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )? )
            // Xmu.g:1830:3: (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )?
            {
            // Xmu.g:1830:3: (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement )
            // Xmu.g:1831:4: a9_0= parse_edu_ustb_sei_mde_xmu_VStatement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1643);
            a9_0=parse_edu_ustb_sei_mde_xmu_VStatement();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[127]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[128]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[129]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[130]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[131]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[132]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[133]);
            		}

            // Xmu.g:1862:3: ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )?
            int alt15=2;
            switch ( input.LA(1) ) {
                case 41:
                    {
                    int LA15_1 = input.LA(2);

                    if ( (synpred18_Xmu()) ) {
                        alt15=1;
                    }
                    }
                    break;
                case 52:
                    {
                    int LA15_2 = input.LA(2);

                    if ( (synpred18_Xmu()) ) {
                        alt15=1;
                    }
                    }
                    break;
                case 51:
                    {
                    int LA15_3 = input.LA(2);

                    if ( (synpred18_Xmu()) ) {
                        alt15=1;
                    }
                    }
                    break;
            }

            switch (alt15) {
                case 1 :
                    // Xmu.g:1863:4: ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? )
                    {
                    // Xmu.g:1863:4: ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? )
                    // Xmu.g:1864:5: (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )?
                    {
                    // Xmu.g:1864:5: (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                    // Xmu.g:1865:6: a10_0= parse_edu_ustb_sei_mde_xmu_VStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1684);
                    a10_0=parse_edu_ustb_sei_mde_xmu_VStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[134]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[135]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[136]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[137]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[138]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[139]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[140]);
                    				}

                    // Xmu.g:1896:5: ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )?
                    int alt14=2;
                    switch ( input.LA(1) ) {
                        case 41:
                            {
                            int LA14_1 = input.LA(2);

                            if ( (synpred17_Xmu()) ) {
                                alt14=1;
                            }
                            }
                            break;
                        case 52:
                            {
                            int LA14_2 = input.LA(2);

                            if ( (synpred17_Xmu()) ) {
                                alt14=1;
                            }
                            }
                            break;
                        case 51:
                            {
                            int LA14_3 = input.LA(2);

                            if ( (synpred17_Xmu()) ) {
                                alt14=1;
                            }
                            }
                            break;
                    }

                    switch (alt14) {
                        case 1 :
                            // Xmu.g:1897:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
                            {
                            // Xmu.g:1897:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
                            // Xmu.g:1898:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                            {
                            // Xmu.g:1898:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                            // Xmu.g:1899:8: a11_0= parse_edu_ustb_sei_mde_xmu_VStatement
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1741);
                            a11_0=parse_edu_ustb_sei_mde_xmu_VStatement();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }


                            if ( state.backtracking==0 ) {
                            							// expected elements (follow set)
                            							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[141]);
                            							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[142]);
                            							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[143]);
                            							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[144]);
                            							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[145]);
                            							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[146]);
                            							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[147]);
                            						}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[148]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[149]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[150]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[151]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[152]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[153]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[154]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[155]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[156]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[157]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[158]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[159]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[160]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[161]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[162]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[168]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_edu_ustb_sei_mde_xmu_ForStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_ForStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_UpdatedStatement"
    // Xmu.g:1970:1: parse_edu_ustb_sei_mde_xmu_UpdatedStatement returns [edu.ustb.sei.mde.xmu.UpdatedStatement element = null] : a0= 'updated' a1= '(' (a2= NAME ) a3= ',' (a4= NAME ) a5= ')' ;
    public final edu.ustb.sei.mde.xmu.UpdatedStatement parse_edu_ustb_sei_mde_xmu_UpdatedStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UpdatedStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_UpdatedStatement_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Xmu.g:1973:2: (a0= 'updated' a1= '(' (a2= NAME ) a3= ',' (a4= NAME ) a5= ')' )
            // Xmu.g:1974:2: a0= 'updated' a1= '(' (a2= NAME ) a3= ',' (a4= NAME ) a5= ')'
            {
            a0=(Token)match(input,54,FOLLOW_54_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1852); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[169]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1866); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[170]);
            	}

            // Xmu.g:2002:2: (a2= NAME )
            // Xmu.g:2003:3: a2= NAME
            {
            a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1884); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				edu.ustb.sei.mde.xmu.ObjectVariable proxy = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createObjectVariable();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContextDependentURIFragmentFactory<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUpdatedStatementSVarReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__SVAR), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__SVAR), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[171]);
            	}

            a3=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1905); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[172]);
            	}

            // Xmu.g:2056:2: (a4= NAME )
            // Xmu.g:2057:3: a4= NAME
            {
            a4=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1923); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__VVAR), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[173]);
            	}

            a5=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1944); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatedStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[180]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_edu_ustb_sei_mde_xmu_UpdatedStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_UpdatedStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_VStatement"
    // Xmu.g:2118:1: parse_edu_ustb_sei_mde_xmu_VStatement returns [edu.ustb.sei.mde.xmu.VStatement element = null] : ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
    public final edu.ustb.sei.mde.xmu.VStatement parse_edu_ustb_sei_mde_xmu_VStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_VStatement_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;
        edu.ustb.sei.mde.xmu.Statement a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Xmu.g:2121:2: ( ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:2122:2: ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            // Xmu.g:2122:2: ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) )
            // Xmu.g:2123:3: (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' )
            {
            // Xmu.g:2123:3: (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt16=1;
                }
                break;
            case 52:
                {
                alt16=2;
                }
                break;
            case 51:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // Xmu.g:2124:4: a0= 'match'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_edu_ustb_sei_mde_xmu_VStatement1982); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Xmu.g:2137:8: a1= 'unmatchv'
                    {
                    a1=(Token)match(input,52,FOLLOW_52_in_parse_edu_ustb_sei_mde_xmu_VStatement1997); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Xmu.g:2150:8: a2= 'unmatchs'
                    {
                    a2=(Token)match(input,51,FOLLOW_51_in_parse_edu_ustb_sei_mde_xmu_VStatement2012); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[181]);
            	}

            a5=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_VStatement2033); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_8_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[185]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[190]);
            	}

            // Xmu.g:2192:2: (a6_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:2193:3: a6_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_VStatement2051);
            a6_0=parse_edu_ustb_sei_mde_xmu_Statement();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[192]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[193]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[194]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[195]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[197]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_edu_ustb_sei_mde_xmu_VStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_VStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Pattern"
    // Xmu.g:2226:1: parse_edu_ustb_sei_mde_xmu_Pattern returns [edu.ustb.sei.mde.xmu.Pattern element = null] : ( (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? |c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern );
    public final edu.ustb.sei.mde.xmu.Pattern parse_edu_ustb_sei_mde_xmu_Pattern() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Pattern element =  null;

        int parse_edu_ustb_sei_mde_xmu_Pattern_StartIndex = input.index();

        Token a1=null;
        Token a3=null;
        edu.ustb.sei.mde.xmu.PatternNode a0_0 =null;

        edu.ustb.sei.mde.xmu.BooleanOrExpr a2_0 =null;

        edu.ustb.sei.mde.xmu.BooleanAndExpr a2_1 =null;

        edu.ustb.sei.mde.xmu.RelationalExpr a2_2 =null;

        edu.ustb.sei.mde.xmu.AdditiveExpr a2_3 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a2_4 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a2_5 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a2_6 =null;

        edu.ustb.sei.mde.xmu.UpdatePattern c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Xmu.g:2229:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? |c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NAME) ) {
                alt19=1;
            }
            else if ( (LA19_0==39) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // Xmu.g:2230:2: (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
                    {
                    // Xmu.g:2230:2: (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
                    // Xmu.g:2231:3: a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_Pattern2088);
                    a0_0=parse_edu_ustb_sei_mde_xmu_PatternNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[198]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[199]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[200]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[201]);
                    	}

                    // Xmu.g:2259:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==32) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // Xmu.g:2260:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                            {
                            // Xmu.g:2260:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                            // Xmu.g:2261:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                            {
                            a1=(Token)match(input,32,FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_Pattern2115); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[202]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[203]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[204]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[205]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[206]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[207]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[208]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[209]);
                            			}

                            // Xmu.g:2282:4: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                            int alt17=7;
                            switch ( input.LA(1) ) {
                            case 43:
                                {
                                int LA17_1 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt17=6;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 1, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 20:
                                {
                                int LA17_2 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt17=6;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 2, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case NAME:
                                {
                                int LA17_3 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (true) ) {
                                    alt17=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 3, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case QUOTED_39_39_92:
                                {
                                int LA17_4 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (true) ) {
                                    alt17=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 4, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 44:
                                {
                                int LA17_5 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (true) ) {
                                    alt17=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 5, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 42:
                                {
                                int LA17_6 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (true) ) {
                                    alt17=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 6, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case NUMBER:
                                {
                                int LA17_7 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (true) ) {
                                    alt17=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 7, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case BOOLEAN:
                                {
                                int LA17_8 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (true) ) {
                                    alt17=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 8, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 15:
                                {
                                int LA17_9 = input.LA(2);

                                if ( (synpred21_Xmu()) ) {
                                    alt17=1;
                                }
                                else if ( (synpred22_Xmu()) ) {
                                    alt17=2;
                                }
                                else if ( (synpred23_Xmu()) ) {
                                    alt17=3;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt17=4;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt17=5;
                                }
                                else if ( (true) ) {
                                    alt17=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 17, 9, input);

                                    throw nvae;

                                }
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 0, input);

                                throw nvae;

                            }

                            switch (alt17) {
                                case 1 :
                                    // Xmu.g:2283:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2141);
                                    a2_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

                                    state._fsp--;
                                    if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
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

                                    }
                                    break;
                                case 2 :
                                    // Xmu.g:2302:10: a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2161);
                                    a2_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

                                    state._fsp--;
                                    if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
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

                                    }
                                    break;
                                case 3 :
                                    // Xmu.g:2321:10: a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2181);
                                    a2_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                                    state._fsp--;
                                    if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
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

                                    }
                                    break;
                                case 4 :
                                    // Xmu.g:2340:10: a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2201);
                                    a2_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                                    state._fsp--;
                                    if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
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

                                    }
                                    break;
                                case 5 :
                                    // Xmu.g:2359:10: a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2221);
                                    a2_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                                    state._fsp--;
                                    if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
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

                                    }
                                    break;
                                case 6 :
                                    // Xmu.g:2378:10: a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2241);
                                    a2_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                                    state._fsp--;
                                    if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
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

                                    }
                                    break;
                                case 7 :
                                    // Xmu.g:2397:10: a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2261);
                                    a2_6=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                                    state._fsp--;
                                    if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
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

                                    }
                                    break;

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[210]);
                            			}

                            a3=(Token)match(input,33,FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_Pattern2289); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_9_0_0_1_0_0_2, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[211]);
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[212]);
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[213]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[214]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[215]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[216]);
                    	}

                    }
                    break;
                case 2 :
                    // Xmu.g:2449:2: c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Pattern2327);
                    c0=parse_edu_ustb_sei_mde_xmu_UpdatePattern();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_edu_ustb_sei_mde_xmu_Pattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Pattern"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_PatternNode"
    // Xmu.g:2453:1: parse_edu_ustb_sei_mde_xmu_PatternNode returns [edu.ustb.sei.mde.xmu.PatternNode element = null] : (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}' ;
    public final edu.ustb.sei.mde.xmu.PatternNode parse_edu_ustb_sei_mde_xmu_PatternNode() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternNode element =  null;

        int parse_edu_ustb_sei_mde_xmu_PatternNode_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a7=null;
        edu.ustb.sei.mde.xmu.PatternExpr a4_0 =null;

        edu.ustb.sei.mde.xmu.PatternExpr a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Xmu.g:2456:2: ( (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}' )
            // Xmu.g:2457:2: (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}'
            {
            // Xmu.g:2457:2: (a0= NAME )
            // Xmu.g:2458:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2356); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[217]);
            	}

            a1=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_xmu_PatternNode2377); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[218]);
            	}

            // Xmu.g:2511:2: (a2= NAME )
            // Xmu.g:2512:3: a2= NAME
            {
            a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2395); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[219]);
            	}

            a3=(Token)match(input,59,FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_PatternNode2416); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[220]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[221]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[222]);
            	}

            // Xmu.g:2567:2: ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Xmu.g:2568:3: ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* )
                    {
                    // Xmu.g:2568:3: ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* )
                    // Xmu.g:2569:4: (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )*
                    {
                    // Xmu.g:2569:4: (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    // Xmu.g:2570:5: a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2445);
                    a4_0=parse_edu_ustb_sei_mde_xmu_PatternExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[223]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[224]);
                    			}

                    // Xmu.g:2596:4: ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==19) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Xmu.g:2597:5: (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) )
                    	    {
                    	    // Xmu.g:2597:5: (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) )
                    	    // Xmu.g:2598:6: a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    	    {
                    	    a5=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_PatternNode2486); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_4_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[225]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[226]);
                    	    					}

                    	    // Xmu.g:2613:6: (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    	    // Xmu.g:2614:7: a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2520);
                    	    a6_0=parse_edu_ustb_sei_mde_xmu_PatternExpr();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[227]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[228]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[229]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[230]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[231]);
            	}

            a7=(Token)match(input,60,FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_PatternNode2594); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_10_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[232]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[233]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[241]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[242]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[243]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_edu_ustb_sei_mde_xmu_PatternNode_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_PatternNode"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr"
    // Xmu.g:2682:1: parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr returns [edu.ustb.sei.mde.xmu.PatternReferenceExpr element = null] : (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ;
    public final edu.ustb.sei.mde.xmu.PatternReferenceExpr parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternReferenceExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        edu.ustb.sei.mde.xmu.AtomicExpr a2_0 =null;

        edu.ustb.sei.mde.xmu.PatternNode a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Xmu.g:2685:2: ( (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) )
            // Xmu.g:2686:2: (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            {
            // Xmu.g:2686:2: (a0= NAME )
            // Xmu.g:2687:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2627); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[245]);
            	}

            // Xmu.g:2727:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Xmu.g:2728:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    {
                    // Xmu.g:2728:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    // Xmu.g:2729:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                    {
                    a1=(Token)match(input,32,FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2657); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[246]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[247]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[248]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[249]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[250]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[251]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[252]);
                    			}

                    // Xmu.g:2749:4: (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                    // Xmu.g:2750:5: a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2683);
                    a2_0=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[253]);
                    			}

                    a3=(Token)match(input,33,FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2711); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_1_0_0_2, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[254]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[255]);
            	}

            a4=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2744); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternReferenceExpr();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_11_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[256]);
            	}

            // Xmu.g:2810:2: (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            // Xmu.g:2811:3: a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2762);
            a5_0=parse_edu_ustb_sei_mde_xmu_PatternNode();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[257]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[258]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_PatternEqualExpr"
    // Xmu.g:2839:1: parse_edu_ustb_sei_mde_xmu_PatternEqualExpr returns [edu.ustb.sei.mde.xmu.PatternEqualExpr element = null] : (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
    public final edu.ustb.sei.mde.xmu.PatternEqualExpr parse_edu_ustb_sei_mde_xmu_PatternEqualExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternEqualExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_PatternEqualExpr_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        edu.ustb.sei.mde.xmu.AtomicExpr a2_0 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Xmu.g:2842:2: ( (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:2843:2: (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:2843:2: (a0= NAME )
            // Xmu.g:2844:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2799); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[259]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[260]);
            	}

            // Xmu.g:2884:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Xmu.g:2885:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    {
                    // Xmu.g:2885:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    // Xmu.g:2886:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                    {
                    a1=(Token)match(input,32,FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2829); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[261]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[262]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[263]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[264]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[265]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[266]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[267]);
                    			}

                    // Xmu.g:2906:4: (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                    // Xmu.g:2907:5: a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2855);
                    a2_0=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[268]);
                    			}

                    a3=(Token)match(input,33,FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2883); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_1_0_0_2, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[269]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[270]);
            	}

            a4=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2916); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPatternEqualExpr();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_12_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[271]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[272]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[273]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[274]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[275]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[276]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[277]);
            	}

            // Xmu.g:2973:2: (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            // Xmu.g:2974:3: a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2934);
            a5_0=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[278]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[279]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_edu_ustb_sei_mde_xmu_PatternEqualExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_PatternEqualExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_VariableExp"
    // Xmu.g:3002:1: parse_edu_ustb_sei_mde_xmu_VariableExp returns [edu.ustb.sei.mde.xmu.VariableExp element = null] : (a0= NAME ) ( (a1= '.' (a2_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )* ;
    public final edu.ustb.sei.mde.xmu.VariableExp parse_edu_ustb_sei_mde_xmu_VariableExp() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VariableExp element =  null;

        int parse_edu_ustb_sei_mde_xmu_VariableExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.xmu.Path a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Xmu.g:3005:2: ( (a0= NAME ) ( (a1= '.' (a2_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )* )
            // Xmu.g:3006:2: (a0= NAME ) ( (a1= '.' (a2_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )*
            {
            // Xmu.g:3006:2: (a0= NAME )
            // Xmu.g:3007:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_VariableExp2971); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[280]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[281]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[282]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[283]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[284]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[285]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[286]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[287]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[288]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[289]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[290]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[291]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[292]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[293]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[294]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[295]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[296]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[297]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[298]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[299]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[300]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[301]);
            	}

            // Xmu.g:3067:2: ( (a1= '.' (a2_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==22) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // Xmu.g:3068:3: (a1= '.' (a2_0= parse_edu_ustb_sei_mde_xmu_Path ) )
            	    {
            	    // Xmu.g:3068:3: (a1= '.' (a2_0= parse_edu_ustb_sei_mde_xmu_Path ) )
            	    // Xmu.g:3069:4: a1= '.' (a2_0= parse_edu_ustb_sei_mde_xmu_Path )
            	    {
            	    a1=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_VariableExp3001); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVariableExp();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_13_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[302]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[303]);
            	    			}

            	    // Xmu.g:3084:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Path )
            	    // Xmu.g:3085:5: a2_0= parse_edu_ustb_sei_mde_xmu_Path
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Path_in_parse_edu_ustb_sei_mde_xmu_VariableExp3027);
            	    a2_0=parse_edu_ustb_sei_mde_xmu_Path();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createVariableExp();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.VARIABLE_EXP__PATH, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_13_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[304]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[305]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[306]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[307]);
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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[320]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[321]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[322]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[323]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[324]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[325]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[326]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[327]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[328]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[329]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[330]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[331]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[332]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[333]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[334]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[335]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[336]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[337]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[338]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[339]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[340]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[341]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[342]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[343]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[344]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[345]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[346]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[347]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_edu_ustb_sei_mde_xmu_VariableExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_VariableExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_FeaturePath"
    // Xmu.g:3161:1: parse_edu_ustb_sei_mde_xmu_FeaturePath returns [edu.ustb.sei.mde.xmu.FeaturePath element = null] : (a0= NAME ) ;
    public final edu.ustb.sei.mde.xmu.FeaturePath parse_edu_ustb_sei_mde_xmu_FeaturePath() throws RecognitionException {
        edu.ustb.sei.mde.xmu.FeaturePath element =  null;

        int parse_edu_ustb_sei_mde_xmu_FeaturePath_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Xmu.g:3164:2: ( (a0= NAME ) )
            // Xmu.g:3165:2: (a0= NAME )
            {
            // Xmu.g:3165:2: (a0= NAME )
            // Xmu.g:3166:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3087); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createFeaturePath();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.FEATURE_PATH__FEATURE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.FEATURE_PATH__FEATURE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_14_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[348]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[349]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[350]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[351]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[352]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[353]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[354]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[355]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[356]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[357]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[358]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[359]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[360]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[361]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[362]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[363]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[364]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[365]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[366]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[367]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[368]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[369]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_edu_ustb_sei_mde_xmu_FeaturePath_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_FeaturePath"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_OperationPath"
    // Xmu.g:3224:1: parse_edu_ustb_sei_mde_xmu_OperationPath returns [edu.ustb.sei.mde.xmu.OperationPath element = null] : (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')' ;
    public final edu.ustb.sei.mde.xmu.OperationPath parse_edu_ustb_sei_mde_xmu_OperationPath() throws RecognitionException {
        edu.ustb.sei.mde.xmu.OperationPath element =  null;

        int parse_edu_ustb_sei_mde_xmu_OperationPath_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        edu.ustb.sei.mde.xmu.Expr a2_0 =null;

        edu.ustb.sei.mde.xmu.Expr a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Xmu.g:3227:2: ( (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')' )
            // Xmu.g:3228:2: (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')'
            {
            // Xmu.g:3228:2: (a0= NAME )
            // Xmu.g:3229:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_OperationPath3127); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NAME");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.OPERATION_PATH__OPERATION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.OPERATION_PATH__OPERATION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[370]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_OperationPath3148); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[371]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[372]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[373]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[374]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[375]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[377]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[379]);
            	}

            // Xmu.g:3286:2: ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==BOOLEAN||(LA26_0 >= NAME && LA26_0 <= NUMBER)||LA26_0==QUOTED_39_39_92||LA26_0==15||LA26_0==20||(LA26_0 >= 42 && LA26_0 <= 44)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // Xmu.g:3287:3: ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    {
                    // Xmu.g:3287:3: ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    // Xmu.g:3288:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    {
                    // Xmu.g:3288:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    // Xmu.g:3289:5: a2_0= parse_edu_ustb_sei_mde_xmu_Expr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3177);
                    a2_0=parse_edu_ustb_sei_mde_xmu_Expr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
                    						startIncompleteElement(element);
                    					}
                    					if (a2_0 != null) {
                    						if (a2_0 != null) {
                    							Object value = a2_0;
                    							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.OPERATION_PATH__PARAMETERS, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[380]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[381]);
                    			}

                    // Xmu.g:3315:4: ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==19) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // Xmu.g:3316:5: (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    {
                    	    // Xmu.g:3316:5: (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    // Xmu.g:3317:6: a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    {
                    	    a3=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_OperationPath3218); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_2_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[382]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[383]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[384]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[385]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[386]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[387]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[388]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[389]);
                    	    					}

                    	    // Xmu.g:3338:6: (a4_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    // Xmu.g:3339:7: a4_0= parse_edu_ustb_sei_mde_xmu_Expr
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3252);
                    	    a4_0=parse_edu_ustb_sei_mde_xmu_Expr();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
                    	    							}
                    	    							if (element == null) {
                    	    								element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
                    	    								startIncompleteElement(element);
                    	    							}
                    	    							if (a4_0 != null) {
                    	    								if (a4_0 != null) {
                    	    									Object value = a4_0;
                    	    									addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.OPERATION_PATH__PARAMETERS, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_2_0_0_1_0_0_1, a4_0, true);
                    	    								copyLocalizationInfos(a4_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[390]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[391]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[392]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[393]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[394]);
            	}

            a5=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_OperationPath3326); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[395]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[396]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[397]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[398]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[399]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[400]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[401]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[402]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[403]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[404]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[405]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[406]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[407]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[408]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[409]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[410]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[411]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[412]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[413]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[414]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[415]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[416]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_edu_ustb_sei_mde_xmu_OperationPath_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_OperationPath"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_StringLiteral"
    // Xmu.g:3417:1: parse_edu_ustb_sei_mde_xmu_StringLiteral returns [edu.ustb.sei.mde.xmu.StringLiteral element = null] : (a0= QUOTED_39_39_92 ) ;
    public final edu.ustb.sei.mde.xmu.StringLiteral parse_edu_ustb_sei_mde_xmu_StringLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.StringLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_StringLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Xmu.g:3420:2: ( (a0= QUOTED_39_39_92 ) )
            // Xmu.g:3421:2: (a0= QUOTED_39_39_92 )
            {
            // Xmu.g:3421:2: (a0= QUOTED_39_39_92 )
            // Xmu.g:3422:3: a0= QUOTED_39_39_92
            {
            a0=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_xmu_StringLiteral3359); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[417]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[418]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[419]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[420]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[421]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[422]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[423]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[424]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[425]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[426]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[427]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[428]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[429]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[430]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[431]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[432]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[433]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[434]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[435]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[436]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[437]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_edu_ustb_sei_mde_xmu_StringLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_StringLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_EmptyLiteral"
    // Xmu.g:3479:1: parse_edu_ustb_sei_mde_xmu_EmptyLiteral returns [edu.ustb.sei.mde.xmu.EmptyLiteral element = null] : ( (a0= 'null' |a1= 'nil' ) ) ;
    public final edu.ustb.sei.mde.xmu.EmptyLiteral parse_edu_ustb_sei_mde_xmu_EmptyLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EmptyLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_EmptyLiteral_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Xmu.g:3482:2: ( ( (a0= 'null' |a1= 'nil' ) ) )
            // Xmu.g:3483:2: ( (a0= 'null' |a1= 'nil' ) )
            {
            // Xmu.g:3483:2: ( (a0= 'null' |a1= 'nil' ) )
            // Xmu.g:3484:3: (a0= 'null' |a1= 'nil' )
            {
            // Xmu.g:3484:3: (a0= 'null' |a1= 'nil' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==44) ) {
                alt27=1;
            }
            else if ( (LA27_0==42) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // Xmu.g:3485:4: a0= 'null'
                    {
                    a0=(Token)match(input,44,FOLLOW_44_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3404); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEmptyLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_17_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEmptyType().getEEnumLiteral(edu.ustb.sei.mde.xmu.EmptyType.NULL_VALUE_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.EMPTY_LITERAL__VALUE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Xmu.g:3498:8: a1= 'nil'
                    {
                    a1=(Token)match(input,42,FOLLOW_42_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3419); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEmptyLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_17_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEmptyType().getEEnumLiteral(edu.ustb.sei.mde.xmu.EmptyType.EMPTY_VALUE_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.EMPTY_LITERAL__VALUE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[438]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[439]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[440]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[441]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[442]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[443]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[444]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[445]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[446]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[447]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[448]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[449]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[450]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[451]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[452]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[453]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[454]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[455]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[456]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[457]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[458]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_edu_ustb_sei_mde_xmu_EmptyLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_EmptyLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_IntegerLiteral"
    // Xmu.g:3540:1: parse_edu_ustb_sei_mde_xmu_IntegerLiteral returns [edu.ustb.sei.mde.xmu.IntegerLiteral element = null] : (a0= NUMBER ) ;
    public final edu.ustb.sei.mde.xmu.IntegerLiteral parse_edu_ustb_sei_mde_xmu_IntegerLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.IntegerLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_IntegerLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Xmu.g:3543:2: ( (a0= NUMBER ) )
            // Xmu.g:3544:2: (a0= NUMBER )
            {
            // Xmu.g:3544:2: (a0= NUMBER )
            // Xmu.g:3545:3: a0= NUMBER
            {
            a0=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_IntegerLiteral3459); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_18_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[459]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[460]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[461]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[462]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[463]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[464]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[465]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[466]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[467]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[468]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[469]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[470]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[471]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[472]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[473]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[474]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[475]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[476]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[477]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[478]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[479]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_edu_ustb_sei_mde_xmu_IntegerLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_IntegerLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_BooleanLiteral"
    // Xmu.g:3602:1: parse_edu_ustb_sei_mde_xmu_BooleanLiteral returns [edu.ustb.sei.mde.xmu.BooleanLiteral element = null] : (a0= BOOLEAN ) ;
    public final edu.ustb.sei.mde.xmu.BooleanLiteral parse_edu_ustb_sei_mde_xmu_BooleanLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_BooleanLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Xmu.g:3605:2: ( (a0= BOOLEAN ) )
            // Xmu.g:3606:2: (a0= BOOLEAN )
            {
            // Xmu.g:3606:2: (a0= BOOLEAN )
            // Xmu.g:3607:3: a0= BOOLEAN
            {
            a0=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_parse_edu_ustb_sei_mde_xmu_BooleanLiteral3499); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_19_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[480]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[481]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[482]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[483]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[484]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[485]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[486]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[487]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[488]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[489]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[490]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[491]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[492]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[493]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[494]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[495]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[496]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[497]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[498]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[499]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[500]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_edu_ustb_sei_mde_xmu_BooleanLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_BooleanLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_EnumLiteral"
    // Xmu.g:3664:1: parse_edu_ustb_sei_mde_xmu_EnumLiteral returns [edu.ustb.sei.mde.xmu.EnumLiteral element = null] : (a0= NAME ) a1= '::' (a2= NAME ) ;
    public final edu.ustb.sei.mde.xmu.EnumLiteral parse_edu_ustb_sei_mde_xmu_EnumLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EnumLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_EnumLiteral_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Xmu.g:3667:2: ( (a0= NAME ) a1= '::' (a2= NAME ) )
            // Xmu.g:3668:2: (a0= NAME ) a1= '::' (a2= NAME )
            {
            // Xmu.g:3668:2: (a0= NAME )
            // Xmu.g:3669:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3539); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_20_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[501]);
            	}

            a1=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3560); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_20_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[502]);
            	}

            // Xmu.g:3722:2: (a2= NAME )
            // Xmu.g:3723:3: a2= NAME
            {
            a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3578); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_20_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[503]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[504]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[505]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[506]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[507]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[508]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[509]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[510]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[511]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[512]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[513]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[514]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[515]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[516]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[517]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[518]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[519]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[520]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[521]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[522]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[523]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_edu_ustb_sei_mde_xmu_EnumLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_EnumLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_BlockStatement"
    // Xmu.g:3784:1: parse_edu_ustb_sei_mde_xmu_BlockStatement returns [edu.ustb.sei.mde.xmu.BlockStatement element = null] : a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}' ;
    public final edu.ustb.sei.mde.xmu.BlockStatement parse_edu_ustb_sei_mde_xmu_BlockStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BlockStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_BlockStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        edu.ustb.sei.mde.xmu.Statement a1_0 =null;

        edu.ustb.sei.mde.xmu.Statement a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Xmu.g:3787:2: (a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}' )
            // Xmu.g:3788:2: a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}'
            {
            a0=(Token)match(input,59,FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3614); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[524]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[525]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[526]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[527]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[528]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[529]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[530]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[531]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[532]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[533]);
            	}

            // Xmu.g:3811:2: ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==NAME||(LA29_0 >= 38 && LA29_0 <= 39)||LA29_0==46||LA29_0==50||(LA29_0 >= 53 && LA29_0 <= 54)||LA29_0==59) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // Xmu.g:3812:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* )
                    {
                    // Xmu.g:3812:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* )
                    // Xmu.g:3813:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )*
                    {
                    // Xmu.g:3813:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    // Xmu.g:3814:5: a1_0= parse_edu_ustb_sei_mde_xmu_Statement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3643);
                    a1_0=parse_edu_ustb_sei_mde_xmu_Statement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_1_0_0_0, a1_0, true);
                    						copyLocalizationInfos(a1_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[534]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[535]);
                    			}

                    // Xmu.g:3840:4: ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==26) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // Xmu.g:3841:5: (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
                    	    {
                    	    // Xmu.g:3841:5: (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
                    	    // Xmu.g:3842:6: a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    	    {
                    	    a2=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3684); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_1_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[536]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[537]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[538]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[539]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[540]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[541]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[542]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[543]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[544]);
                    	    					}

                    	    // Xmu.g:3864:6: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    	    // Xmu.g:3865:7: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3718);
                    	    a3_0=parse_edu_ustb_sei_mde_xmu_Statement();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_1_0_0_1_0_0_1, a3_0, true);
                    	    								copyLocalizationInfos(a3_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[545]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[546]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[547]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[548]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[549]);
            	}

            a4=(Token)match(input,60,FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3792); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[550]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[551]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[552]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[553]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[554]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[555]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[556]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_edu_ustb_sei_mde_xmu_BlockStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_BlockStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_SwitchStatement"
    // Xmu.g:3928:1: parse_edu_ustb_sei_mde_xmu_SwitchStatement returns [edu.ustb.sei.mde.xmu.SwitchStatement element = null] : a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}' ;
    public final edu.ustb.sei.mde.xmu.SwitchStatement parse_edu_ustb_sei_mde_xmu_SwitchStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.SwitchStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_SwitchStatement_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a8=null;
        edu.ustb.sei.mde.xmu.UpdatedStatement a3_0 =null;

        edu.ustb.sei.mde.xmu.UpdatedStatement a5_0 =null;

        edu.ustb.sei.mde.xmu.CaseSubStatement a7_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Xmu.g:3931:2: (a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}' )
            // Xmu.g:3932:2: a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}'
            {
            a0=(Token)match(input,50,FOLLOW_50_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3821); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[557]);
            	}

            // Xmu.g:3946:2: (a1= NAME )
            // Xmu.g:3947:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3839); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[558]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[559]);
            	}

            // Xmu.g:3987:2: ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==57) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Xmu.g:3988:3: (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                    {
                    // Xmu.g:3988:3: (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                    // Xmu.g:3989:4: a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                    {
                    a2=(Token)match(input,57,FOLLOW_57_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3869); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[560]);
                    			}

                    // Xmu.g:4003:4: (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    // Xmu.g:4004:5: a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3895);
                    a3_0=parse_edu_ustb_sei_mde_xmu_UpdatedStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_2_0_0_1, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[561]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[562]);
                    			}

                    // Xmu.g:4030:4: ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==26) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // Xmu.g:4031:5: (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                    	    {
                    	    // Xmu.g:4031:5: (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                    	    // Xmu.g:4032:6: a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    	    {
                    	    a4=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3936); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_2_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[563]);
                    	    					}

                    	    // Xmu.g:4046:6: (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    	    // Xmu.g:4047:7: a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3970);
                    	    a5_0=parse_edu_ustb_sei_mde_xmu_UpdatedStatement();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_2_0_0_2_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[564]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[565]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[566]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[567]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[568]);
            	}

            a6=(Token)match(input,59,FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4044); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[569]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[570]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[571]);
            	}

            // Xmu.g:4104:2: ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==36) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // Xmu.g:4105:3: (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement )
            	    {
            	    // Xmu.g:4105:3: (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement )
            	    // Xmu.g:4106:4: a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseSubStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4067);
            	    a7_0=parse_edu_ustb_sei_mde_xmu_CaseSubStatement();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_4, a7_0, true);
            	    					copyLocalizationInfos(a7_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[572]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[573]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[574]);
            	}

            a8=(Token)match(input,60,FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4093); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[575]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[576]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[577]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[578]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[579]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[580]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[581]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_edu_ustb_sei_mde_xmu_SwitchStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_SwitchStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_CasePatternStatement"
    // Xmu.g:4156:1: parse_edu_ustb_sei_mde_xmu_CasePatternStatement returns [edu.ustb.sei.mde.xmu.CasePatternStatement element = null] : a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
    public final edu.ustb.sei.mde.xmu.CasePatternStatement parse_edu_ustb_sei_mde_xmu_CasePatternStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CasePatternStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CasePatternStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.Pattern a1_0 =null;

        edu.ustb.sei.mde.xmu.Statement a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Xmu.g:4159:2: (a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:4160:2: a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            a0=(Token)match(input,36,FOLLOW_36_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4122); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCasePatternStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[582]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[583]);
            	}

            // Xmu.g:4175:2: (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern )
            // Xmu.g:4176:3: a1_0= parse_edu_ustb_sei_mde_xmu_Pattern
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4140);
            a1_0=parse_edu_ustb_sei_mde_xmu_Pattern();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[584]);
            	}

            a2=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4158); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCasePatternStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[585]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[586]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[587]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[588]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[589]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[590]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[591]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[592]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[593]);
            	}

            // Xmu.g:4223:2: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:4224:3: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4176);
            a3_0=parse_edu_ustb_sei_mde_xmu_Statement();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_3, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[594]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[595]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[596]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_edu_ustb_sei_mde_xmu_CasePatternStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_CasePatternStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_CaseValueStatement"
    // Xmu.g:4253:1: parse_edu_ustb_sei_mde_xmu_CaseValueStatement returns [edu.ustb.sei.mde.xmu.CaseValueStatement element = null] : a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
    public final edu.ustb.sei.mde.xmu.CaseValueStatement parse_edu_ustb_sei_mde_xmu_CaseValueStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CaseValueStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CaseValueStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.Expr a1_0 =null;

        edu.ustb.sei.mde.xmu.Statement a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Xmu.g:4256:2: (a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:4257:2: a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            a0=(Token)match(input,36,FOLLOW_36_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4209); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCaseValueStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[597]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[598]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[599]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[600]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[601]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[602]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[603]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[604]);
            	}

            // Xmu.g:4278:2: (a1_0= parse_edu_ustb_sei_mde_xmu_Expr )
            // Xmu.g:4279:3: a1_0= parse_edu_ustb_sei_mde_xmu_Expr
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4227);
            a1_0=parse_edu_ustb_sei_mde_xmu_Expr();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[605]);
            	}

            a2=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4245); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCaseValueStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[606]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[607]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[608]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[609]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[610]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[611]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[612]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[613]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[614]);
            	}

            // Xmu.g:4326:2: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:4327:3: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4263);
            a3_0=parse_edu_ustb_sei_mde_xmu_Statement();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_3, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[615]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[616]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[617]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_edu_ustb_sei_mde_xmu_CaseValueStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_CaseValueStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_RuleCallStatement"
    // Xmu.g:4356:1: parse_edu_ustb_sei_mde_xmu_RuleCallStatement returns [edu.ustb.sei.mde.xmu.RuleCallStatement element = null] : (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')' ;
    public final edu.ustb.sei.mde.xmu.RuleCallStatement parse_edu_ustb_sei_mde_xmu_RuleCallStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RuleCallStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_RuleCallStatement_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        edu.ustb.sei.mde.xmu.Expr a2_0 =null;

        edu.ustb.sei.mde.xmu.Expr a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Xmu.g:4359:2: ( (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')' )
            // Xmu.g:4360:2: (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')'
            {
            // Xmu.g:4360:2: (a0= NAME )
            // Xmu.g:4361:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4300); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[618]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4321); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[619]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[620]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[621]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[622]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[623]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[624]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[625]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[626]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[627]);
            	}

            // Xmu.g:4422:2: ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==BOOLEAN||(LA34_0 >= NAME && LA34_0 <= NUMBER)||LA34_0==QUOTED_39_39_92||LA34_0==15||LA34_0==20||(LA34_0 >= 42 && LA34_0 <= 44)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // Xmu.g:4423:3: ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    {
                    // Xmu.g:4423:3: ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    // Xmu.g:4424:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    {
                    // Xmu.g:4424:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    // Xmu.g:4425:5: a2_0= parse_edu_ustb_sei_mde_xmu_Expr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4350);
                    a2_0=parse_edu_ustb_sei_mde_xmu_Expr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[628]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[629]);
                    			}

                    // Xmu.g:4451:4: ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==19) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // Xmu.g:4452:5: (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    {
                    	    // Xmu.g:4452:5: (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    // Xmu.g:4453:6: a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    {
                    	    a3=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4391); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_2_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[630]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[631]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[632]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[633]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[634]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[635]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[636]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[637]);
                    	    					}

                    	    // Xmu.g:4474:6: (a4_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    // Xmu.g:4475:7: a4_0= parse_edu_ustb_sei_mde_xmu_Expr
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4425);
                    	    a4_0=parse_edu_ustb_sei_mde_xmu_Expr();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_2_0_0_1_0_0_1, a4_0, true);
                    	    								copyLocalizationInfos(a4_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[638]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[639]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[640]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[641]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[642]);
            	}

            a5=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4499); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[643]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[644]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[645]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[646]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[647]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[648]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[649]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_edu_ustb_sei_mde_xmu_RuleCallStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_RuleCallStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_UpdatePattern"
    // Xmu.g:4538:1: parse_edu_ustb_sei_mde_xmu_UpdatePattern returns [edu.ustb.sei.mde.xmu.UpdatePattern element = null] : a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ;
    public final edu.ustb.sei.mde.xmu.UpdatePattern parse_edu_ustb_sei_mde_xmu_UpdatePattern() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UpdatePattern element =  null;

        int parse_edu_ustb_sei_mde_xmu_UpdatePattern_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.xmu.PatternNode a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Xmu.g:4541:2: (a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) )
            // Xmu.g:4542:2: a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            {
            a0=(Token)match(input,39,FOLLOW_39_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4528); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatePattern();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatePattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[650]);
            	}

            // Xmu.g:4556:2: (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            // Xmu.g:4557:3: a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4546);
            a1_0=parse_edu_ustb_sei_mde_xmu_PatternNode();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[651]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[652]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[653]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[654]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[655]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[656]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[657]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[658]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[659]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_edu_ustb_sei_mde_xmu_UpdatePattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_UpdatePattern"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_DeleteNode"
    // Xmu.g:4592:1: parse_edu_ustb_sei_mde_xmu_DeleteNode returns [edu.ustb.sei.mde.xmu.DeleteNode element = null] : a0= 'delete' (a1= NAME ) ;
    public final edu.ustb.sei.mde.xmu.DeleteNode parse_edu_ustb_sei_mde_xmu_DeleteNode() throws RecognitionException {
        edu.ustb.sei.mde.xmu.DeleteNode element =  null;

        int parse_edu_ustb_sei_mde_xmu_DeleteNode_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Xmu.g:4595:2: (a0= 'delete' (a1= NAME ) )
            // Xmu.g:4596:2: a0= 'delete' (a1= NAME )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4579); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_27_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[660]);
            	}

            // Xmu.g:4610:2: (a1= NAME )
            // Xmu.g:4611:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4597); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_27_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[661]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[662]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[663]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[664]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[665]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[666]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[667]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_edu_ustb_sei_mde_xmu_DeleteNode_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_DeleteNode"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_DeleteLink"
    // Xmu.g:4658:1: parse_edu_ustb_sei_mde_xmu_DeleteLink returns [edu.ustb.sei.mde.xmu.DeleteLink element = null] : a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME ) ;
    public final edu.ustb.sei.mde.xmu.DeleteLink parse_edu_ustb_sei_mde_xmu_DeleteLink() throws RecognitionException {
        edu.ustb.sei.mde.xmu.DeleteLink element =  null;

        int parse_edu_ustb_sei_mde_xmu_DeleteLink_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Xmu.g:4661:2: (a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME ) )
            // Xmu.g:4662:2: a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4633); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[668]);
            	}

            // Xmu.g:4676:2: (a1= NAME )
            // Xmu.g:4677:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4651); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[669]);
            	}

            a2=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4672); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[670]);
            	}

            // Xmu.g:4730:2: (a3= NAME )
            // Xmu.g:4731:3: a3= NAME
            {
            a3=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4690); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_3, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[671]);
            	}

            a4=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4711); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[672]);
            	}

            // Xmu.g:4784:2: (a5= NAME )
            // Xmu.g:4785:3: a5= NAME
            {
            a5=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4729); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_5, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[673]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[674]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[675]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[676]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[677]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[678]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[679]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_edu_ustb_sei_mde_xmu_DeleteLink_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_DeleteLink"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_BooleanOrExpr"
    // Xmu.g:4832:1: parse_edu_ustb_sei_mde_xmu_BooleanOrExpr returns [edu.ustb.sei.mde.xmu.BooleanOrExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
    public final edu.ustb.sei.mde.xmu.BooleanOrExpr parse_edu_ustb_sei_mde_xmu_BooleanOrExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.xmu.BooleanAndExpr a0_0 =null;

        edu.ustb.sei.mde.xmu.RelationalExpr a0_1 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a0_2 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a0_3 =null;

        edu.ustb.sei.mde.xmu.BooleanAndExpr a2_0 =null;

        edu.ustb.sei.mde.xmu.RelationalExpr a2_1 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a2_2 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a2_3 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Xmu.g:4835:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:4836:2: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:4836:2: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt35=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA35_1 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (synpred46_Xmu()) ) {
                    alt35=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA35_2 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (synpred46_Xmu()) ) {
                    alt35=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA35_3 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (true) ) {
                    alt35=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA35_4 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (true) ) {
                    alt35=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 4, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                int LA35_5 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (true) ) {
                    alt35=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 5, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA35_6 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (true) ) {
                    alt35=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA35_7 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (true) ) {
                    alt35=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA35_8 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (true) ) {
                    alt35=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA35_9 = input.LA(2);

                if ( (synpred44_Xmu()) ) {
                    alt35=1;
                }
                else if ( (synpred45_Xmu()) ) {
                    alt35=2;
                }
                else if ( (true) ) {
                    alt35=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // Xmu.g:4837:3: a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4769);
                    a0_0=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:4856:6: a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4783);
                    a0_1=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:4875:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4797);
                    a0_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:4894:6: a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4811);
                    a0_3=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_0, a0_3, true);
                    				copyLocalizationInfos(a0_3, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[680]);
            	}

            // Xmu.g:4919:2: ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==45) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // Xmu.g:4920:3: (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:4920:3: (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:4921:4: a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    a1=(Token)match(input,45,FOLLOW_45_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4838); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[681]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[682]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[683]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[684]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[685]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[686]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[687]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[688]);
            	    			}

            	    // Xmu.g:4942:4: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt36=4;
            	    switch ( input.LA(1) ) {
            	    case 43:
            	        {
            	        int LA36_1 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (synpred49_Xmu()) ) {
            	            alt36=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 1, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 20:
            	        {
            	        int LA36_2 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (synpred49_Xmu()) ) {
            	            alt36=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 2, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NAME:
            	        {
            	        int LA36_3 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (true) ) {
            	            alt36=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 3, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case QUOTED_39_39_92:
            	        {
            	        int LA36_4 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (true) ) {
            	            alt36=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 4, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 44:
            	        {
            	        int LA36_5 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (true) ) {
            	            alt36=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 5, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 42:
            	        {
            	        int LA36_6 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (true) ) {
            	            alt36=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 6, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NUMBER:
            	        {
            	        int LA36_7 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (true) ) {
            	            alt36=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 7, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case BOOLEAN:
            	        {
            	        int LA36_8 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (true) ) {
            	            alt36=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 8, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 15:
            	        {
            	        int LA36_9 = input.LA(2);

            	        if ( (synpred47_Xmu()) ) {
            	            alt36=1;
            	        }
            	        else if ( (synpred48_Xmu()) ) {
            	            alt36=2;
            	        }
            	        else if ( (true) ) {
            	            alt36=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 36, 9, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt36) {
            	        case 1 :
            	            // Xmu.g:4943:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4864);
            	            a2_0=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_1_0_0_1, a2_0, true);
            	            						copyLocalizationInfos(a2_0, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:4962:10: a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4884);
            	            a2_1=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_1_0_0_1, a2_1, true);
            	            						copyLocalizationInfos(a2_1, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 3 :
            	            // Xmu.g:4981:10: a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4904);
            	            a2_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_1_0_0_1, a2_2, true);
            	            						copyLocalizationInfos(a2_2, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 4 :
            	            // Xmu.g:5000:10: a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4924);
            	            a2_3=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_1_0_0_1, a2_3, true);
            	            						copyLocalizationInfos(a2_3, element);
            	            					}
            	            				}

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[689]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[690]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[691]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[692]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[693]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[694]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[695]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[696]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[697]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[698]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[699]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[700]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[701]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[702]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[703]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[704]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[705]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[706]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[707]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[708]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[709]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[710]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[711]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[712]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[713]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[714]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[715]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[716]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[717]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[718]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_BooleanOrExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_BooleanAndExpr"
    // Xmu.g:5062:1: parse_edu_ustb_sei_mde_xmu_BooleanAndExpr returns [edu.ustb.sei.mde.xmu.BooleanAndExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
    public final edu.ustb.sei.mde.xmu.BooleanAndExpr parse_edu_ustb_sei_mde_xmu_BooleanAndExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.xmu.RelationalExpr a0_0 =null;

        edu.ustb.sei.mde.xmu.AdditiveExpr a0_1 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_2 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a0_3 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a0_4 =null;

        edu.ustb.sei.mde.xmu.RelationalExpr a2_0 =null;

        edu.ustb.sei.mde.xmu.AdditiveExpr a2_1 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a2_2 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a2_3 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a2_4 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Xmu.g:5065:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5066:2: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5066:2: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt38=5;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA38_1 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (synpred54_Xmu()) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA38_2 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (synpred54_Xmu()) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA38_3 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA38_4 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 4, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                int LA38_5 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 5, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA38_6 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA38_7 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA38_8 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA38_9 = input.LA(2);

                if ( (synpred51_Xmu()) ) {
                    alt38=1;
                }
                else if ( (synpred52_Xmu()) ) {
                    alt38=2;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // Xmu.g:5067:3: a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr4984);
                    a0_0=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5086:6: a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr4998);
                    a0_1=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:5105:6: a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5012);
                    a0_2=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:5124:6: a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5026);
                    a0_3=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_3, true);
                    				copyLocalizationInfos(a0_3, element);
                    			}
                    		}

                    }
                    break;
                case 5 :
                    // Xmu.g:5143:6: a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5040);
                    a0_4=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_4, true);
                    				copyLocalizationInfos(a0_4, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[719]);
            	}

            // Xmu.g:5168:2: ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==34) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // Xmu.g:5169:3: (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:5169:3: (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:5170:4: a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    a1=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5067); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[720]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[721]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[722]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[723]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[724]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[725]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[726]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[727]);
            	    			}

            	    // Xmu.g:5191:4: (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt39=5;
            	    switch ( input.LA(1) ) {
            	    case 43:
            	        {
            	        int LA39_1 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt39=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 1, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 20:
            	        {
            	        int LA39_2 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt39=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 2, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NAME:
            	        {
            	        int LA39_3 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (true) ) {
            	            alt39=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 3, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case QUOTED_39_39_92:
            	        {
            	        int LA39_4 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (true) ) {
            	            alt39=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 4, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 44:
            	        {
            	        int LA39_5 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (true) ) {
            	            alt39=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 5, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 42:
            	        {
            	        int LA39_6 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (true) ) {
            	            alt39=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 6, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NUMBER:
            	        {
            	        int LA39_7 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (true) ) {
            	            alt39=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 7, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case BOOLEAN:
            	        {
            	        int LA39_8 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (true) ) {
            	            alt39=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 8, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 15:
            	        {
            	        int LA39_9 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt39=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt39=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt39=3;
            	        }
            	        else if ( (true) ) {
            	            alt39=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 39, 9, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt39) {
            	        case 1 :
            	            // Xmu.g:5192:5: a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5093);
            	            a2_0=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_0, true);
            	            						copyLocalizationInfos(a2_0, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:5211:10: a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5113);
            	            a2_1=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_1, true);
            	            						copyLocalizationInfos(a2_1, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 3 :
            	            // Xmu.g:5230:10: a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5133);
            	            a2_2=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_2, true);
            	            						copyLocalizationInfos(a2_2, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 4 :
            	            // Xmu.g:5249:10: a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5153);
            	            a2_3=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_3, true);
            	            						copyLocalizationInfos(a2_3, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 5 :
            	            // Xmu.g:5268:10: a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5173);
            	            a2_4=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_4, true);
            	            						copyLocalizationInfos(a2_4, element);
            	            					}
            	            				}

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[738]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[739]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[740]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[741]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[742]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[743]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[744]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[745]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[746]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[747]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[748]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[749]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[750]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[751]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[752]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[753]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[754]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[755]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[756]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[757]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[758]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[759]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_BooleanAndExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_RelationalExpr"
    // Xmu.g:5332:1: parse_edu_ustb_sei_mde_xmu_RelationalExpr returns [edu.ustb.sei.mde.xmu.RelationalExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
    public final edu.ustb.sei.mde.xmu.RelationalExpr parse_edu_ustb_sei_mde_xmu_RelationalExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_RelationalExpr_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        edu.ustb.sei.mde.xmu.AdditiveExpr a0_0 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_1 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a0_2 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a0_3 =null;

        edu.ustb.sei.mde.xmu.AdditiveExpr a8_0 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a8_1 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a8_2 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a8_3 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Xmu.g:5335:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:5336:2: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:5336:2: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA41_1 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt41=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA41_2 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt41=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA41_3 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (true) ) {
                    alt41=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA41_4 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (true) ) {
                    alt41=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 4, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                int LA41_5 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (true) ) {
                    alt41=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 5, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA41_6 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (true) ) {
                    alt41=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA41_7 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (true) ) {
                    alt41=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA41_8 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (true) ) {
                    alt41=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA41_9 = input.LA(2);

                if ( (synpred60_Xmu()) ) {
                    alt41=1;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt41=2;
                }
                else if ( (true) ) {
                    alt41=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }

            switch (alt41) {
                case 1 :
                    // Xmu.g:5337:3: a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5233);
                    a0_0=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5356:6: a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5247);
                    a0_1=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:5375:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5261);
                    a0_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:5394:6: a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5275);
                    a0_3=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_3, true);
                    				copyLocalizationInfos(a0_3, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[760]);
            	}

            // Xmu.g:5419:2: ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) )
            // Xmu.g:5420:3: (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' )
            {
            // Xmu.g:5420:3: (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' )
            int alt42=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt42=1;
                }
                break;
            case 27:
                {
                alt42=2;
                }
                break;
            case 28:
                {
                alt42=3;
                }
                break;
            case 30:
                {
                alt42=4;
                }
                break;
            case 31:
                {
                alt42=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // Xmu.g:5421:4: a1= '='
                    {
                    a1=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5302); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Xmu.g:5434:8: a2= '<'
                    {
                    a2=(Token)match(input,27,FOLLOW_27_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5317); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.LESS_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Xmu.g:5447:8: a3= '<='
                    {
                    a3=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5332); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.LESS_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Xmu.g:5460:8: a4= '>'
                    {
                    a4=(Token)match(input,30,FOLLOW_30_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5347); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.GREATER_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Xmu.g:5473:8: a5= '>='
                    {
                    a5=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5362); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRelationalExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.RelationalOperator.GREATER_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.RELATIONAL_EXPR__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[761]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[762]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[763]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[764]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[765]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[766]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[767]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[768]);
            	}

            // Xmu.g:5500:2: (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt43=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA43_1 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (synpred69_Xmu()) ) {
                    alt43=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 1, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA43_2 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (synpred69_Xmu()) ) {
                    alt43=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA43_3 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (true) ) {
                    alt43=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA43_4 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (true) ) {
                    alt43=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 4, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                int LA43_5 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (true) ) {
                    alt43=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 5, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA43_6 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (true) ) {
                    alt43=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA43_7 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (true) ) {
                    alt43=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA43_8 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (true) ) {
                    alt43=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA43_9 = input.LA(2);

                if ( (synpred67_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred68_Xmu()) ) {
                    alt43=2;
                }
                else if ( (true) ) {
                    alt43=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // Xmu.g:5501:3: a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5387);
                    a8_0=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_2, a8_0, true);
                    				copyLocalizationInfos(a8_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5520:6: a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5401);
                    a8_1=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_2, a8_1, true);
                    				copyLocalizationInfos(a8_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:5539:6: a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5415);
                    a8_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_2, a8_2, true);
                    				copyLocalizationInfos(a8_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:5558:6: a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5429);
                    a8_3=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_2, a8_3, true);
                    				copyLocalizationInfos(a8_3, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[769]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[770]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[771]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[772]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[773]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[774]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[775]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[776]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[777]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[778]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[779]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[780]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[781]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[782]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[783]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[784]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, parse_edu_ustb_sei_mde_xmu_RelationalExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_RelationalExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_AdditiveExpr"
    // Xmu.g:5600:1: parse_edu_ustb_sei_mde_xmu_AdditiveExpr returns [edu.ustb.sei.mde.xmu.AdditiveExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
    public final edu.ustb.sei.mde.xmu.AdditiveExpr parse_edu_ustb_sei_mde_xmu_AdditiveExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_AdditiveExpr_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_0 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a0_1 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a0_2 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a5_0 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a5_1 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a5_2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Xmu.g:5603:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5604:2: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5604:2: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA44_1 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (synpred71_Xmu()) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA44_2 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (synpred71_Xmu()) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA44_3 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA44_4 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 4, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                int LA44_5 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 5, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA44_6 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA44_7 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA44_8 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA44_9 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // Xmu.g:5605:3: a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5466);
                    a0_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5624:6: a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5480);
                    a0_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:5643:6: a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5494);
                    a0_2=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[785]);
            	}

            // Xmu.g:5668:2: ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==18||LA47_0==20) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // Xmu.g:5669:3: ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:5669:3: ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:5670:4: ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    // Xmu.g:5670:4: ( (a1= '+' |a2= '-' ) )
            	    // Xmu.g:5671:5: (a1= '+' |a2= '-' )
            	    {
            	    // Xmu.g:5671:5: (a1= '+' |a2= '-' )
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( (LA45_0==18) ) {
            	        alt45=1;
            	    }
            	    else if ( (LA45_0==20) ) {
            	        alt45=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 45, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt45) {
            	        case 1 :
            	            // Xmu.g:5672:6: a1= '+'
            	            {
            	            a1=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5534); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.AdditiveOperator.ADD_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:5685:12: a2= '-'
            	            {
            	            a2=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5553); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.AdditiveOperator.SUB_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;

            	    }


            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[786]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[787]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[788]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[789]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[790]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[791]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[792]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[793]);
            	    			}

            	    // Xmu.g:5712:4: (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt46=3;
            	    switch ( input.LA(1) ) {
            	    case 43:
            	        {
            	        int LA46_1 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (synpred74_Xmu()) ) {
            	            alt46=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 1, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 20:
            	        {
            	        int LA46_2 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (synpred74_Xmu()) ) {
            	            alt46=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 2, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NAME:
            	        {
            	        int LA46_3 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (true) ) {
            	            alt46=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 3, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case QUOTED_39_39_92:
            	        {
            	        int LA46_4 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (true) ) {
            	            alt46=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 4, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 44:
            	        {
            	        int LA46_5 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (true) ) {
            	            alt46=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 5, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 42:
            	        {
            	        int LA46_6 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (true) ) {
            	            alt46=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 6, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NUMBER:
            	        {
            	        int LA46_7 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (true) ) {
            	            alt46=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 7, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case BOOLEAN:
            	        {
            	        int LA46_8 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (true) ) {
            	            alt46=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 8, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 15:
            	        {
            	        int LA46_9 = input.LA(2);

            	        if ( (synpred73_Xmu()) ) {
            	            alt46=1;
            	        }
            	        else if ( (true) ) {
            	            alt46=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 46, 9, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 46, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt46) {
            	        case 1 :
            	            // Xmu.g:5713:5: a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5590);
            	            a5_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a5_0 != null) {
            	            						if (a5_0 != null) {
            	            							Object value = a5_0;
            	            							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1_0_0_1, a5_0, true);
            	            						copyLocalizationInfos(a5_0, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:5732:10: a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5610);
            	            a5_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a5_1 != null) {
            	            						if (a5_1 != null) {
            	            							Object value = a5_1;
            	            							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1_0_0_1, a5_1, true);
            	            						copyLocalizationInfos(a5_1, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 3 :
            	            // Xmu.g:5751:10: a5_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5630);
            	            a5_2=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAdditiveExpr();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a5_2 != null) {
            	            						if (a5_2 != null) {
            	            							Object value = a5_2;
            	            							addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.ADDITIVE_EXPR__OPERANDS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_1_0_0_1, a5_2, true);
            	            						copyLocalizationInfos(a5_2, element);
            	            					}
            	            				}

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[794]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[795]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[796]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[797]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[798]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[799]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[800]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[801]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[802]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[803]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[804]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[805]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[806]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[807]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[808]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[809]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[810]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[811]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[812]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[813]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[814]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[815]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[816]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[817]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[818]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[819]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[820]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[821]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[822]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[823]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[824]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[825]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[826]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[827]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, parse_edu_ustb_sei_mde_xmu_AdditiveExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_AdditiveExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr"
    // Xmu.g:5817:1: parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr returns [edu.ustb.sei.mde.xmu.MultiplicativeExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
    public final edu.ustb.sei.mde.xmu.MultiplicativeExpr parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.UnaryExpr a0_0 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a0_1 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a5_0 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a5_1 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Xmu.g:5820:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5821:2: (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5821:2: (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==20||LA48_0==43) ) {
                alt48=1;
            }
            else if ( (LA48_0==BOOLEAN||(LA48_0 >= NAME && LA48_0 <= NUMBER)||LA48_0==QUOTED_39_39_92||LA48_0==15||LA48_0==42||LA48_0==44) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }
            switch (alt48) {
                case 1 :
                    // Xmu.g:5822:3: a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5690);
                    a0_0=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5841:6: a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5704);
                    a0_1=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[828]);
            	}

            // Xmu.g:5866:2: ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==17||LA51_0==23) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // Xmu.g:5867:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:5867:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:5868:4: ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    // Xmu.g:5868:4: ( (a1= '*' |a2= '/' ) )
            	    // Xmu.g:5869:5: (a1= '*' |a2= '/' )
            	    {
            	    // Xmu.g:5869:5: (a1= '*' |a2= '/' )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==17) ) {
            	        alt49=1;
            	    }
            	    else if ( (LA49_0==23) ) {
            	        alt49=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // Xmu.g:5870:6: a1= '*'
            	            {
            	            a1=(Token)match(input,17,FOLLOW_17_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5744); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createMultiplicativeExpr();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.MultiplicativeOperator.MUL_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.MULTIPLICATIVE_EXPR__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:5883:12: a2= '/'
            	            {
            	            a2=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5763); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createMultiplicativeExpr();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.MultiplicativeOperator.DIV_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.MULTIPLICATIVE_EXPR__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;

            	    }


            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[829]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[830]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[831]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[832]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[833]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[834]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[835]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[836]);
            	    			}

            	    // Xmu.g:5910:4: (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt50=2;
            	    int LA50_0 = input.LA(1);

            	    if ( (LA50_0==20||LA50_0==43) ) {
            	        alt50=1;
            	    }
            	    else if ( (LA50_0==BOOLEAN||(LA50_0 >= NAME && LA50_0 <= NUMBER)||LA50_0==QUOTED_39_39_92||LA50_0==15||LA50_0==42||LA50_0==44) ) {
            	        alt50=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 50, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt50) {
            	        case 1 :
            	            // Xmu.g:5911:5: a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5800);
            	            a5_0=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_1, a5_0, true);
            	            						copyLocalizationInfos(a5_0, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:5930:10: a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5820);
            	            a5_1=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_1_0_0_1, a5_1, true);
            	            						copyLocalizationInfos(a5_1, element);
            	            					}
            	            				}

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[837]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[838]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[839]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[840]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[841]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[842]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[843]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[844]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[845]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[846]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[847]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[848]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[849]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[850]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[851]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[852]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[853]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[854]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[855]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[856]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[857]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[858]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[859]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[860]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[861]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[862]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[863]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[864]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[865]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[866]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[867]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[868]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[869]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[870]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[871]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[872]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_ParenExpr"
    // Xmu.g:5998:1: parse_edu_ustb_sei_mde_xmu_ParenExpr returns [edu.ustb.sei.mde.xmu.ParenExpr element = null] : a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')' ;
    public final edu.ustb.sei.mde.xmu.ParenExpr parse_edu_ustb_sei_mde_xmu_ParenExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.ParenExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_ParenExpr_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.BooleanOrExpr a1_0 =null;

        edu.ustb.sei.mde.xmu.BooleanAndExpr a1_1 =null;

        edu.ustb.sei.mde.xmu.RelationalExpr a1_2 =null;

        edu.ustb.sei.mde.xmu.AdditiveExpr a1_3 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a1_4 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a1_5 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a1_6 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Xmu.g:6001:2: (a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')' )
            // Xmu.g:6002:2: a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5876); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[873]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[874]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[875]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[876]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[877]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[878]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[879]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[880]);
            	}

            // Xmu.g:6023:2: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt52=7;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA52_1 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (synpred85_Xmu()) ) {
                    alt52=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA52_2 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (synpred85_Xmu()) ) {
                    alt52=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA52_3 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (true) ) {
                    alt52=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA52_4 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (true) ) {
                    alt52=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 4, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                int LA52_5 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (true) ) {
                    alt52=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 5, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA52_6 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (true) ) {
                    alt52=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA52_7 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (true) ) {
                    alt52=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA52_8 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (true) ) {
                    alt52=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA52_9 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt52=1;
                }
                else if ( (synpred81_Xmu()) ) {
                    alt52=2;
                }
                else if ( (synpred82_Xmu()) ) {
                    alt52=3;
                }
                else if ( (synpred83_Xmu()) ) {
                    alt52=4;
                }
                else if ( (synpred84_Xmu()) ) {
                    alt52=5;
                }
                else if ( (true) ) {
                    alt52=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // Xmu.g:6024:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5894);
                    a1_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1, a1_0, true);
                    				copyLocalizationInfos(a1_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:6043:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5908);
                    a1_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1, a1_1, true);
                    				copyLocalizationInfos(a1_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:6062:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5922);
                    a1_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1, a1_2, true);
                    				copyLocalizationInfos(a1_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:6081:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5936);
                    a1_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1, a1_3, true);
                    				copyLocalizationInfos(a1_3, element);
                    			}
                    		}

                    }
                    break;
                case 5 :
                    // Xmu.g:6100:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5950);
                    a1_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1, a1_4, true);
                    				copyLocalizationInfos(a1_4, element);
                    			}
                    		}

                    }
                    break;
                case 6 :
                    // Xmu.g:6119:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5964);
                    a1_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1, a1_5, true);
                    				copyLocalizationInfos(a1_5, element);
                    			}
                    		}

                    }
                    break;
                case 7 :
                    // Xmu.g:6138:6: a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5978);
                    a1_6=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1, a1_6, true);
                    				copyLocalizationInfos(a1_6, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[881]);
            	}

            a2=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5996); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[882]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[883]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[884]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[885]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[886]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[887]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[888]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[889]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[890]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[891]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[892]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[893]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[894]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[895]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[896]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[897]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[898]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[899]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[900]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[901]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[902]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, parse_edu_ustb_sei_mde_xmu_ParenExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_ParenExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_UnaryExpr"
    // Xmu.g:6199:1: parse_edu_ustb_sei_mde_xmu_UnaryExpr returns [edu.ustb.sei.mde.xmu.UnaryExpr element = null] : ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
    public final edu.ustb.sei.mde.xmu.UnaryExpr parse_edu_ustb_sei_mde_xmu_UnaryExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_UnaryExpr_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.xmu.AtomicExpr a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }

            // Xmu.g:6202:2: ( ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:6203:2: ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:6203:2: ( (a0= 'not' |a1= '-' ) )
            // Xmu.g:6204:3: (a0= 'not' |a1= '-' )
            {
            // Xmu.g:6204:3: (a0= 'not' |a1= '-' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==43) ) {
                alt53=1;
            }
            else if ( (LA53_0==20) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1 :
                    // Xmu.g:6205:4: a0= 'not'
                    {
                    a0=(Token)match(input,43,FOLLOW_43_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6034); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUnaryExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.UnaryOperator.NOT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UNARY_EXPR__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Xmu.g:6218:8: a1= '-'
                    {
                    a1=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6049); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUnaryExpr();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.xmu.UnaryOperator.MINUS_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.xmu.XmuPackage.UNARY_EXPR__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[903]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[904]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[905]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[906]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[907]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[908]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[909]);
            	}

            // Xmu.g:6244:2: (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            // Xmu.g:6245:3: a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6074);
            a4_0=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[910]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[911]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[912]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[913]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[914]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[915]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[916]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[917]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[918]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[919]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[920]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[921]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[922]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[923]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[924]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[925]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[926]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[927]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[928]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 37, parse_edu_ustb_sei_mde_xmu_UnaryExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_UnaryExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_PrintStatement"
    // Xmu.g:6290:1: parse_edu_ustb_sei_mde_xmu_PrintStatement returns [edu.ustb.sei.mde.xmu.PrintStatement element = null] : a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
    public final edu.ustb.sei.mde.xmu.PrintStatement parse_edu_ustb_sei_mde_xmu_PrintStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PrintStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_PrintStatement_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.xmu.BooleanOrExpr a1_0 =null;

        edu.ustb.sei.mde.xmu.BooleanAndExpr a1_1 =null;

        edu.ustb.sei.mde.xmu.RelationalExpr a1_2 =null;

        edu.ustb.sei.mde.xmu.AdditiveExpr a1_3 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a1_4 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a1_5 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a1_6 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Xmu.g:6293:2: (a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:6294:2: a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            a0=(Token)match(input,46,FOLLOW_46_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6107); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[929]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[930]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[931]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[932]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[933]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[934]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[935]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[936]);
            	}

            // Xmu.g:6315:2: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt54=7;
            switch ( input.LA(1) ) {
            case 43:
                {
                int LA54_1 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA54_2 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA54_3 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (true) ) {
                    alt54=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA54_4 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (true) ) {
                    alt54=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 4, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                int LA54_5 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (true) ) {
                    alt54=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 5, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA54_6 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (true) ) {
                    alt54=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA54_7 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (true) ) {
                    alt54=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA54_8 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (true) ) {
                    alt54=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA54_9 = input.LA(2);

                if ( (synpred87_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred88_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred89_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=5;
                }
                else if ( (true) ) {
                    alt54=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // Xmu.g:6316:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6125);
                    a1_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a1_0, true);
                    				copyLocalizationInfos(a1_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:6335:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6139);
                    a1_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a1_1, true);
                    				copyLocalizationInfos(a1_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:6354:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6153);
                    a1_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a1_2, true);
                    				copyLocalizationInfos(a1_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:6373:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6167);
                    a1_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a1_3, true);
                    				copyLocalizationInfos(a1_3, element);
                    			}
                    		}

                    }
                    break;
                case 5 :
                    // Xmu.g:6392:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6181);
                    a1_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a1_4, true);
                    				copyLocalizationInfos(a1_4, element);
                    			}
                    		}

                    }
                    break;
                case 6 :
                    // Xmu.g:6411:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6195);
                    a1_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a1_5, true);
                    				copyLocalizationInfos(a1_5, element);
                    			}
                    		}

                    }
                    break;
                case 7 :
                    // Xmu.g:6430:6: a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6209);
                    a1_6=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a1_6, true);
                    				copyLocalizationInfos(a1_6, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[937]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[938]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[939]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[940]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[941]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[942]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[943]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 38, parse_edu_ustb_sei_mde_xmu_PrintStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_PrintStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Statement"
    // Xmu.g:6463:1: parse_edu_ustb_sei_mde_xmu_Statement returns [edu.ustb.sei.mde.xmu.Statement element = null] : (c0= parse_edu_ustb_sei_mde_xmu_ForStatement |c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement |c2= parse_edu_ustb_sei_mde_xmu_BlockStatement |c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement |c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement |c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern |c6= parse_edu_ustb_sei_mde_xmu_DeleteNode |c7= parse_edu_ustb_sei_mde_xmu_DeleteLink |c8= parse_edu_ustb_sei_mde_xmu_PrintStatement );
    public final edu.ustb.sei.mde.xmu.Statement parse_edu_ustb_sei_mde_xmu_Statement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Statement element =  null;

        int parse_edu_ustb_sei_mde_xmu_Statement_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.ForStatement c0 =null;

        edu.ustb.sei.mde.xmu.UpdatedStatement c1 =null;

        edu.ustb.sei.mde.xmu.BlockStatement c2 =null;

        edu.ustb.sei.mde.xmu.SwitchStatement c3 =null;

        edu.ustb.sei.mde.xmu.RuleCallStatement c4 =null;

        edu.ustb.sei.mde.xmu.UpdatePattern c5 =null;

        edu.ustb.sei.mde.xmu.DeleteNode c6 =null;

        edu.ustb.sei.mde.xmu.DeleteLink c7 =null;

        edu.ustb.sei.mde.xmu.PrintStatement c8 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return element; }

            // Xmu.g:6464:2: (c0= parse_edu_ustb_sei_mde_xmu_ForStatement |c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement |c2= parse_edu_ustb_sei_mde_xmu_BlockStatement |c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement |c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement |c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern |c6= parse_edu_ustb_sei_mde_xmu_DeleteNode |c7= parse_edu_ustb_sei_mde_xmu_DeleteLink |c8= parse_edu_ustb_sei_mde_xmu_PrintStatement )
            int alt55=9;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt55=1;
                }
                break;
            case 54:
                {
                alt55=2;
                }
                break;
            case 59:
                {
                alt55=3;
                }
                break;
            case 50:
                {
                alt55=4;
                }
                break;
            case NAME:
                {
                alt55=5;
                }
                break;
            case 39:
                {
                alt55=6;
                }
                break;
            case 38:
                {
                int LA55_7 = input.LA(2);

                if ( (LA55_7==NAME) ) {
                    int LA55_9 = input.LA(3);

                    if ( (LA55_9==EOF||LA55_9==26||LA55_9==36||LA55_9==41||(LA55_9 >= 51 && LA55_9 <= 52)||LA55_9==60) ) {
                        alt55=7;
                    }
                    else if ( (LA55_9==22) ) {
                        alt55=8;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 55, 9, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 7, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                alt55=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // Xmu.g:6465:2: c0= parse_edu_ustb_sei_mde_xmu_ForStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ForStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6238);
                    c0=parse_edu_ustb_sei_mde_xmu_ForStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6466:4: c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6248);
                    c1=parse_edu_ustb_sei_mde_xmu_UpdatedStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6467:4: c2= parse_edu_ustb_sei_mde_xmu_BlockStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BlockStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6258);
                    c2=parse_edu_ustb_sei_mde_xmu_BlockStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6468:4: c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_SwitchStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6268);
                    c3=parse_edu_ustb_sei_mde_xmu_SwitchStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6469:4: c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RuleCallStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6278);
                    c4=parse_edu_ustb_sei_mde_xmu_RuleCallStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6470:4: c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Statement6288);
                    c5=parse_edu_ustb_sei_mde_xmu_UpdatePattern();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6471:4: c6= parse_edu_ustb_sei_mde_xmu_DeleteNode
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteNode_in_parse_edu_ustb_sei_mde_xmu_Statement6298);
                    c6=parse_edu_ustb_sei_mde_xmu_DeleteNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Xmu.g:6472:4: c7= parse_edu_ustb_sei_mde_xmu_DeleteLink
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteLink_in_parse_edu_ustb_sei_mde_xmu_Statement6308);
                    c7=parse_edu_ustb_sei_mde_xmu_DeleteLink();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Xmu.g:6473:4: c8= parse_edu_ustb_sei_mde_xmu_PrintStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PrintStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6318);
                    c8=parse_edu_ustb_sei_mde_xmu_PrintStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 39, parse_edu_ustb_sei_mde_xmu_Statement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Statement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_AtomicExpr"
    // Xmu.g:6477:1: parse_edu_ustb_sei_mde_xmu_AtomicExpr returns [edu.ustb.sei.mde.xmu.AtomicExpr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_ParenExpr );
    public final edu.ustb.sei.mde.xmu.AtomicExpr parse_edu_ustb_sei_mde_xmu_AtomicExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AtomicExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_AtomicExpr_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.VariableExp c0 =null;

        edu.ustb.sei.mde.xmu.StringLiteral c1 =null;

        edu.ustb.sei.mde.xmu.EmptyLiteral c2 =null;

        edu.ustb.sei.mde.xmu.IntegerLiteral c3 =null;

        edu.ustb.sei.mde.xmu.BooleanLiteral c4 =null;

        edu.ustb.sei.mde.xmu.EnumLiteral c5 =null;

        edu.ustb.sei.mde.xmu.ParenExpr c6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }

            // Xmu.g:6478:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_ParenExpr )
            int alt56=7;
            switch ( input.LA(1) ) {
            case NAME:
                {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==EOF||(LA56_1 >= 16 && LA56_1 <= 23)||(LA56_1 >= 26 && LA56_1 <= 31)||(LA56_1 >= 33 && LA56_1 <= 34)||LA56_1==36||LA56_1==41||LA56_1==45||(LA56_1 >= 51 && LA56_1 <= 52)||LA56_1==60) ) {
                    alt56=1;
                }
                else if ( (LA56_1==25) ) {
                    alt56=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                alt56=2;
                }
                break;
            case 42:
            case 44:
                {
                alt56=3;
                }
                break;
            case NUMBER:
                {
                alt56=4;
                }
                break;
            case BOOLEAN:
                {
                alt56=5;
                }
                break;
            case 15:
                {
                alt56=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // Xmu.g:6479:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6339);
                    c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6480:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6349);
                    c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6481:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6359);
                    c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6482:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6369);
                    c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6483:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6379);
                    c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6484:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6389);
                    c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6485:4: c6= parse_edu_ustb_sei_mde_xmu_ParenExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6399);
                    c6=parse_edu_ustb_sei_mde_xmu_ParenExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 40, parse_edu_ustb_sei_mde_xmu_AtomicExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_AtomicExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_PatternExpr"
    // Xmu.g:6489:1: parse_edu_ustb_sei_mde_xmu_PatternExpr returns [edu.ustb.sei.mde.xmu.PatternExpr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr |c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr );
    public final edu.ustb.sei.mde.xmu.PatternExpr parse_edu_ustb_sei_mde_xmu_PatternExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_PatternExpr_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.PatternReferenceExpr c0 =null;

        edu.ustb.sei.mde.xmu.PatternEqualExpr c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return element; }

            // Xmu.g:6490:2: (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr |c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==NAME) ) {
                int LA57_1 = input.LA(2);

                if ( (synpred107_Xmu()) ) {
                    alt57=1;
                }
                else if ( (true) ) {
                    alt57=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }
            switch (alt57) {
                case 1 :
                    // Xmu.g:6491:2: c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6420);
                    c0=parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6492:4: c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6430);
                    c1=parse_edu_ustb_sei_mde_xmu_PatternEqualExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 41, parse_edu_ustb_sei_mde_xmu_PatternExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_PatternExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Path"
    // Xmu.g:6496:1: parse_edu_ustb_sei_mde_xmu_Path returns [edu.ustb.sei.mde.xmu.Path element = null] : (c0= parse_edu_ustb_sei_mde_xmu_FeaturePath |c1= parse_edu_ustb_sei_mde_xmu_OperationPath );
    public final edu.ustb.sei.mde.xmu.Path parse_edu_ustb_sei_mde_xmu_Path() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Path element =  null;

        int parse_edu_ustb_sei_mde_xmu_Path_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.FeaturePath c0 =null;

        edu.ustb.sei.mde.xmu.OperationPath c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return element; }

            // Xmu.g:6497:2: (c0= parse_edu_ustb_sei_mde_xmu_FeaturePath |c1= parse_edu_ustb_sei_mde_xmu_OperationPath )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==NAME) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==EOF||(LA58_1 >= 16 && LA58_1 <= 23)||(LA58_1 >= 26 && LA58_1 <= 31)||(LA58_1 >= 33 && LA58_1 <= 34)||LA58_1==36||LA58_1==41||LA58_1==45||(LA58_1 >= 51 && LA58_1 <= 52)||LA58_1==60) ) {
                    alt58=1;
                }
                else if ( (LA58_1==15) ) {
                    alt58=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }
            switch (alt58) {
                case 1 :
                    // Xmu.g:6498:2: c0= parse_edu_ustb_sei_mde_xmu_FeaturePath
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_FeaturePath_in_parse_edu_ustb_sei_mde_xmu_Path6451);
                    c0=parse_edu_ustb_sei_mde_xmu_FeaturePath();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6499:4: c1= parse_edu_ustb_sei_mde_xmu_OperationPath
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_OperationPath_in_parse_edu_ustb_sei_mde_xmu_Path6461);
                    c1=parse_edu_ustb_sei_mde_xmu_OperationPath();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 42, parse_edu_ustb_sei_mde_xmu_Path_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Path"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Expr"
    // Xmu.g:6503:1: parse_edu_ustb_sei_mde_xmu_Expr returns [edu.ustb.sei.mde.xmu.Expr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr |c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |c11= parse_edu_ustb_sei_mde_xmu_ParenExpr |c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr );
    public final edu.ustb.sei.mde.xmu.Expr parse_edu_ustb_sei_mde_xmu_Expr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Expr element =  null;

        int parse_edu_ustb_sei_mde_xmu_Expr_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.VariableExp c0 =null;

        edu.ustb.sei.mde.xmu.StringLiteral c1 =null;

        edu.ustb.sei.mde.xmu.EmptyLiteral c2 =null;

        edu.ustb.sei.mde.xmu.IntegerLiteral c3 =null;

        edu.ustb.sei.mde.xmu.BooleanLiteral c4 =null;

        edu.ustb.sei.mde.xmu.EnumLiteral c5 =null;

        edu.ustb.sei.mde.xmu.BooleanOrExpr c6 =null;

        edu.ustb.sei.mde.xmu.BooleanAndExpr c7 =null;

        edu.ustb.sei.mde.xmu.RelationalExpr c8 =null;

        edu.ustb.sei.mde.xmu.AdditiveExpr c9 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr c10 =null;

        edu.ustb.sei.mde.xmu.ParenExpr c11 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr c12 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return element; }

            // Xmu.g:6504:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr |c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |c11= parse_edu_ustb_sei_mde_xmu_ParenExpr |c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
            int alt59=13;
            switch ( input.LA(1) ) {
            case NAME:
                {
                int LA59_1 = input.LA(2);

                if ( (synpred109_Xmu()) ) {
                    alt59=1;
                }
                else if ( (synpred114_Xmu()) ) {
                    alt59=6;
                }
                else if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA59_2 = input.LA(2);

                if ( (synpred110_Xmu()) ) {
                    alt59=2;
                }
                else if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 2, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                int LA59_3 = input.LA(2);

                if ( (synpred111_Xmu()) ) {
                    alt59=3;
                }
                else if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 3, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA59_4 = input.LA(2);

                if ( (synpred111_Xmu()) ) {
                    alt59=3;
                }
                else if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 4, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA59_5 = input.LA(2);

                if ( (synpred112_Xmu()) ) {
                    alt59=4;
                }
                else if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 5, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA59_6 = input.LA(2);

                if ( (synpred113_Xmu()) ) {
                    alt59=5;
                }
                else if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 6, input);

                    throw nvae;

                }
                }
                break;
            case 43:
                {
                int LA59_7 = input.LA(2);

                if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else if ( (true) ) {
                    alt59=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 7, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA59_8 = input.LA(2);

                if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else if ( (true) ) {
                    alt59=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA59_9 = input.LA(2);

                if ( (synpred115_Xmu()) ) {
                    alt59=7;
                }
                else if ( (synpred116_Xmu()) ) {
                    alt59=8;
                }
                else if ( (synpred117_Xmu()) ) {
                    alt59=9;
                }
                else if ( (synpred118_Xmu()) ) {
                    alt59=10;
                }
                else if ( (synpred119_Xmu()) ) {
                    alt59=11;
                }
                else if ( (synpred120_Xmu()) ) {
                    alt59=12;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }

            switch (alt59) {
                case 1 :
                    // Xmu.g:6505:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_Expr6482);
                    c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6506:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6492);
                    c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6507:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6502);
                    c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6508:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6512);
                    c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6509:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6522);
                    c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6510:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6532);
                    c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6511:4: c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6542);
                    c6=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Xmu.g:6512:4: c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6552);
                    c7=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Xmu.g:6513:4: c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6562);
                    c8=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Xmu.g:6514:4: c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6572);
                    c9=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 11 :
                    // Xmu.g:6515:4: c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6582);
                    c10=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c10; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 12 :
                    // Xmu.g:6516:4: c11= parse_edu_ustb_sei_mde_xmu_ParenExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6592);
                    c11=parse_edu_ustb_sei_mde_xmu_ParenExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c11; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 13 :
                    // Xmu.g:6517:4: c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6602);
                    c12=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c12; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 43, parse_edu_ustb_sei_mde_xmu_Expr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Expr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_CaseSubStatement"
    // Xmu.g:6521:1: parse_edu_ustb_sei_mde_xmu_CaseSubStatement returns [edu.ustb.sei.mde.xmu.CaseSubStatement element = null] : (c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement |c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement );
    public final edu.ustb.sei.mde.xmu.CaseSubStatement parse_edu_ustb_sei_mde_xmu_CaseSubStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CaseSubStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CaseSubStatement_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.CasePatternStatement c0 =null;

        edu.ustb.sei.mde.xmu.CaseValueStatement c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return element; }

            // Xmu.g:6522:2: (c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement |c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==36) ) {
                switch ( input.LA(2) ) {
                case NAME:
                    {
                    int LA60_2 = input.LA(3);

                    if ( (LA60_2==24) ) {
                        alt60=1;
                    }
                    else if ( ((LA60_2 >= 17 && LA60_2 <= 18)||(LA60_2 >= 20 && LA60_2 <= 23)||LA60_2==25||(LA60_2 >= 27 && LA60_2 <= 31)||LA60_2==34||LA60_2==45) ) {
                        alt60=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 2, input);

                        throw nvae;

                    }
                    }
                    break;
                case 39:
                    {
                    alt60=1;
                    }
                    break;
                case BOOLEAN:
                case NUMBER:
                case QUOTED_39_39_92:
                case 15:
                case 20:
                case 42:
                case 43:
                case 44:
                    {
                    alt60=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // Xmu.g:6523:2: c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CasePatternStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement6623);
                    c0=parse_edu_ustb_sei_mde_xmu_CasePatternStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6524:4: c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseValueStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement6633);
                    c1=parse_edu_ustb_sei_mde_xmu_CaseValueStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 44, parse_edu_ustb_sei_mde_xmu_CaseSubStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_CaseSubStatement"

    // $ANTLR start synpred17_Xmu
    public final void synpred17_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VStatement a11_0 =null;


        // Xmu.g:1897:6: ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )
        // Xmu.g:1897:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
        {
        // Xmu.g:1897:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
        // Xmu.g:1898:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
        {
        // Xmu.g:1898:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
        // Xmu.g:1899:8: a11_0= parse_edu_ustb_sei_mde_xmu_VStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred17_Xmu1741);
        a11_0=parse_edu_ustb_sei_mde_xmu_VStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }

    }
    // $ANTLR end synpred17_Xmu

    // $ANTLR start synpred18_Xmu
    public final void synpred18_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VStatement a10_0 =null;

        edu.ustb.sei.mde.xmu.VStatement a11_0 =null;


        // Xmu.g:1863:4: ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )
        // Xmu.g:1863:4: ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? )
        {
        // Xmu.g:1863:4: ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? )
        // Xmu.g:1864:5: (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )?
        {
        // Xmu.g:1864:5: (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement )
        // Xmu.g:1865:6: a10_0= parse_edu_ustb_sei_mde_xmu_VStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1684);
        a10_0=parse_edu_ustb_sei_mde_xmu_VStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        // Xmu.g:1896:5: ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )?
        int alt66=2;
        int LA66_0 = input.LA(1);

        if ( (LA66_0==41||(LA66_0 >= 51 && LA66_0 <= 52)) ) {
            alt66=1;
        }
        switch (alt66) {
            case 1 :
                // Xmu.g:1897:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
                {
                // Xmu.g:1897:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
                // Xmu.g:1898:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                {
                // Xmu.g:1898:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                // Xmu.g:1899:8: a11_0= parse_edu_ustb_sei_mde_xmu_VStatement
                {
                pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1741);
                a11_0=parse_edu_ustb_sei_mde_xmu_VStatement();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }

    }
    // $ANTLR end synpred18_Xmu

    // $ANTLR start synpred21_Xmu
    public final void synpred21_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a2_0 =null;


        // Xmu.g:2283:5: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:2283:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred21_Xmu2141);
        a2_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred21_Xmu

    // $ANTLR start synpred22_Xmu
    public final void synpred22_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a2_1 =null;


        // Xmu.g:2302:10: (a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:2302:10: a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred22_Xmu2161);
        a2_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred22_Xmu

    // $ANTLR start synpred23_Xmu
    public final void synpred23_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a2_2 =null;


        // Xmu.g:2321:10: (a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:2321:10: a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred23_Xmu2181);
        a2_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred23_Xmu

    // $ANTLR start synpred24_Xmu
    public final void synpred24_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a2_3 =null;


        // Xmu.g:2340:10: (a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:2340:10: a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred24_Xmu2201);
        a2_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred24_Xmu

    // $ANTLR start synpred25_Xmu
    public final void synpred25_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a2_4 =null;


        // Xmu.g:2359:10: (a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:2359:10: a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred25_Xmu2221);
        a2_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred25_Xmu

    // $ANTLR start synpred26_Xmu
    public final void synpred26_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a2_5 =null;


        // Xmu.g:2378:10: (a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:2378:10: a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred26_Xmu2241);
        a2_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred26_Xmu

    // $ANTLR start synpred44_Xmu
    public final void synpred44_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a0_0 =null;


        // Xmu.g:4837:3: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:4837:3: a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred44_Xmu4769);
        a0_0=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred44_Xmu

    // $ANTLR start synpred45_Xmu
    public final void synpred45_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a0_1 =null;


        // Xmu.g:4856:6: (a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:4856:6: a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred45_Xmu4783);
        a0_1=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred45_Xmu

    // $ANTLR start synpred46_Xmu
    public final void synpred46_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_2 =null;


        // Xmu.g:4875:6: (a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:4875:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred46_Xmu4797);
        a0_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred46_Xmu

    // $ANTLR start synpred47_Xmu
    public final void synpred47_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a2_0 =null;


        // Xmu.g:4943:5: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:4943:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred47_Xmu4864);
        a2_0=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred47_Xmu

    // $ANTLR start synpred48_Xmu
    public final void synpred48_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a2_1 =null;


        // Xmu.g:4962:10: (a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:4962:10: a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred48_Xmu4884);
        a2_1=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred48_Xmu

    // $ANTLR start synpred49_Xmu
    public final void synpred49_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a2_2 =null;


        // Xmu.g:4981:10: (a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:4981:10: a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred49_Xmu4904);
        a2_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred49_Xmu

    // $ANTLR start synpred51_Xmu
    public final void synpred51_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a0_0 =null;


        // Xmu.g:5067:3: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5067:3: a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred51_Xmu4984);
        a0_0=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred51_Xmu

    // $ANTLR start synpred52_Xmu
    public final void synpred52_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a0_1 =null;


        // Xmu.g:5086:6: (a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5086:6: a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred52_Xmu4998);
        a0_1=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred52_Xmu

    // $ANTLR start synpred53_Xmu
    public final void synpred53_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_2 =null;


        // Xmu.g:5105:6: (a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5105:6: a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred53_Xmu5012);
        a0_2=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred53_Xmu

    // $ANTLR start synpred54_Xmu
    public final void synpred54_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_3 =null;


        // Xmu.g:5124:6: (a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5124:6: a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred54_Xmu5026);
        a0_3=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred54_Xmu

    // $ANTLR start synpred55_Xmu
    public final void synpred55_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a2_0 =null;


        // Xmu.g:5192:5: (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5192:5: a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred55_Xmu5093);
        a2_0=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred55_Xmu

    // $ANTLR start synpred56_Xmu
    public final void synpred56_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a2_1 =null;


        // Xmu.g:5211:10: (a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5211:10: a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred56_Xmu5113);
        a2_1=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred56_Xmu

    // $ANTLR start synpred57_Xmu
    public final void synpred57_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a2_2 =null;


        // Xmu.g:5230:10: (a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5230:10: a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred57_Xmu5133);
        a2_2=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred57_Xmu

    // $ANTLR start synpred58_Xmu
    public final void synpred58_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a2_3 =null;


        // Xmu.g:5249:10: (a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5249:10: a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred58_Xmu5153);
        a2_3=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred58_Xmu

    // $ANTLR start synpred60_Xmu
    public final void synpred60_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a0_0 =null;


        // Xmu.g:5337:3: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5337:3: a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred60_Xmu5233);
        a0_0=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred60_Xmu

    // $ANTLR start synpred61_Xmu
    public final void synpred61_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_1 =null;


        // Xmu.g:5356:6: (a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5356:6: a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred61_Xmu5247);
        a0_1=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred61_Xmu

    // $ANTLR start synpred62_Xmu
    public final void synpred62_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_2 =null;


        // Xmu.g:5375:6: (a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5375:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred62_Xmu5261);
        a0_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred62_Xmu

    // $ANTLR start synpred67_Xmu
    public final void synpred67_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a8_0 =null;


        // Xmu.g:5501:3: (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5501:3: a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred67_Xmu5387);
        a8_0=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred67_Xmu

    // $ANTLR start synpred68_Xmu
    public final void synpred68_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a8_1 =null;


        // Xmu.g:5520:6: (a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5520:6: a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred68_Xmu5401);
        a8_1=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred68_Xmu

    // $ANTLR start synpred69_Xmu
    public final void synpred69_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a8_2 =null;


        // Xmu.g:5539:6: (a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5539:6: a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred69_Xmu5415);
        a8_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred69_Xmu

    // $ANTLR start synpred70_Xmu
    public final void synpred70_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_0 =null;


        // Xmu.g:5605:3: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5605:3: a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred70_Xmu5466);
        a0_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred70_Xmu

    // $ANTLR start synpred71_Xmu
    public final void synpred71_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_1 =null;


        // Xmu.g:5624:6: (a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5624:6: a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred71_Xmu5480);
        a0_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred71_Xmu

    // $ANTLR start synpred73_Xmu
    public final void synpred73_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a5_0 =null;


        // Xmu.g:5713:5: (a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5713:5: a5_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred73_Xmu5590);
        a5_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred73_Xmu

    // $ANTLR start synpred74_Xmu
    public final void synpred74_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a5_1 =null;


        // Xmu.g:5732:10: (a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5732:10: a5_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred74_Xmu5610);
        a5_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred74_Xmu

    // $ANTLR start synpred80_Xmu
    public final void synpred80_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a1_0 =null;


        // Xmu.g:6024:3: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6024:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred80_Xmu5894);
        a1_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred80_Xmu

    // $ANTLR start synpred81_Xmu
    public final void synpred81_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a1_1 =null;


        // Xmu.g:6043:6: (a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6043:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred81_Xmu5908);
        a1_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred81_Xmu

    // $ANTLR start synpred82_Xmu
    public final void synpred82_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a1_2 =null;


        // Xmu.g:6062:6: (a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6062:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred82_Xmu5922);
        a1_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred82_Xmu

    // $ANTLR start synpred83_Xmu
    public final void synpred83_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a1_3 =null;


        // Xmu.g:6081:6: (a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6081:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred83_Xmu5936);
        a1_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred83_Xmu

    // $ANTLR start synpred84_Xmu
    public final void synpred84_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a1_4 =null;


        // Xmu.g:6100:6: (a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6100:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred84_Xmu5950);
        a1_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred84_Xmu

    // $ANTLR start synpred85_Xmu
    public final void synpred85_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a1_5 =null;


        // Xmu.g:6119:6: (a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6119:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred85_Xmu5964);
        a1_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred85_Xmu

    // $ANTLR start synpred87_Xmu
    public final void synpred87_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a1_0 =null;


        // Xmu.g:6316:3: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6316:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred87_Xmu6125);
        a1_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred87_Xmu

    // $ANTLR start synpred88_Xmu
    public final void synpred88_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a1_1 =null;


        // Xmu.g:6335:6: (a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6335:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred88_Xmu6139);
        a1_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred88_Xmu

    // $ANTLR start synpred89_Xmu
    public final void synpred89_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a1_2 =null;


        // Xmu.g:6354:6: (a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6354:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred89_Xmu6153);
        a1_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred89_Xmu

    // $ANTLR start synpred90_Xmu
    public final void synpred90_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a1_3 =null;


        // Xmu.g:6373:6: (a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6373:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred90_Xmu6167);
        a1_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred90_Xmu

    // $ANTLR start synpred91_Xmu
    public final void synpred91_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a1_4 =null;


        // Xmu.g:6392:6: (a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6392:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred91_Xmu6181);
        a1_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred91_Xmu

    // $ANTLR start synpred92_Xmu
    public final void synpred92_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a1_5 =null;


        // Xmu.g:6411:6: (a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6411:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred92_Xmu6195);
        a1_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred92_Xmu

    // $ANTLR start synpred107_Xmu
    public final void synpred107_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternReferenceExpr c0 =null;


        // Xmu.g:6491:2: (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr )
        // Xmu.g:6491:2: c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_synpred107_Xmu6420);
        c0=parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred107_Xmu

    // $ANTLR start synpred109_Xmu
    public final void synpred109_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VariableExp c0 =null;


        // Xmu.g:6505:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp )
        // Xmu.g:6505:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_synpred109_Xmu6482);
        c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred109_Xmu

    // $ANTLR start synpred110_Xmu
    public final void synpred110_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.StringLiteral c1 =null;


        // Xmu.g:6506:4: (c1= parse_edu_ustb_sei_mde_xmu_StringLiteral )
        // Xmu.g:6506:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_synpred110_Xmu6492);
        c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred110_Xmu

    // $ANTLR start synpred111_Xmu
    public final void synpred111_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EmptyLiteral c2 =null;


        // Xmu.g:6507:4: (c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral )
        // Xmu.g:6507:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_synpred111_Xmu6502);
        c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred111_Xmu

    // $ANTLR start synpred112_Xmu
    public final void synpred112_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.IntegerLiteral c3 =null;


        // Xmu.g:6508:4: (c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral )
        // Xmu.g:6508:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_synpred112_Xmu6512);
        c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred112_Xmu

    // $ANTLR start synpred113_Xmu
    public final void synpred113_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanLiteral c4 =null;


        // Xmu.g:6509:4: (c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral )
        // Xmu.g:6509:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_synpred113_Xmu6522);
        c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred113_Xmu

    // $ANTLR start synpred114_Xmu
    public final void synpred114_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EnumLiteral c5 =null;


        // Xmu.g:6510:4: (c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral )
        // Xmu.g:6510:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_synpred114_Xmu6532);
        c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred114_Xmu

    // $ANTLR start synpred115_Xmu
    public final void synpred115_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr c6 =null;


        // Xmu.g:6511:4: (c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6511:4: c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred115_Xmu6542);
        c6=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred115_Xmu

    // $ANTLR start synpred116_Xmu
    public final void synpred116_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr c7 =null;


        // Xmu.g:6512:4: (c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6512:4: c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred116_Xmu6552);
        c7=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred116_Xmu

    // $ANTLR start synpred117_Xmu
    public final void synpred117_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr c8 =null;


        // Xmu.g:6513:4: (c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6513:4: c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred117_Xmu6562);
        c8=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred117_Xmu

    // $ANTLR start synpred118_Xmu
    public final void synpred118_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr c9 =null;


        // Xmu.g:6514:4: (c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6514:4: c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred118_Xmu6572);
        c9=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred118_Xmu

    // $ANTLR start synpred119_Xmu
    public final void synpred119_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr c10 =null;


        // Xmu.g:6515:4: (c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6515:4: c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred119_Xmu6582);
        c10=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_Xmu

    // $ANTLR start synpred120_Xmu
    public final void synpred120_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.ParenExpr c11 =null;


        // Xmu.g:6516:4: (c11= parse_edu_ustb_sei_mde_xmu_ParenExpr )
        // Xmu.g:6516:4: c11= parse_edu_ustb_sei_mde_xmu_ParenExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_synpred120_Xmu6592);
        c11=parse_edu_ustb_sei_mde_xmu_ParenExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred120_Xmu

    // Delegated rules

    public final boolean synpred21_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred81_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred73_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred73_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred82_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred74_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred74_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred118_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred111_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_XMUModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_XMUModel124 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_URI_in_parse_edu_ustb_sei_mde_xmu_XMUModel150 = new BitSet(new long[]{0x0002010000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StartStatement_in_parse_edu_ustb_sei_mde_xmu_XMUModel205 = new BitSet(new long[]{0x0002800000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Rule_in_parse_edu_ustb_sei_mde_xmu_XMUModel240 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_49_in_parse_edu_ustb_sei_mde_xmu_StartStatement281 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_StartStatement299 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_StartStatement320 = new BitSet(new long[]{0x0101002000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_StartStatement338 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_StartStatement365 = new BitSet(new long[]{0x0101002000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_StartStatement391 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_StartStatement432 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_StartStatement446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_parse_edu_ustb_sei_mde_xmu_StartRoot484 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_56_in_parse_edu_ustb_sei_mde_xmu_StartRoot499 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_37_in_parse_edu_ustb_sei_mde_xmu_StartRoot514 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_StartRoot535 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_StartRoot553 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_StartRoot574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_parse_edu_ustb_sei_mde_xmu_Rule603 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_Rule621 = new BitSet(new long[]{0x0800000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_Rule651 = new BitSet(new long[]{0x0101002000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Parameter_in_parse_edu_ustb_sei_mde_xmu_Rule677 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_Rule718 = new BitSet(new long[]{0x0101002000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Parameter_in_parse_edu_ustb_sei_mde_xmu_Rule752 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_Rule813 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_Rule846 = new BitSet(new long[]{0x08E440C000000080L});
    public static final BitSet FOLLOW_55_in_parse_edu_ustb_sei_mde_xmu_Rule869 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Rule895 = new BitSet(new long[]{0x086440C000080080L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_Rule936 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Rule970 = new BitSet(new long[]{0x086440C000080080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_Rule1048 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_Rule1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_parse_edu_ustb_sei_mde_xmu_Parameter1104 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_56_in_parse_edu_ustb_sei_mde_xmu_Parameter1119 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_37_in_parse_edu_ustb_sei_mde_xmu_Parameter1134 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_Parameter1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIMITIVE_in_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable1199 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_parse_edu_ustb_sei_mde_xmu_ForStatement1260 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_ForStatement1278 = new BitSet(new long[]{0x0400000800000000L});
    public static final BitSet FOLLOW_58_in_parse_edu_ustb_sei_mde_xmu_ForStatement1305 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_ForStatement1331 = new BitSet(new long[]{0x0200000800000000L});
    public static final BitSet FOLLOW_57_in_parse_edu_ustb_sei_mde_xmu_ForStatement1372 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1406 = new BitSet(new long[]{0x0000000804000000L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_ForStatement1461 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1503 = new BitSet(new long[]{0x0000000804000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_ForStatement1620 = new BitSet(new long[]{0x0018020000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1643 = new BitSet(new long[]{0x0018020000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1684 = new BitSet(new long[]{0x0018020000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1852 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1866 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1884 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1905 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1923 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_edu_ustb_sei_mde_xmu_VStatement1982 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_52_in_parse_edu_ustb_sei_mde_xmu_VStatement1997 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_51_in_parse_edu_ustb_sei_mde_xmu_VStatement2012 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_VStatement2033 = new BitSet(new long[]{0x086440C000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_VStatement2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_Pattern2088 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_Pattern2115 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2141 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2161 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2181 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2201 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2221 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2241 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2261 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_Pattern2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Pattern2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2356 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_xmu_PatternNode2377 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2395 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_PatternNode2416 = new BitSet(new long[]{0x1000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2445 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_PatternNode2486 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2520 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_PatternNode2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2627 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2657 = new BitSet(new long[]{0x0000140000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2683 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2711 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2744 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2799 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2829 = new BitSet(new long[]{0x0000140000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2855 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2883 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2916 = new BitSet(new long[]{0x0000140000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_VariableExp2971 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_VariableExp3001 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Path_in_parse_edu_ustb_sei_mde_xmu_VariableExp3027 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_OperationPath3127 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_OperationPath3148 = new BitSet(new long[]{0x00001C0000118590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3177 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_OperationPath3218 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3252 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_OperationPath3326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_xmu_StringLiteral3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_IntegerLiteral3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_parse_edu_ustb_sei_mde_xmu_BooleanLiteral3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3539 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3560 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3614 = new BitSet(new long[]{0x186440C000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3643 = new BitSet(new long[]{0x1000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3684 = new BitSet(new long[]{0x086440C000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3718 = new BitSet(new long[]{0x1000000004000000L});
    public static final BitSet FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3821 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3839 = new BitSet(new long[]{0x0A00000000000000L});
    public static final BitSet FOLLOW_57_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3869 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3895 = new BitSet(new long[]{0x0800000004000000L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3936 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement3970 = new BitSet(new long[]{0x0800000004000000L});
    public static final BitSet FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4044 = new BitSet(new long[]{0x1000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseSubStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4067 = new BitSet(new long[]{0x1000001000000000L});
    public static final BitSet FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4122 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4140 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4158 = new BitSet(new long[]{0x086440C000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4209 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4227 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4245 = new BitSet(new long[]{0x086440C000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4300 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4321 = new BitSet(new long[]{0x00001C0000118590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4350 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4391 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4425 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4528 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4579 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4633 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4651 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4672 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4690 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4711 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4769 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4783 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4797 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4811 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4838 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4864 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4884 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4904 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr4924 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr4984 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr4998 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5012 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5026 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5040 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5067 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5093 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5113 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5133 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5153 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5173 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5233 = new BitSet(new long[]{0x00000000F8000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5247 = new BitSet(new long[]{0x00000000F8000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5261 = new BitSet(new long[]{0x00000000F8000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5275 = new BitSet(new long[]{0x00000000F8000000L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5302 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_27_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5317 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5332 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_30_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5347 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5362 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5466 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5480 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5494 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5534 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5553 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5590 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5610 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5630 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5690 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5704 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_17_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5744 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5763 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5800 = new BitSet(new long[]{0x0000000000820002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5820 = new BitSet(new long[]{0x0000000000820002L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5876 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5894 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5908 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5922 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5936 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5950 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5964 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5978 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_ParenExpr5996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6034 = new BitSet(new long[]{0x0000140000008590L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6049 = new BitSet(new long[]{0x0000140000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6107 = new BitSet(new long[]{0x00001C0000108590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ForStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BlockStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_SwitchStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RuleCallStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Statement6288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteNode_in_parse_edu_ustb_sei_mde_xmu_Statement6298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteLink_in_parse_edu_ustb_sei_mde_xmu_Statement6308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrintStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_FeaturePath_in_parse_edu_ustb_sei_mde_xmu_Path6451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_OperationPath_in_parse_edu_ustb_sei_mde_xmu_Path6461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_Expr6482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CasePatternStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement6623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseValueStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement6633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred17_Xmu1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1684 = new BitSet(new long[]{0x0018020000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred21_Xmu2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred22_Xmu2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred23_Xmu2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred24_Xmu2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred25_Xmu2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred26_Xmu2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred44_Xmu4769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred45_Xmu4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred46_Xmu4797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred47_Xmu4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred48_Xmu4884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred49_Xmu4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred51_Xmu4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred52_Xmu4998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred53_Xmu5012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred54_Xmu5026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred55_Xmu5093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred56_Xmu5113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred57_Xmu5133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred58_Xmu5153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred60_Xmu5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred61_Xmu5247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred62_Xmu5261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred67_Xmu5387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred68_Xmu5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred69_Xmu5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred70_Xmu5466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred71_Xmu5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred73_Xmu5590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred74_Xmu5610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred80_Xmu5894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred81_Xmu5908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred82_Xmu5922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred83_Xmu5936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred84_Xmu5950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred85_Xmu5964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred87_Xmu6125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred88_Xmu6139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred89_Xmu6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred90_Xmu6167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred91_Xmu6181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred92_Xmu6195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_synpred107_Xmu6420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_synpred109_Xmu6482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_synpred110_Xmu6492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_synpred111_Xmu6502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_synpred112_Xmu6512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_synpred113_Xmu6522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_synpred114_Xmu6532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred115_Xmu6542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred116_Xmu6552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred117_Xmu6562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred118_Xmu6572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred119_Xmu6582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_synpred120_Xmu6592 = new BitSet(new long[]{0x0000000000000002L});

}