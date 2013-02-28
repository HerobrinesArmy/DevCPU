package devcpu.parser.antlr.internal; 

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
import devcpu.services.DASMGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDASMParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_87", "KEYWORD_88", "KEYWORD_83", "KEYWORD_84", "KEYWORD_85", "KEYWORD_86", "KEYWORD_81", "KEYWORD_82", "KEYWORD_78", "KEYWORD_79", "KEYWORD_80", "KEYWORD_39", "KEYWORD_40", "KEYWORD_41", "KEYWORD_42", "KEYWORD_43", "KEYWORD_44", "KEYWORD_45", "KEYWORD_46", "KEYWORD_47", "KEYWORD_48", "KEYWORD_49", "KEYWORD_50", "KEYWORD_51", "KEYWORD_52", "KEYWORD_53", "KEYWORD_54", "KEYWORD_55", "KEYWORD_56", "KEYWORD_57", "KEYWORD_58", "KEYWORD_59", "KEYWORD_60", "KEYWORD_61", "KEYWORD_62", "KEYWORD_63", "KEYWORD_64", "KEYWORD_65", "KEYWORD_66", "KEYWORD_67", "KEYWORD_68", "KEYWORD_69", "KEYWORD_70", "KEYWORD_71", "KEYWORD_72", "KEYWORD_73", "KEYWORD_74", "KEYWORD_75", "KEYWORD_76", "KEYWORD_77", "KEYWORD_28", "KEYWORD_29", "KEYWORD_30", "KEYWORD_31", "KEYWORD_32", "KEYWORD_33", "KEYWORD_34", "KEYWORD_35", "KEYWORD_36", "KEYWORD_37", "KEYWORD_38", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_11", "KEYWORD_12", "KEYWORD_13", "KEYWORD_14", "KEYWORD_15", "KEYWORD_16", "KEYWORD_17", "KEYWORD_18", "KEYWORD_19", "KEYWORD_20", "KEYWORD_21", "KEYWORD_22", "KEYWORD_23", "KEYWORD_24", "KEYWORD_25", "KEYWORD_26", "KEYWORD_27", "RULE_ID", "RULE_HEXNUMBER", "RULE_DECNUMBER", "RULE_BINNUMBER", "RULE_SL_COMMENT", "RULE_STRING", "RULE_WS", "RULE_NL"
    };
    public static final int RULE_ID=92;
    public static final int KEYWORD_56=32;
    public static final int KEYWORD_55=31;
    public static final int KEYWORD_54=30;
    public static final int KEYWORD_53=29;
    public static final int KEYWORD_52=28;
    public static final int KEYWORD_51=27;
    public static final int KEYWORD_50=26;
    public static final int EOF=-1;
    public static final int KEYWORD_59=35;
    public static final int KEYWORD_58=34;
    public static final int KEYWORD_57=33;
    public static final int KEYWORD_65=41;
    public static final int KEYWORD_64=40;
    public static final int KEYWORD_67=43;
    public static final int KEYWORD_66=42;
    public static final int KEYWORD_61=37;
    public static final int KEYWORD_60=36;
    public static final int KEYWORD_63=39;
    public static final int KEYWORD_62=38;
    public static final int KEYWORD_69=45;
    public static final int KEYWORD_68=44;
    public static final int KEYWORD_30=56;
    public static final int KEYWORD_34=60;
    public static final int KEYWORD_33=59;
    public static final int KEYWORD_32=58;
    public static final int KEYWORD_31=57;
    public static final int KEYWORD_38=64;
    public static final int KEYWORD_37=63;
    public static final int KEYWORD_36=62;
    public static final int KEYWORD_35=61;
    public static final int KEYWORD_39=15;
    public static final int RULE_BINNUMBER=95;
    public static final int RULE_STRING=97;
    public static final int RULE_DECNUMBER=94;
    public static final int KEYWORD_41=17;
    public static final int KEYWORD_40=16;
    public static final int KEYWORD_43=19;
    public static final int KEYWORD_42=18;
    public static final int KEYWORD_45=21;
    public static final int KEYWORD_44=20;
    public static final int KEYWORD_47=23;
    public static final int KEYWORD_46=22;
    public static final int KEYWORD_49=25;
    public static final int KEYWORD_48=24;
    public static final int KEYWORD_19=83;
    public static final int KEYWORD_17=81;
    public static final int KEYWORD_18=82;
    public static final int KEYWORD_15=79;
    public static final int KEYWORD_16=80;
    public static final int KEYWORD_13=77;
    public static final int KEYWORD_14=78;
    public static final int KEYWORD_11=75;
    public static final int KEYWORD_12=76;
    public static final int KEYWORD_10=74;
    public static final int KEYWORD_6=70;
    public static final int KEYWORD_7=71;
    public static final int KEYWORD_8=72;
    public static final int KEYWORD_9=73;
    public static final int KEYWORD_28=54;
    public static final int KEYWORD_29=55;
    public static final int KEYWORD_24=88;
    public static final int KEYWORD_25=89;
    public static final int KEYWORD_26=90;
    public static final int KEYWORD_27=91;
    public static final int KEYWORD_20=84;
    public static final int KEYWORD_21=85;
    public static final int KEYWORD_22=86;
    public static final int KEYWORD_23=87;
    public static final int KEYWORD_79=13;
    public static final int KEYWORD_71=47;
    public static final int KEYWORD_72=48;
    public static final int KEYWORD_73=49;
    public static final int KEYWORD_74=50;
    public static final int KEYWORD_75=51;
    public static final int KEYWORD_76=52;
    public static final int KEYWORD_77=53;
    public static final int KEYWORD_78=12;
    public static final int KEYWORD_1=65;
    public static final int RULE_NL=99;
    public static final int KEYWORD_5=69;
    public static final int KEYWORD_4=68;
    public static final int KEYWORD_70=46;
    public static final int KEYWORD_3=67;
    public static final int KEYWORD_2=66;
    public static final int RULE_SL_COMMENT=96;
    public static final int KEYWORD_84=7;
    public static final int KEYWORD_85=8;
    public static final int KEYWORD_82=11;
    public static final int KEYWORD_83=6;
    public static final int KEYWORD_88=5;
    public static final int KEYWORD_86=9;
    public static final int KEYWORD_87=4;
    public static final int KEYWORD_81=10;
    public static final int KEYWORD_80=14;
    public static final int RULE_HEXNUMBER=93;
    public static final int RULE_WS=98;

    // delegates
    // delegators


        public InternalDASMParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDASMParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDASMParser.tokenNames; }
    public String getGrammarFileName() { return "../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g"; }




    	private DASMGrammarAccess grammarAccess;
    	 	
    	public InternalDASMParser(TokenStream input, DASMGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Model";	
    	} 
    	   	   	
    	@Override
    	protected DASMGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleModel"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:62:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:63:2: (iv_ruleModel= ruleModel EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:64:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel67);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel77); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:71:1: ruleModel returns [EObject current=null] : (this_LineDefinition_0= ruleLineDefinition ( () this_NL_2= RULE_NL ( (lv_right_3_0= ruleModel ) ) )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token this_NL_2=null;
        EObject this_LineDefinition_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:74:28: ( (this_LineDefinition_0= ruleLineDefinition ( () this_NL_2= RULE_NL ( (lv_right_3_0= ruleModel ) ) )? ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:75:1: (this_LineDefinition_0= ruleLineDefinition ( () this_NL_2= RULE_NL ( (lv_right_3_0= ruleModel ) ) )? )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:75:1: (this_LineDefinition_0= ruleLineDefinition ( () this_NL_2= RULE_NL ( (lv_right_3_0= ruleModel ) ) )? )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:76:5: this_LineDefinition_0= ruleLineDefinition ( () this_NL_2= RULE_NL ( (lv_right_3_0= ruleModel ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getModelAccess().getLineDefinitionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleLineDefinition_in_ruleModel124);
            this_LineDefinition_0=ruleLineDefinition();

            state._fsp--;


                    current = this_LineDefinition_0;
                    afterParserOrEnumRuleCall();
                
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:84:1: ( () this_NL_2= RULE_NL ( (lv_right_3_0= ruleModel ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_NL) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:84:2: () this_NL_2= RULE_NL ( (lv_right_3_0= ruleModel ) )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:84:2: ()
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:85:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getModelAccess().getOperationLeftAction_1_0(),
                                current);
                        

                    }

                    this_NL_2=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleModel144); 
                     
                        newLeafNode(this_NL_2, grammarAccess.getModelAccess().getNLTerminalRuleCall_1_1()); 
                        
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:94:1: ( (lv_right_3_0= ruleModel ) )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:95:1: (lv_right_3_0= ruleModel )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:95:1: (lv_right_3_0= ruleModel )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:96:3: lv_right_3_0= ruleModel
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getRightModelParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModel_in_ruleModel164);
                    lv_right_3_0=ruleModel();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_3_0, 
                            		"Model");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleLineDefinition"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:120:1: entryRuleLineDefinition returns [EObject current=null] : iv_ruleLineDefinition= ruleLineDefinition EOF ;
    public final EObject entryRuleLineDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineDefinition = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:121:2: (iv_ruleLineDefinition= ruleLineDefinition EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:122:2: iv_ruleLineDefinition= ruleLineDefinition EOF
            {
             newCompositeNode(grammarAccess.getLineDefinitionRule()); 
            pushFollow(FOLLOW_ruleLineDefinition_in_entryRuleLineDefinition201);
            iv_ruleLineDefinition=ruleLineDefinition();

            state._fsp--;

             current =iv_ruleLineDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLineDefinition211); 

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
    // $ANTLR end "entryRuleLineDefinition"


    // $ANTLR start "ruleLineDefinition"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:129:1: ruleLineDefinition returns [EObject current=null] : ( ( (lv_labels_0_0= ruleLabel ) )* ( (lv_content_1_0= ruleLineContent ) )? ( (lv_comment_2_0= RULE_SL_COMMENT ) )? ) ;
    public final EObject ruleLineDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_comment_2_0=null;
        EObject lv_labels_0_0 = null;

        EObject lv_content_1_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:132:28: ( ( ( (lv_labels_0_0= ruleLabel ) )* ( (lv_content_1_0= ruleLineContent ) )? ( (lv_comment_2_0= RULE_SL_COMMENT ) )? ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:133:1: ( ( (lv_labels_0_0= ruleLabel ) )* ( (lv_content_1_0= ruleLineContent ) )? ( (lv_comment_2_0= RULE_SL_COMMENT ) )? )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:133:1: ( ( (lv_labels_0_0= ruleLabel ) )* ( (lv_content_1_0= ruleLineContent ) )? ( (lv_comment_2_0= RULE_SL_COMMENT ) )? )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:133:2: ( (lv_labels_0_0= ruleLabel ) )* ( (lv_content_1_0= ruleLineContent ) )? ( (lv_comment_2_0= RULE_SL_COMMENT ) )?
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:133:2: ( (lv_labels_0_0= ruleLabel ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==KEYWORD_11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:134:1: (lv_labels_0_0= ruleLabel )
            	    {
            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:134:1: (lv_labels_0_0= ruleLabel )
            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:135:3: lv_labels_0_0= ruleLabel
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLineDefinitionAccess().getLabelsLabelParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLabel_in_ruleLineDefinition257);
            	    lv_labels_0_0=ruleLabel();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLineDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"labels",
            	            		lv_labels_0_0, 
            	            		"Label");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:151:3: ( (lv_content_1_0= ruleLineContent ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=KEYWORD_87 && LA3_0<=KEYWORD_78)||(LA3_0>=KEYWORD_40 && LA3_0<=KEYWORD_67)||(LA3_0>=KEYWORD_69 && LA3_0<=KEYWORD_77)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:152:1: (lv_content_1_0= ruleLineContent )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:152:1: (lv_content_1_0= ruleLineContent )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:153:3: lv_content_1_0= ruleLineContent
                    {
                     
                    	        newCompositeNode(grammarAccess.getLineDefinitionAccess().getContentLineContentParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLineContent_in_ruleLineDefinition279);
                    lv_content_1_0=ruleLineContent();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLineDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"content",
                            		lv_content_1_0, 
                            		"LineContent");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:169:3: ( (lv_comment_2_0= RULE_SL_COMMENT ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_SL_COMMENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:170:1: (lv_comment_2_0= RULE_SL_COMMENT )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:170:1: (lv_comment_2_0= RULE_SL_COMMENT )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:171:3: lv_comment_2_0= RULE_SL_COMMENT
                    {
                    lv_comment_2_0=(Token)match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_ruleLineDefinition297); 

                    			newLeafNode(lv_comment_2_0, grammarAccess.getLineDefinitionAccess().getCommentSL_COMMENTTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLineDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"comment",
                            		lv_comment_2_0, 
                            		"SL_COMMENT");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineDefinition"


    // $ANTLR start "entryRuleLineContent"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:195:1: entryRuleLineContent returns [EObject current=null] : iv_ruleLineContent= ruleLineContent EOF ;
    public final EObject entryRuleLineContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineContent = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:196:2: (iv_ruleLineContent= ruleLineContent EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:197:2: iv_ruleLineContent= ruleLineContent EOF
            {
             newCompositeNode(grammarAccess.getLineContentRule()); 
            pushFollow(FOLLOW_ruleLineContent_in_entryRuleLineContent338);
            iv_ruleLineContent=ruleLineContent();

            state._fsp--;

             current =iv_ruleLineContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLineContent348); 

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
    // $ANTLR end "entryRuleLineContent"


    // $ANTLR start "ruleLineContent"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:204:1: ruleLineContent returns [EObject current=null] : (this_Instruction_0= ruleInstruction | this_Directive_1= ruleDirective | this_DataLine_2= ruleDataLine ) ;
    public final EObject ruleLineContent() throws RecognitionException {
        EObject current = null;

        EObject this_Instruction_0 = null;

        EObject this_Directive_1 = null;

        EObject this_DataLine_2 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:207:28: ( (this_Instruction_0= ruleInstruction | this_Directive_1= ruleDirective | this_DataLine_2= ruleDataLine ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:208:1: (this_Instruction_0= ruleInstruction | this_Directive_1= ruleDirective | this_DataLine_2= ruleDataLine )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:208:1: (this_Instruction_0= ruleInstruction | this_Directive_1= ruleDirective | this_DataLine_2= ruleDataLine )
            int alt5=3;
            switch ( input.LA(1) ) {
            case KEYWORD_40:
            case KEYWORD_41:
            case KEYWORD_42:
            case KEYWORD_43:
            case KEYWORD_44:
            case KEYWORD_46:
            case KEYWORD_47:
            case KEYWORD_48:
            case KEYWORD_49:
            case KEYWORD_50:
            case KEYWORD_51:
            case KEYWORD_52:
            case KEYWORD_53:
            case KEYWORD_54:
            case KEYWORD_55:
            case KEYWORD_56:
            case KEYWORD_57:
            case KEYWORD_58:
            case KEYWORD_59:
            case KEYWORD_60:
            case KEYWORD_61:
            case KEYWORD_62:
            case KEYWORD_63:
            case KEYWORD_64:
            case KEYWORD_65:
            case KEYWORD_66:
            case KEYWORD_67:
            case KEYWORD_69:
            case KEYWORD_70:
            case KEYWORD_71:
            case KEYWORD_72:
            case KEYWORD_73:
            case KEYWORD_74:
            case KEYWORD_75:
            case KEYWORD_76:
            case KEYWORD_77:
                {
                alt5=1;
                }
                break;
            case KEYWORD_87:
            case KEYWORD_88:
            case KEYWORD_83:
            case KEYWORD_84:
            case KEYWORD_85:
            case KEYWORD_86:
            case KEYWORD_81:
            case KEYWORD_82:
                {
                alt5=2;
                }
                break;
            case KEYWORD_78:
            case KEYWORD_45:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:209:5: this_Instruction_0= ruleInstruction
                    {
                     
                            newCompositeNode(grammarAccess.getLineContentAccess().getInstructionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInstruction_in_ruleLineContent395);
                    this_Instruction_0=ruleInstruction();

                    state._fsp--;


                            current = this_Instruction_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:219:5: this_Directive_1= ruleDirective
                    {
                     
                            newCompositeNode(grammarAccess.getLineContentAccess().getDirectiveParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDirective_in_ruleLineContent422);
                    this_Directive_1=ruleDirective();

                    state._fsp--;


                            current = this_Directive_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:229:5: this_DataLine_2= ruleDataLine
                    {
                     
                            newCompositeNode(grammarAccess.getLineContentAccess().getDataLineParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDataLine_in_ruleLineContent449);
                    this_DataLine_2=ruleDataLine();

                    state._fsp--;


                            current = this_DataLine_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineContent"


    // $ANTLR start "entryRuleDirective"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:245:1: entryRuleDirective returns [EObject current=null] : iv_ruleDirective= ruleDirective EOF ;
    public final EObject entryRuleDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirective = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:246:2: (iv_ruleDirective= ruleDirective EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:247:2: iv_ruleDirective= ruleDirective EOF
            {
             newCompositeNode(grammarAccess.getDirectiveRule()); 
            pushFollow(FOLLOW_ruleDirective_in_entryRuleDirective483);
            iv_ruleDirective=ruleDirective();

            state._fsp--;

             current =iv_ruleDirective; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirective493); 

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
    // $ANTLR end "entryRuleDirective"


    // $ANTLR start "ruleDirective"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:254:1: ruleDirective returns [EObject current=null] : (this_IncludeDirective_0= ruleIncludeDirective | this_OriginDirective_1= ruleOriginDirective ) ;
    public final EObject ruleDirective() throws RecognitionException {
        EObject current = null;

        EObject this_IncludeDirective_0 = null;

        EObject this_OriginDirective_1 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:257:28: ( (this_IncludeDirective_0= ruleIncludeDirective | this_OriginDirective_1= ruleOriginDirective ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:258:1: (this_IncludeDirective_0= ruleIncludeDirective | this_OriginDirective_1= ruleOriginDirective )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:258:1: (this_IncludeDirective_0= ruleIncludeDirective | this_OriginDirective_1= ruleOriginDirective )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=KEYWORD_87 && LA6_0<=KEYWORD_83)||LA6_0==KEYWORD_85) ) {
                alt6=1;
            }
            else if ( (LA6_0==KEYWORD_84||(LA6_0>=KEYWORD_86 && LA6_0<=KEYWORD_82)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:259:5: this_IncludeDirective_0= ruleIncludeDirective
                    {
                     
                            newCompositeNode(grammarAccess.getDirectiveAccess().getIncludeDirectiveParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIncludeDirective_in_ruleDirective540);
                    this_IncludeDirective_0=ruleIncludeDirective();

                    state._fsp--;


                            current = this_IncludeDirective_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:269:5: this_OriginDirective_1= ruleOriginDirective
                    {
                     
                            newCompositeNode(grammarAccess.getDirectiveAccess().getOriginDirectiveParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOriginDirective_in_ruleDirective567);
                    this_OriginDirective_1=ruleOriginDirective();

                    state._fsp--;


                            current = this_OriginDirective_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirective"


    // $ANTLR start "entryRuleOriginDirective"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:285:1: entryRuleOriginDirective returns [EObject current=null] : iv_ruleOriginDirective= ruleOriginDirective EOF ;
    public final EObject entryRuleOriginDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOriginDirective = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:286:2: (iv_ruleOriginDirective= ruleOriginDirective EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:287:2: iv_ruleOriginDirective= ruleOriginDirective EOF
            {
             newCompositeNode(grammarAccess.getOriginDirectiveRule()); 
            pushFollow(FOLLOW_ruleOriginDirective_in_entryRuleOriginDirective601);
            iv_ruleOriginDirective=ruleOriginDirective();

            state._fsp--;

             current =iv_ruleOriginDirective; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOriginDirective611); 

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
    // $ANTLR end "entryRuleOriginDirective"


    // $ANTLR start "ruleOriginDirective"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:294:1: ruleOriginDirective returns [EObject current=null] : ( (otherlv_0= KEYWORD_86 | otherlv_1= KEYWORD_84 | otherlv_2= KEYWORD_82 | otherlv_3= KEYWORD_81 ) ( (lv_value_4_0= ruleNumber ) ) ) ;
    public final EObject ruleOriginDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:297:28: ( ( (otherlv_0= KEYWORD_86 | otherlv_1= KEYWORD_84 | otherlv_2= KEYWORD_82 | otherlv_3= KEYWORD_81 ) ( (lv_value_4_0= ruleNumber ) ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:298:1: ( (otherlv_0= KEYWORD_86 | otherlv_1= KEYWORD_84 | otherlv_2= KEYWORD_82 | otherlv_3= KEYWORD_81 ) ( (lv_value_4_0= ruleNumber ) ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:298:1: ( (otherlv_0= KEYWORD_86 | otherlv_1= KEYWORD_84 | otherlv_2= KEYWORD_82 | otherlv_3= KEYWORD_81 ) ( (lv_value_4_0= ruleNumber ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:298:2: (otherlv_0= KEYWORD_86 | otherlv_1= KEYWORD_84 | otherlv_2= KEYWORD_82 | otherlv_3= KEYWORD_81 ) ( (lv_value_4_0= ruleNumber ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:298:2: (otherlv_0= KEYWORD_86 | otherlv_1= KEYWORD_84 | otherlv_2= KEYWORD_82 | otherlv_3= KEYWORD_81 )
            int alt7=4;
            switch ( input.LA(1) ) {
            case KEYWORD_86:
                {
                alt7=1;
                }
                break;
            case KEYWORD_84:
                {
                alt7=2;
                }
                break;
            case KEYWORD_82:
                {
                alt7=3;
                }
                break;
            case KEYWORD_81:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:299:2: otherlv_0= KEYWORD_86
                    {
                    otherlv_0=(Token)match(input,KEYWORD_86,FOLLOW_KEYWORD_86_in_ruleOriginDirective650); 

                        	newLeafNode(otherlv_0, grammarAccess.getOriginDirectiveAccess().getOriginKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:305:2: otherlv_1= KEYWORD_84
                    {
                    otherlv_1=(Token)match(input,KEYWORD_84,FOLLOW_KEYWORD_84_in_ruleOriginDirective668); 

                        	newLeafNode(otherlv_1, grammarAccess.getOriginDirectiveAccess().getOriginKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:311:2: otherlv_2= KEYWORD_82
                    {
                    otherlv_2=(Token)match(input,KEYWORD_82,FOLLOW_KEYWORD_82_in_ruleOriginDirective686); 

                        	newLeafNode(otherlv_2, grammarAccess.getOriginDirectiveAccess().getAlignKeyword_0_2());
                        

                    }
                    break;
                case 4 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:317:2: otherlv_3= KEYWORD_81
                    {
                    otherlv_3=(Token)match(input,KEYWORD_81,FOLLOW_KEYWORD_81_in_ruleOriginDirective704); 

                        	newLeafNode(otherlv_3, grammarAccess.getOriginDirectiveAccess().getAlignKeyword_0_3());
                        

                    }
                    break;

            }

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:321:2: ( (lv_value_4_0= ruleNumber ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:322:1: (lv_value_4_0= ruleNumber )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:322:1: (lv_value_4_0= ruleNumber )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:323:3: lv_value_4_0= ruleNumber
            {
             
            	        newCompositeNode(grammarAccess.getOriginDirectiveAccess().getValueNumberParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleNumber_in_ruleOriginDirective725);
            lv_value_4_0=ruleNumber();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOriginDirectiveRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"Number");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOriginDirective"


    // $ANTLR start "entryRuleIncludeDirective"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:347:1: entryRuleIncludeDirective returns [EObject current=null] : iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
    public final EObject entryRuleIncludeDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeDirective = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:348:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:349:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
            {
             newCompositeNode(grammarAccess.getIncludeDirectiveRule()); 
            pushFollow(FOLLOW_ruleIncludeDirective_in_entryRuleIncludeDirective760);
            iv_ruleIncludeDirective=ruleIncludeDirective();

            state._fsp--;

             current =iv_ruleIncludeDirective; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDirective770); 

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
    // $ANTLR end "entryRuleIncludeDirective"


    // $ANTLR start "ruleIncludeDirective"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:356:1: ruleIncludeDirective returns [EObject current=null] : ( (otherlv_0= KEYWORD_88 | otherlv_1= KEYWORD_87 | otherlv_2= KEYWORD_85 | otherlv_3= KEYWORD_83 ) ( (lv_name_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleIncludeDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;

         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:359:28: ( ( (otherlv_0= KEYWORD_88 | otherlv_1= KEYWORD_87 | otherlv_2= KEYWORD_85 | otherlv_3= KEYWORD_83 ) ( (lv_name_4_0= RULE_STRING ) ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:360:1: ( (otherlv_0= KEYWORD_88 | otherlv_1= KEYWORD_87 | otherlv_2= KEYWORD_85 | otherlv_3= KEYWORD_83 ) ( (lv_name_4_0= RULE_STRING ) ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:360:1: ( (otherlv_0= KEYWORD_88 | otherlv_1= KEYWORD_87 | otherlv_2= KEYWORD_85 | otherlv_3= KEYWORD_83 ) ( (lv_name_4_0= RULE_STRING ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:360:2: (otherlv_0= KEYWORD_88 | otherlv_1= KEYWORD_87 | otherlv_2= KEYWORD_85 | otherlv_3= KEYWORD_83 ) ( (lv_name_4_0= RULE_STRING ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:360:2: (otherlv_0= KEYWORD_88 | otherlv_1= KEYWORD_87 | otherlv_2= KEYWORD_85 | otherlv_3= KEYWORD_83 )
            int alt8=4;
            switch ( input.LA(1) ) {
            case KEYWORD_88:
                {
                alt8=1;
                }
                break;
            case KEYWORD_87:
                {
                alt8=2;
                }
                break;
            case KEYWORD_85:
                {
                alt8=3;
                }
                break;
            case KEYWORD_83:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:361:2: otherlv_0= KEYWORD_88
                    {
                    otherlv_0=(Token)match(input,KEYWORD_88,FOLLOW_KEYWORD_88_in_ruleIncludeDirective809); 

                        	newLeafNode(otherlv_0, grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:367:2: otherlv_1= KEYWORD_87
                    {
                    otherlv_1=(Token)match(input,KEYWORD_87,FOLLOW_KEYWORD_87_in_ruleIncludeDirective827); 

                        	newLeafNode(otherlv_1, grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:373:2: otherlv_2= KEYWORD_85
                    {
                    otherlv_2=(Token)match(input,KEYWORD_85,FOLLOW_KEYWORD_85_in_ruleIncludeDirective845); 

                        	newLeafNode(otherlv_2, grammarAccess.getIncludeDirectiveAccess().getImportKeyword_0_2());
                        

                    }
                    break;
                case 4 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:379:2: otherlv_3= KEYWORD_83
                    {
                    otherlv_3=(Token)match(input,KEYWORD_83,FOLLOW_KEYWORD_83_in_ruleIncludeDirective863); 

                        	newLeafNode(otherlv_3, grammarAccess.getIncludeDirectiveAccess().getImportKeyword_0_3());
                        

                    }
                    break;

            }

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:383:2: ( (lv_name_4_0= RULE_STRING ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:384:1: (lv_name_4_0= RULE_STRING )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:384:1: (lv_name_4_0= RULE_STRING )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:385:3: lv_name_4_0= RULE_STRING
            {
            lv_name_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIncludeDirective880); 

            			newLeafNode(lv_name_4_0, grammarAccess.getIncludeDirectiveAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIncludeDirectiveRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncludeDirective"


    // $ANTLR start "entryRuleDataLine"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:409:1: entryRuleDataLine returns [EObject current=null] : iv_ruleDataLine= ruleDataLine EOF ;
    public final EObject entryRuleDataLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataLine = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:410:2: (iv_ruleDataLine= ruleDataLine EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:411:2: iv_ruleDataLine= ruleDataLine EOF
            {
             newCompositeNode(grammarAccess.getDataLineRule()); 
            pushFollow(FOLLOW_ruleDataLine_in_entryRuleDataLine920);
            iv_ruleDataLine=ruleDataLine();

            state._fsp--;

             current =iv_ruleDataLine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataLine930); 

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
    // $ANTLR end "entryRuleDataLine"


    // $ANTLR start "ruleDataLine"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:418:1: ruleDataLine returns [EObject current=null] : ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_78 ) ( (otherlv_2= KEYWORD_8 )* ( (lv_dataElements_3_0= ruleDataElement ) ) (otherlv_4= KEYWORD_8 )* )+ ) ;
    public final EObject ruleDataLine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_dataElements_3_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:421:28: ( ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_78 ) ( (otherlv_2= KEYWORD_8 )* ( (lv_dataElements_3_0= ruleDataElement ) ) (otherlv_4= KEYWORD_8 )* )+ ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:422:1: ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_78 ) ( (otherlv_2= KEYWORD_8 )* ( (lv_dataElements_3_0= ruleDataElement ) ) (otherlv_4= KEYWORD_8 )* )+ )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:422:1: ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_78 ) ( (otherlv_2= KEYWORD_8 )* ( (lv_dataElements_3_0= ruleDataElement ) ) (otherlv_4= KEYWORD_8 )* )+ )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:422:2: (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_78 ) ( (otherlv_2= KEYWORD_8 )* ( (lv_dataElements_3_0= ruleDataElement ) ) (otherlv_4= KEYWORD_8 )* )+
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:422:2: (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_78 )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==KEYWORD_45) ) {
                alt9=1;
            }
            else if ( (LA9_0==KEYWORD_78) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:423:2: otherlv_0= KEYWORD_45
                    {
                    otherlv_0=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleDataLine969); 

                        	newLeafNode(otherlv_0, grammarAccess.getDataLineAccess().getDATKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:429:2: otherlv_1= KEYWORD_78
                    {
                    otherlv_1=(Token)match(input,KEYWORD_78,FOLLOW_KEYWORD_78_in_ruleDataLine987); 

                        	newLeafNode(otherlv_1, grammarAccess.getDataLineAccess().getDatKeyword_0_1());
                        

                    }
                    break;

            }

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:433:2: ( (otherlv_2= KEYWORD_8 )* ( (lv_dataElements_3_0= ruleDataElement ) ) (otherlv_4= KEYWORD_8 )* )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==KEYWORD_8||(LA12_0>=RULE_HEXNUMBER && LA12_0<=RULE_BINNUMBER)||LA12_0==RULE_STRING) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:433:3: (otherlv_2= KEYWORD_8 )* ( (lv_dataElements_3_0= ruleDataElement ) ) (otherlv_4= KEYWORD_8 )*
            	    {
            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:433:3: (otherlv_2= KEYWORD_8 )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==KEYWORD_8) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:434:2: otherlv_2= KEYWORD_8
            	    	    {
            	    	    otherlv_2=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleDataLine1002); 

            	    	        	newLeafNode(otherlv_2, grammarAccess.getDataLineAccess().getCommaKeyword_1_0());
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop10;
            	        }
            	    } while (true);

            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:438:3: ( (lv_dataElements_3_0= ruleDataElement ) )
            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:439:1: (lv_dataElements_3_0= ruleDataElement )
            	    {
            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:439:1: (lv_dataElements_3_0= ruleDataElement )
            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:440:3: lv_dataElements_3_0= ruleDataElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDataLineAccess().getDataElementsDataElementParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDataElement_in_ruleDataLine1024);
            	    lv_dataElements_3_0=ruleDataElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDataLineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"dataElements",
            	            		lv_dataElements_3_0, 
            	            		"DataElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:456:2: (otherlv_4= KEYWORD_8 )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==KEYWORD_8) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:457:2: otherlv_4= KEYWORD_8
            	    	    {
            	    	    otherlv_4=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleDataLine1038); 

            	    	        	newLeafNode(otherlv_4, grammarAccess.getDataLineAccess().getCommaKeyword_1_2());
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop11;
            	        }
            	    } while (true);


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


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataLine"


    // $ANTLR start "entryRuleDataElement"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:469:1: entryRuleDataElement returns [String current=null] : iv_ruleDataElement= ruleDataElement EOF ;
    public final String entryRuleDataElement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataElement = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:470:1: (iv_ruleDataElement= ruleDataElement EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:471:2: iv_ruleDataElement= ruleDataElement EOF
            {
             newCompositeNode(grammarAccess.getDataElementRule()); 
            pushFollow(FOLLOW_ruleDataElement_in_entryRuleDataElement1077);
            iv_ruleDataElement=ruleDataElement();

            state._fsp--;

             current =iv_ruleDataElement.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataElement1088); 

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
    // $ANTLR end "entryRuleDataElement"


    // $ANTLR start "ruleDataElement"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:478:1: ruleDataElement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_Number_1= ruleNumber ) ;
    public final AntlrDatatypeRuleToken ruleDataElement() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        AntlrDatatypeRuleToken this_Number_1 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:482:6: ( (this_STRING_0= RULE_STRING | this_Number_1= ruleNumber ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:483:1: (this_STRING_0= RULE_STRING | this_Number_1= ruleNumber )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:483:1: (this_STRING_0= RULE_STRING | this_Number_1= ruleNumber )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_STRING) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=RULE_HEXNUMBER && LA13_0<=RULE_BINNUMBER)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:483:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDataElement1128); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getDataElementAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:492:5: this_Number_1= ruleNumber
                    {
                     
                            newCompositeNode(grammarAccess.getDataElementAccess().getNumberParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNumber_in_ruleDataElement1161);
                    this_Number_1=ruleNumber();

                    state._fsp--;


                    		current.merge(this_Number_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataElement"


    // $ANTLR start "entryRuleLiteralExpression"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:510:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:511:2: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:512:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
            {
             newCompositeNode(grammarAccess.getLiteralExpressionRule()); 
            pushFollow(FOLLOW_ruleLiteralExpression_in_entryRuleLiteralExpression1205);
            iv_ruleLiteralExpression=ruleLiteralExpression();

            state._fsp--;

             current =iv_ruleLiteralExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralExpression1215); 

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
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:519:1: ruleLiteralExpression returns [EObject current=null] : (this_TerminalExpression_0= ruleTerminalExpression ( () ( (lv_op_2_0= ruleOperator ) ) ( (lv_right_3_0= ruleLiteralExpression ) ) )? ) ;
    public final EObject ruleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalExpression_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:522:28: ( (this_TerminalExpression_0= ruleTerminalExpression ( () ( (lv_op_2_0= ruleOperator ) ) ( (lv_right_3_0= ruleLiteralExpression ) ) )? ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:523:1: (this_TerminalExpression_0= ruleTerminalExpression ( () ( (lv_op_2_0= ruleOperator ) ) ( (lv_right_3_0= ruleLiteralExpression ) ) )? )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:523:1: (this_TerminalExpression_0= ruleTerminalExpression ( () ( (lv_op_2_0= ruleOperator ) ) ( (lv_right_3_0= ruleLiteralExpression ) ) )? )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:524:5: this_TerminalExpression_0= ruleTerminalExpression ( () ( (lv_op_2_0= ruleOperator ) ) ( (lv_right_3_0= ruleLiteralExpression ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getLiteralExpressionAccess().getTerminalExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleTerminalExpression_in_ruleLiteralExpression1262);
            this_TerminalExpression_0=ruleTerminalExpression();

            state._fsp--;


                    current = this_TerminalExpression_0;
                    afterParserOrEnumRuleCall();
                
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:532:1: ( () ( (lv_op_2_0= ruleOperator ) ) ( (lv_right_3_0= ruleLiteralExpression ) ) )?
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:532:2: () ( (lv_op_2_0= ruleOperator ) ) ( (lv_right_3_0= ruleLiteralExpression ) )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:532:2: ()
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:533:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getLiteralExpressionAccess().getOperationLeftAction_1_0(),
                                current);
                        

                    }

                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:538:2: ( (lv_op_2_0= ruleOperator ) )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:539:1: (lv_op_2_0= ruleOperator )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:539:1: (lv_op_2_0= ruleOperator )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:540:3: lv_op_2_0= ruleOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getLiteralExpressionAccess().getOpOperatorEnumRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOperator_in_ruleLiteralExpression1292);
                    lv_op_2_0=ruleOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLiteralExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_2_0, 
                            		"Operator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:556:2: ( (lv_right_3_0= ruleLiteralExpression ) )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:557:1: (lv_right_3_0= ruleLiteralExpression )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:557:1: (lv_right_3_0= ruleLiteralExpression )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:558:3: lv_right_3_0= ruleLiteralExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getLiteralExpressionAccess().getRightLiteralExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLiteralExpression_in_ruleLiteralExpression1313);
                    lv_right_3_0=ruleLiteralExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLiteralExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_3_0, 
                            		"LiteralExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleTerminalExpression"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:582:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:583:2: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:584:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
            {
             newCompositeNode(grammarAccess.getTerminalExpressionRule()); 
            pushFollow(FOLLOW_ruleTerminalExpression_in_entryRuleTerminalExpression1350);
            iv_ruleTerminalExpression=ruleTerminalExpression();

            state._fsp--;

             current =iv_ruleTerminalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpression1360); 

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
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:591:1: ruleTerminalExpression returns [EObject current=null] : ( (otherlv_0= KEYWORD_4 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_5 ) | ( (lv_value_3_0= ruleNonGroupOperand ) ) ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_LiteralExpression_1 = null;

        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:594:28: ( ( (otherlv_0= KEYWORD_4 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_5 ) | ( (lv_value_3_0= ruleNonGroupOperand ) ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:595:1: ( (otherlv_0= KEYWORD_4 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_5 ) | ( (lv_value_3_0= ruleNonGroupOperand ) ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:595:1: ( (otherlv_0= KEYWORD_4 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_5 ) | ( (lv_value_3_0= ruleNonGroupOperand ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==KEYWORD_4) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=KEYWORD_79 && LA15_0<=KEYWORD_80)||LA15_0==KEYWORD_68||(LA15_0>=KEYWORD_35 && LA15_0<=KEYWORD_37)||(LA15_0>=KEYWORD_15 && LA15_0<=KEYWORD_22)||(LA15_0>=RULE_ID && LA15_0<=RULE_BINNUMBER)) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:595:2: (otherlv_0= KEYWORD_4 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_5 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:595:2: (otherlv_0= KEYWORD_4 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_5 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:596:2: otherlv_0= KEYWORD_4 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_5
                    {
                    otherlv_0=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleTerminalExpression1399); 

                        	newLeafNode(otherlv_0, grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getTerminalExpressionAccess().getLiteralExpressionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleLiteralExpression_in_ruleTerminalExpression1420);
                    this_LiteralExpression_1=ruleLiteralExpression();

                    state._fsp--;


                            current = this_LiteralExpression_1;
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleTerminalExpression1432); 

                        	newLeafNode(otherlv_2, grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:615:6: ( (lv_value_3_0= ruleNonGroupOperand ) )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:615:6: ( (lv_value_3_0= ruleNonGroupOperand ) )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:616:1: (lv_value_3_0= ruleNonGroupOperand )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:616:1: (lv_value_3_0= ruleNonGroupOperand )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:617:3: lv_value_3_0= ruleNonGroupOperand
                    {
                     
                    	        newCompositeNode(grammarAccess.getTerminalExpressionAccess().getValueNonGroupOperandParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNonGroupOperand_in_ruleTerminalExpression1459);
                    lv_value_3_0=ruleNonGroupOperand();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTerminalExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_3_0, 
                            		"NonGroupOperand");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleNonGroupOperand"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:641:1: entryRuleNonGroupOperand returns [EObject current=null] : iv_ruleNonGroupOperand= ruleNonGroupOperand EOF ;
    public final EObject entryRuleNonGroupOperand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonGroupOperand = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:642:2: (iv_ruleNonGroupOperand= ruleNonGroupOperand EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:643:2: iv_ruleNonGroupOperand= ruleNonGroupOperand EOF
            {
             newCompositeNode(grammarAccess.getNonGroupOperandRule()); 
            pushFollow(FOLLOW_ruleNonGroupOperand_in_entryRuleNonGroupOperand1494);
            iv_ruleNonGroupOperand=ruleNonGroupOperand();

            state._fsp--;

             current =iv_ruleNonGroupOperand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonGroupOperand1504); 

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
    // $ANTLR end "entryRuleNonGroupOperand"


    // $ANTLR start "ruleNonGroupOperand"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:650:1: ruleNonGroupOperand returns [EObject current=null] : (this_Register_0= ruleRegister | this_Literal_1= ruleLiteral | ( (otherlv_2= RULE_ID ) ) | this_StackValue_3= ruleStackValue ) ;
    public final EObject ruleNonGroupOperand() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Register_0 = null;

        EObject this_Literal_1 = null;

        EObject this_StackValue_3 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:653:28: ( (this_Register_0= ruleRegister | this_Literal_1= ruleLiteral | ( (otherlv_2= RULE_ID ) ) | this_StackValue_3= ruleStackValue ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:654:1: (this_Register_0= ruleRegister | this_Literal_1= ruleLiteral | ( (otherlv_2= RULE_ID ) ) | this_StackValue_3= ruleStackValue )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:654:1: (this_Register_0= ruleRegister | this_Literal_1= ruleLiteral | ( (otherlv_2= RULE_ID ) ) | this_StackValue_3= ruleStackValue )
            int alt16=4;
            switch ( input.LA(1) ) {
            case KEYWORD_35:
            case KEYWORD_36:
            case KEYWORD_37:
            case KEYWORD_15:
            case KEYWORD_16:
            case KEYWORD_17:
            case KEYWORD_18:
            case KEYWORD_19:
            case KEYWORD_20:
            case KEYWORD_21:
            case KEYWORD_22:
                {
                alt16=1;
                }
                break;
            case RULE_HEXNUMBER:
            case RULE_DECNUMBER:
            case RULE_BINNUMBER:
                {
                alt16=2;
                }
                break;
            case RULE_ID:
                {
                alt16=3;
                }
                break;
            case KEYWORD_79:
            case KEYWORD_80:
            case KEYWORD_68:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:655:5: this_Register_0= ruleRegister
                    {
                     
                            newCompositeNode(grammarAccess.getNonGroupOperandAccess().getRegisterParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRegister_in_ruleNonGroupOperand1551);
                    this_Register_0=ruleRegister();

                    state._fsp--;


                            current = this_Register_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:665:5: this_Literal_1= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNonGroupOperandAccess().getLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleNonGroupOperand1578);
                    this_Literal_1=ruleLiteral();

                    state._fsp--;


                            current = this_Literal_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:674:6: ( (otherlv_2= RULE_ID ) )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:674:6: ( (otherlv_2= RULE_ID ) )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:675:1: (otherlv_2= RULE_ID )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:675:1: (otherlv_2= RULE_ID )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:676:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNonGroupOperandRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNonGroupOperand1603); 

                    		newLeafNode(otherlv_2, grammarAccess.getNonGroupOperandAccess().getLabelNameLabelCrossReference_2_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:689:5: this_StackValue_3= ruleStackValue
                    {
                     
                            newCompositeNode(grammarAccess.getNonGroupOperandAccess().getStackValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleStackValue_in_ruleNonGroupOperand1631);
                    this_StackValue_3=ruleStackValue();

                    state._fsp--;


                            current = this_StackValue_3;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonGroupOperand"


    // $ANTLR start "entryRuleStackValue"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:705:1: entryRuleStackValue returns [EObject current=null] : iv_ruleStackValue= ruleStackValue EOF ;
    public final EObject entryRuleStackValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStackValue = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:706:2: (iv_ruleStackValue= ruleStackValue EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:707:2: iv_ruleStackValue= ruleStackValue EOF
            {
             newCompositeNode(grammarAccess.getStackValueRule()); 
            pushFollow(FOLLOW_ruleStackValue_in_entryRuleStackValue1665);
            iv_ruleStackValue=ruleStackValue();

            state._fsp--;

             current =iv_ruleStackValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStackValue1675); 

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
    // $ANTLR end "entryRuleStackValue"


    // $ANTLR start "ruleStackValue"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:714:1: ruleStackValue returns [EObject current=null] : (otherlv_0= KEYWORD_68 | otherlv_1= KEYWORD_80 | this_PickValue_2= rulePickValue ) ;
    public final EObject ruleStackValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_PickValue_2 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:717:28: ( (otherlv_0= KEYWORD_68 | otherlv_1= KEYWORD_80 | this_PickValue_2= rulePickValue ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:718:1: (otherlv_0= KEYWORD_68 | otherlv_1= KEYWORD_80 | this_PickValue_2= rulePickValue )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:718:1: (otherlv_0= KEYWORD_68 | otherlv_1= KEYWORD_80 | this_PickValue_2= rulePickValue )
            int alt17=3;
            switch ( input.LA(1) ) {
            case KEYWORD_68:
                {
                alt17=1;
                }
                break;
            case KEYWORD_80:
                {
                alt17=2;
                }
                break;
            case KEYWORD_79:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:719:2: otherlv_0= KEYWORD_68
                    {
                    otherlv_0=(Token)match(input,KEYWORD_68,FOLLOW_KEYWORD_68_in_ruleStackValue1713); 

                        	newLeafNode(otherlv_0, grammarAccess.getStackValueAccess().getPOPKeyword_0());
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:725:2: otherlv_1= KEYWORD_80
                    {
                    otherlv_1=(Token)match(input,KEYWORD_80,FOLLOW_KEYWORD_80_in_ruleStackValue1731); 

                        	newLeafNode(otherlv_1, grammarAccess.getStackValueAccess().getPUSHKeyword_1());
                        

                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:731:5: this_PickValue_2= rulePickValue
                    {
                     
                            newCompositeNode(grammarAccess.getStackValueAccess().getPickValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePickValue_in_ruleStackValue1758);
                    this_PickValue_2=rulePickValue();

                    state._fsp--;


                            current = this_PickValue_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStackValue"


    // $ANTLR start "entryRulePickValue"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:747:1: entryRulePickValue returns [EObject current=null] : iv_rulePickValue= rulePickValue EOF ;
    public final EObject entryRulePickValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePickValue = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:748:2: (iv_rulePickValue= rulePickValue EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:749:2: iv_rulePickValue= rulePickValue EOF
            {
             newCompositeNode(grammarAccess.getPickValueRule()); 
            pushFollow(FOLLOW_rulePickValue_in_entryRulePickValue1792);
            iv_rulePickValue=rulePickValue();

            state._fsp--;

             current =iv_rulePickValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePickValue1802); 

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
    // $ANTLR end "entryRulePickValue"


    // $ANTLR start "rulePickValue"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:756:1: rulePickValue returns [EObject current=null] : (otherlv_0= KEYWORD_79 ( (lv_pickValue_1_0= ruleLiteralExpression ) ) ) ;
    public final EObject rulePickValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_pickValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:759:28: ( (otherlv_0= KEYWORD_79 ( (lv_pickValue_1_0= ruleLiteralExpression ) ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:760:1: (otherlv_0= KEYWORD_79 ( (lv_pickValue_1_0= ruleLiteralExpression ) ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:760:1: (otherlv_0= KEYWORD_79 ( (lv_pickValue_1_0= ruleLiteralExpression ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:761:2: otherlv_0= KEYWORD_79 ( (lv_pickValue_1_0= ruleLiteralExpression ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_79,FOLLOW_KEYWORD_79_in_rulePickValue1840); 

                	newLeafNode(otherlv_0, grammarAccess.getPickValueAccess().getPICKKeyword_0());
                
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:765:1: ( (lv_pickValue_1_0= ruleLiteralExpression ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:766:1: (lv_pickValue_1_0= ruleLiteralExpression )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:766:1: (lv_pickValue_1_0= ruleLiteralExpression )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:767:3: lv_pickValue_1_0= ruleLiteralExpression
            {
             
            	        newCompositeNode(grammarAccess.getPickValueAccess().getPickValueLiteralExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralExpression_in_rulePickValue1860);
            lv_pickValue_1_0=ruleLiteralExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPickValueRule());
            	        }
                   		set(
                   			current, 
                   			"pickValue",
                    		lv_pickValue_1_0, 
                    		"LiteralExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePickValue"


    // $ANTLR start "entryRuleLabel"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:791:1: entryRuleLabel returns [EObject current=null] : iv_ruleLabel= ruleLabel EOF ;
    public final EObject entryRuleLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabel = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:792:2: (iv_ruleLabel= ruleLabel EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:793:2: iv_ruleLabel= ruleLabel EOF
            {
             newCompositeNode(grammarAccess.getLabelRule()); 
            pushFollow(FOLLOW_ruleLabel_in_entryRuleLabel1895);
            iv_ruleLabel=ruleLabel();

            state._fsp--;

             current =iv_ruleLabel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLabel1905); 

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
    // $ANTLR end "entryRuleLabel"


    // $ANTLR start "ruleLabel"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:800:1: ruleLabel returns [EObject current=null] : (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:803:28: ( (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:804:1: (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:804:1: (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:805:2: otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleLabel1943); 

                	newLeafNode(otherlv_0, grammarAccess.getLabelAccess().getColonKeyword_0());
                
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:809:1: ( (lv_name_1_0= RULE_ID ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:810:1: (lv_name_1_0= RULE_ID )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:810:1: (lv_name_1_0= RULE_ID )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:811:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLabel1959); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLabelAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLabelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLabel"


    // $ANTLR start "entryRuleInstruction"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:835:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:836:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:837:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction1999);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction2009); 

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
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:844:1: ruleInstruction returns [EObject current=null] : (this_BasicInstruction_0= ruleBasicInstruction | this_SpecialInstruction_1= ruleSpecialInstruction ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_BasicInstruction_0 = null;

        EObject this_SpecialInstruction_1 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:847:28: ( (this_BasicInstruction_0= ruleBasicInstruction | this_SpecialInstruction_1= ruleSpecialInstruction ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:848:1: (this_BasicInstruction_0= ruleBasicInstruction | this_SpecialInstruction_1= ruleSpecialInstruction )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:848:1: (this_BasicInstruction_0= ruleBasicInstruction | this_SpecialInstruction_1= ruleSpecialInstruction )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=KEYWORD_40 && LA18_0<=KEYWORD_44)||(LA18_0>=KEYWORD_46 && LA18_0<=KEYWORD_47)||(LA18_0>=KEYWORD_54 && LA18_0<=KEYWORD_61)||(LA18_0>=KEYWORD_64 && LA18_0<=KEYWORD_67)||(LA18_0>=KEYWORD_70 && LA18_0<=KEYWORD_77)) ) {
                alt18=1;
            }
            else if ( ((LA18_0>=KEYWORD_48 && LA18_0<=KEYWORD_53)||(LA18_0>=KEYWORD_62 && LA18_0<=KEYWORD_63)||LA18_0==KEYWORD_69) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:849:5: this_BasicInstruction_0= ruleBasicInstruction
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getBasicInstructionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBasicInstruction_in_ruleInstruction2056);
                    this_BasicInstruction_0=ruleBasicInstruction();

                    state._fsp--;


                            current = this_BasicInstruction_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:859:5: this_SpecialInstruction_1= ruleSpecialInstruction
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSpecialInstructionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSpecialInstruction_in_ruleInstruction2083);
                    this_SpecialInstruction_1=ruleSpecialInstruction();

                    state._fsp--;


                            current = this_SpecialInstruction_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleBasicInstruction"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:875:1: entryRuleBasicInstruction returns [EObject current=null] : iv_ruleBasicInstruction= ruleBasicInstruction EOF ;
    public final EObject entryRuleBasicInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicInstruction = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:876:2: (iv_ruleBasicInstruction= ruleBasicInstruction EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:877:2: iv_ruleBasicInstruction= ruleBasicInstruction EOF
            {
             newCompositeNode(grammarAccess.getBasicInstructionRule()); 
            pushFollow(FOLLOW_ruleBasicInstruction_in_entryRuleBasicInstruction2117);
            iv_ruleBasicInstruction=ruleBasicInstruction();

            state._fsp--;

             current =iv_ruleBasicInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicInstruction2127); 

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
    // $ANTLR end "entryRuleBasicInstruction"


    // $ANTLR start "ruleBasicInstruction"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:884:1: ruleBasicInstruction returns [EObject current=null] : ( ( (lv_opcode_0_0= ruleBasicOpcode ) ) ( (lv_b_1_0= ruleValue ) ) (otherlv_2= KEYWORD_8 )? ( (lv_a_3_0= ruleValue ) ) ) ;
    public final EObject ruleBasicInstruction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_opcode_0_0 = null;

        EObject lv_b_1_0 = null;

        EObject lv_a_3_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:887:28: ( ( ( (lv_opcode_0_0= ruleBasicOpcode ) ) ( (lv_b_1_0= ruleValue ) ) (otherlv_2= KEYWORD_8 )? ( (lv_a_3_0= ruleValue ) ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:888:1: ( ( (lv_opcode_0_0= ruleBasicOpcode ) ) ( (lv_b_1_0= ruleValue ) ) (otherlv_2= KEYWORD_8 )? ( (lv_a_3_0= ruleValue ) ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:888:1: ( ( (lv_opcode_0_0= ruleBasicOpcode ) ) ( (lv_b_1_0= ruleValue ) ) (otherlv_2= KEYWORD_8 )? ( (lv_a_3_0= ruleValue ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:888:2: ( (lv_opcode_0_0= ruleBasicOpcode ) ) ( (lv_b_1_0= ruleValue ) ) (otherlv_2= KEYWORD_8 )? ( (lv_a_3_0= ruleValue ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:888:2: ( (lv_opcode_0_0= ruleBasicOpcode ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:889:1: (lv_opcode_0_0= ruleBasicOpcode )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:889:1: (lv_opcode_0_0= ruleBasicOpcode )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:890:3: lv_opcode_0_0= ruleBasicOpcode
            {
             
            	        newCompositeNode(grammarAccess.getBasicInstructionAccess().getOpcodeBasicOpcodeEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleBasicOpcode_in_ruleBasicInstruction2173);
            lv_opcode_0_0=ruleBasicOpcode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBasicInstructionRule());
            	        }
                   		set(
                   			current, 
                   			"opcode",
                    		lv_opcode_0_0, 
                    		"BasicOpcode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:906:2: ( (lv_b_1_0= ruleValue ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:907:1: (lv_b_1_0= ruleValue )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:907:1: (lv_b_1_0= ruleValue )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:908:3: lv_b_1_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getBasicInstructionAccess().getBValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleBasicInstruction2194);
            lv_b_1_0=ruleValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBasicInstructionRule());
            	        }
                   		set(
                   			current, 
                   			"b",
                    		lv_b_1_0, 
                    		"Value");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:924:2: (otherlv_2= KEYWORD_8 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==KEYWORD_8) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:925:2: otherlv_2= KEYWORD_8
                    {
                    otherlv_2=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleBasicInstruction2208); 

                        	newLeafNode(otherlv_2, grammarAccess.getBasicInstructionAccess().getCommaKeyword_2());
                        

                    }
                    break;

            }

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:929:3: ( (lv_a_3_0= ruleValue ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:930:1: (lv_a_3_0= ruleValue )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:930:1: (lv_a_3_0= ruleValue )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:931:3: lv_a_3_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getBasicInstructionAccess().getAValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleBasicInstruction2230);
            lv_a_3_0=ruleValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBasicInstructionRule());
            	        }
                   		set(
                   			current, 
                   			"a",
                    		lv_a_3_0, 
                    		"Value");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicInstruction"


    // $ANTLR start "entryRuleSpecialInstruction"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:955:1: entryRuleSpecialInstruction returns [EObject current=null] : iv_ruleSpecialInstruction= ruleSpecialInstruction EOF ;
    public final EObject entryRuleSpecialInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecialInstruction = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:956:2: (iv_ruleSpecialInstruction= ruleSpecialInstruction EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:957:2: iv_ruleSpecialInstruction= ruleSpecialInstruction EOF
            {
             newCompositeNode(grammarAccess.getSpecialInstructionRule()); 
            pushFollow(FOLLOW_ruleSpecialInstruction_in_entryRuleSpecialInstruction2265);
            iv_ruleSpecialInstruction=ruleSpecialInstruction();

            state._fsp--;

             current =iv_ruleSpecialInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecialInstruction2275); 

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
    // $ANTLR end "entryRuleSpecialInstruction"


    // $ANTLR start "ruleSpecialInstruction"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:964:1: ruleSpecialInstruction returns [EObject current=null] : ( ( (lv_opcode_0_0= ruleSpecialOpcode ) ) ( (lv_a_1_0= ruleValue ) ) ) ;
    public final EObject ruleSpecialInstruction() throws RecognitionException {
        EObject current = null;

        Enumerator lv_opcode_0_0 = null;

        EObject lv_a_1_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:967:28: ( ( ( (lv_opcode_0_0= ruleSpecialOpcode ) ) ( (lv_a_1_0= ruleValue ) ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:968:1: ( ( (lv_opcode_0_0= ruleSpecialOpcode ) ) ( (lv_a_1_0= ruleValue ) ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:968:1: ( ( (lv_opcode_0_0= ruleSpecialOpcode ) ) ( (lv_a_1_0= ruleValue ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:968:2: ( (lv_opcode_0_0= ruleSpecialOpcode ) ) ( (lv_a_1_0= ruleValue ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:968:2: ( (lv_opcode_0_0= ruleSpecialOpcode ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:969:1: (lv_opcode_0_0= ruleSpecialOpcode )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:969:1: (lv_opcode_0_0= ruleSpecialOpcode )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:970:3: lv_opcode_0_0= ruleSpecialOpcode
            {
             
            	        newCompositeNode(grammarAccess.getSpecialInstructionAccess().getOpcodeSpecialOpcodeEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSpecialOpcode_in_ruleSpecialInstruction2321);
            lv_opcode_0_0=ruleSpecialOpcode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecialInstructionRule());
            	        }
                   		set(
                   			current, 
                   			"opcode",
                    		lv_opcode_0_0, 
                    		"SpecialOpcode");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:986:2: ( (lv_a_1_0= ruleValue ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:987:1: (lv_a_1_0= ruleValue )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:987:1: (lv_a_1_0= ruleValue )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:988:3: lv_a_1_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getSpecialInstructionAccess().getAValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleSpecialInstruction2342);
            lv_a_1_0=ruleValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecialInstructionRule());
            	        }
                   		set(
                   			current, 
                   			"a",
                    		lv_a_1_0, 
                    		"Value");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecialInstruction"


    // $ANTLR start "entryRuleValue"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1012:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1013:2: (iv_ruleValue= ruleValue EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1014:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue2377);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue2387); 

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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1021:1: ruleValue returns [EObject current=null] : (this_LiteralExpression_0= ruleLiteralExpression | this_AddressExpression_1= ruleAddressExpression ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralExpression_0 = null;

        EObject this_AddressExpression_1 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1024:28: ( (this_LiteralExpression_0= ruleLiteralExpression | this_AddressExpression_1= ruleAddressExpression ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1025:1: (this_LiteralExpression_0= ruleLiteralExpression | this_AddressExpression_1= ruleAddressExpression )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1025:1: (this_LiteralExpression_0= ruleLiteralExpression | this_AddressExpression_1= ruleAddressExpression )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=KEYWORD_79 && LA20_0<=KEYWORD_80)||LA20_0==KEYWORD_68||(LA20_0>=KEYWORD_35 && LA20_0<=KEYWORD_37)||LA20_0==KEYWORD_4||(LA20_0>=KEYWORD_15 && LA20_0<=KEYWORD_22)||(LA20_0>=RULE_ID && LA20_0<=RULE_BINNUMBER)) ) {
                alt20=1;
            }
            else if ( (LA20_0==KEYWORD_23) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1026:5: this_LiteralExpression_0= ruleLiteralExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getLiteralExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteralExpression_in_ruleValue2434);
                    this_LiteralExpression_0=ruleLiteralExpression();

                    state._fsp--;


                            current = this_LiteralExpression_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1036:5: this_AddressExpression_1= ruleAddressExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getAddressExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAddressExpression_in_ruleValue2461);
                    this_AddressExpression_1=ruleAddressExpression();

                    state._fsp--;


                            current = this_AddressExpression_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleLiteral"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1052:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1053:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1054:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2495);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2505); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1061:1: ruleLiteral returns [EObject current=null] : ( (lv_number_0_0= ruleNumber ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_number_0_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1064:28: ( ( (lv_number_0_0= ruleNumber ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1065:1: ( (lv_number_0_0= ruleNumber ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1065:1: ( (lv_number_0_0= ruleNumber ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1066:1: (lv_number_0_0= ruleNumber )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1066:1: (lv_number_0_0= ruleNumber )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1067:3: lv_number_0_0= ruleNumber
            {
             
            	        newCompositeNode(grammarAccess.getLiteralAccess().getNumberNumberParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleNumber_in_ruleLiteral2550);
            lv_number_0_0=ruleNumber();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLiteralRule());
            	        }
                   		set(
                   			current, 
                   			"number",
                    		lv_number_0_0, 
                    		"Number");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleRegister"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1091:1: entryRuleRegister returns [EObject current=null] : iv_ruleRegister= ruleRegister EOF ;
    public final EObject entryRuleRegister() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegister = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1092:2: (iv_ruleRegister= ruleRegister EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1093:2: iv_ruleRegister= ruleRegister EOF
            {
             newCompositeNode(grammarAccess.getRegisterRule()); 
            pushFollow(FOLLOW_ruleRegister_in_entryRuleRegister2584);
            iv_ruleRegister=ruleRegister();

            state._fsp--;

             current =iv_ruleRegister; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegister2594); 

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
    // $ANTLR end "entryRuleRegister"


    // $ANTLR start "ruleRegister"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1100:1: ruleRegister returns [EObject current=null] : ( ( (lv_standardRegister_0_0= ruleStandardRegister ) ) | ( (lv_specialRegister_1_0= ruleSpecialRegister ) ) ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Enumerator lv_standardRegister_0_0 = null;

        Enumerator lv_specialRegister_1_0 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1103:28: ( ( ( (lv_standardRegister_0_0= ruleStandardRegister ) ) | ( (lv_specialRegister_1_0= ruleSpecialRegister ) ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1104:1: ( ( (lv_standardRegister_0_0= ruleStandardRegister ) ) | ( (lv_specialRegister_1_0= ruleSpecialRegister ) ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1104:1: ( ( (lv_standardRegister_0_0= ruleStandardRegister ) ) | ( (lv_specialRegister_1_0= ruleSpecialRegister ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=KEYWORD_15 && LA21_0<=KEYWORD_22)) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=KEYWORD_35 && LA21_0<=KEYWORD_37)) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1104:2: ( (lv_standardRegister_0_0= ruleStandardRegister ) )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1104:2: ( (lv_standardRegister_0_0= ruleStandardRegister ) )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1105:1: (lv_standardRegister_0_0= ruleStandardRegister )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1105:1: (lv_standardRegister_0_0= ruleStandardRegister )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1106:3: lv_standardRegister_0_0= ruleStandardRegister
                    {
                     
                    	        newCompositeNode(grammarAccess.getRegisterAccess().getStandardRegisterStandardRegisterEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStandardRegister_in_ruleRegister2640);
                    lv_standardRegister_0_0=ruleStandardRegister();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRegisterRule());
                    	        }
                           		set(
                           			current, 
                           			"standardRegister",
                            		lv_standardRegister_0_0, 
                            		"StandardRegister");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1123:6: ( (lv_specialRegister_1_0= ruleSpecialRegister ) )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1123:6: ( (lv_specialRegister_1_0= ruleSpecialRegister ) )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1124:1: (lv_specialRegister_1_0= ruleSpecialRegister )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1124:1: (lv_specialRegister_1_0= ruleSpecialRegister )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1125:3: lv_specialRegister_1_0= ruleSpecialRegister
                    {
                     
                    	        newCompositeNode(grammarAccess.getRegisterAccess().getSpecialRegisterSpecialRegisterEnumRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSpecialRegister_in_ruleRegister2667);
                    lv_specialRegister_1_0=ruleSpecialRegister();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRegisterRule());
                    	        }
                           		set(
                           			current, 
                           			"specialRegister",
                            		lv_specialRegister_1_0, 
                            		"SpecialRegister");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegister"


    // $ANTLR start "entryRuleAddressExpression"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1151:1: entryRuleAddressExpression returns [EObject current=null] : iv_ruleAddressExpression= ruleAddressExpression EOF ;
    public final EObject entryRuleAddressExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddressExpression = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1152:2: (iv_ruleAddressExpression= ruleAddressExpression EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1153:2: iv_ruleAddressExpression= ruleAddressExpression EOF
            {
             newCompositeNode(grammarAccess.getAddressExpressionRule()); 
            pushFollow(FOLLOW_ruleAddressExpression_in_entryRuleAddressExpression2704);
            iv_ruleAddressExpression=ruleAddressExpression();

            state._fsp--;

             current =iv_ruleAddressExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddressExpression2714); 

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
    // $ANTLR end "entryRuleAddressExpression"


    // $ANTLR start "ruleAddressExpression"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1160:1: ruleAddressExpression returns [EObject current=null] : (otherlv_0= KEYWORD_23 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_24 ) ;
    public final EObject ruleAddressExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_LiteralExpression_1 = null;


         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1163:28: ( (otherlv_0= KEYWORD_23 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_24 ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1164:1: (otherlv_0= KEYWORD_23 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_24 )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1164:1: (otherlv_0= KEYWORD_23 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_24 )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1165:2: otherlv_0= KEYWORD_23 this_LiteralExpression_1= ruleLiteralExpression otherlv_2= KEYWORD_24
            {
            otherlv_0=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleAddressExpression2752); 

                	newLeafNode(otherlv_0, grammarAccess.getAddressExpressionAccess().getLeftSquareBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getAddressExpressionAccess().getLiteralExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleLiteralExpression_in_ruleAddressExpression2773);
            this_LiteralExpression_1=ruleLiteralExpression();

            state._fsp--;


                    current = this_LiteralExpression_1;
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_ruleAddressExpression2785); 

                	newLeafNode(otherlv_2, grammarAccess.getAddressExpressionAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddressExpression"


    // $ANTLR start "entryRuleNumber"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1191:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1192:1: (iv_ruleNumber= ruleNumber EOF )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1193:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber2820);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber2831); 

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
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1200:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEXNUMBER_0= RULE_HEXNUMBER | this_DECNUMBER_1= RULE_DECNUMBER | this_BINNUMBER_2= RULE_BINNUMBER ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXNUMBER_0=null;
        Token this_DECNUMBER_1=null;
        Token this_BINNUMBER_2=null;

         enterRule(); 
            
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1204:6: ( (this_HEXNUMBER_0= RULE_HEXNUMBER | this_DECNUMBER_1= RULE_DECNUMBER | this_BINNUMBER_2= RULE_BINNUMBER ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1205:1: (this_HEXNUMBER_0= RULE_HEXNUMBER | this_DECNUMBER_1= RULE_DECNUMBER | this_BINNUMBER_2= RULE_BINNUMBER )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1205:1: (this_HEXNUMBER_0= RULE_HEXNUMBER | this_DECNUMBER_1= RULE_DECNUMBER | this_BINNUMBER_2= RULE_BINNUMBER )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RULE_HEXNUMBER:
                {
                alt22=1;
                }
                break;
            case RULE_DECNUMBER:
                {
                alt22=2;
                }
                break;
            case RULE_BINNUMBER:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1205:6: this_HEXNUMBER_0= RULE_HEXNUMBER
                    {
                    this_HEXNUMBER_0=(Token)match(input,RULE_HEXNUMBER,FOLLOW_RULE_HEXNUMBER_in_ruleNumber2871); 

                    		current.merge(this_HEXNUMBER_0);
                        
                     
                        newLeafNode(this_HEXNUMBER_0, grammarAccess.getNumberAccess().getHEXNUMBERTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1213:10: this_DECNUMBER_1= RULE_DECNUMBER
                    {
                    this_DECNUMBER_1=(Token)match(input,RULE_DECNUMBER,FOLLOW_RULE_DECNUMBER_in_ruleNumber2897); 

                    		current.merge(this_DECNUMBER_1);
                        
                     
                        newLeafNode(this_DECNUMBER_1, grammarAccess.getNumberAccess().getDECNUMBERTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1221:10: this_BINNUMBER_2= RULE_BINNUMBER
                    {
                    this_BINNUMBER_2=(Token)match(input,RULE_BINNUMBER,FOLLOW_RULE_BINNUMBER_in_ruleNumber2923); 

                    		current.merge(this_BINNUMBER_2);
                        
                     
                        newLeafNode(this_BINNUMBER_2, grammarAccess.getNumberAccess().getBINNUMBERTerminalRuleCall_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "ruleBasicOpcode"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1236:1: ruleBasicOpcode returns [Enumerator current=null] : ( (enumLiteral_0= KEYWORD_71 ) | (enumLiteral_1= KEYWORD_40 ) | (enumLiteral_2= KEYWORD_76 ) | (enumLiteral_3= KEYWORD_67 ) | (enumLiteral_4= KEYWORD_65 ) | (enumLiteral_5= KEYWORD_46 ) | (enumLiteral_6= KEYWORD_47 ) | (enumLiteral_7= KEYWORD_66 ) | (enumLiteral_8= KEYWORD_64 ) | (enumLiteral_9= KEYWORD_42 ) | (enumLiteral_10= KEYWORD_44 ) | (enumLiteral_11= KEYWORD_77 ) | (enumLiteral_12= KEYWORD_73 ) | (enumLiteral_13= KEYWORD_43 ) | (enumLiteral_14= KEYWORD_72 ) | (enumLiteral_15= KEYWORD_55 ) | (enumLiteral_16= KEYWORD_56 ) | (enumLiteral_17= KEYWORD_57 ) | (enumLiteral_18= KEYWORD_60 ) | (enumLiteral_19= KEYWORD_58 ) | (enumLiteral_20= KEYWORD_54 ) | (enumLiteral_21= KEYWORD_59 ) | (enumLiteral_22= KEYWORD_61 ) | (enumLiteral_23= KEYWORD_41 ) | (enumLiteral_24= KEYWORD_70 ) | (enumLiteral_25= KEYWORD_75 ) | (enumLiteral_26= KEYWORD_74 ) ) ;
    public final Enumerator ruleBasicOpcode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;
        Token enumLiteral_26=null;

         enterRule(); 
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1238:28: ( ( (enumLiteral_0= KEYWORD_71 ) | (enumLiteral_1= KEYWORD_40 ) | (enumLiteral_2= KEYWORD_76 ) | (enumLiteral_3= KEYWORD_67 ) | (enumLiteral_4= KEYWORD_65 ) | (enumLiteral_5= KEYWORD_46 ) | (enumLiteral_6= KEYWORD_47 ) | (enumLiteral_7= KEYWORD_66 ) | (enumLiteral_8= KEYWORD_64 ) | (enumLiteral_9= KEYWORD_42 ) | (enumLiteral_10= KEYWORD_44 ) | (enumLiteral_11= KEYWORD_77 ) | (enumLiteral_12= KEYWORD_73 ) | (enumLiteral_13= KEYWORD_43 ) | (enumLiteral_14= KEYWORD_72 ) | (enumLiteral_15= KEYWORD_55 ) | (enumLiteral_16= KEYWORD_56 ) | (enumLiteral_17= KEYWORD_57 ) | (enumLiteral_18= KEYWORD_60 ) | (enumLiteral_19= KEYWORD_58 ) | (enumLiteral_20= KEYWORD_54 ) | (enumLiteral_21= KEYWORD_59 ) | (enumLiteral_22= KEYWORD_61 ) | (enumLiteral_23= KEYWORD_41 ) | (enumLiteral_24= KEYWORD_70 ) | (enumLiteral_25= KEYWORD_75 ) | (enumLiteral_26= KEYWORD_74 ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1239:1: ( (enumLiteral_0= KEYWORD_71 ) | (enumLiteral_1= KEYWORD_40 ) | (enumLiteral_2= KEYWORD_76 ) | (enumLiteral_3= KEYWORD_67 ) | (enumLiteral_4= KEYWORD_65 ) | (enumLiteral_5= KEYWORD_46 ) | (enumLiteral_6= KEYWORD_47 ) | (enumLiteral_7= KEYWORD_66 ) | (enumLiteral_8= KEYWORD_64 ) | (enumLiteral_9= KEYWORD_42 ) | (enumLiteral_10= KEYWORD_44 ) | (enumLiteral_11= KEYWORD_77 ) | (enumLiteral_12= KEYWORD_73 ) | (enumLiteral_13= KEYWORD_43 ) | (enumLiteral_14= KEYWORD_72 ) | (enumLiteral_15= KEYWORD_55 ) | (enumLiteral_16= KEYWORD_56 ) | (enumLiteral_17= KEYWORD_57 ) | (enumLiteral_18= KEYWORD_60 ) | (enumLiteral_19= KEYWORD_58 ) | (enumLiteral_20= KEYWORD_54 ) | (enumLiteral_21= KEYWORD_59 ) | (enumLiteral_22= KEYWORD_61 ) | (enumLiteral_23= KEYWORD_41 ) | (enumLiteral_24= KEYWORD_70 ) | (enumLiteral_25= KEYWORD_75 ) | (enumLiteral_26= KEYWORD_74 ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1239:1: ( (enumLiteral_0= KEYWORD_71 ) | (enumLiteral_1= KEYWORD_40 ) | (enumLiteral_2= KEYWORD_76 ) | (enumLiteral_3= KEYWORD_67 ) | (enumLiteral_4= KEYWORD_65 ) | (enumLiteral_5= KEYWORD_46 ) | (enumLiteral_6= KEYWORD_47 ) | (enumLiteral_7= KEYWORD_66 ) | (enumLiteral_8= KEYWORD_64 ) | (enumLiteral_9= KEYWORD_42 ) | (enumLiteral_10= KEYWORD_44 ) | (enumLiteral_11= KEYWORD_77 ) | (enumLiteral_12= KEYWORD_73 ) | (enumLiteral_13= KEYWORD_43 ) | (enumLiteral_14= KEYWORD_72 ) | (enumLiteral_15= KEYWORD_55 ) | (enumLiteral_16= KEYWORD_56 ) | (enumLiteral_17= KEYWORD_57 ) | (enumLiteral_18= KEYWORD_60 ) | (enumLiteral_19= KEYWORD_58 ) | (enumLiteral_20= KEYWORD_54 ) | (enumLiteral_21= KEYWORD_59 ) | (enumLiteral_22= KEYWORD_61 ) | (enumLiteral_23= KEYWORD_41 ) | (enumLiteral_24= KEYWORD_70 ) | (enumLiteral_25= KEYWORD_75 ) | (enumLiteral_26= KEYWORD_74 ) )
            int alt23=27;
            switch ( input.LA(1) ) {
            case KEYWORD_71:
                {
                alt23=1;
                }
                break;
            case KEYWORD_40:
                {
                alt23=2;
                }
                break;
            case KEYWORD_76:
                {
                alt23=3;
                }
                break;
            case KEYWORD_67:
                {
                alt23=4;
                }
                break;
            case KEYWORD_65:
                {
                alt23=5;
                }
                break;
            case KEYWORD_46:
                {
                alt23=6;
                }
                break;
            case KEYWORD_47:
                {
                alt23=7;
                }
                break;
            case KEYWORD_66:
                {
                alt23=8;
                }
                break;
            case KEYWORD_64:
                {
                alt23=9;
                }
                break;
            case KEYWORD_42:
                {
                alt23=10;
                }
                break;
            case KEYWORD_44:
                {
                alt23=11;
                }
                break;
            case KEYWORD_77:
                {
                alt23=12;
                }
                break;
            case KEYWORD_73:
                {
                alt23=13;
                }
                break;
            case KEYWORD_43:
                {
                alt23=14;
                }
                break;
            case KEYWORD_72:
                {
                alt23=15;
                }
                break;
            case KEYWORD_55:
                {
                alt23=16;
                }
                break;
            case KEYWORD_56:
                {
                alt23=17;
                }
                break;
            case KEYWORD_57:
                {
                alt23=18;
                }
                break;
            case KEYWORD_60:
                {
                alt23=19;
                }
                break;
            case KEYWORD_58:
                {
                alt23=20;
                }
                break;
            case KEYWORD_54:
                {
                alt23=21;
                }
                break;
            case KEYWORD_59:
                {
                alt23=22;
                }
                break;
            case KEYWORD_61:
                {
                alt23=23;
                }
                break;
            case KEYWORD_41:
                {
                alt23=24;
                }
                break;
            case KEYWORD_70:
                {
                alt23=25;
                }
                break;
            case KEYWORD_75:
                {
                alt23=26;
                }
                break;
            case KEYWORD_74:
                {
                alt23=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1239:2: (enumLiteral_0= KEYWORD_71 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1239:2: (enumLiteral_0= KEYWORD_71 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1239:7: enumLiteral_0= KEYWORD_71
                    {
                    enumLiteral_0=(Token)match(input,KEYWORD_71,FOLLOW_KEYWORD_71_in_ruleBasicOpcode2985); 

                            current = grammarAccess.getBasicOpcodeAccess().getSETEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getBasicOpcodeAccess().getSETEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1245:6: (enumLiteral_1= KEYWORD_40 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1245:6: (enumLiteral_1= KEYWORD_40 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1245:11: enumLiteral_1= KEYWORD_40
                    {
                    enumLiteral_1=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleBasicOpcode3007); 

                            current = grammarAccess.getBasicOpcodeAccess().getADDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getBasicOpcodeAccess().getADDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1251:6: (enumLiteral_2= KEYWORD_76 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1251:6: (enumLiteral_2= KEYWORD_76 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1251:11: enumLiteral_2= KEYWORD_76
                    {
                    enumLiteral_2=(Token)match(input,KEYWORD_76,FOLLOW_KEYWORD_76_in_ruleBasicOpcode3029); 

                            current = grammarAccess.getBasicOpcodeAccess().getSUBEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getBasicOpcodeAccess().getSUBEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1257:6: (enumLiteral_3= KEYWORD_67 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1257:6: (enumLiteral_3= KEYWORD_67 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1257:11: enumLiteral_3= KEYWORD_67
                    {
                    enumLiteral_3=(Token)match(input,KEYWORD_67,FOLLOW_KEYWORD_67_in_ruleBasicOpcode3051); 

                            current = grammarAccess.getBasicOpcodeAccess().getMULEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getBasicOpcodeAccess().getMULEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1263:6: (enumLiteral_4= KEYWORD_65 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1263:6: (enumLiteral_4= KEYWORD_65 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1263:11: enumLiteral_4= KEYWORD_65
                    {
                    enumLiteral_4=(Token)match(input,KEYWORD_65,FOLLOW_KEYWORD_65_in_ruleBasicOpcode3073); 

                            current = grammarAccess.getBasicOpcodeAccess().getMLIEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getBasicOpcodeAccess().getMLIEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1269:6: (enumLiteral_5= KEYWORD_46 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1269:6: (enumLiteral_5= KEYWORD_46 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1269:11: enumLiteral_5= KEYWORD_46
                    {
                    enumLiteral_5=(Token)match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_ruleBasicOpcode3095); 

                            current = grammarAccess.getBasicOpcodeAccess().getDIVEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getBasicOpcodeAccess().getDIVEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1275:6: (enumLiteral_6= KEYWORD_47 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1275:6: (enumLiteral_6= KEYWORD_47 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1275:11: enumLiteral_6= KEYWORD_47
                    {
                    enumLiteral_6=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_ruleBasicOpcode3117); 

                            current = grammarAccess.getBasicOpcodeAccess().getDVIEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getBasicOpcodeAccess().getDVIEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1281:6: (enumLiteral_7= KEYWORD_66 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1281:6: (enumLiteral_7= KEYWORD_66 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1281:11: enumLiteral_7= KEYWORD_66
                    {
                    enumLiteral_7=(Token)match(input,KEYWORD_66,FOLLOW_KEYWORD_66_in_ruleBasicOpcode3139); 

                            current = grammarAccess.getBasicOpcodeAccess().getMODEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getBasicOpcodeAccess().getMODEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1287:6: (enumLiteral_8= KEYWORD_64 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1287:6: (enumLiteral_8= KEYWORD_64 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1287:11: enumLiteral_8= KEYWORD_64
                    {
                    enumLiteral_8=(Token)match(input,KEYWORD_64,FOLLOW_KEYWORD_64_in_ruleBasicOpcode3161); 

                            current = grammarAccess.getBasicOpcodeAccess().getMDIEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getBasicOpcodeAccess().getMDIEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1293:6: (enumLiteral_9= KEYWORD_42 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1293:6: (enumLiteral_9= KEYWORD_42 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1293:11: enumLiteral_9= KEYWORD_42
                    {
                    enumLiteral_9=(Token)match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_ruleBasicOpcode3183); 

                            current = grammarAccess.getBasicOpcodeAccess().getANDEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getBasicOpcodeAccess().getANDEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1299:6: (enumLiteral_10= KEYWORD_44 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1299:6: (enumLiteral_10= KEYWORD_44 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1299:11: enumLiteral_10= KEYWORD_44
                    {
                    enumLiteral_10=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleBasicOpcode3205); 

                            current = grammarAccess.getBasicOpcodeAccess().getBOREnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getBasicOpcodeAccess().getBOREnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1305:6: (enumLiteral_11= KEYWORD_77 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1305:6: (enumLiteral_11= KEYWORD_77 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1305:11: enumLiteral_11= KEYWORD_77
                    {
                    enumLiteral_11=(Token)match(input,KEYWORD_77,FOLLOW_KEYWORD_77_in_ruleBasicOpcode3227); 

                            current = grammarAccess.getBasicOpcodeAccess().getXOREnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_11, grammarAccess.getBasicOpcodeAccess().getXOREnumLiteralDeclaration_11()); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1311:6: (enumLiteral_12= KEYWORD_73 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1311:6: (enumLiteral_12= KEYWORD_73 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1311:11: enumLiteral_12= KEYWORD_73
                    {
                    enumLiteral_12=(Token)match(input,KEYWORD_73,FOLLOW_KEYWORD_73_in_ruleBasicOpcode3249); 

                            current = grammarAccess.getBasicOpcodeAccess().getSHREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_12, grammarAccess.getBasicOpcodeAccess().getSHREnumLiteralDeclaration_12()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1317:6: (enumLiteral_13= KEYWORD_43 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1317:6: (enumLiteral_13= KEYWORD_43 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1317:11: enumLiteral_13= KEYWORD_43
                    {
                    enumLiteral_13=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_ruleBasicOpcode3271); 

                            current = grammarAccess.getBasicOpcodeAccess().getASREnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_13, grammarAccess.getBasicOpcodeAccess().getASREnumLiteralDeclaration_13()); 
                        

                    }


                    }
                    break;
                case 15 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1323:6: (enumLiteral_14= KEYWORD_72 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1323:6: (enumLiteral_14= KEYWORD_72 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1323:11: enumLiteral_14= KEYWORD_72
                    {
                    enumLiteral_14=(Token)match(input,KEYWORD_72,FOLLOW_KEYWORD_72_in_ruleBasicOpcode3293); 

                            current = grammarAccess.getBasicOpcodeAccess().getSHLEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_14, grammarAccess.getBasicOpcodeAccess().getSHLEnumLiteralDeclaration_14()); 
                        

                    }


                    }
                    break;
                case 16 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1329:6: (enumLiteral_15= KEYWORD_55 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1329:6: (enumLiteral_15= KEYWORD_55 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1329:11: enumLiteral_15= KEYWORD_55
                    {
                    enumLiteral_15=(Token)match(input,KEYWORD_55,FOLLOW_KEYWORD_55_in_ruleBasicOpcode3315); 

                            current = grammarAccess.getBasicOpcodeAccess().getIFBEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_15, grammarAccess.getBasicOpcodeAccess().getIFBEnumLiteralDeclaration_15()); 
                        

                    }


                    }
                    break;
                case 17 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1335:6: (enumLiteral_16= KEYWORD_56 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1335:6: (enumLiteral_16= KEYWORD_56 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1335:11: enumLiteral_16= KEYWORD_56
                    {
                    enumLiteral_16=(Token)match(input,KEYWORD_56,FOLLOW_KEYWORD_56_in_ruleBasicOpcode3337); 

                            current = grammarAccess.getBasicOpcodeAccess().getIFCEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_16, grammarAccess.getBasicOpcodeAccess().getIFCEnumLiteralDeclaration_16()); 
                        

                    }


                    }
                    break;
                case 18 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1341:6: (enumLiteral_17= KEYWORD_57 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1341:6: (enumLiteral_17= KEYWORD_57 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1341:11: enumLiteral_17= KEYWORD_57
                    {
                    enumLiteral_17=(Token)match(input,KEYWORD_57,FOLLOW_KEYWORD_57_in_ruleBasicOpcode3359); 

                            current = grammarAccess.getBasicOpcodeAccess().getIFEEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_17, grammarAccess.getBasicOpcodeAccess().getIFEEnumLiteralDeclaration_17()); 
                        

                    }


                    }
                    break;
                case 19 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1347:6: (enumLiteral_18= KEYWORD_60 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1347:6: (enumLiteral_18= KEYWORD_60 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1347:11: enumLiteral_18= KEYWORD_60
                    {
                    enumLiteral_18=(Token)match(input,KEYWORD_60,FOLLOW_KEYWORD_60_in_ruleBasicOpcode3381); 

                            current = grammarAccess.getBasicOpcodeAccess().getIFNEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_18, grammarAccess.getBasicOpcodeAccess().getIFNEnumLiteralDeclaration_18()); 
                        

                    }


                    }
                    break;
                case 20 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1353:6: (enumLiteral_19= KEYWORD_58 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1353:6: (enumLiteral_19= KEYWORD_58 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1353:11: enumLiteral_19= KEYWORD_58
                    {
                    enumLiteral_19=(Token)match(input,KEYWORD_58,FOLLOW_KEYWORD_58_in_ruleBasicOpcode3403); 

                            current = grammarAccess.getBasicOpcodeAccess().getIFGEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_19, grammarAccess.getBasicOpcodeAccess().getIFGEnumLiteralDeclaration_19()); 
                        

                    }


                    }
                    break;
                case 21 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1359:6: (enumLiteral_20= KEYWORD_54 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1359:6: (enumLiteral_20= KEYWORD_54 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1359:11: enumLiteral_20= KEYWORD_54
                    {
                    enumLiteral_20=(Token)match(input,KEYWORD_54,FOLLOW_KEYWORD_54_in_ruleBasicOpcode3425); 

                            current = grammarAccess.getBasicOpcodeAccess().getIFAEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_20, grammarAccess.getBasicOpcodeAccess().getIFAEnumLiteralDeclaration_20()); 
                        

                    }


                    }
                    break;
                case 22 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1365:6: (enumLiteral_21= KEYWORD_59 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1365:6: (enumLiteral_21= KEYWORD_59 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1365:11: enumLiteral_21= KEYWORD_59
                    {
                    enumLiteral_21=(Token)match(input,KEYWORD_59,FOLLOW_KEYWORD_59_in_ruleBasicOpcode3447); 

                            current = grammarAccess.getBasicOpcodeAccess().getIFLEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_21, grammarAccess.getBasicOpcodeAccess().getIFLEnumLiteralDeclaration_21()); 
                        

                    }


                    }
                    break;
                case 23 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1371:6: (enumLiteral_22= KEYWORD_61 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1371:6: (enumLiteral_22= KEYWORD_61 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1371:11: enumLiteral_22= KEYWORD_61
                    {
                    enumLiteral_22=(Token)match(input,KEYWORD_61,FOLLOW_KEYWORD_61_in_ruleBasicOpcode3469); 

                            current = grammarAccess.getBasicOpcodeAccess().getIFUEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_22, grammarAccess.getBasicOpcodeAccess().getIFUEnumLiteralDeclaration_22()); 
                        

                    }


                    }
                    break;
                case 24 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1377:6: (enumLiteral_23= KEYWORD_41 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1377:6: (enumLiteral_23= KEYWORD_41 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1377:11: enumLiteral_23= KEYWORD_41
                    {
                    enumLiteral_23=(Token)match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_ruleBasicOpcode3491); 

                            current = grammarAccess.getBasicOpcodeAccess().getADXEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_23, grammarAccess.getBasicOpcodeAccess().getADXEnumLiteralDeclaration_23()); 
                        

                    }


                    }
                    break;
                case 25 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1383:6: (enumLiteral_24= KEYWORD_70 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1383:6: (enumLiteral_24= KEYWORD_70 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1383:11: enumLiteral_24= KEYWORD_70
                    {
                    enumLiteral_24=(Token)match(input,KEYWORD_70,FOLLOW_KEYWORD_70_in_ruleBasicOpcode3513); 

                            current = grammarAccess.getBasicOpcodeAccess().getSBXEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_24, grammarAccess.getBasicOpcodeAccess().getSBXEnumLiteralDeclaration_24()); 
                        

                    }


                    }
                    break;
                case 26 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1389:6: (enumLiteral_25= KEYWORD_75 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1389:6: (enumLiteral_25= KEYWORD_75 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1389:11: enumLiteral_25= KEYWORD_75
                    {
                    enumLiteral_25=(Token)match(input,KEYWORD_75,FOLLOW_KEYWORD_75_in_ruleBasicOpcode3535); 

                            current = grammarAccess.getBasicOpcodeAccess().getSTIEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_25, grammarAccess.getBasicOpcodeAccess().getSTIEnumLiteralDeclaration_25()); 
                        

                    }


                    }
                    break;
                case 27 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1395:6: (enumLiteral_26= KEYWORD_74 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1395:6: (enumLiteral_26= KEYWORD_74 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1395:11: enumLiteral_26= KEYWORD_74
                    {
                    enumLiteral_26=(Token)match(input,KEYWORD_74,FOLLOW_KEYWORD_74_in_ruleBasicOpcode3557); 

                            current = grammarAccess.getBasicOpcodeAccess().getSTDEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_26, grammarAccess.getBasicOpcodeAccess().getSTDEnumLiteralDeclaration_26()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicOpcode"


    // $ANTLR start "ruleSpecialOpcode"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1405:1: ruleSpecialOpcode returns [Enumerator current=null] : ( (enumLiteral_0= KEYWORD_63 ) | (enumLiteral_1= KEYWORD_62 ) | (enumLiteral_2= KEYWORD_51 ) | (enumLiteral_3= KEYWORD_53 ) | (enumLiteral_4= KEYWORD_69 ) | (enumLiteral_5= KEYWORD_52 ) | (enumLiteral_6= KEYWORD_49 ) | (enumLiteral_7= KEYWORD_50 ) | (enumLiteral_8= KEYWORD_48 ) ) ;
    public final Enumerator ruleSpecialOpcode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;

         enterRule(); 
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1407:28: ( ( (enumLiteral_0= KEYWORD_63 ) | (enumLiteral_1= KEYWORD_62 ) | (enumLiteral_2= KEYWORD_51 ) | (enumLiteral_3= KEYWORD_53 ) | (enumLiteral_4= KEYWORD_69 ) | (enumLiteral_5= KEYWORD_52 ) | (enumLiteral_6= KEYWORD_49 ) | (enumLiteral_7= KEYWORD_50 ) | (enumLiteral_8= KEYWORD_48 ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1408:1: ( (enumLiteral_0= KEYWORD_63 ) | (enumLiteral_1= KEYWORD_62 ) | (enumLiteral_2= KEYWORD_51 ) | (enumLiteral_3= KEYWORD_53 ) | (enumLiteral_4= KEYWORD_69 ) | (enumLiteral_5= KEYWORD_52 ) | (enumLiteral_6= KEYWORD_49 ) | (enumLiteral_7= KEYWORD_50 ) | (enumLiteral_8= KEYWORD_48 ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1408:1: ( (enumLiteral_0= KEYWORD_63 ) | (enumLiteral_1= KEYWORD_62 ) | (enumLiteral_2= KEYWORD_51 ) | (enumLiteral_3= KEYWORD_53 ) | (enumLiteral_4= KEYWORD_69 ) | (enumLiteral_5= KEYWORD_52 ) | (enumLiteral_6= KEYWORD_49 ) | (enumLiteral_7= KEYWORD_50 ) | (enumLiteral_8= KEYWORD_48 ) )
            int alt24=9;
            switch ( input.LA(1) ) {
            case KEYWORD_63:
                {
                alt24=1;
                }
                break;
            case KEYWORD_62:
                {
                alt24=2;
                }
                break;
            case KEYWORD_51:
                {
                alt24=3;
                }
                break;
            case KEYWORD_53:
                {
                alt24=4;
                }
                break;
            case KEYWORD_69:
                {
                alt24=5;
                }
                break;
            case KEYWORD_52:
                {
                alt24=6;
                }
                break;
            case KEYWORD_49:
                {
                alt24=7;
                }
                break;
            case KEYWORD_50:
                {
                alt24=8;
                }
                break;
            case KEYWORD_48:
                {
                alt24=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1408:2: (enumLiteral_0= KEYWORD_63 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1408:2: (enumLiteral_0= KEYWORD_63 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1408:7: enumLiteral_0= KEYWORD_63
                    {
                    enumLiteral_0=(Token)match(input,KEYWORD_63,FOLLOW_KEYWORD_63_in_ruleSpecialOpcode3607); 

                            current = grammarAccess.getSpecialOpcodeAccess().getJSREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getSpecialOpcodeAccess().getJSREnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1414:6: (enumLiteral_1= KEYWORD_62 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1414:6: (enumLiteral_1= KEYWORD_62 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1414:11: enumLiteral_1= KEYWORD_62
                    {
                    enumLiteral_1=(Token)match(input,KEYWORD_62,FOLLOW_KEYWORD_62_in_ruleSpecialOpcode3629); 

                            current = grammarAccess.getSpecialOpcodeAccess().getINTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getSpecialOpcodeAccess().getINTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1420:6: (enumLiteral_2= KEYWORD_51 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1420:6: (enumLiteral_2= KEYWORD_51 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1420:11: enumLiteral_2= KEYWORD_51
                    {
                    enumLiteral_2=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_ruleSpecialOpcode3651); 

                            current = grammarAccess.getSpecialOpcodeAccess().getIAGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getSpecialOpcodeAccess().getIAGEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1426:6: (enumLiteral_3= KEYWORD_53 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1426:6: (enumLiteral_3= KEYWORD_53 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1426:11: enumLiteral_3= KEYWORD_53
                    {
                    enumLiteral_3=(Token)match(input,KEYWORD_53,FOLLOW_KEYWORD_53_in_ruleSpecialOpcode3673); 

                            current = grammarAccess.getSpecialOpcodeAccess().getIASEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getSpecialOpcodeAccess().getIASEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1432:6: (enumLiteral_4= KEYWORD_69 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1432:6: (enumLiteral_4= KEYWORD_69 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1432:11: enumLiteral_4= KEYWORD_69
                    {
                    enumLiteral_4=(Token)match(input,KEYWORD_69,FOLLOW_KEYWORD_69_in_ruleSpecialOpcode3695); 

                            current = grammarAccess.getSpecialOpcodeAccess().getRFIEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getSpecialOpcodeAccess().getRFIEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1438:6: (enumLiteral_5= KEYWORD_52 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1438:6: (enumLiteral_5= KEYWORD_52 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1438:11: enumLiteral_5= KEYWORD_52
                    {
                    enumLiteral_5=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_ruleSpecialOpcode3717); 

                            current = grammarAccess.getSpecialOpcodeAccess().getIAQEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getSpecialOpcodeAccess().getIAQEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1444:6: (enumLiteral_6= KEYWORD_49 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1444:6: (enumLiteral_6= KEYWORD_49 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1444:11: enumLiteral_6= KEYWORD_49
                    {
                    enumLiteral_6=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_ruleSpecialOpcode3739); 

                            current = grammarAccess.getSpecialOpcodeAccess().getHWNEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getSpecialOpcodeAccess().getHWNEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1450:6: (enumLiteral_7= KEYWORD_50 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1450:6: (enumLiteral_7= KEYWORD_50 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1450:11: enumLiteral_7= KEYWORD_50
                    {
                    enumLiteral_7=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_ruleSpecialOpcode3761); 

                            current = grammarAccess.getSpecialOpcodeAccess().getHWQEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getSpecialOpcodeAccess().getHWQEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1456:6: (enumLiteral_8= KEYWORD_48 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1456:6: (enumLiteral_8= KEYWORD_48 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1456:11: enumLiteral_8= KEYWORD_48
                    {
                    enumLiteral_8=(Token)match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_ruleSpecialOpcode3783); 

                            current = grammarAccess.getSpecialOpcodeAccess().getHWIEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getSpecialOpcodeAccess().getHWIEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecialOpcode"


    // $ANTLR start "ruleStandardRegister"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1466:1: ruleStandardRegister returns [Enumerator current=null] : ( (enumLiteral_0= KEYWORD_15 ) | (enumLiteral_1= KEYWORD_16 ) | (enumLiteral_2= KEYWORD_17 ) | (enumLiteral_3= KEYWORD_20 ) | (enumLiteral_4= KEYWORD_21 ) | (enumLiteral_5= KEYWORD_22 ) | (enumLiteral_6= KEYWORD_18 ) | (enumLiteral_7= KEYWORD_19 ) ) ;
    public final Enumerator ruleStandardRegister() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;

         enterRule(); 
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1468:28: ( ( (enumLiteral_0= KEYWORD_15 ) | (enumLiteral_1= KEYWORD_16 ) | (enumLiteral_2= KEYWORD_17 ) | (enumLiteral_3= KEYWORD_20 ) | (enumLiteral_4= KEYWORD_21 ) | (enumLiteral_5= KEYWORD_22 ) | (enumLiteral_6= KEYWORD_18 ) | (enumLiteral_7= KEYWORD_19 ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1469:1: ( (enumLiteral_0= KEYWORD_15 ) | (enumLiteral_1= KEYWORD_16 ) | (enumLiteral_2= KEYWORD_17 ) | (enumLiteral_3= KEYWORD_20 ) | (enumLiteral_4= KEYWORD_21 ) | (enumLiteral_5= KEYWORD_22 ) | (enumLiteral_6= KEYWORD_18 ) | (enumLiteral_7= KEYWORD_19 ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1469:1: ( (enumLiteral_0= KEYWORD_15 ) | (enumLiteral_1= KEYWORD_16 ) | (enumLiteral_2= KEYWORD_17 ) | (enumLiteral_3= KEYWORD_20 ) | (enumLiteral_4= KEYWORD_21 ) | (enumLiteral_5= KEYWORD_22 ) | (enumLiteral_6= KEYWORD_18 ) | (enumLiteral_7= KEYWORD_19 ) )
            int alt25=8;
            switch ( input.LA(1) ) {
            case KEYWORD_15:
                {
                alt25=1;
                }
                break;
            case KEYWORD_16:
                {
                alt25=2;
                }
                break;
            case KEYWORD_17:
                {
                alt25=3;
                }
                break;
            case KEYWORD_20:
                {
                alt25=4;
                }
                break;
            case KEYWORD_21:
                {
                alt25=5;
                }
                break;
            case KEYWORD_22:
                {
                alt25=6;
                }
                break;
            case KEYWORD_18:
                {
                alt25=7;
                }
                break;
            case KEYWORD_19:
                {
                alt25=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1469:2: (enumLiteral_0= KEYWORD_15 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1469:2: (enumLiteral_0= KEYWORD_15 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1469:7: enumLiteral_0= KEYWORD_15
                    {
                    enumLiteral_0=(Token)match(input,KEYWORD_15,FOLLOW_KEYWORD_15_in_ruleStandardRegister3833); 

                            current = grammarAccess.getStandardRegisterAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getStandardRegisterAccess().getAEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1475:6: (enumLiteral_1= KEYWORD_16 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1475:6: (enumLiteral_1= KEYWORD_16 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1475:11: enumLiteral_1= KEYWORD_16
                    {
                    enumLiteral_1=(Token)match(input,KEYWORD_16,FOLLOW_KEYWORD_16_in_ruleStandardRegister3855); 

                            current = grammarAccess.getStandardRegisterAccess().getBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getStandardRegisterAccess().getBEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1481:6: (enumLiteral_2= KEYWORD_17 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1481:6: (enumLiteral_2= KEYWORD_17 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1481:11: enumLiteral_2= KEYWORD_17
                    {
                    enumLiteral_2=(Token)match(input,KEYWORD_17,FOLLOW_KEYWORD_17_in_ruleStandardRegister3877); 

                            current = grammarAccess.getStandardRegisterAccess().getCEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getStandardRegisterAccess().getCEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1487:6: (enumLiteral_3= KEYWORD_20 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1487:6: (enumLiteral_3= KEYWORD_20 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1487:11: enumLiteral_3= KEYWORD_20
                    {
                    enumLiteral_3=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleStandardRegister3899); 

                            current = grammarAccess.getStandardRegisterAccess().getXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getStandardRegisterAccess().getXEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1493:6: (enumLiteral_4= KEYWORD_21 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1493:6: (enumLiteral_4= KEYWORD_21 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1493:11: enumLiteral_4= KEYWORD_21
                    {
                    enumLiteral_4=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleStandardRegister3921); 

                            current = grammarAccess.getStandardRegisterAccess().getYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getStandardRegisterAccess().getYEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1499:6: (enumLiteral_5= KEYWORD_22 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1499:6: (enumLiteral_5= KEYWORD_22 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1499:11: enumLiteral_5= KEYWORD_22
                    {
                    enumLiteral_5=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleStandardRegister3943); 

                            current = grammarAccess.getStandardRegisterAccess().getZEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getStandardRegisterAccess().getZEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1505:6: (enumLiteral_6= KEYWORD_18 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1505:6: (enumLiteral_6= KEYWORD_18 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1505:11: enumLiteral_6= KEYWORD_18
                    {
                    enumLiteral_6=(Token)match(input,KEYWORD_18,FOLLOW_KEYWORD_18_in_ruleStandardRegister3965); 

                            current = grammarAccess.getStandardRegisterAccess().getIEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getStandardRegisterAccess().getIEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1511:6: (enumLiteral_7= KEYWORD_19 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1511:6: (enumLiteral_7= KEYWORD_19 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1511:11: enumLiteral_7= KEYWORD_19
                    {
                    enumLiteral_7=(Token)match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_ruleStandardRegister3987); 

                            current = grammarAccess.getStandardRegisterAccess().getJEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getStandardRegisterAccess().getJEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStandardRegister"


    // $ANTLR start "ruleSpecialRegister"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1521:1: ruleSpecialRegister returns [Enumerator current=null] : ( (enumLiteral_0= KEYWORD_37 ) | (enumLiteral_1= KEYWORD_36 ) | (enumLiteral_2= KEYWORD_35 ) ) ;
    public final Enumerator ruleSpecialRegister() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1523:28: ( ( (enumLiteral_0= KEYWORD_37 ) | (enumLiteral_1= KEYWORD_36 ) | (enumLiteral_2= KEYWORD_35 ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1524:1: ( (enumLiteral_0= KEYWORD_37 ) | (enumLiteral_1= KEYWORD_36 ) | (enumLiteral_2= KEYWORD_35 ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1524:1: ( (enumLiteral_0= KEYWORD_37 ) | (enumLiteral_1= KEYWORD_36 ) | (enumLiteral_2= KEYWORD_35 ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case KEYWORD_37:
                {
                alt26=1;
                }
                break;
            case KEYWORD_36:
                {
                alt26=2;
                }
                break;
            case KEYWORD_35:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1524:2: (enumLiteral_0= KEYWORD_37 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1524:2: (enumLiteral_0= KEYWORD_37 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1524:7: enumLiteral_0= KEYWORD_37
                    {
                    enumLiteral_0=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleSpecialRegister4037); 

                            current = grammarAccess.getSpecialRegisterAccess().getSPEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getSpecialRegisterAccess().getSPEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1530:6: (enumLiteral_1= KEYWORD_36 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1530:6: (enumLiteral_1= KEYWORD_36 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1530:11: enumLiteral_1= KEYWORD_36
                    {
                    enumLiteral_1=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleSpecialRegister4059); 

                            current = grammarAccess.getSpecialRegisterAccess().getPCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getSpecialRegisterAccess().getPCEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1536:6: (enumLiteral_2= KEYWORD_35 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1536:6: (enumLiteral_2= KEYWORD_35 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1536:11: enumLiteral_2= KEYWORD_35
                    {
                    enumLiteral_2=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleSpecialRegister4081); 

                            current = grammarAccess.getSpecialRegisterAccess().getEXEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getSpecialRegisterAccess().getEXEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecialRegister"


    // $ANTLR start "ruleOperator"
    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1546:1: ruleOperator returns [Enumerator current=null] : ( (enumLiteral_0= KEYWORD_7 ) | (enumLiteral_1= KEYWORD_9 ) | (enumLiteral_2= KEYWORD_6 ) | (enumLiteral_3= KEYWORD_10 ) | (enumLiteral_4= KEYWORD_2 ) | (enumLiteral_5= KEYWORD_30 ) | (enumLiteral_6= KEYWORD_34 ) | (enumLiteral_7= KEYWORD_39 ) | (enumLiteral_8= KEYWORD_3 ) | (enumLiteral_9= KEYWORD_26 ) | (enumLiteral_10= KEYWORD_25 ) | (enumLiteral_11= KEYWORD_27 ) | (enumLiteral_12= KEYWORD_1 ) | (enumLiteral_13= KEYWORD_32 ) | (enumLiteral_14= KEYWORD_28 ) | (enumLiteral_15= KEYWORD_13 ) | (enumLiteral_16= KEYWORD_33 ) | (enumLiteral_17= KEYWORD_12 ) | (enumLiteral_18= KEYWORD_31 ) | (enumLiteral_19= KEYWORD_29 ) | (enumLiteral_20= KEYWORD_38 ) | (enumLiteral_21= KEYWORD_14 ) | (enumLiteral_22= KEYWORD_11 ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;

         enterRule(); 
        try {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1548:28: ( ( (enumLiteral_0= KEYWORD_7 ) | (enumLiteral_1= KEYWORD_9 ) | (enumLiteral_2= KEYWORD_6 ) | (enumLiteral_3= KEYWORD_10 ) | (enumLiteral_4= KEYWORD_2 ) | (enumLiteral_5= KEYWORD_30 ) | (enumLiteral_6= KEYWORD_34 ) | (enumLiteral_7= KEYWORD_39 ) | (enumLiteral_8= KEYWORD_3 ) | (enumLiteral_9= KEYWORD_26 ) | (enumLiteral_10= KEYWORD_25 ) | (enumLiteral_11= KEYWORD_27 ) | (enumLiteral_12= KEYWORD_1 ) | (enumLiteral_13= KEYWORD_32 ) | (enumLiteral_14= KEYWORD_28 ) | (enumLiteral_15= KEYWORD_13 ) | (enumLiteral_16= KEYWORD_33 ) | (enumLiteral_17= KEYWORD_12 ) | (enumLiteral_18= KEYWORD_31 ) | (enumLiteral_19= KEYWORD_29 ) | (enumLiteral_20= KEYWORD_38 ) | (enumLiteral_21= KEYWORD_14 ) | (enumLiteral_22= KEYWORD_11 ) ) )
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1549:1: ( (enumLiteral_0= KEYWORD_7 ) | (enumLiteral_1= KEYWORD_9 ) | (enumLiteral_2= KEYWORD_6 ) | (enumLiteral_3= KEYWORD_10 ) | (enumLiteral_4= KEYWORD_2 ) | (enumLiteral_5= KEYWORD_30 ) | (enumLiteral_6= KEYWORD_34 ) | (enumLiteral_7= KEYWORD_39 ) | (enumLiteral_8= KEYWORD_3 ) | (enumLiteral_9= KEYWORD_26 ) | (enumLiteral_10= KEYWORD_25 ) | (enumLiteral_11= KEYWORD_27 ) | (enumLiteral_12= KEYWORD_1 ) | (enumLiteral_13= KEYWORD_32 ) | (enumLiteral_14= KEYWORD_28 ) | (enumLiteral_15= KEYWORD_13 ) | (enumLiteral_16= KEYWORD_33 ) | (enumLiteral_17= KEYWORD_12 ) | (enumLiteral_18= KEYWORD_31 ) | (enumLiteral_19= KEYWORD_29 ) | (enumLiteral_20= KEYWORD_38 ) | (enumLiteral_21= KEYWORD_14 ) | (enumLiteral_22= KEYWORD_11 ) )
            {
            // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1549:1: ( (enumLiteral_0= KEYWORD_7 ) | (enumLiteral_1= KEYWORD_9 ) | (enumLiteral_2= KEYWORD_6 ) | (enumLiteral_3= KEYWORD_10 ) | (enumLiteral_4= KEYWORD_2 ) | (enumLiteral_5= KEYWORD_30 ) | (enumLiteral_6= KEYWORD_34 ) | (enumLiteral_7= KEYWORD_39 ) | (enumLiteral_8= KEYWORD_3 ) | (enumLiteral_9= KEYWORD_26 ) | (enumLiteral_10= KEYWORD_25 ) | (enumLiteral_11= KEYWORD_27 ) | (enumLiteral_12= KEYWORD_1 ) | (enumLiteral_13= KEYWORD_32 ) | (enumLiteral_14= KEYWORD_28 ) | (enumLiteral_15= KEYWORD_13 ) | (enumLiteral_16= KEYWORD_33 ) | (enumLiteral_17= KEYWORD_12 ) | (enumLiteral_18= KEYWORD_31 ) | (enumLiteral_19= KEYWORD_29 ) | (enumLiteral_20= KEYWORD_38 ) | (enumLiteral_21= KEYWORD_14 ) | (enumLiteral_22= KEYWORD_11 ) )
            int alt27=23;
            switch ( input.LA(1) ) {
            case KEYWORD_7:
                {
                alt27=1;
                }
                break;
            case KEYWORD_9:
                {
                alt27=2;
                }
                break;
            case KEYWORD_6:
                {
                alt27=3;
                }
                break;
            case KEYWORD_10:
                {
                alt27=4;
                }
                break;
            case KEYWORD_2:
                {
                alt27=5;
                }
                break;
            case KEYWORD_30:
                {
                alt27=6;
                }
                break;
            case KEYWORD_34:
                {
                alt27=7;
                }
                break;
            case KEYWORD_39:
                {
                alt27=8;
                }
                break;
            case KEYWORD_3:
                {
                alt27=9;
                }
                break;
            case KEYWORD_26:
                {
                alt27=10;
                }
                break;
            case KEYWORD_25:
                {
                alt27=11;
                }
                break;
            case KEYWORD_27:
                {
                alt27=12;
                }
                break;
            case KEYWORD_1:
                {
                alt27=13;
                }
                break;
            case KEYWORD_32:
                {
                alt27=14;
                }
                break;
            case KEYWORD_28:
                {
                alt27=15;
                }
                break;
            case KEYWORD_13:
                {
                alt27=16;
                }
                break;
            case KEYWORD_33:
                {
                alt27=17;
                }
                break;
            case KEYWORD_12:
                {
                alt27=18;
                }
                break;
            case KEYWORD_31:
                {
                alt27=19;
                }
                break;
            case KEYWORD_29:
                {
                alt27=20;
                }
                break;
            case KEYWORD_38:
                {
                alt27=21;
                }
                break;
            case KEYWORD_14:
                {
                alt27=22;
                }
                break;
            case KEYWORD_11:
                {
                alt27=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1549:2: (enumLiteral_0= KEYWORD_7 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1549:2: (enumLiteral_0= KEYWORD_7 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1549:7: enumLiteral_0= KEYWORD_7
                    {
                    enumLiteral_0=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleOperator4131); 

                            current = grammarAccess.getOperatorAccess().getADDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1555:6: (enumLiteral_1= KEYWORD_9 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1555:6: (enumLiteral_1= KEYWORD_9 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1555:11: enumLiteral_1= KEYWORD_9
                    {
                    enumLiteral_1=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleOperator4153); 

                            current = grammarAccess.getOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1561:6: (enumLiteral_2= KEYWORD_6 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1561:6: (enumLiteral_2= KEYWORD_6 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1561:11: enumLiteral_2= KEYWORD_6
                    {
                    enumLiteral_2=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleOperator4175); 

                            current = grammarAccess.getOperatorAccess().getMULTIPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getOperatorAccess().getMULTIPLYEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1567:6: (enumLiteral_3= KEYWORD_10 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1567:6: (enumLiteral_3= KEYWORD_10 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1567:11: enumLiteral_3= KEYWORD_10
                    {
                    enumLiteral_3=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleOperator4197); 

                            current = grammarAccess.getOperatorAccess().getDIVIDEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getOperatorAccess().getDIVIDEEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1573:6: (enumLiteral_4= KEYWORD_2 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1573:6: (enumLiteral_4= KEYWORD_2 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1573:11: enumLiteral_4= KEYWORD_2
                    {
                    enumLiteral_4=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleOperator4219); 

                            current = grammarAccess.getOperatorAccess().getMODULUSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getOperatorAccess().getMODULUSEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1579:6: (enumLiteral_5= KEYWORD_30 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1579:6: (enumLiteral_5= KEYWORD_30 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1579:11: enumLiteral_5= KEYWORD_30
                    {
                    enumLiteral_5=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleOperator4241); 

                            current = grammarAccess.getOperatorAccess().getLEFT_SHIFTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getOperatorAccess().getLEFT_SHIFTEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1585:6: (enumLiteral_6= KEYWORD_34 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1585:6: (enumLiteral_6= KEYWORD_34 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1585:11: enumLiteral_6= KEYWORD_34
                    {
                    enumLiteral_6=(Token)match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_ruleOperator4263); 

                            current = grammarAccess.getOperatorAccess().getARITHMETIC_RIGHT_SHIFTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getOperatorAccess().getARITHMETIC_RIGHT_SHIFTEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1591:6: (enumLiteral_7= KEYWORD_39 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1591:6: (enumLiteral_7= KEYWORD_39 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1591:11: enumLiteral_7= KEYWORD_39
                    {
                    enumLiteral_7=(Token)match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_ruleOperator4285); 

                            current = grammarAccess.getOperatorAccess().getLOGICAL_RIGHT_SHIFTEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getOperatorAccess().getLOGICAL_RIGHT_SHIFTEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1597:6: (enumLiteral_8= KEYWORD_3 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1597:6: (enumLiteral_8= KEYWORD_3 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1597:11: enumLiteral_8= KEYWORD_3
                    {
                    enumLiteral_8=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleOperator4307); 

                            current = grammarAccess.getOperatorAccess().getBITWISE_ANDEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getOperatorAccess().getBITWISE_ANDEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1603:6: (enumLiteral_9= KEYWORD_26 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1603:6: (enumLiteral_9= KEYWORD_26 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1603:11: enumLiteral_9= KEYWORD_26
                    {
                    enumLiteral_9=(Token)match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_ruleOperator4329); 

                            current = grammarAccess.getOperatorAccess().getBITWISE_OREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getOperatorAccess().getBITWISE_OREnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1609:6: (enumLiteral_10= KEYWORD_25 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1609:6: (enumLiteral_10= KEYWORD_25 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1609:11: enumLiteral_10= KEYWORD_25
                    {
                    enumLiteral_10=(Token)match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_ruleOperator4351); 

                            current = grammarAccess.getOperatorAccess().getBITWISE_XOREnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getOperatorAccess().getBITWISE_XOREnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1615:6: (enumLiteral_11= KEYWORD_27 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1615:6: (enumLiteral_11= KEYWORD_27 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1615:11: enumLiteral_11= KEYWORD_27
                    {
                    enumLiteral_11=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleOperator4373); 

                            current = grammarAccess.getOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_11, grammarAccess.getOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_11()); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1621:6: (enumLiteral_12= KEYWORD_1 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1621:6: (enumLiteral_12= KEYWORD_1 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1621:11: enumLiteral_12= KEYWORD_1
                    {
                    enumLiteral_12=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleOperator4395); 

                            current = grammarAccess.getOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_12, grammarAccess.getOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_12()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1627:6: (enumLiteral_13= KEYWORD_32 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1627:6: (enumLiteral_13= KEYWORD_32 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1627:11: enumLiteral_13= KEYWORD_32
                    {
                    enumLiteral_13=(Token)match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_ruleOperator4417); 

                            current = grammarAccess.getOperatorAccess().getEQUALEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_13, grammarAccess.getOperatorAccess().getEQUALEnumLiteralDeclaration_13()); 
                        

                    }


                    }
                    break;
                case 15 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1633:6: (enumLiteral_14= KEYWORD_28 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1633:6: (enumLiteral_14= KEYWORD_28 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1633:11: enumLiteral_14= KEYWORD_28
                    {
                    enumLiteral_14=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_ruleOperator4439); 

                            current = grammarAccess.getOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_14, grammarAccess.getOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_14()); 
                        

                    }


                    }
                    break;
                case 16 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1639:6: (enumLiteral_15= KEYWORD_13 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1639:6: (enumLiteral_15= KEYWORD_13 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1639:11: enumLiteral_15= KEYWORD_13
                    {
                    enumLiteral_15=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleOperator4461); 

                            current = grammarAccess.getOperatorAccess().getGREATEREnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_15, grammarAccess.getOperatorAccess().getGREATEREnumLiteralDeclaration_15()); 
                        

                    }


                    }
                    break;
                case 17 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1645:6: (enumLiteral_16= KEYWORD_33 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1645:6: (enumLiteral_16= KEYWORD_33 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1645:11: enumLiteral_16= KEYWORD_33
                    {
                    enumLiteral_16=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleOperator4483); 

                            current = grammarAccess.getOperatorAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_16, grammarAccess.getOperatorAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_16()); 
                        

                    }


                    }
                    break;
                case 18 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1651:6: (enumLiteral_17= KEYWORD_12 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1651:6: (enumLiteral_17= KEYWORD_12 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1651:11: enumLiteral_17= KEYWORD_12
                    {
                    enumLiteral_17=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleOperator4505); 

                            current = grammarAccess.getOperatorAccess().getLESSEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_17, grammarAccess.getOperatorAccess().getLESSEnumLiteralDeclaration_17()); 
                        

                    }


                    }
                    break;
                case 19 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1657:6: (enumLiteral_18= KEYWORD_31 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1657:6: (enumLiteral_18= KEYWORD_31 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1657:11: enumLiteral_18= KEYWORD_31
                    {
                    enumLiteral_18=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleOperator4527); 

                            current = grammarAccess.getOperatorAccess().getLESS_OR_EQUALEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_18, grammarAccess.getOperatorAccess().getLESS_OR_EQUALEnumLiteralDeclaration_18()); 
                        

                    }


                    }
                    break;
                case 20 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1663:6: (enumLiteral_19= KEYWORD_29 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1663:6: (enumLiteral_19= KEYWORD_29 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1663:11: enumLiteral_19= KEYWORD_29
                    {
                    enumLiteral_19=(Token)match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_ruleOperator4549); 

                            current = grammarAccess.getOperatorAccess().getLOGICAL_ANDEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_19, grammarAccess.getOperatorAccess().getLOGICAL_ANDEnumLiteralDeclaration_19()); 
                        

                    }


                    }
                    break;
                case 21 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1669:6: (enumLiteral_20= KEYWORD_38 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1669:6: (enumLiteral_20= KEYWORD_38 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1669:11: enumLiteral_20= KEYWORD_38
                    {
                    enumLiteral_20=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleOperator4571); 

                            current = grammarAccess.getOperatorAccess().getLOGICAL_OREnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_20, grammarAccess.getOperatorAccess().getLOGICAL_OREnumLiteralDeclaration_20()); 
                        

                    }


                    }
                    break;
                case 22 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1675:6: (enumLiteral_21= KEYWORD_14 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1675:6: (enumLiteral_21= KEYWORD_14 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1675:11: enumLiteral_21= KEYWORD_14
                    {
                    enumLiteral_21=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleOperator4593); 

                            current = grammarAccess.getOperatorAccess().getCONDITIONAL_TRUEEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_21, grammarAccess.getOperatorAccess().getCONDITIONAL_TRUEEnumLiteralDeclaration_21()); 
                        

                    }


                    }
                    break;
                case 23 :
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1681:6: (enumLiteral_22= KEYWORD_11 )
                    {
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1681:6: (enumLiteral_22= KEYWORD_11 )
                    // ../devcpu.DASM/src-gen/devcpu/parser/antlr/internal/InternalDASMParser.g:1681:11: enumLiteral_22= KEYWORD_11
                    {
                    enumLiteral_22=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleOperator4615); 

                            current = grammarAccess.getOperatorAccess().getCONDITIONAL_FALSEEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_22, grammarAccess.getOperatorAccess().getCONDITIONAL_FALSEEnumLiteralDeclaration_22()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\31\uffff";
    static final String DFA14_eofS =
        "\1\30\30\uffff";
    static final String DFA14_minS =
        "\1\15\30\uffff";
    static final String DFA14_maxS =
        "\1\143\30\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\27\1\1\2";
    static final String DFA14_specialS =
        "\31\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\30\1\10\34\uffff\1\30\11\uffff\1\17\1\24\1\6\1\23\1\16\1"+
            "\21\1\7\3\30\1\25\1\15\1\5\1\11\2\30\1\3\1\1\1\30\1\2\1\4\1"+
            "\27\1\22\1\20\1\26\12\30\1\13\1\12\1\14\5\30\2\uffff\1\30",
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
            return "532:1: ( () ( (lv_op_2_0= ruleOperator ) ) ( (lv_right_3_0= ruleLiteralExpression ) ) )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLineDefinition_in_ruleModel124 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleModel144 = new BitSet(new long[]{0x003FEFFFFFFF1FF0L,0x0000000900000800L});
    public static final BitSet FOLLOW_ruleModel_in_ruleModel164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLineDefinition_in_entryRuleLineDefinition201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLineDefinition211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLabel_in_ruleLineDefinition257 = new BitSet(new long[]{0x003FEFFFFFFF1FF2L,0x0000000100000800L});
    public static final BitSet FOLLOW_ruleLineContent_in_ruleLineDefinition279 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleLineDefinition297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLineContent_in_entryRuleLineContent338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLineContent348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleLineContent395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirective_in_ruleLineContent422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataLine_in_ruleLineContent449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirective_in_entryRuleDirective483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirective493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDirective_in_ruleDirective540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOriginDirective_in_ruleDirective567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOriginDirective_in_entryRuleOriginDirective601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOriginDirective611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_86_in_ruleOriginDirective650 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_KEYWORD_84_in_ruleOriginDirective668 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_KEYWORD_82_in_ruleOriginDirective686 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_KEYWORD_81_in_ruleOriginDirective704 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleOriginDirective725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDirective_in_entryRuleIncludeDirective760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDirective770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_88_in_ruleIncludeDirective809 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_KEYWORD_87_in_ruleIncludeDirective827 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_KEYWORD_85_in_ruleIncludeDirective845 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_KEYWORD_83_in_ruleIncludeDirective863 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIncludeDirective880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataLine_in_entryRuleDataLine920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataLine930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleDataLine969 = new BitSet(new long[]{0x0000000000000000L,0x00000002E0000100L});
    public static final BitSet FOLLOW_KEYWORD_78_in_ruleDataLine987 = new BitSet(new long[]{0x0000000000000000L,0x00000002E0000100L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleDataLine1002 = new BitSet(new long[]{0x0000000000000000L,0x00000002E0000100L});
    public static final BitSet FOLLOW_ruleDataElement_in_ruleDataLine1024 = new BitSet(new long[]{0x0000000000000002L,0x00000002E0000100L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleDataLine1038 = new BitSet(new long[]{0x0000000000000002L,0x00000002E0000100L});
    public static final BitSet FOLLOW_ruleDataElement_in_entryRuleDataElement1077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataElement1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDataElement1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleDataElement1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_entryRuleLiteralExpression1205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralExpression1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_ruleLiteralExpression1262 = new BitSet(new long[]{0x1FC0000000008002L,0x000000000E007ECFL});
    public static final BitSet FOLLOW_ruleOperator_in_ruleLiteralExpression1292 = new BitSet(new long[]{0xE000100000006000L,0x00000000F07F8010L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_ruleLiteralExpression1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_entryRuleTerminalExpression1350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpression1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleTerminalExpression1399 = new BitSet(new long[]{0xE000100000006000L,0x00000000F07F8010L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_ruleTerminalExpression1420 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleTerminalExpression1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonGroupOperand_in_ruleTerminalExpression1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonGroupOperand_in_entryRuleNonGroupOperand1494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonGroupOperand1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegister_in_ruleNonGroupOperand1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleNonGroupOperand1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNonGroupOperand1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStackValue_in_ruleNonGroupOperand1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStackValue_in_entryRuleStackValue1665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStackValue1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_68_in_ruleStackValue1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_80_in_ruleStackValue1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePickValue_in_ruleStackValue1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePickValue_in_entryRulePickValue1792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePickValue1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_79_in_rulePickValue1840 = new BitSet(new long[]{0xE000100000006000L,0x00000000F07F8010L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_rulePickValue1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLabel_in_entryRuleLabel1895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLabel1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleLabel1943 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLabel1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction1999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicInstruction_in_ruleInstruction2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialInstruction_in_ruleInstruction2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicInstruction_in_entryRuleBasicInstruction2117 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicInstruction2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicOpcode_in_ruleBasicInstruction2173 = new BitSet(new long[]{0xE000100000006000L,0x00000000F0FF8010L});
    public static final BitSet FOLLOW_ruleValue_in_ruleBasicInstruction2194 = new BitSet(new long[]{0xE000100000006000L,0x00000000F0FF8110L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleBasicInstruction2208 = new BitSet(new long[]{0xE000100000006000L,0x00000000F0FF8010L});
    public static final BitSet FOLLOW_ruleValue_in_ruleBasicInstruction2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialInstruction_in_entryRuleSpecialInstruction2265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecialInstruction2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialOpcode_in_ruleSpecialInstruction2321 = new BitSet(new long[]{0xE000100000006000L,0x00000000F0FF8010L});
    public static final BitSet FOLLOW_ruleValue_in_ruleSpecialInstruction2342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue2377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_ruleValue2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddressExpression_in_ruleValue2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleLiteral2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegister_in_entryRuleRegister2584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegister2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStandardRegister_in_ruleRegister2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialRegister_in_ruleRegister2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddressExpression_in_entryRuleAddressExpression2704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddressExpression2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleAddressExpression2752 = new BitSet(new long[]{0xE000100000006000L,0x00000000F07F8010L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_ruleAddressExpression2773 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_KEYWORD_24_in_ruleAddressExpression2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber2820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXNUMBER_in_ruleNumber2871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECNUMBER_in_ruleNumber2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINNUMBER_in_ruleNumber2923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_71_in_ruleBasicOpcode2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleBasicOpcode3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_76_in_ruleBasicOpcode3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_67_in_ruleBasicOpcode3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_65_in_ruleBasicOpcode3073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_46_in_ruleBasicOpcode3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_ruleBasicOpcode3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_66_in_ruleBasicOpcode3139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_64_in_ruleBasicOpcode3161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_42_in_ruleBasicOpcode3183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleBasicOpcode3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_77_in_ruleBasicOpcode3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_73_in_ruleBasicOpcode3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_ruleBasicOpcode3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_72_in_ruleBasicOpcode3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_55_in_ruleBasicOpcode3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_56_in_ruleBasicOpcode3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_57_in_ruleBasicOpcode3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_60_in_ruleBasicOpcode3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_58_in_ruleBasicOpcode3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_54_in_ruleBasicOpcode3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_59_in_ruleBasicOpcode3447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_61_in_ruleBasicOpcode3469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_41_in_ruleBasicOpcode3491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_70_in_ruleBasicOpcode3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_75_in_ruleBasicOpcode3535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_74_in_ruleBasicOpcode3557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_63_in_ruleSpecialOpcode3607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_62_in_ruleSpecialOpcode3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_51_in_ruleSpecialOpcode3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_53_in_ruleSpecialOpcode3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_69_in_ruleSpecialOpcode3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_52_in_ruleSpecialOpcode3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_ruleSpecialOpcode3739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_50_in_ruleSpecialOpcode3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_48_in_ruleSpecialOpcode3783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_15_in_ruleStandardRegister3833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_16_in_ruleStandardRegister3855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_17_in_ruleStandardRegister3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleStandardRegister3899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleStandardRegister3921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleStandardRegister3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_18_in_ruleStandardRegister3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_19_in_ruleStandardRegister3987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleSpecialRegister4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleSpecialRegister4059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleSpecialRegister4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleOperator4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleOperator4153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleOperator4175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleOperator4197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleOperator4219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleOperator4241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_34_in_ruleOperator4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_39_in_ruleOperator4285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleOperator4307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_26_in_ruleOperator4329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_25_in_ruleOperator4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleOperator4373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleOperator4395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_32_in_ruleOperator4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_28_in_ruleOperator4439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleOperator4461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleOperator4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleOperator4505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleOperator4527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_29_in_ruleOperator4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleOperator4571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleOperator4593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleOperator4615 = new BitSet(new long[]{0x0000000000000002L});

}