package devcpu.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDASMLexer extends Lexer {
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
    public static final int RULE_STRING=97;
    public static final int RULE_BINNUMBER=95;
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

    public InternalDASMLexer() {;} 
    public InternalDASMLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDASMLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g"; }

    // $ANTLR start "KEYWORD_87"
    public final void mKEYWORD_87() throws RecognitionException {
        try {
            int _type = KEYWORD_87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:19:12: ( '#' ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:19:14: '#' ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' )
            {
            match('#'); 
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_87"

    // $ANTLR start "KEYWORD_88"
    public final void mKEYWORD_88() throws RecognitionException {
        try {
            int _type = KEYWORD_88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:21:12: ( '.' ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:21:14: '.' ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' )
            {
            match('.'); 
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_88"

    // $ANTLR start "KEYWORD_83"
    public final void mKEYWORD_83() throws RecognitionException {
        try {
            int _type = KEYWORD_83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:23:12: ( '#' ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:23:14: '#' ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' )
            {
            match('#'); 
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_83"

    // $ANTLR start "KEYWORD_84"
    public final void mKEYWORD_84() throws RecognitionException {
        try {
            int _type = KEYWORD_84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:25:12: ( '#' ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'I' | 'i' ) ( 'N' | 'n' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:25:14: '#' ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'I' | 'i' ) ( 'N' | 'n' )
            {
            match('#'); 
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_84"

    // $ANTLR start "KEYWORD_85"
    public final void mKEYWORD_85() throws RecognitionException {
        try {
            int _type = KEYWORD_85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:27:12: ( '.' ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:27:14: '.' ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' )
            {
            match('.'); 
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_85"

    // $ANTLR start "KEYWORD_86"
    public final void mKEYWORD_86() throws RecognitionException {
        try {
            int _type = KEYWORD_86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:29:12: ( '.' ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'I' | 'i' ) ( 'N' | 'n' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:29:14: '.' ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'I' | 'i' ) ( 'N' | 'n' )
            {
            match('.'); 
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_86"

    // $ANTLR start "KEYWORD_81"
    public final void mKEYWORD_81() throws RecognitionException {
        try {
            int _type = KEYWORD_81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:31:12: ( '#' ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:31:14: '#' ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' )
            {
            match('#'); 
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_81"

    // $ANTLR start "KEYWORD_82"
    public final void mKEYWORD_82() throws RecognitionException {
        try {
            int _type = KEYWORD_82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:33:12: ( '.' ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:33:14: '.' ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' )
            {
            match('.'); 
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_82"

    // $ANTLR start "KEYWORD_78"
    public final void mKEYWORD_78() throws RecognitionException {
        try {
            int _type = KEYWORD_78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:35:12: ( '.' ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:35:14: '.' ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' )
            {
            match('.'); 
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_78"

    // $ANTLR start "KEYWORD_79"
    public final void mKEYWORD_79() throws RecognitionException {
        try {
            int _type = KEYWORD_79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:37:12: ( ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'K' | 'k' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:37:14: ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_79"

    // $ANTLR start "KEYWORD_80"
    public final void mKEYWORD_80() throws RecognitionException {
        try {
            int _type = KEYWORD_80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:39:12: ( ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'S' | 's' ) ( 'H' | 'h' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:39:14: ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'S' | 's' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_80"

    // $ANTLR start "KEYWORD_39"
    public final void mKEYWORD_39() throws RecognitionException {
        try {
            int _type = KEYWORD_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:41:12: ( '>' '>' '>' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:41:14: '>' '>' '>'
            {
            match('>'); 
            match('>'); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_39"

    // $ANTLR start "KEYWORD_40"
    public final void mKEYWORD_40() throws RecognitionException {
        try {
            int _type = KEYWORD_40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:43:12: ( ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'D' | 'd' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:43:14: ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_40"

    // $ANTLR start "KEYWORD_41"
    public final void mKEYWORD_41() throws RecognitionException {
        try {
            int _type = KEYWORD_41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:45:12: ( ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'X' | 'x' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:45:14: ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_41"

    // $ANTLR start "KEYWORD_42"
    public final void mKEYWORD_42() throws RecognitionException {
        try {
            int _type = KEYWORD_42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:47:12: ( ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:47:14: ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_42"

    // $ANTLR start "KEYWORD_43"
    public final void mKEYWORD_43() throws RecognitionException {
        try {
            int _type = KEYWORD_43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:49:12: ( ( 'A' | 'a' ) ( 'S' | 's' ) ( 'R' | 'r' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:49:14: ( 'A' | 'a' ) ( 'S' | 's' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_43"

    // $ANTLR start "KEYWORD_44"
    public final void mKEYWORD_44() throws RecognitionException {
        try {
            int _type = KEYWORD_44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:51:12: ( ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:51:14: ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_44"

    // $ANTLR start "KEYWORD_45"
    public final void mKEYWORD_45() throws RecognitionException {
        try {
            int _type = KEYWORD_45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:53:12: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:53:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_45"

    // $ANTLR start "KEYWORD_46"
    public final void mKEYWORD_46() throws RecognitionException {
        try {
            int _type = KEYWORD_46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:55:12: ( ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'V' | 'v' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:55:14: ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'V' | 'v' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_46"

    // $ANTLR start "KEYWORD_47"
    public final void mKEYWORD_47() throws RecognitionException {
        try {
            int _type = KEYWORD_47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:57:12: ( ( 'D' | 'd' ) ( 'V' | 'v' ) ( 'I' | 'i' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:57:14: ( 'D' | 'd' ) ( 'V' | 'v' ) ( 'I' | 'i' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_47"

    // $ANTLR start "KEYWORD_48"
    public final void mKEYWORD_48() throws RecognitionException {
        try {
            int _type = KEYWORD_48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:59:12: ( ( 'H' | 'h' ) ( 'W' | 'w' ) ( 'I' | 'i' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:59:14: ( 'H' | 'h' ) ( 'W' | 'w' ) ( 'I' | 'i' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_48"

    // $ANTLR start "KEYWORD_49"
    public final void mKEYWORD_49() throws RecognitionException {
        try {
            int _type = KEYWORD_49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:61:12: ( ( 'H' | 'h' ) ( 'W' | 'w' ) ( 'N' | 'n' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:61:14: ( 'H' | 'h' ) ( 'W' | 'w' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_49"

    // $ANTLR start "KEYWORD_50"
    public final void mKEYWORD_50() throws RecognitionException {
        try {
            int _type = KEYWORD_50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:63:12: ( ( 'H' | 'h' ) ( 'W' | 'w' ) ( 'Q' | 'q' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:63:14: ( 'H' | 'h' ) ( 'W' | 'w' ) ( 'Q' | 'q' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_50"

    // $ANTLR start "KEYWORD_51"
    public final void mKEYWORD_51() throws RecognitionException {
        try {
            int _type = KEYWORD_51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:65:12: ( ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'G' | 'g' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:65:14: ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'G' | 'g' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_51"

    // $ANTLR start "KEYWORD_52"
    public final void mKEYWORD_52() throws RecognitionException {
        try {
            int _type = KEYWORD_52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:67:12: ( ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'Q' | 'q' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:67:14: ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'Q' | 'q' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_52"

    // $ANTLR start "KEYWORD_53"
    public final void mKEYWORD_53() throws RecognitionException {
        try {
            int _type = KEYWORD_53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:69:12: ( ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:69:14: ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_53"

    // $ANTLR start "KEYWORD_54"
    public final void mKEYWORD_54() throws RecognitionException {
        try {
            int _type = KEYWORD_54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:71:12: ( ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'A' | 'a' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:71:14: ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'A' | 'a' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_54"

    // $ANTLR start "KEYWORD_55"
    public final void mKEYWORD_55() throws RecognitionException {
        try {
            int _type = KEYWORD_55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:73:12: ( ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'B' | 'b' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:73:14: ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'B' | 'b' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_55"

    // $ANTLR start "KEYWORD_56"
    public final void mKEYWORD_56() throws RecognitionException {
        try {
            int _type = KEYWORD_56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:75:12: ( ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'C' | 'c' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:75:14: ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'C' | 'c' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_56"

    // $ANTLR start "KEYWORD_57"
    public final void mKEYWORD_57() throws RecognitionException {
        try {
            int _type = KEYWORD_57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:77:12: ( ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'E' | 'e' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:77:14: ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_57"

    // $ANTLR start "KEYWORD_58"
    public final void mKEYWORD_58() throws RecognitionException {
        try {
            int _type = KEYWORD_58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:79:12: ( ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'G' | 'g' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:79:14: ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'G' | 'g' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_58"

    // $ANTLR start "KEYWORD_59"
    public final void mKEYWORD_59() throws RecognitionException {
        try {
            int _type = KEYWORD_59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:81:12: ( ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'L' | 'l' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:81:14: ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_59"

    // $ANTLR start "KEYWORD_60"
    public final void mKEYWORD_60() throws RecognitionException {
        try {
            int _type = KEYWORD_60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:83:12: ( ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'N' | 'n' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:83:14: ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_60"

    // $ANTLR start "KEYWORD_61"
    public final void mKEYWORD_61() throws RecognitionException {
        try {
            int _type = KEYWORD_61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:85:12: ( ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'U' | 'u' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:85:14: ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'U' | 'u' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_61"

    // $ANTLR start "KEYWORD_62"
    public final void mKEYWORD_62() throws RecognitionException {
        try {
            int _type = KEYWORD_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:87:12: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:87:14: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_62"

    // $ANTLR start "KEYWORD_63"
    public final void mKEYWORD_63() throws RecognitionException {
        try {
            int _type = KEYWORD_63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:89:12: ( ( 'J' | 'j' ) ( 'S' | 's' ) ( 'R' | 'r' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:89:14: ( 'J' | 'j' ) ( 'S' | 's' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_63"

    // $ANTLR start "KEYWORD_64"
    public final void mKEYWORD_64() throws RecognitionException {
        try {
            int _type = KEYWORD_64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:91:12: ( ( 'M' | 'm' ) ( 'D' | 'd' ) ( 'I' | 'i' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:91:14: ( 'M' | 'm' ) ( 'D' | 'd' ) ( 'I' | 'i' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_64"

    // $ANTLR start "KEYWORD_65"
    public final void mKEYWORD_65() throws RecognitionException {
        try {
            int _type = KEYWORD_65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:93:12: ( ( 'M' | 'm' ) ( 'L' | 'l' ) ( 'I' | 'i' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:93:14: ( 'M' | 'm' ) ( 'L' | 'l' ) ( 'I' | 'i' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_65"

    // $ANTLR start "KEYWORD_66"
    public final void mKEYWORD_66() throws RecognitionException {
        try {
            int _type = KEYWORD_66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:95:12: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:95:14: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_66"

    // $ANTLR start "KEYWORD_67"
    public final void mKEYWORD_67() throws RecognitionException {
        try {
            int _type = KEYWORD_67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:97:12: ( ( 'M' | 'm' ) ( 'U' | 'u' ) ( 'L' | 'l' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:97:14: ( 'M' | 'm' ) ( 'U' | 'u' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_67"

    // $ANTLR start "KEYWORD_68"
    public final void mKEYWORD_68() throws RecognitionException {
        try {
            int _type = KEYWORD_68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:99:12: ( ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'P' | 'p' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:99:14: ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_68"

    // $ANTLR start "KEYWORD_69"
    public final void mKEYWORD_69() throws RecognitionException {
        try {
            int _type = KEYWORD_69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:101:12: ( ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'I' | 'i' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:101:14: ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'I' | 'i' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_69"

    // $ANTLR start "KEYWORD_70"
    public final void mKEYWORD_70() throws RecognitionException {
        try {
            int _type = KEYWORD_70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:103:12: ( ( 'S' | 's' ) ( 'B' | 'b' ) ( 'X' | 'x' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:103:14: ( 'S' | 's' ) ( 'B' | 'b' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_70"

    // $ANTLR start "KEYWORD_71"
    public final void mKEYWORD_71() throws RecognitionException {
        try {
            int _type = KEYWORD_71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:105:12: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'T' | 't' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:105:14: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_71"

    // $ANTLR start "KEYWORD_72"
    public final void mKEYWORD_72() throws RecognitionException {
        try {
            int _type = KEYWORD_72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:107:12: ( ( 'S' | 's' ) ( 'H' | 'h' ) ( 'L' | 'l' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:107:14: ( 'S' | 's' ) ( 'H' | 'h' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_72"

    // $ANTLR start "KEYWORD_73"
    public final void mKEYWORD_73() throws RecognitionException {
        try {
            int _type = KEYWORD_73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:109:12: ( ( 'S' | 's' ) ( 'H' | 'h' ) ( 'R' | 'r' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:109:14: ( 'S' | 's' ) ( 'H' | 'h' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_73"

    // $ANTLR start "KEYWORD_74"
    public final void mKEYWORD_74() throws RecognitionException {
        try {
            int _type = KEYWORD_74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:111:12: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'D' | 'd' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:111:14: ( 'S' | 's' ) ( 'T' | 't' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_74"

    // $ANTLR start "KEYWORD_75"
    public final void mKEYWORD_75() throws RecognitionException {
        try {
            int _type = KEYWORD_75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:113:12: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'I' | 'i' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:113:14: ( 'S' | 's' ) ( 'T' | 't' ) ( 'I' | 'i' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_75"

    // $ANTLR start "KEYWORD_76"
    public final void mKEYWORD_76() throws RecognitionException {
        try {
            int _type = KEYWORD_76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:115:12: ( ( 'S' | 's' ) ( 'U' | 'u' ) ( 'B' | 'b' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:115:14: ( 'S' | 's' ) ( 'U' | 'u' ) ( 'B' | 'b' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_76"

    // $ANTLR start "KEYWORD_77"
    public final void mKEYWORD_77() throws RecognitionException {
        try {
            int _type = KEYWORD_77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:117:12: ( ( 'X' | 'x' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:117:14: ( 'X' | 'x' ) ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_77"

    // $ANTLR start "KEYWORD_28"
    public final void mKEYWORD_28() throws RecognitionException {
        try {
            int _type = KEYWORD_28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:119:12: ( '!' '=' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:119:14: '!' '='
            {
            match('!'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_28"

    // $ANTLR start "KEYWORD_29"
    public final void mKEYWORD_29() throws RecognitionException {
        try {
            int _type = KEYWORD_29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:121:12: ( '&' '&' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:121:14: '&' '&'
            {
            match('&'); 
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_29"

    // $ANTLR start "KEYWORD_30"
    public final void mKEYWORD_30() throws RecognitionException {
        try {
            int _type = KEYWORD_30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:123:12: ( '<' '<' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:123:14: '<' '<'
            {
            match('<'); 
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_30"

    // $ANTLR start "KEYWORD_31"
    public final void mKEYWORD_31() throws RecognitionException {
        try {
            int _type = KEYWORD_31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:125:12: ( '<' '=' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:125:14: '<' '='
            {
            match('<'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_31"

    // $ANTLR start "KEYWORD_32"
    public final void mKEYWORD_32() throws RecognitionException {
        try {
            int _type = KEYWORD_32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:127:12: ( '=' '=' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:127:14: '=' '='
            {
            match('='); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_32"

    // $ANTLR start "KEYWORD_33"
    public final void mKEYWORD_33() throws RecognitionException {
        try {
            int _type = KEYWORD_33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:129:12: ( '>' '=' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:129:14: '>' '='
            {
            match('>'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_33"

    // $ANTLR start "KEYWORD_34"
    public final void mKEYWORD_34() throws RecognitionException {
        try {
            int _type = KEYWORD_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:131:12: ( '>' '>' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:131:14: '>' '>'
            {
            match('>'); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_34"

    // $ANTLR start "KEYWORD_35"
    public final void mKEYWORD_35() throws RecognitionException {
        try {
            int _type = KEYWORD_35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:133:12: ( ( 'E' | 'e' ) ( 'X' | 'x' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:133:14: ( 'E' | 'e' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_35"

    // $ANTLR start "KEYWORD_36"
    public final void mKEYWORD_36() throws RecognitionException {
        try {
            int _type = KEYWORD_36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:135:12: ( ( 'P' | 'p' ) ( 'C' | 'c' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:135:14: ( 'P' | 'p' ) ( 'C' | 'c' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_36"

    // $ANTLR start "KEYWORD_37"
    public final void mKEYWORD_37() throws RecognitionException {
        try {
            int _type = KEYWORD_37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:137:12: ( ( 'S' | 's' ) ( 'P' | 'p' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:137:14: ( 'S' | 's' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_37"

    // $ANTLR start "KEYWORD_38"
    public final void mKEYWORD_38() throws RecognitionException {
        try {
            int _type = KEYWORD_38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:139:12: ( '|' '|' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:139:14: '|' '|'
            {
            match('|'); 
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_38"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:141:11: ( '!' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:141:13: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_1"

    // $ANTLR start "KEYWORD_2"
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:143:11: ( '%' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:143:13: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_2"

    // $ANTLR start "KEYWORD_3"
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:145:11: ( '&' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:145:13: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_3"

    // $ANTLR start "KEYWORD_4"
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:147:11: ( '(' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:147:13: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_4"

    // $ANTLR start "KEYWORD_5"
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:149:11: ( ')' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:149:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_5"

    // $ANTLR start "KEYWORD_6"
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:151:11: ( '*' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:151:13: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_6"

    // $ANTLR start "KEYWORD_7"
    public final void mKEYWORD_7() throws RecognitionException {
        try {
            int _type = KEYWORD_7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:153:11: ( '+' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:153:13: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_7"

    // $ANTLR start "KEYWORD_8"
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:155:11: ( ',' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:155:13: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_8"

    // $ANTLR start "KEYWORD_9"
    public final void mKEYWORD_9() throws RecognitionException {
        try {
            int _type = KEYWORD_9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:157:11: ( '-' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:157:13: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_9"

    // $ANTLR start "KEYWORD_10"
    public final void mKEYWORD_10() throws RecognitionException {
        try {
            int _type = KEYWORD_10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:159:12: ( '/' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:159:14: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_10"

    // $ANTLR start "KEYWORD_11"
    public final void mKEYWORD_11() throws RecognitionException {
        try {
            int _type = KEYWORD_11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:161:12: ( ':' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:161:14: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_11"

    // $ANTLR start "KEYWORD_12"
    public final void mKEYWORD_12() throws RecognitionException {
        try {
            int _type = KEYWORD_12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:163:12: ( '<' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:163:14: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_12"

    // $ANTLR start "KEYWORD_13"
    public final void mKEYWORD_13() throws RecognitionException {
        try {
            int _type = KEYWORD_13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:165:12: ( '>' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:165:14: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_13"

    // $ANTLR start "KEYWORD_14"
    public final void mKEYWORD_14() throws RecognitionException {
        try {
            int _type = KEYWORD_14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:167:12: ( '?' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:167:14: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_14"

    // $ANTLR start "KEYWORD_15"
    public final void mKEYWORD_15() throws RecognitionException {
        try {
            int _type = KEYWORD_15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:169:12: ( ( 'A' | 'a' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:169:14: ( 'A' | 'a' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_15"

    // $ANTLR start "KEYWORD_16"
    public final void mKEYWORD_16() throws RecognitionException {
        try {
            int _type = KEYWORD_16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:171:12: ( ( 'B' | 'b' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:171:14: ( 'B' | 'b' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_16"

    // $ANTLR start "KEYWORD_17"
    public final void mKEYWORD_17() throws RecognitionException {
        try {
            int _type = KEYWORD_17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:173:12: ( ( 'C' | 'c' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:173:14: ( 'C' | 'c' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_17"

    // $ANTLR start "KEYWORD_18"
    public final void mKEYWORD_18() throws RecognitionException {
        try {
            int _type = KEYWORD_18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:175:12: ( ( 'I' | 'i' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:175:14: ( 'I' | 'i' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_18"

    // $ANTLR start "KEYWORD_19"
    public final void mKEYWORD_19() throws RecognitionException {
        try {
            int _type = KEYWORD_19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:177:12: ( ( 'J' | 'j' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:177:14: ( 'J' | 'j' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_19"

    // $ANTLR start "KEYWORD_20"
    public final void mKEYWORD_20() throws RecognitionException {
        try {
            int _type = KEYWORD_20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:179:12: ( ( 'X' | 'x' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:179:14: ( 'X' | 'x' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_20"

    // $ANTLR start "KEYWORD_21"
    public final void mKEYWORD_21() throws RecognitionException {
        try {
            int _type = KEYWORD_21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:181:12: ( ( 'Y' | 'y' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:181:14: ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_21"

    // $ANTLR start "KEYWORD_22"
    public final void mKEYWORD_22() throws RecognitionException {
        try {
            int _type = KEYWORD_22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:183:12: ( ( 'Z' | 'z' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:183:14: ( 'Z' | 'z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_22"

    // $ANTLR start "KEYWORD_23"
    public final void mKEYWORD_23() throws RecognitionException {
        try {
            int _type = KEYWORD_23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:185:12: ( '[' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:185:14: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_23"

    // $ANTLR start "KEYWORD_24"
    public final void mKEYWORD_24() throws RecognitionException {
        try {
            int _type = KEYWORD_24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:187:12: ( ']' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:187:14: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_24"

    // $ANTLR start "KEYWORD_25"
    public final void mKEYWORD_25() throws RecognitionException {
        try {
            int _type = KEYWORD_25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:189:12: ( '^' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:189:14: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_25"

    // $ANTLR start "KEYWORD_26"
    public final void mKEYWORD_26() throws RecognitionException {
        try {
            int _type = KEYWORD_26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:191:12: ( '|' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:191:14: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_26"

    // $ANTLR start "KEYWORD_27"
    public final void mKEYWORD_27() throws RecognitionException {
        try {
            int _type = KEYWORD_27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:193:12: ( '~' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:193:14: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_27"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:197:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:197:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:197:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:197:11: '^'
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

            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:197:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:
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
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_HEXNUMBER"
    public final void mRULE_HEXNUMBER() throws RecognitionException {
        try {
            int _type = RULE_HEXNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:199:16: ( '0x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:199:18: '0x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match("0x"); 

            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:199:23: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='F')||(LA3_0>='a' && LA3_0<='f')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEXNUMBER"

    // $ANTLR start "RULE_DECNUMBER"
    public final void mRULE_DECNUMBER() throws RecognitionException {
        try {
            int _type = RULE_DECNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:201:16: ( ( '-' )? ( '0' .. '9' )+ )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:201:18: ( '-' )? ( '0' .. '9' )+
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:201:18: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:201:18: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:201:23: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:201:24: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECNUMBER"

    // $ANTLR start "RULE_BINNUMBER"
    public final void mRULE_BINNUMBER() throws RecognitionException {
        try {
            int _type = RULE_BINNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:203:16: ( '0b' ( '0' | '1' )+ )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:203:18: '0b' ( '0' | '1' )+
            {
            match("0b"); 

            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:203:23: ( '0' | '1' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='1')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINNUMBER"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:205:17: ( ';' (~ ( ( '\\n' | '\\r' ) ) )* )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:205:19: ';' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match(';'); 
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:205:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:205:23: ~ ( ( '\\n' | '\\r' ) )
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:207:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop9;
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:209:9: ( ( ' ' | '\\t' )+ )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:209:11: ( ' ' | '\\t' )+
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:209:11: ( ' ' | '\\t' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_NL"
    public final void mRULE_NL() throws RecognitionException {
        try {
            int _type = RULE_NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:211:9: ( ( ' ' | '\\t' )* ( '\\r' )? '\\n' )
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:211:11: ( ' ' | '\\t' )* ( '\\r' )? '\\n'
            {
            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:211:11: ( ' ' | '\\t' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\t'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:211:23: ( '\\r' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:211:23: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NL"

    public void mTokens() throws RecognitionException {
        // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:8: ( KEYWORD_87 | KEYWORD_88 | KEYWORD_83 | KEYWORD_84 | KEYWORD_85 | KEYWORD_86 | KEYWORD_81 | KEYWORD_82 | KEYWORD_78 | KEYWORD_79 | KEYWORD_80 | KEYWORD_39 | KEYWORD_40 | KEYWORD_41 | KEYWORD_42 | KEYWORD_43 | KEYWORD_44 | KEYWORD_45 | KEYWORD_46 | KEYWORD_47 | KEYWORD_48 | KEYWORD_49 | KEYWORD_50 | KEYWORD_51 | KEYWORD_52 | KEYWORD_53 | KEYWORD_54 | KEYWORD_55 | KEYWORD_56 | KEYWORD_57 | KEYWORD_58 | KEYWORD_59 | KEYWORD_60 | KEYWORD_61 | KEYWORD_62 | KEYWORD_63 | KEYWORD_64 | KEYWORD_65 | KEYWORD_66 | KEYWORD_67 | KEYWORD_68 | KEYWORD_69 | KEYWORD_70 | KEYWORD_71 | KEYWORD_72 | KEYWORD_73 | KEYWORD_74 | KEYWORD_75 | KEYWORD_76 | KEYWORD_77 | KEYWORD_28 | KEYWORD_29 | KEYWORD_30 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_37 | KEYWORD_38 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_19 | KEYWORD_20 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_26 | KEYWORD_27 | RULE_ID | RULE_HEXNUMBER | RULE_DECNUMBER | RULE_BINNUMBER | RULE_SL_COMMENT | RULE_STRING | RULE_WS | RULE_NL )
        int alt14=96;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:10: KEYWORD_87
                {
                mKEYWORD_87(); 

                }
                break;
            case 2 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:21: KEYWORD_88
                {
                mKEYWORD_88(); 

                }
                break;
            case 3 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:32: KEYWORD_83
                {
                mKEYWORD_83(); 

                }
                break;
            case 4 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:43: KEYWORD_84
                {
                mKEYWORD_84(); 

                }
                break;
            case 5 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:54: KEYWORD_85
                {
                mKEYWORD_85(); 

                }
                break;
            case 6 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:65: KEYWORD_86
                {
                mKEYWORD_86(); 

                }
                break;
            case 7 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:76: KEYWORD_81
                {
                mKEYWORD_81(); 

                }
                break;
            case 8 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:87: KEYWORD_82
                {
                mKEYWORD_82(); 

                }
                break;
            case 9 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:98: KEYWORD_78
                {
                mKEYWORD_78(); 

                }
                break;
            case 10 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:109: KEYWORD_79
                {
                mKEYWORD_79(); 

                }
                break;
            case 11 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:120: KEYWORD_80
                {
                mKEYWORD_80(); 

                }
                break;
            case 12 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:131: KEYWORD_39
                {
                mKEYWORD_39(); 

                }
                break;
            case 13 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:142: KEYWORD_40
                {
                mKEYWORD_40(); 

                }
                break;
            case 14 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:153: KEYWORD_41
                {
                mKEYWORD_41(); 

                }
                break;
            case 15 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:164: KEYWORD_42
                {
                mKEYWORD_42(); 

                }
                break;
            case 16 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:175: KEYWORD_43
                {
                mKEYWORD_43(); 

                }
                break;
            case 17 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:186: KEYWORD_44
                {
                mKEYWORD_44(); 

                }
                break;
            case 18 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:197: KEYWORD_45
                {
                mKEYWORD_45(); 

                }
                break;
            case 19 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:208: KEYWORD_46
                {
                mKEYWORD_46(); 

                }
                break;
            case 20 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:219: KEYWORD_47
                {
                mKEYWORD_47(); 

                }
                break;
            case 21 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:230: KEYWORD_48
                {
                mKEYWORD_48(); 

                }
                break;
            case 22 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:241: KEYWORD_49
                {
                mKEYWORD_49(); 

                }
                break;
            case 23 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:252: KEYWORD_50
                {
                mKEYWORD_50(); 

                }
                break;
            case 24 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:263: KEYWORD_51
                {
                mKEYWORD_51(); 

                }
                break;
            case 25 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:274: KEYWORD_52
                {
                mKEYWORD_52(); 

                }
                break;
            case 26 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:285: KEYWORD_53
                {
                mKEYWORD_53(); 

                }
                break;
            case 27 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:296: KEYWORD_54
                {
                mKEYWORD_54(); 

                }
                break;
            case 28 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:307: KEYWORD_55
                {
                mKEYWORD_55(); 

                }
                break;
            case 29 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:318: KEYWORD_56
                {
                mKEYWORD_56(); 

                }
                break;
            case 30 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:329: KEYWORD_57
                {
                mKEYWORD_57(); 

                }
                break;
            case 31 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:340: KEYWORD_58
                {
                mKEYWORD_58(); 

                }
                break;
            case 32 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:351: KEYWORD_59
                {
                mKEYWORD_59(); 

                }
                break;
            case 33 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:362: KEYWORD_60
                {
                mKEYWORD_60(); 

                }
                break;
            case 34 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:373: KEYWORD_61
                {
                mKEYWORD_61(); 

                }
                break;
            case 35 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:384: KEYWORD_62
                {
                mKEYWORD_62(); 

                }
                break;
            case 36 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:395: KEYWORD_63
                {
                mKEYWORD_63(); 

                }
                break;
            case 37 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:406: KEYWORD_64
                {
                mKEYWORD_64(); 

                }
                break;
            case 38 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:417: KEYWORD_65
                {
                mKEYWORD_65(); 

                }
                break;
            case 39 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:428: KEYWORD_66
                {
                mKEYWORD_66(); 

                }
                break;
            case 40 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:439: KEYWORD_67
                {
                mKEYWORD_67(); 

                }
                break;
            case 41 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:450: KEYWORD_68
                {
                mKEYWORD_68(); 

                }
                break;
            case 42 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:461: KEYWORD_69
                {
                mKEYWORD_69(); 

                }
                break;
            case 43 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:472: KEYWORD_70
                {
                mKEYWORD_70(); 

                }
                break;
            case 44 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:483: KEYWORD_71
                {
                mKEYWORD_71(); 

                }
                break;
            case 45 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:494: KEYWORD_72
                {
                mKEYWORD_72(); 

                }
                break;
            case 46 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:505: KEYWORD_73
                {
                mKEYWORD_73(); 

                }
                break;
            case 47 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:516: KEYWORD_74
                {
                mKEYWORD_74(); 

                }
                break;
            case 48 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:527: KEYWORD_75
                {
                mKEYWORD_75(); 

                }
                break;
            case 49 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:538: KEYWORD_76
                {
                mKEYWORD_76(); 

                }
                break;
            case 50 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:549: KEYWORD_77
                {
                mKEYWORD_77(); 

                }
                break;
            case 51 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:560: KEYWORD_28
                {
                mKEYWORD_28(); 

                }
                break;
            case 52 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:571: KEYWORD_29
                {
                mKEYWORD_29(); 

                }
                break;
            case 53 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:582: KEYWORD_30
                {
                mKEYWORD_30(); 

                }
                break;
            case 54 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:593: KEYWORD_31
                {
                mKEYWORD_31(); 

                }
                break;
            case 55 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:604: KEYWORD_32
                {
                mKEYWORD_32(); 

                }
                break;
            case 56 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:615: KEYWORD_33
                {
                mKEYWORD_33(); 

                }
                break;
            case 57 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:626: KEYWORD_34
                {
                mKEYWORD_34(); 

                }
                break;
            case 58 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:637: KEYWORD_35
                {
                mKEYWORD_35(); 

                }
                break;
            case 59 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:648: KEYWORD_36
                {
                mKEYWORD_36(); 

                }
                break;
            case 60 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:659: KEYWORD_37
                {
                mKEYWORD_37(); 

                }
                break;
            case 61 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:670: KEYWORD_38
                {
                mKEYWORD_38(); 

                }
                break;
            case 62 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:681: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 63 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:691: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 64 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:701: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 65 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:711: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 66 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:721: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 67 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:731: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 68 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:741: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 69 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:751: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 70 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:761: KEYWORD_9
                {
                mKEYWORD_9(); 

                }
                break;
            case 71 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:771: KEYWORD_10
                {
                mKEYWORD_10(); 

                }
                break;
            case 72 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:782: KEYWORD_11
                {
                mKEYWORD_11(); 

                }
                break;
            case 73 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:793: KEYWORD_12
                {
                mKEYWORD_12(); 

                }
                break;
            case 74 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:804: KEYWORD_13
                {
                mKEYWORD_13(); 

                }
                break;
            case 75 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:815: KEYWORD_14
                {
                mKEYWORD_14(); 

                }
                break;
            case 76 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:826: KEYWORD_15
                {
                mKEYWORD_15(); 

                }
                break;
            case 77 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:837: KEYWORD_16
                {
                mKEYWORD_16(); 

                }
                break;
            case 78 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:848: KEYWORD_17
                {
                mKEYWORD_17(); 

                }
                break;
            case 79 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:859: KEYWORD_18
                {
                mKEYWORD_18(); 

                }
                break;
            case 80 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:870: KEYWORD_19
                {
                mKEYWORD_19(); 

                }
                break;
            case 81 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:881: KEYWORD_20
                {
                mKEYWORD_20(); 

                }
                break;
            case 82 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:892: KEYWORD_21
                {
                mKEYWORD_21(); 

                }
                break;
            case 83 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:903: KEYWORD_22
                {
                mKEYWORD_22(); 

                }
                break;
            case 84 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:914: KEYWORD_23
                {
                mKEYWORD_23(); 

                }
                break;
            case 85 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:925: KEYWORD_24
                {
                mKEYWORD_24(); 

                }
                break;
            case 86 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:936: KEYWORD_25
                {
                mKEYWORD_25(); 

                }
                break;
            case 87 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:947: KEYWORD_26
                {
                mKEYWORD_26(); 

                }
                break;
            case 88 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:958: KEYWORD_27
                {
                mKEYWORD_27(); 

                }
                break;
            case 89 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:969: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 90 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:977: RULE_HEXNUMBER
                {
                mRULE_HEXNUMBER(); 

                }
                break;
            case 91 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:992: RULE_DECNUMBER
                {
                mRULE_DECNUMBER(); 

                }
                break;
            case 92 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:1007: RULE_BINNUMBER
                {
                mRULE_BINNUMBER(); 

                }
                break;
            case 93 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:1022: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 94 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:1038: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 95 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:1050: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 96 :
                // ../devcpu.DASM.ui/src-gen/devcpu/ui/contentassist/antlr/lexer/InternalDASMLexer.g:1:1058: RULE_NL
                {
                mRULE_NL(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\3\uffff\1\46\1\72\1\76\1\100\2\46\1\110\1\112\3\46\1\127\1\131"+
        "\1\133\1\136\1\uffff\1\46\1\141\6\uffff\1\142\3\uffff\1\143\1\144"+
        "\1\145\2\uffff\1\146\2\uffff\1\50\3\uffff\1\151\10\uffff\3\46\1"+
        "\161\1\163\2\uffff\3\46\1\uffff\1\46\1\uffff\7\46\1\uffff\1\46\1"+
        "\uffff\12\46\1\u0098\1\46\10\uffff\1\u009a\16\uffff\2\46\1\u009d"+
        "\3\uffff\1\u009e\1\u009f\1\u00a0\1\u00a1\1\u00a2\1\u00a3\1\u00a4"+
        "\1\u00a5\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa\1\u00ab\1\u00ac"+
        "\1\u00ad\1\u00ae\1\u00af\1\u00b0\1\u00b1\1\u00b2\1\u00b3\1\u00b4"+
        "\1\u00b5\1\u00b6\1\u00b7\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc"+
        "\1\u00bd\1\u00be\1\u00bf\1\u00c0\1\u00c1\1\uffff\1\u00c2\1\uffff"+
        "\1\u00c3\1\u00c4\50\uffff";
    static final String DFA14_eofS =
        "\u00c5\uffff";
    static final String DFA14_minS =
        "\1\11\2\101\1\103\1\75\2\60\1\101\1\127\2\60\1\104\1\106\1\102"+
        "\1\60\1\75\1\46\1\74\1\uffff\1\130\1\174\6\uffff\1\60\3\uffff\3"+
        "\60\2\uffff\1\101\2\uffff\1\142\3\uffff\1\11\1\uffff\1\115\2\uffff"+
        "\1\115\3\uffff\1\103\1\123\1\120\1\60\1\76\2\uffff\2\104\1\122\1"+
        "\uffff\1\122\1\uffff\1\124\1\126\2\111\1\107\1\101\1\124\1\uffff"+
        "\1\122\1\uffff\2\111\1\104\1\114\1\111\1\130\1\124\1\114\1\104\1"+
        "\102\1\60\1\122\10\uffff\1\60\16\uffff\1\113\1\110\1\60\3\uffff"+
        "\44\60\1\uffff\1\60\1\uffff\2\60\50\uffff";
    static final String DFA14_maxS =
        "\1\176\2\157\1\165\1\76\2\172\1\166\1\167\2\172\1\165\1\146\1\165"+
        "\1\172\1\75\1\46\1\75\1\uffff\1\170\1\174\6\uffff\1\71\3\uffff\3"+
        "\172\2\uffff\1\172\2\uffff\1\170\3\uffff\1\40\1\uffff\1\156\2\uffff"+
        "\1\156\3\uffff\1\143\1\163\1\160\1\172\1\76\2\uffff\1\170\1\144"+
        "\1\162\1\uffff\1\162\1\uffff\1\164\1\166\1\151\1\161\1\163\1\165"+
        "\1\164\1\uffff\1\162\1\uffff\2\151\1\144\1\154\1\151\1\170\1\164"+
        "\1\162\1\151\1\142\1\172\1\162\10\uffff\1\172\16\uffff\1\153\1\150"+
        "\1\172\3\uffff\44\172\1\uffff\1\172\1\uffff\2\172\50\uffff";
    static final String DFA14_acceptS =
        "\22\uffff\1\67\2\uffff\1\77\1\101\1\102\1\103\1\104\1\105\1\uffff"+
        "\1\107\1\110\1\113\3\uffff\1\124\1\125\1\uffff\1\130\1\131\1\uffff"+
        "\1\133\1\135\1\136\1\uffff\1\140\1\uffff\1\4\1\7\1\uffff\1\6\1\10"+
        "\1\11\5\uffff\1\70\1\112\3\uffff\1\114\1\uffff\1\115\7\uffff\1\117"+
        "\1\uffff\1\120\14\uffff\1\121\1\63\1\76\1\64\1\100\1\65\1\66\1\111"+
        "\1\uffff\1\75\1\127\1\106\1\116\1\122\1\123\1\126\1\132\1\134\1"+
        "\137\1\1\1\3\1\2\1\5\3\uffff\1\73\1\14\1\71\44\uffff\1\74\1\uffff"+
        "\1\72\2\uffff\1\51\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
        "\1\43\1\44\1\45\1\46\1\47\1\50\1\52\1\53\1\54\1\55\1\56\1\57\1\60"+
        "\1\61\1\62\1\12\1\13";
    static final String DFA14_specialS =
        "\u00c5\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\53\1\54\2\uffff\1\54\22\uffff\1\53\1\17\1\52\1\1\1\uffff"+
            "\1\25\1\20\1\52\1\26\1\27\1\30\1\31\1\32\1\33\1\2\1\34\1\47"+
            "\11\50\1\35\1\51\1\21\1\22\1\4\1\36\1\uffff\1\5\1\6\1\37\1\7"+
            "\1\23\2\46\1\10\1\11\1\12\2\46\1\13\2\46\1\3\1\46\1\14\1\15"+
            "\4\46\1\16\1\40\1\41\1\42\1\uffff\1\43\1\44\1\46\1\uffff\1\5"+
            "\1\6\1\37\1\7\1\23\2\46\1\10\1\11\1\12\2\46\1\13\2\46\1\3\1"+
            "\46\1\14\1\15\4\46\1\16\1\40\1\41\1\uffff\1\24\1\uffff\1\45",
            "\1\57\7\uffff\1\55\5\uffff\1\56\21\uffff\1\57\7\uffff\1\55"+
            "\5\uffff\1\56",
            "\1\62\2\uffff\1\63\4\uffff\1\60\5\uffff\1\61\21\uffff\1\62"+
            "\2\uffff\1\63\4\uffff\1\60\5\uffff\1\61",
            "\1\67\5\uffff\1\64\5\uffff\1\66\5\uffff\1\65\15\uffff\1\67"+
            "\5\uffff\1\64\5\uffff\1\66\5\uffff\1\65",
            "\1\71\1\70",
            "\12\46\7\uffff\3\46\1\73\11\46\1\74\4\46\1\75\7\46\4\uffff"+
            "\1\46\1\uffff\3\46\1\73\11\46\1\74\4\46\1\75\7\46",
            "\12\46\7\uffff\16\46\1\77\13\46\4\uffff\1\46\1\uffff\16\46"+
            "\1\77\13\46",
            "\1\101\7\uffff\1\102\14\uffff\1\103\12\uffff\1\101\7\uffff"+
            "\1\102\14\uffff\1\103",
            "\1\104\37\uffff\1\104",
            "\12\46\7\uffff\1\105\4\46\1\106\7\46\1\107\14\46\4\uffff\1"+
            "\46\1\uffff\1\105\4\46\1\106\7\46\1\107\14\46",
            "\12\46\7\uffff\22\46\1\111\7\46\4\uffff\1\46\1\uffff\22\46"+
            "\1\111\7\46",
            "\1\113\7\uffff\1\114\2\uffff\1\115\5\uffff\1\116\16\uffff"+
            "\1\113\7\uffff\1\114\2\uffff\1\115\5\uffff\1\116",
            "\1\117\37\uffff\1\117",
            "\1\120\2\uffff\1\121\2\uffff\1\122\7\uffff\1\125\3\uffff\1"+
            "\123\1\124\14\uffff\1\120\2\uffff\1\121\2\uffff\1\122\7\uffff"+
            "\1\125\3\uffff\1\123\1\124",
            "\12\46\7\uffff\16\46\1\126\13\46\4\uffff\1\46\1\uffff\16\46"+
            "\1\126\13\46",
            "\1\130",
            "\1\132",
            "\1\134\1\135",
            "",
            "\1\137\37\uffff\1\137",
            "\1\140",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\50",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\1\150\25\uffff\1\147",
            "",
            "",
            "",
            "\1\53\1\54\2\uffff\1\54\22\uffff\1\53",
            "",
            "\1\153\1\152\36\uffff\1\153\1\152",
            "",
            "",
            "\1\155\1\154\36\uffff\1\155\1\154",
            "",
            "",
            "",
            "\1\156\37\uffff\1\156",
            "\1\157\37\uffff\1\157",
            "\1\160\37\uffff\1\160",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\162",
            "",
            "",
            "\1\164\23\uffff\1\165\13\uffff\1\164\23\uffff\1\165",
            "\1\166\37\uffff\1\166",
            "\1\167\37\uffff\1\167",
            "",
            "\1\170\37\uffff\1\170",
            "",
            "\1\171\37\uffff\1\171",
            "\1\172\37\uffff\1\172",
            "\1\173\37\uffff\1\173",
            "\1\174\4\uffff\1\175\2\uffff\1\176\27\uffff\1\174\4\uffff"+
            "\1\175\2\uffff\1\176",
            "\1\177\11\uffff\1\u0080\1\uffff\1\u0081\23\uffff\1\177\11"+
            "\uffff\1\u0080\1\uffff\1\u0081",
            "\1\u0082\1\u0083\1\u0084\1\uffff\1\u0085\1\uffff\1\u0086\4"+
            "\uffff\1\u0087\1\uffff\1\u0088\6\uffff\1\u0089\13\uffff\1\u0082"+
            "\1\u0083\1\u0084\1\uffff\1\u0085\1\uffff\1\u0086\4\uffff\1\u0087"+
            "\1\uffff\1\u0088\6\uffff\1\u0089",
            "\1\u008a\37\uffff\1\u008a",
            "",
            "\1\u008b\37\uffff\1\u008b",
            "",
            "\1\u008c\37\uffff\1\u008c",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008e\37\uffff\1\u008e",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0092\37\uffff\1\u0092",
            "\1\u0093\5\uffff\1\u0094\31\uffff\1\u0093\5\uffff\1\u0094",
            "\1\u0095\4\uffff\1\u0096\32\uffff\1\u0095\4\uffff\1\u0096",
            "\1\u0097\37\uffff\1\u0097",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0099\37\uffff\1\u0099",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
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
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009c\37\uffff\1\u009c",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
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
            return "1:1: Tokens : ( KEYWORD_87 | KEYWORD_88 | KEYWORD_83 | KEYWORD_84 | KEYWORD_85 | KEYWORD_86 | KEYWORD_81 | KEYWORD_82 | KEYWORD_78 | KEYWORD_79 | KEYWORD_80 | KEYWORD_39 | KEYWORD_40 | KEYWORD_41 | KEYWORD_42 | KEYWORD_43 | KEYWORD_44 | KEYWORD_45 | KEYWORD_46 | KEYWORD_47 | KEYWORD_48 | KEYWORD_49 | KEYWORD_50 | KEYWORD_51 | KEYWORD_52 | KEYWORD_53 | KEYWORD_54 | KEYWORD_55 | KEYWORD_56 | KEYWORD_57 | KEYWORD_58 | KEYWORD_59 | KEYWORD_60 | KEYWORD_61 | KEYWORD_62 | KEYWORD_63 | KEYWORD_64 | KEYWORD_65 | KEYWORD_66 | KEYWORD_67 | KEYWORD_68 | KEYWORD_69 | KEYWORD_70 | KEYWORD_71 | KEYWORD_72 | KEYWORD_73 | KEYWORD_74 | KEYWORD_75 | KEYWORD_76 | KEYWORD_77 | KEYWORD_28 | KEYWORD_29 | KEYWORD_30 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_37 | KEYWORD_38 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_19 | KEYWORD_20 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_26 | KEYWORD_27 | RULE_ID | RULE_HEXNUMBER | RULE_DECNUMBER | RULE_BINNUMBER | RULE_SL_COMMENT | RULE_STRING | RULE_WS | RULE_NL );";
        }
    }
 

}