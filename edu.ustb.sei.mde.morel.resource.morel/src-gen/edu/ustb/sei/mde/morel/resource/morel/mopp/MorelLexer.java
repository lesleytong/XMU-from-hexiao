// $ANTLR 3.4

	package edu.ustb.sei.mde.morel.resource.morel.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MorelLexer extends Lexer {
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

    public MorelLexer() {} 
    public MorelLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MorelLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Morel.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:15:7: ( '!' )
            // Morel.g:15:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:16:7: ( '!=' )
            // Morel.g:16:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:17:7: ( '(' )
            // Morel.g:17:9: '('
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:18:7: ( ')' )
            // Morel.g:18:9: ')'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:19:7: ( '*' )
            // Morel.g:19:9: '*'
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:20:7: ( '+' )
            // Morel.g:20:9: '+'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:21:7: ( ',' )
            // Morel.g:21:9: ','
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:22:7: ( '-' )
            // Morel.g:22:9: '-'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:23:7: ( '->' )
            // Morel.g:23:9: '->'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:24:7: ( '.' )
            // Morel.g:24:9: '.'
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:25:7: ( '/' )
            // Morel.g:25:9: '/'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:26:7: ( ':' )
            // Morel.g:26:9: ':'
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:27:7: ( ';' )
            // Morel.g:27:9: ';'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:28:7: ( '<' )
            // Morel.g:28:9: '<'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:29:7: ( '<-' )
            // Morel.g:29:9: '<-'
            {
            match("<-"); 



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
            // Morel.g:30:7: ( '<=' )
            // Morel.g:30:9: '<='
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:31:7: ( '<>' )
            // Morel.g:31:9: '<>'
            {
            match("<>"); 



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
            // Morel.g:32:7: ( '=' )
            // Morel.g:32:9: '='
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:33:7: ( '>' )
            // Morel.g:33:9: '>'
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:34:7: ( '>=' )
            // Morel.g:34:9: '>='
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:35:7: ( 'and' )
            // Morel.g:35:9: 'and'
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:36:7: ( 'closure' )
            // Morel.g:36:9: 'closure'
            {
            match("closure"); 



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
            // Morel.g:37:7: ( 'collect' )
            // Morel.g:37:9: 'collect'
            {
            match("collect"); 



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
            // Morel.g:38:7: ( 'else' )
            // Morel.g:38:9: 'else'
            {
            match("else"); 



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
            // Morel.g:39:7: ( 'endif' )
            // Morel.g:39:9: 'endif'
            {
            match("endif"); 



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
            // Morel.g:40:7: ( 'exists' )
            // Morel.g:40:9: 'exists'
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:41:7: ( 'false' )
            // Morel.g:41:9: 'false'
            {
            match("false"); 



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
            // Morel.g:42:7: ( 'for' )
            // Morel.g:42:9: 'for'
            {
            match("for"); 



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
            // Morel.g:43:7: ( 'forAll' )
            // Morel.g:43:9: 'forAll'
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
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:44:7: ( 'if' )
            // Morel.g:44:9: 'if'
            {
            match("if"); 



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
            // Morel.g:45:7: ( 'implies' )
            // Morel.g:45:9: 'implies'
            {
            match("implies"); 



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
            // Morel.g:46:7: ( 'in' )
            // Morel.g:46:9: 'in'
            {
            match("in"); 



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
            // Morel.g:47:7: ( 'let' )
            // Morel.g:47:9: 'let'
            {
            match("let"); 



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
            // Morel.g:48:7: ( 'lhs' )
            // Morel.g:48:9: 'lhs'
            {
            match("lhs"); 



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
            // Morel.g:49:7: ( 'match' )
            // Morel.g:49:9: 'match'
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
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:50:7: ( 'nac' )
            // Morel.g:50:9: 'nac'
            {
            match("nac"); 



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
            // Morel.g:51:7: ( 'not' )
            // Morel.g:51:9: 'not'
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
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:52:7: ( 'or' )
            // Morel.g:52:9: 'or'
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
            // Morel.g:53:7: ( 'pac' )
            // Morel.g:53:9: 'pac'
            {
            match("pac"); 



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
            // Morel.g:54:7: ( 'post' )
            // Morel.g:54:9: 'post'
            {
            match("post"); 



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
            // Morel.g:55:7: ( 'pre' )
            // Morel.g:55:9: 'pre'
            {
            match("pre"); 



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
            // Morel.g:56:7: ( 'query' )
            // Morel.g:56:9: 'query'
            {
            match("query"); 



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
            // Morel.g:57:7: ( 'querymodel' )
            // Morel.g:57:9: 'querymodel'
            {
            match("querymodel"); 



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
            // Morel.g:58:7: ( 'reject' )
            // Morel.g:58:9: 'reject'
            {
            match("reject"); 



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
            // Morel.g:59:7: ( 'rhs' )
            // Morel.g:59:9: 'rhs'
            {
            match("rhs"); 



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
            // Morel.g:60:7: ( 'rule' )
            // Morel.g:60:9: 'rule'
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
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:61:7: ( 'select' )
            // Morel.g:61:9: 'select'
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
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:62:7: ( 'then' )
            // Morel.g:62:9: 'then'
            {
            match("then"); 



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
            // Morel.g:63:7: ( 'transformation' )
            // Morel.g:63:9: 'transformation'
            {
            match("transformation"); 



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
            // Morel.g:64:7: ( 'true' )
            // Morel.g:64:9: 'true'
            {
            match("true"); 



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
            // Morel.g:65:7: ( 'type' )
            // Morel.g:65:9: 'type'
            {
            match("type"); 



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
            // Morel.g:66:7: ( 'when' )
            // Morel.g:66:9: 'when'
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
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:67:7: ( '{' )
            // Morel.g:67:9: '{'
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
            // Morel.g:68:7: ( '|' )
            // Morel.g:68:9: '|'
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
            // Morel.g:69:7: ( '}' )
            // Morel.g:69:9: '}'
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

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:7189:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Morel.g:7190:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Morel.g:7190:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Morel.g:7190:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Morel.g:7190:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='\n') ) {
                    alt1=1;
                }
                else {
                    alt1=2;
                }
            }
            else if ( (LA1_0=='\n') ) {
                alt1=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // Morel.g:7190:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Morel.g:7190:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Morel.g:7190:16: '\\n'
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

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:7193:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Morel.g:7194:2: ( ( ' ' | '\\t' | '\\f' ) )
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

    // $ANTLR start "DATA_TYPE"
    public final void mDATA_TYPE() throws RecognitionException {
        try {
            int _type = DATA_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:7197:10: ( ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )* | ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+ ) )
            // Morel.g:7198:2: ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )* | ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+ )
            {
            // Morel.g:7198:2: ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )* | ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+ )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // Morel.g:7198:3: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )*
                    {
                    // Morel.g:7198:3: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )*
                    loop3:
                    do {
                        int alt3=2;
                        switch ( input.LA(1) ) {
                        case 'S':
                            {
                            int LA3_1 = input.LA(2);

                            if ( (LA3_1=='e') ) {
                                alt3=1;
                            }


                            }
                            break;
                        case 'B':
                            {
                            int LA3_3 = input.LA(2);

                            if ( (LA3_3=='a') ) {
                                alt3=1;
                            }


                            }
                            break;
                        case 'O':
                            {
                            alt3=1;
                            }
                            break;

                        }

                        switch (alt3) {
                    	case 1 :
                    	    // Morel.g:7198:4: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '('
                    	    {
                    	    // Morel.g:7198:4: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' )
                    	    int alt2=4;
                    	    switch ( input.LA(1) ) {
                    	    case 'S':
                    	        {
                    	        int LA2_1 = input.LA(2);

                    	        if ( (LA2_1=='e') ) {
                    	            int LA2_4 = input.LA(3);

                    	            if ( (LA2_4=='q') ) {
                    	                alt2=1;
                    	            }
                    	            else if ( (LA2_4=='t') ) {
                    	                alt2=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 2, 4, input);

                    	                throw nvae;

                    	            }
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 2, 1, input);

                    	            throw nvae;

                    	        }
                    	        }
                    	        break;
                    	    case 'B':
                    	        {
                    	        alt2=3;
                    	        }
                    	        break;
                    	    case 'O':
                    	        {
                    	        alt2=4;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 2, 0, input);

                    	        throw nvae;

                    	    }

                    	    switch (alt2) {
                    	        case 1 :
                    	            // Morel.g:7198:5: 'Sequence'
                    	            {
                    	            match("Sequence"); 



                    	            }
                    	            break;
                    	        case 2 :
                    	            // Morel.g:7198:16: 'Set'
                    	            {
                    	            match("Set"); 



                    	            }
                    	            break;
                    	        case 3 :
                    	            // Morel.g:7198:22: 'Bag'
                    	            {
                    	            match("Bag"); 



                    	            }
                    	            break;
                    	        case 4 :
                    	            // Morel.g:7198:28: 'OrderedSet'
                    	            {
                    	            match("OrderedSet"); 



                    	            }
                    	            break;

                    	    }


                    	    match('('); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    // Morel.g:7198:46: ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' )
                    int alt4=6;
                    switch ( input.LA(1) ) {
                    case 'S':
                        {
                        alt4=1;
                        }
                        break;
                    case 'I':
                        {
                        alt4=2;
                        }
                        break;
                    case 'B':
                        {
                        alt4=3;
                        }
                        break;
                    case 'R':
                        {
                        alt4=4;
                        }
                        break;
                    case 'C':
                        {
                        alt4=5;
                        }
                        break;
                    case 'A':
                        {
                        alt4=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;

                    }

                    switch (alt4) {
                        case 1 :
                            // Morel.g:7198:47: 'String'
                            {
                            match("String"); 



                            }
                            break;
                        case 2 :
                            // Morel.g:7198:56: 'Integer'
                            {
                            match("Integer"); 



                            }
                            break;
                        case 3 :
                            // Morel.g:7198:66: 'Boolean'
                            {
                            match("Boolean"); 



                            }
                            break;
                        case 4 :
                            // Morel.g:7198:76: 'Real'
                            {
                            match("Real"); 



                            }
                            break;
                        case 5 :
                            // Morel.g:7198:83: 'Char'
                            {
                            match("Char"); 



                            }
                            break;
                        case 6 :
                            // Morel.g:7198:90: 'Any'
                            {
                            match("Any"); 



                            }
                            break;

                    }


                    // Morel.g:7198:96: ( ')' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==')') ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Morel.g:7198:96: ')'
                    	    {
                    	    match(')'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Morel.g:7198:101: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+
                    {
                    // Morel.g:7198:101: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        switch ( input.LA(1) ) {
                        case 'S':
                            {
                            int LA7_1 = input.LA(2);

                            if ( (LA7_1=='e') ) {
                                int LA7_5 = input.LA(3);

                                if ( (LA7_5=='q') ) {
                                    int LA7_8 = input.LA(4);

                                    if ( (LA7_8=='u') ) {
                                        int LA7_12 = input.LA(5);

                                        if ( (LA7_12=='e') ) {
                                            int LA7_15 = input.LA(6);

                                            if ( (LA7_15=='n') ) {
                                                int LA7_17 = input.LA(7);

                                                if ( (LA7_17=='c') ) {
                                                    int LA7_19 = input.LA(8);

                                                    if ( (LA7_19=='e') ) {
                                                        int LA7_21 = input.LA(9);

                                                        if ( (LA7_21=='(') ) {
                                                            alt7=1;
                                                        }


                                                    }


                                                }


                                            }


                                        }


                                    }


                                }
                                else if ( (LA7_5=='t') ) {
                                    int LA7_9 = input.LA(4);

                                    if ( (LA7_9=='(') ) {
                                        alt7=1;
                                    }


                                }


                            }


                            }
                            break;
                        case 'B':
                            {
                            int LA7_2 = input.LA(2);

                            if ( (LA7_2=='a') ) {
                                int LA7_6 = input.LA(3);

                                if ( (LA7_6=='g') ) {
                                    int LA7_10 = input.LA(4);

                                    if ( (LA7_10=='(') ) {
                                        alt7=1;
                                    }


                                }


                            }


                            }
                            break;
                        case 'O':
                            {
                            int LA7_3 = input.LA(2);

                            if ( (LA7_3=='r') ) {
                                int LA7_7 = input.LA(3);

                                if ( (LA7_7=='d') ) {
                                    int LA7_11 = input.LA(4);

                                    if ( (LA7_11=='e') ) {
                                        int LA7_14 = input.LA(5);

                                        if ( (LA7_14=='r') ) {
                                            int LA7_16 = input.LA(6);

                                            if ( (LA7_16=='e') ) {
                                                int LA7_18 = input.LA(7);

                                                if ( (LA7_18=='d') ) {
                                                    int LA7_20 = input.LA(8);

                                                    if ( (LA7_20=='S') ) {
                                                        int LA7_22 = input.LA(9);

                                                        if ( (LA7_22=='e') ) {
                                                            int LA7_23 = input.LA(10);

                                                            if ( (LA7_23=='t') ) {
                                                                int LA7_24 = input.LA(11);

                                                                if ( (LA7_24=='(') ) {
                                                                    alt7=1;
                                                                }


                                                            }


                                                        }


                                                    }


                                                }


                                            }


                                        }


                                    }


                                }


                            }


                            }
                            break;

                        }

                        switch (alt7) {
                    	case 1 :
                    	    // Morel.g:7198:102: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '('
                    	    {
                    	    // Morel.g:7198:102: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' )
                    	    int alt6=4;
                    	    switch ( input.LA(1) ) {
                    	    case 'S':
                    	        {
                    	        int LA6_1 = input.LA(2);

                    	        if ( (LA6_1=='e') ) {
                    	            int LA6_4 = input.LA(3);

                    	            if ( (LA6_4=='q') ) {
                    	                alt6=1;
                    	            }
                    	            else if ( (LA6_4=='t') ) {
                    	                alt6=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 6, 4, input);

                    	                throw nvae;

                    	            }
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 6, 1, input);

                    	            throw nvae;

                    	        }
                    	        }
                    	        break;
                    	    case 'B':
                    	        {
                    	        alt6=3;
                    	        }
                    	        break;
                    	    case 'O':
                    	        {
                    	        alt6=4;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 6, 0, input);

                    	        throw nvae;

                    	    }

                    	    switch (alt6) {
                    	        case 1 :
                    	            // Morel.g:7198:103: 'Sequence'
                    	            {
                    	            match("Sequence"); 



                    	            }
                    	            break;
                    	        case 2 :
                    	            // Morel.g:7198:114: 'Set'
                    	            {
                    	            match("Set"); 



                    	            }
                    	            break;
                    	        case 3 :
                    	            // Morel.g:7198:120: 'Bag'
                    	            {
                    	            match("Bag"); 



                    	            }
                    	            break;
                    	        case 4 :
                    	            // Morel.g:7198:126: 'OrderedSet'
                    	            {
                    	            match("OrderedSet"); 



                    	            }
                    	            break;

                    	    }


                    	    match('('); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    // Morel.g:7198:144: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
                    // Morel.g:7198:145: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Morel.g:7198:168: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Morel.g:
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
                    	    break loop8;
                        }
                    } while (true);


                    }


                    // Morel.g:7198:202: ( ')' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==')') ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Morel.g:7198:202: ')'
                    	    {
                    	    match(')'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


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
    // $ANTLR end "DATA_TYPE"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:7200:11: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) )
            // Morel.g:7201:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            {
            // Morel.g:7201:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // Morel.g:7201:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Morel.g:7201:26: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'Z')||LA11_0=='_'||(LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Morel.g:
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
            	    break loop11;
                }
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
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "URINS"
    public final void mURINS() throws RecognitionException {
        try {
            int _type = URINS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:7203:6: ( ( '#' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+ '#' ) )
            // Morel.g:7204:2: ( '#' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+ '#' )
            {
            // Morel.g:7204:2: ( '#' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+ '#' )
            // Morel.g:7204:3: '#' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+ '#'
            {
            match('#'); 

            // Morel.g:7204:6: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '-' && LA12_0 <= ':')||(LA12_0 >= 'A' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'a' && LA12_0 <= 'z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Morel.g:
            	    {
            	    if ( (input.LA(1) >= '-' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            match('#'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "URINS"

    // $ANTLR start "INUMBER"
    public final void mINUMBER() throws RecognitionException {
        try {
            int _type = INUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:7206:8: ( ( ( '0' .. '9' ) ( '0' .. '1' )* ) )
            // Morel.g:7207:2: ( ( '0' .. '9' ) ( '0' .. '1' )* )
            {
            // Morel.g:7207:2: ( ( '0' .. '9' ) ( '0' .. '1' )* )
            // Morel.g:7207:3: ( '0' .. '9' ) ( '0' .. '1' )*
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Morel.g:7207:13: ( '0' .. '1' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= '0' && LA13_0 <= '1')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Morel.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
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


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INUMBER"

    // $ANTLR start "RNUMBER"
    public final void mRNUMBER() throws RecognitionException {
        try {
            int _type = RNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:7209:8: ( ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+ ) )
            // Morel.g:7210:2: ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+ )
            {
            // Morel.g:7210:2: ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+ )
            // Morel.g:7210:3: ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+
            {
            // Morel.g:7210:3: ( '0' .. '9' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Morel.g:
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
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            match('.'); 

            // Morel.g:7210:18: ( '0' .. '9' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Morel.g:
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
    // $ANTLR end "RNUMBER"

    // $ANTLR start "QUOTED_39_39_92"
    public final void mQUOTED_39_39_92() throws RecognitionException {
        try {
            int _type = QUOTED_39_39_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:7212:16: ( ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) ) )
            // Morel.g:7213:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            {
            // Morel.g:7213:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            // Morel.g:7213:3: ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' )
            {
            // Morel.g:7213:3: ( '\\'' )
            // Morel.g:7213:4: '\\''
            {
            match('\''); 

            }


            // Morel.g:7213:9: ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )*
            loop16:
            do {
                int alt16=4;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\\') ) {
                    int LA16_2 = input.LA(2);

                    if ( (LA16_2=='\'') ) {
                        alt16=1;
                    }
                    else if ( (LA16_2=='\\') ) {
                        alt16=2;
                    }


                }
                else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '&')||(LA16_0 >= '(' && LA16_0 <= '[')||(LA16_0 >= ']' && LA16_0 <= '\uFFFF')) ) {
                    alt16=3;
                }


                switch (alt16) {
            	case 1 :
            	    // Morel.g:7213:10: ( '\\\\' '\\'' )
            	    {
            	    // Morel.g:7213:10: ( '\\\\' '\\'' )
            	    // Morel.g:7213:11: '\\\\' '\\''
            	    {
            	    match('\\'); 

            	    match('\''); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Morel.g:7213:21: ( '\\\\' '\\\\' )
            	    {
            	    // Morel.g:7213:21: ( '\\\\' '\\\\' )
            	    // Morel.g:7213:22: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Morel.g:7213:32: (~ ( '\\'' | '\\\\' ) )
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
            	    break loop16;
                }
            } while (true);


            // Morel.g:7213:48: ( '\\'' )
            // Morel.g:7213:49: '\\''
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
        // Morel.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | LINEBREAK | WHITESPACE | DATA_TYPE | IDENTIFIER | URINS | INUMBER | RNUMBER | QUOTED_39_39_92 )
        int alt17=63;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // Morel.g:1:10: T__12
                {
                mT__12(); 


                }
                break;
            case 2 :
                // Morel.g:1:16: T__13
                {
                mT__13(); 


                }
                break;
            case 3 :
                // Morel.g:1:22: T__14
                {
                mT__14(); 


                }
                break;
            case 4 :
                // Morel.g:1:28: T__15
                {
                mT__15(); 


                }
                break;
            case 5 :
                // Morel.g:1:34: T__16
                {
                mT__16(); 


                }
                break;
            case 6 :
                // Morel.g:1:40: T__17
                {
                mT__17(); 


                }
                break;
            case 7 :
                // Morel.g:1:46: T__18
                {
                mT__18(); 


                }
                break;
            case 8 :
                // Morel.g:1:52: T__19
                {
                mT__19(); 


                }
                break;
            case 9 :
                // Morel.g:1:58: T__20
                {
                mT__20(); 


                }
                break;
            case 10 :
                // Morel.g:1:64: T__21
                {
                mT__21(); 


                }
                break;
            case 11 :
                // Morel.g:1:70: T__22
                {
                mT__22(); 


                }
                break;
            case 12 :
                // Morel.g:1:76: T__23
                {
                mT__23(); 


                }
                break;
            case 13 :
                // Morel.g:1:82: T__24
                {
                mT__24(); 


                }
                break;
            case 14 :
                // Morel.g:1:88: T__25
                {
                mT__25(); 


                }
                break;
            case 15 :
                // Morel.g:1:94: T__26
                {
                mT__26(); 


                }
                break;
            case 16 :
                // Morel.g:1:100: T__27
                {
                mT__27(); 


                }
                break;
            case 17 :
                // Morel.g:1:106: T__28
                {
                mT__28(); 


                }
                break;
            case 18 :
                // Morel.g:1:112: T__29
                {
                mT__29(); 


                }
                break;
            case 19 :
                // Morel.g:1:118: T__30
                {
                mT__30(); 


                }
                break;
            case 20 :
                // Morel.g:1:124: T__31
                {
                mT__31(); 


                }
                break;
            case 21 :
                // Morel.g:1:130: T__32
                {
                mT__32(); 


                }
                break;
            case 22 :
                // Morel.g:1:136: T__33
                {
                mT__33(); 


                }
                break;
            case 23 :
                // Morel.g:1:142: T__34
                {
                mT__34(); 


                }
                break;
            case 24 :
                // Morel.g:1:148: T__35
                {
                mT__35(); 


                }
                break;
            case 25 :
                // Morel.g:1:154: T__36
                {
                mT__36(); 


                }
                break;
            case 26 :
                // Morel.g:1:160: T__37
                {
                mT__37(); 


                }
                break;
            case 27 :
                // Morel.g:1:166: T__38
                {
                mT__38(); 


                }
                break;
            case 28 :
                // Morel.g:1:172: T__39
                {
                mT__39(); 


                }
                break;
            case 29 :
                // Morel.g:1:178: T__40
                {
                mT__40(); 


                }
                break;
            case 30 :
                // Morel.g:1:184: T__41
                {
                mT__41(); 


                }
                break;
            case 31 :
                // Morel.g:1:190: T__42
                {
                mT__42(); 


                }
                break;
            case 32 :
                // Morel.g:1:196: T__43
                {
                mT__43(); 


                }
                break;
            case 33 :
                // Morel.g:1:202: T__44
                {
                mT__44(); 


                }
                break;
            case 34 :
                // Morel.g:1:208: T__45
                {
                mT__45(); 


                }
                break;
            case 35 :
                // Morel.g:1:214: T__46
                {
                mT__46(); 


                }
                break;
            case 36 :
                // Morel.g:1:220: T__47
                {
                mT__47(); 


                }
                break;
            case 37 :
                // Morel.g:1:226: T__48
                {
                mT__48(); 


                }
                break;
            case 38 :
                // Morel.g:1:232: T__49
                {
                mT__49(); 


                }
                break;
            case 39 :
                // Morel.g:1:238: T__50
                {
                mT__50(); 


                }
                break;
            case 40 :
                // Morel.g:1:244: T__51
                {
                mT__51(); 


                }
                break;
            case 41 :
                // Morel.g:1:250: T__52
                {
                mT__52(); 


                }
                break;
            case 42 :
                // Morel.g:1:256: T__53
                {
                mT__53(); 


                }
                break;
            case 43 :
                // Morel.g:1:262: T__54
                {
                mT__54(); 


                }
                break;
            case 44 :
                // Morel.g:1:268: T__55
                {
                mT__55(); 


                }
                break;
            case 45 :
                // Morel.g:1:274: T__56
                {
                mT__56(); 


                }
                break;
            case 46 :
                // Morel.g:1:280: T__57
                {
                mT__57(); 


                }
                break;
            case 47 :
                // Morel.g:1:286: T__58
                {
                mT__58(); 


                }
                break;
            case 48 :
                // Morel.g:1:292: T__59
                {
                mT__59(); 


                }
                break;
            case 49 :
                // Morel.g:1:298: T__60
                {
                mT__60(); 


                }
                break;
            case 50 :
                // Morel.g:1:304: T__61
                {
                mT__61(); 


                }
                break;
            case 51 :
                // Morel.g:1:310: T__62
                {
                mT__62(); 


                }
                break;
            case 52 :
                // Morel.g:1:316: T__63
                {
                mT__63(); 


                }
                break;
            case 53 :
                // Morel.g:1:322: T__64
                {
                mT__64(); 


                }
                break;
            case 54 :
                // Morel.g:1:328: T__65
                {
                mT__65(); 


                }
                break;
            case 55 :
                // Morel.g:1:334: T__66
                {
                mT__66(); 


                }
                break;
            case 56 :
                // Morel.g:1:340: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 57 :
                // Morel.g:1:350: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 58 :
                // Morel.g:1:361: DATA_TYPE
                {
                mDATA_TYPE(); 


                }
                break;
            case 59 :
                // Morel.g:1:371: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 60 :
                // Morel.g:1:382: URINS
                {
                mURINS(); 


                }
                break;
            case 61 :
                // Morel.g:1:388: INUMBER
                {
                mINUMBER(); 


                }
                break;
            case 62 :
                // Morel.g:1:396: RNUMBER
                {
                mRNUMBER(); 


                }
                break;
            case 63 :
                // Morel.g:1:404: QUOTED_39_39_92
                {
                mQUOTED_39_39_92(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA10_eotS =
        "\55\uffff\1\67\7\uffff\2\67\11\uffff\1\67\6\uffff\2\67\5\uffff";
    static final String DFA10_eofS =
        "\116\uffff";
    static final String DFA10_minS =
        "\1\101\1\145\1\141\1\162\1\uffff\1\161\1\147\1\144\1\165\2\50\2"+
        "\145\1\101\1\162\1\156\7\51\1\uffff\1\145\1\143\11\51\1\144\1\145"+
        "\2\51\1\50\2\51\1\50\2\51\1\60\1\51\1\123\1\50\4\51\2\60\1\uffff"+
        "\1\51\1\145\5\51\1\164\1\60\4\51\1\50\1\51\2\60\1\51\1\50\2\51\1"+
        "\50";
    static final String DFA10_maxS =
        "\1\123\1\164\1\157\1\162\1\uffff\1\164\1\147\1\144\1\165\2\50\2"+
        "\145\1\172\1\162\1\156\7\172\1\uffff\1\145\1\143\11\172\1\144\1"+
        "\145\12\172\1\123\1\50\6\172\1\uffff\1\172\1\145\5\172\1\164\5\172"+
        "\1\50\10\172";
    static final String DFA10_acceptS =
        "\4\uffff\1\1\22\uffff\1\2\37\uffff\1\1\26\uffff";
    static final String DFA10_specialS =
        "\116\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\4\1\2\1\4\5\uffff\1\4\5\uffff\1\3\2\uffff\1\4\1\1",
            "\1\5\16\uffff\1\4",
            "\1\6\15\uffff\1\4",
            "\1\7",
            "",
            "\1\10\2\uffff\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\25\1\22\1\24\5\27\1\21\5\27\1\26\2\27\1\23\1\20\7\27\4\uffff"+
            "\1\27\1\uffff\32\27",
            "\1\30",
            "\1\31",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\33\16\27\1\32\6\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\15\27"+
            "\1\34\14\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\1\36"+
            "\15\27\1\35\13\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\37\25\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\7\27"+
            "\1\40\22\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\15\27"+
            "\1\41\14\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\21\27"+
            "\1\42\10\27",
            "",
            "\1\43",
            "\1\44",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\21\27"+
            "\1\45\10\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\20\27"+
            "\1\46\2\27\1\47\6\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\23\27"+
            "\1\50\6\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\16\27"+
            "\1\51\13\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\6\27"+
            "\1\52\23\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\1\53"+
            "\31\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\1\54"+
            "\31\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\30\27"+
            "\1\55\1\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\3\27"+
            "\1\56\26\27",
            "\1\57",
            "\1\60",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\10\27"+
            "\1\61\21\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\24\27"+
            "\1\62\5\27",
            "\1\15\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff"+
            "\32\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\63\25\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\13\27"+
            "\1\64\16\27",
            "\1\15\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff"+
            "\32\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\13\27"+
            "\1\65\16\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\21\27"+
            "\1\66\10\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\70\25\27",
            "\1\71",
            "\1\15",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\15\27"+
            "\1\72\14\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\73\25\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\6\27"+
            "\1\74\23\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\75\25\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\21\27"+
            "\1\76\10\27",
            "\1\77",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\6\27"+
            "\1\100\23\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\15\27"+
            "\1\101\14\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\102\25\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\1\103"+
            "\31\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\104\25\27",
            "\1\105",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\2\27"+
            "\1\106\27\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\21\27"+
            "\1\107\10\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\15\27"+
            "\1\110\14\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\3\27"+
            "\1\111\26\27",
            "\1\15",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\112\25\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\27\6\uffff\12\27\7\uffff\22\27\1\113\7\27\4\uffff\1\27\1"+
            "\uffff\32\27",
            "\1\15\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff"+
            "\32\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"+
            "\1\114\25\27",
            "\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\23\27"+
            "\1\115\6\27",
            "\1\15\1\27\6\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff"+
            "\32\27"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "7198:2: ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )* | ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+ )";
        }
    }
    static final String DFA17_eotS =
        "\1\uffff\1\57\5\uffff\1\61\4\uffff\1\65\1\uffff\1\67\17\52\5\uffff"+
        "\7\52\2\uffff\1\137\13\uffff\10\52\1\151\1\52\1\153\5\52\1\161\25"+
        "\52\1\137\2\uffff\1\u0089\6\52\1\u0091\1\uffff\1\52\1\uffff\1\u0093"+
        "\1\u0094\1\52\1\u0096\1\u0097\1\uffff\1\u0098\1\52\1\u009a\2\52"+
        "\1\u009d\20\52\1\u00a6\1\uffff\2\52\1\u00af\4\52\1\uffff\1\52\2"+
        "\uffff\1\52\3\uffff\1\u00b6\1\uffff\2\52\1\uffff\1\u00b9\1\52\1"+
        "\u00bb\1\52\1\u00bd\1\u00be\1\u00bf\1\52\1\uffff\4\52\2\u00a6\2"+
        "\52\1\uffff\1\u00c7\1\52\1\u00c9\2\52\1\u00cc\1\uffff\1\u00ce\1"+
        "\52\1\uffff\1\52\1\uffff\1\52\3\uffff\7\52\1\uffff\1\u00d9\1\uffff"+
        "\1\u00da\1\52\1\uffff\1\52\1\uffff\1\u00dd\1\u00de\2\52\1\u00a6"+
        "\3\52\1\u00e4\1\u00e5\2\uffff\1\u00e6\1\52\2\uffff\2\52\1\u00a6"+
        "\1\52\1\u00a6\3\uffff\7\52\1\u00f1\2\52\1\uffff\3\52\1\u00f6\1\uffff";
    static final String DFA17_eofS =
        "\u00f7\uffff";
    static final String DFA17_minS =
        "\1\11\1\75\5\uffff\1\76\4\uffff\1\55\1\uffff\1\75\1\156\2\154\1"+
        "\141\1\146\1\145\2\141\1\162\1\141\1\165\2\145\2\150\5\uffff\1\145"+
        "\1\141\1\162\1\156\1\145\1\150\1\156\2\uffff\1\56\13\uffff\1\144"+
        "\1\157\1\154\1\163\1\144\1\151\1\154\1\162\1\60\1\160\1\60\1\164"+
        "\1\163\1\164\1\143\1\164\1\60\1\143\1\163\2\145\1\152\1\163\2\154"+
        "\1\145\1\141\1\160\1\145\1\161\1\162\1\147\1\157\1\144\1\164\2\141"+
        "\1\171\1\56\2\uffff\1\60\1\163\1\154\1\145\1\151\2\163\1\60\1\uffff"+
        "\1\154\1\uffff\2\60\1\143\2\60\1\uffff\1\60\1\164\1\60\1\162\1\145"+
        "\1\60\2\145\2\156\2\145\1\156\1\165\1\50\1\151\1\50\1\154\2\145"+
        "\1\154\1\162\1\60\1\uffff\1\165\1\145\1\60\1\146\1\164\1\145\1\154"+
        "\1\uffff\1\151\2\uffff\1\150\3\uffff\1\60\1\uffff\1\171\1\143\1"+
        "\uffff\1\60\1\143\1\60\1\163\3\60\1\145\1\uffff\1\156\1\145\1\162"+
        "\1\147\2\60\1\162\1\143\1\uffff\1\60\1\163\1\60\1\154\1\145\1\60"+
        "\1\uffff\1\60\1\164\1\uffff\1\164\1\uffff\1\146\3\uffff\1\156\1"+
        "\147\1\141\3\145\1\164\1\uffff\1\60\1\uffff\1\60\1\163\1\uffff\1"+
        "\157\1\uffff\2\60\1\157\1\143\1\60\1\156\1\144\1\162\2\60\2\uffff"+
        "\1\60\1\144\2\uffff\1\162\1\145\1\60\1\123\1\60\3\uffff\1\145\1"+
        "\155\1\50\1\145\1\154\1\141\1\164\1\60\1\164\1\50\1\uffff\1\151"+
        "\1\157\1\156\1\60\1\uffff";
    static final String DFA17_maxS =
        "\1\175\1\75\5\uffff\1\76\4\uffff\1\76\1\uffff\1\75\1\156\1\157\1"+
        "\170\1\157\1\156\1\150\1\141\1\157\2\162\2\165\1\145\1\171\1\150"+
        "\5\uffff\1\164\1\157\1\162\1\156\1\145\1\150\1\156\2\uffff\1\71"+
        "\13\uffff\1\144\1\157\1\154\1\163\1\144\1\151\1\154\1\162\1\172"+
        "\1\160\1\172\1\164\1\163\1\164\1\143\1\164\1\172\1\143\1\163\2\145"+
        "\1\152\1\163\2\154\1\145\1\165\1\160\1\145\1\164\1\162\1\147\1\157"+
        "\1\144\1\164\2\141\1\171\1\71\2\uffff\1\172\1\163\1\154\1\145\1"+
        "\151\2\163\1\172\1\uffff\1\154\1\uffff\2\172\1\143\2\172\1\uffff"+
        "\1\172\1\164\1\172\1\162\1\145\1\172\2\145\2\156\2\145\1\156\1\165"+
        "\1\50\1\151\1\50\1\154\2\145\1\154\1\162\1\172\1\uffff\1\165\1\145"+
        "\1\172\1\146\1\164\1\145\1\154\1\uffff\1\151\2\uffff\1\150\3\uffff"+
        "\1\172\1\uffff\1\171\1\143\1\uffff\1\172\1\143\1\172\1\163\3\172"+
        "\1\145\1\uffff\1\156\1\145\1\162\1\147\2\172\1\162\1\143\1\uffff"+
        "\1\172\1\163\1\172\1\154\1\145\1\172\1\uffff\1\172\1\164\1\uffff"+
        "\1\164\1\uffff\1\146\3\uffff\1\156\1\147\1\141\3\145\1\164\1\uffff"+
        "\1\172\1\uffff\1\172\1\163\1\uffff\1\157\1\uffff\2\172\1\157\1\143"+
        "\1\172\1\156\1\144\1\162\2\172\2\uffff\1\172\1\144\2\uffff\1\162"+
        "\1\145\1\172\1\123\1\172\3\uffff\1\145\1\155\1\50\1\145\1\154\1"+
        "\141\1\164\1\172\1\164\1\50\1\uffff\1\151\1\157\1\156\1\172\1\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\1\13\1\14\1\15\1\uffff"+
        "\1\22\20\uffff\1\65\1\66\1\67\1\70\1\71\7\uffff\1\73\1\74\1\uffff"+
        "\1\77\1\2\1\1\1\11\1\10\1\17\1\20\1\21\1\16\1\24\1\23\47\uffff\1"+
        "\75\1\76\10\uffff\1\36\1\uffff\1\40\5\uffff\1\46\27\uffff\1\25\7"+
        "\uffff\1\34\1\uffff\1\41\1\42\1\uffff\1\44\1\45\1\47\1\uffff\1\51"+
        "\2\uffff\1\55\10\uffff\1\72\10\uffff\1\30\6\uffff\1\50\2\uffff\1"+
        "\56\1\uffff\1\60\1\uffff\1\62\1\63\1\64\7\uffff\1\31\1\uffff\1\33"+
        "\2\uffff\1\43\1\uffff\1\52\12\uffff\1\32\1\35\2\uffff\1\54\1\57"+
        "\5\uffff\1\26\1\27\1\37\12\uffff\1\53\4\uffff\1\61";
    static final String DFA17_specialS =
        "\u00f7\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\42\1\41\1\uffff\1\42\1\41\22\uffff\1\42\1\1\1\uffff\1\53"+
            "\3\uffff\1\55\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\12\54\1\12\1"+
            "\13\1\14\1\15\1\16\2\uffff\1\51\1\44\1\50\5\52\1\46\5\52\1\45"+
            "\2\52\1\47\1\43\7\52\4\uffff\1\52\1\uffff\1\17\1\52\1\20\1\52"+
            "\1\21\1\22\2\52\1\23\2\52\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
            "\1\33\1\34\2\52\1\35\3\52\1\36\1\37\1\40",
            "\1\56",
            "",
            "",
            "",
            "",
            "",
            "\1\60",
            "",
            "",
            "",
            "",
            "\1\62\17\uffff\1\63\1\64",
            "",
            "\1\66",
            "\1\70",
            "\1\71\2\uffff\1\72",
            "\1\73\1\uffff\1\74\11\uffff\1\75",
            "\1\76\15\uffff\1\77",
            "\1\100\6\uffff\1\101\1\102",
            "\1\103\2\uffff\1\104",
            "\1\105",
            "\1\106\15\uffff\1\107",
            "\1\110",
            "\1\111\15\uffff\1\112\2\uffff\1\113",
            "\1\114",
            "\1\115\2\uffff\1\116\14\uffff\1\117",
            "\1\120",
            "\1\121\11\uffff\1\122\6\uffff\1\123",
            "\1\124",
            "",
            "",
            "",
            "",
            "",
            "\1\125\16\uffff\1\126",
            "\1\127\15\uffff\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "",
            "",
            "\1\140\1\uffff\2\136\10\140",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\152",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173\23\uffff\1\174",
            "\1\175",
            "\1\176",
            "\1\177\2\uffff\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\140\1\uffff\2\136\10\140",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\12\52\7\uffff\1\u0090\31\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u0092",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0095",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0099",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u009b",
            "\1\u009c",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a6",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u00ad",
            "\1\u00ae",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "",
            "\1\u00b4",
            "",
            "",
            "\1\u00b5",
            "",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00ba",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00bc",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00c0",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00c5",
            "\1\u00c6",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00c8",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00ca",
            "\1\u00cb",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\14\52\1\u00cd\15"+
            "\52",
            "\1\u00cf",
            "",
            "\1\u00d0",
            "",
            "\1\u00d1",
            "",
            "",
            "",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00db",
            "",
            "\1\u00dc",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00df",
            "\1\u00e0",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00e7",
            "",
            "",
            "\1\u00e8",
            "\1\u00e9",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00ea",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00a6",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00f2",
            "\1\u00a6",
            "",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | LINEBREAK | WHITESPACE | DATA_TYPE | IDENTIFIER | URINS | INUMBER | RNUMBER | QUOTED_39_39_92 );";
        }
    }
 

}