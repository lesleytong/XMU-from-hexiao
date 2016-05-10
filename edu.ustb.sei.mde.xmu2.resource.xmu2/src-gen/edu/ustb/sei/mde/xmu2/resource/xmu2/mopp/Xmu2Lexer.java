// $ANTLR 3.4

	package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Xmu2Lexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int BOOLEAN=4;
    public static final int LINEBREAK=5;
    public static final int ML_COMMENT=6;
    public static final int NAME=7;
    public static final int NUMBER=8;
    public static final int OBJ_URI=9;
    public static final int QUOTED_39_39_92=10;
    public static final int QUOTED_60_62_92=11;
    public static final int SL_COMMENT=12;
    public static final int TEXT=13;
    public static final int TYPE=14;
    public static final int WHITESPACE=15;

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

    public Xmu2Lexer() {} 
    public Xmu2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Xmu2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Xmu2.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:15:7: ( '(' )
            // Xmu2.g:15:9: '('
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:16:7: ( ')' )
            // Xmu2.g:16:9: ')'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:17:7: ( '*' )
            // Xmu2.g:17:9: '*'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:18:7: ( '+' )
            // Xmu2.g:18:9: '+'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:19:7: ( '++' )
            // Xmu2.g:19:9: '++'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:20:7: ( ',' )
            // Xmu2.g:20:9: ','
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:21:7: ( '-' )
            // Xmu2.g:21:9: '-'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:22:7: ( '->' )
            // Xmu2.g:22:9: '->'
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:23:7: ( '.' )
            // Xmu2.g:23:9: '.'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:24:7: ( '/' )
            // Xmu2.g:24:9: '/'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:25:7: ( ':' )
            // Xmu2.g:25:9: ':'
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
            // Xmu2.g:26:7: ( '::' )
            // Xmu2.g:26:9: '::'
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
            // Xmu2.g:27:7: ( ';' )
            // Xmu2.g:27:9: ';'
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
            // Xmu2.g:28:7: ( '<' )
            // Xmu2.g:28:9: '<'
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
            // Xmu2.g:29:7: ( '<=' )
            // Xmu2.g:29:9: '<='
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
            // Xmu2.g:30:7: ( '=' )
            // Xmu2.g:30:9: '='
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
            // Xmu2.g:31:7: ( '>' )
            // Xmu2.g:31:9: '>'
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
            // Xmu2.g:32:7: ( '>=' )
            // Xmu2.g:32:9: '>='
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
            // Xmu2.g:33:7: ( '[' )
            // Xmu2.g:33:9: '['
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
            // Xmu2.g:34:7: ( ']' )
            // Xmu2.g:34:9: ']'
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
            // Xmu2.g:35:7: ( 'and' )
            // Xmu2.g:35:9: 'and'
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
            // Xmu2.g:36:7: ( 'at' )
            // Xmu2.g:36:9: 'at'
            {
            match("at"); 



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
            // Xmu2.g:37:7: ( 'by' )
            // Xmu2.g:37:9: 'by'
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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:38:7: ( 'case' )
            // Xmu2.g:38:9: 'case'
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
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:39:7: ( 'default' )
            // Xmu2.g:39:9: 'default'
            {
            match("default"); 



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
            // Xmu2.g:40:7: ( 'delete' )
            // Xmu2.g:40:9: 'delete'
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
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:41:7: ( 'enforce' )
            // Xmu2.g:41:9: 'enforce'
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
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:42:7: ( 'entry' )
            // Xmu2.g:42:9: 'entry'
            {
            match("entry"); 



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
            // Xmu2.g:43:7: ( 'exists' )
            // Xmu2.g:43:9: 'exists'
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
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:44:7: ( 'first' )
            // Xmu2.g:44:9: 'first'
            {
            match("first"); 



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
            // Xmu2.g:45:7: ( 'forAll' )
            // Xmu2.g:45:9: 'forAll'
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
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:46:7: ( 'foreach' )
            // Xmu2.g:46:9: 'foreach'
            {
            match("foreach"); 



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
            // Xmu2.g:47:7: ( 'import' )
            // Xmu2.g:47:9: 'import'
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
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:48:7: ( 'last' )
            // Xmu2.g:48:9: 'last'
            {
            match("last"); 



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
            // Xmu2.g:49:7: ( 'match' )
            // Xmu2.g:49:9: 'match'
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
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:50:7: ( 'module' )
            // Xmu2.g:50:9: 'module'
            {
            match("module"); 



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
            // Xmu2.g:51:7: ( 'not' )
            // Xmu2.g:51:9: 'not'
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
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:52:7: ( 'null' )
            // Xmu2.g:52:9: 'null'
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
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:53:7: ( 'or' )
            // Xmu2.g:53:9: 'or'
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
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:54:7: ( 'otherwise' )
            // Xmu2.g:54:9: 'otherwise'
            {
            match("otherwise"); 



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
            // Xmu2.g:55:7: ( 'rule' )
            // Xmu2.g:55:9: 'rule'
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
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:56:7: ( 'select' )
            // Xmu2.g:56:9: 'select'
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
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:57:7: ( 'skip' )
            // Xmu2.g:57:9: 'skip'
            {
            match("skip"); 



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
            // Xmu2.g:58:7: ( 'source' )
            // Xmu2.g:58:9: 'source'
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
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:59:7: ( 'switch' )
            // Xmu2.g:59:9: 'switch'
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
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:60:7: ( 'top' )
            // Xmu2.g:60:9: 'top'
            {
            match("top"); 



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
            // Xmu2.g:61:7: ( 'undefined' )
            // Xmu2.g:61:9: 'undefined'
            {
            match("undefined"); 



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
            // Xmu2.g:62:7: ( 'unmatchs' )
            // Xmu2.g:62:9: 'unmatchs'
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
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:63:7: ( 'unmatchv' )
            // Xmu2.g:63:9: 'unmatchv'
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
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:64:7: ( 'update' )
            // Xmu2.g:64:9: 'update'
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
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:65:7: ( 'view' )
            // Xmu2.g:65:9: 'view'
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
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:66:7: ( 'with' )
            // Xmu2.g:66:9: 'with'
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
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:67:7: ( '{' )
            // Xmu2.g:67:9: '{'
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
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:68:7: ( '|' )
            // Xmu2.g:68:9: '|'
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
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:69:7: ( '}' )
            // Xmu2.g:69:9: '}'
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
    // $ANTLR end "T__70"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:7837:5: ( ( 'String' | 'Boolean' | 'Integer' | 'Resource' | ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ) ) )
            // Xmu2.g:7838:2: ( 'String' | 'Boolean' | 'Integer' | 'Resource' | ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ) )
            {
            // Xmu2.g:7838:2: ( 'String' | 'Boolean' | 'Integer' | 'Resource' | ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 'S':
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='t') ) {
                    int LA3_6 = input.LA(3);

                    if ( (LA3_6=='r') ) {
                        int LA3_10 = input.LA(4);

                        if ( (LA3_10=='i') ) {
                            int LA3_14 = input.LA(5);

                            if ( (LA3_14=='n') ) {
                                int LA3_18 = input.LA(6);

                                if ( (LA3_18=='g') ) {
                                    int LA3_22 = input.LA(7);

                                    if ( (LA3_22=='!'||(LA3_22 >= '0' && LA3_22 <= '9')||(LA3_22 >= 'A' && LA3_22 <= 'Z')||LA3_22=='_'||(LA3_22 >= 'a' && LA3_22 <= 'z')) ) {
                                        alt3=5;
                                    }
                                    else {
                                        alt3=1;
                                    }
                                }
                                else if ( (LA3_18=='!'||(LA3_18 >= '0' && LA3_18 <= '9')||(LA3_18 >= 'A' && LA3_18 <= 'Z')||LA3_18=='_'||(LA3_18 >= 'a' && LA3_18 <= 'f')||(LA3_18 >= 'h' && LA3_18 <= 'z')) ) {
                                    alt3=5;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 3, 18, input);

                                    throw nvae;

                                }
                            }
                            else if ( (LA3_14=='!'||(LA3_14 >= '0' && LA3_14 <= '9')||(LA3_14 >= 'A' && LA3_14 <= 'Z')||LA3_14=='_'||(LA3_14 >= 'a' && LA3_14 <= 'm')||(LA3_14 >= 'o' && LA3_14 <= 'z')) ) {
                                alt3=5;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 14, input);

                                throw nvae;

                            }
                        }
                        else if ( (LA3_10=='!'||(LA3_10 >= '0' && LA3_10 <= '9')||(LA3_10 >= 'A' && LA3_10 <= 'Z')||LA3_10=='_'||(LA3_10 >= 'a' && LA3_10 <= 'h')||(LA3_10 >= 'j' && LA3_10 <= 'z')) ) {
                            alt3=5;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 10, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA3_6=='!'||(LA3_6 >= '0' && LA3_6 <= '9')||(LA3_6 >= 'A' && LA3_6 <= 'Z')||LA3_6=='_'||(LA3_6 >= 'a' && LA3_6 <= 'q')||(LA3_6 >= 's' && LA3_6 <= 'z')) ) {
                        alt3=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 6, input);

                        throw nvae;

                    }
                }
                else if ( (LA3_1=='!'||(LA3_1 >= '0' && LA3_1 <= '9')||(LA3_1 >= 'A' && LA3_1 <= 'Z')||LA3_1=='_'||(LA3_1 >= 'a' && LA3_1 <= 's')||(LA3_1 >= 'u' && LA3_1 <= 'z')) ) {
                    alt3=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
                }
                break;
            case 'B':
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2=='o') ) {
                    int LA3_7 = input.LA(3);

                    if ( (LA3_7=='o') ) {
                        int LA3_11 = input.LA(4);

                        if ( (LA3_11=='l') ) {
                            int LA3_15 = input.LA(5);

                            if ( (LA3_15=='e') ) {
                                int LA3_19 = input.LA(6);

                                if ( (LA3_19=='a') ) {
                                    int LA3_23 = input.LA(7);

                                    if ( (LA3_23=='n') ) {
                                        int LA3_27 = input.LA(8);

                                        if ( (LA3_27=='!'||(LA3_27 >= '0' && LA3_27 <= '9')||(LA3_27 >= 'A' && LA3_27 <= 'Z')||LA3_27=='_'||(LA3_27 >= 'a' && LA3_27 <= 'z')) ) {
                                            alt3=5;
                                        }
                                        else {
                                            alt3=2;
                                        }
                                    }
                                    else if ( (LA3_23=='!'||(LA3_23 >= '0' && LA3_23 <= '9')||(LA3_23 >= 'A' && LA3_23 <= 'Z')||LA3_23=='_'||(LA3_23 >= 'a' && LA3_23 <= 'm')||(LA3_23 >= 'o' && LA3_23 <= 'z')) ) {
                                        alt3=5;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 3, 23, input);

                                        throw nvae;

                                    }
                                }
                                else if ( (LA3_19=='!'||(LA3_19 >= '0' && LA3_19 <= '9')||(LA3_19 >= 'A' && LA3_19 <= 'Z')||LA3_19=='_'||(LA3_19 >= 'b' && LA3_19 <= 'z')) ) {
                                    alt3=5;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 3, 19, input);

                                    throw nvae;

                                }
                            }
                            else if ( (LA3_15=='!'||(LA3_15 >= '0' && LA3_15 <= '9')||(LA3_15 >= 'A' && LA3_15 <= 'Z')||LA3_15=='_'||(LA3_15 >= 'a' && LA3_15 <= 'd')||(LA3_15 >= 'f' && LA3_15 <= 'z')) ) {
                                alt3=5;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 15, input);

                                throw nvae;

                            }
                        }
                        else if ( (LA3_11=='!'||(LA3_11 >= '0' && LA3_11 <= '9')||(LA3_11 >= 'A' && LA3_11 <= 'Z')||LA3_11=='_'||(LA3_11 >= 'a' && LA3_11 <= 'k')||(LA3_11 >= 'm' && LA3_11 <= 'z')) ) {
                            alt3=5;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 11, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA3_7=='!'||(LA3_7 >= '0' && LA3_7 <= '9')||(LA3_7 >= 'A' && LA3_7 <= 'Z')||LA3_7=='_'||(LA3_7 >= 'a' && LA3_7 <= 'n')||(LA3_7 >= 'p' && LA3_7 <= 'z')) ) {
                        alt3=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 7, input);

                        throw nvae;

                    }
                }
                else if ( (LA3_2=='!'||(LA3_2 >= '0' && LA3_2 <= '9')||(LA3_2 >= 'A' && LA3_2 <= 'Z')||LA3_2=='_'||(LA3_2 >= 'a' && LA3_2 <= 'n')||(LA3_2 >= 'p' && LA3_2 <= 'z')) ) {
                    alt3=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;

                }
                }
                break;
            case 'I':
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3=='n') ) {
                    int LA3_8 = input.LA(3);

                    if ( (LA3_8=='t') ) {
                        int LA3_12 = input.LA(4);

                        if ( (LA3_12=='e') ) {
                            int LA3_16 = input.LA(5);

                            if ( (LA3_16=='g') ) {
                                int LA3_20 = input.LA(6);

                                if ( (LA3_20=='e') ) {
                                    int LA3_24 = input.LA(7);

                                    if ( (LA3_24=='r') ) {
                                        int LA3_28 = input.LA(8);

                                        if ( (LA3_28=='!'||(LA3_28 >= '0' && LA3_28 <= '9')||(LA3_28 >= 'A' && LA3_28 <= 'Z')||LA3_28=='_'||(LA3_28 >= 'a' && LA3_28 <= 'z')) ) {
                                            alt3=5;
                                        }
                                        else {
                                            alt3=3;
                                        }
                                    }
                                    else if ( (LA3_24=='!'||(LA3_24 >= '0' && LA3_24 <= '9')||(LA3_24 >= 'A' && LA3_24 <= 'Z')||LA3_24=='_'||(LA3_24 >= 'a' && LA3_24 <= 'q')||(LA3_24 >= 's' && LA3_24 <= 'z')) ) {
                                        alt3=5;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 3, 24, input);

                                        throw nvae;

                                    }
                                }
                                else if ( (LA3_20=='!'||(LA3_20 >= '0' && LA3_20 <= '9')||(LA3_20 >= 'A' && LA3_20 <= 'Z')||LA3_20=='_'||(LA3_20 >= 'a' && LA3_20 <= 'd')||(LA3_20 >= 'f' && LA3_20 <= 'z')) ) {
                                    alt3=5;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 3, 20, input);

                                    throw nvae;

                                }
                            }
                            else if ( (LA3_16=='!'||(LA3_16 >= '0' && LA3_16 <= '9')||(LA3_16 >= 'A' && LA3_16 <= 'Z')||LA3_16=='_'||(LA3_16 >= 'a' && LA3_16 <= 'f')||(LA3_16 >= 'h' && LA3_16 <= 'z')) ) {
                                alt3=5;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 16, input);

                                throw nvae;

                            }
                        }
                        else if ( (LA3_12=='!'||(LA3_12 >= '0' && LA3_12 <= '9')||(LA3_12 >= 'A' && LA3_12 <= 'Z')||LA3_12=='_'||(LA3_12 >= 'a' && LA3_12 <= 'd')||(LA3_12 >= 'f' && LA3_12 <= 'z')) ) {
                            alt3=5;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 12, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA3_8=='!'||(LA3_8 >= '0' && LA3_8 <= '9')||(LA3_8 >= 'A' && LA3_8 <= 'Z')||LA3_8=='_'||(LA3_8 >= 'a' && LA3_8 <= 's')||(LA3_8 >= 'u' && LA3_8 <= 'z')) ) {
                        alt3=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 8, input);

                        throw nvae;

                    }
                }
                else if ( (LA3_3=='!'||(LA3_3 >= '0' && LA3_3 <= '9')||(LA3_3 >= 'A' && LA3_3 <= 'Z')||LA3_3=='_'||(LA3_3 >= 'a' && LA3_3 <= 'm')||(LA3_3 >= 'o' && LA3_3 <= 'z')) ) {
                    alt3=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;

                }
                }
                break;
            case 'R':
                {
                int LA3_4 = input.LA(2);

                if ( (LA3_4=='e') ) {
                    int LA3_9 = input.LA(3);

                    if ( (LA3_9=='s') ) {
                        int LA3_13 = input.LA(4);

                        if ( (LA3_13=='o') ) {
                            int LA3_17 = input.LA(5);

                            if ( (LA3_17=='u') ) {
                                int LA3_21 = input.LA(6);

                                if ( (LA3_21=='r') ) {
                                    int LA3_25 = input.LA(7);

                                    if ( (LA3_25=='c') ) {
                                        int LA3_29 = input.LA(8);

                                        if ( (LA3_29=='e') ) {
                                            int LA3_32 = input.LA(9);

                                            if ( (LA3_32=='!'||(LA3_32 >= '0' && LA3_32 <= '9')||(LA3_32 >= 'A' && LA3_32 <= 'Z')||LA3_32=='_'||(LA3_32 >= 'a' && LA3_32 <= 'z')) ) {
                                                alt3=5;
                                            }
                                            else {
                                                alt3=4;
                                            }
                                        }
                                        else if ( (LA3_29=='!'||(LA3_29 >= '0' && LA3_29 <= '9')||(LA3_29 >= 'A' && LA3_29 <= 'Z')||LA3_29=='_'||(LA3_29 >= 'a' && LA3_29 <= 'd')||(LA3_29 >= 'f' && LA3_29 <= 'z')) ) {
                                            alt3=5;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 3, 29, input);

                                            throw nvae;

                                        }
                                    }
                                    else if ( (LA3_25=='!'||(LA3_25 >= '0' && LA3_25 <= '9')||(LA3_25 >= 'A' && LA3_25 <= 'Z')||LA3_25=='_'||(LA3_25 >= 'a' && LA3_25 <= 'b')||(LA3_25 >= 'd' && LA3_25 <= 'z')) ) {
                                        alt3=5;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 3, 25, input);

                                        throw nvae;

                                    }
                                }
                                else if ( (LA3_21=='!'||(LA3_21 >= '0' && LA3_21 <= '9')||(LA3_21 >= 'A' && LA3_21 <= 'Z')||LA3_21=='_'||(LA3_21 >= 'a' && LA3_21 <= 'q')||(LA3_21 >= 's' && LA3_21 <= 'z')) ) {
                                    alt3=5;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 3, 21, input);

                                    throw nvae;

                                }
                            }
                            else if ( (LA3_17=='!'||(LA3_17 >= '0' && LA3_17 <= '9')||(LA3_17 >= 'A' && LA3_17 <= 'Z')||LA3_17=='_'||(LA3_17 >= 'a' && LA3_17 <= 't')||(LA3_17 >= 'v' && LA3_17 <= 'z')) ) {
                                alt3=5;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 17, input);

                                throw nvae;

                            }
                        }
                        else if ( (LA3_13=='!'||(LA3_13 >= '0' && LA3_13 <= '9')||(LA3_13 >= 'A' && LA3_13 <= 'Z')||LA3_13=='_'||(LA3_13 >= 'a' && LA3_13 <= 'n')||(LA3_13 >= 'p' && LA3_13 <= 'z')) ) {
                            alt3=5;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 13, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA3_9=='!'||(LA3_9 >= '0' && LA3_9 <= '9')||(LA3_9 >= 'A' && LA3_9 <= 'Z')||LA3_9=='_'||(LA3_9 >= 'a' && LA3_9 <= 'r')||(LA3_9 >= 't' && LA3_9 <= 'z')) ) {
                        alt3=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 9, input);

                        throw nvae;

                    }
                }
                else if ( (LA3_4=='!'||(LA3_4 >= '0' && LA3_4 <= '9')||(LA3_4 >= 'A' && LA3_4 <= 'Z')||LA3_4=='_'||(LA3_4 >= 'a' && LA3_4 <= 'd')||(LA3_4 >= 'f' && LA3_4 <= 'z')) ) {
                    alt3=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 4, input);

                    throw nvae;

                }
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // Xmu2.g:7838:3: 'String'
                    {
                    match("String"); 



                    }
                    break;
                case 2 :
                    // Xmu2.g:7838:12: 'Boolean'
                    {
                    match("Boolean"); 



                    }
                    break;
                case 3 :
                    // Xmu2.g:7838:22: 'Integer'
                    {
                    match("Integer"); 



                    }
                    break;
                case 4 :
                    // Xmu2.g:7838:32: 'Resource'
                    {
                    match("Resource"); 



                    }
                    break;
                case 5 :
                    // Xmu2.g:7838:43: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* )
                    {
                    // Xmu2.g:7838:43: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* )
                    // Xmu2.g:7838:44: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '!' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )*
                    {
                    // Xmu2.g:7838:44: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // Xmu2.g:
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
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    match('!'); 

                    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Xmu2.g:7838:103: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Xmu2.g:
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
                    	    break loop2;
                        }
                    } while (true);


                    }


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
    // $ANTLR end "TYPE"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:7840:8: ( ( 'true' | 'false' ) )
            // Xmu2.g:7841:2: ( 'true' | 'false' )
            {
            // Xmu2.g:7841:2: ( 'true' | 'false' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='t') ) {
                alt4=1;
            }
            else if ( (LA4_0=='f') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Xmu2.g:7841:3: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // Xmu2.g:7841:10: 'false'
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
            // Xmu2.g:7843:5: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ( '@post' )? ) )
            // Xmu2.g:7844:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ( '@post' )? )
            {
            // Xmu2.g:7844:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ( '@post' )? )
            // Xmu2.g:7844:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* ( '@post' )?
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Xmu2.g:7844:26: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Xmu2.g:
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
            	    break loop5;
                }
            } while (true);


            // Xmu2.g:7844:59: ( '@post' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='@') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Xmu2.g:7844:60: '@post'
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
            // Xmu2.g:7846:7: ( ( ( '0' .. '9' )+ ) )
            // Xmu2.g:7847:2: ( ( '0' .. '9' )+ )
            {
            // Xmu2.g:7847:2: ( ( '0' .. '9' )+ )
            // Xmu2.g:7847:3: ( '0' .. '9' )+
            {
            // Xmu2.g:7847:3: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Xmu2.g:
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
            // Xmu2.g:7849:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Xmu2.g:7850:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Xmu2.g:7850:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Xmu2.g:7850:4: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Xmu2.g:7850:8: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Xmu2.g:
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
            	    break loop8;
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
            // Xmu2.g:7853:11: ( ( '/*' ( . )* '*/' ) )
            // Xmu2.g:7854:2: ( '/*' ( . )* '*/' )
            {
            // Xmu2.g:7854:2: ( '/*' ( . )* '*/' )
            // Xmu2.g:7854:4: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Xmu2.g:7854:8: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1 >= '\u0000' && LA9_1 <= '.')||(LA9_1 >= '0' && LA9_1 <= '\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0 >= '\u0000' && LA9_0 <= ')')||(LA9_0 >= '+' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Xmu2.g:7854:8: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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

    // $ANTLR start "OBJ_URI"
    public final void mOBJ_URI() throws RecognitionException {
        try {
            int _type = OBJ_URI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:7857:8: ( ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '\\\\' | '\\.' | ':' | '#' )* ) )
            // Xmu2.g:7858:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '\\\\' | '\\.' | ':' | '#' )* )
            {
            // Xmu2.g:7858:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '\\\\' | '\\.' | ':' | '#' )* )
            // Xmu2.g:7858:3: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '\\\\' | '\\.' | ':' | '#' )*
            {
            match('@'); 

            // Xmu2.g:7858:6: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '\\\\' | '\\.' | ':' | '#' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='#'||(LA10_0 >= '.' && LA10_0 <= ':')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='\\'||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Xmu2.g:
            	    {
            	    if ( input.LA(1)=='#'||(input.LA(1) >= '.' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    break loop10;
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
    // $ANTLR end "OBJ_URI"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:7860:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Xmu2.g:7861:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Xmu2.g:7861:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Xmu2.g:7861:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Xmu2.g:7861:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
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
            	    // Xmu2.g:
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
            // Xmu2.g:7864:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Xmu2.g:7865:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Xmu2.g:7868:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Xmu2.g:7869:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Xmu2.g:7869:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Xmu2.g:7869:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Xmu2.g:7869:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Xmu2.g:7869:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Xmu2.g:7869:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Xmu2.g:7869:20: '\\n'
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

    // $ANTLR start "QUOTED_60_62_92"
    public final void mQUOTED_60_62_92() throws RecognitionException {
        try {
            int _type = QUOTED_60_62_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:7872:16: ( ( ( '<' ) ( ( '\\\\' '>' ) | ( '\\\\' '\\\\' ) | (~ ( '>' | '\\\\' ) ) )* ( '>' ) ) )
            // Xmu2.g:7873:2: ( ( '<' ) ( ( '\\\\' '>' ) | ( '\\\\' '\\\\' ) | (~ ( '>' | '\\\\' ) ) )* ( '>' ) )
            {
            // Xmu2.g:7873:2: ( ( '<' ) ( ( '\\\\' '>' ) | ( '\\\\' '\\\\' ) | (~ ( '>' | '\\\\' ) ) )* ( '>' ) )
            // Xmu2.g:7873:3: ( '<' ) ( ( '\\\\' '>' ) | ( '\\\\' '\\\\' ) | (~ ( '>' | '\\\\' ) ) )* ( '>' )
            {
            // Xmu2.g:7873:3: ( '<' )
            // Xmu2.g:7873:4: '<'
            {
            match('<'); 

            }


            // Xmu2.g:7873:8: ( ( '\\\\' '>' ) | ( '\\\\' '\\\\' ) | (~ ( '>' | '\\\\' ) ) )*
            loop13:
            do {
                int alt13=4;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\\') ) {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2=='>') ) {
                        alt13=1;
                    }
                    else if ( (LA13_2=='\\') ) {
                        alt13=2;
                    }


                }
                else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '=')||(LA13_0 >= '?' && LA13_0 <= '[')||(LA13_0 >= ']' && LA13_0 <= '\uFFFF')) ) {
                    alt13=3;
                }


                switch (alt13) {
            	case 1 :
            	    // Xmu2.g:7873:9: ( '\\\\' '>' )
            	    {
            	    // Xmu2.g:7873:9: ( '\\\\' '>' )
            	    // Xmu2.g:7873:10: '\\\\' '>'
            	    {
            	    match('\\'); 

            	    match('>'); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Xmu2.g:7873:19: ( '\\\\' '\\\\' )
            	    {
            	    // Xmu2.g:7873:19: ( '\\\\' '\\\\' )
            	    // Xmu2.g:7873:20: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Xmu2.g:7873:30: (~ ( '>' | '\\\\' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '=')||(input.LA(1) >= '?' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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


            // Xmu2.g:7873:45: ( '>' )
            // Xmu2.g:7873:46: '>'
            {
            match('>'); 

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
    // $ANTLR end "QUOTED_60_62_92"

    // $ANTLR start "QUOTED_39_39_92"
    public final void mQUOTED_39_39_92() throws RecognitionException {
        try {
            int _type = QUOTED_39_39_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xmu2.g:7875:16: ( ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) ) )
            // Xmu2.g:7876:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            {
            // Xmu2.g:7876:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            // Xmu2.g:7876:3: ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' )
            {
            // Xmu2.g:7876:3: ( '\\'' )
            // Xmu2.g:7876:4: '\\''
            {
            match('\''); 

            }


            // Xmu2.g:7876:9: ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )*
            loop14:
            do {
                int alt14=4;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\\') ) {
                    int LA14_2 = input.LA(2);

                    if ( (LA14_2=='\'') ) {
                        alt14=1;
                    }
                    else if ( (LA14_2=='\\') ) {
                        alt14=2;
                    }


                }
                else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '&')||(LA14_0 >= '(' && LA14_0 <= '[')||(LA14_0 >= ']' && LA14_0 <= '\uFFFF')) ) {
                    alt14=3;
                }


                switch (alt14) {
            	case 1 :
            	    // Xmu2.g:7876:10: ( '\\\\' '\\'' )
            	    {
            	    // Xmu2.g:7876:10: ( '\\\\' '\\'' )
            	    // Xmu2.g:7876:11: '\\\\' '\\''
            	    {
            	    match('\\'); 

            	    match('\''); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Xmu2.g:7876:21: ( '\\\\' '\\\\' )
            	    {
            	    // Xmu2.g:7876:21: ( '\\\\' '\\\\' )
            	    // Xmu2.g:7876:22: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Xmu2.g:7876:32: (~ ( '\\'' | '\\\\' ) )
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
            	    break loop14;
                }
            } while (true);


            // Xmu2.g:7876:48: ( '\\'' )
            // Xmu2.g:7876:49: '\\''
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
        // Xmu2.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | TYPE | BOOLEAN | NAME | NUMBER | SL_COMMENT | ML_COMMENT | OBJ_URI | TEXT | WHITESPACE | LINEBREAK | QUOTED_60_62_92 | QUOTED_39_39_92 )
        int alt15=67;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // Xmu2.g:1:10: T__16
                {
                mT__16(); 


                }
                break;
            case 2 :
                // Xmu2.g:1:16: T__17
                {
                mT__17(); 


                }
                break;
            case 3 :
                // Xmu2.g:1:22: T__18
                {
                mT__18(); 


                }
                break;
            case 4 :
                // Xmu2.g:1:28: T__19
                {
                mT__19(); 


                }
                break;
            case 5 :
                // Xmu2.g:1:34: T__20
                {
                mT__20(); 


                }
                break;
            case 6 :
                // Xmu2.g:1:40: T__21
                {
                mT__21(); 


                }
                break;
            case 7 :
                // Xmu2.g:1:46: T__22
                {
                mT__22(); 


                }
                break;
            case 8 :
                // Xmu2.g:1:52: T__23
                {
                mT__23(); 


                }
                break;
            case 9 :
                // Xmu2.g:1:58: T__24
                {
                mT__24(); 


                }
                break;
            case 10 :
                // Xmu2.g:1:64: T__25
                {
                mT__25(); 


                }
                break;
            case 11 :
                // Xmu2.g:1:70: T__26
                {
                mT__26(); 


                }
                break;
            case 12 :
                // Xmu2.g:1:76: T__27
                {
                mT__27(); 


                }
                break;
            case 13 :
                // Xmu2.g:1:82: T__28
                {
                mT__28(); 


                }
                break;
            case 14 :
                // Xmu2.g:1:88: T__29
                {
                mT__29(); 


                }
                break;
            case 15 :
                // Xmu2.g:1:94: T__30
                {
                mT__30(); 


                }
                break;
            case 16 :
                // Xmu2.g:1:100: T__31
                {
                mT__31(); 


                }
                break;
            case 17 :
                // Xmu2.g:1:106: T__32
                {
                mT__32(); 


                }
                break;
            case 18 :
                // Xmu2.g:1:112: T__33
                {
                mT__33(); 


                }
                break;
            case 19 :
                // Xmu2.g:1:118: T__34
                {
                mT__34(); 


                }
                break;
            case 20 :
                // Xmu2.g:1:124: T__35
                {
                mT__35(); 


                }
                break;
            case 21 :
                // Xmu2.g:1:130: T__36
                {
                mT__36(); 


                }
                break;
            case 22 :
                // Xmu2.g:1:136: T__37
                {
                mT__37(); 


                }
                break;
            case 23 :
                // Xmu2.g:1:142: T__38
                {
                mT__38(); 


                }
                break;
            case 24 :
                // Xmu2.g:1:148: T__39
                {
                mT__39(); 


                }
                break;
            case 25 :
                // Xmu2.g:1:154: T__40
                {
                mT__40(); 


                }
                break;
            case 26 :
                // Xmu2.g:1:160: T__41
                {
                mT__41(); 


                }
                break;
            case 27 :
                // Xmu2.g:1:166: T__42
                {
                mT__42(); 


                }
                break;
            case 28 :
                // Xmu2.g:1:172: T__43
                {
                mT__43(); 


                }
                break;
            case 29 :
                // Xmu2.g:1:178: T__44
                {
                mT__44(); 


                }
                break;
            case 30 :
                // Xmu2.g:1:184: T__45
                {
                mT__45(); 


                }
                break;
            case 31 :
                // Xmu2.g:1:190: T__46
                {
                mT__46(); 


                }
                break;
            case 32 :
                // Xmu2.g:1:196: T__47
                {
                mT__47(); 


                }
                break;
            case 33 :
                // Xmu2.g:1:202: T__48
                {
                mT__48(); 


                }
                break;
            case 34 :
                // Xmu2.g:1:208: T__49
                {
                mT__49(); 


                }
                break;
            case 35 :
                // Xmu2.g:1:214: T__50
                {
                mT__50(); 


                }
                break;
            case 36 :
                // Xmu2.g:1:220: T__51
                {
                mT__51(); 


                }
                break;
            case 37 :
                // Xmu2.g:1:226: T__52
                {
                mT__52(); 


                }
                break;
            case 38 :
                // Xmu2.g:1:232: T__53
                {
                mT__53(); 


                }
                break;
            case 39 :
                // Xmu2.g:1:238: T__54
                {
                mT__54(); 


                }
                break;
            case 40 :
                // Xmu2.g:1:244: T__55
                {
                mT__55(); 


                }
                break;
            case 41 :
                // Xmu2.g:1:250: T__56
                {
                mT__56(); 


                }
                break;
            case 42 :
                // Xmu2.g:1:256: T__57
                {
                mT__57(); 


                }
                break;
            case 43 :
                // Xmu2.g:1:262: T__58
                {
                mT__58(); 


                }
                break;
            case 44 :
                // Xmu2.g:1:268: T__59
                {
                mT__59(); 


                }
                break;
            case 45 :
                // Xmu2.g:1:274: T__60
                {
                mT__60(); 


                }
                break;
            case 46 :
                // Xmu2.g:1:280: T__61
                {
                mT__61(); 


                }
                break;
            case 47 :
                // Xmu2.g:1:286: T__62
                {
                mT__62(); 


                }
                break;
            case 48 :
                // Xmu2.g:1:292: T__63
                {
                mT__63(); 


                }
                break;
            case 49 :
                // Xmu2.g:1:298: T__64
                {
                mT__64(); 


                }
                break;
            case 50 :
                // Xmu2.g:1:304: T__65
                {
                mT__65(); 


                }
                break;
            case 51 :
                // Xmu2.g:1:310: T__66
                {
                mT__66(); 


                }
                break;
            case 52 :
                // Xmu2.g:1:316: T__67
                {
                mT__67(); 


                }
                break;
            case 53 :
                // Xmu2.g:1:322: T__68
                {
                mT__68(); 


                }
                break;
            case 54 :
                // Xmu2.g:1:328: T__69
                {
                mT__69(); 


                }
                break;
            case 55 :
                // Xmu2.g:1:334: T__70
                {
                mT__70(); 


                }
                break;
            case 56 :
                // Xmu2.g:1:340: TYPE
                {
                mTYPE(); 


                }
                break;
            case 57 :
                // Xmu2.g:1:345: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 58 :
                // Xmu2.g:1:353: NAME
                {
                mNAME(); 


                }
                break;
            case 59 :
                // Xmu2.g:1:358: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 60 :
                // Xmu2.g:1:365: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 61 :
                // Xmu2.g:1:376: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 62 :
                // Xmu2.g:1:387: OBJ_URI
                {
                mOBJ_URI(); 


                }
                break;
            case 63 :
                // Xmu2.g:1:395: TEXT
                {
                mTEXT(); 


                }
                break;
            case 64 :
                // Xmu2.g:1:400: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 65 :
                // Xmu2.g:1:411: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 66 :
                // Xmu2.g:1:421: QUOTED_60_62_92
                {
                mQUOTED_60_62_92(); 


                }
                break;
            case 67 :
                // Xmu2.g:1:437: QUOTED_39_39_92
                {
                mQUOTED_39_39_92(); 


                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\4\uffff\1\57\1\uffff\1\61\1\uffff\1\65\1\67\1\uffff\1\71\1\uffff"+
        "\1\74\2\uffff\21\101\3\uffff\5\101\1\141\16\uffff\1\143\4\uffff"+
        "\1\101\1\145\1\uffff\1\101\1\uffff\1\146\15\101\1\166\20\101\1\uffff"+
        "\1\62\1\uffff\1\u0088\2\uffff\15\101\1\u0097\1\101\1\uffff\6\101"+
        "\1\u009f\12\101\1\uffff\1\u00aa\12\101\1\u00b5\2\101\1\uffff\1\u00b8"+
        "\1\101\1\u00ba\1\101\1\u00bc\2\101\1\uffff\1\u00bf\3\101\1\u00c3"+
        "\1\u00c4\4\101\1\uffff\3\101\1\u00cc\1\101\1\u00ce\2\101\1\u00bf"+
        "\1\101\1\uffff\1\u00d2\1\101\1\uffff\1\101\1\uffff\1\101\1\uffff"+
        "\2\101\1\uffff\3\101\2\uffff\5\101\1\u00e0\1\101\1\uffff\1\u00e2"+
        "\1\uffff\1\u00e3\1\101\1\u00e5\1\uffff\1\u00e6\1\101\1\u00e8\1\u00e9"+
        "\1\u00ea\2\101\1\u00ed\1\77\3\101\1\u00f1\1\uffff\1\u00f2\2\uffff"+
        "\1\u00f3\2\uffff\1\101\3\uffff\2\101\1\uffff\2\77\1\101\3\uffff"+
        "\2\101\1\u00fb\1\u00fc\1\77\1\u00fd\1\u00fe\4\uffff";
    static final String DFA15_eofS =
        "\u00ff\uffff";
    static final String DFA15_minS =
        "\1\11\3\uffff\1\53\1\uffff\1\55\1\uffff\1\52\1\72\1\uffff\1\0\1"+
        "\uffff\1\75\2\uffff\21\41\3\uffff\6\41\16\uffff\1\0\4\uffff\2\41"+
        "\1\uffff\1\41\1\uffff\37\41\1\uffff\1\41\1\uffff\1\41\2\uffff\17"+
        "\41\1\uffff\21\41\1\uffff\16\41\1\uffff\7\41\1\uffff\12\41\1\uffff"+
        "\12\41\1\uffff\2\41\1\uffff\1\41\1\uffff\1\41\1\uffff\2\41\1\uffff"+
        "\3\41\2\uffff\7\41\1\uffff\1\41\1\uffff\3\41\1\uffff\10\41\1\55"+
        "\4\41\1\uffff\1\41\2\uffff\1\41\2\uffff\1\41\3\uffff\2\41\1\uffff"+
        "\2\55\1\41\3\uffff\4\41\1\55\2\41\4\uffff";
    static final String DFA15_maxS =
        "\1\175\3\uffff\1\53\1\uffff\1\172\1\uffff\1\57\1\72\1\uffff\1\uffff"+
        "\1\uffff\1\75\2\uffff\21\172\3\uffff\6\172\16\uffff\1\uffff\4\uffff"+
        "\2\172\1\uffff\1\172\1\uffff\37\172\1\uffff\1\172\1\uffff\1\172"+
        "\2\uffff\17\172\1\uffff\21\172\1\uffff\16\172\1\uffff\7\172\1\uffff"+
        "\12\172\1\uffff\12\172\1\uffff\2\172\1\uffff\1\172\1\uffff\1\172"+
        "\1\uffff\2\172\1\uffff\3\172\2\uffff\7\172\1\uffff\1\172\1\uffff"+
        "\3\172\1\uffff\15\172\1\uffff\1\172\2\uffff\1\172\2\uffff\1\172"+
        "\3\uffff\2\172\1\uffff\3\172\3\uffff\7\172\4\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\uffff\1\11\2\uffff\1\15\1\uffff"+
        "\1\20\1\uffff\1\23\1\24\21\uffff\1\65\1\66\1\67\6\uffff\1\76\1\100"+
        "\1\101\1\103\1\5\1\4\1\10\1\7\1\77\1\74\1\75\1\12\1\14\1\13\1\uffff"+
        "\1\16\1\102\1\22\1\21\2\uffff\1\70\1\uffff\1\72\37\uffff\1\73\1"+
        "\uffff\1\17\1\uffff\1\26\1\27\17\uffff\1\47\21\uffff\1\25\16\uffff"+
        "\1\45\7\uffff\1\56\12\uffff\1\30\12\uffff\1\42\2\uffff\1\46\1\uffff"+
        "\1\51\1\uffff\1\53\2\uffff\1\71\3\uffff\1\63\1\64\7\uffff\1\34\1"+
        "\uffff\1\36\3\uffff\1\43\15\uffff\1\32\1\uffff\1\35\1\37\1\uffff"+
        "\1\41\1\44\1\uffff\1\52\1\54\1\55\2\uffff\1\62\3\uffff\1\31\1\33"+
        "\1\40\7\uffff\1\60\1\61\1\50\1\57";
    static final String DFA15_specialS =
        "\13\uffff\1\0\54\uffff\1\1\u00c6\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\53\1\54\1\uffff\1\53\1\54\22\uffff\1\53\6\uffff\1\55\1\1"+
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\12\51\1\11\1\12\1\13\1\14\1\15"+
            "\1\uffff\1\52\1\50\1\45\6\50\1\46\10\50\1\47\1\44\7\50\1\16"+
            "\1\uffff\1\17\1\uffff\1\50\1\uffff\1\20\1\21\1\22\1\23\1\24"+
            "\1\25\2\50\1\26\2\50\1\27\1\30\1\31\1\32\2\50\1\33\1\34\1\35"+
            "\1\36\1\37\1\40\3\50\1\41\1\42\1\43",
            "",
            "",
            "",
            "\1\56",
            "",
            "\1\62\2\uffff\12\62\4\uffff\1\60\2\uffff\32\62\4\uffff\1\62"+
            "\1\uffff\32\62",
            "",
            "\1\64\4\uffff\1\63",
            "\1\66",
            "",
            "\75\72\1\70\uffc2\72",
            "",
            "\1\73",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\15\100\1\75\5\100\1\76\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\30\100\1\102\1\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\103\31\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\104\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\15\100\1\105\11\100\1\106\2\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\111\7\100\1\107\5\100\1\110\13\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\14\100\1\112\15\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\113\31\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\114\15\100\1\115\13\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\16\100\1\116\5\100\1\117\5\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\120\1\100\1\121\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\24\100\1\122\5\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\123\5\100\1\124\3\100\1\125\7\100\1\126"+
            "\3\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\16\100\1\127\2\100\1\130\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\15\100\1\131\1\100\1\132\12\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\10\100\1\133\21\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\10\100\1\134\21\100",
            "",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\135\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\16\100\1\136\13\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\15\100\1\137\14\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\140\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\51\7\uffff\32\142\4\uffff\1"+
            "\142\1\uffff\32\142",
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
            "",
            "",
            "",
            "\0\72",
            "",
            "",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\3\100\1\144\26\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\32\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\147\7\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\5\100\1\150\5\100\1\151\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\5\100\1\152\15\100\1\153\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\10\100\1\154\21\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\155\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\156\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\157\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\17\100\1\160\12\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\161\7\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\162\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\3\100\1\163\26\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\164\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\165\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\7\100\1\167\22\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\170\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\171\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\10\100\1\172\21\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\24\100\1\173\5\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\10\100\1\174\21\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\17\100\1\175\12\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\24\100\1\176\5\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\3\100\1\177\10\100\1\u0080\15\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\3\100\1\u0081\26\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u0082\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u0083\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\u0084\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\16\100\1\u0085\13\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u0086\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\u0087\7\100",
            "",
            "\1\77\16\uffff\12\142\7\uffff\32\142\4\uffff\1\142\1\uffff"+
            "\32\142",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u0089\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\u008a\31\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u008b\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\16\100\1\u008c\13\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\u008d\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\u008e\7\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\u008f\7\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\1\u0090\31\100\4"+
            "\uffff\1\100\1\uffff\4\100\1\u0091\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\u0092\7\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\16\100\1\u0093\13\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u0094\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\2\100\1\u0095\27\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\24\100\1\u0096\5\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\u0098\16\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u0099\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u009a\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u009b\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\17\100\1\u009c\12\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\u009d\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u009e\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00a0\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00a1\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\u00a2\31\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\u00a3\31\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\26\100\1\u00a4\3\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\7\100\1\u00a5\22\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\10\100\1\u00a6\21\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\u00a7\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00a8\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\16\100\1\u00a9\13\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\24\100\1\u00ab\5\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u00ac\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\u00ad\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\30\100\1\u00ae\1\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u00af\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u00b0\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\u00b1\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\u00b2\31\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00b3\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\u00b4\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\7\100\1\u00b6\22\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\u00b7\16\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\u00b9\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\2\100\1\u00bb\27\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\2\100\1\u00bd\27\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\2\100\1\u00be\27\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\5\100\1\u00c0\24\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u00c1\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u00c2\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\15\100\1\u00c5\14\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00c6\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\6\100\1\u00c7\23\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\24\100\1\u00c8\5\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\u00c9\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00ca\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\2\100\1\u00cb\27\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\u00cd\7\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\13\100\1\u00cf\16\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\2\100\1\u00d0\27\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u00d1\6\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00d3\25\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\26\100\1\u00d4\3\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u00d5\6\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00d6\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\7\100\1\u00d7\22\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\10\100\1\u00d8\21\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\2\100\1\u00d9\27\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00da\25\100",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\6\100\1\u00db\23\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\1\u00dc\31\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00dd\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\u00de\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\23\100\1\u00df\6\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00e1\25\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\7\100\1\u00e4\22\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\10\100\1\u00e7\21\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\15\100\1\u00eb\14\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\7\100\1\u00ec\22\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\15\100\1\u00ee\14\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\21\100\1\u00ef\10\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\2\100\1\u00f0\27\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\u00f4\7\100",
            "",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00f5\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\22\100\1\u00f6\2\100\1\u00f7\4\100",
            "",
            "\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00f8\25\100",
            "",
            "",
            "",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\4\100\1\u00f9\25\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\7\uffff\32\100\4\uffff\1"+
            "\100\1\uffff\3\100\1\u00fa\26\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "\1\77\13\uffff\1\62\2\uffff\12\100\6\uffff\1\101\32\100\4\uffff"+
            "\1\100\1\uffff\32\100",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | TYPE | BOOLEAN | NAME | NUMBER | SL_COMMENT | ML_COMMENT | OBJ_URI | TEXT | WHITESPACE | LINEBREAK | QUOTED_60_62_92 | QUOTED_39_39_92 );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_11 = input.LA(1);

                        s = -1;
                        if ( (LA15_11=='=') ) {s = 56;}

                        else if ( ((LA15_11 >= '\u0000' && LA15_11 <= '<')||(LA15_11 >= '>' && LA15_11 <= '\uFFFF')) ) {s = 58;}

                        else s = 57;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_56 = input.LA(1);

                        s = -1;
                        if ( ((LA15_56 >= '\u0000' && LA15_56 <= '\uFFFF')) ) {s = 58;}

                        else s = 99;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}