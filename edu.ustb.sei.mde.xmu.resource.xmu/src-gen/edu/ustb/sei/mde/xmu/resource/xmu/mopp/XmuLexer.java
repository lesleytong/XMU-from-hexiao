// $ANTLR 3.4

	package edu.ustb.sei.mde.xmu.resource.xmu.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class XmuLexer extends Lexer {
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

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public XmuLexer() {} 
    public XmuLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public XmuLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Xmu.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:15:7: ( '(' )
            // Xmu.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:16:7: ( ')' )
            // Xmu.g:16:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:17:7: ( '*' )
            // Xmu.g:17:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:18:7: ( '+' )
            // Xmu.g:18:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:19:7: ( '++' )
            // Xmu.g:19:9: '++'
            {
            match("++"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:20:7: ( ',' )
            // Xmu.g:20:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:21:7: ( '-' )
            // Xmu.g:21:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:22:7: ( '->' )
            // Xmu.g:22:9: '->'
            {
            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:23:7: ( '.' )
            // Xmu.g:23:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:24:7: ( '/' )
            // Xmu.g:24:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:25:7: ( '//' )
            // Xmu.g:25:9: '//'
            {
            match("//"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:26:7: ( ':' )
            // Xmu.g:26:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:27:7: ( '::' )
            // Xmu.g:27:9: '::'
            {
            match("::"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:28:7: ( ';' )
            // Xmu.g:28:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:29:7: ( '<' )
            // Xmu.g:29:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:30:7: ( '<=' )
            // Xmu.g:30:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:31:7: ( '=' )
            // Xmu.g:31:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:32:7: ( '>' )
            // Xmu.g:32:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:33:7: ( '>=' )
            // Xmu.g:33:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:34:7: ( '[' )
            // Xmu.g:34:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:35:7: ( ']' )
            // Xmu.g:35:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:36:7: ( 'and' )
            // Xmu.g:36:9: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:37:7: ( 'by' )
            // Xmu.g:37:9: 'by'
            {
            match("by"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:38:7: ( 'case' )
            // Xmu.g:38:9: 'case'
            {
            match("case"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:39:7: ( 'context' )
            // Xmu.g:39:9: 'context'
            {
            match("context"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:40:7: ( 'delete' )
            // Xmu.g:40:9: 'delete'
            {
            match("delete"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:41:7: ( 'enforce' )
            // Xmu.g:41:9: 'enforce'
            {
            match("enforce"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:42:7: ( 'exists' )
            // Xmu.g:42:9: 'exists'
            {
            match("exists"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:43:7: ( 'forAll' )
            // Xmu.g:43:9: 'forAll'
            {
            match("forAll"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:44:7: ( 'import' )
            // Xmu.g:44:9: 'import'
            {
            match("import"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:45:7: ( 'match' )
            // Xmu.g:45:9: 'match'
            {
            match("match"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:46:7: ( 'nil' )
            // Xmu.g:46:9: 'nil'
            {
            match("nil"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:47:7: ( 'not' )
            // Xmu.g:47:9: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:48:7: ( 'null' )
            // Xmu.g:48:9: 'null'
            {
            match("null"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:49:7: ( 'or' )
            // Xmu.g:49:9: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:50:7: ( 'print' )
            // Xmu.g:50:9: 'print'
            {
            match("print"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:51:7: ( 'rule' )
            // Xmu.g:51:9: 'rule'
            {
            match("rule"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:52:7: ( 'select' )
            // Xmu.g:52:9: 'select'
            {
            match("select"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:53:7: ( 'source' )
            // Xmu.g:53:9: 'source'
            {
            match("source"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:54:7: ( 'start' )
            // Xmu.g:54:9: 'start'
            {
            match("start"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:55:7: ( 'switch' )
            // Xmu.g:55:9: 'switch'
            {
            match("switch"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:56:7: ( 'unmatchs' )
            // Xmu.g:56:9: 'unmatchs'
            {
            match("unmatchs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:57:7: ( 'unmatchv' )
            // Xmu.g:57:9: 'unmatchv'
            {
            match("unmatchv"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:58:7: ( 'update' )
            // Xmu.g:58:9: 'update'
            {
            match("update"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:59:7: ( 'updated' )
            // Xmu.g:59:9: 'updated'
            {
            match("updated"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:60:7: ( 'using' )
            // Xmu.g:60:9: 'using'
            {
            match("using"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:61:7: ( 'view' )
            // Xmu.g:61:9: 'view'
            {
            match("view"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:62:7: ( 'when' )
            // Xmu.g:62:9: 'when'
            {
            match("when"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:63:7: ( 'with' )
            // Xmu.g:63:9: 'with'
            {
            match("with"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:64:7: ( '{' )
            // Xmu.g:64:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:65:7: ( '|' )
            // Xmu.g:65:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:66:7: ( '}' )
            // Xmu.g:66:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "URI"
    public final void mURI() throws RecognitionException {
        try {
            int _type = URI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7003:4: ( ( '<' ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '/' | '\\\\' | '\\.' | ':' )+ '>' ) )
            // Xmu.g:7004:2: ( '<' ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '/' | '\\\\' | '\\.' | ':' )+ '>' )
            {
            // Xmu.g:7004:2: ( '<' ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '/' | '\\\\' | '\\.' | ':' )+ '>' )
            // Xmu.g:7004:3: '<' ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '/' | '\\\\' | '\\.' | ':' )+ '>'
            {
            match('<'); 

            // Xmu.g:7004:6: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '/' | '\\\\' | '\\.' | ':' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '-' && LA1_0 <= ':')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='\\'||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Xmu.g:
            	    {
            	    if ( (input.LA(1) >= '-' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match('>'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "URI"

    // $ANTLR start "PRIMITIVE"
    public final void mPRIMITIVE() throws RecognitionException {
        try {
            int _type = PRIMITIVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7006:10: ( ( 'String' | 'Boolean' | 'Integer' ) )
            // Xmu.g:7007:2: ( 'String' | 'Boolean' | 'Integer' )
            {
            // Xmu.g:7007:2: ( 'String' | 'Boolean' | 'Integer' )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 'S':
                {
                alt2=1;
                }
                break;
            case 'B':
                {
                alt2=2;
                }
                break;
            case 'I':
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // Xmu.g:7007:3: 'String'
                    {
                    match("String"); 



                    }
                    break;
                case 2 :
                    // Xmu.g:7007:12: 'Boolean'
                    {
                    match("Boolean"); 



                    }
                    break;
                case 3 :
                    // Xmu.g:7007:22: 'Integer'
                    {
                    match("Integer"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PRIMITIVE"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7009:8: ( ( 'true' | 'false' ) )
            // Xmu.g:7010:2: ( 'true' | 'false' )
            {
            // Xmu.g:7010:2: ( 'true' | 'false' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='t') ) {
                alt3=1;
            }
            else if ( (LA3_0=='f') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Xmu.g:7010:3: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // Xmu.g:7010:10: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7012:5: ( ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ( '@post' )? ) )
            // Xmu.g:7013:2: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ( '@post' )? )
            {
            // Xmu.g:7013:2: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ( '@post' )? )
            // Xmu.g:7013:3: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ( '@post' )?
            {
            // Xmu.g:7013:3: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // Xmu.g:7013:4: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!'
                    {
                    // Xmu.g:7013:4: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Xmu.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match('!'); 

                    }
                    break;

            }


            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Xmu.g:7013:65: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Xmu.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // Xmu.g:7013:98: ( '@post' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='@') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Xmu.g:7013:99: '@post'
                    {
                    match("@post"); 



                    }
                    break;

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7015:7: ( ( ( '0' .. '9' )+ ) )
            // Xmu.g:7016:2: ( ( '0' .. '9' )+ )
            {
            // Xmu.g:7016:2: ( ( '0' .. '9' )+ )
            // Xmu.g:7016:3: ( '0' .. '9' )+
            {
            // Xmu.g:7016:3: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Xmu.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7018:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Xmu.g:7019:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Xmu.g:7019:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Xmu.g:7019:4: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Xmu.g:7019:8: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Xmu.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7022:11: ( ( '/*' ( . )* '*/' ) )
            // Xmu.g:7023:2: ( '/*' ( . )* '*/' )
            {
            // Xmu.g:7023:2: ( '/*' ( . )* '*/' )
            // Xmu.g:7023:4: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Xmu.g:7023:8: ( . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1 >= '\u0000' && LA10_1 <= '.')||(LA10_1 >= '0' && LA10_1 <= '\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0 >= '\u0000' && LA10_0 <= ')')||(LA10_0 >= '+' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Xmu.g:7023:8: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match("*/"); 



            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7026:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Xmu.g:7027:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Xmu.g:7027:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Xmu.g:7027:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Xmu.g:7027:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='-'||(LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'Z')||LA11_0=='_'||(LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Xmu.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7030:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Xmu.g:7031:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7034:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Xmu.g:7035:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Xmu.g:7035:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Xmu.g:7035:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Xmu.g:7035:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\r') ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1=='\n') ) {
                    alt12=1;
                }
                else {
                    alt12=2;
                }
            }
            else if ( (LA12_0=='\n') ) {
                alt12=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Xmu.g:7035:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Xmu.g:7035:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Xmu.g:7035:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_39_39_92"
    public final void mQUOTED_39_39_92() throws RecognitionException {
        try {
            int _type = QUOTED_39_39_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu.g:7038:16: ( ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) ) )
            // Xmu.g:7039:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            {
            // Xmu.g:7039:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            // Xmu.g:7039:3: ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' )
            {
            // Xmu.g:7039:3: ( '\\'' )
            // Xmu.g:7039:4: '\\''
            {
            match('\''); 

            }


            // Xmu.g:7039:9: ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )*
            loop13:
            do {
                int alt13=4;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\\') ) {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2=='\'') ) {
                        alt13=1;
                    }
                    else if ( (LA13_2=='\\') ) {
                        alt13=2;
                    }


                }
                else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '&')||(LA13_0 >= '(' && LA13_0 <= '[')||(LA13_0 >= ']' && LA13_0 <= '\uFFFF')) ) {
                    alt13=3;
                }


                switch (alt13) {
            	case 1 :
            	    // Xmu.g:7039:10: ( '\\\\' '\\'' )
            	    {
            	    // Xmu.g:7039:10: ( '\\\\' '\\'' )
            	    // Xmu.g:7039:11: '\\\\' '\\''
            	    {
            	    match('\\'); 

            	    match('\''); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Xmu.g:7039:21: ( '\\\\' '\\\\' )
            	    {
            	    // Xmu.g:7039:21: ( '\\\\' '\\\\' )
            	    // Xmu.g:7039:22: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Xmu.g:7039:32: (~ ( '\\'' | '\\\\' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            // Xmu.g:7039:48: ( '\\'' )
            // Xmu.g:7039:49: '\\''
            {
            match('\''); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_39_39_92"

    public void mTokens() throws RecognitionException {
        // Xmu.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | URI | PRIMITIVE | BOOLEAN | NAME | NUMBER | SL_COMMENT | ML_COMMENT | TEXT | WHITESPACE | LINEBREAK | QUOTED_39_39_92 )
        int alt14=63;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // Xmu.g:1:10: T__15
                {
                mT__15(); 


                }
                break;
            case 2 :
                // Xmu.g:1:16: T__16
                {
                mT__16(); 


                }
                break;
            case 3 :
                // Xmu.g:1:22: T__17
                {
                mT__17(); 


                }
                break;
            case 4 :
                // Xmu.g:1:28: T__18
                {
                mT__18(); 


                }
                break;
            case 5 :
                // Xmu.g:1:34: T__19
                {
                mT__19(); 


                }
                break;
            case 6 :
                // Xmu.g:1:40: T__20
                {
                mT__20(); 


                }
                break;
            case 7 :
                // Xmu.g:1:46: T__21
                {
                mT__21(); 


                }
                break;
            case 8 :
                // Xmu.g:1:52: T__22
                {
                mT__22(); 


                }
                break;
            case 9 :
                // Xmu.g:1:58: T__23
                {
                mT__23(); 


                }
                break;
            case 10 :
                // Xmu.g:1:64: T__24
                {
                mT__24(); 


                }
                break;
            case 11 :
                // Xmu.g:1:70: T__25
                {
                mT__25(); 


                }
                break;
            case 12 :
                // Xmu.g:1:76: T__26
                {
                mT__26(); 


                }
                break;
            case 13 :
                // Xmu.g:1:82: T__27
                {
                mT__27(); 


                }
                break;
            case 14 :
                // Xmu.g:1:88: T__28
                {
                mT__28(); 


                }
                break;
            case 15 :
                // Xmu.g:1:94: T__29
                {
                mT__29(); 


                }
                break;
            case 16 :
                // Xmu.g:1:100: T__30
                {
                mT__30(); 


                }
                break;
            case 17 :
                // Xmu.g:1:106: T__31
                {
                mT__31(); 


                }
                break;
            case 18 :
                // Xmu.g:1:112: T__32
                {
                mT__32(); 


                }
                break;
            case 19 :
                // Xmu.g:1:118: T__33
                {
                mT__33(); 


                }
                break;
            case 20 :
                // Xmu.g:1:124: T__34
                {
                mT__34(); 


                }
                break;
            case 21 :
                // Xmu.g:1:130: T__35
                {
                mT__35(); 


                }
                break;
            case 22 :
                // Xmu.g:1:136: T__36
                {
                mT__36(); 


                }
                break;
            case 23 :
                // Xmu.g:1:142: T__37
                {
                mT__37(); 


                }
                break;
            case 24 :
                // Xmu.g:1:148: T__38
                {
                mT__38(); 


                }
                break;
            case 25 :
                // Xmu.g:1:154: T__39
                {
                mT__39(); 


                }
                break;
            case 26 :
                // Xmu.g:1:160: T__40
                {
                mT__40(); 


                }
                break;
            case 27 :
                // Xmu.g:1:166: T__41
                {
                mT__41(); 


                }
                break;
            case 28 :
                // Xmu.g:1:172: T__42
                {
                mT__42(); 


                }
                break;
            case 29 :
                // Xmu.g:1:178: T__43
                {
                mT__43(); 


                }
                break;
            case 30 :
                // Xmu.g:1:184: T__44
                {
                mT__44(); 


                }
                break;
            case 31 :
                // Xmu.g:1:190: T__45
                {
                mT__45(); 


                }
                break;
            case 32 :
                // Xmu.g:1:196: T__46
                {
                mT__46(); 


                }
                break;
            case 33 :
                // Xmu.g:1:202: T__47
                {
                mT__47(); 


                }
                break;
            case 34 :
                // Xmu.g:1:208: T__48
                {
                mT__48(); 


                }
                break;
            case 35 :
                // Xmu.g:1:214: T__49
                {
                mT__49(); 


                }
                break;
            case 36 :
                // Xmu.g:1:220: T__50
                {
                mT__50(); 


                }
                break;
            case 37 :
                // Xmu.g:1:226: T__51
                {
                mT__51(); 


                }
                break;
            case 38 :
                // Xmu.g:1:232: T__52
                {
                mT__52(); 


                }
                break;
            case 39 :
                // Xmu.g:1:238: T__53
                {
                mT__53(); 


                }
                break;
            case 40 :
                // Xmu.g:1:244: T__54
                {
                mT__54(); 


                }
                break;
            case 41 :
                // Xmu.g:1:250: T__55
                {
                mT__55(); 


                }
                break;
            case 42 :
                // Xmu.g:1:256: T__56
                {
                mT__56(); 


                }
                break;
            case 43 :
                // Xmu.g:1:262: T__57
                {
                mT__57(); 


                }
                break;
            case 44 :
                // Xmu.g:1:268: T__58
                {
                mT__58(); 


                }
                break;
            case 45 :
                // Xmu.g:1:274: T__59
                {
                mT__59(); 


                }
                break;
            case 46 :
                // Xmu.g:1:280: T__60
                {
                mT__60(); 


                }
                break;
            case 47 :
                // Xmu.g:1:286: T__61
                {
                mT__61(); 


                }
                break;
            case 48 :
                // Xmu.g:1:292: T__62
                {
                mT__62(); 


                }
                break;
            case 49 :
                // Xmu.g:1:298: T__63
                {
                mT__63(); 


                }
                break;
            case 50 :
                // Xmu.g:1:304: T__64
                {
                mT__64(); 


                }
                break;
            case 51 :
                // Xmu.g:1:310: T__65
                {
                mT__65(); 


                }
                break;
            case 52 :
                // Xmu.g:1:316: T__66
                {
                mT__66(); 


                }
                break;
            case 53 :
                // Xmu.g:1:322: URI
                {
                mURI(); 


                }
                break;
            case 54 :
                // Xmu.g:1:326: PRIMITIVE
                {
                mPRIMITIVE(); 


                }
                break;
            case 55 :
                // Xmu.g:1:336: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 56 :
                // Xmu.g:1:344: NAME
                {
                mNAME(); 


                }
                break;
            case 57 :
                // Xmu.g:1:349: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 58 :
                // Xmu.g:1:356: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 59 :
                // Xmu.g:1:367: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 60 :
                // Xmu.g:1:378: TEXT
                {
                mTEXT(); 


                }
                break;
            case 61 :
                // Xmu.g:1:383: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 62 :
                // Xmu.g:1:394: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 63 :
                // Xmu.g:1:404: QUOTED_39_39_92
                {
                mQUOTED_39_39_92(); 


                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA5_eotS =
        "\1\uffff\1\4\1\uffff\1\4\1\uffff";
    static final String DFA5_eofS =
        "\5\uffff";
    static final String DFA5_minS =
        "\1\60\1\41\1\uffff\1\41\1\uffff";
    static final String DFA5_maxS =
        "\2\172\1\uffff\1\172\1\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\1\1\uffff\1\2";
    static final String DFA5_specialS =
        "\5\uffff}>";
    static final String[] DFA5_transitionS = {
            "\12\2\7\uffff\32\1\4\uffff\1\1\1\uffff\32\1",
            "\1\2\16\uffff\12\3\7\uffff\32\3\4\uffff\1\3\1\uffff\32\3",
            "",
            "\1\2\16\uffff\12\3\7\uffff\32\3\4\uffff\1\3\1\uffff\32\3",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "7013:3: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' )?";
        }
    }
    static final String DFA14_eotS =
        "\4\uffff\1\55\1\uffff\1\57\1\uffff\1\63\1\65\1\uffff\1\67\1\uffff"+
        "\1\72\2\uffff\20\74\3\uffff\5\74\1\134\10\uffff\1\136\11\uffff\1"+
        "\74\1\uffff\1\74\1\141\14\74\1\156\20\74\1\uffff\1\60\2\uffff\1"+
        "\177\1\uffff\11\74\1\u0089\1\u008a\1\74\1\uffff\20\74\1\uffff\1"+
        "\u009c\10\74\2\uffff\1\u00a5\1\74\1\u00a7\7\74\1\u00af\1\u00b0\1"+
        "\u00b1\3\74\1\u00b5\1\uffff\5\74\1\u00b5\1\74\1\u00bc\1\uffff\1"+
        "\u00bd\1\uffff\2\74\1\u00c0\3\74\1\u00c4\3\uffff\3\74\1\uffff\1"+
        "\74\1\u00c9\1\74\1\u00cb\1\u00cc\1\u00cd\2\uffff\1\u00ce\1\u00cf"+
        "\1\uffff\1\u00d0\1\74\1\u00d3\1\uffff\1\u00d4\2\74\1\u00d7\1\uffff"+
        "\1\u00d8\6\uffff\1\74\1\u00db\2\uffff\2\u00d4\2\uffff\1\u00dc\1"+
        "\u00dd\3\uffff";
    static final String DFA14_eofS =
        "\u00de\uffff";
    static final String DFA14_minS =
        "\1\11\3\uffff\1\53\1\uffff\1\55\1\uffff\1\52\1\72\1\uffff\1\55\1"+
        "\uffff\1\75\2\uffff\20\55\3\uffff\5\55\1\41\10\uffff\1\0\11\uffff"+
        "\1\55\1\uffff\1\55\1\41\14\55\1\41\20\55\1\uffff\1\41\2\uffff\1"+
        "\41\1\uffff\11\55\2\41\1\55\1\uffff\20\55\1\uffff\1\41\10\55\2\uffff"+
        "\1\41\1\55\1\41\7\55\3\41\3\55\1\41\1\uffff\5\55\1\41\1\55\1\41"+
        "\1\uffff\1\41\1\uffff\2\55\1\41\3\55\1\41\3\uffff\3\55\1\uffff\1"+
        "\55\1\41\1\55\3\41\2\uffff\2\41\1\uffff\1\41\1\55\1\41\1\uffff\1"+
        "\41\2\55\1\41\1\uffff\1\41\6\uffff\1\55\1\41\2\uffff\2\41\2\uffff"+
        "\2\41\3\uffff";
    static final String DFA14_maxS =
        "\1\175\3\uffff\1\53\1\uffff\1\172\1\uffff\1\57\1\72\1\uffff\1\172"+
        "\1\uffff\1\75\2\uffff\20\172\3\uffff\6\172\10\uffff\1\ufffe\11\uffff"+
        "\1\172\1\uffff\37\172\1\uffff\1\172\2\uffff\1\172\1\uffff\14\172"+
        "\1\uffff\20\172\1\uffff\11\172\2\uffff\21\172\1\uffff\10\172\1\uffff"+
        "\1\172\1\uffff\7\172\3\uffff\3\172\1\uffff\6\172\2\uffff\2\172\1"+
        "\uffff\3\172\1\uffff\4\172\1\uffff\1\172\6\uffff\2\172\2\uffff\2"+
        "\172\2\uffff\2\172\3\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\uffff\1\11\2\uffff\1\16\1\uffff"+
        "\1\21\1\uffff\1\24\1\25\20\uffff\1\62\1\63\1\64\6\uffff\1\75\1\76"+
        "\1\77\1\5\1\4\1\10\1\7\1\74\1\uffff\1\73\1\12\1\15\1\14\1\20\1\17"+
        "\1\65\1\23\1\22\1\uffff\1\70\37\uffff\1\71\1\uffff\1\13\1\72\1\uffff"+
        "\1\27\14\uffff\1\43\20\uffff\1\26\11\uffff\1\40\1\41\21\uffff\1"+
        "\30\10\uffff\1\42\1\uffff\1\45\7\uffff\1\57\1\60\1\61\3\uffff\1"+
        "\67\6\uffff\1\37\1\44\2\uffff\1\50\3\uffff\1\56\4\uffff\1\32\1\uffff"+
        "\1\34\1\35\1\36\1\46\1\47\1\51\2\uffff\1\54\1\66\2\uffff\1\31\1"+
        "\33\2\uffff\1\55\1\52\1\53";
    static final String DFA14_specialS =
        "\u00de\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\51\1\52\1\uffff\1\51\1\52\22\uffff\1\51\6\uffff\1\53\1\1"+
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\12\50\1\11\1\12\1\13\1\14\1\15"+
            "\2\uffff\1\47\1\44\6\47\1\45\11\47\1\43\7\47\1\16\1\uffff\1"+
            "\17\1\uffff\1\47\1\uffff\1\20\1\21\1\22\1\23\1\24\1\25\2\47"+
            "\1\26\3\47\1\27\1\30\1\31\1\32\1\47\1\33\1\34\1\46\1\35\1\36"+
            "\1\37\3\47\1\40\1\41\1\42",
            "",
            "",
            "",
            "\1\54",
            "",
            "\1\60\2\uffff\12\60\4\uffff\1\56\2\uffff\32\60\4\uffff\1\60"+
            "\1\uffff\32\60",
            "",
            "\1\62\4\uffff\1\61",
            "\1\64",
            "",
            "\16\70\2\uffff\1\66\3\uffff\32\70\1\uffff\1\70\2\uffff\1\70"+
            "\1\uffff\32\70",
            "",
            "\1\71",
            "",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\73\14\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\30\75"+
            "\1\76\1\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\77"+
            "\15\75\1\100\13\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\101\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\102\11\75\1\103\2\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\105"+
            "\15\75\1\104\13\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\14\75"+
            "\1\106\15\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\107"+
            "\31\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75"+
            "\1\110\5\75\1\111\5\75\1\112\5\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\113\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\114\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\24\75"+
            "\1\115\5\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\116\11\75\1\117\4\75\1\120\2\75\1\121\3\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\122\1\75\1\123\2\75\1\124\7\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75"+
            "\1\125\21\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\7\75"+
            "\1\126\1\127\21\75",
            "",
            "",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\130\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\16\75"+
            "\1\131\13\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\132\14\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\133\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\50\7\uffff\32\135\4\uffff\1"+
            "\135\1\uffff\32\135",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\137\1\uffff\2\137\1\uffff\ufff1\137",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\3\75"+
            "\1\140\26\75",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\22\75"+
            "\1\142\7\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\143\14\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\144\16\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\5\75"+
            "\1\145\24\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75"+
            "\1\146\21\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\147\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\150\16\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\17\75"+
            "\1\151\12\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\152\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\153\16\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\154\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\155\16\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75"+
            "\1\157\21\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\160\16\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\161\16\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\24\75"+
            "\1\162\5\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\163"+
            "\31\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75"+
            "\1\164\21\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\14\75"+
            "\1\165\15\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\3\75"+
            "\1\166\26\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75"+
            "\1\167\21\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\170\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\171\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\172\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\173\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\16\75"+
            "\1\174\13\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\175\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\24\75"+
            "\1\176\5\75",
            "",
            "\1\74\16\uffff\12\135\7\uffff\32\135\4\uffff\1\135\1\uffff"+
            "\32\135",
            "",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u0080\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u0081\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u0082\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\16\75"+
            "\1\u0083\13\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\22\75"+
            "\1\u0084\7\75",
            "\1\60\2\uffff\12\75\7\uffff\1\u0085\31\75\4\uffff\1\75\1\uffff"+
            "\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\22\75"+
            "\1\u0086\7\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\16\75"+
            "\1\u0087\13\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\2\75"+
            "\1\u0088\27\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\u008b\16\75",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\u008c\14\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u008d\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u008e\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\u008f\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\u0090\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u0091\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\u0092"+
            "\31\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\u0093"+
            "\31\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\u0094\14\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\26\75"+
            "\1\u0095\3\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\u0096\14\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\7\75"+
            "\1\u0097\22\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\10\75"+
            "\1\u0098\21\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\u0099\16\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u009a\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u009b\25\75",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u009d\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u009e\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\u009f\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u00a0\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\u00a1\16\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u00a2\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\u00a3\10\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\7\75"+
            "\1\u00a4\22\75",
            "",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u00a6\6\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\2\75"+
            "\1\u00a8\27\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\2\75"+
            "\1\u00a9\27\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u00aa\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\2\75"+
            "\1\u00ab\27\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u00ac\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u00ad\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\6\75"+
            "\1\u00ae\23\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\u00b2\14\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u00b3\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\6\75"+
            "\1\u00b4\23\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\27\75"+
            "\1\u00b6\2\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u00b7\25\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\2\75"+
            "\1\u00b8\27\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\22\75"+
            "\1\u00b9\7\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\13\75"+
            "\1\u00ba\16\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u00bb\6\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u00be\6\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u00bf\25\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\7\75"+
            "\1\u00c1\22\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\2\75"+
            "\1\u00c2\27\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u00c3\25\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\6\75"+
            "\1\u00c5\23\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\1\u00c6"+
            "\31\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u00c7\25\75",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\23\75"+
            "\1\u00c8\6\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\4\75"+
            "\1\u00ca\25\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\7\75"+
            "\1\u00d1\22\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\3\75\1\u00d2\26\75",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\15\75"+
            "\1\u00d5\14\75",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\21\75"+
            "\1\u00d6\10\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60\2\uffff\12\75\7\uffff\32\75\4\uffff\1\75\1\uffff\22\75"+
            "\1\u00d9\2\75\1\u00da\4\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "\1\74\13\uffff\1\60\2\uffff\12\75\6\uffff\1\74\32\75\4\uffff"+
            "\1\75\1\uffff\32\75",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | URI | PRIMITIVE | BOOLEAN | NAME | NUMBER | SL_COMMENT | ML_COMMENT | TEXT | WHITESPACE | LINEBREAK | QUOTED_39_39_92 );";
        }
    }
 

}