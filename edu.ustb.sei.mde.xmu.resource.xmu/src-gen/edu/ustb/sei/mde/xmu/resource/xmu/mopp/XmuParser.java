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
        this.state.initializeRuleMemo(181 + 1);
         

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
    // Xmu.g:1978:1: parse_edu_ustb_sei_mde_xmu_UpdatedStatement returns [edu.ustb.sei.mde.xmu.UpdatedStatement element = null] : a0= 'updated' a1= '(' ( (a2= NAME ) )+ a3= ',' ( (a4= NAME ) )+ a5= ')' ;
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

            // Xmu.g:1981:2: (a0= 'updated' a1= '(' ( (a2= NAME ) )+ a3= ',' ( (a4= NAME ) )+ a5= ')' )
            // Xmu.g:1982:2: a0= 'updated' a1= '(' ( (a2= NAME ) )+ a3= ',' ( (a4= NAME ) )+ a5= ')'
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

            // Xmu.g:2010:2: ( (a2= NAME ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==NAME) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // Xmu.g:2011:3: (a2= NAME )
            	    {
            	    // Xmu.g:2011:3: (a2= NAME )
            	    // Xmu.g:2012:4: a2= NAME
            	    {
            	    a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1889); if (state.failed) return element;

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

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[174]);
            	}

            a3=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1919); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[175]);
            	}

            // Xmu.g:2067:2: ( (a4= NAME ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==NAME) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Xmu.g:2068:3: (a4= NAME )
            	    {
            	    // Xmu.g:2068:3: (a4= NAME )
            	    // Xmu.g:2069:4: a4= NAME
            	    {
            	    a4=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1942); if (state.failed) return element;

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
            	    						addObjectToList(element, edu.ustb.sei.mde.xmu.XmuPackage.UPDATED_STATEMENT__VVAR, value);
            	    						completedElement(value, false);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuGrammarInformationProvider.XMU_7_0_0_4, proxy, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[177]);
            	}

            a5=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1972); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[180]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[184]);
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
    // Xmu.g:2132:1: parse_edu_ustb_sei_mde_xmu_VStatement returns [edu.ustb.sei.mde.xmu.VStatement element = null] : ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
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

            // Xmu.g:2135:2: ( ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:2136:2: ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) ) a5= '->' (a6_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            // Xmu.g:2136:2: ( (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' ) )
            // Xmu.g:2137:3: (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' )
            {
            // Xmu.g:2137:3: (a0= 'match' |a1= 'unmatchv' |a2= 'unmatchs' )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt18=1;
                }
                break;
            case 57:
                {
                alt18=2;
                }
                break;
            case 56:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }

            switch (alt18) {
                case 1 :
                    // Xmu.g:2138:4: a0= 'match'
                    {
                    a0=(Token)match(input,45,FOLLOW_45_in_parse_edu_ustb_sei_mde_xmu_VStatement2010); if (state.failed) return element;

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
                    // Xmu.g:2151:8: a1= 'unmatchv'
                    {
                    a1=(Token)match(input,57,FOLLOW_57_in_parse_edu_ustb_sei_mde_xmu_VStatement2025); if (state.failed) return element;

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
                    // Xmu.g:2164:8: a2= 'unmatchs'
                    {
                    a2=(Token)match(input,56,FOLLOW_56_in_parse_edu_ustb_sei_mde_xmu_VStatement2040); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[185]);
            	}

            a5=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_VStatement2061); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[190]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[192]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[193]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[194]);
            	}

            // Xmu.g:2206:2: (a6_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:2207:3: a6_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_VStatement2079);
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[195]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[197]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[198]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[199]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[200]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[201]);
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
    // Xmu.g:2240:1: parse_edu_ustb_sei_mde_xmu_Pattern returns [edu.ustb.sei.mde.xmu.Pattern element = null] : ( (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? |c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern );
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

            // Xmu.g:2243:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? |c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME) ) {
                alt21=1;
            }
            else if ( (LA21_0==41) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // Xmu.g:2244:2: (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
                    {
                    // Xmu.g:2244:2: (a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
                    // Xmu.g:2245:3: a0_0= parse_edu_ustb_sei_mde_xmu_PatternNode
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_Pattern2116);
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
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[202]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[203]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[204]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[205]);
                    	}

                    // Xmu.g:2273:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==34) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // Xmu.g:2274:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                            {
                            // Xmu.g:2274:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                            // Xmu.g:2275:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                            {
                            a1=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_Pattern2143); if (state.failed) return element;

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
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[206]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[207]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[208]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[209]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[210]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[211]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[212]);
                            				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[213]);
                            			}

                            // Xmu.g:2296:4: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                            int alt19=7;
                            switch ( input.LA(1) ) {
                            case 47:
                                {
                                int LA19_1 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (synpred28_Xmu()) ) {
                                    alt19=6;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 1, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 21:
                                {
                                int LA19_2 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (synpred28_Xmu()) ) {
                                    alt19=6;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 2, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case NAME:
                                {
                                int LA19_3 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (true) ) {
                                    alt19=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 3, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case QUOTED_39_39_92:
                                {
                                int LA19_4 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (true) ) {
                                    alt19=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 4, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 48:
                                {
                                int LA19_5 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (true) ) {
                                    alt19=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 5, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 46:
                                {
                                int LA19_6 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (true) ) {
                                    alt19=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 6, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case NUMBER:
                                {
                                int LA19_7 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (true) ) {
                                    alt19=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 7, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case BOOLEAN:
                                {
                                int LA19_8 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (true) ) {
                                    alt19=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 8, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 15:
                                {
                                int LA19_9 = input.LA(2);

                                if ( (synpred23_Xmu()) ) {
                                    alt19=1;
                                }
                                else if ( (synpred24_Xmu()) ) {
                                    alt19=2;
                                }
                                else if ( (synpred25_Xmu()) ) {
                                    alt19=3;
                                }
                                else if ( (synpred26_Xmu()) ) {
                                    alt19=4;
                                }
                                else if ( (synpred27_Xmu()) ) {
                                    alt19=5;
                                }
                                else if ( (true) ) {
                                    alt19=7;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 19, 9, input);

                                    throw nvae;

                                }
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 19, 0, input);

                                throw nvae;

                            }

                            switch (alt19) {
                                case 1 :
                                    // Xmu.g:2297:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2169);
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
                                    // Xmu.g:2316:10: a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2189);
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
                                    // Xmu.g:2335:10: a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2209);
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
                                    // Xmu.g:2354:10: a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2229);
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
                                    // Xmu.g:2373:10: a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2249);
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
                                    // Xmu.g:2392:10: a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2269);
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
                                    // Xmu.g:2411:10: a2_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                                    {
                                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2289);
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
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[214]);
                            			}

                            a3=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_Pattern2317); if (state.failed) return element;

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
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[215]);
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[216]);
                            				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[217]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[218]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[219]);
                    		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[220]);
                    	}

                    }
                    break;
                case 2 :
                    // Xmu.g:2463:2: c0= parse_edu_ustb_sei_mde_xmu_UpdatePattern
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Pattern2355);
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
    // Xmu.g:2467:1: parse_edu_ustb_sei_mde_xmu_PatternNode returns [edu.ustb.sei.mde.xmu.PatternNode element = null] : (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}' ;
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

            // Xmu.g:2470:2: ( (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}' )
            // Xmu.g:2471:2: (a0= NAME ) a1= ':' (a2= NAME ) a3= '{' ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )? a7= '}'
            {
            // Xmu.g:2471:2: (a0= NAME )
            // Xmu.g:2472:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2384); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[221]);
            	}

            a1=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_PatternNode2405); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[222]);
            	}

            // Xmu.g:2525:2: (a2= NAME )
            // Xmu.g:2526:3: a2= NAME
            {
            a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2423); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[223]);
            	}

            a3=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_PatternNode2444); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[224]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[225]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[226]);
            	}

            // Xmu.g:2581:2: ( ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==NAME) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Xmu.g:2582:3: ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* )
                    {
                    // Xmu.g:2582:3: ( (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )* )
                    // Xmu.g:2583:4: (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )*
                    {
                    // Xmu.g:2583:4: (a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    // Xmu.g:2584:5: a4_0= parse_edu_ustb_sei_mde_xmu_PatternExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2473);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[227]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[228]);
                    			}

                    // Xmu.g:2610:4: ( (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==20) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // Xmu.g:2611:5: (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) )
                    	    {
                    	    // Xmu.g:2611:5: (a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr ) )
                    	    // Xmu.g:2612:6: a5= ',' (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    	    {
                    	    a5=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_PatternNode2514); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[229]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[230]);
                    	    					}

                    	    // Xmu.g:2627:6: (a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr )
                    	    // Xmu.g:2628:7: a6_0= parse_edu_ustb_sei_mde_xmu_PatternExpr
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2548);
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[231]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[232]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[233]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[234]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[235]);
            	}

            a7=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_PatternNode2622); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[241]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[242]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[243]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[246]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[247]);
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
    // Xmu.g:2696:1: parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr returns [edu.ustb.sei.mde.xmu.PatternReferenceExpr element = null] : (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ;
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

            // Xmu.g:2699:2: ( (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) )
            // Xmu.g:2700:2: (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            {
            // Xmu.g:2700:2: (a0= NAME )
            // Xmu.g:2701:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2655); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[248]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[249]);
            	}

            // Xmu.g:2741:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Xmu.g:2742:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    {
                    // Xmu.g:2742:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    // Xmu.g:2743:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                    {
                    a1=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2685); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[250]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[251]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[252]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[253]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[254]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[255]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[256]);
                    			}

                    // Xmu.g:2763:4: (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                    // Xmu.g:2764:5: a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2711);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[257]);
                    			}

                    a3=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2739); if (state.failed) return element;

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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[258]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[259]);
            	}

            a4=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2772); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[260]);
            	}

            // Xmu.g:2824:2: (a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            // Xmu.g:2825:3: a5_0= parse_edu_ustb_sei_mde_xmu_PatternNode
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2790);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[261]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[262]);
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
    // Xmu.g:2853:1: parse_edu_ustb_sei_mde_xmu_PatternEqualExpr returns [edu.ustb.sei.mde.xmu.PatternEqualExpr element = null] : (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
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

            // Xmu.g:2856:2: ( (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:2857:2: (a0= NAME ) ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )? a4= '=' (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:2857:2: (a0= NAME )
            // Xmu.g:2858:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2827); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[263]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[264]);
            	}

            // Xmu.g:2898:2: ( (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // Xmu.g:2899:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    {
                    // Xmu.g:2899:3: (a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']' )
                    // Xmu.g:2900:4: a1= '[' (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a3= ']'
                    {
                    a1=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2857); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[265]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[266]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[267]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[268]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[269]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[270]);
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[271]);
                    			}

                    // Xmu.g:2920:4: (a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
                    // Xmu.g:2921:5: a2_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2883);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[272]);
                    			}

                    a3=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2911); if (state.failed) return element;

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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[273]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[274]);
            	}

            a4=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2944); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[275]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[276]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[277]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[278]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[279]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[280]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[281]);
            	}

            // Xmu.g:2987:2: (a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            // Xmu.g:2988:3: a5_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2962);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[282]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[283]);
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
    // Xmu.g:3016:1: parse_edu_ustb_sei_mde_xmu_VariableExp returns [edu.ustb.sei.mde.xmu.VariableExp element = null] : (a0= NAME ) ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )* ;
    public final edu.ustb.sei.mde.xmu.VariableExp parse_edu_ustb_sei_mde_xmu_VariableExp() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VariableExp element =  null;

        int parse_edu_ustb_sei_mde_xmu_VariableExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.xmu.Path a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Xmu.g:3019:2: ( (a0= NAME ) ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )* )
            // Xmu.g:3020:2: (a0= NAME ) ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )*
            {
            // Xmu.g:3020:2: (a0= NAME )
            // Xmu.g:3021:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_VariableExp2999); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[284]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[285]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[286]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[301]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[302]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[303]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[304]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[305]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[306]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[307]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[308]);
            	}

            // Xmu.g:3084:2: ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==22) ) {
                    int LA26_2 = input.LA(2);

                    if ( ((LA26_2 >= 42 && LA26_2 <= 43)||LA26_2==52) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==23) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // Xmu.g:3085:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) )
            	    {
            	    // Xmu.g:3085:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Path ) )
            	    // Xmu.g:3086:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Path )
            	    {
            	    // Xmu.g:3086:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Path )
            	    // Xmu.g:3087:5: a1_0= parse_edu_ustb_sei_mde_xmu_Path
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Path_in_parse_edu_ustb_sei_mde_xmu_VariableExp3035);
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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[309]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[310]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[311]);
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[326]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[327]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[328]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[329]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[330]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[331]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[332]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[333]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[334]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[335]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[336]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[351]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[352]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[353]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[354]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[355]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[356]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[357]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[358]);
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
    // Xmu.g:3169:1: parse_edu_ustb_sei_mde_xmu_FeaturePath returns [edu.ustb.sei.mde.xmu.FeaturePath element = null] : a0= '.' (a1= NAME ) ;
    public final edu.ustb.sei.mde.xmu.FeaturePath parse_edu_ustb_sei_mde_xmu_FeaturePath() throws RecognitionException {
        edu.ustb.sei.mde.xmu.FeaturePath element =  null;

        int parse_edu_ustb_sei_mde_xmu_FeaturePath_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Xmu.g:3172:2: (a0= '.' (a1= NAME ) )
            // Xmu.g:3173:2: a0= '.' (a1= NAME )
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3091); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[359]);
            	}

            // Xmu.g:3187:2: (a1= NAME )
            // Xmu.g:3188:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3109); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[360]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[361]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[362]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[377]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[379]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[380]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[381]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[382]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[383]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[384]);
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
    // Xmu.g:3249:1: parse_edu_ustb_sei_mde_xmu_LoopPath returns [edu.ustb.sei.mde.xmu.LoopPath element = null] : a0= '->' ( (a1= 'select' |a2= 'forAll' |a3= 'exists' ) ) a6= '(' (a7_0= parse_edu_ustb_sei_mde_xmu_Variable ) a8= '|' (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a10= ')' ;
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

            // Xmu.g:3252:2: (a0= '->' ( (a1= 'select' |a2= 'forAll' |a3= 'exists' ) ) a6= '(' (a7_0= parse_edu_ustb_sei_mde_xmu_Variable ) a8= '|' (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a10= ')' )
            // Xmu.g:3253:2: a0= '->' ( (a1= 'select' |a2= 'forAll' |a3= 'exists' ) ) a6= '(' (a7_0= parse_edu_ustb_sei_mde_xmu_Variable ) a8= '|' (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a10= ')'
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_LoopPath3145); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[385]);
            	}

            // Xmu.g:3267:2: ( (a1= 'select' |a2= 'forAll' |a3= 'exists' ) )
            // Xmu.g:3268:3: (a1= 'select' |a2= 'forAll' |a3= 'exists' )
            {
            // Xmu.g:3268:3: (a1= 'select' |a2= 'forAll' |a3= 'exists' )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt27=1;
                }
                break;
            case 43:
                {
                alt27=2;
                }
                break;
            case 42:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }

            switch (alt27) {
                case 1 :
                    // Xmu.g:3269:4: a1= 'select'
                    {
                    a1=(Token)match(input,52,FOLLOW_52_in_parse_edu_ustb_sei_mde_xmu_LoopPath3168); if (state.failed) return element;

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
                    // Xmu.g:3282:8: a2= 'forAll'
                    {
                    a2=(Token)match(input,43,FOLLOW_43_in_parse_edu_ustb_sei_mde_xmu_LoopPath3183); if (state.failed) return element;

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
                    // Xmu.g:3295:8: a3= 'exists'
                    {
                    a3=(Token)match(input,42,FOLLOW_42_in_parse_edu_ustb_sei_mde_xmu_LoopPath3198); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[386]);
            	}

            a6=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_LoopPath3219); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[387]);
            	}

            // Xmu.g:3329:2: (a7_0= parse_edu_ustb_sei_mde_xmu_Variable )
            // Xmu.g:3330:3: a7_0= parse_edu_ustb_sei_mde_xmu_Variable
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Variable_in_parse_edu_ustb_sei_mde_xmu_LoopPath3237);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[388]);
            	}

            a8=(Token)match(input,65,FOLLOW_65_in_parse_edu_ustb_sei_mde_xmu_LoopPath3255); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[389]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[390]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[391]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[392]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[393]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[394]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[395]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[396]);
            	}

            // Xmu.g:3376:2: (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt28=7;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA28_1 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (synpred43_Xmu()) ) {
                    alt28=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA28_2 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (synpred43_Xmu()) ) {
                    alt28=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA28_3 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (true) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA28_4 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (true) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA28_5 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (true) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA28_6 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (true) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA28_7 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (true) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA28_8 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (true) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA28_9 = input.LA(2);

                if ( (synpred38_Xmu()) ) {
                    alt28=1;
                }
                else if ( (synpred39_Xmu()) ) {
                    alt28=2;
                }
                else if ( (synpred40_Xmu()) ) {
                    alt28=3;
                }
                else if ( (synpred41_Xmu()) ) {
                    alt28=4;
                }
                else if ( (synpred42_Xmu()) ) {
                    alt28=5;
                }
                else if ( (true) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 9, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // Xmu.g:3377:3: a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3273);
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
                    // Xmu.g:3396:6: a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3287);
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
                    // Xmu.g:3415:6: a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3301);
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
                    // Xmu.g:3434:6: a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3315);
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
                    // Xmu.g:3453:6: a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3329);
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
                    // Xmu.g:3472:6: a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3343);
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
                    // Xmu.g:3491:6: a9_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3357);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[397]);
            	}

            a10=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_LoopPath3375); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[398]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[399]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[400]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[415]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[416]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[417]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[418]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[419]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[420]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[421]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[422]);
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
    // Xmu.g:3556:1: parse_edu_ustb_sei_mde_xmu_OperationPath returns [edu.ustb.sei.mde.xmu.OperationPath element = null] : a0= '.' (a1= NAME ) a2= '(' ( ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a6= ')' ;
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

            // Xmu.g:3559:2: (a0= '.' (a1= NAME ) a2= '(' ( ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a6= ')' )
            // Xmu.g:3560:2: a0= '.' (a1= NAME ) a2= '(' ( ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a6= ')'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_OperationPath3404); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[423]);
            	}

            // Xmu.g:3574:2: (a1= NAME )
            // Xmu.g:3575:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_OperationPath3422); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[424]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_OperationPath3443); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[425]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[426]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[427]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[428]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[429]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[430]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[431]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[432]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[433]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[434]);
            	}

            // Xmu.g:3633:2: ( ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==BOOLEAN||(LA30_0 >= NAME && LA30_0 <= NUMBER)||LA30_0==QUOTED_39_39_92||LA30_0==15||LA30_0==21||LA30_0==39||(LA30_0 >= 46 && LA30_0 <= 48)||LA30_0==53||LA30_0==61) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Xmu.g:3634:3: ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    {
                    // Xmu.g:3634:3: ( (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    // Xmu.g:3635:4: (a3_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    {
                    // Xmu.g:3635:4: (a3_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    // Xmu.g:3636:5: a3_0= parse_edu_ustb_sei_mde_xmu_Expr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3472);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[435]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[436]);
                    			}

                    // Xmu.g:3662:4: ( (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==20) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // Xmu.g:3663:5: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    {
                    	    // Xmu.g:3663:5: (a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    // Xmu.g:3664:6: a4= ',' (a5_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    {
                    	    a4=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_OperationPath3513); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[437]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[438]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[439]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[440]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[441]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[442]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[443]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[444]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[445]);
                    	    					}

                    	    // Xmu.g:3686:6: (a5_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    // Xmu.g:3687:7: a5_0= parse_edu_ustb_sei_mde_xmu_Expr
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3547);
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[446]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[447]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[448]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[449]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[450]);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_OperationPath3621); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[451]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[452]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[453]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[468]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[469]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[470]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[471]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[472]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[473]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[474]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[475]);
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
    // Xmu.g:3768:1: parse_edu_ustb_sei_mde_xmu_StringLiteral returns [edu.ustb.sei.mde.xmu.StringLiteral element = null] : (a0= QUOTED_39_39_92 ) ;
    public final edu.ustb.sei.mde.xmu.StringLiteral parse_edu_ustb_sei_mde_xmu_StringLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.StringLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_StringLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Xmu.g:3771:2: ( (a0= QUOTED_39_39_92 ) )
            // Xmu.g:3772:2: (a0= QUOTED_39_39_92 )
            {
            // Xmu.g:3772:2: (a0= QUOTED_39_39_92 )
            // Xmu.g:3773:3: a0= QUOTED_39_39_92
            {
            a0=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_xmu_StringLiteral3654); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[490]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[491]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[492]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[493]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[494]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[495]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[496]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[497]);
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
    // Xmu.g:3831:1: parse_edu_ustb_sei_mde_xmu_EmptyLiteral returns [edu.ustb.sei.mde.xmu.EmptyLiteral element = null] : ( (a0= 'null' |a1= 'nil' ) ) ;
    public final edu.ustb.sei.mde.xmu.EmptyLiteral parse_edu_ustb_sei_mde_xmu_EmptyLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EmptyLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_EmptyLiteral_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Xmu.g:3834:2: ( ( (a0= 'null' |a1= 'nil' ) ) )
            // Xmu.g:3835:2: ( (a0= 'null' |a1= 'nil' ) )
            {
            // Xmu.g:3835:2: ( (a0= 'null' |a1= 'nil' ) )
            // Xmu.g:3836:3: (a0= 'null' |a1= 'nil' )
            {
            // Xmu.g:3836:3: (a0= 'null' |a1= 'nil' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==48) ) {
                alt31=1;
            }
            else if ( (LA31_0==46) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // Xmu.g:3837:4: a0= 'null'
                    {
                    a0=(Token)match(input,48,FOLLOW_48_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3699); if (state.failed) return element;

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
                    // Xmu.g:3850:8: a1= 'nil'
                    {
                    a1=(Token)match(input,46,FOLLOW_46_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3714); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[512]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[513]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[514]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[515]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[516]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[517]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[518]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[519]);
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
    // Xmu.g:3893:1: parse_edu_ustb_sei_mde_xmu_IntegerLiteral returns [edu.ustb.sei.mde.xmu.IntegerLiteral element = null] : (a0= NUMBER ) ;
    public final edu.ustb.sei.mde.xmu.IntegerLiteral parse_edu_ustb_sei_mde_xmu_IntegerLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.IntegerLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_IntegerLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Xmu.g:3896:2: ( (a0= NUMBER ) )
            // Xmu.g:3897:2: (a0= NUMBER )
            {
            // Xmu.g:3897:2: (a0= NUMBER )
            // Xmu.g:3898:3: a0= NUMBER
            {
            a0=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_IntegerLiteral3754); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[534]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[535]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[536]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[537]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[538]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[539]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[540]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[541]);
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
    // Xmu.g:3956:1: parse_edu_ustb_sei_mde_xmu_BooleanLiteral returns [edu.ustb.sei.mde.xmu.BooleanLiteral element = null] : (a0= BOOLEAN ) ;
    public final edu.ustb.sei.mde.xmu.BooleanLiteral parse_edu_ustb_sei_mde_xmu_BooleanLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_BooleanLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Xmu.g:3959:2: ( (a0= BOOLEAN ) )
            // Xmu.g:3960:2: (a0= BOOLEAN )
            {
            // Xmu.g:3960:2: (a0= BOOLEAN )
            // Xmu.g:3961:3: a0= BOOLEAN
            {
            a0=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_parse_edu_ustb_sei_mde_xmu_BooleanLiteral3794); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[556]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[557]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[558]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[559]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[560]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[561]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[562]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[563]);
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
    // Xmu.g:4019:1: parse_edu_ustb_sei_mde_xmu_EnumLiteral returns [edu.ustb.sei.mde.xmu.EnumLiteral element = null] : (a0= NAME ) a1= '::' (a2= NAME ) ;
    public final edu.ustb.sei.mde.xmu.EnumLiteral parse_edu_ustb_sei_mde_xmu_EnumLiteral() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EnumLiteral element =  null;

        int parse_edu_ustb_sei_mde_xmu_EnumLiteral_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Xmu.g:4022:2: ( (a0= NAME ) a1= '::' (a2= NAME ) )
            // Xmu.g:4023:2: (a0= NAME ) a1= '::' (a2= NAME )
            {
            // Xmu.g:4023:2: (a0= NAME )
            // Xmu.g:4024:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3834); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[564]);
            	}

            a1=(Token)match(input,27,FOLLOW_27_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3855); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[565]);
            	}

            // Xmu.g:4077:2: (a2= NAME )
            // Xmu.g:4078:3: a2= NAME
            {
            a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3873); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[580]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[581]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[582]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[583]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[584]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[585]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[586]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[587]);
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
    // Xmu.g:4140:1: parse_edu_ustb_sei_mde_xmu_BlockStatement returns [edu.ustb.sei.mde.xmu.BlockStatement element = null] : a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}' ;
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

            // Xmu.g:4143:2: (a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}' )
            // Xmu.g:4144:2: a0= '{' ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )? a4= '}'
            {
            a0=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3909); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[588]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[589]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[590]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[591]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[592]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[593]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[594]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[595]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[596]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[597]);
            	}

            // Xmu.g:4167:2: ( ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==NAME||(LA33_0 >= 40 && LA33_0 <= 41)||LA33_0==50||LA33_0==55||(LA33_0 >= 58 && LA33_0 <= 59)||LA33_0==64) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // Xmu.g:4168:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* )
                    {
                    // Xmu.g:4168:3: ( (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )* )
                    // Xmu.g:4169:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Statement ) ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )*
                    {
                    // Xmu.g:4169:4: (a1_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    // Xmu.g:4170:5: a1_0= parse_edu_ustb_sei_mde_xmu_Statement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3938);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[598]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[599]);
                    			}

                    // Xmu.g:4196:4: ( (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==28) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // Xmu.g:4197:5: (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
                    	    {
                    	    // Xmu.g:4197:5: (a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
                    	    // Xmu.g:4198:6: a2= ';' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    	    {
                    	    a2=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3979); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[600]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[601]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[602]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[603]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[604]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[605]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[606]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[607]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[608]);
                    	    					}

                    	    // Xmu.g:4220:6: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
                    	    // Xmu.g:4221:7: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement4013);
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[609]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[610]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[611]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[612]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[613]);
            	}

            a4=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_BlockStatement4087); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[614]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[615]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[616]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[617]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[618]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[619]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[620]);
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
    // Xmu.g:4284:1: parse_edu_ustb_sei_mde_xmu_SwitchStatement returns [edu.ustb.sei.mde.xmu.SwitchStatement element = null] : a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}' ;
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

            // Xmu.g:4287:2: (a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}' )
            // Xmu.g:4288:2: a0= 'switch' (a1= NAME ) ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )? a6= '{' ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )* a8= '}'
            {
            a0=(Token)match(input,55,FOLLOW_55_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4116); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[621]);
            	}

            // Xmu.g:4302:2: (a1= NAME )
            // Xmu.g:4303:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4134); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[622]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[623]);
            	}

            // Xmu.g:4343:2: ( (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==62) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // Xmu.g:4344:3: (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                    {
                    // Xmu.g:4344:3: (a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )* )
                    // Xmu.g:4345:4: a2= 'when' (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                    {
                    a2=(Token)match(input,62,FOLLOW_62_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4164); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[624]);
                    			}

                    // Xmu.g:4359:4: (a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    // Xmu.g:4360:5: a3_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4190);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[625]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[626]);
                    			}

                    // Xmu.g:4386:4: ( (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==28) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // Xmu.g:4387:5: (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                    	    {
                    	    // Xmu.g:4387:5: (a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement ) )
                    	    // Xmu.g:4388:6: a4= ';' (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    	    {
                    	    a4=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4231); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[627]);
                    	    					}

                    	    // Xmu.g:4402:6: (a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement )
                    	    // Xmu.g:4403:7: a5_0= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4265);
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[628]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[629]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[630]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[631]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[632]);
            	}

            a6=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4339); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[633]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[634]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[635]);
            	}

            // Xmu.g:4460:2: ( (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==38) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Xmu.g:4461:3: (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement )
            	    {
            	    // Xmu.g:4461:3: (a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement )
            	    // Xmu.g:4462:4: a7_0= parse_edu_ustb_sei_mde_xmu_CaseSubStatement
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseSubStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4362);
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
            	    break loop36;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[636]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[637]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[638]);
            	}

            a8=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4388); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[639]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[640]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[641]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[642]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[643]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[644]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[645]);
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
    // Xmu.g:4512:1: parse_edu_ustb_sei_mde_xmu_CasePatternStatement returns [edu.ustb.sei.mde.xmu.CasePatternStatement element = null] : a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
    public final edu.ustb.sei.mde.xmu.CasePatternStatement parse_edu_ustb_sei_mde_xmu_CasePatternStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CasePatternStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CasePatternStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.Pattern a1_0 =null;

        edu.ustb.sei.mde.xmu.Statement a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Xmu.g:4515:2: (a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:4516:2: a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4417); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[646]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[647]);
            	}

            // Xmu.g:4531:2: (a1_0= parse_edu_ustb_sei_mde_xmu_Pattern )
            // Xmu.g:4532:3: a1_0= parse_edu_ustb_sei_mde_xmu_Pattern
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4435);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[648]);
            	}

            a2=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4453); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[649]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[650]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[651]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[652]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[653]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[654]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[655]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[656]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[657]);
            	}

            // Xmu.g:4579:2: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:4580:3: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4471);
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[658]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[659]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[660]);
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
    // Xmu.g:4609:1: parse_edu_ustb_sei_mde_xmu_CaseValueStatement returns [edu.ustb.sei.mde.xmu.CaseValueStatement element = null] : a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) ;
    public final edu.ustb.sei.mde.xmu.CaseValueStatement parse_edu_ustb_sei_mde_xmu_CaseValueStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CaseValueStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CaseValueStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.Expr a1_0 =null;

        edu.ustb.sei.mde.xmu.Statement a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Xmu.g:4612:2: (a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement ) )
            // Xmu.g:4613:2: a0= 'case' (a1_0= parse_edu_ustb_sei_mde_xmu_Expr ) a2= '->' (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4504); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[661]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[662]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[663]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[664]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[665]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[666]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[667]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[668]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[669]);
            	}

            // Xmu.g:4635:2: (a1_0= parse_edu_ustb_sei_mde_xmu_Expr )
            // Xmu.g:4636:3: a1_0= parse_edu_ustb_sei_mde_xmu_Expr
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4522);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[670]);
            	}

            a2=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4540); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[671]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[672]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[673]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[674]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[675]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[676]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[677]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[678]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[679]);
            	}

            // Xmu.g:4683:2: (a3_0= parse_edu_ustb_sei_mde_xmu_Statement )
            // Xmu.g:4684:3: a3_0= parse_edu_ustb_sei_mde_xmu_Statement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4558);
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[680]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[681]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[682]);
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
    // Xmu.g:4713:1: parse_edu_ustb_sei_mde_xmu_RuleCallStatement returns [edu.ustb.sei.mde.xmu.RuleCallStatement element = null] : (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')' ;
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

            // Xmu.g:4716:2: ( (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')' )
            // Xmu.g:4717:2: (a0= NAME ) a1= '(' ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )? a5= ')'
            {
            // Xmu.g:4717:2: (a0= NAME )
            // Xmu.g:4718:3: a0= NAME
            {
            a0=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4595); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[683]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4616); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[684]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[685]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[686]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[687]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[688]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[689]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[690]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[691]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[692]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[693]);
            	}

            // Xmu.g:4780:2: ( ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==BOOLEAN||(LA38_0 >= NAME && LA38_0 <= NUMBER)||LA38_0==QUOTED_39_39_92||LA38_0==15||LA38_0==21||LA38_0==39||(LA38_0 >= 46 && LA38_0 <= 48)||LA38_0==53||LA38_0==61) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // Xmu.g:4781:3: ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    {
                    // Xmu.g:4781:3: ( (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )* )
                    // Xmu.g:4782:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Expr ) ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    {
                    // Xmu.g:4782:4: (a2_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    // Xmu.g:4783:5: a2_0= parse_edu_ustb_sei_mde_xmu_Expr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4645);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[694]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[695]);
                    			}

                    // Xmu.g:4809:4: ( (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==20) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // Xmu.g:4810:5: (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    {
                    	    // Xmu.g:4810:5: (a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr ) )
                    	    // Xmu.g:4811:6: a3= ',' (a4_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    {
                    	    a3=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4686); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[696]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[697]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[698]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[699]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[700]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[701]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[702]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[703]);
                    	    						addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[704]);
                    	    					}

                    	    // Xmu.g:4833:6: (a4_0= parse_edu_ustb_sei_mde_xmu_Expr )
                    	    // Xmu.g:4834:7: a4_0= parse_edu_ustb_sei_mde_xmu_Expr
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4720);
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[705]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[706]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[707]);
                    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[708]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[709]);
            	}

            a5=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4794); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[710]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[711]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[712]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[713]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[714]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[715]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[716]);
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
    // Xmu.g:4897:1: parse_edu_ustb_sei_mde_xmu_UpdatePattern returns [edu.ustb.sei.mde.xmu.UpdatePattern element = null] : a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) ;
    public final edu.ustb.sei.mde.xmu.UpdatePattern parse_edu_ustb_sei_mde_xmu_UpdatePattern() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UpdatePattern element =  null;

        int parse_edu_ustb_sei_mde_xmu_UpdatePattern_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.xmu.PatternNode a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Xmu.g:4900:2: (a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode ) )
            // Xmu.g:4901:2: a0= 'enforce' (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4823); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatePattern(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[717]);
            	}

            // Xmu.g:4915:2: (a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode )
            // Xmu.g:4916:3: a1_0= parse_edu_ustb_sei_mde_xmu_PatternNode
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4841);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[718]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[719]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[720]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[721]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[722]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[723]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[724]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[725]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[726]);
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
    // Xmu.g:4951:1: parse_edu_ustb_sei_mde_xmu_DeleteNode returns [edu.ustb.sei.mde.xmu.DeleteNode element = null] : a0= 'delete' (a1= NAME ) ;
    public final edu.ustb.sei.mde.xmu.DeleteNode parse_edu_ustb_sei_mde_xmu_DeleteNode() throws RecognitionException {
        edu.ustb.sei.mde.xmu.DeleteNode element =  null;

        int parse_edu_ustb_sei_mde_xmu_DeleteNode_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Xmu.g:4954:2: (a0= 'delete' (a1= NAME ) )
            // Xmu.g:4955:2: a0= 'delete' (a1= NAME )
            {
            a0=(Token)match(input,40,FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4874); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[727]);
            	}

            // Xmu.g:4969:2: (a1= NAME )
            // Xmu.g:4970:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4892); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[728]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[729]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[730]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[731]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[732]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[733]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[734]);
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
    // Xmu.g:5017:1: parse_edu_ustb_sei_mde_xmu_DeleteLink returns [edu.ustb.sei.mde.xmu.DeleteLink element = null] : a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME ) ;
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

            // Xmu.g:5020:2: (a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME ) )
            // Xmu.g:5021:2: a0= 'delete' (a1= NAME ) a2= '.' (a3= NAME ) a4= '=' (a5= NAME )
            {
            a0=(Token)match(input,40,FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4928); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[735]);
            	}

            // Xmu.g:5035:2: (a1= NAME )
            // Xmu.g:5036:3: a1= NAME
            {
            a1=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4946); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[736]);
            	}

            a2=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4967); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[737]);
            	}

            // Xmu.g:5089:2: (a3= NAME )
            // Xmu.g:5090:3: a3= NAME
            {
            a3=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4985); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[738]);
            	}

            a4=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_DeleteLink5006); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[739]);
            	}

            // Xmu.g:5143:2: (a5= NAME )
            // Xmu.g:5144:3: a5= NAME
            {
            a5=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink5024); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[740]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[741]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[742]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[743]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[744]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[745]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[746]);
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
    // Xmu.g:5191:1: parse_edu_ustb_sei_mde_xmu_BooleanOrExpr returns [edu.ustb.sei.mde.xmu.BooleanOrExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
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

            // Xmu.g:5194:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5195:2: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5195:2: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt39=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA39_1 = input.LA(2);

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (synpred56_Xmu()) ) {
                    alt39=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA39_2 = input.LA(2);

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (synpred56_Xmu()) ) {
                    alt39=3;
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

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (true) ) {
                    alt39=4;
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

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA39_5 = input.LA(2);

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA39_6 = input.LA(2);

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (true) ) {
                    alt39=4;
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

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (true) ) {
                    alt39=4;
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

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (true) ) {
                    alt39=4;
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

                if ( (synpred54_Xmu()) ) {
                    alt39=1;
                }
                else if ( (synpred55_Xmu()) ) {
                    alt39=2;
                }
                else if ( (true) ) {
                    alt39=4;
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
                    // Xmu.g:5196:3: a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5064);
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
                    // Xmu.g:5215:6: a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5078);
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
                    // Xmu.g:5234:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5092);
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
                    // Xmu.g:5253:6: a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5106);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[747]);
            	}

            // Xmu.g:5278:2: ( (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==49) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // Xmu.g:5279:3: (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:5279:3: (a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:5280:4: a1= 'or' (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    a1=(Token)match(input,49,FOLLOW_49_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5133); if (state.failed) return element;

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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[748]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[749]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[750]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[751]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[752]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[753]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[754]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[755]);
            	    			}

            	    // Xmu.g:5301:4: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt40=4;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        int LA40_1 = input.LA(2);

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (synpred59_Xmu()) ) {
            	            alt40=3;
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

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (synpred59_Xmu()) ) {
            	            alt40=3;
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

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (true) ) {
            	            alt40=4;
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

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (true) ) {
            	            alt40=4;
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

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (true) ) {
            	            alt40=4;
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

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (true) ) {
            	            alt40=4;
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

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (true) ) {
            	            alt40=4;
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

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (true) ) {
            	            alt40=4;
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

            	        if ( (synpred57_Xmu()) ) {
            	            alt40=1;
            	        }
            	        else if ( (synpred58_Xmu()) ) {
            	            alt40=2;
            	        }
            	        else if ( (true) ) {
            	            alt40=4;
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
            	            // Xmu.g:5302:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5159);
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
            	            // Xmu.g:5321:10: a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5179);
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
            	            // Xmu.g:5340:10: a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5199);
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
            	            // Xmu.g:5359:10: a2_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5219);
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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[766]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[767]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[768]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[769]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[770]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[771]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[772]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[773]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[774]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[775]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[776]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[777]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[778]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[779]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[780]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[781]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[782]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[783]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[784]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[785]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[786]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[787]);
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
    // Xmu.g:5423:1: parse_edu_ustb_sei_mde_xmu_BooleanAndExpr returns [edu.ustb.sei.mde.xmu.BooleanAndExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
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

            // Xmu.g:5426:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5427:2: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5427:2: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt42=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA42_1 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (synpred64_Xmu()) ) {
                    alt42=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA42_2 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (synpred64_Xmu()) ) {
                    alt42=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA42_3 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (true) ) {
                    alt42=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA42_4 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (true) ) {
                    alt42=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA42_5 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (true) ) {
                    alt42=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA42_6 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (true) ) {
                    alt42=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA42_7 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (true) ) {
                    alt42=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA42_8 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (true) ) {
                    alt42=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA42_9 = input.LA(2);

                if ( (synpred61_Xmu()) ) {
                    alt42=1;
                }
                else if ( (synpred62_Xmu()) ) {
                    alt42=2;
                }
                else if ( (synpred63_Xmu()) ) {
                    alt42=3;
                }
                else if ( (true) ) {
                    alt42=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 9, input);

                    throw nvae;

                }
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
                    // Xmu.g:5428:3: a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5279);
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
                    // Xmu.g:5447:6: a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5293);
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
                    // Xmu.g:5466:6: a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5307);
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
                    // Xmu.g:5485:6: a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5321);
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
                    // Xmu.g:5504:6: a0_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5335);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[788]);
            	}

            // Xmu.g:5529:2: ( (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==36) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // Xmu.g:5530:3: (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:5530:3: (a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:5531:4: a1= 'and' (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    a1=(Token)match(input,36,FOLLOW_36_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5362); if (state.failed) return element;

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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[789]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[790]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[791]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[792]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[793]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[794]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[795]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[796]);
            	    			}

            	    // Xmu.g:5552:4: (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt43=5;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        int LA43_1 = input.LA(2);

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (synpred68_Xmu()) ) {
            	            alt43=4;
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

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (synpred68_Xmu()) ) {
            	            alt43=4;
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

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (true) ) {
            	            alt43=5;
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

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (true) ) {
            	            alt43=5;
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

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (true) ) {
            	            alt43=5;
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

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (true) ) {
            	            alt43=5;
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

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (true) ) {
            	            alt43=5;
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

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (true) ) {
            	            alt43=5;
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

            	        if ( (synpred65_Xmu()) ) {
            	            alt43=1;
            	        }
            	        else if ( (synpred66_Xmu()) ) {
            	            alt43=2;
            	        }
            	        else if ( (synpred67_Xmu()) ) {
            	            alt43=3;
            	        }
            	        else if ( (true) ) {
            	            alt43=5;
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
            	            // Xmu.g:5553:5: a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5388);
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
            	            // Xmu.g:5572:10: a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5408);
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
            	            // Xmu.g:5591:10: a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5428);
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
            	            // Xmu.g:5610:10: a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5448);
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
            	            // Xmu.g:5629:10: a2_4= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5468);
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[797]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[798]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[799]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[800]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[801]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[802]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[803]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[804]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[805]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[806]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[807]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[808]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[809]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[810]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[811]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[812]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[813]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[814]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[815]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[816]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[817]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[818]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[819]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[820]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[821]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[822]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[823]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[824]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[825]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[826]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[827]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[828]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[829]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[830]);
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
    // Xmu.g:5695:1: parse_edu_ustb_sei_mde_xmu_RelationalExpr returns [edu.ustb.sei.mde.xmu.RelationalExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
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

            // Xmu.g:5698:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:5699:2: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) ) (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:5699:2: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA45_1 = input.LA(2);

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
                    alt45=2;
                }
                else if ( (synpred72_Xmu()) ) {
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

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
                    alt45=2;
                }
                else if ( (synpred72_Xmu()) ) {
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

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
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

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
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

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
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

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
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

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
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

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
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

                if ( (synpred70_Xmu()) ) {
                    alt45=1;
                }
                else if ( (synpred71_Xmu()) ) {
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
                    // Xmu.g:5700:3: a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5528);
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
                    // Xmu.g:5719:6: a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5542);
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
                    // Xmu.g:5738:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5556);
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
                    // Xmu.g:5757:6: a0_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5570);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[831]);
            	}

            // Xmu.g:5782:2: ( (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' ) )
            // Xmu.g:5783:3: (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' )
            {
            // Xmu.g:5783:3: (a1= '=' |a2= '<' |a3= '<=' |a4= '>' |a5= '>=' )
            int alt46=5;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt46=1;
                }
                break;
            case 29:
                {
                alt46=2;
                }
                break;
            case 30:
                {
                alt46=3;
                }
                break;
            case 32:
                {
                alt46=4;
                }
                break;
            case 33:
                {
                alt46=5;
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
                    // Xmu.g:5784:4: a1= '='
                    {
                    a1=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5597); if (state.failed) return element;

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
                    // Xmu.g:5797:8: a2= '<'
                    {
                    a2=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5612); if (state.failed) return element;

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
                    // Xmu.g:5810:8: a3= '<='
                    {
                    a3=(Token)match(input,30,FOLLOW_30_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5627); if (state.failed) return element;

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
                    // Xmu.g:5823:8: a4= '>'
                    {
                    a4=(Token)match(input,32,FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5642); if (state.failed) return element;

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
                    // Xmu.g:5836:8: a5= '>='
                    {
                    a5=(Token)match(input,33,FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5657); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[832]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[833]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[834]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[835]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[836]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[837]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[838]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[839]);
            	}

            // Xmu.g:5863:2: (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt47=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA47_1 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (synpred79_Xmu()) ) {
                    alt47=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA47_2 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (synpred79_Xmu()) ) {
                    alt47=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA47_3 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA47_4 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA47_5 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA47_6 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA47_7 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA47_8 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA47_9 = input.LA(2);

                if ( (synpred77_Xmu()) ) {
                    alt47=1;
                }
                else if ( (synpred78_Xmu()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 9, input);

                    throw nvae;

                }
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
                    // Xmu.g:5864:3: a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5682);
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
                    // Xmu.g:5883:6: a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5696);
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
                    // Xmu.g:5902:6: a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5710);
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
                    // Xmu.g:5921:6: a8_3= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5724);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[840]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[841]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[842]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[843]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[844]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[845]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[846]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[847]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[848]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[849]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[850]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[851]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[852]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[853]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[854]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[855]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[856]);
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
    // Xmu.g:5964:1: parse_edu_ustb_sei_mde_xmu_AdditiveExpr returns [edu.ustb.sei.mde.xmu.AdditiveExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
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

            // Xmu.g:5967:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:5968:2: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:5968:2: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA48_1 = input.LA(2);

                if ( (synpred80_Xmu()) ) {
                    alt48=1;
                }
                else if ( (synpred81_Xmu()) ) {
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

                if ( (synpred80_Xmu()) ) {
                    alt48=1;
                }
                else if ( (synpred81_Xmu()) ) {
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

                if ( (synpred80_Xmu()) ) {
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

                if ( (synpred80_Xmu()) ) {
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

                if ( (synpred80_Xmu()) ) {
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

                if ( (synpred80_Xmu()) ) {
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

                if ( (synpred80_Xmu()) ) {
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

                if ( (synpred80_Xmu()) ) {
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

                if ( (synpred80_Xmu()) ) {
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
                    // Xmu.g:5969:3: a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5761);
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
                    // Xmu.g:5988:6: a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5775);
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
                    // Xmu.g:6007:6: a0_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5789);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[857]);
            	}

            // Xmu.g:6032:2: ( ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0 >= 18 && LA51_0 <= 19)||LA51_0==21) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // Xmu.g:6033:3: ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:6033:3: ( ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:6034:4: ( (a1= '+' |a2= '-' |a3= '++' ) ) (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    // Xmu.g:6034:4: ( (a1= '+' |a2= '-' |a3= '++' ) )
            	    // Xmu.g:6035:5: (a1= '+' |a2= '-' |a3= '++' )
            	    {
            	    // Xmu.g:6035:5: (a1= '+' |a2= '-' |a3= '++' )
            	    int alt49=3;
            	    switch ( input.LA(1) ) {
            	    case 18:
            	        {
            	        alt49=1;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt49=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt49=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt49) {
            	        case 1 :
            	            // Xmu.g:6036:6: a1= '+'
            	            {
            	            a1=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5829); if (state.failed) return element;

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
            	            // Xmu.g:6049:12: a2= '-'
            	            {
            	            a2=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5848); if (state.failed) return element;

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
            	            // Xmu.g:6062:12: a3= '++'
            	            {
            	            a3=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5867); if (state.failed) return element;

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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[858]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[859]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[860]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[861]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[862]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[863]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[864]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[865]);
            	    			}

            	    // Xmu.g:6089:4: (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt50=3;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        int LA50_1 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (synpred85_Xmu()) ) {
            	            alt50=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 1, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 21:
            	        {
            	        int LA50_2 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (synpred85_Xmu()) ) {
            	            alt50=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 2, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NAME:
            	        {
            	        int LA50_3 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (true) ) {
            	            alt50=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 3, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case QUOTED_39_39_92:
            	        {
            	        int LA50_4 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (true) ) {
            	            alt50=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 4, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 48:
            	        {
            	        int LA50_5 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (true) ) {
            	            alt50=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 5, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 46:
            	        {
            	        int LA50_6 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (true) ) {
            	            alt50=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 6, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case NUMBER:
            	        {
            	        int LA50_7 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (true) ) {
            	            alt50=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 7, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case BOOLEAN:
            	        {
            	        int LA50_8 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (true) ) {
            	            alt50=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 8, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    case 15:
            	        {
            	        int LA50_9 = input.LA(2);

            	        if ( (synpred84_Xmu()) ) {
            	            alt50=1;
            	        }
            	        else if ( (true) ) {
            	            alt50=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 50, 9, input);

            	            throw nvae;

            	        }
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 50, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt50) {
            	        case 1 :
            	            // Xmu.g:6090:5: a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5904);
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
            	            // Xmu.g:6109:10: a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5924);
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
            	            // Xmu.g:6128:10: a6_2= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5944);
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[876]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[877]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[878]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[879]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[880]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[881]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[882]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[883]);
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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[896]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[897]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[898]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[899]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[900]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[901]);
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
    // Xmu.g:6196:1: parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr returns [edu.ustb.sei.mde.xmu.MultiplicativeExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ ;
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

            // Xmu.g:6199:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+ )
            // Xmu.g:6200:2: (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            {
            // Xmu.g:6200:2: (a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
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
                    // Xmu.g:6201:3: a0_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6004);
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
                    // Xmu.g:6220:6: a0_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6018);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[902]);
            	}

            // Xmu.g:6245:2: ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ) )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==17||LA55_0==24) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // Xmu.g:6246:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    {
            	    // Xmu.g:6246:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            	    // Xmu.g:6247:4: ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    {
            	    // Xmu.g:6247:4: ( (a1= '*' |a2= '/' ) )
            	    // Xmu.g:6248:5: (a1= '*' |a2= '/' )
            	    {
            	    // Xmu.g:6248:5: (a1= '*' |a2= '/' )
            	    int alt53=2;
            	    int LA53_0 = input.LA(1);

            	    if ( (LA53_0==17) ) {
            	        alt53=1;
            	    }
            	    else if ( (LA53_0==24) ) {
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
            	            // Xmu.g:6249:6: a1= '*'
            	            {
            	            a1=(Token)match(input,17,FOLLOW_17_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6058); if (state.failed) return element;

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
            	            // Xmu.g:6262:12: a2= '/'
            	            {
            	            a2=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6077); if (state.failed) return element;

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
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[903]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[904]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[905]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[906]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[907]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[908]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[909]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[910]);
            	    			}

            	    // Xmu.g:6289:4: (a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( (LA54_0==21||LA54_0==47) ) {
            	        alt54=1;
            	    }
            	    else if ( (LA54_0==BOOLEAN||(LA54_0 >= NAME && LA54_0 <= NUMBER)||LA54_0==QUOTED_39_39_92||LA54_0==15||LA54_0==46||LA54_0==48) ) {
            	        alt54=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 54, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // Xmu.g:6290:5: a5_0= parse_edu_ustb_sei_mde_xmu_UnaryExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6114);
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
            	            // Xmu.g:6309:10: a5_1= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            	            {
            	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6134);
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[923]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[924]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[925]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[926]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[927]);
            	    				addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[928]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[929]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[941]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[942]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[943]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[944]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[945]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[946]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[947]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[948]);
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
    // Xmu.g:6379:1: parse_edu_ustb_sei_mde_xmu_ParenExpr returns [edu.ustb.sei.mde.xmu.ParenExpr element = null] : a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')' ;
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

            // Xmu.g:6382:2: (a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')' )
            // Xmu.g:6383:2: a0= '(' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6190); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[949]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[950]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[951]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[952]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[953]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[954]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[955]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[956]);
            	}

            // Xmu.g:6404:2: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt56=7;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA56_1 = input.LA(2);

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
                    alt56=5;
                }
                else if ( (synpred96_Xmu()) ) {
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

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
                    alt56=5;
                }
                else if ( (synpred96_Xmu()) ) {
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

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
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

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
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

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
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

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
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

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
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

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
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

                if ( (synpred91_Xmu()) ) {
                    alt56=1;
                }
                else if ( (synpred92_Xmu()) ) {
                    alt56=2;
                }
                else if ( (synpred93_Xmu()) ) {
                    alt56=3;
                }
                else if ( (synpred94_Xmu()) ) {
                    alt56=4;
                }
                else if ( (synpred95_Xmu()) ) {
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
                    // Xmu.g:6405:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6208);
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
                    // Xmu.g:6424:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6222);
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
                    // Xmu.g:6443:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6236);
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
                    // Xmu.g:6462:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6250);
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
                    // Xmu.g:6481:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6264);
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
                    // Xmu.g:6500:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6278);
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
                    // Xmu.g:6519:6: a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6292);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[957]);
            	}

            a2=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6310); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[972]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[973]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[974]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[975]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[976]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[977]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[978]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[979]);
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
    // Xmu.g:6581:1: parse_edu_ustb_sei_mde_xmu_UnaryExpr returns [edu.ustb.sei.mde.xmu.UnaryExpr element = null] : ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
    public final edu.ustb.sei.mde.xmu.UnaryExpr parse_edu_ustb_sei_mde_xmu_UnaryExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_UnaryExpr_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.xmu.AtomicExpr a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Xmu.g:6584:2: ( ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:6585:2: ( (a0= 'not' |a1= '-' ) ) (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            // Xmu.g:6585:2: ( (a0= 'not' |a1= '-' ) )
            // Xmu.g:6586:3: (a0= 'not' |a1= '-' )
            {
            // Xmu.g:6586:3: (a0= 'not' |a1= '-' )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==47) ) {
                alt57=1;
            }
            else if ( (LA57_0==21) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }
            switch (alt57) {
                case 1 :
                    // Xmu.g:6587:4: a0= 'not'
                    {
                    a0=(Token)match(input,47,FOLLOW_47_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6348); if (state.failed) return element;

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
                    // Xmu.g:6600:8: a1= '-'
                    {
                    a1=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6363); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[980]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[981]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[982]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[983]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[984]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[985]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[986]);
            	}

            // Xmu.g:6626:2: (a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            // Xmu.g:6627:3: a4_0= parse_edu_ustb_sei_mde_xmu_AtomicExpr
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6388);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[999]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1000]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1001]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1002]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1003]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1004]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1005]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1006]);
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
    // Xmu.g:6673:1: parse_edu_ustb_sei_mde_xmu_PrintStatement returns [edu.ustb.sei.mde.xmu.PrintStatement element = null] : a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) ;
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

            // Xmu.g:6676:2: (a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr ) )
            // Xmu.g:6677:2: a0= 'print' (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            {
            a0=(Token)match(input,50,FOLLOW_50_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6421); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1007]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1008]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1009]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1010]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1011]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1012]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1013]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1014]);
            	}

            // Xmu.g:6698:2: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr |a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr |a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr )
            int alt58=7;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA58_1 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (synpred103_Xmu()) ) {
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
            case 21:
                {
                int LA58_2 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (synpred103_Xmu()) ) {
                    alt58=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
                {
                int LA58_3 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (true) ) {
                    alt58=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA58_4 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (true) ) {
                    alt58=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 4, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA58_5 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (true) ) {
                    alt58=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 5, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA58_6 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (true) ) {
                    alt58=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 6, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA58_7 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (true) ) {
                    alt58=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 7, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA58_8 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (true) ) {
                    alt58=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA58_9 = input.LA(2);

                if ( (synpred98_Xmu()) ) {
                    alt58=1;
                }
                else if ( (synpred99_Xmu()) ) {
                    alt58=2;
                }
                else if ( (synpred100_Xmu()) ) {
                    alt58=3;
                }
                else if ( (synpred101_Xmu()) ) {
                    alt58=4;
                }
                else if ( (synpred102_Xmu()) ) {
                    alt58=5;
                }
                else if ( (true) ) {
                    alt58=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 9, input);

                    throw nvae;

                }
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
                    // Xmu.g:6699:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6439);
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
                    // Xmu.g:6718:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6453);
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
                    // Xmu.g:6737:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6467);
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
                    // Xmu.g:6756:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6481);
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
                    // Xmu.g:6775:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6495);
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
                    // Xmu.g:6794:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6509);
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
                    // Xmu.g:6813:6: a1_6= parse_edu_ustb_sei_mde_xmu_AtomicExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6523);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1015]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1016]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1017]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1018]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1019]);
            		addExpectedElement(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(), edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1020]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1021]);
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
    // Xmu.g:6846:1: parse_edu_ustb_sei_mde_xmu_AllInstanceExpr returns [edu.ustb.sei.mde.xmu.AllInstanceExpr element = null] : (a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) a1= '//' (a2= NAME ) ;
    public final edu.ustb.sei.mde.xmu.AllInstanceExpr parse_edu_ustb_sei_mde_xmu_AllInstanceExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AllInstanceExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_AllInstanceExpr_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.xmu.StartRoot a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }

            // Xmu.g:6849:2: ( (a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) a1= '//' (a2= NAME ) )
            // Xmu.g:6850:2: (a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot ) a1= '//' (a2= NAME )
            {
            // Xmu.g:6850:2: (a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot )
            // Xmu.g:6851:3: a0_0= parse_edu_ustb_sei_mde_xmu_StartRoot
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6560);
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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1022]);
            	}

            a1=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6578); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1023]);
            	}

            // Xmu.g:6890:2: (a2= NAME )
            // Xmu.g:6891:3: a2= NAME
            {
            a2=(Token)match(input,NAME,FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6596); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1024]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1025]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1026]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1027]);
            		addExpectedElement(null, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuExpectationConstants.EXPECTATIONS[1028]);
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
    // Xmu.g:6936:1: parse_edu_ustb_sei_mde_xmu_Statement returns [edu.ustb.sei.mde.xmu.Statement element = null] : (c0= parse_edu_ustb_sei_mde_xmu_ForStatement |c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement |c2= parse_edu_ustb_sei_mde_xmu_BlockStatement |c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement |c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement |c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern |c6= parse_edu_ustb_sei_mde_xmu_DeleteNode |c7= parse_edu_ustb_sei_mde_xmu_DeleteLink |c8= parse_edu_ustb_sei_mde_xmu_PrintStatement );
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

            // Xmu.g:6937:2: (c0= parse_edu_ustb_sei_mde_xmu_ForStatement |c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement |c2= parse_edu_ustb_sei_mde_xmu_BlockStatement |c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement |c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement |c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern |c6= parse_edu_ustb_sei_mde_xmu_DeleteNode |c7= parse_edu_ustb_sei_mde_xmu_DeleteLink |c8= parse_edu_ustb_sei_mde_xmu_PrintStatement )
            int alt59=9;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt59=1;
                }
                break;
            case 59:
                {
                alt59=2;
                }
                break;
            case 64:
                {
                alt59=3;
                }
                break;
            case 55:
                {
                alt59=4;
                }
                break;
            case NAME:
                {
                alt59=5;
                }
                break;
            case 41:
                {
                alt59=6;
                }
                break;
            case 40:
                {
                int LA59_7 = input.LA(2);

                if ( (LA59_7==NAME) ) {
                    int LA59_9 = input.LA(3);

                    if ( (LA59_9==EOF||LA59_9==28||LA59_9==38||LA59_9==45||(LA59_9 >= 56 && LA59_9 <= 57)||LA59_9==66) ) {
                        alt59=7;
                    }
                    else if ( (LA59_9==23) ) {
                        alt59=8;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 9, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 7, input);

                    throw nvae;

                }
                }
                break;
            case 50:
                {
                alt59=9;
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
                    // Xmu.g:6938:2: c0= parse_edu_ustb_sei_mde_xmu_ForStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ForStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6628);
                    c0=parse_edu_ustb_sei_mde_xmu_ForStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6939:4: c1= parse_edu_ustb_sei_mde_xmu_UpdatedStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6638);
                    c1=parse_edu_ustb_sei_mde_xmu_UpdatedStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6940:4: c2= parse_edu_ustb_sei_mde_xmu_BlockStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BlockStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6648);
                    c2=parse_edu_ustb_sei_mde_xmu_BlockStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6941:4: c3= parse_edu_ustb_sei_mde_xmu_SwitchStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_SwitchStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6658);
                    c3=parse_edu_ustb_sei_mde_xmu_SwitchStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6942:4: c4= parse_edu_ustb_sei_mde_xmu_RuleCallStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RuleCallStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6668);
                    c4=parse_edu_ustb_sei_mde_xmu_RuleCallStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6943:4: c5= parse_edu_ustb_sei_mde_xmu_UpdatePattern
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Statement6678);
                    c5=parse_edu_ustb_sei_mde_xmu_UpdatePattern();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6944:4: c6= parse_edu_ustb_sei_mde_xmu_DeleteNode
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteNode_in_parse_edu_ustb_sei_mde_xmu_Statement6688);
                    c6=parse_edu_ustb_sei_mde_xmu_DeleteNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Xmu.g:6945:4: c7= parse_edu_ustb_sei_mde_xmu_DeleteLink
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteLink_in_parse_edu_ustb_sei_mde_xmu_Statement6698);
                    c7=parse_edu_ustb_sei_mde_xmu_DeleteLink();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Xmu.g:6946:4: c8= parse_edu_ustb_sei_mde_xmu_PrintStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PrintStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6708);
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
    // Xmu.g:6950:1: parse_edu_ustb_sei_mde_xmu_AtomicExpr returns [edu.ustb.sei.mde.xmu.AtomicExpr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_ParenExpr );
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

            // Xmu.g:6951:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_ParenExpr )
            int alt60=7;
            switch ( input.LA(1) ) {
            case NAME:
                {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==EOF||(LA60_1 >= 16 && LA60_1 <= 24)||(LA60_1 >= 28 && LA60_1 <= 33)||(LA60_1 >= 35 && LA60_1 <= 36)||LA60_1==38||LA60_1==45||LA60_1==49||(LA60_1 >= 56 && LA60_1 <= 57)||LA60_1==66) ) {
                    alt60=1;
                }
                else if ( (LA60_1==27) ) {
                    alt60=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                alt60=2;
                }
                break;
            case 46:
            case 48:
                {
                alt60=3;
                }
                break;
            case NUMBER:
                {
                alt60=4;
                }
                break;
            case BOOLEAN:
                {
                alt60=5;
                }
                break;
            case 15:
                {
                alt60=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }

            switch (alt60) {
                case 1 :
                    // Xmu.g:6952:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6729);
                    c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6953:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6739);
                    c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6954:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6749);
                    c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6955:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6759);
                    c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6956:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6769);
                    c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6957:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6779);
                    c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6958:4: c6= parse_edu_ustb_sei_mde_xmu_ParenExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6789);
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
    // Xmu.g:6962:1: parse_edu_ustb_sei_mde_xmu_PatternExpr returns [edu.ustb.sei.mde.xmu.PatternExpr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr |c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr );
    public final edu.ustb.sei.mde.xmu.PatternExpr parse_edu_ustb_sei_mde_xmu_PatternExpr() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternExpr element =  null;

        int parse_edu_ustb_sei_mde_xmu_PatternExpr_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.PatternReferenceExpr c0 =null;

        edu.ustb.sei.mde.xmu.PatternEqualExpr c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return element; }

            // Xmu.g:6963:2: (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr |c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==NAME) ) {
                int LA61_1 = input.LA(2);

                if ( (synpred118_Xmu()) ) {
                    alt61=1;
                }
                else if ( (true) ) {
                    alt61=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }
            switch (alt61) {
                case 1 :
                    // Xmu.g:6964:2: c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6810);
                    c0=parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6965:4: c1= parse_edu_ustb_sei_mde_xmu_PatternEqualExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6820);
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
    // Xmu.g:6969:1: parse_edu_ustb_sei_mde_xmu_Path returns [edu.ustb.sei.mde.xmu.Path element = null] : (c0= parse_edu_ustb_sei_mde_xmu_FeaturePath |c1= parse_edu_ustb_sei_mde_xmu_LoopPath |c2= parse_edu_ustb_sei_mde_xmu_OperationPath );
    public final edu.ustb.sei.mde.xmu.Path parse_edu_ustb_sei_mde_xmu_Path() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Path element =  null;

        int parse_edu_ustb_sei_mde_xmu_Path_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.FeaturePath c0 =null;

        edu.ustb.sei.mde.xmu.LoopPath c1 =null;

        edu.ustb.sei.mde.xmu.OperationPath c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return element; }

            // Xmu.g:6970:2: (c0= parse_edu_ustb_sei_mde_xmu_FeaturePath |c1= parse_edu_ustb_sei_mde_xmu_LoopPath |c2= parse_edu_ustb_sei_mde_xmu_OperationPath )
            int alt62=3;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==23) ) {
                int LA62_1 = input.LA(2);

                if ( (LA62_1==NAME) ) {
                    int LA62_3 = input.LA(3);

                    if ( (LA62_3==EOF||(LA62_3 >= 16 && LA62_3 <= 24)||(LA62_3 >= 28 && LA62_3 <= 33)||(LA62_3 >= 35 && LA62_3 <= 36)||LA62_3==38||LA62_3==45||LA62_3==49||(LA62_3 >= 56 && LA62_3 <= 57)||LA62_3==66) ) {
                        alt62=1;
                    }
                    else if ( (LA62_3==15) ) {
                        alt62=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA62_0==22) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }
            switch (alt62) {
                case 1 :
                    // Xmu.g:6971:2: c0= parse_edu_ustb_sei_mde_xmu_FeaturePath
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_FeaturePath_in_parse_edu_ustb_sei_mde_xmu_Path6841);
                    c0=parse_edu_ustb_sei_mde_xmu_FeaturePath();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6972:4: c1= parse_edu_ustb_sei_mde_xmu_LoopPath
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_LoopPath_in_parse_edu_ustb_sei_mde_xmu_Path6851);
                    c1=parse_edu_ustb_sei_mde_xmu_LoopPath();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6973:4: c2= parse_edu_ustb_sei_mde_xmu_OperationPath
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_OperationPath_in_parse_edu_ustb_sei_mde_xmu_Path6861);
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
    // Xmu.g:6977:1: parse_edu_ustb_sei_mde_xmu_Variable returns [edu.ustb.sei.mde.xmu.Variable element = null] : c0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable ;
    public final edu.ustb.sei.mde.xmu.Variable parse_edu_ustb_sei_mde_xmu_Variable() throws RecognitionException {
        edu.ustb.sei.mde.xmu.Variable element =  null;

        int parse_edu_ustb_sei_mde_xmu_Variable_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.PrimitiveVariable c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return element; }

            // Xmu.g:6978:2: (c0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable )
            // Xmu.g:6979:2: c0= parse_edu_ustb_sei_mde_xmu_PrimitiveVariable
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Variable6882);
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
    // Xmu.g:6983:1: parse_edu_ustb_sei_mde_xmu_Expr returns [edu.ustb.sei.mde.xmu.Expr element = null] : (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr |c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |c11= parse_edu_ustb_sei_mde_xmu_ParenExpr |c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr |c13= parse_edu_ustb_sei_mde_xmu_AllInstanceExpr );
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

            // Xmu.g:6984:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp |c1= parse_edu_ustb_sei_mde_xmu_StringLiteral |c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral |c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral |c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral |c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral |c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr |c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr |c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr |c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr |c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr |c11= parse_edu_ustb_sei_mde_xmu_ParenExpr |c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr |c13= parse_edu_ustb_sei_mde_xmu_AllInstanceExpr )
            int alt63=14;
            switch ( input.LA(1) ) {
            case NAME:
                {
                int LA63_1 = input.LA(2);

                if ( (synpred121_Xmu()) ) {
                    alt63=1;
                }
                else if ( (synpred126_Xmu()) ) {
                    alt63=6;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA63_2 = input.LA(2);

                if ( (synpred122_Xmu()) ) {
                    alt63=2;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 2, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA63_3 = input.LA(2);

                if ( (synpred123_Xmu()) ) {
                    alt63=3;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 3, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA63_4 = input.LA(2);

                if ( (synpred123_Xmu()) ) {
                    alt63=3;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 4, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                int LA63_5 = input.LA(2);

                if ( (synpred124_Xmu()) ) {
                    alt63=4;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 5, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
                {
                int LA63_6 = input.LA(2);

                if ( (synpred125_Xmu()) ) {
                    alt63=5;
                }
                else if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 6, input);

                    throw nvae;

                }
                }
                break;
            case 47:
                {
                int LA63_7 = input.LA(2);

                if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else if ( (synpred133_Xmu()) ) {
                    alt63=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 7, input);

                    throw nvae;

                }
                }
                break;
            case 21:
                {
                int LA63_8 = input.LA(2);

                if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else if ( (synpred133_Xmu()) ) {
                    alt63=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 8, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA63_9 = input.LA(2);

                if ( (synpred127_Xmu()) ) {
                    alt63=7;
                }
                else if ( (synpred128_Xmu()) ) {
                    alt63=8;
                }
                else if ( (synpred129_Xmu()) ) {
                    alt63=9;
                }
                else if ( (synpred130_Xmu()) ) {
                    alt63=10;
                }
                else if ( (synpred131_Xmu()) ) {
                    alt63=11;
                }
                else if ( (synpred132_Xmu()) ) {
                    alt63=12;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 9, input);

                    throw nvae;

                }
                }
                break;
            case 39:
            case 53:
            case 61:
                {
                alt63=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // Xmu.g:6985:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_Expr6903);
                    c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:6986:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6913);
                    c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Xmu.g:6987:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6923);
                    c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Xmu.g:6988:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6933);
                    c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Xmu.g:6989:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6943);
                    c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Xmu.g:6990:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6953);
                    c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Xmu.g:6991:4: c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6963);
                    c6=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Xmu.g:6992:4: c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6973);
                    c7=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Xmu.g:6993:4: c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6983);
                    c8=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Xmu.g:6994:4: c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6993);
                    c9=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 11 :
                    // Xmu.g:6995:4: c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7003);
                    c10=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c10; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 12 :
                    // Xmu.g:6996:4: c11= parse_edu_ustb_sei_mde_xmu_ParenExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7013);
                    c11=parse_edu_ustb_sei_mde_xmu_ParenExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c11; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 13 :
                    // Xmu.g:6997:4: c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7023);
                    c12=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c12; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 14 :
                    // Xmu.g:6998:4: c13= parse_edu_ustb_sei_mde_xmu_AllInstanceExpr
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7033);
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
    // Xmu.g:7002:1: parse_edu_ustb_sei_mde_xmu_CaseSubStatement returns [edu.ustb.sei.mde.xmu.CaseSubStatement element = null] : (c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement |c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement );
    public final edu.ustb.sei.mde.xmu.CaseSubStatement parse_edu_ustb_sei_mde_xmu_CaseSubStatement() throws RecognitionException {
        edu.ustb.sei.mde.xmu.CaseSubStatement element =  null;

        int parse_edu_ustb_sei_mde_xmu_CaseSubStatement_StartIndex = input.index();

        edu.ustb.sei.mde.xmu.CasePatternStatement c0 =null;

        edu.ustb.sei.mde.xmu.CaseValueStatement c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return element; }

            // Xmu.g:7003:2: (c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement |c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==38) ) {
                switch ( input.LA(2) ) {
                case NAME:
                    {
                    int LA64_2 = input.LA(3);

                    if ( (LA64_2==26) ) {
                        alt64=1;
                    }
                    else if ( ((LA64_2 >= 17 && LA64_2 <= 19)||(LA64_2 >= 21 && LA64_2 <= 24)||LA64_2==27||(LA64_2 >= 29 && LA64_2 <= 33)||LA64_2==36||LA64_2==49) ) {
                        alt64=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 2, input);

                        throw nvae;

                    }
                    }
                    break;
                case 41:
                    {
                    alt64=1;
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
                    alt64=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }
            switch (alt64) {
                case 1 :
                    // Xmu.g:7004:2: c0= parse_edu_ustb_sei_mde_xmu_CasePatternStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CasePatternStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement7054);
                    c0=parse_edu_ustb_sei_mde_xmu_CasePatternStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Xmu.g:7005:4: c1= parse_edu_ustb_sei_mde_xmu_CaseValueStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseValueStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement7064);
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
        int alt70=2;
        int LA70_0 = input.LA(1);

        if ( (LA70_0==45||(LA70_0 >= 56 && LA70_0 <= 57)) ) {
            alt70=1;
        }
        switch (alt70) {
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

    // $ANTLR start synpred23_Xmu
    public final void synpred23_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a2_0 =null;


        // Xmu.g:2297:5: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:2297:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred23_Xmu2169);
        a2_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred23_Xmu

    // $ANTLR start synpred24_Xmu
    public final void synpred24_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a2_1 =null;


        // Xmu.g:2316:10: (a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:2316:10: a2_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred24_Xmu2189);
        a2_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred24_Xmu

    // $ANTLR start synpred25_Xmu
    public final void synpred25_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a2_2 =null;


        // Xmu.g:2335:10: (a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:2335:10: a2_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred25_Xmu2209);
        a2_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred25_Xmu

    // $ANTLR start synpred26_Xmu
    public final void synpred26_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a2_3 =null;


        // Xmu.g:2354:10: (a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:2354:10: a2_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred26_Xmu2229);
        a2_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred26_Xmu

    // $ANTLR start synpred27_Xmu
    public final void synpred27_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a2_4 =null;


        // Xmu.g:2373:10: (a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:2373:10: a2_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred27_Xmu2249);
        a2_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred27_Xmu

    // $ANTLR start synpred28_Xmu
    public final void synpred28_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a2_5 =null;


        // Xmu.g:2392:10: (a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:2392:10: a2_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred28_Xmu2269);
        a2_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred28_Xmu

    // $ANTLR start synpred38_Xmu
    public final void synpred38_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a9_0 =null;


        // Xmu.g:3377:3: (a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:3377:3: a9_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred38_Xmu3273);
        a9_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred38_Xmu

    // $ANTLR start synpred39_Xmu
    public final void synpred39_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a9_1 =null;


        // Xmu.g:3396:6: (a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:3396:6: a9_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred39_Xmu3287);
        a9_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred39_Xmu

    // $ANTLR start synpred40_Xmu
    public final void synpred40_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a9_2 =null;


        // Xmu.g:3415:6: (a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:3415:6: a9_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred40_Xmu3301);
        a9_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred40_Xmu

    // $ANTLR start synpred41_Xmu
    public final void synpred41_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a9_3 =null;


        // Xmu.g:3434:6: (a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:3434:6: a9_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred41_Xmu3315);
        a9_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred41_Xmu

    // $ANTLR start synpred42_Xmu
    public final void synpred42_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a9_4 =null;


        // Xmu.g:3453:6: (a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:3453:6: a9_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred42_Xmu3329);
        a9_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred42_Xmu

    // $ANTLR start synpred43_Xmu
    public final void synpred43_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a9_5 =null;


        // Xmu.g:3472:6: (a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:3472:6: a9_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred43_Xmu3343);
        a9_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred43_Xmu

    // $ANTLR start synpred54_Xmu
    public final void synpred54_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a0_0 =null;


        // Xmu.g:5196:3: (a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:5196:3: a0_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred54_Xmu5064);
        a0_0=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred54_Xmu

    // $ANTLR start synpred55_Xmu
    public final void synpred55_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a0_1 =null;


        // Xmu.g:5215:6: (a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5215:6: a0_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred55_Xmu5078);
        a0_1=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred55_Xmu

    // $ANTLR start synpred56_Xmu
    public final void synpred56_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_2 =null;


        // Xmu.g:5234:6: (a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5234:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred56_Xmu5092);
        a0_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred56_Xmu

    // $ANTLR start synpred57_Xmu
    public final void synpred57_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a2_0 =null;


        // Xmu.g:5302:5: (a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:5302:5: a2_0= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred57_Xmu5159);
        a2_0=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred57_Xmu

    // $ANTLR start synpred58_Xmu
    public final void synpred58_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a2_1 =null;


        // Xmu.g:5321:10: (a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5321:10: a2_1= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred58_Xmu5179);
        a2_1=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred58_Xmu

    // $ANTLR start synpred59_Xmu
    public final void synpred59_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a2_2 =null;


        // Xmu.g:5340:10: (a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5340:10: a2_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred59_Xmu5199);
        a2_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred59_Xmu

    // $ANTLR start synpred61_Xmu
    public final void synpred61_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a0_0 =null;


        // Xmu.g:5428:3: (a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5428:3: a0_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred61_Xmu5279);
        a0_0=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred61_Xmu

    // $ANTLR start synpred62_Xmu
    public final void synpred62_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a0_1 =null;


        // Xmu.g:5447:6: (a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5447:6: a0_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred62_Xmu5293);
        a0_1=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred62_Xmu

    // $ANTLR start synpred63_Xmu
    public final void synpred63_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_2 =null;


        // Xmu.g:5466:6: (a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5466:6: a0_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred63_Xmu5307);
        a0_2=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred63_Xmu

    // $ANTLR start synpred64_Xmu
    public final void synpred64_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_3 =null;


        // Xmu.g:5485:6: (a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5485:6: a0_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred64_Xmu5321);
        a0_3=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred64_Xmu

    // $ANTLR start synpred65_Xmu
    public final void synpred65_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a2_0 =null;


        // Xmu.g:5553:5: (a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:5553:5: a2_0= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred65_Xmu5388);
        a2_0=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred65_Xmu

    // $ANTLR start synpred66_Xmu
    public final void synpred66_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a2_1 =null;


        // Xmu.g:5572:10: (a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5572:10: a2_1= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred66_Xmu5408);
        a2_1=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred66_Xmu

    // $ANTLR start synpred67_Xmu
    public final void synpred67_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a2_2 =null;


        // Xmu.g:5591:10: (a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5591:10: a2_2= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred67_Xmu5428);
        a2_2=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred67_Xmu

    // $ANTLR start synpred68_Xmu
    public final void synpred68_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a2_3 =null;


        // Xmu.g:5610:10: (a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5610:10: a2_3= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred68_Xmu5448);
        a2_3=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred68_Xmu

    // $ANTLR start synpred70_Xmu
    public final void synpred70_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a0_0 =null;


        // Xmu.g:5700:3: (a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5700:3: a0_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred70_Xmu5528);
        a0_0=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred70_Xmu

    // $ANTLR start synpred71_Xmu
    public final void synpred71_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_1 =null;


        // Xmu.g:5719:6: (a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5719:6: a0_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred71_Xmu5542);
        a0_1=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred71_Xmu

    // $ANTLR start synpred72_Xmu
    public final void synpred72_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_2 =null;


        // Xmu.g:5738:6: (a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5738:6: a0_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred72_Xmu5556);
        a0_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred72_Xmu

    // $ANTLR start synpred77_Xmu
    public final void synpred77_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a8_0 =null;


        // Xmu.g:5864:3: (a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:5864:3: a8_0= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred77_Xmu5682);
        a8_0=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred77_Xmu

    // $ANTLR start synpred78_Xmu
    public final void synpred78_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a8_1 =null;


        // Xmu.g:5883:6: (a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5883:6: a8_1= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred78_Xmu5696);
        a8_1=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred78_Xmu

    // $ANTLR start synpred79_Xmu
    public final void synpred79_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a8_2 =null;


        // Xmu.g:5902:6: (a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5902:6: a8_2= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred79_Xmu5710);
        a8_2=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred79_Xmu

    // $ANTLR start synpred80_Xmu
    public final void synpred80_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a0_0 =null;


        // Xmu.g:5969:3: (a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:5969:3: a0_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred80_Xmu5761);
        a0_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred80_Xmu

    // $ANTLR start synpred81_Xmu
    public final void synpred81_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a0_1 =null;


        // Xmu.g:5988:6: (a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:5988:6: a0_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred81_Xmu5775);
        a0_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred81_Xmu

    // $ANTLR start synpred84_Xmu
    public final void synpred84_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a6_0 =null;


        // Xmu.g:6090:5: (a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6090:5: a6_0= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred84_Xmu5904);
        a6_0=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred84_Xmu

    // $ANTLR start synpred85_Xmu
    public final void synpred85_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a6_1 =null;


        // Xmu.g:6109:10: (a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6109:10: a6_1= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred85_Xmu5924);
        a6_1=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred85_Xmu

    // $ANTLR start synpred91_Xmu
    public final void synpred91_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a1_0 =null;


        // Xmu.g:6405:3: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6405:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred91_Xmu6208);
        a1_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred91_Xmu

    // $ANTLR start synpred92_Xmu
    public final void synpred92_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a1_1 =null;


        // Xmu.g:6424:6: (a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6424:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred92_Xmu6222);
        a1_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred92_Xmu

    // $ANTLR start synpred93_Xmu
    public final void synpred93_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a1_2 =null;


        // Xmu.g:6443:6: (a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6443:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred93_Xmu6236);
        a1_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred93_Xmu

    // $ANTLR start synpred94_Xmu
    public final void synpred94_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a1_3 =null;


        // Xmu.g:6462:6: (a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6462:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred94_Xmu6250);
        a1_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred94_Xmu

    // $ANTLR start synpred95_Xmu
    public final void synpred95_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a1_4 =null;


        // Xmu.g:6481:6: (a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6481:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred95_Xmu6264);
        a1_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred95_Xmu

    // $ANTLR start synpred96_Xmu
    public final void synpred96_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a1_5 =null;


        // Xmu.g:6500:6: (a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6500:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred96_Xmu6278);
        a1_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred96_Xmu

    // $ANTLR start synpred98_Xmu
    public final void synpred98_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr a1_0 =null;


        // Xmu.g:6699:3: (a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6699:3: a1_0= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred98_Xmu6439);
        a1_0=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred98_Xmu

    // $ANTLR start synpred99_Xmu
    public final void synpred99_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr a1_1 =null;


        // Xmu.g:6718:6: (a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6718:6: a1_1= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred99_Xmu6453);
        a1_1=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred99_Xmu

    // $ANTLR start synpred100_Xmu
    public final void synpred100_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr a1_2 =null;


        // Xmu.g:6737:6: (a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6737:6: a1_2= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred100_Xmu6467);
        a1_2=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred100_Xmu

    // $ANTLR start synpred101_Xmu
    public final void synpred101_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr a1_3 =null;


        // Xmu.g:6756:6: (a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6756:6: a1_3= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred101_Xmu6481);
        a1_3=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred101_Xmu

    // $ANTLR start synpred102_Xmu
    public final void synpred102_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr a1_4 =null;


        // Xmu.g:6775:6: (a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6775:6: a1_4= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred102_Xmu6495);
        a1_4=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred102_Xmu

    // $ANTLR start synpred103_Xmu
    public final void synpred103_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr a1_5 =null;


        // Xmu.g:6794:6: (a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6794:6: a1_5= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred103_Xmu6509);
        a1_5=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred103_Xmu

    // $ANTLR start synpred118_Xmu
    public final void synpred118_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.PatternReferenceExpr c0 =null;


        // Xmu.g:6964:2: (c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr )
        // Xmu.g:6964:2: c0= parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_synpred118_Xmu6810);
        c0=parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred118_Xmu

    // $ANTLR start synpred121_Xmu
    public final void synpred121_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.VariableExp c0 =null;


        // Xmu.g:6985:2: (c0= parse_edu_ustb_sei_mde_xmu_VariableExp )
        // Xmu.g:6985:2: c0= parse_edu_ustb_sei_mde_xmu_VariableExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_synpred121_Xmu6903);
        c0=parse_edu_ustb_sei_mde_xmu_VariableExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred121_Xmu

    // $ANTLR start synpred122_Xmu
    public final void synpred122_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.StringLiteral c1 =null;


        // Xmu.g:6986:4: (c1= parse_edu_ustb_sei_mde_xmu_StringLiteral )
        // Xmu.g:6986:4: c1= parse_edu_ustb_sei_mde_xmu_StringLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_synpred122_Xmu6913);
        c1=parse_edu_ustb_sei_mde_xmu_StringLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred122_Xmu

    // $ANTLR start synpred123_Xmu
    public final void synpred123_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EmptyLiteral c2 =null;


        // Xmu.g:6987:4: (c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral )
        // Xmu.g:6987:4: c2= parse_edu_ustb_sei_mde_xmu_EmptyLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_synpred123_Xmu6923);
        c2=parse_edu_ustb_sei_mde_xmu_EmptyLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred123_Xmu

    // $ANTLR start synpred124_Xmu
    public final void synpred124_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.IntegerLiteral c3 =null;


        // Xmu.g:6988:4: (c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral )
        // Xmu.g:6988:4: c3= parse_edu_ustb_sei_mde_xmu_IntegerLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_synpred124_Xmu6933);
        c3=parse_edu_ustb_sei_mde_xmu_IntegerLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred124_Xmu

    // $ANTLR start synpred125_Xmu
    public final void synpred125_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanLiteral c4 =null;


        // Xmu.g:6989:4: (c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral )
        // Xmu.g:6989:4: c4= parse_edu_ustb_sei_mde_xmu_BooleanLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_synpred125_Xmu6943);
        c4=parse_edu_ustb_sei_mde_xmu_BooleanLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred125_Xmu

    // $ANTLR start synpred126_Xmu
    public final void synpred126_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.EnumLiteral c5 =null;


        // Xmu.g:6990:4: (c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral )
        // Xmu.g:6990:4: c5= parse_edu_ustb_sei_mde_xmu_EnumLiteral
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_synpred126_Xmu6953);
        c5=parse_edu_ustb_sei_mde_xmu_EnumLiteral();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred126_Xmu

    // $ANTLR start synpred127_Xmu
    public final void synpred127_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanOrExpr c6 =null;


        // Xmu.g:6991:4: (c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr )
        // Xmu.g:6991:4: c6= parse_edu_ustb_sei_mde_xmu_BooleanOrExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred127_Xmu6963);
        c6=parse_edu_ustb_sei_mde_xmu_BooleanOrExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred127_Xmu

    // $ANTLR start synpred128_Xmu
    public final void synpred128_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.BooleanAndExpr c7 =null;


        // Xmu.g:6992:4: (c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr )
        // Xmu.g:6992:4: c7= parse_edu_ustb_sei_mde_xmu_BooleanAndExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred128_Xmu6973);
        c7=parse_edu_ustb_sei_mde_xmu_BooleanAndExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred128_Xmu

    // $ANTLR start synpred129_Xmu
    public final void synpred129_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.RelationalExpr c8 =null;


        // Xmu.g:6993:4: (c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr )
        // Xmu.g:6993:4: c8= parse_edu_ustb_sei_mde_xmu_RelationalExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred129_Xmu6983);
        c8=parse_edu_ustb_sei_mde_xmu_RelationalExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred129_Xmu

    // $ANTLR start synpred130_Xmu
    public final void synpred130_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.AdditiveExpr c9 =null;


        // Xmu.g:6994:4: (c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr )
        // Xmu.g:6994:4: c9= parse_edu_ustb_sei_mde_xmu_AdditiveExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred130_Xmu6993);
        c9=parse_edu_ustb_sei_mde_xmu_AdditiveExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred130_Xmu

    // $ANTLR start synpred131_Xmu
    public final void synpred131_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.MultiplicativeExpr c10 =null;


        // Xmu.g:6995:4: (c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr )
        // Xmu.g:6995:4: c10= parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred131_Xmu7003);
        c10=parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred131_Xmu

    // $ANTLR start synpred132_Xmu
    public final void synpred132_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.ParenExpr c11 =null;


        // Xmu.g:6996:4: (c11= parse_edu_ustb_sei_mde_xmu_ParenExpr )
        // Xmu.g:6996:4: c11= parse_edu_ustb_sei_mde_xmu_ParenExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_synpred132_Xmu7013);
        c11=parse_edu_ustb_sei_mde_xmu_ParenExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_Xmu

    // $ANTLR start synpred133_Xmu
    public final void synpred133_Xmu_fragment() throws RecognitionException {
        edu.ustb.sei.mde.xmu.UnaryExpr c12 =null;


        // Xmu.g:6997:4: (c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr )
        // Xmu.g:6997:4: c12= parse_edu_ustb_sei_mde_xmu_UnaryExpr
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred133_Xmu7023);
        c12=parse_edu_ustb_sei_mde_xmu_UnaryExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_Xmu

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
    public final boolean synpred72_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred102_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred132_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred133_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred28_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred103_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred43_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred42_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_Xmu_fragment(); // can never throw exception
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
    public final boolean synpred27_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_Xmu_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred95_Xmu() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred95_Xmu_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1889 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1919 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1942 = new BitSet(new long[]{0x0000000000010080L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_UpdatedStatement1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_edu_ustb_sei_mde_xmu_VStatement2010 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_57_in_parse_edu_ustb_sei_mde_xmu_VStatement2025 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_56_in_parse_edu_ustb_sei_mde_xmu_VStatement2040 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_VStatement2061 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_VStatement2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_Pattern2116 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_Pattern2143 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2169 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2189 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2209 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2229 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2249 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2269 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_Pattern2289 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_Pattern2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Pattern2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2384 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_xmu_PatternNode2405 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternNode2423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_PatternNode2444 = new BitSet(new long[]{0x0000000000000080L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2473 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000004L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_PatternNode2514 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternExpr_in_parse_edu_ustb_sei_mde_xmu_PatternNode2548 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_PatternNode2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2655 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2685 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2711 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2739 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2772 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr2790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2827 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2857 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2883 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2911 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2944 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_VariableExp2999 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Path_in_parse_edu_ustb_sei_mde_xmu_VariableExp3035 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3091 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_FeaturePath3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_LoopPath3145 = new BitSet(new long[]{0x00100C0000000000L});
    public static final BitSet FOLLOW_52_in_parse_edu_ustb_sei_mde_xmu_LoopPath3168 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_43_in_parse_edu_ustb_sei_mde_xmu_LoopPath3183 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_42_in_parse_edu_ustb_sei_mde_xmu_LoopPath3198 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_LoopPath3219 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Variable_in_parse_edu_ustb_sei_mde_xmu_LoopPath3237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_parse_edu_ustb_sei_mde_xmu_LoopPath3255 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3273 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3287 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3301 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3315 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3329 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3343 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_LoopPath3357 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_LoopPath3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_OperationPath3404 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_OperationPath3422 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_OperationPath3443 = new BitSet(new long[]{0x2021C08000218590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3472 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_OperationPath3513 = new BitSet(new long[]{0x2021C08000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_OperationPath3547 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_OperationPath3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_xmu_StringLiteral3654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_parse_edu_ustb_sei_mde_xmu_EmptyLiteral3714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_parse_edu_ustb_sei_mde_xmu_IntegerLiteral3754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_parse_edu_ustb_sei_mde_xmu_BooleanLiteral3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3834 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3855 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_EnumLiteral3873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3909 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000005L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3938 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_BlockStatement3979 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_BlockStatement4013 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_BlockStatement4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4116 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4134 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_62_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4164 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4190 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4231 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4265 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4339 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseSubStatement_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4362 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_xmu_SwitchStatement4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4417 = new BitSet(new long[]{0x0000020000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Pattern_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4435 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4453 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CasePatternStatement4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4504 = new BitSet(new long[]{0x2021C08000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4522 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4540 = new BitSet(new long[]{0x0C84030000000080L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Statement_in_parse_edu_ustb_sei_mde_xmu_CaseValueStatement4558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4595 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4616 = new BitSet(new long[]{0x2021C08000218590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4645 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4686 = new BitSet(new long[]{0x2021C08000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_Expr_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4720 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_RuleCallStatement4794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4823 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternNode_in_parse_edu_ustb_sei_mde_xmu_UpdatePattern4841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4874 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteNode4892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4928 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4946 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4967 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink4985 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_DeleteLink5006 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_DeleteLink5024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5064 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5078 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5092 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5106 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5133 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5159 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5179 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5199 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr5219 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5279 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5293 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5307 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5321 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5335 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5362 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5388 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5408 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5428 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5448 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr5468 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5528 = new BitSet(new long[]{0x00000003E0000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5542 = new BitSet(new long[]{0x00000003E0000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5556 = new BitSet(new long[]{0x00000003E0000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5570 = new BitSet(new long[]{0x00000003E0000000L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5597 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5612 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_30_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5627 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_32_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5642 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_33_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5657 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_RelationalExpr5724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5761 = new BitSet(new long[]{0x00000000002C0000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5775 = new BitSet(new long[]{0x00000000002C0000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5789 = new BitSet(new long[]{0x00000000002C0000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5829 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5848 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5867 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5904 = new BitSet(new long[]{0x00000000002C0002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5924 = new BitSet(new long[]{0x00000000002C0002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_AdditiveExpr5944 = new BitSet(new long[]{0x00000000002C0002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6004 = new BitSet(new long[]{0x0000000001020000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6018 = new BitSet(new long[]{0x0000000001020000L});
    public static final BitSet FOLLOW_17_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6058 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6077 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6114 = new BitSet(new long[]{0x0000000001020002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr6134 = new BitSet(new long[]{0x0000000001020002L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6190 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6208 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6222 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6236 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6250 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6264 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6278 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6292 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_xmu_ParenExpr6310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6348 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6363 = new BitSet(new long[]{0x0001400000008590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_UnaryExpr6388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6421 = new BitSet(new long[]{0x0001C00000208590L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AtomicExpr_in_parse_edu_ustb_sei_mde_xmu_PrintStatement6523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StartRoot_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6560 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6578 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NAME_in_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr6596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ForStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatedStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BlockStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_SwitchStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RuleCallStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UpdatePattern_in_parse_edu_ustb_sei_mde_xmu_Statement6678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteNode_in_parse_edu_ustb_sei_mde_xmu_Statement6688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_DeleteLink_in_parse_edu_ustb_sei_mde_xmu_Statement6698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrintStatement_in_parse_edu_ustb_sei_mde_xmu_Statement6708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_AtomicExpr6789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternEqualExpr_in_parse_edu_ustb_sei_mde_xmu_PatternExpr6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_FeaturePath_in_parse_edu_ustb_sei_mde_xmu_Path6841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_LoopPath_in_parse_edu_ustb_sei_mde_xmu_Path6851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_OperationPath_in_parse_edu_ustb_sei_mde_xmu_Path6861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PrimitiveVariable_in_parse_edu_ustb_sei_mde_xmu_Variable6882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_parse_edu_ustb_sei_mde_xmu_Expr6903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_parse_edu_ustb_sei_mde_xmu_Expr6953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_parse_edu_ustb_sei_mde_xmu_Expr6993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AllInstanceExpr_in_parse_edu_ustb_sei_mde_xmu_Expr7033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CasePatternStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement7054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_CaseValueStatement_in_parse_edu_ustb_sei_mde_xmu_CaseSubStatement7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred17_Xmu1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1684 = new BitSet(new long[]{0x0300200000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VStatement_in_synpred18_Xmu1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred23_Xmu2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred24_Xmu2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred25_Xmu2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred26_Xmu2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred27_Xmu2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred28_Xmu2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred38_Xmu3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred39_Xmu3287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred40_Xmu3301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred41_Xmu3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred42_Xmu3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred43_Xmu3343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred54_Xmu5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred55_Xmu5078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred56_Xmu5092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred57_Xmu5159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred58_Xmu5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred59_Xmu5199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred61_Xmu5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred62_Xmu5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred63_Xmu5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred64_Xmu5321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred65_Xmu5388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred66_Xmu5408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred67_Xmu5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred68_Xmu5448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred70_Xmu5528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred71_Xmu5542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred72_Xmu5556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred77_Xmu5682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred78_Xmu5696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred79_Xmu5710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred80_Xmu5761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred81_Xmu5775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred84_Xmu5904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred85_Xmu5924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred91_Xmu6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred92_Xmu6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred93_Xmu6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred94_Xmu6250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred95_Xmu6264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred96_Xmu6278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred98_Xmu6439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred99_Xmu6453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred100_Xmu6467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred101_Xmu6481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred102_Xmu6495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred103_Xmu6509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_PatternReferenceExpr_in_synpred118_Xmu6810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_VariableExp_in_synpred121_Xmu6903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_StringLiteral_in_synpred122_Xmu6913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EmptyLiteral_in_synpred123_Xmu6923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_IntegerLiteral_in_synpred124_Xmu6933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanLiteral_in_synpred125_Xmu6943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_EnumLiteral_in_synpred126_Xmu6953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanOrExpr_in_synpred127_Xmu6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_BooleanAndExpr_in_synpred128_Xmu6973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_RelationalExpr_in_synpred129_Xmu6983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_AdditiveExpr_in_synpred130_Xmu6993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_MultiplicativeExpr_in_synpred131_Xmu7003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_ParenExpr_in_synpred132_Xmu7013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_xmu_UnaryExpr_in_synpred133_Xmu7023 = new BitSet(new long[]{0x0000000000000002L});

}