package devcpu.assembler;

import devcpu.lexer.tokens.AValueEndToken;
import devcpu.lexer.tokens.AValueStartToken;
import devcpu.lexer.tokens.AddressStartToken;
import devcpu.lexer.tokens.BValueEndToken;
import devcpu.lexer.tokens.BValueStartToken;
import devcpu.lexer.tokens.BasicOpCodeToken;
import devcpu.lexer.tokens.DataToken;
import devcpu.lexer.tokens.DirectiveParametersToken;
import devcpu.lexer.tokens.LabelToken;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.OperatorToken;
import devcpu.lexer.tokens.RegisterToken;
import devcpu.lexer.tokens.SpecialOpCodeToken;
import devcpu.lexer.tokens.UnaryOperatorToken;

public class AssemblyLine {
	//TODO Consider making these and other classes' fields public so they can be accessed directly in the interest of assembly speed
	private String text;
	private LexerToken[] sourceTokens;
	private LexerToken[] processedTokens;
	private AssemblyDocument document;
	private int lineNumber;
	private Directive directive;
	//Let's try out some public fields and see how we like them.
	public int offset;
	public int minOffset;
	public int maxOffset;
	public int nextOffset; //Used only in directives
	public int size;
	public int minSize;
	public int maxSize;
	public char opCode;
	public char value1;
	public char value2;
	public boolean assembled;
	public boolean sized;
	public boolean located;
	//Set by Preprocess
	public int unvaluedLabelTokens;
	public boolean isDat; //Other preprocess fields invalid if this is true
	public boolean isSpecial;
	public String aRegister;
	public String bRegister;
	public boolean aHasRegisterToken;
	public boolean bHasRegisterToken;
	public boolean aIsAddress;
	public boolean bIsAddress;
	public boolean aHasNonAddition;
	public boolean bHasNonAddition;
	//Set on Calculation
	public char literalA;
	public char literalB;
	public boolean literalASet;
	public boolean literalBSet;

	public AssemblyLine(AssemblyDocument document, int lineNumber, String lineText, LexerToken[] tokens) {
		this.document = document;
		this.lineNumber = lineNumber;
		this.text = lineText;
		this.processedTokens = this.sourceTokens = tokens;
	}
	
	public String getText() {
		return text;
	}

	public LexerToken[] getTokens() {
		return sourceTokens;
	}

	public LexerToken[] getProcessedTokens() {
		return processedTokens;
	}

	public void setProcessedTokens(LexerToken[] processedTokens) {
		this.processedTokens = processedTokens;
		if (directive != null) {
			for (LexerToken token : processedTokens) {
				if (token instanceof DirectiveParametersToken) {
					directive.setParameters((DirectiveParametersToken)token);
				}
			}
		}
	}
	
	public void preprocess() {
		boolean inA = false;
		for (LexerToken t : processedTokens) {
			if (t instanceof DataToken) {
				isDat = true;
			} else if (t instanceof BValueEndToken) {
				inA = true; //Don't bother checking for other starts or ends
				isSpecial = true; //BValueEndToken is all that needs to be found for this and inA/inB
			} else if (t instanceof AddressStartToken) {
				if (inA) {
					aIsAddress = true;
				} else {
					bIsAddress = true;
				}
			} else if (t instanceof RegisterToken) {
				if (inA) {
					aRegister = ((RegisterToken) t).getRegister();
					aHasRegisterToken = true;
				} else {
					bRegister = ((RegisterToken) t).getRegister();
					bHasRegisterToken = true;
				}
			} else if (t instanceof LabelToken) {
				if (!((LabelToken) t).valueSet) {
					unvaluedLabelTokens++;
				}
			} else if (t instanceof OperatorToken) {
				if (!"+".equals(t.getText())) {
					if (inA) {
						aHasNonAddition = true;
					} else {
						bHasNonAddition = true;
					}
				}
			} else if (t instanceof UnaryOperatorToken) {
				if (inA) {
					aHasNonAddition = true;
				} else {
					bHasNonAddition = true;
				}
			}
		}
	}
	
	public AssemblyDocument getDocument() {
		return document;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setDirective(Directive directive) {
		this.directive = directive;
	}

	public Directive getDirective() {
		return directive;
	}
	
	public boolean isDirective() {
		return directive != null;
	}

//	public void setOffset(int offset) {
//		this.offset = offset;
//	}
//
//	public int getOffset() {
//		return offset;
//	}
//
//	public void setSize(int size) {
//		this.size = size;
//	}
//	
//	public int getSize() {
//		return size;
//	}
}
