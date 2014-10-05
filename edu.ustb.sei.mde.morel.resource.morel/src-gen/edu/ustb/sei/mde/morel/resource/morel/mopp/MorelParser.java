// $ANTLR 3.4

	package edu.ustb.sei.mde.morel.resource.morel.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MorelParser extends MorelANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATA_TYPE", "IDENTIFIER", "INUMBER", "LINEBREAK", "QUOTED_39_39_92", "RNUMBER", "URINS", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "':'", "';'", "'<'", "'<-'", "'<='", "'<>'", "'='", "'=>'", "'>'", "'>='", "'and'", "'closure'", "'collect'", "'else'", "'endif'", "'exists'", "'false'", "'for'", "'forAll'", "'if'", "'implies'", "'in'", "'invalid'", "'let'", "'lhs'", "'match'", "'nac'", "'not'", "'null'", "'or'", "'pac'", "'post'", "'pre'", "'query'", "'querymodel'", "'reject'", "'rhs'", "'rule'", "'select'", "'then'", "'transformation'", "'true'", "'type'", "'when'", "'{'", "'|'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
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
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int DATA_TYPE=4;
    public static final int IDENTIFIER=5;
    public static final int INUMBER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_39_39_92=8;
    public static final int RNUMBER=9;
    public static final int URINS=10;
    public static final int WHITESPACE=11;

    // delegates
    public MorelANTLRParserBase[] getDelegates() {
        return new MorelANTLRParserBase[] {};
    }

    // delegators


    public MorelParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public MorelParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(191 + 1);
         

    }

    public String[] getTokenNames() { return MorelParser.tokenNames; }
    public String getGrammarFileName() { return "Morel.g"; }


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
    			if (type.getInstanceClass() == edu.ustb.sei.mde.morel.LinkConstraint.class) {
    				return parse_edu_ustb_sei_mde_morel_LinkConstraint();
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
    		int followSetID = 208;
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
    	



    // $ANTLR start "start"
    // Morel.g:604:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_edu_ustb_sei_mde_morel_QueryModel |c1= parse_edu_ustb_sei_mde_morel_TransformationModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        edu.ustb.sei.mde.morel.QueryModel c0 =null;

        edu.ustb.sei.mde.morel.TransformationModel c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Morel.g:605:2: ( (c0= parse_edu_ustb_sei_mde_morel_QueryModel |c1= parse_edu_ustb_sei_mde_morel_TransformationModel ) EOF )
            // Morel.g:606:2: (c0= parse_edu_ustb_sei_mde_morel_QueryModel |c1= parse_edu_ustb_sei_mde_morel_TransformationModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Morel.g:612:2: (c0= parse_edu_ustb_sei_mde_morel_QueryModel |c1= parse_edu_ustb_sei_mde_morel_TransformationModel )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==58) ) {
                alt1=1;
            }
            else if ( (LA1_0==64) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // Morel.g:613:3: c0= parse_edu_ustb_sei_mde_morel_QueryModel
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_QueryModel_in_start82);
                    c0=parse_edu_ustb_sei_mde_morel_QueryModel();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; }

                    }
                    break;
                case 2 :
                    // Morel.g:614:8: c1= parse_edu_ustb_sei_mde_morel_TransformationModel
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TransformationModel_in_start96);
                    c1=parse_edu_ustb_sei_mde_morel_TransformationModel();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; }

                    }
                    break;

            }


            match(input,EOF,FOLLOW_EOF_in_start103); if (state.failed) return element;

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



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_QueryModel"
    // Morel.g:622:1: parse_edu_ustb_sei_mde_morel_QueryModel returns [edu.ustb.sei.mde.morel.QueryModel element = null] : a0= 'querymodel' ( (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a2_0= parse_edu_ustb_sei_mde_morel_Query ) )* ;
    public final edu.ustb.sei.mde.morel.QueryModel parse_edu_ustb_sei_mde_morel_QueryModel() throws RecognitionException {
        edu.ustb.sei.mde.morel.QueryModel element =  null;

        int parse_edu_ustb_sei_mde_morel_QueryModel_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.TypedModel a1_0 =null;

        edu.ustb.sei.mde.morel.Query a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Morel.g:625:2: (a0= 'querymodel' ( (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a2_0= parse_edu_ustb_sei_mde_morel_Query ) )* )
            // Morel.g:626:2: a0= 'querymodel' ( (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a2_0= parse_edu_ustb_sei_mde_morel_Query ) )*
            {
            a0=(Token)match(input,58,FOLLOW_58_in_parse_edu_ustb_sei_mde_morel_QueryModel129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQueryModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2]);
            	}

            // Morel.g:640:2: ( (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==66) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Morel.g:641:3: (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel )
            	    {
            	    // Morel.g:641:3: (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel )
            	    // Morel.g:642:4: a1_0= parse_edu_ustb_sei_mde_morel_TypedModel
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypedModel_in_parse_edu_ustb_sei_mde_morel_QueryModel152);
            	    a1_0=parse_edu_ustb_sei_mde_morel_TypedModel();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[4]);
            	}

            // Morel.g:669:2: ( (a2_0= parse_edu_ustb_sei_mde_morel_Query ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==57) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Morel.g:670:3: (a2_0= parse_edu_ustb_sei_mde_morel_Query )
            	    {
            	    // Morel.g:670:3: (a2_0= parse_edu_ustb_sei_mde_morel_Query )
            	    // Morel.g:671:4: a2_0= parse_edu_ustb_sei_mde_morel_Query
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Query_in_parse_edu_ustb_sei_mde_morel_QueryModel187);
            	    a2_0=parse_edu_ustb_sei_mde_morel_Query();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[5]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_edu_ustb_sei_mde_morel_QueryModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_QueryModel"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_TypedModel"
    // Morel.g:699:1: parse_edu_ustb_sei_mde_morel_TypedModel returns [edu.ustb.sei.mde.morel.TypedModel element = null] : a0= 'type' (a1= IDENTIFIER ) a2= '<-' (a3= URINS ) ;
    public final edu.ustb.sei.mde.morel.TypedModel parse_edu_ustb_sei_mde_morel_TypedModel() throws RecognitionException {
        edu.ustb.sei.mde.morel.TypedModel element =  null;

        int parse_edu_ustb_sei_mde_morel_TypedModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Morel.g:702:2: (a0= 'type' (a1= IDENTIFIER ) a2= '<-' (a3= URINS ) )
            // Morel.g:703:2: a0= 'type' (a1= IDENTIFIER ) a2= '<-' (a3= URINS )
            {
            a0=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_TypedModel228); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[6]);
            	}

            // Morel.g:717:2: (a1= IDENTIFIER )
            // Morel.g:718:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_TypedModel246); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[7]);
            	}

            a2=(Token)match(input,27,FOLLOW_27_in_parse_edu_ustb_sei_mde_morel_TypedModel267); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[8]);
            	}

            // Morel.g:767:2: (a3= URINS )
            // Morel.g:768:3: a3= URINS
            {
            a3=(Token)match(input,URINS,FOLLOW_URINS_in_parse_edu_ustb_sei_mde_morel_TypedModel285); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTypedModel();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("URINS");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.TYPED_MODEL__PACKAGE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_1_0_0_3, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[11]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_edu_ustb_sei_mde_morel_TypedModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_TypedModel"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Query"
    // Morel.g:811:1: parse_edu_ustb_sei_mde_morel_Query returns [edu.ustb.sei.mde.morel.Query element = null] : a0= 'query' ( (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )? ) (a9= IDENTIFIER ) a10= '{' a11= 'match' a12= ':' ( ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' ) )? ( ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' ) )? ( (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a24= '}' ;
    public final edu.ustb.sei.mde.morel.Query parse_edu_ustb_sei_mde_morel_Query() throws RecognitionException {
        edu.ustb.sei.mde.morel.Query element =  null;

        int parse_edu_ustb_sei_mde_morel_Query_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a14=null;
        Token a16=null;
        Token a18=null;
        Token a20=null;
        Token a21=null;
        Token a22=null;
        Token a24=null;
        edu.ustb.sei.mde.morel.Variable a13_0 =null;

        edu.ustb.sei.mde.morel.Variable a15_0 =null;

        edu.ustb.sei.mde.morel.LinkConstraint a17_0 =null;

        edu.ustb.sei.mde.morel.LinkConstraint a19_0 =null;

        edu.ustb.sei.mde.morel.Statement a23_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Morel.g:814:2: (a0= 'query' ( (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )? ) (a9= IDENTIFIER ) a10= '{' a11= 'match' a12= ':' ( ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' ) )? ( ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' ) )? ( (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a24= '}' )
            // Morel.g:815:2: a0= 'query' ( (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )? ) (a9= IDENTIFIER ) a10= '{' a11= 'match' a12= ':' ( ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' ) )? ( ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' ) )? ( (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a24= '}'
            {
            a0=(Token)match(input,57,FOLLOW_57_in_parse_edu_ustb_sei_mde_morel_Query321); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[12]);
            	}

            // Morel.g:832:2: ( (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )? )
            // Morel.g:833:3: (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )?
            {
            // Morel.g:833:3: (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )?
            int alt4=7;
            switch ( input.LA(1) ) {
                case 48:
                    {
                    alt4=1;
                    }
                    break;
                case 60:
                    {
                    alt4=2;
                    }
                    break;
                case 50:
                    {
                    alt4=3;
                    }
                    break;
                case 54:
                    {
                    alt4=4;
                    }
                    break;
                case 56:
                    {
                    alt4=5;
                    }
                    break;
                case 55:
                    {
                    alt4=6;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // Morel.g:834:4: a1= 'lhs'
                    {
                    a1=(Token)match(input,48,FOLLOW_48_in_parse_edu_ustb_sei_mde_morel_Query344); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Morel.g:850:8: a2= 'rhs'
                    {
                    a2=(Token)match(input,60,FOLLOW_60_in_parse_edu_ustb_sei_mde_morel_Query359); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.RHS_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Morel.g:866:8: a3= 'nac'
                    {
                    a3=(Token)match(input,50,FOLLOW_50_in_parse_edu_ustb_sei_mde_morel_Query374); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.NAC_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Morel.g:882:8: a4= 'pac'
                    {
                    a4=(Token)match(input,54,FOLLOW_54_in_parse_edu_ustb_sei_mde_morel_Query389); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PAC_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Morel.g:898:8: a5= 'pre'
                    {
                    a5=(Token)match(input,56,FOLLOW_56_in_parse_edu_ustb_sei_mde_morel_Query404); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PRE_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 6 :
                    // Morel.g:914:8: a6= 'post'
                    {
                    a6=(Token)match(input,55,FOLLOW_55_in_parse_edu_ustb_sei_mde_morel_Query419); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.POST_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[13]);
            	}

            // Morel.g:936:2: (a9= IDENTIFIER )
            // Morel.g:937:3: a9= IDENTIFIER
            {
            a9=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_Query444); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            			if (a9 != null) {
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[14]);
            	}

            a10=(Token)match(input,68,FOLLOW_68_in_parse_edu_ustb_sei_mde_morel_Query465); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[15]);
            	}

            a11=(Token)match(input,49,FOLLOW_49_in_parse_edu_ustb_sei_mde_morel_Query479); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[16]);
            	}

            a12=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Query493); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[23]);
            	}

            // Morel.g:1032:2: ( ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==IDENTIFIER) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==24) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // Morel.g:1033:3: ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' )
                    {
                    // Morel.g:1033:3: ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' )
                    // Morel.g:1034:4: (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';'
                    {
                    // Morel.g:1034:4: (a13_0= parse_edu_ustb_sei_mde_morel_Variable )
                    // Morel.g:1035:5: a13_0= parse_edu_ustb_sei_mde_morel_Variable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Query522);
                    a13_0=parse_edu_ustb_sei_mde_morel_Variable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    					if (a13_0 != null) {
                    						if (a13_0 != null) {
                    							Object value = a13_0;
                    							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__VARIABLES, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_6_0_0_0, a13_0, true);
                    						copyLocalizationInfos(a13_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[24]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[25]);
                    			}

                    // Morel.g:1064:4: ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==19) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Morel.g:1065:5: (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                    	    {
                    	    // Morel.g:1065:5: (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                    	    // Morel.g:1066:6: a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable )
                    	    {
                    	    a14=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_Query563); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    	    							startIncompleteElement(element);
                    	    							// initialize enumeration attribute
                    	    							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    	    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_6_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[26]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[27]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[28]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[29]);
                    	    					}

                    	    // Morel.g:1086:6: (a15_0= parse_edu_ustb_sei_mde_morel_Variable )
                    	    // Morel.g:1087:7: a15_0= parse_edu_ustb_sei_mde_morel_Variable
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Query597);
                    	    a15_0=parse_edu_ustb_sei_mde_morel_Variable();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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
                    	    							if (a15_0 != null) {
                    	    								if (a15_0 != null) {
                    	    									Object value = a15_0;
                    	    									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__VARIABLES, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_6_0_0_1_0_0_1, a15_0, true);
                    	    								copyLocalizationInfos(a15_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[30]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[31]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[32]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[33]);
                    			}

                    a16=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_Query658); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_6_0_0_2, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[34]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[35]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[36]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[39]);
            	}

            // Morel.g:1152:2: ( ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDENTIFIER) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Morel.g:1153:3: ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' )
                    {
                    // Morel.g:1153:3: ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' )
                    // Morel.g:1154:4: (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';'
                    {
                    // Morel.g:1154:4: (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                    // Morel.g:1155:5: a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Query706);
                    a17_0=parse_edu_ustb_sei_mde_morel_LinkConstraint();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    					if (a17_0 != null) {
                    						if (a17_0 != null) {
                    							Object value = a17_0;
                    							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__LINK_CONSTRAINTS, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_7_0_0_0, a17_0, true);
                    						copyLocalizationInfos(a17_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[40]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[41]);
                    			}

                    // Morel.g:1184:4: ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==19) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Morel.g:1185:5: (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) )
                    	    {
                    	    // Morel.g:1185:5: (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) )
                    	    // Morel.g:1186:6: a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                    	    {
                    	    a18=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_Query747); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    	    							startIncompleteElement(element);
                    	    							// initialize enumeration attribute
                    	    							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    	    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_7_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[42]);
                    	    					}

                    	    // Morel.g:1203:6: (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                    	    // Morel.g:1204:7: a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Query781);
                    	    a19_0=parse_edu_ustb_sei_mde_morel_LinkConstraint();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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
                    	    							if (a19_0 != null) {
                    	    								if (a19_0 != null) {
                    	    									Object value = a19_0;
                    	    									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__LINK_CONSTRAINTS, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_7_0_0_1_0_0_1, a19_0, true);
                    	    								copyLocalizationInfos(a19_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[43]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[44]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[45]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[46]);
                    			}

                    a20=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_Query842); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_7_0_0_2, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[47]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[48]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[50]);
            	}

            // Morel.g:1267:2: ( (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==67) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Morel.g:1268:3: (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ )
                    {
                    // Morel.g:1268:3: (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ )
                    // Morel.g:1269:4: a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+
                    {
                    a21=(Token)match(input,67,FOLLOW_67_in_parse_edu_ustb_sei_mde_morel_Query884); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_8_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[51]);
                    			}

                    a22=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Query904); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_8_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[52]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[53]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[54]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[55]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[56]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[57]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[58]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[59]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[60]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[61]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[62]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[63]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[64]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[65]);
                    			}

                    // Morel.g:1316:4: ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= DATA_TYPE && LA9_0 <= INUMBER)||(LA9_0 >= QUOTED_39_39_92 && LA9_0 <= RNUMBER)||LA9_0==12||LA9_0==15||LA9_0==18||LA9_0==20||(LA9_0 >= 40 && LA9_0 <= 41)||LA9_0==43||(LA9_0 >= 46 && LA9_0 <= 47)||(LA9_0 >= 51 && LA9_0 <= 52)||LA9_0==65||LA9_0==68) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Morel.g:1317:5: ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) )
                    	    {
                    	    // Morel.g:1317:5: ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) )
                    	    // Morel.g:1318:6: (a23_0= parse_edu_ustb_sei_mde_morel_Statement )
                    	    {
                    	    // Morel.g:1318:6: (a23_0= parse_edu_ustb_sei_mde_morel_Statement )
                    	    // Morel.g:1319:7: a23_0= parse_edu_ustb_sei_mde_morel_Statement
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_Query945);
                    	    a23_0=parse_edu_ustb_sei_mde_morel_Statement();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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
                    	    									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.QUERY__STATEMENTS, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_8_0_0_2_0_0_0, a23_0, true);
                    	    								copyLocalizationInfos(a23_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[66]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[67]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[68]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[69]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[70]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[71]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[72]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[73]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[74]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[75]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[76]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[77]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[78]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[79]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[80]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[81]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[82]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[83]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[84]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[85]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[86]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[87]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[88]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[89]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[90]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[91]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[92]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[93]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[94]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[95]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[96]);
            	}

            a24=(Token)match(input,71,FOLLOW_71_in_parse_edu_ustb_sei_mde_morel_Query1019); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createQuery();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.QUERY__TYPE), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_2_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[97]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[99]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_edu_ustb_sei_mde_morel_Query_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Query"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_ObjectVariable"
    // Morel.g:1410:1: parse_edu_ustb_sei_mde_morel_ObjectVariable returns [edu.ustb.sei.mde.morel.ObjectVariable element = null] : ( (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) |c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit );
    public final edu.ustb.sei.mde.morel.ObjectVariable parse_edu_ustb_sei_mde_morel_ObjectVariable() throws RecognitionException {
        edu.ustb.sei.mde.morel.ObjectVariable element =  null;

        int parse_edu_ustb_sei_mde_morel_ObjectVariable_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        edu.ustb.sei.mde.morel.ObjectVariableWithInit c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Morel.g:1413:2: ( (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) |c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENTIFIER) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==24) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==IDENTIFIER) ) {
                        switch ( input.LA(4) ) {
                        case 12:
                            {
                            int LA12_4 = input.LA(5);

                            if ( (LA12_4==IDENTIFIER) ) {
                                int LA12_7 = input.LA(6);

                                if ( (LA12_7==EOF||LA12_7==19||LA12_7==25||LA12_7==69) ) {
                                    alt12=1;
                                }
                                else if ( (LA12_7==30) ) {
                                    alt12=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 12, 7, input);

                                    throw nvae;

                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 12, 4, input);

                                throw nvae;

                            }
                            }
                            break;
                        case EOF:
                        case 19:
                        case 25:
                        case 69:
                            {
                            alt12=1;
                            }
                            break;
                        case 30:
                            {
                            alt12=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 3, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Morel.g:1414:2: (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER )
                    {
                    // Morel.g:1414:2: (a0= IDENTIFIER )
                    // Morel.g:1415:3: a0= IDENTIFIER
                    {
                    a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1052); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[100]);
                    	}

                    a1=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1073); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_3_0_0_1, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[101]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[102]);
                    	}

                    // Morel.g:1465:2: ( ( (a2= IDENTIFIER ) a3= '!' ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDENTIFIER) ) {
                        int LA11_1 = input.LA(2);

                        if ( (LA11_1==12) ) {
                            alt11=1;
                        }
                    }
                    switch (alt11) {
                        case 1 :
                            // Morel.g:1466:3: ( (a2= IDENTIFIER ) a3= '!' )
                            {
                            // Morel.g:1466:3: ( (a2= IDENTIFIER ) a3= '!' )
                            // Morel.g:1467:4: (a2= IDENTIFIER ) a3= '!'
                            {
                            // Morel.g:1467:4: (a2= IDENTIFIER )
                            // Morel.g:1468:5: a2= IDENTIFIER
                            {
                            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1102); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[103]);
                            			}

                            a3=(Token)match(input,12,FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1135); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
                            					startIncompleteElement(element);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_3_0_0_2_0_0_1, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[104]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[105]);
                    	}

                    // Morel.g:1528:2: (a4= IDENTIFIER )
                    // Morel.g:1529:3: a4= IDENTIFIER
                    {
                    a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1172); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[106]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[107]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[108]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[109]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[110]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[111]);
                    	}

                    }
                    break;
                case 2 :
                    // Morel.g:1575:2: c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1198);
                    c0=parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit();

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
            if ( state.backtracking>0 ) { memoize(input, 5, parse_edu_ustb_sei_mde_morel_ObjectVariable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_ObjectVariable"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_PrimitiveVariable"
    // Morel.g:1579:1: parse_edu_ustb_sei_mde_morel_PrimitiveVariable returns [edu.ustb.sei.mde.morel.PrimitiveVariable element = null] : ( (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) |c0= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit );
    public final edu.ustb.sei.mde.morel.PrimitiveVariable parse_edu_ustb_sei_mde_morel_PrimitiveVariable() throws RecognitionException {
        edu.ustb.sei.mde.morel.PrimitiveVariable element =  null;

        int parse_edu_ustb_sei_mde_morel_PrimitiveVariable_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.PrimitiveVariableWithInit c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Morel.g:1582:2: ( (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) |c0= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENTIFIER) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==24) ) {
                    int LA13_2 = input.LA(3);

                    if ( (LA13_2==DATA_TYPE) ) {
                        int LA13_3 = input.LA(4);

                        if ( (LA13_3==EOF||LA13_3==19||LA13_3==25||LA13_3==69) ) {
                            alt13=1;
                        }
                        else if ( (LA13_3==30) ) {
                            alt13=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // Morel.g:1583:2: (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE )
                    {
                    // Morel.g:1583:2: (a0= IDENTIFIER )
                    // Morel.g:1584:3: a0= IDENTIFIER
                    {
                    a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1227); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[112]);
                    	}

                    a1=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1248); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariable();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_4_0_0_1, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[113]);
                    	}

                    // Morel.g:1633:2: (a2= DATA_TYPE )
                    // Morel.g:1634:3: a2= DATA_TYPE
                    {
                    a2=(Token)match(input,DATA_TYPE,FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1266); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[114]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[115]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[116]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[117]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[118]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[119]);
                    	}

                    }
                    break;
                case 2 :
                    // Morel.g:1680:2: c0= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1292);
                    c0=parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit();

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
            if ( state.backtracking>0 ) { memoize(input, 6, parse_edu_ustb_sei_mde_morel_PrimitiveVariable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_PrimitiveVariable"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit"
    // Morel.g:1684:1: parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit returns [edu.ustb.sei.mde.morel.ObjectVariableWithInit element = null] : (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) a5= '=' (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ;
    public final edu.ustb.sei.mde.morel.ObjectVariableWithInit parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit() throws RecognitionException {
        edu.ustb.sei.mde.morel.ObjectVariableWithInit element =  null;

        int parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        edu.ustb.sei.mde.morel.LetExp a6_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a6_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a6_2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Morel.g:1687:2: ( (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) a5= '=' (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
            // Morel.g:1688:2: (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) a5= '=' (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            {
            // Morel.g:1688:2: (a0= IDENTIFIER )
            // Morel.g:1689:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1321); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[120]);
            	}

            a1=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1342); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[122]);
            	}

            // Morel.g:1739:2: ( ( (a2= IDENTIFIER ) a3= '!' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==12) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // Morel.g:1740:3: ( (a2= IDENTIFIER ) a3= '!' )
                    {
                    // Morel.g:1740:3: ( (a2= IDENTIFIER ) a3= '!' )
                    // Morel.g:1741:4: (a2= IDENTIFIER ) a3= '!'
                    {
                    // Morel.g:1741:4: (a2= IDENTIFIER )
                    // Morel.g:1742:5: a2= IDENTIFIER
                    {
                    a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1371); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[123]);
                    			}

                    a3=(Token)match(input,12,FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1404); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_2_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[124]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[125]);
            	}

            // Morel.g:1802:2: (a4= IDENTIFIER )
            // Morel.g:1803:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1441); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[126]);
            	}

            a5=(Token)match(input,30,FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1462); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariableWithInit();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_5_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[137]);
            	}

            // Morel.g:1866:2: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt15=1;
                }
                break;
            case 43:
                {
                alt15=2;
                }
                break;
            case DATA_TYPE:
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 12:
            case 15:
            case 18:
            case 20:
            case 40:
            case 46:
            case 51:
            case 52:
            case 65:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // Morel.g:1867:3: a6_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1480);
                    a6_0=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Morel.g:1886:6: a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1494);
                    a6_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Morel.g:1905:6: a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1508);
                    a6_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[140]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[144]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[146]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit"
    // Morel.g:1940:1: parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit returns [edu.ustb.sei.mde.morel.PrimitiveVariableWithInit element = null] : (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) a3= '=' (a4_0= parse_edu_ustb_sei_mde_morel_LetExp |a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ;
    public final edu.ustb.sei.mde.morel.PrimitiveVariableWithInit parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit() throws RecognitionException {
        edu.ustb.sei.mde.morel.PrimitiveVariableWithInit element =  null;

        int parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        edu.ustb.sei.mde.morel.LetExp a4_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a4_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a4_2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Morel.g:1943:2: ( (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) a3= '=' (a4_0= parse_edu_ustb_sei_mde_morel_LetExp |a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
            // Morel.g:1944:2: (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) a3= '=' (a4_0= parse_edu_ustb_sei_mde_morel_LetExp |a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            {
            // Morel.g:1944:2: (a0= IDENTIFIER )
            // Morel.g:1945:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1545); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[147]);
            	}

            a1=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1566); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[148]);
            	}

            // Morel.g:1994:2: (a2= DATA_TYPE )
            // Morel.g:1995:3: a2= DATA_TYPE
            {
            a2=(Token)match(input,DATA_TYPE,FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1584); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[149]);
            	}

            a3=(Token)match(input,30,FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1605); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPrimitiveVariableWithInit();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_6_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[154]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[158]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[159]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[160]);
            	}

            // Morel.g:2058:2: (a4_0= parse_edu_ustb_sei_mde_morel_LetExp |a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt16=1;
                }
                break;
            case 43:
                {
                alt16=2;
                }
                break;
            case DATA_TYPE:
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 12:
            case 15:
            case 18:
            case 20:
            case 40:
            case 46:
            case 51:
            case 52:
            case 65:
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
                    // Morel.g:2059:3: a4_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1623);
                    a4_0=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Morel.g:2078:6: a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1637);
                    a4_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Morel.g:2097:6: a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1651);
                    a4_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[161]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[162]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[169]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_LinkConstraint"
    // Morel.g:2132:1: parse_edu_ustb_sei_mde_morel_LinkConstraint returns [edu.ustb.sei.mde.morel.LinkConstraint element = null] : (a0= IDENTIFIER ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= IDENTIFIER ) ;
    public final edu.ustb.sei.mde.morel.LinkConstraint parse_edu_ustb_sei_mde_morel_LinkConstraint() throws RecognitionException {
        edu.ustb.sei.mde.morel.LinkConstraint element =  null;

        int parse_edu_ustb_sei_mde_morel_LinkConstraint_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Morel.g:2135:2: ( (a0= IDENTIFIER ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= IDENTIFIER ) )
            // Morel.g:2136:2: (a0= IDENTIFIER ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= IDENTIFIER )
            {
            // Morel.g:2136:2: (a0= IDENTIFIER )
            // Morel.g:2137:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1688); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLinkConstraint();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__SOURCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__SOURCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__SOURCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[170]);
            	}

            a1=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1709); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLinkConstraint();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[171]);
            	}

            // Morel.g:2190:2: (a2= IDENTIFIER )
            // Morel.g:2191:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1727); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLinkConstraint();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__REFERENCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.eclipse.emf.ecore.EReference proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, org.eclipse.emf.ecore.EReference>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintReferenceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__REFERENCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__REFERENCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[172]);
            	}

            a3=(Token)match(input,30,FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1748); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLinkConstraint();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[173]);
            	}

            // Morel.g:2244:2: (a4= IDENTIFIER )
            // Morel.g:2245:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1766); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLinkConstraint();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__TARGET), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				edu.ustb.sei.mde.morel.ObjectVariable proxy = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createObjectVariable();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContextDependentURIFragmentFactory<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getLinkConstraintTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__TARGET), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.LINK_CONSTRAINT__TARGET), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_7_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[177]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_edu_ustb_sei_mde_morel_LinkConstraint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_LinkConstraint"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_VariableExp"
    // Morel.g:2289:1: parse_edu_ustb_sei_mde_morel_VariableExp returns [edu.ustb.sei.mde.morel.VariableExp element = null] : (a0= IDENTIFIER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.VariableExp parse_edu_ustb_sei_mde_morel_VariableExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.VariableExp element =  null;

        int parse_edu_ustb_sei_mde_morel_VariableExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Morel.g:2292:2: ( (a0= IDENTIFIER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2293:2: (a0= IDENTIFIER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:2293:2: (a0= IDENTIFIER )
            // Morel.g:2294:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_VariableExp1806); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[180]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[185]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[190]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[192]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[193]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[194]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[195]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[197]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[198]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[199]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[200]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[201]);
            	}

            // Morel.g:2356:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0 >= 21 && LA17_0 <= 22)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Morel.g:2357:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2357:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2358:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2358:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2359:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_VariableExp1842);
                    a1_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_8_0_0_1_0_0_0, a1_0, true);
                    						copyLocalizationInfos(a1_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[202]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[203]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[204]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[205]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[206]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[207]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[208]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[209]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[210]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[211]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[212]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[213]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[214]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[215]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[216]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[217]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[218]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[219]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[220]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[221]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[222]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[223]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[224]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[225]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[226]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[227]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[228]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[229]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[230]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[231]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[232]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[233]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[241]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[242]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[243]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_edu_ustb_sei_mde_morel_VariableExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_VariableExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_NestedExp"
    // Morel.g:2433:1: parse_edu_ustb_sei_mde_morel_NestedExp returns [edu.ustb.sei.mde.morel.NestedExp element = null] : a0= '(' (a1_0= parse_edu_ustb_sei_mde_morel_LetExp |a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= ')' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.NestedExp parse_edu_ustb_sei_mde_morel_NestedExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.NestedExp element =  null;

        int parse_edu_ustb_sei_mde_morel_NestedExp_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.LetExp a1_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a1_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a1_2 =null;

        edu.ustb.sei.mde.morel.CallPathExp a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Morel.g:2436:2: (a0= '(' (a1_0= parse_edu_ustb_sei_mde_morel_LetExp |a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= ')' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2437:2: a0= '(' (a1_0= parse_edu_ustb_sei_mde_morel_LetExp |a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= ')' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_NestedExp1898); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createNestedExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[246]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[247]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[248]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[249]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[250]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[251]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[252]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[253]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[254]);
            	}

            // Morel.g:2461:2: (a1_0= parse_edu_ustb_sei_mde_morel_LetExp |a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt18=1;
                }
                break;
            case 43:
                {
                alt18=2;
                }
                break;
            case DATA_TYPE:
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 12:
            case 15:
            case 18:
            case 20:
            case 40:
            case 46:
            case 51:
            case 52:
            case 65:
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
                    // Morel.g:2462:3: a1_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1916);
                    a1_0=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_1, a1_0, true);
                    				copyLocalizationInfos(a1_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:2481:6: a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1930);
                    a1_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_1, a1_1, true);
                    				copyLocalizationInfos(a1_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:2500:6: a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1944);
                    a1_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_1, a1_2, true);
                    				copyLocalizationInfos(a1_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[255]);
            	}

            a2=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_NestedExp1962); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createNestedExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[256]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[257]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[258]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[259]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[260]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[261]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[262]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[263]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[264]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[265]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[266]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[267]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[268]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[269]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[270]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[271]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[272]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[273]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[274]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[275]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[276]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[277]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[278]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[279]);
            	}

            // Morel.g:2562:2: ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0 >= 21 && LA19_0 <= 22)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Morel.g:2563:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2563:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2564:4: (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2564:4: (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2565:5: a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1991);
                    a3_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_9_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[280]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[281]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[282]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[283]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[284]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[285]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[286]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[287]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[288]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[289]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[290]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[291]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[292]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[293]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[294]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[295]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[296]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[297]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[298]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[299]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[300]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[301]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[302]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[303]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[304]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[305]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[306]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[307]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[308]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[309]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[310]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[311]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[312]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[313]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[314]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[315]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[316]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[317]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[318]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[319]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[320]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[321]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_edu_ustb_sei_mde_morel_NestedExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_NestedExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_IntegerLiteralExp"
    // Morel.g:2639:1: parse_edu_ustb_sei_mde_morel_IntegerLiteralExp returns [edu.ustb.sei.mde.morel.IntegerLiteralExp element = null] : (a0= INUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.IntegerLiteralExp parse_edu_ustb_sei_mde_morel_IntegerLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.IntegerLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Morel.g:2642:2: ( (a0= INUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2643:2: (a0= INUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:2643:2: (a0= INUMBER )
            // Morel.g:2644:3: a0= INUMBER
            {
            a0=(Token)match(input,INUMBER,FOLLOW_INUMBER_in_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp2051); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_10_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[322]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[323]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[324]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[325]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[326]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[327]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[328]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[329]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[330]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[331]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[332]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[333]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[334]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[335]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[336]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[337]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[338]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[339]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[340]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[341]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[342]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[343]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[344]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[345]);
            	}

            // Morel.g:2702:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0 >= 21 && LA20_0 <= 22)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Morel.g:2703:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2703:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2704:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2704:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2705:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp2087);
                    a1_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_10_0_0_1_0_0_0, a1_0, true);
                    						copyLocalizationInfos(a1_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[346]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[347]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[348]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[349]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[350]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[351]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[352]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[353]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[354]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[355]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[356]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[357]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[358]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[359]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[360]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[361]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[362]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[363]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[364]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[365]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[366]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[367]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[368]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[369]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[370]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[371]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[372]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[373]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[374]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[375]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[377]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[379]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[380]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[381]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[382]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[383]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[384]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[385]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[386]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[387]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_IntegerLiteralExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_RealLiteralExp"
    // Morel.g:2779:1: parse_edu_ustb_sei_mde_morel_RealLiteralExp returns [edu.ustb.sei.mde.morel.RealLiteralExp element = null] : (a0= RNUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.RealLiteralExp parse_edu_ustb_sei_mde_morel_RealLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.RealLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_RealLiteralExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Morel.g:2782:2: ( (a0= RNUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2783:2: (a0= RNUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:2783:2: (a0= RNUMBER )
            // Morel.g:2784:3: a0= RNUMBER
            {
            a0=(Token)match(input,RNUMBER,FOLLOW_RNUMBER_in_parse_edu_ustb_sei_mde_morel_RealLiteralExp2147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_11_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[388]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[389]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[390]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[391]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[392]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[393]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[394]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[395]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[396]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[397]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[398]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[399]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[400]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[401]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[402]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[403]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[404]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[405]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[406]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[407]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[408]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[409]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[410]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[411]);
            	}

            // Morel.g:2842:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0 >= 21 && LA21_0 <= 22)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Morel.g:2843:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2843:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2844:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2844:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2845:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_RealLiteralExp2183);
                    a1_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_11_0_0_1_0_0_0, a1_0, true);
                    						copyLocalizationInfos(a1_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[428]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[429]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[430]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[431]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[432]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[433]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[434]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[435]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[436]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[437]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[438]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[439]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[440]);
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_edu_ustb_sei_mde_morel_RealLiteralExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_RealLiteralExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_StringLiteralExp"
    // Morel.g:2919:1: parse_edu_ustb_sei_mde_morel_StringLiteralExp returns [edu.ustb.sei.mde.morel.StringLiteralExp element = null] : (a0= QUOTED_39_39_92 ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.StringLiteralExp parse_edu_ustb_sei_mde_morel_StringLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.StringLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_StringLiteralExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Morel.g:2922:2: ( (a0= QUOTED_39_39_92 ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2923:2: (a0= QUOTED_39_39_92 ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:2923:2: (a0= QUOTED_39_39_92 )
            // Morel.g:2924:3: a0= QUOTED_39_39_92
            {
            a0=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_morel_StringLiteralExp2243); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_12_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[454]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[455]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[456]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[457]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[458]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[459]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[460]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[461]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[462]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[463]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[464]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[465]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[466]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[467]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[468]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[469]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[470]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[471]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[472]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[473]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[474]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[475]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[476]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[477]);
            	}

            // Morel.g:2982:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0 >= 21 && LA22_0 <= 22)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Morel.g:2983:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2983:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2984:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2984:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2985:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_StringLiteralExp2279);
                    a1_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_12_0_0_1_0_0_0, a1_0, true);
                    						copyLocalizationInfos(a1_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[494]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[495]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[496]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[497]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[498]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[499]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[500]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[501]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[502]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[503]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[504]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[505]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[506]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[507]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[508]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[509]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[510]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[511]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[512]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[513]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[514]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[515]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[516]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[517]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[518]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[519]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_edu_ustb_sei_mde_morel_StringLiteralExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_StringLiteralExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BooleanLiteralExp"
    // Morel.g:3059:1: parse_edu_ustb_sei_mde_morel_BooleanLiteralExp returns [edu.ustb.sei.mde.morel.BooleanLiteralExp element = null] : ( (a0= 'true' |a1= 'false' ) ) ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.BooleanLiteralExp parse_edu_ustb_sei_mde_morel_BooleanLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.morel.CallPathExp a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Morel.g:3062:2: ( ( (a0= 'true' |a1= 'false' ) ) ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:3063:2: ( (a0= 'true' |a1= 'false' ) ) ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:3063:2: ( (a0= 'true' |a1= 'false' ) )
            // Morel.g:3064:3: (a0= 'true' |a1= 'false' )
            {
            // Morel.g:3064:3: (a0= 'true' |a1= 'false' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==65) ) {
                alt23=1;
            }
            else if ( (LA23_0==40) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // Morel.g:3065:4: a0= 'true'
                    {
                    a0=(Token)match(input,65,FOLLOW_65_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2344); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanLiteralExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_13_0_0_0, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__BOOL_SYMBOL), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Morel.g:3078:8: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2359); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanLiteralExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_13_0_0_0, false, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of boolean attribute
                    				Object value = false;
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_LITERAL_EXP__BOOL_SYMBOL), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[520]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[521]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[522]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[523]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[524]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[525]);
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
            	}

            // Morel.g:3121:2: ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0 >= 21 && LA24_0 <= 22)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Morel.g:3122:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:3122:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:3123:4: (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3123:4: (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3124:5: a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2395);
                    a3_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_13_0_0_1_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[544]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[545]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[546]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[547]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[548]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[549]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[550]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[551]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[552]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[553]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[554]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[555]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[556]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[557]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[558]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[559]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[560]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[561]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[562]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[563]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[564]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[579]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[580]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[581]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[582]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[583]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[584]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[585]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BooleanLiteralExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp"
    // Morel.g:3198:1: parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp returns [edu.ustb.sei.mde.morel.UndefinedLiteralExp element = null] : ( (a0= 'null' |a1= 'invalid' ) ) ( ( (a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.UndefinedLiteralExp parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.UndefinedLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.morel.CallPathExp a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Morel.g:3201:2: ( ( (a0= 'null' |a1= 'invalid' ) ) ( ( (a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:3202:2: ( (a0= 'null' |a1= 'invalid' ) ) ( ( (a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:3202:2: ( (a0= 'null' |a1= 'invalid' ) )
            // Morel.g:3203:3: (a0= 'null' |a1= 'invalid' )
            {
            // Morel.g:3203:3: (a0= 'null' |a1= 'invalid' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==52) ) {
                alt25=1;
            }
            else if ( (LA25_0==46) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // Morel.g:3204:4: a0= 'null'
                    {
                    a0=(Token)match(input,52,FOLLOW_52_in_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp2460); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUndefinedLiteralExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_14_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteral().getEEnumLiteral(edu.ustb.sei.mde.morel.UndefinedLiteral.NULL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__VALUE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Morel.g:3217:8: a1= 'invalid'
                    {
                    a1=(Token)match(input,46,FOLLOW_46_in_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp2475); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUndefinedLiteralExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_14_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteral().getEEnumLiteral(edu.ustb.sei.mde.morel.UndefinedLiteral.INVALID_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNDEFINED_LITERAL_EXP__VALUE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[586]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[587]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[588]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[589]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[590]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[591]);
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
            	}

            // Morel.g:3260:2: ( ( (a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0 >= 21 && LA26_0 <= 22)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // Morel.g:3261:3: ( (a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:3261:3: ( (a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:3262:4: (a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3262:4: (a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3263:5: a4_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp2511);
                    a4_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_14_0_0_1_0_0_0, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[610]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[611]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[612]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[613]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[614]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[615]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[616]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[617]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[618]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[619]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[620]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[621]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[622]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[623]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[624]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[625]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[626]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[627]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[628]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[629]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[630]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[648]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[649]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[650]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[651]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_TypeLiteralExp"
    // Morel.g:3337:1: parse_edu_ustb_sei_mde_morel_TypeLiteralExp returns [edu.ustb.sei.mde.morel.TypeLiteralExp element = null] : (a0= DATA_TYPE ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.TypeLiteralExp parse_edu_ustb_sei_mde_morel_TypeLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.TypeLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_TypeLiteralExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Morel.g:3340:2: ( (a0= DATA_TYPE ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:3341:2: (a0= DATA_TYPE ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:3341:2: (a0= DATA_TYPE )
            // Morel.g:3342:3: a0= DATA_TYPE
            {
            a0=(Token)match(input,DATA_TYPE,FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_TypeLiteralExp2571); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[652]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[653]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[654]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[655]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[656]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[657]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[658]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[659]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[660]);
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
            	}

            // Morel.g:3404:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0 >= 21 && LA27_0 <= 22)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // Morel.g:3405:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:3405:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:3406:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3406:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3407:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_TypeLiteralExp2607);
                    a1_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_1_0_0_0, a1_0, true);
                    						copyLocalizationInfos(a1_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[676]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[677]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[678]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[679]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[680]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[681]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[682]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[683]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[684]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[685]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[686]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[687]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[688]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[689]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[690]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[691]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[692]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[693]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[694]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[695]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[696]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[714]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[715]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[716]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[717]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_edu_ustb_sei_mde_morel_TypeLiteralExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_TypeLiteralExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_FeaturePathExp"
    // Morel.g:3481:1: parse_edu_ustb_sei_mde_morel_FeaturePathExp returns [edu.ustb.sei.mde.morel.FeaturePathExp element = null] : a0= '.' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )? ;
    public final edu.ustb.sei.mde.morel.FeaturePathExp parse_edu_ustb_sei_mde_morel_FeaturePathExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.FeaturePathExp element =  null;

        int parse_edu_ustb_sei_mde_morel_FeaturePathExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.morel.CallPathExp a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Morel.g:3484:2: (a0= '.' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )? )
            // Morel.g:3485:2: a0= '.' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )?
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2663); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createFeaturePathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[718]);
            	}

            // Morel.g:3499:2: (a1= IDENTIFIER )
            // Morel.g:3500:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2681); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[719]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[720]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[721]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[722]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[723]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[724]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[725]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[726]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[727]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[728]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[729]);
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
            	}

            // Morel.g:3558:2: ( (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0 >= 21 && LA28_0 <= 22)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // Morel.g:3559:3: (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3559:3: (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3560:4: a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2711);
                    a2_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_2, a2_0, true);
                    					copyLocalizationInfos(a2_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[743]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[744]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[745]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[746]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[747]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[748]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[749]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[750]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[751]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[752]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[753]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[754]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[755]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[756]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[757]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[758]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[759]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[760]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[761]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[762]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[763]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_edu_ustb_sei_mde_morel_FeaturePathExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_FeaturePathExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_OperationPathExp"
    // Morel.g:3608:1: parse_edu_ustb_sei_mde_morel_OperationPathExp returns [edu.ustb.sei.mde.morel.OperationPathExp element = null] : ( (a0= '.' |a1= '->' ) ) (a4= IDENTIFIER ) a5= '(' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* ) )? a9= ')' ( (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )? ;
    public final edu.ustb.sei.mde.morel.OperationPathExp parse_edu_ustb_sei_mde_morel_OperationPathExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.OperationPathExp element =  null;

        int parse_edu_ustb_sei_mde_morel_OperationPathExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a9=null;
        edu.ustb.sei.mde.morel.LetExp a6_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a6_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a6_2 =null;

        edu.ustb.sei.mde.morel.LetExp a8_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a8_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a8_2 =null;

        edu.ustb.sei.mde.morel.CallPathExp a10_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Morel.g:3611:2: ( ( (a0= '.' |a1= '->' ) ) (a4= IDENTIFIER ) a5= '(' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* ) )? a9= ')' ( (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )? )
            // Morel.g:3612:2: ( (a0= '.' |a1= '->' ) ) (a4= IDENTIFIER ) a5= '(' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* ) )? a9= ')' ( (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )?
            {
            // Morel.g:3612:2: ( (a0= '.' |a1= '->' ) )
            // Morel.g:3613:3: (a0= '.' |a1= '->' )
            {
            // Morel.g:3613:3: (a0= '.' |a1= '->' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==22) ) {
                alt29=1;
            }
            else if ( (LA29_0==21) ) {
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
                    // Morel.g:3614:4: a0= '.'
                    {
                    a0=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2761); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationSeparator().getEEnumLiteral(edu.ustb.sei.mde.morel.OperationSeparator.DOT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__SEPARATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Morel.g:3627:8: a1= '->'
                    {
                    a1=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2776); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationSeparator().getEEnumLiteral(edu.ustb.sei.mde.morel.OperationSeparator.ARROW_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__SEPARATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[764]);
            	}

            // Morel.g:3647:2: (a4= IDENTIFIER )
            // Morel.g:3648:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2801); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
            				startIncompleteElement(element);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[765]);
            	}

            a5=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2822); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[766]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[767]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[768]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[769]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[770]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[771]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[772]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[773]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[774]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[775]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[776]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[777]);
            	}

            // Morel.g:3708:2: ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0 >= DATA_TYPE && LA33_0 <= INUMBER)||(LA33_0 >= QUOTED_39_39_92 && LA33_0 <= RNUMBER)||LA33_0==12||LA33_0==15||LA33_0==18||LA33_0==20||LA33_0==40||LA33_0==43||(LA33_0 >= 46 && LA33_0 <= 47)||(LA33_0 >= 51 && LA33_0 <= 52)||LA33_0==65) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // Morel.g:3709:3: ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* )
                    {
                    // Morel.g:3709:3: ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* )
                    // Morel.g:3710:4: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )*
                    {
                    // Morel.g:3710:4: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    int alt30=3;
                    switch ( input.LA(1) ) {
                    case 47:
                        {
                        alt30=1;
                        }
                        break;
                    case 43:
                        {
                        alt30=2;
                        }
                        break;
                    case DATA_TYPE:
                    case IDENTIFIER:
                    case INUMBER:
                    case QUOTED_39_39_92:
                    case RNUMBER:
                    case 12:
                    case 15:
                    case 18:
                    case 20:
                    case 40:
                    case 46:
                    case 51:
                    case 52:
                    case 65:
                        {
                        alt30=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;

                    }

                    switch (alt30) {
                        case 1 :
                            // Morel.g:3711:5: a6_0= parse_edu_ustb_sei_mde_morel_LetExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2851);
                            a6_0=parse_edu_ustb_sei_mde_morel_LetExp();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (terminateParsing) {
                            						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
                            					}
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                            						startIncompleteElement(element);
                            					}
                            					if (a6_0 != null) {
                            						if (a6_0 != null) {
                            							Object value = a6_0;
                            							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
                            							completedElement(value, true);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_3_0_0_0, a6_0, true);
                            						copyLocalizationInfos(a6_0, element);
                            					}
                            				}

                            }
                            break;
                        case 2 :
                            // Morel.g:3730:10: a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2871);
                            a6_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (terminateParsing) {
                            						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
                            					}
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                            						startIncompleteElement(element);
                            					}
                            					if (a6_1 != null) {
                            						if (a6_1 != null) {
                            							Object value = a6_1;
                            							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
                            							completedElement(value, true);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_3_0_0_0, a6_1, true);
                            						copyLocalizationInfos(a6_1, element);
                            					}
                            				}

                            }
                            break;
                        case 3 :
                            // Morel.g:3749:10: a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2891);
                            a6_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (terminateParsing) {
                            						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
                            					}
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                            						startIncompleteElement(element);
                            					}
                            					if (a6_2 != null) {
                            						if (a6_2 != null) {
                            							Object value = a6_2;
                            							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
                            							completedElement(value, true);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_3_0_0_0, a6_2, true);
                            						copyLocalizationInfos(a6_2, element);
                            					}
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[778]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[779]);
                    			}

                    // Morel.g:3775:4: ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==19) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // Morel.g:3776:5: (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
                    	    {
                    	    // Morel.g:3776:5: (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
                    	    // Morel.g:3777:6: a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    	    {
                    	    a7=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2932); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[780]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[781]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[782]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[783]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[784]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[785]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[786]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[787]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[788]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[789]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[790]);
                    	    					}

                    	    // Morel.g:3801:6: (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    	    int alt31=3;
                    	    switch ( input.LA(1) ) {
                    	    case 47:
                    	        {
                    	        alt31=1;
                    	        }
                    	        break;
                    	    case 43:
                    	        {
                    	        alt31=2;
                    	        }
                    	        break;
                    	    case DATA_TYPE:
                    	    case IDENTIFIER:
                    	    case INUMBER:
                    	    case QUOTED_39_39_92:
                    	    case RNUMBER:
                    	    case 12:
                    	    case 15:
                    	    case 18:
                    	    case 20:
                    	    case 40:
                    	    case 46:
                    	    case 51:
                    	    case 52:
                    	    case 65:
                    	        {
                    	        alt31=3;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return element;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 31, 0, input);

                    	        throw nvae;

                    	    }

                    	    switch (alt31) {
                    	        case 1 :
                    	            // Morel.g:3802:7: a8_0= parse_edu_ustb_sei_mde_morel_LetExp
                    	            {
                    	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2966);
                    	            a8_0=parse_edu_ustb_sei_mde_morel_LetExp();

                    	            state._fsp--;
                    	            if (state.failed) return element;

                    	            if ( state.backtracking==0 ) {
                    	            							if (terminateParsing) {
                    	            								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
                    	            							}
                    	            							if (element == null) {
                    	            								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    	            								startIncompleteElement(element);
                    	            							}
                    	            							if (a8_0 != null) {
                    	            								if (a8_0 != null) {
                    	            									Object value = a8_0;
                    	            									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
                    	            									completedElement(value, true);
                    	            								}
                    	            								collectHiddenTokens(element);
                    	            								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_3_0_0_1_0_0_1, a8_0, true);
                    	            								copyLocalizationInfos(a8_0, element);
                    	            							}
                    	            						}

                    	            }
                    	            break;
                    	        case 2 :
                    	            // Morel.g:3821:14: a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    	            {
                    	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2992);
                    	            a8_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    	            state._fsp--;
                    	            if (state.failed) return element;

                    	            if ( state.backtracking==0 ) {
                    	            							if (terminateParsing) {
                    	            								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
                    	            							}
                    	            							if (element == null) {
                    	            								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    	            								startIncompleteElement(element);
                    	            							}
                    	            							if (a8_1 != null) {
                    	            								if (a8_1 != null) {
                    	            									Object value = a8_1;
                    	            									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
                    	            									completedElement(value, true);
                    	            								}
                    	            								collectHiddenTokens(element);
                    	            								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_3_0_0_1_0_0_1, a8_1, true);
                    	            								copyLocalizationInfos(a8_1, element);
                    	            							}
                    	            						}

                    	            }
                    	            break;
                    	        case 3 :
                    	            // Morel.g:3840:14: a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    	            {
                    	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp3018);
                    	            a8_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    	            state._fsp--;
                    	            if (state.failed) return element;

                    	            if ( state.backtracking==0 ) {
                    	            							if (terminateParsing) {
                    	            								throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
                    	            							}
                    	            							if (element == null) {
                    	            								element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    	            								startIncompleteElement(element);
                    	            							}
                    	            							if (a8_2 != null) {
                    	            								if (a8_2 != null) {
                    	            									Object value = a8_2;
                    	            									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__PARAMETERS, value);
                    	            									completedElement(value, true);
                    	            								}
                    	            								collectHiddenTokens(element);
                    	            								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_3_0_0_1_0_0_1, a8_2, true);
                    	            								copyLocalizationInfos(a8_2, element);
                    	            							}
                    	            						}

                    	            }
                    	            break;

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[791]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[792]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[793]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[794]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[795]);
            	}

            a9=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_OperationPathExp3092); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[796]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[797]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[798]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[816]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[817]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[818]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[819]);
            	}

            // Morel.g:3918:2: ( (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0 >= 21 && LA34_0 <= 22)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // Morel.g:3919:3: (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3919:3: (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3920:4: a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp3115);
                    a10_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    					startIncompleteElement(element);
                    				}
                    				if (a10_0 != null) {
                    					if (a10_0 != null) {
                    						Object value = a10_0;
                    						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__NEXT), value);
                    						completedElement(value, true);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_5, a10_0, true);
                    					copyLocalizationInfos(a10_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[820]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[821]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[822]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[823]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[824]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[825]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[826]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[827]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[828]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[829]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[830]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[831]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[832]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[833]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[834]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[835]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[836]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[837]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[838]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[839]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[840]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_edu_ustb_sei_mde_morel_OperationPathExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_OperationPathExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_IteratorPathExp"
    // Morel.g:3968:1: parse_edu_ustb_sei_mde_morel_IteratorPathExp returns [edu.ustb.sei.mde.morel.IteratorPathExp element = null] : a0= '->' ( (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' ) ) a9= '(' (a10_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )? a13= '|' (a14_0= parse_edu_ustb_sei_mde_morel_LetExp |a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a15= ')' ( ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.IteratorPathExp parse_edu_ustb_sei_mde_morel_IteratorPathExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.IteratorPathExp element =  null;

        int parse_edu_ustb_sei_mde_morel_IteratorPathExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a9=null;
        Token a11=null;
        Token a13=null;
        Token a15=null;
        edu.ustb.sei.mde.morel.Variable a10_0 =null;

        edu.ustb.sei.mde.morel.Variable a12_0 =null;

        edu.ustb.sei.mde.morel.LetExp a14_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a14_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a14_2 =null;

        edu.ustb.sei.mde.morel.CallPathExp a16_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Morel.g:3971:2: (a0= '->' ( (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' ) ) a9= '(' (a10_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )? a13= '|' (a14_0= parse_edu_ustb_sei_mde_morel_LetExp |a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a15= ')' ( ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:3972:2: a0= '->' ( (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' ) ) a9= '(' (a10_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )? a13= '|' (a14_0= parse_edu_ustb_sei_mde_morel_LetExp |a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a15= ')' ( ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3156); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[841]);
            	}

            // Morel.g:3986:2: ( (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' ) )
            // Morel.g:3987:3: (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' )
            {
            // Morel.g:3987:3: (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' )
            int alt35=6;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt35=1;
                }
                break;
            case 39:
                {
                alt35=2;
                }
                break;
            case 62:
                {
                alt35=3;
                }
                break;
            case 59:
                {
                alt35=4;
                }
                break;
            case 36:
                {
                alt35=5;
                }
                break;
            case 35:
                {
                alt35=6;
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
                    // Morel.g:3988:4: a1= 'forAll'
                    {
                    a1=(Token)match(input,42,FOLLOW_42_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3179); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.FOR_ALL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Morel.g:4001:8: a2= 'exists'
                    {
                    a2=(Token)match(input,39,FOLLOW_39_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3194); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.EXISTS_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Morel.g:4014:8: a3= 'select'
                    {
                    a3=(Token)match(input,62,FOLLOW_62_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3209); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.SELECT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Morel.g:4027:8: a4= 'reject'
                    {
                    a4=(Token)match(input,59,FOLLOW_59_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3224); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.REJECT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Morel.g:4040:8: a5= 'collect'
                    {
                    a5=(Token)match(input,36,FOLLOW_36_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3239); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.COLLECT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 6 :
                    // Morel.g:4053:8: a6= 'closure'
                    {
                    a6=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3254); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.CLOSURE_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[842]);
            	}

            a9=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3275); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[843]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[844]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[845]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[846]);
            	}

            // Morel.g:4090:2: (a10_0= parse_edu_ustb_sei_mde_morel_Variable )
            // Morel.g:4091:3: a10_0= parse_edu_ustb_sei_mde_morel_Variable
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3293);
            a10_0=parse_edu_ustb_sei_mde_morel_Variable();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_3, a10_0, true);
            				copyLocalizationInfos(a10_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[847]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[848]);
            	}

            // Morel.g:4117:2: ( (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==19) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // Morel.g:4118:3: (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                    {
                    // Morel.g:4118:3: (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                    // Morel.g:4119:4: a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable )
                    {
                    a11=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3320); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_4_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[849]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[850]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[851]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[852]);
                    			}

                    // Morel.g:4136:4: (a12_0= parse_edu_ustb_sei_mde_morel_Variable )
                    // Morel.g:4137:5: a12_0= parse_edu_ustb_sei_mde_morel_Variable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3346);
                    a12_0=parse_edu_ustb_sei_mde_morel_Variable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_4_0_0_1, a12_0, true);
                    						copyLocalizationInfos(a12_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[853]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[854]);
            	}

            a13=(Token)match(input,69,FOLLOW_69_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3387); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[855]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[856]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[857]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[858]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[859]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[860]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[861]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[862]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[863]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[864]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[865]);
            	}

            // Morel.g:4193:2: (a14_0= parse_edu_ustb_sei_mde_morel_LetExp |a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt37=1;
                }
                break;
            case 43:
                {
                alt37=2;
                }
                break;
            case DATA_TYPE:
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 12:
            case 15:
            case 18:
            case 20:
            case 40:
            case 46:
            case 51:
            case 52:
            case 65:
                {
                alt37=3;
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
                    // Morel.g:4194:3: a14_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3405);
                    a14_0=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_6, a14_0, true);
                    				copyLocalizationInfos(a14_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:4213:6: a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3419);
                    a14_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_6, a14_1, true);
                    				copyLocalizationInfos(a14_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:4232:6: a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3433);
                    a14_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_6, a14_2, true);
                    				copyLocalizationInfos(a14_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[866]);
            	}

            a15=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3451); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[867]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[868]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[869]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[885]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[886]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[887]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[888]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[889]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[890]);
            	}

            // Morel.g:4294:2: ( ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0 >= 21 && LA38_0 <= 22)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // Morel.g:4295:3: ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:4295:3: ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:4296:4: (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:4296:4: (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:4297:5: a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3480);
                    a16_0=parse_edu_ustb_sei_mde_morel_CallPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_8_0_0_0, a16_0, true);
                    						copyLocalizationInfos(a16_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[891]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[892]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[893]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[894]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[895]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[896]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[897]);
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
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[912]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[913]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[914]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[915]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[916]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[917]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[918]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[919]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[920]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[921]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[922]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[923]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[924]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[925]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[926]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[927]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[928]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[929]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[930]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[931]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[932]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_edu_ustb_sei_mde_morel_IteratorPathExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_IteratorPathExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_LetExp"
    // Morel.g:4371:1: parse_edu_ustb_sei_mde_morel_LetExp returns [edu.ustb.sei.mde.morel.LetExp element = null] : a0= 'let' (a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ( (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ) )* a4= 'in' (a5_0= parse_edu_ustb_sei_mde_morel_LetExp |a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ;
    public final edu.ustb.sei.mde.morel.LetExp parse_edu_ustb_sei_mde_morel_LetExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.LetExp element =  null;

        int parse_edu_ustb_sei_mde_morel_LetExp_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        edu.ustb.sei.mde.morel.VariableWithInit a1_0 =null;

        edu.ustb.sei.mde.morel.VariableWithInit a3_0 =null;

        edu.ustb.sei.mde.morel.LetExp a5_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a5_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a5_2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Morel.g:4374:2: (a0= 'let' (a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ( (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ) )* a4= 'in' (a5_0= parse_edu_ustb_sei_mde_morel_LetExp |a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
            // Morel.g:4375:2: a0= 'let' (a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ( (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ) )* a4= 'in' (a5_0= parse_edu_ustb_sei_mde_morel_LetExp |a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            {
            a0=(Token)match(input,47,FOLLOW_47_in_parse_edu_ustb_sei_mde_morel_LetExp3536); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[933]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[934]);
            	}

            // Morel.g:4390:2: (a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit )
            // Morel.g:4391:3: a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_LetExp3554);
            a1_0=parse_edu_ustb_sei_mde_morel_VariableWithInit();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[935]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[936]);
            	}

            // Morel.g:4417:2: ( (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==19) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // Morel.g:4418:3: (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) )
            	    {
            	    // Morel.g:4418:3: (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) )
            	    // Morel.g:4419:4: a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit )
            	    {
            	    a2=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_LetExp3581); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_2_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[937]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[938]);
            	    			}

            	    // Morel.g:4434:4: (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit )
            	    // Morel.g:4435:5: a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_LetExp3607);
            	    a3_0=parse_edu_ustb_sei_mde_morel_VariableWithInit();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_2_0_0_1, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[939]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[940]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[941]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[942]);
            	}

            a4=(Token)match(input,45,FOLLOW_45_in_parse_edu_ustb_sei_mde_morel_LetExp3648); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[943]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[944]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[945]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[946]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[947]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[948]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[949]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[950]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[951]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[952]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[953]);
            	}

            // Morel.g:4493:2: (a5_0= parse_edu_ustb_sei_mde_morel_LetExp |a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt40=1;
                }
                break;
            case 43:
                {
                alt40=2;
                }
                break;
            case DATA_TYPE:
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 12:
            case 15:
            case 18:
            case 20:
            case 40:
            case 46:
            case 51:
            case 52:
            case 65:
                {
                alt40=3;
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
                    // Morel.g:4494:3: a5_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_LetExp3666);
                    a5_0=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_4, a5_0, true);
                    				copyLocalizationInfos(a5_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:4513:6: a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_LetExp3680);
                    a5_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_4, a5_1, true);
                    				copyLocalizationInfos(a5_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:4532:6: a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_LetExp3694);
                    a5_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_4, a5_2, true);
                    				copyLocalizationInfos(a5_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[954]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[955]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[956]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[957]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[958]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[959]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[960]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[961]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[962]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[963]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[964]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[965]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[966]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[967]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_edu_ustb_sei_mde_morel_LetExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_LetExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_ConditionExp"
    // Morel.g:4572:1: parse_edu_ustb_sei_mde_morel_ConditionExp returns [edu.ustb.sei.mde.morel.ConditionExp element = null] : a0= 'if' (a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= 'then' (a3_0= parse_edu_ustb_sei_mde_morel_Expression ) a4= 'else' (a5_0= parse_edu_ustb_sei_mde_morel_Expression ) a6= 'endif' ;
    public final edu.ustb.sei.mde.morel.ConditionExp parse_edu_ustb_sei_mde_morel_ConditionExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.ConditionExp element =  null;

        int parse_edu_ustb_sei_mde_morel_ConditionExp_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        edu.ustb.sei.mde.morel.BooleanImpliesExp a1_0 =null;

        edu.ustb.sei.mde.morel.Expression a3_0 =null;

        edu.ustb.sei.mde.morel.Expression a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Morel.g:4575:2: (a0= 'if' (a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= 'then' (a3_0= parse_edu_ustb_sei_mde_morel_Expression ) a4= 'else' (a5_0= parse_edu_ustb_sei_mde_morel_Expression ) a6= 'endif' )
            // Morel.g:4576:2: a0= 'if' (a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= 'then' (a3_0= parse_edu_ustb_sei_mde_morel_Expression ) a4= 'else' (a5_0= parse_edu_ustb_sei_mde_morel_Expression ) a6= 'endif'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_edu_ustb_sei_mde_morel_ConditionExp3727); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[968]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[969]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[970]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[971]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[972]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[973]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[974]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[975]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[976]);
            	}

            // Morel.g:4598:2: (a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            // Morel.g:4599:3: a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ConditionExp3745);
            a1_0=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[977]);
            	}

            a2=(Token)match(input,63,FOLLOW_63_in_parse_edu_ustb_sei_mde_morel_ConditionExp3763); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[978]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[979]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[980]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[981]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[982]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[983]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[984]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[985]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[986]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[987]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[988]);
            	}

            // Morel.g:4648:2: (a3_0= parse_edu_ustb_sei_mde_morel_Expression )
            // Morel.g:4649:3: a3_0= parse_edu_ustb_sei_mde_morel_Expression
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Expression_in_parse_edu_ustb_sei_mde_morel_ConditionExp3781);
            a3_0=parse_edu_ustb_sei_mde_morel_Expression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_3, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[989]);
            	}

            a4=(Token)match(input,37,FOLLOW_37_in_parse_edu_ustb_sei_mde_morel_ConditionExp3799); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[990]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[991]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[992]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[993]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[994]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[995]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[996]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[997]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[998]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[999]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1000]);
            	}

            // Morel.g:4698:2: (a5_0= parse_edu_ustb_sei_mde_morel_Expression )
            // Morel.g:4699:3: a5_0= parse_edu_ustb_sei_mde_morel_Expression
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Expression_in_parse_edu_ustb_sei_mde_morel_ConditionExp3817);
            a5_0=parse_edu_ustb_sei_mde_morel_Expression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_5, a5_0, true);
            				copyLocalizationInfos(a5_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1001]);
            	}

            a6=(Token)match(input,38,FOLLOW_38_in_parse_edu_ustb_sei_mde_morel_ConditionExp3835); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_edu_ustb_sei_mde_morel_ConditionExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_ConditionExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BooleanImpliesExp"
    // Morel.g:4753:1: parse_edu_ustb_sei_mde_morel_BooleanImpliesExp returns [edu.ustb.sei.mde.morel.BooleanImpliesExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ( ( ( (a1= 'implies' |a2= '=>' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.BooleanImpliesExp parse_edu_ustb_sei_mde_morel_BooleanImpliesExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanImpliesExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.BooleanOrExp a0_0 =null;

        edu.ustb.sei.mde.morel.BooleanOrExp a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Morel.g:4756:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ( ( ( (a1= 'implies' |a2= '=>' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ) )? )
            // Morel.g:4757:2: (a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ( ( ( (a1= 'implies' |a2= '=>' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ) )?
            {
            // Morel.g:4757:2: (a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp )
            // Morel.g:4758:3: a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3868);
            a0_0=parse_edu_ustb_sei_mde_morel_BooleanOrExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1016]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1017]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1018]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1019]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1020]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1021]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1022]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1023]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1024]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1025]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1026]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1027]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1028]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1029]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1030]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1031]);
            	}

            // Morel.g:4798:2: ( ( ( (a1= 'implies' |a2= '=>' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==31||LA42_0==44) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // Morel.g:4799:3: ( ( (a1= 'implies' |a2= '=>' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) )
                    {
                    // Morel.g:4799:3: ( ( (a1= 'implies' |a2= '=>' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) )
                    // Morel.g:4800:4: ( (a1= 'implies' |a2= '=>' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp )
                    {
                    // Morel.g:4800:4: ( (a1= 'implies' |a2= '=>' ) )
                    // Morel.g:4801:5: (a1= 'implies' |a2= '=>' )
                    {
                    // Morel.g:4801:5: (a1= 'implies' |a2= '=>' )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==44) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==31) ) {
                        alt41=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 0, input);

                        throw nvae;

                    }
                    switch (alt41) {
                        case 1 :
                            // Morel.g:4802:6: a1= 'implies'
                            {
                            a1=(Token)match(input,44,FOLLOW_44_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3908); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanImpliesExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.IMPLIES_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 2 :
                            // Morel.g:4815:12: a2= '=>'
                            {
                            a2=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3927); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanImpliesExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.IMPLIES_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1032]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1033]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1034]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1035]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1036]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1037]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1038]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1039]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1040]);
                    			}

                    // Morel.g:4843:4: (a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp )
                    // Morel.g:4844:5: a5_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3964);
                    a5_0=parse_edu_ustb_sei_mde_morel_BooleanOrExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_1_0_0_1, a5_0, true);
                    						copyLocalizationInfos(a5_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
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

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1056]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1057]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1058]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1059]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1060]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1061]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1062]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1063]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1064]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1065]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1066]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1067]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1068]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1069]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1070]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BooleanImpliesExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BooleanOrExp"
    // Morel.g:4906:1: parse_edu_ustb_sei_mde_morel_BooleanOrExp returns [edu.ustb.sei.mde.morel.BooleanOrExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ( ( ( (a1= 'or' |a2= '||' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.BooleanOrExp parse_edu_ustb_sei_mde_morel_BooleanOrExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanOrExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BooleanOrExp_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.BooleanAndExp a0_0 =null;

        edu.ustb.sei.mde.morel.BooleanAndExp a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Morel.g:4909:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ( ( ( (a1= 'or' |a2= '||' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ) )? )
            // Morel.g:4910:2: (a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ( ( ( (a1= 'or' |a2= '||' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ) )?
            {
            // Morel.g:4910:2: (a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp )
            // Morel.g:4911:3: a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp4024);
            a0_0=parse_edu_ustb_sei_mde_morel_BooleanAndExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            	}

            // Morel.g:4952:2: ( ( ( (a1= 'or' |a2= '||' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==53||LA44_0==70) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // Morel.g:4953:3: ( ( (a1= 'or' |a2= '||' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) )
                    {
                    // Morel.g:4953:3: ( ( (a1= 'or' |a2= '||' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) )
                    // Morel.g:4954:4: ( (a1= 'or' |a2= '||' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp )
                    {
                    // Morel.g:4954:4: ( (a1= 'or' |a2= '||' ) )
                    // Morel.g:4955:5: (a1= 'or' |a2= '||' )
                    {
                    // Morel.g:4955:5: (a1= 'or' |a2= '||' )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==53) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==70) ) {
                        alt43=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;

                    }
                    switch (alt43) {
                        case 1 :
                            // Morel.g:4956:6: a1= 'or'
                            {
                            a1=(Token)match(input,53,FOLLOW_53_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp4064); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanOrExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.OR_VALUE).getInstance();
                            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__OPERATORS, value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 2 :
                            // Morel.g:4969:12: a2= '||'
                            {
                            a2=(Token)match(input,70,FOLLOW_70_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp4083); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanOrExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.OR_VALUE).getInstance();
                            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__OPERATORS, value);
                            						completedElement(value, false);
                            					}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1088]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1089]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1090]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1091]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1092]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1093]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1094]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1095]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1096]);
                    			}

                    // Morel.g:4997:4: (a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp )
                    // Morel.g:4998:5: a5_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp4120);
                    a5_0=parse_edu_ustb_sei_mde_morel_BooleanAndExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_1, a5_0, true);
                    						copyLocalizationInfos(a5_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1097]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1098]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1099]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1100]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1101]);
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
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1113]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1114]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1115]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1116]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1117]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1118]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1119]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1120]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1121]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1122]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1123]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1124]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1125]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1126]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1127]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1128]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_edu_ustb_sei_mde_morel_BooleanOrExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BooleanOrExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BooleanAndExp"
    // Morel.g:5062:1: parse_edu_ustb_sei_mde_morel_BooleanAndExp returns [edu.ustb.sei.mde.morel.BooleanAndExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ( ( ( (a1= 'and' |a2= '&&' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.BooleanAndExp parse_edu_ustb_sei_mde_morel_BooleanAndExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanAndExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BooleanAndExp_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.RelationalExp a0_0 =null;

        edu.ustb.sei.mde.morel.RelationalExp a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Morel.g:5065:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ( ( ( (a1= 'and' |a2= '&&' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ) )? )
            // Morel.g:5066:2: (a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ( ( ( (a1= 'and' |a2= '&&' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ) )?
            {
            // Morel.g:5066:2: (a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp )
            // Morel.g:5067:3: a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp4180);
            a0_0=parse_edu_ustb_sei_mde_morel_RelationalExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1129]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1130]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1131]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1132]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1133]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1134]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1135]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1136]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1137]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1138]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1139]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1140]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1141]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1142]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1143]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1144]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1145]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1146]);
            	}

            // Morel.g:5109:2: ( ( ( (a1= 'and' |a2= '&&' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==14||LA46_0==34) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // Morel.g:5110:3: ( ( (a1= 'and' |a2= '&&' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) )
                    {
                    // Morel.g:5110:3: ( ( (a1= 'and' |a2= '&&' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) )
                    // Morel.g:5111:4: ( (a1= 'and' |a2= '&&' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp )
                    {
                    // Morel.g:5111:4: ( (a1= 'and' |a2= '&&' ) )
                    // Morel.g:5112:5: (a1= 'and' |a2= '&&' )
                    {
                    // Morel.g:5112:5: (a1= 'and' |a2= '&&' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==34) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==14) ) {
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
                            // Morel.g:5113:6: a1= 'and'
                            {
                            a1=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp4220); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanAndExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.AND_VALUE).getInstance();
                            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__OPERATORS, value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 2 :
                            // Morel.g:5126:12: a2= '&&'
                            {
                            a2=(Token)match(input,14,FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp4239); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanAndExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.AND_VALUE).getInstance();
                            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__OPERATORS, value);
                            						completedElement(value, false);
                            					}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1147]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1148]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1149]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1150]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1151]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1152]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1153]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1154]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1155]);
                    			}

                    // Morel.g:5154:4: (a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp )
                    // Morel.g:5155:5: a5_0= parse_edu_ustb_sei_mde_morel_RelationalExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp4276);
                    a5_0=parse_edu_ustb_sei_mde_morel_RelationalExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1_0_0_1, a5_0, true);
                    						copyLocalizationInfos(a5_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1156]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1157]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1158]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1159]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1160]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1161]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1162]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1163]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1164]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1165]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1166]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1167]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1168]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1169]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1170]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1171]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1172]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_edu_ustb_sei_mde_morel_BooleanAndExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BooleanAndExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_RelationalExp"
    // Morel.g:5221:1: parse_edu_ustb_sei_mde_morel_RelationalExp returns [edu.ustb.sei.mde.morel.RelationalExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ( ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.RelationalExp parse_edu_ustb_sei_mde_morel_RelationalExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.RelationalExp element =  null;

        int parse_edu_ustb_sei_mde_morel_RelationalExp_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        edu.ustb.sei.mde.morel.AdditiveExp a0_0 =null;

        edu.ustb.sei.mde.morel.AdditiveExp a10_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Morel.g:5224:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ( ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ) )? )
            // Morel.g:5225:2: (a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ( ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ) )?
            {
            // Morel.g:5225:2: (a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp )
            // Morel.g:5226:3: a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_RelationalExp4336);
            a0_0=parse_edu_ustb_sei_mde_morel_AdditiveExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1190]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1191]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1192]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1193]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1194]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1195]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1196]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1197]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1198]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1199]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1200]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1201]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1202]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1203]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1204]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1205]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1206]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1207]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1208]);
            	}

            // Morel.g:5269:2: ( ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==13||LA48_0==26||(LA48_0 >= 28 && LA48_0 <= 30)||(LA48_0 >= 32 && LA48_0 <= 33)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // Morel.g:5270:3: ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) )
                    {
                    // Morel.g:5270:3: ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) )
                    // Morel.g:5271:4: ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp )
                    {
                    // Morel.g:5271:4: ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) )
                    // Morel.g:5272:5: (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' )
                    {
                    // Morel.g:5272:5: (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' )
                    int alt47=7;
                    switch ( input.LA(1) ) {
                    case 30:
                        {
                        alt47=1;
                        }
                        break;
                    case 29:
                        {
                        alt47=2;
                        }
                        break;
                    case 13:
                        {
                        alt47=3;
                        }
                        break;
                    case 26:
                        {
                        alt47=4;
                        }
                        break;
                    case 28:
                        {
                        alt47=5;
                        }
                        break;
                    case 32:
                        {
                        alt47=6;
                        }
                        break;
                    case 33:
                        {
                        alt47=7;
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
                            // Morel.g:5273:6: a1= '='
                            {
                            a1=(Token)match(input,30,FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_RelationalExp4376); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.EQUAL_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 2 :
                            // Morel.g:5286:12: a2= '<>'
                            {
                            a2=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_RelationalExp4395); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.NOT_EQUAL_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 3 :
                            // Morel.g:5299:12: a3= '!='
                            {
                            a3=(Token)match(input,13,FOLLOW_13_in_parse_edu_ustb_sei_mde_morel_RelationalExp4414); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.NOT_EQUAL_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 4 :
                            // Morel.g:5312:12: a4= '<'
                            {
                            a4=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_morel_RelationalExp4433); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.LESS_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 5 :
                            // Morel.g:5325:12: a5= '<='
                            {
                            a5=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_morel_RelationalExp4452); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.LESS_OR_EQ_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 6 :
                            // Morel.g:5338:12: a6= '>'
                            {
                            a6=(Token)match(input,32,FOLLOW_32_in_parse_edu_ustb_sei_mde_morel_RelationalExp4471); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.GREATER_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 7 :
                            // Morel.g:5351:12: a7= '>='
                            {
                            a7=(Token)match(input,33,FOLLOW_33_in_parse_edu_ustb_sei_mde_morel_RelationalExp4490); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.GREATER_OR_EQ_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1209]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1210]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1211]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1212]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1213]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1214]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1215]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1216]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1217]);
                    			}

                    // Morel.g:5379:4: (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp )
                    // Morel.g:5380:5: a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_RelationalExp4527);
                    a10_0=parse_edu_ustb_sei_mde_morel_AdditiveExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_1, a10_0, true);
                    						copyLocalizationInfos(a10_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1218]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1219]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1220]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1221]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1222]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1223]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1224]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1225]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1226]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1227]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1228]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1229]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1230]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1231]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1232]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1233]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1234]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1235]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1236]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1237]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1238]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1239]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1240]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1241]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1242]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1243]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1244]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1245]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1246]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1247]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1248]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1249]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1250]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1251]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1252]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1253]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_edu_ustb_sei_mde_morel_RelationalExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_RelationalExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_AdditiveExp"
    // Morel.g:5448:1: parse_edu_ustb_sei_mde_morel_AdditiveExp returns [edu.ustb.sei.mde.morel.AdditiveExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ) )* ;
    public final edu.ustb.sei.mde.morel.AdditiveExp parse_edu_ustb_sei_mde_morel_AdditiveExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.AdditiveExp element =  null;

        int parse_edu_ustb_sei_mde_morel_AdditiveExp_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.MultiplicativeExp a0_0 =null;

        edu.ustb.sei.mde.morel.MultiplicativeExp a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Morel.g:5451:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ) )* )
            // Morel.g:5452:2: (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ) )*
            {
            // Morel.g:5452:2: (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp )
            // Morel.g:5453:3: a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4587);
            a0_0=parse_edu_ustb_sei_mde_morel_MultiplicativeExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1254]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1255]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1256]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1257]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1258]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1259]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1260]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1261]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1262]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1263]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1264]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1265]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1266]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1267]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1268]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1269]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1270]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1271]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1272]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1273]);
            	}

            // Morel.g:5497:2: ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==18||LA50_0==20) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // Morel.g:5498:3: ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) )
            	    {
            	    // Morel.g:5498:3: ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) )
            	    // Morel.g:5499:4: ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp )
            	    {
            	    // Morel.g:5499:4: ( (a1= '+' |a2= '-' ) )
            	    // Morel.g:5500:5: (a1= '+' |a2= '-' )
            	    {
            	    // Morel.g:5500:5: (a1= '+' |a2= '-' )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==18) ) {
            	        alt49=1;
            	    }
            	    else if ( (LA49_0==20) ) {
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
            	            // Morel.g:5501:6: a1= '+'
            	            {
            	            a1=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4627); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAdditiveExp();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.AdditiveOperator.PLUS_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;
            	        case 2 :
            	            // Morel.g:5514:12: a2= '-'
            	            {
            	            a2=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4646); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAdditiveExp();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.AdditiveOperator.MINUS_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;

            	    }


            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1274]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1275]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1276]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1277]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1278]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1279]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1280]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1281]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1282]);
            	    			}

            	    // Morel.g:5542:4: (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp )
            	    // Morel.g:5543:5: a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4683);
            	    a5_0=parse_edu_ustb_sei_mde_morel_MultiplicativeExp();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_1_0_0_1, a5_0, true);
            	    						copyLocalizationInfos(a5_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1301]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1302]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1303]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1304]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1305]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1306]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1307]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1308]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1309]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1310]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1311]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1312]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1313]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1314]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1315]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1316]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1317]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1318]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1319]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1320]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1321]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1322]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_edu_ustb_sei_mde_morel_AdditiveExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_AdditiveExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_MultiplicativeExp"
    // Morel.g:5615:1: parse_edu_ustb_sei_mde_morel_MultiplicativeExp returns [edu.ustb.sei.mde.morel.MultiplicativeExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ) )* ;
    public final edu.ustb.sei.mde.morel.MultiplicativeExp parse_edu_ustb_sei_mde_morel_MultiplicativeExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.MultiplicativeExp element =  null;

        int parse_edu_ustb_sei_mde_morel_MultiplicativeExp_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.MultiplicativeExpChild a0_0 =null;

        edu.ustb.sei.mde.morel.MultiplicativeExpChild a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Morel.g:5618:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ) )* )
            // Morel.g:5619:2: (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ) )*
            {
            // Morel.g:5619:2: (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild )
            // Morel.g:5620:3: a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4743);
            a0_0=parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1334]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1335]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1336]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1337]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1338]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1339]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1340]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1341]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1342]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1343]);
            	}

            // Morel.g:5665:2: ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==17||LA52_0==23) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // Morel.g:5666:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) )
            	    {
            	    // Morel.g:5666:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) )
            	    // Morel.g:5667:4: ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild )
            	    {
            	    // Morel.g:5667:4: ( (a1= '*' |a2= '/' ) )
            	    // Morel.g:5668:5: (a1= '*' |a2= '/' )
            	    {
            	    // Morel.g:5668:5: (a1= '*' |a2= '/' )
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( (LA51_0==17) ) {
            	        alt51=1;
            	    }
            	    else if ( (LA51_0==23) ) {
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
            	            // Morel.g:5669:6: a1= '*'
            	            {
            	            a1=(Token)match(input,17,FOLLOW_17_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4783); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createMultiplicativeExp();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.MultiplicativeOperator.MULTI_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;
            	        case 2 :
            	            // Morel.g:5682:12: a2= '/'
            	            {
            	            a2=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4802); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createMultiplicativeExp();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.MultiplicativeOperator.DIV_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;

            	    }


            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1344]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1345]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1346]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1347]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1348]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1349]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1350]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1351]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1352]);
            	    			}

            	    // Morel.g:5710:4: (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild )
            	    // Morel.g:5711:5: a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4839);
            	    a5_0=parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_1_0_0_1, a5_0, true);
            	    						copyLocalizationInfos(a5_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1367]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1368]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1369]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1370]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1371]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1372]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1373]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1374]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1375]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1376]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1377]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1378]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1379]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1380]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1381]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1382]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1383]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1384]);
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_edu_ustb_sei_mde_morel_MultiplicativeExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_MultiplicativeExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_UnaryExp"
    // Morel.g:5785:1: parse_edu_ustb_sei_mde_morel_UnaryExp returns [edu.ustb.sei.mde.morel.UnaryExp element = null] : ( ( (a0= '+' |a1= '-' |a2= 'not' |a3= '!' ) ) )? (a6_0= parse_edu_ustb_sei_mde_morel_AtomicExp ) ;
    public final edu.ustb.sei.mde.morel.UnaryExp parse_edu_ustb_sei_mde_morel_UnaryExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.UnaryExp element =  null;

        int parse_edu_ustb_sei_mde_morel_UnaryExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        edu.ustb.sei.mde.morel.AtomicExp a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Morel.g:5788:2: ( ( ( (a0= '+' |a1= '-' |a2= 'not' |a3= '!' ) ) )? (a6_0= parse_edu_ustb_sei_mde_morel_AtomicExp ) )
            // Morel.g:5789:2: ( ( (a0= '+' |a1= '-' |a2= 'not' |a3= '!' ) ) )? (a6_0= parse_edu_ustb_sei_mde_morel_AtomicExp )
            {
            // Morel.g:5789:2: ( ( (a0= '+' |a1= '-' |a2= 'not' |a3= '!' ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==12||LA54_0==18||LA54_0==20||LA54_0==51) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // Morel.g:5790:3: ( (a0= '+' |a1= '-' |a2= 'not' |a3= '!' ) )
                    {
                    // Morel.g:5790:3: ( (a0= '+' |a1= '-' |a2= 'not' |a3= '!' ) )
                    // Morel.g:5791:4: (a0= '+' |a1= '-' |a2= 'not' |a3= '!' )
                    {
                    // Morel.g:5791:4: (a0= '+' |a1= '-' |a2= 'not' |a3= '!' )
                    int alt53=4;
                    switch ( input.LA(1) ) {
                    case 18:
                        {
                        alt53=1;
                        }
                        break;
                    case 20:
                        {
                        alt53=2;
                        }
                        break;
                    case 51:
                        {
                        alt53=3;
                        }
                        break;
                    case 12:
                        {
                        alt53=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;

                    }

                    switch (alt53) {
                        case 1 :
                            // Morel.g:5792:5: a0= '+'
                            {
                            a0=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_UnaryExp4910); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                            					// set value of enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.PLUS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
                            					completedElement(value, false);
                            				}

                            }
                            break;
                        case 2 :
                            // Morel.g:5805:10: a1= '-'
                            {
                            a1=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_morel_UnaryExp4927); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            					// set value of enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.MINUS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
                            					completedElement(value, false);
                            				}

                            }
                            break;
                        case 3 :
                            // Morel.g:5818:10: a2= 'not'
                            {
                            a2=(Token)match(input,51,FOLLOW_51_in_parse_edu_ustb_sei_mde_morel_UnaryExp4944); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                            					// set value of enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.NOT_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
                            					completedElement(value, false);
                            				}

                            }
                            break;
                        case 4 :
                            // Morel.g:5831:10: a3= '!'
                            {
                            a3=(Token)match(input,12,FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_UnaryExp4961); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            					// set value of enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.NOT_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
                            					completedElement(value, false);
                            				}

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1395]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1396]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1397]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1398]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1399]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1400]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1401]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1402]);
            	}

            // Morel.g:5859:2: (a6_0= parse_edu_ustb_sei_mde_morel_AtomicExp )
            // Morel.g:5860:3: a6_0= parse_edu_ustb_sei_mde_morel_AtomicExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AtomicExp_in_parse_edu_ustb_sei_mde_morel_UnaryExp4994);
            a6_0=parse_edu_ustb_sei_mde_morel_AtomicExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_1, a6_0, true);
            				copyLocalizationInfos(a6_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1403]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1404]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1405]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1406]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1407]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1408]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1409]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1410]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1411]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1412]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1413]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1414]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1415]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1416]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1417]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1418]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1419]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1420]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1421]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1422]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1423]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_edu_ustb_sei_mde_morel_UnaryExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_UnaryExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BindExp"
    // Morel.g:5907:1: parse_edu_ustb_sei_mde_morel_BindExp returns [edu.ustb.sei.mde.morel.BindExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_VariableExp ) a1= '<-' (a2_0= parse_edu_ustb_sei_mde_morel_LetExp |a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ;
    public final edu.ustb.sei.mde.morel.BindExp parse_edu_ustb_sei_mde_morel_BindExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BindExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BindExp_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.morel.VariableExp a0_0 =null;

        edu.ustb.sei.mde.morel.LetExp a2_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a2_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a2_2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Morel.g:5910:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_VariableExp ) a1= '<-' (a2_0= parse_edu_ustb_sei_mde_morel_LetExp |a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
            // Morel.g:5911:2: (a0_0= parse_edu_ustb_sei_mde_morel_VariableExp ) a1= '<-' (a2_0= parse_edu_ustb_sei_mde_morel_LetExp |a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            {
            // Morel.g:5911:2: (a0_0= parse_edu_ustb_sei_mde_morel_VariableExp )
            // Morel.g:5912:3: a0_0= parse_edu_ustb_sei_mde_morel_VariableExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_BindExp5031);
            a0_0=parse_edu_ustb_sei_mde_morel_VariableExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1424]);
            	}

            a1=(Token)match(input,27,FOLLOW_27_in_parse_edu_ustb_sei_mde_morel_BindExp5049); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBindExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1425]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1426]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1427]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1428]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1429]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1430]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1431]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1432]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1433]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1434]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1435]);
            	}

            // Morel.g:5961:2: (a2_0= parse_edu_ustb_sei_mde_morel_LetExp |a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt55=1;
                }
                break;
            case 43:
                {
                alt55=2;
                }
                break;
            case DATA_TYPE:
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 12:
            case 15:
            case 18:
            case 20:
            case 40:
            case 46:
            case 51:
            case 52:
            case 65:
                {
                alt55=3;
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
                    // Morel.g:5962:3: a2_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_BindExp5067);
                    a2_0=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_2, a2_0, true);
                    				copyLocalizationInfos(a2_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:5981:6: a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_BindExp5081);
                    a2_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_2, a2_1, true);
                    				copyLocalizationInfos(a2_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:6000:6: a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_BindExp5095);
                    a2_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_2, a2_2, true);
                    				copyLocalizationInfos(a2_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1436]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1437]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_edu_ustb_sei_mde_morel_BindExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BindExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_DeclarativeStatement"
    // Morel.g:6028:1: parse_edu_ustb_sei_mde_morel_DeclarativeStatement returns [edu.ustb.sei.mde.morel.DeclarativeStatement element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_BindExp |a0_1= parse_edu_ustb_sei_mde_morel_LetExp |a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp |a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a1= ';' ;
    public final edu.ustb.sei.mde.morel.DeclarativeStatement parse_edu_ustb_sei_mde_morel_DeclarativeStatement() throws RecognitionException {
        edu.ustb.sei.mde.morel.DeclarativeStatement element =  null;

        int parse_edu_ustb_sei_mde_morel_DeclarativeStatement_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.morel.BindExp a0_0 =null;

        edu.ustb.sei.mde.morel.LetExp a0_1 =null;

        edu.ustb.sei.mde.morel.ConditionExp a0_2 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a0_3 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Morel.g:6031:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_BindExp |a0_1= parse_edu_ustb_sei_mde_morel_LetExp |a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp |a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a1= ';' )
            // Morel.g:6032:2: (a0_0= parse_edu_ustb_sei_mde_morel_BindExp |a0_1= parse_edu_ustb_sei_mde_morel_LetExp |a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp |a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a1= ';'
            {
            // Morel.g:6032:2: (a0_0= parse_edu_ustb_sei_mde_morel_BindExp |a0_1= parse_edu_ustb_sei_mde_morel_LetExp |a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp |a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt56=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA56_1 = input.LA(2);

                if ( (synpred80_Morel()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;

                }
                }
                break;
            case 47:
                {
                alt56=2;
                }
                break;
            case 43:
                {
                alt56=3;
                }
                break;
            case DATA_TYPE:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 12:
            case 15:
            case 18:
            case 20:
            case 40:
            case 46:
            case 51:
            case 52:
            case 65:
                {
                alt56=4;
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
                    // Morel.g:6033:3: a0_0= parse_edu_ustb_sei_mde_morel_BindExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5132);
                    a0_0=parse_edu_ustb_sei_mde_morel_BindExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:6052:6: a0_1= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5146);
                    a0_1=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:6071:6: a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5160);
                    a0_2=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Morel.g:6090:6: a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5174);
                    a0_3=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_0, a0_3, true);
                    				copyLocalizationInfos(a0_3, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1438]);
            	}

            a1=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5192); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1439]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1440]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1441]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1442]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1443]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1444]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1445]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1446]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1447]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1448]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1449]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1450]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1451]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1452]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1453]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1454]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1455]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_edu_ustb_sei_mde_morel_DeclarativeStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_DeclarativeStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_IfStatement"
    // Morel.g:6147:1: parse_edu_ustb_sei_mde_morel_IfStatement returns [edu.ustb.sei.mde.morel.IfStatement element = null] : a0= 'if' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a3= ')' (a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )? ;
    public final edu.ustb.sei.mde.morel.IfStatement parse_edu_ustb_sei_mde_morel_IfStatement() throws RecognitionException {
        edu.ustb.sei.mde.morel.IfStatement element =  null;

        int parse_edu_ustb_sei_mde_morel_IfStatement_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        edu.ustb.sei.mde.morel.BooleanImpliesExp a2_0 =null;

        edu.ustb.sei.mde.morel.ImperativeStatement a4_0 =null;

        edu.ustb.sei.mde.morel.ImperativeStatement a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Morel.g:6150:2: (a0= 'if' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a3= ')' (a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )? )
            // Morel.g:6151:2: a0= 'if' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a3= ')' (a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )?
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_edu_ustb_sei_mde_morel_IfStatement5221); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1456]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_IfStatement5235); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1457]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1458]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1459]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1460]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1461]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1462]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1463]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1464]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1465]);
            	}

            // Morel.g:6187:2: (a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            // Morel.g:6188:3: a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_IfStatement5253);
            a2_0=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_2, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1466]);
            	}

            a3=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_IfStatement5271); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1467]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1468]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1469]);
            	}

            // Morel.g:6229:2: (a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
            // Morel.g:6230:3: a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_IfStatement5289);
            a4_0=parse_edu_ustb_sei_mde_morel_ImperativeStatement();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_4, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1470]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1471]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1472]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1473]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1474]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1475]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1476]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1477]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1478]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1479]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1480]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1481]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1482]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1483]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1484]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1485]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1486]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1487]);
            	}

            // Morel.g:6272:2: ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==37) ) {
                int LA57_1 = input.LA(2);

                if ( (synpred83_Morel()) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // Morel.g:6273:3: (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
                    {
                    // Morel.g:6273:3: (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
                    // Morel.g:6274:4: a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
                    {
                    a5=(Token)match(input,37,FOLLOW_37_in_parse_edu_ustb_sei_mde_morel_IfStatement5316); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1488]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1489]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1490]);
                    			}

                    // Morel.g:6290:4: (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
                    // Morel.g:6291:5: a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_IfStatement5342);
                    a6_0=parse_edu_ustb_sei_mde_morel_ImperativeStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_5_0_0_1, a6_0, true);
                    						copyLocalizationInfos(a6_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1491]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1492]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1493]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1494]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1495]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1496]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1497]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1498]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1499]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1500]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1501]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1502]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1503]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1504]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1505]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1506]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1507]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1508]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1509]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1510]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1511]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1512]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1513]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1514]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1515]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1516]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1517]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1518]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1519]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1520]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1521]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1522]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1523]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1524]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1525]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1526]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, parse_edu_ustb_sei_mde_morel_IfStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_IfStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_ForStatement"
    // Morel.g:6359:1: parse_edu_ustb_sei_mde_morel_ForStatement returns [edu.ustb.sei.mde.morel.ForStatement element = null] : a0= 'for' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) a3= ';' (a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a5= ';' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )? a7= ')' (a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ;
    public final edu.ustb.sei.mde.morel.ForStatement parse_edu_ustb_sei_mde_morel_ForStatement() throws RecognitionException {
        edu.ustb.sei.mde.morel.ForStatement element =  null;

        int parse_edu_ustb_sei_mde_morel_ForStatement_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        Token a7=null;
        edu.ustb.sei.mde.morel.VariableWithInit a2_0 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a4_0 =null;

        edu.ustb.sei.mde.morel.LetExp a6_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a6_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a6_2 =null;

        edu.ustb.sei.mde.morel.ImperativeStatement a8_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Morel.g:6362:2: (a0= 'for' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) a3= ';' (a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a5= ';' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )? a7= ')' (a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
            // Morel.g:6363:2: a0= 'for' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) a3= ';' (a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a5= ';' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )? a7= ')' (a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_edu_ustb_sei_mde_morel_ForStatement5398); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1527]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_ForStatement5412); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1528]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1529]);
            	}

            // Morel.g:6392:2: (a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit )
            // Morel.g:6393:3: a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_ForStatement5430);
            a2_0=parse_edu_ustb_sei_mde_morel_VariableWithInit();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_2, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1530]);
            	}

            a3=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_ForStatement5448); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1531]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1532]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1533]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1534]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1535]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1536]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1537]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1538]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1539]);
            	}

            // Morel.g:6440:2: (a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            // Morel.g:6441:3: a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5466);
            a4_0=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_4, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1540]);
            	}

            a5=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_ForStatement5484); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1541]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1542]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1543]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1544]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1545]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1546]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1547]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1548]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1549]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1550]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1551]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1552]);
            	}

            // Morel.g:6491:2: ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0 >= DATA_TYPE && LA59_0 <= INUMBER)||(LA59_0 >= QUOTED_39_39_92 && LA59_0 <= RNUMBER)||LA59_0==12||LA59_0==15||LA59_0==18||LA59_0==20||LA59_0==40||LA59_0==43||(LA59_0 >= 46 && LA59_0 <= 47)||(LA59_0 >= 51 && LA59_0 <= 52)||LA59_0==65) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // Morel.g:6492:3: ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
                    {
                    // Morel.g:6492:3: ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
                    // Morel.g:6493:4: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    {
                    // Morel.g:6493:4: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    int alt58=3;
                    switch ( input.LA(1) ) {
                    case 47:
                        {
                        alt58=1;
                        }
                        break;
                    case 43:
                        {
                        alt58=2;
                        }
                        break;
                    case DATA_TYPE:
                    case IDENTIFIER:
                    case INUMBER:
                    case QUOTED_39_39_92:
                    case RNUMBER:
                    case 12:
                    case 15:
                    case 18:
                    case 20:
                    case 40:
                    case 46:
                    case 51:
                    case 52:
                    case 65:
                        {
                        alt58=3;
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
                            // Morel.g:6494:5: a6_0= parse_edu_ustb_sei_mde_morel_LetExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5513);
                            a6_0=parse_edu_ustb_sei_mde_morel_LetExp();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_6_0_0_0, a6_0, true);
                            						copyLocalizationInfos(a6_0, element);
                            					}
                            				}

                            }
                            break;
                        case 2 :
                            // Morel.g:6513:10: a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5533);
                            a6_1=parse_edu_ustb_sei_mde_morel_ConditionExp();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_6_0_0_0, a6_1, true);
                            						copyLocalizationInfos(a6_1, element);
                            					}
                            				}

                            }
                            break;
                        case 3 :
                            // Morel.g:6532:10: a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5553);
                            a6_2=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_6_0_0_0, a6_2, true);
                            						copyLocalizationInfos(a6_2, element);
                            					}
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1553]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1554]);
            	}

            a7=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_ForStatement5594); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1555]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1556]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1557]);
            	}

            // Morel.g:6580:2: (a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
            // Morel.g:6581:3: a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_ForStatement5612);
            a8_0=parse_edu_ustb_sei_mde_morel_ImperativeStatement();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_8, a8_0, true);
            				copyLocalizationInfos(a8_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1558]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1559]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1560]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1561]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1562]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1563]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1564]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1565]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1566]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1567]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1568]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1569]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1570]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1571]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1572]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1573]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1574]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1575]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, parse_edu_ustb_sei_mde_morel_ForStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_ForStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BlockStatement"
    // Morel.g:6625:1: parse_edu_ustb_sei_mde_morel_BlockStatement returns [edu.ustb.sei.mde.morel.BlockStatement element = null] : a0= '{' ( (a1_0= parse_edu_ustb_sei_mde_morel_Statement ) )* a2= '}' ;
    public final edu.ustb.sei.mde.morel.BlockStatement parse_edu_ustb_sei_mde_morel_BlockStatement() throws RecognitionException {
        edu.ustb.sei.mde.morel.BlockStatement element =  null;

        int parse_edu_ustb_sei_mde_morel_BlockStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.Statement a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Morel.g:6628:2: (a0= '{' ( (a1_0= parse_edu_ustb_sei_mde_morel_Statement ) )* a2= '}' )
            // Morel.g:6629:2: a0= '{' ( (a1_0= parse_edu_ustb_sei_mde_morel_Statement ) )* a2= '}'
            {
            a0=(Token)match(input,68,FOLLOW_68_in_parse_edu_ustb_sei_mde_morel_BlockStatement5645); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBlockStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1576]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1577]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1578]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1579]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1580]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1581]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1582]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1583]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1584]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1585]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1586]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1587]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1588]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1589]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1590]);
            	}

            // Morel.g:6657:2: ( (a1_0= parse_edu_ustb_sei_mde_morel_Statement ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0 >= DATA_TYPE && LA60_0 <= INUMBER)||(LA60_0 >= QUOTED_39_39_92 && LA60_0 <= RNUMBER)||LA60_0==12||LA60_0==15||LA60_0==18||LA60_0==20||(LA60_0 >= 40 && LA60_0 <= 41)||LA60_0==43||(LA60_0 >= 46 && LA60_0 <= 47)||(LA60_0 >= 51 && LA60_0 <= 52)||LA60_0==65||LA60_0==68) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // Morel.g:6658:3: (a1_0= parse_edu_ustb_sei_mde_morel_Statement )
            	    {
            	    // Morel.g:6658:3: (a1_0= parse_edu_ustb_sei_mde_morel_Statement )
            	    // Morel.g:6659:4: a1_0= parse_edu_ustb_sei_mde_morel_Statement
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_BlockStatement5668);
            	    a1_0=parse_edu_ustb_sei_mde_morel_Statement();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_1, a1_0, true);
            	    					copyLocalizationInfos(a1_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1591]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1592]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1593]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1594]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1595]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1596]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1597]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1598]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1599]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1600]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1601]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1602]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1603]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1604]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1605]);
            	}

            a2=(Token)match(input,71,FOLLOW_71_in_parse_edu_ustb_sei_mde_morel_BlockStatement5694); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBlockStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1606]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1607]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1608]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1609]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1610]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1611]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1612]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1613]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1614]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1615]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1616]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1617]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1618]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1619]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1620]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1621]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1622]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1623]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, parse_edu_ustb_sei_mde_morel_BlockStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BlockStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_TransformationModel"
    // Morel.g:6732:1: parse_edu_ustb_sei_mde_morel_TransformationModel returns [edu.ustb.sei.mde.morel.TransformationModel element = null] : a0= 'transformation' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a3_0= parse_edu_ustb_sei_mde_morel_Rule ) )* ;
    public final edu.ustb.sei.mde.morel.TransformationModel parse_edu_ustb_sei_mde_morel_TransformationModel() throws RecognitionException {
        edu.ustb.sei.mde.morel.TransformationModel element =  null;

        int parse_edu_ustb_sei_mde_morel_TransformationModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.morel.TypedModel a2_0 =null;

        edu.ustb.sei.mde.morel.Rule a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Morel.g:6735:2: (a0= 'transformation' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a3_0= parse_edu_ustb_sei_mde_morel_Rule ) )* )
            // Morel.g:6736:2: a0= 'transformation' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a3_0= parse_edu_ustb_sei_mde_morel_Rule ) )*
            {
            a0=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_TransformationModel5723); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTransformationModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1624]);
            	}

            // Morel.g:6750:2: (a1= IDENTIFIER )
            // Morel.g:6751:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_TransformationModel5741); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1625]);
            	}

            // Morel.g:6786:2: ( (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==66) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // Morel.g:6787:3: (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel )
            	    {
            	    // Morel.g:6787:3: (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel )
            	    // Morel.g:6788:4: a2_0= parse_edu_ustb_sei_mde_morel_TypedModel
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypedModel_in_parse_edu_ustb_sei_mde_morel_TransformationModel5771);
            	    a2_0=parse_edu_ustb_sei_mde_morel_TypedModel();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_2, a2_0, true);
            	    					copyLocalizationInfos(a2_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1626]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1627]);
            	}

            // Morel.g:6815:2: ( (a3_0= parse_edu_ustb_sei_mde_morel_Rule ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==61) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // Morel.g:6816:3: (a3_0= parse_edu_ustb_sei_mde_morel_Rule )
            	    {
            	    // Morel.g:6816:3: (a3_0= parse_edu_ustb_sei_mde_morel_Rule )
            	    // Morel.g:6817:4: a3_0= parse_edu_ustb_sei_mde_morel_Rule
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Rule_in_parse_edu_ustb_sei_mde_morel_TransformationModel5806);
            	    a3_0=parse_edu_ustb_sei_mde_morel_Rule();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_3, a3_0, true);
            	    					copyLocalizationInfos(a3_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1628]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, parse_edu_ustb_sei_mde_morel_TransformationModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_TransformationModel"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Rule"
    // Morel.g:6845:1: parse_edu_ustb_sei_mde_morel_Rule returns [edu.ustb.sei.mde.morel.Rule element = null] : a0= 'rule' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) ) )* a4= '}' ;
    public final edu.ustb.sei.mde.morel.Rule parse_edu_ustb_sei_mde_morel_Rule() throws RecognitionException {
        edu.ustb.sei.mde.morel.Rule element =  null;

        int parse_edu_ustb_sei_mde_morel_Rule_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        edu.ustb.sei.mde.morel.Pattern a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Morel.g:6848:2: (a0= 'rule' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) ) )* a4= '}' )
            // Morel.g:6849:2: a0= 'rule' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) ) )* a4= '}'
            {
            a0=(Token)match(input,61,FOLLOW_61_in_parse_edu_ustb_sei_mde_morel_Rule5847); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1629]);
            	}

            // Morel.g:6863:2: (a1= IDENTIFIER )
            // Morel.g:6864:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_Rule5865); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
            			}
            			if (element == null) {
            				element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RULE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1630]);
            	}

            a2=(Token)match(input,68,FOLLOW_68_in_parse_edu_ustb_sei_mde_morel_Rule5886); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1631]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1632]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1633]);
            	}

            // Morel.g:6915:2: ( ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==48||LA63_0==50||(LA63_0 >= 54 && LA63_0 <= 57)||LA63_0==60||LA63_0==68) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // Morel.g:6916:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) )
            	    {
            	    // Morel.g:6916:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) )
            	    // Morel.g:6917:4: (a3_0= parse_edu_ustb_sei_mde_morel_Pattern )
            	    {
            	    // Morel.g:6917:4: (a3_0= parse_edu_ustb_sei_mde_morel_Pattern )
            	    // Morel.g:6918:5: a3_0= parse_edu_ustb_sei_mde_morel_Pattern
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Pattern_in_parse_edu_ustb_sei_mde_morel_Rule5915);
            	    a3_0=parse_edu_ustb_sei_mde_morel_Pattern();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a3_0 != null) {
            	    						if (a3_0 != null) {
            	    							Object value = a3_0;
            	    							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.RULE__PATTERNS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_3_0_0_0, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1634]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1635]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1636]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1637]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1638]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1639]);
            	}

            a4=(Token)match(input,71,FOLLOW_71_in_parse_edu_ustb_sei_mde_morel_Rule5956); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_34_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1640]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, parse_edu_ustb_sei_mde_morel_Rule_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Rule"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Pattern"
    // Morel.g:6970:1: parse_edu_ustb_sei_mde_morel_Pattern returns [edu.ustb.sei.mde.morel.Pattern element = null] : ( ( (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )? ) a8= '{' a9= 'match' a10= ':' ( ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' ) )? ( ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' ) )? ( (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a22= '}' |c0= parse_edu_ustb_sei_mde_morel_Query );
    public final edu.ustb.sei.mde.morel.Pattern parse_edu_ustb_sei_mde_morel_Pattern() throws RecognitionException {
        edu.ustb.sei.mde.morel.Pattern element =  null;

        int parse_edu_ustb_sei_mde_morel_Pattern_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a12=null;
        Token a14=null;
        Token a16=null;
        Token a18=null;
        Token a19=null;
        Token a20=null;
        Token a22=null;
        edu.ustb.sei.mde.morel.Variable a11_0 =null;

        edu.ustb.sei.mde.morel.Variable a13_0 =null;

        edu.ustb.sei.mde.morel.LinkConstraint a15_0 =null;

        edu.ustb.sei.mde.morel.LinkConstraint a17_0 =null;

        edu.ustb.sei.mde.morel.Statement a21_0 =null;

        edu.ustb.sei.mde.morel.Query c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }

            // Morel.g:6973:2: ( ( (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )? ) a8= '{' a9= 'match' a10= ':' ( ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' ) )? ( ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' ) )? ( (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a22= '}' |c0= parse_edu_ustb_sei_mde_morel_Query )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==48||LA71_0==50||(LA71_0 >= 54 && LA71_0 <= 56)||LA71_0==60||LA71_0==68) ) {
                alt71=1;
            }
            else if ( (LA71_0==57) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1 :
                    // Morel.g:6974:2: ( (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )? ) a8= '{' a9= 'match' a10= ':' ( ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' ) )? ( ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' ) )? ( (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a22= '}'
                    {
                    // Morel.g:6974:2: ( (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )? )
                    // Morel.g:6975:3: (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )?
                    {
                    // Morel.g:6975:3: (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )?
                    int alt64=7;
                    switch ( input.LA(1) ) {
                        case 48:
                            {
                            alt64=1;
                            }
                            break;
                        case 60:
                            {
                            alt64=2;
                            }
                            break;
                        case 50:
                            {
                            alt64=3;
                            }
                            break;
                        case 54:
                            {
                            alt64=4;
                            }
                            break;
                        case 56:
                            {
                            alt64=5;
                            }
                            break;
                        case 55:
                            {
                            alt64=6;
                            }
                            break;
                    }

                    switch (alt64) {
                        case 1 :
                            // Morel.g:6976:4: a0= 'lhs'
                            {
                            a0=(Token)match(input,48,FOLLOW_48_in_parse_edu_ustb_sei_mde_morel_Pattern5994); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 2 :
                            // Morel.g:6992:8: a1= 'rhs'
                            {
                            a1=(Token)match(input,60,FOLLOW_60_in_parse_edu_ustb_sei_mde_morel_Pattern6009); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.RHS_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 3 :
                            // Morel.g:7008:8: a2= 'nac'
                            {
                            a2=(Token)match(input,50,FOLLOW_50_in_parse_edu_ustb_sei_mde_morel_Pattern6024); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.NAC_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 4 :
                            // Morel.g:7024:8: a3= 'pac'
                            {
                            a3=(Token)match(input,54,FOLLOW_54_in_parse_edu_ustb_sei_mde_morel_Pattern6039); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PAC_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 5 :
                            // Morel.g:7040:8: a4= 'pre'
                            {
                            a4=(Token)match(input,56,FOLLOW_56_in_parse_edu_ustb_sei_mde_morel_Pattern6054); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PRE_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 6 :
                            // Morel.g:7056:8: a5= 'post'
                            {
                            a5=(Token)match(input,55,FOLLOW_55_in_parse_edu_ustb_sei_mde_morel_Pattern6069); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.POST_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1641]);
                    	}

                    a8=(Token)match(input,68,FOLLOW_68_in_parse_edu_ustb_sei_mde_morel_Pattern6090); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    			// initialize enumeration attribute
                    			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_1, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1642]);
                    	}

                    a9=(Token)match(input,49,FOLLOW_49_in_parse_edu_ustb_sei_mde_morel_Pattern6104); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    			// initialize enumeration attribute
                    			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_2, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1643]);
                    	}

                    a10=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Pattern6118); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    			// initialize enumeration attribute
                    			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_3, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1644]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1645]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1646]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1647]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1648]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1649]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1650]);
                    	}

                    // Morel.g:7135:2: ( ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' ) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==IDENTIFIER) ) {
                        int LA66_1 = input.LA(2);

                        if ( (LA66_1==24) ) {
                            alt66=1;
                        }
                    }
                    switch (alt66) {
                        case 1 :
                            // Morel.g:7136:3: ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' )
                            {
                            // Morel.g:7136:3: ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' )
                            // Morel.g:7137:4: (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';'
                            {
                            // Morel.g:7137:4: (a11_0= parse_edu_ustb_sei_mde_morel_Variable )
                            // Morel.g:7138:5: a11_0= parse_edu_ustb_sei_mde_morel_Variable
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Pattern6147);
                            a11_0=parse_edu_ustb_sei_mde_morel_Variable();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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
                            					if (a11_0 != null) {
                            						if (a11_0 != null) {
                            							Object value = a11_0;
                            							addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__VARIABLES, value);
                            							completedElement(value, true);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_4_0_0_0, a11_0, true);
                            						copyLocalizationInfos(a11_0, element);
                            					}
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1651]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1652]);
                            			}

                            // Morel.g:7167:4: ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )*
                            loop65:
                            do {
                                int alt65=2;
                                int LA65_0 = input.LA(1);

                                if ( (LA65_0==19) ) {
                                    alt65=1;
                                }


                                switch (alt65) {
                            	case 1 :
                            	    // Morel.g:7168:5: (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                            	    {
                            	    // Morel.g:7168:5: (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                            	    // Morel.g:7169:6: a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable )
                            	    {
                            	    a12=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_Pattern6188); if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    						if (element == null) {
                            	    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            	    							startIncompleteElement(element);
                            	    							// initialize enumeration attribute
                            	    							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            	    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            	    						}
                            	    						collectHiddenTokens(element);
                            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_4_0_0_1_0_0_0, null, true);
                            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
                            	    					}

                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1653]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1654]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1655]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1656]);
                            	    					}

                            	    // Morel.g:7189:6: (a13_0= parse_edu_ustb_sei_mde_morel_Variable )
                            	    // Morel.g:7190:7: a13_0= parse_edu_ustb_sei_mde_morel_Variable
                            	    {
                            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Pattern6222);
                            	    a13_0=parse_edu_ustb_sei_mde_morel_Variable();

                            	    state._fsp--;
                            	    if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
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
                            	    									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__VARIABLES, value);
                            	    									completedElement(value, true);
                            	    								}
                            	    								collectHiddenTokens(element);
                            	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_4_0_0_1_0_0_1, a13_0, true);
                            	    								copyLocalizationInfos(a13_0, element);
                            	    							}
                            	    						}

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1657]);
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1658]);
                            	    					}

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop65;
                                }
                            } while (true);


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1659]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1660]);
                            			}

                            a14=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_Pattern6283); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_4_0_0_2, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1661]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1662]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1663]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1664]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1665]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1666]);
                    	}

                    // Morel.g:7255:2: ( ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==IDENTIFIER) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // Morel.g:7256:3: ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' )
                            {
                            // Morel.g:7256:3: ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' )
                            // Morel.g:7257:4: (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';'
                            {
                            // Morel.g:7257:4: (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                            // Morel.g:7258:5: a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Pattern6331);
                            a15_0=parse_edu_ustb_sei_mde_morel_LinkConstraint();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_5_0_0_0, a15_0, true);
                            						copyLocalizationInfos(a15_0, element);
                            					}
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1667]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1668]);
                            			}

                            // Morel.g:7287:4: ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )*
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( (LA67_0==19) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // Morel.g:7288:5: (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) )
                            	    {
                            	    // Morel.g:7288:5: (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) )
                            	    // Morel.g:7289:6: a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                            	    {
                            	    a16=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_Pattern6372); if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    						if (element == null) {
                            	    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            	    							startIncompleteElement(element);
                            	    							// initialize enumeration attribute
                            	    							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            	    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            	    						}
                            	    						collectHiddenTokens(element);
                            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_5_0_0_1_0_0_0, null, true);
                            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
                            	    					}

                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1669]);
                            	    					}

                            	    // Morel.g:7306:6: (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                            	    // Morel.g:7307:7: a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint
                            	    {
                            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Pattern6406);
                            	    a17_0=parse_edu_ustb_sei_mde_morel_LinkConstraint();

                            	    state._fsp--;
                            	    if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
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
                            	    							if (a17_0 != null) {
                            	    								if (a17_0 != null) {
                            	    									Object value = a17_0;
                            	    									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__LINK_CONSTRAINTS, value);
                            	    									completedElement(value, true);
                            	    								}
                            	    								collectHiddenTokens(element);
                            	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_5_0_0_1_0_0_1, a17_0, true);
                            	    								copyLocalizationInfos(a17_0, element);
                            	    							}
                            	    						}

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1670]);
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1671]);
                            	    					}

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop67;
                                }
                            } while (true);


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1672]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1673]);
                            			}

                            a18=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_Pattern6467); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_5_0_0_2, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1674]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1675]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1676]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1677]);
                    	}

                    // Morel.g:7370:2: ( (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==67) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // Morel.g:7371:3: (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ )
                            {
                            // Morel.g:7371:3: (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ )
                            // Morel.g:7372:4: a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+
                            {
                            a19=(Token)match(input,67,FOLLOW_67_in_parse_edu_ustb_sei_mde_morel_Pattern6509); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_6_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a19, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1678]);
                            			}

                            a20=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Pattern6529); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_6_0_0_1, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1679]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1680]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1681]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1682]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1683]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1684]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1685]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1686]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1687]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1688]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1689]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1690]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1691]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1692]);
                            			}

                            // Morel.g:7419:4: ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+
                            int cnt69=0;
                            loop69:
                            do {
                                int alt69=2;
                                int LA69_0 = input.LA(1);

                                if ( ((LA69_0 >= DATA_TYPE && LA69_0 <= INUMBER)||(LA69_0 >= QUOTED_39_39_92 && LA69_0 <= RNUMBER)||LA69_0==12||LA69_0==15||LA69_0==18||LA69_0==20||(LA69_0 >= 40 && LA69_0 <= 41)||LA69_0==43||(LA69_0 >= 46 && LA69_0 <= 47)||(LA69_0 >= 51 && LA69_0 <= 52)||LA69_0==65||LA69_0==68) ) {
                                    alt69=1;
                                }


                                switch (alt69) {
                            	case 1 :
                            	    // Morel.g:7420:5: ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) )
                            	    {
                            	    // Morel.g:7420:5: ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) )
                            	    // Morel.g:7421:6: (a21_0= parse_edu_ustb_sei_mde_morel_Statement )
                            	    {
                            	    // Morel.g:7421:6: (a21_0= parse_edu_ustb_sei_mde_morel_Statement )
                            	    // Morel.g:7422:7: a21_0= parse_edu_ustb_sei_mde_morel_Statement
                            	    {
                            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_Pattern6570);
                            	    a21_0=parse_edu_ustb_sei_mde_morel_Statement();

                            	    state._fsp--;
                            	    if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
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
                            	    							if (a21_0 != null) {
                            	    								if (a21_0 != null) {
                            	    									Object value = a21_0;
                            	    									addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.PATTERN__STATEMENTS, value);
                            	    									completedElement(value, true);
                            	    								}
                            	    								collectHiddenTokens(element);
                            	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_6_0_0_2_0_0_0, a21_0, true);
                            	    								copyLocalizationInfos(a21_0, element);
                            	    							}
                            	    						}

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1693]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1694]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1695]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1696]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1697]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1698]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1699]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1700]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1701]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1702]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1703]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1704]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1705]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1706]);
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1707]);
                            	    					}

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt69 >= 1 ) break loop69;
                            	    if (state.backtracking>0) {state.failed=true; return element;}
                                        EarlyExitException eee =
                                            new EarlyExitException(69, input);
                                        throw eee;
                                }
                                cnt69++;
                            } while (true);


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1708]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1709]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1710]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1711]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1712]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1713]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1714]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1715]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1716]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1717]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1718]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1719]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1720]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1721]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1722]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1723]);
                    	}

                    a22=(Token)match(input,71,FOLLOW_71_in_parse_edu_ustb_sei_mde_morel_Pattern6644); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    			// initialize enumeration attribute
                    			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_35_0_0_7, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1724]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1725]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1726]);
                    	}

                    }
                    break;
                case 2 :
                    // Morel.g:7513:2: c0= parse_edu_ustb_sei_mde_morel_Query
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Query_in_parse_edu_ustb_sei_mde_morel_Pattern6663);
                    c0=parse_edu_ustb_sei_mde_morel_Query();

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
            if ( state.backtracking>0 ) { memoize(input, 37, parse_edu_ustb_sei_mde_morel_Pattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Pattern"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Variable"
    // Morel.g:7517:1: parse_edu_ustb_sei_mde_morel_Variable returns [edu.ustb.sei.mde.morel.Variable element = null] : (c0= parse_edu_ustb_sei_mde_morel_ObjectVariable |c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable |c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit |c3= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit );
    public final edu.ustb.sei.mde.morel.Variable parse_edu_ustb_sei_mde_morel_Variable() throws RecognitionException {
        edu.ustb.sei.mde.morel.Variable element =  null;

        int parse_edu_ustb_sei_mde_morel_Variable_StartIndex = input.index();

        edu.ustb.sei.mde.morel.ObjectVariable c0 =null;

        edu.ustb.sei.mde.morel.PrimitiveVariable c1 =null;

        edu.ustb.sei.mde.morel.ObjectVariableWithInit c2 =null;

        edu.ustb.sei.mde.morel.PrimitiveVariableWithInit c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Morel.g:7518:2: (c0= parse_edu_ustb_sei_mde_morel_ObjectVariable |c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable |c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit |c3= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit )
            int alt72=4;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==IDENTIFIER) ) {
                int LA72_1 = input.LA(2);

                if ( (synpred104_Morel()) ) {
                    alt72=1;
                }
                else if ( (synpred105_Morel()) ) {
                    alt72=2;
                }
                else if ( (synpred106_Morel()) ) {
                    alt72=3;
                }
                else if ( (true) ) {
                    alt72=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }
            switch (alt72) {
                case 1 :
                    // Morel.g:7519:2: c0= parse_edu_ustb_sei_mde_morel_ObjectVariable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariable_in_parse_edu_ustb_sei_mde_morel_Variable6684);
                    c0=parse_edu_ustb_sei_mde_morel_ObjectVariable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7520:4: c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariable_in_parse_edu_ustb_sei_mde_morel_Variable6694);
                    c1=parse_edu_ustb_sei_mde_morel_PrimitiveVariable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7521:4: c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_Variable6704);
                    c2=parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7522:4: c3= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_Variable6714);
                    c3=parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 38, parse_edu_ustb_sei_mde_morel_Variable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Variable"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Statement"
    // Morel.g:7526:1: parse_edu_ustb_sei_mde_morel_Statement returns [edu.ustb.sei.mde.morel.Statement element = null] : (c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement |c1= parse_edu_ustb_sei_mde_morel_IfStatement |c2= parse_edu_ustb_sei_mde_morel_ForStatement |c3= parse_edu_ustb_sei_mde_morel_BlockStatement );
    public final edu.ustb.sei.mde.morel.Statement parse_edu_ustb_sei_mde_morel_Statement() throws RecognitionException {
        edu.ustb.sei.mde.morel.Statement element =  null;

        int parse_edu_ustb_sei_mde_morel_Statement_StartIndex = input.index();

        edu.ustb.sei.mde.morel.DeclarativeStatement c0 =null;

        edu.ustb.sei.mde.morel.IfStatement c1 =null;

        edu.ustb.sei.mde.morel.ForStatement c2 =null;

        edu.ustb.sei.mde.morel.BlockStatement c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return element; }

            // Morel.g:7527:2: (c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement |c1= parse_edu_ustb_sei_mde_morel_IfStatement |c2= parse_edu_ustb_sei_mde_morel_ForStatement |c3= parse_edu_ustb_sei_mde_morel_BlockStatement )
            int alt73=4;
            switch ( input.LA(1) ) {
            case DATA_TYPE:
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 12:
            case 15:
            case 18:
            case 20:
            case 40:
            case 46:
            case 47:
            case 51:
            case 52:
            case 65:
                {
                alt73=1;
                }
                break;
            case 43:
                {
                int LA73_3 = input.LA(2);

                if ( (synpred107_Morel()) ) {
                    alt73=1;
                }
                else if ( (synpred108_Morel()) ) {
                    alt73=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 3, input);

                    throw nvae;

                }
                }
                break;
            case 41:
                {
                alt73=3;
                }
                break;
            case 68:
                {
                alt73=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }

            switch (alt73) {
                case 1 :
                    // Morel.g:7528:2: c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_DeclarativeStatement_in_parse_edu_ustb_sei_mde_morel_Statement6735);
                    c0=parse_edu_ustb_sei_mde_morel_DeclarativeStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7529:4: c1= parse_edu_ustb_sei_mde_morel_IfStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_parse_edu_ustb_sei_mde_morel_Statement6745);
                    c1=parse_edu_ustb_sei_mde_morel_IfStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7530:4: c2= parse_edu_ustb_sei_mde_morel_ForStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ForStatement_in_parse_edu_ustb_sei_mde_morel_Statement6755);
                    c2=parse_edu_ustb_sei_mde_morel_ForStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7531:4: c3= parse_edu_ustb_sei_mde_morel_BlockStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BlockStatement_in_parse_edu_ustb_sei_mde_morel_Statement6765);
                    c3=parse_edu_ustb_sei_mde_morel_BlockStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 39, parse_edu_ustb_sei_mde_morel_Statement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Statement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_CallPathExp"
    // Morel.g:7535:1: parse_edu_ustb_sei_mde_morel_CallPathExp returns [edu.ustb.sei.mde.morel.CallPathExp element = null] : (c0= parse_edu_ustb_sei_mde_morel_FeaturePathExp |c1= parse_edu_ustb_sei_mde_morel_OperationPathExp |c2= parse_edu_ustb_sei_mde_morel_IteratorPathExp );
    public final edu.ustb.sei.mde.morel.CallPathExp parse_edu_ustb_sei_mde_morel_CallPathExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.CallPathExp element =  null;

        int parse_edu_ustb_sei_mde_morel_CallPathExp_StartIndex = input.index();

        edu.ustb.sei.mde.morel.FeaturePathExp c0 =null;

        edu.ustb.sei.mde.morel.OperationPathExp c1 =null;

        edu.ustb.sei.mde.morel.IteratorPathExp c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }

            // Morel.g:7536:2: (c0= parse_edu_ustb_sei_mde_morel_FeaturePathExp |c1= parse_edu_ustb_sei_mde_morel_OperationPathExp |c2= parse_edu_ustb_sei_mde_morel_IteratorPathExp )
            int alt74=3;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==22) ) {
                int LA74_1 = input.LA(2);

                if ( (LA74_1==IDENTIFIER) ) {
                    int LA74_3 = input.LA(3);

                    if ( (LA74_3==EOF||(LA74_3 >= 13 && LA74_3 <= 14)||(LA74_3 >= 16 && LA74_3 <= 23)||(LA74_3 >= 25 && LA74_3 <= 34)||(LA74_3 >= 37 && LA74_3 <= 38)||(LA74_3 >= 44 && LA74_3 <= 45)||LA74_3==53||LA74_3==63||(LA74_3 >= 69 && LA74_3 <= 70)) ) {
                        alt74=1;
                    }
                    else if ( (LA74_3==15) ) {
                        alt74=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 74, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA74_0==21) ) {
                int LA74_2 = input.LA(2);

                if ( (LA74_2==IDENTIFIER) ) {
                    alt74=2;
                }
                else if ( ((LA74_2 >= 35 && LA74_2 <= 36)||LA74_2==39||LA74_2==42||LA74_2==59||LA74_2==62) ) {
                    alt74=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }
            switch (alt74) {
                case 1 :
                    // Morel.g:7537:2: c0= parse_edu_ustb_sei_mde_morel_FeaturePathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_FeaturePathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6786);
                    c0=parse_edu_ustb_sei_mde_morel_FeaturePathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7538:4: c1= parse_edu_ustb_sei_mde_morel_OperationPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_OperationPathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6796);
                    c1=parse_edu_ustb_sei_mde_morel_OperationPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7539:4: c2= parse_edu_ustb_sei_mde_morel_IteratorPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IteratorPathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6806);
                    c2=parse_edu_ustb_sei_mde_morel_IteratorPathExp();

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
            if ( state.backtracking>0 ) { memoize(input, 40, parse_edu_ustb_sei_mde_morel_CallPathExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_CallPathExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_VariableWithInit"
    // Morel.g:7543:1: parse_edu_ustb_sei_mde_morel_VariableWithInit returns [edu.ustb.sei.mde.morel.VariableWithInit element = null] : (c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit |c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit );
    public final edu.ustb.sei.mde.morel.VariableWithInit parse_edu_ustb_sei_mde_morel_VariableWithInit() throws RecognitionException {
        edu.ustb.sei.mde.morel.VariableWithInit element =  null;

        int parse_edu_ustb_sei_mde_morel_VariableWithInit_StartIndex = input.index();

        edu.ustb.sei.mde.morel.ObjectVariableWithInit c0 =null;

        edu.ustb.sei.mde.morel.PrimitiveVariableWithInit c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return element; }

            // Morel.g:7544:2: (c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit |c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==IDENTIFIER) ) {
                int LA75_1 = input.LA(2);

                if ( (LA75_1==24) ) {
                    int LA75_2 = input.LA(3);

                    if ( (LA75_2==IDENTIFIER) ) {
                        alt75=1;
                    }
                    else if ( (LA75_2==DATA_TYPE) ) {
                        alt75=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1 :
                    // Morel.g:7545:2: c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_VariableWithInit6827);
                    c0=parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7546:4: c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_VariableWithInit6837);
                    c1=parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit();

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
            if ( state.backtracking>0 ) { memoize(input, 41, parse_edu_ustb_sei_mde_morel_VariableWithInit_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_VariableWithInit"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Expression"
    // Morel.g:7550:1: parse_edu_ustb_sei_mde_morel_Expression returns [edu.ustb.sei.mde.morel.Expression element = null] : (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp |c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp |c8= parse_edu_ustb_sei_mde_morel_LetExp |c9= parse_edu_ustb_sei_mde_morel_ConditionExp |c10= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp |c11= parse_edu_ustb_sei_mde_morel_BooleanOrExp |c12= parse_edu_ustb_sei_mde_morel_BooleanAndExp |c13= parse_edu_ustb_sei_mde_morel_RelationalExp |c14= parse_edu_ustb_sei_mde_morel_AdditiveExp |c15= parse_edu_ustb_sei_mde_morel_MultiplicativeExp |c16= parse_edu_ustb_sei_mde_morel_UnaryExp |c17= parse_edu_ustb_sei_mde_morel_BindExp );
    public final edu.ustb.sei.mde.morel.Expression parse_edu_ustb_sei_mde_morel_Expression() throws RecognitionException {
        edu.ustb.sei.mde.morel.Expression element =  null;

        int parse_edu_ustb_sei_mde_morel_Expression_StartIndex = input.index();

        edu.ustb.sei.mde.morel.VariableExp c0 =null;

        edu.ustb.sei.mde.morel.NestedExp c1 =null;

        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;

        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;

        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;

        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;

        edu.ustb.sei.mde.morel.UndefinedLiteralExp c6 =null;

        edu.ustb.sei.mde.morel.TypeLiteralExp c7 =null;

        edu.ustb.sei.mde.morel.LetExp c8 =null;

        edu.ustb.sei.mde.morel.ConditionExp c9 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp c10 =null;

        edu.ustb.sei.mde.morel.BooleanOrExp c11 =null;

        edu.ustb.sei.mde.morel.BooleanAndExp c12 =null;

        edu.ustb.sei.mde.morel.RelationalExp c13 =null;

        edu.ustb.sei.mde.morel.AdditiveExp c14 =null;

        edu.ustb.sei.mde.morel.MultiplicativeExp c15 =null;

        edu.ustb.sei.mde.morel.UnaryExp c16 =null;

        edu.ustb.sei.mde.morel.BindExp c17 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return element; }

            // Morel.g:7551:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp |c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp |c8= parse_edu_ustb_sei_mde_morel_LetExp |c9= parse_edu_ustb_sei_mde_morel_ConditionExp |c10= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp |c11= parse_edu_ustb_sei_mde_morel_BooleanOrExp |c12= parse_edu_ustb_sei_mde_morel_BooleanAndExp |c13= parse_edu_ustb_sei_mde_morel_RelationalExp |c14= parse_edu_ustb_sei_mde_morel_AdditiveExp |c15= parse_edu_ustb_sei_mde_morel_MultiplicativeExp |c16= parse_edu_ustb_sei_mde_morel_UnaryExp |c17= parse_edu_ustb_sei_mde_morel_BindExp )
            int alt76=18;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA76_1 = input.LA(2);

                if ( (synpred113_Morel()) ) {
                    alt76=1;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else if ( (true) ) {
                    alt76=18;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 1, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA76_2 = input.LA(2);

                if ( (synpred114_Morel()) ) {
                    alt76=2;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 2, input);

                    throw nvae;

                }
                }
                break;
            case INUMBER:
                {
                int LA76_3 = input.LA(2);

                if ( (synpred115_Morel()) ) {
                    alt76=3;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 3, input);

                    throw nvae;

                }
                }
                break;
            case RNUMBER:
                {
                int LA76_4 = input.LA(2);

                if ( (synpred116_Morel()) ) {
                    alt76=4;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 4, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA76_5 = input.LA(2);

                if ( (synpred117_Morel()) ) {
                    alt76=5;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 5, input);

                    throw nvae;

                }
                }
                break;
            case 65:
                {
                int LA76_6 = input.LA(2);

                if ( (synpred118_Morel()) ) {
                    alt76=6;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 6, input);

                    throw nvae;

                }
                }
                break;
            case 40:
                {
                int LA76_7 = input.LA(2);

                if ( (synpred118_Morel()) ) {
                    alt76=6;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 7, input);

                    throw nvae;

                }
                }
                break;
            case 52:
                {
                int LA76_8 = input.LA(2);

                if ( (synpred119_Morel()) ) {
                    alt76=7;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 8, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA76_9 = input.LA(2);

                if ( (synpred119_Morel()) ) {
                    alt76=7;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 9, input);

                    throw nvae;

                }
                }
                break;
            case DATA_TYPE:
                {
                int LA76_10 = input.LA(2);

                if ( (synpred120_Morel()) ) {
                    alt76=8;
                }
                else if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 10, input);

                    throw nvae;

                }
                }
                break;
            case 47:
                {
                alt76=9;
                }
                break;
            case 43:
                {
                alt76=10;
                }
                break;
            case 18:
                {
                int LA76_13 = input.LA(2);

                if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 13, input);

                    throw nvae;

                }
                }
                break;
            case 20:
                {
                int LA76_14 = input.LA(2);

                if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 14, input);

                    throw nvae;

                }
                }
                break;
            case 51:
                {
                int LA76_15 = input.LA(2);

                if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 15, input);

                    throw nvae;

                }
                }
                break;
            case 12:
                {
                int LA76_16 = input.LA(2);

                if ( (synpred123_Morel()) ) {
                    alt76=11;
                }
                else if ( (synpred124_Morel()) ) {
                    alt76=12;
                }
                else if ( (synpred125_Morel()) ) {
                    alt76=13;
                }
                else if ( (synpred126_Morel()) ) {
                    alt76=14;
                }
                else if ( (synpred127_Morel()) ) {
                    alt76=15;
                }
                else if ( (synpred128_Morel()) ) {
                    alt76=16;
                }
                else if ( (synpred129_Morel()) ) {
                    alt76=17;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 16, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;

            }

            switch (alt76) {
                case 1 :
                    // Morel.g:7552:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_Expression6858);
                    c0=parse_edu_ustb_sei_mde_morel_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7553:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_Expression6868);
                    c1=parse_edu_ustb_sei_mde_morel_NestedExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7554:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6878);
                    c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7555:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6888);
                    c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Morel.g:7556:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6898);
                    c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Morel.g:7557:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6908);
                    c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Morel.g:7558:4: c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6918);
                    c6=parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Morel.g:7559:4: c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6928);
                    c7=parse_edu_ustb_sei_mde_morel_TypeLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Morel.g:7560:4: c8= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_Expression6938);
                    c8=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Morel.g:7561:4: c9= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_Expression6948);
                    c9=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 11 :
                    // Morel.g:7562:4: c10= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_Expression6958);
                    c10=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c10; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 12 :
                    // Morel.g:7563:4: c11= parse_edu_ustb_sei_mde_morel_BooleanOrExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_Expression6968);
                    c11=parse_edu_ustb_sei_mde_morel_BooleanOrExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c11; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 13 :
                    // Morel.g:7564:4: c12= parse_edu_ustb_sei_mde_morel_BooleanAndExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_Expression6978);
                    c12=parse_edu_ustb_sei_mde_morel_BooleanAndExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c12; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 14 :
                    // Morel.g:7565:4: c13= parse_edu_ustb_sei_mde_morel_RelationalExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_Expression6988);
                    c13=parse_edu_ustb_sei_mde_morel_RelationalExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c13; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 15 :
                    // Morel.g:7566:4: c14= parse_edu_ustb_sei_mde_morel_AdditiveExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_Expression6998);
                    c14=parse_edu_ustb_sei_mde_morel_AdditiveExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c14; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 16 :
                    // Morel.g:7567:4: c15= parse_edu_ustb_sei_mde_morel_MultiplicativeExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_Expression7008);
                    c15=parse_edu_ustb_sei_mde_morel_MultiplicativeExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c15; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 17 :
                    // Morel.g:7568:4: c16= parse_edu_ustb_sei_mde_morel_UnaryExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_parse_edu_ustb_sei_mde_morel_Expression7018);
                    c16=parse_edu_ustb_sei_mde_morel_UnaryExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c16; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 18 :
                    // Morel.g:7569:4: c17= parse_edu_ustb_sei_mde_morel_BindExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_parse_edu_ustb_sei_mde_morel_Expression7028);
                    c17=parse_edu_ustb_sei_mde_morel_BindExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c17; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 42, parse_edu_ustb_sei_mde_morel_Expression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Expression"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild"
    // Morel.g:7573:1: parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild returns [edu.ustb.sei.mde.morel.MultiplicativeExpChild element = null] : (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp |c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp |c8= parse_edu_ustb_sei_mde_morel_UnaryExp );
    public final edu.ustb.sei.mde.morel.MultiplicativeExpChild parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild() throws RecognitionException {
        edu.ustb.sei.mde.morel.MultiplicativeExpChild element =  null;

        int parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_StartIndex = input.index();

        edu.ustb.sei.mde.morel.VariableExp c0 =null;

        edu.ustb.sei.mde.morel.NestedExp c1 =null;

        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;

        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;

        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;

        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;

        edu.ustb.sei.mde.morel.UndefinedLiteralExp c6 =null;

        edu.ustb.sei.mde.morel.TypeLiteralExp c7 =null;

        edu.ustb.sei.mde.morel.UnaryExp c8 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return element; }

            // Morel.g:7574:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp |c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp |c8= parse_edu_ustb_sei_mde_morel_UnaryExp )
            int alt77=9;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA77_1 = input.LA(2);

                if ( (synpred130_Morel()) ) {
                    alt77=1;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 1, input);

                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA77_2 = input.LA(2);

                if ( (synpred131_Morel()) ) {
                    alt77=2;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 2, input);

                    throw nvae;

                }
                }
                break;
            case INUMBER:
                {
                int LA77_3 = input.LA(2);

                if ( (synpred132_Morel()) ) {
                    alt77=3;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 3, input);

                    throw nvae;

                }
                }
                break;
            case RNUMBER:
                {
                int LA77_4 = input.LA(2);

                if ( (synpred133_Morel()) ) {
                    alt77=4;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 4, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA77_5 = input.LA(2);

                if ( (synpred134_Morel()) ) {
                    alt77=5;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 5, input);

                    throw nvae;

                }
                }
                break;
            case 65:
                {
                int LA77_6 = input.LA(2);

                if ( (synpred135_Morel()) ) {
                    alt77=6;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 6, input);

                    throw nvae;

                }
                }
                break;
            case 40:
                {
                int LA77_7 = input.LA(2);

                if ( (synpred135_Morel()) ) {
                    alt77=6;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 7, input);

                    throw nvae;

                }
                }
                break;
            case 52:
                {
                int LA77_8 = input.LA(2);

                if ( (synpred136_Morel()) ) {
                    alt77=7;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 8, input);

                    throw nvae;

                }
                }
                break;
            case 46:
                {
                int LA77_9 = input.LA(2);

                if ( (synpred136_Morel()) ) {
                    alt77=7;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 9, input);

                    throw nvae;

                }
                }
                break;
            case DATA_TYPE:
                {
                int LA77_10 = input.LA(2);

                if ( (synpred137_Morel()) ) {
                    alt77=8;
                }
                else if ( (true) ) {
                    alt77=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 10, input);

                    throw nvae;

                }
                }
                break;
            case 12:
            case 18:
            case 20:
            case 51:
                {
                alt77=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;

            }

            switch (alt77) {
                case 1 :
                    // Morel.g:7575:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7049);
                    c0=parse_edu_ustb_sei_mde_morel_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7576:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7059);
                    c1=parse_edu_ustb_sei_mde_morel_NestedExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7577:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7069);
                    c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7578:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7079);
                    c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Morel.g:7579:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7089);
                    c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Morel.g:7580:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7099);
                    c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Morel.g:7581:4: c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7109);
                    c6=parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Morel.g:7582:4: c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7119);
                    c7=parse_edu_ustb_sei_mde_morel_TypeLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Morel.g:7583:4: c8= parse_edu_ustb_sei_mde_morel_UnaryExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7129);
                    c8=parse_edu_ustb_sei_mde_morel_UnaryExp();

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
            if ( state.backtracking>0 ) { memoize(input, 43, parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_AtomicExp"
    // Morel.g:7587:1: parse_edu_ustb_sei_mde_morel_AtomicExp returns [edu.ustb.sei.mde.morel.AtomicExp element = null] : (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp |c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp );
    public final edu.ustb.sei.mde.morel.AtomicExp parse_edu_ustb_sei_mde_morel_AtomicExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.AtomicExp element =  null;

        int parse_edu_ustb_sei_mde_morel_AtomicExp_StartIndex = input.index();

        edu.ustb.sei.mde.morel.VariableExp c0 =null;

        edu.ustb.sei.mde.morel.NestedExp c1 =null;

        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;

        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;

        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;

        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;

        edu.ustb.sei.mde.morel.UndefinedLiteralExp c6 =null;

        edu.ustb.sei.mde.morel.TypeLiteralExp c7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return element; }

            // Morel.g:7588:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp |c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp )
            int alt78=8;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt78=1;
                }
                break;
            case 15:
                {
                alt78=2;
                }
                break;
            case INUMBER:
                {
                alt78=3;
                }
                break;
            case RNUMBER:
                {
                alt78=4;
                }
                break;
            case QUOTED_39_39_92:
                {
                alt78=5;
                }
                break;
            case 40:
            case 65:
                {
                alt78=6;
                }
                break;
            case 46:
            case 52:
                {
                alt78=7;
                }
                break;
            case DATA_TYPE:
                {
                alt78=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }

            switch (alt78) {
                case 1 :
                    // Morel.g:7589:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7150);
                    c0=parse_edu_ustb_sei_mde_morel_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7590:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7160);
                    c1=parse_edu_ustb_sei_mde_morel_NestedExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7591:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7170);
                    c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7592:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7180);
                    c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Morel.g:7593:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7190);
                    c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Morel.g:7594:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7200);
                    c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Morel.g:7595:4: c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7210);
                    c6=parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Morel.g:7596:4: c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7220);
                    c7=parse_edu_ustb_sei_mde_morel_TypeLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 44, parse_edu_ustb_sei_mde_morel_AtomicExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_AtomicExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_ImperativeStatement"
    // Morel.g:7600:1: parse_edu_ustb_sei_mde_morel_ImperativeStatement returns [edu.ustb.sei.mde.morel.ImperativeStatement element = null] : (c0= parse_edu_ustb_sei_mde_morel_IfStatement |c1= parse_edu_ustb_sei_mde_morel_ForStatement |c2= parse_edu_ustb_sei_mde_morel_BlockStatement );
    public final edu.ustb.sei.mde.morel.ImperativeStatement parse_edu_ustb_sei_mde_morel_ImperativeStatement() throws RecognitionException {
        edu.ustb.sei.mde.morel.ImperativeStatement element =  null;

        int parse_edu_ustb_sei_mde_morel_ImperativeStatement_StartIndex = input.index();

        edu.ustb.sei.mde.morel.IfStatement c0 =null;

        edu.ustb.sei.mde.morel.ForStatement c1 =null;

        edu.ustb.sei.mde.morel.BlockStatement c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return element; }

            // Morel.g:7601:2: (c0= parse_edu_ustb_sei_mde_morel_IfStatement |c1= parse_edu_ustb_sei_mde_morel_ForStatement |c2= parse_edu_ustb_sei_mde_morel_BlockStatement )
            int alt79=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt79=1;
                }
                break;
            case 41:
                {
                alt79=2;
                }
                break;
            case 68:
                {
                alt79=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }

            switch (alt79) {
                case 1 :
                    // Morel.g:7602:2: c0= parse_edu_ustb_sei_mde_morel_IfStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement7241);
                    c0=parse_edu_ustb_sei_mde_morel_IfStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7603:4: c1= parse_edu_ustb_sei_mde_morel_ForStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ForStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement7251);
                    c1=parse_edu_ustb_sei_mde_morel_ForStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7604:4: c2= parse_edu_ustb_sei_mde_morel_BlockStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BlockStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement7261);
                    c2=parse_edu_ustb_sei_mde_morel_BlockStatement();

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
            if ( state.backtracking>0 ) { memoize(input, 45, parse_edu_ustb_sei_mde_morel_ImperativeStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_ImperativeStatement"

    // $ANTLR start synpred80_Morel
    public final void synpred80_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BindExp a0_0 =null;


        // Morel.g:6033:3: (a0_0= parse_edu_ustb_sei_mde_morel_BindExp )
        // Morel.g:6033:3: a0_0= parse_edu_ustb_sei_mde_morel_BindExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_synpred80_Morel5132);
        a0_0=parse_edu_ustb_sei_mde_morel_BindExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred80_Morel

    // $ANTLR start synpred83_Morel
    public final void synpred83_Morel_fragment() throws RecognitionException {
        Token a5=null;
        edu.ustb.sei.mde.morel.ImperativeStatement a6_0 =null;


        // Morel.g:6273:3: ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )
        // Morel.g:6273:3: (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
        {
        // Morel.g:6273:3: (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
        // Morel.g:6274:4: a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
        {
        a5=(Token)match(input,37,FOLLOW_37_in_synpred83_Morel5316); if (state.failed) return ;

        // Morel.g:6290:4: (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
        // Morel.g:6291:5: a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_synpred83_Morel5342);
        a6_0=parse_edu_ustb_sei_mde_morel_ImperativeStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }

    }
    // $ANTLR end synpred83_Morel

    // $ANTLR start synpred104_Morel
    public final void synpred104_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.ObjectVariable c0 =null;


        // Morel.g:7519:2: (c0= parse_edu_ustb_sei_mde_morel_ObjectVariable )
        // Morel.g:7519:2: c0= parse_edu_ustb_sei_mde_morel_ObjectVariable
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariable_in_synpred104_Morel6684);
        c0=parse_edu_ustb_sei_mde_morel_ObjectVariable();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred104_Morel

    // $ANTLR start synpred105_Morel
    public final void synpred105_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.PrimitiveVariable c1 =null;


        // Morel.g:7520:4: (c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable )
        // Morel.g:7520:4: c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariable_in_synpred105_Morel6694);
        c1=parse_edu_ustb_sei_mde_morel_PrimitiveVariable();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred105_Morel

    // $ANTLR start synpred106_Morel
    public final void synpred106_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.ObjectVariableWithInit c2 =null;


        // Morel.g:7521:4: (c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit )
        // Morel.g:7521:4: c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_synpred106_Morel6704);
        c2=parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred106_Morel

    // $ANTLR start synpred107_Morel
    public final void synpred107_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.DeclarativeStatement c0 =null;


        // Morel.g:7528:2: (c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement )
        // Morel.g:7528:2: c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_DeclarativeStatement_in_synpred107_Morel6735);
        c0=parse_edu_ustb_sei_mde_morel_DeclarativeStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred107_Morel

    // $ANTLR start synpred108_Morel
    public final void synpred108_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.IfStatement c1 =null;


        // Morel.g:7529:4: (c1= parse_edu_ustb_sei_mde_morel_IfStatement )
        // Morel.g:7529:4: c1= parse_edu_ustb_sei_mde_morel_IfStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_synpred108_Morel6745);
        c1=parse_edu_ustb_sei_mde_morel_IfStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred108_Morel

    // $ANTLR start synpred113_Morel
    public final void synpred113_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.VariableExp c0 =null;


        // Morel.g:7552:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp )
        // Morel.g:7552:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_synpred113_Morel6858);
        c0=parse_edu_ustb_sei_mde_morel_VariableExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred113_Morel

    // $ANTLR start synpred114_Morel
    public final void synpred114_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.NestedExp c1 =null;


        // Morel.g:7553:4: (c1= parse_edu_ustb_sei_mde_morel_NestedExp )
        // Morel.g:7553:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_synpred114_Morel6868);
        c1=parse_edu_ustb_sei_mde_morel_NestedExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred114_Morel

    // $ANTLR start synpred115_Morel
    public final void synpred115_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;


        // Morel.g:7554:4: (c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp )
        // Morel.g:7554:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_synpred115_Morel6878);
        c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred115_Morel

    // $ANTLR start synpred116_Morel
    public final void synpred116_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;


        // Morel.g:7555:4: (c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp )
        // Morel.g:7555:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_synpred116_Morel6888);
        c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred116_Morel

    // $ANTLR start synpred117_Morel
    public final void synpred117_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;


        // Morel.g:7556:4: (c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp )
        // Morel.g:7556:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_synpred117_Morel6898);
        c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred117_Morel

    // $ANTLR start synpred118_Morel
    public final void synpred118_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;


        // Morel.g:7557:4: (c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp )
        // Morel.g:7557:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_synpred118_Morel6908);
        c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred118_Morel

    // $ANTLR start synpred119_Morel
    public final void synpred119_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.UndefinedLiteralExp c6 =null;


        // Morel.g:7558:4: (c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp )
        // Morel.g:7558:4: c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_synpred119_Morel6918);
        c6=parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_Morel

    // $ANTLR start synpred120_Morel
    public final void synpred120_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.TypeLiteralExp c7 =null;


        // Morel.g:7559:4: (c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp )
        // Morel.g:7559:4: c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_synpred120_Morel6928);
        c7=parse_edu_ustb_sei_mde_morel_TypeLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred120_Morel

    // $ANTLR start synpred123_Morel
    public final void synpred123_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanImpliesExp c10 =null;


        // Morel.g:7562:4: (c10= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
        // Morel.g:7562:4: c10= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_synpred123_Morel6958);
        c10=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred123_Morel

    // $ANTLR start synpred124_Morel
    public final void synpred124_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanOrExp c11 =null;


        // Morel.g:7563:4: (c11= parse_edu_ustb_sei_mde_morel_BooleanOrExp )
        // Morel.g:7563:4: c11= parse_edu_ustb_sei_mde_morel_BooleanOrExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_synpred124_Morel6968);
        c11=parse_edu_ustb_sei_mde_morel_BooleanOrExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred124_Morel

    // $ANTLR start synpred125_Morel
    public final void synpred125_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanAndExp c12 =null;


        // Morel.g:7564:4: (c12= parse_edu_ustb_sei_mde_morel_BooleanAndExp )
        // Morel.g:7564:4: c12= parse_edu_ustb_sei_mde_morel_BooleanAndExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_synpred125_Morel6978);
        c12=parse_edu_ustb_sei_mde_morel_BooleanAndExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred125_Morel

    // $ANTLR start synpred126_Morel
    public final void synpred126_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.RelationalExp c13 =null;


        // Morel.g:7565:4: (c13= parse_edu_ustb_sei_mde_morel_RelationalExp )
        // Morel.g:7565:4: c13= parse_edu_ustb_sei_mde_morel_RelationalExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_synpred126_Morel6988);
        c13=parse_edu_ustb_sei_mde_morel_RelationalExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred126_Morel

    // $ANTLR start synpred127_Morel
    public final void synpred127_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.AdditiveExp c14 =null;


        // Morel.g:7566:4: (c14= parse_edu_ustb_sei_mde_morel_AdditiveExp )
        // Morel.g:7566:4: c14= parse_edu_ustb_sei_mde_morel_AdditiveExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_synpred127_Morel6998);
        c14=parse_edu_ustb_sei_mde_morel_AdditiveExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred127_Morel

    // $ANTLR start synpred128_Morel
    public final void synpred128_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.MultiplicativeExp c15 =null;


        // Morel.g:7567:4: (c15= parse_edu_ustb_sei_mde_morel_MultiplicativeExp )
        // Morel.g:7567:4: c15= parse_edu_ustb_sei_mde_morel_MultiplicativeExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_synpred128_Morel7008);
        c15=parse_edu_ustb_sei_mde_morel_MultiplicativeExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred128_Morel

    // $ANTLR start synpred129_Morel
    public final void synpred129_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.UnaryExp c16 =null;


        // Morel.g:7568:4: (c16= parse_edu_ustb_sei_mde_morel_UnaryExp )
        // Morel.g:7568:4: c16= parse_edu_ustb_sei_mde_morel_UnaryExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_synpred129_Morel7018);
        c16=parse_edu_ustb_sei_mde_morel_UnaryExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred129_Morel

    // $ANTLR start synpred130_Morel
    public final void synpred130_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.VariableExp c0 =null;


        // Morel.g:7575:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp )
        // Morel.g:7575:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_synpred130_Morel7049);
        c0=parse_edu_ustb_sei_mde_morel_VariableExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred130_Morel

    // $ANTLR start synpred131_Morel
    public final void synpred131_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.NestedExp c1 =null;


        // Morel.g:7576:4: (c1= parse_edu_ustb_sei_mde_morel_NestedExp )
        // Morel.g:7576:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_synpred131_Morel7059);
        c1=parse_edu_ustb_sei_mde_morel_NestedExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred131_Morel

    // $ANTLR start synpred132_Morel
    public final void synpred132_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;


        // Morel.g:7577:4: (c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp )
        // Morel.g:7577:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_synpred132_Morel7069);
        c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_Morel

    // $ANTLR start synpred133_Morel
    public final void synpred133_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;


        // Morel.g:7578:4: (c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp )
        // Morel.g:7578:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_synpred133_Morel7079);
        c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_Morel

    // $ANTLR start synpred134_Morel
    public final void synpred134_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;


        // Morel.g:7579:4: (c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp )
        // Morel.g:7579:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_synpred134_Morel7089);
        c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred134_Morel

    // $ANTLR start synpred135_Morel
    public final void synpred135_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;


        // Morel.g:7580:4: (c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp )
        // Morel.g:7580:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_synpred135_Morel7099);
        c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred135_Morel

    // $ANTLR start synpred136_Morel
    public final void synpred136_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.UndefinedLiteralExp c6 =null;


        // Morel.g:7581:4: (c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp )
        // Morel.g:7581:4: c6= parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_synpred136_Morel7109);
        c6=parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred136_Morel

    // $ANTLR start synpred137_Morel
    public final void synpred137_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.TypeLiteralExp c7 =null;


        // Morel.g:7582:4: (c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp )
        // Morel.g:7582:4: c7= parse_edu_ustb_sei_mde_morel_TypeLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_synpred137_Morel7119);
        c7=parse_edu_ustb_sei_mde_morel_TypeLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred137_Morel

    // Delegated rules

    public final boolean synpred104_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred129_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred129_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred130_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred136_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred118_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred123_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred123_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred133_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred131_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred131_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred125_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_QueryModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TransformationModel_in_start96 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_parse_edu_ustb_sei_mde_morel_QueryModel129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypedModel_in_parse_edu_ustb_sei_mde_morel_QueryModel152 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Query_in_parse_edu_ustb_sei_mde_morel_QueryModel187 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_TypedModel228 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_TypedModel246 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_edu_ustb_sei_mde_morel_TypedModel267 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_URINS_in_parse_edu_ustb_sei_mde_morel_TypedModel285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_parse_edu_ustb_sei_mde_morel_Query321 = new BitSet(new long[]{0x11C5000000000020L});
    public static final BitSet FOLLOW_48_in_parse_edu_ustb_sei_mde_morel_Query344 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_60_in_parse_edu_ustb_sei_mde_morel_Query359 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_50_in_parse_edu_ustb_sei_mde_morel_Query374 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_54_in_parse_edu_ustb_sei_mde_morel_Query389 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_56_in_parse_edu_ustb_sei_mde_morel_Query404 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_55_in_parse_edu_ustb_sei_mde_morel_Query419 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_Query444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_parse_edu_ustb_sei_mde_morel_Query465 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_parse_edu_ustb_sei_mde_morel_Query479 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Query493 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000088L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Query522 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_Query563 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Query597 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_Query658 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000088L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Query706 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_Query747 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Query781 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_Query842 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000088L});
    public static final BitSet FOLLOW_67_in_parse_edu_ustb_sei_mde_morel_Query884 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Query904 = new BitSet(new long[]{0x0018CB0000149370L,0x0000000000000012L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_Query945 = new BitSet(new long[]{0x0018CB0000149370L,0x0000000000000092L});
    public static final BitSet FOLLOW_71_in_parse_edu_ustb_sei_mde_morel_Query1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1052 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1073 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1102 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1135 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1227 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1321 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1342 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1371 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1404 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1441 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1462 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1545 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1584 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1605 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1688 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1709 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1727 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1748 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_VariableExp1806 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_VariableExp1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_NestedExp1898 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1916 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1930 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1944 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_NestedExp1962 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INUMBER_in_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp2051 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RNUMBER_in_parse_edu_ustb_sei_mde_morel_RealLiteralExp2147 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_RealLiteralExp2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_morel_StringLiteralExp2243 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_StringLiteralExp2279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2344 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_40_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2359 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp2460 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_46_in_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp2475 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_TypeLiteralExp2571 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_TypeLiteralExp2607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2663 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2681 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2761 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2776 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2801 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2822 = new BitSet(new long[]{0x0018C90000159370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2851 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2871 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2891 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2932 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2966 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2992 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp3018 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_OperationPathExp3092 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3156 = new BitSet(new long[]{0x4800049800000000L});
    public static final BitSet FOLLOW_42_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3179 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_39_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3194 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_62_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3209 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_59_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3224 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_36_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3239 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3254 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3275 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3293 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000020L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3320 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3387 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3405 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3419 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3433 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3451 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_parse_edu_ustb_sei_mde_morel_LetExp3536 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_LetExp3554 = new BitSet(new long[]{0x0000200000080000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_LetExp3581 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_LetExp3607 = new BitSet(new long[]{0x0000200000080000L});
    public static final BitSet FOLLOW_45_in_parse_edu_ustb_sei_mde_morel_LetExp3648 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_LetExp3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_LetExp3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_LetExp3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_edu_ustb_sei_mde_morel_ConditionExp3727 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ConditionExp3745 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_parse_edu_ustb_sei_mde_morel_ConditionExp3763 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Expression_in_parse_edu_ustb_sei_mde_morel_ConditionExp3781 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_edu_ustb_sei_mde_morel_ConditionExp3799 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Expression_in_parse_edu_ustb_sei_mde_morel_ConditionExp3817 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_parse_edu_ustb_sei_mde_morel_ConditionExp3835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3868 = new BitSet(new long[]{0x0000100080000002L});
    public static final BitSet FOLLOW_44_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3908 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3927 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp4024 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_53_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp4064 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp4083 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp4120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp4180 = new BitSet(new long[]{0x0000000400004002L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp4220 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp4239 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_RelationalExp4336 = new BitSet(new long[]{0x0000000374002002L});
    public static final BitSet FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_RelationalExp4376 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_RelationalExp4395 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_edu_ustb_sei_mde_morel_RelationalExp4414 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_morel_RelationalExp4433 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_morel_RelationalExp4452 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_edu_ustb_sei_mde_morel_RelationalExp4471 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_edu_ustb_sei_mde_morel_RelationalExp4490 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_RelationalExp4527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4587 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4627 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4646 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4683 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4743 = new BitSet(new long[]{0x0000000000820002L});
    public static final BitSet FOLLOW_17_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4783 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4802 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4839 = new BitSet(new long[]{0x0000000000820002L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_UnaryExp4910 = new BitSet(new long[]{0x0010410000008370L,0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_morel_UnaryExp4927 = new BitSet(new long[]{0x0010410000008370L,0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_parse_edu_ustb_sei_mde_morel_UnaryExp4944 = new BitSet(new long[]{0x0010410000008370L,0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_UnaryExp4961 = new BitSet(new long[]{0x0010410000008370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AtomicExp_in_parse_edu_ustb_sei_mde_morel_UnaryExp4994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_BindExp5031 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_edu_ustb_sei_mde_morel_BindExp5049 = new BitSet(new long[]{0x0018C90000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_BindExp5067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_BindExp5081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_BindExp5095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5132 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5146 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5160 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5174 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_edu_ustb_sei_mde_morel_IfStatement5221 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_IfStatement5235 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_IfStatement5253 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_IfStatement5271 = new BitSet(new long[]{0x00000A0000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_IfStatement5289 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_parse_edu_ustb_sei_mde_morel_IfStatement5316 = new BitSet(new long[]{0x00000A0000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_IfStatement5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_edu_ustb_sei_mde_morel_ForStatement5398 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_ForStatement5412 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_ForStatement5430 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_ForStatement5448 = new BitSet(new long[]{0x0018410000149370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5466 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_ForStatement5484 = new BitSet(new long[]{0x0018C90000159370L,0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5513 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5533 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5553 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_ForStatement5594 = new BitSet(new long[]{0x00000A0000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_ForStatement5612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_parse_edu_ustb_sei_mde_morel_BlockStatement5645 = new BitSet(new long[]{0x0018CB0000149370L,0x0000000000000092L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_BlockStatement5668 = new BitSet(new long[]{0x0018CB0000149370L,0x0000000000000092L});
    public static final BitSet FOLLOW_71_in_parse_edu_ustb_sei_mde_morel_BlockStatement5694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_TransformationModel5723 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_TransformationModel5741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypedModel_in_parse_edu_ustb_sei_mde_morel_TransformationModel5771 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Rule_in_parse_edu_ustb_sei_mde_morel_TransformationModel5806 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_parse_edu_ustb_sei_mde_morel_Rule5847 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_Rule5865 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_parse_edu_ustb_sei_mde_morel_Rule5886 = new BitSet(new long[]{0x13C5000000000000L,0x0000000000000090L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Pattern_in_parse_edu_ustb_sei_mde_morel_Rule5915 = new BitSet(new long[]{0x13C5000000000000L,0x0000000000000090L});
    public static final BitSet FOLLOW_71_in_parse_edu_ustb_sei_mde_morel_Rule5956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_parse_edu_ustb_sei_mde_morel_Pattern5994 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_60_in_parse_edu_ustb_sei_mde_morel_Pattern6009 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_50_in_parse_edu_ustb_sei_mde_morel_Pattern6024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_54_in_parse_edu_ustb_sei_mde_morel_Pattern6039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_56_in_parse_edu_ustb_sei_mde_morel_Pattern6054 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_55_in_parse_edu_ustb_sei_mde_morel_Pattern6069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_parse_edu_ustb_sei_mde_morel_Pattern6090 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_parse_edu_ustb_sei_mde_morel_Pattern6104 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Pattern6118 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000088L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Pattern6147 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_Pattern6188 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Pattern6222 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_Pattern6283 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000088L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Pattern6331 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_Pattern6372 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Pattern6406 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_Pattern6467 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000088L});
    public static final BitSet FOLLOW_67_in_parse_edu_ustb_sei_mde_morel_Pattern6509 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Pattern6529 = new BitSet(new long[]{0x0018CB0000149370L,0x0000000000000012L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_Pattern6570 = new BitSet(new long[]{0x0018CB0000149370L,0x0000000000000092L});
    public static final BitSet FOLLOW_71_in_parse_edu_ustb_sei_mde_morel_Pattern6644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Query_in_parse_edu_ustb_sei_mde_morel_Pattern6663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariable_in_parse_edu_ustb_sei_mde_morel_Variable6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariable_in_parse_edu_ustb_sei_mde_morel_Variable6694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_Variable6704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_Variable6714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_DeclarativeStatement_in_parse_edu_ustb_sei_mde_morel_Statement6735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_parse_edu_ustb_sei_mde_morel_Statement6745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ForStatement_in_parse_edu_ustb_sei_mde_morel_Statement6755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BlockStatement_in_parse_edu_ustb_sei_mde_morel_Statement6765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_FeaturePathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_OperationPathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IteratorPathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_VariableWithInit6827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_VariableWithInit6837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_Expression6858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_Expression6868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_Expression6938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_Expression6948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_Expression6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_Expression6968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_Expression6978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_Expression6988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_Expression6998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_Expression7008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_parse_edu_ustb_sei_mde_morel_Expression7018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_parse_edu_ustb_sei_mde_morel_Expression7028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild7129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp7220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement7241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ForStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement7251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BlockStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement7261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_synpred80_Morel5132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred83_Morel5316 = new BitSet(new long[]{0x00000A0000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_synpred83_Morel5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariable_in_synpred104_Morel6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariable_in_synpred105_Morel6694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_synpred106_Morel6704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_DeclarativeStatement_in_synpred107_Morel6735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_synpred108_Morel6745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_synpred113_Morel6858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_synpred114_Morel6868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_synpred115_Morel6878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_synpred116_Morel6888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_synpred117_Morel6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_synpred118_Morel6908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_synpred119_Morel6918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_synpred120_Morel6928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_synpred123_Morel6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_synpred124_Morel6968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_synpred125_Morel6978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_synpred126_Morel6988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_synpred127_Morel6998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_synpred128_Morel7008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_synpred129_Morel7018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_synpred130_Morel7049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_synpred131_Morel7059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_synpred132_Morel7069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_synpred133_Morel7079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_synpred134_Morel7089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_synpred135_Morel7099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UndefinedLiteralExp_in_synpred136_Morel7109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypeLiteralExp_in_synpred137_Morel7119 = new BitSet(new long[]{0x0000000000000002L});

}