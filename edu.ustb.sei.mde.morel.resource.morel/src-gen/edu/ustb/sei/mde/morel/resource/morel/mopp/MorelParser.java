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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATA_TYPE", "IDENTIFIER", "INUMBER", "LINEBREAK", "QUOTED_39_39_92", "RNUMBER", "URINS", "WHITESPACE", "'!'", "'!='", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "':'", "';'", "'<'", "'<-'", "'<='", "'<>'", "'='", "'>'", "'>='", "'and'", "'closure'", "'collect'", "'else'", "'endif'", "'exists'", "'false'", "'for'", "'forAll'", "'if'", "'implies'", "'in'", "'let'", "'lhs'", "'match'", "'nac'", "'not'", "'or'", "'pac'", "'post'", "'pre'", "'query'", "'querymodel'", "'reject'", "'rhs'", "'rule'", "'select'", "'then'", "'transformation'", "'true'", "'type'", "'when'", "'{'", "'|'", "'}'"
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
        this.state.initializeRuleMemo(175 + 1);
         

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
    		int followSetID = 202;
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
    // Morel.g:598:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_edu_ustb_sei_mde_morel_QueryModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        edu.ustb.sei.mde.morel.QueryModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Morel.g:599:2: ( (c0= parse_edu_ustb_sei_mde_morel_QueryModel ) EOF )
            // Morel.g:600:2: (c0= parse_edu_ustb_sei_mde_morel_QueryModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Morel.g:605:2: (c0= parse_edu_ustb_sei_mde_morel_QueryModel )
            // Morel.g:606:3: c0= parse_edu_ustb_sei_mde_morel_QueryModel
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_QueryModel_in_start82);
            c0=parse_edu_ustb_sei_mde_morel_QueryModel();

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



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_QueryModel"
    // Morel.g:614:1: parse_edu_ustb_sei_mde_morel_QueryModel returns [edu.ustb.sei.mde.morel.QueryModel element = null] : a0= 'querymodel' ( (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a2_0= parse_edu_ustb_sei_mde_morel_Query ) )* ;
    public final edu.ustb.sei.mde.morel.QueryModel parse_edu_ustb_sei_mde_morel_QueryModel() throws RecognitionException {
        edu.ustb.sei.mde.morel.QueryModel element =  null;

        int parse_edu_ustb_sei_mde_morel_QueryModel_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.TypedModel a1_0 =null;

        edu.ustb.sei.mde.morel.Query a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Morel.g:617:2: (a0= 'querymodel' ( (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a2_0= parse_edu_ustb_sei_mde_morel_Query ) )* )
            // Morel.g:618:2: a0= 'querymodel' ( (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a2_0= parse_edu_ustb_sei_mde_morel_Query ) )*
            {
            a0=(Token)match(input,54,FOLLOW_54_in_parse_edu_ustb_sei_mde_morel_QueryModel115); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1]);
            	}

            // Morel.g:632:2: ( (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==62) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Morel.g:633:3: (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel )
            	    {
            	    // Morel.g:633:3: (a1_0= parse_edu_ustb_sei_mde_morel_TypedModel )
            	    // Morel.g:634:4: a1_0= parse_edu_ustb_sei_mde_morel_TypedModel
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypedModel_in_parse_edu_ustb_sei_mde_morel_QueryModel138);
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
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[3]);
            	}

            // Morel.g:661:2: ( (a2_0= parse_edu_ustb_sei_mde_morel_Query ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==53) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Morel.g:662:3: (a2_0= parse_edu_ustb_sei_mde_morel_Query )
            	    {
            	    // Morel.g:662:3: (a2_0= parse_edu_ustb_sei_mde_morel_Query )
            	    // Morel.g:663:4: a2_0= parse_edu_ustb_sei_mde_morel_Query
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Query_in_parse_edu_ustb_sei_mde_morel_QueryModel173);
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
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[4]);
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
    // Morel.g:691:1: parse_edu_ustb_sei_mde_morel_TypedModel returns [edu.ustb.sei.mde.morel.TypedModel element = null] : a0= 'type' (a1= IDENTIFIER ) a2= '<-' (a3= URINS ) ;
    public final edu.ustb.sei.mde.morel.TypedModel parse_edu_ustb_sei_mde_morel_TypedModel() throws RecognitionException {
        edu.ustb.sei.mde.morel.TypedModel element =  null;

        int parse_edu_ustb_sei_mde_morel_TypedModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Morel.g:694:2: (a0= 'type' (a1= IDENTIFIER ) a2= '<-' (a3= URINS ) )
            // Morel.g:695:2: a0= 'type' (a1= IDENTIFIER ) a2= '<-' (a3= URINS )
            {
            a0=(Token)match(input,62,FOLLOW_62_in_parse_edu_ustb_sei_mde_morel_TypedModel214); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[5]);
            	}

            // Morel.g:709:2: (a1= IDENTIFIER )
            // Morel.g:710:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_TypedModel232); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[6]);
            	}

            a2=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_morel_TypedModel253); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[7]);
            	}

            // Morel.g:759:2: (a3= URINS )
            // Morel.g:760:3: a3= URINS
            {
            a3=(Token)match(input,URINS,FOLLOW_URINS_in_parse_edu_ustb_sei_mde_morel_TypedModel271); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[10]);
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
    // Morel.g:803:1: parse_edu_ustb_sei_mde_morel_Query returns [edu.ustb.sei.mde.morel.Query element = null] : a0= 'query' ( (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )? ) (a9= IDENTIFIER ) a10= '{' a11= 'match' a12= ':' ( ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' ) )? ( ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' ) )? ( (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a24= '}' ;
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

            // Morel.g:806:2: (a0= 'query' ( (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )? ) (a9= IDENTIFIER ) a10= '{' a11= 'match' a12= ':' ( ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' ) )? ( ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' ) )? ( (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a24= '}' )
            // Morel.g:807:2: a0= 'query' ( (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )? ) (a9= IDENTIFIER ) a10= '{' a11= 'match' a12= ':' ( ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' ) )? ( ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' ) )? ( (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a24= '}'
            {
            a0=(Token)match(input,53,FOLLOW_53_in_parse_edu_ustb_sei_mde_morel_Query307); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[11]);
            	}

            // Morel.g:824:2: ( (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )? )
            // Morel.g:825:3: (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )?
            {
            // Morel.g:825:3: (a1= 'lhs' |a2= 'rhs' |a3= 'nac' |a4= 'pac' |a5= 'pre' |a6= 'post' )?
            int alt3=7;
            switch ( input.LA(1) ) {
                case 45:
                    {
                    alt3=1;
                    }
                    break;
                case 56:
                    {
                    alt3=2;
                    }
                    break;
                case 47:
                    {
                    alt3=3;
                    }
                    break;
                case 50:
                    {
                    alt3=4;
                    }
                    break;
                case 52:
                    {
                    alt3=5;
                    }
                    break;
                case 51:
                    {
                    alt3=6;
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // Morel.g:826:4: a1= 'lhs'
                    {
                    a1=(Token)match(input,45,FOLLOW_45_in_parse_edu_ustb_sei_mde_morel_Query330); if (state.failed) return element;

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
                    // Morel.g:842:8: a2= 'rhs'
                    {
                    a2=(Token)match(input,56,FOLLOW_56_in_parse_edu_ustb_sei_mde_morel_Query345); if (state.failed) return element;

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
                    // Morel.g:858:8: a3= 'nac'
                    {
                    a3=(Token)match(input,47,FOLLOW_47_in_parse_edu_ustb_sei_mde_morel_Query360); if (state.failed) return element;

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
                    // Morel.g:874:8: a4= 'pac'
                    {
                    a4=(Token)match(input,50,FOLLOW_50_in_parse_edu_ustb_sei_mde_morel_Query375); if (state.failed) return element;

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
                    // Morel.g:890:8: a5= 'pre'
                    {
                    a5=(Token)match(input,52,FOLLOW_52_in_parse_edu_ustb_sei_mde_morel_Query390); if (state.failed) return element;

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
                    // Morel.g:906:8: a6= 'post'
                    {
                    a6=(Token)match(input,51,FOLLOW_51_in_parse_edu_ustb_sei_mde_morel_Query405); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[12]);
            	}

            // Morel.g:928:2: (a9= IDENTIFIER )
            // Morel.g:929:3: a9= IDENTIFIER
            {
            a9=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_Query430); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[13]);
            	}

            a10=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_Query451); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[14]);
            	}

            a11=(Token)match(input,46,FOLLOW_46_in_parse_edu_ustb_sei_mde_morel_Query465); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[15]);
            	}

            a12=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_Query479); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[16]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[22]);
            	}

            // Morel.g:1024:2: ( ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENTIFIER) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==23) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // Morel.g:1025:3: ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' )
                    {
                    // Morel.g:1025:3: ( (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';' )
                    // Morel.g:1026:4: (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a16= ';'
                    {
                    // Morel.g:1026:4: (a13_0= parse_edu_ustb_sei_mde_morel_Variable )
                    // Morel.g:1027:5: a13_0= parse_edu_ustb_sei_mde_morel_Variable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Query508);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[23]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[24]);
                    			}

                    // Morel.g:1056:4: ( (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==18) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Morel.g:1057:5: (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                    	    {
                    	    // Morel.g:1057:5: (a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                    	    // Morel.g:1058:6: a14= ',' (a15_0= parse_edu_ustb_sei_mde_morel_Variable )
                    	    {
                    	    a14=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_Query549); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[25]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[26]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[27]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[28]);
                    	    					}

                    	    // Morel.g:1078:6: (a15_0= parse_edu_ustb_sei_mde_morel_Variable )
                    	    // Morel.g:1079:7: a15_0= parse_edu_ustb_sei_mde_morel_Variable
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Query583);
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[29]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[30]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[31]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[32]);
                    			}

                    a16=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Query644); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[33]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[34]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[35]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[38]);
            	}

            // Morel.g:1144:2: ( ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDENTIFIER) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Morel.g:1145:3: ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' )
                    {
                    // Morel.g:1145:3: ( (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';' )
                    // Morel.g:1146:4: (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a20= ';'
                    {
                    // Morel.g:1146:4: (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                    // Morel.g:1147:5: a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Query692);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[39]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[40]);
                    			}

                    // Morel.g:1176:4: ( (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==18) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Morel.g:1177:5: (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) )
                    	    {
                    	    // Morel.g:1177:5: (a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) )
                    	    // Morel.g:1178:6: a18= ',' (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                    	    {
                    	    a18=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_Query733); if (state.failed) return element;

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
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[41]);
                    	    					}

                    	    // Morel.g:1195:6: (a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                    	    // Morel.g:1196:7: a19_0= parse_edu_ustb_sei_mde_morel_LinkConstraint
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Query767);
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
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[42]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[43]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[44]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[45]);
                    			}

                    a20=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Query828); if (state.failed) return element;

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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[46]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[47]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[49]);
            	}

            // Morel.g:1259:2: ( (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==63) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Morel.g:1260:3: (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ )
                    {
                    // Morel.g:1260:3: (a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ )
                    // Morel.g:1261:4: a21= 'when' a22= ':' ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+
                    {
                    a21=(Token)match(input,63,FOLLOW_63_in_parse_edu_ustb_sei_mde_morel_Query870); if (state.failed) return element;

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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[50]);
                    			}

                    a22=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_Query890); if (state.failed) return element;

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
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[51]);
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
                    			}

                    // Morel.g:1306:4: ( ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= IDENTIFIER && LA8_0 <= INUMBER)||(LA8_0 >= QUOTED_39_39_92 && LA8_0 <= RNUMBER)||LA8_0==14||LA8_0==17||LA8_0==19||(LA8_0 >= 38 && LA8_0 <= 39)||LA8_0==41||LA8_0==44||LA8_0==48||LA8_0==61||LA8_0==64) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Morel.g:1307:5: ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) )
                    	    {
                    	    // Morel.g:1307:5: ( (a23_0= parse_edu_ustb_sei_mde_morel_Statement ) )
                    	    // Morel.g:1308:6: (a23_0= parse_edu_ustb_sei_mde_morel_Statement )
                    	    {
                    	    // Morel.g:1308:6: (a23_0= parse_edu_ustb_sei_mde_morel_Statement )
                    	    // Morel.g:1309:7: a23_0= parse_edu_ustb_sei_mde_morel_Statement
                    	    {
                    	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_Query931);
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
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[63]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[64]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[65]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[66]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[67]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[68]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[69]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[70]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[71]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[72]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[73]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[74]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[75]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[76]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[77]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[78]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[79]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[80]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[81]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[82]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[83]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[84]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[85]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[86]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[87]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[88]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[89]);
            	}

            a24=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_Query1005); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[92]);
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
    // Morel.g:1396:1: parse_edu_ustb_sei_mde_morel_ObjectVariable returns [edu.ustb.sei.mde.morel.ObjectVariable element = null] : ( (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) |c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit );
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

            // Morel.g:1399:2: ( (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) |c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENTIFIER) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==23) ) {
                    int LA11_2 = input.LA(3);

                    if ( (LA11_2==IDENTIFIER) ) {
                        switch ( input.LA(4) ) {
                        case 12:
                            {
                            int LA11_4 = input.LA(5);

                            if ( (LA11_4==IDENTIFIER) ) {
                                int LA11_7 = input.LA(6);

                                if ( (LA11_7==EOF||LA11_7==18||LA11_7==24||LA11_7==65) ) {
                                    alt11=1;
                                }
                                else if ( (LA11_7==29) ) {
                                    alt11=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 11, 7, input);

                                    throw nvae;

                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 11, 4, input);

                                throw nvae;

                            }
                            }
                            break;
                        case EOF:
                        case 18:
                        case 24:
                        case 65:
                            {
                            alt11=1;
                            }
                            break;
                        case 29:
                            {
                            alt11=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 3, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // Morel.g:1400:2: (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER )
                    {
                    // Morel.g:1400:2: (a0= IDENTIFIER )
                    // Morel.g:1401:3: a0= IDENTIFIER
                    {
                    a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1038); if (state.failed) return element;

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
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[93]);
                    	}

                    a1=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1059); if (state.failed) return element;

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
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[94]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[95]);
                    	}

                    // Morel.g:1451:2: ( ( (a2= IDENTIFIER ) a3= '!' ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDENTIFIER) ) {
                        int LA10_1 = input.LA(2);

                        if ( (LA10_1==12) ) {
                            alt10=1;
                        }
                    }
                    switch (alt10) {
                        case 1 :
                            // Morel.g:1452:3: ( (a2= IDENTIFIER ) a3= '!' )
                            {
                            // Morel.g:1452:3: ( (a2= IDENTIFIER ) a3= '!' )
                            // Morel.g:1453:4: (a2= IDENTIFIER ) a3= '!'
                            {
                            // Morel.g:1453:4: (a2= IDENTIFIER )
                            // Morel.g:1454:5: a2= IDENTIFIER
                            {
                            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1088); if (state.failed) return element;

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
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[96]);
                            			}

                            a3=(Token)match(input,12,FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1121); if (state.failed) return element;

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
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[97]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[98]);
                    	}

                    // Morel.g:1514:2: (a4= IDENTIFIER )
                    // Morel.g:1515:3: a4= IDENTIFIER
                    {
                    a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1158); if (state.failed) return element;

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
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[99]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[100]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[101]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[102]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[103]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[104]);
                    	}

                    }
                    break;
                case 2 :
                    // Morel.g:1561:2: c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1184);
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
    // Morel.g:1565:1: parse_edu_ustb_sei_mde_morel_PrimitiveVariable returns [edu.ustb.sei.mde.morel.PrimitiveVariable element = null] : ( (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) |c0= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit );
    public final edu.ustb.sei.mde.morel.PrimitiveVariable parse_edu_ustb_sei_mde_morel_PrimitiveVariable() throws RecognitionException {
        edu.ustb.sei.mde.morel.PrimitiveVariable element =  null;

        int parse_edu_ustb_sei_mde_morel_PrimitiveVariable_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.PrimitiveVariableWithInit c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Morel.g:1568:2: ( (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) |c0= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENTIFIER) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==23) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==DATA_TYPE) ) {
                        int LA12_3 = input.LA(4);

                        if ( (LA12_3==EOF||LA12_3==18||LA12_3==24||LA12_3==65) ) {
                            alt12=1;
                        }
                        else if ( (LA12_3==29) ) {
                            alt12=2;
                        }
                        else {
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
                    // Morel.g:1569:2: (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE )
                    {
                    // Morel.g:1569:2: (a0= IDENTIFIER )
                    // Morel.g:1570:3: a0= IDENTIFIER
                    {
                    a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1213); if (state.failed) return element;

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
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[105]);
                    	}

                    a1=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1234); if (state.failed) return element;

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
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[106]);
                    	}

                    // Morel.g:1619:2: (a2= DATA_TYPE )
                    // Morel.g:1620:3: a2= DATA_TYPE
                    {
                    a2=(Token)match(input,DATA_TYPE,FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1252); if (state.failed) return element;

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
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[107]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[108]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[109]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[110]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[111]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[112]);
                    	}

                    }
                    break;
                case 2 :
                    // Morel.g:1666:2: c0= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1278);
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
    // Morel.g:1670:1: parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit returns [edu.ustb.sei.mde.morel.ObjectVariableWithInit element = null] : (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) a5= '=' (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ;
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

            // Morel.g:1673:2: ( (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) a5= '=' (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
            // Morel.g:1674:2: (a0= IDENTIFIER ) a1= ':' ( ( (a2= IDENTIFIER ) a3= '!' ) )? (a4= IDENTIFIER ) a5= '=' (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            {
            // Morel.g:1674:2: (a0= IDENTIFIER )
            // Morel.g:1675:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1307); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[113]);
            	}

            a1=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1328); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[115]);
            	}

            // Morel.g:1725:2: ( ( (a2= IDENTIFIER ) a3= '!' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENTIFIER) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==12) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // Morel.g:1726:3: ( (a2= IDENTIFIER ) a3= '!' )
                    {
                    // Morel.g:1726:3: ( (a2= IDENTIFIER ) a3= '!' )
                    // Morel.g:1727:4: (a2= IDENTIFIER ) a3= '!'
                    {
                    // Morel.g:1727:4: (a2= IDENTIFIER )
                    // Morel.g:1728:5: a2= IDENTIFIER
                    {
                    a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1357); if (state.failed) return element;

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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[116]);
                    			}

                    a3=(Token)match(input,12,FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1390); if (state.failed) return element;

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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[117]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[118]);
            	}

            // Morel.g:1788:2: (a4= IDENTIFIER )
            // Morel.g:1789:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1427); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[119]);
            	}

            a5=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1448); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[124]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[125]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[128]);
            	}

            // Morel.g:1850:2: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt14=1;
                }
                break;
            case 41:
                {
                alt14=2;
                }
                break;
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 14:
            case 17:
            case 19:
            case 38:
            case 48:
            case 61:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // Morel.g:1851:3: a6_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1466);
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
                    // Morel.g:1870:6: a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1480);
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
                    // Morel.g:1889:6: a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1494);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[137]);
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
    // Morel.g:1924:1: parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit returns [edu.ustb.sei.mde.morel.PrimitiveVariableWithInit element = null] : (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) a3= '=' (a4_0= parse_edu_ustb_sei_mde_morel_LetExp |a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ;
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

            // Morel.g:1927:2: ( (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) a3= '=' (a4_0= parse_edu_ustb_sei_mde_morel_LetExp |a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
            // Morel.g:1928:2: (a0= IDENTIFIER ) a1= ':' (a2= DATA_TYPE ) a3= '=' (a4_0= parse_edu_ustb_sei_mde_morel_LetExp |a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            {
            // Morel.g:1928:2: (a0= IDENTIFIER )
            // Morel.g:1929:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1531); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[138]);
            	}

            a1=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1552); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[139]);
            	}

            // Morel.g:1978:2: (a2= DATA_TYPE )
            // Morel.g:1979:3: a2= DATA_TYPE
            {
            a2=(Token)match(input,DATA_TYPE,FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1570); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[140]);
            	}

            a3=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1591); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[144]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[147]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[149]);
            	}

            // Morel.g:2040:2: (a4_0= parse_edu_ustb_sei_mde_morel_LetExp |a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt15=1;
                }
                break;
            case 41:
                {
                alt15=2;
                }
                break;
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 14:
            case 17:
            case 19:
            case 38:
            case 48:
            case 61:
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
                    // Morel.g:2041:3: a4_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1609);
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
                    // Morel.g:2060:6: a4_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1623);
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
                    // Morel.g:2079:6: a4_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1637);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[154]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[158]);
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
    // Morel.g:2114:1: parse_edu_ustb_sei_mde_morel_LinkConstraint returns [edu.ustb.sei.mde.morel.LinkConstraint element = null] : (a0= IDENTIFIER ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= IDENTIFIER ) ;
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

            // Morel.g:2117:2: ( (a0= IDENTIFIER ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= IDENTIFIER ) )
            // Morel.g:2118:2: (a0= IDENTIFIER ) a1= '.' (a2= IDENTIFIER ) a3= '=' (a4= IDENTIFIER )
            {
            // Morel.g:2118:2: (a0= IDENTIFIER )
            // Morel.g:2119:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1674); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[159]);
            	}

            a1=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1695); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[160]);
            	}

            // Morel.g:2172:2: (a2= IDENTIFIER )
            // Morel.g:2173:3: a2= IDENTIFIER
            {
            a2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1713); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[161]);
            	}

            a3=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1734); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[162]);
            	}

            // Morel.g:2226:2: (a4= IDENTIFIER )
            // Morel.g:2227:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1752); if (state.failed) return element;

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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[166]);
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
    // Morel.g:2271:1: parse_edu_ustb_sei_mde_morel_VariableExp returns [edu.ustb.sei.mde.morel.VariableExp element = null] : (a0= IDENTIFIER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.VariableExp parse_edu_ustb_sei_mde_morel_VariableExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.VariableExp element =  null;

        int parse_edu_ustb_sei_mde_morel_VariableExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Morel.g:2274:2: ( (a0= IDENTIFIER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2275:2: (a0= IDENTIFIER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:2275:2: (a0= IDENTIFIER )
            // Morel.g:2276:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_VariableExp1792); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[180]);
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
            	}

            // Morel.g:2338:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0 >= 20 && LA16_0 <= 21)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Morel.g:2339:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2339:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2340:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2340:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2341:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_VariableExp1828);
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
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
    // Morel.g:2415:1: parse_edu_ustb_sei_mde_morel_NestedExp returns [edu.ustb.sei.mde.morel.NestedExp element = null] : a0= '(' (a1_0= parse_edu_ustb_sei_mde_morel_LetExp |a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= ')' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
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

            // Morel.g:2418:2: (a0= '(' (a1_0= parse_edu_ustb_sei_mde_morel_LetExp |a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= ')' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2419:2: a0= '(' (a1_0= parse_edu_ustb_sei_mde_morel_LetExp |a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= ')' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_NestedExp1884); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[233]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[241]);
            	}

            // Morel.g:2441:2: (a1_0= parse_edu_ustb_sei_mde_morel_LetExp |a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt17=1;
                }
                break;
            case 41:
                {
                alt17=2;
                }
                break;
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 14:
            case 17:
            case 19:
            case 38:
            case 48:
            case 61:
                {
                alt17=3;
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
                    // Morel.g:2442:3: a1_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1902);
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
                    // Morel.g:2461:6: a1_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1916);
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
                    // Morel.g:2480:6: a1_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1930);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[242]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_NestedExp1948); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[243]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[246]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[247]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[248]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[249]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[250]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[251]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[252]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[253]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[254]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[255]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[256]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[257]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[258]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[259]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[260]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[261]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[262]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[263]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[264]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[265]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[266]);
            	}

            // Morel.g:2542:2: ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0 >= 20 && LA18_0 <= 21)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Morel.g:2543:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2543:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2544:4: (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2544:4: (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2545:5: a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1977);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[280]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[281]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[282]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[283]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[284]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[285]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[286]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[287]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[301]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[302]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[303]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[304]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[305]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[306]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[307]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[308]);
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
    // Morel.g:2619:1: parse_edu_ustb_sei_mde_morel_IntegerLiteralExp returns [edu.ustb.sei.mde.morel.IntegerLiteralExp element = null] : (a0= INUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.IntegerLiteralExp parse_edu_ustb_sei_mde_morel_IntegerLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.IntegerLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Morel.g:2622:2: ( (a0= INUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2623:2: (a0= INUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:2623:2: (a0= INUMBER )
            // Morel.g:2624:3: a0= INUMBER
            {
            a0=(Token)match(input,INUMBER,FOLLOW_INUMBER_in_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp2037); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[309]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[310]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[311]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[322]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[323]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[324]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[325]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[326]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[327]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[328]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[329]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[330]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[331]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[332]);
            	}

            // Morel.g:2682:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0 >= 20 && LA19_0 <= 21)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Morel.g:2683:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2683:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2684:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2684:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2685:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp2073);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[346]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[347]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[348]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[349]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[350]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[351]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[352]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[353]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[367]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[368]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[369]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[370]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[371]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[372]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[373]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[374]);
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
    // Morel.g:2759:1: parse_edu_ustb_sei_mde_morel_RealLiteralExp returns [edu.ustb.sei.mde.morel.RealLiteralExp element = null] : (a0= RNUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.RealLiteralExp parse_edu_ustb_sei_mde_morel_RealLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.RealLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_RealLiteralExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Morel.g:2762:2: ( (a0= RNUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2763:2: (a0= RNUMBER ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:2763:2: (a0= RNUMBER )
            // Morel.g:2764:3: a0= RNUMBER
            {
            a0=(Token)match(input,RNUMBER,FOLLOW_RNUMBER_in_parse_edu_ustb_sei_mde_morel_RealLiteralExp2133); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[375]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[377]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[388]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[389]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[390]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[391]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[392]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[393]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[394]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[395]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[396]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[397]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[398]);
            	}

            // Morel.g:2822:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0 >= 20 && LA20_0 <= 21)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Morel.g:2823:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2823:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2824:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2824:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2825:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_RealLiteralExp2169);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[412]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[413]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[414]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[415]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[416]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[417]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[418]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[419]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[433]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[434]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[435]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[436]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[437]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[438]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[439]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[440]);
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
    // Morel.g:2899:1: parse_edu_ustb_sei_mde_morel_StringLiteralExp returns [edu.ustb.sei.mde.morel.StringLiteralExp element = null] : (a0= QUOTED_39_39_92 ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.StringLiteralExp parse_edu_ustb_sei_mde_morel_StringLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.StringLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_StringLiteralExp_StartIndex = input.index();

        Token a0=null;
        edu.ustb.sei.mde.morel.CallPathExp a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Morel.g:2902:2: ( (a0= QUOTED_39_39_92 ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:2903:2: (a0= QUOTED_39_39_92 ) ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:2903:2: (a0= QUOTED_39_39_92 )
            // Morel.g:2904:3: a0= QUOTED_39_39_92
            {
            a0=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_morel_StringLiteralExp2229); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[441]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[442]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[443]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[461]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[462]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[463]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[464]);
            	}

            // Morel.g:2962:2: ( ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0 >= 20 && LA21_0 <= 21)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Morel.g:2963:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:2963:3: ( (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:2964:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:2964:4: (a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:2965:5: a1_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_StringLiteralExp2265);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[478]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[479]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[480]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[481]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[482]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[483]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[484]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[485]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[499]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[500]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[501]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[502]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[503]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[504]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[505]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[506]);
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
    // Morel.g:3039:1: parse_edu_ustb_sei_mde_morel_BooleanLiteralExp returns [edu.ustb.sei.mde.morel.BooleanLiteralExp element = null] : ( (a0= 'true' |a1= 'false' ) ) ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.BooleanLiteralExp parse_edu_ustb_sei_mde_morel_BooleanLiteralExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanLiteralExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.morel.CallPathExp a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Morel.g:3042:2: ( ( (a0= 'true' |a1= 'false' ) ) ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:3043:2: ( (a0= 'true' |a1= 'false' ) ) ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            // Morel.g:3043:2: ( (a0= 'true' |a1= 'false' ) )
            // Morel.g:3044:3: (a0= 'true' |a1= 'false' )
            {
            // Morel.g:3044:3: (a0= 'true' |a1= 'false' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==61) ) {
                alt22=1;
            }
            else if ( (LA22_0==38) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // Morel.g:3045:4: a0= 'true'
                    {
                    a0=(Token)match(input,61,FOLLOW_61_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2330); if (state.failed) return element;

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
                    // Morel.g:3058:8: a1= 'false'
                    {
                    a1=(Token)match(input,38,FOLLOW_38_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2345); if (state.failed) return element;

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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[507]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[508]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[509]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[520]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[521]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[522]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[523]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[524]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[525]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[526]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[527]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[528]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[529]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[530]);
            	}

            // Morel.g:3101:2: ( ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0 >= 20 && LA23_0 <= 21)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Morel.g:3102:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:3102:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:3103:4: (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3103:4: (a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3104:5: a3_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2381);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[546]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[547]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[548]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[549]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[550]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[551]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[565]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[566]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[567]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[568]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[569]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[570]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[571]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[572]);
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



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_FeaturePathExp"
    // Morel.g:3178:1: parse_edu_ustb_sei_mde_morel_FeaturePathExp returns [edu.ustb.sei.mde.morel.FeaturePathExp element = null] : a0= '.' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )? ;
    public final edu.ustb.sei.mde.morel.FeaturePathExp parse_edu_ustb_sei_mde_morel_FeaturePathExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.FeaturePathExp element =  null;

        int parse_edu_ustb_sei_mde_morel_FeaturePathExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.morel.CallPathExp a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Morel.g:3181:2: (a0= '.' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )? )
            // Morel.g:3182:2: a0= '.' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )?
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2437); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createFeaturePathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_14_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[573]);
            	}

            // Morel.g:3196:2: (a1= IDENTIFIER )
            // Morel.g:3197:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2455); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_14_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[574]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[575]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[576]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[577]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[578]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[579]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[580]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[581]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[582]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[583]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[584]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[585]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[586]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[587]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[588]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[589]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[590]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[591]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[592]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[593]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[594]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[595]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[596]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[597]);
            	}

            // Morel.g:3255:2: ( (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0 >= 20 && LA24_0 <= 21)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Morel.g:3256:3: (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3256:3: (a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3257:4: a2_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2485);
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
                    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_14_0_0_2, a2_0, true);
                    					copyLocalizationInfos(a2_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[612]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[613]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[614]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[615]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[616]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[617]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[618]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_edu_ustb_sei_mde_morel_FeaturePathExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_FeaturePathExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_OperationPathExp"
    // Morel.g:3305:1: parse_edu_ustb_sei_mde_morel_OperationPathExp returns [edu.ustb.sei.mde.morel.OperationPathExp element = null] : ( (a0= '.' |a1= '->' ) ) (a4= IDENTIFIER ) a5= '(' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* ) )? a9= ')' ( (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Morel.g:3308:2: ( ( (a0= '.' |a1= '->' ) ) (a4= IDENTIFIER ) a5= '(' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* ) )? a9= ')' ( (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )? )
            // Morel.g:3309:2: ( (a0= '.' |a1= '->' ) ) (a4= IDENTIFIER ) a5= '(' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* ) )? a9= ')' ( (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )?
            {
            // Morel.g:3309:2: ( (a0= '.' |a1= '->' ) )
            // Morel.g:3310:3: (a0= '.' |a1= '->' )
            {
            // Morel.g:3310:3: (a0= '.' |a1= '->' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==21) ) {
                alt25=1;
            }
            else if ( (LA25_0==20) ) {
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
                    // Morel.g:3311:4: a0= '.'
                    {
                    a0=(Token)match(input,21,FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2535); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationSeparator().getEEnumLiteral(edu.ustb.sei.mde.morel.OperationSeparator.DOT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.OPERATION_PATH_EXP__SEPARATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Morel.g:3324:8: a1= '->'
                    {
                    a1=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2550); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_0, null, true);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[619]);
            	}

            // Morel.g:3344:2: (a4= IDENTIFIER )
            // Morel.g:3345:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2575); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[620]);
            	}

            a5=(Token)match(input,14,FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2596); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[621]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[622]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[623]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[624]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[625]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[626]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[627]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[628]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[629]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[630]);
            	}

            // Morel.g:3403:2: ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0 >= IDENTIFIER && LA29_0 <= INUMBER)||(LA29_0 >= QUOTED_39_39_92 && LA29_0 <= RNUMBER)||LA29_0==14||LA29_0==17||LA29_0==19||LA29_0==38||LA29_0==41||LA29_0==44||LA29_0==48||LA29_0==61) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // Morel.g:3404:3: ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* )
                    {
                    // Morel.g:3404:3: ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )* )
                    // Morel.g:3405:4: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )*
                    {
                    // Morel.g:3405:4: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    int alt26=3;
                    switch ( input.LA(1) ) {
                    case 44:
                        {
                        alt26=1;
                        }
                        break;
                    case 41:
                        {
                        alt26=2;
                        }
                        break;
                    case IDENTIFIER:
                    case INUMBER:
                    case QUOTED_39_39_92:
                    case RNUMBER:
                    case 14:
                    case 17:
                    case 19:
                    case 38:
                    case 48:
                    case 61:
                        {
                        alt26=3;
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
                            // Morel.g:3406:5: a6_0= parse_edu_ustb_sei_mde_morel_LetExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2625);
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_3_0_0_0, a6_0, true);
                            						copyLocalizationInfos(a6_0, element);
                            					}
                            				}

                            }
                            break;
                        case 2 :
                            // Morel.g:3425:10: a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2645);
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_3_0_0_0, a6_1, true);
                            						copyLocalizationInfos(a6_1, element);
                            					}
                            				}

                            }
                            break;
                        case 3 :
                            // Morel.g:3444:10: a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2665);
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_3_0_0_0, a6_2, true);
                            						copyLocalizationInfos(a6_2, element);
                            					}
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[631]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[632]);
                    			}

                    // Morel.g:3470:4: ( (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==18) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // Morel.g:3471:5: (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
                    	    {
                    	    // Morel.g:3471:5: (a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
                    	    // Morel.g:3472:6: a7= ',' (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    	    {
                    	    a7=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2706); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[633]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[634]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[635]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[636]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[637]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[638]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[639]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[640]);
                    	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[641]);
                    	    					}

                    	    // Morel.g:3494:6: (a8_0= parse_edu_ustb_sei_mde_morel_LetExp |a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    	    int alt27=3;
                    	    switch ( input.LA(1) ) {
                    	    case 44:
                    	        {
                    	        alt27=1;
                    	        }
                    	        break;
                    	    case 41:
                    	        {
                    	        alt27=2;
                    	        }
                    	        break;
                    	    case IDENTIFIER:
                    	    case INUMBER:
                    	    case QUOTED_39_39_92:
                    	    case RNUMBER:
                    	    case 14:
                    	    case 17:
                    	    case 19:
                    	    case 38:
                    	    case 48:
                    	    case 61:
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
                    	            // Morel.g:3495:7: a8_0= parse_edu_ustb_sei_mde_morel_LetExp
                    	            {
                    	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2740);
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
                    	            								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_3_0_0_1_0_0_1, a8_0, true);
                    	            								copyLocalizationInfos(a8_0, element);
                    	            							}
                    	            						}

                    	            }
                    	            break;
                    	        case 2 :
                    	            // Morel.g:3514:14: a8_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    	            {
                    	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2766);
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
                    	            								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_3_0_0_1_0_0_1, a8_1, true);
                    	            								copyLocalizationInfos(a8_1, element);
                    	            							}
                    	            						}

                    	            }
                    	            break;
                    	        case 3 :
                    	            // Morel.g:3533:14: a8_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    	            {
                    	            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2792);
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
                    	            								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_3_0_0_1_0_0_1, a8_2, true);
                    	            								copyLocalizationInfos(a8_2, element);
                    	            							}
                    	            						}

                    	            }
                    	            break;

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[642]);
                    	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[643]);
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[644]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[645]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[646]);
            	}

            a9=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2866); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createOperationPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[647]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[648]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[649]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[650]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[651]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[652]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[653]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[654]);
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
            	}

            // Morel.g:3611:2: ( (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0 >= 20 && LA30_0 <= 21)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Morel.g:3612:3: (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3612:3: (a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3613:4: a10_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2889);
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
                    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_15_0_0_5, a10_0, true);
                    					copyLocalizationInfos(a10_0, element);
                    				}
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_edu_ustb_sei_mde_morel_OperationPathExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_OperationPathExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_IteratorPathExp"
    // Morel.g:3661:1: parse_edu_ustb_sei_mde_morel_IteratorPathExp returns [edu.ustb.sei.mde.morel.IteratorPathExp element = null] : a0= '->' ( (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' ) ) a9= '(' (a10_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )? a13= '|' (a14_0= parse_edu_ustb_sei_mde_morel_LetExp |a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a15= ')' ( ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Morel.g:3664:2: (a0= '->' ( (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' ) ) a9= '(' (a10_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )? a13= '|' (a14_0= parse_edu_ustb_sei_mde_morel_LetExp |a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a15= ')' ( ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )? )
            // Morel.g:3665:2: a0= '->' ( (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' ) ) a9= '(' (a10_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )? a13= '|' (a14_0= parse_edu_ustb_sei_mde_morel_LetExp |a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a15= ')' ( ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2930); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[692]);
            	}

            // Morel.g:3679:2: ( (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' ) )
            // Morel.g:3680:3: (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' )
            {
            // Morel.g:3680:3: (a1= 'forAll' |a2= 'exists' |a3= 'select' |a4= 'reject' |a5= 'collect' |a6= 'closure' )
            int alt31=6;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt31=1;
                }
                break;
            case 37:
                {
                alt31=2;
                }
                break;
            case 58:
                {
                alt31=3;
                }
                break;
            case 55:
                {
                alt31=4;
                }
                break;
            case 34:
                {
                alt31=5;
                }
                break;
            case 33:
                {
                alt31=6;
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
                    // Morel.g:3681:4: a1= 'forAll'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2953); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.FOR_ALL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Morel.g:3694:8: a2= 'exists'
                    {
                    a2=(Token)match(input,37,FOLLOW_37_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2968); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.EXISTS_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Morel.g:3707:8: a3= 'select'
                    {
                    a3=(Token)match(input,58,FOLLOW_58_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2983); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.SELECT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Morel.g:3720:8: a4= 'reject'
                    {
                    a4=(Token)match(input,55,FOLLOW_55_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2998); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.REJECT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Morel.g:3733:8: a5= 'collect'
                    {
                    a5=(Token)match(input,34,FOLLOW_34_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3013); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				// set value of enumeration attribute
                    				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorType().getEEnumLiteral(edu.ustb.sei.mde.morel.IteratorType.COLLECT_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.ITERATOR_PATH_EXP__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 6 :
                    // Morel.g:3746:8: a6= 'closure'
                    {
                    a6=(Token)match(input,33,FOLLOW_33_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3028); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_1, null, true);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[693]);
            	}

            a9=(Token)match(input,14,FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3049); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[694]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[695]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[696]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[697]);
            	}

            // Morel.g:3783:2: (a10_0= parse_edu_ustb_sei_mde_morel_Variable )
            // Morel.g:3784:3: a10_0= parse_edu_ustb_sei_mde_morel_Variable
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3067);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_3, a10_0, true);
            				copyLocalizationInfos(a10_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[698]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[699]);
            	}

            // Morel.g:3810:2: ( (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==18) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Morel.g:3811:3: (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                    {
                    // Morel.g:3811:3: (a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                    // Morel.g:3812:4: a11= ',' (a12_0= parse_edu_ustb_sei_mde_morel_Variable )
                    {
                    a11=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3094); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_4_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[700]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[701]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[702]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[703]);
                    			}

                    // Morel.g:3829:4: (a12_0= parse_edu_ustb_sei_mde_morel_Variable )
                    // Morel.g:3830:5: a12_0= parse_edu_ustb_sei_mde_morel_Variable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3120);
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_4_0_0_1, a12_0, true);
                    						copyLocalizationInfos(a12_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[704]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[705]);
            	}

            a13=(Token)match(input,65,FOLLOW_65_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3161); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[706]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[707]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[708]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[709]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[710]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[711]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[712]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[713]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[714]);
            	}

            // Morel.g:3884:2: (a14_0= parse_edu_ustb_sei_mde_morel_LetExp |a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt33=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt33=1;
                }
                break;
            case 41:
                {
                alt33=2;
                }
                break;
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 14:
            case 17:
            case 19:
            case 38:
            case 48:
            case 61:
                {
                alt33=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }

            switch (alt33) {
                case 1 :
                    // Morel.g:3885:3: a14_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3179);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_6, a14_0, true);
                    				copyLocalizationInfos(a14_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:3904:6: a14_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3193);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_6, a14_1, true);
                    				copyLocalizationInfos(a14_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:3923:6: a14_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3207);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_6, a14_2, true);
                    				copyLocalizationInfos(a14_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[715]);
            	}

            a15=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3225); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIteratorPathExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[716]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[717]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[718]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[719]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[720]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[721]);
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
            	}

            // Morel.g:3985:2: ( ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0 >= 20 && LA34_0 <= 21)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // Morel.g:3986:3: ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    {
                    // Morel.g:3986:3: ( (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp ) )
                    // Morel.g:3987:4: (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    {
                    // Morel.g:3987:4: (a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp )
                    // Morel.g:3988:5: a16_0= parse_edu_ustb_sei_mde_morel_CallPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3254);
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_16_0_0_8_0_0_0, a16_0, true);
                    						copyLocalizationInfos(a16_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
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
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[761]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[762]);
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_edu_ustb_sei_mde_morel_IteratorPathExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_IteratorPathExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_LetExp"
    // Morel.g:4062:1: parse_edu_ustb_sei_mde_morel_LetExp returns [edu.ustb.sei.mde.morel.LetExp element = null] : a0= 'let' (a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ( (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ) )* a4= 'in' (a5_0= parse_edu_ustb_sei_mde_morel_LetExp |a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Morel.g:4065:2: (a0= 'let' (a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ( (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ) )* a4= 'in' (a5_0= parse_edu_ustb_sei_mde_morel_LetExp |a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
            // Morel.g:4066:2: a0= 'let' (a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ( (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ) )* a4= 'in' (a5_0= parse_edu_ustb_sei_mde_morel_LetExp |a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_edu_ustb_sei_mde_morel_LetExp3310); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[782]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[783]);
            	}

            // Morel.g:4081:2: (a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit )
            // Morel.g:4082:3: a1_0= parse_edu_ustb_sei_mde_morel_VariableWithInit
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_LetExp3328);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[784]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[785]);
            	}

            // Morel.g:4108:2: ( (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==18) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Morel.g:4109:3: (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) )
            	    {
            	    // Morel.g:4109:3: (a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) )
            	    // Morel.g:4110:4: a2= ',' (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit )
            	    {
            	    a2=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_LetExp3355); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_2_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[786]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[787]);
            	    			}

            	    // Morel.g:4125:4: (a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit )
            	    // Morel.g:4126:5: a3_0= parse_edu_ustb_sei_mde_morel_VariableWithInit
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_LetExp3381);
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
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_2_0_0_1, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[788]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[789]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[790]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[791]);
            	}

            a4=(Token)match(input,43,FOLLOW_43_in_parse_edu_ustb_sei_mde_morel_LetExp3422); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createLetExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[792]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[793]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[794]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[795]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[796]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[797]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[798]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[799]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[800]);
            	}

            // Morel.g:4182:2: (a5_0= parse_edu_ustb_sei_mde_morel_LetExp |a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt36=1;
                }
                break;
            case 41:
                {
                alt36=2;
                }
                break;
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 14:
            case 17:
            case 19:
            case 38:
            case 48:
            case 61:
                {
                alt36=3;
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
                    // Morel.g:4183:3: a5_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_LetExp3440);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_4, a5_0, true);
                    				copyLocalizationInfos(a5_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:4202:6: a5_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_LetExp3454);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_4, a5_1, true);
                    				copyLocalizationInfos(a5_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:4221:6: a5_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_LetExp3468);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_17_0_0_4, a5_2, true);
                    				copyLocalizationInfos(a5_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_edu_ustb_sei_mde_morel_LetExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_LetExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_ConditionExp"
    // Morel.g:4261:1: parse_edu_ustb_sei_mde_morel_ConditionExp returns [edu.ustb.sei.mde.morel.ConditionExp element = null] : a0= 'if' (a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= 'then' (a3_0= parse_edu_ustb_sei_mde_morel_Expression ) a4= 'else' (a5_0= parse_edu_ustb_sei_mde_morel_Expression ) a6= 'endif' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Morel.g:4264:2: (a0= 'if' (a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= 'then' (a3_0= parse_edu_ustb_sei_mde_morel_Expression ) a4= 'else' (a5_0= parse_edu_ustb_sei_mde_morel_Expression ) a6= 'endif' )
            // Morel.g:4265:2: a0= 'if' (a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a2= 'then' (a3_0= parse_edu_ustb_sei_mde_morel_Expression ) a4= 'else' (a5_0= parse_edu_ustb_sei_mde_morel_Expression ) a6= 'endif'
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_edu_ustb_sei_mde_morel_ConditionExp3501); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[815]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[816]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[817]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[818]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[819]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[820]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[821]);
            	}

            // Morel.g:4285:2: (a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            // Morel.g:4286:3: a1_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ConditionExp3519);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[822]);
            	}

            a2=(Token)match(input,59,FOLLOW_59_in_parse_edu_ustb_sei_mde_morel_ConditionExp3537); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[823]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[824]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[825]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[826]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[827]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[828]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[829]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[830]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[831]);
            	}

            // Morel.g:4333:2: (a3_0= parse_edu_ustb_sei_mde_morel_Expression )
            // Morel.g:4334:3: a3_0= parse_edu_ustb_sei_mde_morel_Expression
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Expression_in_parse_edu_ustb_sei_mde_morel_ConditionExp3555);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_3, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[832]);
            	}

            a4=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_morel_ConditionExp3573); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[833]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[834]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[835]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[836]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[837]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[838]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[839]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[840]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[841]);
            	}

            // Morel.g:4381:2: (a5_0= parse_edu_ustb_sei_mde_morel_Expression )
            // Morel.g:4382:3: a5_0= parse_edu_ustb_sei_mde_morel_Expression
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Expression_in_parse_edu_ustb_sei_mde_morel_ConditionExp3591);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_5, a5_0, true);
            				copyLocalizationInfos(a5_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[842]);
            	}

            a6=(Token)match(input,36,FOLLOW_36_in_parse_edu_ustb_sei_mde_morel_ConditionExp3609); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createConditionExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_18_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[843]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[844]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[845]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[846]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[847]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[848]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[849]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[850]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[851]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[852]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[853]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[854]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[855]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[856]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_edu_ustb_sei_mde_morel_ConditionExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_ConditionExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BooleanImpliesExp"
    // Morel.g:4436:1: parse_edu_ustb_sei_mde_morel_BooleanImpliesExp returns [edu.ustb.sei.mde.morel.BooleanImpliesExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ( ( ( (a1= 'implies' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.BooleanImpliesExp parse_edu_ustb_sei_mde_morel_BooleanImpliesExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanImpliesExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.morel.BooleanOrExp a0_0 =null;

        edu.ustb.sei.mde.morel.BooleanOrExp a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Morel.g:4439:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ( ( ( (a1= 'implies' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ) )? )
            // Morel.g:4440:2: (a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ( ( ( (a1= 'implies' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ) )?
            {
            // Morel.g:4440:2: (a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp )
            // Morel.g:4441:3: a0_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3642);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[857]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[858]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[859]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[860]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[861]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[862]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[863]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[864]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[865]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[866]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[867]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[868]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[869]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[870]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[871]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[872]);
            	}

            // Morel.g:4481:2: ( ( ( (a1= 'implies' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==42) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // Morel.g:4482:3: ( ( (a1= 'implies' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) )
                    {
                    // Morel.g:4482:3: ( ( (a1= 'implies' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp ) )
                    // Morel.g:4483:4: ( (a1= 'implies' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp )
                    {
                    // Morel.g:4483:4: ( (a1= 'implies' ) )
                    // Morel.g:4484:5: (a1= 'implies' )
                    {
                    // Morel.g:4484:5: (a1= 'implies' )
                    // Morel.g:4485:6: a1= 'implies'
                    {
                    a1=(Token)match(input,42,FOLLOW_42_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3682); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (element == null) {
                    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanImpliesExp();
                    							startIncompleteElement(element);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_1_0_0_0, null, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    						// set value of enumeration attribute
                    						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.IMPLIES_VALUE).getInstance();
                    						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__OPERATOR), value);
                    						completedElement(value, false);
                    					}

                    }


                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[873]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[874]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[875]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[876]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[877]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[878]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[879]);
                    			}

                    // Morel.g:4511:4: (a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp )
                    // Morel.g:4512:5: a4_0= parse_edu_ustb_sei_mde_morel_BooleanOrExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3719);
                    a4_0=parse_edu_ustb_sei_mde_morel_BooleanOrExp();

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
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_IMPLIES_EXP__RIGHT), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_19_0_0_1_0_0_1, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
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
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[891]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[892]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[893]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[894]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BooleanImpliesExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BooleanOrExp"
    // Morel.g:4574:1: parse_edu_ustb_sei_mde_morel_BooleanOrExp returns [edu.ustb.sei.mde.morel.BooleanOrExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ( ( ( (a1= 'or' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.BooleanOrExp parse_edu_ustb_sei_mde_morel_BooleanOrExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanOrExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BooleanOrExp_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.morel.BooleanAndExp a0_0 =null;

        edu.ustb.sei.mde.morel.BooleanAndExp a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Morel.g:4577:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ( ( ( (a1= 'or' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ) )? )
            // Morel.g:4578:2: (a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ( ( ( (a1= 'or' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ) )?
            {
            // Morel.g:4578:2: (a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp )
            // Morel.g:4579:3: a0_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp3779);
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
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__LEFT), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[910]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[911]);
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
            	}

            // Morel.g:4620:2: ( ( ( (a1= 'or' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==49) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // Morel.g:4621:3: ( ( (a1= 'or' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) )
                    {
                    // Morel.g:4621:3: ( ( (a1= 'or' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp ) )
                    // Morel.g:4622:4: ( (a1= 'or' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp )
                    {
                    // Morel.g:4622:4: ( (a1= 'or' ) )
                    // Morel.g:4623:5: (a1= 'or' )
                    {
                    // Morel.g:4623:5: (a1= 'or' )
                    // Morel.g:4624:6: a1= 'or'
                    {
                    a1=(Token)match(input,49,FOLLOW_49_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp3819); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (element == null) {
                    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanOrExp();
                    							startIncompleteElement(element);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_0, null, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    						// set value of enumeration attribute
                    						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.OR_VALUE).getInstance();
                    						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__OPERATOR), value);
                    						completedElement(value, false);
                    					}

                    }


                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[927]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[928]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[929]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[930]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[931]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[932]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[933]);
                    			}

                    // Morel.g:4650:4: (a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp )
                    // Morel.g:4651:5: a4_0= parse_edu_ustb_sei_mde_morel_BooleanAndExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp3856);
                    a4_0=parse_edu_ustb_sei_mde_morel_BooleanAndExp();

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
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_OR_EXP__RIGHT), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_20_0_0_1_0_0_1, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
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
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[950]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[951]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[952]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[953]);
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_edu_ustb_sei_mde_morel_BooleanOrExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BooleanOrExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BooleanAndExp"
    // Morel.g:4715:1: parse_edu_ustb_sei_mde_morel_BooleanAndExp returns [edu.ustb.sei.mde.morel.BooleanAndExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ( ( ( (a1= 'and' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ) )? ;
    public final edu.ustb.sei.mde.morel.BooleanAndExp parse_edu_ustb_sei_mde_morel_BooleanAndExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanAndExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BooleanAndExp_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.morel.RelationalExp a0_0 =null;

        edu.ustb.sei.mde.morel.RelationalExp a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Morel.g:4718:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ( ( ( (a1= 'and' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ) )? )
            // Morel.g:4719:2: (a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ( ( ( (a1= 'and' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ) )?
            {
            // Morel.g:4719:2: (a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp )
            // Morel.g:4720:3: a0_0= parse_edu_ustb_sei_mde_morel_RelationalExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp3916);
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
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__LEFT), value);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[966]);
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
            	}

            // Morel.g:4762:2: ( ( ( (a1= 'and' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==32) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // Morel.g:4763:3: ( ( (a1= 'and' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) )
                    {
                    // Morel.g:4763:3: ( ( (a1= 'and' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp ) )
                    // Morel.g:4764:4: ( (a1= 'and' ) ) (a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp )
                    {
                    // Morel.g:4764:4: ( (a1= 'and' ) )
                    // Morel.g:4765:5: (a1= 'and' )
                    {
                    // Morel.g:4765:5: (a1= 'and' )
                    // Morel.g:4766:6: a1= 'and'
                    {
                    a1=(Token)match(input,32,FOLLOW_32_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp3956); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (element == null) {
                    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBooleanAndExp();
                    							startIncompleteElement(element);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_1_0_0_0, null, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    						// set value of enumeration attribute
                    						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.BooleanOperator.AND_VALUE).getInstance();
                    						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__OPERATOR), value);
                    						completedElement(value, false);
                    					}

                    }


                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[984]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[985]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[986]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[987]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[988]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[989]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[990]);
                    			}

                    // Morel.g:4792:4: (a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp )
                    // Morel.g:4793:5: a4_0= parse_edu_ustb_sei_mde_morel_RelationalExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp3993);
                    a4_0=parse_edu_ustb_sei_mde_morel_RelationalExp();

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
                    					if (a4_0 != null) {
                    						if (a4_0 != null) {
                    							Object value = a4_0;
                    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.BOOLEAN_AND_EXP__RIGHT), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_21_0_0_1_0_0_1, a4_0, true);
                    						copyLocalizationInfos(a4_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[991]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[992]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[993]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[994]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[995]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[996]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[997]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[998]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[999]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1000]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1001]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1002]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1003]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1004]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1005]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1006]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1007]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1020]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1021]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1022]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1023]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1024]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_edu_ustb_sei_mde_morel_BooleanAndExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BooleanAndExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_RelationalExp"
    // Morel.g:4859:1: parse_edu_ustb_sei_mde_morel_RelationalExp returns [edu.ustb.sei.mde.morel.RelationalExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ( ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Morel.g:4862:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ( ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ) )? )
            // Morel.g:4863:2: (a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ( ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ) )?
            {
            // Morel.g:4863:2: (a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp )
            // Morel.g:4864:3: a0_0= parse_edu_ustb_sei_mde_morel_AdditiveExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_RelationalExp4053);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1025]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1026]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1027]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1028]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1029]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1030]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1031]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1032]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1033]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1034]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1035]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1036]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1037]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1038]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1039]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1040]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1041]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1042]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1043]);
            	}

            // Morel.g:4907:2: ( ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==13||LA41_0==25||(LA41_0 >= 27 && LA41_0 <= 31)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // Morel.g:4908:3: ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) )
                    {
                    // Morel.g:4908:3: ( ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp ) )
                    // Morel.g:4909:4: ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) ) (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp )
                    {
                    // Morel.g:4909:4: ( (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' ) )
                    // Morel.g:4910:5: (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' )
                    {
                    // Morel.g:4910:5: (a1= '=' |a2= '<>' |a3= '!=' |a4= '<' |a5= '<=' |a6= '>' |a7= '>=' )
                    int alt40=7;
                    switch ( input.LA(1) ) {
                    case 29:
                        {
                        alt40=1;
                        }
                        break;
                    case 28:
                        {
                        alt40=2;
                        }
                        break;
                    case 13:
                        {
                        alt40=3;
                        }
                        break;
                    case 25:
                        {
                        alt40=4;
                        }
                        break;
                    case 27:
                        {
                        alt40=5;
                        }
                        break;
                    case 30:
                        {
                        alt40=6;
                        }
                        break;
                    case 31:
                        {
                        alt40=7;
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
                            // Morel.g:4911:6: a1= '='
                            {
                            a1=(Token)match(input,29,FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_RelationalExp4093); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.EQUAL_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 2 :
                            // Morel.g:4924:12: a2= '<>'
                            {
                            a2=(Token)match(input,28,FOLLOW_28_in_parse_edu_ustb_sei_mde_morel_RelationalExp4112); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.NOT_EQUAL_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 3 :
                            // Morel.g:4937:12: a3= '!='
                            {
                            a3=(Token)match(input,13,FOLLOW_13_in_parse_edu_ustb_sei_mde_morel_RelationalExp4131); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.NOT_EQUAL_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 4 :
                            // Morel.g:4950:12: a4= '<'
                            {
                            a4=(Token)match(input,25,FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_RelationalExp4150); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.LESS_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 5 :
                            // Morel.g:4963:12: a5= '<='
                            {
                            a5=(Token)match(input,27,FOLLOW_27_in_parse_edu_ustb_sei_mde_morel_RelationalExp4169); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.LESS_OR_EQ_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 6 :
                            // Morel.g:4976:12: a6= '>'
                            {
                            a6=(Token)match(input,30,FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_RelationalExp4188); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
                            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                            						// set value of enumeration attribute
                            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.RelationalOperator.GREATER_VALUE).getInstance();
                            						element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.RELATIONAL_EXP__OPERATOR), value);
                            						completedElement(value, false);
                            					}

                            }
                            break;
                        case 7 :
                            // Morel.g:4989:12: a7= '>='
                            {
                            a7=(Token)match(input,31,FOLLOW_31_in_parse_edu_ustb_sei_mde_morel_RelationalExp4207); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (element == null) {
                            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRelationalExp();
                            							startIncompleteElement(element);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_0, null, true);
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
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1044]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1045]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1046]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1047]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1048]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1049]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1050]);
                    			}

                    // Morel.g:5015:4: (a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp )
                    // Morel.g:5016:5: a10_0= parse_edu_ustb_sei_mde_morel_AdditiveExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_RelationalExp4244);
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_22_0_0_1_0_0_1, a10_0, true);
                    						copyLocalizationInfos(a10_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1051]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1052]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1053]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1054]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1055]);
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
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_edu_ustb_sei_mde_morel_RelationalExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_RelationalExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_AdditiveExp"
    // Morel.g:5084:1: parse_edu_ustb_sei_mde_morel_AdditiveExp returns [edu.ustb.sei.mde.morel.AdditiveExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ) )* ;
    public final edu.ustb.sei.mde.morel.AdditiveExp parse_edu_ustb_sei_mde_morel_AdditiveExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.AdditiveExp element =  null;

        int parse_edu_ustb_sei_mde_morel_AdditiveExp_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.MultiplicativeExp a0_0 =null;

        edu.ustb.sei.mde.morel.MultiplicativeExp a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Morel.g:5087:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ) )* )
            // Morel.g:5088:2: (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ) )*
            {
            // Morel.g:5088:2: (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp )
            // Morel.g:5089:3: a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4304);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1087]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1088]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1089]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1090]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1091]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1092]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1093]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1094]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1095]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1096]);
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
            	}

            // Morel.g:5133:2: ( ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==17||LA43_0==19) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // Morel.g:5134:3: ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) )
            	    {
            	    // Morel.g:5134:3: ( ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp ) )
            	    // Morel.g:5135:4: ( (a1= '+' |a2= '-' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp )
            	    {
            	    // Morel.g:5135:4: ( (a1= '+' |a2= '-' ) )
            	    // Morel.g:5136:5: (a1= '+' |a2= '-' )
            	    {
            	    // Morel.g:5136:5: (a1= '+' |a2= '-' )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==17) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==19) ) {
            	        alt42=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // Morel.g:5137:6: a1= '+'
            	            {
            	            a1=(Token)match(input,17,FOLLOW_17_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4344); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAdditiveExp();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.AdditiveOperator.PLUS_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.ADDITIVE_EXP__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;
            	        case 2 :
            	            // Morel.g:5150:12: a2= '-'
            	            {
            	            a2=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4363); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createAdditiveExp();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1_0_0_0, null, true);
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
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1107]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1108]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1109]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1110]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1111]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1112]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1113]);
            	    			}

            	    // Morel.g:5176:4: (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp )
            	    // Morel.g:5177:5: a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExp
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4400);
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
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_23_0_0_1_0_0_1, a5_0, true);
            	    						copyLocalizationInfos(a5_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
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
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1129]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1130]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1131]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1132]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1133]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1147]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1148]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1149]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1150]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1151]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1152]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1153]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_edu_ustb_sei_mde_morel_AdditiveExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_AdditiveExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_MultiplicativeExp"
    // Morel.g:5249:1: parse_edu_ustb_sei_mde_morel_MultiplicativeExp returns [edu.ustb.sei.mde.morel.MultiplicativeExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ) )* ;
    public final edu.ustb.sei.mde.morel.MultiplicativeExp parse_edu_ustb_sei_mde_morel_MultiplicativeExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.MultiplicativeExp element =  null;

        int parse_edu_ustb_sei_mde_morel_MultiplicativeExp_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.MultiplicativeExpChild a0_0 =null;

        edu.ustb.sei.mde.morel.MultiplicativeExpChild a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Morel.g:5252:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ) )* )
            // Morel.g:5253:2: (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ) )*
            {
            // Morel.g:5253:2: (a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild )
            // Morel.g:5254:3: a0_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4460);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1154]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1155]);
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
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1173]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1174]);
            	}

            // Morel.g:5299:2: ( ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==16||LA45_0==22) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // Morel.g:5300:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) )
            	    {
            	    // Morel.g:5300:3: ( ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild ) )
            	    // Morel.g:5301:4: ( (a1= '*' |a2= '/' ) ) (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild )
            	    {
            	    // Morel.g:5301:4: ( (a1= '*' |a2= '/' ) )
            	    // Morel.g:5302:5: (a1= '*' |a2= '/' )
            	    {
            	    // Morel.g:5302:5: (a1= '*' |a2= '/' )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==16) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==22) ) {
            	        alt44=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // Morel.g:5303:6: a1= '*'
            	            {
            	            a1=(Token)match(input,16,FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4500); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createMultiplicativeExp();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	            						// set value of enumeration attribute
            	            						Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.MultiplicativeOperator.MULTI_VALUE).getInstance();
            	            						addObjectToList(element, edu.ustb.sei.mde.morel.MorelPackage.MULTIPLICATIVE_EXP__OPERATORS, value);
            	            						completedElement(value, false);
            	            					}

            	            }
            	            break;
            	        case 2 :
            	            // Morel.g:5316:12: a2= '/'
            	            {
            	            a2=(Token)match(input,22,FOLLOW_22_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4519); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            						if (element == null) {
            	            							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createMultiplicativeExp();
            	            							startIncompleteElement(element);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_0, null, true);
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
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1175]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1176]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1177]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1178]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1179]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1180]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1181]);
            	    			}

            	    // Morel.g:5342:4: (a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild )
            	    // Morel.g:5343:5: a5_0= parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4556);
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
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_24_0_0_1_0_0_1, a5_0, true);
            	    						copyLocalizationInfos(a5_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1182]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1183]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1184]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1185]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1186]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1187]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1188]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1189]);
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
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1203]);
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_edu_ustb_sei_mde_morel_MultiplicativeExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_MultiplicativeExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_UnaryExp"
    // Morel.g:5417:1: parse_edu_ustb_sei_mde_morel_UnaryExp returns [edu.ustb.sei.mde.morel.UnaryExp element = null] : ( ( (a0= '+' |a1= '-' |a2= 'not' ) ) )? (a5_0= parse_edu_ustb_sei_mde_morel_AtomicExp ) ;
    public final edu.ustb.sei.mde.morel.UnaryExp parse_edu_ustb_sei_mde_morel_UnaryExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.UnaryExp element =  null;

        int parse_edu_ustb_sei_mde_morel_UnaryExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.AtomicExp a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Morel.g:5420:2: ( ( ( (a0= '+' |a1= '-' |a2= 'not' ) ) )? (a5_0= parse_edu_ustb_sei_mde_morel_AtomicExp ) )
            // Morel.g:5421:2: ( ( (a0= '+' |a1= '-' |a2= 'not' ) ) )? (a5_0= parse_edu_ustb_sei_mde_morel_AtomicExp )
            {
            // Morel.g:5421:2: ( ( (a0= '+' |a1= '-' |a2= 'not' ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==17||LA47_0==19||LA47_0==48) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // Morel.g:5422:3: ( (a0= '+' |a1= '-' |a2= 'not' ) )
                    {
                    // Morel.g:5422:3: ( (a0= '+' |a1= '-' |a2= 'not' ) )
                    // Morel.g:5423:4: (a0= '+' |a1= '-' |a2= 'not' )
                    {
                    // Morel.g:5423:4: (a0= '+' |a1= '-' |a2= 'not' )
                    int alt46=3;
                    switch ( input.LA(1) ) {
                    case 17:
                        {
                        alt46=1;
                        }
                        break;
                    case 19:
                        {
                        alt46=2;
                        }
                        break;
                    case 48:
                        {
                        alt46=3;
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
                            // Morel.g:5424:5: a0= '+'
                            {
                            a0=(Token)match(input,17,FOLLOW_17_in_parse_edu_ustb_sei_mde_morel_UnaryExp4627); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                            					// set value of enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.PLUS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
                            					completedElement(value, false);
                            				}

                            }
                            break;
                        case 2 :
                            // Morel.g:5437:10: a1= '-'
                            {
                            a1=(Token)match(input,19,FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_UnaryExp4644); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            					// set value of enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryOperator().getEEnumLiteral(edu.ustb.sei.mde.morel.UnaryOperator.MINUS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__OPERATOR), value);
                            					completedElement(value, false);
                            				}

                            }
                            break;
                        case 3 :
                            // Morel.g:5450:10: a2= 'not'
                            {
                            a2=(Token)match(input,48,FOLLOW_48_in_parse_edu_ustb_sei_mde_morel_UnaryExp4661); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createUnaryExp();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
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
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1224]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1225]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1226]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1227]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1228]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1229]);
            	}

            // Morel.g:5476:2: (a5_0= parse_edu_ustb_sei_mde_morel_AtomicExp )
            // Morel.g:5477:3: a5_0= parse_edu_ustb_sei_mde_morel_AtomicExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AtomicExp_in_parse_edu_ustb_sei_mde_morel_UnaryExp4694);
            a5_0=parse_edu_ustb_sei_mde_morel_AtomicExp();

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
            			if (a5_0 != null) {
            				if (a5_0 != null) {
            					Object value = a5_0;
            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.UNARY_EXP__CHILD), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_25_0_0_1, a5_0, true);
            				copyLocalizationInfos(a5_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1230]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1231]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1232]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1233]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1234]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1235]);
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_edu_ustb_sei_mde_morel_UnaryExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_UnaryExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BindExp"
    // Morel.g:5524:1: parse_edu_ustb_sei_mde_morel_BindExp returns [edu.ustb.sei.mde.morel.BindExp element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_VariableExp ) a1= '<-' (a2_0= parse_edu_ustb_sei_mde_morel_LetExp |a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ;
    public final edu.ustb.sei.mde.morel.BindExp parse_edu_ustb_sei_mde_morel_BindExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.BindExp element =  null;

        int parse_edu_ustb_sei_mde_morel_BindExp_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.morel.VariableExp a0_0 =null;

        edu.ustb.sei.mde.morel.LetExp a2_0 =null;

        edu.ustb.sei.mde.morel.ConditionExp a2_1 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a2_2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Morel.g:5527:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_VariableExp ) a1= '<-' (a2_0= parse_edu_ustb_sei_mde_morel_LetExp |a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
            // Morel.g:5528:2: (a0_0= parse_edu_ustb_sei_mde_morel_VariableExp ) a1= '<-' (a2_0= parse_edu_ustb_sei_mde_morel_LetExp |a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            {
            // Morel.g:5528:2: (a0_0= parse_edu_ustb_sei_mde_morel_VariableExp )
            // Morel.g:5529:3: a0_0= parse_edu_ustb_sei_mde_morel_VariableExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_BindExp4731);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1251]);
            	}

            a1=(Token)match(input,26,FOLLOW_26_in_parse_edu_ustb_sei_mde_morel_BindExp4749); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBindExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1252]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1253]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1254]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1255]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1256]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1257]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1258]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1259]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1260]);
            	}

            // Morel.g:5576:2: (a2_0= parse_edu_ustb_sei_mde_morel_LetExp |a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt48=1;
                }
                break;
            case 41:
                {
                alt48=2;
                }
                break;
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 14:
            case 17:
            case 19:
            case 38:
            case 48:
            case 61:
                {
                alt48=3;
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
                    // Morel.g:5577:3: a2_0= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_BindExp4767);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_2, a2_0, true);
                    				copyLocalizationInfos(a2_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:5596:6: a2_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_BindExp4781);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_2, a2_1, true);
                    				copyLocalizationInfos(a2_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:5615:6: a2_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_BindExp4795);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_26_0_0_2, a2_2, true);
                    				copyLocalizationInfos(a2_2, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1261]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1262]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_edu_ustb_sei_mde_morel_BindExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BindExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_DeclarativeStatement"
    // Morel.g:5643:1: parse_edu_ustb_sei_mde_morel_DeclarativeStatement returns [edu.ustb.sei.mde.morel.DeclarativeStatement element = null] : (a0_0= parse_edu_ustb_sei_mde_morel_BindExp |a0_1= parse_edu_ustb_sei_mde_morel_LetExp |a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp |a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a1= ';' ;
    public final edu.ustb.sei.mde.morel.DeclarativeStatement parse_edu_ustb_sei_mde_morel_DeclarativeStatement() throws RecognitionException {
        edu.ustb.sei.mde.morel.DeclarativeStatement element =  null;

        int parse_edu_ustb_sei_mde_morel_DeclarativeStatement_StartIndex = input.index();

        Token a1=null;
        edu.ustb.sei.mde.morel.BindExp a0_0 =null;

        edu.ustb.sei.mde.morel.LetExp a0_1 =null;

        edu.ustb.sei.mde.morel.ConditionExp a0_2 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp a0_3 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Morel.g:5646:2: ( (a0_0= parse_edu_ustb_sei_mde_morel_BindExp |a0_1= parse_edu_ustb_sei_mde_morel_LetExp |a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp |a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a1= ';' )
            // Morel.g:5647:2: (a0_0= parse_edu_ustb_sei_mde_morel_BindExp |a0_1= parse_edu_ustb_sei_mde_morel_LetExp |a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp |a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a1= ';'
            {
            // Morel.g:5647:2: (a0_0= parse_edu_ustb_sei_mde_morel_BindExp |a0_1= parse_edu_ustb_sei_mde_morel_LetExp |a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp |a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            int alt49=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA49_1 = input.LA(2);

                if ( (synpred72_Morel()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                alt49=2;
                }
                break;
            case 41:
                {
                alt49=3;
                }
                break;
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 14:
            case 17:
            case 19:
            case 38:
            case 48:
            case 61:
                {
                alt49=4;
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
                    // Morel.g:5648:3: a0_0= parse_edu_ustb_sei_mde_morel_BindExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4832);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }
                    break;
                case 2 :
                    // Morel.g:5667:6: a0_1= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4846);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, a0_1, true);
                    				copyLocalizationInfos(a0_1, element);
                    			}
                    		}

                    }
                    break;
                case 3 :
                    // Morel.g:5686:6: a0_2= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4860);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, a0_2, true);
                    				copyLocalizationInfos(a0_2, element);
                    			}
                    		}

                    }
                    break;
                case 4 :
                    // Morel.g:5705:6: a0_3= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4874);
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
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_0, a0_3, true);
                    				copyLocalizationInfos(a0_3, element);
                    			}
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1263]);
            	}

            a1=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4892); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createDeclarativeStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_27_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1264]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1265]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1266]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1267]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1268]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1269]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1270]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1271]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1272]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1273]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1274]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1275]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1276]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1277]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1278]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_edu_ustb_sei_mde_morel_DeclarativeStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_DeclarativeStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_IfStatement"
    // Morel.g:5760:1: parse_edu_ustb_sei_mde_morel_IfStatement returns [edu.ustb.sei.mde.morel.IfStatement element = null] : a0= 'if' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a3= ')' (a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Morel.g:5763:2: (a0= 'if' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a3= ')' (a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )? )
            // Morel.g:5764:2: a0= 'if' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a3= ')' (a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )?
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_edu_ustb_sei_mde_morel_IfStatement4921); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1279]);
            	}

            a1=(Token)match(input,14,FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_IfStatement4935); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1280]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1281]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1282]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1283]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1284]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1285]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1286]);
            	}

            // Morel.g:5798:2: (a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            // Morel.g:5799:3: a2_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_IfStatement4953);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_2, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1287]);
            	}

            a3=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_IfStatement4971); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1288]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1289]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1290]);
            	}

            // Morel.g:5840:2: (a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
            // Morel.g:5841:3: a4_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_IfStatement4989);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_4, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1291]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1292]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1293]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1294]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1295]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1296]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1297]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1298]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1299]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1300]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1301]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1302]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1303]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1304]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1305]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1306]);
            	}

            // Morel.g:5881:2: ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==35) ) {
                int LA50_1 = input.LA(2);

                if ( (synpred75_Morel()) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // Morel.g:5882:3: (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
                    {
                    // Morel.g:5882:3: (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
                    // Morel.g:5883:4: a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
                    {
                    a5=(Token)match(input,35,FOLLOW_35_in_parse_edu_ustb_sei_mde_morel_IfStatement5016); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createIfStatement();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1307]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1308]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1309]);
                    			}

                    // Morel.g:5899:4: (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
                    // Morel.g:5900:5: a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_IfStatement5042);
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
                    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_28_0_0_5_0_0_1, a6_0, true);
                    						copyLocalizationInfos(a6_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1310]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1311]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1312]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1313]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1314]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1315]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1316]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1317]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1318]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1319]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1320]);
                    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1321]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1322]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1323]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1324]);
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1325]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1326]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1327]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1328]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1329]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1330]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1331]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1332]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1333]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1334]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1335]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1336]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1337]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1338]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1339]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1340]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1341]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_edu_ustb_sei_mde_morel_IfStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_IfStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_ForStatement"
    // Morel.g:5964:1: parse_edu_ustb_sei_mde_morel_ForStatement returns [edu.ustb.sei.mde.morel.ForStatement element = null] : a0= 'for' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) a3= ';' (a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a5= ';' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )? a7= ')' (a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Morel.g:5967:2: (a0= 'for' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) a3= ';' (a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a5= ';' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )? a7= ')' (a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
            // Morel.g:5968:2: a0= 'for' a1= '(' (a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit ) a3= ';' (a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) a5= ';' ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )? a7= ')' (a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
            {
            a0=(Token)match(input,39,FOLLOW_39_in_parse_edu_ustb_sei_mde_morel_ForStatement5098); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1342]);
            	}

            a1=(Token)match(input,14,FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_ForStatement5112); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1343]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1344]);
            	}

            // Morel.g:5997:2: (a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit )
            // Morel.g:5998:3: a2_0= parse_edu_ustb_sei_mde_morel_VariableWithInit
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_ForStatement5130);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_2, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1345]);
            	}

            a3=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_ForStatement5148); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1346]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1347]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1348]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1349]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1350]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1351]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1352]);
            	}

            // Morel.g:6043:2: (a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
            // Morel.g:6044:3: a4_0= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5166);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_4, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1353]);
            	}

            a5=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_ForStatement5184); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1354]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1355]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1356]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1357]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1358]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1359]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1360]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1361]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1362]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1363]);
            	}

            // Morel.g:6092:2: ( ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0 >= IDENTIFIER && LA52_0 <= INUMBER)||(LA52_0 >= QUOTED_39_39_92 && LA52_0 <= RNUMBER)||LA52_0==14||LA52_0==17||LA52_0==19||LA52_0==38||LA52_0==41||LA52_0==44||LA52_0==48||LA52_0==61) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // Morel.g:6093:3: ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
                    {
                    // Morel.g:6093:3: ( (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp ) )
                    // Morel.g:6094:4: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    {
                    // Morel.g:6094:4: (a6_0= parse_edu_ustb_sei_mde_morel_LetExp |a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp |a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
                    int alt51=3;
                    switch ( input.LA(1) ) {
                    case 44:
                        {
                        alt51=1;
                        }
                        break;
                    case 41:
                        {
                        alt51=2;
                        }
                        break;
                    case IDENTIFIER:
                    case INUMBER:
                    case QUOTED_39_39_92:
                    case RNUMBER:
                    case 14:
                    case 17:
                    case 19:
                    case 38:
                    case 48:
                    case 61:
                        {
                        alt51=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;

                    }

                    switch (alt51) {
                        case 1 :
                            // Morel.g:6095:5: a6_0= parse_edu_ustb_sei_mde_morel_LetExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5213);
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_6_0_0_0, a6_0, true);
                            						copyLocalizationInfos(a6_0, element);
                            					}
                            				}

                            }
                            break;
                        case 2 :
                            // Morel.g:6114:10: a6_1= parse_edu_ustb_sei_mde_morel_ConditionExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5233);
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_6_0_0_0, a6_1, true);
                            						copyLocalizationInfos(a6_1, element);
                            					}
                            				}

                            }
                            break;
                        case 3 :
                            // Morel.g:6133:10: a6_2= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5253);
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_6_0_0_0, a6_2, true);
                            						copyLocalizationInfos(a6_2, element);
                            					}
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1364]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1365]);
            	}

            a7=(Token)match(input,15,FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_ForStatement5294); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createForStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1366]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1367]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1368]);
            	}

            // Morel.g:6181:2: (a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
            // Morel.g:6182:3: a8_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement
            {
            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_ForStatement5312);
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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_29_0_0_8, a8_0, true);
            				copyLocalizationInfos(a8_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1369]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1370]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1371]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1372]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1373]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1374]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1375]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1376]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1377]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1378]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1379]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1380]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1381]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1382]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1383]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1384]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_edu_ustb_sei_mde_morel_ForStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_ForStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_BlockStatement"
    // Morel.g:6224:1: parse_edu_ustb_sei_mde_morel_BlockStatement returns [edu.ustb.sei.mde.morel.BlockStatement element = null] : a0= '{' ( (a1_0= parse_edu_ustb_sei_mde_morel_Statement ) )* a2= '}' ;
    public final edu.ustb.sei.mde.morel.BlockStatement parse_edu_ustb_sei_mde_morel_BlockStatement() throws RecognitionException {
        edu.ustb.sei.mde.morel.BlockStatement element =  null;

        int parse_edu_ustb_sei_mde_morel_BlockStatement_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        edu.ustb.sei.mde.morel.Statement a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Morel.g:6227:2: (a0= '{' ( (a1_0= parse_edu_ustb_sei_mde_morel_Statement ) )* a2= '}' )
            // Morel.g:6228:2: a0= '{' ( (a1_0= parse_edu_ustb_sei_mde_morel_Statement ) )* a2= '}'
            {
            a0=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_BlockStatement5345); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBlockStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1385]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1386]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1387]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1388]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1389]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1390]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1391]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1392]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1393]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1394]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1395]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1396]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1397]);
            	}

            // Morel.g:6254:2: ( (a1_0= parse_edu_ustb_sei_mde_morel_Statement ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0 >= IDENTIFIER && LA53_0 <= INUMBER)||(LA53_0 >= QUOTED_39_39_92 && LA53_0 <= RNUMBER)||LA53_0==14||LA53_0==17||LA53_0==19||(LA53_0 >= 38 && LA53_0 <= 39)||LA53_0==41||LA53_0==44||LA53_0==48||LA53_0==61||LA53_0==64) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // Morel.g:6255:3: (a1_0= parse_edu_ustb_sei_mde_morel_Statement )
            	    {
            	    // Morel.g:6255:3: (a1_0= parse_edu_ustb_sei_mde_morel_Statement )
            	    // Morel.g:6256:4: a1_0= parse_edu_ustb_sei_mde_morel_Statement
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_BlockStatement5368);
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
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_1, a1_0, true);
            	    					copyLocalizationInfos(a1_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1398]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1399]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1400]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1401]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1402]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1403]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1404]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1405]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1406]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1407]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1408]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1409]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1410]);
            	}

            a2=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_BlockStatement5394); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createBlockStatement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_30_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1411]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1412]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1413]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1414]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1415]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1416]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1417]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1418]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1419]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1420]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1421]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1422]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1423]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1424]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1425]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1426]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, parse_edu_ustb_sei_mde_morel_BlockStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_BlockStatement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_TransformationModel"
    // Morel.g:6325:1: parse_edu_ustb_sei_mde_morel_TransformationModel returns [edu.ustb.sei.mde.morel.TransformationModel element = null] : a0= 'transformation' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a3_0= parse_edu_ustb_sei_mde_morel_Rule ) )* ;
    public final edu.ustb.sei.mde.morel.TransformationModel parse_edu_ustb_sei_mde_morel_TransformationModel() throws RecognitionException {
        edu.ustb.sei.mde.morel.TransformationModel element =  null;

        int parse_edu_ustb_sei_mde_morel_TransformationModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        edu.ustb.sei.mde.morel.TypedModel a2_0 =null;

        edu.ustb.sei.mde.morel.Rule a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Morel.g:6328:2: (a0= 'transformation' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a3_0= parse_edu_ustb_sei_mde_morel_Rule ) )* )
            // Morel.g:6329:2: a0= 'transformation' (a1= IDENTIFIER ) ( (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+ ( (a3_0= parse_edu_ustb_sei_mde_morel_Rule ) )*
            {
            a0=(Token)match(input,60,FOLLOW_60_in_parse_edu_ustb_sei_mde_morel_TransformationModel5423); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createTransformationModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1427]);
            	}

            // Morel.g:6343:2: (a1= IDENTIFIER )
            // Morel.g:6344:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_TransformationModel5441); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1428]);
            	}

            // Morel.g:6379:2: ( (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel ) )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==62) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // Morel.g:6380:3: (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel )
            	    {
            	    // Morel.g:6380:3: (a2_0= parse_edu_ustb_sei_mde_morel_TypedModel )
            	    // Morel.g:6381:4: a2_0= parse_edu_ustb_sei_mde_morel_TypedModel
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_TypedModel_in_parse_edu_ustb_sei_mde_morel_TransformationModel5471);
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
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_2, a2_0, true);
            	    					copyLocalizationInfos(a2_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1429]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1430]);
            	}

            // Morel.g:6408:2: ( (a3_0= parse_edu_ustb_sei_mde_morel_Rule ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==57) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // Morel.g:6409:3: (a3_0= parse_edu_ustb_sei_mde_morel_Rule )
            	    {
            	    // Morel.g:6409:3: (a3_0= parse_edu_ustb_sei_mde_morel_Rule )
            	    // Morel.g:6410:4: a3_0= parse_edu_ustb_sei_mde_morel_Rule
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Rule_in_parse_edu_ustb_sei_mde_morel_TransformationModel5506);
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
            	    					retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_31_0_0_3, a3_0, true);
            	    					copyLocalizationInfos(a3_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1431]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, parse_edu_ustb_sei_mde_morel_TransformationModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_TransformationModel"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Rule"
    // Morel.g:6438:1: parse_edu_ustb_sei_mde_morel_Rule returns [edu.ustb.sei.mde.morel.Rule element = null] : a0= 'rule' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) ) )* a4= '}' ;
    public final edu.ustb.sei.mde.morel.Rule parse_edu_ustb_sei_mde_morel_Rule() throws RecognitionException {
        edu.ustb.sei.mde.morel.Rule element =  null;

        int parse_edu_ustb_sei_mde_morel_Rule_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        edu.ustb.sei.mde.morel.Pattern a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Morel.g:6441:2: (a0= 'rule' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) ) )* a4= '}' )
            // Morel.g:6442:2: a0= 'rule' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) ) )* a4= '}'
            {
            a0=(Token)match(input,57,FOLLOW_57_in_parse_edu_ustb_sei_mde_morel_Rule5547); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1432]);
            	}

            // Morel.g:6456:2: (a1= IDENTIFIER )
            // Morel.g:6457:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_Rule5565); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1433]);
            	}

            a2=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_Rule5586); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1434]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1435]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1436]);
            	}

            // Morel.g:6508:2: ( ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==45||LA56_0==47||(LA56_0 >= 50 && LA56_0 <= 53)||LA56_0==56||LA56_0==64) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // Morel.g:6509:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) )
            	    {
            	    // Morel.g:6509:3: ( (a3_0= parse_edu_ustb_sei_mde_morel_Pattern ) )
            	    // Morel.g:6510:4: (a3_0= parse_edu_ustb_sei_mde_morel_Pattern )
            	    {
            	    // Morel.g:6510:4: (a3_0= parse_edu_ustb_sei_mde_morel_Pattern )
            	    // Morel.g:6511:5: a3_0= parse_edu_ustb_sei_mde_morel_Pattern
            	    {
            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Pattern_in_parse_edu_ustb_sei_mde_morel_Rule5615);
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
            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_3_0_0_0, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1437]);
            	    				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1438]);
            	    				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1439]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1440]);
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1441]);
            		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1442]);
            	}

            a4=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_Rule5656); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_32_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1443]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, parse_edu_ustb_sei_mde_morel_Rule_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Rule"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Pattern"
    // Morel.g:6563:1: parse_edu_ustb_sei_mde_morel_Pattern returns [edu.ustb.sei.mde.morel.Pattern element = null] : ( ( (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )? ) a8= '{' a9= 'match' a10= ':' ( ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' ) )? ( ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' ) )? ( (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a22= '}' |c0= parse_edu_ustb_sei_mde_morel_Query );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Morel.g:6566:2: ( ( (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )? ) a8= '{' a9= 'match' a10= ':' ( ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' ) )? ( ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' ) )? ( (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a22= '}' |c0= parse_edu_ustb_sei_mde_morel_Query )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==45||LA64_0==47||(LA64_0 >= 50 && LA64_0 <= 52)||LA64_0==56||LA64_0==64) ) {
                alt64=1;
            }
            else if ( (LA64_0==53) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }
            switch (alt64) {
                case 1 :
                    // Morel.g:6567:2: ( (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )? ) a8= '{' a9= 'match' a10= ':' ( ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' ) )? ( ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' ) )? ( (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )? a22= '}'
                    {
                    // Morel.g:6567:2: ( (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )? )
                    // Morel.g:6568:3: (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )?
                    {
                    // Morel.g:6568:3: (a0= 'lhs' |a1= 'rhs' |a2= 'nac' |a3= 'pac' |a4= 'pre' |a5= 'post' )?
                    int alt57=7;
                    switch ( input.LA(1) ) {
                        case 45:
                            {
                            alt57=1;
                            }
                            break;
                        case 56:
                            {
                            alt57=2;
                            }
                            break;
                        case 47:
                            {
                            alt57=3;
                            }
                            break;
                        case 50:
                            {
                            alt57=4;
                            }
                            break;
                        case 52:
                            {
                            alt57=5;
                            }
                            break;
                        case 51:
                            {
                            alt57=6;
                            }
                            break;
                    }

                    switch (alt57) {
                        case 1 :
                            // Morel.g:6569:4: a0= 'lhs'
                            {
                            a0=(Token)match(input,45,FOLLOW_45_in_parse_edu_ustb_sei_mde_morel_Pattern5694); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 2 :
                            // Morel.g:6585:8: a1= 'rhs'
                            {
                            a1=(Token)match(input,56,FOLLOW_56_in_parse_edu_ustb_sei_mde_morel_Pattern5709); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.RHS_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 3 :
                            // Morel.g:6601:8: a2= 'nac'
                            {
                            a2=(Token)match(input,47,FOLLOW_47_in_parse_edu_ustb_sei_mde_morel_Pattern5724); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.NAC_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 4 :
                            // Morel.g:6617:8: a3= 'pac'
                            {
                            a3=(Token)match(input,50,FOLLOW_50_in_parse_edu_ustb_sei_mde_morel_Pattern5739); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PAC_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 5 :
                            // Morel.g:6633:8: a4= 'pre'
                            {
                            a4=(Token)match(input,52,FOLLOW_52_in_parse_edu_ustb_sei_mde_morel_Pattern5754); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                            				// set value of enumeration attribute
                            				Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.PRE_VALUE).getInstance();
                            				element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				completedElement(value, false);
                            			}

                            }
                            break;
                        case 6 :
                            // Morel.g:6649:8: a5= 'post'
                            {
                            a5=(Token)match(input,51,FOLLOW_51_in_parse_edu_ustb_sei_mde_morel_Pattern5769); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_0, null, true);
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
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1444]);
                    	}

                    a8=(Token)match(input,64,FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_Pattern5790); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    			// initialize enumeration attribute
                    			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_1, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1445]);
                    	}

                    a9=(Token)match(input,46,FOLLOW_46_in_parse_edu_ustb_sei_mde_morel_Pattern5804); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    			// initialize enumeration attribute
                    			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_2, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1446]);
                    	}

                    a10=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_Pattern5818); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    			// initialize enumeration attribute
                    			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_3, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1447]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1448]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1449]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1450]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1451]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1452]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1453]);
                    	}

                    // Morel.g:6728:2: ( ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==IDENTIFIER) ) {
                        int LA59_1 = input.LA(2);

                        if ( (LA59_1==23) ) {
                            alt59=1;
                        }
                    }
                    switch (alt59) {
                        case 1 :
                            // Morel.g:6729:3: ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' )
                            {
                            // Morel.g:6729:3: ( (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';' )
                            // Morel.g:6730:4: (a11_0= parse_edu_ustb_sei_mde_morel_Variable ) ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )* a14= ';'
                            {
                            // Morel.g:6730:4: (a11_0= parse_edu_ustb_sei_mde_morel_Variable )
                            // Morel.g:6731:5: a11_0= parse_edu_ustb_sei_mde_morel_Variable
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Pattern5847);
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_4_0_0_0, a11_0, true);
                            						copyLocalizationInfos(a11_0, element);
                            					}
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1454]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1455]);
                            			}

                            // Morel.g:6760:4: ( (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) ) )*
                            loop58:
                            do {
                                int alt58=2;
                                int LA58_0 = input.LA(1);

                                if ( (LA58_0==18) ) {
                                    alt58=1;
                                }


                                switch (alt58) {
                            	case 1 :
                            	    // Morel.g:6761:5: (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                            	    {
                            	    // Morel.g:6761:5: (a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable ) )
                            	    // Morel.g:6762:6: a12= ',' (a13_0= parse_edu_ustb_sei_mde_morel_Variable )
                            	    {
                            	    a12=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_Pattern5888); if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    						if (element == null) {
                            	    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            	    							startIncompleteElement(element);
                            	    							// initialize enumeration attribute
                            	    							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            	    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            	    						}
                            	    						collectHiddenTokens(element);
                            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_4_0_0_1_0_0_0, null, true);
                            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
                            	    					}

                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1456]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1457]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1458]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1459]);
                            	    					}

                            	    // Morel.g:6782:6: (a13_0= parse_edu_ustb_sei_mde_morel_Variable )
                            	    // Morel.g:6783:7: a13_0= parse_edu_ustb_sei_mde_morel_Variable
                            	    {
                            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Pattern5922);
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
                            	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_4_0_0_1_0_0_1, a13_0, true);
                            	    								copyLocalizationInfos(a13_0, element);
                            	    							}
                            	    						}

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1460]);
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1461]);
                            	    					}

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop58;
                                }
                            } while (true);


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1462]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1463]);
                            			}

                            a14=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Pattern5983); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_4_0_0_2, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1464]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1465]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1466]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1467]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1468]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1469]);
                    	}

                    // Morel.g:6848:2: ( ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==IDENTIFIER) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // Morel.g:6849:3: ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' )
                            {
                            // Morel.g:6849:3: ( (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';' )
                            // Morel.g:6850:4: (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )* a18= ';'
                            {
                            // Morel.g:6850:4: (a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                            // Morel.g:6851:5: a15_0= parse_edu_ustb_sei_mde_morel_LinkConstraint
                            {
                            pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Pattern6031);
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
                            						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_5_0_0_0, a15_0, true);
                            						copyLocalizationInfos(a15_0, element);
                            					}
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1470]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1471]);
                            			}

                            // Morel.g:6880:4: ( (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) ) )*
                            loop60:
                            do {
                                int alt60=2;
                                int LA60_0 = input.LA(1);

                                if ( (LA60_0==18) ) {
                                    alt60=1;
                                }


                                switch (alt60) {
                            	case 1 :
                            	    // Morel.g:6881:5: (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) )
                            	    {
                            	    // Morel.g:6881:5: (a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint ) )
                            	    // Morel.g:6882:6: a16= ',' (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                            	    {
                            	    a16=(Token)match(input,18,FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_Pattern6072); if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    						if (element == null) {
                            	    							element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            	    							startIncompleteElement(element);
                            	    							// initialize enumeration attribute
                            	    							Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            	    							element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            	    						}
                            	    						collectHiddenTokens(element);
                            	    						retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_5_0_0_1_0_0_0, null, true);
                            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
                            	    					}

                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1472]);
                            	    					}

                            	    // Morel.g:6899:6: (a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint )
                            	    // Morel.g:6900:7: a17_0= parse_edu_ustb_sei_mde_morel_LinkConstraint
                            	    {
                            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Pattern6106);
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
                            	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_5_0_0_1_0_0_1, a17_0, true);
                            	    								copyLocalizationInfos(a17_0, element);
                            	    							}
                            	    						}

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1473]);
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1474]);
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
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1475]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1476]);
                            			}

                            a18=(Token)match(input,24,FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Pattern6167); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_5_0_0_2, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1477]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1478]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1479]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1480]);
                    	}

                    // Morel.g:6963:2: ( (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==63) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // Morel.g:6964:3: (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ )
                            {
                            // Morel.g:6964:3: (a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+ )
                            // Morel.g:6965:4: a19= 'when' a20= ':' ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+
                            {
                            a19=(Token)match(input,63,FOLLOW_63_in_parse_edu_ustb_sei_mde_morel_Pattern6209); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_6_0_0_0, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a19, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1481]);
                            			}

                            a20=(Token)match(input,23,FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_Pattern6229); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            				if (element == null) {
                            					element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                            					startIncompleteElement(element);
                            					// initialize enumeration attribute
                            					Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                            					element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                            				}
                            				collectHiddenTokens(element);
                            				retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_6_0_0_1, null, true);
                            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
                            			}

                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1482]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1483]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1484]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1485]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1486]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1487]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1488]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1489]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1490]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1491]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1492]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1493]);
                            			}

                            // Morel.g:7010:4: ( ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) ) )+
                            int cnt62=0;
                            loop62:
                            do {
                                int alt62=2;
                                int LA62_0 = input.LA(1);

                                if ( ((LA62_0 >= IDENTIFIER && LA62_0 <= INUMBER)||(LA62_0 >= QUOTED_39_39_92 && LA62_0 <= RNUMBER)||LA62_0==14||LA62_0==17||LA62_0==19||(LA62_0 >= 38 && LA62_0 <= 39)||LA62_0==41||LA62_0==44||LA62_0==48||LA62_0==61||LA62_0==64) ) {
                                    alt62=1;
                                }


                                switch (alt62) {
                            	case 1 :
                            	    // Morel.g:7011:5: ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) )
                            	    {
                            	    // Morel.g:7011:5: ( (a21_0= parse_edu_ustb_sei_mde_morel_Statement ) )
                            	    // Morel.g:7012:6: (a21_0= parse_edu_ustb_sei_mde_morel_Statement )
                            	    {
                            	    // Morel.g:7012:6: (a21_0= parse_edu_ustb_sei_mde_morel_Statement )
                            	    // Morel.g:7013:7: a21_0= parse_edu_ustb_sei_mde_morel_Statement
                            	    {
                            	    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_Pattern6270);
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
                            	    								retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_6_0_0_2_0_0_0, a21_0, true);
                            	    								copyLocalizationInfos(a21_0, element);
                            	    							}
                            	    						}

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1494]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1495]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1496]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1497]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1498]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1499]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1500]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1501]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1502]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1503]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1504]);
                            	    						addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1505]);
                            	    						addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1506]);
                            	    					}

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt62 >= 1 ) break loop62;
                            	    if (state.backtracking>0) {state.failed=true; return element;}
                                        EarlyExitException eee =
                                            new EarlyExitException(62, input);
                                        throw eee;
                                }
                                cnt62++;
                            } while (true);


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1507]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1508]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1509]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1510]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1511]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1512]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1513]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1514]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1515]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1516]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1517]);
                            				addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1518]);
                            				addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1519]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1520]);
                    	}

                    a22=(Token)match(input,66,FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_Pattern6344); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = edu.ustb.sei.mde.morel.MorelFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    			// initialize enumeration attribute
                    			Object value = edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSectionType().getEEnumLiteral(edu.ustb.sei.mde.morel.SectionType.LHS_VALUE).getInstance();
                    			element.eSet(element.eClass().getEStructuralFeature(edu.ustb.sei.mde.morel.MorelPackage.PATTERN__TYPE), value);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelGrammarInformationProvider.MOREL_33_0_0_7, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1521]);
                    		addExpectedElement(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(), edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1522]);
                    		addExpectedElement(null, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelExpectationConstants.EXPECTATIONS[1523]);
                    	}

                    }
                    break;
                case 2 :
                    // Morel.g:7100:2: c0= parse_edu_ustb_sei_mde_morel_Query
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_Query_in_parse_edu_ustb_sei_mde_morel_Pattern6363);
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
            if ( state.backtracking>0 ) { memoize(input, 35, parse_edu_ustb_sei_mde_morel_Pattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Pattern"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Variable"
    // Morel.g:7104:1: parse_edu_ustb_sei_mde_morel_Variable returns [edu.ustb.sei.mde.morel.Variable element = null] : (c0= parse_edu_ustb_sei_mde_morel_ObjectVariable |c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable |c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit |c3= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit );
    public final edu.ustb.sei.mde.morel.Variable parse_edu_ustb_sei_mde_morel_Variable() throws RecognitionException {
        edu.ustb.sei.mde.morel.Variable element =  null;

        int parse_edu_ustb_sei_mde_morel_Variable_StartIndex = input.index();

        edu.ustb.sei.mde.morel.ObjectVariable c0 =null;

        edu.ustb.sei.mde.morel.PrimitiveVariable c1 =null;

        edu.ustb.sei.mde.morel.ObjectVariableWithInit c2 =null;

        edu.ustb.sei.mde.morel.PrimitiveVariableWithInit c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Morel.g:7105:2: (c0= parse_edu_ustb_sei_mde_morel_ObjectVariable |c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable |c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit |c3= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit )
            int alt65=4;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==IDENTIFIER) ) {
                int LA65_1 = input.LA(2);

                if ( (synpred96_Morel()) ) {
                    alt65=1;
                }
                else if ( (synpred97_Morel()) ) {
                    alt65=2;
                }
                else if ( (synpred98_Morel()) ) {
                    alt65=3;
                }
                else if ( (true) ) {
                    alt65=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // Morel.g:7106:2: c0= parse_edu_ustb_sei_mde_morel_ObjectVariable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariable_in_parse_edu_ustb_sei_mde_morel_Variable6384);
                    c0=parse_edu_ustb_sei_mde_morel_ObjectVariable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7107:4: c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariable_in_parse_edu_ustb_sei_mde_morel_Variable6394);
                    c1=parse_edu_ustb_sei_mde_morel_PrimitiveVariable();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7108:4: c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_Variable6404);
                    c2=parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7109:4: c3= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_Variable6414);
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
            if ( state.backtracking>0 ) { memoize(input, 36, parse_edu_ustb_sei_mde_morel_Variable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Variable"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Statement"
    // Morel.g:7113:1: parse_edu_ustb_sei_mde_morel_Statement returns [edu.ustb.sei.mde.morel.Statement element = null] : (c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement |c1= parse_edu_ustb_sei_mde_morel_IfStatement |c2= parse_edu_ustb_sei_mde_morel_ForStatement |c3= parse_edu_ustb_sei_mde_morel_BlockStatement );
    public final edu.ustb.sei.mde.morel.Statement parse_edu_ustb_sei_mde_morel_Statement() throws RecognitionException {
        edu.ustb.sei.mde.morel.Statement element =  null;

        int parse_edu_ustb_sei_mde_morel_Statement_StartIndex = input.index();

        edu.ustb.sei.mde.morel.DeclarativeStatement c0 =null;

        edu.ustb.sei.mde.morel.IfStatement c1 =null;

        edu.ustb.sei.mde.morel.ForStatement c2 =null;

        edu.ustb.sei.mde.morel.BlockStatement c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }

            // Morel.g:7114:2: (c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement |c1= parse_edu_ustb_sei_mde_morel_IfStatement |c2= parse_edu_ustb_sei_mde_morel_ForStatement |c3= parse_edu_ustb_sei_mde_morel_BlockStatement )
            int alt66=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
            case INUMBER:
            case QUOTED_39_39_92:
            case RNUMBER:
            case 14:
            case 17:
            case 19:
            case 38:
            case 44:
            case 48:
            case 61:
                {
                alt66=1;
                }
                break;
            case 41:
                {
                int LA66_3 = input.LA(2);

                if ( (synpred99_Morel()) ) {
                    alt66=1;
                }
                else if ( (synpred100_Morel()) ) {
                    alt66=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 3, input);

                    throw nvae;

                }
                }
                break;
            case 39:
                {
                alt66=3;
                }
                break;
            case 64:
                {
                alt66=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }

            switch (alt66) {
                case 1 :
                    // Morel.g:7115:2: c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_DeclarativeStatement_in_parse_edu_ustb_sei_mde_morel_Statement6435);
                    c0=parse_edu_ustb_sei_mde_morel_DeclarativeStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7116:4: c1= parse_edu_ustb_sei_mde_morel_IfStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_parse_edu_ustb_sei_mde_morel_Statement6445);
                    c1=parse_edu_ustb_sei_mde_morel_IfStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7117:4: c2= parse_edu_ustb_sei_mde_morel_ForStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ForStatement_in_parse_edu_ustb_sei_mde_morel_Statement6455);
                    c2=parse_edu_ustb_sei_mde_morel_ForStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7118:4: c3= parse_edu_ustb_sei_mde_morel_BlockStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BlockStatement_in_parse_edu_ustb_sei_mde_morel_Statement6465);
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
            if ( state.backtracking>0 ) { memoize(input, 37, parse_edu_ustb_sei_mde_morel_Statement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Statement"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_CallPathExp"
    // Morel.g:7122:1: parse_edu_ustb_sei_mde_morel_CallPathExp returns [edu.ustb.sei.mde.morel.CallPathExp element = null] : (c0= parse_edu_ustb_sei_mde_morel_FeaturePathExp |c1= parse_edu_ustb_sei_mde_morel_OperationPathExp |c2= parse_edu_ustb_sei_mde_morel_IteratorPathExp );
    public final edu.ustb.sei.mde.morel.CallPathExp parse_edu_ustb_sei_mde_morel_CallPathExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.CallPathExp element =  null;

        int parse_edu_ustb_sei_mde_morel_CallPathExp_StartIndex = input.index();

        edu.ustb.sei.mde.morel.FeaturePathExp c0 =null;

        edu.ustb.sei.mde.morel.OperationPathExp c1 =null;

        edu.ustb.sei.mde.morel.IteratorPathExp c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Morel.g:7123:2: (c0= parse_edu_ustb_sei_mde_morel_FeaturePathExp |c1= parse_edu_ustb_sei_mde_morel_OperationPathExp |c2= parse_edu_ustb_sei_mde_morel_IteratorPathExp )
            int alt67=3;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==21) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==IDENTIFIER) ) {
                    int LA67_3 = input.LA(3);

                    if ( (LA67_3==EOF||LA67_3==13||(LA67_3 >= 15 && LA67_3 <= 22)||(LA67_3 >= 24 && LA67_3 <= 32)||(LA67_3 >= 35 && LA67_3 <= 36)||(LA67_3 >= 42 && LA67_3 <= 43)||LA67_3==49||LA67_3==59||LA67_3==65) ) {
                        alt67=1;
                    }
                    else if ( (LA67_3==14) ) {
                        alt67=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA67_0==20) ) {
                int LA67_2 = input.LA(2);

                if ( (LA67_2==IDENTIFIER) ) {
                    alt67=2;
                }
                else if ( ((LA67_2 >= 33 && LA67_2 <= 34)||LA67_2==37||LA67_2==40||LA67_2==55||LA67_2==58) ) {
                    alt67=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }
            switch (alt67) {
                case 1 :
                    // Morel.g:7124:2: c0= parse_edu_ustb_sei_mde_morel_FeaturePathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_FeaturePathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6486);
                    c0=parse_edu_ustb_sei_mde_morel_FeaturePathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7125:4: c1= parse_edu_ustb_sei_mde_morel_OperationPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_OperationPathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6496);
                    c1=parse_edu_ustb_sei_mde_morel_OperationPathExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7126:4: c2= parse_edu_ustb_sei_mde_morel_IteratorPathExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IteratorPathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6506);
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
            if ( state.backtracking>0 ) { memoize(input, 38, parse_edu_ustb_sei_mde_morel_CallPathExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_CallPathExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_VariableWithInit"
    // Morel.g:7130:1: parse_edu_ustb_sei_mde_morel_VariableWithInit returns [edu.ustb.sei.mde.morel.VariableWithInit element = null] : (c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit |c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit );
    public final edu.ustb.sei.mde.morel.VariableWithInit parse_edu_ustb_sei_mde_morel_VariableWithInit() throws RecognitionException {
        edu.ustb.sei.mde.morel.VariableWithInit element =  null;

        int parse_edu_ustb_sei_mde_morel_VariableWithInit_StartIndex = input.index();

        edu.ustb.sei.mde.morel.ObjectVariableWithInit c0 =null;

        edu.ustb.sei.mde.morel.PrimitiveVariableWithInit c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return element; }

            // Morel.g:7131:2: (c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit |c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==IDENTIFIER) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==23) ) {
                    int LA68_2 = input.LA(3);

                    if ( (LA68_2==IDENTIFIER) ) {
                        alt68=1;
                    }
                    else if ( (LA68_2==DATA_TYPE) ) {
                        alt68=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }
            switch (alt68) {
                case 1 :
                    // Morel.g:7132:2: c0= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_VariableWithInit6527);
                    c0=parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7133:4: c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_VariableWithInit6537);
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
            if ( state.backtracking>0 ) { memoize(input, 39, parse_edu_ustb_sei_mde_morel_VariableWithInit_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_VariableWithInit"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_Expression"
    // Morel.g:7137:1: parse_edu_ustb_sei_mde_morel_Expression returns [edu.ustb.sei.mde.morel.Expression element = null] : (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_LetExp |c7= parse_edu_ustb_sei_mde_morel_ConditionExp |c8= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp |c9= parse_edu_ustb_sei_mde_morel_BooleanOrExp |c10= parse_edu_ustb_sei_mde_morel_BooleanAndExp |c11= parse_edu_ustb_sei_mde_morel_RelationalExp |c12= parse_edu_ustb_sei_mde_morel_AdditiveExp |c13= parse_edu_ustb_sei_mde_morel_MultiplicativeExp |c14= parse_edu_ustb_sei_mde_morel_UnaryExp |c15= parse_edu_ustb_sei_mde_morel_BindExp );
    public final edu.ustb.sei.mde.morel.Expression parse_edu_ustb_sei_mde_morel_Expression() throws RecognitionException {
        edu.ustb.sei.mde.morel.Expression element =  null;

        int parse_edu_ustb_sei_mde_morel_Expression_StartIndex = input.index();

        edu.ustb.sei.mde.morel.VariableExp c0 =null;

        edu.ustb.sei.mde.morel.NestedExp c1 =null;

        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;

        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;

        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;

        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;

        edu.ustb.sei.mde.morel.LetExp c6 =null;

        edu.ustb.sei.mde.morel.ConditionExp c7 =null;

        edu.ustb.sei.mde.morel.BooleanImpliesExp c8 =null;

        edu.ustb.sei.mde.morel.BooleanOrExp c9 =null;

        edu.ustb.sei.mde.morel.BooleanAndExp c10 =null;

        edu.ustb.sei.mde.morel.RelationalExp c11 =null;

        edu.ustb.sei.mde.morel.AdditiveExp c12 =null;

        edu.ustb.sei.mde.morel.MultiplicativeExp c13 =null;

        edu.ustb.sei.mde.morel.UnaryExp c14 =null;

        edu.ustb.sei.mde.morel.BindExp c15 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }

            // Morel.g:7138:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_LetExp |c7= parse_edu_ustb_sei_mde_morel_ConditionExp |c8= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp |c9= parse_edu_ustb_sei_mde_morel_BooleanOrExp |c10= parse_edu_ustb_sei_mde_morel_BooleanAndExp |c11= parse_edu_ustb_sei_mde_morel_RelationalExp |c12= parse_edu_ustb_sei_mde_morel_AdditiveExp |c13= parse_edu_ustb_sei_mde_morel_MultiplicativeExp |c14= parse_edu_ustb_sei_mde_morel_UnaryExp |c15= parse_edu_ustb_sei_mde_morel_BindExp )
            int alt69=16;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA69_1 = input.LA(2);

                if ( (synpred105_Morel()) ) {
                    alt69=1;
                }
                else if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else if ( (true) ) {
                    alt69=16;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;

                }
                }
                break;
            case 14:
                {
                int LA69_2 = input.LA(2);

                if ( (synpred106_Morel()) ) {
                    alt69=2;
                }
                else if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 2, input);

                    throw nvae;

                }
                }
                break;
            case INUMBER:
                {
                int LA69_3 = input.LA(2);

                if ( (synpred107_Morel()) ) {
                    alt69=3;
                }
                else if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 3, input);

                    throw nvae;

                }
                }
                break;
            case RNUMBER:
                {
                int LA69_4 = input.LA(2);

                if ( (synpred108_Morel()) ) {
                    alt69=4;
                }
                else if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 4, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA69_5 = input.LA(2);

                if ( (synpred109_Morel()) ) {
                    alt69=5;
                }
                else if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 5, input);

                    throw nvae;

                }
                }
                break;
            case 61:
                {
                int LA69_6 = input.LA(2);

                if ( (synpred110_Morel()) ) {
                    alt69=6;
                }
                else if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 6, input);

                    throw nvae;

                }
                }
                break;
            case 38:
                {
                int LA69_7 = input.LA(2);

                if ( (synpred110_Morel()) ) {
                    alt69=6;
                }
                else if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 7, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                alt69=7;
                }
                break;
            case 41:
                {
                alt69=8;
                }
                break;
            case 17:
                {
                int LA69_10 = input.LA(2);

                if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 10, input);

                    throw nvae;

                }
                }
                break;
            case 19:
                {
                int LA69_11 = input.LA(2);

                if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 11, input);

                    throw nvae;

                }
                }
                break;
            case 48:
                {
                int LA69_12 = input.LA(2);

                if ( (synpred113_Morel()) ) {
                    alt69=9;
                }
                else if ( (synpred114_Morel()) ) {
                    alt69=10;
                }
                else if ( (synpred115_Morel()) ) {
                    alt69=11;
                }
                else if ( (synpred116_Morel()) ) {
                    alt69=12;
                }
                else if ( (synpred117_Morel()) ) {
                    alt69=13;
                }
                else if ( (synpred118_Morel()) ) {
                    alt69=14;
                }
                else if ( (synpred119_Morel()) ) {
                    alt69=15;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 12, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }

            switch (alt69) {
                case 1 :
                    // Morel.g:7139:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_Expression6558);
                    c0=parse_edu_ustb_sei_mde_morel_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7140:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_Expression6568);
                    c1=parse_edu_ustb_sei_mde_morel_NestedExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7141:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6578);
                    c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7142:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6588);
                    c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Morel.g:7143:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6598);
                    c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Morel.g:7144:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6608);
                    c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Morel.g:7145:4: c6= parse_edu_ustb_sei_mde_morel_LetExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_Expression6618);
                    c6=parse_edu_ustb_sei_mde_morel_LetExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Morel.g:7146:4: c7= parse_edu_ustb_sei_mde_morel_ConditionExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_Expression6628);
                    c7=parse_edu_ustb_sei_mde_morel_ConditionExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Morel.g:7147:4: c8= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_Expression6638);
                    c8=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Morel.g:7148:4: c9= parse_edu_ustb_sei_mde_morel_BooleanOrExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_Expression6648);
                    c9=parse_edu_ustb_sei_mde_morel_BooleanOrExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 11 :
                    // Morel.g:7149:4: c10= parse_edu_ustb_sei_mde_morel_BooleanAndExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_Expression6658);
                    c10=parse_edu_ustb_sei_mde_morel_BooleanAndExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c10; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 12 :
                    // Morel.g:7150:4: c11= parse_edu_ustb_sei_mde_morel_RelationalExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_Expression6668);
                    c11=parse_edu_ustb_sei_mde_morel_RelationalExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c11; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 13 :
                    // Morel.g:7151:4: c12= parse_edu_ustb_sei_mde_morel_AdditiveExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_Expression6678);
                    c12=parse_edu_ustb_sei_mde_morel_AdditiveExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c12; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 14 :
                    // Morel.g:7152:4: c13= parse_edu_ustb_sei_mde_morel_MultiplicativeExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_Expression6688);
                    c13=parse_edu_ustb_sei_mde_morel_MultiplicativeExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c13; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 15 :
                    // Morel.g:7153:4: c14= parse_edu_ustb_sei_mde_morel_UnaryExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_parse_edu_ustb_sei_mde_morel_Expression6698);
                    c14=parse_edu_ustb_sei_mde_morel_UnaryExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c14; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 16 :
                    // Morel.g:7154:4: c15= parse_edu_ustb_sei_mde_morel_BindExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_parse_edu_ustb_sei_mde_morel_Expression6708);
                    c15=parse_edu_ustb_sei_mde_morel_BindExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c15; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 40, parse_edu_ustb_sei_mde_morel_Expression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_Expression"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild"
    // Morel.g:7158:1: parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild returns [edu.ustb.sei.mde.morel.MultiplicativeExpChild element = null] : (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_UnaryExp );
    public final edu.ustb.sei.mde.morel.MultiplicativeExpChild parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild() throws RecognitionException {
        edu.ustb.sei.mde.morel.MultiplicativeExpChild element =  null;

        int parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_StartIndex = input.index();

        edu.ustb.sei.mde.morel.VariableExp c0 =null;

        edu.ustb.sei.mde.morel.NestedExp c1 =null;

        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;

        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;

        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;

        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;

        edu.ustb.sei.mde.morel.UnaryExp c6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return element; }

            // Morel.g:7159:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp |c6= parse_edu_ustb_sei_mde_morel_UnaryExp )
            int alt70=7;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA70_1 = input.LA(2);

                if ( (synpred120_Morel()) ) {
                    alt70=1;
                }
                else if ( (true) ) {
                    alt70=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;

                }
                }
                break;
            case 14:
                {
                int LA70_2 = input.LA(2);

                if ( (synpred121_Morel()) ) {
                    alt70=2;
                }
                else if ( (true) ) {
                    alt70=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 2, input);

                    throw nvae;

                }
                }
                break;
            case INUMBER:
                {
                int LA70_3 = input.LA(2);

                if ( (synpred122_Morel()) ) {
                    alt70=3;
                }
                else if ( (true) ) {
                    alt70=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 3, input);

                    throw nvae;

                }
                }
                break;
            case RNUMBER:
                {
                int LA70_4 = input.LA(2);

                if ( (synpred123_Morel()) ) {
                    alt70=4;
                }
                else if ( (true) ) {
                    alt70=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 4, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_39_39_92:
                {
                int LA70_5 = input.LA(2);

                if ( (synpred124_Morel()) ) {
                    alt70=5;
                }
                else if ( (true) ) {
                    alt70=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 5, input);

                    throw nvae;

                }
                }
                break;
            case 61:
                {
                int LA70_6 = input.LA(2);

                if ( (synpred125_Morel()) ) {
                    alt70=6;
                }
                else if ( (true) ) {
                    alt70=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 6, input);

                    throw nvae;

                }
                }
                break;
            case 38:
                {
                int LA70_7 = input.LA(2);

                if ( (synpred125_Morel()) ) {
                    alt70=6;
                }
                else if ( (true) ) {
                    alt70=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 7, input);

                    throw nvae;

                }
                }
                break;
            case 17:
            case 19:
            case 48:
                {
                alt70=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }

            switch (alt70) {
                case 1 :
                    // Morel.g:7160:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6729);
                    c0=parse_edu_ustb_sei_mde_morel_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7161:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6739);
                    c1=parse_edu_ustb_sei_mde_morel_NestedExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7162:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6749);
                    c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7163:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6759);
                    c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Morel.g:7164:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6769);
                    c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Morel.g:7165:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6779);
                    c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Morel.g:7166:4: c6= parse_edu_ustb_sei_mde_morel_UnaryExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6789);
                    c6=parse_edu_ustb_sei_mde_morel_UnaryExp();

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
            if ( state.backtracking>0 ) { memoize(input, 41, parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_AtomicExp"
    // Morel.g:7170:1: parse_edu_ustb_sei_mde_morel_AtomicExp returns [edu.ustb.sei.mde.morel.AtomicExp element = null] : (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp );
    public final edu.ustb.sei.mde.morel.AtomicExp parse_edu_ustb_sei_mde_morel_AtomicExp() throws RecognitionException {
        edu.ustb.sei.mde.morel.AtomicExp element =  null;

        int parse_edu_ustb_sei_mde_morel_AtomicExp_StartIndex = input.index();

        edu.ustb.sei.mde.morel.VariableExp c0 =null;

        edu.ustb.sei.mde.morel.NestedExp c1 =null;

        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;

        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;

        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;

        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return element; }

            // Morel.g:7171:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp |c1= parse_edu_ustb_sei_mde_morel_NestedExp |c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp |c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp |c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp |c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp )
            int alt71=6;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt71=1;
                }
                break;
            case 14:
                {
                alt71=2;
                }
                break;
            case INUMBER:
                {
                alt71=3;
                }
                break;
            case RNUMBER:
                {
                alt71=4;
                }
                break;
            case QUOTED_39_39_92:
                {
                alt71=5;
                }
                break;
            case 38:
            case 61:
                {
                alt71=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }

            switch (alt71) {
                case 1 :
                    // Morel.g:7172:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6810);
                    c0=parse_edu_ustb_sei_mde_morel_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7173:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6820);
                    c1=parse_edu_ustb_sei_mde_morel_NestedExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7174:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6830);
                    c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Morel.g:7175:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6840);
                    c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Morel.g:7176:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6850);
                    c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Morel.g:7177:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6860);
                    c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 42, parse_edu_ustb_sei_mde_morel_AtomicExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_AtomicExp"



    // $ANTLR start "parse_edu_ustb_sei_mde_morel_ImperativeStatement"
    // Morel.g:7181:1: parse_edu_ustb_sei_mde_morel_ImperativeStatement returns [edu.ustb.sei.mde.morel.ImperativeStatement element = null] : (c0= parse_edu_ustb_sei_mde_morel_IfStatement |c1= parse_edu_ustb_sei_mde_morel_ForStatement |c2= parse_edu_ustb_sei_mde_morel_BlockStatement );
    public final edu.ustb.sei.mde.morel.ImperativeStatement parse_edu_ustb_sei_mde_morel_ImperativeStatement() throws RecognitionException {
        edu.ustb.sei.mde.morel.ImperativeStatement element =  null;

        int parse_edu_ustb_sei_mde_morel_ImperativeStatement_StartIndex = input.index();

        edu.ustb.sei.mde.morel.IfStatement c0 =null;

        edu.ustb.sei.mde.morel.ForStatement c1 =null;

        edu.ustb.sei.mde.morel.BlockStatement c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return element; }

            // Morel.g:7182:2: (c0= parse_edu_ustb_sei_mde_morel_IfStatement |c1= parse_edu_ustb_sei_mde_morel_ForStatement |c2= parse_edu_ustb_sei_mde_morel_BlockStatement )
            int alt72=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt72=1;
                }
                break;
            case 39:
                {
                alt72=2;
                }
                break;
            case 64:
                {
                alt72=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }

            switch (alt72) {
                case 1 :
                    // Morel.g:7183:2: c0= parse_edu_ustb_sei_mde_morel_IfStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement6881);
                    c0=parse_edu_ustb_sei_mde_morel_IfStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Morel.g:7184:4: c1= parse_edu_ustb_sei_mde_morel_ForStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ForStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement6891);
                    c1=parse_edu_ustb_sei_mde_morel_ForStatement();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Morel.g:7185:4: c2= parse_edu_ustb_sei_mde_morel_BlockStatement
                    {
                    pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BlockStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement6901);
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
            if ( state.backtracking>0 ) { memoize(input, 43, parse_edu_ustb_sei_mde_morel_ImperativeStatement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_edu_ustb_sei_mde_morel_ImperativeStatement"

    // $ANTLR start synpred72_Morel
    public final void synpred72_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BindExp a0_0 =null;


        // Morel.g:5648:3: (a0_0= parse_edu_ustb_sei_mde_morel_BindExp )
        // Morel.g:5648:3: a0_0= parse_edu_ustb_sei_mde_morel_BindExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_synpred72_Morel4832);
        a0_0=parse_edu_ustb_sei_mde_morel_BindExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred72_Morel

    // $ANTLR start synpred75_Morel
    public final void synpred75_Morel_fragment() throws RecognitionException {
        Token a5=null;
        edu.ustb.sei.mde.morel.ImperativeStatement a6_0 =null;


        // Morel.g:5882:3: ( (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) ) )
        // Morel.g:5882:3: (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
        {
        // Morel.g:5882:3: (a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement ) )
        // Morel.g:5883:4: a5= 'else' (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
        {
        a5=(Token)match(input,35,FOLLOW_35_in_synpred75_Morel5016); if (state.failed) return ;

        // Morel.g:5899:4: (a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement )
        // Morel.g:5900:5: a6_0= parse_edu_ustb_sei_mde_morel_ImperativeStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_synpred75_Morel5042);
        a6_0=parse_edu_ustb_sei_mde_morel_ImperativeStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }

    }
    // $ANTLR end synpred75_Morel

    // $ANTLR start synpred96_Morel
    public final void synpred96_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.ObjectVariable c0 =null;


        // Morel.g:7106:2: (c0= parse_edu_ustb_sei_mde_morel_ObjectVariable )
        // Morel.g:7106:2: c0= parse_edu_ustb_sei_mde_morel_ObjectVariable
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariable_in_synpred96_Morel6384);
        c0=parse_edu_ustb_sei_mde_morel_ObjectVariable();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred96_Morel

    // $ANTLR start synpred97_Morel
    public final void synpred97_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.PrimitiveVariable c1 =null;


        // Morel.g:7107:4: (c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable )
        // Morel.g:7107:4: c1= parse_edu_ustb_sei_mde_morel_PrimitiveVariable
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariable_in_synpred97_Morel6394);
        c1=parse_edu_ustb_sei_mde_morel_PrimitiveVariable();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred97_Morel

    // $ANTLR start synpred98_Morel
    public final void synpred98_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.ObjectVariableWithInit c2 =null;


        // Morel.g:7108:4: (c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit )
        // Morel.g:7108:4: c2= parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_synpred98_Morel6404);
        c2=parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred98_Morel

    // $ANTLR start synpred99_Morel
    public final void synpred99_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.DeclarativeStatement c0 =null;


        // Morel.g:7115:2: (c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement )
        // Morel.g:7115:2: c0= parse_edu_ustb_sei_mde_morel_DeclarativeStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_DeclarativeStatement_in_synpred99_Morel6435);
        c0=parse_edu_ustb_sei_mde_morel_DeclarativeStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred99_Morel

    // $ANTLR start synpred100_Morel
    public final void synpred100_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.IfStatement c1 =null;


        // Morel.g:7116:4: (c1= parse_edu_ustb_sei_mde_morel_IfStatement )
        // Morel.g:7116:4: c1= parse_edu_ustb_sei_mde_morel_IfStatement
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_synpred100_Morel6445);
        c1=parse_edu_ustb_sei_mde_morel_IfStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred100_Morel

    // $ANTLR start synpred105_Morel
    public final void synpred105_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.VariableExp c0 =null;


        // Morel.g:7139:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp )
        // Morel.g:7139:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_synpred105_Morel6558);
        c0=parse_edu_ustb_sei_mde_morel_VariableExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred105_Morel

    // $ANTLR start synpred106_Morel
    public final void synpred106_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.NestedExp c1 =null;


        // Morel.g:7140:4: (c1= parse_edu_ustb_sei_mde_morel_NestedExp )
        // Morel.g:7140:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_synpred106_Morel6568);
        c1=parse_edu_ustb_sei_mde_morel_NestedExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred106_Morel

    // $ANTLR start synpred107_Morel
    public final void synpred107_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;


        // Morel.g:7141:4: (c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp )
        // Morel.g:7141:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_synpred107_Morel6578);
        c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred107_Morel

    // $ANTLR start synpred108_Morel
    public final void synpred108_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;


        // Morel.g:7142:4: (c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp )
        // Morel.g:7142:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_synpred108_Morel6588);
        c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred108_Morel

    // $ANTLR start synpred109_Morel
    public final void synpred109_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;


        // Morel.g:7143:4: (c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp )
        // Morel.g:7143:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_synpred109_Morel6598);
        c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred109_Morel

    // $ANTLR start synpred110_Morel
    public final void synpred110_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;


        // Morel.g:7144:4: (c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp )
        // Morel.g:7144:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_synpred110_Morel6608);
        c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred110_Morel

    // $ANTLR start synpred113_Morel
    public final void synpred113_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanImpliesExp c8 =null;


        // Morel.g:7147:4: (c8= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp )
        // Morel.g:7147:4: c8= parse_edu_ustb_sei_mde_morel_BooleanImpliesExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_synpred113_Morel6638);
        c8=parse_edu_ustb_sei_mde_morel_BooleanImpliesExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred113_Morel

    // $ANTLR start synpred114_Morel
    public final void synpred114_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanOrExp c9 =null;


        // Morel.g:7148:4: (c9= parse_edu_ustb_sei_mde_morel_BooleanOrExp )
        // Morel.g:7148:4: c9= parse_edu_ustb_sei_mde_morel_BooleanOrExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_synpred114_Morel6648);
        c9=parse_edu_ustb_sei_mde_morel_BooleanOrExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred114_Morel

    // $ANTLR start synpred115_Morel
    public final void synpred115_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanAndExp c10 =null;


        // Morel.g:7149:4: (c10= parse_edu_ustb_sei_mde_morel_BooleanAndExp )
        // Morel.g:7149:4: c10= parse_edu_ustb_sei_mde_morel_BooleanAndExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_synpred115_Morel6658);
        c10=parse_edu_ustb_sei_mde_morel_BooleanAndExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred115_Morel

    // $ANTLR start synpred116_Morel
    public final void synpred116_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.RelationalExp c11 =null;


        // Morel.g:7150:4: (c11= parse_edu_ustb_sei_mde_morel_RelationalExp )
        // Morel.g:7150:4: c11= parse_edu_ustb_sei_mde_morel_RelationalExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_synpred116_Morel6668);
        c11=parse_edu_ustb_sei_mde_morel_RelationalExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred116_Morel

    // $ANTLR start synpred117_Morel
    public final void synpred117_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.AdditiveExp c12 =null;


        // Morel.g:7151:4: (c12= parse_edu_ustb_sei_mde_morel_AdditiveExp )
        // Morel.g:7151:4: c12= parse_edu_ustb_sei_mde_morel_AdditiveExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_synpred117_Morel6678);
        c12=parse_edu_ustb_sei_mde_morel_AdditiveExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred117_Morel

    // $ANTLR start synpred118_Morel
    public final void synpred118_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.MultiplicativeExp c13 =null;


        // Morel.g:7152:4: (c13= parse_edu_ustb_sei_mde_morel_MultiplicativeExp )
        // Morel.g:7152:4: c13= parse_edu_ustb_sei_mde_morel_MultiplicativeExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_synpred118_Morel6688);
        c13=parse_edu_ustb_sei_mde_morel_MultiplicativeExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred118_Morel

    // $ANTLR start synpred119_Morel
    public final void synpred119_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.UnaryExp c14 =null;


        // Morel.g:7153:4: (c14= parse_edu_ustb_sei_mde_morel_UnaryExp )
        // Morel.g:7153:4: c14= parse_edu_ustb_sei_mde_morel_UnaryExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_synpred119_Morel6698);
        c14=parse_edu_ustb_sei_mde_morel_UnaryExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_Morel

    // $ANTLR start synpred120_Morel
    public final void synpred120_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.VariableExp c0 =null;


        // Morel.g:7160:2: (c0= parse_edu_ustb_sei_mde_morel_VariableExp )
        // Morel.g:7160:2: c0= parse_edu_ustb_sei_mde_morel_VariableExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_synpred120_Morel6729);
        c0=parse_edu_ustb_sei_mde_morel_VariableExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred120_Morel

    // $ANTLR start synpred121_Morel
    public final void synpred121_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.NestedExp c1 =null;


        // Morel.g:7161:4: (c1= parse_edu_ustb_sei_mde_morel_NestedExp )
        // Morel.g:7161:4: c1= parse_edu_ustb_sei_mde_morel_NestedExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_synpred121_Morel6739);
        c1=parse_edu_ustb_sei_mde_morel_NestedExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred121_Morel

    // $ANTLR start synpred122_Morel
    public final void synpred122_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.IntegerLiteralExp c2 =null;


        // Morel.g:7162:4: (c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp )
        // Morel.g:7162:4: c2= parse_edu_ustb_sei_mde_morel_IntegerLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_synpred122_Morel6749);
        c2=parse_edu_ustb_sei_mde_morel_IntegerLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred122_Morel

    // $ANTLR start synpred123_Morel
    public final void synpred123_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.RealLiteralExp c3 =null;


        // Morel.g:7163:4: (c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp )
        // Morel.g:7163:4: c3= parse_edu_ustb_sei_mde_morel_RealLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_synpred123_Morel6759);
        c3=parse_edu_ustb_sei_mde_morel_RealLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred123_Morel

    // $ANTLR start synpred124_Morel
    public final void synpred124_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.StringLiteralExp c4 =null;


        // Morel.g:7164:4: (c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp )
        // Morel.g:7164:4: c4= parse_edu_ustb_sei_mde_morel_StringLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_synpred124_Morel6769);
        c4=parse_edu_ustb_sei_mde_morel_StringLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred124_Morel

    // $ANTLR start synpred125_Morel
    public final void synpred125_Morel_fragment() throws RecognitionException {
        edu.ustb.sei.mde.morel.BooleanLiteralExp c5 =null;


        // Morel.g:7165:4: (c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp )
        // Morel.g:7165:4: c5= parse_edu_ustb_sei_mde_morel_BooleanLiteralExp
        {
        pushFollow(FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_synpred125_Morel6779);
        c5=parse_edu_ustb_sei_mde_morel_BooleanLiteralExp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred125_Morel

    // Delegated rules

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
    public final boolean synpred72_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_Morel_fragment(); // can never throw exception
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
    public final boolean synpred110_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred97_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_Morel_fragment(); // can never throw exception
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
    public final boolean synpred121_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_Morel_fragment(); // can never throw exception
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
    public final boolean synpred96_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_Morel_fragment(); // can never throw exception
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
    public final boolean synpred100_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_Morel_fragment(); // can never throw exception
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
    public final boolean synpred98_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_Morel_fragment(); // can never throw exception
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
    public final boolean synpred99_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_Morel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_Morel_fragment(); // can never throw exception
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
    public final boolean synpred75_Morel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_Morel_fragment(); // can never throw exception
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


 

    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_QueryModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_parse_edu_ustb_sei_mde_morel_QueryModel115 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypedModel_in_parse_edu_ustb_sei_mde_morel_QueryModel138 = new BitSet(new long[]{0x4020000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Query_in_parse_edu_ustb_sei_mde_morel_QueryModel173 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_62_in_parse_edu_ustb_sei_mde_morel_TypedModel214 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_TypedModel232 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_morel_TypedModel253 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_URINS_in_parse_edu_ustb_sei_mde_morel_TypedModel271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_parse_edu_ustb_sei_mde_morel_Query307 = new BitSet(new long[]{0x011CA00000000020L});
    public static final BitSet FOLLOW_45_in_parse_edu_ustb_sei_mde_morel_Query330 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_56_in_parse_edu_ustb_sei_mde_morel_Query345 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_47_in_parse_edu_ustb_sei_mde_morel_Query360 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_50_in_parse_edu_ustb_sei_mde_morel_Query375 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_52_in_parse_edu_ustb_sei_mde_morel_Query390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_51_in_parse_edu_ustb_sei_mde_morel_Query405 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_Query430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_Query451 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_edu_ustb_sei_mde_morel_Query465 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_Query479 = new BitSet(new long[]{0x8000000000000020L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Query508 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_Query549 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Query583 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Query644 = new BitSet(new long[]{0x8000000000000020L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Query692 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_Query733 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Query767 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Query828 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_63_in_parse_edu_ustb_sei_mde_morel_Query870 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_Query890 = new BitSet(new long[]{0x200112C0000A4360L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_Query931 = new BitSet(new long[]{0x200112C0000A4360L,0x0000000000000005L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_Query1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1038 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1059 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1088 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1121 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_ObjectVariable1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1213 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1234 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariable1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1307 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1328 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1357 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1427 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1448 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1531 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATA_TYPE_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1570 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1591 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1674 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1695 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1713 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1734 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_LinkConstraint1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_VariableExp1792 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_VariableExp1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_NestedExp1884 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1902 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1916 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1930 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_NestedExp1948 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_NestedExp1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INUMBER_in_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp2037 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RNUMBER_in_parse_edu_ustb_sei_mde_morel_RealLiteralExp2133 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_RealLiteralExp2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_edu_ustb_sei_mde_morel_StringLiteralExp2229 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_StringLiteralExp2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2330 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_38_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2345 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2437 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2455 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_FeaturePathExp2485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2535 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2550 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2575 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2596 = new BitSet(new long[]{0x20011240000AC360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2625 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2645 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2665 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2706 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2740 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2766 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2792 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2866 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_OperationPathExp2889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2930 = new BitSet(new long[]{0x0480012600000000L});
    public static final BitSet FOLLOW_40_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2953 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_37_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2968 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_58_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2983 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_55_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp2998 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_34_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3013 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_33_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3028 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3049 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3067 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3094 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3161 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3179 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3193 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3207 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3225 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_CallPathExp_in_parse_edu_ustb_sei_mde_morel_IteratorPathExp3254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_edu_ustb_sei_mde_morel_LetExp3310 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_LetExp3328 = new BitSet(new long[]{0x0000080000040000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_LetExp3355 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_LetExp3381 = new BitSet(new long[]{0x0000080000040000L});
    public static final BitSet FOLLOW_43_in_parse_edu_ustb_sei_mde_morel_LetExp3422 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_LetExp3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_LetExp3454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_LetExp3468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_edu_ustb_sei_mde_morel_ConditionExp3501 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ConditionExp3519 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_parse_edu_ustb_sei_mde_morel_ConditionExp3537 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Expression_in_parse_edu_ustb_sei_mde_morel_ConditionExp3555 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_morel_ConditionExp3573 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Expression_in_parse_edu_ustb_sei_mde_morel_ConditionExp3591 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_edu_ustb_sei_mde_morel_ConditionExp3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3642 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3682 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp3779 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp3819 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_BooleanOrExp3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp3916 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp3956 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_BooleanAndExp3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_RelationalExp4053 = new BitSet(new long[]{0x00000000FA002002L});
    public static final BitSet FOLLOW_29_in_parse_edu_ustb_sei_mde_morel_RelationalExp4093 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_28_in_parse_edu_ustb_sei_mde_morel_RelationalExp4112 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_13_in_parse_edu_ustb_sei_mde_morel_RelationalExp4131 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_25_in_parse_edu_ustb_sei_mde_morel_RelationalExp4150 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_27_in_parse_edu_ustb_sei_mde_morel_RelationalExp4169 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_30_in_parse_edu_ustb_sei_mde_morel_RelationalExp4188 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_31_in_parse_edu_ustb_sei_mde_morel_RelationalExp4207 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_RelationalExp4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4304 = new BitSet(new long[]{0x00000000000A0002L});
    public static final BitSet FOLLOW_17_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4344 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4363 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_AdditiveExp4400 = new BitSet(new long[]{0x00000000000A0002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4460 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_16_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4500 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_22_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4519 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExp4556 = new BitSet(new long[]{0x0000000000410002L});
    public static final BitSet FOLLOW_17_in_parse_edu_ustb_sei_mde_morel_UnaryExp4627 = new BitSet(new long[]{0x2000004000004360L});
    public static final BitSet FOLLOW_19_in_parse_edu_ustb_sei_mde_morel_UnaryExp4644 = new BitSet(new long[]{0x2000004000004360L});
    public static final BitSet FOLLOW_48_in_parse_edu_ustb_sei_mde_morel_UnaryExp4661 = new BitSet(new long[]{0x2000004000004360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AtomicExp_in_parse_edu_ustb_sei_mde_morel_UnaryExp4694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_BindExp4731 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_edu_ustb_sei_mde_morel_BindExp4749 = new BitSet(new long[]{0x20011240000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_BindExp4767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_BindExp4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_BindExp4795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4832 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4846 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4860 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4874 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_DeclarativeStatement4892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_edu_ustb_sei_mde_morel_IfStatement4921 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_IfStatement4935 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_IfStatement4953 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_IfStatement4971 = new BitSet(new long[]{0x0000028000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_IfStatement4989 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_parse_edu_ustb_sei_mde_morel_IfStatement5016 = new BitSet(new long[]{0x0000028000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_IfStatement5042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_edu_ustb_sei_mde_morel_ForStatement5098 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_edu_ustb_sei_mde_morel_ForStatement5112 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableWithInit_in_parse_edu_ustb_sei_mde_morel_ForStatement5130 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_ForStatement5148 = new BitSet(new long[]{0x20010040000A4360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5166 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_ForStatement5184 = new BitSet(new long[]{0x20011240000AC360L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5213 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5233 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_ForStatement5253 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_edu_ustb_sei_mde_morel_ForStatement5294 = new BitSet(new long[]{0x0000028000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_parse_edu_ustb_sei_mde_morel_ForStatement5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_BlockStatement5345 = new BitSet(new long[]{0x200112C0000A4360L,0x0000000000000005L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_BlockStatement5368 = new BitSet(new long[]{0x200112C0000A4360L,0x0000000000000005L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_BlockStatement5394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_parse_edu_ustb_sei_mde_morel_TransformationModel5423 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_TransformationModel5441 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_TypedModel_in_parse_edu_ustb_sei_mde_morel_TransformationModel5471 = new BitSet(new long[]{0x4200000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Rule_in_parse_edu_ustb_sei_mde_morel_TransformationModel5506 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_parse_edu_ustb_sei_mde_morel_Rule5547 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_edu_ustb_sei_mde_morel_Rule5565 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_Rule5586 = new BitSet(new long[]{0x013CA00000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Pattern_in_parse_edu_ustb_sei_mde_morel_Rule5615 = new BitSet(new long[]{0x013CA00000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_Rule5656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_edu_ustb_sei_mde_morel_Pattern5694 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_56_in_parse_edu_ustb_sei_mde_morel_Pattern5709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_47_in_parse_edu_ustb_sei_mde_morel_Pattern5724 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_50_in_parse_edu_ustb_sei_mde_morel_Pattern5739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_52_in_parse_edu_ustb_sei_mde_morel_Pattern5754 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_51_in_parse_edu_ustb_sei_mde_morel_Pattern5769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_parse_edu_ustb_sei_mde_morel_Pattern5790 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_edu_ustb_sei_mde_morel_Pattern5804 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_Pattern5818 = new BitSet(new long[]{0x8000000000000020L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Pattern5847 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_Pattern5888 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Variable_in_parse_edu_ustb_sei_mde_morel_Pattern5922 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Pattern5983 = new BitSet(new long[]{0x8000000000000020L,0x0000000000000004L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Pattern6031 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_18_in_parse_edu_ustb_sei_mde_morel_Pattern6072 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LinkConstraint_in_parse_edu_ustb_sei_mde_morel_Pattern6106 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_24_in_parse_edu_ustb_sei_mde_morel_Pattern6167 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_63_in_parse_edu_ustb_sei_mde_morel_Pattern6209 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edu_ustb_sei_mde_morel_Pattern6229 = new BitSet(new long[]{0x200112C0000A4360L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Statement_in_parse_edu_ustb_sei_mde_morel_Pattern6270 = new BitSet(new long[]{0x200112C0000A4360L,0x0000000000000005L});
    public static final BitSet FOLLOW_66_in_parse_edu_ustb_sei_mde_morel_Pattern6344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_Query_in_parse_edu_ustb_sei_mde_morel_Pattern6363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariable_in_parse_edu_ustb_sei_mde_morel_Variable6384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariable_in_parse_edu_ustb_sei_mde_morel_Variable6394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_Variable6404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_Variable6414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_DeclarativeStatement_in_parse_edu_ustb_sei_mde_morel_Statement6435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_parse_edu_ustb_sei_mde_morel_Statement6445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ForStatement_in_parse_edu_ustb_sei_mde_morel_Statement6455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BlockStatement_in_parse_edu_ustb_sei_mde_morel_Statement6465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_FeaturePathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_OperationPathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IteratorPathExp_in_parse_edu_ustb_sei_mde_morel_CallPathExp6506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_parse_edu_ustb_sei_mde_morel_VariableWithInit6527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit_in_parse_edu_ustb_sei_mde_morel_VariableWithInit6537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_Expression6558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_Expression6568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_Expression6608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_LetExp_in_parse_edu_ustb_sei_mde_morel_Expression6618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ConditionExp_in_parse_edu_ustb_sei_mde_morel_Expression6628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_parse_edu_ustb_sei_mde_morel_Expression6638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_parse_edu_ustb_sei_mde_morel_Expression6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_parse_edu_ustb_sei_mde_morel_Expression6658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_parse_edu_ustb_sei_mde_morel_Expression6668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_parse_edu_ustb_sei_mde_morel_Expression6678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_parse_edu_ustb_sei_mde_morel_Expression6688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_parse_edu_ustb_sei_mde_morel_Expression6698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_parse_edu_ustb_sei_mde_morel_Expression6708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_parse_edu_ustb_sei_mde_morel_MultiplicativeExpChild6789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_parse_edu_ustb_sei_mde_morel_AtomicExp6860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement6881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ForStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement6891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BlockStatement_in_parse_edu_ustb_sei_mde_morel_ImperativeStatement6901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BindExp_in_synpred72_Morel4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred75_Morel5016 = new BitSet(new long[]{0x0000028000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ImperativeStatement_in_synpred75_Morel5042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariable_in_synpred96_Morel6384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_PrimitiveVariable_in_synpred97_Morel6394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_ObjectVariableWithInit_in_synpred98_Morel6404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_DeclarativeStatement_in_synpred99_Morel6435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IfStatement_in_synpred100_Morel6445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_synpred105_Morel6558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_synpred106_Morel6568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_synpred107_Morel6578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_synpred108_Morel6588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_synpred109_Morel6598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_synpred110_Morel6608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanImpliesExp_in_synpred113_Morel6638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanOrExp_in_synpred114_Morel6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanAndExp_in_synpred115_Morel6658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RelationalExp_in_synpred116_Morel6668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_AdditiveExp_in_synpred117_Morel6678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_MultiplicativeExp_in_synpred118_Morel6688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_UnaryExp_in_synpred119_Morel6698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_VariableExp_in_synpred120_Morel6729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_NestedExp_in_synpred121_Morel6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_IntegerLiteralExp_in_synpred122_Morel6749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_RealLiteralExp_in_synpred123_Morel6759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_StringLiteralExp_in_synpred124_Morel6769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edu_ustb_sei_mde_morel_BooleanLiteralExp_in_synpred125_Morel6779 = new BitSet(new long[]{0x0000000000000002L});

}