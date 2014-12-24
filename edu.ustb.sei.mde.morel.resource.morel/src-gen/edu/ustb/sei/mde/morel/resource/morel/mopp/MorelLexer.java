// $ANTLR 3.4

	package edu.ustb.sei.mde.morel.resource.morel.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MorelLexer extends Lexer {
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
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int COLLECTION=4;
    public static final int DATA_TYPE=5;
    public static final int IDENTIFIER=6;
    public static final int INUMBER=7;
    public static final int LINEBREAK=8;
    public static final int ML_COMMENT=9;
    public static final int QUOTED_39_39_92=10;
    public static final int RNUMBER=11;
    public static final int SL_COMMENT=12;
    public static final int URINS=13;
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

    public MorelLexer() {} 
    public MorelLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MorelLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Morel.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:17:7: ( '#' )
            // Morel.g:17:9: '#'
            {
            match('#'); 

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
            // Morel.g:18:7: ( '&&' )
            // Morel.g:18:9: '&&'
            {
            match("&&"); 



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
            // Morel.g:19:7: ( '&' )
            // Morel.g:19:9: '&'
            {
            match('&'); 

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
            // Morel.g:20:7: ( '(' )
            // Morel.g:20:9: '('
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:21:7: ( ')' )
            // Morel.g:21:9: ')'
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:22:7: ( '*' )
            // Morel.g:22:9: '*'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:23:7: ( '+' )
            // Morel.g:23:9: '+'
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:24:7: ( ',' )
            // Morel.g:24:9: ','
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:25:7: ( '-' )
            // Morel.g:25:9: '-'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:26:7: ( '->' )
            // Morel.g:26:9: '->'
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:27:7: ( '.' )
            // Morel.g:27:9: '.'
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:28:7: ( '/' )
            // Morel.g:28:9: '/'
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:29:7: ( ':' )
            // Morel.g:29:9: ':'
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:30:7: ( ';' )
            // Morel.g:30:9: ';'
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:31:7: ( '<' )
            // Morel.g:31:9: '<'
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:32:7: ( '<-' )
            // Morel.g:32:9: '<-'
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:33:7: ( '<=' )
            // Morel.g:33:9: '<='
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:34:7: ( '<>' )
            // Morel.g:34:9: '<>'
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:35:7: ( '=' )
            // Morel.g:35:9: '='
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:36:7: ( '=>' )
            // Morel.g:36:9: '=>'
            {
            match("=>"); 



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
            // Morel.g:37:7: ( '>' )
            // Morel.g:37:9: '>'
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:38:7: ( '>=' )
            // Morel.g:38:9: '>='
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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:39:7: ( '@' )
            // Morel.g:39:9: '@'
            {
            match('@'); 

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
            // Morel.g:40:7: ( '@id' )
            // Morel.g:40:9: '@id'
            {
            match("@id"); 



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
            // Morel.g:41:7: ( '@this' )
            // Morel.g:41:9: '@this'
            {
            match("@this"); 



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
            // Morel.g:42:7: ( '[' )
            // Morel.g:42:9: '['
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
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:43:7: ( ']' )
            // Morel.g:43:9: ']'
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
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:44:7: ( '^' )
            // Morel.g:44:9: '^'
            {
            match('^'); 

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
            // Morel.g:45:7: ( 'active' )
            // Morel.g:45:9: 'active'
            {
            match("active"); 



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
            // Morel.g:46:7: ( 'all' )
            // Morel.g:46:9: 'all'
            {
            match("all"); 



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
            // Morel.g:47:7: ( 'allDiff' )
            // Morel.g:47:9: 'allDiff'
            {
            match("allDiff"); 



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
            // Morel.g:48:7: ( 'and' )
            // Morel.g:48:9: 'and'
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
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:49:7: ( 'any' )
            // Morel.g:49:9: 'any'
            {
            match("any"); 



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
            // Morel.g:50:7: ( 'closure' )
            // Morel.g:50:9: 'closure'
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
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:51:7: ( 'collect' )
            // Morel.g:51:9: 'collect'
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
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:52:7: ( 'createOnly' )
            // Morel.g:52:9: 'createOnly'
            {
            match("createOnly"); 



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
            // Morel.g:53:7: ( 'default' )
            // Morel.g:53:9: 'default'
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
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:54:7: ( 'else' )
            // Morel.g:54:9: 'else'
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
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:55:7: ( 'endif' )
            // Morel.g:55:9: 'endif'
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
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:56:7: ( 'exists' )
            // Morel.g:56:9: 'exists'
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
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:57:7: ( 'false' )
            // Morel.g:57:9: 'false'
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
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:58:7: ( 'for' )
            // Morel.g:58:9: 'for'
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
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:59:7: ( 'forAll' )
            // Morel.g:59:9: 'forAll'
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
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:60:7: ( 'group' )
            // Morel.g:60:9: 'group'
            {
            match("group"); 



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
            // Morel.g:61:7: ( 'if' )
            // Morel.g:61:9: 'if'
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
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:62:7: ( 'implies' )
            // Morel.g:62:9: 'implies'
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
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:63:7: ( 'in' )
            // Morel.g:63:9: 'in'
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
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:64:7: ( 'invalid' )
            // Morel.g:64:9: 'invalid'
            {
            match("invalid"); 



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
            // Morel.g:65:7: ( 'iterating' )
            // Morel.g:65:9: 'iterating'
            {
            match("iterating"); 



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
            // Morel.g:66:7: ( 'let' )
            // Morel.g:66:9: 'let'
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
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:67:7: ( 'lhs' )
            // Morel.g:67:9: 'lhs'
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
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:68:7: ( 'match' )
            // Morel.g:68:9: 'match'
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
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:69:7: ( 'nac' )
            // Morel.g:69:9: 'nac'
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
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:70:7: ( 'not' )
            // Morel.g:70:9: 'not'
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
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:71:7: ( 'null' )
            // Morel.g:71:9: 'null'
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
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:72:7: ( 'or' )
            // Morel.g:72:9: 'or'
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
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:73:7: ( 'order' )
            // Morel.g:73:9: 'order'
            {
            match("order"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:74:7: ( 'pac' )
            // Morel.g:74:9: 'pac'
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
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:75:7: ( 'parallel' )
            // Morel.g:75:9: 'parallel'
            {
            match("parallel"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:76:7: ( 'passive' )
            // Morel.g:76:9: 'passive'
            {
            match("passive"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:77:7: ( 'post' )
            // Morel.g:77:9: 'post'
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
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:78:7: ( 'pre' )
            // Morel.g:78:9: 'pre'
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
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:79:7: ( 'query' )
            // Morel.g:79:9: 'query'
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
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:80:7: ( 'querymodel' )
            // Morel.g:80:9: 'querymodel'
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
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:81:7: ( 'random' )
            // Morel.g:81:9: 'random'
            {
            match("random"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:82:7: ( 'random*' )
            // Morel.g:82:9: 'random*'
            {
            match("random*"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:83:7: ( 'readOnly' )
            // Morel.g:83:9: 'readOnly'
            {
            match("readOnly"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:84:7: ( 'reject' )
            // Morel.g:84:9: 'reject'
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
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:85:7: ( 'repeating' )
            // Morel.g:85:9: 'repeating'
            {
            match("repeating"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:86:7: ( 'rhs' )
            // Morel.g:86:9: 'rhs'
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
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:87:7: ( 'rule' )
            // Morel.g:87:9: 'rule'
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
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:88:7: ( 'scope' )
            // Morel.g:88:9: 'scope'
            {
            match("scope"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:89:7: ( 'select' )
            // Morel.g:89:9: 'select'
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
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:90:7: ( 'sequential' )
            // Morel.g:90:9: 'sequential'
            {
            match("sequential"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:91:7: ( 'then' )
            // Morel.g:91:9: 'then'
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
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:92:7: ( 'transformation' )
            // Morel.g:92:9: 'transformation'
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
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:93:7: ( 'transient' )
            // Morel.g:93:9: 'transient'
            {
            match("transient"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:94:7: ( 'true' )
            // Morel.g:94:9: 'true'
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
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:95:7: ( 'type' )
            // Morel.g:95:9: 'type'
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
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:96:7: ( 'view' )
            // Morel.g:96:9: 'view'
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
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:97:7: ( 'where' )
            // Morel.g:97:9: 'where'
            {
            match("where"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:98:7: ( '{' )
            // Morel.g:98:9: '{'
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
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:99:7: ( '|' )
            // Morel.g:99:9: '|'
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
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:100:8: ( '||' )
            // Morel.g:100:10: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:101:8: ( '}' )
            // Morel.g:101:10: '}'
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
    // $ANTLR end "T__101"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:12817:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Morel.g:12818:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Morel.g:12818:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Morel.g:12818:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Morel.g:12818:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Morel.g:12818:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Morel.g:12818:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Morel.g:12818:16: '\\n'
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

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:12821:11: ( ( '--' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Morel.g:12822:2: ( '--' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Morel.g:12822:2: ( '--' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Morel.g:12822:4: '--' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("--"); 



            // Morel.g:12822:8: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFE')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Morel.g:
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
            	    break loop2;
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
            // Morel.g:12825:11: ( ( '/*' ( . )* '*/' ) )
            // Morel.g:12826:2: ( '/*' ( . )* '*/' )
            {
            // Morel.g:12826:2: ( '/*' ( . )* '*/' )
            // Morel.g:12826:4: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Morel.g:12826:8: ( . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Morel.g:12826:8: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
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

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:12829:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Morel.g:12830:2: ( ( ' ' | '\\t' | '\\f' ) )
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

    // $ANTLR start "COLLECTION"
    public final void mCOLLECTION() throws RecognitionException {
        try {
            int _type = COLLECTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:12833:11: ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) ) )
            // Morel.g:12834:2: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) )
            {
            // Morel.g:12834:2: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) )
            // Morel.g:12834:3: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' )
            {
            // Morel.g:12834:3: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 'S':
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='e') ) {
                    int LA4_4 = input.LA(3);

                    if ( (LA4_4=='q') ) {
                        alt4=1;
                    }
                    else if ( (LA4_4=='t') ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 4, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
                }
                break;
            case 'B':
                {
                alt4=3;
                }
                break;
            case 'O':
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // Morel.g:12834:4: 'Sequence'
                    {
                    match("Sequence"); 



                    }
                    break;
                case 2 :
                    // Morel.g:12834:15: 'Set'
                    {
                    match("Set"); 



                    }
                    break;
                case 3 :
                    // Morel.g:12834:21: 'Bag'
                    {
                    match("Bag"); 



                    }
                    break;
                case 4 :
                    // Morel.g:12834:27: 'OrderedSet'
                    {
                    match("OrderedSet"); 



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
    // $ANTLR end "COLLECTION"

    // $ANTLR start "DATA_TYPE"
    public final void mDATA_TYPE() throws RecognitionException {
        try {
            int _type = DATA_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:12836:10: ( ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )* | ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+ ) )
            // Morel.g:12837:2: ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )* | ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+ )
            {
            // Morel.g:12837:2: ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )* | ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+ )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // Morel.g:12837:3: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )*
                    {
                    // Morel.g:12837:3: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )*
                    loop6:
                    do {
                        int alt6=2;
                        switch ( input.LA(1) ) {
                        case 'S':
                            {
                            int LA6_1 = input.LA(2);

                            if ( (LA6_1=='e') ) {
                                alt6=1;
                            }


                            }
                            break;
                        case 'B':
                            {
                            int LA6_3 = input.LA(2);

                            if ( (LA6_3=='a') ) {
                                alt6=1;
                            }


                            }
                            break;
                        case 'O':
                            {
                            alt6=1;
                            }
                            break;

                        }

                        switch (alt6) {
                    	case 1 :
                    	    // Morel.g:12837:4: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '('
                    	    {
                    	    // Morel.g:12837:4: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' )
                    	    int alt5=4;
                    	    switch ( input.LA(1) ) {
                    	    case 'S':
                    	        {
                    	        int LA5_1 = input.LA(2);

                    	        if ( (LA5_1=='e') ) {
                    	            int LA5_4 = input.LA(3);

                    	            if ( (LA5_4=='q') ) {
                    	                alt5=1;
                    	            }
                    	            else if ( (LA5_4=='t') ) {
                    	                alt5=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 5, 4, input);

                    	                throw nvae;

                    	            }
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 5, 1, input);

                    	            throw nvae;

                    	        }
                    	        }
                    	        break;
                    	    case 'B':
                    	        {
                    	        alt5=3;
                    	        }
                    	        break;
                    	    case 'O':
                    	        {
                    	        alt5=4;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 5, 0, input);

                    	        throw nvae;

                    	    }

                    	    switch (alt5) {
                    	        case 1 :
                    	            // Morel.g:12837:5: 'Sequence'
                    	            {
                    	            match("Sequence"); 



                    	            }
                    	            break;
                    	        case 2 :
                    	            // Morel.g:12837:16: 'Set'
                    	            {
                    	            match("Set"); 



                    	            }
                    	            break;
                    	        case 3 :
                    	            // Morel.g:12837:22: 'Bag'
                    	            {
                    	            match("Bag"); 



                    	            }
                    	            break;
                    	        case 4 :
                    	            // Morel.g:12837:28: 'OrderedSet'
                    	            {
                    	            match("OrderedSet"); 



                    	            }
                    	            break;

                    	    }


                    	    match('('); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    // Morel.g:12837:46: ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' )
                    int alt7=6;
                    switch ( input.LA(1) ) {
                    case 'S':
                        {
                        alt7=1;
                        }
                        break;
                    case 'I':
                        {
                        alt7=2;
                        }
                        break;
                    case 'B':
                        {
                        alt7=3;
                        }
                        break;
                    case 'R':
                        {
                        alt7=4;
                        }
                        break;
                    case 'C':
                        {
                        alt7=5;
                        }
                        break;
                    case 'A':
                        {
                        alt7=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;

                    }

                    switch (alt7) {
                        case 1 :
                            // Morel.g:12837:47: 'String'
                            {
                            match("String"); 



                            }
                            break;
                        case 2 :
                            // Morel.g:12837:56: 'Integer'
                            {
                            match("Integer"); 



                            }
                            break;
                        case 3 :
                            // Morel.g:12837:66: 'Boolean'
                            {
                            match("Boolean"); 



                            }
                            break;
                        case 4 :
                            // Morel.g:12837:76: 'Real'
                            {
                            match("Real"); 



                            }
                            break;
                        case 5 :
                            // Morel.g:12837:83: 'Char'
                            {
                            match("Char"); 



                            }
                            break;
                        case 6 :
                            // Morel.g:12837:90: 'Any'
                            {
                            match("Any"); 



                            }
                            break;

                    }


                    // Morel.g:12837:96: ( ')' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==')') ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Morel.g:12837:96: ')'
                    	    {
                    	    match(')'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Morel.g:12837:101: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+
                    {
                    // Morel.g:12837:101: ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        switch ( input.LA(1) ) {
                        case 'S':
                            {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1=='e') ) {
                                int LA10_5 = input.LA(3);

                                if ( (LA10_5=='q') ) {
                                    int LA10_8 = input.LA(4);

                                    if ( (LA10_8=='u') ) {
                                        int LA10_12 = input.LA(5);

                                        if ( (LA10_12=='e') ) {
                                            int LA10_15 = input.LA(6);

                                            if ( (LA10_15=='n') ) {
                                                int LA10_17 = input.LA(7);

                                                if ( (LA10_17=='c') ) {
                                                    int LA10_19 = input.LA(8);

                                                    if ( (LA10_19=='e') ) {
                                                        int LA10_21 = input.LA(9);

                                                        if ( (LA10_21=='(') ) {
                                                            alt10=1;
                                                        }


                                                    }


                                                }


                                            }


                                        }


                                    }


                                }
                                else if ( (LA10_5=='t') ) {
                                    int LA10_9 = input.LA(4);

                                    if ( (LA10_9=='(') ) {
                                        alt10=1;
                                    }


                                }


                            }


                            }
                            break;
                        case 'B':
                            {
                            int LA10_2 = input.LA(2);

                            if ( (LA10_2=='a') ) {
                                int LA10_6 = input.LA(3);

                                if ( (LA10_6=='g') ) {
                                    int LA10_10 = input.LA(4);

                                    if ( (LA10_10=='(') ) {
                                        alt10=1;
                                    }


                                }


                            }


                            }
                            break;
                        case 'O':
                            {
                            int LA10_3 = input.LA(2);

                            if ( (LA10_3=='r') ) {
                                int LA10_7 = input.LA(3);

                                if ( (LA10_7=='d') ) {
                                    int LA10_11 = input.LA(4);

                                    if ( (LA10_11=='e') ) {
                                        int LA10_14 = input.LA(5);

                                        if ( (LA10_14=='r') ) {
                                            int LA10_16 = input.LA(6);

                                            if ( (LA10_16=='e') ) {
                                                int LA10_18 = input.LA(7);

                                                if ( (LA10_18=='d') ) {
                                                    int LA10_20 = input.LA(8);

                                                    if ( (LA10_20=='S') ) {
                                                        int LA10_22 = input.LA(9);

                                                        if ( (LA10_22=='e') ) {
                                                            int LA10_23 = input.LA(10);

                                                            if ( (LA10_23=='t') ) {
                                                                int LA10_24 = input.LA(11);

                                                                if ( (LA10_24=='(') ) {
                                                                    alt10=1;
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

                        switch (alt10) {
                    	case 1 :
                    	    // Morel.g:12837:102: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '('
                    	    {
                    	    // Morel.g:12837:102: ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' )
                    	    int alt9=4;
                    	    switch ( input.LA(1) ) {
                    	    case 'S':
                    	        {
                    	        int LA9_1 = input.LA(2);

                    	        if ( (LA9_1=='e') ) {
                    	            int LA9_4 = input.LA(3);

                    	            if ( (LA9_4=='q') ) {
                    	                alt9=1;
                    	            }
                    	            else if ( (LA9_4=='t') ) {
                    	                alt9=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 9, 4, input);

                    	                throw nvae;

                    	            }
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 9, 1, input);

                    	            throw nvae;

                    	        }
                    	        }
                    	        break;
                    	    case 'B':
                    	        {
                    	        alt9=3;
                    	        }
                    	        break;
                    	    case 'O':
                    	        {
                    	        alt9=4;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 9, 0, input);

                    	        throw nvae;

                    	    }

                    	    switch (alt9) {
                    	        case 1 :
                    	            // Morel.g:12837:103: 'Sequence'
                    	            {
                    	            match("Sequence"); 



                    	            }
                    	            break;
                    	        case 2 :
                    	            // Morel.g:12837:114: 'Set'
                    	            {
                    	            match("Set"); 



                    	            }
                    	            break;
                    	        case 3 :
                    	            // Morel.g:12837:120: 'Bag'
                    	            {
                    	            match("Bag"); 



                    	            }
                    	            break;
                    	        case 4 :
                    	            // Morel.g:12837:126: 'OrderedSet'
                    	            {
                    	            match("OrderedSet"); 



                    	            }
                    	            break;

                    	    }


                    	    match('('); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    // Morel.g:12837:144: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
                    // Morel.g:12837:145: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Morel.g:12837:168: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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


                    // Morel.g:12837:202: ( ')' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==')') ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Morel.g:12837:202: ')'
                    	    {
                    	    match(')'); 

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
            // Morel.g:12839:11: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) )
            // Morel.g:12840:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            {
            // Morel.g:12840:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // Morel.g:12840:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Morel.g:12840:26: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= '0' && LA14_0 <= '9')||(LA14_0 >= 'A' && LA14_0 <= 'Z')||LA14_0=='_'||(LA14_0 >= 'a' && LA14_0 <= 'z')) ) {
                    alt14=1;
                }


                switch (alt14) {
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
            	    break loop14;
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
            // Morel.g:12842:6: ( ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+ ) )
            // Morel.g:12843:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+ )
            {
            // Morel.g:12843:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+ )
            // Morel.g:12843:3: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+
            {
            match('@'); 

            // Morel.g:12843:6: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '/' | ':' | '\\.' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= '-' && LA15_0 <= ':')||(LA15_0 >= 'A' && LA15_0 <= 'Z')||LA15_0=='_'||(LA15_0 >= 'a' && LA15_0 <= 'z')) ) {
                    alt15=1;
                }


                switch (alt15) {
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
    // $ANTLR end "URINS"

    // $ANTLR start "INUMBER"
    public final void mINUMBER() throws RecognitionException {
        try {
            int _type = INUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Morel.g:12845:8: ( ( ( '0' .. '9' ) ( '0' .. '1' )* ) )
            // Morel.g:12846:2: ( ( '0' .. '9' ) ( '0' .. '1' )* )
            {
            // Morel.g:12846:2: ( ( '0' .. '9' ) ( '0' .. '1' )* )
            // Morel.g:12846:3: ( '0' .. '9' ) ( '0' .. '1' )*
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Morel.g:12846:13: ( '0' .. '1' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= '0' && LA16_0 <= '1')) ) {
                    alt16=1;
                }


                switch (alt16) {
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
            	    break loop16;
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
            // Morel.g:12848:8: ( ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+ ) )
            // Morel.g:12849:2: ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+ )
            {
            // Morel.g:12849:2: ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+ )
            // Morel.g:12849:3: ( '0' .. '9' )+ '\\.' ( '0' .. '9' )+
            {
            // Morel.g:12849:3: ( '0' .. '9' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0 >= '0' && LA17_0 <= '9')) ) {
                    alt17=1;
                }


                switch (alt17) {
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
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            match('.'); 

            // Morel.g:12849:18: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '0' && LA18_0 <= '9')) ) {
                    alt18=1;
                }


                switch (alt18) {
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
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
            // Morel.g:12851:16: ( ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) ) )
            // Morel.g:12852:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            {
            // Morel.g:12852:2: ( ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' ) )
            // Morel.g:12852:3: ( '\\'' ) ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )* ( '\\'' )
            {
            // Morel.g:12852:3: ( '\\'' )
            // Morel.g:12852:4: '\\''
            {
            match('\''); 

            }


            // Morel.g:12852:9: ( ( '\\\\' '\\'' ) | ( '\\\\' '\\\\' ) | (~ ( '\\'' | '\\\\' ) ) )*
            loop19:
            do {
                int alt19=4;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\\') ) {
                    int LA19_2 = input.LA(2);

                    if ( (LA19_2=='\'') ) {
                        alt19=1;
                    }
                    else if ( (LA19_2=='\\') ) {
                        alt19=2;
                    }


                }
                else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '&')||(LA19_0 >= '(' && LA19_0 <= '[')||(LA19_0 >= ']' && LA19_0 <= '\uFFFF')) ) {
                    alt19=3;
                }


                switch (alt19) {
            	case 1 :
            	    // Morel.g:12852:10: ( '\\\\' '\\'' )
            	    {
            	    // Morel.g:12852:10: ( '\\\\' '\\'' )
            	    // Morel.g:12852:11: '\\\\' '\\''
            	    {
            	    match('\\'); 

            	    match('\''); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Morel.g:12852:21: ( '\\\\' '\\\\' )
            	    {
            	    // Morel.g:12852:21: ( '\\\\' '\\\\' )
            	    // Morel.g:12852:22: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Morel.g:12852:32: (~ ( '\\'' | '\\\\' ) )
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
            	    break loop19;
                }
            } while (true);


            // Morel.g:12852:48: ( '\\'' )
            // Morel.g:12852:49: '\\''
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
        // Morel.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | LINEBREAK | SL_COMMENT | ML_COMMENT | WHITESPACE | COLLECTION | DATA_TYPE | IDENTIFIER | URINS | INUMBER | RNUMBER | QUOTED_39_39_92 )
        int alt20=98;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // Morel.g:1:10: T__15
                {
                mT__15(); 


                }
                break;
            case 2 :
                // Morel.g:1:16: T__16
                {
                mT__16(); 


                }
                break;
            case 3 :
                // Morel.g:1:22: T__17
                {
                mT__17(); 


                }
                break;
            case 4 :
                // Morel.g:1:28: T__18
                {
                mT__18(); 


                }
                break;
            case 5 :
                // Morel.g:1:34: T__19
                {
                mT__19(); 


                }
                break;
            case 6 :
                // Morel.g:1:40: T__20
                {
                mT__20(); 


                }
                break;
            case 7 :
                // Morel.g:1:46: T__21
                {
                mT__21(); 


                }
                break;
            case 8 :
                // Morel.g:1:52: T__22
                {
                mT__22(); 


                }
                break;
            case 9 :
                // Morel.g:1:58: T__23
                {
                mT__23(); 


                }
                break;
            case 10 :
                // Morel.g:1:64: T__24
                {
                mT__24(); 


                }
                break;
            case 11 :
                // Morel.g:1:70: T__25
                {
                mT__25(); 


                }
                break;
            case 12 :
                // Morel.g:1:76: T__26
                {
                mT__26(); 


                }
                break;
            case 13 :
                // Morel.g:1:82: T__27
                {
                mT__27(); 


                }
                break;
            case 14 :
                // Morel.g:1:88: T__28
                {
                mT__28(); 


                }
                break;
            case 15 :
                // Morel.g:1:94: T__29
                {
                mT__29(); 


                }
                break;
            case 16 :
                // Morel.g:1:100: T__30
                {
                mT__30(); 


                }
                break;
            case 17 :
                // Morel.g:1:106: T__31
                {
                mT__31(); 


                }
                break;
            case 18 :
                // Morel.g:1:112: T__32
                {
                mT__32(); 


                }
                break;
            case 19 :
                // Morel.g:1:118: T__33
                {
                mT__33(); 


                }
                break;
            case 20 :
                // Morel.g:1:124: T__34
                {
                mT__34(); 


                }
                break;
            case 21 :
                // Morel.g:1:130: T__35
                {
                mT__35(); 


                }
                break;
            case 22 :
                // Morel.g:1:136: T__36
                {
                mT__36(); 


                }
                break;
            case 23 :
                // Morel.g:1:142: T__37
                {
                mT__37(); 


                }
                break;
            case 24 :
                // Morel.g:1:148: T__38
                {
                mT__38(); 


                }
                break;
            case 25 :
                // Morel.g:1:154: T__39
                {
                mT__39(); 


                }
                break;
            case 26 :
                // Morel.g:1:160: T__40
                {
                mT__40(); 


                }
                break;
            case 27 :
                // Morel.g:1:166: T__41
                {
                mT__41(); 


                }
                break;
            case 28 :
                // Morel.g:1:172: T__42
                {
                mT__42(); 


                }
                break;
            case 29 :
                // Morel.g:1:178: T__43
                {
                mT__43(); 


                }
                break;
            case 30 :
                // Morel.g:1:184: T__44
                {
                mT__44(); 


                }
                break;
            case 31 :
                // Morel.g:1:190: T__45
                {
                mT__45(); 


                }
                break;
            case 32 :
                // Morel.g:1:196: T__46
                {
                mT__46(); 


                }
                break;
            case 33 :
                // Morel.g:1:202: T__47
                {
                mT__47(); 


                }
                break;
            case 34 :
                // Morel.g:1:208: T__48
                {
                mT__48(); 


                }
                break;
            case 35 :
                // Morel.g:1:214: T__49
                {
                mT__49(); 


                }
                break;
            case 36 :
                // Morel.g:1:220: T__50
                {
                mT__50(); 


                }
                break;
            case 37 :
                // Morel.g:1:226: T__51
                {
                mT__51(); 


                }
                break;
            case 38 :
                // Morel.g:1:232: T__52
                {
                mT__52(); 


                }
                break;
            case 39 :
                // Morel.g:1:238: T__53
                {
                mT__53(); 


                }
                break;
            case 40 :
                // Morel.g:1:244: T__54
                {
                mT__54(); 


                }
                break;
            case 41 :
                // Morel.g:1:250: T__55
                {
                mT__55(); 


                }
                break;
            case 42 :
                // Morel.g:1:256: T__56
                {
                mT__56(); 


                }
                break;
            case 43 :
                // Morel.g:1:262: T__57
                {
                mT__57(); 


                }
                break;
            case 44 :
                // Morel.g:1:268: T__58
                {
                mT__58(); 


                }
                break;
            case 45 :
                // Morel.g:1:274: T__59
                {
                mT__59(); 


                }
                break;
            case 46 :
                // Morel.g:1:280: T__60
                {
                mT__60(); 


                }
                break;
            case 47 :
                // Morel.g:1:286: T__61
                {
                mT__61(); 


                }
                break;
            case 48 :
                // Morel.g:1:292: T__62
                {
                mT__62(); 


                }
                break;
            case 49 :
                // Morel.g:1:298: T__63
                {
                mT__63(); 


                }
                break;
            case 50 :
                // Morel.g:1:304: T__64
                {
                mT__64(); 


                }
                break;
            case 51 :
                // Morel.g:1:310: T__65
                {
                mT__65(); 


                }
                break;
            case 52 :
                // Morel.g:1:316: T__66
                {
                mT__66(); 


                }
                break;
            case 53 :
                // Morel.g:1:322: T__67
                {
                mT__67(); 


                }
                break;
            case 54 :
                // Morel.g:1:328: T__68
                {
                mT__68(); 


                }
                break;
            case 55 :
                // Morel.g:1:334: T__69
                {
                mT__69(); 


                }
                break;
            case 56 :
                // Morel.g:1:340: T__70
                {
                mT__70(); 


                }
                break;
            case 57 :
                // Morel.g:1:346: T__71
                {
                mT__71(); 


                }
                break;
            case 58 :
                // Morel.g:1:352: T__72
                {
                mT__72(); 


                }
                break;
            case 59 :
                // Morel.g:1:358: T__73
                {
                mT__73(); 


                }
                break;
            case 60 :
                // Morel.g:1:364: T__74
                {
                mT__74(); 


                }
                break;
            case 61 :
                // Morel.g:1:370: T__75
                {
                mT__75(); 


                }
                break;
            case 62 :
                // Morel.g:1:376: T__76
                {
                mT__76(); 


                }
                break;
            case 63 :
                // Morel.g:1:382: T__77
                {
                mT__77(); 


                }
                break;
            case 64 :
                // Morel.g:1:388: T__78
                {
                mT__78(); 


                }
                break;
            case 65 :
                // Morel.g:1:394: T__79
                {
                mT__79(); 


                }
                break;
            case 66 :
                // Morel.g:1:400: T__80
                {
                mT__80(); 


                }
                break;
            case 67 :
                // Morel.g:1:406: T__81
                {
                mT__81(); 


                }
                break;
            case 68 :
                // Morel.g:1:412: T__82
                {
                mT__82(); 


                }
                break;
            case 69 :
                // Morel.g:1:418: T__83
                {
                mT__83(); 


                }
                break;
            case 70 :
                // Morel.g:1:424: T__84
                {
                mT__84(); 


                }
                break;
            case 71 :
                // Morel.g:1:430: T__85
                {
                mT__85(); 


                }
                break;
            case 72 :
                // Morel.g:1:436: T__86
                {
                mT__86(); 


                }
                break;
            case 73 :
                // Morel.g:1:442: T__87
                {
                mT__87(); 


                }
                break;
            case 74 :
                // Morel.g:1:448: T__88
                {
                mT__88(); 


                }
                break;
            case 75 :
                // Morel.g:1:454: T__89
                {
                mT__89(); 


                }
                break;
            case 76 :
                // Morel.g:1:460: T__90
                {
                mT__90(); 


                }
                break;
            case 77 :
                // Morel.g:1:466: T__91
                {
                mT__91(); 


                }
                break;
            case 78 :
                // Morel.g:1:472: T__92
                {
                mT__92(); 


                }
                break;
            case 79 :
                // Morel.g:1:478: T__93
                {
                mT__93(); 


                }
                break;
            case 80 :
                // Morel.g:1:484: T__94
                {
                mT__94(); 


                }
                break;
            case 81 :
                // Morel.g:1:490: T__95
                {
                mT__95(); 


                }
                break;
            case 82 :
                // Morel.g:1:496: T__96
                {
                mT__96(); 


                }
                break;
            case 83 :
                // Morel.g:1:502: T__97
                {
                mT__97(); 


                }
                break;
            case 84 :
                // Morel.g:1:508: T__98
                {
                mT__98(); 


                }
                break;
            case 85 :
                // Morel.g:1:514: T__99
                {
                mT__99(); 


                }
                break;
            case 86 :
                // Morel.g:1:520: T__100
                {
                mT__100(); 


                }
                break;
            case 87 :
                // Morel.g:1:527: T__101
                {
                mT__101(); 


                }
                break;
            case 88 :
                // Morel.g:1:534: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 89 :
                // Morel.g:1:544: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 90 :
                // Morel.g:1:555: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 91 :
                // Morel.g:1:566: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 92 :
                // Morel.g:1:577: COLLECTION
                {
                mCOLLECTION(); 


                }
                break;
            case 93 :
                // Morel.g:1:588: DATA_TYPE
                {
                mDATA_TYPE(); 


                }
                break;
            case 94 :
                // Morel.g:1:598: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 95 :
                // Morel.g:1:609: URINS
                {
                mURINS(); 


                }
                break;
            case 96 :
                // Morel.g:1:615: INUMBER
                {
                mINUMBER(); 


                }
                break;
            case 97 :
                // Morel.g:1:623: RNUMBER
                {
                mRNUMBER(); 


                }
                break;
            case 98 :
                // Morel.g:1:631: QUOTED_39_39_92
                {
                mQUOTED_39_39_92(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA13_eotS =
        "\55\uffff\1\67\7\uffff\2\67\11\uffff\1\67\6\uffff\2\67\5\uffff";
    static final String DFA13_eofS =
        "\116\uffff";
    static final String DFA13_minS =
        "\1\101\1\145\1\141\1\162\1\uffff\1\161\1\147\1\144\1\165\2\50\2"+
        "\145\1\101\1\162\1\156\7\51\1\uffff\1\145\1\143\11\51\1\144\1\145"+
        "\2\51\1\50\2\51\1\50\2\51\1\60\1\51\1\123\1\50\4\51\2\60\1\uffff"+
        "\1\51\1\145\5\51\1\164\1\60\4\51\1\50\1\51\2\60\1\51\1\50\2\51\1"+
        "\50";
    static final String DFA13_maxS =
        "\1\123\1\164\1\157\1\162\1\uffff\1\164\1\147\1\144\1\165\2\50\2"+
        "\145\1\172\1\162\1\156\7\172\1\uffff\1\145\1\143\11\172\1\144\1"+
        "\145\12\172\1\123\1\50\6\172\1\uffff\1\172\1\145\5\172\1\164\5\172"+
        "\1\50\10\172";
    static final String DFA13_acceptS =
        "\4\uffff\1\1\22\uffff\1\2\37\uffff\1\1\26\uffff";
    static final String DFA13_specialS =
        "\116\uffff}>";
    static final String[] DFA13_transitionS = {
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

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "12837:2: ( ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )* ( 'String' | 'Integer' | 'Boolean' | 'Real' | 'Char' | 'Any' ) ( ')' )* | ( ( 'Sequence' | 'Set' | 'Bag' | 'OrderedSet' ) '(' )+ ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ) ( ')' )+ )";
        }
    }
    static final String DFA20_eotS =
        "\1\uffff\1\67\1\uffff\1\71\5\uffff\1\74\1\uffff\1\76\2\uffff\1\102"+
        "\1\104\1\106\1\111\3\uffff\22\63\1\uffff\1\163\3\uffff\7\63\1\uffff"+
        "\1\176\22\uffff\2\112\2\uffff\15\63\1\u0090\1\63\1\u0093\7\63\1"+
        "\u009c\17\63\2\uffff\11\63\1\176\2\uffff\1\u00bc\1\112\1\63\1\u00c0"+
        "\1\u00c1\1\u00c2\10\63\1\u00cc\1\63\1\uffff\2\63\1\uffff\1\63\1"+
        "\u00d1\1\u00d2\1\63\1\u00d4\1\u00d5\2\63\1\uffff\1\u00d8\3\63\1"+
        "\u00dc\5\63\1\u00e2\13\63\1\u00ee\1\63\1\u00ee\5\63\1\u00ef\1\uffff"+
        "\1\112\2\63\3\uffff\4\63\1\u00fd\4\63\1\uffff\4\63\2\uffff\1\63"+
        "\2\uffff\1\u0107\1\63\1\uffff\2\63\1\u010b\1\uffff\5\63\1\uffff"+
        "\1\u0111\3\63\1\u0115\1\63\1\u0117\1\u0118\1\u0119\2\63\2\uffff"+
        "\4\63\2\u00ef\1\u0120\6\63\1\uffff\1\u0127\1\63\1\u0129\1\63\1\u012b"+
        "\3\63\1\u012f\1\uffff\1\u0130\2\63\1\uffff\1\u0134\4\63\1\uffff"+
        "\1\u0139\2\63\1\uffff\1\63\3\uffff\1\u013e\5\63\1\uffff\1\u0144"+
        "\5\63\1\uffff\1\u014a\1\uffff\1\u014b\1\uffff\3\63\2\uffff\3\63"+
        "\1\uffff\1\u0153\1\63\1\u0155\1\63\1\uffff\1\u0157\3\63\1\uffff"+
        "\1\63\1\u00ef\3\63\1\uffff\1\u015f\1\u0160\1\u0161\1\63\1\u0163"+
        "\2\uffff\1\u0164\1\u0165\2\63\1\u0168\1\63\2\uffff\1\63\1\uffff"+
        "\1\63\1\uffff\4\63\1\u00ef\1\63\1\u00ef\3\uffff\1\63\3\uffff\1\63"+
        "\1\u0173\1\uffff\1\63\1\u0175\4\63\1\u00ee\2\63\1\u017c\1\uffff"+
        "\1\63\1\uffff\1\u017e\2\63\1\u0181\1\63\1\u0183\1\uffff\1\u0184"+
        "\1\uffff\1\u0185\1\63\1\uffff\1\u00ee\3\uffff\3\63\1\u018a\1\uffff";
    static final String DFA20_eofS =
        "\u018b\uffff";
    static final String DFA20_minS =
        "\1\11\1\75\1\uffff\1\46\5\uffff\1\55\1\uffff\1\52\2\uffff\1\55\1"+
        "\76\1\75\1\55\3\uffff\1\143\1\154\1\145\1\154\1\141\1\162\1\146"+
        "\1\145\2\141\1\162\1\141\1\165\1\141\1\143\1\150\1\151\1\150\1\uffff"+
        "\1\174\3\uffff\1\145\1\141\1\162\1\156\1\145\1\150\1\156\1\uffff"+
        "\1\56\22\uffff\1\144\1\150\2\uffff\1\164\1\154\1\144\1\157\1\154"+
        "\1\145\1\146\1\163\1\144\1\151\1\154\1\162\1\157\1\60\1\160\1\60"+
        "\1\145\1\164\1\163\1\164\1\143\1\164\1\154\1\60\1\143\1\163\2\145"+
        "\1\156\1\141\1\163\1\154\1\157\1\154\1\145\1\141\1\160\2\145\2\uffff"+
        "\1\161\1\162\1\147\1\157\1\144\1\164\2\141\1\171\1\56\2\uffff\1"+
        "\55\2\151\3\60\1\163\1\154\2\141\1\145\1\151\2\163\1\60\1\165\1"+
        "\uffff\1\154\1\141\1\uffff\1\162\2\60\1\143\2\60\1\154\1\145\1\uffff"+
        "\1\60\1\141\1\163\1\164\1\60\1\162\2\144\2\145\1\60\1\145\1\160"+
        "\1\145\1\165\2\156\2\145\1\167\1\162\1\165\1\50\1\151\1\50\1\154"+
        "\2\145\1\154\1\162\1\60\1\uffff\1\163\1\166\1\151\3\uffff\1\165"+
        "\1\145\1\164\1\165\1\60\1\146\1\164\1\145\1\154\1\uffff\1\160\1"+
        "\151\1\154\1\141\2\uffff\1\150\2\uffff\1\60\1\162\1\uffff\1\154"+
        "\1\151\1\60\1\uffff\1\171\1\157\1\117\1\143\1\141\1\uffff\1\60\1"+
        "\145\1\143\1\145\1\60\1\163\3\60\2\145\2\uffff\1\156\1\145\1\162"+
        "\1\147\2\60\1\55\1\145\1\146\1\162\1\143\1\145\1\154\1\uffff\1\60"+
        "\1\163\1\60\1\154\1\60\1\145\1\151\1\164\1\60\1\uffff\1\60\1\154"+
        "\1\166\1\uffff\1\60\1\155\1\156\2\164\1\uffff\1\60\1\164\1\156\1"+
        "\uffff\1\146\3\uffff\1\60\1\156\1\147\1\141\2\145\1\uffff\1\60\1"+
        "\146\1\145\1\164\1\117\1\164\1\uffff\1\60\1\uffff\1\60\1\uffff\1"+
        "\163\1\144\1\151\2\uffff\2\145\1\157\1\uffff\1\52\1\154\1\60\1\151"+
        "\1\uffff\1\60\1\164\1\157\1\145\1\uffff\1\143\1\60\1\156\1\144\1"+
        "\162\1\uffff\3\60\1\156\1\60\2\uffff\2\60\1\156\1\154\1\60\1\144"+
        "\2\uffff\1\171\1\uffff\1\156\1\uffff\1\151\1\162\1\156\1\145\1\60"+
        "\1\123\1\60\3\uffff\1\154\3\uffff\1\147\1\60\1\uffff\1\145\1\60"+
        "\1\147\1\141\1\155\1\164\1\50\1\145\1\171\1\60\1\uffff\1\154\1\uffff"+
        "\1\60\1\154\1\141\1\60\1\164\1\60\1\uffff\1\60\1\uffff\1\60\1\164"+
        "\1\uffff\1\50\3\uffff\1\151\1\157\1\156\1\60\1\uffff";
    static final String DFA20_maxS =
        "\1\175\1\75\1\uffff\1\46\5\uffff\1\76\1\uffff\1\52\2\uffff\2\76"+
        "\1\75\1\172\3\uffff\1\156\1\162\1\145\1\170\1\157\1\162\1\164\1"+
        "\150\1\141\1\165\2\162\2\165\1\145\1\171\1\151\1\150\1\uffff\1\174"+
        "\3\uffff\1\164\1\157\1\162\1\156\1\145\1\150\1\156\1\uffff\1\71"+
        "\22\uffff\1\144\1\150\2\uffff\1\164\1\154\1\171\1\157\1\154\1\145"+
        "\1\146\1\163\1\144\1\151\1\154\1\162\1\157\1\172\1\160\1\172\1\145"+
        "\1\164\1\163\1\164\1\143\1\164\1\154\1\172\2\163\2\145\1\156\1\160"+
        "\1\163\1\154\1\157\1\161\1\145\1\165\1\160\2\145\2\uffff\1\164\1"+
        "\162\1\147\1\157\1\144\1\164\2\141\1\171\1\71\2\uffff\1\172\2\151"+
        "\3\172\1\163\1\154\2\141\1\145\1\151\2\163\1\172\1\165\1\uffff\1"+
        "\154\1\141\1\uffff\1\162\2\172\1\143\2\172\1\154\1\145\1\uffff\1"+
        "\172\1\141\1\163\1\164\1\172\1\162\2\144\2\145\1\172\1\145\1\160"+
        "\1\145\1\165\2\156\2\145\1\167\1\162\1\165\1\172\1\151\1\172\1\154"+
        "\2\145\1\154\1\162\1\172\1\uffff\1\163\1\166\1\151\3\uffff\1\165"+
        "\1\145\1\164\1\165\1\172\1\146\1\164\1\145\1\154\1\uffff\1\160\1"+
        "\151\1\154\1\141\2\uffff\1\150\2\uffff\1\172\1\162\1\uffff\1\154"+
        "\1\151\1\172\1\uffff\1\171\1\157\1\117\1\143\1\141\1\uffff\1\172"+
        "\1\145\1\143\1\145\1\172\1\163\3\172\2\145\2\uffff\1\156\1\145\1"+
        "\162\1\147\3\172\1\145\1\146\1\162\1\143\1\145\1\154\1\uffff\1\172"+
        "\1\163\1\172\1\154\1\172\1\145\1\151\1\164\1\172\1\uffff\1\172\1"+
        "\154\1\166\1\uffff\1\172\1\155\1\156\2\164\1\uffff\1\172\1\164\1"+
        "\156\1\uffff\1\151\3\uffff\1\172\1\156\1\147\1\141\2\145\1\uffff"+
        "\1\172\1\146\1\145\1\164\1\117\1\164\1\uffff\1\172\1\uffff\1\172"+
        "\1\uffff\1\163\1\144\1\151\2\uffff\2\145\1\157\1\uffff\1\172\1\154"+
        "\1\172\1\151\1\uffff\1\172\1\164\1\157\1\145\1\uffff\1\143\1\172"+
        "\1\156\1\144\1\162\1\uffff\3\172\1\156\1\172\2\uffff\2\172\1\156"+
        "\1\154\1\172\1\144\2\uffff\1\171\1\uffff\1\156\1\uffff\1\151\1\162"+
        "\1\156\1\145\1\172\1\123\1\172\3\uffff\1\154\3\uffff\1\147\1\172"+
        "\1\uffff\1\145\1\172\1\147\1\141\1\155\1\164\1\172\1\145\1\171\1"+
        "\172\1\uffff\1\154\1\uffff\1\172\1\154\1\141\1\172\1\164\1\172\1"+
        "\uffff\1\172\1\uffff\1\172\1\164\1\uffff\1\172\3\uffff\1\151\1\157"+
        "\1\156\1\172\1\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\3\1\uffff\1\6\1\7\1\10\1\11\1\12\1\uffff\1\15\1\uffff"+
        "\1\17\1\20\4\uffff\1\34\1\35\1\36\22\uffff\1\124\1\uffff\1\127\1"+
        "\130\1\133\7\uffff\1\136\1\uffff\1\142\1\2\1\1\1\4\1\5\1\14\1\131"+
        "\1\13\1\132\1\16\1\22\1\23\1\24\1\21\1\26\1\25\1\30\1\27\2\uffff"+
        "\1\31\1\137\47\uffff\1\126\1\125\12\uffff\1\140\1\141\20\uffff\1"+
        "\57\2\uffff\1\61\10\uffff\1\72\37\uffff\1\32\3\uffff\1\40\1\42\1"+
        "\43\11\uffff\1\54\4\uffff\1\64\1\65\1\uffff\1\67\1\70\2\uffff\1"+
        "\74\3\uffff\1\100\5\uffff\1\110\13\uffff\1\134\1\135\15\uffff\1"+
        "\50\11\uffff\1\71\3\uffff\1\77\5\uffff\1\111\3\uffff\1\115\1\uffff"+
        "\1\120\1\121\1\122\6\uffff\1\33\6\uffff\1\51\1\uffff\1\53\1\uffff"+
        "\1\56\3\uffff\1\66\1\73\3\uffff\1\101\4\uffff\1\112\4\uffff\1\123"+
        "\5\uffff\1\37\5\uffff\1\52\1\55\6\uffff\1\104\1\103\1\uffff\1\106"+
        "\1\uffff\1\113\7\uffff\1\41\1\44\1\45\1\uffff\1\47\1\60\1\62\2\uffff"+
        "\1\76\12\uffff\1\75\1\uffff\1\105\6\uffff\1\63\1\uffff\1\107\2\uffff"+
        "\1\117\1\uffff\1\46\1\102\1\114\4\uffff\1\116";
    static final String DFA20_specialS =
        "\u018b\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\53\1\52\1\uffff\1\53\1\52\22\uffff\1\53\1\1\1\uffff\1\2\2"+
            "\uffff\1\3\1\65\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\12\64\1"+
            "\14\1\15\1\16\1\17\1\20\1\uffff\1\21\1\62\1\55\1\61\5\63\1\57"+
            "\5\63\1\56\2\63\1\60\1\54\7\63\1\22\1\uffff\1\23\1\24\1\63\1"+
            "\uffff\1\25\1\63\1\26\1\27\1\30\1\31\1\32\1\63\1\33\2\63\1\34"+
            "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\63\1\45\1\46\3\63"+
            "\1\47\1\50\1\51",
            "\1\66",
            "",
            "\1\70",
            "",
            "",
            "",
            "",
            "",
            "\1\73\20\uffff\1\72",
            "",
            "\1\75",
            "",
            "",
            "\1\77\17\uffff\1\100\1\101",
            "\1\103",
            "\1\105",
            "\16\112\6\uffff\32\112\4\uffff\1\112\1\uffff\10\112\1\107\12"+
            "\112\1\110\6\112",
            "",
            "",
            "",
            "\1\113\10\uffff\1\114\1\uffff\1\115",
            "\1\116\2\uffff\1\117\2\uffff\1\120",
            "\1\121",
            "\1\122\1\uffff\1\123\11\uffff\1\124",
            "\1\125\15\uffff\1\126",
            "\1\127",
            "\1\130\6\uffff\1\131\1\132\5\uffff\1\133",
            "\1\134\2\uffff\1\135",
            "\1\136",
            "\1\137\15\uffff\1\140\5\uffff\1\141",
            "\1\142",
            "\1\143\15\uffff\1\144\2\uffff\1\145",
            "\1\146",
            "\1\147\3\uffff\1\150\2\uffff\1\151\14\uffff\1\152",
            "\1\153\1\uffff\1\154",
            "\1\155\11\uffff\1\156\6\uffff\1\157",
            "\1\160",
            "\1\161",
            "",
            "\1\162",
            "",
            "",
            "",
            "\1\164\16\uffff\1\165",
            "\1\166\15\uffff\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "\1\177\1\uffff\2\175\10\177",
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
            "",
            "",
            "",
            "",
            "\1\u0080",
            "\1\u0081",
            "",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084\24\uffff\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0091",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\25\63\1\u0092\4\63",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\3\63\1\u009b\26\63",
            "\1\u009d\16\uffff\1\u009e\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4\10\uffff\1\u00a5\5\uffff\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa\4\uffff\1\u00ab",
            "\1\u00ac",
            "\1\u00ad\23\uffff\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "",
            "\1\u00b2\2\uffff\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\177\1\uffff\2\175\10\177",
            "",
            "",
            "\16\112\6\uffff\32\112\4\uffff\1\112\1\uffff\32\112",
            "\1\u00bd",
            "\1\u00be",
            "\12\63\7\uffff\3\63\1\u00bf\26\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\12\63\7\uffff\1\u00cb\31\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00cd",
            "",
            "\1\u00ce",
            "\1\u00cf",
            "",
            "\1\u00d0",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00d3",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00d6",
            "\1\u00d7",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ef\7\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32"+
            "\63",
            "\1\u00f0",
            "\1\u00ef\7\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32"+
            "\63",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "",
            "",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "",
            "",
            "\1\u0106",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0108",
            "",
            "\1\u0109",
            "\1\u010a",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0116",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u011a",
            "\1\u011b",
            "",
            "",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\16\112\6\uffff\32\112\4\uffff\1\112\1\uffff\32\112",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0128",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u012a",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0131",
            "\1\u0132",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\14\63\1\u0133\15"+
            "\63",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u013a",
            "\1\u013b",
            "",
            "\1\u013c\2\uffff\1\u013d",
            "",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "",
            "",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "",
            "\1\u0152\5\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32"+
            "\63",
            "\1\u0154",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0156",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "",
            "\1\u015b",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0162",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0166",
            "\1\u0167",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0169",
            "",
            "",
            "\1\u016a",
            "",
            "\1\u016b",
            "",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0170",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "\1\u0171",
            "",
            "",
            "",
            "\1\u0172",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u0174",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\1\u00ef\7\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32"+
            "\63",
            "\1\u017a",
            "\1\u017b",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u017d",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u017f",
            "\1\u0180",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0182",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0186",
            "",
            "\1\u00ef\7\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32"+
            "\63",
            "",
            "",
            "",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | LINEBREAK | SL_COMMENT | ML_COMMENT | WHITESPACE | COLLECTION | DATA_TYPE | IDENTIFIER | URINS | INUMBER | RNUMBER | QUOTED_39_39_92 );";
        }
    }
 

}