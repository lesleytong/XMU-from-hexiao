package edu.ustb.sei.mde.xmuxtext.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXmu2Lexer extends Lexer {
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=11;
    public static final int T__19=19;
    public static final int RULE_MODEL_URI=7;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=15;
    public static final int RULE_PRIMITIVE_TYPE=4;
    public static final int RULE_OBJ_URI=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_NAME=6;
    public static final int RULE_STRING=10;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=14;
    public static final int RULE_PATH_NAME=5;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public InternalXmu2Lexer() {;} 
    public InternalXmu2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXmu2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalXmu2.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:11:7: ( 'source' )
            // InternalXmu2.g:11:9: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:12:7: ( 'view' )
            // InternalXmu2.g:12:9: 'view'
            {
            match("view"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:13:7: ( 'select' )
            // InternalXmu2.g:13:9: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:14:7: ( 'forAll' )
            // InternalXmu2.g:14:9: 'forAll'
            {
            match("forAll"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:15:7: ( 'exists' )
            // InternalXmu2.g:15:9: 'exists'
            {
            match("exists"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:16:7: ( 'first' )
            // InternalXmu2.g:16:9: 'first'
            {
            match("first"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:17:7: ( 'last' )
            // InternalXmu2.g:17:9: 'last'
            {
            match("last"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:18:7: ( 'at' )
            // InternalXmu2.g:18:9: 'at'
            {
            match("at"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:19:7: ( 'null' )
            // InternalXmu2.g:19:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:20:7: ( 'undefined' )
            // InternalXmu2.g:20:9: 'undefined'
            {
            match("undefined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:21:7: ( 'not' )
            // InternalXmu2.g:21:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:22:7: ( '-' )
            // InternalXmu2.g:22:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:23:7: ( '*' )
            // InternalXmu2.g:23:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:24:7: ( '/' )
            // InternalXmu2.g:24:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:25:7: ( '+' )
            // InternalXmu2.g:25:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:26:7: ( '++' )
            // InternalXmu2.g:26:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:27:7: ( '=' )
            // InternalXmu2.g:27:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:28:7: ( '<' )
            // InternalXmu2.g:28:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:29:7: ( '<=' )
            // InternalXmu2.g:29:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:30:7: ( '>' )
            // InternalXmu2.g:30:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:31:7: ( '>=' )
            // InternalXmu2.g:31:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:32:7: ( 'match' )
            // InternalXmu2.g:32:9: 'match'
            {
            match("match"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:33:7: ( 'unmatchs' )
            // InternalXmu2.g:33:9: 'unmatchs'
            {
            match("unmatchs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:34:7: ( 'unmatchv' )
            // InternalXmu2.g:34:9: 'unmatchv'
            {
            match("unmatchv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:35:7: ( 'default' )
            // InternalXmu2.g:35:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:36:7: ( 'module' )
            // InternalXmu2.g:36:9: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:37:7: ( 'import' )
            // InternalXmu2.g:37:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:38:7: ( 'entry' )
            // InternalXmu2.g:38:9: 'entry'
            {
            match("entry"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:39:7: ( '(' )
            // InternalXmu2.g:39:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:40:7: ( ')' )
            // InternalXmu2.g:40:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:41:7: ( ',' )
            // InternalXmu2.g:41:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:42:7: ( '[' )
            // InternalXmu2.g:42:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:43:7: ( ']' )
            // InternalXmu2.g:43:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:44:7: ( 'rule' )
            // InternalXmu2.g:44:9: 'rule'
            {
            match("rule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:45:7: ( '{' )
            // InternalXmu2.g:45:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:46:7: ( '}' )
            // InternalXmu2.g:46:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:47:7: ( ';' )
            // InternalXmu2.g:47:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:48:7: ( 'function' )
            // InternalXmu2.g:48:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:49:7: ( ':' )
            // InternalXmu2.g:49:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:50:7: ( '->' )
            // InternalXmu2.g:50:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:51:7: ( '|' )
            // InternalXmu2.g:51:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:52:7: ( '.' )
            // InternalXmu2.g:52:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:53:7: ( '::' )
            // InternalXmu2.g:53:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:54:7: ( 'and' )
            // InternalXmu2.g:54:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:55:7: ( 'or' )
            // InternalXmu2.g:55:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:56:7: ( 'update' )
            // InternalXmu2.g:56:9: 'update'
            {
            match("update"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:57:7: ( 'with' )
            // InternalXmu2.g:57:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:58:7: ( 'by' )
            // InternalXmu2.g:58:9: 'by'
            {
            match("by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:59:7: ( 'switch' )
            // InternalXmu2.g:59:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:60:7: ( 'case' )
            // InternalXmu2.g:60:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:61:7: ( 'otherwise' )
            // InternalXmu2.g:61:9: 'otherwise'
            {
            match("otherwise"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:62:7: ( 'delete' )
            // InternalXmu2.g:62:9: 'delete'
            {
            match("delete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:63:7: ( 'enforce' )
            // InternalXmu2.g:63:9: 'enforce'
            {
            match("enforce"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:64:7: ( 'foreach' )
            // InternalXmu2.g:64:9: 'foreach'
            {
            match("foreach"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:65:7: ( 'skip' )
            // InternalXmu2.g:65:9: 'skip'
            {
            match("skip"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:66:7: ( 'fail' )
            // InternalXmu2.g:66:9: 'fail'
            {
            match("fail"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:67:7: ( '::=' )
            // InternalXmu2.g:67:9: '::='
            {
            match("::="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:68:7: ( '?' )
            // InternalXmu2.g:68:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9447:14: ( ( 'true' | 'false' ) )
            // InternalXmu2.g:9447:16: ( 'true' | 'false' )
            {
            // InternalXmu2.g:9447:16: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalXmu2.g:9447:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:9447:24: 'false'
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
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9449:10: ( ( '0' .. '9' )+ )
            // InternalXmu2.g:9449:12: ( '0' .. '9' )+
            {
            // InternalXmu2.g:9449:12: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalXmu2.g:9449:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9451:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalXmu2.g:9451:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalXmu2.g:9451:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\"') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\'') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXmu2.g:9451:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalXmu2.g:9451:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalXmu2.g:9451:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXmu2.g:9451:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalXmu2.g:9451:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalXmu2.g:9451:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalXmu2.g:9451:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXmu2.g:9451:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9453:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalXmu2.g:9453:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalXmu2.g:9453:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalXmu2.g:9453:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9455:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalXmu2.g:9455:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalXmu2.g:9455:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXmu2.g:9455:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalXmu2.g:9455:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXmu2.g:9455:41: ( '\\r' )? '\\n'
                    {
                    // InternalXmu2.g:9455:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalXmu2.g:9455:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9457:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalXmu2.g:9457:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalXmu2.g:9457:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalXmu2.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_PRIMITIVE_TYPE"
    public final void mRULE_PRIMITIVE_TYPE() throws RecognitionException {
        try {
            int _type = RULE_PRIMITIVE_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9459:21: ( ( 'String' | 'Boolean' | 'Integer' | 'OclAny' | 'Resource' | 'OclObject' ) )
            // InternalXmu2.g:9459:23: ( 'String' | 'Boolean' | 'Integer' | 'OclAny' | 'Resource' | 'OclObject' )
            {
            // InternalXmu2.g:9459:23: ( 'String' | 'Boolean' | 'Integer' | 'OclAny' | 'Resource' | 'OclObject' )
            int alt11=6;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalXmu2.g:9459:24: 'String'
                    {
                    match("String"); 


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:9459:33: 'Boolean'
                    {
                    match("Boolean"); 


                    }
                    break;
                case 3 :
                    // InternalXmu2.g:9459:43: 'Integer'
                    {
                    match("Integer"); 


                    }
                    break;
                case 4 :
                    // InternalXmu2.g:9459:53: 'OclAny'
                    {
                    match("OclAny"); 


                    }
                    break;
                case 5 :
                    // InternalXmu2.g:9459:62: 'Resource'
                    {
                    match("Resource"); 


                    }
                    break;
                case 6 :
                    // InternalXmu2.g:9459:73: 'OclObject'
                    {
                    match("OclObject"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PRIMITIVE_TYPE"

    // $ANTLR start "RULE_PATH_NAME"
    public final void mRULE_PATH_NAME() throws RecognitionException {
        try {
            int _type = RULE_PATH_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9461:16: ( RULE_ID '!' RULE_ID )
            // InternalXmu2.g:9461:18: RULE_ID '!' RULE_ID
            {
            mRULE_ID(); 
            match('!'); 
            mRULE_ID(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PATH_NAME"

    // $ANTLR start "RULE_NAME"
    public final void mRULE_NAME() throws RecognitionException {
        try {
            int _type = RULE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9463:11: ( RULE_ID ( '@post' )? )
            // InternalXmu2.g:9463:13: RULE_ID ( '@post' )?
            {
            mRULE_ID(); 
            // InternalXmu2.g:9463:21: ( '@post' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='@') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXmu2.g:9463:21: '@post'
                    {
                    match("@post"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NAME"

    // $ANTLR start "RULE_MODEL_URI"
    public final void mRULE_MODEL_URI() throws RecognitionException {
        try {
            int _type = RULE_MODEL_URI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9465:16: ( '<' ( options {greedy=false; } : . )* '>' )
            // InternalXmu2.g:9465:18: '<' ( options {greedy=false; } : . )* '>'
            {
            match('<'); 
            // InternalXmu2.g:9465:22: ( options {greedy=false; } : . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='>') ) {
                    alt13=2;
                }
                else if ( ((LA13_0>='\u0000' && LA13_0<='=')||(LA13_0>='?' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalXmu2.g:9465:50: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MODEL_URI"

    // $ANTLR start "RULE_OBJ_URI"
    public final void mRULE_OBJ_URI() throws RecognitionException {
        try {
            int _type = RULE_OBJ_URI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXmu2.g:9467:14: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '\\\\' | '.' | ':' | '#' )* )
            // InternalXmu2.g:9467:16: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '\\\\' | '.' | ':' | '#' )*
            {
            match('@'); 
            // InternalXmu2.g:9467:20: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '/' | '\\\\' | '.' | ':' | '#' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='#'||(LA14_0>='.' && LA14_0<=':')||(LA14_0>='A' && LA14_0<='Z')||LA14_0=='\\'||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalXmu2.g:
            	    {
            	    if ( input.LA(1)=='#'||(input.LA(1)>='.' && input.LA(1)<=':')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OBJ_URI"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            // InternalXmu2.g:9469:18: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalXmu2.g:9469:20: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalXmu2.g:9469:20: ( '^' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='^') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXmu2.g:9469:20: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalXmu2.g:9469:49: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalXmu2.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    public void mTokens() throws RecognitionException {
        // InternalXmu2.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | RULE_BOOLEAN | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_PRIMITIVE_TYPE | RULE_PATH_NAME | RULE_NAME | RULE_MODEL_URI | RULE_OBJ_URI )
        int alt17=69;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // InternalXmu2.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // InternalXmu2.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // InternalXmu2.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // InternalXmu2.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // InternalXmu2.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // InternalXmu2.g:1:40: T__21
                {
                mT__21(); 

                }
                break;
            case 7 :
                // InternalXmu2.g:1:46: T__22
                {
                mT__22(); 

                }
                break;
            case 8 :
                // InternalXmu2.g:1:52: T__23
                {
                mT__23(); 

                }
                break;
            case 9 :
                // InternalXmu2.g:1:58: T__24
                {
                mT__24(); 

                }
                break;
            case 10 :
                // InternalXmu2.g:1:64: T__25
                {
                mT__25(); 

                }
                break;
            case 11 :
                // InternalXmu2.g:1:70: T__26
                {
                mT__26(); 

                }
                break;
            case 12 :
                // InternalXmu2.g:1:76: T__27
                {
                mT__27(); 

                }
                break;
            case 13 :
                // InternalXmu2.g:1:82: T__28
                {
                mT__28(); 

                }
                break;
            case 14 :
                // InternalXmu2.g:1:88: T__29
                {
                mT__29(); 

                }
                break;
            case 15 :
                // InternalXmu2.g:1:94: T__30
                {
                mT__30(); 

                }
                break;
            case 16 :
                // InternalXmu2.g:1:100: T__31
                {
                mT__31(); 

                }
                break;
            case 17 :
                // InternalXmu2.g:1:106: T__32
                {
                mT__32(); 

                }
                break;
            case 18 :
                // InternalXmu2.g:1:112: T__33
                {
                mT__33(); 

                }
                break;
            case 19 :
                // InternalXmu2.g:1:118: T__34
                {
                mT__34(); 

                }
                break;
            case 20 :
                // InternalXmu2.g:1:124: T__35
                {
                mT__35(); 

                }
                break;
            case 21 :
                // InternalXmu2.g:1:130: T__36
                {
                mT__36(); 

                }
                break;
            case 22 :
                // InternalXmu2.g:1:136: T__37
                {
                mT__37(); 

                }
                break;
            case 23 :
                // InternalXmu2.g:1:142: T__38
                {
                mT__38(); 

                }
                break;
            case 24 :
                // InternalXmu2.g:1:148: T__39
                {
                mT__39(); 

                }
                break;
            case 25 :
                // InternalXmu2.g:1:154: T__40
                {
                mT__40(); 

                }
                break;
            case 26 :
                // InternalXmu2.g:1:160: T__41
                {
                mT__41(); 

                }
                break;
            case 27 :
                // InternalXmu2.g:1:166: T__42
                {
                mT__42(); 

                }
                break;
            case 28 :
                // InternalXmu2.g:1:172: T__43
                {
                mT__43(); 

                }
                break;
            case 29 :
                // InternalXmu2.g:1:178: T__44
                {
                mT__44(); 

                }
                break;
            case 30 :
                // InternalXmu2.g:1:184: T__45
                {
                mT__45(); 

                }
                break;
            case 31 :
                // InternalXmu2.g:1:190: T__46
                {
                mT__46(); 

                }
                break;
            case 32 :
                // InternalXmu2.g:1:196: T__47
                {
                mT__47(); 

                }
                break;
            case 33 :
                // InternalXmu2.g:1:202: T__48
                {
                mT__48(); 

                }
                break;
            case 34 :
                // InternalXmu2.g:1:208: T__49
                {
                mT__49(); 

                }
                break;
            case 35 :
                // InternalXmu2.g:1:214: T__50
                {
                mT__50(); 

                }
                break;
            case 36 :
                // InternalXmu2.g:1:220: T__51
                {
                mT__51(); 

                }
                break;
            case 37 :
                // InternalXmu2.g:1:226: T__52
                {
                mT__52(); 

                }
                break;
            case 38 :
                // InternalXmu2.g:1:232: T__53
                {
                mT__53(); 

                }
                break;
            case 39 :
                // InternalXmu2.g:1:238: T__54
                {
                mT__54(); 

                }
                break;
            case 40 :
                // InternalXmu2.g:1:244: T__55
                {
                mT__55(); 

                }
                break;
            case 41 :
                // InternalXmu2.g:1:250: T__56
                {
                mT__56(); 

                }
                break;
            case 42 :
                // InternalXmu2.g:1:256: T__57
                {
                mT__57(); 

                }
                break;
            case 43 :
                // InternalXmu2.g:1:262: T__58
                {
                mT__58(); 

                }
                break;
            case 44 :
                // InternalXmu2.g:1:268: T__59
                {
                mT__59(); 

                }
                break;
            case 45 :
                // InternalXmu2.g:1:274: T__60
                {
                mT__60(); 

                }
                break;
            case 46 :
                // InternalXmu2.g:1:280: T__61
                {
                mT__61(); 

                }
                break;
            case 47 :
                // InternalXmu2.g:1:286: T__62
                {
                mT__62(); 

                }
                break;
            case 48 :
                // InternalXmu2.g:1:292: T__63
                {
                mT__63(); 

                }
                break;
            case 49 :
                // InternalXmu2.g:1:298: T__64
                {
                mT__64(); 

                }
                break;
            case 50 :
                // InternalXmu2.g:1:304: T__65
                {
                mT__65(); 

                }
                break;
            case 51 :
                // InternalXmu2.g:1:310: T__66
                {
                mT__66(); 

                }
                break;
            case 52 :
                // InternalXmu2.g:1:316: T__67
                {
                mT__67(); 

                }
                break;
            case 53 :
                // InternalXmu2.g:1:322: T__68
                {
                mT__68(); 

                }
                break;
            case 54 :
                // InternalXmu2.g:1:328: T__69
                {
                mT__69(); 

                }
                break;
            case 55 :
                // InternalXmu2.g:1:334: T__70
                {
                mT__70(); 

                }
                break;
            case 56 :
                // InternalXmu2.g:1:340: T__71
                {
                mT__71(); 

                }
                break;
            case 57 :
                // InternalXmu2.g:1:346: T__72
                {
                mT__72(); 

                }
                break;
            case 58 :
                // InternalXmu2.g:1:352: T__73
                {
                mT__73(); 

                }
                break;
            case 59 :
                // InternalXmu2.g:1:358: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 60 :
                // InternalXmu2.g:1:371: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 61 :
                // InternalXmu2.g:1:380: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 62 :
                // InternalXmu2.g:1:392: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 63 :
                // InternalXmu2.g:1:408: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 64 :
                // InternalXmu2.g:1:424: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 65 :
                // InternalXmu2.g:1:432: RULE_PRIMITIVE_TYPE
                {
                mRULE_PRIMITIVE_TYPE(); 

                }
                break;
            case 66 :
                // InternalXmu2.g:1:452: RULE_PATH_NAME
                {
                mRULE_PATH_NAME(); 

                }
                break;
            case 67 :
                // InternalXmu2.g:1:467: RULE_NAME
                {
                mRULE_NAME(); 

                }
                break;
            case 68 :
                // InternalXmu2.g:1:477: RULE_MODEL_URI
                {
                mRULE_MODEL_URI(); 

                }
                break;
            case 69 :
                // InternalXmu2.g:1:492: RULE_OBJ_URI
                {
                mRULE_OBJ_URI(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA11_eotS =
        "\12\uffff";
    static final String DFA11_eofS =
        "\12\uffff";
    static final String DFA11_minS =
        "\1\102\3\uffff\1\143\1\uffff\1\154\1\101\2\uffff";
    static final String DFA11_maxS =
        "\1\123\3\uffff\1\143\1\uffff\1\154\1\117\2\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\2\uffff\1\4\1\6";
    static final String DFA11_specialS =
        "\12\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\6\uffff\1\3\5\uffff\1\4\2\uffff\1\5\1\1",
            "",
            "",
            "",
            "\1\6",
            "",
            "\1\7",
            "\1\10\15\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "9459:23: ( 'String' | 'Boolean' | 'Integer' | 'OclAny' | 'Resource' | 'OclObject' )";
        }
    }
    static final String DFA17_eotS =
        "\1\uffff\10\65\1\106\1\uffff\1\111\1\113\1\uffff\1\116\1\120\3\65\5\uffff\1\65\3\uffff\1\127\2\uffff\4\65\1\uffff\1\65\3\uffff\5\65\1\uffff\1\65\1\uffff\5\65\2\uffff\10\65\1\161\5\65\7\uffff\1\170\4\uffff\5\65\1\u0080\1\uffff\1\u0081\2\65\1\u0084\25\65\1\uffff\1\u009b\1\65\1\u009d\3\65\1\uffff\6\65\3\uffff\2\65\1\uffff\12\65\1\u00b4\1\u00b5\4\65\1\u00ba\4\65\1\u00bf\1\uffff\1\u00c0\1\uffff\10\65\1\u00c9\1\65\1\u00cb\1\u00cc\1\u00cd\11\65\2\uffff\2\65\1\u00d9\1\65\1\uffff\1\u00cd\1\65\1\u00dc\1\65\2\uffff\3\65\1\u00e1\4\65\1\uffff\1\65\3\uffff\6\65\1\u00ed\1\u00ee\1\u00ef\1\u00f0\1\65\1\uffff\1\65\1\u00f3\1\uffff\3\65\1\u00f7\1\uffff\1\u00f8\1\65\1\u00fa\1\u00fb\1\65\1\u00fd\2\65\1\u00fd\2\65\4\uffff\1\u0102\1\65\1\uffff\1\u0104\2\65\2\uffff\1\u0108\2\uffff\1\65\1\uffff\2\u00fd\2\65\1\uffff\1\u010c\1\uffff\1\65\1\u010e\1\u010f\1\uffff\2\65\1\u00fd\1\uffff\1\u0112\2\uffff\1\u0113\1\u00fd\2\uffff";
    static final String DFA17_eofS =
        "\u0114\uffff";
    static final String DFA17_minS =
        "\1\11\10\41\1\76\1\uffff\1\52\1\53\1\uffff\1\0\1\75\3\41\5\uffff\1\41\3\uffff\1\72\2\uffff\4\41\1\uffff\1\41\3\uffff\5\41\1\101\1\41\1\uffff\5\41\2\uffff\16\41\7\uffff\1\0\4\uffff\5\41\1\75\1\uffff\31\41\1\uffff\6\41\1\uffff\6\41\3\uffff\2\41\1\uffff\26\41\1\uffff\1\41\1\uffff\26\41\2\uffff\4\41\1\uffff\4\41\2\uffff\10\41\1\uffff\1\41\3\uffff\13\41\1\uffff\2\41\1\uffff\4\41\1\uffff\13\41\4\uffff\2\41\1\uffff\3\41\2\uffff\1\41\2\uffff\1\41\1\uffff\4\41\1\uffff\1\41\1\uffff\3\41\1\uffff\3\41\1\uffff\1\41\2\uffff\2\41\2\uffff";
    static final String DFA17_maxS =
        "\1\175\10\172\1\76\1\uffff\1\57\1\53\1\uffff\1\uffff\1\75\3\172\5\uffff\1\172\3\uffff\1\72\2\uffff\4\172\1\uffff\1\172\3\uffff\7\172\1\uffff\5\172\2\uffff\16\172\7\uffff\1\uffff\4\uffff\5\172\1\75\1\uffff\31\172\1\uffff\6\172\1\uffff\6\172\3\uffff\2\172\1\uffff\26\172\1\uffff\1\172\1\uffff\26\172\2\uffff\4\172\1\uffff\4\172\2\uffff\10\172\1\uffff\1\172\3\uffff\13\172\1\uffff\2\172\1\uffff\4\172\1\uffff\13\172\4\uffff\2\172\1\uffff\3\172\2\uffff\1\172\2\uffff\1\172\1\uffff\4\172\1\uffff\1\172\1\uffff\3\172\1\uffff\3\172\1\uffff\1\172\2\uffff\2\172\2\uffff";
    static final String DFA17_acceptS =
        "\12\uffff\1\15\2\uffff\1\21\5\uffff\1\35\1\36\1\37\1\40\1\41\1\uffff\1\43\1\44\1\45\1\uffff\1\51\1\52\4\uffff\1\72\1\uffff\1\74\1\75\1\100\7\uffff\1\105\5\uffff\1\103\1\102\16\uffff\1\50\1\14\1\76\1\77\1\16\1\20\1\17\1\uffff\1\104\1\22\1\25\1\24\6\uffff\1\47\31\uffff\1\10\6\uffff\1\23\6\uffff\1\71\1\53\1\55\2\uffff\1\60\26\uffff\1\54\1\uffff\1\13\26\uffff\1\67\1\2\4\uffff\1\70\4\uffff\1\7\1\11\10\uffff\1\42\1\uffff\1\57\1\62\1\73\13\uffff\1\6\2\uffff\1\34\4\uffff\1\26\13\uffff\1\1\1\3\1\61\1\4\2\uffff\1\5\3\uffff\1\56\1\32\1\uffff\1\64\1\33\1\uffff\1\101\4\uffff\1\66\1\uffff\1\65\3\uffff\1\31\3\uffff\1\46\1\uffff\1\27\1\30\2\uffff\1\12\1\63";
    static final String DFA17_specialS =
        "\16\uffff\1\1\75\uffff\1\0\u00c7\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\47\2\uffff\1\47\22\uffff\1\47\1\uffff\1\46\4\uffff\1\46\1\23\1\24\1\12\1\14\1\25\1\11\1\36\1\13\12\45\1\34\1\33\1\16\1\15\1\17\1\43\1\57\1\56\1\51\6\56\1\52\5\56\1\53\2\56\1\54\1\50\7\56\1\26\1\uffff\1\27\1\55\1\56\1\uffff\1\6\1\41\1\42\1\21\1\4\1\3\2\56\1\22\2\56\1\5\1\20\1\7\1\37\2\56\1\30\1\1\1\44\1\10\1\2\1\40\3\56\1\31\1\35\1\32",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\61\5\64\1\63\3\64\1\60\7\64\1\62\3\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\67\21\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\73\7\64\1\71\5\64\1\70\5\64\1\72\5\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\75\11\64\1\74\2\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\76\31\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\100\5\64\1\77\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\102\5\64\1\101\5\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\103\1\64\1\104\12\64",
            "\1\105",
            "",
            "\1\107\4\uffff\1\110",
            "\1\112",
            "",
            "\75\115\1\114\uffc2\115",
            "\1\117",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\121\15\64\1\122\13\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\123\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\124\15\64",
            "",
            "",
            "",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\125\5\64",
            "",
            "",
            "",
            "\1\126",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\130\1\64\1\131\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\132\21\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\30\64\1\133\1\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\134\31\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\135\10\64",
            "",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\136\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\137\13\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\140\14\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\141\27\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\142\25\64",
            "\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\143\5\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\144\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\145\21\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\146\21\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\147\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\150\10\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\151\10\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\152\14\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\153\2\64\1\154\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\155\21\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\5\64\1\157\15\64\1\156\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\160\7\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\162\26\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\163\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\164\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\165\10\64\1\166\15\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\167\26\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\0\115",
            "",
            "",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\171\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\172\26\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\5\64\1\173\5\64\1\174\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\175\12\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\176\16\64",
            "\1\177",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\7\64\1\u0082\22\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0083\6\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u0085\7\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u0086\5\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u0087\10\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u0088\13\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0089\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u008a\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u008b\7\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u008c\10\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u008d\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u008e\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\u008f\12\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\26\64\1\u0090\3\64",
            "\1\66\16\uffff\12\64\7\uffff\1\u0091\31\64\4\uffff\1\64\1\uffff\4\64\1\u0092\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u0093\7\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u0094\27\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u0095\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u0096\7\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u0097\7\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u0098\10\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u0099\13\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u009a\6\64",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u009c\16\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u009e\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\u009f\31\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\u00a0\31\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u00a1\27\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00a2\5\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\u00a3\31\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00a4\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u00a5\13\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00a6\25\64",
            "",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00a7\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\7\64\1\u00a8\22\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00a9\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00aa\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u00ab\21\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00ac\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00ad\25\64",
            "\1\66\16\uffff\12\64\7\uffff\1\u00ae\15\64\1\u00af\13\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u00b0\13\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u00b1\27\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u00b2\27\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u00b3\27\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00b6\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\u00b7\31\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00b8\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00b9\6\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00bb\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00bc\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\30\64\1\u00bd\1\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00be\10\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\5\64\1\u00c1\24\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00c2\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00c3\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\7\64\1\u00c4\22\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00c5\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00c6\5\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00c7\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00c8\10\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00ca\10\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u00ce\14\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00cf\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\6\64\1\u00d0\23\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u00d1\14\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\64\1\u00d2\30\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00d3\5\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00d4\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00d5\6\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\7\64\1\u00d6\22\64",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00d7\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u00d8\27\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u00da\21\64",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u00db\7\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u00dd\27\64",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u00de\21\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u00df\27\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00e0\25\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00e2\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00e3\16\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00e4\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00e5\6\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\26\64\1\u00e6\3\64",
            "",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\6\64\1\u00e7\23\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\1\u00e8\31\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00e9\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\30\64\1\u00ea\1\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\11\64\1\u00eb\20\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00ec\10\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\7\64\1\u00f1\22\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u00f2\13\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00f4\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u00f5\14\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\7\64\1\u00f6\22\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00f9\6\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u00fc\21\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u00fe\14\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00ff\10\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0100\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u0101\27\64",
            "",
            "",
            "",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u0103\14\64",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0105\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u0106\2\64\1\u0107\4\64",
            "",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u0109\7\64",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u010a\27\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u010b\25\64",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u010d\26\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0110\25\64",
            "\1\66\16\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0111\6\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\66\16\uffff\12\64\6\uffff\1\65\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
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
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | RULE_BOOLEAN | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_PRIMITIVE_TYPE | RULE_PATH_NAME | RULE_NAME | RULE_MODEL_URI | RULE_OBJ_URI );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_76 = input.LA(1);

                        s = -1;
                        if ( ((LA17_76>='\u0000' && LA17_76<='\uFFFF')) ) {s = 77;}

                        else s = 120;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_14 = input.LA(1);

                        s = -1;
                        if ( (LA17_14=='=') ) {s = 76;}

                        else if ( ((LA17_14>='\u0000' && LA17_14<='<')||(LA17_14>='>' && LA17_14<='\uFFFF')) ) {s = 77;}

                        else s = 78;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}