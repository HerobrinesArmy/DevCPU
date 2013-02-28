package devcpu.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import devcpu.services.DASMGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDASMParser extends AbstractInternalContentAssistParser {
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
    public String getGrammarFileName() { return "../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g"; }


     
     	private DASMGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("KEYWORD_1", "'!'");
    		tokenNameToValue.put("KEYWORD_2", "'%'");
    		tokenNameToValue.put("KEYWORD_3", "'&'");
    		tokenNameToValue.put("KEYWORD_4", "'('");
    		tokenNameToValue.put("KEYWORD_5", "')'");
    		tokenNameToValue.put("KEYWORD_6", "'*'");
    		tokenNameToValue.put("KEYWORD_7", "'+'");
    		tokenNameToValue.put("KEYWORD_8", "','");
    		tokenNameToValue.put("KEYWORD_9", "'-'");
    		tokenNameToValue.put("KEYWORD_10", "'/'");
    		tokenNameToValue.put("KEYWORD_11", "':'");
    		tokenNameToValue.put("KEYWORD_12", "'<'");
    		tokenNameToValue.put("KEYWORD_13", "'>'");
    		tokenNameToValue.put("KEYWORD_14", "'?'");
    		tokenNameToValue.put("KEYWORD_15", "'A'");
    		tokenNameToValue.put("KEYWORD_16", "'B'");
    		tokenNameToValue.put("KEYWORD_17", "'C'");
    		tokenNameToValue.put("KEYWORD_18", "'I'");
    		tokenNameToValue.put("KEYWORD_19", "'J'");
    		tokenNameToValue.put("KEYWORD_20", "'X'");
    		tokenNameToValue.put("KEYWORD_21", "'Y'");
    		tokenNameToValue.put("KEYWORD_22", "'Z'");
    		tokenNameToValue.put("KEYWORD_23", "'['");
    		tokenNameToValue.put("KEYWORD_24", "']'");
    		tokenNameToValue.put("KEYWORD_25", "'^'");
    		tokenNameToValue.put("KEYWORD_26", "'|'");
    		tokenNameToValue.put("KEYWORD_27", "'~'");
    		tokenNameToValue.put("KEYWORD_28", "'!='");
    		tokenNameToValue.put("KEYWORD_29", "'&&'");
    		tokenNameToValue.put("KEYWORD_30", "'<<'");
    		tokenNameToValue.put("KEYWORD_31", "'<='");
    		tokenNameToValue.put("KEYWORD_32", "'=='");
    		tokenNameToValue.put("KEYWORD_33", "'>='");
    		tokenNameToValue.put("KEYWORD_34", "'>>'");
    		tokenNameToValue.put("KEYWORD_35", "'EX'");
    		tokenNameToValue.put("KEYWORD_36", "'PC'");
    		tokenNameToValue.put("KEYWORD_37", "'SP'");
    		tokenNameToValue.put("KEYWORD_38", "'||'");
    		tokenNameToValue.put("KEYWORD_39", "'>>>'");
    		tokenNameToValue.put("KEYWORD_40", "'ADD'");
    		tokenNameToValue.put("KEYWORD_41", "'ADX'");
    		tokenNameToValue.put("KEYWORD_42", "'AND'");
    		tokenNameToValue.put("KEYWORD_43", "'ASR'");
    		tokenNameToValue.put("KEYWORD_44", "'BOR'");
    		tokenNameToValue.put("KEYWORD_45", "'DAT'");
    		tokenNameToValue.put("KEYWORD_46", "'DIV'");
    		tokenNameToValue.put("KEYWORD_47", "'DVI'");
    		tokenNameToValue.put("KEYWORD_48", "'HWI'");
    		tokenNameToValue.put("KEYWORD_49", "'HWN'");
    		tokenNameToValue.put("KEYWORD_50", "'HWQ'");
    		tokenNameToValue.put("KEYWORD_51", "'IAG'");
    		tokenNameToValue.put("KEYWORD_52", "'IAQ'");
    		tokenNameToValue.put("KEYWORD_53", "'IAS'");
    		tokenNameToValue.put("KEYWORD_54", "'IFA'");
    		tokenNameToValue.put("KEYWORD_55", "'IFB'");
    		tokenNameToValue.put("KEYWORD_56", "'IFC'");
    		tokenNameToValue.put("KEYWORD_57", "'IFE'");
    		tokenNameToValue.put("KEYWORD_58", "'IFG'");
    		tokenNameToValue.put("KEYWORD_59", "'IFL'");
    		tokenNameToValue.put("KEYWORD_60", "'IFN'");
    		tokenNameToValue.put("KEYWORD_61", "'IFU'");
    		tokenNameToValue.put("KEYWORD_62", "'INT'");
    		tokenNameToValue.put("KEYWORD_63", "'JSR'");
    		tokenNameToValue.put("KEYWORD_64", "'MDI'");
    		tokenNameToValue.put("KEYWORD_65", "'MLI'");
    		tokenNameToValue.put("KEYWORD_66", "'MOD'");
    		tokenNameToValue.put("KEYWORD_67", "'MUL'");
    		tokenNameToValue.put("KEYWORD_68", "'POP'");
    		tokenNameToValue.put("KEYWORD_69", "'RFI'");
    		tokenNameToValue.put("KEYWORD_70", "'SBX'");
    		tokenNameToValue.put("KEYWORD_71", "'SET'");
    		tokenNameToValue.put("KEYWORD_72", "'SHL'");
    		tokenNameToValue.put("KEYWORD_73", "'SHR'");
    		tokenNameToValue.put("KEYWORD_74", "'STD'");
    		tokenNameToValue.put("KEYWORD_75", "'STI'");
    		tokenNameToValue.put("KEYWORD_76", "'SUB'");
    		tokenNameToValue.put("KEYWORD_77", "'XOR'");
    		tokenNameToValue.put("KEYWORD_78", "'.dat'");
    		tokenNameToValue.put("KEYWORD_79", "'PICK'");
    		tokenNameToValue.put("KEYWORD_80", "'PUSH'");
    		tokenNameToValue.put("KEYWORD_81", "'#align'");
    		tokenNameToValue.put("KEYWORD_82", "'.align'");
    		tokenNameToValue.put("KEYWORD_83", "'#import'");
    		tokenNameToValue.put("KEYWORD_84", "'#origin'");
    		tokenNameToValue.put("KEYWORD_85", "'.import'");
    		tokenNameToValue.put("KEYWORD_86", "'.origin'");
    		tokenNameToValue.put("KEYWORD_87", "'#include'");
    		tokenNameToValue.put("KEYWORD_88", "'.include'");
     	}
     	
        public void setGrammarAccess(DASMGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRuleModel"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:151:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:152:1: ( ruleModel EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:153:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel61); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:160:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:164:5: ( ( ( rule__Model__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:165:1: ( ( rule__Model__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:165:1: ( ( rule__Model__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:166:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:167:1: ( rule__Model__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:167:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel91);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleLineDefinition"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:179:1: entryRuleLineDefinition : ruleLineDefinition EOF ;
    public final void entryRuleLineDefinition() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:180:1: ( ruleLineDefinition EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:181:1: ruleLineDefinition EOF
            {
             before(grammarAccess.getLineDefinitionRule()); 
            pushFollow(FOLLOW_ruleLineDefinition_in_entryRuleLineDefinition118);
            ruleLineDefinition();

            state._fsp--;

             after(grammarAccess.getLineDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLineDefinition125); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLineDefinition"


    // $ANTLR start "ruleLineDefinition"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:188:1: ruleLineDefinition : ( ( rule__LineDefinition__Group__0 ) ) ;
    public final void ruleLineDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:192:5: ( ( ( rule__LineDefinition__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:193:1: ( ( rule__LineDefinition__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:193:1: ( ( rule__LineDefinition__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:194:1: ( rule__LineDefinition__Group__0 )
            {
             before(grammarAccess.getLineDefinitionAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:195:1: ( rule__LineDefinition__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:195:2: rule__LineDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__LineDefinition__Group__0_in_ruleLineDefinition155);
            rule__LineDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLineDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLineDefinition"


    // $ANTLR start "entryRuleLineContent"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:207:1: entryRuleLineContent : ruleLineContent EOF ;
    public final void entryRuleLineContent() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:208:1: ( ruleLineContent EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:209:1: ruleLineContent EOF
            {
             before(grammarAccess.getLineContentRule()); 
            pushFollow(FOLLOW_ruleLineContent_in_entryRuleLineContent182);
            ruleLineContent();

            state._fsp--;

             after(grammarAccess.getLineContentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLineContent189); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLineContent"


    // $ANTLR start "ruleLineContent"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:216:1: ruleLineContent : ( ( rule__LineContent__Alternatives ) ) ;
    public final void ruleLineContent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:220:5: ( ( ( rule__LineContent__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:221:1: ( ( rule__LineContent__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:221:1: ( ( rule__LineContent__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:222:1: ( rule__LineContent__Alternatives )
            {
             before(grammarAccess.getLineContentAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:223:1: ( rule__LineContent__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:223:2: rule__LineContent__Alternatives
            {
            pushFollow(FOLLOW_rule__LineContent__Alternatives_in_ruleLineContent219);
            rule__LineContent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLineContentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLineContent"


    // $ANTLR start "entryRuleDirective"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:235:1: entryRuleDirective : ruleDirective EOF ;
    public final void entryRuleDirective() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:236:1: ( ruleDirective EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:237:1: ruleDirective EOF
            {
             before(grammarAccess.getDirectiveRule()); 
            pushFollow(FOLLOW_ruleDirective_in_entryRuleDirective246);
            ruleDirective();

            state._fsp--;

             after(grammarAccess.getDirectiveRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirective253); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDirective"


    // $ANTLR start "ruleDirective"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:244:1: ruleDirective : ( ( rule__Directive__Alternatives ) ) ;
    public final void ruleDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:248:5: ( ( ( rule__Directive__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:249:1: ( ( rule__Directive__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:249:1: ( ( rule__Directive__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:250:1: ( rule__Directive__Alternatives )
            {
             before(grammarAccess.getDirectiveAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:251:1: ( rule__Directive__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:251:2: rule__Directive__Alternatives
            {
            pushFollow(FOLLOW_rule__Directive__Alternatives_in_ruleDirective283);
            rule__Directive__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDirectiveAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDirective"


    // $ANTLR start "entryRuleOriginDirective"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:263:1: entryRuleOriginDirective : ruleOriginDirective EOF ;
    public final void entryRuleOriginDirective() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:264:1: ( ruleOriginDirective EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:265:1: ruleOriginDirective EOF
            {
             before(grammarAccess.getOriginDirectiveRule()); 
            pushFollow(FOLLOW_ruleOriginDirective_in_entryRuleOriginDirective310);
            ruleOriginDirective();

            state._fsp--;

             after(grammarAccess.getOriginDirectiveRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOriginDirective317); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOriginDirective"


    // $ANTLR start "ruleOriginDirective"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:272:1: ruleOriginDirective : ( ( rule__OriginDirective__Group__0 ) ) ;
    public final void ruleOriginDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:276:5: ( ( ( rule__OriginDirective__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:277:1: ( ( rule__OriginDirective__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:277:1: ( ( rule__OriginDirective__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:278:1: ( rule__OriginDirective__Group__0 )
            {
             before(grammarAccess.getOriginDirectiveAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:279:1: ( rule__OriginDirective__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:279:2: rule__OriginDirective__Group__0
            {
            pushFollow(FOLLOW_rule__OriginDirective__Group__0_in_ruleOriginDirective347);
            rule__OriginDirective__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOriginDirectiveAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOriginDirective"


    // $ANTLR start "entryRuleIncludeDirective"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:291:1: entryRuleIncludeDirective : ruleIncludeDirective EOF ;
    public final void entryRuleIncludeDirective() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:292:1: ( ruleIncludeDirective EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:293:1: ruleIncludeDirective EOF
            {
             before(grammarAccess.getIncludeDirectiveRule()); 
            pushFollow(FOLLOW_ruleIncludeDirective_in_entryRuleIncludeDirective374);
            ruleIncludeDirective();

            state._fsp--;

             after(grammarAccess.getIncludeDirectiveRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDirective381); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIncludeDirective"


    // $ANTLR start "ruleIncludeDirective"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:300:1: ruleIncludeDirective : ( ( rule__IncludeDirective__Group__0 ) ) ;
    public final void ruleIncludeDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:304:5: ( ( ( rule__IncludeDirective__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:305:1: ( ( rule__IncludeDirective__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:305:1: ( ( rule__IncludeDirective__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:306:1: ( rule__IncludeDirective__Group__0 )
            {
             before(grammarAccess.getIncludeDirectiveAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:307:1: ( rule__IncludeDirective__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:307:2: rule__IncludeDirective__Group__0
            {
            pushFollow(FOLLOW_rule__IncludeDirective__Group__0_in_ruleIncludeDirective411);
            rule__IncludeDirective__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIncludeDirectiveAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIncludeDirective"


    // $ANTLR start "entryRuleDataLine"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:319:1: entryRuleDataLine : ruleDataLine EOF ;
    public final void entryRuleDataLine() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:320:1: ( ruleDataLine EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:321:1: ruleDataLine EOF
            {
             before(grammarAccess.getDataLineRule()); 
            pushFollow(FOLLOW_ruleDataLine_in_entryRuleDataLine438);
            ruleDataLine();

            state._fsp--;

             after(grammarAccess.getDataLineRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataLine445); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataLine"


    // $ANTLR start "ruleDataLine"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:328:1: ruleDataLine : ( ( rule__DataLine__Group__0 ) ) ;
    public final void ruleDataLine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:332:5: ( ( ( rule__DataLine__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:333:1: ( ( rule__DataLine__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:333:1: ( ( rule__DataLine__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:334:1: ( rule__DataLine__Group__0 )
            {
             before(grammarAccess.getDataLineAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:335:1: ( rule__DataLine__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:335:2: rule__DataLine__Group__0
            {
            pushFollow(FOLLOW_rule__DataLine__Group__0_in_ruleDataLine475);
            rule__DataLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataLineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataLine"


    // $ANTLR start "entryRuleDataElement"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:347:1: entryRuleDataElement : ruleDataElement EOF ;
    public final void entryRuleDataElement() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:348:1: ( ruleDataElement EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:349:1: ruleDataElement EOF
            {
             before(grammarAccess.getDataElementRule()); 
            pushFollow(FOLLOW_ruleDataElement_in_entryRuleDataElement502);
            ruleDataElement();

            state._fsp--;

             after(grammarAccess.getDataElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataElement509); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataElement"


    // $ANTLR start "ruleDataElement"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:356:1: ruleDataElement : ( ( rule__DataElement__Alternatives ) ) ;
    public final void ruleDataElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:360:5: ( ( ( rule__DataElement__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:361:1: ( ( rule__DataElement__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:361:1: ( ( rule__DataElement__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:362:1: ( rule__DataElement__Alternatives )
            {
             before(grammarAccess.getDataElementAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:363:1: ( rule__DataElement__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:363:2: rule__DataElement__Alternatives
            {
            pushFollow(FOLLOW_rule__DataElement__Alternatives_in_ruleDataElement539);
            rule__DataElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataElement"


    // $ANTLR start "entryRuleLiteralExpression"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:375:1: entryRuleLiteralExpression : ruleLiteralExpression EOF ;
    public final void entryRuleLiteralExpression() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:376:1: ( ruleLiteralExpression EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:377:1: ruleLiteralExpression EOF
            {
             before(grammarAccess.getLiteralExpressionRule()); 
            pushFollow(FOLLOW_ruleLiteralExpression_in_entryRuleLiteralExpression566);
            ruleLiteralExpression();

            state._fsp--;

             after(grammarAccess.getLiteralExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralExpression573); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:384:1: ruleLiteralExpression : ( ( rule__LiteralExpression__Group__0 ) ) ;
    public final void ruleLiteralExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:388:5: ( ( ( rule__LiteralExpression__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:389:1: ( ( rule__LiteralExpression__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:389:1: ( ( rule__LiteralExpression__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:390:1: ( rule__LiteralExpression__Group__0 )
            {
             before(grammarAccess.getLiteralExpressionAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:391:1: ( rule__LiteralExpression__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:391:2: rule__LiteralExpression__Group__0
            {
            pushFollow(FOLLOW_rule__LiteralExpression__Group__0_in_ruleLiteralExpression603);
            rule__LiteralExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleTerminalExpression"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:403:1: entryRuleTerminalExpression : ruleTerminalExpression EOF ;
    public final void entryRuleTerminalExpression() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:404:1: ( ruleTerminalExpression EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:405:1: ruleTerminalExpression EOF
            {
             before(grammarAccess.getTerminalExpressionRule()); 
            pushFollow(FOLLOW_ruleTerminalExpression_in_entryRuleTerminalExpression630);
            ruleTerminalExpression();

            state._fsp--;

             after(grammarAccess.getTerminalExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpression637); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:412:1: ruleTerminalExpression : ( ( rule__TerminalExpression__Alternatives ) ) ;
    public final void ruleTerminalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:416:5: ( ( ( rule__TerminalExpression__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:417:1: ( ( rule__TerminalExpression__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:417:1: ( ( rule__TerminalExpression__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:418:1: ( rule__TerminalExpression__Alternatives )
            {
             before(grammarAccess.getTerminalExpressionAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:419:1: ( rule__TerminalExpression__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:419:2: rule__TerminalExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__TerminalExpression__Alternatives_in_ruleTerminalExpression667);
            rule__TerminalExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTerminalExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleNonGroupOperand"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:431:1: entryRuleNonGroupOperand : ruleNonGroupOperand EOF ;
    public final void entryRuleNonGroupOperand() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:432:1: ( ruleNonGroupOperand EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:433:1: ruleNonGroupOperand EOF
            {
             before(grammarAccess.getNonGroupOperandRule()); 
            pushFollow(FOLLOW_ruleNonGroupOperand_in_entryRuleNonGroupOperand694);
            ruleNonGroupOperand();

            state._fsp--;

             after(grammarAccess.getNonGroupOperandRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonGroupOperand701); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNonGroupOperand"


    // $ANTLR start "ruleNonGroupOperand"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:440:1: ruleNonGroupOperand : ( ( rule__NonGroupOperand__Alternatives ) ) ;
    public final void ruleNonGroupOperand() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:444:5: ( ( ( rule__NonGroupOperand__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:445:1: ( ( rule__NonGroupOperand__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:445:1: ( ( rule__NonGroupOperand__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:446:1: ( rule__NonGroupOperand__Alternatives )
            {
             before(grammarAccess.getNonGroupOperandAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:447:1: ( rule__NonGroupOperand__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:447:2: rule__NonGroupOperand__Alternatives
            {
            pushFollow(FOLLOW_rule__NonGroupOperand__Alternatives_in_ruleNonGroupOperand731);
            rule__NonGroupOperand__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNonGroupOperandAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNonGroupOperand"


    // $ANTLR start "entryRuleStackValue"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:459:1: entryRuleStackValue : ruleStackValue EOF ;
    public final void entryRuleStackValue() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:460:1: ( ruleStackValue EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:461:1: ruleStackValue EOF
            {
             before(grammarAccess.getStackValueRule()); 
            pushFollow(FOLLOW_ruleStackValue_in_entryRuleStackValue758);
            ruleStackValue();

            state._fsp--;

             after(grammarAccess.getStackValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStackValue765); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStackValue"


    // $ANTLR start "ruleStackValue"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:468:1: ruleStackValue : ( ( rule__StackValue__Alternatives ) ) ;
    public final void ruleStackValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:472:5: ( ( ( rule__StackValue__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:473:1: ( ( rule__StackValue__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:473:1: ( ( rule__StackValue__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:474:1: ( rule__StackValue__Alternatives )
            {
             before(grammarAccess.getStackValueAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:475:1: ( rule__StackValue__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:475:2: rule__StackValue__Alternatives
            {
            pushFollow(FOLLOW_rule__StackValue__Alternatives_in_ruleStackValue795);
            rule__StackValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStackValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStackValue"


    // $ANTLR start "entryRulePickValue"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:487:1: entryRulePickValue : rulePickValue EOF ;
    public final void entryRulePickValue() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:488:1: ( rulePickValue EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:489:1: rulePickValue EOF
            {
             before(grammarAccess.getPickValueRule()); 
            pushFollow(FOLLOW_rulePickValue_in_entryRulePickValue822);
            rulePickValue();

            state._fsp--;

             after(grammarAccess.getPickValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePickValue829); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePickValue"


    // $ANTLR start "rulePickValue"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:496:1: rulePickValue : ( ( rule__PickValue__Group__0 ) ) ;
    public final void rulePickValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:500:5: ( ( ( rule__PickValue__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:501:1: ( ( rule__PickValue__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:501:1: ( ( rule__PickValue__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:502:1: ( rule__PickValue__Group__0 )
            {
             before(grammarAccess.getPickValueAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:503:1: ( rule__PickValue__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:503:2: rule__PickValue__Group__0
            {
            pushFollow(FOLLOW_rule__PickValue__Group__0_in_rulePickValue859);
            rule__PickValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPickValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePickValue"


    // $ANTLR start "entryRuleLabel"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:515:1: entryRuleLabel : ruleLabel EOF ;
    public final void entryRuleLabel() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:516:1: ( ruleLabel EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:517:1: ruleLabel EOF
            {
             before(grammarAccess.getLabelRule()); 
            pushFollow(FOLLOW_ruleLabel_in_entryRuleLabel886);
            ruleLabel();

            state._fsp--;

             after(grammarAccess.getLabelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLabel893); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLabel"


    // $ANTLR start "ruleLabel"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:524:1: ruleLabel : ( ( rule__Label__Group__0 ) ) ;
    public final void ruleLabel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:528:5: ( ( ( rule__Label__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:529:1: ( ( rule__Label__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:529:1: ( ( rule__Label__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:530:1: ( rule__Label__Group__0 )
            {
             before(grammarAccess.getLabelAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:531:1: ( rule__Label__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:531:2: rule__Label__Group__0
            {
            pushFollow(FOLLOW_rule__Label__Group__0_in_ruleLabel923);
            rule__Label__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLabelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLabel"


    // $ANTLR start "entryRuleInstruction"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:543:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:544:1: ( ruleInstruction EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:545:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction950);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction957); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:552:1: ruleInstruction : ( ( rule__Instruction__Alternatives ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:556:5: ( ( ( rule__Instruction__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:557:1: ( ( rule__Instruction__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:557:1: ( ( rule__Instruction__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:558:1: ( rule__Instruction__Alternatives )
            {
             before(grammarAccess.getInstructionAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:559:1: ( rule__Instruction__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:559:2: rule__Instruction__Alternatives
            {
            pushFollow(FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction987);
            rule__Instruction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleBasicInstruction"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:571:1: entryRuleBasicInstruction : ruleBasicInstruction EOF ;
    public final void entryRuleBasicInstruction() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:572:1: ( ruleBasicInstruction EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:573:1: ruleBasicInstruction EOF
            {
             before(grammarAccess.getBasicInstructionRule()); 
            pushFollow(FOLLOW_ruleBasicInstruction_in_entryRuleBasicInstruction1014);
            ruleBasicInstruction();

            state._fsp--;

             after(grammarAccess.getBasicInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicInstruction1021); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBasicInstruction"


    // $ANTLR start "ruleBasicInstruction"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:580:1: ruleBasicInstruction : ( ( rule__BasicInstruction__Group__0 ) ) ;
    public final void ruleBasicInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:584:5: ( ( ( rule__BasicInstruction__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:585:1: ( ( rule__BasicInstruction__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:585:1: ( ( rule__BasicInstruction__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:586:1: ( rule__BasicInstruction__Group__0 )
            {
             before(grammarAccess.getBasicInstructionAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:587:1: ( rule__BasicInstruction__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:587:2: rule__BasicInstruction__Group__0
            {
            pushFollow(FOLLOW_rule__BasicInstruction__Group__0_in_ruleBasicInstruction1051);
            rule__BasicInstruction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBasicInstructionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBasicInstruction"


    // $ANTLR start "entryRuleSpecialInstruction"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:599:1: entryRuleSpecialInstruction : ruleSpecialInstruction EOF ;
    public final void entryRuleSpecialInstruction() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:600:1: ( ruleSpecialInstruction EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:601:1: ruleSpecialInstruction EOF
            {
             before(grammarAccess.getSpecialInstructionRule()); 
            pushFollow(FOLLOW_ruleSpecialInstruction_in_entryRuleSpecialInstruction1078);
            ruleSpecialInstruction();

            state._fsp--;

             after(grammarAccess.getSpecialInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecialInstruction1085); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSpecialInstruction"


    // $ANTLR start "ruleSpecialInstruction"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:608:1: ruleSpecialInstruction : ( ( rule__SpecialInstruction__Group__0 ) ) ;
    public final void ruleSpecialInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:612:5: ( ( ( rule__SpecialInstruction__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:613:1: ( ( rule__SpecialInstruction__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:613:1: ( ( rule__SpecialInstruction__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:614:1: ( rule__SpecialInstruction__Group__0 )
            {
             before(grammarAccess.getSpecialInstructionAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:615:1: ( rule__SpecialInstruction__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:615:2: rule__SpecialInstruction__Group__0
            {
            pushFollow(FOLLOW_rule__SpecialInstruction__Group__0_in_ruleSpecialInstruction1115);
            rule__SpecialInstruction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSpecialInstructionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpecialInstruction"


    // $ANTLR start "entryRuleValue"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:627:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:628:1: ( ruleValue EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:629:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1142);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1149); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:636:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:640:5: ( ( ( rule__Value__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:641:1: ( ( rule__Value__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:641:1: ( ( rule__Value__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:642:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:643:1: ( rule__Value__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:643:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue1179);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleLiteral"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:655:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:656:1: ( ruleLiteral EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:657:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1206);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1213); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:664:1: ruleLiteral : ( ( rule__Literal__NumberAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:668:5: ( ( ( rule__Literal__NumberAssignment ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:669:1: ( ( rule__Literal__NumberAssignment ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:669:1: ( ( rule__Literal__NumberAssignment ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:670:1: ( rule__Literal__NumberAssignment )
            {
             before(grammarAccess.getLiteralAccess().getNumberAssignment()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:671:1: ( rule__Literal__NumberAssignment )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:671:2: rule__Literal__NumberAssignment
            {
            pushFollow(FOLLOW_rule__Literal__NumberAssignment_in_ruleLiteral1243);
            rule__Literal__NumberAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getNumberAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleRegister"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:683:1: entryRuleRegister : ruleRegister EOF ;
    public final void entryRuleRegister() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:684:1: ( ruleRegister EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:685:1: ruleRegister EOF
            {
             before(grammarAccess.getRegisterRule()); 
            pushFollow(FOLLOW_ruleRegister_in_entryRuleRegister1270);
            ruleRegister();

            state._fsp--;

             after(grammarAccess.getRegisterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegister1277); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegister"


    // $ANTLR start "ruleRegister"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:692:1: ruleRegister : ( ( rule__Register__Alternatives ) ) ;
    public final void ruleRegister() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:696:5: ( ( ( rule__Register__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:697:1: ( ( rule__Register__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:697:1: ( ( rule__Register__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:698:1: ( rule__Register__Alternatives )
            {
             before(grammarAccess.getRegisterAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:699:1: ( rule__Register__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:699:2: rule__Register__Alternatives
            {
            pushFollow(FOLLOW_rule__Register__Alternatives_in_ruleRegister1307);
            rule__Register__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRegisterAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegister"


    // $ANTLR start "entryRuleAddressExpression"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:713:1: entryRuleAddressExpression : ruleAddressExpression EOF ;
    public final void entryRuleAddressExpression() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:714:1: ( ruleAddressExpression EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:715:1: ruleAddressExpression EOF
            {
             before(grammarAccess.getAddressExpressionRule()); 
            pushFollow(FOLLOW_ruleAddressExpression_in_entryRuleAddressExpression1336);
            ruleAddressExpression();

            state._fsp--;

             after(grammarAccess.getAddressExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddressExpression1343); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAddressExpression"


    // $ANTLR start "ruleAddressExpression"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:722:1: ruleAddressExpression : ( ( rule__AddressExpression__Group__0 ) ) ;
    public final void ruleAddressExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:726:5: ( ( ( rule__AddressExpression__Group__0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:727:1: ( ( rule__AddressExpression__Group__0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:727:1: ( ( rule__AddressExpression__Group__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:728:1: ( rule__AddressExpression__Group__0 )
            {
             before(grammarAccess.getAddressExpressionAccess().getGroup()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:729:1: ( rule__AddressExpression__Group__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:729:2: rule__AddressExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AddressExpression__Group__0_in_ruleAddressExpression1373);
            rule__AddressExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAddressExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddressExpression"


    // $ANTLR start "entryRuleNumber"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:741:1: entryRuleNumber : ruleNumber EOF ;
    public final void entryRuleNumber() throws RecognitionException {
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:742:1: ( ruleNumber EOF )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:743:1: ruleNumber EOF
            {
             before(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber1400);
            ruleNumber();

            state._fsp--;

             after(grammarAccess.getNumberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber1407); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:750:1: ruleNumber : ( ( rule__Number__Alternatives ) ) ;
    public final void ruleNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:754:5: ( ( ( rule__Number__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:755:1: ( ( rule__Number__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:755:1: ( ( rule__Number__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:756:1: ( rule__Number__Alternatives )
            {
             before(grammarAccess.getNumberAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:757:1: ( rule__Number__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:757:2: rule__Number__Alternatives
            {
            pushFollow(FOLLOW_rule__Number__Alternatives_in_ruleNumber1437);
            rule__Number__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNumberAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "ruleBasicOpcode"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:770:1: ruleBasicOpcode : ( ( rule__BasicOpcode__Alternatives ) ) ;
    public final void ruleBasicOpcode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:774:1: ( ( ( rule__BasicOpcode__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:775:1: ( ( rule__BasicOpcode__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:775:1: ( ( rule__BasicOpcode__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:776:1: ( rule__BasicOpcode__Alternatives )
            {
             before(grammarAccess.getBasicOpcodeAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:777:1: ( rule__BasicOpcode__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:777:2: rule__BasicOpcode__Alternatives
            {
            pushFollow(FOLLOW_rule__BasicOpcode__Alternatives_in_ruleBasicOpcode1474);
            rule__BasicOpcode__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBasicOpcodeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBasicOpcode"


    // $ANTLR start "ruleSpecialOpcode"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:789:1: ruleSpecialOpcode : ( ( rule__SpecialOpcode__Alternatives ) ) ;
    public final void ruleSpecialOpcode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:793:1: ( ( ( rule__SpecialOpcode__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:794:1: ( ( rule__SpecialOpcode__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:794:1: ( ( rule__SpecialOpcode__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:795:1: ( rule__SpecialOpcode__Alternatives )
            {
             before(grammarAccess.getSpecialOpcodeAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:796:1: ( rule__SpecialOpcode__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:796:2: rule__SpecialOpcode__Alternatives
            {
            pushFollow(FOLLOW_rule__SpecialOpcode__Alternatives_in_ruleSpecialOpcode1510);
            rule__SpecialOpcode__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSpecialOpcodeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpecialOpcode"


    // $ANTLR start "ruleStandardRegister"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:808:1: ruleStandardRegister : ( ( rule__StandardRegister__Alternatives ) ) ;
    public final void ruleStandardRegister() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:812:1: ( ( ( rule__StandardRegister__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:813:1: ( ( rule__StandardRegister__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:813:1: ( ( rule__StandardRegister__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:814:1: ( rule__StandardRegister__Alternatives )
            {
             before(grammarAccess.getStandardRegisterAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:815:1: ( rule__StandardRegister__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:815:2: rule__StandardRegister__Alternatives
            {
            pushFollow(FOLLOW_rule__StandardRegister__Alternatives_in_ruleStandardRegister1546);
            rule__StandardRegister__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStandardRegisterAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStandardRegister"


    // $ANTLR start "ruleSpecialRegister"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:827:1: ruleSpecialRegister : ( ( rule__SpecialRegister__Alternatives ) ) ;
    public final void ruleSpecialRegister() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:831:1: ( ( ( rule__SpecialRegister__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:832:1: ( ( rule__SpecialRegister__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:832:1: ( ( rule__SpecialRegister__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:833:1: ( rule__SpecialRegister__Alternatives )
            {
             before(grammarAccess.getSpecialRegisterAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:834:1: ( rule__SpecialRegister__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:834:2: rule__SpecialRegister__Alternatives
            {
            pushFollow(FOLLOW_rule__SpecialRegister__Alternatives_in_ruleSpecialRegister1582);
            rule__SpecialRegister__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSpecialRegisterAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpecialRegister"


    // $ANTLR start "ruleOperator"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:846:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:850:1: ( ( ( rule__Operator__Alternatives ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:851:1: ( ( rule__Operator__Alternatives ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:851:1: ( ( rule__Operator__Alternatives ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:852:1: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:853:1: ( rule__Operator__Alternatives )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:853:2: rule__Operator__Alternatives
            {
            pushFollow(FOLLOW_rule__Operator__Alternatives_in_ruleOperator1618);
            rule__Operator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "rule__LineContent__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:864:1: rule__LineContent__Alternatives : ( ( ruleInstruction ) | ( ruleDirective ) | ( ruleDataLine ) );
    public final void rule__LineContent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:868:1: ( ( ruleInstruction ) | ( ruleDirective ) | ( ruleDataLine ) )
            int alt1=3;
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
                alt1=1;
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
                alt1=2;
                }
                break;
            case KEYWORD_78:
            case KEYWORD_45:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:869:1: ( ruleInstruction )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:869:1: ( ruleInstruction )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:870:1: ruleInstruction
                    {
                     before(grammarAccess.getLineContentAccess().getInstructionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleInstruction_in_rule__LineContent__Alternatives1653);
                    ruleInstruction();

                    state._fsp--;

                     after(grammarAccess.getLineContentAccess().getInstructionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:875:6: ( ruleDirective )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:875:6: ( ruleDirective )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:876:1: ruleDirective
                    {
                     before(grammarAccess.getLineContentAccess().getDirectiveParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDirective_in_rule__LineContent__Alternatives1670);
                    ruleDirective();

                    state._fsp--;

                     after(grammarAccess.getLineContentAccess().getDirectiveParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:881:6: ( ruleDataLine )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:881:6: ( ruleDataLine )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:882:1: ruleDataLine
                    {
                     before(grammarAccess.getLineContentAccess().getDataLineParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDataLine_in_rule__LineContent__Alternatives1687);
                    ruleDataLine();

                    state._fsp--;

                     after(grammarAccess.getLineContentAccess().getDataLineParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineContent__Alternatives"


    // $ANTLR start "rule__Directive__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:892:1: rule__Directive__Alternatives : ( ( ruleIncludeDirective ) | ( ruleOriginDirective ) );
    public final void rule__Directive__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:896:1: ( ( ruleIncludeDirective ) | ( ruleOriginDirective ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=KEYWORD_87 && LA2_0<=KEYWORD_83)||LA2_0==KEYWORD_85) ) {
                alt2=1;
            }
            else if ( (LA2_0==KEYWORD_84||(LA2_0>=KEYWORD_86 && LA2_0<=KEYWORD_82)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:897:1: ( ruleIncludeDirective )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:897:1: ( ruleIncludeDirective )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:898:1: ruleIncludeDirective
                    {
                     before(grammarAccess.getDirectiveAccess().getIncludeDirectiveParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIncludeDirective_in_rule__Directive__Alternatives1719);
                    ruleIncludeDirective();

                    state._fsp--;

                     after(grammarAccess.getDirectiveAccess().getIncludeDirectiveParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:903:6: ( ruleOriginDirective )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:903:6: ( ruleOriginDirective )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:904:1: ruleOriginDirective
                    {
                     before(grammarAccess.getDirectiveAccess().getOriginDirectiveParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleOriginDirective_in_rule__Directive__Alternatives1736);
                    ruleOriginDirective();

                    state._fsp--;

                     after(grammarAccess.getDirectiveAccess().getOriginDirectiveParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Directive__Alternatives"


    // $ANTLR start "rule__OriginDirective__Alternatives_0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:914:1: rule__OriginDirective__Alternatives_0 : ( ( KEYWORD_86 ) | ( KEYWORD_84 ) | ( KEYWORD_82 ) | ( KEYWORD_81 ) );
    public final void rule__OriginDirective__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:918:1: ( ( KEYWORD_86 ) | ( KEYWORD_84 ) | ( KEYWORD_82 ) | ( KEYWORD_81 ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case KEYWORD_86:
                {
                alt3=1;
                }
                break;
            case KEYWORD_84:
                {
                alt3=2;
                }
                break;
            case KEYWORD_82:
                {
                alt3=3;
                }
                break;
            case KEYWORD_81:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:919:1: ( KEYWORD_86 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:919:1: ( KEYWORD_86 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:920:1: KEYWORD_86
                    {
                     before(grammarAccess.getOriginDirectiveAccess().getOriginKeyword_0_0()); 
                    match(input,KEYWORD_86,FOLLOW_KEYWORD_86_in_rule__OriginDirective__Alternatives_01769); 
                     after(grammarAccess.getOriginDirectiveAccess().getOriginKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:927:6: ( KEYWORD_84 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:927:6: ( KEYWORD_84 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:928:1: KEYWORD_84
                    {
                     before(grammarAccess.getOriginDirectiveAccess().getOriginKeyword_0_1()); 
                    match(input,KEYWORD_84,FOLLOW_KEYWORD_84_in_rule__OriginDirective__Alternatives_01789); 
                     after(grammarAccess.getOriginDirectiveAccess().getOriginKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:935:6: ( KEYWORD_82 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:935:6: ( KEYWORD_82 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:936:1: KEYWORD_82
                    {
                     before(grammarAccess.getOriginDirectiveAccess().getAlignKeyword_0_2()); 
                    match(input,KEYWORD_82,FOLLOW_KEYWORD_82_in_rule__OriginDirective__Alternatives_01809); 
                     after(grammarAccess.getOriginDirectiveAccess().getAlignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:943:6: ( KEYWORD_81 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:943:6: ( KEYWORD_81 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:944:1: KEYWORD_81
                    {
                     before(grammarAccess.getOriginDirectiveAccess().getAlignKeyword_0_3()); 
                    match(input,KEYWORD_81,FOLLOW_KEYWORD_81_in_rule__OriginDirective__Alternatives_01829); 
                     after(grammarAccess.getOriginDirectiveAccess().getAlignKeyword_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OriginDirective__Alternatives_0"


    // $ANTLR start "rule__IncludeDirective__Alternatives_0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:956:1: rule__IncludeDirective__Alternatives_0 : ( ( KEYWORD_88 ) | ( KEYWORD_87 ) | ( KEYWORD_85 ) | ( KEYWORD_83 ) );
    public final void rule__IncludeDirective__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:960:1: ( ( KEYWORD_88 ) | ( KEYWORD_87 ) | ( KEYWORD_85 ) | ( KEYWORD_83 ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case KEYWORD_88:
                {
                alt4=1;
                }
                break;
            case KEYWORD_87:
                {
                alt4=2;
                }
                break;
            case KEYWORD_85:
                {
                alt4=3;
                }
                break;
            case KEYWORD_83:
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
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:961:1: ( KEYWORD_88 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:961:1: ( KEYWORD_88 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:962:1: KEYWORD_88
                    {
                     before(grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_0_0()); 
                    match(input,KEYWORD_88,FOLLOW_KEYWORD_88_in_rule__IncludeDirective__Alternatives_01864); 
                     after(grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:969:6: ( KEYWORD_87 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:969:6: ( KEYWORD_87 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:970:1: KEYWORD_87
                    {
                     before(grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_0_1()); 
                    match(input,KEYWORD_87,FOLLOW_KEYWORD_87_in_rule__IncludeDirective__Alternatives_01884); 
                     after(grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:977:6: ( KEYWORD_85 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:977:6: ( KEYWORD_85 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:978:1: KEYWORD_85
                    {
                     before(grammarAccess.getIncludeDirectiveAccess().getImportKeyword_0_2()); 
                    match(input,KEYWORD_85,FOLLOW_KEYWORD_85_in_rule__IncludeDirective__Alternatives_01904); 
                     after(grammarAccess.getIncludeDirectiveAccess().getImportKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:985:6: ( KEYWORD_83 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:985:6: ( KEYWORD_83 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:986:1: KEYWORD_83
                    {
                     before(grammarAccess.getIncludeDirectiveAccess().getImportKeyword_0_3()); 
                    match(input,KEYWORD_83,FOLLOW_KEYWORD_83_in_rule__IncludeDirective__Alternatives_01924); 
                     after(grammarAccess.getIncludeDirectiveAccess().getImportKeyword_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Alternatives_0"


    // $ANTLR start "rule__DataLine__Alternatives_0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:998:1: rule__DataLine__Alternatives_0 : ( ( KEYWORD_45 ) | ( KEYWORD_78 ) );
    public final void rule__DataLine__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1002:1: ( ( KEYWORD_45 ) | ( KEYWORD_78 ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==KEYWORD_45) ) {
                alt5=1;
            }
            else if ( (LA5_0==KEYWORD_78) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1003:1: ( KEYWORD_45 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1003:1: ( KEYWORD_45 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1004:1: KEYWORD_45
                    {
                     before(grammarAccess.getDataLineAccess().getDATKeyword_0_0()); 
                    match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_rule__DataLine__Alternatives_01959); 
                     after(grammarAccess.getDataLineAccess().getDATKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1011:6: ( KEYWORD_78 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1011:6: ( KEYWORD_78 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1012:1: KEYWORD_78
                    {
                     before(grammarAccess.getDataLineAccess().getDatKeyword_0_1()); 
                    match(input,KEYWORD_78,FOLLOW_KEYWORD_78_in_rule__DataLine__Alternatives_01979); 
                     after(grammarAccess.getDataLineAccess().getDatKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Alternatives_0"


    // $ANTLR start "rule__DataElement__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1024:1: rule__DataElement__Alternatives : ( ( RULE_STRING ) | ( ruleNumber ) );
    public final void rule__DataElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1028:1: ( ( RULE_STRING ) | ( ruleNumber ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=RULE_HEXNUMBER && LA6_0<=RULE_BINNUMBER)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1029:1: ( RULE_STRING )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1029:1: ( RULE_STRING )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1030:1: RULE_STRING
                    {
                     before(grammarAccess.getDataElementAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DataElement__Alternatives2013); 
                     after(grammarAccess.getDataElementAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1035:6: ( ruleNumber )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1035:6: ( ruleNumber )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1036:1: ruleNumber
                    {
                     before(grammarAccess.getDataElementAccess().getNumberParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumber_in_rule__DataElement__Alternatives2030);
                    ruleNumber();

                    state._fsp--;

                     after(grammarAccess.getDataElementAccess().getNumberParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataElement__Alternatives"


    // $ANTLR start "rule__TerminalExpression__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1046:1: rule__TerminalExpression__Alternatives : ( ( ( rule__TerminalExpression__Group_0__0 ) ) | ( ( rule__TerminalExpression__ValueAssignment_1 ) ) );
    public final void rule__TerminalExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1050:1: ( ( ( rule__TerminalExpression__Group_0__0 ) ) | ( ( rule__TerminalExpression__ValueAssignment_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KEYWORD_4) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=KEYWORD_79 && LA7_0<=KEYWORD_80)||LA7_0==KEYWORD_68||(LA7_0>=KEYWORD_35 && LA7_0<=KEYWORD_37)||(LA7_0>=KEYWORD_15 && LA7_0<=KEYWORD_22)||(LA7_0>=RULE_ID && LA7_0<=RULE_BINNUMBER)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1051:1: ( ( rule__TerminalExpression__Group_0__0 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1051:1: ( ( rule__TerminalExpression__Group_0__0 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1052:1: ( rule__TerminalExpression__Group_0__0 )
                    {
                     before(grammarAccess.getTerminalExpressionAccess().getGroup_0()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1053:1: ( rule__TerminalExpression__Group_0__0 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1053:2: rule__TerminalExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpression__Group_0__0_in_rule__TerminalExpression__Alternatives2062);
                    rule__TerminalExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1057:6: ( ( rule__TerminalExpression__ValueAssignment_1 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1057:6: ( ( rule__TerminalExpression__ValueAssignment_1 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1058:1: ( rule__TerminalExpression__ValueAssignment_1 )
                    {
                     before(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1059:1: ( rule__TerminalExpression__ValueAssignment_1 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1059:2: rule__TerminalExpression__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TerminalExpression__ValueAssignment_1_in_rule__TerminalExpression__Alternatives2080);
                    rule__TerminalExpression__ValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Alternatives"


    // $ANTLR start "rule__NonGroupOperand__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1068:1: rule__NonGroupOperand__Alternatives : ( ( ruleRegister ) | ( ruleLiteral ) | ( ( rule__NonGroupOperand__LabelNameAssignment_2 ) ) | ( ruleStackValue ) );
    public final void rule__NonGroupOperand__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1072:1: ( ( ruleRegister ) | ( ruleLiteral ) | ( ( rule__NonGroupOperand__LabelNameAssignment_2 ) ) | ( ruleStackValue ) )
            int alt8=4;
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
                alt8=1;
                }
                break;
            case RULE_HEXNUMBER:
            case RULE_DECNUMBER:
            case RULE_BINNUMBER:
                {
                alt8=2;
                }
                break;
            case RULE_ID:
                {
                alt8=3;
                }
                break;
            case KEYWORD_79:
            case KEYWORD_80:
            case KEYWORD_68:
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
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1073:1: ( ruleRegister )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1073:1: ( ruleRegister )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1074:1: ruleRegister
                    {
                     before(grammarAccess.getNonGroupOperandAccess().getRegisterParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRegister_in_rule__NonGroupOperand__Alternatives2113);
                    ruleRegister();

                    state._fsp--;

                     after(grammarAccess.getNonGroupOperandAccess().getRegisterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1079:6: ( ruleLiteral )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1079:6: ( ruleLiteral )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1080:1: ruleLiteral
                    {
                     before(grammarAccess.getNonGroupOperandAccess().getLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleLiteral_in_rule__NonGroupOperand__Alternatives2130);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getNonGroupOperandAccess().getLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1085:6: ( ( rule__NonGroupOperand__LabelNameAssignment_2 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1085:6: ( ( rule__NonGroupOperand__LabelNameAssignment_2 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1086:1: ( rule__NonGroupOperand__LabelNameAssignment_2 )
                    {
                     before(grammarAccess.getNonGroupOperandAccess().getLabelNameAssignment_2()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1087:1: ( rule__NonGroupOperand__LabelNameAssignment_2 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1087:2: rule__NonGroupOperand__LabelNameAssignment_2
                    {
                    pushFollow(FOLLOW_rule__NonGroupOperand__LabelNameAssignment_2_in_rule__NonGroupOperand__Alternatives2147);
                    rule__NonGroupOperand__LabelNameAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getNonGroupOperandAccess().getLabelNameAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1091:6: ( ruleStackValue )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1091:6: ( ruleStackValue )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1092:1: ruleStackValue
                    {
                     before(grammarAccess.getNonGroupOperandAccess().getStackValueParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleStackValue_in_rule__NonGroupOperand__Alternatives2165);
                    ruleStackValue();

                    state._fsp--;

                     after(grammarAccess.getNonGroupOperandAccess().getStackValueParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonGroupOperand__Alternatives"


    // $ANTLR start "rule__StackValue__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1102:1: rule__StackValue__Alternatives : ( ( KEYWORD_68 ) | ( KEYWORD_80 ) | ( rulePickValue ) );
    public final void rule__StackValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1106:1: ( ( KEYWORD_68 ) | ( KEYWORD_80 ) | ( rulePickValue ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case KEYWORD_68:
                {
                alt9=1;
                }
                break;
            case KEYWORD_80:
                {
                alt9=2;
                }
                break;
            case KEYWORD_79:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1107:1: ( KEYWORD_68 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1107:1: ( KEYWORD_68 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1108:1: KEYWORD_68
                    {
                     before(grammarAccess.getStackValueAccess().getPOPKeyword_0()); 
                    match(input,KEYWORD_68,FOLLOW_KEYWORD_68_in_rule__StackValue__Alternatives2198); 
                     after(grammarAccess.getStackValueAccess().getPOPKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1115:6: ( KEYWORD_80 )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1115:6: ( KEYWORD_80 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1116:1: KEYWORD_80
                    {
                     before(grammarAccess.getStackValueAccess().getPUSHKeyword_1()); 
                    match(input,KEYWORD_80,FOLLOW_KEYWORD_80_in_rule__StackValue__Alternatives2218); 
                     after(grammarAccess.getStackValueAccess().getPUSHKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1123:6: ( rulePickValue )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1123:6: ( rulePickValue )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1124:1: rulePickValue
                    {
                     before(grammarAccess.getStackValueAccess().getPickValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_rulePickValue_in_rule__StackValue__Alternatives2237);
                    rulePickValue();

                    state._fsp--;

                     after(grammarAccess.getStackValueAccess().getPickValueParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StackValue__Alternatives"


    // $ANTLR start "rule__Instruction__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1134:1: rule__Instruction__Alternatives : ( ( ruleBasicInstruction ) | ( ruleSpecialInstruction ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1138:1: ( ( ruleBasicInstruction ) | ( ruleSpecialInstruction ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=KEYWORD_40 && LA10_0<=KEYWORD_44)||(LA10_0>=KEYWORD_46 && LA10_0<=KEYWORD_47)||(LA10_0>=KEYWORD_54 && LA10_0<=KEYWORD_61)||(LA10_0>=KEYWORD_64 && LA10_0<=KEYWORD_67)||(LA10_0>=KEYWORD_70 && LA10_0<=KEYWORD_77)) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=KEYWORD_48 && LA10_0<=KEYWORD_53)||(LA10_0>=KEYWORD_62 && LA10_0<=KEYWORD_63)||LA10_0==KEYWORD_69) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1139:1: ( ruleBasicInstruction )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1139:1: ( ruleBasicInstruction )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1140:1: ruleBasicInstruction
                    {
                     before(grammarAccess.getInstructionAccess().getBasicInstructionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBasicInstruction_in_rule__Instruction__Alternatives2269);
                    ruleBasicInstruction();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getBasicInstructionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1145:6: ( ruleSpecialInstruction )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1145:6: ( ruleSpecialInstruction )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1146:1: ruleSpecialInstruction
                    {
                     before(grammarAccess.getInstructionAccess().getSpecialInstructionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSpecialInstruction_in_rule__Instruction__Alternatives2286);
                    ruleSpecialInstruction();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getSpecialInstructionParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Alternatives"


    // $ANTLR start "rule__Value__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1156:1: rule__Value__Alternatives : ( ( ruleLiteralExpression ) | ( ruleAddressExpression ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1160:1: ( ( ruleLiteralExpression ) | ( ruleAddressExpression ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=KEYWORD_79 && LA11_0<=KEYWORD_80)||LA11_0==KEYWORD_68||(LA11_0>=KEYWORD_35 && LA11_0<=KEYWORD_37)||LA11_0==KEYWORD_4||(LA11_0>=KEYWORD_15 && LA11_0<=KEYWORD_22)||(LA11_0>=RULE_ID && LA11_0<=RULE_BINNUMBER)) ) {
                alt11=1;
            }
            else if ( (LA11_0==KEYWORD_23) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1161:1: ( ruleLiteralExpression )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1161:1: ( ruleLiteralExpression )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1162:1: ruleLiteralExpression
                    {
                     before(grammarAccess.getValueAccess().getLiteralExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLiteralExpression_in_rule__Value__Alternatives2318);
                    ruleLiteralExpression();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getLiteralExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1167:6: ( ruleAddressExpression )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1167:6: ( ruleAddressExpression )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1168:1: ruleAddressExpression
                    {
                     before(grammarAccess.getValueAccess().getAddressExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAddressExpression_in_rule__Value__Alternatives2335);
                    ruleAddressExpression();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getAddressExpressionParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Alternatives"


    // $ANTLR start "rule__Register__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1178:1: rule__Register__Alternatives : ( ( ( rule__Register__StandardRegisterAssignment_0 ) ) | ( ( rule__Register__SpecialRegisterAssignment_1 ) ) );
    public final void rule__Register__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1182:1: ( ( ( rule__Register__StandardRegisterAssignment_0 ) ) | ( ( rule__Register__SpecialRegisterAssignment_1 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=KEYWORD_15 && LA12_0<=KEYWORD_22)) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=KEYWORD_35 && LA12_0<=KEYWORD_37)) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1183:1: ( ( rule__Register__StandardRegisterAssignment_0 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1183:1: ( ( rule__Register__StandardRegisterAssignment_0 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1184:1: ( rule__Register__StandardRegisterAssignment_0 )
                    {
                     before(grammarAccess.getRegisterAccess().getStandardRegisterAssignment_0()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1185:1: ( rule__Register__StandardRegisterAssignment_0 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1185:2: rule__Register__StandardRegisterAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Register__StandardRegisterAssignment_0_in_rule__Register__Alternatives2367);
                    rule__Register__StandardRegisterAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRegisterAccess().getStandardRegisterAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1189:6: ( ( rule__Register__SpecialRegisterAssignment_1 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1189:6: ( ( rule__Register__SpecialRegisterAssignment_1 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1190:1: ( rule__Register__SpecialRegisterAssignment_1 )
                    {
                     before(grammarAccess.getRegisterAccess().getSpecialRegisterAssignment_1()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1191:1: ( rule__Register__SpecialRegisterAssignment_1 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1191:2: rule__Register__SpecialRegisterAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Register__SpecialRegisterAssignment_1_in_rule__Register__Alternatives2385);
                    rule__Register__SpecialRegisterAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getRegisterAccess().getSpecialRegisterAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Register__Alternatives"


    // $ANTLR start "rule__Number__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1201:1: rule__Number__Alternatives : ( ( RULE_HEXNUMBER ) | ( RULE_DECNUMBER ) | ( RULE_BINNUMBER ) );
    public final void rule__Number__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1205:1: ( ( RULE_HEXNUMBER ) | ( RULE_DECNUMBER ) | ( RULE_BINNUMBER ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_HEXNUMBER:
                {
                alt13=1;
                }
                break;
            case RULE_DECNUMBER:
                {
                alt13=2;
                }
                break;
            case RULE_BINNUMBER:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1206:1: ( RULE_HEXNUMBER )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1206:1: ( RULE_HEXNUMBER )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1207:1: RULE_HEXNUMBER
                    {
                     before(grammarAccess.getNumberAccess().getHEXNUMBERTerminalRuleCall_0()); 
                    match(input,RULE_HEXNUMBER,FOLLOW_RULE_HEXNUMBER_in_rule__Number__Alternatives2419); 
                     after(grammarAccess.getNumberAccess().getHEXNUMBERTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1212:6: ( RULE_DECNUMBER )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1212:6: ( RULE_DECNUMBER )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1213:1: RULE_DECNUMBER
                    {
                     before(grammarAccess.getNumberAccess().getDECNUMBERTerminalRuleCall_1()); 
                    match(input,RULE_DECNUMBER,FOLLOW_RULE_DECNUMBER_in_rule__Number__Alternatives2436); 
                     after(grammarAccess.getNumberAccess().getDECNUMBERTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1218:6: ( RULE_BINNUMBER )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1218:6: ( RULE_BINNUMBER )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1219:1: RULE_BINNUMBER
                    {
                     before(grammarAccess.getNumberAccess().getBINNUMBERTerminalRuleCall_2()); 
                    match(input,RULE_BINNUMBER,FOLLOW_RULE_BINNUMBER_in_rule__Number__Alternatives2453); 
                     after(grammarAccess.getNumberAccess().getBINNUMBERTerminalRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Alternatives"


    // $ANTLR start "rule__BasicOpcode__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1229:1: rule__BasicOpcode__Alternatives : ( ( ( KEYWORD_71 ) ) | ( ( KEYWORD_40 ) ) | ( ( KEYWORD_76 ) ) | ( ( KEYWORD_67 ) ) | ( ( KEYWORD_65 ) ) | ( ( KEYWORD_46 ) ) | ( ( KEYWORD_47 ) ) | ( ( KEYWORD_66 ) ) | ( ( KEYWORD_64 ) ) | ( ( KEYWORD_42 ) ) | ( ( KEYWORD_44 ) ) | ( ( KEYWORD_77 ) ) | ( ( KEYWORD_73 ) ) | ( ( KEYWORD_43 ) ) | ( ( KEYWORD_72 ) ) | ( ( KEYWORD_55 ) ) | ( ( KEYWORD_56 ) ) | ( ( KEYWORD_57 ) ) | ( ( KEYWORD_60 ) ) | ( ( KEYWORD_58 ) ) | ( ( KEYWORD_54 ) ) | ( ( KEYWORD_59 ) ) | ( ( KEYWORD_61 ) ) | ( ( KEYWORD_41 ) ) | ( ( KEYWORD_70 ) ) | ( ( KEYWORD_75 ) ) | ( ( KEYWORD_74 ) ) );
    public final void rule__BasicOpcode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1233:1: ( ( ( KEYWORD_71 ) ) | ( ( KEYWORD_40 ) ) | ( ( KEYWORD_76 ) ) | ( ( KEYWORD_67 ) ) | ( ( KEYWORD_65 ) ) | ( ( KEYWORD_46 ) ) | ( ( KEYWORD_47 ) ) | ( ( KEYWORD_66 ) ) | ( ( KEYWORD_64 ) ) | ( ( KEYWORD_42 ) ) | ( ( KEYWORD_44 ) ) | ( ( KEYWORD_77 ) ) | ( ( KEYWORD_73 ) ) | ( ( KEYWORD_43 ) ) | ( ( KEYWORD_72 ) ) | ( ( KEYWORD_55 ) ) | ( ( KEYWORD_56 ) ) | ( ( KEYWORD_57 ) ) | ( ( KEYWORD_60 ) ) | ( ( KEYWORD_58 ) ) | ( ( KEYWORD_54 ) ) | ( ( KEYWORD_59 ) ) | ( ( KEYWORD_61 ) ) | ( ( KEYWORD_41 ) ) | ( ( KEYWORD_70 ) ) | ( ( KEYWORD_75 ) ) | ( ( KEYWORD_74 ) ) )
            int alt14=27;
            switch ( input.LA(1) ) {
            case KEYWORD_71:
                {
                alt14=1;
                }
                break;
            case KEYWORD_40:
                {
                alt14=2;
                }
                break;
            case KEYWORD_76:
                {
                alt14=3;
                }
                break;
            case KEYWORD_67:
                {
                alt14=4;
                }
                break;
            case KEYWORD_65:
                {
                alt14=5;
                }
                break;
            case KEYWORD_46:
                {
                alt14=6;
                }
                break;
            case KEYWORD_47:
                {
                alt14=7;
                }
                break;
            case KEYWORD_66:
                {
                alt14=8;
                }
                break;
            case KEYWORD_64:
                {
                alt14=9;
                }
                break;
            case KEYWORD_42:
                {
                alt14=10;
                }
                break;
            case KEYWORD_44:
                {
                alt14=11;
                }
                break;
            case KEYWORD_77:
                {
                alt14=12;
                }
                break;
            case KEYWORD_73:
                {
                alt14=13;
                }
                break;
            case KEYWORD_43:
                {
                alt14=14;
                }
                break;
            case KEYWORD_72:
                {
                alt14=15;
                }
                break;
            case KEYWORD_55:
                {
                alt14=16;
                }
                break;
            case KEYWORD_56:
                {
                alt14=17;
                }
                break;
            case KEYWORD_57:
                {
                alt14=18;
                }
                break;
            case KEYWORD_60:
                {
                alt14=19;
                }
                break;
            case KEYWORD_58:
                {
                alt14=20;
                }
                break;
            case KEYWORD_54:
                {
                alt14=21;
                }
                break;
            case KEYWORD_59:
                {
                alt14=22;
                }
                break;
            case KEYWORD_61:
                {
                alt14=23;
                }
                break;
            case KEYWORD_41:
                {
                alt14=24;
                }
                break;
            case KEYWORD_70:
                {
                alt14=25;
                }
                break;
            case KEYWORD_75:
                {
                alt14=26;
                }
                break;
            case KEYWORD_74:
                {
                alt14=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1234:1: ( ( KEYWORD_71 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1234:1: ( ( KEYWORD_71 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1235:1: ( KEYWORD_71 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getSETEnumLiteralDeclaration_0()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1236:1: ( KEYWORD_71 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1236:3: KEYWORD_71
                    {
                    match(input,KEYWORD_71,FOLLOW_KEYWORD_71_in_rule__BasicOpcode__Alternatives2486); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getSETEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1241:6: ( ( KEYWORD_40 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1241:6: ( ( KEYWORD_40 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1242:1: ( KEYWORD_40 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getADDEnumLiteralDeclaration_1()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1243:1: ( KEYWORD_40 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1243:3: KEYWORD_40
                    {
                    match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_rule__BasicOpcode__Alternatives2506); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getADDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1248:6: ( ( KEYWORD_76 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1248:6: ( ( KEYWORD_76 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1249:1: ( KEYWORD_76 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getSUBEnumLiteralDeclaration_2()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1250:1: ( KEYWORD_76 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1250:3: KEYWORD_76
                    {
                    match(input,KEYWORD_76,FOLLOW_KEYWORD_76_in_rule__BasicOpcode__Alternatives2526); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getSUBEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1255:6: ( ( KEYWORD_67 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1255:6: ( ( KEYWORD_67 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1256:1: ( KEYWORD_67 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getMULEnumLiteralDeclaration_3()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1257:1: ( KEYWORD_67 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1257:3: KEYWORD_67
                    {
                    match(input,KEYWORD_67,FOLLOW_KEYWORD_67_in_rule__BasicOpcode__Alternatives2546); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getMULEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1262:6: ( ( KEYWORD_65 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1262:6: ( ( KEYWORD_65 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1263:1: ( KEYWORD_65 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getMLIEnumLiteralDeclaration_4()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1264:1: ( KEYWORD_65 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1264:3: KEYWORD_65
                    {
                    match(input,KEYWORD_65,FOLLOW_KEYWORD_65_in_rule__BasicOpcode__Alternatives2566); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getMLIEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1269:6: ( ( KEYWORD_46 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1269:6: ( ( KEYWORD_46 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1270:1: ( KEYWORD_46 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getDIVEnumLiteralDeclaration_5()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1271:1: ( KEYWORD_46 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1271:3: KEYWORD_46
                    {
                    match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_rule__BasicOpcode__Alternatives2586); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getDIVEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1276:6: ( ( KEYWORD_47 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1276:6: ( ( KEYWORD_47 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1277:1: ( KEYWORD_47 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getDVIEnumLiteralDeclaration_6()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1278:1: ( KEYWORD_47 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1278:3: KEYWORD_47
                    {
                    match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_rule__BasicOpcode__Alternatives2606); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getDVIEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1283:6: ( ( KEYWORD_66 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1283:6: ( ( KEYWORD_66 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1284:1: ( KEYWORD_66 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getMODEnumLiteralDeclaration_7()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1285:1: ( KEYWORD_66 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1285:3: KEYWORD_66
                    {
                    match(input,KEYWORD_66,FOLLOW_KEYWORD_66_in_rule__BasicOpcode__Alternatives2626); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getMODEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1290:6: ( ( KEYWORD_64 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1290:6: ( ( KEYWORD_64 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1291:1: ( KEYWORD_64 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getMDIEnumLiteralDeclaration_8()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1292:1: ( KEYWORD_64 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1292:3: KEYWORD_64
                    {
                    match(input,KEYWORD_64,FOLLOW_KEYWORD_64_in_rule__BasicOpcode__Alternatives2646); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getMDIEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1297:6: ( ( KEYWORD_42 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1297:6: ( ( KEYWORD_42 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1298:1: ( KEYWORD_42 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getANDEnumLiteralDeclaration_9()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1299:1: ( KEYWORD_42 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1299:3: KEYWORD_42
                    {
                    match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_rule__BasicOpcode__Alternatives2666); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getANDEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1304:6: ( ( KEYWORD_44 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1304:6: ( ( KEYWORD_44 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1305:1: ( KEYWORD_44 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getBOREnumLiteralDeclaration_10()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1306:1: ( KEYWORD_44 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1306:3: KEYWORD_44
                    {
                    match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_rule__BasicOpcode__Alternatives2686); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getBOREnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1311:6: ( ( KEYWORD_77 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1311:6: ( ( KEYWORD_77 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1312:1: ( KEYWORD_77 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getXOREnumLiteralDeclaration_11()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1313:1: ( KEYWORD_77 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1313:3: KEYWORD_77
                    {
                    match(input,KEYWORD_77,FOLLOW_KEYWORD_77_in_rule__BasicOpcode__Alternatives2706); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getXOREnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1318:6: ( ( KEYWORD_73 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1318:6: ( ( KEYWORD_73 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1319:1: ( KEYWORD_73 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getSHREnumLiteralDeclaration_12()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1320:1: ( KEYWORD_73 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1320:3: KEYWORD_73
                    {
                    match(input,KEYWORD_73,FOLLOW_KEYWORD_73_in_rule__BasicOpcode__Alternatives2726); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getSHREnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1325:6: ( ( KEYWORD_43 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1325:6: ( ( KEYWORD_43 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1326:1: ( KEYWORD_43 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getASREnumLiteralDeclaration_13()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1327:1: ( KEYWORD_43 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1327:3: KEYWORD_43
                    {
                    match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_rule__BasicOpcode__Alternatives2746); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getASREnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1332:6: ( ( KEYWORD_72 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1332:6: ( ( KEYWORD_72 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1333:1: ( KEYWORD_72 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getSHLEnumLiteralDeclaration_14()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1334:1: ( KEYWORD_72 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1334:3: KEYWORD_72
                    {
                    match(input,KEYWORD_72,FOLLOW_KEYWORD_72_in_rule__BasicOpcode__Alternatives2766); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getSHLEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1339:6: ( ( KEYWORD_55 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1339:6: ( ( KEYWORD_55 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1340:1: ( KEYWORD_55 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getIFBEnumLiteralDeclaration_15()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1341:1: ( KEYWORD_55 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1341:3: KEYWORD_55
                    {
                    match(input,KEYWORD_55,FOLLOW_KEYWORD_55_in_rule__BasicOpcode__Alternatives2786); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getIFBEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1346:6: ( ( KEYWORD_56 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1346:6: ( ( KEYWORD_56 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1347:1: ( KEYWORD_56 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getIFCEnumLiteralDeclaration_16()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1348:1: ( KEYWORD_56 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1348:3: KEYWORD_56
                    {
                    match(input,KEYWORD_56,FOLLOW_KEYWORD_56_in_rule__BasicOpcode__Alternatives2806); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getIFCEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1353:6: ( ( KEYWORD_57 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1353:6: ( ( KEYWORD_57 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1354:1: ( KEYWORD_57 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getIFEEnumLiteralDeclaration_17()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1355:1: ( KEYWORD_57 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1355:3: KEYWORD_57
                    {
                    match(input,KEYWORD_57,FOLLOW_KEYWORD_57_in_rule__BasicOpcode__Alternatives2826); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getIFEEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1360:6: ( ( KEYWORD_60 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1360:6: ( ( KEYWORD_60 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1361:1: ( KEYWORD_60 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getIFNEnumLiteralDeclaration_18()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1362:1: ( KEYWORD_60 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1362:3: KEYWORD_60
                    {
                    match(input,KEYWORD_60,FOLLOW_KEYWORD_60_in_rule__BasicOpcode__Alternatives2846); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getIFNEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1367:6: ( ( KEYWORD_58 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1367:6: ( ( KEYWORD_58 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1368:1: ( KEYWORD_58 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getIFGEnumLiteralDeclaration_19()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1369:1: ( KEYWORD_58 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1369:3: KEYWORD_58
                    {
                    match(input,KEYWORD_58,FOLLOW_KEYWORD_58_in_rule__BasicOpcode__Alternatives2866); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getIFGEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1374:6: ( ( KEYWORD_54 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1374:6: ( ( KEYWORD_54 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1375:1: ( KEYWORD_54 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getIFAEnumLiteralDeclaration_20()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1376:1: ( KEYWORD_54 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1376:3: KEYWORD_54
                    {
                    match(input,KEYWORD_54,FOLLOW_KEYWORD_54_in_rule__BasicOpcode__Alternatives2886); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getIFAEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1381:6: ( ( KEYWORD_59 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1381:6: ( ( KEYWORD_59 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1382:1: ( KEYWORD_59 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getIFLEnumLiteralDeclaration_21()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1383:1: ( KEYWORD_59 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1383:3: KEYWORD_59
                    {
                    match(input,KEYWORD_59,FOLLOW_KEYWORD_59_in_rule__BasicOpcode__Alternatives2906); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getIFLEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1388:6: ( ( KEYWORD_61 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1388:6: ( ( KEYWORD_61 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1389:1: ( KEYWORD_61 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getIFUEnumLiteralDeclaration_22()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1390:1: ( KEYWORD_61 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1390:3: KEYWORD_61
                    {
                    match(input,KEYWORD_61,FOLLOW_KEYWORD_61_in_rule__BasicOpcode__Alternatives2926); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getIFUEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1395:6: ( ( KEYWORD_41 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1395:6: ( ( KEYWORD_41 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1396:1: ( KEYWORD_41 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getADXEnumLiteralDeclaration_23()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1397:1: ( KEYWORD_41 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1397:3: KEYWORD_41
                    {
                    match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_rule__BasicOpcode__Alternatives2946); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getADXEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1402:6: ( ( KEYWORD_70 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1402:6: ( ( KEYWORD_70 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1403:1: ( KEYWORD_70 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getSBXEnumLiteralDeclaration_24()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1404:1: ( KEYWORD_70 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1404:3: KEYWORD_70
                    {
                    match(input,KEYWORD_70,FOLLOW_KEYWORD_70_in_rule__BasicOpcode__Alternatives2966); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getSBXEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1409:6: ( ( KEYWORD_75 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1409:6: ( ( KEYWORD_75 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1410:1: ( KEYWORD_75 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getSTIEnumLiteralDeclaration_25()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1411:1: ( KEYWORD_75 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1411:3: KEYWORD_75
                    {
                    match(input,KEYWORD_75,FOLLOW_KEYWORD_75_in_rule__BasicOpcode__Alternatives2986); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getSTIEnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1416:6: ( ( KEYWORD_74 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1416:6: ( ( KEYWORD_74 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1417:1: ( KEYWORD_74 )
                    {
                     before(grammarAccess.getBasicOpcodeAccess().getSTDEnumLiteralDeclaration_26()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1418:1: ( KEYWORD_74 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1418:3: KEYWORD_74
                    {
                    match(input,KEYWORD_74,FOLLOW_KEYWORD_74_in_rule__BasicOpcode__Alternatives3006); 

                    }

                     after(grammarAccess.getBasicOpcodeAccess().getSTDEnumLiteralDeclaration_26()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicOpcode__Alternatives"


    // $ANTLR start "rule__SpecialOpcode__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1428:1: rule__SpecialOpcode__Alternatives : ( ( ( KEYWORD_63 ) ) | ( ( KEYWORD_62 ) ) | ( ( KEYWORD_51 ) ) | ( ( KEYWORD_53 ) ) | ( ( KEYWORD_69 ) ) | ( ( KEYWORD_52 ) ) | ( ( KEYWORD_49 ) ) | ( ( KEYWORD_50 ) ) | ( ( KEYWORD_48 ) ) );
    public final void rule__SpecialOpcode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1432:1: ( ( ( KEYWORD_63 ) ) | ( ( KEYWORD_62 ) ) | ( ( KEYWORD_51 ) ) | ( ( KEYWORD_53 ) ) | ( ( KEYWORD_69 ) ) | ( ( KEYWORD_52 ) ) | ( ( KEYWORD_49 ) ) | ( ( KEYWORD_50 ) ) | ( ( KEYWORD_48 ) ) )
            int alt15=9;
            switch ( input.LA(1) ) {
            case KEYWORD_63:
                {
                alt15=1;
                }
                break;
            case KEYWORD_62:
                {
                alt15=2;
                }
                break;
            case KEYWORD_51:
                {
                alt15=3;
                }
                break;
            case KEYWORD_53:
                {
                alt15=4;
                }
                break;
            case KEYWORD_69:
                {
                alt15=5;
                }
                break;
            case KEYWORD_52:
                {
                alt15=6;
                }
                break;
            case KEYWORD_49:
                {
                alt15=7;
                }
                break;
            case KEYWORD_50:
                {
                alt15=8;
                }
                break;
            case KEYWORD_48:
                {
                alt15=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1433:1: ( ( KEYWORD_63 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1433:1: ( ( KEYWORD_63 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1434:1: ( KEYWORD_63 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getJSREnumLiteralDeclaration_0()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1435:1: ( KEYWORD_63 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1435:3: KEYWORD_63
                    {
                    match(input,KEYWORD_63,FOLLOW_KEYWORD_63_in_rule__SpecialOpcode__Alternatives3041); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getJSREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1440:6: ( ( KEYWORD_62 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1440:6: ( ( KEYWORD_62 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1441:1: ( KEYWORD_62 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getINTEnumLiteralDeclaration_1()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1442:1: ( KEYWORD_62 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1442:3: KEYWORD_62
                    {
                    match(input,KEYWORD_62,FOLLOW_KEYWORD_62_in_rule__SpecialOpcode__Alternatives3061); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1447:6: ( ( KEYWORD_51 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1447:6: ( ( KEYWORD_51 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1448:1: ( KEYWORD_51 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getIAGEnumLiteralDeclaration_2()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1449:1: ( KEYWORD_51 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1449:3: KEYWORD_51
                    {
                    match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_rule__SpecialOpcode__Alternatives3081); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getIAGEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1454:6: ( ( KEYWORD_53 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1454:6: ( ( KEYWORD_53 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1455:1: ( KEYWORD_53 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getIASEnumLiteralDeclaration_3()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1456:1: ( KEYWORD_53 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1456:3: KEYWORD_53
                    {
                    match(input,KEYWORD_53,FOLLOW_KEYWORD_53_in_rule__SpecialOpcode__Alternatives3101); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getIASEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1461:6: ( ( KEYWORD_69 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1461:6: ( ( KEYWORD_69 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1462:1: ( KEYWORD_69 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getRFIEnumLiteralDeclaration_4()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1463:1: ( KEYWORD_69 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1463:3: KEYWORD_69
                    {
                    match(input,KEYWORD_69,FOLLOW_KEYWORD_69_in_rule__SpecialOpcode__Alternatives3121); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getRFIEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1468:6: ( ( KEYWORD_52 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1468:6: ( ( KEYWORD_52 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1469:1: ( KEYWORD_52 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getIAQEnumLiteralDeclaration_5()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1470:1: ( KEYWORD_52 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1470:3: KEYWORD_52
                    {
                    match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_rule__SpecialOpcode__Alternatives3141); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getIAQEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1475:6: ( ( KEYWORD_49 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1475:6: ( ( KEYWORD_49 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1476:1: ( KEYWORD_49 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getHWNEnumLiteralDeclaration_6()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1477:1: ( KEYWORD_49 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1477:3: KEYWORD_49
                    {
                    match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_rule__SpecialOpcode__Alternatives3161); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getHWNEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1482:6: ( ( KEYWORD_50 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1482:6: ( ( KEYWORD_50 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1483:1: ( KEYWORD_50 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getHWQEnumLiteralDeclaration_7()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1484:1: ( KEYWORD_50 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1484:3: KEYWORD_50
                    {
                    match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_rule__SpecialOpcode__Alternatives3181); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getHWQEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1489:6: ( ( KEYWORD_48 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1489:6: ( ( KEYWORD_48 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1490:1: ( KEYWORD_48 )
                    {
                     before(grammarAccess.getSpecialOpcodeAccess().getHWIEnumLiteralDeclaration_8()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1491:1: ( KEYWORD_48 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1491:3: KEYWORD_48
                    {
                    match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_rule__SpecialOpcode__Alternatives3201); 

                    }

                     after(grammarAccess.getSpecialOpcodeAccess().getHWIEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecialOpcode__Alternatives"


    // $ANTLR start "rule__StandardRegister__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1501:1: rule__StandardRegister__Alternatives : ( ( ( KEYWORD_15 ) ) | ( ( KEYWORD_16 ) ) | ( ( KEYWORD_17 ) ) | ( ( KEYWORD_20 ) ) | ( ( KEYWORD_21 ) ) | ( ( KEYWORD_22 ) ) | ( ( KEYWORD_18 ) ) | ( ( KEYWORD_19 ) ) );
    public final void rule__StandardRegister__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1505:1: ( ( ( KEYWORD_15 ) ) | ( ( KEYWORD_16 ) ) | ( ( KEYWORD_17 ) ) | ( ( KEYWORD_20 ) ) | ( ( KEYWORD_21 ) ) | ( ( KEYWORD_22 ) ) | ( ( KEYWORD_18 ) ) | ( ( KEYWORD_19 ) ) )
            int alt16=8;
            switch ( input.LA(1) ) {
            case KEYWORD_15:
                {
                alt16=1;
                }
                break;
            case KEYWORD_16:
                {
                alt16=2;
                }
                break;
            case KEYWORD_17:
                {
                alt16=3;
                }
                break;
            case KEYWORD_20:
                {
                alt16=4;
                }
                break;
            case KEYWORD_21:
                {
                alt16=5;
                }
                break;
            case KEYWORD_22:
                {
                alt16=6;
                }
                break;
            case KEYWORD_18:
                {
                alt16=7;
                }
                break;
            case KEYWORD_19:
                {
                alt16=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1506:1: ( ( KEYWORD_15 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1506:1: ( ( KEYWORD_15 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1507:1: ( KEYWORD_15 )
                    {
                     before(grammarAccess.getStandardRegisterAccess().getAEnumLiteralDeclaration_0()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1508:1: ( KEYWORD_15 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1508:3: KEYWORD_15
                    {
                    match(input,KEYWORD_15,FOLLOW_KEYWORD_15_in_rule__StandardRegister__Alternatives3236); 

                    }

                     after(grammarAccess.getStandardRegisterAccess().getAEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1513:6: ( ( KEYWORD_16 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1513:6: ( ( KEYWORD_16 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1514:1: ( KEYWORD_16 )
                    {
                     before(grammarAccess.getStandardRegisterAccess().getBEnumLiteralDeclaration_1()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1515:1: ( KEYWORD_16 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1515:3: KEYWORD_16
                    {
                    match(input,KEYWORD_16,FOLLOW_KEYWORD_16_in_rule__StandardRegister__Alternatives3256); 

                    }

                     after(grammarAccess.getStandardRegisterAccess().getBEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1520:6: ( ( KEYWORD_17 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1520:6: ( ( KEYWORD_17 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1521:1: ( KEYWORD_17 )
                    {
                     before(grammarAccess.getStandardRegisterAccess().getCEnumLiteralDeclaration_2()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1522:1: ( KEYWORD_17 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1522:3: KEYWORD_17
                    {
                    match(input,KEYWORD_17,FOLLOW_KEYWORD_17_in_rule__StandardRegister__Alternatives3276); 

                    }

                     after(grammarAccess.getStandardRegisterAccess().getCEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1527:6: ( ( KEYWORD_20 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1527:6: ( ( KEYWORD_20 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1528:1: ( KEYWORD_20 )
                    {
                     before(grammarAccess.getStandardRegisterAccess().getXEnumLiteralDeclaration_3()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1529:1: ( KEYWORD_20 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1529:3: KEYWORD_20
                    {
                    match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_rule__StandardRegister__Alternatives3296); 

                    }

                     after(grammarAccess.getStandardRegisterAccess().getXEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1534:6: ( ( KEYWORD_21 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1534:6: ( ( KEYWORD_21 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1535:1: ( KEYWORD_21 )
                    {
                     before(grammarAccess.getStandardRegisterAccess().getYEnumLiteralDeclaration_4()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1536:1: ( KEYWORD_21 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1536:3: KEYWORD_21
                    {
                    match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_rule__StandardRegister__Alternatives3316); 

                    }

                     after(grammarAccess.getStandardRegisterAccess().getYEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1541:6: ( ( KEYWORD_22 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1541:6: ( ( KEYWORD_22 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1542:1: ( KEYWORD_22 )
                    {
                     before(grammarAccess.getStandardRegisterAccess().getZEnumLiteralDeclaration_5()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1543:1: ( KEYWORD_22 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1543:3: KEYWORD_22
                    {
                    match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_rule__StandardRegister__Alternatives3336); 

                    }

                     after(grammarAccess.getStandardRegisterAccess().getZEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1548:6: ( ( KEYWORD_18 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1548:6: ( ( KEYWORD_18 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1549:1: ( KEYWORD_18 )
                    {
                     before(grammarAccess.getStandardRegisterAccess().getIEnumLiteralDeclaration_6()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1550:1: ( KEYWORD_18 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1550:3: KEYWORD_18
                    {
                    match(input,KEYWORD_18,FOLLOW_KEYWORD_18_in_rule__StandardRegister__Alternatives3356); 

                    }

                     after(grammarAccess.getStandardRegisterAccess().getIEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1555:6: ( ( KEYWORD_19 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1555:6: ( ( KEYWORD_19 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1556:1: ( KEYWORD_19 )
                    {
                     before(grammarAccess.getStandardRegisterAccess().getJEnumLiteralDeclaration_7()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1557:1: ( KEYWORD_19 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1557:3: KEYWORD_19
                    {
                    match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_rule__StandardRegister__Alternatives3376); 

                    }

                     after(grammarAccess.getStandardRegisterAccess().getJEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StandardRegister__Alternatives"


    // $ANTLR start "rule__SpecialRegister__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1567:1: rule__SpecialRegister__Alternatives : ( ( ( KEYWORD_37 ) ) | ( ( KEYWORD_36 ) ) | ( ( KEYWORD_35 ) ) );
    public final void rule__SpecialRegister__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1571:1: ( ( ( KEYWORD_37 ) ) | ( ( KEYWORD_36 ) ) | ( ( KEYWORD_35 ) ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case KEYWORD_37:
                {
                alt17=1;
                }
                break;
            case KEYWORD_36:
                {
                alt17=2;
                }
                break;
            case KEYWORD_35:
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
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1572:1: ( ( KEYWORD_37 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1572:1: ( ( KEYWORD_37 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1573:1: ( KEYWORD_37 )
                    {
                     before(grammarAccess.getSpecialRegisterAccess().getSPEnumLiteralDeclaration_0()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1574:1: ( KEYWORD_37 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1574:3: KEYWORD_37
                    {
                    match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_rule__SpecialRegister__Alternatives3411); 

                    }

                     after(grammarAccess.getSpecialRegisterAccess().getSPEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1579:6: ( ( KEYWORD_36 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1579:6: ( ( KEYWORD_36 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1580:1: ( KEYWORD_36 )
                    {
                     before(grammarAccess.getSpecialRegisterAccess().getPCEnumLiteralDeclaration_1()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1581:1: ( KEYWORD_36 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1581:3: KEYWORD_36
                    {
                    match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_rule__SpecialRegister__Alternatives3431); 

                    }

                     after(grammarAccess.getSpecialRegisterAccess().getPCEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1586:6: ( ( KEYWORD_35 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1586:6: ( ( KEYWORD_35 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1587:1: ( KEYWORD_35 )
                    {
                     before(grammarAccess.getSpecialRegisterAccess().getEXEnumLiteralDeclaration_2()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1588:1: ( KEYWORD_35 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1588:3: KEYWORD_35
                    {
                    match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_rule__SpecialRegister__Alternatives3451); 

                    }

                     after(grammarAccess.getSpecialRegisterAccess().getEXEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecialRegister__Alternatives"


    // $ANTLR start "rule__Operator__Alternatives"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1598:1: rule__Operator__Alternatives : ( ( ( KEYWORD_7 ) ) | ( ( KEYWORD_9 ) ) | ( ( KEYWORD_6 ) ) | ( ( KEYWORD_10 ) ) | ( ( KEYWORD_2 ) ) | ( ( KEYWORD_30 ) ) | ( ( KEYWORD_34 ) ) | ( ( KEYWORD_39 ) ) | ( ( KEYWORD_3 ) ) | ( ( KEYWORD_26 ) ) | ( ( KEYWORD_25 ) ) | ( ( KEYWORD_27 ) ) | ( ( KEYWORD_1 ) ) | ( ( KEYWORD_32 ) ) | ( ( KEYWORD_28 ) ) | ( ( KEYWORD_13 ) ) | ( ( KEYWORD_33 ) ) | ( ( KEYWORD_12 ) ) | ( ( KEYWORD_31 ) ) | ( ( KEYWORD_29 ) ) | ( ( KEYWORD_38 ) ) | ( ( KEYWORD_14 ) ) | ( ( KEYWORD_11 ) ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1602:1: ( ( ( KEYWORD_7 ) ) | ( ( KEYWORD_9 ) ) | ( ( KEYWORD_6 ) ) | ( ( KEYWORD_10 ) ) | ( ( KEYWORD_2 ) ) | ( ( KEYWORD_30 ) ) | ( ( KEYWORD_34 ) ) | ( ( KEYWORD_39 ) ) | ( ( KEYWORD_3 ) ) | ( ( KEYWORD_26 ) ) | ( ( KEYWORD_25 ) ) | ( ( KEYWORD_27 ) ) | ( ( KEYWORD_1 ) ) | ( ( KEYWORD_32 ) ) | ( ( KEYWORD_28 ) ) | ( ( KEYWORD_13 ) ) | ( ( KEYWORD_33 ) ) | ( ( KEYWORD_12 ) ) | ( ( KEYWORD_31 ) ) | ( ( KEYWORD_29 ) ) | ( ( KEYWORD_38 ) ) | ( ( KEYWORD_14 ) ) | ( ( KEYWORD_11 ) ) )
            int alt18=23;
            switch ( input.LA(1) ) {
            case KEYWORD_7:
                {
                alt18=1;
                }
                break;
            case KEYWORD_9:
                {
                alt18=2;
                }
                break;
            case KEYWORD_6:
                {
                alt18=3;
                }
                break;
            case KEYWORD_10:
                {
                alt18=4;
                }
                break;
            case KEYWORD_2:
                {
                alt18=5;
                }
                break;
            case KEYWORD_30:
                {
                alt18=6;
                }
                break;
            case KEYWORD_34:
                {
                alt18=7;
                }
                break;
            case KEYWORD_39:
                {
                alt18=8;
                }
                break;
            case KEYWORD_3:
                {
                alt18=9;
                }
                break;
            case KEYWORD_26:
                {
                alt18=10;
                }
                break;
            case KEYWORD_25:
                {
                alt18=11;
                }
                break;
            case KEYWORD_27:
                {
                alt18=12;
                }
                break;
            case KEYWORD_1:
                {
                alt18=13;
                }
                break;
            case KEYWORD_32:
                {
                alt18=14;
                }
                break;
            case KEYWORD_28:
                {
                alt18=15;
                }
                break;
            case KEYWORD_13:
                {
                alt18=16;
                }
                break;
            case KEYWORD_33:
                {
                alt18=17;
                }
                break;
            case KEYWORD_12:
                {
                alt18=18;
                }
                break;
            case KEYWORD_31:
                {
                alt18=19;
                }
                break;
            case KEYWORD_29:
                {
                alt18=20;
                }
                break;
            case KEYWORD_38:
                {
                alt18=21;
                }
                break;
            case KEYWORD_14:
                {
                alt18=22;
                }
                break;
            case KEYWORD_11:
                {
                alt18=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1603:1: ( ( KEYWORD_7 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1603:1: ( ( KEYWORD_7 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1604:1: ( KEYWORD_7 )
                    {
                     before(grammarAccess.getOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1605:1: ( KEYWORD_7 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1605:3: KEYWORD_7
                    {
                    match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_rule__Operator__Alternatives3486); 

                    }

                     after(grammarAccess.getOperatorAccess().getADDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1610:6: ( ( KEYWORD_9 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1610:6: ( ( KEYWORD_9 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1611:1: ( KEYWORD_9 )
                    {
                     before(grammarAccess.getOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1612:1: ( KEYWORD_9 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1612:3: KEYWORD_9
                    {
                    match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_rule__Operator__Alternatives3506); 

                    }

                     after(grammarAccess.getOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1617:6: ( ( KEYWORD_6 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1617:6: ( ( KEYWORD_6 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1618:1: ( KEYWORD_6 )
                    {
                     before(grammarAccess.getOperatorAccess().getMULTIPLYEnumLiteralDeclaration_2()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1619:1: ( KEYWORD_6 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1619:3: KEYWORD_6
                    {
                    match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_rule__Operator__Alternatives3526); 

                    }

                     after(grammarAccess.getOperatorAccess().getMULTIPLYEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1624:6: ( ( KEYWORD_10 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1624:6: ( ( KEYWORD_10 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1625:1: ( KEYWORD_10 )
                    {
                     before(grammarAccess.getOperatorAccess().getDIVIDEEnumLiteralDeclaration_3()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1626:1: ( KEYWORD_10 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1626:3: KEYWORD_10
                    {
                    match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_rule__Operator__Alternatives3546); 

                    }

                     after(grammarAccess.getOperatorAccess().getDIVIDEEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1631:6: ( ( KEYWORD_2 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1631:6: ( ( KEYWORD_2 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1632:1: ( KEYWORD_2 )
                    {
                     before(grammarAccess.getOperatorAccess().getMODULUSEnumLiteralDeclaration_4()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1633:1: ( KEYWORD_2 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1633:3: KEYWORD_2
                    {
                    match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rule__Operator__Alternatives3566); 

                    }

                     after(grammarAccess.getOperatorAccess().getMODULUSEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1638:6: ( ( KEYWORD_30 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1638:6: ( ( KEYWORD_30 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1639:1: ( KEYWORD_30 )
                    {
                     before(grammarAccess.getOperatorAccess().getLEFT_SHIFTEnumLiteralDeclaration_5()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1640:1: ( KEYWORD_30 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1640:3: KEYWORD_30
                    {
                    match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_rule__Operator__Alternatives3586); 

                    }

                     after(grammarAccess.getOperatorAccess().getLEFT_SHIFTEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1645:6: ( ( KEYWORD_34 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1645:6: ( ( KEYWORD_34 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1646:1: ( KEYWORD_34 )
                    {
                     before(grammarAccess.getOperatorAccess().getARITHMETIC_RIGHT_SHIFTEnumLiteralDeclaration_6()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1647:1: ( KEYWORD_34 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1647:3: KEYWORD_34
                    {
                    match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_rule__Operator__Alternatives3606); 

                    }

                     after(grammarAccess.getOperatorAccess().getARITHMETIC_RIGHT_SHIFTEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1652:6: ( ( KEYWORD_39 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1652:6: ( ( KEYWORD_39 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1653:1: ( KEYWORD_39 )
                    {
                     before(grammarAccess.getOperatorAccess().getLOGICAL_RIGHT_SHIFTEnumLiteralDeclaration_7()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1654:1: ( KEYWORD_39 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1654:3: KEYWORD_39
                    {
                    match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_rule__Operator__Alternatives3626); 

                    }

                     after(grammarAccess.getOperatorAccess().getLOGICAL_RIGHT_SHIFTEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1659:6: ( ( KEYWORD_3 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1659:6: ( ( KEYWORD_3 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1660:1: ( KEYWORD_3 )
                    {
                     before(grammarAccess.getOperatorAccess().getBITWISE_ANDEnumLiteralDeclaration_8()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1661:1: ( KEYWORD_3 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1661:3: KEYWORD_3
                    {
                    match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_rule__Operator__Alternatives3646); 

                    }

                     after(grammarAccess.getOperatorAccess().getBITWISE_ANDEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1666:6: ( ( KEYWORD_26 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1666:6: ( ( KEYWORD_26 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1667:1: ( KEYWORD_26 )
                    {
                     before(grammarAccess.getOperatorAccess().getBITWISE_OREnumLiteralDeclaration_9()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1668:1: ( KEYWORD_26 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1668:3: KEYWORD_26
                    {
                    match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_rule__Operator__Alternatives3666); 

                    }

                     after(grammarAccess.getOperatorAccess().getBITWISE_OREnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1673:6: ( ( KEYWORD_25 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1673:6: ( ( KEYWORD_25 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1674:1: ( KEYWORD_25 )
                    {
                     before(grammarAccess.getOperatorAccess().getBITWISE_XOREnumLiteralDeclaration_10()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1675:1: ( KEYWORD_25 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1675:3: KEYWORD_25
                    {
                    match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_rule__Operator__Alternatives3686); 

                    }

                     after(grammarAccess.getOperatorAccess().getBITWISE_XOREnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1680:6: ( ( KEYWORD_27 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1680:6: ( ( KEYWORD_27 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1681:1: ( KEYWORD_27 )
                    {
                     before(grammarAccess.getOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_11()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1682:1: ( KEYWORD_27 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1682:3: KEYWORD_27
                    {
                    match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_rule__Operator__Alternatives3706); 

                    }

                     after(grammarAccess.getOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1687:6: ( ( KEYWORD_1 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1687:6: ( ( KEYWORD_1 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1688:1: ( KEYWORD_1 )
                    {
                     before(grammarAccess.getOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_12()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1689:1: ( KEYWORD_1 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1689:3: KEYWORD_1
                    {
                    match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_rule__Operator__Alternatives3726); 

                    }

                     after(grammarAccess.getOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1694:6: ( ( KEYWORD_32 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1694:6: ( ( KEYWORD_32 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1695:1: ( KEYWORD_32 )
                    {
                     before(grammarAccess.getOperatorAccess().getEQUALEnumLiteralDeclaration_13()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1696:1: ( KEYWORD_32 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1696:3: KEYWORD_32
                    {
                    match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_rule__Operator__Alternatives3746); 

                    }

                     after(grammarAccess.getOperatorAccess().getEQUALEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1701:6: ( ( KEYWORD_28 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1701:6: ( ( KEYWORD_28 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1702:1: ( KEYWORD_28 )
                    {
                     before(grammarAccess.getOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_14()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1703:1: ( KEYWORD_28 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1703:3: KEYWORD_28
                    {
                    match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_rule__Operator__Alternatives3766); 

                    }

                     after(grammarAccess.getOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1708:6: ( ( KEYWORD_13 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1708:6: ( ( KEYWORD_13 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1709:1: ( KEYWORD_13 )
                    {
                     before(grammarAccess.getOperatorAccess().getGREATEREnumLiteralDeclaration_15()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1710:1: ( KEYWORD_13 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1710:3: KEYWORD_13
                    {
                    match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_rule__Operator__Alternatives3786); 

                    }

                     after(grammarAccess.getOperatorAccess().getGREATEREnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1715:6: ( ( KEYWORD_33 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1715:6: ( ( KEYWORD_33 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1716:1: ( KEYWORD_33 )
                    {
                     before(grammarAccess.getOperatorAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_16()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1717:1: ( KEYWORD_33 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1717:3: KEYWORD_33
                    {
                    match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_rule__Operator__Alternatives3806); 

                    }

                     after(grammarAccess.getOperatorAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1722:6: ( ( KEYWORD_12 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1722:6: ( ( KEYWORD_12 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1723:1: ( KEYWORD_12 )
                    {
                     before(grammarAccess.getOperatorAccess().getLESSEnumLiteralDeclaration_17()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1724:1: ( KEYWORD_12 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1724:3: KEYWORD_12
                    {
                    match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_rule__Operator__Alternatives3826); 

                    }

                     after(grammarAccess.getOperatorAccess().getLESSEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1729:6: ( ( KEYWORD_31 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1729:6: ( ( KEYWORD_31 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1730:1: ( KEYWORD_31 )
                    {
                     before(grammarAccess.getOperatorAccess().getLESS_OR_EQUALEnumLiteralDeclaration_18()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1731:1: ( KEYWORD_31 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1731:3: KEYWORD_31
                    {
                    match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_rule__Operator__Alternatives3846); 

                    }

                     after(grammarAccess.getOperatorAccess().getLESS_OR_EQUALEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1736:6: ( ( KEYWORD_29 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1736:6: ( ( KEYWORD_29 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1737:1: ( KEYWORD_29 )
                    {
                     before(grammarAccess.getOperatorAccess().getLOGICAL_ANDEnumLiteralDeclaration_19()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1738:1: ( KEYWORD_29 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1738:3: KEYWORD_29
                    {
                    match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_rule__Operator__Alternatives3866); 

                    }

                     after(grammarAccess.getOperatorAccess().getLOGICAL_ANDEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1743:6: ( ( KEYWORD_38 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1743:6: ( ( KEYWORD_38 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1744:1: ( KEYWORD_38 )
                    {
                     before(grammarAccess.getOperatorAccess().getLOGICAL_OREnumLiteralDeclaration_20()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1745:1: ( KEYWORD_38 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1745:3: KEYWORD_38
                    {
                    match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_rule__Operator__Alternatives3886); 

                    }

                     after(grammarAccess.getOperatorAccess().getLOGICAL_OREnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1750:6: ( ( KEYWORD_14 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1750:6: ( ( KEYWORD_14 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1751:1: ( KEYWORD_14 )
                    {
                     before(grammarAccess.getOperatorAccess().getCONDITIONAL_TRUEEnumLiteralDeclaration_21()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1752:1: ( KEYWORD_14 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1752:3: KEYWORD_14
                    {
                    match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_rule__Operator__Alternatives3906); 

                    }

                     after(grammarAccess.getOperatorAccess().getCONDITIONAL_TRUEEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1757:6: ( ( KEYWORD_11 ) )
                    {
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1757:6: ( ( KEYWORD_11 ) )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1758:1: ( KEYWORD_11 )
                    {
                     before(grammarAccess.getOperatorAccess().getCONDITIONAL_FALSEEnumLiteralDeclaration_22()); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1759:1: ( KEYWORD_11 )
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1759:3: KEYWORD_11
                    {
                    match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_rule__Operator__Alternatives3926); 

                    }

                     after(grammarAccess.getOperatorAccess().getCONDITIONAL_FALSEEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1771:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1775:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1776:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__03958);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__03961);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1783:1: rule__Model__Group__0__Impl : ( ruleLineDefinition ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1787:1: ( ( ruleLineDefinition ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1788:1: ( ruleLineDefinition )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1788:1: ( ruleLineDefinition )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1789:1: ruleLineDefinition
            {
             before(grammarAccess.getModelAccess().getLineDefinitionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleLineDefinition_in_rule__Model__Group__0__Impl3988);
            ruleLineDefinition();

            state._fsp--;

             after(grammarAccess.getModelAccess().getLineDefinitionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1800:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1804:1: ( rule__Model__Group__1__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1805:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14017);
            rule__Model__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1811:1: rule__Model__Group__1__Impl : ( ( rule__Model__Group_1__0 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1815:1: ( ( ( rule__Model__Group_1__0 )? ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1816:1: ( ( rule__Model__Group_1__0 )? )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1816:1: ( ( rule__Model__Group_1__0 )? )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1817:1: ( rule__Model__Group_1__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1818:1: ( rule__Model__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_NL) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1818:2: rule__Model__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl4044);
                    rule__Model__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1832:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1836:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1837:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__04079);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__04082);
            rule__Model__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1844:1: rule__Model__Group_1__0__Impl : ( () ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1848:1: ( ( () ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1849:1: ( () )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1849:1: ( () )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1850:1: ()
            {
             before(grammarAccess.getModelAccess().getOperationLeftAction_1_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1851:1: ()
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1853:1: 
            {
            }

             after(grammarAccess.getModelAccess().getOperationLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1863:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl rule__Model__Group_1__2 ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1867:1: ( rule__Model__Group_1__1__Impl rule__Model__Group_1__2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1868:2: rule__Model__Group_1__1__Impl rule__Model__Group_1__2
            {
            pushFollow(FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__14140);
            rule__Model__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_1__2_in_rule__Model__Group_1__14143);
            rule__Model__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1875:1: rule__Model__Group_1__1__Impl : ( RULE_NL ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1879:1: ( ( RULE_NL ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1880:1: ( RULE_NL )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1880:1: ( RULE_NL )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1881:1: RULE_NL
            {
             before(grammarAccess.getModelAccess().getNLTerminalRuleCall_1_1()); 
            match(input,RULE_NL,FOLLOW_RULE_NL_in_rule__Model__Group_1__1__Impl4170); 
             after(grammarAccess.getModelAccess().getNLTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__Model__Group_1__2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1892:1: rule__Model__Group_1__2 : rule__Model__Group_1__2__Impl ;
    public final void rule__Model__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1896:1: ( rule__Model__Group_1__2__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1897:2: rule__Model__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_1__2__Impl_in_rule__Model__Group_1__24199);
            rule__Model__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__2"


    // $ANTLR start "rule__Model__Group_1__2__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1903:1: rule__Model__Group_1__2__Impl : ( ( rule__Model__RightAssignment_1_2 ) ) ;
    public final void rule__Model__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1907:1: ( ( ( rule__Model__RightAssignment_1_2 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1908:1: ( ( rule__Model__RightAssignment_1_2 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1908:1: ( ( rule__Model__RightAssignment_1_2 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1909:1: ( rule__Model__RightAssignment_1_2 )
            {
             before(grammarAccess.getModelAccess().getRightAssignment_1_2()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1910:1: ( rule__Model__RightAssignment_1_2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1910:2: rule__Model__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Model__RightAssignment_1_2_in_rule__Model__Group_1__2__Impl4226);
            rule__Model__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__2__Impl"


    // $ANTLR start "rule__LineDefinition__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1926:1: rule__LineDefinition__Group__0 : rule__LineDefinition__Group__0__Impl rule__LineDefinition__Group__1 ;
    public final void rule__LineDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1930:1: ( rule__LineDefinition__Group__0__Impl rule__LineDefinition__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1931:2: rule__LineDefinition__Group__0__Impl rule__LineDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__LineDefinition__Group__0__Impl_in_rule__LineDefinition__Group__04262);
            rule__LineDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LineDefinition__Group__1_in_rule__LineDefinition__Group__04265);
            rule__LineDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__Group__0"


    // $ANTLR start "rule__LineDefinition__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1938:1: rule__LineDefinition__Group__0__Impl : ( ( rule__LineDefinition__LabelsAssignment_0 )* ) ;
    public final void rule__LineDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1942:1: ( ( ( rule__LineDefinition__LabelsAssignment_0 )* ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1943:1: ( ( rule__LineDefinition__LabelsAssignment_0 )* )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1943:1: ( ( rule__LineDefinition__LabelsAssignment_0 )* )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1944:1: ( rule__LineDefinition__LabelsAssignment_0 )*
            {
             before(grammarAccess.getLineDefinitionAccess().getLabelsAssignment_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1945:1: ( rule__LineDefinition__LabelsAssignment_0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==KEYWORD_11) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1945:2: rule__LineDefinition__LabelsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__LineDefinition__LabelsAssignment_0_in_rule__LineDefinition__Group__0__Impl4292);
            	    rule__LineDefinition__LabelsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getLineDefinitionAccess().getLabelsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__Group__0__Impl"


    // $ANTLR start "rule__LineDefinition__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1955:1: rule__LineDefinition__Group__1 : rule__LineDefinition__Group__1__Impl rule__LineDefinition__Group__2 ;
    public final void rule__LineDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1959:1: ( rule__LineDefinition__Group__1__Impl rule__LineDefinition__Group__2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1960:2: rule__LineDefinition__Group__1__Impl rule__LineDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__LineDefinition__Group__1__Impl_in_rule__LineDefinition__Group__14323);
            rule__LineDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LineDefinition__Group__2_in_rule__LineDefinition__Group__14326);
            rule__LineDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__Group__1"


    // $ANTLR start "rule__LineDefinition__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1967:1: rule__LineDefinition__Group__1__Impl : ( ( rule__LineDefinition__ContentAssignment_1 )? ) ;
    public final void rule__LineDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1971:1: ( ( ( rule__LineDefinition__ContentAssignment_1 )? ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1972:1: ( ( rule__LineDefinition__ContentAssignment_1 )? )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1972:1: ( ( rule__LineDefinition__ContentAssignment_1 )? )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1973:1: ( rule__LineDefinition__ContentAssignment_1 )?
            {
             before(grammarAccess.getLineDefinitionAccess().getContentAssignment_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1974:1: ( rule__LineDefinition__ContentAssignment_1 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=KEYWORD_87 && LA21_0<=KEYWORD_78)||(LA21_0>=KEYWORD_40 && LA21_0<=KEYWORD_67)||(LA21_0>=KEYWORD_69 && LA21_0<=KEYWORD_77)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1974:2: rule__LineDefinition__ContentAssignment_1
                    {
                    pushFollow(FOLLOW_rule__LineDefinition__ContentAssignment_1_in_rule__LineDefinition__Group__1__Impl4353);
                    rule__LineDefinition__ContentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLineDefinitionAccess().getContentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__Group__1__Impl"


    // $ANTLR start "rule__LineDefinition__Group__2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1984:1: rule__LineDefinition__Group__2 : rule__LineDefinition__Group__2__Impl ;
    public final void rule__LineDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1988:1: ( rule__LineDefinition__Group__2__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1989:2: rule__LineDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LineDefinition__Group__2__Impl_in_rule__LineDefinition__Group__24384);
            rule__LineDefinition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__Group__2"


    // $ANTLR start "rule__LineDefinition__Group__2__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1995:1: rule__LineDefinition__Group__2__Impl : ( ( rule__LineDefinition__CommentAssignment_2 )? ) ;
    public final void rule__LineDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:1999:1: ( ( ( rule__LineDefinition__CommentAssignment_2 )? ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2000:1: ( ( rule__LineDefinition__CommentAssignment_2 )? )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2000:1: ( ( rule__LineDefinition__CommentAssignment_2 )? )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2001:1: ( rule__LineDefinition__CommentAssignment_2 )?
            {
             before(grammarAccess.getLineDefinitionAccess().getCommentAssignment_2()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2002:1: ( rule__LineDefinition__CommentAssignment_2 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_SL_COMMENT) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2002:2: rule__LineDefinition__CommentAssignment_2
                    {
                    pushFollow(FOLLOW_rule__LineDefinition__CommentAssignment_2_in_rule__LineDefinition__Group__2__Impl4411);
                    rule__LineDefinition__CommentAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLineDefinitionAccess().getCommentAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__Group__2__Impl"


    // $ANTLR start "rule__OriginDirective__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2018:1: rule__OriginDirective__Group__0 : rule__OriginDirective__Group__0__Impl rule__OriginDirective__Group__1 ;
    public final void rule__OriginDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2022:1: ( rule__OriginDirective__Group__0__Impl rule__OriginDirective__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2023:2: rule__OriginDirective__Group__0__Impl rule__OriginDirective__Group__1
            {
            pushFollow(FOLLOW_rule__OriginDirective__Group__0__Impl_in_rule__OriginDirective__Group__04448);
            rule__OriginDirective__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OriginDirective__Group__1_in_rule__OriginDirective__Group__04451);
            rule__OriginDirective__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OriginDirective__Group__0"


    // $ANTLR start "rule__OriginDirective__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2030:1: rule__OriginDirective__Group__0__Impl : ( ( rule__OriginDirective__Alternatives_0 ) ) ;
    public final void rule__OriginDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2034:1: ( ( ( rule__OriginDirective__Alternatives_0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2035:1: ( ( rule__OriginDirective__Alternatives_0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2035:1: ( ( rule__OriginDirective__Alternatives_0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2036:1: ( rule__OriginDirective__Alternatives_0 )
            {
             before(grammarAccess.getOriginDirectiveAccess().getAlternatives_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2037:1: ( rule__OriginDirective__Alternatives_0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2037:2: rule__OriginDirective__Alternatives_0
            {
            pushFollow(FOLLOW_rule__OriginDirective__Alternatives_0_in_rule__OriginDirective__Group__0__Impl4478);
            rule__OriginDirective__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getOriginDirectiveAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OriginDirective__Group__0__Impl"


    // $ANTLR start "rule__OriginDirective__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2047:1: rule__OriginDirective__Group__1 : rule__OriginDirective__Group__1__Impl ;
    public final void rule__OriginDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2051:1: ( rule__OriginDirective__Group__1__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2052:2: rule__OriginDirective__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__OriginDirective__Group__1__Impl_in_rule__OriginDirective__Group__14508);
            rule__OriginDirective__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OriginDirective__Group__1"


    // $ANTLR start "rule__OriginDirective__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2058:1: rule__OriginDirective__Group__1__Impl : ( ( rule__OriginDirective__ValueAssignment_1 ) ) ;
    public final void rule__OriginDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2062:1: ( ( ( rule__OriginDirective__ValueAssignment_1 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2063:1: ( ( rule__OriginDirective__ValueAssignment_1 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2063:1: ( ( rule__OriginDirective__ValueAssignment_1 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2064:1: ( rule__OriginDirective__ValueAssignment_1 )
            {
             before(grammarAccess.getOriginDirectiveAccess().getValueAssignment_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2065:1: ( rule__OriginDirective__ValueAssignment_1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2065:2: rule__OriginDirective__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__OriginDirective__ValueAssignment_1_in_rule__OriginDirective__Group__1__Impl4535);
            rule__OriginDirective__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOriginDirectiveAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OriginDirective__Group__1__Impl"


    // $ANTLR start "rule__IncludeDirective__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2079:1: rule__IncludeDirective__Group__0 : rule__IncludeDirective__Group__0__Impl rule__IncludeDirective__Group__1 ;
    public final void rule__IncludeDirective__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2083:1: ( rule__IncludeDirective__Group__0__Impl rule__IncludeDirective__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2084:2: rule__IncludeDirective__Group__0__Impl rule__IncludeDirective__Group__1
            {
            pushFollow(FOLLOW_rule__IncludeDirective__Group__0__Impl_in_rule__IncludeDirective__Group__04569);
            rule__IncludeDirective__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IncludeDirective__Group__1_in_rule__IncludeDirective__Group__04572);
            rule__IncludeDirective__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__0"


    // $ANTLR start "rule__IncludeDirective__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2091:1: rule__IncludeDirective__Group__0__Impl : ( ( rule__IncludeDirective__Alternatives_0 ) ) ;
    public final void rule__IncludeDirective__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2095:1: ( ( ( rule__IncludeDirective__Alternatives_0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2096:1: ( ( rule__IncludeDirective__Alternatives_0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2096:1: ( ( rule__IncludeDirective__Alternatives_0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2097:1: ( rule__IncludeDirective__Alternatives_0 )
            {
             before(grammarAccess.getIncludeDirectiveAccess().getAlternatives_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2098:1: ( rule__IncludeDirective__Alternatives_0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2098:2: rule__IncludeDirective__Alternatives_0
            {
            pushFollow(FOLLOW_rule__IncludeDirective__Alternatives_0_in_rule__IncludeDirective__Group__0__Impl4599);
            rule__IncludeDirective__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getIncludeDirectiveAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__0__Impl"


    // $ANTLR start "rule__IncludeDirective__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2108:1: rule__IncludeDirective__Group__1 : rule__IncludeDirective__Group__1__Impl ;
    public final void rule__IncludeDirective__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2112:1: ( rule__IncludeDirective__Group__1__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2113:2: rule__IncludeDirective__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IncludeDirective__Group__1__Impl_in_rule__IncludeDirective__Group__14629);
            rule__IncludeDirective__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__1"


    // $ANTLR start "rule__IncludeDirective__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2119:1: rule__IncludeDirective__Group__1__Impl : ( ( rule__IncludeDirective__NameAssignment_1 ) ) ;
    public final void rule__IncludeDirective__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2123:1: ( ( ( rule__IncludeDirective__NameAssignment_1 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2124:1: ( ( rule__IncludeDirective__NameAssignment_1 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2124:1: ( ( rule__IncludeDirective__NameAssignment_1 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2125:1: ( rule__IncludeDirective__NameAssignment_1 )
            {
             before(grammarAccess.getIncludeDirectiveAccess().getNameAssignment_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2126:1: ( rule__IncludeDirective__NameAssignment_1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2126:2: rule__IncludeDirective__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IncludeDirective__NameAssignment_1_in_rule__IncludeDirective__Group__1__Impl4656);
            rule__IncludeDirective__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIncludeDirectiveAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__Group__1__Impl"


    // $ANTLR start "rule__DataLine__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2140:1: rule__DataLine__Group__0 : rule__DataLine__Group__0__Impl rule__DataLine__Group__1 ;
    public final void rule__DataLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2144:1: ( rule__DataLine__Group__0__Impl rule__DataLine__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2145:2: rule__DataLine__Group__0__Impl rule__DataLine__Group__1
            {
            pushFollow(FOLLOW_rule__DataLine__Group__0__Impl_in_rule__DataLine__Group__04690);
            rule__DataLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DataLine__Group__1_in_rule__DataLine__Group__04693);
            rule__DataLine__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group__0"


    // $ANTLR start "rule__DataLine__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2152:1: rule__DataLine__Group__0__Impl : ( ( rule__DataLine__Alternatives_0 ) ) ;
    public final void rule__DataLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2156:1: ( ( ( rule__DataLine__Alternatives_0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2157:1: ( ( rule__DataLine__Alternatives_0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2157:1: ( ( rule__DataLine__Alternatives_0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2158:1: ( rule__DataLine__Alternatives_0 )
            {
             before(grammarAccess.getDataLineAccess().getAlternatives_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2159:1: ( rule__DataLine__Alternatives_0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2159:2: rule__DataLine__Alternatives_0
            {
            pushFollow(FOLLOW_rule__DataLine__Alternatives_0_in_rule__DataLine__Group__0__Impl4720);
            rule__DataLine__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getDataLineAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group__0__Impl"


    // $ANTLR start "rule__DataLine__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2169:1: rule__DataLine__Group__1 : rule__DataLine__Group__1__Impl ;
    public final void rule__DataLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2173:1: ( rule__DataLine__Group__1__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2174:2: rule__DataLine__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DataLine__Group__1__Impl_in_rule__DataLine__Group__14750);
            rule__DataLine__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group__1"


    // $ANTLR start "rule__DataLine__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2180:1: rule__DataLine__Group__1__Impl : ( ( ( rule__DataLine__Group_1__0 ) ) ( ( rule__DataLine__Group_1__0 )* ) ) ;
    public final void rule__DataLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2184:1: ( ( ( ( rule__DataLine__Group_1__0 ) ) ( ( rule__DataLine__Group_1__0 )* ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2185:1: ( ( ( rule__DataLine__Group_1__0 ) ) ( ( rule__DataLine__Group_1__0 )* ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2185:1: ( ( ( rule__DataLine__Group_1__0 ) ) ( ( rule__DataLine__Group_1__0 )* ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2186:1: ( ( rule__DataLine__Group_1__0 ) ) ( ( rule__DataLine__Group_1__0 )* )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2186:1: ( ( rule__DataLine__Group_1__0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2187:1: ( rule__DataLine__Group_1__0 )
            {
             before(grammarAccess.getDataLineAccess().getGroup_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2188:1: ( rule__DataLine__Group_1__0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2188:2: rule__DataLine__Group_1__0
            {
            pushFollow(FOLLOW_rule__DataLine__Group_1__0_in_rule__DataLine__Group__1__Impl4779);
            rule__DataLine__Group_1__0();

            state._fsp--;


            }

             after(grammarAccess.getDataLineAccess().getGroup_1()); 

            }

            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2191:1: ( ( rule__DataLine__Group_1__0 )* )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2192:1: ( rule__DataLine__Group_1__0 )*
            {
             before(grammarAccess.getDataLineAccess().getGroup_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2193:1: ( rule__DataLine__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==KEYWORD_8||(LA23_0>=RULE_HEXNUMBER && LA23_0<=RULE_BINNUMBER)||LA23_0==RULE_STRING) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2193:2: rule__DataLine__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__DataLine__Group_1__0_in_rule__DataLine__Group__1__Impl4791);
            	    rule__DataLine__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getDataLineAccess().getGroup_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group__1__Impl"


    // $ANTLR start "rule__DataLine__Group_1__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2208:1: rule__DataLine__Group_1__0 : rule__DataLine__Group_1__0__Impl rule__DataLine__Group_1__1 ;
    public final void rule__DataLine__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2212:1: ( rule__DataLine__Group_1__0__Impl rule__DataLine__Group_1__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2213:2: rule__DataLine__Group_1__0__Impl rule__DataLine__Group_1__1
            {
            pushFollow(FOLLOW_rule__DataLine__Group_1__0__Impl_in_rule__DataLine__Group_1__04828);
            rule__DataLine__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DataLine__Group_1__1_in_rule__DataLine__Group_1__04831);
            rule__DataLine__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group_1__0"


    // $ANTLR start "rule__DataLine__Group_1__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2220:1: rule__DataLine__Group_1__0__Impl : ( ( KEYWORD_8 )* ) ;
    public final void rule__DataLine__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2224:1: ( ( ( KEYWORD_8 )* ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2225:1: ( ( KEYWORD_8 )* )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2225:1: ( ( KEYWORD_8 )* )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2226:1: ( KEYWORD_8 )*
            {
             before(grammarAccess.getDataLineAccess().getCommaKeyword_1_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2227:1: ( KEYWORD_8 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==KEYWORD_8) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2228:2: KEYWORD_8
            	    {
            	    match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_rule__DataLine__Group_1__0__Impl4860); 

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getDataLineAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group_1__0__Impl"


    // $ANTLR start "rule__DataLine__Group_1__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2239:1: rule__DataLine__Group_1__1 : rule__DataLine__Group_1__1__Impl rule__DataLine__Group_1__2 ;
    public final void rule__DataLine__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2243:1: ( rule__DataLine__Group_1__1__Impl rule__DataLine__Group_1__2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2244:2: rule__DataLine__Group_1__1__Impl rule__DataLine__Group_1__2
            {
            pushFollow(FOLLOW_rule__DataLine__Group_1__1__Impl_in_rule__DataLine__Group_1__14893);
            rule__DataLine__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DataLine__Group_1__2_in_rule__DataLine__Group_1__14896);
            rule__DataLine__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group_1__1"


    // $ANTLR start "rule__DataLine__Group_1__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2251:1: rule__DataLine__Group_1__1__Impl : ( ( rule__DataLine__DataElementsAssignment_1_1 ) ) ;
    public final void rule__DataLine__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2255:1: ( ( ( rule__DataLine__DataElementsAssignment_1_1 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2256:1: ( ( rule__DataLine__DataElementsAssignment_1_1 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2256:1: ( ( rule__DataLine__DataElementsAssignment_1_1 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2257:1: ( rule__DataLine__DataElementsAssignment_1_1 )
            {
             before(grammarAccess.getDataLineAccess().getDataElementsAssignment_1_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2258:1: ( rule__DataLine__DataElementsAssignment_1_1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2258:2: rule__DataLine__DataElementsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DataLine__DataElementsAssignment_1_1_in_rule__DataLine__Group_1__1__Impl4923);
            rule__DataLine__DataElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDataLineAccess().getDataElementsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group_1__1__Impl"


    // $ANTLR start "rule__DataLine__Group_1__2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2268:1: rule__DataLine__Group_1__2 : rule__DataLine__Group_1__2__Impl ;
    public final void rule__DataLine__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2272:1: ( rule__DataLine__Group_1__2__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2273:2: rule__DataLine__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__DataLine__Group_1__2__Impl_in_rule__DataLine__Group_1__24953);
            rule__DataLine__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group_1__2"


    // $ANTLR start "rule__DataLine__Group_1__2__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2279:1: rule__DataLine__Group_1__2__Impl : ( ( KEYWORD_8 )* ) ;
    public final void rule__DataLine__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2283:1: ( ( ( KEYWORD_8 )* ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2284:1: ( ( KEYWORD_8 )* )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2284:1: ( ( KEYWORD_8 )* )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2285:1: ( KEYWORD_8 )*
            {
             before(grammarAccess.getDataLineAccess().getCommaKeyword_1_2()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2286:1: ( KEYWORD_8 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==KEYWORD_8) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2287:2: KEYWORD_8
            	    {
            	    match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_rule__DataLine__Group_1__2__Impl4982); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getDataLineAccess().getCommaKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__Group_1__2__Impl"


    // $ANTLR start "rule__LiteralExpression__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2304:1: rule__LiteralExpression__Group__0 : rule__LiteralExpression__Group__0__Impl rule__LiteralExpression__Group__1 ;
    public final void rule__LiteralExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2308:1: ( rule__LiteralExpression__Group__0__Impl rule__LiteralExpression__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2309:2: rule__LiteralExpression__Group__0__Impl rule__LiteralExpression__Group__1
            {
            pushFollow(FOLLOW_rule__LiteralExpression__Group__0__Impl_in_rule__LiteralExpression__Group__05021);
            rule__LiteralExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralExpression__Group__1_in_rule__LiteralExpression__Group__05024);
            rule__LiteralExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group__0"


    // $ANTLR start "rule__LiteralExpression__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2316:1: rule__LiteralExpression__Group__0__Impl : ( ruleTerminalExpression ) ;
    public final void rule__LiteralExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2320:1: ( ( ruleTerminalExpression ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2321:1: ( ruleTerminalExpression )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2321:1: ( ruleTerminalExpression )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2322:1: ruleTerminalExpression
            {
             before(grammarAccess.getLiteralExpressionAccess().getTerminalExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleTerminalExpression_in_rule__LiteralExpression__Group__0__Impl5051);
            ruleTerminalExpression();

            state._fsp--;

             after(grammarAccess.getLiteralExpressionAccess().getTerminalExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group__0__Impl"


    // $ANTLR start "rule__LiteralExpression__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2333:1: rule__LiteralExpression__Group__1 : rule__LiteralExpression__Group__1__Impl ;
    public final void rule__LiteralExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2337:1: ( rule__LiteralExpression__Group__1__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2338:2: rule__LiteralExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LiteralExpression__Group__1__Impl_in_rule__LiteralExpression__Group__15080);
            rule__LiteralExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group__1"


    // $ANTLR start "rule__LiteralExpression__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2344:1: rule__LiteralExpression__Group__1__Impl : ( ( rule__LiteralExpression__Group_1__0 )? ) ;
    public final void rule__LiteralExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2348:1: ( ( ( rule__LiteralExpression__Group_1__0 )? ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2349:1: ( ( rule__LiteralExpression__Group_1__0 )? )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2349:1: ( ( rule__LiteralExpression__Group_1__0 )? )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2350:1: ( rule__LiteralExpression__Group_1__0 )?
            {
             before(grammarAccess.getLiteralExpressionAccess().getGroup_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2351:1: ( rule__LiteralExpression__Group_1__0 )?
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2351:2: rule__LiteralExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__LiteralExpression__Group_1__0_in_rule__LiteralExpression__Group__1__Impl5107);
                    rule__LiteralExpression__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLiteralExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group__1__Impl"


    // $ANTLR start "rule__LiteralExpression__Group_1__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2365:1: rule__LiteralExpression__Group_1__0 : rule__LiteralExpression__Group_1__0__Impl rule__LiteralExpression__Group_1__1 ;
    public final void rule__LiteralExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2369:1: ( rule__LiteralExpression__Group_1__0__Impl rule__LiteralExpression__Group_1__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2370:2: rule__LiteralExpression__Group_1__0__Impl rule__LiteralExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__LiteralExpression__Group_1__0__Impl_in_rule__LiteralExpression__Group_1__05142);
            rule__LiteralExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralExpression__Group_1__1_in_rule__LiteralExpression__Group_1__05145);
            rule__LiteralExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group_1__0"


    // $ANTLR start "rule__LiteralExpression__Group_1__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2377:1: rule__LiteralExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__LiteralExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2381:1: ( ( () ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2382:1: ( () )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2382:1: ( () )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2383:1: ()
            {
             before(grammarAccess.getLiteralExpressionAccess().getOperationLeftAction_1_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2384:1: ()
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2386:1: 
            {
            }

             after(grammarAccess.getLiteralExpressionAccess().getOperationLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group_1__0__Impl"


    // $ANTLR start "rule__LiteralExpression__Group_1__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2396:1: rule__LiteralExpression__Group_1__1 : rule__LiteralExpression__Group_1__1__Impl rule__LiteralExpression__Group_1__2 ;
    public final void rule__LiteralExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2400:1: ( rule__LiteralExpression__Group_1__1__Impl rule__LiteralExpression__Group_1__2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2401:2: rule__LiteralExpression__Group_1__1__Impl rule__LiteralExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__LiteralExpression__Group_1__1__Impl_in_rule__LiteralExpression__Group_1__15203);
            rule__LiteralExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralExpression__Group_1__2_in_rule__LiteralExpression__Group_1__15206);
            rule__LiteralExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group_1__1"


    // $ANTLR start "rule__LiteralExpression__Group_1__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2408:1: rule__LiteralExpression__Group_1__1__Impl : ( ( rule__LiteralExpression__OpAssignment_1_1 ) ) ;
    public final void rule__LiteralExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2412:1: ( ( ( rule__LiteralExpression__OpAssignment_1_1 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2413:1: ( ( rule__LiteralExpression__OpAssignment_1_1 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2413:1: ( ( rule__LiteralExpression__OpAssignment_1_1 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2414:1: ( rule__LiteralExpression__OpAssignment_1_1 )
            {
             before(grammarAccess.getLiteralExpressionAccess().getOpAssignment_1_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2415:1: ( rule__LiteralExpression__OpAssignment_1_1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2415:2: rule__LiteralExpression__OpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LiteralExpression__OpAssignment_1_1_in_rule__LiteralExpression__Group_1__1__Impl5233);
            rule__LiteralExpression__OpAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralExpressionAccess().getOpAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group_1__1__Impl"


    // $ANTLR start "rule__LiteralExpression__Group_1__2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2425:1: rule__LiteralExpression__Group_1__2 : rule__LiteralExpression__Group_1__2__Impl ;
    public final void rule__LiteralExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2429:1: ( rule__LiteralExpression__Group_1__2__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2430:2: rule__LiteralExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LiteralExpression__Group_1__2__Impl_in_rule__LiteralExpression__Group_1__25263);
            rule__LiteralExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group_1__2"


    // $ANTLR start "rule__LiteralExpression__Group_1__2__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2436:1: rule__LiteralExpression__Group_1__2__Impl : ( ( rule__LiteralExpression__RightAssignment_1_2 ) ) ;
    public final void rule__LiteralExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2440:1: ( ( ( rule__LiteralExpression__RightAssignment_1_2 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2441:1: ( ( rule__LiteralExpression__RightAssignment_1_2 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2441:1: ( ( rule__LiteralExpression__RightAssignment_1_2 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2442:1: ( rule__LiteralExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getLiteralExpressionAccess().getRightAssignment_1_2()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2443:1: ( rule__LiteralExpression__RightAssignment_1_2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2443:2: rule__LiteralExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__LiteralExpression__RightAssignment_1_2_in_rule__LiteralExpression__Group_1__2__Impl5290);
            rule__LiteralExpression__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getLiteralExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Group_1__2__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_0__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2459:1: rule__TerminalExpression__Group_0__0 : rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1 ;
    public final void rule__TerminalExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2463:1: ( rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2464:2: rule__TerminalExpression__Group_0__0__Impl rule__TerminalExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__TerminalExpression__Group_0__0__Impl_in_rule__TerminalExpression__Group_0__05326);
            rule__TerminalExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TerminalExpression__Group_0__1_in_rule__TerminalExpression__Group_0__05329);
            rule__TerminalExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__0"


    // $ANTLR start "rule__TerminalExpression__Group_0__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2471:1: rule__TerminalExpression__Group_0__0__Impl : ( KEYWORD_4 ) ;
    public final void rule__TerminalExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2475:1: ( ( KEYWORD_4 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2476:1: ( KEYWORD_4 )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2476:1: ( KEYWORD_4 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2477:1: KEYWORD_4
            {
             before(grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_rule__TerminalExpression__Group_0__0__Impl5357); 
             after(grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__0__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_0__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2490:1: rule__TerminalExpression__Group_0__1 : rule__TerminalExpression__Group_0__1__Impl rule__TerminalExpression__Group_0__2 ;
    public final void rule__TerminalExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2494:1: ( rule__TerminalExpression__Group_0__1__Impl rule__TerminalExpression__Group_0__2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2495:2: rule__TerminalExpression__Group_0__1__Impl rule__TerminalExpression__Group_0__2
            {
            pushFollow(FOLLOW_rule__TerminalExpression__Group_0__1__Impl_in_rule__TerminalExpression__Group_0__15388);
            rule__TerminalExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TerminalExpression__Group_0__2_in_rule__TerminalExpression__Group_0__15391);
            rule__TerminalExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__1"


    // $ANTLR start "rule__TerminalExpression__Group_0__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2502:1: rule__TerminalExpression__Group_0__1__Impl : ( ruleLiteralExpression ) ;
    public final void rule__TerminalExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2506:1: ( ( ruleLiteralExpression ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2507:1: ( ruleLiteralExpression )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2507:1: ( ruleLiteralExpression )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2508:1: ruleLiteralExpression
            {
             before(grammarAccess.getTerminalExpressionAccess().getLiteralExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleLiteralExpression_in_rule__TerminalExpression__Group_0__1__Impl5418);
            ruleLiteralExpression();

            state._fsp--;

             after(grammarAccess.getTerminalExpressionAccess().getLiteralExpressionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__1__Impl"


    // $ANTLR start "rule__TerminalExpression__Group_0__2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2519:1: rule__TerminalExpression__Group_0__2 : rule__TerminalExpression__Group_0__2__Impl ;
    public final void rule__TerminalExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2523:1: ( rule__TerminalExpression__Group_0__2__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2524:2: rule__TerminalExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpression__Group_0__2__Impl_in_rule__TerminalExpression__Group_0__25447);
            rule__TerminalExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__2"


    // $ANTLR start "rule__TerminalExpression__Group_0__2__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2530:1: rule__TerminalExpression__Group_0__2__Impl : ( KEYWORD_5 ) ;
    public final void rule__TerminalExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2534:1: ( ( KEYWORD_5 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2535:1: ( KEYWORD_5 )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2535:1: ( KEYWORD_5 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2536:1: KEYWORD_5
            {
             before(grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_rule__TerminalExpression__Group_0__2__Impl5475); 
             after(grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__Group_0__2__Impl"


    // $ANTLR start "rule__PickValue__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2555:1: rule__PickValue__Group__0 : rule__PickValue__Group__0__Impl rule__PickValue__Group__1 ;
    public final void rule__PickValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2559:1: ( rule__PickValue__Group__0__Impl rule__PickValue__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2560:2: rule__PickValue__Group__0__Impl rule__PickValue__Group__1
            {
            pushFollow(FOLLOW_rule__PickValue__Group__0__Impl_in_rule__PickValue__Group__05512);
            rule__PickValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PickValue__Group__1_in_rule__PickValue__Group__05515);
            rule__PickValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PickValue__Group__0"


    // $ANTLR start "rule__PickValue__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2567:1: rule__PickValue__Group__0__Impl : ( KEYWORD_79 ) ;
    public final void rule__PickValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2571:1: ( ( KEYWORD_79 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2572:1: ( KEYWORD_79 )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2572:1: ( KEYWORD_79 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2573:1: KEYWORD_79
            {
             before(grammarAccess.getPickValueAccess().getPICKKeyword_0()); 
            match(input,KEYWORD_79,FOLLOW_KEYWORD_79_in_rule__PickValue__Group__0__Impl5543); 
             after(grammarAccess.getPickValueAccess().getPICKKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PickValue__Group__0__Impl"


    // $ANTLR start "rule__PickValue__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2586:1: rule__PickValue__Group__1 : rule__PickValue__Group__1__Impl ;
    public final void rule__PickValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2590:1: ( rule__PickValue__Group__1__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2591:2: rule__PickValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PickValue__Group__1__Impl_in_rule__PickValue__Group__15574);
            rule__PickValue__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PickValue__Group__1"


    // $ANTLR start "rule__PickValue__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2597:1: rule__PickValue__Group__1__Impl : ( ( rule__PickValue__PickValueAssignment_1 ) ) ;
    public final void rule__PickValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2601:1: ( ( ( rule__PickValue__PickValueAssignment_1 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2602:1: ( ( rule__PickValue__PickValueAssignment_1 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2602:1: ( ( rule__PickValue__PickValueAssignment_1 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2603:1: ( rule__PickValue__PickValueAssignment_1 )
            {
             before(grammarAccess.getPickValueAccess().getPickValueAssignment_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2604:1: ( rule__PickValue__PickValueAssignment_1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2604:2: rule__PickValue__PickValueAssignment_1
            {
            pushFollow(FOLLOW_rule__PickValue__PickValueAssignment_1_in_rule__PickValue__Group__1__Impl5601);
            rule__PickValue__PickValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPickValueAccess().getPickValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PickValue__Group__1__Impl"


    // $ANTLR start "rule__Label__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2618:1: rule__Label__Group__0 : rule__Label__Group__0__Impl rule__Label__Group__1 ;
    public final void rule__Label__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2622:1: ( rule__Label__Group__0__Impl rule__Label__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2623:2: rule__Label__Group__0__Impl rule__Label__Group__1
            {
            pushFollow(FOLLOW_rule__Label__Group__0__Impl_in_rule__Label__Group__05635);
            rule__Label__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Label__Group__1_in_rule__Label__Group__05638);
            rule__Label__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__0"


    // $ANTLR start "rule__Label__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2630:1: rule__Label__Group__0__Impl : ( KEYWORD_11 ) ;
    public final void rule__Label__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2634:1: ( ( KEYWORD_11 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2635:1: ( KEYWORD_11 )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2635:1: ( KEYWORD_11 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2636:1: KEYWORD_11
            {
             before(grammarAccess.getLabelAccess().getColonKeyword_0()); 
            match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_rule__Label__Group__0__Impl5666); 
             after(grammarAccess.getLabelAccess().getColonKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__0__Impl"


    // $ANTLR start "rule__Label__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2649:1: rule__Label__Group__1 : rule__Label__Group__1__Impl ;
    public final void rule__Label__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2653:1: ( rule__Label__Group__1__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2654:2: rule__Label__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Label__Group__1__Impl_in_rule__Label__Group__15697);
            rule__Label__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__1"


    // $ANTLR start "rule__Label__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2660:1: rule__Label__Group__1__Impl : ( ( rule__Label__NameAssignment_1 ) ) ;
    public final void rule__Label__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2664:1: ( ( ( rule__Label__NameAssignment_1 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2665:1: ( ( rule__Label__NameAssignment_1 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2665:1: ( ( rule__Label__NameAssignment_1 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2666:1: ( rule__Label__NameAssignment_1 )
            {
             before(grammarAccess.getLabelAccess().getNameAssignment_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2667:1: ( rule__Label__NameAssignment_1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2667:2: rule__Label__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Label__NameAssignment_1_in_rule__Label__Group__1__Impl5724);
            rule__Label__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLabelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__1__Impl"


    // $ANTLR start "rule__BasicInstruction__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2681:1: rule__BasicInstruction__Group__0 : rule__BasicInstruction__Group__0__Impl rule__BasicInstruction__Group__1 ;
    public final void rule__BasicInstruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2685:1: ( rule__BasicInstruction__Group__0__Impl rule__BasicInstruction__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2686:2: rule__BasicInstruction__Group__0__Impl rule__BasicInstruction__Group__1
            {
            pushFollow(FOLLOW_rule__BasicInstruction__Group__0__Impl_in_rule__BasicInstruction__Group__05758);
            rule__BasicInstruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BasicInstruction__Group__1_in_rule__BasicInstruction__Group__05761);
            rule__BasicInstruction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__Group__0"


    // $ANTLR start "rule__BasicInstruction__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2693:1: rule__BasicInstruction__Group__0__Impl : ( ( rule__BasicInstruction__OpcodeAssignment_0 ) ) ;
    public final void rule__BasicInstruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2697:1: ( ( ( rule__BasicInstruction__OpcodeAssignment_0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2698:1: ( ( rule__BasicInstruction__OpcodeAssignment_0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2698:1: ( ( rule__BasicInstruction__OpcodeAssignment_0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2699:1: ( rule__BasicInstruction__OpcodeAssignment_0 )
            {
             before(grammarAccess.getBasicInstructionAccess().getOpcodeAssignment_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2700:1: ( rule__BasicInstruction__OpcodeAssignment_0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2700:2: rule__BasicInstruction__OpcodeAssignment_0
            {
            pushFollow(FOLLOW_rule__BasicInstruction__OpcodeAssignment_0_in_rule__BasicInstruction__Group__0__Impl5788);
            rule__BasicInstruction__OpcodeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBasicInstructionAccess().getOpcodeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__Group__0__Impl"


    // $ANTLR start "rule__BasicInstruction__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2710:1: rule__BasicInstruction__Group__1 : rule__BasicInstruction__Group__1__Impl rule__BasicInstruction__Group__2 ;
    public final void rule__BasicInstruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2714:1: ( rule__BasicInstruction__Group__1__Impl rule__BasicInstruction__Group__2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2715:2: rule__BasicInstruction__Group__1__Impl rule__BasicInstruction__Group__2
            {
            pushFollow(FOLLOW_rule__BasicInstruction__Group__1__Impl_in_rule__BasicInstruction__Group__15818);
            rule__BasicInstruction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BasicInstruction__Group__2_in_rule__BasicInstruction__Group__15821);
            rule__BasicInstruction__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__Group__1"


    // $ANTLR start "rule__BasicInstruction__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2722:1: rule__BasicInstruction__Group__1__Impl : ( ( rule__BasicInstruction__BAssignment_1 ) ) ;
    public final void rule__BasicInstruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2726:1: ( ( ( rule__BasicInstruction__BAssignment_1 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2727:1: ( ( rule__BasicInstruction__BAssignment_1 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2727:1: ( ( rule__BasicInstruction__BAssignment_1 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2728:1: ( rule__BasicInstruction__BAssignment_1 )
            {
             before(grammarAccess.getBasicInstructionAccess().getBAssignment_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2729:1: ( rule__BasicInstruction__BAssignment_1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2729:2: rule__BasicInstruction__BAssignment_1
            {
            pushFollow(FOLLOW_rule__BasicInstruction__BAssignment_1_in_rule__BasicInstruction__Group__1__Impl5848);
            rule__BasicInstruction__BAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBasicInstructionAccess().getBAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__Group__1__Impl"


    // $ANTLR start "rule__BasicInstruction__Group__2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2739:1: rule__BasicInstruction__Group__2 : rule__BasicInstruction__Group__2__Impl rule__BasicInstruction__Group__3 ;
    public final void rule__BasicInstruction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2743:1: ( rule__BasicInstruction__Group__2__Impl rule__BasicInstruction__Group__3 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2744:2: rule__BasicInstruction__Group__2__Impl rule__BasicInstruction__Group__3
            {
            pushFollow(FOLLOW_rule__BasicInstruction__Group__2__Impl_in_rule__BasicInstruction__Group__25878);
            rule__BasicInstruction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BasicInstruction__Group__3_in_rule__BasicInstruction__Group__25881);
            rule__BasicInstruction__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__Group__2"


    // $ANTLR start "rule__BasicInstruction__Group__2__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2751:1: rule__BasicInstruction__Group__2__Impl : ( ( KEYWORD_8 )? ) ;
    public final void rule__BasicInstruction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2755:1: ( ( ( KEYWORD_8 )? ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2756:1: ( ( KEYWORD_8 )? )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2756:1: ( ( KEYWORD_8 )? )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2757:1: ( KEYWORD_8 )?
            {
             before(grammarAccess.getBasicInstructionAccess().getCommaKeyword_2()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2758:1: ( KEYWORD_8 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==KEYWORD_8) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2759:2: KEYWORD_8
                    {
                    match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_rule__BasicInstruction__Group__2__Impl5910); 

                    }
                    break;

            }

             after(grammarAccess.getBasicInstructionAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__Group__2__Impl"


    // $ANTLR start "rule__BasicInstruction__Group__3"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2770:1: rule__BasicInstruction__Group__3 : rule__BasicInstruction__Group__3__Impl ;
    public final void rule__BasicInstruction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2774:1: ( rule__BasicInstruction__Group__3__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2775:2: rule__BasicInstruction__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__BasicInstruction__Group__3__Impl_in_rule__BasicInstruction__Group__35943);
            rule__BasicInstruction__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__Group__3"


    // $ANTLR start "rule__BasicInstruction__Group__3__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2781:1: rule__BasicInstruction__Group__3__Impl : ( ( rule__BasicInstruction__AAssignment_3 ) ) ;
    public final void rule__BasicInstruction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2785:1: ( ( ( rule__BasicInstruction__AAssignment_3 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2786:1: ( ( rule__BasicInstruction__AAssignment_3 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2786:1: ( ( rule__BasicInstruction__AAssignment_3 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2787:1: ( rule__BasicInstruction__AAssignment_3 )
            {
             before(grammarAccess.getBasicInstructionAccess().getAAssignment_3()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2788:1: ( rule__BasicInstruction__AAssignment_3 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2788:2: rule__BasicInstruction__AAssignment_3
            {
            pushFollow(FOLLOW_rule__BasicInstruction__AAssignment_3_in_rule__BasicInstruction__Group__3__Impl5970);
            rule__BasicInstruction__AAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBasicInstructionAccess().getAAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__Group__3__Impl"


    // $ANTLR start "rule__SpecialInstruction__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2806:1: rule__SpecialInstruction__Group__0 : rule__SpecialInstruction__Group__0__Impl rule__SpecialInstruction__Group__1 ;
    public final void rule__SpecialInstruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2810:1: ( rule__SpecialInstruction__Group__0__Impl rule__SpecialInstruction__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2811:2: rule__SpecialInstruction__Group__0__Impl rule__SpecialInstruction__Group__1
            {
            pushFollow(FOLLOW_rule__SpecialInstruction__Group__0__Impl_in_rule__SpecialInstruction__Group__06008);
            rule__SpecialInstruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SpecialInstruction__Group__1_in_rule__SpecialInstruction__Group__06011);
            rule__SpecialInstruction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecialInstruction__Group__0"


    // $ANTLR start "rule__SpecialInstruction__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2818:1: rule__SpecialInstruction__Group__0__Impl : ( ( rule__SpecialInstruction__OpcodeAssignment_0 ) ) ;
    public final void rule__SpecialInstruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2822:1: ( ( ( rule__SpecialInstruction__OpcodeAssignment_0 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2823:1: ( ( rule__SpecialInstruction__OpcodeAssignment_0 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2823:1: ( ( rule__SpecialInstruction__OpcodeAssignment_0 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2824:1: ( rule__SpecialInstruction__OpcodeAssignment_0 )
            {
             before(grammarAccess.getSpecialInstructionAccess().getOpcodeAssignment_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2825:1: ( rule__SpecialInstruction__OpcodeAssignment_0 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2825:2: rule__SpecialInstruction__OpcodeAssignment_0
            {
            pushFollow(FOLLOW_rule__SpecialInstruction__OpcodeAssignment_0_in_rule__SpecialInstruction__Group__0__Impl6038);
            rule__SpecialInstruction__OpcodeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSpecialInstructionAccess().getOpcodeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecialInstruction__Group__0__Impl"


    // $ANTLR start "rule__SpecialInstruction__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2835:1: rule__SpecialInstruction__Group__1 : rule__SpecialInstruction__Group__1__Impl ;
    public final void rule__SpecialInstruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2839:1: ( rule__SpecialInstruction__Group__1__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2840:2: rule__SpecialInstruction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SpecialInstruction__Group__1__Impl_in_rule__SpecialInstruction__Group__16068);
            rule__SpecialInstruction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecialInstruction__Group__1"


    // $ANTLR start "rule__SpecialInstruction__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2846:1: rule__SpecialInstruction__Group__1__Impl : ( ( rule__SpecialInstruction__AAssignment_1 ) ) ;
    public final void rule__SpecialInstruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2850:1: ( ( ( rule__SpecialInstruction__AAssignment_1 ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2851:1: ( ( rule__SpecialInstruction__AAssignment_1 ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2851:1: ( ( rule__SpecialInstruction__AAssignment_1 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2852:1: ( rule__SpecialInstruction__AAssignment_1 )
            {
             before(grammarAccess.getSpecialInstructionAccess().getAAssignment_1()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2853:1: ( rule__SpecialInstruction__AAssignment_1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2853:2: rule__SpecialInstruction__AAssignment_1
            {
            pushFollow(FOLLOW_rule__SpecialInstruction__AAssignment_1_in_rule__SpecialInstruction__Group__1__Impl6095);
            rule__SpecialInstruction__AAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSpecialInstructionAccess().getAAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecialInstruction__Group__1__Impl"


    // $ANTLR start "rule__AddressExpression__Group__0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2868:1: rule__AddressExpression__Group__0 : rule__AddressExpression__Group__0__Impl rule__AddressExpression__Group__1 ;
    public final void rule__AddressExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2872:1: ( rule__AddressExpression__Group__0__Impl rule__AddressExpression__Group__1 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2873:2: rule__AddressExpression__Group__0__Impl rule__AddressExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AddressExpression__Group__0__Impl_in_rule__AddressExpression__Group__06130);
            rule__AddressExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AddressExpression__Group__1_in_rule__AddressExpression__Group__06133);
            rule__AddressExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddressExpression__Group__0"


    // $ANTLR start "rule__AddressExpression__Group__0__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2880:1: rule__AddressExpression__Group__0__Impl : ( KEYWORD_23 ) ;
    public final void rule__AddressExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2884:1: ( ( KEYWORD_23 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2885:1: ( KEYWORD_23 )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2885:1: ( KEYWORD_23 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2886:1: KEYWORD_23
            {
             before(grammarAccess.getAddressExpressionAccess().getLeftSquareBracketKeyword_0()); 
            match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_rule__AddressExpression__Group__0__Impl6161); 
             after(grammarAccess.getAddressExpressionAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddressExpression__Group__0__Impl"


    // $ANTLR start "rule__AddressExpression__Group__1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2899:1: rule__AddressExpression__Group__1 : rule__AddressExpression__Group__1__Impl rule__AddressExpression__Group__2 ;
    public final void rule__AddressExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2903:1: ( rule__AddressExpression__Group__1__Impl rule__AddressExpression__Group__2 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2904:2: rule__AddressExpression__Group__1__Impl rule__AddressExpression__Group__2
            {
            pushFollow(FOLLOW_rule__AddressExpression__Group__1__Impl_in_rule__AddressExpression__Group__16192);
            rule__AddressExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AddressExpression__Group__2_in_rule__AddressExpression__Group__16195);
            rule__AddressExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddressExpression__Group__1"


    // $ANTLR start "rule__AddressExpression__Group__1__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2911:1: rule__AddressExpression__Group__1__Impl : ( ruleLiteralExpression ) ;
    public final void rule__AddressExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2915:1: ( ( ruleLiteralExpression ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2916:1: ( ruleLiteralExpression )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2916:1: ( ruleLiteralExpression )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2917:1: ruleLiteralExpression
            {
             before(grammarAccess.getAddressExpressionAccess().getLiteralExpressionParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleLiteralExpression_in_rule__AddressExpression__Group__1__Impl6222);
            ruleLiteralExpression();

            state._fsp--;

             after(grammarAccess.getAddressExpressionAccess().getLiteralExpressionParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddressExpression__Group__1__Impl"


    // $ANTLR start "rule__AddressExpression__Group__2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2928:1: rule__AddressExpression__Group__2 : rule__AddressExpression__Group__2__Impl ;
    public final void rule__AddressExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2932:1: ( rule__AddressExpression__Group__2__Impl )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2933:2: rule__AddressExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__AddressExpression__Group__2__Impl_in_rule__AddressExpression__Group__26251);
            rule__AddressExpression__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddressExpression__Group__2"


    // $ANTLR start "rule__AddressExpression__Group__2__Impl"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2939:1: rule__AddressExpression__Group__2__Impl : ( KEYWORD_24 ) ;
    public final void rule__AddressExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2943:1: ( ( KEYWORD_24 ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2944:1: ( KEYWORD_24 )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2944:1: ( KEYWORD_24 )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2945:1: KEYWORD_24
            {
             before(grammarAccess.getAddressExpressionAccess().getRightSquareBracketKeyword_2()); 
            match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_rule__AddressExpression__Group__2__Impl6279); 
             after(grammarAccess.getAddressExpressionAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddressExpression__Group__2__Impl"


    // $ANTLR start "rule__Model__RightAssignment_1_2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2965:1: rule__Model__RightAssignment_1_2 : ( ruleModel ) ;
    public final void rule__Model__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2969:1: ( ( ruleModel ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2970:1: ( ruleModel )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2970:1: ( ruleModel )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2971:1: ruleModel
            {
             before(grammarAccess.getModelAccess().getRightModelParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleModel_in_rule__Model__RightAssignment_1_26321);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelAccess().getRightModelParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__RightAssignment_1_2"


    // $ANTLR start "rule__LineDefinition__LabelsAssignment_0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2980:1: rule__LineDefinition__LabelsAssignment_0 : ( ruleLabel ) ;
    public final void rule__LineDefinition__LabelsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2984:1: ( ( ruleLabel ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2985:1: ( ruleLabel )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2985:1: ( ruleLabel )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2986:1: ruleLabel
            {
             before(grammarAccess.getLineDefinitionAccess().getLabelsLabelParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleLabel_in_rule__LineDefinition__LabelsAssignment_06352);
            ruleLabel();

            state._fsp--;

             after(grammarAccess.getLineDefinitionAccess().getLabelsLabelParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__LabelsAssignment_0"


    // $ANTLR start "rule__LineDefinition__ContentAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2995:1: rule__LineDefinition__ContentAssignment_1 : ( ruleLineContent ) ;
    public final void rule__LineDefinition__ContentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:2999:1: ( ( ruleLineContent ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3000:1: ( ruleLineContent )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3000:1: ( ruleLineContent )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3001:1: ruleLineContent
            {
             before(grammarAccess.getLineDefinitionAccess().getContentLineContentParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleLineContent_in_rule__LineDefinition__ContentAssignment_16383);
            ruleLineContent();

            state._fsp--;

             after(grammarAccess.getLineDefinitionAccess().getContentLineContentParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__ContentAssignment_1"


    // $ANTLR start "rule__LineDefinition__CommentAssignment_2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3010:1: rule__LineDefinition__CommentAssignment_2 : ( RULE_SL_COMMENT ) ;
    public final void rule__LineDefinition__CommentAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3014:1: ( ( RULE_SL_COMMENT ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3015:1: ( RULE_SL_COMMENT )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3015:1: ( RULE_SL_COMMENT )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3016:1: RULE_SL_COMMENT
            {
             before(grammarAccess.getLineDefinitionAccess().getCommentSL_COMMENTTerminalRuleCall_2_0()); 
            match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_rule__LineDefinition__CommentAssignment_26414); 
             after(grammarAccess.getLineDefinitionAccess().getCommentSL_COMMENTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LineDefinition__CommentAssignment_2"


    // $ANTLR start "rule__OriginDirective__ValueAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3025:1: rule__OriginDirective__ValueAssignment_1 : ( ruleNumber ) ;
    public final void rule__OriginDirective__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3029:1: ( ( ruleNumber ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3030:1: ( ruleNumber )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3030:1: ( ruleNumber )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3031:1: ruleNumber
            {
             before(grammarAccess.getOriginDirectiveAccess().getValueNumberParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleNumber_in_rule__OriginDirective__ValueAssignment_16445);
            ruleNumber();

            state._fsp--;

             after(grammarAccess.getOriginDirectiveAccess().getValueNumberParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OriginDirective__ValueAssignment_1"


    // $ANTLR start "rule__IncludeDirective__NameAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3040:1: rule__IncludeDirective__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__IncludeDirective__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3044:1: ( ( RULE_STRING ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3045:1: ( RULE_STRING )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3045:1: ( RULE_STRING )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3046:1: RULE_STRING
            {
             before(grammarAccess.getIncludeDirectiveAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IncludeDirective__NameAssignment_16476); 
             after(grammarAccess.getIncludeDirectiveAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IncludeDirective__NameAssignment_1"


    // $ANTLR start "rule__DataLine__DataElementsAssignment_1_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3055:1: rule__DataLine__DataElementsAssignment_1_1 : ( ruleDataElement ) ;
    public final void rule__DataLine__DataElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3059:1: ( ( ruleDataElement ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3060:1: ( ruleDataElement )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3060:1: ( ruleDataElement )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3061:1: ruleDataElement
            {
             before(grammarAccess.getDataLineAccess().getDataElementsDataElementParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleDataElement_in_rule__DataLine__DataElementsAssignment_1_16507);
            ruleDataElement();

            state._fsp--;

             after(grammarAccess.getDataLineAccess().getDataElementsDataElementParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataLine__DataElementsAssignment_1_1"


    // $ANTLR start "rule__LiteralExpression__OpAssignment_1_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3070:1: rule__LiteralExpression__OpAssignment_1_1 : ( ruleOperator ) ;
    public final void rule__LiteralExpression__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3074:1: ( ( ruleOperator ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3075:1: ( ruleOperator )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3075:1: ( ruleOperator )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3076:1: ruleOperator
            {
             before(grammarAccess.getLiteralExpressionAccess().getOpOperatorEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleOperator_in_rule__LiteralExpression__OpAssignment_1_16538);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getLiteralExpressionAccess().getOpOperatorEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__OpAssignment_1_1"


    // $ANTLR start "rule__LiteralExpression__RightAssignment_1_2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3085:1: rule__LiteralExpression__RightAssignment_1_2 : ( ruleLiteralExpression ) ;
    public final void rule__LiteralExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3089:1: ( ( ruleLiteralExpression ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3090:1: ( ruleLiteralExpression )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3090:1: ( ruleLiteralExpression )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3091:1: ruleLiteralExpression
            {
             before(grammarAccess.getLiteralExpressionAccess().getRightLiteralExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleLiteralExpression_in_rule__LiteralExpression__RightAssignment_1_26569);
            ruleLiteralExpression();

            state._fsp--;

             after(grammarAccess.getLiteralExpressionAccess().getRightLiteralExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__RightAssignment_1_2"


    // $ANTLR start "rule__TerminalExpression__ValueAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3100:1: rule__TerminalExpression__ValueAssignment_1 : ( ruleNonGroupOperand ) ;
    public final void rule__TerminalExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3104:1: ( ( ruleNonGroupOperand ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3105:1: ( ruleNonGroupOperand )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3105:1: ( ruleNonGroupOperand )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3106:1: ruleNonGroupOperand
            {
             before(grammarAccess.getTerminalExpressionAccess().getValueNonGroupOperandParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleNonGroupOperand_in_rule__TerminalExpression__ValueAssignment_16600);
            ruleNonGroupOperand();

            state._fsp--;

             after(grammarAccess.getTerminalExpressionAccess().getValueNonGroupOperandParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpression__ValueAssignment_1"


    // $ANTLR start "rule__NonGroupOperand__LabelNameAssignment_2"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3115:1: rule__NonGroupOperand__LabelNameAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__NonGroupOperand__LabelNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3119:1: ( ( ( RULE_ID ) ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3120:1: ( ( RULE_ID ) )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3120:1: ( ( RULE_ID ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3121:1: ( RULE_ID )
            {
             before(grammarAccess.getNonGroupOperandAccess().getLabelNameLabelCrossReference_2_0()); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3122:1: ( RULE_ID )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3123:1: RULE_ID
            {
             before(grammarAccess.getNonGroupOperandAccess().getLabelNameLabelIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NonGroupOperand__LabelNameAssignment_26635); 
             after(grammarAccess.getNonGroupOperandAccess().getLabelNameLabelIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getNonGroupOperandAccess().getLabelNameLabelCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonGroupOperand__LabelNameAssignment_2"


    // $ANTLR start "rule__PickValue__PickValueAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3134:1: rule__PickValue__PickValueAssignment_1 : ( ruleLiteralExpression ) ;
    public final void rule__PickValue__PickValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3138:1: ( ( ruleLiteralExpression ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3139:1: ( ruleLiteralExpression )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3139:1: ( ruleLiteralExpression )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3140:1: ruleLiteralExpression
            {
             before(grammarAccess.getPickValueAccess().getPickValueLiteralExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleLiteralExpression_in_rule__PickValue__PickValueAssignment_16670);
            ruleLiteralExpression();

            state._fsp--;

             after(grammarAccess.getPickValueAccess().getPickValueLiteralExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PickValue__PickValueAssignment_1"


    // $ANTLR start "rule__Label__NameAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3149:1: rule__Label__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Label__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3153:1: ( ( RULE_ID ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3154:1: ( RULE_ID )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3154:1: ( RULE_ID )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3155:1: RULE_ID
            {
             before(grammarAccess.getLabelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Label__NameAssignment_16701); 
             after(grammarAccess.getLabelAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__NameAssignment_1"


    // $ANTLR start "rule__BasicInstruction__OpcodeAssignment_0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3164:1: rule__BasicInstruction__OpcodeAssignment_0 : ( ruleBasicOpcode ) ;
    public final void rule__BasicInstruction__OpcodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3168:1: ( ( ruleBasicOpcode ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3169:1: ( ruleBasicOpcode )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3169:1: ( ruleBasicOpcode )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3170:1: ruleBasicOpcode
            {
             before(grammarAccess.getBasicInstructionAccess().getOpcodeBasicOpcodeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleBasicOpcode_in_rule__BasicInstruction__OpcodeAssignment_06732);
            ruleBasicOpcode();

            state._fsp--;

             after(grammarAccess.getBasicInstructionAccess().getOpcodeBasicOpcodeEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__OpcodeAssignment_0"


    // $ANTLR start "rule__BasicInstruction__BAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3179:1: rule__BasicInstruction__BAssignment_1 : ( ruleValue ) ;
    public final void rule__BasicInstruction__BAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3183:1: ( ( ruleValue ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3184:1: ( ruleValue )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3184:1: ( ruleValue )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3185:1: ruleValue
            {
             before(grammarAccess.getBasicInstructionAccess().getBValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__BasicInstruction__BAssignment_16763);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getBasicInstructionAccess().getBValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__BAssignment_1"


    // $ANTLR start "rule__BasicInstruction__AAssignment_3"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3194:1: rule__BasicInstruction__AAssignment_3 : ( ruleValue ) ;
    public final void rule__BasicInstruction__AAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3198:1: ( ( ruleValue ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3199:1: ( ruleValue )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3199:1: ( ruleValue )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3200:1: ruleValue
            {
             before(grammarAccess.getBasicInstructionAccess().getAValueParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__BasicInstruction__AAssignment_36794);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getBasicInstructionAccess().getAValueParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicInstruction__AAssignment_3"


    // $ANTLR start "rule__SpecialInstruction__OpcodeAssignment_0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3209:1: rule__SpecialInstruction__OpcodeAssignment_0 : ( ruleSpecialOpcode ) ;
    public final void rule__SpecialInstruction__OpcodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3213:1: ( ( ruleSpecialOpcode ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3214:1: ( ruleSpecialOpcode )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3214:1: ( ruleSpecialOpcode )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3215:1: ruleSpecialOpcode
            {
             before(grammarAccess.getSpecialInstructionAccess().getOpcodeSpecialOpcodeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleSpecialOpcode_in_rule__SpecialInstruction__OpcodeAssignment_06825);
            ruleSpecialOpcode();

            state._fsp--;

             after(grammarAccess.getSpecialInstructionAccess().getOpcodeSpecialOpcodeEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecialInstruction__OpcodeAssignment_0"


    // $ANTLR start "rule__SpecialInstruction__AAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3224:1: rule__SpecialInstruction__AAssignment_1 : ( ruleValue ) ;
    public final void rule__SpecialInstruction__AAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3228:1: ( ( ruleValue ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3229:1: ( ruleValue )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3229:1: ( ruleValue )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3230:1: ruleValue
            {
             before(grammarAccess.getSpecialInstructionAccess().getAValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__SpecialInstruction__AAssignment_16856);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getSpecialInstructionAccess().getAValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecialInstruction__AAssignment_1"


    // $ANTLR start "rule__Literal__NumberAssignment"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3239:1: rule__Literal__NumberAssignment : ( ruleNumber ) ;
    public final void rule__Literal__NumberAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3243:1: ( ( ruleNumber ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3244:1: ( ruleNumber )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3244:1: ( ruleNumber )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3245:1: ruleNumber
            {
             before(grammarAccess.getLiteralAccess().getNumberNumberParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleNumber_in_rule__Literal__NumberAssignment6887);
            ruleNumber();

            state._fsp--;

             after(grammarAccess.getLiteralAccess().getNumberNumberParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__NumberAssignment"


    // $ANTLR start "rule__Register__StandardRegisterAssignment_0"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3254:1: rule__Register__StandardRegisterAssignment_0 : ( ruleStandardRegister ) ;
    public final void rule__Register__StandardRegisterAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3258:1: ( ( ruleStandardRegister ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3259:1: ( ruleStandardRegister )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3259:1: ( ruleStandardRegister )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3260:1: ruleStandardRegister
            {
             before(grammarAccess.getRegisterAccess().getStandardRegisterStandardRegisterEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleStandardRegister_in_rule__Register__StandardRegisterAssignment_06918);
            ruleStandardRegister();

            state._fsp--;

             after(grammarAccess.getRegisterAccess().getStandardRegisterStandardRegisterEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Register__StandardRegisterAssignment_0"


    // $ANTLR start "rule__Register__SpecialRegisterAssignment_1"
    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3269:1: rule__Register__SpecialRegisterAssignment_1 : ( ruleSpecialRegister ) ;
    public final void rule__Register__SpecialRegisterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3273:1: ( ( ruleSpecialRegister ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3274:1: ( ruleSpecialRegister )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3274:1: ( ruleSpecialRegister )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/internal/InternalDASMParser.g:3275:1: ruleSpecialRegister
            {
             before(grammarAccess.getRegisterAccess().getSpecialRegisterSpecialRegisterEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSpecialRegister_in_rule__Register__SpecialRegisterAssignment_16949);
            ruleSpecialRegister();

            state._fsp--;

             after(grammarAccess.getRegisterAccess().getSpecialRegisterSpecialRegisterEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Register__SpecialRegisterAssignment_1"

    // Delegated rules


    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA26_eotS =
        "\31\uffff";
    static final String DFA26_eofS =
        "\1\30\30\uffff";
    static final String DFA26_minS =
        "\1\15\30\uffff";
    static final String DFA26_maxS =
        "\1\143\30\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\27\1\1\2";
    static final String DFA26_specialS =
        "\31\uffff}>";
    static final String[] DFA26_transitionS = {
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

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "2351:1: ( rule__LiteralExpression__Group_1__0 )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLineDefinition_in_entryRuleLineDefinition118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLineDefinition125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LineDefinition__Group__0_in_ruleLineDefinition155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLineContent_in_entryRuleLineContent182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLineContent189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LineContent__Alternatives_in_ruleLineContent219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirective_in_entryRuleDirective246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirective253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Directive__Alternatives_in_ruleDirective283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOriginDirective_in_entryRuleOriginDirective310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOriginDirective317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OriginDirective__Group__0_in_ruleOriginDirective347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDirective_in_entryRuleIncludeDirective374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDirective381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDirective__Group__0_in_ruleIncludeDirective411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataLine_in_entryRuleDataLine438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataLine445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataLine__Group__0_in_ruleDataLine475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataElement_in_entryRuleDataElement502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataElement509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataElement__Alternatives_in_ruleDataElement539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_entryRuleLiteralExpression566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralExpression573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group__0_in_ruleLiteralExpression603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_entryRuleTerminalExpression630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpression637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpression__Alternatives_in_ruleTerminalExpression667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonGroupOperand_in_entryRuleNonGroupOperand694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonGroupOperand701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NonGroupOperand__Alternatives_in_ruleNonGroupOperand731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStackValue_in_entryRuleStackValue758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStackValue765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StackValue__Alternatives_in_ruleStackValue795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePickValue_in_entryRulePickValue822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePickValue829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PickValue__Group__0_in_rulePickValue859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLabel_in_entryRuleLabel886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLabel893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Label__Group__0_in_ruleLabel923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicInstruction_in_entryRuleBasicInstruction1014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicInstruction1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicInstruction__Group__0_in_ruleBasicInstruction1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialInstruction_in_entryRuleSpecialInstruction1078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecialInstruction1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SpecialInstruction__Group__0_in_ruleSpecialInstruction1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__NumberAssignment_in_ruleLiteral1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegister_in_entryRuleRegister1270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegister1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Register__Alternatives_in_ruleRegister1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddressExpression_in_entryRuleAddressExpression1336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddressExpression1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AddressExpression__Group__0_in_ruleAddressExpression1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber1400 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Number__Alternatives_in_ruleNumber1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicOpcode__Alternatives_in_ruleBasicOpcode1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SpecialOpcode__Alternatives_in_ruleSpecialOpcode1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StandardRegister__Alternatives_in_ruleStandardRegister1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SpecialRegister__Alternatives_in_ruleSpecialRegister1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Operator__Alternatives_in_ruleOperator1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__LineContent__Alternatives1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirective_in_rule__LineContent__Alternatives1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataLine_in_rule__LineContent__Alternatives1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeDirective_in_rule__Directive__Alternatives1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOriginDirective_in_rule__Directive__Alternatives1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_86_in_rule__OriginDirective__Alternatives_01769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_84_in_rule__OriginDirective__Alternatives_01789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_82_in_rule__OriginDirective__Alternatives_01809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_81_in_rule__OriginDirective__Alternatives_01829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_88_in_rule__IncludeDirective__Alternatives_01864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_87_in_rule__IncludeDirective__Alternatives_01884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_85_in_rule__IncludeDirective__Alternatives_01904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_83_in_rule__IncludeDirective__Alternatives_01924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_rule__DataLine__Alternatives_01959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_78_in_rule__DataLine__Alternatives_01979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DataElement__Alternatives2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_rule__DataElement__Alternatives2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpression__Group_0__0_in_rule__TerminalExpression__Alternatives2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpression__ValueAssignment_1_in_rule__TerminalExpression__Alternatives2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegister_in_rule__NonGroupOperand__Alternatives2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__NonGroupOperand__Alternatives2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NonGroupOperand__LabelNameAssignment_2_in_rule__NonGroupOperand__Alternatives2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStackValue_in_rule__NonGroupOperand__Alternatives2165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_68_in_rule__StackValue__Alternatives2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_80_in_rule__StackValue__Alternatives2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePickValue_in_rule__StackValue__Alternatives2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicInstruction_in_rule__Instruction__Alternatives2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialInstruction_in_rule__Instruction__Alternatives2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_rule__Value__Alternatives2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddressExpression_in_rule__Value__Alternatives2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Register__StandardRegisterAssignment_0_in_rule__Register__Alternatives2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Register__SpecialRegisterAssignment_1_in_rule__Register__Alternatives2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXNUMBER_in_rule__Number__Alternatives2419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECNUMBER_in_rule__Number__Alternatives2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINNUMBER_in_rule__Number__Alternatives2453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_71_in_rule__BasicOpcode__Alternatives2486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_rule__BasicOpcode__Alternatives2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_76_in_rule__BasicOpcode__Alternatives2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_67_in_rule__BasicOpcode__Alternatives2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_65_in_rule__BasicOpcode__Alternatives2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_46_in_rule__BasicOpcode__Alternatives2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_rule__BasicOpcode__Alternatives2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_66_in_rule__BasicOpcode__Alternatives2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_64_in_rule__BasicOpcode__Alternatives2646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_42_in_rule__BasicOpcode__Alternatives2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_rule__BasicOpcode__Alternatives2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_77_in_rule__BasicOpcode__Alternatives2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_73_in_rule__BasicOpcode__Alternatives2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_rule__BasicOpcode__Alternatives2746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_72_in_rule__BasicOpcode__Alternatives2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_55_in_rule__BasicOpcode__Alternatives2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_56_in_rule__BasicOpcode__Alternatives2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_57_in_rule__BasicOpcode__Alternatives2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_60_in_rule__BasicOpcode__Alternatives2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_58_in_rule__BasicOpcode__Alternatives2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_54_in_rule__BasicOpcode__Alternatives2886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_59_in_rule__BasicOpcode__Alternatives2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_61_in_rule__BasicOpcode__Alternatives2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_41_in_rule__BasicOpcode__Alternatives2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_70_in_rule__BasicOpcode__Alternatives2966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_75_in_rule__BasicOpcode__Alternatives2986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_74_in_rule__BasicOpcode__Alternatives3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_63_in_rule__SpecialOpcode__Alternatives3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_62_in_rule__SpecialOpcode__Alternatives3061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_51_in_rule__SpecialOpcode__Alternatives3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_53_in_rule__SpecialOpcode__Alternatives3101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_69_in_rule__SpecialOpcode__Alternatives3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_52_in_rule__SpecialOpcode__Alternatives3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_rule__SpecialOpcode__Alternatives3161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_50_in_rule__SpecialOpcode__Alternatives3181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_48_in_rule__SpecialOpcode__Alternatives3201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_15_in_rule__StandardRegister__Alternatives3236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_16_in_rule__StandardRegister__Alternatives3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_17_in_rule__StandardRegister__Alternatives3276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_20_in_rule__StandardRegister__Alternatives3296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_rule__StandardRegister__Alternatives3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_rule__StandardRegister__Alternatives3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_18_in_rule__StandardRegister__Alternatives3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_19_in_rule__StandardRegister__Alternatives3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_37_in_rule__SpecialRegister__Alternatives3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_rule__SpecialRegister__Alternatives3431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_rule__SpecialRegister__Alternatives3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_rule__Operator__Alternatives3486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_rule__Operator__Alternatives3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_rule__Operator__Alternatives3526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_rule__Operator__Alternatives3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rule__Operator__Alternatives3566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_rule__Operator__Alternatives3586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_34_in_rule__Operator__Alternatives3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_39_in_rule__Operator__Alternatives3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_rule__Operator__Alternatives3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_26_in_rule__Operator__Alternatives3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_25_in_rule__Operator__Alternatives3686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_rule__Operator__Alternatives3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_rule__Operator__Alternatives3726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_32_in_rule__Operator__Alternatives3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_28_in_rule__Operator__Alternatives3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_13_in_rule__Operator__Alternatives3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_rule__Operator__Alternatives3806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_12_in_rule__Operator__Alternatives3826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_31_in_rule__Operator__Alternatives3846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_29_in_rule__Operator__Alternatives3866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_rule__Operator__Alternatives3886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_rule__Operator__Alternatives3906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_rule__Operator__Alternatives3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__03958 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__03961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLineDefinition_in_rule__Model__Group__0__Impl3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl4044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__04079 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__04082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__14140 = new BitSet(new long[]{0x003FEFFFFFFF1FF0L,0x0000000100000800L});
    public static final BitSet FOLLOW_rule__Model__Group_1__2_in_rule__Model__Group_1__14143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NL_in_rule__Model__Group_1__1__Impl4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__2__Impl_in_rule__Model__Group_1__24199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__RightAssignment_1_2_in_rule__Model__Group_1__2__Impl4226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LineDefinition__Group__0__Impl_in_rule__LineDefinition__Group__04262 = new BitSet(new long[]{0x003FEFFFFFFF1FF0L,0x0000000100000800L});
    public static final BitSet FOLLOW_rule__LineDefinition__Group__1_in_rule__LineDefinition__Group__04265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LineDefinition__LabelsAssignment_0_in_rule__LineDefinition__Group__0__Impl4292 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_rule__LineDefinition__Group__1__Impl_in_rule__LineDefinition__Group__14323 = new BitSet(new long[]{0x003FEFFFFFFF1FF0L,0x0000000100000800L});
    public static final BitSet FOLLOW_rule__LineDefinition__Group__2_in_rule__LineDefinition__Group__14326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LineDefinition__ContentAssignment_1_in_rule__LineDefinition__Group__1__Impl4353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LineDefinition__Group__2__Impl_in_rule__LineDefinition__Group__24384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LineDefinition__CommentAssignment_2_in_rule__LineDefinition__Group__2__Impl4411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OriginDirective__Group__0__Impl_in_rule__OriginDirective__Group__04448 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_rule__OriginDirective__Group__1_in_rule__OriginDirective__Group__04451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OriginDirective__Alternatives_0_in_rule__OriginDirective__Group__0__Impl4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OriginDirective__Group__1__Impl_in_rule__OriginDirective__Group__14508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OriginDirective__ValueAssignment_1_in_rule__OriginDirective__Group__1__Impl4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDirective__Group__0__Impl_in_rule__IncludeDirective__Group__04569 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_rule__IncludeDirective__Group__1_in_rule__IncludeDirective__Group__04572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDirective__Alternatives_0_in_rule__IncludeDirective__Group__0__Impl4599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDirective__Group__1__Impl_in_rule__IncludeDirective__Group__14629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IncludeDirective__NameAssignment_1_in_rule__IncludeDirective__Group__1__Impl4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataLine__Group__0__Impl_in_rule__DataLine__Group__04690 = new BitSet(new long[]{0x0000000000000000L,0x00000002E0000100L});
    public static final BitSet FOLLOW_rule__DataLine__Group__1_in_rule__DataLine__Group__04693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataLine__Alternatives_0_in_rule__DataLine__Group__0__Impl4720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataLine__Group__1__Impl_in_rule__DataLine__Group__14750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataLine__Group_1__0_in_rule__DataLine__Group__1__Impl4779 = new BitSet(new long[]{0x0000000000000002L,0x00000002E0000100L});
    public static final BitSet FOLLOW_rule__DataLine__Group_1__0_in_rule__DataLine__Group__1__Impl4791 = new BitSet(new long[]{0x0000000000000002L,0x00000002E0000100L});
    public static final BitSet FOLLOW_rule__DataLine__Group_1__0__Impl_in_rule__DataLine__Group_1__04828 = new BitSet(new long[]{0x0000000000000000L,0x00000002E0000100L});
    public static final BitSet FOLLOW_rule__DataLine__Group_1__1_in_rule__DataLine__Group_1__04831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_rule__DataLine__Group_1__0__Impl4860 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DataLine__Group_1__1__Impl_in_rule__DataLine__Group_1__14893 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__DataLine__Group_1__2_in_rule__DataLine__Group_1__14896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataLine__DataElementsAssignment_1_1_in_rule__DataLine__Group_1__1__Impl4923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataLine__Group_1__2__Impl_in_rule__DataLine__Group_1__24953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_rule__DataLine__Group_1__2__Impl4982 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group__0__Impl_in_rule__LiteralExpression__Group__05021 = new BitSet(new long[]{0x1FC0000000008000L,0x000000000E007ECFL});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group__1_in_rule__LiteralExpression__Group__05024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_rule__LiteralExpression__Group__0__Impl5051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group__1__Impl_in_rule__LiteralExpression__Group__15080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group_1__0_in_rule__LiteralExpression__Group__1__Impl5107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group_1__0__Impl_in_rule__LiteralExpression__Group_1__05142 = new BitSet(new long[]{0x1FC0000000008000L,0x000000000E007ECFL});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group_1__1_in_rule__LiteralExpression__Group_1__05145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group_1__1__Impl_in_rule__LiteralExpression__Group_1__15203 = new BitSet(new long[]{0xE000100000006000L,0x00000000F07F8010L});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group_1__2_in_rule__LiteralExpression__Group_1__15206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralExpression__OpAssignment_1_1_in_rule__LiteralExpression__Group_1__1__Impl5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralExpression__Group_1__2__Impl_in_rule__LiteralExpression__Group_1__25263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralExpression__RightAssignment_1_2_in_rule__LiteralExpression__Group_1__2__Impl5290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpression__Group_0__0__Impl_in_rule__TerminalExpression__Group_0__05326 = new BitSet(new long[]{0xE000100000006000L,0x00000000F07F8010L});
    public static final BitSet FOLLOW_rule__TerminalExpression__Group_0__1_in_rule__TerminalExpression__Group_0__05329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_rule__TerminalExpression__Group_0__0__Impl5357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpression__Group_0__1__Impl_in_rule__TerminalExpression__Group_0__15388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TerminalExpression__Group_0__2_in_rule__TerminalExpression__Group_0__15391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_rule__TerminalExpression__Group_0__1__Impl5418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpression__Group_0__2__Impl_in_rule__TerminalExpression__Group_0__25447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_rule__TerminalExpression__Group_0__2__Impl5475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PickValue__Group__0__Impl_in_rule__PickValue__Group__05512 = new BitSet(new long[]{0xE000100000006000L,0x00000000F07F8010L});
    public static final BitSet FOLLOW_rule__PickValue__Group__1_in_rule__PickValue__Group__05515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_79_in_rule__PickValue__Group__0__Impl5543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PickValue__Group__1__Impl_in_rule__PickValue__Group__15574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PickValue__PickValueAssignment_1_in_rule__PickValue__Group__1__Impl5601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Label__Group__0__Impl_in_rule__Label__Group__05635 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Label__Group__1_in_rule__Label__Group__05638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_rule__Label__Group__0__Impl5666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Label__Group__1__Impl_in_rule__Label__Group__15697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Label__NameAssignment_1_in_rule__Label__Group__1__Impl5724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicInstruction__Group__0__Impl_in_rule__BasicInstruction__Group__05758 = new BitSet(new long[]{0xE000100000006000L,0x00000000F0FF8010L});
    public static final BitSet FOLLOW_rule__BasicInstruction__Group__1_in_rule__BasicInstruction__Group__05761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicInstruction__OpcodeAssignment_0_in_rule__BasicInstruction__Group__0__Impl5788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicInstruction__Group__1__Impl_in_rule__BasicInstruction__Group__15818 = new BitSet(new long[]{0xE000100000006000L,0x00000000F0FF8110L});
    public static final BitSet FOLLOW_rule__BasicInstruction__Group__2_in_rule__BasicInstruction__Group__15821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicInstruction__BAssignment_1_in_rule__BasicInstruction__Group__1__Impl5848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicInstruction__Group__2__Impl_in_rule__BasicInstruction__Group__25878 = new BitSet(new long[]{0xE000100000006000L,0x00000000F0FF8110L});
    public static final BitSet FOLLOW_rule__BasicInstruction__Group__3_in_rule__BasicInstruction__Group__25881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_rule__BasicInstruction__Group__2__Impl5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicInstruction__Group__3__Impl_in_rule__BasicInstruction__Group__35943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicInstruction__AAssignment_3_in_rule__BasicInstruction__Group__3__Impl5970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SpecialInstruction__Group__0__Impl_in_rule__SpecialInstruction__Group__06008 = new BitSet(new long[]{0xE000100000006000L,0x00000000F0FF8010L});
    public static final BitSet FOLLOW_rule__SpecialInstruction__Group__1_in_rule__SpecialInstruction__Group__06011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SpecialInstruction__OpcodeAssignment_0_in_rule__SpecialInstruction__Group__0__Impl6038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SpecialInstruction__Group__1__Impl_in_rule__SpecialInstruction__Group__16068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SpecialInstruction__AAssignment_1_in_rule__SpecialInstruction__Group__1__Impl6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AddressExpression__Group__0__Impl_in_rule__AddressExpression__Group__06130 = new BitSet(new long[]{0xE000100000006000L,0x00000000F07F8010L});
    public static final BitSet FOLLOW_rule__AddressExpression__Group__1_in_rule__AddressExpression__Group__06133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_rule__AddressExpression__Group__0__Impl6161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AddressExpression__Group__1__Impl_in_rule__AddressExpression__Group__16192 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_rule__AddressExpression__Group__2_in_rule__AddressExpression__Group__16195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_rule__AddressExpression__Group__1__Impl6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AddressExpression__Group__2__Impl_in_rule__AddressExpression__Group__26251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_24_in_rule__AddressExpression__Group__2__Impl6279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_rule__Model__RightAssignment_1_26321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLabel_in_rule__LineDefinition__LabelsAssignment_06352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLineContent_in_rule__LineDefinition__ContentAssignment_16383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_rule__LineDefinition__CommentAssignment_26414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_rule__OriginDirective__ValueAssignment_16445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IncludeDirective__NameAssignment_16476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataElement_in_rule__DataLine__DataElementsAssignment_1_16507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_rule__LiteralExpression__OpAssignment_1_16538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_rule__LiteralExpression__RightAssignment_1_26569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonGroupOperand_in_rule__TerminalExpression__ValueAssignment_16600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NonGroupOperand__LabelNameAssignment_26635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_rule__PickValue__PickValueAssignment_16670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Label__NameAssignment_16701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicOpcode_in_rule__BasicInstruction__OpcodeAssignment_06732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__BasicInstruction__BAssignment_16763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__BasicInstruction__AAssignment_36794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialOpcode_in_rule__SpecialInstruction__OpcodeAssignment_06825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__SpecialInstruction__AAssignment_16856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_rule__Literal__NumberAssignment6887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStandardRegister_in_rule__Register__StandardRegisterAssignment_06918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialRegister_in_rule__Register__SpecialRegisterAssignment_16949 = new BitSet(new long[]{0x0000000000000002L});

}