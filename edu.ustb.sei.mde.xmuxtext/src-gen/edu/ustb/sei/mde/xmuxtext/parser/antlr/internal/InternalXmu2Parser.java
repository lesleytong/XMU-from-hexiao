package edu.ustb.sei.mde.xmuxtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.ustb.sei.mde.xmuxtext.services.Xmu2GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXmu2Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NAME", "RULE_MODEL_URI", "RULE_INT", "RULE_OBJ_URI", "RULE_PRIMITIVE_TYPE", "RULE_PATH_NAME", "RULE_STRING", "RULE_BOOLEAN", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ID", "'module'", "'import'", "'entry'", "'('", "','", "')'", "'['", "']'", "'rule'", "'{'", "';'", "'}'", "'function'", "':'", "'='", "'?'", "'->'", "'|'", "'.'", "'::'", "'and'", "'or'", "'update'", "'with'", "'by'", "'switch'", "'case'", "'otherwise'", "'delete'", "'enforce'", "'foreach'", "'skip'", "'fail'", "'::='", "'source'", "'view'", "'select'", "'forAll'", "'exists'", "'first'", "'last'", "'at'", "'null'", "'undefined'", "'not'", "'-'", "'*'", "'/'", "'+'", "'++'", "'<'", "'<='", "'>'", "'>='", "'match'", "'unmatchs'", "'unmatchv'", "'default'"
    };
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=11;
    public static final int T__19=19;
    public static final int RULE_MODEL_URI=5;
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
    public static final int RULE_PRIMITIVE_TYPE=8;
    public static final int RULE_OBJ_URI=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
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
    public static final int RULE_NAME=4;
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
    public static final int RULE_PATH_NAME=9;
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


        public InternalXmu2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXmu2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXmu2Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalXmu2.g"; }



     	private Xmu2GrammarAccess grammarAccess;

        public InternalXmu2Parser(TokenStream input, Xmu2GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "TransformationModel";
       	}

       	@Override
       	protected Xmu2GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTransformationModel"
    // InternalXmu2.g:65:1: entryRuleTransformationModel returns [EObject current=null] : iv_ruleTransformationModel= ruleTransformationModel EOF ;
    public final EObject entryRuleTransformationModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationModel = null;


        try {
            // InternalXmu2.g:65:60: (iv_ruleTransformationModel= ruleTransformationModel EOF )
            // InternalXmu2.g:66:2: iv_ruleTransformationModel= ruleTransformationModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTransformationModel=ruleTransformationModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformationModel"


    // $ANTLR start "ruleTransformationModel"
    // InternalXmu2.g:72:1: ruleTransformationModel returns [EObject current=null] : ( () otherlv_1= 'module' ( (lv_name_2_0= RULE_NAME ) ) (otherlv_3= 'import' ( (otherlv_4= RULE_MODEL_URI ) ) )* ( (lv_entryPoints_5_0= ruleEntryPoint ) )* ( (lv_rules_6_0= ruleAbstractRule ) )* ) ;
    public final EObject ruleTransformationModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_entryPoints_5_0 = null;

        EObject lv_rules_6_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:78:2: ( ( () otherlv_1= 'module' ( (lv_name_2_0= RULE_NAME ) ) (otherlv_3= 'import' ( (otherlv_4= RULE_MODEL_URI ) ) )* ( (lv_entryPoints_5_0= ruleEntryPoint ) )* ( (lv_rules_6_0= ruleAbstractRule ) )* ) )
            // InternalXmu2.g:79:2: ( () otherlv_1= 'module' ( (lv_name_2_0= RULE_NAME ) ) (otherlv_3= 'import' ( (otherlv_4= RULE_MODEL_URI ) ) )* ( (lv_entryPoints_5_0= ruleEntryPoint ) )* ( (lv_rules_6_0= ruleAbstractRule ) )* )
            {
            // InternalXmu2.g:79:2: ( () otherlv_1= 'module' ( (lv_name_2_0= RULE_NAME ) ) (otherlv_3= 'import' ( (otherlv_4= RULE_MODEL_URI ) ) )* ( (lv_entryPoints_5_0= ruleEntryPoint ) )* ( (lv_rules_6_0= ruleAbstractRule ) )* )
            // InternalXmu2.g:80:3: () otherlv_1= 'module' ( (lv_name_2_0= RULE_NAME ) ) (otherlv_3= 'import' ( (otherlv_4= RULE_MODEL_URI ) ) )* ( (lv_entryPoints_5_0= ruleEntryPoint ) )* ( (lv_rules_6_0= ruleAbstractRule ) )*
            {
            // InternalXmu2.g:80:3: ()
            // InternalXmu2.g:81:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTransformationModelAccess().getTransformationModelAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,16,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTransformationModelAccess().getModuleKeyword_1());
              		
            }
            // InternalXmu2.g:91:3: ( (lv_name_2_0= RULE_NAME ) )
            // InternalXmu2.g:92:4: (lv_name_2_0= RULE_NAME )
            {
            // InternalXmu2.g:92:4: (lv_name_2_0= RULE_NAME )
            // InternalXmu2.g:93:5: lv_name_2_0= RULE_NAME
            {
            lv_name_2_0=(Token)match(input,RULE_NAME,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getTransformationModelAccess().getNameNAMETerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTransformationModelRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              				
            }

            }


            }

            // InternalXmu2.g:109:3: (otherlv_3= 'import' ( (otherlv_4= RULE_MODEL_URI ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalXmu2.g:110:4: otherlv_3= 'import' ( (otherlv_4= RULE_MODEL_URI ) )
            	    {
            	    otherlv_3=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getTransformationModelAccess().getImportKeyword_3_0());
            	      			
            	    }
            	    // InternalXmu2.g:114:4: ( (otherlv_4= RULE_MODEL_URI ) )
            	    // InternalXmu2.g:115:5: (otherlv_4= RULE_MODEL_URI )
            	    {
            	    // InternalXmu2.g:115:5: (otherlv_4= RULE_MODEL_URI )
            	    // InternalXmu2.g:116:6: otherlv_4= RULE_MODEL_URI
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getTransformationModelRule());
            	      						}
            	      					
            	    }
            	    otherlv_4=(Token)match(input,RULE_MODEL_URI,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_4, grammarAccess.getTransformationModelAccess().getPackagesEPackageCrossReference_3_1_0());
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalXmu2.g:128:3: ( (lv_entryPoints_5_0= ruleEntryPoint ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalXmu2.g:129:4: (lv_entryPoints_5_0= ruleEntryPoint )
            	    {
            	    // InternalXmu2.g:129:4: (lv_entryPoints_5_0= ruleEntryPoint )
            	    // InternalXmu2.g:130:5: lv_entryPoints_5_0= ruleEntryPoint
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTransformationModelAccess().getEntryPointsEntryPointParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_entryPoints_5_0=ruleEntryPoint();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTransformationModelRule());
            	      					}
            	      					add(
            	      						current,
            	      						"entryPoints",
            	      						lv_entryPoints_5_0,
            	      						"edu.ustb.sei.mde.xmuxtext.Xmu2.EntryPoint");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalXmu2.g:147:3: ( (lv_rules_6_0= ruleAbstractRule ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==24||LA3_0==28) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalXmu2.g:148:4: (lv_rules_6_0= ruleAbstractRule )
            	    {
            	    // InternalXmu2.g:148:4: (lv_rules_6_0= ruleAbstractRule )
            	    // InternalXmu2.g:149:5: lv_rules_6_0= ruleAbstractRule
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTransformationModelAccess().getRulesAbstractRuleParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_rules_6_0=ruleAbstractRule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTransformationModelRule());
            	      					}
            	      					add(
            	      						current,
            	      						"rules",
            	      						lv_rules_6_0,
            	      						"edu.ustb.sei.mde.xmuxtext.Xmu2.AbstractRule");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformationModel"


    // $ANTLR start "entryRuleEntryPoint"
    // InternalXmu2.g:170:1: entryRuleEntryPoint returns [EObject current=null] : iv_ruleEntryPoint= ruleEntryPoint EOF ;
    public final EObject entryRuleEntryPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPoint = null;


        try {
            // InternalXmu2.g:170:51: (iv_ruleEntryPoint= ruleEntryPoint EOF )
            // InternalXmu2.g:171:2: iv_ruleEntryPoint= ruleEntryPoint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryPointRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEntryPoint=ruleEntryPoint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntryPoint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntryPoint"


    // $ANTLR start "ruleEntryPoint"
    // InternalXmu2.g:177:1: ruleEntryPoint returns [EObject current=null] : (otherlv_0= 'entry' ( (otherlv_1= RULE_NAME ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleEntryData ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleEntryData ) ) )* otherlv_6= ')' ) ;
    public final EObject ruleEntryPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:183:2: ( (otherlv_0= 'entry' ( (otherlv_1= RULE_NAME ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleEntryData ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleEntryData ) ) )* otherlv_6= ')' ) )
            // InternalXmu2.g:184:2: (otherlv_0= 'entry' ( (otherlv_1= RULE_NAME ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleEntryData ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleEntryData ) ) )* otherlv_6= ')' )
            {
            // InternalXmu2.g:184:2: (otherlv_0= 'entry' ( (otherlv_1= RULE_NAME ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleEntryData ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleEntryData ) ) )* otherlv_6= ')' )
            // InternalXmu2.g:185:3: otherlv_0= 'entry' ( (otherlv_1= RULE_NAME ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleEntryData ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleEntryData ) ) )* otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEntryPointAccess().getEntryKeyword_0());
              		
            }
            // InternalXmu2.g:189:3: ( (otherlv_1= RULE_NAME ) )
            // InternalXmu2.g:190:4: (otherlv_1= RULE_NAME )
            {
            // InternalXmu2.g:190:4: (otherlv_1= RULE_NAME )
            // InternalXmu2.g:191:5: otherlv_1= RULE_NAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEntryPointRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_NAME,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getEntryPointAccess().getRuleModelRuleCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEntryPointAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalXmu2.g:206:3: ( (lv_parameters_3_0= ruleEntryData ) )
            // InternalXmu2.g:207:4: (lv_parameters_3_0= ruleEntryData )
            {
            // InternalXmu2.g:207:4: (lv_parameters_3_0= ruleEntryData )
            // InternalXmu2.g:208:5: lv_parameters_3_0= ruleEntryData
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEntryPointAccess().getParametersEntryDataParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_parameters_3_0=ruleEntryData();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEntryPointRule());
              					}
              					add(
              						current,
              						"parameters",
              						lv_parameters_3_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.EntryData");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:225:3: (otherlv_4= ',' ( (lv_parameters_5_0= ruleEntryData ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalXmu2.g:226:4: otherlv_4= ',' ( (lv_parameters_5_0= ruleEntryData ) )
            	    {
            	    otherlv_4=(Token)match(input,20,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getEntryPointAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalXmu2.g:230:4: ( (lv_parameters_5_0= ruleEntryData ) )
            	    // InternalXmu2.g:231:5: (lv_parameters_5_0= ruleEntryData )
            	    {
            	    // InternalXmu2.g:231:5: (lv_parameters_5_0= ruleEntryData )
            	    // InternalXmu2.g:232:6: lv_parameters_5_0= ruleEntryData
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEntryPointAccess().getParametersEntryDataParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_parameters_5_0=ruleEntryData();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEntryPointRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parameters",
            	      							lv_parameters_5_0,
            	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.EntryData");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_6=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEntryPointAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntryPoint"


    // $ANTLR start "entryRuleEntryData"
    // InternalXmu2.g:258:1: entryRuleEntryData returns [EObject current=null] : iv_ruleEntryData= ruleEntryData EOF ;
    public final EObject entryRuleEntryData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryData = null;


        try {
            // InternalXmu2.g:258:50: (iv_ruleEntryData= ruleEntryData EOF )
            // InternalXmu2.g:259:2: iv_ruleEntryData= ruleEntryData EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryDataRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEntryData=ruleEntryData();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntryData; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntryData"


    // $ANTLR start "ruleEntryData"
    // InternalXmu2.g:265:1: ruleEntryData returns [EObject current=null] : ( ( (lv_tag_0_0= ruleTag ) )? otherlv_1= '[' ( (lv_index_2_0= RULE_INT ) ) ( (lv_fragment_3_0= RULE_OBJ_URI ) )? otherlv_4= ']' ) ;
    public final EObject ruleEntryData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_index_2_0=null;
        Token lv_fragment_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_tag_0_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:271:2: ( ( ( (lv_tag_0_0= ruleTag ) )? otherlv_1= '[' ( (lv_index_2_0= RULE_INT ) ) ( (lv_fragment_3_0= RULE_OBJ_URI ) )? otherlv_4= ']' ) )
            // InternalXmu2.g:272:2: ( ( (lv_tag_0_0= ruleTag ) )? otherlv_1= '[' ( (lv_index_2_0= RULE_INT ) ) ( (lv_fragment_3_0= RULE_OBJ_URI ) )? otherlv_4= ']' )
            {
            // InternalXmu2.g:272:2: ( ( (lv_tag_0_0= ruleTag ) )? otherlv_1= '[' ( (lv_index_2_0= RULE_INT ) ) ( (lv_fragment_3_0= RULE_OBJ_URI ) )? otherlv_4= ']' )
            // InternalXmu2.g:273:3: ( (lv_tag_0_0= ruleTag ) )? otherlv_1= '[' ( (lv_index_2_0= RULE_INT ) ) ( (lv_fragment_3_0= RULE_OBJ_URI ) )? otherlv_4= ']'
            {
            // InternalXmu2.g:273:3: ( (lv_tag_0_0= ruleTag ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=50 && LA5_0<=51)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXmu2.g:274:4: (lv_tag_0_0= ruleTag )
                    {
                    // InternalXmu2.g:274:4: (lv_tag_0_0= ruleTag )
                    // InternalXmu2.g:275:5: lv_tag_0_0= ruleTag
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getEntryDataAccess().getTagTagEnumRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_11);
                    lv_tag_0_0=ruleTag();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getEntryDataRule());
                      					}
                      					set(
                      						current,
                      						"tag",
                      						lv_tag_0_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.Tag");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEntryDataAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalXmu2.g:296:3: ( (lv_index_2_0= RULE_INT ) )
            // InternalXmu2.g:297:4: (lv_index_2_0= RULE_INT )
            {
            // InternalXmu2.g:297:4: (lv_index_2_0= RULE_INT )
            // InternalXmu2.g:298:5: lv_index_2_0= RULE_INT
            {
            lv_index_2_0=(Token)match(input,RULE_INT,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_index_2_0, grammarAccess.getEntryDataAccess().getIndexINTTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEntryDataRule());
              					}
              					setWithLastConsumed(
              						current,
              						"index",
              						lv_index_2_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.INT");
              				
            }

            }


            }

            // InternalXmu2.g:314:3: ( (lv_fragment_3_0= RULE_OBJ_URI ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_OBJ_URI) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXmu2.g:315:4: (lv_fragment_3_0= RULE_OBJ_URI )
                    {
                    // InternalXmu2.g:315:4: (lv_fragment_3_0= RULE_OBJ_URI )
                    // InternalXmu2.g:316:5: lv_fragment_3_0= RULE_OBJ_URI
                    {
                    lv_fragment_3_0=(Token)match(input,RULE_OBJ_URI,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_fragment_3_0, grammarAccess.getEntryDataAccess().getFragmentOBJ_URITerminalRuleCall_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEntryDataRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"fragment",
                      						lv_fragment_3_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.OBJ_URI");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getEntryDataAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntryData"


    // $ANTLR start "entryRuleAbstractRule"
    // InternalXmu2.g:340:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // InternalXmu2.g:340:53: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // InternalXmu2.g:341:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // InternalXmu2.g:347:1: ruleAbstractRule returns [EObject current=null] : (this_ArithmeticRule_0= ruleArithmeticRule | this_ModelRule_1= ruleModelRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ArithmeticRule_0 = null;

        EObject this_ModelRule_1 = null;



        	enterRule();

        try {
            // InternalXmu2.g:353:2: ( (this_ArithmeticRule_0= ruleArithmeticRule | this_ModelRule_1= ruleModelRule ) )
            // InternalXmu2.g:354:2: (this_ArithmeticRule_0= ruleArithmeticRule | this_ModelRule_1= ruleModelRule )
            {
            // InternalXmu2.g:354:2: (this_ArithmeticRule_0= ruleArithmeticRule | this_ModelRule_1= ruleModelRule )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            else if ( (LA7_0==24) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalXmu2.g:355:3: this_ArithmeticRule_0= ruleArithmeticRule
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractRuleAccess().getArithmeticRuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArithmeticRule_0=ruleArithmeticRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArithmeticRule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalXmu2.g:364:3: this_ModelRule_1= ruleModelRule
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractRuleAccess().getModelRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ModelRule_1=ruleModelRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ModelRule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleModelRule"
    // InternalXmu2.g:376:1: entryRuleModelRule returns [EObject current=null] : iv_ruleModelRule= ruleModelRule EOF ;
    public final EObject entryRuleModelRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelRule = null;


        try {
            // InternalXmu2.g:376:50: (iv_ruleModelRule= ruleModelRule EOF )
            // InternalXmu2.g:377:2: iv_ruleModelRule= ruleModelRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModelRule=ruleModelRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelRule"


    // $ANTLR start "ruleModelRule"
    // InternalXmu2.g:383:1: ruleModelRule returns [EObject current=null] : (otherlv_0= 'rule' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( ( (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration ) ) otherlv_9= ';' )* ( (lv_statement_10_0= ruleStatement ) )? otherlv_11= '}' ) ;
    public final EObject ruleModelRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_variableDeclarations_8_0 = null;

        EObject lv_statement_10_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:389:2: ( (otherlv_0= 'rule' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( ( (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration ) ) otherlv_9= ';' )* ( (lv_statement_10_0= ruleStatement ) )? otherlv_11= '}' ) )
            // InternalXmu2.g:390:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( ( (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration ) ) otherlv_9= ';' )* ( (lv_statement_10_0= ruleStatement ) )? otherlv_11= '}' )
            {
            // InternalXmu2.g:390:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( ( (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration ) ) otherlv_9= ';' )* ( (lv_statement_10_0= ruleStatement ) )? otherlv_11= '}' )
            // InternalXmu2.g:391:3: otherlv_0= 'rule' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( ( (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration ) ) otherlv_9= ';' )* ( (lv_statement_10_0= ruleStatement ) )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getModelRuleAccess().getRuleKeyword_0());
              		
            }
            // InternalXmu2.g:395:3: ( (lv_name_1_0= RULE_NAME ) )
            // InternalXmu2.g:396:4: (lv_name_1_0= RULE_NAME )
            {
            // InternalXmu2.g:396:4: (lv_name_1_0= RULE_NAME )
            // InternalXmu2.g:397:5: lv_name_1_0= RULE_NAME
            {
            lv_name_1_0=(Token)match(input,RULE_NAME,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getModelRuleAccess().getNameNAMETerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getModelRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getModelRuleAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalXmu2.g:417:3: ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_NAME||(LA9_0>=50 && LA9_0<=51)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalXmu2.g:418:4: ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    {
                    // InternalXmu2.g:418:4: ( (lv_parameters_3_0= ruleParameter ) )
                    // InternalXmu2.g:419:5: (lv_parameters_3_0= ruleParameter )
                    {
                    // InternalXmu2.g:419:5: (lv_parameters_3_0= ruleParameter )
                    // InternalXmu2.g:420:6: lv_parameters_3_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getModelRuleAccess().getParametersParameterParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_parameters_3_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getModelRuleRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_3_0,
                      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Parameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalXmu2.g:437:4: (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==20) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalXmu2.g:438:5: otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getModelRuleAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalXmu2.g:442:5: ( (lv_parameters_5_0= ruleParameter ) )
                    	    // InternalXmu2.g:443:6: (lv_parameters_5_0= ruleParameter )
                    	    {
                    	    // InternalXmu2.g:443:6: (lv_parameters_5_0= ruleParameter )
                    	    // InternalXmu2.g:444:7: lv_parameters_5_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getModelRuleAccess().getParametersParameterParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_parameters_5_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getModelRuleRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_5_0,
                    	      								"edu.ustb.sei.mde.xmuxtext.Xmu2.Parameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getModelRuleAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_7=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getModelRuleAccess().getLeftCurlyBracketKeyword_5());
              		
            }
            // InternalXmu2.g:471:3: ( ( (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration ) ) otherlv_9= ';' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_NAME) ) {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2==29) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // InternalXmu2.g:472:4: ( (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration ) ) otherlv_9= ';'
            	    {
            	    // InternalXmu2.g:472:4: ( (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration ) )
            	    // InternalXmu2.g:473:5: (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration )
            	    {
            	    // InternalXmu2.g:473:5: (lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration )
            	    // InternalXmu2.g:474:6: lv_variableDeclarations_8_0= ruleConcreteVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModelRuleAccess().getVariableDeclarationsConcreteVariableDeclarationParserRuleCall_6_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_variableDeclarations_8_0=ruleConcreteVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getModelRuleRule());
            	      						}
            	      						add(
            	      							current,
            	      							"variableDeclarations",
            	      							lv_variableDeclarations_8_0,
            	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.ConcreteVariableDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_9=(Token)match(input,26,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_9, grammarAccess.getModelRuleAccess().getSemicolonKeyword_6_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalXmu2.g:496:3: ( (lv_statement_10_0= ruleStatement ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_NAME||LA11_0==25||LA11_0==38||LA11_0==41||(LA11_0>=44 && LA11_0<=48)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalXmu2.g:497:4: (lv_statement_10_0= ruleStatement )
                    {
                    // InternalXmu2.g:497:4: (lv_statement_10_0= ruleStatement )
                    // InternalXmu2.g:498:5: lv_statement_10_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getModelRuleAccess().getStatementStatementParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
                    lv_statement_10_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getModelRuleRule());
                      					}
                      					set(
                      						current,
                      						"statement",
                      						lv_statement_10_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getModelRuleAccess().getRightCurlyBracketKeyword_8());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelRule"


    // $ANTLR start "entryRuleArithmeticRule"
    // InternalXmu2.g:523:1: entryRuleArithmeticRule returns [EObject current=null] : iv_ruleArithmeticRule= ruleArithmeticRule EOF ;
    public final EObject entryRuleArithmeticRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticRule = null;


        try {
            // InternalXmu2.g:523:55: (iv_ruleArithmeticRule= ruleArithmeticRule EOF )
            // InternalXmu2.g:524:2: iv_ruleArithmeticRule= ruleArithmeticRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithmeticRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticRule=ruleArithmeticRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithmeticRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmeticRule"


    // $ANTLR start "ruleArithmeticRule"
    // InternalXmu2.g:530:1: ruleArithmeticRule returns [EObject current=null] : (otherlv_0= 'function' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_statements_8_0= ruleStatement ) )* otherlv_9= '}' ) ;
    public final EObject ruleArithmeticRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_statements_8_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:536:2: ( (otherlv_0= 'function' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_statements_8_0= ruleStatement ) )* otherlv_9= '}' ) )
            // InternalXmu2.g:537:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_statements_8_0= ruleStatement ) )* otherlv_9= '}' )
            {
            // InternalXmu2.g:537:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_statements_8_0= ruleStatement ) )* otherlv_9= '}' )
            // InternalXmu2.g:538:3: otherlv_0= 'function' ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_statements_8_0= ruleStatement ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArithmeticRuleAccess().getFunctionKeyword_0());
              		
            }
            // InternalXmu2.g:542:3: ( (lv_name_1_0= RULE_NAME ) )
            // InternalXmu2.g:543:4: (lv_name_1_0= RULE_NAME )
            {
            // InternalXmu2.g:543:4: (lv_name_1_0= RULE_NAME )
            // InternalXmu2.g:544:5: lv_name_1_0= RULE_NAME
            {
            lv_name_1_0=(Token)match(input,RULE_NAME,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getArithmeticRuleAccess().getNameNAMETerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getArithmeticRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getArithmeticRuleAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalXmu2.g:564:3: ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_NAME||(LA13_0>=50 && LA13_0<=51)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalXmu2.g:565:4: ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    {
                    // InternalXmu2.g:565:4: ( (lv_parameters_3_0= ruleParameter ) )
                    // InternalXmu2.g:566:5: (lv_parameters_3_0= ruleParameter )
                    {
                    // InternalXmu2.g:566:5: (lv_parameters_3_0= ruleParameter )
                    // InternalXmu2.g:567:6: lv_parameters_3_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArithmeticRuleAccess().getParametersParameterParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_parameters_3_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getArithmeticRuleRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_3_0,
                      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Parameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalXmu2.g:584:4: (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==20) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalXmu2.g:585:5: otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getArithmeticRuleAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalXmu2.g:589:5: ( (lv_parameters_5_0= ruleParameter ) )
                    	    // InternalXmu2.g:590:6: (lv_parameters_5_0= ruleParameter )
                    	    {
                    	    // InternalXmu2.g:590:6: (lv_parameters_5_0= ruleParameter )
                    	    // InternalXmu2.g:591:7: lv_parameters_5_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArithmeticRuleAccess().getParametersParameterParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_parameters_5_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getArithmeticRuleRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_5_0,
                    	      								"edu.ustb.sei.mde.xmuxtext.Xmu2.Parameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getArithmeticRuleAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_7=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getArithmeticRuleAccess().getLeftCurlyBracketKeyword_5());
              		
            }
            // InternalXmu2.g:618:3: ( (lv_statements_8_0= ruleStatement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_NAME||LA14_0==25||LA14_0==38||LA14_0==41||(LA14_0>=44 && LA14_0<=48)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalXmu2.g:619:4: (lv_statements_8_0= ruleStatement )
            	    {
            	    // InternalXmu2.g:619:4: (lv_statements_8_0= ruleStatement )
            	    // InternalXmu2.g:620:5: lv_statements_8_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getArithmeticRuleAccess().getStatementsStatementParserRuleCall_6_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_18);
            	    lv_statements_8_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getArithmeticRuleRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_8_0,
            	      						"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_9=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getArithmeticRuleAccess().getRightCurlyBracketKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmeticRule"


    // $ANTLR start "entryRuleParameter"
    // InternalXmu2.g:645:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalXmu2.g:645:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalXmu2.g:646:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalXmu2.g:652:1: ruleParameter returns [EObject current=null] : ( ( (lv_tag_0_0= ruleTag ) )? ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= ':' ( ( ruleType ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Enumerator lv_tag_0_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:658:2: ( ( ( (lv_tag_0_0= ruleTag ) )? ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= ':' ( ( ruleType ) ) ) )
            // InternalXmu2.g:659:2: ( ( (lv_tag_0_0= ruleTag ) )? ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= ':' ( ( ruleType ) ) )
            {
            // InternalXmu2.g:659:2: ( ( (lv_tag_0_0= ruleTag ) )? ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= ':' ( ( ruleType ) ) )
            // InternalXmu2.g:660:3: ( (lv_tag_0_0= ruleTag ) )? ( (lv_name_1_0= RULE_NAME ) ) otherlv_2= ':' ( ( ruleType ) )
            {
            // InternalXmu2.g:660:3: ( (lv_tag_0_0= ruleTag ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=50 && LA15_0<=51)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXmu2.g:661:4: (lv_tag_0_0= ruleTag )
                    {
                    // InternalXmu2.g:661:4: (lv_tag_0_0= ruleTag )
                    // InternalXmu2.g:662:5: lv_tag_0_0= ruleTag
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getParameterAccess().getTagTagEnumRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_3);
                    lv_tag_0_0=ruleTag();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getParameterRule());
                      					}
                      					set(
                      						current,
                      						"tag",
                      						lv_tag_0_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.Tag");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalXmu2.g:679:3: ( (lv_name_1_0= RULE_NAME ) )
            // InternalXmu2.g:680:4: (lv_name_1_0= RULE_NAME )
            {
            // InternalXmu2.g:680:4: (lv_name_1_0= RULE_NAME )
            // InternalXmu2.g:681:5: lv_name_1_0= RULE_NAME
            {
            lv_name_1_0=(Token)match(input,RULE_NAME,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameNAMETerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
              		
            }
            // InternalXmu2.g:701:3: ( ( ruleType ) )
            // InternalXmu2.g:702:4: ( ruleType )
            {
            // InternalXmu2.g:702:4: ( ruleType )
            // InternalXmu2.g:703:5: ruleType
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeEClassifierCrossReference_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleType"
    // InternalXmu2.g:721:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalXmu2.g:721:44: (iv_ruleType= ruleType EOF )
            // InternalXmu2.g:722:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalXmu2.g:728:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PRIMITIVE_TYPE_0= RULE_PRIMITIVE_TYPE | this_PATH_NAME_1= RULE_PATH_NAME ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_PRIMITIVE_TYPE_0=null;
        Token this_PATH_NAME_1=null;


        	enterRule();

        try {
            // InternalXmu2.g:734:2: ( (this_PRIMITIVE_TYPE_0= RULE_PRIMITIVE_TYPE | this_PATH_NAME_1= RULE_PATH_NAME ) )
            // InternalXmu2.g:735:2: (this_PRIMITIVE_TYPE_0= RULE_PRIMITIVE_TYPE | this_PATH_NAME_1= RULE_PATH_NAME )
            {
            // InternalXmu2.g:735:2: (this_PRIMITIVE_TYPE_0= RULE_PRIMITIVE_TYPE | this_PATH_NAME_1= RULE_PATH_NAME )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_PRIMITIVE_TYPE) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_PATH_NAME) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalXmu2.g:736:3: this_PRIMITIVE_TYPE_0= RULE_PRIMITIVE_TYPE
                    {
                    this_PRIMITIVE_TYPE_0=(Token)match(input,RULE_PRIMITIVE_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_PRIMITIVE_TYPE_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_PRIMITIVE_TYPE_0, grammarAccess.getTypeAccess().getPRIMITIVE_TYPETerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalXmu2.g:744:3: this_PATH_NAME_1= RULE_PATH_NAME
                    {
                    this_PATH_NAME_1=(Token)match(input,RULE_PATH_NAME,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_PATH_NAME_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_PATH_NAME_1, grammarAccess.getTypeAccess().getPATH_NAMETerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleConcreteVariableDeclaration"
    // InternalXmu2.g:755:1: entryRuleConcreteVariableDeclaration returns [EObject current=null] : iv_ruleConcreteVariableDeclaration= ruleConcreteVariableDeclaration EOF ;
    public final EObject entryRuleConcreteVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteVariableDeclaration = null;


        try {
            // InternalXmu2.g:755:68: (iv_ruleConcreteVariableDeclaration= ruleConcreteVariableDeclaration EOF )
            // InternalXmu2.g:756:2: iv_ruleConcreteVariableDeclaration= ruleConcreteVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConcreteVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConcreteVariableDeclaration=ruleConcreteVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConcreteVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteVariableDeclaration"


    // $ANTLR start "ruleConcreteVariableDeclaration"
    // InternalXmu2.g:762:1: ruleConcreteVariableDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_NAME ) ) otherlv_1= ':' ( ( ruleType ) ) ) ;
    public final EObject ruleConcreteVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalXmu2.g:768:2: ( ( ( (lv_name_0_0= RULE_NAME ) ) otherlv_1= ':' ( ( ruleType ) ) ) )
            // InternalXmu2.g:769:2: ( ( (lv_name_0_0= RULE_NAME ) ) otherlv_1= ':' ( ( ruleType ) ) )
            {
            // InternalXmu2.g:769:2: ( ( (lv_name_0_0= RULE_NAME ) ) otherlv_1= ':' ( ( ruleType ) ) )
            // InternalXmu2.g:770:3: ( (lv_name_0_0= RULE_NAME ) ) otherlv_1= ':' ( ( ruleType ) )
            {
            // InternalXmu2.g:770:3: ( (lv_name_0_0= RULE_NAME ) )
            // InternalXmu2.g:771:4: (lv_name_0_0= RULE_NAME )
            {
            // InternalXmu2.g:771:4: (lv_name_0_0= RULE_NAME )
            // InternalXmu2.g:772:5: lv_name_0_0= RULE_NAME
            {
            lv_name_0_0=(Token)match(input,RULE_NAME,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getConcreteVariableDeclarationAccess().getNameNAMETerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConcreteVariableDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConcreteVariableDeclarationAccess().getColonKeyword_1());
              		
            }
            // InternalXmu2.g:792:3: ( ( ruleType ) )
            // InternalXmu2.g:793:4: ( ruleType )
            {
            // InternalXmu2.g:793:4: ( ruleType )
            // InternalXmu2.g:794:5: ruleType
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConcreteVariableDeclarationRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConcreteVariableDeclarationAccess().getTypeEClassifierCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteVariableDeclaration"


    // $ANTLR start "entryRulePattern"
    // InternalXmu2.g:812:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalXmu2.g:812:48: (iv_rulePattern= rulePattern EOF )
            // InternalXmu2.g:813:2: iv_rulePattern= rulePattern EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePattern; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalXmu2.g:819:1: rulePattern returns [EObject current=null] : ( ( (lv_root_0_0= rulePatternNode ) ) (otherlv_1= '[' ( (lv_guard_2_0= ruleExpression ) ) otherlv_3= ']' )? ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_root_0_0 = null;

        EObject lv_guard_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:825:2: ( ( ( (lv_root_0_0= rulePatternNode ) ) (otherlv_1= '[' ( (lv_guard_2_0= ruleExpression ) ) otherlv_3= ']' )? ) )
            // InternalXmu2.g:826:2: ( ( (lv_root_0_0= rulePatternNode ) ) (otherlv_1= '[' ( (lv_guard_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            {
            // InternalXmu2.g:826:2: ( ( (lv_root_0_0= rulePatternNode ) ) (otherlv_1= '[' ( (lv_guard_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            // InternalXmu2.g:827:3: ( (lv_root_0_0= rulePatternNode ) ) (otherlv_1= '[' ( (lv_guard_2_0= ruleExpression ) ) otherlv_3= ']' )?
            {
            // InternalXmu2.g:827:3: ( (lv_root_0_0= rulePatternNode ) )
            // InternalXmu2.g:828:4: (lv_root_0_0= rulePatternNode )
            {
            // InternalXmu2.g:828:4: (lv_root_0_0= rulePatternNode )
            // InternalXmu2.g:829:5: lv_root_0_0= rulePatternNode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPatternAccess().getRootPatternNodeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_23);
            lv_root_0_0=rulePatternNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPatternRule());
              					}
              					set(
              						current,
              						"root",
              						lv_root_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.PatternNode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:846:3: (otherlv_1= '[' ( (lv_guard_2_0= ruleExpression ) ) otherlv_3= ']' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalXmu2.g:847:4: otherlv_1= '[' ( (lv_guard_2_0= ruleExpression ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPatternAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalXmu2.g:851:4: ( (lv_guard_2_0= ruleExpression ) )
                    // InternalXmu2.g:852:5: (lv_guard_2_0= ruleExpression )
                    {
                    // InternalXmu2.g:852:5: (lv_guard_2_0= ruleExpression )
                    // InternalXmu2.g:853:6: lv_guard_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPatternAccess().getGuardExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_guard_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPatternRule());
                      						}
                      						set(
                      							current,
                      							"guard",
                      							lv_guard_2_0,
                      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPatternAccess().getRightSquareBracketKeyword_1_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRulePatternNode"
    // InternalXmu2.g:879:1: entryRulePatternNode returns [EObject current=null] : iv_rulePatternNode= rulePatternNode EOF ;
    public final EObject entryRulePatternNode() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternNode = null;


        try {
            // InternalXmu2.g:879:52: (iv_rulePatternNode= rulePatternNode EOF )
            // InternalXmu2.g:880:2: iv_rulePatternNode= rulePatternNode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePatternNode=rulePatternNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternNode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternNode"


    // $ANTLR start "rulePatternNode"
    // InternalXmu2.g:886:1: rulePatternNode returns [EObject current=null] : ( () ( (lv_variable_1_0= ruleConcreteVariableDeclaration ) ) (otherlv_2= '{' ( ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )* )? otherlv_6= '}' )? ) ;
    public final EObject rulePatternNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_variable_1_0 = null;

        EObject lv_expressions_3_0 = null;

        EObject lv_expressions_5_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:892:2: ( ( () ( (lv_variable_1_0= ruleConcreteVariableDeclaration ) ) (otherlv_2= '{' ( ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )* )? otherlv_6= '}' )? ) )
            // InternalXmu2.g:893:2: ( () ( (lv_variable_1_0= ruleConcreteVariableDeclaration ) ) (otherlv_2= '{' ( ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )* )? otherlv_6= '}' )? )
            {
            // InternalXmu2.g:893:2: ( () ( (lv_variable_1_0= ruleConcreteVariableDeclaration ) ) (otherlv_2= '{' ( ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )* )? otherlv_6= '}' )? )
            // InternalXmu2.g:894:3: () ( (lv_variable_1_0= ruleConcreteVariableDeclaration ) ) (otherlv_2= '{' ( ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )* )? otherlv_6= '}' )?
            {
            // InternalXmu2.g:894:3: ()
            // InternalXmu2.g:895:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPatternNodeAccess().getPatternNodeAction_0(),
              					current);
              			
            }

            }

            // InternalXmu2.g:901:3: ( (lv_variable_1_0= ruleConcreteVariableDeclaration ) )
            // InternalXmu2.g:902:4: (lv_variable_1_0= ruleConcreteVariableDeclaration )
            {
            // InternalXmu2.g:902:4: (lv_variable_1_0= ruleConcreteVariableDeclaration )
            // InternalXmu2.g:903:5: lv_variable_1_0= ruleConcreteVariableDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPatternNodeAccess().getVariableConcreteVariableDeclarationParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_variable_1_0=ruleConcreteVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPatternNodeRule());
              					}
              					set(
              						current,
              						"variable",
              						lv_variable_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.ConcreteVariableDeclaration");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:920:3: (otherlv_2= '{' ( ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )* )? otherlv_6= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==RULE_NAME) ) {
                    int LA20_3 = input.LA(3);

                    if ( (LA20_3==30||LA20_3==32) ) {
                        alt20=1;
                    }
                }
                else if ( (LA20_1==27) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // InternalXmu2.g:921:4: otherlv_2= '{' ( ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )* )? otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPatternNodeAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalXmu2.g:925:4: ( ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )* )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_NAME) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalXmu2.g:926:5: ( (lv_expressions_3_0= rulePatternExpression ) ) (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )*
                            {
                            // InternalXmu2.g:926:5: ( (lv_expressions_3_0= rulePatternExpression ) )
                            // InternalXmu2.g:927:6: (lv_expressions_3_0= rulePatternExpression )
                            {
                            // InternalXmu2.g:927:6: (lv_expressions_3_0= rulePatternExpression )
                            // InternalXmu2.g:928:7: lv_expressions_3_0= rulePatternExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPatternNodeAccess().getExpressionsPatternExpressionParserRuleCall_2_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_27);
                            lv_expressions_3_0=rulePatternExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getPatternNodeRule());
                              							}
                              							add(
                              								current,
                              								"expressions",
                              								lv_expressions_3_0,
                              								"edu.ustb.sei.mde.xmuxtext.Xmu2.PatternExpression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalXmu2.g:945:5: (otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) ) )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==20) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // InternalXmu2.g:946:6: otherlv_4= ',' ( (lv_expressions_5_0= rulePatternExpression ) )
                            	    {
                            	    otherlv_4=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_4, grammarAccess.getPatternNodeAccess().getCommaKeyword_2_1_1_0());
                            	      					
                            	    }
                            	    // InternalXmu2.g:950:6: ( (lv_expressions_5_0= rulePatternExpression ) )
                            	    // InternalXmu2.g:951:7: (lv_expressions_5_0= rulePatternExpression )
                            	    {
                            	    // InternalXmu2.g:951:7: (lv_expressions_5_0= rulePatternExpression )
                            	    // InternalXmu2.g:952:8: lv_expressions_5_0= rulePatternExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getPatternNodeAccess().getExpressionsPatternExpressionParserRuleCall_2_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_27);
                            	    lv_expressions_5_0=rulePatternExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getPatternNodeRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"expressions",
                            	      									lv_expressions_5_0,
                            	      									"edu.ustb.sei.mde.xmuxtext.Xmu2.PatternExpression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop18;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getPatternNodeAccess().getRightCurlyBracketKeyword_2_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternNode"


    // $ANTLR start "entryRulePatternExpression"
    // InternalXmu2.g:980:1: entryRulePatternExpression returns [EObject current=null] : iv_rulePatternExpression= rulePatternExpression EOF ;
    public final EObject entryRulePatternExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternExpression = null;


        try {
            // InternalXmu2.g:980:58: (iv_rulePatternExpression= rulePatternExpression EOF )
            // InternalXmu2.g:981:2: iv_rulePatternExpression= rulePatternExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePatternExpression=rulePatternExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternExpression"


    // $ANTLR start "rulePatternExpression"
    // InternalXmu2.g:987:1: rulePatternExpression returns [EObject current=null] : ( ( ( rulePropertyPatternExpression )=>this_PropertyPatternExpression_0= rulePropertyPatternExpression ) | this_ObjectPatternExpression_1= ruleObjectPatternExpression ) ;
    public final EObject rulePatternExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyPatternExpression_0 = null;

        EObject this_ObjectPatternExpression_1 = null;



        	enterRule();

        try {
            // InternalXmu2.g:993:2: ( ( ( ( rulePropertyPatternExpression )=>this_PropertyPatternExpression_0= rulePropertyPatternExpression ) | this_ObjectPatternExpression_1= ruleObjectPatternExpression ) )
            // InternalXmu2.g:994:2: ( ( ( rulePropertyPatternExpression )=>this_PropertyPatternExpression_0= rulePropertyPatternExpression ) | this_ObjectPatternExpression_1= ruleObjectPatternExpression )
            {
            // InternalXmu2.g:994:2: ( ( ( rulePropertyPatternExpression )=>this_PropertyPatternExpression_0= rulePropertyPatternExpression ) | this_ObjectPatternExpression_1= ruleObjectPatternExpression )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_NAME) ) {
                int LA21_1 = input.LA(2);

                if ( (synpred1_InternalXmu2()) ) {
                    alt21=1;
                }
                else if ( (true) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalXmu2.g:995:3: ( ( rulePropertyPatternExpression )=>this_PropertyPatternExpression_0= rulePropertyPatternExpression )
                    {
                    // InternalXmu2.g:995:3: ( ( rulePropertyPatternExpression )=>this_PropertyPatternExpression_0= rulePropertyPatternExpression )
                    // InternalXmu2.g:996:4: ( rulePropertyPatternExpression )=>this_PropertyPatternExpression_0= rulePropertyPatternExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPatternExpressionAccess().getPropertyPatternExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_PropertyPatternExpression_0=rulePropertyPatternExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PropertyPatternExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:1007:3: this_ObjectPatternExpression_1= ruleObjectPatternExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPatternExpressionAccess().getObjectPatternExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ObjectPatternExpression_1=ruleObjectPatternExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ObjectPatternExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternExpression"


    // $ANTLR start "entryRuleObjectPatternExpression"
    // InternalXmu2.g:1019:1: entryRuleObjectPatternExpression returns [EObject current=null] : iv_ruleObjectPatternExpression= ruleObjectPatternExpression EOF ;
    public final EObject entryRuleObjectPatternExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectPatternExpression = null;


        try {
            // InternalXmu2.g:1019:64: (iv_ruleObjectPatternExpression= ruleObjectPatternExpression EOF )
            // InternalXmu2.g:1020:2: iv_ruleObjectPatternExpression= ruleObjectPatternExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectPatternExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleObjectPatternExpression=ruleObjectPatternExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectPatternExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectPatternExpression"


    // $ANTLR start "ruleObjectPatternExpression"
    // InternalXmu2.g:1026:1: ruleObjectPatternExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetNode_6_0= rulePatternNode ) ) ) ;
    public final EObject ruleObjectPatternExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_nullable_5_0=null;
        EObject lv_selector_2_0 = null;

        EObject lv_position_3_0 = null;

        EObject lv_targetNode_6_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1032:2: ( ( () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetNode_6_0= rulePatternNode ) ) ) )
            // InternalXmu2.g:1033:2: ( () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetNode_6_0= rulePatternNode ) ) )
            {
            // InternalXmu2.g:1033:2: ( () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetNode_6_0= rulePatternNode ) ) )
            // InternalXmu2.g:1034:3: () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetNode_6_0= rulePatternNode ) )
            {
            // InternalXmu2.g:1034:3: ()
            // InternalXmu2.g:1035:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getObjectPatternExpressionAccess().getObjectPatternExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalXmu2.g:1041:3: ( (otherlv_1= RULE_NAME ) )
            // InternalXmu2.g:1042:4: (otherlv_1= RULE_NAME )
            {
            // InternalXmu2.g:1042:4: (otherlv_1= RULE_NAME )
            // InternalXmu2.g:1043:5: otherlv_1= RULE_NAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getObjectPatternExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_NAME,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getObjectPatternExpressionAccess().getFeatureEStructuralFeatureCrossReference_1_0());
              				
            }

            }


            }

            // InternalXmu2.g:1054:3: ( (lv_selector_2_0= ruleLoopPath ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                int LA22_1 = input.LA(2);

                if ( ((LA22_1>=52 && LA22_1<=54)) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalXmu2.g:1055:4: (lv_selector_2_0= ruleLoopPath )
                    {
                    // InternalXmu2.g:1055:4: (lv_selector_2_0= ruleLoopPath )
                    // InternalXmu2.g:1056:5: lv_selector_2_0= ruleLoopPath
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getObjectPatternExpressionAccess().getSelectorLoopPathParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    lv_selector_2_0=ruleLoopPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getObjectPatternExpressionRule());
                      					}
                      					set(
                      						current,
                      						"selector",
                      						lv_selector_2_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.LoopPath");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalXmu2.g:1073:3: ( (lv_position_3_0= rulePositionPath ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalXmu2.g:1074:4: (lv_position_3_0= rulePositionPath )
                    {
                    // InternalXmu2.g:1074:4: (lv_position_3_0= rulePositionPath )
                    // InternalXmu2.g:1075:5: lv_position_3_0= rulePositionPath
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getObjectPatternExpressionAccess().getPositionPositionPathParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_29);
                    lv_position_3_0=rulePositionPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getObjectPatternExpressionRule());
                      					}
                      					set(
                      						current,
                      						"position",
                      						lv_position_3_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.PositionPath");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,30,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getObjectPatternExpressionAccess().getEqualsSignKeyword_4());
              		
            }
            // InternalXmu2.g:1096:3: ( (lv_nullable_5_0= '?' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXmu2.g:1097:4: (lv_nullable_5_0= '?' )
                    {
                    // InternalXmu2.g:1097:4: (lv_nullable_5_0= '?' )
                    // InternalXmu2.g:1098:5: lv_nullable_5_0= '?'
                    {
                    lv_nullable_5_0=(Token)match(input,31,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_nullable_5_0, grammarAccess.getObjectPatternExpressionAccess().getNullableQuestionMarkKeyword_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getObjectPatternExpressionRule());
                      					}
                      					setWithLastConsumed(current, "nullable", true, "?");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalXmu2.g:1110:3: ( (lv_targetNode_6_0= rulePatternNode ) )
            // InternalXmu2.g:1111:4: (lv_targetNode_6_0= rulePatternNode )
            {
            // InternalXmu2.g:1111:4: (lv_targetNode_6_0= rulePatternNode )
            // InternalXmu2.g:1112:5: lv_targetNode_6_0= rulePatternNode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getObjectPatternExpressionAccess().getTargetNodePatternNodeParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_targetNode_6_0=rulePatternNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getObjectPatternExpressionRule());
              					}
              					set(
              						current,
              						"targetNode",
              						lv_targetNode_6_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.PatternNode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectPatternExpression"


    // $ANTLR start "entryRulePropertyPatternExpression"
    // InternalXmu2.g:1133:1: entryRulePropertyPatternExpression returns [EObject current=null] : iv_rulePropertyPatternExpression= rulePropertyPatternExpression EOF ;
    public final EObject entryRulePropertyPatternExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyPatternExpression = null;


        try {
            // InternalXmu2.g:1133:66: (iv_rulePropertyPatternExpression= rulePropertyPatternExpression EOF )
            // InternalXmu2.g:1134:2: iv_rulePropertyPatternExpression= rulePropertyPatternExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyPatternExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyPatternExpression=rulePropertyPatternExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyPatternExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyPatternExpression"


    // $ANTLR start "rulePropertyPatternExpression"
    // InternalXmu2.g:1140:1: rulePropertyPatternExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetExpression_6_0= ruleExpression ) ) ) ;
    public final EObject rulePropertyPatternExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_nullable_5_0=null;
        EObject lv_selector_2_0 = null;

        EObject lv_position_3_0 = null;

        EObject lv_targetExpression_6_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1146:2: ( ( () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetExpression_6_0= ruleExpression ) ) ) )
            // InternalXmu2.g:1147:2: ( () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetExpression_6_0= ruleExpression ) ) )
            {
            // InternalXmu2.g:1147:2: ( () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetExpression_6_0= ruleExpression ) ) )
            // InternalXmu2.g:1148:3: () ( (otherlv_1= RULE_NAME ) ) ( (lv_selector_2_0= ruleLoopPath ) )? ( (lv_position_3_0= rulePositionPath ) )? otherlv_4= '=' ( (lv_nullable_5_0= '?' ) )? ( (lv_targetExpression_6_0= ruleExpression ) )
            {
            // InternalXmu2.g:1148:3: ()
            // InternalXmu2.g:1149:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPropertyPatternExpressionAccess().getPropertyPatternExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalXmu2.g:1155:3: ( (otherlv_1= RULE_NAME ) )
            // InternalXmu2.g:1156:4: (otherlv_1= RULE_NAME )
            {
            // InternalXmu2.g:1156:4: (otherlv_1= RULE_NAME )
            // InternalXmu2.g:1157:5: otherlv_1= RULE_NAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyPatternExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_NAME,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getPropertyPatternExpressionAccess().getFeatureEStructuralFeatureCrossReference_1_0());
              				
            }

            }


            }

            // InternalXmu2.g:1168:3: ( (lv_selector_2_0= ruleLoopPath ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                int LA25_1 = input.LA(2);

                if ( ((LA25_1>=52 && LA25_1<=54)) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalXmu2.g:1169:4: (lv_selector_2_0= ruleLoopPath )
                    {
                    // InternalXmu2.g:1169:4: (lv_selector_2_0= ruleLoopPath )
                    // InternalXmu2.g:1170:5: lv_selector_2_0= ruleLoopPath
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyPatternExpressionAccess().getSelectorLoopPathParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    lv_selector_2_0=ruleLoopPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyPatternExpressionRule());
                      					}
                      					set(
                      						current,
                      						"selector",
                      						lv_selector_2_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.LoopPath");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalXmu2.g:1187:3: ( (lv_position_3_0= rulePositionPath ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXmu2.g:1188:4: (lv_position_3_0= rulePositionPath )
                    {
                    // InternalXmu2.g:1188:4: (lv_position_3_0= rulePositionPath )
                    // InternalXmu2.g:1189:5: lv_position_3_0= rulePositionPath
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyPatternExpressionAccess().getPositionPositionPathParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_29);
                    lv_position_3_0=rulePositionPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyPatternExpressionRule());
                      					}
                      					set(
                      						current,
                      						"position",
                      						lv_position_3_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.PositionPath");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,30,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPropertyPatternExpressionAccess().getEqualsSignKeyword_4());
              		
            }
            // InternalXmu2.g:1210:3: ( (lv_nullable_5_0= '?' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==31) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalXmu2.g:1211:4: (lv_nullable_5_0= '?' )
                    {
                    // InternalXmu2.g:1211:4: (lv_nullable_5_0= '?' )
                    // InternalXmu2.g:1212:5: lv_nullable_5_0= '?'
                    {
                    lv_nullable_5_0=(Token)match(input,31,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_nullable_5_0, grammarAccess.getPropertyPatternExpressionAccess().getNullableQuestionMarkKeyword_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPropertyPatternExpressionRule());
                      					}
                      					setWithLastConsumed(current, "nullable", true, "?");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalXmu2.g:1224:3: ( (lv_targetExpression_6_0= ruleExpression ) )
            // InternalXmu2.g:1225:4: (lv_targetExpression_6_0= ruleExpression )
            {
            // InternalXmu2.g:1225:4: (lv_targetExpression_6_0= ruleExpression )
            // InternalXmu2.g:1226:5: lv_targetExpression_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyPatternExpressionAccess().getTargetExpressionExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_targetExpression_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPropertyPatternExpressionRule());
              					}
              					set(
              						current,
              						"targetExpression",
              						lv_targetExpression_6_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyPatternExpression"


    // $ANTLR start "entryRuleLoopPath"
    // InternalXmu2.g:1247:1: entryRuleLoopPath returns [EObject current=null] : iv_ruleLoopPath= ruleLoopPath EOF ;
    public final EObject entryRuleLoopPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopPath = null;


        try {
            // InternalXmu2.g:1247:49: (iv_ruleLoopPath= ruleLoopPath EOF )
            // InternalXmu2.g:1248:2: iv_ruleLoopPath= ruleLoopPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopPathRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoopPath=ruleLoopPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopPath; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopPath"


    // $ANTLR start "ruleLoopPath"
    // InternalXmu2.g:1254:1: ruleLoopPath returns [EObject current=null] : (otherlv_0= '->' ( (lv_operator_1_0= ruleLoopOperator ) ) otherlv_2= '(' ( (lv_variable_3_0= ruleConcreteVariableDeclaration ) ) otherlv_4= '|' ( (lv_body_5_0= ruleExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleLoopPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_operator_1_0 = null;

        EObject lv_variable_3_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1260:2: ( (otherlv_0= '->' ( (lv_operator_1_0= ruleLoopOperator ) ) otherlv_2= '(' ( (lv_variable_3_0= ruleConcreteVariableDeclaration ) ) otherlv_4= '|' ( (lv_body_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            // InternalXmu2.g:1261:2: (otherlv_0= '->' ( (lv_operator_1_0= ruleLoopOperator ) ) otherlv_2= '(' ( (lv_variable_3_0= ruleConcreteVariableDeclaration ) ) otherlv_4= '|' ( (lv_body_5_0= ruleExpression ) ) otherlv_6= ')' )
            {
            // InternalXmu2.g:1261:2: (otherlv_0= '->' ( (lv_operator_1_0= ruleLoopOperator ) ) otherlv_2= '(' ( (lv_variable_3_0= ruleConcreteVariableDeclaration ) ) otherlv_4= '|' ( (lv_body_5_0= ruleExpression ) ) otherlv_6= ')' )
            // InternalXmu2.g:1262:3: otherlv_0= '->' ( (lv_operator_1_0= ruleLoopOperator ) ) otherlv_2= '(' ( (lv_variable_3_0= ruleConcreteVariableDeclaration ) ) otherlv_4= '|' ( (lv_body_5_0= ruleExpression ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLoopPathAccess().getHyphenMinusGreaterThanSignKeyword_0());
              		
            }
            // InternalXmu2.g:1266:3: ( (lv_operator_1_0= ruleLoopOperator ) )
            // InternalXmu2.g:1267:4: (lv_operator_1_0= ruleLoopOperator )
            {
            // InternalXmu2.g:1267:4: (lv_operator_1_0= ruleLoopOperator )
            // InternalXmu2.g:1268:5: lv_operator_1_0= ruleLoopOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopPathAccess().getOperatorLoopOperatorEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_operator_1_0=ruleLoopOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLoopPathRule());
              					}
              					set(
              						current,
              						"operator",
              						lv_operator_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.LoopOperator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLoopPathAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalXmu2.g:1289:3: ( (lv_variable_3_0= ruleConcreteVariableDeclaration ) )
            // InternalXmu2.g:1290:4: (lv_variable_3_0= ruleConcreteVariableDeclaration )
            {
            // InternalXmu2.g:1290:4: (lv_variable_3_0= ruleConcreteVariableDeclaration )
            // InternalXmu2.g:1291:5: lv_variable_3_0= ruleConcreteVariableDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopPathAccess().getVariableConcreteVariableDeclarationParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_variable_3_0=ruleConcreteVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLoopPathRule());
              					}
              					set(
              						current,
              						"variable",
              						lv_variable_3_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.ConcreteVariableDeclaration");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLoopPathAccess().getVerticalLineKeyword_4());
              		
            }
            // InternalXmu2.g:1312:3: ( (lv_body_5_0= ruleExpression ) )
            // InternalXmu2.g:1313:4: (lv_body_5_0= ruleExpression )
            {
            // InternalXmu2.g:1313:4: (lv_body_5_0= ruleExpression )
            // InternalXmu2.g:1314:5: lv_body_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopPathAccess().getBodyExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_body_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLoopPathRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getLoopPathAccess().getRightParenthesisKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopPath"


    // $ANTLR start "entryRulePositionPath"
    // InternalXmu2.g:1339:1: entryRulePositionPath returns [EObject current=null] : iv_rulePositionPath= rulePositionPath EOF ;
    public final EObject entryRulePositionPath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePositionPath = null;


        try {
            // InternalXmu2.g:1339:53: (iv_rulePositionPath= rulePositionPath EOF )
            // InternalXmu2.g:1340:2: iv_rulePositionPath= rulePositionPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPositionPathRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePositionPath=rulePositionPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePositionPath; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePositionPath"


    // $ANTLR start "rulePositionPath"
    // InternalXmu2.g:1346:1: rulePositionPath returns [EObject current=null] : (otherlv_0= '->' ( (lv_type_1_0= rulePositionOperator ) ) otherlv_2= '(' ( (lv_value_3_0= ruleExpression ) )? otherlv_4= ')' ) ;
    public final EObject rulePositionPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1352:2: ( (otherlv_0= '->' ( (lv_type_1_0= rulePositionOperator ) ) otherlv_2= '(' ( (lv_value_3_0= ruleExpression ) )? otherlv_4= ')' ) )
            // InternalXmu2.g:1353:2: (otherlv_0= '->' ( (lv_type_1_0= rulePositionOperator ) ) otherlv_2= '(' ( (lv_value_3_0= ruleExpression ) )? otherlv_4= ')' )
            {
            // InternalXmu2.g:1353:2: (otherlv_0= '->' ( (lv_type_1_0= rulePositionOperator ) ) otherlv_2= '(' ( (lv_value_3_0= ruleExpression ) )? otherlv_4= ')' )
            // InternalXmu2.g:1354:3: otherlv_0= '->' ( (lv_type_1_0= rulePositionOperator ) ) otherlv_2= '(' ( (lv_value_3_0= ruleExpression ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPositionPathAccess().getHyphenMinusGreaterThanSignKeyword_0());
              		
            }
            // InternalXmu2.g:1358:3: ( (lv_type_1_0= rulePositionOperator ) )
            // InternalXmu2.g:1359:4: (lv_type_1_0= rulePositionOperator )
            {
            // InternalXmu2.g:1359:4: (lv_type_1_0= rulePositionOperator )
            // InternalXmu2.g:1360:5: lv_type_1_0= rulePositionOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPositionPathAccess().getTypePositionOperatorEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_type_1_0=rulePositionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPositionPathRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.PositionOperator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPositionPathAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalXmu2.g:1381:3: ( (lv_value_3_0= ruleExpression ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_NAME||(LA28_0>=RULE_INT && LA28_0<=RULE_BOOLEAN)||LA28_0==19||(LA28_0>=58 && LA28_0<=61)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXmu2.g:1382:4: (lv_value_3_0= ruleExpression )
                    {
                    // InternalXmu2.g:1382:4: (lv_value_3_0= ruleExpression )
                    // InternalXmu2.g:1383:5: lv_value_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPositionPathAccess().getValueExpressionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_34);
                    lv_value_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPositionPathRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_3_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPositionPathAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePositionPath"


    // $ANTLR start "entryRuleFeaturePath"
    // InternalXmu2.g:1408:1: entryRuleFeaturePath returns [EObject current=null] : iv_ruleFeaturePath= ruleFeaturePath EOF ;
    public final EObject entryRuleFeaturePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeaturePath = null;


        try {
            // InternalXmu2.g:1408:52: (iv_ruleFeaturePath= ruleFeaturePath EOF )
            // InternalXmu2.g:1409:2: iv_ruleFeaturePath= ruleFeaturePath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeaturePathRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeaturePath=ruleFeaturePath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeaturePath; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeaturePath"


    // $ANTLR start "ruleFeaturePath"
    // InternalXmu2.g:1415:1: ruleFeaturePath returns [EObject current=null] : (otherlv_0= '.' ( (lv_feature_1_0= RULE_NAME ) ) ) ;
    public final EObject ruleFeaturePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_feature_1_0=null;


        	enterRule();

        try {
            // InternalXmu2.g:1421:2: ( (otherlv_0= '.' ( (lv_feature_1_0= RULE_NAME ) ) ) )
            // InternalXmu2.g:1422:2: (otherlv_0= '.' ( (lv_feature_1_0= RULE_NAME ) ) )
            {
            // InternalXmu2.g:1422:2: (otherlv_0= '.' ( (lv_feature_1_0= RULE_NAME ) ) )
            // InternalXmu2.g:1423:3: otherlv_0= '.' ( (lv_feature_1_0= RULE_NAME ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFeaturePathAccess().getFullStopKeyword_0());
              		
            }
            // InternalXmu2.g:1427:3: ( (lv_feature_1_0= RULE_NAME ) )
            // InternalXmu2.g:1428:4: (lv_feature_1_0= RULE_NAME )
            {
            // InternalXmu2.g:1428:4: (lv_feature_1_0= RULE_NAME )
            // InternalXmu2.g:1429:5: lv_feature_1_0= RULE_NAME
            {
            lv_feature_1_0=(Token)match(input,RULE_NAME,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_feature_1_0, grammarAccess.getFeaturePathAccess().getFeatureNAMETerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFeaturePathRule());
              					}
              					setWithLastConsumed(
              						current,
              						"feature",
              						lv_feature_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeaturePath"


    // $ANTLR start "entryRuleOperationPath"
    // InternalXmu2.g:1449:1: entryRuleOperationPath returns [EObject current=null] : iv_ruleOperationPath= ruleOperationPath EOF ;
    public final EObject entryRuleOperationPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationPath = null;


        try {
            // InternalXmu2.g:1449:54: (iv_ruleOperationPath= ruleOperationPath EOF )
            // InternalXmu2.g:1450:2: iv_ruleOperationPath= ruleOperationPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationPathRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperationPath=ruleOperationPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationPath; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationPath"


    // $ANTLR start "ruleOperationPath"
    // InternalXmu2.g:1456:1: ruleOperationPath returns [EObject current=null] : (otherlv_0= '.' ( (lv_operation_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleOperationPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_operation_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1462:2: ( (otherlv_0= '.' ( (lv_operation_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalXmu2.g:1463:2: (otherlv_0= '.' ( (lv_operation_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalXmu2.g:1463:2: (otherlv_0= '.' ( (lv_operation_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalXmu2.g:1464:3: otherlv_0= '.' ( (lv_operation_1_0= RULE_NAME ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getOperationPathAccess().getFullStopKeyword_0());
              		
            }
            // InternalXmu2.g:1468:3: ( (lv_operation_1_0= RULE_NAME ) )
            // InternalXmu2.g:1469:4: (lv_operation_1_0= RULE_NAME )
            {
            // InternalXmu2.g:1469:4: (lv_operation_1_0= RULE_NAME )
            // InternalXmu2.g:1470:5: lv_operation_1_0= RULE_NAME
            {
            lv_operation_1_0=(Token)match(input,RULE_NAME,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_operation_1_0, grammarAccess.getOperationPathAccess().getOperationNAMETerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOperationPathRule());
              					}
              					setWithLastConsumed(
              						current,
              						"operation",
              						lv_operation_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getOperationPathAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalXmu2.g:1490:3: ( ( (lv_parameters_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_NAME||(LA30_0>=RULE_INT && LA30_0<=RULE_BOOLEAN)||LA30_0==19||(LA30_0>=58 && LA30_0<=61)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalXmu2.g:1491:4: ( (lv_parameters_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) ) )*
                    {
                    // InternalXmu2.g:1491:4: ( (lv_parameters_3_0= ruleExpression ) )
                    // InternalXmu2.g:1492:5: (lv_parameters_3_0= ruleExpression )
                    {
                    // InternalXmu2.g:1492:5: (lv_parameters_3_0= ruleExpression )
                    // InternalXmu2.g:1493:6: lv_parameters_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationPathAccess().getParametersExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_parameters_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOperationPathRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_3_0,
                      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalXmu2.g:1510:4: (otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==20) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalXmu2.g:1511:5: otherlv_4= ',' ( (lv_parameters_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getOperationPathAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalXmu2.g:1515:5: ( (lv_parameters_5_0= ruleExpression ) )
                    	    // InternalXmu2.g:1516:6: (lv_parameters_5_0= ruleExpression )
                    	    {
                    	    // InternalXmu2.g:1516:6: (lv_parameters_5_0= ruleExpression )
                    	    // InternalXmu2.g:1517:7: lv_parameters_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOperationPathAccess().getParametersExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_parameters_5_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getOperationPathRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_5_0,
                    	      								"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getOperationPathAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationPath"


    // $ANTLR start "entryRuleVariableExpression"
    // InternalXmu2.g:1544:1: entryRuleVariableExpression returns [EObject current=null] : iv_ruleVariableExpression= ruleVariableExpression EOF ;
    public final EObject entryRuleVariableExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableExpression = null;


        try {
            // InternalXmu2.g:1544:59: (iv_ruleVariableExpression= ruleVariableExpression EOF )
            // InternalXmu2.g:1545:2: iv_ruleVariableExpression= ruleVariableExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableExpression=ruleVariableExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableExpression"


    // $ANTLR start "ruleVariableExpression"
    // InternalXmu2.g:1551:1: ruleVariableExpression returns [EObject current=null] : ( (lv_variable_0_0= RULE_NAME ) ) ;
    public final EObject ruleVariableExpression() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;


        	enterRule();

        try {
            // InternalXmu2.g:1557:2: ( ( (lv_variable_0_0= RULE_NAME ) ) )
            // InternalXmu2.g:1558:2: ( (lv_variable_0_0= RULE_NAME ) )
            {
            // InternalXmu2.g:1558:2: ( (lv_variable_0_0= RULE_NAME ) )
            // InternalXmu2.g:1559:3: (lv_variable_0_0= RULE_NAME )
            {
            // InternalXmu2.g:1559:3: (lv_variable_0_0= RULE_NAME )
            // InternalXmu2.g:1560:4: lv_variable_0_0= RULE_NAME
            {
            lv_variable_0_0=(Token)match(input,RULE_NAME,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_variable_0_0, grammarAccess.getVariableExpressionAccess().getVariableNAMETerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getVariableExpressionRule());
              				}
              				setWithLastConsumed(
              					current,
              					"variable",
              					lv_variable_0_0,
              					"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableExpression"


    // $ANTLR start "entryRulePath"
    // InternalXmu2.g:1579:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalXmu2.g:1579:45: (iv_rulePath= rulePath EOF )
            // InternalXmu2.g:1580:2: iv_rulePath= rulePath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePath; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalXmu2.g:1586:1: rulePath returns [EObject current=null] : ( ( ( ruleLoopPath )=>this_LoopPath_0= ruleLoopPath ) | this_PositionPath_1= rulePositionPath | ( ( ruleFeaturePath )=>this_FeaturePath_2= ruleFeaturePath ) | this_OperationPath_3= ruleOperationPath ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        EObject this_LoopPath_0 = null;

        EObject this_PositionPath_1 = null;

        EObject this_FeaturePath_2 = null;

        EObject this_OperationPath_3 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1592:2: ( ( ( ( ruleLoopPath )=>this_LoopPath_0= ruleLoopPath ) | this_PositionPath_1= rulePositionPath | ( ( ruleFeaturePath )=>this_FeaturePath_2= ruleFeaturePath ) | this_OperationPath_3= ruleOperationPath ) )
            // InternalXmu2.g:1593:2: ( ( ( ruleLoopPath )=>this_LoopPath_0= ruleLoopPath ) | this_PositionPath_1= rulePositionPath | ( ( ruleFeaturePath )=>this_FeaturePath_2= ruleFeaturePath ) | this_OperationPath_3= ruleOperationPath )
            {
            // InternalXmu2.g:1593:2: ( ( ( ruleLoopPath )=>this_LoopPath_0= ruleLoopPath ) | this_PositionPath_1= rulePositionPath | ( ( ruleFeaturePath )=>this_FeaturePath_2= ruleFeaturePath ) | this_OperationPath_3= ruleOperationPath )
            int alt31=4;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // InternalXmu2.g:1594:3: ( ( ruleLoopPath )=>this_LoopPath_0= ruleLoopPath )
                    {
                    // InternalXmu2.g:1594:3: ( ( ruleLoopPath )=>this_LoopPath_0= ruleLoopPath )
                    // InternalXmu2.g:1595:4: ( ruleLoopPath )=>this_LoopPath_0= ruleLoopPath
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPathAccess().getLoopPathParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_LoopPath_0=ruleLoopPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LoopPath_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:1606:3: this_PositionPath_1= rulePositionPath
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPathAccess().getPositionPathParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PositionPath_1=rulePositionPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PositionPath_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalXmu2.g:1615:3: ( ( ruleFeaturePath )=>this_FeaturePath_2= ruleFeaturePath )
                    {
                    // InternalXmu2.g:1615:3: ( ( ruleFeaturePath )=>this_FeaturePath_2= ruleFeaturePath )
                    // InternalXmu2.g:1616:4: ( ruleFeaturePath )=>this_FeaturePath_2= ruleFeaturePath
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPathAccess().getFeaturePathParserRuleCall_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_FeaturePath_2=ruleFeaturePath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_FeaturePath_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXmu2.g:1627:3: this_OperationPath_3= ruleOperationPath
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPathAccess().getOperationPathParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_OperationPath_3=ruleOperationPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OperationPath_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleEmptyExpression"
    // InternalXmu2.g:1639:1: entryRuleEmptyExpression returns [EObject current=null] : iv_ruleEmptyExpression= ruleEmptyExpression EOF ;
    public final EObject entryRuleEmptyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyExpression = null;


        try {
            // InternalXmu2.g:1639:56: (iv_ruleEmptyExpression= ruleEmptyExpression EOF )
            // InternalXmu2.g:1640:2: iv_ruleEmptyExpression= ruleEmptyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEmptyExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEmptyExpression=ruleEmptyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEmptyExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEmptyExpression"


    // $ANTLR start "ruleEmptyExpression"
    // InternalXmu2.g:1646:1: ruleEmptyExpression returns [EObject current=null] : ( (lv_type_0_0= ruleEmptyValue ) ) ;
    public final EObject ruleEmptyExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1652:2: ( ( (lv_type_0_0= ruleEmptyValue ) ) )
            // InternalXmu2.g:1653:2: ( (lv_type_0_0= ruleEmptyValue ) )
            {
            // InternalXmu2.g:1653:2: ( (lv_type_0_0= ruleEmptyValue ) )
            // InternalXmu2.g:1654:3: (lv_type_0_0= ruleEmptyValue )
            {
            // InternalXmu2.g:1654:3: (lv_type_0_0= ruleEmptyValue )
            // InternalXmu2.g:1655:4: lv_type_0_0= ruleEmptyValue
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getEmptyExpressionAccess().getTypeEmptyValueEnumRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_type_0_0=ruleEmptyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getEmptyExpressionRule());
              				}
              				set(
              					current,
              					"type",
              					lv_type_0_0,
              					"edu.ustb.sei.mde.xmuxtext.Xmu2.EmptyValue");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEmptyExpression"


    // $ANTLR start "entryRuleStringLiteralExpression"
    // InternalXmu2.g:1675:1: entryRuleStringLiteralExpression returns [EObject current=null] : iv_ruleStringLiteralExpression= ruleStringLiteralExpression EOF ;
    public final EObject entryRuleStringLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpression = null;


        try {
            // InternalXmu2.g:1675:64: (iv_ruleStringLiteralExpression= ruleStringLiteralExpression EOF )
            // InternalXmu2.g:1676:2: iv_ruleStringLiteralExpression= ruleStringLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteralExpression=ruleStringLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteralExpression"


    // $ANTLR start "ruleStringLiteralExpression"
    // InternalXmu2.g:1682:1: ruleStringLiteralExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalXmu2.g:1688:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalXmu2.g:1689:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalXmu2.g:1689:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalXmu2.g:1690:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalXmu2.g:1690:3: (lv_value_0_0= RULE_STRING )
            // InternalXmu2.g:1691:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralExpressionAccess().getValueSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getStringLiteralExpressionRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"edu.ustb.sei.mde.xmuxtext.Xmu2.STRING");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteralExpression"


    // $ANTLR start "entryRuleIntegerLiteralExpression"
    // InternalXmu2.g:1710:1: entryRuleIntegerLiteralExpression returns [EObject current=null] : iv_ruleIntegerLiteralExpression= ruleIntegerLiteralExpression EOF ;
    public final EObject entryRuleIntegerLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralExpression = null;


        try {
            // InternalXmu2.g:1710:65: (iv_ruleIntegerLiteralExpression= ruleIntegerLiteralExpression EOF )
            // InternalXmu2.g:1711:2: iv_ruleIntegerLiteralExpression= ruleIntegerLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerLiteralExpression=ruleIntegerLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerLiteralExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerLiteralExpression"


    // $ANTLR start "ruleIntegerLiteralExpression"
    // InternalXmu2.g:1717:1: ruleIntegerLiteralExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalXmu2.g:1723:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalXmu2.g:1724:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalXmu2.g:1724:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalXmu2.g:1725:3: (lv_value_0_0= RULE_INT )
            {
            // InternalXmu2.g:1725:3: (lv_value_0_0= RULE_INT )
            // InternalXmu2.g:1726:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getIntegerLiteralExpressionAccess().getValueINTTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getIntegerLiteralExpressionRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"edu.ustb.sei.mde.xmuxtext.Xmu2.INT");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerLiteralExpression"


    // $ANTLR start "entryRuleBooleanLiteralExpression"
    // InternalXmu2.g:1745:1: entryRuleBooleanLiteralExpression returns [EObject current=null] : iv_ruleBooleanLiteralExpression= ruleBooleanLiteralExpression EOF ;
    public final EObject entryRuleBooleanLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpression = null;


        try {
            // InternalXmu2.g:1745:65: (iv_ruleBooleanLiteralExpression= ruleBooleanLiteralExpression EOF )
            // InternalXmu2.g:1746:2: iv_ruleBooleanLiteralExpression= ruleBooleanLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteralExpression=ruleBooleanLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteralExpression"


    // $ANTLR start "ruleBooleanLiteralExpression"
    // InternalXmu2.g:1752:1: ruleBooleanLiteralExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBooleanLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalXmu2.g:1758:2: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // InternalXmu2.g:1759:2: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // InternalXmu2.g:1759:2: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // InternalXmu2.g:1760:3: (lv_value_0_0= RULE_BOOLEAN )
            {
            // InternalXmu2.g:1760:3: (lv_value_0_0= RULE_BOOLEAN )
            // InternalXmu2.g:1761:4: lv_value_0_0= RULE_BOOLEAN
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getBooleanLiteralExpressionAccess().getValueBOOLEANTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBooleanLiteralExpressionRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"edu.ustb.sei.mde.xmuxtext.Xmu2.BOOLEAN");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteralExpression"


    // $ANTLR start "entryRuleEnumLiteralExpression"
    // InternalXmu2.g:1780:1: entryRuleEnumLiteralExpression returns [EObject current=null] : iv_ruleEnumLiteralExpression= ruleEnumLiteralExpression EOF ;
    public final EObject entryRuleEnumLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralExpression = null;


        try {
            // InternalXmu2.g:1780:62: (iv_ruleEnumLiteralExpression= ruleEnumLiteralExpression EOF )
            // InternalXmu2.g:1781:2: iv_ruleEnumLiteralExpression= ruleEnumLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteralExpression=ruleEnumLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumLiteralExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteralExpression"


    // $ANTLR start "ruleEnumLiteralExpression"
    // InternalXmu2.g:1787:1: ruleEnumLiteralExpression returns [EObject current=null] : ( ( ( ruleType ) ) otherlv_1= '::' ( (otherlv_2= RULE_NAME ) ) ) ;
    public final EObject ruleEnumLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalXmu2.g:1793:2: ( ( ( ( ruleType ) ) otherlv_1= '::' ( (otherlv_2= RULE_NAME ) ) ) )
            // InternalXmu2.g:1794:2: ( ( ( ruleType ) ) otherlv_1= '::' ( (otherlv_2= RULE_NAME ) ) )
            {
            // InternalXmu2.g:1794:2: ( ( ( ruleType ) ) otherlv_1= '::' ( (otherlv_2= RULE_NAME ) ) )
            // InternalXmu2.g:1795:3: ( ( ruleType ) ) otherlv_1= '::' ( (otherlv_2= RULE_NAME ) )
            {
            // InternalXmu2.g:1795:3: ( ( ruleType ) )
            // InternalXmu2.g:1796:4: ( ruleType )
            {
            // InternalXmu2.g:1796:4: ( ruleType )
            // InternalXmu2.g:1797:5: ruleType
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumLiteralExpressionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumLiteralExpressionAccess().getTypeEEnumCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_37);
            ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEnumLiteralExpressionAccess().getColonColonKeyword_1());
              		
            }
            // InternalXmu2.g:1815:3: ( (otherlv_2= RULE_NAME ) )
            // InternalXmu2.g:1816:4: (otherlv_2= RULE_NAME )
            {
            // InternalXmu2.g:1816:4: (otherlv_2= RULE_NAME )
            // InternalXmu2.g:1817:5: otherlv_2= RULE_NAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumLiteralExpressionRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_NAME,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getEnumLiteralExpressionAccess().getValueEEnumLiteralCrossReference_2_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiteralExpression"


    // $ANTLR start "entryRuleObjectURIExpression"
    // InternalXmu2.g:1832:1: entryRuleObjectURIExpression returns [EObject current=null] : iv_ruleObjectURIExpression= ruleObjectURIExpression EOF ;
    public final EObject entryRuleObjectURIExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectURIExpression = null;


        try {
            // InternalXmu2.g:1832:60: (iv_ruleObjectURIExpression= ruleObjectURIExpression EOF )
            // InternalXmu2.g:1833:2: iv_ruleObjectURIExpression= ruleObjectURIExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectURIExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleObjectURIExpression=ruleObjectURIExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectURIExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectURIExpression"


    // $ANTLR start "ruleObjectURIExpression"
    // InternalXmu2.g:1839:1: ruleObjectURIExpression returns [EObject current=null] : ( (otherlv_0= RULE_OBJ_URI ) ) ;
    public final EObject ruleObjectURIExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalXmu2.g:1845:2: ( ( (otherlv_0= RULE_OBJ_URI ) ) )
            // InternalXmu2.g:1846:2: ( (otherlv_0= RULE_OBJ_URI ) )
            {
            // InternalXmu2.g:1846:2: ( (otherlv_0= RULE_OBJ_URI ) )
            // InternalXmu2.g:1847:3: (otherlv_0= RULE_OBJ_URI )
            {
            // InternalXmu2.g:1847:3: (otherlv_0= RULE_OBJ_URI )
            // InternalXmu2.g:1848:4: otherlv_0= RULE_OBJ_URI
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getObjectURIExpressionRule());
              				}
              			
            }
            otherlv_0=(Token)match(input,RULE_OBJ_URI,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_0, grammarAccess.getObjectURIExpressionAccess().getObjectEObjectCrossReference_0());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectURIExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalXmu2.g:1862:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalXmu2.g:1862:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalXmu2.g:1863:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalXmu2.g:1869:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_operator_0_0= ruleUnaryOperator ) ) ( (lv_body_1_0= ruleUnaryExpressionChild ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_body_1_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1875:2: ( ( ( (lv_operator_0_0= ruleUnaryOperator ) ) ( (lv_body_1_0= ruleUnaryExpressionChild ) ) ) )
            // InternalXmu2.g:1876:2: ( ( (lv_operator_0_0= ruleUnaryOperator ) ) ( (lv_body_1_0= ruleUnaryExpressionChild ) ) )
            {
            // InternalXmu2.g:1876:2: ( ( (lv_operator_0_0= ruleUnaryOperator ) ) ( (lv_body_1_0= ruleUnaryExpressionChild ) ) )
            // InternalXmu2.g:1877:3: ( (lv_operator_0_0= ruleUnaryOperator ) ) ( (lv_body_1_0= ruleUnaryExpressionChild ) )
            {
            // InternalXmu2.g:1877:3: ( (lv_operator_0_0= ruleUnaryOperator ) )
            // InternalXmu2.g:1878:4: (lv_operator_0_0= ruleUnaryOperator )
            {
            // InternalXmu2.g:1878:4: (lv_operator_0_0= ruleUnaryOperator )
            // InternalXmu2.g:1879:5: lv_operator_0_0= ruleUnaryOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_operator_0_0=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
              					}
              					set(
              						current,
              						"operator",
              						lv_operator_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.UnaryOperator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:1896:3: ( (lv_body_1_0= ruleUnaryExpressionChild ) )
            // InternalXmu2.g:1897:4: (lv_body_1_0= ruleUnaryExpressionChild )
            {
            // InternalXmu2.g:1897:4: (lv_body_1_0= ruleUnaryExpressionChild )
            // InternalXmu2.g:1898:5: lv_body_1_0= ruleUnaryExpressionChild
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getBodyUnaryExpressionChildParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_1_0=ruleUnaryExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.UnaryExpressionChild");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleUnaryExpressionChild"
    // InternalXmu2.g:1919:1: entryRuleUnaryExpressionChild returns [EObject current=null] : iv_ruleUnaryExpressionChild= ruleUnaryExpressionChild EOF ;
    public final EObject entryRuleUnaryExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpressionChild = null;


        try {
            // InternalXmu2.g:1919:61: (iv_ruleUnaryExpressionChild= ruleUnaryExpressionChild EOF )
            // InternalXmu2.g:1920:2: iv_ruleUnaryExpressionChild= ruleUnaryExpressionChild EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionChildRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpressionChild=ruleUnaryExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpressionChild; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpressionChild"


    // $ANTLR start "ruleUnaryExpressionChild"
    // InternalXmu2.g:1926:1: ruleUnaryExpressionChild returns [EObject current=null] : (this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_path_2_0= rulePath ) ) ( (lv_path_3_0= rulePath ) )* )? ) ;
    public final EObject ruleUnaryExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicExpression_0 = null;

        EObject lv_path_2_0 = null;

        EObject lv_path_3_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:1932:2: ( (this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_path_2_0= rulePath ) ) ( (lv_path_3_0= rulePath ) )* )? ) )
            // InternalXmu2.g:1933:2: (this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_path_2_0= rulePath ) ) ( (lv_path_3_0= rulePath ) )* )? )
            {
            // InternalXmu2.g:1933:2: (this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_path_2_0= rulePath ) ) ( (lv_path_3_0= rulePath ) )* )? )
            // InternalXmu2.g:1934:3: this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_path_2_0= rulePath ) ) ( (lv_path_3_0= rulePath ) )* )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getUnaryExpressionChildAccess().getAtomicExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_AtomicExpression_0=ruleAtomicExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AtomicExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalXmu2.g:1942:3: ( () ( (lv_path_2_0= rulePath ) ) ( (lv_path_3_0= rulePath ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==32) ) {
                int LA33_1 = input.LA(2);

                if ( ((LA33_1>=52 && LA33_1<=57)) ) {
                    alt33=1;
                }
            }
            else if ( (LA33_0==34) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXmu2.g:1943:4: () ( (lv_path_2_0= rulePath ) ) ( (lv_path_3_0= rulePath ) )*
                    {
                    // InternalXmu2.g:1943:4: ()
                    // InternalXmu2.g:1944:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getUnaryExpressionChildAccess().getPathExpressionHostAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalXmu2.g:1950:4: ( (lv_path_2_0= rulePath ) )
                    // InternalXmu2.g:1951:5: (lv_path_2_0= rulePath )
                    {
                    // InternalXmu2.g:1951:5: (lv_path_2_0= rulePath )
                    // InternalXmu2.g:1952:6: lv_path_2_0= rulePath
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionChildAccess().getPathPathParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_38);
                    lv_path_2_0=rulePath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionChildRule());
                      						}
                      						add(
                      							current,
                      							"path",
                      							lv_path_2_0,
                      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Path");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalXmu2.g:1969:4: ( (lv_path_3_0= rulePath ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==32) ) {
                            int LA32_2 = input.LA(2);

                            if ( ((LA32_2>=52 && LA32_2<=57)) ) {
                                alt32=1;
                            }


                        }
                        else if ( (LA32_0==34) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalXmu2.g:1970:5: (lv_path_3_0= rulePath )
                    	    {
                    	    // InternalXmu2.g:1970:5: (lv_path_3_0= rulePath )
                    	    // InternalXmu2.g:1971:6: lv_path_3_0= rulePath
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getUnaryExpressionChildAccess().getPathPathParserRuleCall_1_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_38);
                    	    lv_path_3_0=rulePath();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getUnaryExpressionChildRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"path",
                    	      							lv_path_3_0,
                    	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Path");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpressionChild"


    // $ANTLR start "entryRuleAtomicExpression"
    // InternalXmu2.g:1993:1: entryRuleAtomicExpression returns [EObject current=null] : iv_ruleAtomicExpression= ruleAtomicExpression EOF ;
    public final EObject entryRuleAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpression = null;


        try {
            // InternalXmu2.g:1993:57: (iv_ruleAtomicExpression= ruleAtomicExpression EOF )
            // InternalXmu2.g:1994:2: iv_ruleAtomicExpression= ruleAtomicExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomicExpression=ruleAtomicExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExpression"


    // $ANTLR start "ruleAtomicExpression"
    // InternalXmu2.g:2000:1: ruleAtomicExpression returns [EObject current=null] : ( (otherlv_0= '(' () ( (lv_body_2_0= ruleExpression ) ) otherlv_3= ')' ) | this_VariableExpression_4= ruleVariableExpression | this_ConstantExpression_5= ruleConstantExpression ) ;
    public final EObject ruleAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;

        EObject this_VariableExpression_4 = null;

        EObject this_ConstantExpression_5 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2006:2: ( ( (otherlv_0= '(' () ( (lv_body_2_0= ruleExpression ) ) otherlv_3= ')' ) | this_VariableExpression_4= ruleVariableExpression | this_ConstantExpression_5= ruleConstantExpression ) )
            // InternalXmu2.g:2007:2: ( (otherlv_0= '(' () ( (lv_body_2_0= ruleExpression ) ) otherlv_3= ')' ) | this_VariableExpression_4= ruleVariableExpression | this_ConstantExpression_5= ruleConstantExpression )
            {
            // InternalXmu2.g:2007:2: ( (otherlv_0= '(' () ( (lv_body_2_0= ruleExpression ) ) otherlv_3= ')' ) | this_VariableExpression_4= ruleVariableExpression | this_ConstantExpression_5= ruleConstantExpression )
            int alt34=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt34=1;
                }
                break;
            case RULE_NAME:
                {
                alt34=2;
                }
                break;
            case RULE_INT:
            case RULE_OBJ_URI:
            case RULE_PRIMITIVE_TYPE:
            case RULE_PATH_NAME:
            case RULE_STRING:
            case RULE_BOOLEAN:
            case 58:
            case 59:
                {
                alt34=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalXmu2.g:2008:3: (otherlv_0= '(' () ( (lv_body_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalXmu2.g:2008:3: (otherlv_0= '(' () ( (lv_body_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalXmu2.g:2009:4: otherlv_0= '(' () ( (lv_body_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getAtomicExpressionAccess().getLeftParenthesisKeyword_0_0());
                      			
                    }
                    // InternalXmu2.g:2013:4: ()
                    // InternalXmu2.g:2014:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getParenExpressionAction_0_1(),
                      						current);
                      				
                    }

                    }

                    // InternalXmu2.g:2020:4: ( (lv_body_2_0= ruleExpression ) )
                    // InternalXmu2.g:2021:5: (lv_body_2_0= ruleExpression )
                    {
                    // InternalXmu2.g:2021:5: (lv_body_2_0= ruleExpression )
                    // InternalXmu2.g:2022:6: lv_body_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getBodyExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
                    lv_body_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                      						}
                      						set(
                      							current,
                      							"body",
                      							lv_body_2_0,
                      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAtomicExpressionAccess().getRightParenthesisKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:2045:3: this_VariableExpression_4= ruleVariableExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicExpressionAccess().getVariableExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableExpression_4=ruleVariableExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalXmu2.g:2054:3: this_ConstantExpression_5= ruleConstantExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicExpressionAccess().getConstantExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConstantExpression_5=ruleConstantExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstantExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExpression"


    // $ANTLR start "entryRuleConstantExpression"
    // InternalXmu2.g:2066:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalXmu2.g:2066:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalXmu2.g:2067:2: iv_ruleConstantExpression= ruleConstantExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstantExpression=ruleConstantExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantExpression"


    // $ANTLR start "ruleConstantExpression"
    // InternalXmu2.g:2073:1: ruleConstantExpression returns [EObject current=null] : (this_EmptyExpression_0= ruleEmptyExpression | this_StringLiteralExpression_1= ruleStringLiteralExpression | this_IntegerLiteralExpression_2= ruleIntegerLiteralExpression | this_BooleanLiteralExpression_3= ruleBooleanLiteralExpression | this_EnumLiteralExpression_4= ruleEnumLiteralExpression | this_ObjectURIExpression_5= ruleObjectURIExpression ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EmptyExpression_0 = null;

        EObject this_StringLiteralExpression_1 = null;

        EObject this_IntegerLiteralExpression_2 = null;

        EObject this_BooleanLiteralExpression_3 = null;

        EObject this_EnumLiteralExpression_4 = null;

        EObject this_ObjectURIExpression_5 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2079:2: ( (this_EmptyExpression_0= ruleEmptyExpression | this_StringLiteralExpression_1= ruleStringLiteralExpression | this_IntegerLiteralExpression_2= ruleIntegerLiteralExpression | this_BooleanLiteralExpression_3= ruleBooleanLiteralExpression | this_EnumLiteralExpression_4= ruleEnumLiteralExpression | this_ObjectURIExpression_5= ruleObjectURIExpression ) )
            // InternalXmu2.g:2080:2: (this_EmptyExpression_0= ruleEmptyExpression | this_StringLiteralExpression_1= ruleStringLiteralExpression | this_IntegerLiteralExpression_2= ruleIntegerLiteralExpression | this_BooleanLiteralExpression_3= ruleBooleanLiteralExpression | this_EnumLiteralExpression_4= ruleEnumLiteralExpression | this_ObjectURIExpression_5= ruleObjectURIExpression )
            {
            // InternalXmu2.g:2080:2: (this_EmptyExpression_0= ruleEmptyExpression | this_StringLiteralExpression_1= ruleStringLiteralExpression | this_IntegerLiteralExpression_2= ruleIntegerLiteralExpression | this_BooleanLiteralExpression_3= ruleBooleanLiteralExpression | this_EnumLiteralExpression_4= ruleEnumLiteralExpression | this_ObjectURIExpression_5= ruleObjectURIExpression )
            int alt35=6;
            switch ( input.LA(1) ) {
            case 58:
            case 59:
                {
                alt35=1;
                }
                break;
            case RULE_STRING:
                {
                alt35=2;
                }
                break;
            case RULE_INT:
                {
                alt35=3;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt35=4;
                }
                break;
            case RULE_PRIMITIVE_TYPE:
            case RULE_PATH_NAME:
                {
                alt35=5;
                }
                break;
            case RULE_OBJ_URI:
                {
                alt35=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalXmu2.g:2081:3: this_EmptyExpression_0= ruleEmptyExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantExpressionAccess().getEmptyExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EmptyExpression_0=ruleEmptyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EmptyExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalXmu2.g:2090:3: this_StringLiteralExpression_1= ruleStringLiteralExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantExpressionAccess().getStringLiteralExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteralExpression_1=ruleStringLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteralExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalXmu2.g:2099:3: this_IntegerLiteralExpression_2= ruleIntegerLiteralExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantExpressionAccess().getIntegerLiteralExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntegerLiteralExpression_2=ruleIntegerLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntegerLiteralExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalXmu2.g:2108:3: this_BooleanLiteralExpression_3= ruleBooleanLiteralExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantExpressionAccess().getBooleanLiteralExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteralExpression_3=ruleBooleanLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanLiteralExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalXmu2.g:2117:3: this_EnumLiteralExpression_4= ruleEnumLiteralExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantExpressionAccess().getEnumLiteralExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EnumLiteralExpression_4=ruleEnumLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EnumLiteralExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalXmu2.g:2126:3: this_ObjectURIExpression_5= ruleObjectURIExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConstantExpressionAccess().getObjectURIExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ObjectURIExpression_5=ruleObjectURIExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ObjectURIExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalXmu2.g:2138:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalXmu2.g:2138:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalXmu2.g:2139:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalXmu2.g:2145:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_operands_0_0= ruleMultiplicativeExpressionChild ) ) ( ( (lv_operators_1_0= ruleMultiplicativeOperator ) ) ( (lv_operands_2_0= ruleMultiplicativeExpressionChild ) ) )+ ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operands_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2151:2: ( ( ( (lv_operands_0_0= ruleMultiplicativeExpressionChild ) ) ( ( (lv_operators_1_0= ruleMultiplicativeOperator ) ) ( (lv_operands_2_0= ruleMultiplicativeExpressionChild ) ) )+ ) )
            // InternalXmu2.g:2152:2: ( ( (lv_operands_0_0= ruleMultiplicativeExpressionChild ) ) ( ( (lv_operators_1_0= ruleMultiplicativeOperator ) ) ( (lv_operands_2_0= ruleMultiplicativeExpressionChild ) ) )+ )
            {
            // InternalXmu2.g:2152:2: ( ( (lv_operands_0_0= ruleMultiplicativeExpressionChild ) ) ( ( (lv_operators_1_0= ruleMultiplicativeOperator ) ) ( (lv_operands_2_0= ruleMultiplicativeExpressionChild ) ) )+ )
            // InternalXmu2.g:2153:3: ( (lv_operands_0_0= ruleMultiplicativeExpressionChild ) ) ( ( (lv_operators_1_0= ruleMultiplicativeOperator ) ) ( (lv_operands_2_0= ruleMultiplicativeExpressionChild ) ) )+
            {
            // InternalXmu2.g:2153:3: ( (lv_operands_0_0= ruleMultiplicativeExpressionChild ) )
            // InternalXmu2.g:2154:4: (lv_operands_0_0= ruleMultiplicativeExpressionChild )
            {
            // InternalXmu2.g:2154:4: (lv_operands_0_0= ruleMultiplicativeExpressionChild )
            // InternalXmu2.g:2155:5: lv_operands_0_0= ruleMultiplicativeExpressionChild
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandsMultiplicativeExpressionChildParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_39);
            lv_operands_0_0=ruleMultiplicativeExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
              					}
              					add(
              						current,
              						"operands",
              						lv_operands_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.MultiplicativeExpressionChild");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:2172:3: ( ( (lv_operators_1_0= ruleMultiplicativeOperator ) ) ( (lv_operands_2_0= ruleMultiplicativeExpressionChild ) ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=62 && LA36_0<=63)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalXmu2.g:2173:4: ( (lv_operators_1_0= ruleMultiplicativeOperator ) ) ( (lv_operands_2_0= ruleMultiplicativeExpressionChild ) )
            	    {
            	    // InternalXmu2.g:2173:4: ( (lv_operators_1_0= ruleMultiplicativeOperator ) )
            	    // InternalXmu2.g:2174:5: (lv_operators_1_0= ruleMultiplicativeOperator )
            	    {
            	    // InternalXmu2.g:2174:5: (lv_operators_1_0= ruleMultiplicativeOperator )
            	    // InternalXmu2.g:2175:6: lv_operators_1_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorsMultiplicativeOperatorEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_operators_1_0=ruleMultiplicativeOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operators",
            	      							lv_operators_1_0,
            	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.MultiplicativeOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalXmu2.g:2192:4: ( (lv_operands_2_0= ruleMultiplicativeExpressionChild ) )
            	    // InternalXmu2.g:2193:5: (lv_operands_2_0= ruleMultiplicativeExpressionChild )
            	    {
            	    // InternalXmu2.g:2193:5: (lv_operands_2_0= ruleMultiplicativeExpressionChild )
            	    // InternalXmu2.g:2194:6: lv_operands_2_0= ruleMultiplicativeExpressionChild
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperandsMultiplicativeExpressionChildParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_operands_2_0=ruleMultiplicativeExpressionChild();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operands",
            	      							lv_operands_2_0,
            	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.MultiplicativeExpressionChild");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleMultiplicativeExpressionChild"
    // InternalXmu2.g:2216:1: entryRuleMultiplicativeExpressionChild returns [EObject current=null] : iv_ruleMultiplicativeExpressionChild= ruleMultiplicativeExpressionChild EOF ;
    public final EObject entryRuleMultiplicativeExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionChild = null;


        try {
            // InternalXmu2.g:2216:70: (iv_ruleMultiplicativeExpressionChild= ruleMultiplicativeExpressionChild EOF )
            // InternalXmu2.g:2217:2: iv_ruleMultiplicativeExpressionChild= ruleMultiplicativeExpressionChild EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionChildRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpressionChild=ruleMultiplicativeExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionChild; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpressionChild"


    // $ANTLR start "ruleMultiplicativeExpressionChild"
    // InternalXmu2.g:2223:1: ruleMultiplicativeExpressionChild returns [EObject current=null] : ( ( ( ruleUnaryExpression )=>this_UnaryExpression_0= ruleUnaryExpression ) | this_UnaryExpressionChild_1= ruleUnaryExpressionChild ) ;
    public final EObject ruleMultiplicativeExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryExpression_0 = null;

        EObject this_UnaryExpressionChild_1 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2229:2: ( ( ( ( ruleUnaryExpression )=>this_UnaryExpression_0= ruleUnaryExpression ) | this_UnaryExpressionChild_1= ruleUnaryExpressionChild ) )
            // InternalXmu2.g:2230:2: ( ( ( ruleUnaryExpression )=>this_UnaryExpression_0= ruleUnaryExpression ) | this_UnaryExpressionChild_1= ruleUnaryExpressionChild )
            {
            // InternalXmu2.g:2230:2: ( ( ( ruleUnaryExpression )=>this_UnaryExpression_0= ruleUnaryExpression ) | this_UnaryExpressionChild_1= ruleUnaryExpressionChild )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==60) && (synpred4_InternalXmu2())) {
                alt37=1;
            }
            else if ( (LA37_0==61) && (synpred4_InternalXmu2())) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_NAME||(LA37_0>=RULE_INT && LA37_0<=RULE_BOOLEAN)||LA37_0==19||(LA37_0>=58 && LA37_0<=59)) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalXmu2.g:2231:3: ( ( ruleUnaryExpression )=>this_UnaryExpression_0= ruleUnaryExpression )
                    {
                    // InternalXmu2.g:2231:3: ( ( ruleUnaryExpression )=>this_UnaryExpression_0= ruleUnaryExpression )
                    // InternalXmu2.g:2232:4: ( ruleUnaryExpression )=>this_UnaryExpression_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getMultiplicativeExpressionChildAccess().getUnaryExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_UnaryExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:2243:3: this_UnaryExpressionChild_1= ruleUnaryExpressionChild
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getMultiplicativeExpressionChildAccess().getUnaryExpressionChildParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpressionChild_1=ruleUnaryExpressionChild();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpressionChild_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpressionChild"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalXmu2.g:2255:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalXmu2.g:2255:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalXmu2.g:2256:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalXmu2.g:2262:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_operands_0_0= ruleAdditiveExpressionChild ) ) ( ( (lv_operators_1_0= ruleAdditiveOperator ) ) ( (lv_operands_2_0= ruleAdditiveExpressionChild ) ) )+ ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operands_0_0 = null;

        Enumerator lv_operators_1_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2268:2: ( ( ( (lv_operands_0_0= ruleAdditiveExpressionChild ) ) ( ( (lv_operators_1_0= ruleAdditiveOperator ) ) ( (lv_operands_2_0= ruleAdditiveExpressionChild ) ) )+ ) )
            // InternalXmu2.g:2269:2: ( ( (lv_operands_0_0= ruleAdditiveExpressionChild ) ) ( ( (lv_operators_1_0= ruleAdditiveOperator ) ) ( (lv_operands_2_0= ruleAdditiveExpressionChild ) ) )+ )
            {
            // InternalXmu2.g:2269:2: ( ( (lv_operands_0_0= ruleAdditiveExpressionChild ) ) ( ( (lv_operators_1_0= ruleAdditiveOperator ) ) ( (lv_operands_2_0= ruleAdditiveExpressionChild ) ) )+ )
            // InternalXmu2.g:2270:3: ( (lv_operands_0_0= ruleAdditiveExpressionChild ) ) ( ( (lv_operators_1_0= ruleAdditiveOperator ) ) ( (lv_operands_2_0= ruleAdditiveExpressionChild ) ) )+
            {
            // InternalXmu2.g:2270:3: ( (lv_operands_0_0= ruleAdditiveExpressionChild ) )
            // InternalXmu2.g:2271:4: (lv_operands_0_0= ruleAdditiveExpressionChild )
            {
            // InternalXmu2.g:2271:4: (lv_operands_0_0= ruleAdditiveExpressionChild )
            // InternalXmu2.g:2272:5: lv_operands_0_0= ruleAdditiveExpressionChild
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandsAdditiveExpressionChildParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_41);
            lv_operands_0_0=ruleAdditiveExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
              					}
              					add(
              						current,
              						"operands",
              						lv_operands_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.AdditiveExpressionChild");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:2289:3: ( ( (lv_operators_1_0= ruleAdditiveOperator ) ) ( (lv_operands_2_0= ruleAdditiveExpressionChild ) ) )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==61||(LA38_0>=64 && LA38_0<=65)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalXmu2.g:2290:4: ( (lv_operators_1_0= ruleAdditiveOperator ) ) ( (lv_operands_2_0= ruleAdditiveExpressionChild ) )
            	    {
            	    // InternalXmu2.g:2290:4: ( (lv_operators_1_0= ruleAdditiveOperator ) )
            	    // InternalXmu2.g:2291:5: (lv_operators_1_0= ruleAdditiveOperator )
            	    {
            	    // InternalXmu2.g:2291:5: (lv_operators_1_0= ruleAdditiveOperator )
            	    // InternalXmu2.g:2292:6: lv_operators_1_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperatorsAdditiveOperatorEnumRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_operators_1_0=ruleAdditiveOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operators",
            	      							lv_operators_1_0,
            	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.AdditiveOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalXmu2.g:2309:4: ( (lv_operands_2_0= ruleAdditiveExpressionChild ) )
            	    // InternalXmu2.g:2310:5: (lv_operands_2_0= ruleAdditiveExpressionChild )
            	    {
            	    // InternalXmu2.g:2310:5: (lv_operands_2_0= ruleAdditiveExpressionChild )
            	    // InternalXmu2.g:2311:6: lv_operands_2_0= ruleAdditiveExpressionChild
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperandsAdditiveExpressionChildParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_operands_2_0=ruleAdditiveExpressionChild();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operands",
            	      							lv_operands_2_0,
            	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.AdditiveExpressionChild");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionChild"
    // InternalXmu2.g:2333:1: entryRuleAdditiveExpressionChild returns [EObject current=null] : iv_ruleAdditiveExpressionChild= ruleAdditiveExpressionChild EOF ;
    public final EObject entryRuleAdditiveExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionChild = null;


        try {
            // InternalXmu2.g:2333:64: (iv_ruleAdditiveExpressionChild= ruleAdditiveExpressionChild EOF )
            // InternalXmu2.g:2334:2: iv_ruleAdditiveExpressionChild= ruleAdditiveExpressionChild EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionChildRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpressionChild=ruleAdditiveExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionChild; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpressionChild"


    // $ANTLR start "ruleAdditiveExpressionChild"
    // InternalXmu2.g:2340:1: ruleAdditiveExpressionChild returns [EObject current=null] : ( ( ( ruleMultiplicativeExpression )=>this_MultiplicativeExpression_0= ruleMultiplicativeExpression ) | this_MultiplicativeExpressionChild_1= ruleMultiplicativeExpressionChild ) ;
    public final EObject ruleAdditiveExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        EObject this_MultiplicativeExpressionChild_1 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2346:2: ( ( ( ( ruleMultiplicativeExpression )=>this_MultiplicativeExpression_0= ruleMultiplicativeExpression ) | this_MultiplicativeExpressionChild_1= ruleMultiplicativeExpressionChild ) )
            // InternalXmu2.g:2347:2: ( ( ( ruleMultiplicativeExpression )=>this_MultiplicativeExpression_0= ruleMultiplicativeExpression ) | this_MultiplicativeExpressionChild_1= ruleMultiplicativeExpressionChild )
            {
            // InternalXmu2.g:2347:2: ( ( ( ruleMultiplicativeExpression )=>this_MultiplicativeExpression_0= ruleMultiplicativeExpression ) | this_MultiplicativeExpressionChild_1= ruleMultiplicativeExpressionChild )
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // InternalXmu2.g:2348:3: ( ( ruleMultiplicativeExpression )=>this_MultiplicativeExpression_0= ruleMultiplicativeExpression )
                    {
                    // InternalXmu2.g:2348:3: ( ( ruleMultiplicativeExpression )=>this_MultiplicativeExpression_0= ruleMultiplicativeExpression )
                    // InternalXmu2.g:2349:4: ( ruleMultiplicativeExpression )=>this_MultiplicativeExpression_0= ruleMultiplicativeExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAdditiveExpressionChildAccess().getMultiplicativeExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_MultiplicativeExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:2360:3: this_MultiplicativeExpressionChild_1= ruleMultiplicativeExpressionChild
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAdditiveExpressionChildAccess().getMultiplicativeExpressionChildParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_MultiplicativeExpressionChild_1=ruleMultiplicativeExpressionChild();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MultiplicativeExpressionChild_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpressionChild"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalXmu2.g:2372:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalXmu2.g:2372:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalXmu2.g:2373:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalXmu2.g:2379:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpressionChild ) ) ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_right_2_0= ruleRelationalExpressionChild ) ) ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2385:2: ( ( ( (lv_left_0_0= ruleRelationalExpressionChild ) ) ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_right_2_0= ruleRelationalExpressionChild ) ) ) )
            // InternalXmu2.g:2386:2: ( ( (lv_left_0_0= ruleRelationalExpressionChild ) ) ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_right_2_0= ruleRelationalExpressionChild ) ) )
            {
            // InternalXmu2.g:2386:2: ( ( (lv_left_0_0= ruleRelationalExpressionChild ) ) ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_right_2_0= ruleRelationalExpressionChild ) ) )
            // InternalXmu2.g:2387:3: ( (lv_left_0_0= ruleRelationalExpressionChild ) ) ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_right_2_0= ruleRelationalExpressionChild ) )
            {
            // InternalXmu2.g:2387:3: ( (lv_left_0_0= ruleRelationalExpressionChild ) )
            // InternalXmu2.g:2388:4: (lv_left_0_0= ruleRelationalExpressionChild )
            {
            // InternalXmu2.g:2388:4: (lv_left_0_0= ruleRelationalExpressionChild )
            // InternalXmu2.g:2389:5: lv_left_0_0= ruleRelationalExpressionChild
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftRelationalExpressionChildParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_left_0_0=ruleRelationalExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
              					}
              					set(
              						current,
              						"left",
              						lv_left_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.RelationalExpressionChild");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:2406:3: ( (lv_operator_1_0= ruleRelationalOperator ) )
            // InternalXmu2.g:2407:4: (lv_operator_1_0= ruleRelationalOperator )
            {
            // InternalXmu2.g:2407:4: (lv_operator_1_0= ruleRelationalOperator )
            // InternalXmu2.g:2408:5: lv_operator_1_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_operator_1_0=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
              					}
              					set(
              						current,
              						"operator",
              						lv_operator_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.RelationalOperator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:2425:3: ( (lv_right_2_0= ruleRelationalExpressionChild ) )
            // InternalXmu2.g:2426:4: (lv_right_2_0= ruleRelationalExpressionChild )
            {
            // InternalXmu2.g:2426:4: (lv_right_2_0= ruleRelationalExpressionChild )
            // InternalXmu2.g:2427:5: lv_right_2_0= ruleRelationalExpressionChild
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionChildParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_right_2_0=ruleRelationalExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
              					}
              					set(
              						current,
              						"right",
              						lv_right_2_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.RelationalExpressionChild");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleRelationalExpressionChild"
    // InternalXmu2.g:2448:1: entryRuleRelationalExpressionChild returns [EObject current=null] : iv_ruleRelationalExpressionChild= ruleRelationalExpressionChild EOF ;
    public final EObject entryRuleRelationalExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionChild = null;


        try {
            // InternalXmu2.g:2448:66: (iv_ruleRelationalExpressionChild= ruleRelationalExpressionChild EOF )
            // InternalXmu2.g:2449:2: iv_ruleRelationalExpressionChild= ruleRelationalExpressionChild EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionChildRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpressionChild=ruleRelationalExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionChild; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpressionChild"


    // $ANTLR start "ruleRelationalExpressionChild"
    // InternalXmu2.g:2455:1: ruleRelationalExpressionChild returns [EObject current=null] : ( ( ( ruleAdditiveExpression )=>this_AdditiveExpression_0= ruleAdditiveExpression ) | this_AdditiveExpressionChild_1= ruleAdditiveExpressionChild ) ;
    public final EObject ruleRelationalExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        EObject this_AdditiveExpressionChild_1 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2461:2: ( ( ( ( ruleAdditiveExpression )=>this_AdditiveExpression_0= ruleAdditiveExpression ) | this_AdditiveExpressionChild_1= ruleAdditiveExpressionChild ) )
            // InternalXmu2.g:2462:2: ( ( ( ruleAdditiveExpression )=>this_AdditiveExpression_0= ruleAdditiveExpression ) | this_AdditiveExpressionChild_1= ruleAdditiveExpressionChild )
            {
            // InternalXmu2.g:2462:2: ( ( ( ruleAdditiveExpression )=>this_AdditiveExpression_0= ruleAdditiveExpression ) | this_AdditiveExpressionChild_1= ruleAdditiveExpressionChild )
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // InternalXmu2.g:2463:3: ( ( ruleAdditiveExpression )=>this_AdditiveExpression_0= ruleAdditiveExpression )
                    {
                    // InternalXmu2.g:2463:3: ( ( ruleAdditiveExpression )=>this_AdditiveExpression_0= ruleAdditiveExpression )
                    // InternalXmu2.g:2464:4: ( ruleAdditiveExpression )=>this_AdditiveExpression_0= ruleAdditiveExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRelationalExpressionChildAccess().getAdditiveExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_AdditiveExpression_0=ruleAdditiveExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_AdditiveExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:2475:3: this_AdditiveExpressionChild_1= ruleAdditiveExpressionChild
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRelationalExpressionChildAccess().getAdditiveExpressionChildParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AdditiveExpressionChild_1=ruleAdditiveExpressionChild();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AdditiveExpressionChild_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpressionChild"


    // $ANTLR start "entryRuleBooleanAndExpression"
    // InternalXmu2.g:2487:1: entryRuleBooleanAndExpression returns [EObject current=null] : iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF ;
    public final EObject entryRuleBooleanAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAndExpression = null;


        try {
            // InternalXmu2.g:2487:61: (iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF )
            // InternalXmu2.g:2488:2: iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanAndExpression=ruleBooleanAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanAndExpression"


    // $ANTLR start "ruleBooleanAndExpression"
    // InternalXmu2.g:2494:1: ruleBooleanAndExpression returns [EObject current=null] : ( ( (lv_operands_0_0= ruleBooleanAndExpressionChild ) ) (otherlv_1= 'and' ( (lv_operands_2_0= ruleBooleanAndExpressionChild ) ) )+ ) ;
    public final EObject ruleBooleanAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operands_0_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2500:2: ( ( ( (lv_operands_0_0= ruleBooleanAndExpressionChild ) ) (otherlv_1= 'and' ( (lv_operands_2_0= ruleBooleanAndExpressionChild ) ) )+ ) )
            // InternalXmu2.g:2501:2: ( ( (lv_operands_0_0= ruleBooleanAndExpressionChild ) ) (otherlv_1= 'and' ( (lv_operands_2_0= ruleBooleanAndExpressionChild ) ) )+ )
            {
            // InternalXmu2.g:2501:2: ( ( (lv_operands_0_0= ruleBooleanAndExpressionChild ) ) (otherlv_1= 'and' ( (lv_operands_2_0= ruleBooleanAndExpressionChild ) ) )+ )
            // InternalXmu2.g:2502:3: ( (lv_operands_0_0= ruleBooleanAndExpressionChild ) ) (otherlv_1= 'and' ( (lv_operands_2_0= ruleBooleanAndExpressionChild ) ) )+
            {
            // InternalXmu2.g:2502:3: ( (lv_operands_0_0= ruleBooleanAndExpressionChild ) )
            // InternalXmu2.g:2503:4: (lv_operands_0_0= ruleBooleanAndExpressionChild )
            {
            // InternalXmu2.g:2503:4: (lv_operands_0_0= ruleBooleanAndExpressionChild )
            // InternalXmu2.g:2504:5: lv_operands_0_0= ruleBooleanAndExpressionChild
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBooleanAndExpressionAccess().getOperandsBooleanAndExpressionChildParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_44);
            lv_operands_0_0=ruleBooleanAndExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBooleanAndExpressionRule());
              					}
              					add(
              						current,
              						"operands",
              						lv_operands_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.BooleanAndExpressionChild");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:2521:3: (otherlv_1= 'and' ( (lv_operands_2_0= ruleBooleanAndExpressionChild ) ) )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==36) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalXmu2.g:2522:4: otherlv_1= 'and' ( (lv_operands_2_0= ruleBooleanAndExpressionChild ) )
            	    {
            	    otherlv_1=(Token)match(input,36,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getBooleanAndExpressionAccess().getAndKeyword_1_0());
            	      			
            	    }
            	    // InternalXmu2.g:2526:4: ( (lv_operands_2_0= ruleBooleanAndExpressionChild ) )
            	    // InternalXmu2.g:2527:5: (lv_operands_2_0= ruleBooleanAndExpressionChild )
            	    {
            	    // InternalXmu2.g:2527:5: (lv_operands_2_0= ruleBooleanAndExpressionChild )
            	    // InternalXmu2.g:2528:6: lv_operands_2_0= ruleBooleanAndExpressionChild
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBooleanAndExpressionAccess().getOperandsBooleanAndExpressionChildParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_45);
            	    lv_operands_2_0=ruleBooleanAndExpressionChild();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBooleanAndExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operands",
            	      							lv_operands_2_0,
            	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.BooleanAndExpressionChild");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanAndExpression"


    // $ANTLR start "entryRuleBooleanAndExpressionChild"
    // InternalXmu2.g:2550:1: entryRuleBooleanAndExpressionChild returns [EObject current=null] : iv_ruleBooleanAndExpressionChild= ruleBooleanAndExpressionChild EOF ;
    public final EObject entryRuleBooleanAndExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAndExpressionChild = null;


        try {
            // InternalXmu2.g:2550:66: (iv_ruleBooleanAndExpressionChild= ruleBooleanAndExpressionChild EOF )
            // InternalXmu2.g:2551:2: iv_ruleBooleanAndExpressionChild= ruleBooleanAndExpressionChild EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanAndExpressionChildRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanAndExpressionChild=ruleBooleanAndExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAndExpressionChild; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanAndExpressionChild"


    // $ANTLR start "ruleBooleanAndExpressionChild"
    // InternalXmu2.g:2557:1: ruleBooleanAndExpressionChild returns [EObject current=null] : ( ( ( ruleRelationalExpression )=>this_RelationalExpression_0= ruleRelationalExpression ) | this_RelationalExpressionChild_1= ruleRelationalExpressionChild ) ;
    public final EObject ruleBooleanAndExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        EObject this_RelationalExpressionChild_1 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2563:2: ( ( ( ( ruleRelationalExpression )=>this_RelationalExpression_0= ruleRelationalExpression ) | this_RelationalExpressionChild_1= ruleRelationalExpressionChild ) )
            // InternalXmu2.g:2564:2: ( ( ( ruleRelationalExpression )=>this_RelationalExpression_0= ruleRelationalExpression ) | this_RelationalExpressionChild_1= ruleRelationalExpressionChild )
            {
            // InternalXmu2.g:2564:2: ( ( ( ruleRelationalExpression )=>this_RelationalExpression_0= ruleRelationalExpression ) | this_RelationalExpressionChild_1= ruleRelationalExpressionChild )
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // InternalXmu2.g:2565:3: ( ( ruleRelationalExpression )=>this_RelationalExpression_0= ruleRelationalExpression )
                    {
                    // InternalXmu2.g:2565:3: ( ( ruleRelationalExpression )=>this_RelationalExpression_0= ruleRelationalExpression )
                    // InternalXmu2.g:2566:4: ( ruleRelationalExpression )=>this_RelationalExpression_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBooleanAndExpressionChildAccess().getRelationalExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_RelationalExpression_0=ruleRelationalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_RelationalExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:2577:3: this_RelationalExpressionChild_1= ruleRelationalExpressionChild
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBooleanAndExpressionChildAccess().getRelationalExpressionChildParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RelationalExpressionChild_1=ruleRelationalExpressionChild();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RelationalExpressionChild_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanAndExpressionChild"


    // $ANTLR start "entryRuleBooleanOrExpression"
    // InternalXmu2.g:2589:1: entryRuleBooleanOrExpression returns [EObject current=null] : iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF ;
    public final EObject entryRuleBooleanOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOrExpression = null;


        try {
            // InternalXmu2.g:2589:60: (iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF )
            // InternalXmu2.g:2590:2: iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanOrExpression=ruleBooleanOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanOrExpression"


    // $ANTLR start "ruleBooleanOrExpression"
    // InternalXmu2.g:2596:1: ruleBooleanOrExpression returns [EObject current=null] : ( ( (lv_operands_0_0= ruleBooleanOrExpressionChild ) ) (otherlv_1= 'or' ( (lv_operands_2_0= ruleBooleanOrExpressionChild ) ) )+ ) ;
    public final EObject ruleBooleanOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operands_0_0 = null;

        EObject lv_operands_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2602:2: ( ( ( (lv_operands_0_0= ruleBooleanOrExpressionChild ) ) (otherlv_1= 'or' ( (lv_operands_2_0= ruleBooleanOrExpressionChild ) ) )+ ) )
            // InternalXmu2.g:2603:2: ( ( (lv_operands_0_0= ruleBooleanOrExpressionChild ) ) (otherlv_1= 'or' ( (lv_operands_2_0= ruleBooleanOrExpressionChild ) ) )+ )
            {
            // InternalXmu2.g:2603:2: ( ( (lv_operands_0_0= ruleBooleanOrExpressionChild ) ) (otherlv_1= 'or' ( (lv_operands_2_0= ruleBooleanOrExpressionChild ) ) )+ )
            // InternalXmu2.g:2604:3: ( (lv_operands_0_0= ruleBooleanOrExpressionChild ) ) (otherlv_1= 'or' ( (lv_operands_2_0= ruleBooleanOrExpressionChild ) ) )+
            {
            // InternalXmu2.g:2604:3: ( (lv_operands_0_0= ruleBooleanOrExpressionChild ) )
            // InternalXmu2.g:2605:4: (lv_operands_0_0= ruleBooleanOrExpressionChild )
            {
            // InternalXmu2.g:2605:4: (lv_operands_0_0= ruleBooleanOrExpressionChild )
            // InternalXmu2.g:2606:5: lv_operands_0_0= ruleBooleanOrExpressionChild
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBooleanOrExpressionAccess().getOperandsBooleanOrExpressionChildParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_46);
            lv_operands_0_0=ruleBooleanOrExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBooleanOrExpressionRule());
              					}
              					add(
              						current,
              						"operands",
              						lv_operands_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.BooleanOrExpressionChild");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalXmu2.g:2623:3: (otherlv_1= 'or' ( (lv_operands_2_0= ruleBooleanOrExpressionChild ) ) )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==37) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalXmu2.g:2624:4: otherlv_1= 'or' ( (lv_operands_2_0= ruleBooleanOrExpressionChild ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getBooleanOrExpressionAccess().getOrKeyword_1_0());
            	      			
            	    }
            	    // InternalXmu2.g:2628:4: ( (lv_operands_2_0= ruleBooleanOrExpressionChild ) )
            	    // InternalXmu2.g:2629:5: (lv_operands_2_0= ruleBooleanOrExpressionChild )
            	    {
            	    // InternalXmu2.g:2629:5: (lv_operands_2_0= ruleBooleanOrExpressionChild )
            	    // InternalXmu2.g:2630:6: lv_operands_2_0= ruleBooleanOrExpressionChild
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBooleanOrExpressionAccess().getOperandsBooleanOrExpressionChildParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
            	    lv_operands_2_0=ruleBooleanOrExpressionChild();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBooleanOrExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"operands",
            	      							lv_operands_2_0,
            	      							"edu.ustb.sei.mde.xmuxtext.Xmu2.BooleanOrExpressionChild");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt43 >= 1 ) break loop43;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanOrExpression"


    // $ANTLR start "entryRuleBooleanOrExpressionChild"
    // InternalXmu2.g:2652:1: entryRuleBooleanOrExpressionChild returns [EObject current=null] : iv_ruleBooleanOrExpressionChild= ruleBooleanOrExpressionChild EOF ;
    public final EObject entryRuleBooleanOrExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOrExpressionChild = null;


        try {
            // InternalXmu2.g:2652:65: (iv_ruleBooleanOrExpressionChild= ruleBooleanOrExpressionChild EOF )
            // InternalXmu2.g:2653:2: iv_ruleBooleanOrExpressionChild= ruleBooleanOrExpressionChild EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanOrExpressionChildRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanOrExpressionChild=ruleBooleanOrExpressionChild();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanOrExpressionChild; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanOrExpressionChild"


    // $ANTLR start "ruleBooleanOrExpressionChild"
    // InternalXmu2.g:2659:1: ruleBooleanOrExpressionChild returns [EObject current=null] : ( ( ( ruleBooleanAndExpression )=>this_BooleanAndExpression_0= ruleBooleanAndExpression ) | this_BooleanAndExpressionChild_1= ruleBooleanAndExpressionChild ) ;
    public final EObject ruleBooleanOrExpressionChild() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanAndExpression_0 = null;

        EObject this_BooleanAndExpressionChild_1 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2665:2: ( ( ( ( ruleBooleanAndExpression )=>this_BooleanAndExpression_0= ruleBooleanAndExpression ) | this_BooleanAndExpressionChild_1= ruleBooleanAndExpressionChild ) )
            // InternalXmu2.g:2666:2: ( ( ( ruleBooleanAndExpression )=>this_BooleanAndExpression_0= ruleBooleanAndExpression ) | this_BooleanAndExpressionChild_1= ruleBooleanAndExpressionChild )
            {
            // InternalXmu2.g:2666:2: ( ( ( ruleBooleanAndExpression )=>this_BooleanAndExpression_0= ruleBooleanAndExpression ) | this_BooleanAndExpressionChild_1= ruleBooleanAndExpressionChild )
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // InternalXmu2.g:2667:3: ( ( ruleBooleanAndExpression )=>this_BooleanAndExpression_0= ruleBooleanAndExpression )
                    {
                    // InternalXmu2.g:2667:3: ( ( ruleBooleanAndExpression )=>this_BooleanAndExpression_0= ruleBooleanAndExpression )
                    // InternalXmu2.g:2668:4: ( ruleBooleanAndExpression )=>this_BooleanAndExpression_0= ruleBooleanAndExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBooleanOrExpressionChildAccess().getBooleanAndExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanAndExpression_0=ruleBooleanAndExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_BooleanAndExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:2679:3: this_BooleanAndExpressionChild_1= ruleBooleanAndExpressionChild
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBooleanOrExpressionChildAccess().getBooleanAndExpressionChildParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanAndExpressionChild_1=ruleBooleanAndExpressionChild();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanAndExpressionChild_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanOrExpressionChild"


    // $ANTLR start "entryRuleExpression"
    // InternalXmu2.g:2691:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalXmu2.g:2691:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalXmu2.g:2692:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalXmu2.g:2698:1: ruleExpression returns [EObject current=null] : ( ( ( ruleBooleanOrExpression )=>this_BooleanOrExpression_0= ruleBooleanOrExpression ) | this_BooleanOrExpressionChild_1= ruleBooleanOrExpressionChild ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanOrExpression_0 = null;

        EObject this_BooleanOrExpressionChild_1 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2704:2: ( ( ( ( ruleBooleanOrExpression )=>this_BooleanOrExpression_0= ruleBooleanOrExpression ) | this_BooleanOrExpressionChild_1= ruleBooleanOrExpressionChild ) )
            // InternalXmu2.g:2705:2: ( ( ( ruleBooleanOrExpression )=>this_BooleanOrExpression_0= ruleBooleanOrExpression ) | this_BooleanOrExpressionChild_1= ruleBooleanOrExpressionChild )
            {
            // InternalXmu2.g:2705:2: ( ( ( ruleBooleanOrExpression )=>this_BooleanOrExpression_0= ruleBooleanOrExpression ) | this_BooleanOrExpressionChild_1= ruleBooleanOrExpressionChild )
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // InternalXmu2.g:2706:3: ( ( ruleBooleanOrExpression )=>this_BooleanOrExpression_0= ruleBooleanOrExpression )
                    {
                    // InternalXmu2.g:2706:3: ( ( ruleBooleanOrExpression )=>this_BooleanOrExpression_0= ruleBooleanOrExpression )
                    // InternalXmu2.g:2707:4: ( ruleBooleanOrExpression )=>this_BooleanOrExpression_0= ruleBooleanOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getExpressionAccess().getBooleanOrExpressionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanOrExpression_0=ruleBooleanOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_BooleanOrExpression_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:2718:3: this_BooleanOrExpressionChild_1= ruleBooleanOrExpressionChild
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getBooleanOrExpressionChildParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanOrExpressionChild_1=ruleBooleanOrExpressionChild();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanOrExpressionChild_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBlockStatement"
    // InternalXmu2.g:2730:1: entryRuleBlockStatement returns [EObject current=null] : iv_ruleBlockStatement= ruleBlockStatement EOF ;
    public final EObject entryRuleBlockStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStatement = null;


        try {
            // InternalXmu2.g:2730:55: (iv_ruleBlockStatement= ruleBlockStatement EOF )
            // InternalXmu2.g:2731:2: iv_ruleBlockStatement= ruleBlockStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockStatement=ruleBlockStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockStatement"


    // $ANTLR start "ruleBlockStatement"
    // InternalXmu2.g:2737:1: ruleBlockStatement returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_body_2_0= ruleStatement ) ) (otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleBlockStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_body_2_0 = null;

        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2743:2: ( ( () otherlv_1= '{' ( ( (lv_body_2_0= ruleStatement ) ) (otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) ) )* )? otherlv_5= '}' ) )
            // InternalXmu2.g:2744:2: ( () otherlv_1= '{' ( ( (lv_body_2_0= ruleStatement ) ) (otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) ) )* )? otherlv_5= '}' )
            {
            // InternalXmu2.g:2744:2: ( () otherlv_1= '{' ( ( (lv_body_2_0= ruleStatement ) ) (otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) ) )* )? otherlv_5= '}' )
            // InternalXmu2.g:2745:3: () otherlv_1= '{' ( ( (lv_body_2_0= ruleStatement ) ) (otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) ) )* )? otherlv_5= '}'
            {
            // InternalXmu2.g:2745:3: ()
            // InternalXmu2.g:2746:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockStatementAccess().getBlockStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalXmu2.g:2756:3: ( ( (lv_body_2_0= ruleStatement ) ) (otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_NAME||LA47_0==25||LA47_0==38||LA47_0==41||(LA47_0>=44 && LA47_0<=48)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalXmu2.g:2757:4: ( (lv_body_2_0= ruleStatement ) ) (otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) ) )*
                    {
                    // InternalXmu2.g:2757:4: ( (lv_body_2_0= ruleStatement ) )
                    // InternalXmu2.g:2758:5: (lv_body_2_0= ruleStatement )
                    {
                    // InternalXmu2.g:2758:5: (lv_body_2_0= ruleStatement )
                    // InternalXmu2.g:2759:6: lv_body_2_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBlockStatementAccess().getBodyStatementParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_48);
                    lv_body_2_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBlockStatementRule());
                      						}
                      						add(
                      							current,
                      							"body",
                      							lv_body_2_0,
                      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalXmu2.g:2776:4: (otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==26) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalXmu2.g:2777:5: otherlv_3= ';' ( (lv_body_4_0= ruleStatement ) )
                    	    {
                    	    otherlv_3=(Token)match(input,26,FOLLOW_49); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getBlockStatementAccess().getSemicolonKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalXmu2.g:2781:5: ( (lv_body_4_0= ruleStatement ) )
                    	    // InternalXmu2.g:2782:6: (lv_body_4_0= ruleStatement )
                    	    {
                    	    // InternalXmu2.g:2782:6: (lv_body_4_0= ruleStatement )
                    	    // InternalXmu2.g:2783:7: lv_body_4_0= ruleStatement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getBlockStatementAccess().getBodyStatementParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_48);
                    	    lv_body_4_0=ruleStatement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getBlockStatementRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"body",
                    	      								lv_body_4_0,
                    	      								"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getBlockStatementAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockStatement"


    // $ANTLR start "entryRuleUpdateStatement"
    // InternalXmu2.g:2810:1: entryRuleUpdateStatement returns [EObject current=null] : iv_ruleUpdateStatement= ruleUpdateStatement EOF ;
    public final EObject entryRuleUpdateStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateStatement = null;


        try {
            // InternalXmu2.g:2810:56: (iv_ruleUpdateStatement= ruleUpdateStatement EOF )
            // InternalXmu2.g:2811:2: iv_ruleUpdateStatement= ruleUpdateStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpdateStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUpdateStatement=ruleUpdateStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpdateStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpdateStatement"


    // $ANTLR start "ruleUpdateStatement"
    // InternalXmu2.g:2817:1: ruleUpdateStatement returns [EObject current=null] : (otherlv_0= 'update' ( (lv_source_1_0= rulePattern ) ) otherlv_2= 'with' ( (lv_view_3_0= rulePattern ) ) otherlv_4= 'by' ( (lv_clauses_5_0= ruleUpdateClause ) )+ ) ;
    public final EObject ruleUpdateStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_source_1_0 = null;

        EObject lv_view_3_0 = null;

        EObject lv_clauses_5_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2823:2: ( (otherlv_0= 'update' ( (lv_source_1_0= rulePattern ) ) otherlv_2= 'with' ( (lv_view_3_0= rulePattern ) ) otherlv_4= 'by' ( (lv_clauses_5_0= ruleUpdateClause ) )+ ) )
            // InternalXmu2.g:2824:2: (otherlv_0= 'update' ( (lv_source_1_0= rulePattern ) ) otherlv_2= 'with' ( (lv_view_3_0= rulePattern ) ) otherlv_4= 'by' ( (lv_clauses_5_0= ruleUpdateClause ) )+ )
            {
            // InternalXmu2.g:2824:2: (otherlv_0= 'update' ( (lv_source_1_0= rulePattern ) ) otherlv_2= 'with' ( (lv_view_3_0= rulePattern ) ) otherlv_4= 'by' ( (lv_clauses_5_0= ruleUpdateClause ) )+ )
            // InternalXmu2.g:2825:3: otherlv_0= 'update' ( (lv_source_1_0= rulePattern ) ) otherlv_2= 'with' ( (lv_view_3_0= rulePattern ) ) otherlv_4= 'by' ( (lv_clauses_5_0= ruleUpdateClause ) )+
            {
            otherlv_0=(Token)match(input,38,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getUpdateStatementAccess().getUpdateKeyword_0());
              		
            }
            // InternalXmu2.g:2829:3: ( (lv_source_1_0= rulePattern ) )
            // InternalXmu2.g:2830:4: (lv_source_1_0= rulePattern )
            {
            // InternalXmu2.g:2830:4: (lv_source_1_0= rulePattern )
            // InternalXmu2.g:2831:5: lv_source_1_0= rulePattern
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUpdateStatementAccess().getSourcePatternParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_50);
            lv_source_1_0=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUpdateStatementRule());
              					}
              					set(
              						current,
              						"source",
              						lv_source_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Pattern");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUpdateStatementAccess().getWithKeyword_2());
              		
            }
            // InternalXmu2.g:2852:3: ( (lv_view_3_0= rulePattern ) )
            // InternalXmu2.g:2853:4: (lv_view_3_0= rulePattern )
            {
            // InternalXmu2.g:2853:4: (lv_view_3_0= rulePattern )
            // InternalXmu2.g:2854:5: lv_view_3_0= rulePattern
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUpdateStatementAccess().getViewPatternParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_51);
            lv_view_3_0=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUpdateStatementRule());
              					}
              					set(
              						current,
              						"view",
              						lv_view_3_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Pattern");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getUpdateStatementAccess().getByKeyword_4());
              		
            }
            // InternalXmu2.g:2875:3: ( (lv_clauses_5_0= ruleUpdateClause ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                switch ( input.LA(1) ) {
                case 70:
                    {
                    alt48=1;
                    }
                    break;
                case 71:
                    {
                    alt48=1;
                    }
                    break;
                case 72:
                    {
                    alt48=1;
                    }
                    break;
                case 73:
                    {
                    alt48=1;
                    }
                    break;

                }

                switch (alt48) {
            	case 1 :
            	    // InternalXmu2.g:2876:4: (lv_clauses_5_0= ruleUpdateClause )
            	    {
            	    // InternalXmu2.g:2876:4: (lv_clauses_5_0= ruleUpdateClause )
            	    // InternalXmu2.g:2877:5: lv_clauses_5_0= ruleUpdateClause
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUpdateStatementAccess().getClausesUpdateClauseParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_53);
            	    lv_clauses_5_0=ruleUpdateClause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getUpdateStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"clauses",
            	      						lv_clauses_5_0,
            	      						"edu.ustb.sei.mde.xmuxtext.Xmu2.UpdateClause");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpdateStatement"


    // $ANTLR start "entryRuleUpdateClause"
    // InternalXmu2.g:2898:1: entryRuleUpdateClause returns [EObject current=null] : iv_ruleUpdateClause= ruleUpdateClause EOF ;
    public final EObject entryRuleUpdateClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateClause = null;


        try {
            // InternalXmu2.g:2898:53: (iv_ruleUpdateClause= ruleUpdateClause EOF )
            // InternalXmu2.g:2899:2: iv_ruleUpdateClause= ruleUpdateClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpdateClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUpdateClause=ruleUpdateClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpdateClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpdateClause"


    // $ANTLR start "ruleUpdateClause"
    // InternalXmu2.g:2905:1: ruleUpdateClause returns [EObject current=null] : ( ( (lv_type_0_0= ruleActionType ) ) otherlv_1= '->' ( (lv_statement_2_0= ruleStatement ) ) ) ;
    public final EObject ruleUpdateClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_statement_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2911:2: ( ( ( (lv_type_0_0= ruleActionType ) ) otherlv_1= '->' ( (lv_statement_2_0= ruleStatement ) ) ) )
            // InternalXmu2.g:2912:2: ( ( (lv_type_0_0= ruleActionType ) ) otherlv_1= '->' ( (lv_statement_2_0= ruleStatement ) ) )
            {
            // InternalXmu2.g:2912:2: ( ( (lv_type_0_0= ruleActionType ) ) otherlv_1= '->' ( (lv_statement_2_0= ruleStatement ) ) )
            // InternalXmu2.g:2913:3: ( (lv_type_0_0= ruleActionType ) ) otherlv_1= '->' ( (lv_statement_2_0= ruleStatement ) )
            {
            // InternalXmu2.g:2913:3: ( (lv_type_0_0= ruleActionType ) )
            // InternalXmu2.g:2914:4: (lv_type_0_0= ruleActionType )
            {
            // InternalXmu2.g:2914:4: (lv_type_0_0= ruleActionType )
            // InternalXmu2.g:2915:5: lv_type_0_0= ruleActionType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUpdateClauseAccess().getTypeActionTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_54);
            lv_type_0_0=ruleActionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUpdateClauseRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.ActionType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUpdateClauseAccess().getHyphenMinusGreaterThanSignKeyword_1());
              		
            }
            // InternalXmu2.g:2936:3: ( (lv_statement_2_0= ruleStatement ) )
            // InternalXmu2.g:2937:4: (lv_statement_2_0= ruleStatement )
            {
            // InternalXmu2.g:2937:4: (lv_statement_2_0= ruleStatement )
            // InternalXmu2.g:2938:5: lv_statement_2_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUpdateClauseAccess().getStatementStatementParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_statement_2_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUpdateClauseRule());
              					}
              					set(
              						current,
              						"statement",
              						lv_statement_2_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpdateClause"


    // $ANTLR start "entryRuleSwitchStatement"
    // InternalXmu2.g:2959:1: entryRuleSwitchStatement returns [EObject current=null] : iv_ruleSwitchStatement= ruleSwitchStatement EOF ;
    public final EObject entryRuleSwitchStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStatement = null;


        try {
            // InternalXmu2.g:2959:56: (iv_ruleSwitchStatement= ruleSwitchStatement EOF )
            // InternalXmu2.g:2960:2: iv_ruleSwitchStatement= ruleSwitchStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitchStatement=ruleSwitchStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchStatement"


    // $ANTLR start "ruleSwitchStatement"
    // InternalXmu2.g:2966:1: ruleSwitchStatement returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_root_2_0= ruleVariableExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCaseClause ) )+ otherlv_6= '}' ) ;
    public final EObject ruleSwitchStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_root_2_0 = null;

        EObject lv_cases_5_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:2972:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_root_2_0= ruleVariableExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCaseClause ) )+ otherlv_6= '}' ) )
            // InternalXmu2.g:2973:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_root_2_0= ruleVariableExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCaseClause ) )+ otherlv_6= '}' )
            {
            // InternalXmu2.g:2973:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_root_2_0= ruleVariableExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCaseClause ) )+ otherlv_6= '}' )
            // InternalXmu2.g:2974:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_root_2_0= ruleVariableExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCaseClause ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatementAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalXmu2.g:2982:3: ( (lv_root_2_0= ruleVariableExpression ) )
            // InternalXmu2.g:2983:4: (lv_root_2_0= ruleVariableExpression )
            {
            // InternalXmu2.g:2983:4: (lv_root_2_0= ruleVariableExpression )
            // InternalXmu2.g:2984:5: lv_root_2_0= ruleVariableExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatementAccess().getRootVariableExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_root_2_0=ruleVariableExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
              					}
              					set(
              						current,
              						"root",
              						lv_root_2_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.VariableExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,25,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatementAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalXmu2.g:3009:3: ( (lv_cases_5_0= ruleCaseClause ) )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=42 && LA49_0<=43)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalXmu2.g:3010:4: (lv_cases_5_0= ruleCaseClause )
            	    {
            	    // InternalXmu2.g:3010:4: (lv_cases_5_0= ruleCaseClause )
            	    // InternalXmu2.g:3011:5: lv_cases_5_0= ruleCaseClause
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchStatementAccess().getCasesCaseClauseParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_56);
            	    lv_cases_5_0=ruleCaseClause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"cases",
            	      						lv_cases_5_0,
            	      						"edu.ustb.sei.mde.xmuxtext.Xmu2.CaseClause");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);

            otherlv_6=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSwitchStatementAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchStatement"


    // $ANTLR start "entryRuleCaseClause"
    // InternalXmu2.g:3036:1: entryRuleCaseClause returns [EObject current=null] : iv_ruleCaseClause= ruleCaseClause EOF ;
    public final EObject entryRuleCaseClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseClause = null;


        try {
            // InternalXmu2.g:3036:51: (iv_ruleCaseClause= ruleCaseClause EOF )
            // InternalXmu2.g:3037:2: iv_ruleCaseClause= ruleCaseClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCaseClause=ruleCaseClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseClause"


    // $ANTLR start "ruleCaseClause"
    // InternalXmu2.g:3043:1: ruleCaseClause returns [EObject current=null] : (this_PatternCaseClause_0= rulePatternCaseClause | this_ExpressionCaseClause_1= ruleExpressionCaseClause | this_DefaultCaseClause_2= ruleDefaultCaseClause ) ;
    public final EObject ruleCaseClause() throws RecognitionException {
        EObject current = null;

        EObject this_PatternCaseClause_0 = null;

        EObject this_ExpressionCaseClause_1 = null;

        EObject this_DefaultCaseClause_2 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3049:2: ( (this_PatternCaseClause_0= rulePatternCaseClause | this_ExpressionCaseClause_1= ruleExpressionCaseClause | this_DefaultCaseClause_2= ruleDefaultCaseClause ) )
            // InternalXmu2.g:3050:2: (this_PatternCaseClause_0= rulePatternCaseClause | this_ExpressionCaseClause_1= ruleExpressionCaseClause | this_DefaultCaseClause_2= ruleDefaultCaseClause )
            {
            // InternalXmu2.g:3050:2: (this_PatternCaseClause_0= rulePatternCaseClause | this_ExpressionCaseClause_1= ruleExpressionCaseClause | this_DefaultCaseClause_2= ruleDefaultCaseClause )
            int alt50=3;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==42) ) {
                int LA50_1 = input.LA(2);

                if ( ((LA50_1>=RULE_INT && LA50_1<=RULE_BOOLEAN)||LA50_1==19||(LA50_1>=58 && LA50_1<=61)) ) {
                    alt50=2;
                }
                else if ( (LA50_1==RULE_NAME) ) {
                    int LA50_4 = input.LA(3);

                    if ( (LA50_4==30||LA50_4==32||LA50_4==34||(LA50_4>=36 && LA50_4<=37)||(LA50_4>=61 && LA50_4<=69)) ) {
                        alt50=2;
                    }
                    else if ( (LA50_4==29) ) {
                        alt50=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA50_0==43) ) {
                alt50=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalXmu2.g:3051:3: this_PatternCaseClause_0= rulePatternCaseClause
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCaseClauseAccess().getPatternCaseClauseParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PatternCaseClause_0=rulePatternCaseClause();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PatternCaseClause_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalXmu2.g:3060:3: this_ExpressionCaseClause_1= ruleExpressionCaseClause
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCaseClauseAccess().getExpressionCaseClauseParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExpressionCaseClause_1=ruleExpressionCaseClause();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionCaseClause_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalXmu2.g:3069:3: this_DefaultCaseClause_2= ruleDefaultCaseClause
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCaseClauseAccess().getDefaultCaseClauseParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DefaultCaseClause_2=ruleDefaultCaseClause();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DefaultCaseClause_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseClause"


    // $ANTLR start "entryRulePatternCaseClause"
    // InternalXmu2.g:3081:1: entryRulePatternCaseClause returns [EObject current=null] : iv_rulePatternCaseClause= rulePatternCaseClause EOF ;
    public final EObject entryRulePatternCaseClause() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternCaseClause = null;


        try {
            // InternalXmu2.g:3081:58: (iv_rulePatternCaseClause= rulePatternCaseClause EOF )
            // InternalXmu2.g:3082:2: iv_rulePatternCaseClause= rulePatternCaseClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternCaseClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePatternCaseClause=rulePatternCaseClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternCaseClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternCaseClause"


    // $ANTLR start "rulePatternCaseClause"
    // InternalXmu2.g:3088:1: rulePatternCaseClause returns [EObject current=null] : (otherlv_0= 'case' ( (lv_condition_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) ) ;
    public final EObject rulePatternCaseClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_action_3_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3094:2: ( (otherlv_0= 'case' ( (lv_condition_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) ) )
            // InternalXmu2.g:3095:2: (otherlv_0= 'case' ( (lv_condition_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) )
            {
            // InternalXmu2.g:3095:2: (otherlv_0= 'case' ( (lv_condition_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) )
            // InternalXmu2.g:3096:3: otherlv_0= 'case' ( (lv_condition_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPatternCaseClauseAccess().getCaseKeyword_0());
              		
            }
            // InternalXmu2.g:3100:3: ( (lv_condition_1_0= rulePattern ) )
            // InternalXmu2.g:3101:4: (lv_condition_1_0= rulePattern )
            {
            // InternalXmu2.g:3101:4: (lv_condition_1_0= rulePattern )
            // InternalXmu2.g:3102:5: lv_condition_1_0= rulePattern
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPatternCaseClauseAccess().getConditionPatternParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_54);
            lv_condition_1_0=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPatternCaseClauseRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Pattern");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPatternCaseClauseAccess().getHyphenMinusGreaterThanSignKeyword_2());
              		
            }
            // InternalXmu2.g:3123:3: ( (lv_action_3_0= ruleStatement ) )
            // InternalXmu2.g:3124:4: (lv_action_3_0= ruleStatement )
            {
            // InternalXmu2.g:3124:4: (lv_action_3_0= ruleStatement )
            // InternalXmu2.g:3125:5: lv_action_3_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPatternCaseClauseAccess().getActionStatementParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_action_3_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPatternCaseClauseRule());
              					}
              					set(
              						current,
              						"action",
              						lv_action_3_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternCaseClause"


    // $ANTLR start "entryRuleExpressionCaseClause"
    // InternalXmu2.g:3146:1: entryRuleExpressionCaseClause returns [EObject current=null] : iv_ruleExpressionCaseClause= ruleExpressionCaseClause EOF ;
    public final EObject entryRuleExpressionCaseClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionCaseClause = null;


        try {
            // InternalXmu2.g:3146:61: (iv_ruleExpressionCaseClause= ruleExpressionCaseClause EOF )
            // InternalXmu2.g:3147:2: iv_ruleExpressionCaseClause= ruleExpressionCaseClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionCaseClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionCaseClause=ruleExpressionCaseClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionCaseClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionCaseClause"


    // $ANTLR start "ruleExpressionCaseClause"
    // InternalXmu2.g:3153:1: ruleExpressionCaseClause returns [EObject current=null] : (otherlv_0= 'case' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) ) ;
    public final EObject ruleExpressionCaseClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_action_3_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3159:2: ( (otherlv_0= 'case' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) ) )
            // InternalXmu2.g:3160:2: (otherlv_0= 'case' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) )
            {
            // InternalXmu2.g:3160:2: (otherlv_0= 'case' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) )
            // InternalXmu2.g:3161:3: otherlv_0= 'case' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExpressionCaseClauseAccess().getCaseKeyword_0());
              		
            }
            // InternalXmu2.g:3165:3: ( (lv_condition_1_0= ruleExpression ) )
            // InternalXmu2.g:3166:4: (lv_condition_1_0= ruleExpression )
            {
            // InternalXmu2.g:3166:4: (lv_condition_1_0= ruleExpression )
            // InternalXmu2.g:3167:5: lv_condition_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionCaseClauseAccess().getConditionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_54);
            lv_condition_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExpressionCaseClauseRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getExpressionCaseClauseAccess().getHyphenMinusGreaterThanSignKeyword_2());
              		
            }
            // InternalXmu2.g:3188:3: ( (lv_action_3_0= ruleStatement ) )
            // InternalXmu2.g:3189:4: (lv_action_3_0= ruleStatement )
            {
            // InternalXmu2.g:3189:4: (lv_action_3_0= ruleStatement )
            // InternalXmu2.g:3190:5: lv_action_3_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionCaseClauseAccess().getActionStatementParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_action_3_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExpressionCaseClauseRule());
              					}
              					set(
              						current,
              						"action",
              						lv_action_3_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionCaseClause"


    // $ANTLR start "entryRuleDefaultCaseClause"
    // InternalXmu2.g:3211:1: entryRuleDefaultCaseClause returns [EObject current=null] : iv_ruleDefaultCaseClause= ruleDefaultCaseClause EOF ;
    public final EObject entryRuleDefaultCaseClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultCaseClause = null;


        try {
            // InternalXmu2.g:3211:58: (iv_ruleDefaultCaseClause= ruleDefaultCaseClause EOF )
            // InternalXmu2.g:3212:2: iv_ruleDefaultCaseClause= ruleDefaultCaseClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultCaseClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefaultCaseClause=ruleDefaultCaseClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultCaseClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultCaseClause"


    // $ANTLR start "ruleDefaultCaseClause"
    // InternalXmu2.g:3218:1: ruleDefaultCaseClause returns [EObject current=null] : (otherlv_0= 'otherwise' otherlv_1= '->' ( (lv_action_2_0= ruleStatement ) ) ) ;
    public final EObject ruleDefaultCaseClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_action_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3224:2: ( (otherlv_0= 'otherwise' otherlv_1= '->' ( (lv_action_2_0= ruleStatement ) ) ) )
            // InternalXmu2.g:3225:2: (otherlv_0= 'otherwise' otherlv_1= '->' ( (lv_action_2_0= ruleStatement ) ) )
            {
            // InternalXmu2.g:3225:2: (otherlv_0= 'otherwise' otherlv_1= '->' ( (lv_action_2_0= ruleStatement ) ) )
            // InternalXmu2.g:3226:3: otherlv_0= 'otherwise' otherlv_1= '->' ( (lv_action_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDefaultCaseClauseAccess().getOtherwiseKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,32,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDefaultCaseClauseAccess().getHyphenMinusGreaterThanSignKeyword_1());
              		
            }
            // InternalXmu2.g:3234:3: ( (lv_action_2_0= ruleStatement ) )
            // InternalXmu2.g:3235:4: (lv_action_2_0= ruleStatement )
            {
            // InternalXmu2.g:3235:4: (lv_action_2_0= ruleStatement )
            // InternalXmu2.g:3236:5: lv_action_2_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDefaultCaseClauseAccess().getActionStatementParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_action_2_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDefaultCaseClauseRule());
              					}
              					set(
              						current,
              						"action",
              						lv_action_2_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultCaseClause"


    // $ANTLR start "entryRuleDeleteNodeStatement"
    // InternalXmu2.g:3257:1: entryRuleDeleteNodeStatement returns [EObject current=null] : iv_ruleDeleteNodeStatement= ruleDeleteNodeStatement EOF ;
    public final EObject entryRuleDeleteNodeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteNodeStatement = null;


        try {
            // InternalXmu2.g:3257:60: (iv_ruleDeleteNodeStatement= ruleDeleteNodeStatement EOF )
            // InternalXmu2.g:3258:2: iv_ruleDeleteNodeStatement= ruleDeleteNodeStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeleteNodeStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeleteNodeStatement=ruleDeleteNodeStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeleteNodeStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeleteNodeStatement"


    // $ANTLR start "ruleDeleteNodeStatement"
    // InternalXmu2.g:3264:1: ruleDeleteNodeStatement returns [EObject current=null] : (otherlv_0= 'delete' ( (lv_node_1_0= ruleVariableExpression ) ) ) ;
    public final EObject ruleDeleteNodeStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_node_1_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3270:2: ( (otherlv_0= 'delete' ( (lv_node_1_0= ruleVariableExpression ) ) ) )
            // InternalXmu2.g:3271:2: (otherlv_0= 'delete' ( (lv_node_1_0= ruleVariableExpression ) ) )
            {
            // InternalXmu2.g:3271:2: (otherlv_0= 'delete' ( (lv_node_1_0= ruleVariableExpression ) ) )
            // InternalXmu2.g:3272:3: otherlv_0= 'delete' ( (lv_node_1_0= ruleVariableExpression ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDeleteNodeStatementAccess().getDeleteKeyword_0());
              		
            }
            // InternalXmu2.g:3276:3: ( (lv_node_1_0= ruleVariableExpression ) )
            // InternalXmu2.g:3277:4: (lv_node_1_0= ruleVariableExpression )
            {
            // InternalXmu2.g:3277:4: (lv_node_1_0= ruleVariableExpression )
            // InternalXmu2.g:3278:5: lv_node_1_0= ruleVariableExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeleteNodeStatementAccess().getNodeVariableExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_node_1_0=ruleVariableExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeleteNodeStatementRule());
              					}
              					set(
              						current,
              						"node",
              						lv_node_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.VariableExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeleteNodeStatement"


    // $ANTLR start "entryRuleDeleteLinkStatement"
    // InternalXmu2.g:3299:1: entryRuleDeleteLinkStatement returns [EObject current=null] : iv_ruleDeleteLinkStatement= ruleDeleteLinkStatement EOF ;
    public final EObject entryRuleDeleteLinkStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteLinkStatement = null;


        try {
            // InternalXmu2.g:3299:60: (iv_ruleDeleteLinkStatement= ruleDeleteLinkStatement EOF )
            // InternalXmu2.g:3300:2: iv_ruleDeleteLinkStatement= ruleDeleteLinkStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeleteLinkStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeleteLinkStatement=ruleDeleteLinkStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeleteLinkStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeleteLinkStatement"


    // $ANTLR start "ruleDeleteLinkStatement"
    // InternalXmu2.g:3306:1: ruleDeleteLinkStatement returns [EObject current=null] : ( () otherlv_1= 'delete' ( (lv_source_2_0= ruleVariableExpression ) ) otherlv_3= '.' ( (lv_feature_4_0= RULE_NAME ) ) otherlv_5= '=' ( (lv_target_6_0= ruleExpression ) ) ) ;
    public final EObject ruleDeleteLinkStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_feature_4_0=null;
        Token otherlv_5=null;
        EObject lv_source_2_0 = null;

        EObject lv_target_6_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3312:2: ( ( () otherlv_1= 'delete' ( (lv_source_2_0= ruleVariableExpression ) ) otherlv_3= '.' ( (lv_feature_4_0= RULE_NAME ) ) otherlv_5= '=' ( (lv_target_6_0= ruleExpression ) ) ) )
            // InternalXmu2.g:3313:2: ( () otherlv_1= 'delete' ( (lv_source_2_0= ruleVariableExpression ) ) otherlv_3= '.' ( (lv_feature_4_0= RULE_NAME ) ) otherlv_5= '=' ( (lv_target_6_0= ruleExpression ) ) )
            {
            // InternalXmu2.g:3313:2: ( () otherlv_1= 'delete' ( (lv_source_2_0= ruleVariableExpression ) ) otherlv_3= '.' ( (lv_feature_4_0= RULE_NAME ) ) otherlv_5= '=' ( (lv_target_6_0= ruleExpression ) ) )
            // InternalXmu2.g:3314:3: () otherlv_1= 'delete' ( (lv_source_2_0= ruleVariableExpression ) ) otherlv_3= '.' ( (lv_feature_4_0= RULE_NAME ) ) otherlv_5= '=' ( (lv_target_6_0= ruleExpression ) )
            {
            // InternalXmu2.g:3314:3: ()
            // InternalXmu2.g:3315:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDeleteLinkStatementAccess().getConcreteDeleteLinkStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,44,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDeleteLinkStatementAccess().getDeleteKeyword_1());
              		
            }
            // InternalXmu2.g:3325:3: ( (lv_source_2_0= ruleVariableExpression ) )
            // InternalXmu2.g:3326:4: (lv_source_2_0= ruleVariableExpression )
            {
            // InternalXmu2.g:3326:4: (lv_source_2_0= ruleVariableExpression )
            // InternalXmu2.g:3327:5: lv_source_2_0= ruleVariableExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeleteLinkStatementAccess().getSourceVariableExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_57);
            lv_source_2_0=ruleVariableExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeleteLinkStatementRule());
              					}
              					set(
              						current,
              						"source",
              						lv_source_2_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.VariableExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,34,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDeleteLinkStatementAccess().getFullStopKeyword_3());
              		
            }
            // InternalXmu2.g:3348:3: ( (lv_feature_4_0= RULE_NAME ) )
            // InternalXmu2.g:3349:4: (lv_feature_4_0= RULE_NAME )
            {
            // InternalXmu2.g:3349:4: (lv_feature_4_0= RULE_NAME )
            // InternalXmu2.g:3350:5: lv_feature_4_0= RULE_NAME
            {
            lv_feature_4_0=(Token)match(input,RULE_NAME,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_feature_4_0, grammarAccess.getDeleteLinkStatementAccess().getFeatureNAMETerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDeleteLinkStatementRule());
              					}
              					setWithLastConsumed(
              						current,
              						"feature",
              						lv_feature_4_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.NAME");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,30,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getDeleteLinkStatementAccess().getEqualsSignKeyword_5());
              		
            }
            // InternalXmu2.g:3370:3: ( (lv_target_6_0= ruleExpression ) )
            // InternalXmu2.g:3371:4: (lv_target_6_0= ruleExpression )
            {
            // InternalXmu2.g:3371:4: (lv_target_6_0= ruleExpression )
            // InternalXmu2.g:3372:5: lv_target_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeleteLinkStatementAccess().getTargetExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_target_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeleteLinkStatementRule());
              					}
              					set(
              						current,
              						"target",
              						lv_target_6_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeleteLinkStatement"


    // $ANTLR start "entryRuleEnforcePatternStatement"
    // InternalXmu2.g:3393:1: entryRuleEnforcePatternStatement returns [EObject current=null] : iv_ruleEnforcePatternStatement= ruleEnforcePatternStatement EOF ;
    public final EObject entryRuleEnforcePatternStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnforcePatternStatement = null;


        try {
            // InternalXmu2.g:3393:64: (iv_ruleEnforcePatternStatement= ruleEnforcePatternStatement EOF )
            // InternalXmu2.g:3394:2: iv_ruleEnforcePatternStatement= ruleEnforcePatternStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnforcePatternStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnforcePatternStatement=ruleEnforcePatternStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnforcePatternStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnforcePatternStatement"


    // $ANTLR start "ruleEnforcePatternStatement"
    // InternalXmu2.g:3400:1: ruleEnforcePatternStatement returns [EObject current=null] : (otherlv_0= 'enforce' ( (lv_pattern_1_0= rulePattern ) ) ) ;
    public final EObject ruleEnforcePatternStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_pattern_1_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3406:2: ( (otherlv_0= 'enforce' ( (lv_pattern_1_0= rulePattern ) ) ) )
            // InternalXmu2.g:3407:2: (otherlv_0= 'enforce' ( (lv_pattern_1_0= rulePattern ) ) )
            {
            // InternalXmu2.g:3407:2: (otherlv_0= 'enforce' ( (lv_pattern_1_0= rulePattern ) ) )
            // InternalXmu2.g:3408:3: otherlv_0= 'enforce' ( (lv_pattern_1_0= rulePattern ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnforcePatternStatementAccess().getEnforceKeyword_0());
              		
            }
            // InternalXmu2.g:3412:3: ( (lv_pattern_1_0= rulePattern ) )
            // InternalXmu2.g:3413:4: (lv_pattern_1_0= rulePattern )
            {
            // InternalXmu2.g:3413:4: (lv_pattern_1_0= rulePattern )
            // InternalXmu2.g:3414:5: lv_pattern_1_0= rulePattern
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnforcePatternStatementAccess().getPatternPatternParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_pattern_1_0=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnforcePatternStatementRule());
              					}
              					set(
              						current,
              						"pattern",
              						lv_pattern_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Pattern");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnforcePatternStatement"


    // $ANTLR start "entryRuleForEachStatement"
    // InternalXmu2.g:3435:1: entryRuleForEachStatement returns [EObject current=null] : iv_ruleForEachStatement= ruleForEachStatement EOF ;
    public final EObject entryRuleForEachStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForEachStatement = null;


        try {
            // InternalXmu2.g:3435:57: (iv_ruleForEachStatement= ruleForEachStatement EOF )
            // InternalXmu2.g:3436:2: iv_ruleForEachStatement= ruleForEachStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForEachStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForEachStatement=ruleForEachStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForEachStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForEachStatement"


    // $ANTLR start "ruleForEachStatement"
    // InternalXmu2.g:3442:1: ruleForEachStatement returns [EObject current=null] : (otherlv_0= 'foreach' ( (lv_pattern_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) ) ;
    public final EObject ruleForEachStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_pattern_1_0 = null;

        EObject lv_action_3_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3448:2: ( (otherlv_0= 'foreach' ( (lv_pattern_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) ) )
            // InternalXmu2.g:3449:2: (otherlv_0= 'foreach' ( (lv_pattern_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) )
            {
            // InternalXmu2.g:3449:2: (otherlv_0= 'foreach' ( (lv_pattern_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) ) )
            // InternalXmu2.g:3450:3: otherlv_0= 'foreach' ( (lv_pattern_1_0= rulePattern ) ) otherlv_2= '->' ( (lv_action_3_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForEachStatementAccess().getForeachKeyword_0());
              		
            }
            // InternalXmu2.g:3454:3: ( (lv_pattern_1_0= rulePattern ) )
            // InternalXmu2.g:3455:4: (lv_pattern_1_0= rulePattern )
            {
            // InternalXmu2.g:3455:4: (lv_pattern_1_0= rulePattern )
            // InternalXmu2.g:3456:5: lv_pattern_1_0= rulePattern
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForEachStatementAccess().getPatternPatternParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_54);
            lv_pattern_1_0=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForEachStatementRule());
              					}
              					set(
              						current,
              						"pattern",
              						lv_pattern_1_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Pattern");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getForEachStatementAccess().getHyphenMinusGreaterThanSignKeyword_2());
              		
            }
            // InternalXmu2.g:3477:3: ( (lv_action_3_0= ruleStatement ) )
            // InternalXmu2.g:3478:4: (lv_action_3_0= ruleStatement )
            {
            // InternalXmu2.g:3478:4: (lv_action_3_0= ruleStatement )
            // InternalXmu2.g:3479:5: lv_action_3_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForEachStatementAccess().getActionStatementParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_action_3_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForEachStatementRule());
              					}
              					set(
              						current,
              						"action",
              						lv_action_3_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForEachStatement"


    // $ANTLR start "entryRuleRuleCallStatement"
    // InternalXmu2.g:3500:1: entryRuleRuleCallStatement returns [EObject current=null] : iv_ruleRuleCallStatement= ruleRuleCallStatement EOF ;
    public final EObject entryRuleRuleCallStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallStatement = null;


        try {
            // InternalXmu2.g:3500:58: (iv_ruleRuleCallStatement= ruleRuleCallStatement EOF )
            // InternalXmu2.g:3501:2: iv_ruleRuleCallStatement= ruleRuleCallStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleCallStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleCallStatement=ruleRuleCallStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleCallStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCallStatement"


    // $ANTLR start "ruleRuleCallStatement"
    // InternalXmu2.g:3507:1: ruleRuleCallStatement returns [EObject current=null] : ( ( (otherlv_0= RULE_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleRuleCallStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3513:2: ( ( ( (otherlv_0= RULE_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalXmu2.g:3514:2: ( ( (otherlv_0= RULE_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalXmu2.g:3514:2: ( ( (otherlv_0= RULE_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            // InternalXmu2.g:3515:3: ( (otherlv_0= RULE_NAME ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalXmu2.g:3515:3: ( (otherlv_0= RULE_NAME ) )
            // InternalXmu2.g:3516:4: (otherlv_0= RULE_NAME )
            {
            // InternalXmu2.g:3516:4: (otherlv_0= RULE_NAME )
            // InternalXmu2.g:3517:5: otherlv_0= RULE_NAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRuleCallStatementRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_NAME,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getRuleCallStatementAccess().getRuleAbstractRuleCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRuleCallStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalXmu2.g:3532:3: ( ( (lv_parameters_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_NAME||(LA52_0>=RULE_INT && LA52_0<=RULE_BOOLEAN)||LA52_0==19||(LA52_0>=58 && LA52_0<=61)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalXmu2.g:3533:4: ( (lv_parameters_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) ) )*
                    {
                    // InternalXmu2.g:3533:4: ( (lv_parameters_2_0= ruleExpression ) )
                    // InternalXmu2.g:3534:5: (lv_parameters_2_0= ruleExpression )
                    {
                    // InternalXmu2.g:3534:5: (lv_parameters_2_0= ruleExpression )
                    // InternalXmu2.g:3535:6: lv_parameters_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRuleCallStatementAccess().getParametersExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_parameters_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRuleCallStatementRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_2_0,
                      							"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalXmu2.g:3552:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==20) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalXmu2.g:3553:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getRuleCallStatementAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalXmu2.g:3557:5: ( (lv_parameters_4_0= ruleExpression ) )
                    	    // InternalXmu2.g:3558:6: (lv_parameters_4_0= ruleExpression )
                    	    {
                    	    // InternalXmu2.g:3558:6: (lv_parameters_4_0= ruleExpression )
                    	    // InternalXmu2.g:3559:7: lv_parameters_4_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRuleCallStatementAccess().getParametersExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_parameters_4_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRuleCallStatementRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_4_0,
                    	      								"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRuleCallStatementAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleCallStatement"


    // $ANTLR start "entryRuleSkip"
    // InternalXmu2.g:3586:1: entryRuleSkip returns [EObject current=null] : iv_ruleSkip= ruleSkip EOF ;
    public final EObject entryRuleSkip() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSkip = null;


        try {
            // InternalXmu2.g:3586:45: (iv_ruleSkip= ruleSkip EOF )
            // InternalXmu2.g:3587:2: iv_ruleSkip= ruleSkip EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSkipRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSkip=ruleSkip();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSkip; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSkip"


    // $ANTLR start "ruleSkip"
    // InternalXmu2.g:3593:1: ruleSkip returns [EObject current=null] : ( () otherlv_1= 'skip' ) ;
    public final EObject ruleSkip() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalXmu2.g:3599:2: ( ( () otherlv_1= 'skip' ) )
            // InternalXmu2.g:3600:2: ( () otherlv_1= 'skip' )
            {
            // InternalXmu2.g:3600:2: ( () otherlv_1= 'skip' )
            // InternalXmu2.g:3601:3: () otherlv_1= 'skip'
            {
            // InternalXmu2.g:3601:3: ()
            // InternalXmu2.g:3602:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSkipAccess().getSkipAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSkipAccess().getSkipKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSkip"


    // $ANTLR start "entryRuleFail"
    // InternalXmu2.g:3616:1: entryRuleFail returns [EObject current=null] : iv_ruleFail= ruleFail EOF ;
    public final EObject entryRuleFail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFail = null;


        try {
            // InternalXmu2.g:3616:45: (iv_ruleFail= ruleFail EOF )
            // InternalXmu2.g:3617:2: iv_ruleFail= ruleFail EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFailRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFail=ruleFail();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFail; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFail"


    // $ANTLR start "ruleFail"
    // InternalXmu2.g:3623:1: ruleFail returns [EObject current=null] : ( () otherlv_1= 'fail' ( (lv_expression_2_0= ruleExpression ) )? ) ;
    public final EObject ruleFail() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3629:2: ( ( () otherlv_1= 'fail' ( (lv_expression_2_0= ruleExpression ) )? ) )
            // InternalXmu2.g:3630:2: ( () otherlv_1= 'fail' ( (lv_expression_2_0= ruleExpression ) )? )
            {
            // InternalXmu2.g:3630:2: ( () otherlv_1= 'fail' ( (lv_expression_2_0= ruleExpression ) )? )
            // InternalXmu2.g:3631:3: () otherlv_1= 'fail' ( (lv_expression_2_0= ruleExpression ) )?
            {
            // InternalXmu2.g:3631:3: ()
            // InternalXmu2.g:3632:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFailAccess().getFailAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFailAccess().getFailKeyword_1());
              		
            }
            // InternalXmu2.g:3642:3: ( (lv_expression_2_0= ruleExpression ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_INT && LA53_0<=RULE_BOOLEAN)||LA53_0==19||(LA53_0>=58 && LA53_0<=61)) ) {
                alt53=1;
            }
            else if ( (LA53_0==RULE_NAME) ) {
                int LA53_2 = input.LA(2);

                if ( (LA53_2==EOF||LA53_2==RULE_NAME||(LA53_2>=25 && LA53_2<=27)||LA53_2==30||LA53_2==32||LA53_2==34||(LA53_2>=36 && LA53_2<=38)||(LA53_2>=41 && LA53_2<=48)||(LA53_2>=61 && LA53_2<=73)) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalXmu2.g:3643:4: (lv_expression_2_0= ruleExpression )
                    {
                    // InternalXmu2.g:3643:4: (lv_expression_2_0= ruleExpression )
                    // InternalXmu2.g:3644:5: lv_expression_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFailAccess().getExpressionExpressionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFailRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_2_0,
                      						"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFail"


    // $ANTLR start "entryRuleAssignStatement"
    // InternalXmu2.g:3665:1: entryRuleAssignStatement returns [EObject current=null] : iv_ruleAssignStatement= ruleAssignStatement EOF ;
    public final EObject entryRuleAssignStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignStatement = null;


        try {
            // InternalXmu2.g:3665:56: (iv_ruleAssignStatement= ruleAssignStatement EOF )
            // InternalXmu2.g:3666:2: iv_ruleAssignStatement= ruleAssignStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignStatement=ruleAssignStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignStatement"


    // $ANTLR start "ruleAssignStatement"
    // InternalXmu2.g:3672:1: ruleAssignStatement returns [EObject current=null] : ( ( (lv_updatedVariable_0_0= ruleVariableExpression ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_updatedVariable_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3678:2: ( ( ( (lv_updatedVariable_0_0= ruleVariableExpression ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalXmu2.g:3679:2: ( ( (lv_updatedVariable_0_0= ruleVariableExpression ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalXmu2.g:3679:2: ( ( (lv_updatedVariable_0_0= ruleVariableExpression ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleExpression ) ) )
            // InternalXmu2.g:3680:3: ( (lv_updatedVariable_0_0= ruleVariableExpression ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalXmu2.g:3680:3: ( (lv_updatedVariable_0_0= ruleVariableExpression ) )
            // InternalXmu2.g:3681:4: (lv_updatedVariable_0_0= ruleVariableExpression )
            {
            // InternalXmu2.g:3681:4: (lv_updatedVariable_0_0= ruleVariableExpression )
            // InternalXmu2.g:3682:5: lv_updatedVariable_0_0= ruleVariableExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignStatementAccess().getUpdatedVariableVariableExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_59);
            lv_updatedVariable_0_0=ruleVariableExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignStatementRule());
              					}
              					set(
              						current,
              						"updatedVariable",
              						lv_updatedVariable_0_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.VariableExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,49,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAssignStatementAccess().getColonColonEqualsSignKeyword_1());
              		
            }
            // InternalXmu2.g:3703:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalXmu2.g:3704:4: (lv_value_2_0= ruleExpression )
            {
            // InternalXmu2.g:3704:4: (lv_value_2_0= ruleExpression )
            // InternalXmu2.g:3705:5: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignStatementAccess().getValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignStatementRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"edu.ustb.sei.mde.xmuxtext.Xmu2.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignStatement"


    // $ANTLR start "entryRuleStatement"
    // InternalXmu2.g:3726:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalXmu2.g:3726:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalXmu2.g:3727:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalXmu2.g:3733:1: ruleStatement returns [EObject current=null] : (this_BlockStatement_0= ruleBlockStatement | this_UpdateStatement_1= ruleUpdateStatement | this_SwitchStatement_2= ruleSwitchStatement | this_DeleteNodeStatement_3= ruleDeleteNodeStatement | this_DeleteLinkStatement_4= ruleDeleteLinkStatement | this_EnforcePatternStatement_5= ruleEnforcePatternStatement | this_ForEachStatement_6= ruleForEachStatement | this_RuleCallStatement_7= ruleRuleCallStatement | this_Skip_8= ruleSkip | this_Fail_9= ruleFail | this_AssignStatement_10= ruleAssignStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_BlockStatement_0 = null;

        EObject this_UpdateStatement_1 = null;

        EObject this_SwitchStatement_2 = null;

        EObject this_DeleteNodeStatement_3 = null;

        EObject this_DeleteLinkStatement_4 = null;

        EObject this_EnforcePatternStatement_5 = null;

        EObject this_ForEachStatement_6 = null;

        EObject this_RuleCallStatement_7 = null;

        EObject this_Skip_8 = null;

        EObject this_Fail_9 = null;

        EObject this_AssignStatement_10 = null;



        	enterRule();

        try {
            // InternalXmu2.g:3739:2: ( (this_BlockStatement_0= ruleBlockStatement | this_UpdateStatement_1= ruleUpdateStatement | this_SwitchStatement_2= ruleSwitchStatement | this_DeleteNodeStatement_3= ruleDeleteNodeStatement | this_DeleteLinkStatement_4= ruleDeleteLinkStatement | this_EnforcePatternStatement_5= ruleEnforcePatternStatement | this_ForEachStatement_6= ruleForEachStatement | this_RuleCallStatement_7= ruleRuleCallStatement | this_Skip_8= ruleSkip | this_Fail_9= ruleFail | this_AssignStatement_10= ruleAssignStatement ) )
            // InternalXmu2.g:3740:2: (this_BlockStatement_0= ruleBlockStatement | this_UpdateStatement_1= ruleUpdateStatement | this_SwitchStatement_2= ruleSwitchStatement | this_DeleteNodeStatement_3= ruleDeleteNodeStatement | this_DeleteLinkStatement_4= ruleDeleteLinkStatement | this_EnforcePatternStatement_5= ruleEnforcePatternStatement | this_ForEachStatement_6= ruleForEachStatement | this_RuleCallStatement_7= ruleRuleCallStatement | this_Skip_8= ruleSkip | this_Fail_9= ruleFail | this_AssignStatement_10= ruleAssignStatement )
            {
            // InternalXmu2.g:3740:2: (this_BlockStatement_0= ruleBlockStatement | this_UpdateStatement_1= ruleUpdateStatement | this_SwitchStatement_2= ruleSwitchStatement | this_DeleteNodeStatement_3= ruleDeleteNodeStatement | this_DeleteLinkStatement_4= ruleDeleteLinkStatement | this_EnforcePatternStatement_5= ruleEnforcePatternStatement | this_ForEachStatement_6= ruleForEachStatement | this_RuleCallStatement_7= ruleRuleCallStatement | this_Skip_8= ruleSkip | this_Fail_9= ruleFail | this_AssignStatement_10= ruleAssignStatement )
            int alt54=11;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // InternalXmu2.g:3741:3: this_BlockStatement_0= ruleBlockStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getBlockStatementParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BlockStatement_0=ruleBlockStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockStatement_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalXmu2.g:3750:3: this_UpdateStatement_1= ruleUpdateStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getUpdateStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UpdateStatement_1=ruleUpdateStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UpdateStatement_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalXmu2.g:3759:3: this_SwitchStatement_2= ruleSwitchStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatementParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SwitchStatement_2=ruleSwitchStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SwitchStatement_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalXmu2.g:3768:3: this_DeleteNodeStatement_3= ruleDeleteNodeStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getDeleteNodeStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DeleteNodeStatement_3=ruleDeleteNodeStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DeleteNodeStatement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalXmu2.g:3777:3: this_DeleteLinkStatement_4= ruleDeleteLinkStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getDeleteLinkStatementParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DeleteLinkStatement_4=ruleDeleteLinkStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DeleteLinkStatement_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalXmu2.g:3786:3: this_EnforcePatternStatement_5= ruleEnforcePatternStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getEnforcePatternStatementParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EnforcePatternStatement_5=ruleEnforcePatternStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EnforcePatternStatement_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalXmu2.g:3795:3: this_ForEachStatement_6= ruleForEachStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getForEachStatementParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ForEachStatement_6=ruleForEachStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ForEachStatement_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalXmu2.g:3804:3: this_RuleCallStatement_7= ruleRuleCallStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getRuleCallStatementParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RuleCallStatement_7=ruleRuleCallStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RuleCallStatement_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalXmu2.g:3813:3: this_Skip_8= ruleSkip
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSkipParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Skip_8=ruleSkip();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Skip_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalXmu2.g:3822:3: this_Fail_9= ruleFail
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getFailParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Fail_9=ruleFail();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Fail_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalXmu2.g:3831:3: this_AssignStatement_10= ruleAssignStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getAssignStatementParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AssignStatement_10=ruleAssignStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignStatement_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "ruleTag"
    // InternalXmu2.g:3843:1: ruleTag returns [Enumerator current=null] : ( (enumLiteral_0= 'source' ) | (enumLiteral_1= 'view' ) ) ;
    public final Enumerator ruleTag() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalXmu2.g:3849:2: ( ( (enumLiteral_0= 'source' ) | (enumLiteral_1= 'view' ) ) )
            // InternalXmu2.g:3850:2: ( (enumLiteral_0= 'source' ) | (enumLiteral_1= 'view' ) )
            {
            // InternalXmu2.g:3850:2: ( (enumLiteral_0= 'source' ) | (enumLiteral_1= 'view' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==50) ) {
                alt55=1;
            }
            else if ( (LA55_0==51) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalXmu2.g:3851:3: (enumLiteral_0= 'source' )
                    {
                    // InternalXmu2.g:3851:3: (enumLiteral_0= 'source' )
                    // InternalXmu2.g:3852:4: enumLiteral_0= 'source'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTagAccess().getSourceEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTagAccess().getSourceEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:3859:3: (enumLiteral_1= 'view' )
                    {
                    // InternalXmu2.g:3859:3: (enumLiteral_1= 'view' )
                    // InternalXmu2.g:3860:4: enumLiteral_1= 'view'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTagAccess().getViewEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getTagAccess().getViewEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTag"


    // $ANTLR start "ruleLoopOperator"
    // InternalXmu2.g:3870:1: ruleLoopOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'select' ) | (enumLiteral_1= 'forAll' ) | (enumLiteral_2= 'exists' ) ) ;
    public final Enumerator ruleLoopOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalXmu2.g:3876:2: ( ( (enumLiteral_0= 'select' ) | (enumLiteral_1= 'forAll' ) | (enumLiteral_2= 'exists' ) ) )
            // InternalXmu2.g:3877:2: ( (enumLiteral_0= 'select' ) | (enumLiteral_1= 'forAll' ) | (enumLiteral_2= 'exists' ) )
            {
            // InternalXmu2.g:3877:2: ( (enumLiteral_0= 'select' ) | (enumLiteral_1= 'forAll' ) | (enumLiteral_2= 'exists' ) )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt56=1;
                }
                break;
            case 53:
                {
                alt56=2;
                }
                break;
            case 54:
                {
                alt56=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalXmu2.g:3878:3: (enumLiteral_0= 'select' )
                    {
                    // InternalXmu2.g:3878:3: (enumLiteral_0= 'select' )
                    // InternalXmu2.g:3879:4: enumLiteral_0= 'select'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getLoopOperatorAccess().getSelectEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getLoopOperatorAccess().getSelectEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:3886:3: (enumLiteral_1= 'forAll' )
                    {
                    // InternalXmu2.g:3886:3: (enumLiteral_1= 'forAll' )
                    // InternalXmu2.g:3887:4: enumLiteral_1= 'forAll'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getLoopOperatorAccess().getForAllEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getLoopOperatorAccess().getForAllEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXmu2.g:3894:3: (enumLiteral_2= 'exists' )
                    {
                    // InternalXmu2.g:3894:3: (enumLiteral_2= 'exists' )
                    // InternalXmu2.g:3895:4: enumLiteral_2= 'exists'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getLoopOperatorAccess().getExistsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getLoopOperatorAccess().getExistsEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopOperator"


    // $ANTLR start "rulePositionOperator"
    // InternalXmu2.g:3905:1: rulePositionOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) ) ;
    public final Enumerator rulePositionOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalXmu2.g:3911:2: ( ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) ) )
            // InternalXmu2.g:3912:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) )
            {
            // InternalXmu2.g:3912:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt57=1;
                }
                break;
            case 56:
                {
                alt57=2;
                }
                break;
            case 57:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalXmu2.g:3913:3: (enumLiteral_0= 'first' )
                    {
                    // InternalXmu2.g:3913:3: (enumLiteral_0= 'first' )
                    // InternalXmu2.g:3914:4: enumLiteral_0= 'first'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPositionOperatorAccess().getFirstEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getPositionOperatorAccess().getFirstEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:3921:3: (enumLiteral_1= 'last' )
                    {
                    // InternalXmu2.g:3921:3: (enumLiteral_1= 'last' )
                    // InternalXmu2.g:3922:4: enumLiteral_1= 'last'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPositionOperatorAccess().getLastEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getPositionOperatorAccess().getLastEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXmu2.g:3929:3: (enumLiteral_2= 'at' )
                    {
                    // InternalXmu2.g:3929:3: (enumLiteral_2= 'at' )
                    // InternalXmu2.g:3930:4: enumLiteral_2= 'at'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPositionOperatorAccess().getAtEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getPositionOperatorAccess().getAtEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePositionOperator"


    // $ANTLR start "ruleEmptyValue"
    // InternalXmu2.g:3940:1: ruleEmptyValue returns [Enumerator current=null] : ( (enumLiteral_0= 'null' ) | (enumLiteral_1= 'undefined' ) ) ;
    public final Enumerator ruleEmptyValue() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalXmu2.g:3946:2: ( ( (enumLiteral_0= 'null' ) | (enumLiteral_1= 'undefined' ) ) )
            // InternalXmu2.g:3947:2: ( (enumLiteral_0= 'null' ) | (enumLiteral_1= 'undefined' ) )
            {
            // InternalXmu2.g:3947:2: ( (enumLiteral_0= 'null' ) | (enumLiteral_1= 'undefined' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==58) ) {
                alt58=1;
            }
            else if ( (LA58_0==59) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalXmu2.g:3948:3: (enumLiteral_0= 'null' )
                    {
                    // InternalXmu2.g:3948:3: (enumLiteral_0= 'null' )
                    // InternalXmu2.g:3949:4: enumLiteral_0= 'null'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEmptyValueAccess().getNullValueEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getEmptyValueAccess().getNullValueEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:3956:3: (enumLiteral_1= 'undefined' )
                    {
                    // InternalXmu2.g:3956:3: (enumLiteral_1= 'undefined' )
                    // InternalXmu2.g:3957:4: enumLiteral_1= 'undefined'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEmptyValueAccess().getEmptyValueEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getEmptyValueAccess().getEmptyValueEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEmptyValue"


    // $ANTLR start "ruleUnaryOperator"
    // InternalXmu2.g:3967:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'not' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalXmu2.g:3973:2: ( ( (enumLiteral_0= 'not' ) | (enumLiteral_1= '-' ) ) )
            // InternalXmu2.g:3974:2: ( (enumLiteral_0= 'not' ) | (enumLiteral_1= '-' ) )
            {
            // InternalXmu2.g:3974:2: ( (enumLiteral_0= 'not' ) | (enumLiteral_1= '-' ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==60) ) {
                alt59=1;
            }
            else if ( (LA59_0==61) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalXmu2.g:3975:3: (enumLiteral_0= 'not' )
                    {
                    // InternalXmu2.g:3975:3: (enumLiteral_0= 'not' )
                    // InternalXmu2.g:3976:4: enumLiteral_0= 'not'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOperatorAccess().getNotEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getNotEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:3983:3: (enumLiteral_1= '-' )
                    {
                    // InternalXmu2.g:3983:3: (enumLiteral_1= '-' )
                    // InternalXmu2.g:3984:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOperatorAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getMinusEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // InternalXmu2.g:3994:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalXmu2.g:4000:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) ) )
            // InternalXmu2.g:4001:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) )
            {
            // InternalXmu2.g:4001:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==62) ) {
                alt60=1;
            }
            else if ( (LA60_0==63) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalXmu2.g:4002:3: (enumLiteral_0= '*' )
                    {
                    // InternalXmu2.g:4002:3: (enumLiteral_0= '*' )
                    // InternalXmu2.g:4003:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:4010:3: (enumLiteral_1= '/' )
                    {
                    // InternalXmu2.g:4010:3: (enumLiteral_1= '/' )
                    // InternalXmu2.g:4011:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // InternalXmu2.g:4021:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '++' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalXmu2.g:4027:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '++' ) ) )
            // InternalXmu2.g:4028:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '++' ) )
            {
            // InternalXmu2.g:4028:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '++' ) )
            int alt61=3;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt61=1;
                }
                break;
            case 61:
                {
                alt61=2;
                }
                break;
            case 65:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalXmu2.g:4029:3: (enumLiteral_0= '+' )
                    {
                    // InternalXmu2.g:4029:3: (enumLiteral_0= '+' )
                    // InternalXmu2.g:4030:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getAddEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:4037:3: (enumLiteral_1= '-' )
                    {
                    // InternalXmu2.g:4037:3: (enumLiteral_1= '-' )
                    // InternalXmu2.g:4038:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOperatorAccess().getSubEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOperatorAccess().getSubEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXmu2.g:4045:3: (enumLiteral_2= '++' )
                    {
                    // InternalXmu2.g:4045:3: (enumLiteral_2= '++' )
                    // InternalXmu2.g:4046:4: enumLiteral_2= '++'
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOperatorAccess().getAppendEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAdditiveOperatorAccess().getAppendEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalXmu2.g:4056:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>' ) | (enumLiteral_4= '>=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalXmu2.g:4062:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>' ) | (enumLiteral_4= '>=' ) ) )
            // InternalXmu2.g:4063:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>' ) | (enumLiteral_4= '>=' ) )
            {
            // InternalXmu2.g:4063:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>' ) | (enumLiteral_4= '>=' ) )
            int alt62=5;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt62=1;
                }
                break;
            case 66:
                {
                alt62=2;
                }
                break;
            case 67:
                {
                alt62=3;
                }
                break;
            case 68:
                {
                alt62=4;
                }
                break;
            case 69:
                {
                alt62=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalXmu2.g:4064:3: (enumLiteral_0= '=' )
                    {
                    // InternalXmu2.g:4064:3: (enumLiteral_0= '=' )
                    // InternalXmu2.g:4065:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getEqualEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:4072:3: (enumLiteral_1= '<' )
                    {
                    // InternalXmu2.g:4072:3: (enumLiteral_1= '<' )
                    // InternalXmu2.g:4073:4: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getLessEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getLessEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXmu2.g:4080:3: (enumLiteral_2= '<=' )
                    {
                    // InternalXmu2.g:4080:3: (enumLiteral_2= '<=' )
                    // InternalXmu2.g:4081:4: enumLiteral_2= '<='
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getLessEqualEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXmu2.g:4088:3: (enumLiteral_3= '>' )
                    {
                    // InternalXmu2.g:4088:3: (enumLiteral_3= '>' )
                    // InternalXmu2.g:4089:4: enumLiteral_3= '>'
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalXmu2.g:4096:3: (enumLiteral_4= '>=' )
                    {
                    // InternalXmu2.g:4096:3: (enumLiteral_4= '>=' )
                    // InternalXmu2.g:4097:4: enumLiteral_4= '>='
                    {
                    enumLiteral_4=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "ruleActionType"
    // InternalXmu2.g:4107:1: ruleActionType returns [Enumerator current=null] : ( (enumLiteral_0= 'match' ) | (enumLiteral_1= 'unmatchs' ) | (enumLiteral_2= 'unmatchv' ) | (enumLiteral_3= 'default' ) ) ;
    public final Enumerator ruleActionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalXmu2.g:4113:2: ( ( (enumLiteral_0= 'match' ) | (enumLiteral_1= 'unmatchs' ) | (enumLiteral_2= 'unmatchv' ) | (enumLiteral_3= 'default' ) ) )
            // InternalXmu2.g:4114:2: ( (enumLiteral_0= 'match' ) | (enumLiteral_1= 'unmatchs' ) | (enumLiteral_2= 'unmatchv' ) | (enumLiteral_3= 'default' ) )
            {
            // InternalXmu2.g:4114:2: ( (enumLiteral_0= 'match' ) | (enumLiteral_1= 'unmatchs' ) | (enumLiteral_2= 'unmatchv' ) | (enumLiteral_3= 'default' ) )
            int alt63=4;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt63=1;
                }
                break;
            case 71:
                {
                alt63=2;
                }
                break;
            case 72:
                {
                alt63=3;
                }
                break;
            case 73:
                {
                alt63=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalXmu2.g:4115:3: (enumLiteral_0= 'match' )
                    {
                    // InternalXmu2.g:4115:3: (enumLiteral_0= 'match' )
                    // InternalXmu2.g:4116:4: enumLiteral_0= 'match'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getActionTypeAccess().getMatchEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getActionTypeAccess().getMatchEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXmu2.g:4123:3: (enumLiteral_1= 'unmatchs' )
                    {
                    // InternalXmu2.g:4123:3: (enumLiteral_1= 'unmatchs' )
                    // InternalXmu2.g:4124:4: enumLiteral_1= 'unmatchs'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getActionTypeAccess().getUnmatchsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getActionTypeAccess().getUnmatchsEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXmu2.g:4131:3: (enumLiteral_2= 'unmatchv' )
                    {
                    // InternalXmu2.g:4131:3: (enumLiteral_2= 'unmatchv' )
                    // InternalXmu2.g:4132:4: enumLiteral_2= 'unmatchv'
                    {
                    enumLiteral_2=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getActionTypeAccess().getUnmatchvEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getActionTypeAccess().getUnmatchvEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXmu2.g:4139:3: (enumLiteral_3= 'default' )
                    {
                    // InternalXmu2.g:4139:3: (enumLiteral_3= 'default' )
                    // InternalXmu2.g:4140:4: enumLiteral_3= 'default'
                    {
                    enumLiteral_3=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getActionTypeAccess().getDefaultEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getActionTypeAccess().getDefaultEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionType"

    // $ANTLR start synpred1_InternalXmu2
    public final void synpred1_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:996:4: ( rulePropertyPatternExpression )
        // InternalXmu2.g:996:5: rulePropertyPatternExpression
        {
        pushFollow(FOLLOW_2);
        rulePropertyPatternExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalXmu2

    // $ANTLR start synpred2_InternalXmu2
    public final void synpred2_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:1595:4: ( ruleLoopPath )
        // InternalXmu2.g:1595:5: ruleLoopPath
        {
        pushFollow(FOLLOW_2);
        ruleLoopPath();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalXmu2

    // $ANTLR start synpred3_InternalXmu2
    public final void synpred3_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:1616:4: ( ruleFeaturePath )
        // InternalXmu2.g:1616:5: ruleFeaturePath
        {
        pushFollow(FOLLOW_2);
        ruleFeaturePath();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalXmu2

    // $ANTLR start synpred4_InternalXmu2
    public final void synpred4_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:2232:4: ( ruleUnaryExpression )
        // InternalXmu2.g:2232:5: ruleUnaryExpression
        {
        pushFollow(FOLLOW_2);
        ruleUnaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalXmu2

    // $ANTLR start synpred5_InternalXmu2
    public final void synpred5_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:2349:4: ( ruleMultiplicativeExpression )
        // InternalXmu2.g:2349:5: ruleMultiplicativeExpression
        {
        pushFollow(FOLLOW_2);
        ruleMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalXmu2

    // $ANTLR start synpred6_InternalXmu2
    public final void synpred6_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:2464:4: ( ruleAdditiveExpression )
        // InternalXmu2.g:2464:5: ruleAdditiveExpression
        {
        pushFollow(FOLLOW_2);
        ruleAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalXmu2

    // $ANTLR start synpred7_InternalXmu2
    public final void synpred7_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:2566:4: ( ruleRelationalExpression )
        // InternalXmu2.g:2566:5: ruleRelationalExpression
        {
        pushFollow(FOLLOW_2);
        ruleRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalXmu2

    // $ANTLR start synpred8_InternalXmu2
    public final void synpred8_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:2668:4: ( ruleBooleanAndExpression )
        // InternalXmu2.g:2668:5: ruleBooleanAndExpression
        {
        pushFollow(FOLLOW_2);
        ruleBooleanAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalXmu2

    // $ANTLR start synpred9_InternalXmu2
    public final void synpred9_InternalXmu2_fragment() throws RecognitionException {   
        // InternalXmu2.g:2707:4: ( ruleBooleanOrExpression )
        // InternalXmu2.g:2707:5: ruleBooleanOrExpression
        {
        pushFollow(FOLLOW_2);
        ruleBooleanOrExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalXmu2

    // Delegated rules

    public final boolean synpred9_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalXmu2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalXmu2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA31 dfa31 = new DFA31(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA54 dfa54 = new DFA54(this);
    static final String dfa_1s = "\54\uffff";
    static final String dfa_2s = "\7\uffff\1\10\44\uffff";
    static final String dfa_3s = "\1\40\1\64\1\4\4\uffff\1\4\44\uffff";
    static final String dfa_4s = "\1\42\1\71\1\4\4\uffff\1\111\44\uffff";
    static final String dfa_5s = "\3\uffff\1\2\3\1\1\uffff\43\3\1\4";
    static final String dfa_6s = "\1\uffff\1\1\5\uffff\1\0\44\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\uffff\1\2",
            "\1\4\1\5\1\6\3\3",
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\41\16\uffff\1\53\1\30\1\32\1\uffff\1\27\1\uffff\1\33\1\44\1\31\2\uffff\1\20\1\uffff\1\11\1\uffff\1\12\1\uffff\1\25\1\26\1\34\2\uffff\1\35\1\51\1\52\1\36\1\37\1\40\1\42\1\43\14\uffff\1\16\1\13\1\14\1\15\1\17\1\21\1\22\1\23\1\24\1\45\1\46\1\47\1\50",
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
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1593:2: ( ( ( ruleLoopPath )=>this_LoopPath_0= ruleLoopPath ) | this_PositionPath_1= rulePositionPath | ( ( ruleFeaturePath )=>this_FeaturePath_2= ruleFeaturePath ) | this_OperationPath_3= ruleOperationPath )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_7 = input.LA(1);

                         
                        int index31_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA31_7==EOF) && (synpred3_InternalXmu2())) {s = 8;}

                        else if ( (LA31_7==32) && (synpred3_InternalXmu2())) {s = 9;}

                        else if ( (LA31_7==34) && (synpred3_InternalXmu2())) {s = 10;}

                        else if ( (LA31_7==62) && (synpred3_InternalXmu2())) {s = 11;}

                        else if ( (LA31_7==63) && (synpred3_InternalXmu2())) {s = 12;}

                        else if ( (LA31_7==64) && (synpred3_InternalXmu2())) {s = 13;}

                        else if ( (LA31_7==61) && (synpred3_InternalXmu2())) {s = 14;}

                        else if ( (LA31_7==65) && (synpred3_InternalXmu2())) {s = 15;}

                        else if ( (LA31_7==30) && (synpred3_InternalXmu2())) {s = 16;}

                        else if ( (LA31_7==66) && (synpred3_InternalXmu2())) {s = 17;}

                        else if ( (LA31_7==67) && (synpred3_InternalXmu2())) {s = 18;}

                        else if ( (LA31_7==68) && (synpred3_InternalXmu2())) {s = 19;}

                        else if ( (LA31_7==69) && (synpred3_InternalXmu2())) {s = 20;}

                        else if ( (LA31_7==36) && (synpred3_InternalXmu2())) {s = 21;}

                        else if ( (LA31_7==37) && (synpred3_InternalXmu2())) {s = 22;}

                        else if ( (LA31_7==23) && (synpred3_InternalXmu2())) {s = 23;}

                        else if ( (LA31_7==20) && (synpred3_InternalXmu2())) {s = 24;}

                        else if ( (LA31_7==27) && (synpred3_InternalXmu2())) {s = 25;}

                        else if ( (LA31_7==21) && (synpred3_InternalXmu2())) {s = 26;}

                        else if ( (LA31_7==25) && (synpred3_InternalXmu2())) {s = 27;}

                        else if ( (LA31_7==38) && (synpred3_InternalXmu2())) {s = 28;}

                        else if ( (LA31_7==41) && (synpred3_InternalXmu2())) {s = 29;}

                        else if ( (LA31_7==44) && (synpred3_InternalXmu2())) {s = 30;}

                        else if ( (LA31_7==45) && (synpred3_InternalXmu2())) {s = 31;}

                        else if ( (LA31_7==46) && (synpred3_InternalXmu2())) {s = 32;}

                        else if ( (LA31_7==RULE_NAME) && (synpred3_InternalXmu2())) {s = 33;}

                        else if ( (LA31_7==47) && (synpred3_InternalXmu2())) {s = 34;}

                        else if ( (LA31_7==48) && (synpred3_InternalXmu2())) {s = 35;}

                        else if ( (LA31_7==26) && (synpred3_InternalXmu2())) {s = 36;}

                        else if ( (LA31_7==70) && (synpred3_InternalXmu2())) {s = 37;}

                        else if ( (LA31_7==71) && (synpred3_InternalXmu2())) {s = 38;}

                        else if ( (LA31_7==72) && (synpred3_InternalXmu2())) {s = 39;}

                        else if ( (LA31_7==73) && (synpred3_InternalXmu2())) {s = 40;}

                        else if ( (LA31_7==42) && (synpred3_InternalXmu2())) {s = 41;}

                        else if ( (LA31_7==43) && (synpred3_InternalXmu2())) {s = 42;}

                        else if ( (LA31_7==19) ) {s = 43;}

                         
                        input.seek(index31_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_1 = input.LA(1);

                         
                        int index31_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA31_1>=55 && LA31_1<=57)) ) {s = 3;}

                        else if ( (LA31_1==52) && (synpred2_InternalXmu2())) {s = 4;}

                        else if ( (LA31_1==53) && (synpred2_InternalXmu2())) {s = 5;}

                        else if ( (LA31_1==54) && (synpred2_InternalXmu2())) {s = 6;}

                         
                        input.seek(index31_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\17\uffff";
    static final String dfa_9s = "\1\4\14\0\2\uffff";
    static final String dfa_10s = "\1\75\14\0\2\uffff";
    static final String dfa_11s = "\15\uffff\1\1\1\2";
    static final String dfa_12s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\2\uffff}>";
    static final String[] dfa_13s = {
            "\1\4\1\uffff\1\10\1\14\1\12\1\13\1\7\1\11\7\uffff\1\3\46\uffff\1\5\1\6\1\1\1\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2347:2: ( ( ( ruleMultiplicativeExpression )=>this_MultiplicativeExpression_0= ruleMultiplicativeExpression ) | this_MultiplicativeExpressionChild_1= ruleMultiplicativeExpressionChild )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_3 = input.LA(1);

                         
                        int index39_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA39_4 = input.LA(1);

                         
                        int index39_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA39_5 = input.LA(1);

                         
                        int index39_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA39_6 = input.LA(1);

                         
                        int index39_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA39_7 = input.LA(1);

                         
                        int index39_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA39_8 = input.LA(1);

                         
                        int index39_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA39_9 = input.LA(1);

                         
                        int index39_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA39_10 = input.LA(1);

                         
                        int index39_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA39_11 = input.LA(1);

                         
                        int index39_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA39_12 = input.LA(1);

                         
                        int index39_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index39_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2462:2: ( ( ( ruleAdditiveExpression )=>this_AdditiveExpression_0= ruleAdditiveExpression ) | this_AdditiveExpressionChild_1= ruleAdditiveExpressionChild )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_1 = input.LA(1);

                         
                        int index40_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_2 = input.LA(1);

                         
                        int index40_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_3 = input.LA(1);

                         
                        int index40_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA40_4 = input.LA(1);

                         
                        int index40_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA40_5 = input.LA(1);

                         
                        int index40_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA40_6 = input.LA(1);

                         
                        int index40_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA40_7 = input.LA(1);

                         
                        int index40_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA40_8 = input.LA(1);

                         
                        int index40_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA40_9 = input.LA(1);

                         
                        int index40_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA40_10 = input.LA(1);

                         
                        int index40_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA40_11 = input.LA(1);

                         
                        int index40_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA40_12 = input.LA(1);

                         
                        int index40_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index40_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2564:2: ( ( ( ruleRelationalExpression )=>this_RelationalExpression_0= ruleRelationalExpression ) | this_RelationalExpressionChild_1= ruleRelationalExpressionChild )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_1 = input.LA(1);

                         
                        int index42_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_2 = input.LA(1);

                         
                        int index42_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_3 = input.LA(1);

                         
                        int index42_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_4 = input.LA(1);

                         
                        int index42_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_5 = input.LA(1);

                         
                        int index42_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_6 = input.LA(1);

                         
                        int index42_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_7 = input.LA(1);

                         
                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA42_8 = input.LA(1);

                         
                        int index42_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA42_9 = input.LA(1);

                         
                        int index42_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA42_10 = input.LA(1);

                         
                        int index42_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA42_11 = input.LA(1);

                         
                        int index42_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA42_12 = input.LA(1);

                         
                        int index42_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index42_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2666:2: ( ( ( ruleBooleanAndExpression )=>this_BooleanAndExpression_0= ruleBooleanAndExpression ) | this_BooleanAndExpressionChild_1= ruleBooleanAndExpressionChild )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_1 = input.LA(1);

                         
                        int index44_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA44_2 = input.LA(1);

                         
                        int index44_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA44_3 = input.LA(1);

                         
                        int index44_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA44_4 = input.LA(1);

                         
                        int index44_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA44_5 = input.LA(1);

                         
                        int index44_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA44_6 = input.LA(1);

                         
                        int index44_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA44_7 = input.LA(1);

                         
                        int index44_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA44_8 = input.LA(1);

                         
                        int index44_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA44_9 = input.LA(1);

                         
                        int index44_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA44_10 = input.LA(1);

                         
                        int index44_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA44_11 = input.LA(1);

                         
                        int index44_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA44_12 = input.LA(1);

                         
                        int index44_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index44_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2705:2: ( ( ( ruleBooleanOrExpression )=>this_BooleanOrExpression_0= ruleBooleanOrExpression ) | this_BooleanOrExpressionChild_1= ruleBooleanOrExpressionChild )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_1 = input.LA(1);

                         
                        int index45_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_2 = input.LA(1);

                         
                        int index45_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA45_3 = input.LA(1);

                         
                        int index45_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA45_4 = input.LA(1);

                         
                        int index45_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA45_5 = input.LA(1);

                         
                        int index45_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA45_6 = input.LA(1);

                         
                        int index45_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA45_7 = input.LA(1);

                         
                        int index45_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA45_8 = input.LA(1);

                         
                        int index45_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA45_9 = input.LA(1);

                         
                        int index45_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA45_10 = input.LA(1);

                         
                        int index45_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA45_11 = input.LA(1);

                         
                        int index45_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA45_12 = input.LA(1);

                         
                        int index45_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalXmu2()) ) {s = 13;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index45_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\12\uffff\1\15\4\uffff";
    static final String dfa_15s = "\1\4\3\uffff\1\4\2\uffff\1\23\2\uffff\1\4\4\uffff";
    static final String dfa_16s = "\1\60\3\uffff\1\4\2\uffff\1\61\2\uffff\1\111\4\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\1\uffff\1\11\1\12\1\uffff\1\10\1\13\1\4\1\5";
    static final String dfa_18s = "\17\uffff}>";
    static final String[] dfa_19s = {
            "\1\7\24\uffff\1\1\14\uffff\1\2\2\uffff\1\3\2\uffff\1\4\1\5\1\6\1\10\1\11",
            "",
            "",
            "",
            "\1\12",
            "",
            "",
            "\1\13\35\uffff\1\14",
            "",
            "",
            "\1\15\24\uffff\3\15\6\uffff\1\16\3\uffff\1\15\2\uffff\10\15\25\uffff\4\15",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = dfa_8;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "3740:2: (this_BlockStatement_0= ruleBlockStatement | this_UpdateStatement_1= ruleUpdateStatement | this_SwitchStatement_2= ruleSwitchStatement | this_DeleteNodeStatement_3= ruleDeleteNodeStatement | this_DeleteLinkStatement_4= ruleDeleteLinkStatement | this_EnforcePatternStatement_5= ruleEnforcePatternStatement | this_ForEachStatement_6= ruleForEachStatement | this_RuleCallStatement_7= ruleRuleCallStatement | this_Skip_8= ruleSkip | this_Fail_9= ruleFail | this_AssignStatement_10= ruleAssignStatement )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000011060002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000011040002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000011000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000C000000400000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800080L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000C000000200010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000C000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0001F2400A000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x3C01F24002080FD0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008100000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x3C01F24082080FD0L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0380000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x3C01F24002280FD0L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000500000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000040000000L,0x000000000000003CL});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0001F24002000010L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x00000000000003C0L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x00000000000003C0L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x00000C0008000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x3C01F24002080FD2L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0002000000000000L});

}