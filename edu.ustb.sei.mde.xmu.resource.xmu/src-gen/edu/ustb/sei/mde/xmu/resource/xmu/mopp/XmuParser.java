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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "LINEBREAK", "ML_COMMENT", "NAME", "NUMBER", "PRIMITIVE", "QUOTED_39_39_92", "SL_COMMENT", "TEXT", "URI", "WHITESPACE", "'('", "')'", "'*'", "'+'", "'++'", "','", "'-'", "'->'", "'.'", "'/'", "'//'", "':'", "'::'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'['", "']'", "'and'", "'by'", "'case'", "'context'", "'delete'", "'enforce'", "'exists'", "'forAll'", "'import'", "'match'", "'nil'", "'not'", "'null'", "'or'", "'print'", "'rule'", "'select'", "'source'", "'start'", "'switch'", "'unmatchs'", "'unmatchv'", "'update'", "'updated'", "'using'", "'view'", "'when'", "'with'", "'{'", "'|'", "'}'"
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
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
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
        this.state.initializeRuleMemo(179 + 1);
         

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
    		int followSetID = 198;
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
    // Xmu.g:613:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_edu_ustb_sei_mde_xmu_XMUModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.XMUModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Xmu.g:614:2: ( (c0= parse_edu_ustb_sei_mde_xmu_XMUModel ) EOF )
            // Xmu.g:615:2: (c0= parse_edu_ustb_sei_mde_xmu_XMUModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Xmu.g:621:2: (c0= parse_edu_ustb_sei_mde_xmu_XMUModel )
            // Xmu.g:622:3: c0= parse_edu_ustb_sei_mde_xmu_XMUModel
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
    // Xmu.g:630:1: parse_edu_ustb_sei_mde_xmu_XMUModel returns [edu.ustb.sei.mde.xmu.XMUModel element = null] : ( (a0= 'import' (a1= URI ) ) )* ( (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement ) )+ ( (a3_0= parse_edu_ustb_sei_mde_xmu_Rule ) )* ;
    public final edu.ustb.sei.mde.xmu.XMUModel parse_edu_ustb_sei_mde_xmu_XMUModel() throws RecognitionException {
        edu.ustb.sei.mde.xmu.XMUModel element =  null;

        int parse_edu_ustb_sei_mde_xmu_XMUModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.xmu.StartStatement a2_0 =null;

        edu.ustb.sei.mde.xmu.Rule a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Xmu.g:633:2: ( ( (a0= 'import' (a1= URI ) ) )* ( (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement ) )+ ( (a3_0= parse_edu_ustb_sei_mde_xmu_Rule ) )* )
            // Xmu.g:634:2: ( (a0= 'import' (a1= URI ) ) )* ( (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement ) )+ ( (a3_0= parse_edu_ustb_sei_mde_xmu_Rule ) )*
            {
            // Xmu.g:634:2: ( (a0= 'import' (a1= URI ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==44) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Xmu.g:635:3: (a0= 'import' (a1= URI ) )
            	    {
            	    // Xmu.g:635:3: (a0= 'import' (a1= URI ) )
            	    // Xmu.g:636:4: a0= 'import' (a1= URI )
            	    {
            	    a0=(Token)match(input,44,FOLLOW_44_in_parse_edu_ustb_sei_mde_xmu_XMUModel124); if (state.failed) return element;

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

            	    // Xmu.g:650:4: (a1= URI )
            	    // Xmu.g:651:5: a1= URI
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

            // Xmu.g:699:2: ( (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==54) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Xmu.g:700:3: (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement )
            	    {
            	    // Xmu.g:700:3: (a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement )
            	    // Xmu.g:701:4: a2_0= parse_edu_ustb_sei_mde_xmu_StartStatement
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

            // Xmu.g:728:2: ( (a3_0= parse_edu_ustb_sei_mde_xmu_Rule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==51) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Xmu.g:729:3: (a3_0= parse_edu_ustb_sei_mde_xmu_Rule )
            	    {
            	    // Xmu.g:729:3: (a3_0= parse_edu_ustb_sei_mde_xmu_Rule )
            	    // Xmu.g:730:4: a3_0= parse_edu_ustb_sei_mde_xmu_Rule
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
    // Xmu.g:758:1: parse_edu_ustb_sei_mde_xmu_StartStatement returns [edu.ustb.sei.mde.xmu.StartStatement element = null] : a0= 'start' (a1= NAME ) a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ) )* a6= ')' a7= ';' ;
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

            // Xmu.g:761:2: (a0= 'start' (a1= NAME ) a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ) )* a6= ')' a7= ';' )
            // Xmu.g:762:2: a0= 'start' (a1= NAME ) a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ) )* a6= ')' a7= ';'
            {
            a0=(Token)match(input,54,FOLLOW_54_in_parse_edu_ustb_sei_mde_xmu_StartStatement281); if (state.failed) return element;

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

            // Xmu.g:776:2: (a1= NAME )
            // Xmu.g:777:3: a1= NAME
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

            // Xmu.g:830:2: (a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot )
            // Xmu.g:831:3: a3_0= parse_edu_ustb_sei_mde_xmu_StartRoot
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

            // Xmu.g:857:2: ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Xmu.g:858:3: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) )
            	    {
            	    // Xmu.g:858:3: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) )
            	    // Xmu.g:859:4: a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot )
            	    {
            	    a4=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_StartStatement365); if (state.failed) return element;

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

            	    // Xmu.g:873:4: (a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot )
            	    // Xmu.g:874:5: a5_0= parse_edu_ustb_sei_mde_xmu_StartRoot
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

            a7=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_StartStatement446); if (state.failed) return element;

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
    // Xmu.g:939:1: parse_edu_ustb_sei_mde_xmu_StartRoot returns [edu.ustb.sei.mde.xmu.StartRoot element = null] : ( (a0= 'source' |a1= 'view' |a2= 'context' ) ) a5= '[' (a6= NUMBER ) a7= ']' ;
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

            // Xmu.g:942:2: ( ( (a0= 'source' |a1= 'view' |a2= 'context' ) ) a5= '[' (a6= NUMBER ) a7= ']' )
            // Xmu.g:943:2: ( (a0= 'source' |a1= 'view' |a2= 'context' ) ) a5= '[' (a6= NUMBER ) a7= ']'
            {
            // Xmu.g:943:2: ( (a0= 'source' |a1= 'view' |a2= 'context' ) )
            // Xmu.g:944:3: (a0= 'source' |a1= 'view' |a2= 'context' )
            {
            // Xmu.g:944:3: (a0= 'source' |a1= 'view' |a2= 'context' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt5=1;
                }
                break;
            case 61:
                {
                alt5=2;
                }
                break;
            case 39:
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
                    // Xmu.g:945:4: a0= 'source'
                    {
                    a0=(Token)match(input,53,FOLLOW_53_in_parse_edu_ustb_sei_mde_xmu_StartRoot484); if (state.failed) return element;

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
                    // Xmu.g:958:8: a1= 'view'
                    {
                    a1=(Token)match(input,61,FOLLOW_61_in_parse_edu_ustb_sei_mde_xmu_StartRoot499); if (state.failed) return element;

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
                    // Xmu.g:971:8: a2= 'context'
                    {
                    a2=(Token)match(input,39,FOLLOW_39_in_parse_edu_ustb_sei_mde_xmu_StartRoot514); if (state.failed) return element;

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

            a5=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_StartRoot535); if (state.failed) return element;

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

            // Xmu.g:1005:2: (a6= NUMBER )
            // Xmu.g:1006:3: a6= NUMBER
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

            a7=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_StartRoot574); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[28]);
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
    // Xmu.g:1059:1: parse_edu_ustb_sei_mde_xmu_Rule returns [edu.ustb.sei.mde.xmu.Rule element = null] : a0= 'rule' (a1= NAME ) ( (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' ) )? a7= '{' ( (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* ) )? (a12_0= parse_edu_ustb_sei_mde_xmu_Statement ) a13= '}' ;
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

            // Xmu.g:1062:2: (a0= 'rule' (a1= NAME ) ( (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' ) )? a7= '{' ( (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* ) )? (a12_0= parse_edu_ustb_sei_mde_xmu_Statement ) a13= '}' )
            // Xmu.g:1063:2: a0= 'rule' (a1= NAME ) ( (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' ) )? a7= '{' ( (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* ) )? (a12_0= parse_edu_ustb_sei_mde_xmu_Statement ) a13= '}'
            {
            a0=(Token)match(input,51,FOLLOW_51_in_parse_edu_ustb_sei_mde_xmu_Rule603); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[29]);
            	}

            // Xmu.g:1077:2: (a1= NAME )
            // Xmu.g:1078:3: a1= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[31]);
            	}

            // Xmu.g:1114:2: ( (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Xmu.g:1115:3: (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' )
                    {
                    // Xmu.g:1115:3: (a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')' )
                    // Xmu.g:1116:4: a2= '(' (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )* a6= ')'
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
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[32]);
                    			}

                    // Xmu.g:1130:4: (a3_0= parse_edu_ustb_sei_mde_xmu_Parameter )
                    // Xmu.g:1131:5: a3_0= parse_edu_ustb_sei_mde_xmu_Parameter
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[33]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[34]);
                    			}

                    // Xmu.g:1157:4: ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==20) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Xmu.g:1158:5: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) )
                    	    {
                    	    // Xmu.g:1158:5: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter ) )
                    	    // Xmu.g:1159:6: a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter )
                    	    {
                    	    a4=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_Rule718); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[35]);
                    	    					}

                    	    // Xmu.g:1173:6: (a5_0= parse_edu_ustb_sei_mde_xmu_Parameter )
                    	    // Xmu.g:1174:7: a5_0= parse_edu_ustb_sei_mde_xmu_Parameter
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[36]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[37]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[38]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[39]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[40]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[41]);
            	}

            a7=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_Rule846); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[42]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[50]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[51]);
            	}

            // Xmu.g:1252:2: ( (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==60) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Xmu.g:1253:3: (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* )
                    {
                    // Xmu.g:1253:3: (a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )* )
                    // Xmu.g:1254:4: a8= 'using' (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )*
                    {
                    a8=(Token)match(input,60,FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_Rule869); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[52]);
                    			}

                    // Xmu.g:1268:4: (a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable )
                    // Xmu.g:1269:5: a9_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[53]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[54]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[55]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[56]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[57]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[58]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[59]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[60]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[61]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[62]);
                    			}

                    // Xmu.g:1303:4: ( (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==20) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Xmu.g:1304:5: (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) )
                    	    {
                    	    // Xmu.g:1304:5: (a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ) )
                    	    // Xmu.g:1305:6: a10= ',' (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable )
                    	    {
                    	    a10=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_Rule936); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[63]);
                    	    					}

                    	    // Xmu.g:1319:6: (a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable )
                    	    // Xmu.g:1320:7: a11_0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[64]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[65]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[66]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[67]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[68]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[69]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[70]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[71]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[72]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[73]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[74]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[75]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[76]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[77]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[78]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[79]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[80]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[81]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[82]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[83]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[92]);
            	}

            // Xmu.g:1385:2: (a12_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:1386:3: a12_0= parse_edu_ustb_sei_mde_xmu_Statement
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[93]);
            	}

            a13=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_Rule1066); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[94]);
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
    // Xmu.g:1427:1: parse_edu_ustb_sei_mde_xmu_Parameter returns [edu.ustb.sei.mde.xmu.Parameter element = null] : ( (a0= 'source' |a1= 'view' |a2= 'context' )? ) (a5= NAME ) ;
    public final edu.ustb.sei.mde.xmu.Parameter parse_edu_ustb_sei_mde_xmu_Parameter() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Parameter element =  null;

        int parse_edu_ustb_sei_mde_xmu_Parameter_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Xmu.g:1430:2: ( ( (a0= 'source' |a1= 'view' |a2= 'context' )? ) (a5= NAME ) )
            // Xmu.g:1431:2: ( (a0= 'source' |a1= 'view' |a2= 'context' )? ) (a5= NAME )
            {
            // Xmu.g:1431:2: ( (a0= 'source' |a1= 'view' |a2= 'context' )? )
            // Xmu.g:1432:3: (a0= 'source' |a1= 'view' |a2= 'context' )?
            {
            // Xmu.g:1432:3: (a0= 'source' |a1= 'view' |a2= 'context' )?
            int alt10=4;
            switch ( input.LA(1) ) {
                case 53:
                    {
                    alt10=1;
                    }
                    break;
                case 61:
                    {
                    alt10=2;
                    }
                    break;
                case 39:
                    {
                    alt10=3;
                    }
                    break;
            }

            switch (alt10) {
                case 1 :
                    // Xmu.g:1433:4: a0= 'source'
                    {
                    a0=(Token)match(input,53,FOLLOW_53_in_parse_edu_ustb_sei_mde_xmu_Parameter1104); if (state.failed) return element;

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
                    // Xmu.g:1449:8: a1= 'view'
                    {
                    a1=(Token)match(input,61,FOLLOW_61_in_parse_edu_ustb_sei_mde_xmu_Parameter1119); if (state.failed) return element;

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
                    // Xmu.g:1465:8: a2= 'context'
                    {
                    a2=(Token)match(input,39,FOLLOW_39_in_parse_edu_ustb_sei_mde_xmu_Parameter1134); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[95]);
            	}

            // Xmu.g:1487:2: (a5= NAME )
            // Xmu.g:1488:3: a5= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[97]);
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
    // Xmu.g:1533:1: parse_edu_ustb_sei_mde_xmu_PrimitiveVariable returns [edu.ustb.sei.mde.xmu.PrimitiveVariable element = null] : (a0= PRIMITIVE ) (a1= NAME ) ;
    public final edu.ustb.sei.mde.xmu.PrimitiveVariable parse_edu_ustb_sei_mde_xmu_PrimitiveVariable() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PrimitiveVariable element =  null;

        int parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Xmu.g:1536:2: ( (a0= PRIMITIVE ) (a1= NAME ) )
            // Xmu.g:1537:2: (a0= PRIMITIVE ) (a1= NAME )
            {
            // Xmu.g:1537:2: (a0= PRIMITIVE )
            // Xmu.g:1538:3: a0= PRIMITIVE
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[98]);
            	}

            // Xmu.g:1577:2: (a1= NAME )
            // Xmu.g:1578:3: a1= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[101]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[102]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[103]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[109]);
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
    // Xmu.g:1625:1: parse_edu_ustb_sei_mde_xmu_ForStatement returns [edu.ustb.sei.mde.xmu.ForStatement element = null] : a0= 'update' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? ) )? a8= 'by' ( (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )? ) ;
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

            // Xmu.g:1628:2: (a0= 'update' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? ) )? a8= 'by' ( (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )? ) )
            // Xmu.g:1629:2: a0= 'update' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? ) )? a8= 'by' ( (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )? )
            {
            a0=(Token)match(input,58,FOLLOW_58_in_parse_edu_ustb_sei_mde_xmu_ForStatement1260); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[110]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[111]);
            	}

            // Xmu.g:1644:2: (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern )
            // Xmu.g:1645:3: a1_0= parse_edu_ustb_sei_mde_xmu_Pattern
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[113]);
            	}

            // Xmu.g:1671:2: ( (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==63) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Xmu.g:1672:3: (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? )
                    {
                    // Xmu.g:1672:3: (a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? )
                    // Xmu.g:1673:4: a2= 'with' (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern ) ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )?
                    {
                    a2=(Token)match(input,63,FOLLOW_63_in_parse_edu_ustb_sei_mde_xmu_ForStatement1305); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[114]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[115]);
                    			}

                    // Xmu.g:1688:4: (a3_0= parse_edu_ustb_sei_mde_xmu_Pattern )
                    // Xmu.g:1689:5: a3_0= parse_edu_ustb_sei_mde_xmu_Pattern
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[116]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[117]);
                    			}

                    // Xmu.g:1715:4: ( (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==62) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // Xmu.g:1716:5: (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                            {
                            // Xmu.g:1716:5: (a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                            // Xmu.g:1717:6: a4= 'when' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                            {
                            a4=(Token)match(input,62,FOLLOW_62_in_parse_edu_ustb_sei_mde_xmu_ForStatement1372); if (state.failed) return element;

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
                            						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[118]);
                            					}

                            // Xmu.g:1731:6: (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                            // Xmu.g:1732:7: a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
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
                            						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[119]);
                            						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[120]);
                            					}

                            // Xmu.g:1758:6: ( (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==28) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // Xmu.g:1759:7: (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                            	    {
                            	    // Xmu.g:1759:7: (a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                            	    // Xmu.g:1760:8: a6= ';' (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                            	    {
                            	    a6=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_ForStatement1461); if (state.failed) return element;

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
                            	    								addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[121]);
                            	    							}

                            	    // Xmu.g:1774:8: (a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                            	    // Xmu.g:1775:9: a7_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
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
                            	    								addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[122]);
                            	    								addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[123]);
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
                            						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[124]);
                            						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[125]);
                            					}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[126]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[127]);
            	}

            a8=(Token)match(input,37,FOLLOW_37_in_parse_edu_ustb_sei_mde_xmu_ForStatement1620); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[128]);
            	}

            // Xmu.g:1837:2: ( (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )? )
            // Xmu.g:1838:3: (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )?
            {
            // Xmu.g:1838:3: (a9_0= parse_edu_ustb_sei_mde_xmu_VStatement )
            // Xmu.g:1839:4: a9_0= parse_edu_ustb_sei_mde_xmu_VStatement
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
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[129]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[130]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[131]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[132]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[133]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[134]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[135]);
            		}

            // Xmu.g:1870:3: ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )?
            int alt15=2;
            switch ( input.LA(1) ) {
                case 45:
                    {
                    int LA15_1 = input.LA(2);

                    if ( (synpred18_Xmu()) ) {
                        alt15=1;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA15_2 = input.LA(2);

                    if ( (synpred18_Xmu()) ) {
                        alt15=1;
                    }
                    }
                    break;
                case 56:
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
                    // Xmu.g:1871:4: ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? )
                    {
                    // Xmu.g:1871:4: ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? )
                    // Xmu.g:1872:5: (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )?
                    {
                    // Xmu.g:1872:5: (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                    // Xmu.g:1873:6: a10_0= parse_edu_ustb_sei_mde_xmu_VStatement
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
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[136]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[137]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[138]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[139]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[140]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[141]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[142]);
                    				}

                    // Xmu.g:1904:5: ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )?
                    int alt14=2;
                    switch ( input.LA(1) ) {
                        case 45:
                            {
                            int LA14_1 = input.LA(2);

                            if ( (synpred17_Xmu()) ) {
                                alt14=1;
                            }
                            }
                            break;
                        case 57:
                            {
                            int LA14_2 = input.LA(2);

                            if ( (synpred17_Xmu()) ) {
                                alt14=1;
                            }
                            }
                            break;
                        case 56:
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
                            // Xmu.g:1905:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
                            {
                            // Xmu.g:1905:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
                            // Xmu.g:1906:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                            {
                            // Xmu.g:1906:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                            // Xmu.g:1907:8: a11_0= parse_edu_ustb_sei_mde_xmu_VStatement
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
                            							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[143]);
                            							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[144]);
                            							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[145]);
                            							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[146]);
                            							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[147]);
                            							addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[148]);
                            							addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[149]);
                            						}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[150]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[151]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[152]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[153]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[154]);
                    					addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[155]);
                    					addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[156]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[157]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[158]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[159]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[160]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[161]);
            			addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[162]);
            			addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[163]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[170]);
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
    // Xmu.g:1978:1: parse_edu_ustb_sei_mde_xmu_UpdatedStatement returns [edu.ustb.sei.mde.xmu.UpdatedStatement element = null] : a0= 'updated' a1= '(' (a2= NAME ) a3= ',' (a4= NAME ) a5= ')' ;
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

            // Xmu.g:1981:2: (a0= 'updated' a1= '(' (a2= NAME ) a3= ',' (a4= NAME ) a5= ')' )
            // Xmu.g:1982:2: a0= 'updated' a1= '(' (a2= NAME ) a3= ',' (a4= NAME ) a5= ')'
            {
            a0=(Token)match(input,59,FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1852); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[171]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[172]);
            	}

            // Xmu.g:2010:2: (a2= NAME )
            // Xmu.g:2011:3: a2= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[173]);
            	}

            a3=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1905); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[174]);
            	}

            // Xmu.g:2064:2: (a4= NAME )
            // Xmu.g:2065:3: a4= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[175]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[180]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[182]);
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
    // Xmu.g:2126:1: parse_edu_ustb_sei_mde_xmu_VStatement returns [edu.ustb.sei.mde.xmu.VStatement element = null] : ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
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

            // Xmu.g:2129:2: ( ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:2130:2: ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            // Xmu.g:2130:2: ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) )
            // Xmu.g:2131:3: (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' )
            {
            // Xmu.g:2131:3: (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt16=1;
                }
                break;
            case 57:
                {
                alt16=2;
                }
                break;
            case 56:
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
                    // Xmu.g:2132:4: a0= 'match'
                    {
                    a0=(Token)match(input,45,FOLLOW_45_in_parse_edu_ustb_sei_mde_xmu_VStatement1982); if (state.failed) return element;

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
                    // Xmu.g:2145:8: a1= 'unmatchv'
                    {
                    a1=(Token)match(input,57,FOLLOW_57_in_parse_edu_ustb_sei_mde_xmu_VStatement1997); if (state.failed) return element;

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
                    // Xmu.g:2158:8: a2= 'unmatchs'
                    {
                    a2=(Token)match(input,56,FOLLOW_56_in_parse_edu_ustb_sei_mde_xmu_VStatement2012); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[183]);
            	}

            a5=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_VStatement2033); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[185]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[190]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[192]);
            	}

            // Xmu.g:2200:2: (a6_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:2201:3: a6_0= parse_edu_ustb_sei_mde_xmu_Statement
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[193]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[194]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[195]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[197]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[198]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[199]);
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
    // Xmu.g:2234:1: parse_edu_ustb_sei_mde_xmu_Pattern returns [edu.ustb.sei.mde.xmu.Pattern element = null] : ( (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? |c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern );
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

            // Xmu.g:2237:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? |c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NAME) ) {
                alt19=1;
            }
            else if ( (LA19_0==41) ) {
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
                    // Xmu.g:2238:2: (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
                    {
                    // Xmu.g:2238:2: (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
                    // Xmu.g:2239:3: a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode
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
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[200]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[201]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[202]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[203]);
                    	}

                    // Xmu.g:2267:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==34) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // Xmu.g:2268:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                            {
                            // Xmu.g:2268:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                            // Xmu.g:2269:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                            {
                            a1=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_Pattern2115); if (state.failed) return element;

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
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[204]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[205]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[206]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[207]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[208]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[209]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[210]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[211]);
                            			}

                            // Xmu.g:2290:4: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                            int alt17=7;
                            switch ( input.LA(1) ) {
                            case 47:
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
                            case 21:
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
                            case 48:
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
                            case 46:
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
                                    // Xmu.g:2291:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
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
                                    // Xmu.g:2310:10: a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
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
                                    // Xmu.g:2329:10: a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
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
                                    // Xmu.g:2348:10: a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
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
                                    // Xmu.g:2367:10: a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
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
                                    // Xmu.g:2386:10: a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
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
                                    // Xmu.g:2405:10: a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
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
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[212]);
                            			}

                            a3=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_Pattern2289); if (state.failed) return element;

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
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[213]);
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[214]);
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[215]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[216]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[217]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[218]);
                    	}

                    }
                    break;
                case 2 :
                    // Xmu.g:2457:2: c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern
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
    // Xmu.g:2461:1: parse_edu_ustb_sei_mde_xmu_PatternNode returns [edu.ustb.sei.mde.xmu.PatternNode element = null] : (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}' ;
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

            // Xmu.g:2464:2: ( (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}' )
            // Xmu.g:2465:2: (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}'
            {
            // Xmu.g:2465:2: (a0= NAME )
            // Xmu.g:2466:3: a0= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[219]);
            	}

            a1=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_PatternNode2377); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[220]);
            	}

            // Xmu.g:2519:2: (a2= NAME )
            // Xmu.g:2520:3: a2= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[221]);
            	}

            a3=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_PatternNode2416); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[222]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[223]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[224]);
            	}

            // Xmu.g:2575:2: ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Xmu.g:2576:3: ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* )
                    {
                    // Xmu.g:2576:3: ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* )
                    // Xmu.g:2577:4: (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )*
                    {
                    // Xmu.g:2577:4: (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    // Xmu.g:2578:5: a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[225]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[226]);
                    			}

                    // Xmu.g:2604:4: ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==20) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Xmu.g:2605:5: (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) )
                    	    {
                    	    // Xmu.g:2605:5: (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) )
                    	    // Xmu.g:2606:6: a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    	    {
                    	    a5=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_PatternNode2486); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[227]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[228]);
                    	    					}

                    	    // Xmu.g:2621:6: (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    	    // Xmu.g:2622:7: a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[229]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[230]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[231]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[232]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[233]);
            	}

            a7=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_PatternNode2594); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[241]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[242]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[243]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[245]);
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
    // Xmu.g:2690:1: parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr returns [edu.ustb.sei.mde.xmu.PatternReferenceExpr element = null] : (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ;
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

            // Xmu.g:2693:2: ( (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) )
            // Xmu.g:2694:2: (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            {
            // Xmu.g:2694:2: (a0= NAME )
            // Xmu.g:2695:3: a0= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[246]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[247]);
            	}

            // Xmu.g:2735:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==34) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Xmu.g:2736:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    {
                    // Xmu.g:2736:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    // Xmu.g:2737:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                    {
                    a1=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2657); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[248]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[249]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[250]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[251]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[252]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[253]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[254]);
                    			}

                    // Xmu.g:2757:4: (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                    // Xmu.g:2758:5: a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[255]);
                    			}

                    a3=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2711); if (state.failed) return element;

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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[256]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[257]);
            	}

            a4=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2744); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[258]);
            	}

            // Xmu.g:2818:2: (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            // Xmu.g:2819:3: a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[259]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[260]);
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
    // Xmu.g:2847:1: parse_edu_ustb_sei_mde_xmu_PatternEqualExpr returns [edu.ustb.sei.mde.xmu.PatternEqualExpr element = null] : (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
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

            // Xmu.g:2850:2: ( (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:2851:2: (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:2851:2: (a0= NAME )
            // Xmu.g:2852:3: a0= NAME
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[261]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[262]);
            	}

            // Xmu.g:2892:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Xmu.g:2893:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    {
                    // Xmu.g:2893:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    // Xmu.g:2894:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                    {
                    a1=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2829); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[263]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[264]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[265]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[266]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[267]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[268]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[269]);
                    			}

                    // Xmu.g:2914:4: (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                    // Xmu.g:2915:5: a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[270]);
                    			}

                    a3=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2883); if (state.failed) return element;

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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[271]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[272]);
            	}

            a4=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2916); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[273]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[274]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[275]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[276]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[277]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[278]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[279]);
            	}

            // Xmu.g:2981:2: (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            // Xmu.g:2982:3: a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[280]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[281]);
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
    // Xmu.g:3010:1: parse_edu_ustb_sei_mde_xmu_VariableExp returns [edu.ustb.sei.mde.xmu.VariableExp element = null] : (a0= NAME ) ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )* ;
    public final edu.ustb.sei.mde.xmu.VariableExp parse_edu_ustb_sei_mde_xmu_VariableExp() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VariableExp element =  null;

        int parse_edu_ustb_sei_mde_xmu_VariableExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.xmu.Path a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Xmu.g:3013:2: ( (a0= NAME ) ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )* )
            // Xmu.g:3014:2: (a0= NAME ) ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )*
            {
            // Xmu.g:3014:2: (a0= NAME )
            // Xmu.g:3015:3: a0= NAME
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[282]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[283]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[284]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[296]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[297]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[298]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[299]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[300]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[301]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[302]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[303]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[304]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[305]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[306]);
            	}

            // Xmu.g:3078:2: ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==22) ) {
                    int LA24_2 = input.LA(2);

                    if ( ((LA24_2 >= 42 && LA24_2 <= 43)||LA24_2==52) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==23) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // Xmu.g:3079:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) )
            	    {
            	    // Xmu.g:3079:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) )
            	    // Xmu.g:3080:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Path )
            	    {
            	    // Xmu.g:3080:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Path )
            	    // Xmu.g:3081:5: a1_0= parse_edu_ustb_sei_mde_xmu_Path
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Path_in_parse_edu_ustb_sei_mde_xmu_VariableExp3007);
            	    a1_0=parse_edu_ustb_sei_mde_xmu_Path();

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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[307]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[308]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[309]);
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[324]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[325]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[326]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[327]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[328]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[329]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[330]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[331]);
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[332]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[333]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[334]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[350]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[351]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[352]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[353]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[354]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[355]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[356]);
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
    // Xmu.g:3163:1: parse_edu_ustb_sei_mde_xmu_FeaturePath returns [edu.ustb.sei.mde.xmu.FeaturePath element = null] : a0= '.' (a1= NAME ) ;
    public final edu.ustb.sei.mde.xmu.FeaturePath parse_edu_ustb_sei_mde_xmu_FeaturePath() throws RecognitionException {
        edu.ustb.sei.mde.xmu.FeaturePath element =  null;

        int parse_edu_ustb_sei_mde_xmu_FeaturePath_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Xmu.g:3166:2: (a0= '.' (a1= NAME ) )
            // Xmu.g:3167:2: a0= '.' (a1= NAME )
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3063); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createFeaturePath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_14_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[357]);
            	}

            // Xmu.g:3181:2: (a1= NAME )
            // Xmu.g:3182:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3081); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[358]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[359]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[360]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[377]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[379]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[380]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[381]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[382]);
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



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_LoopPath"
    // Xmu.g:3243:1: parse_edu_ustb_sei_mde_xmu_LoopPath returns [edu.ustb.sei.mde.xmu.LoopPath element = null] : a0= '->' ( (a1= 'select' |a2= 'forAll' |a3= 'exists' ) ) a6= '(' (a7_0= parse_edu_ustb_sei_mde_xmu_Variable ) a8= '|' (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a10= ')' ;
    public final edu.ustb.sei.mde.xmu.LoopPath parse_edu_ustb_sei_mde_xmu_LoopPath() throws RecognitionException {
        edu.ustb.sei.mde.xmu.LoopPath element =  null;

        int parse_edu_ustb_sei_mde_xmu_LoopPath_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a6=null;
        Token a8=null;
        Token a10=null;
        edu.ustb.sei.mde.xmu.Variable a7_0 =null;

        edu.ustb.sei.mde.xmu.BooleanOrExpr a9_0 =null;

        edu.ustb.sei.mde.xmu.BooleanAndExpr a9_1 =null;

        edu.ustb.sei.mde.xmu.RelationalExpr a9_2 =null;

        edu.ustb.sei.mde.xmu.AdditiveExpr a9_3 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a9_4 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a9_5 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a9_6 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Xmu.g:3246:2: (a0= '->' ( (a1= 'select' |a2= 'forAll' |a3= 'exists' ) ) a6= '(' (a7_0= parse_edu_ustb_sei_mde_xmu_Variable ) a8= '|' (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a10= ')' )
            // Xmu.g:3247:2: a0= '->' ( (a1= 'select' |a2= 'forAll' |a3= 'exists' ) ) a6= '(' (a7_0= parse_edu_ustb_sei_mde_xmu_Variable ) a8= '|' (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a10= ')'
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_LoopPath3117); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[383]);
            	}

            // Xmu.g:3261:2: ( (a1= 'select' |a2= 'forAll' |a3= 'exists' ) )
            // Xmu.g:3262:3: (a1= 'select' |a2= 'forAll' |a3= 'exists' )
            {
            // Xmu.g:3262:3: (a1= 'select' |a2= 'forAll' |a3= 'exists' )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt25=1;
                }
                break;
            case 43:
                {
                alt25=2;
                }
                break;
            case 42:
                {
                alt25=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // Xmu.g:3263:4: a1= 'select'
                    {
                    a1=(Token)match(input,52,FOLLOW_52_in_parse_edu_ustb_sei_mde_xmu_LoopPath3140); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Xmu.g:3276:8: a2= 'forAll'
                    {
                    a2=(Token)match(input,43,FOLLOW_43_in_parse_edu_ustb_sei_mde_xmu_LoopPath3155); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Xmu.g:3289:8: a3= 'exists'
                    {
                    a3=(Token)match(input,42,FOLLOW_42_in_parse_edu_ustb_sei_mde_xmu_LoopPath3170); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[384]);
            	}

            a6=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_LoopPath3191); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[385]);
            	}

            // Xmu.g:3323:2: (a7_0= parse_edu_ustb_sei_mde_xmu_Variable )
            // Xmu.g:3324:3: a7_0= parse_edu_ustb_sei_mde_xmu_Variable
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Variable_in_parse_edu_ustb_sei_mde_xmu_LoopPath3209);
            a7_0=parse_edu_ustb_sei_mde_xmu_Variable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[386]);
            	}

            a8=(Token)match(input,65,FOLLOW_65_in_parse_edu_ustb_sei_mde_xmu_LoopPath3227); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[387]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[388]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[389]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[390]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[391]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[392]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[393]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[394]);
            	}

            // Xmu.g:3370:2: (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt26=7;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA26_1 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt26=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA26_2 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt26=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA26_3 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (true) ) {
                    alt26=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA26_4 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (true) ) {
                    alt26=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA26_5 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (true) ) {
                    alt26=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA26_6 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (true) ) {
                    alt26=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA26_7 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (true) ) {
                    alt26=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA26_8 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (true) ) {
                    alt26=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA26_9 = input.LA(2);

                if ( (synpred36_Xmu()) ) {
                    alt26=1;
                }
                else if ( (synpred37_Xmu()) ) {
                    alt26=2;
                }
                else if ( (synpred38_Xmu()) ) {
                    alt26=3;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt26=4;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt26=5;
                }
                else if ( (true) ) {
                    alt26=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // Xmu.g:3371:3: a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3245);
                    a9_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Xmu.g:3390:6: a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3259);
                    a9_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Xmu.g:3409:6: a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3273);
                    a9_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 4 :
                    // Xmu.g:3428:6: a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3287);
                    a9_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 5 :
                    // Xmu.g:3447:6: a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3301);
                    a9_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 6 :
                    // Xmu.g:3466:6: a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3315);
                    a9_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 7 :
                    // Xmu.g:3485:6: a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3329);
                    a9_6=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[395]);
            	}

            a10=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_LoopPath3347); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createLoopPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_15_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[396]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[397]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[398]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[411]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[412]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[413]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[414]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[415]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[416]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[417]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[418]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[419]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[420]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_edu_ustb_sei_mde_xmu_LoopPath_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_LoopPath"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_OperationPath"
    // Xmu.g:3550:1: parse_edu_ustb_sei_mde_xmu_OperationPath returns [edu.ustb.sei.mde.xmu.OperationPath element = null] : a0= '.' (a1= NAME ) a2= '(' ( ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a6= ')' ;
    public final edu.ustb.sei.mde.xmu.OperationPath parse_edu_ustb_sei_mde_xmu_OperationPath() throws RecognitionException {
        edu.ustb.sei.mde.xmu.OperationPath element =  null;

        int parse_edu_ustb_sei_mde_xmu_OperationPath_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        edu.ustb.sei.mde.xmu.Expr a3_0 =null;

        edu.ustb.sei.mde.xmu.Expr a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Xmu.g:3553:2: (a0= '.' (a1= NAME ) a2= '(' ( ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a6= ')' )
            // Xmu.g:3554:2: a0= '.' (a1= NAME ) a2= '(' ( ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a6= ')'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_OperationPath3376); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[421]);
            	}

            // Xmu.g:3568:2: (a1= NAME )
            // Xmu.g:3569:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_OperationPath3394); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[422]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_OperationPath3415); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[423]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[424]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[425]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[426]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[427]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[428]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[429]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[430]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[431]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[432]);
            	}

            // Xmu.g:3627:2: ( ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==BOOLEAN||(LA28_0 >= NAME && LA28_0 <= NUMBER)||LA28_0==QUOTED_39_39_92||LA28_0==15||LA28_0==21||LA28_0==39||(LA28_0 >= 46 && LA28_0 <= 48)||LA28_0==53||LA28_0==61) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // Xmu.g:3628:3: ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    {
                    // Xmu.g:3628:3: ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    // Xmu.g:3629:4: (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    {
                    // Xmu.g:3629:4: (a3_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    // Xmu.g:3630:5: a3_0= parse_edu_ustb_sei_mde_xmu_Expr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3444);
                    a3_0=parse_edu_ustb_sei_mde_xmu_Expr();

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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[433]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[434]);
                    			}

                    // Xmu.g:3656:4: ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==20) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // Xmu.g:3657:5: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    {
                    	    // Xmu.g:3657:5: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    // Xmu.g:3658:6: a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    {
                    	    a4=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_OperationPath3485); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[435]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[436]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[437]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[438]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[439]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[440]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[441]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[442]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[443]);
                    	    					}

                    	    // Xmu.g:3680:6: (a5_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    // Xmu.g:3681:7: a5_0= parse_edu_ustb_sei_mde_xmu_Expr
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3519);
                    	    a5_0=parse_edu_ustb_sei_mde_xmu_Expr();

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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[444]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[445]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[446]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[447]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[448]);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_OperationPath3593); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createOperationPath();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_16_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[449]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[450]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[451]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[452]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[453]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[454]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[455]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[456]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[457]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[458]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[459]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[460]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[461]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[462]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[463]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[464]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[465]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[466]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[467]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[468]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[469]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[470]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[471]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[472]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[473]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_edu_ustb_sei_mde_xmu_OperationPath_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_OperationPath"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_StringLiteral"
    // Xmu.g:3762:1: parse_edu_ustb_sei_mde_xmu_StringLiteral returns [edu.ustb.sei.mde.xmu.StringLiteral element = null] : (a0= QUOTED_39_39_92 ) ;
    public final edu.ustb.sei.mde.xmu.StringLiteral parse_edu_ustb_sei_mde_xmu_StringLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.StringLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_StringLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Xmu.g:3765:2: ( (a0= QUOTED_39_39_92 ) )
            // Xmu.g:3766:2: (a0= QUOTED_39_39_92 )
            {
            // Xmu.g:3766:2: (a0= QUOTED_39_39_92 )
            // Xmu.g:3767:3: a0= QUOTED_39_39_92
            {
            a0=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_xmu_StringLiteral3626); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_17_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[474]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[475]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[476]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[477]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[478]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[479]);
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[490]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[491]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[492]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[493]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[494]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[495]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_edu_ustb_sei_mde_xmu_StringLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_StringLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_EmptyLiteral"
    // Xmu.g:3825:1: parse_edu_ustb_sei_mde_xmu_EmptyLiteral returns [edu.ustb.sei.mde.xmu.EmptyLiteral element = null] : ( (a0= 'null' |a1= 'nil' ) ) ;
    public final edu.ustb.sei.mde.xmu.EmptyLiteral parse_edu_ustb_sei_mde_xmu_EmptyLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EmptyLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_EmptyLiteral_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Xmu.g:3828:2: ( ( (a0= 'null' |a1= 'nil' ) ) )
            // Xmu.g:3829:2: ( (a0= 'null' |a1= 'nil' ) )
            {
            // Xmu.g:3829:2: ( (a0= 'null' |a1= 'nil' ) )
            // Xmu.g:3830:3: (a0= 'null' |a1= 'nil' )
            {
            // Xmu.g:3830:3: (a0= 'null' |a1= 'nil' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==48) ) {
                alt29=1;
            }
            else if ( (LA29_0==46) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // Xmu.g:3831:4: a0= 'null'
                    {
                    a0=(Token)match(input,48,FOLLOW_48_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3671); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Xmu.g:3844:8: a1= 'nil'
                    {
                    a1=(Token)match(input,46,FOLLOW_46_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3686); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[508]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[509]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[510]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[511]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[512]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[513]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[514]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[515]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[516]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[517]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_edu_ustb_sei_mde_xmu_EmptyLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_EmptyLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_IntegerLiteral"
    // Xmu.g:3887:1: parse_edu_ustb_sei_mde_xmu_IntegerLiteral returns [edu.ustb.sei.mde.xmu.IntegerLiteral element = null] : (a0= NUMBER ) ;
    public final edu.ustb.sei.mde.xmu.IntegerLiteral parse_edu_ustb_sei_mde_xmu_IntegerLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.IntegerLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_IntegerLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Xmu.g:3890:2: ( (a0= NUMBER ) )
            // Xmu.g:3891:2: (a0= NUMBER )
            {
            // Xmu.g:3891:2: (a0= NUMBER )
            // Xmu.g:3892:3: a0= NUMBER
            {
            a0=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_IntegerLiteral3726); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_19_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[518]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[519]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[520]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[521]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[522]);
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[534]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[535]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[536]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[537]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[538]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[539]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_edu_ustb_sei_mde_xmu_IntegerLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_IntegerLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_BooleanLiteral"
    // Xmu.g:3950:1: parse_edu_ustb_sei_mde_xmu_BooleanLiteral returns [edu.ustb.sei.mde.xmu.BooleanLiteral element = null] : (a0= BOOLEAN ) ;
    public final edu.ustb.sei.mde.xmu.BooleanLiteral parse_edu_ustb_sei_mde_xmu_BooleanLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_BooleanLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Xmu.g:3953:2: ( (a0= BOOLEAN ) )
            // Xmu.g:3954:2: (a0= BOOLEAN )
            {
            // Xmu.g:3954:2: (a0= BOOLEAN )
            // Xmu.g:3955:3: a0= BOOLEAN
            {
            a0=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_parse_edu_ustb_sei_mde_xmu_BooleanLiteral3766); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_20_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[540]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[541]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[542]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[543]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[544]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[545]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[546]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[547]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[548]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[549]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[550]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[551]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[552]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[553]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[554]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[555]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[556]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[557]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[558]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[559]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[560]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[561]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_edu_ustb_sei_mde_xmu_BooleanLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_BooleanLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_EnumLiteral"
    // Xmu.g:4013:1: parse_edu_ustb_sei_mde_xmu_EnumLiteral returns [edu.ustb.sei.mde.xmu.EnumLiteral element = null] : (a0= NAME ) a1= '::' (a2= NAME ) ;
    public final edu.ustb.sei.mde.xmu.EnumLiteral parse_edu_ustb_sei_mde_xmu_EnumLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EnumLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_EnumLiteral_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Xmu.g:4016:2: ( (a0= NAME ) a1= '::' (a2= NAME ) )
            // Xmu.g:4017:2: (a0= NAME ) a1= '::' (a2= NAME )
            {
            // Xmu.g:4017:2: (a0= NAME )
            // Xmu.g:4018:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3806); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[562]);
            	}

            a1=(Token)match(input,27,FOLLOW_27_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3827); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[563]);
            	}

            // Xmu.g:4071:2: (a2= NAME )
            // Xmu.g:4072:3: a2= NAME
            {
            a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3845); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_21_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[564]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[565]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[566]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[567]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[568]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[569]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[570]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[571]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[572]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[573]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[574]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[575]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[576]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[577]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[578]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[579]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[580]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[581]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[582]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[583]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[584]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[585]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_edu_ustb_sei_mde_xmu_EnumLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_EnumLiteral"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_BlockStatement"
    // Xmu.g:4134:1: parse_edu_ustb_sei_mde_xmu_BlockStatement returns [edu.ustb.sei.mde.xmu.BlockStatement element = null] : a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}' ;
    public final edu.ustb.sei.mde.xmu.BlockStatement parse_edu_ustb_sei_mde_xmu_BlockStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BlockStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_BlockStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        edu.ustb.sei.mde.xmu.Statement a1_0 =null;

        edu.ustb.sei.mde.xmu.Statement a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Xmu.g:4137:2: (a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}' )
            // Xmu.g:4138:2: a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}'
            {
            a0=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3881); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[586]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[587]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[588]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[589]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[590]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[591]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[592]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[593]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[594]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[595]);
            	}

            // Xmu.g:4161:2: ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==NAME||(LA31_0 >= 40 && LA31_0 <= 41)||LA31_0==50||LA31_0==55||(LA31_0 >= 58 && LA31_0 <= 59)||LA31_0==64) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Xmu.g:4162:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* )
                    {
                    // Xmu.g:4162:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* )
                    // Xmu.g:4163:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )*
                    {
                    // Xmu.g:4163:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    // Xmu.g:4164:5: a1_0= parse_edu_ustb_sei_mde_xmu_Statement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3910);
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_1_0_0_0, a1_0, true);
                    						copyLocalizationInfos(a1_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[596]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[597]);
                    			}

                    // Xmu.g:4190:4: ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==28) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // Xmu.g:4191:5: (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
                    	    {
                    	    // Xmu.g:4191:5: (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
                    	    // Xmu.g:4192:6: a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    	    {
                    	    a2=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3951); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_1_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[598]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[599]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[600]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[601]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[602]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[603]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[604]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[605]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[606]);
                    	    					}

                    	    // Xmu.g:4214:6: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    	    // Xmu.g:4215:7: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3985);
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
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_1_0_0_1_0_0_1, a3_0, true);
                    	    								copyLocalizationInfos(a3_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[607]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[608]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[609]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[610]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[611]);
            	}

            a4=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_BlockStatement4059); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBlockStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_22_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[612]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[613]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[614]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[615]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[616]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[617]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[618]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_edu_ustb_sei_mde_xmu_BlockStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_BlockStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_SwitchStatement"
    // Xmu.g:4278:1: parse_edu_ustb_sei_mde_xmu_SwitchStatement returns [edu.ustb.sei.mde.xmu.SwitchStatement element = null] : a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Xmu.g:4281:2: (a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}' )
            // Xmu.g:4282:2: a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}'
            {
            a0=(Token)match(input,55,FOLLOW_55_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4088); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[619]);
            	}

            // Xmu.g:4296:2: (a1= NAME )
            // Xmu.g:4297:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4106); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[620]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[621]);
            	}

            // Xmu.g:4337:2: ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==62) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // Xmu.g:4338:3: (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                    {
                    // Xmu.g:4338:3: (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                    // Xmu.g:4339:4: a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                    {
                    a2=(Token)match(input,62,FOLLOW_62_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4136); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[622]);
                    			}

                    // Xmu.g:4353:4: (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    // Xmu.g:4354:5: a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4162);
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2_0_0_1, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[623]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[624]);
                    			}

                    // Xmu.g:4380:4: ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==28) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // Xmu.g:4381:5: (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                    	    {
                    	    // Xmu.g:4381:5: (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                    	    // Xmu.g:4382:6: a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    	    {
                    	    a4=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4203); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[625]);
                    	    					}

                    	    // Xmu.g:4396:6: (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    	    // Xmu.g:4397:7: a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4237);
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
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_2_0_0_2_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[626]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[627]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[628]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[629]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[630]);
            	}

            a6=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4311); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[631]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[632]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[633]);
            	}

            // Xmu.g:4454:2: ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==38) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Xmu.g:4455:3: (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement )
            	    {
            	    // Xmu.g:4455:3: (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement )
            	    // Xmu.g:4456:4: a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseSubStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4334);
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
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_4, a7_0, true);
            	    					copyLocalizationInfos(a7_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[634]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[635]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[636]);
            	}

            a8=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4360); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createSwitchStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_23_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[637]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[638]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[639]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[640]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[641]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[642]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[643]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_edu_ustb_sei_mde_xmu_SwitchStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_SwitchStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_CasePatternStatement"
    // Xmu.g:4506:1: parse_edu_ustb_sei_mde_xmu_CasePatternStatement returns [edu.ustb.sei.mde.xmu.CasePatternStatement element = null] : a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
    public final edu.ustb.sei.mde.xmu.CasePatternStatement parse_edu_ustb_sei_mde_xmu_CasePatternStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CasePatternStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CasePatternStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.Pattern a1_0 =null;

        edu.ustb.sei.mde.xmu.Statement a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Xmu.g:4509:2: (a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:4510:2: a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4389); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCasePatternStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[644]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[645]);
            	}

            // Xmu.g:4525:2: (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern )
            // Xmu.g:4526:3: a1_0= parse_edu_ustb_sei_mde_xmu_Pattern
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4407);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[646]);
            	}

            a2=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4425); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCasePatternStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[647]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[648]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[649]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[650]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[651]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[652]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[653]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[654]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[655]);
            	}

            // Xmu.g:4573:2: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:4574:3: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4443);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_24_0_0_3, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[656]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[657]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[658]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_edu_ustb_sei_mde_xmu_CasePatternStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_CasePatternStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_CaseValueStatement"
    // Xmu.g:4603:1: parse_edu_ustb_sei_mde_xmu_CaseValueStatement returns [edu.ustb.sei.mde.xmu.CaseValueStatement element = null] : a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
    public final edu.ustb.sei.mde.xmu.CaseValueStatement parse_edu_ustb_sei_mde_xmu_CaseValueStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CaseValueStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CaseValueStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.Expr a1_0 =null;

        edu.ustb.sei.mde.xmu.Statement a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Xmu.g:4606:2: (a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:4607:2: a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4476); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCaseValueStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[659]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[660]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[661]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[662]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[663]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[664]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[665]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[666]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[667]);
            	}

            // Xmu.g:4629:2: (a1_0= parse_edu_ustb_sei_mde_xmu_Expr )
            // Xmu.g:4630:3: a1_0= parse_edu_ustb_sei_mde_xmu_Expr
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4494);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[668]);
            	}

            a2=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4512); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createCaseValueStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[669]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[670]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[671]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[672]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[673]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[674]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[675]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[676]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[677]);
            	}

            // Xmu.g:4677:2: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:4678:3: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4530);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_25_0_0_3, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[678]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[679]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[680]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_edu_ustb_sei_mde_xmu_CaseValueStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_CaseValueStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_RuleCallStatement"
    // Xmu.g:4707:1: parse_edu_ustb_sei_mde_xmu_RuleCallStatement returns [edu.ustb.sei.mde.xmu.RuleCallStatement element = null] : (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Xmu.g:4710:2: ( (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')' )
            // Xmu.g:4711:2: (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')'
            {
            // Xmu.g:4711:2: (a0= NAME )
            // Xmu.g:4712:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4567); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[681]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4588); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[682]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[683]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[684]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[685]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[686]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[687]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[688]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[689]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[690]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[691]);
            	}

            // Xmu.g:4774:2: ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==BOOLEAN||(LA36_0 >= NAME && LA36_0 <= NUMBER)||LA36_0==QUOTED_39_39_92||LA36_0==15||LA36_0==21||LA36_0==39||(LA36_0 >= 46 && LA36_0 <= 48)||LA36_0==53||LA36_0==61) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // Xmu.g:4775:3: ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    {
                    // Xmu.g:4775:3: ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    // Xmu.g:4776:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    {
                    // Xmu.g:4776:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    // Xmu.g:4777:5: a2_0= parse_edu_ustb_sei_mde_xmu_Expr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4617);
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[692]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[693]);
                    			}

                    // Xmu.g:4803:4: ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==20) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // Xmu.g:4804:5: (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    {
                    	    // Xmu.g:4804:5: (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    // Xmu.g:4805:6: a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    {
                    	    a3=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4658); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_2_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[694]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[695]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[696]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[697]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[698]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[699]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[700]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[701]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[702]);
                    	    					}

                    	    // Xmu.g:4827:6: (a4_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    // Xmu.g:4828:7: a4_0= parse_edu_ustb_sei_mde_xmu_Expr
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4692);
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
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_2_0_0_1_0_0_1, a4_0, true);
                    	    								copyLocalizationInfos(a4_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[703]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[704]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[705]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[706]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[707]);
            	}

            a5=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4766); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createRuleCallStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_26_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[708]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[709]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[710]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[711]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[712]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[713]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[714]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_edu_ustb_sei_mde_xmu_RuleCallStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_RuleCallStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_UpdatePattern"
    // Xmu.g:4891:1: parse_edu_ustb_sei_mde_xmu_UpdatePattern returns [edu.ustb.sei.mde.xmu.UpdatePattern element = null] : a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ;
    public final edu.ustb.sei.mde.xmu.UpdatePattern parse_edu_ustb_sei_mde_xmu_UpdatePattern() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UpdatePattern element =  null;

        int parse_edu_ustb_sei_mde_xmu_UpdatePattern_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.xmu.PatternNode a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Xmu.g:4894:2: (a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) )
            // Xmu.g:4895:2: a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4795); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createUpdatePattern();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_27_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatePattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[715]);
            	}

            // Xmu.g:4909:2: (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            // Xmu.g:4910:3: a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4813);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_27_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[716]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[717]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[718]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[719]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[720]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[721]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[722]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[723]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[724]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_edu_ustb_sei_mde_xmu_UpdatePattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_UpdatePattern"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_DeleteNode"
    // Xmu.g:4945:1: parse_edu_ustb_sei_mde_xmu_DeleteNode returns [edu.ustb.sei.mde.xmu.DeleteNode element = null] : a0= 'delete' (a1= NAME ) ;
    public final edu.ustb.sei.mde.xmu.DeleteNode parse_edu_ustb_sei_mde_xmu_DeleteNode() throws RecognitionException {
        edu.ustb.sei.mde.xmu.DeleteNode element =  null;

        int parse_edu_ustb_sei_mde_xmu_DeleteNode_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Xmu.g:4948:2: (a0= 'delete' (a1= NAME ) )
            // Xmu.g:4949:2: a0= 'delete' (a1= NAME )
            {
            a0=(Token)match(input,40,FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4846); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[725]);
            	}

            // Xmu.g:4963:2: (a1= NAME )
            // Xmu.g:4964:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4864); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_28_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[726]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[727]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[728]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[729]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[730]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[731]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[732]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_edu_ustb_sei_mde_xmu_DeleteNode_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_DeleteNode"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_DeleteLink"
    // Xmu.g:5011:1: parse_edu_ustb_sei_mde_xmu_DeleteLink returns [edu.ustb.sei.mde.xmu.DeleteLink element = null] : a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Xmu.g:5014:2: (a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME ) )
            // Xmu.g:5015:2: a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME )
            {
            a0=(Token)match(input,40,FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4900); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[733]);
            	}

            // Xmu.g:5029:2: (a1= NAME )
            // Xmu.g:5030:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4918); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[734]);
            	}

            a2=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4939); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[735]);
            	}

            // Xmu.g:5083:2: (a3= NAME )
            // Xmu.g:5084:3: a3= NAME
            {
            a3=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4957); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_3, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[736]);
            	}

            a4=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4978); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createDeleteLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[737]);
            	}

            // Xmu.g:5137:2: (a5= NAME )
            // Xmu.g:5138:3: a5= NAME
            {
            a5=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4996); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_29_0_0_5, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[738]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[739]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[740]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[741]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[742]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[743]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[744]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_edu_ustb_sei_mde_xmu_DeleteLink_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_DeleteLink"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_BooleanOrExpr"
    // Xmu.g:5185:1: parse_edu_ustb_sei_mde_xmu_BooleanOrExpr returns [edu.ustb.sei.mde.xmu.BooleanOrExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Xmu.g:5188:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5189:2: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5189:2: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt37=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA37_1 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (synpred54_Xmu()) ) {
                    alt37=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA37_2 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (synpred54_Xmu()) ) {
                    alt37=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA37_3 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (true) ) {
                    alt37=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA37_4 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (true) ) {
                    alt37=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA37_5 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (true) ) {
                    alt37=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA37_6 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (true) ) {
                    alt37=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA37_7 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (true) ) {
                    alt37=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA37_8 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (true) ) {
                    alt37=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA37_9 = input.LA(2);

                if ( (synpred52_Xmu()) ) {
                    alt37=1;
                }
                else if ( (synpred53_Xmu()) ) {
                    alt37=2;
                }
                else if ( (true) ) {
                    alt37=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // Xmu.g:5190:3: a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5036);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5209:6: a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5050);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:5228:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5064);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:5247:6: a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5078);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_0, a0_3, true);
                    				copyLocalizationInfos(a0_3, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[745]);
            	}

            // Xmu.g:5272:2: ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==49) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // Xmu.g:5273:3: (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:5273:3: (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:5274:4: a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    a1=(Token)match(input,49,FOLLOW_49_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5105); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanOrExpr();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[746]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[747]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[748]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[749]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[750]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[751]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[752]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[753]);
            	    			}

            	    // Xmu.g:5295:4: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt38=4;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        int LA38_1 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt38=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 38, 1, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 21:
            	        {
            	        int LA38_2 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (synpred57_Xmu()) ) {
            	            alt38=3;
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

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (true) ) {
            	            alt38=4;
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

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (true) ) {
            	            alt38=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 38, 4, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 48:
            	        {
            	        int LA38_5 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (true) ) {
            	            alt38=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 38, 5, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 46:
            	        {
            	        int LA38_6 = input.LA(2);

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (true) ) {
            	            alt38=4;
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

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (true) ) {
            	            alt38=4;
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

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (true) ) {
            	            alt38=4;
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

            	        if ( (synpred55_Xmu()) ) {
            	            alt38=1;
            	        }
            	        else if ( (synpred56_Xmu()) ) {
            	            alt38=2;
            	        }
            	        else if ( (true) ) {
            	            alt38=4;
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
            	            // Xmu.g:5296:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5131);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_0, true);
            	            						copyLocalizationInfos(a2_0, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:5315:10: a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5151);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_1, true);
            	            						copyLocalizationInfos(a2_1, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 3 :
            	            // Xmu.g:5334:10: a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5171);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_2, true);
            	            						copyLocalizationInfos(a2_2, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 4 :
            	            // Xmu.g:5353:10: a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5191);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_30_0_0_1_0_0_1, a2_3, true);
            	            						copyLocalizationInfos(a2_3, element);
            	            					}
            	            				}

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[764]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[765]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[766]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[767]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[768]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[769]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[770]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[771]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[772]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[773]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[774]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[775]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[776]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[777]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[778]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[779]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[780]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[781]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[782]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[783]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[784]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[785]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_BooleanOrExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_BooleanAndExpr"
    // Xmu.g:5417:1: parse_edu_ustb_sei_mde_xmu_BooleanAndExpr returns [edu.ustb.sei.mde.xmu.BooleanAndExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Xmu.g:5420:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5421:2: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5421:2: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt40=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA40_1 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt40=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA40_2 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt40=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA40_3 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (true) ) {
                    alt40=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA40_4 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (true) ) {
                    alt40=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA40_5 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (true) ) {
                    alt40=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA40_6 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (true) ) {
                    alt40=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA40_7 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (true) ) {
                    alt40=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA40_8 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (true) ) {
                    alt40=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA40_9 = input.LA(2);

                if ( (synpred59_Xmu()) ) {
                    alt40=1;
                }
                else if ( (synpred60_Xmu()) ) {
                    alt40=2;
                }
                else if ( (synpred61_Xmu()) ) {
                    alt40=3;
                }
                else if ( (true) ) {
                    alt40=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // Xmu.g:5422:3: a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5251);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5441:6: a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5265);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:5460:6: a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5279);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:5479:6: a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5293);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_3, true);
                    				copyLocalizationInfos(a0_3, element);
                    			}
                    		}

                    }
                    break;
                case 5 :
                    // Xmu.g:5498:6: a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5307);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_0, a0_4, true);
                    				copyLocalizationInfos(a0_4, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[786]);
            	}

            // Xmu.g:5523:2: ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==36) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // Xmu.g:5524:3: (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:5524:3: (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:5525:4: a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    a1=(Token)match(input,36,FOLLOW_36_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5334); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createBooleanAndExpr();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[787]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[788]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[789]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[790]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[791]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[792]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[793]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[794]);
            	    			}

            	    // Xmu.g:5546:4: (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt41=5;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        int LA41_1 = input.LA(2);

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt41=4;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 41, 1, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 21:
            	        {
            	        int LA41_2 = input.LA(2);

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt41=4;
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

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (true) ) {
            	            alt41=5;
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

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (true) ) {
            	            alt41=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 41, 4, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 48:
            	        {
            	        int LA41_5 = input.LA(2);

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (true) ) {
            	            alt41=5;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 41, 5, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 46:
            	        {
            	        int LA41_6 = input.LA(2);

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (true) ) {
            	            alt41=5;
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

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (true) ) {
            	            alt41=5;
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

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (true) ) {
            	            alt41=5;
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

            	        if ( (synpred63_Xmu()) ) {
            	            alt41=1;
            	        }
            	        else if ( (synpred64_Xmu()) ) {
            	            alt41=2;
            	        }
            	        else if ( (synpred65_Xmu()) ) {
            	            alt41=3;
            	        }
            	        else if ( (true) ) {
            	            alt41=5;
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
            	            // Xmu.g:5547:5: a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5360);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_0, true);
            	            						copyLocalizationInfos(a2_0, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:5566:10: a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5380);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_1, true);
            	            						copyLocalizationInfos(a2_1, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 3 :
            	            // Xmu.g:5585:10: a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5400);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_2, true);
            	            						copyLocalizationInfos(a2_2, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 4 :
            	            // Xmu.g:5604:10: a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5420);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_3, true);
            	            						copyLocalizationInfos(a2_3, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 5 :
            	            // Xmu.g:5623:10: a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5440);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_31_0_0_1_0_0_1, a2_4, true);
            	            						copyLocalizationInfos(a2_4, element);
            	            					}
            	            				}

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[805]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[806]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[807]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[808]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[809]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[810]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[811]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt42 >= 1 ) break loop42;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[822]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[823]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[824]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[825]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[826]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[827]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[828]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_BooleanAndExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_RelationalExpr"
    // Xmu.g:5689:1: parse_edu_ustb_sei_mde_xmu_RelationalExpr returns [edu.ustb.sei.mde.xmu.RelationalExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Xmu.g:5692:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:5693:2: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:5693:2: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt43=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA43_1 = input.LA(2);

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
                    alt43=2;
                }
                else if ( (synpred70_Xmu()) ) {
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
            case 21:
                {
                int LA43_2 = input.LA(2);

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
                    alt43=2;
                }
                else if ( (synpred70_Xmu()) ) {
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

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
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

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
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
            case 48:
                {
                int LA43_5 = input.LA(2);

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
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
            case 46:
                {
                int LA43_6 = input.LA(2);

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
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

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
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

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
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

                if ( (synpred68_Xmu()) ) {
                    alt43=1;
                }
                else if ( (synpred69_Xmu()) ) {
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
                    // Xmu.g:5694:3: a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5500);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5713:6: a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5514);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:5732:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5528);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:5751:6: a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5542);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_0, a0_3, true);
                    				copyLocalizationInfos(a0_3, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[829]);
            	}

            // Xmu.g:5776:2: ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) )
            // Xmu.g:5777:3: (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' )
            {
            // Xmu.g:5777:3: (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' )
            int alt44=5;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt44=1;
                }
                break;
            case 29:
                {
                alt44=2;
                }
                break;
            case 30:
                {
                alt44=3;
                }
                break;
            case 32:
                {
                alt44=4;
                }
                break;
            case 33:
                {
                alt44=5;
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
                    // Xmu.g:5778:4: a1= '='
                    {
                    a1=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5569); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Xmu.g:5791:8: a2= '<'
                    {
                    a2=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5584); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Xmu.g:5804:8: a3= '<='
                    {
                    a3=(Token)match(input,30,FOLLOW_30_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5599); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 4 :
                    // Xmu.g:5817:8: a4= '>'
                    {
                    a4=(Token)match(input,32,FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5614); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 5 :
                    // Xmu.g:5830:8: a5= '>='
                    {
                    a5=(Token)match(input,33,FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5629); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[830]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[831]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[832]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[833]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[834]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[835]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[836]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[837]);
            	}

            // Xmu.g:5857:2: (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA45_1 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (synpred77_Xmu()) ) {
                    alt45=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA45_2 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (synpred77_Xmu()) ) {
                    alt45=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA45_3 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (true) ) {
                    alt45=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA45_4 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (true) ) {
                    alt45=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA45_5 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (true) ) {
                    alt45=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA45_6 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (true) ) {
                    alt45=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA45_7 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (true) ) {
                    alt45=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA45_8 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (true) ) {
                    alt45=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA45_9 = input.LA(2);

                if ( (synpred75_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred76_Xmu()) ) {
                    alt45=2;
                }
                else if ( (true) ) {
                    alt45=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // Xmu.g:5858:3: a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5654);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_2, a8_0, true);
                    				copyLocalizationInfos(a8_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5877:6: a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5668);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_2, a8_1, true);
                    				copyLocalizationInfos(a8_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:5896:6: a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5682);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_2, a8_2, true);
                    				copyLocalizationInfos(a8_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:5915:6: a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5696);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_32_0_0_2, a8_3, true);
                    				copyLocalizationInfos(a8_3, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, parse_edu_ustb_sei_mde_xmu_RelationalExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_RelationalExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_AdditiveExpr"
    // Xmu.g:5958:1: parse_edu_ustb_sei_mde_xmu_AdditiveExpr returns [edu.ustb.sei.mde.xmu.AdditiveExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
    public final edu.ustb.sei.mde.xmu.AdditiveExpr parse_edu_ustb_sei_mde_xmu_AdditiveExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_AdditiveExpr_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a3=null;
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_0 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a0_1 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a0_2 =null;

        edu.ustb.sei.mde.xmu.MultiplicativeExpr a6_0 =null;

        edu.ustb.sei.mde.xmu.UnaryExpr a6_1 =null;

        edu.ustb.sei.mde.xmu.AtomicExpr a6_2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Xmu.g:5961:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5962:2: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5962:2: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA46_1 = input.LA(2);

                if ( (synpred78_Xmu()) ) {
                    alt46=1;
                }
                else if ( (synpred79_Xmu()) ) {
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
            case 21:
                {
                int LA46_2 = input.LA(2);

                if ( (synpred78_Xmu()) ) {
                    alt46=1;
                }
                else if ( (synpred79_Xmu()) ) {
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

                if ( (synpred78_Xmu()) ) {
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

                if ( (synpred78_Xmu()) ) {
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
            case 48:
                {
                int LA46_5 = input.LA(2);

                if ( (synpred78_Xmu()) ) {
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
            case 46:
                {
                int LA46_6 = input.LA(2);

                if ( (synpred78_Xmu()) ) {
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

                if ( (synpred78_Xmu()) ) {
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

                if ( (synpred78_Xmu()) ) {
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

                if ( (synpred78_Xmu()) ) {
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
                    // Xmu.g:5963:3: a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5733);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:5982:6: a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5747);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:6001:6: a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5761);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_33_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[855]);
            	}

            // Xmu.g:6026:2: ( ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0 >= 18 && LA49_0 <= 19)||LA49_0==21) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // Xmu.g:6027:3: ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:6027:3: ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:6028:4: ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    // Xmu.g:6028:4: ( (a1= '+' |a2= '-' |a3= '++' ) )
            	    // Xmu.g:6029:5: (a1= '+' |a2= '-' |a3= '++' )
            	    {
            	    // Xmu.g:6029:5: (a1= '+' |a2= '-' |a3= '++' )
            	    int alt47=3;
            	    switch ( input.LA(1) ) {
            	    case 18:
            	        {
            	        alt47=1;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt47=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt47=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 47, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt47) {
            	        case 1 :
            	            // Xmu.g:6030:6: a1= '+'
            	            {
            	            a1=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5801); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:6043:12: a2= '-'
            	            {
            	            a2=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5820); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }
            	            break;
            	        case 3 :
            	            // Xmu.g:6056:12: a3= '++'
            	            {
            	            a3=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5839); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }
            	            break;

            	    }


            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[856]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[857]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[858]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[859]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[860]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[861]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[862]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[863]);
            	    			}

            	    // Xmu.g:6083:4: (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt48=3;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        int LA48_1 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (synpred83_Xmu()) ) {
            	            alt48=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 1, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 21:
            	        {
            	        int LA48_2 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (synpred83_Xmu()) ) {
            	            alt48=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 2, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NAME:
            	        {
            	        int LA48_3 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (true) ) {
            	            alt48=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 3, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case QUOTED_39_39_92:
            	        {
            	        int LA48_4 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (true) ) {
            	            alt48=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 4, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 48:
            	        {
            	        int LA48_5 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (true) ) {
            	            alt48=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 5, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 46:
            	        {
            	        int LA48_6 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (true) ) {
            	            alt48=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 6, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NUMBER:
            	        {
            	        int LA48_7 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (true) ) {
            	            alt48=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 7, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case BOOLEAN:
            	        {
            	        int LA48_8 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (true) ) {
            	            alt48=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 8, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 15:
            	        {
            	        int LA48_9 = input.LA(2);

            	        if ( (synpred82_Xmu()) ) {
            	            alt48=1;
            	        }
            	        else if ( (true) ) {
            	            alt48=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 48, 9, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 48, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt48) {
            	        case 1 :
            	            // Xmu.g:6084:5: a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5876);
            	            a6_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

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

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:6103:10: a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5896);
            	            a6_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

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

            	            }
            	            break;
            	        case 3 :
            	            // Xmu.g:6122:10: a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5916);
            	            a6_2=parse_edu_ustb_sei_mde_xmu_AtomicExpr();

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

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[864]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[865]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[866]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[867]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[868]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[869]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[870]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[871]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[872]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[873]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[874]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[875]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[876]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[877]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[878]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[879]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[880]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[881]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);


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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[894]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[895]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[896]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[897]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[898]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[899]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, parse_edu_ustb_sei_mde_xmu_AdditiveExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_AdditiveExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr"
    // Xmu.g:6190:1: parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr returns [edu.ustb.sei.mde.xmu.MultiplicativeExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Xmu.g:6193:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:6194:2: (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:6194:2: (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==21||LA50_0==47) ) {
                alt50=1;
            }
            else if ( (LA50_0==BOOLEAN||(LA50_0 >= NAME && LA50_0 <= NUMBER)||LA50_0==QUOTED_39_39_92||LA50_0==15||LA50_0==46||LA50_0==48) ) {
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
                    // Xmu.g:6195:3: a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5976);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:6214:6: a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5990);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[900]);
            	}

            // Xmu.g:6239:2: ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==17||LA53_0==24) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // Xmu.g:6240:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:6240:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:6241:4: ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    // Xmu.g:6241:4: ( (a1= '*' |a2= '/' ) )
            	    // Xmu.g:6242:5: (a1= '*' |a2= '/' )
            	    {
            	    // Xmu.g:6242:5: (a1= '*' |a2= '/' )
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( (LA51_0==17) ) {
            	        alt51=1;
            	    }
            	    else if ( (LA51_0==24) ) {
            	        alt51=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 51, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt51) {
            	        case 1 :
            	            // Xmu.g:6243:6: a1= '*'
            	            {
            	            a1=(Token)match(input,17,FOLLOW_17_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6030); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:6256:12: a2= '/'
            	            {
            	            a2=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6049); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
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

            	            }
            	            break;

            	    }


            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[901]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[902]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[903]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[904]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[905]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[906]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[907]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[908]);
            	    			}

            	    // Xmu.g:6283:4: (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt52=2;
            	    int LA52_0 = input.LA(1);

            	    if ( (LA52_0==21||LA52_0==47) ) {
            	        alt52=1;
            	    }
            	    else if ( (LA52_0==BOOLEAN||(LA52_0 >= NAME && LA52_0 <= NUMBER)||LA52_0==QUOTED_39_39_92||LA52_0==15||LA52_0==46||LA52_0==48) ) {
            	        alt52=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 52, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt52) {
            	        case 1 :
            	            // Xmu.g:6284:5: a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6086);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1_0_0_1, a5_0, true);
            	            						copyLocalizationInfos(a5_0, element);
            	            					}
            	            				}

            	            }
            	            break;
            	        case 2 :
            	            // Xmu.g:6303:10: a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6106);
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
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_34_0_0_1_0_0_1, a5_1, true);
            	            						copyLocalizationInfos(a5_1, element);
            	            					}
            	            				}

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[909]);
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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[922]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[923]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[924]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[925]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[926]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[927]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[928]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[929]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[930]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[931]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[932]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[933]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[934]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[935]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[936]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[937]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[938]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[939]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[940]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[941]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[942]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[943]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[944]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[945]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[946]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_ParenExpr"
    // Xmu.g:6373:1: parse_edu_ustb_sei_mde_xmu_ParenExpr returns [edu.ustb.sei.mde.xmu.ParenExpr element = null] : a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }

            // Xmu.g:6376:2: (a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')' )
            // Xmu.g:6377:2: a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6162); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[947]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[948]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[949]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[950]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[951]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[952]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[953]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[954]);
            	}

            // Xmu.g:6398:2: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt54=7;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA54_1 = input.LA(2);

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt54=5;
                }
                else if ( (synpred94_Xmu()) ) {
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
            case 21:
                {
                int LA54_2 = input.LA(2);

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt54=5;
                }
                else if ( (synpred94_Xmu()) ) {
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

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
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

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
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
            case 48:
                {
                int LA54_5 = input.LA(2);

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
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
            case 46:
                {
                int LA54_6 = input.LA(2);

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
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

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
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

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
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

                if ( (synpred89_Xmu()) ) {
                    alt54=1;
                }
                else if ( (synpred90_Xmu()) ) {
                    alt54=2;
                }
                else if ( (synpred91_Xmu()) ) {
                    alt54=3;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt54=4;
                }
                else if ( (synpred93_Xmu()) ) {
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
                    // Xmu.g:6399:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6180);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_0, true);
                    				copyLocalizationInfos(a1_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:6418:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6194);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_1, true);
                    				copyLocalizationInfos(a1_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:6437:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6208);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_2, true);
                    				copyLocalizationInfos(a1_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:6456:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6222);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_3, true);
                    				copyLocalizationInfos(a1_3, element);
                    			}
                    		}

                    }
                    break;
                case 5 :
                    // Xmu.g:6475:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6236);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_4, true);
                    				copyLocalizationInfos(a1_4, element);
                    			}
                    		}

                    }
                    break;
                case 6 :
                    // Xmu.g:6494:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6250);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_5, true);
                    				copyLocalizationInfos(a1_5, element);
                    			}
                    		}

                    }
                    break;
                case 7 :
                    // Xmu.g:6513:6: a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6264);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_1, a1_6, true);
                    				copyLocalizationInfos(a1_6, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[955]);
            	}

            a2=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6282); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createParenExpr();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_35_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[956]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[957]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[958]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[959]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[970]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[971]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[972]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[973]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[974]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[975]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[976]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[977]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 37, parse_edu_ustb_sei_mde_xmu_ParenExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_ParenExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_UnaryExpr"
    // Xmu.g:6575:1: parse_edu_ustb_sei_mde_xmu_UnaryExpr returns [edu.ustb.sei.mde.xmu.UnaryExpr element = null] : ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
    public final edu.ustb.sei.mde.xmu.UnaryExpr parse_edu_ustb_sei_mde_xmu_UnaryExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_UnaryExpr_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.xmu.AtomicExpr a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Xmu.g:6578:2: ( ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:6579:2: ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:6579:2: ( (a0= 'not' |a1= '-' ) )
            // Xmu.g:6580:3: (a0= 'not' |a1= '-' )
            {
            // Xmu.g:6580:3: (a0= 'not' |a1= '-' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==47) ) {
                alt55=1;
            }
            else if ( (LA55_0==21) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // Xmu.g:6581:4: a0= 'not'
                    {
                    a0=(Token)match(input,47,FOLLOW_47_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6320); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Xmu.g:6594:8: a1= '-'
                    {
                    a1=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6335); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[978]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[979]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[980]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[981]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[982]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[983]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[984]);
            	}

            // Xmu.g:6620:2: (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            // Xmu.g:6621:3: a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6360);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_36_0_0_1, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[996]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[997]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[998]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[999]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1000]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1001]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1002]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1003]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1004]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 38, parse_edu_ustb_sei_mde_xmu_UnaryExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_UnaryExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_PrintStatement"
    // Xmu.g:6667:1: parse_edu_ustb_sei_mde_xmu_PrintStatement returns [edu.ustb.sei.mde.xmu.PrintStatement element = null] : a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return element; }

            // Xmu.g:6670:2: (a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:6671:2: a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            a0=(Token)match(input,50,FOLLOW_50_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6393); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createPrintStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1005]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1006]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1007]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1008]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1009]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1010]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1011]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1012]);
            	}

            // Xmu.g:6692:2: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt56=7;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA56_1 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (synpred101_Xmu()) ) {
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
            case 21:
                {
                int LA56_2 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt56=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA56_3 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (true) ) {
                    alt56=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA56_4 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (true) ) {
                    alt56=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA56_5 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (true) ) {
                    alt56=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA56_6 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (true) ) {
                    alt56=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA56_7 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (true) ) {
                    alt56=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA56_8 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (true) ) {
                    alt56=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA56_9 = input.LA(2);

                if ( (synpred96_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred97_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred98_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt56=5;
                }
                else if ( (true) ) {
                    alt56=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 9, input);

                    throw nvae;

                }
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
                    // Xmu.g:6693:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6411);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_0, true);
                    				copyLocalizationInfos(a1_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Xmu.g:6712:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6425);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_1, true);
                    				copyLocalizationInfos(a1_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Xmu.g:6731:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6439);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_2, true);
                    				copyLocalizationInfos(a1_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Xmu.g:6750:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6453);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_3, true);
                    				copyLocalizationInfos(a1_3, element);
                    			}
                    		}

                    }
                    break;
                case 5 :
                    // Xmu.g:6769:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6467);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_4, true);
                    				copyLocalizationInfos(a1_4, element);
                    			}
                    		}

                    }
                    break;
                case 6 :
                    // Xmu.g:6788:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6481);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_5, true);
                    				copyLocalizationInfos(a1_5, element);
                    			}
                    		}

                    }
                    break;
                case 7 :
                    // Xmu.g:6807:6: a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6495);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_37_0_0_1, a1_6, true);
                    				copyLocalizationInfos(a1_6, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1013]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1014]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1015]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1016]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1017]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1018]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1019]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 39, parse_edu_ustb_sei_mde_xmu_PrintStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_PrintStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_AllInstanceExpr"
    // Xmu.g:6840:1: parse_edu_ustb_sei_mde_xmu_AllInstanceExpr returns [edu.ustb.sei.mde.xmu.AllInstanceExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) a1= '//' (a2= NAME ) ;
    public final edu.ustb.sei.mde.xmu.AllInstanceExpr parse_edu_ustb_sei_mde_xmu_AllInstanceExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AllInstanceExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_AllInstanceExpr_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.StartRoot a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }

            // Xmu.g:6843:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) a1= '//' (a2= NAME ) )
            // Xmu.g:6844:2: (a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) a1= '//' (a2= NAME )
            {
            // Xmu.g:6844:2: (a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot )
            // Xmu.g:6845:3: a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6532);
            a0_0=parse_edu_ustb_sei_mde_xmu_StartRoot();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1020]);
            	}

            a1=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6550); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.xmu.XmuFactory.eINSTANCE.createAllInstanceExpr();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_38_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1021]);
            	}

            // Xmu.g:6884:2: (a2= NAME )
            // Xmu.g:6885:3: a2= NAME
            {
            a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6568); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1022]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1023]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1024]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1025]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1026]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 40, parse_edu_ustb_sei_mde_xmu_AllInstanceExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_AllInstanceExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Statement"
    // Xmu.g:6930:1: parse_edu_ustb_sei_mde_xmu_Statement returns [edu.ustb.sei.mde.xmu.Statement element = null] : (c0= parse_edu_ustb_sei_mde_xmu_ForStatement |c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement |c2= parse_edu_ustb_sei_mde_xmu_BlockStatement |c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement |c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement |c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern |c6= parse_edu_ustb_sei_mde_xmu_DeleteNode |c7= parse_edu_ustb_sei_mde_xmu_DeleteLink |c8= parse_edu_ustb_sei_mde_xmu_PrintStatement );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return element; }

            // Xmu.g:6931:2: (c0= parse_edu_ustb_sei_mde_xmu_ForStatement |c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement |c2= parse_edu_ustb_sei_mde_xmu_BlockStatement |c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement |c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement |c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern |c6= parse_edu_ustb_sei_mde_xmu_DeleteNode |c7= parse_edu_ustb_sei_mde_xmu_DeleteLink |c8= parse_edu_ustb_sei_mde_xmu_PrintStatement )
            int alt57=9;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt57=1;
                }
                break;
            case 59:
                {
                alt57=2;
                }
                break;
            case 64:
                {
                alt57=3;
                }
                break;
            case 55:
                {
                alt57=4;
                }
                break;
            case NAME:
                {
                alt57=5;
                }
                break;
            case 41:
                {
                alt57=6;
                }
                break;
            case 40:
                {
                int LA57_7 = input.LA(2);

                if ( (LA57_7==NAME) ) {
                    int LA57_9 = input.LA(3);

                    if ( (LA57_9==EOF||LA57_9==28||LA57_9==38||LA57_9==45||(LA57_9 >= 56 && LA57_9 <= 57)||LA57_9==66) ) {
                        alt57=7;
                    }
                    else if ( (LA57_9==23) ) {
                        alt57=8;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 57, 9, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 7, input);

                    throw nvae;

                }
                }
                break;
            case 50:
                {
                alt57=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // Xmu.g:6932:2: c0= parse_edu_ustb_sei_mde_xmu_ForStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ForStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6600);
                    c0=parse_edu_ustb_sei_mde_xmu_ForStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6933:4: c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6610);
                    c1=parse_edu_ustb_sei_mde_xmu_UpdatedStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6934:4: c2= parse_edu_ustb_sei_mde_xmu_BlockStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BlockStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6620);
                    c2=parse_edu_ustb_sei_mde_xmu_BlockStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6935:4: c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_SwitchStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6630);
                    c3=parse_edu_ustb_sei_mde_xmu_SwitchStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6936:4: c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RuleCallStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6640);
                    c4=parse_edu_ustb_sei_mde_xmu_RuleCallStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6937:4: c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Statement6650);
                    c5=parse_edu_ustb_sei_mde_xmu_UpdatePattern();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6938:4: c6= parse_edu_ustb_sei_mde_xmu_DeleteNode
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteNode_in_parse_edu_ustb_sei_mde_xmu_Statement6660);
                    c6=parse_edu_ustb_sei_mde_xmu_DeleteNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Xmu.g:6939:4: c7= parse_edu_ustb_sei_mde_xmu_DeleteLink
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteLink_in_parse_edu_ustb_sei_mde_xmu_Statement6670);
                    c7=parse_edu_ustb_sei_mde_xmu_DeleteLink();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Xmu.g:6940:4: c8= parse_edu_ustb_sei_mde_xmu_PrintStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PrintStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6680);
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
            if ( state.backtracking>0 ) { memoize(input, 41, parse_edu_ustb_sei_mde_xmu_Statement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Statement"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_AtomicExpr"
    // Xmu.g:6944:1: parse_edu_ustb_sei_mde_xmu_AtomicExpr returns [edu.ustb.sei.mde.xmu.AtomicExpr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_ParenExpr );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return element; }

            // Xmu.g:6945:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_ParenExpr )
            int alt58=7;
            switch ( input.LA(1) ) {
            case NAME:
                {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==EOF||(LA58_1 >= 16 && LA58_1 <= 24)||(LA58_1 >= 28 && LA58_1 <= 33)||(LA58_1 >= 35 && LA58_1 <= 36)||LA58_1==38||LA58_1==45||LA58_1==49||(LA58_1 >= 56 && LA58_1 <= 57)||LA58_1==66) ) {
                    alt58=1;
                }
                else if ( (LA58_1==27) ) {
                    alt58=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                alt58=2;
                }
                break;
            case 46:
            case 48:
                {
                alt58=3;
                }
                break;
            case NUMBER:
                {
                alt58=4;
                }
                break;
            case BOOLEAN:
                {
                alt58=5;
                }
                break;
            case 15:
                {
                alt58=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }

            switch (alt58) {
                case 1 :
                    // Xmu.g:6946:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6701);
                    c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6947:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6711);
                    c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6948:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6721);
                    c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6949:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6731);
                    c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6950:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6741);
                    c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6951:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6751);
                    c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6952:4: c6= parse_edu_ustb_sei_mde_xmu_ParenExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6761);
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
            if ( state.backtracking>0 ) { memoize(input, 42, parse_edu_ustb_sei_mde_xmu_AtomicExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_AtomicExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_PatternExpr"
    // Xmu.g:6956:1: parse_edu_ustb_sei_mde_xmu_PatternExpr returns [edu.ustb.sei.mde.xmu.PatternExpr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr |c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr );
    public final edu.ustb.sei.mde.xmu.PatternExpr parse_edu_ustb_sei_mde_xmu_PatternExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_PatternExpr_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.PatternReferenceExpr c0 =null;

        edu.ustb.sei.mde.xmu.PatternEqualExpr c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return element; }

            // Xmu.g:6957:2: (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr |c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==NAME) ) {
                int LA59_1 = input.LA(2);

                if ( (synpred116_Xmu()) ) {
                    alt59=1;
                }
                else if ( (true) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }
            switch (alt59) {
                case 1 :
                    // Xmu.g:6958:2: c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6782);
                    c0=parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6959:4: c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6792);
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
            if ( state.backtracking>0 ) { memoize(input, 43, parse_edu_ustb_sei_mde_xmu_PatternExpr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_PatternExpr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Path"
    // Xmu.g:6963:1: parse_edu_ustb_sei_mde_xmu_Path returns [edu.ustb.sei.mde.xmu.Path element = null] : (c0= parse_edu_ustb_sei_mde_xmu_FeaturePath |c1= parse_edu_ustb_sei_mde_xmu_LoopPath |c2= parse_edu_ustb_sei_mde_xmu_OperationPath );
    public final edu.ustb.sei.mde.xmu.Path parse_edu_ustb_sei_mde_xmu_Path() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Path element =  null;

        int parse_edu_ustb_sei_mde_xmu_Path_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.FeaturePath c0 =null;

        edu.ustb.sei.mde.xmu.LoopPath c1 =null;

        edu.ustb.sei.mde.xmu.OperationPath c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return element; }

            // Xmu.g:6964:2: (c0= parse_edu_ustb_sei_mde_xmu_FeaturePath |c1= parse_edu_ustb_sei_mde_xmu_LoopPath |c2= parse_edu_ustb_sei_mde_xmu_OperationPath )
            int alt60=3;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==23) ) {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==NAME) ) {
                    int LA60_3 = input.LA(3);

                    if ( (LA60_3==EOF||(LA60_3 >= 16 && LA60_3 <= 24)||(LA60_3 >= 28 && LA60_3 <= 33)||(LA60_3 >= 35 && LA60_3 <= 36)||LA60_3==38||LA60_3==45||LA60_3==49||(LA60_3 >= 56 && LA60_3 <= 57)||LA60_3==66) ) {
                        alt60=1;
                    }
                    else if ( (LA60_3==15) ) {
                        alt60=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA60_0==22) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // Xmu.g:6965:2: c0= parse_edu_ustb_sei_mde_xmu_FeaturePath
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_FeaturePath_in_parse_edu_ustb_sei_mde_xmu_Path6813);
                    c0=parse_edu_ustb_sei_mde_xmu_FeaturePath();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6966:4: c1= parse_edu_ustb_sei_mde_xmu_LoopPath
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_LoopPath_in_parse_edu_ustb_sei_mde_xmu_Path6823);
                    c1=parse_edu_ustb_sei_mde_xmu_LoopPath();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6967:4: c2= parse_edu_ustb_sei_mde_xmu_OperationPath
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_OperationPath_in_parse_edu_ustb_sei_mde_xmu_Path6833);
                    c2=parse_edu_ustb_sei_mde_xmu_OperationPath();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 44, parse_edu_ustb_sei_mde_xmu_Path_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Path"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Variable"
    // Xmu.g:6971:1: parse_edu_ustb_sei_mde_xmu_Variable returns [edu.ustb.sei.mde.xmu.Variable element = null] : c0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ;
    public final edu.ustb.sei.mde.xmu.Variable parse_edu_ustb_sei_mde_xmu_Variable() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Variable element =  null;

        int parse_edu_ustb_sei_mde_xmu_Variable_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.PrimitiveVariable c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return element; }

            // Xmu.g:6972:2: (c0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable )
            // Xmu.g:6973:2: c0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Variable6854);
            c0=parse_edu_ustb_sei_mde_xmu_PrimitiveVariable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 45, parse_edu_ustb_sei_mde_xmu_Variable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Variable"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_Expr"
    // Xmu.g:6977:1: parse_edu_ustb_sei_mde_xmu_Expr returns [edu.ustb.sei.mde.xmu.Expr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr |c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |c11= parse_edu_ustb_sei_mde_xmu_ParenExpr |c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr |c13= parse_edu_ustb_sei_mde_xmu_AllInstanceExpr );
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

        edu.ustb.sei.mde.xmu.AllInstanceExpr c13 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return element; }

            // Xmu.g:6978:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr |c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |c11= parse_edu_ustb_sei_mde_xmu_ParenExpr |c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr |c13= parse_edu_ustb_sei_mde_xmu_AllInstanceExpr )
            int alt61=14;
            switch ( input.LA(1) ) {
            case NAME:
                {
                int LA61_1 = input.LA(2);

                if ( (synpred119_Xmu()) ) {
                    alt61=1;
                }
                else if ( (synpred124_Xmu()) ) {
                    alt61=6;
                }
                else if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA61_2 = input.LA(2);

                if ( (synpred120_Xmu()) ) {
                    alt61=2;
                }
                else if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 2, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA61_3 = input.LA(2);

                if ( (synpred121_Xmu()) ) {
                    alt61=3;
                }
                else if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 3, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA61_4 = input.LA(2);

                if ( (synpred121_Xmu()) ) {
                    alt61=3;
                }
                else if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 4, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA61_5 = input.LA(2);

                if ( (synpred122_Xmu()) ) {
                    alt61=4;
                }
                else if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 5, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA61_6 = input.LA(2);

                if ( (synpred123_Xmu()) ) {
                    alt61=5;
                }
                else if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 6, input);

                    throw nvae;

                }
                }
                break;
            case 47:
                {
                int LA61_7 = input.LA(2);

                if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt61=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 7, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA61_8 = input.LA(2);

                if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt61=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA61_9 = input.LA(2);

                if ( (synpred125_Xmu()) ) {
                    alt61=7;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt61=8;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt61=9;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt61=10;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt61=11;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt61=12;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 9, input);

                    throw nvae;

                }
                }
                break;
            case 39:
            case 53:
            case 61:
                {
                alt61=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // Xmu.g:6979:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_Expr6875);
                    c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6980:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6885);
                    c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6981:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6895);
                    c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6982:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6905);
                    c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6983:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6915);
                    c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6984:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6925);
                    c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6985:4: c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6935);
                    c6=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Xmu.g:6986:4: c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6945);
                    c7=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Xmu.g:6987:4: c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6955);
                    c8=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Xmu.g:6988:4: c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6965);
                    c9=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 11 :
                    // Xmu.g:6989:4: c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6975);
                    c10=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c10; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 12 :
                    // Xmu.g:6990:4: c11= parse_edu_ustb_sei_mde_xmu_ParenExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6985);
                    c11=parse_edu_ustb_sei_mde_xmu_ParenExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c11; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 13 :
                    // Xmu.g:6991:4: c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6995);
                    c12=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c12; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 14 :
                    // Xmu.g:6992:4: c13= parse_edu_ustb_sei_mde_xmu_AllInstanceExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7005);
                    c13=parse_edu_ustb_sei_mde_xmu_AllInstanceExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c13; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 46, parse_edu_ustb_sei_mde_xmu_Expr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_Expr"



    // $ANTLR start "parse_edu_ustb_sei_mde_xmu_CaseSubStatement"
    // Xmu.g:6996:1: parse_edu_ustb_sei_mde_xmu_CaseSubStatement returns [edu.ustb.sei.mde.xmu.CaseSubStatement element = null] : (c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement |c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement );
    public final edu.ustb.sei.mde.xmu.CaseSubStatement parse_edu_ustb_sei_mde_xmu_CaseSubStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CaseSubStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CaseSubStatement_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.CasePatternStatement c0 =null;

        edu.ustb.sei.mde.xmu.CaseValueStatement c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return element; }

            // Xmu.g:6997:2: (c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement |c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==38) ) {
                switch ( input.LA(2) ) {
                case NAME:
                    {
                    int LA62_2 = input.LA(3);

                    if ( (LA62_2==26) ) {
                        alt62=1;
                    }
                    else if ( ((LA62_2 >= 17 && LA62_2 <= 19)||(LA62_2 >= 21 && LA62_2 <= 24)||LA62_2==27||(LA62_2 >= 29 && LA62_2 <= 33)||LA62_2==36||LA62_2==49) ) {
                        alt62=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 2, input);

                        throw nvae;

                    }
                    }
                    break;
                case 41:
                    {
                    alt62=1;
                    }
                    break;
                case BOOLEAN:
                case NUMBER:
                case QUOTED_39_39_92:
                case 15:
                case 21:
                case 39:
                case 46:
                case 47:
                case 48:
                case 53:
                case 61:
                    {
                    alt62=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }
            switch (alt62) {
                case 1 :
                    // Xmu.g:6998:2: c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CasePatternStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement7026);
                    c0=parse_edu_ustb_sei_mde_xmu_CasePatternStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6999:4: c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseValueStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement7036);
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
            if ( state.backtracking>0 ) { memoize(input, 47, parse_edu_ustb_sei_mde_xmu_CaseSubStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_xmu_CaseSubStatement"

    // $ANTLR start synpred17_Xmu
    public final void synpred17_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VStatement a11_0 =null;


        // Xmu.g:1905:6: ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )
        // Xmu.g:1905:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
        {
        // Xmu.g:1905:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
        // Xmu.g:1906:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
        {
        // Xmu.g:1906:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
        // Xmu.g:1907:8: a11_0= parse_edu_ustb_sei_mde_xmu_VStatement
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


        // Xmu.g:1871:4: ( ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? ) )
        // Xmu.g:1871:4: ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? )
        {
        // Xmu.g:1871:4: ( (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )? )
        // Xmu.g:1872:5: (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )?
        {
        // Xmu.g:1872:5: (a10_0= parse_edu_ustb_sei_mde_xmu_VStatement )
        // Xmu.g:1873:6: a10_0= parse_edu_ustb_sei_mde_xmu_VStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1684);
        a10_0=parse_edu_ustb_sei_mde_xmu_VStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        // Xmu.g:1904:5: ( ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) ) )?
        int alt68=2;
        int LA68_0 = input.LA(1);

        if ( (LA68_0==45||(LA68_0 >= 56 && LA68_0 <= 57)) ) {
            alt68=1;
        }
        switch (alt68) {
            case 1 :
                // Xmu.g:1905:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
                {
                // Xmu.g:1905:6: ( (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement ) )
                // Xmu.g:1906:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                {
                // Xmu.g:1906:7: (a11_0= parse_edu_ustb_sei_mde_xmu_VStatement )
                // Xmu.g:1907:8: a11_0= parse_edu_ustb_sei_mde_xmu_VStatement
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


        // Xmu.g:2291:5: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:2291:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
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


        // Xmu.g:2310:10: (a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:2310:10: a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
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


        // Xmu.g:2329:10: (a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:2329:10: a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
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


        // Xmu.g:2348:10: (a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:2348:10: a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
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


        // Xmu.g:2367:10: (a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:2367:10: a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
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


        // Xmu.g:2386:10: (a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:2386:10: a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred26_Xmu2241);
        a2_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred26_Xmu

    // $ANTLR start synpred36_Xmu
    public final void synpred36_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a9_0 =null;


        // Xmu.g:3371:3: (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:3371:3: a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred36_Xmu3245);
        a9_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred36_Xmu

    // $ANTLR start synpred37_Xmu
    public final void synpred37_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a9_1 =null;


        // Xmu.g:3390:6: (a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:3390:6: a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred37_Xmu3259);
        a9_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred37_Xmu

    // $ANTLR start synpred38_Xmu
    public final void synpred38_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a9_2 =null;


        // Xmu.g:3409:6: (a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:3409:6: a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred38_Xmu3273);
        a9_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred38_Xmu

    // $ANTLR start synpred39_Xmu
    public final void synpred39_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a9_3 =null;


        // Xmu.g:3428:6: (a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:3428:6: a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred39_Xmu3287);
        a9_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred39_Xmu

    // $ANTLR start synpred40_Xmu
    public final void synpred40_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a9_4 =null;


        // Xmu.g:3447:6: (a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:3447:6: a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred40_Xmu3301);
        a9_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred40_Xmu

    // $ANTLR start synpred41_Xmu
    public final void synpred41_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a9_5 =null;


        // Xmu.g:3466:6: (a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:3466:6: a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred41_Xmu3315);
        a9_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred41_Xmu

    // $ANTLR start synpred52_Xmu
    public final void synpred52_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a0_0 =null;


        // Xmu.g:5190:3: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:5190:3: a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred52_Xmu5036);
        a0_0=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred52_Xmu

    // $ANTLR start synpred53_Xmu
    public final void synpred53_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a0_1 =null;


        // Xmu.g:5209:6: (a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5209:6: a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred53_Xmu5050);
        a0_1=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred53_Xmu

    // $ANTLR start synpred54_Xmu
    public final void synpred54_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_2 =null;


        // Xmu.g:5228:6: (a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5228:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred54_Xmu5064);
        a0_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred54_Xmu

    // $ANTLR start synpred55_Xmu
    public final void synpred55_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a2_0 =null;


        // Xmu.g:5296:5: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:5296:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred55_Xmu5131);
        a2_0=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred55_Xmu

    // $ANTLR start synpred56_Xmu
    public final void synpred56_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a2_1 =null;


        // Xmu.g:5315:10: (a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5315:10: a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred56_Xmu5151);
        a2_1=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred56_Xmu

    // $ANTLR start synpred57_Xmu
    public final void synpred57_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a2_2 =null;


        // Xmu.g:5334:10: (a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5334:10: a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred57_Xmu5171);
        a2_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred57_Xmu

    // $ANTLR start synpred59_Xmu
    public final void synpred59_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a0_0 =null;


        // Xmu.g:5422:3: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5422:3: a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred59_Xmu5251);
        a0_0=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred59_Xmu

    // $ANTLR start synpred60_Xmu
    public final void synpred60_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a0_1 =null;


        // Xmu.g:5441:6: (a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5441:6: a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred60_Xmu5265);
        a0_1=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred60_Xmu

    // $ANTLR start synpred61_Xmu
    public final void synpred61_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_2 =null;


        // Xmu.g:5460:6: (a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5460:6: a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred61_Xmu5279);
        a0_2=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred61_Xmu

    // $ANTLR start synpred62_Xmu
    public final void synpred62_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_3 =null;


        // Xmu.g:5479:6: (a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5479:6: a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred62_Xmu5293);
        a0_3=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred62_Xmu

    // $ANTLR start synpred63_Xmu
    public final void synpred63_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a2_0 =null;


        // Xmu.g:5547:5: (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5547:5: a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred63_Xmu5360);
        a2_0=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred63_Xmu

    // $ANTLR start synpred64_Xmu
    public final void synpred64_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a2_1 =null;


        // Xmu.g:5566:10: (a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5566:10: a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred64_Xmu5380);
        a2_1=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred64_Xmu

    // $ANTLR start synpred65_Xmu
    public final void synpred65_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a2_2 =null;


        // Xmu.g:5585:10: (a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5585:10: a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred65_Xmu5400);
        a2_2=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred65_Xmu

    // $ANTLR start synpred66_Xmu
    public final void synpred66_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a2_3 =null;


        // Xmu.g:5604:10: (a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5604:10: a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred66_Xmu5420);
        a2_3=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred66_Xmu

    // $ANTLR start synpred68_Xmu
    public final void synpred68_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a0_0 =null;


        // Xmu.g:5694:3: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5694:3: a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred68_Xmu5500);
        a0_0=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred68_Xmu

    // $ANTLR start synpred69_Xmu
    public final void synpred69_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_1 =null;


        // Xmu.g:5713:6: (a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5713:6: a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred69_Xmu5514);
        a0_1=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred69_Xmu

    // $ANTLR start synpred70_Xmu
    public final void synpred70_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_2 =null;


        // Xmu.g:5732:6: (a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5732:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred70_Xmu5528);
        a0_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred70_Xmu

    // $ANTLR start synpred75_Xmu
    public final void synpred75_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a8_0 =null;


        // Xmu.g:5858:3: (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5858:3: a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred75_Xmu5654);
        a8_0=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred75_Xmu

    // $ANTLR start synpred76_Xmu
    public final void synpred76_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a8_1 =null;


        // Xmu.g:5877:6: (a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5877:6: a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred76_Xmu5668);
        a8_1=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred76_Xmu

    // $ANTLR start synpred77_Xmu
    public final void synpred77_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a8_2 =null;


        // Xmu.g:5896:6: (a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5896:6: a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred77_Xmu5682);
        a8_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred77_Xmu

    // $ANTLR start synpred78_Xmu
    public final void synpred78_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_0 =null;


        // Xmu.g:5963:3: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5963:3: a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred78_Xmu5733);
        a0_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred78_Xmu

    // $ANTLR start synpred79_Xmu
    public final void synpred79_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_1 =null;


        // Xmu.g:5982:6: (a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5982:6: a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred79_Xmu5747);
        a0_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred79_Xmu

    // $ANTLR start synpred82_Xmu
    public final void synpred82_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a6_0 =null;


        // Xmu.g:6084:5: (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6084:5: a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred82_Xmu5876);
        a6_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred82_Xmu

    // $ANTLR start synpred83_Xmu
    public final void synpred83_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a6_1 =null;


        // Xmu.g:6103:10: (a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6103:10: a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred83_Xmu5896);
        a6_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred83_Xmu

    // $ANTLR start synpred89_Xmu
    public final void synpred89_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a1_0 =null;


        // Xmu.g:6399:3: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6399:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred89_Xmu6180);
        a1_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred89_Xmu

    // $ANTLR start synpred90_Xmu
    public final void synpred90_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a1_1 =null;


        // Xmu.g:6418:6: (a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6418:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred90_Xmu6194);
        a1_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred90_Xmu

    // $ANTLR start synpred91_Xmu
    public final void synpred91_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a1_2 =null;


        // Xmu.g:6437:6: (a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6437:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred91_Xmu6208);
        a1_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred91_Xmu

    // $ANTLR start synpred92_Xmu
    public final void synpred92_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a1_3 =null;


        // Xmu.g:6456:6: (a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6456:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred92_Xmu6222);
        a1_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred92_Xmu

    // $ANTLR start synpred93_Xmu
    public final void synpred93_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a1_4 =null;


        // Xmu.g:6475:6: (a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6475:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred93_Xmu6236);
        a1_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred93_Xmu

    // $ANTLR start synpred94_Xmu
    public final void synpred94_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a1_5 =null;


        // Xmu.g:6494:6: (a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6494:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred94_Xmu6250);
        a1_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred94_Xmu

    // $ANTLR start synpred96_Xmu
    public final void synpred96_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a1_0 =null;


        // Xmu.g:6693:3: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6693:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred96_Xmu6411);
        a1_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred96_Xmu

    // $ANTLR start synpred97_Xmu
    public final void synpred97_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a1_1 =null;


        // Xmu.g:6712:6: (a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6712:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred97_Xmu6425);
        a1_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred97_Xmu

    // $ANTLR start synpred98_Xmu
    public final void synpred98_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a1_2 =null;


        // Xmu.g:6731:6: (a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6731:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred98_Xmu6439);
        a1_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred98_Xmu

    // $ANTLR start synpred99_Xmu
    public final void synpred99_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a1_3 =null;


        // Xmu.g:6750:6: (a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6750:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred99_Xmu6453);
        a1_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred99_Xmu

    // $ANTLR start synpred100_Xmu
    public final void synpred100_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a1_4 =null;


        // Xmu.g:6769:6: (a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6769:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred100_Xmu6467);
        a1_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred100_Xmu

    // $ANTLR start synpred101_Xmu
    public final void synpred101_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a1_5 =null;


        // Xmu.g:6788:6: (a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6788:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred101_Xmu6481);
        a1_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred101_Xmu

    // $ANTLR start synpred116_Xmu
    public final void synpred116_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternReferenceExpr c0 =null;


        // Xmu.g:6958:2: (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr )
        // Xmu.g:6958:2: c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_synpred116_Xmu6782);
        c0=parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred116_Xmu

    // $ANTLR start synpred119_Xmu
    public final void synpred119_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VariableExp c0 =null;


        // Xmu.g:6979:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp )
        // Xmu.g:6979:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_synpred119_Xmu6875);
        c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_Xmu

    // $ANTLR start synpred120_Xmu
    public final void synpred120_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.StringLiteral c1 =null;


        // Xmu.g:6980:4: (c1= parse_edu_ustb_sei_mde_xmu_StringLiteral )
        // Xmu.g:6980:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_synpred120_Xmu6885);
        c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred120_Xmu

    // $ANTLR start synpred121_Xmu
    public final void synpred121_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EmptyLiteral c2 =null;


        // Xmu.g:6981:4: (c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral )
        // Xmu.g:6981:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_synpred121_Xmu6895);
        c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred121_Xmu

    // $ANTLR start synpred122_Xmu
    public final void synpred122_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.IntegerLiteral c3 =null;


        // Xmu.g:6982:4: (c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral )
        // Xmu.g:6982:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_synpred122_Xmu6905);
        c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred122_Xmu

    // $ANTLR start synpred123_Xmu
    public final void synpred123_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanLiteral c4 =null;


        // Xmu.g:6983:4: (c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral )
        // Xmu.g:6983:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_synpred123_Xmu6915);
        c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred123_Xmu

    // $ANTLR start synpred124_Xmu
    public final void synpred124_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EnumLiteral c5 =null;


        // Xmu.g:6984:4: (c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral )
        // Xmu.g:6984:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_synpred124_Xmu6925);
        c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred124_Xmu

    // $ANTLR start synpred125_Xmu
    public final void synpred125_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr c6 =null;


        // Xmu.g:6985:4: (c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6985:4: c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred125_Xmu6935);
        c6=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred125_Xmu

    // $ANTLR start synpred126_Xmu
    public final void synpred126_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr c7 =null;


        // Xmu.g:6986:4: (c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6986:4: c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred126_Xmu6945);
        c7=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred126_Xmu

    // $ANTLR start synpred127_Xmu
    public final void synpred127_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr c8 =null;


        // Xmu.g:6987:4: (c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6987:4: c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred127_Xmu6955);
        c8=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred127_Xmu

    // $ANTLR start synpred128_Xmu
    public final void synpred128_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr c9 =null;


        // Xmu.g:6988:4: (c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6988:4: c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred128_Xmu6965);
        c9=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred128_Xmu

    // $ANTLR start synpred129_Xmu
    public final void synpred129_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr c10 =null;


        // Xmu.g:6989:4: (c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6989:4: c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred129_Xmu6975);
        c10=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred129_Xmu

    // $ANTLR start synpred130_Xmu
    public final void synpred130_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.ParenExpr c11 =null;


        // Xmu.g:6990:4: (c11= parse_edu_ustb_sei_mde_xmu_ParenExpr )
        // Xmu.g:6990:4: c11= parse_edu_ustb_sei_mde_xmu_ParenExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_synpred130_Xmu6985);
        c11=parse_edu_ustb_sei_mde_xmu_ParenExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred130_Xmu

    // $ANTLR start synpred131_Xmu
    public final void synpred131_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr c12 =null;


        // Xmu.g:6991:4: (c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6991:4: c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred131_Xmu6995);
        c12=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred131_Xmu

    // Delegated rules

    public final boolean synpred130_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred122_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred99_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred38_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred123_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred123_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred131_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred131_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred65_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred129_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred129_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred128_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred59_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred121_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred93_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred94_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred126_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred77_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred127_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred78_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred36_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred79_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred97_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred125_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_Xmu_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_44_in_parse_edu_ustb_sei_mde_xmu_XMUModel124 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_URI_in_parse_edu_ustb_sei_mde_xmu_XMUModel150 = new BitSet(new long[]{0x0040100000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StartStatement_in_parse_edu_ustb_sei_mde_xmu_XMUModel205 = new BitSet(new long[]{0x0048000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Rule_in_parse_edu_ustb_sei_mde_xmu_XMUModel240 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_54_in_parse_edu_ustb_sei_mde_xmu_StartStatement281 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_StartStatement299 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_StartStatement320 = new BitSet(new long[]{0x2020008000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_StartStatement338 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_StartStatement365 = new BitSet(new long[]{0x2020008000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_StartStatement391 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_StartStatement432 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_StartStatement446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_parse_edu_ustb_sei_mde_xmu_StartRoot484 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_61_in_parse_edu_ustb_sei_mde_xmu_StartRoot499 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_39_in_parse_edu_ustb_sei_mde_xmu_StartRoot514 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_StartRoot535 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_StartRoot553 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_StartRoot574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_parse_edu_ustb_sei_mde_xmu_Rule603 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_Rule621 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000001L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_Rule651 = new BitSet(new long[]{0x2020008000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Parameter_in_parse_edu_ustb_sei_mde_xmu_Rule677 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_Rule718 = new BitSet(new long[]{0x2020008000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Parameter_in_parse_edu_ustb_sei_mde_xmu_Rule752 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_Rule813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_Rule846 = new BitSet(new long[]{0x1C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_60_in_parse_edu_ustb_sei_mde_xmu_Rule869 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Rule895 = new BitSet(new long[]{0x0C84030000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_Rule936 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Rule970 = new BitSet(new long[]{0x0C84030000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_Rule1048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_Rule1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_parse_edu_ustb_sei_mde_xmu_Parameter1104 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_61_in_parse_edu_ustb_sei_mde_xmu_Parameter1119 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_39_in_parse_edu_ustb_sei_mde_xmu_Parameter1134 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_Parameter1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIMITIVE_in_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable1199 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_parse_edu_ustb_sei_mde_xmu_ForStatement1260 = new BitSet(new long[]{0x0000020000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_ForStatement1278 = new BitSet(new long[]{0x8000002000000000L});
    public static final BitSet FOLLOW_63_in_parse_edu_ustb_sei_mde_xmu_ForStatement1305 = new BitSet(new long[]{0x0000020000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_ForStatement1331 = new BitSet(new long[]{0x4000002000000000L});
    public static final BitSet FOLLOW_62_in_parse_edu_ustb_sei_mde_xmu_ForStatement1372 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1406 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_ForStatement1461 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1503 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_parse_edu_ustb_sei_mde_xmu_ForStatement1620 = new BitSet(new long[]{0x0300200000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1643 = new BitSet(new long[]{0x0300200000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1684 = new BitSet(new long[]{0x0300200000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_parse_edu_ustb_sei_mde_xmu_ForStatement1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1852 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1866 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1884 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1905 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1923 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_edu_ustb_sei_mde_xmu_VStatement1982 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_57_in_parse_edu_ustb_sei_mde_xmu_VStatement1997 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_56_in_parse_edu_ustb_sei_mde_xmu_VStatement2012 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_VStatement2033 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_VStatement2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_Pattern2088 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_Pattern2115 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2141 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2161 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2181 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2201 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2221 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2241 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2261 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_Pattern2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Pattern2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2356 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_PatternNode2377 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_PatternNode2416 = new BitSet(new long[]{0x0000000000000080L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2445 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000004L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_PatternNode2486 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2520 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_PatternNode2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2627 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2657 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2683 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2711 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2744 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2799 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2829 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2855 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2883 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2916 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_VariableExp2971 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Path_in_parse_edu_ustb_sei_mde_xmu_VariableExp3007 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3063 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_LoopPath3117 = new BitSet(new long[]{0x00100C0000000000L});
    public static final BitSet FOLLOW_52_in_parse_edu_ustb_sei_mde_xmu_LoopPath3140 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_43_in_parse_edu_ustb_sei_mde_xmu_LoopPath3155 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_42_in_parse_edu_ustb_sei_mde_xmu_LoopPath3170 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_LoopPath3191 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Variable_in_parse_edu_ustb_sei_mde_xmu_LoopPath3209 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_parse_edu_ustb_sei_mde_xmu_LoopPath3227 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3245 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3259 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3273 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3287 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3301 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3315 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3329 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_LoopPath3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_OperationPath3376 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_OperationPath3394 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_OperationPath3415 = new BitSet(new long[]{0x2021C08000218590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3444 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_OperationPath3485 = new BitSet(new long[]{0x2021C08000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3519 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_OperationPath3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_xmu_StringLiteral3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_IntegerLiteral3726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_parse_edu_ustb_sei_mde_xmu_BooleanLiteral3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3806 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3827 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3881 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000005L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3910 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3951 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3985 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_BlockStatement4059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4088 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4106 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_62_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4136 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4162 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4203 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4237 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4311 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseSubStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4334 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4389 = new BitSet(new long[]{0x0000020000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4407 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4425 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4476 = new BitSet(new long[]{0x2021C08000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4494 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4512 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4567 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4588 = new BitSet(new long[]{0x2021C08000218590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4617 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4658 = new BitSet(new long[]{0x2021C08000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4692 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4795 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4846 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4900 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4918 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4939 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4957 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4978 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5036 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5050 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5064 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5078 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5105 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5131 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5151 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5171 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5191 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5251 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5265 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5279 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5293 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5307 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5334 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5360 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5380 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5400 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5420 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5440 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5500 = new BitSet(new long[]{0x00000003E0000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5514 = new BitSet(new long[]{0x00000003E0000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5528 = new BitSet(new long[]{0x00000003E0000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5542 = new BitSet(new long[]{0x00000003E0000000L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5569 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5584 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_30_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5599 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5614 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5629 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5733 = new BitSet(new long[]{0x00000000002C0000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5747 = new BitSet(new long[]{0x00000000002C0000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5761 = new BitSet(new long[]{0x00000000002C0000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5801 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5820 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5839 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5876 = new BitSet(new long[]{0x00000000002C0002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5896 = new BitSet(new long[]{0x00000000002C0002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5916 = new BitSet(new long[]{0x00000000002C0002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5976 = new BitSet(new long[]{0x0000000001020000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr5990 = new BitSet(new long[]{0x0000000001020000L});
    public static final BitSet FOLLOW_17_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6030 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6049 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6086 = new BitSet(new long[]{0x0000000001020002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6106 = new BitSet(new long[]{0x0000000001020002L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6162 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6180 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6194 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6208 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6222 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6236 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6250 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6264 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6320 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6335 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6393 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6532 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6550 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ForStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BlockStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_SwitchStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RuleCallStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Statement6650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteNode_in_parse_edu_ustb_sei_mde_xmu_Statement6660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteLink_in_parse_edu_ustb_sei_mde_xmu_Statement6670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrintStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_FeaturePath_in_parse_edu_ustb_sei_mde_xmu_Path6813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_LoopPath_in_parse_edu_ustb_sei_mde_xmu_Path6823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_OperationPath_in_parse_edu_ustb_sei_mde_xmu_Path6833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Variable6854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_Expr6875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CasePatternStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement7026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseValueStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement7036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred17_Xmu1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1684 = new BitSet(new long[]{0x0300200000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred21_Xmu2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred22_Xmu2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred23_Xmu2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred24_Xmu2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred25_Xmu2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred26_Xmu2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred36_Xmu3245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred37_Xmu3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred38_Xmu3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred39_Xmu3287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred40_Xmu3301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred41_Xmu3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred52_Xmu5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred53_Xmu5050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred54_Xmu5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred55_Xmu5131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred56_Xmu5151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred57_Xmu5171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred59_Xmu5251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred60_Xmu5265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred61_Xmu5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred62_Xmu5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred63_Xmu5360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred64_Xmu5380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred65_Xmu5400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred66_Xmu5420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred68_Xmu5500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred69_Xmu5514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred70_Xmu5528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred75_Xmu5654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred76_Xmu5668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred77_Xmu5682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred78_Xmu5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred79_Xmu5747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred82_Xmu5876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred83_Xmu5896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred89_Xmu6180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred90_Xmu6194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred91_Xmu6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred92_Xmu6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred93_Xmu6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred94_Xmu6250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred96_Xmu6411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred97_Xmu6425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred98_Xmu6439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred99_Xmu6453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred100_Xmu6467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred101_Xmu6481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_synpred116_Xmu6782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_synpred119_Xmu6875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_synpred120_Xmu6885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_synpred121_Xmu6895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_synpred122_Xmu6905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_synpred123_Xmu6915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_synpred124_Xmu6925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred125_Xmu6935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred126_Xmu6945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred127_Xmu6955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred128_Xmu6965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred129_Xmu6975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_synpred130_Xmu6985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred131_Xmu6995 = new BitSet(new long[]{0x0000000000000002L});

}