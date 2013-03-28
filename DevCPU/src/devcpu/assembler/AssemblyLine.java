package devcpu.assembler;

import devcpu.emulation.OpCodes;
import devcpu.lexer.tokens.AddressStartToken;
import devcpu.lexer.tokens.BValueEndToken;
import devcpu.lexer.tokens.BasicOpCodeToken;
import devcpu.lexer.tokens.DataToken;
import devcpu.lexer.tokens.DirectiveParametersToken;
import devcpu.lexer.tokens.GroupStartToken;
import devcpu.lexer.tokens.LabelToken;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.OffsetStackAccessToken;
import devcpu.lexer.tokens.OperatorToken;
import devcpu.lexer.tokens.RegisterToken;
import devcpu.lexer.tokens.SimpleStackAccessToken;
import devcpu.lexer.tokens.SpecialOpCodeToken;
import devcpu.lexer.tokens.UnaryOperatorToken;

public class AssemblyLine {
	public static final int VALUE_REGISTER = 1;
	public static final int VALUE_REGISTER_MEMORY = 2;
	public static final int VALUE_REGISTER_OFFSET_MEMORY = 3;
	public static final int VALUE_SIMPLE_STACK = 4;
	public static final int VALUE_OFFSET_STACK = 5;
	public static final int VALUE_LITERAL_ADDRESS = 6;
	public static final int VALUE_LITERAL = 7;
	
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
	public char aVal;
	public char bVal;
	public boolean aSet;
	public boolean bSet;
	public boolean opCodeSet;//Needed?
	public boolean assembled;//Unused?
	public boolean sized;
	public boolean located;
	//Set by Preprocess
	public int unvaluedLabelTokens;
	public boolean isDat; //Other preprocess fields invalid if this is true
	public boolean isSpecial;
	public boolean isBasic;
//	public String mnemonic;
	public LexerToken opCodeToken;
	public String aRegister;
	public String bRegister;
	public String aAccessor;
	public String bAccessor;
	public boolean aHasRegister;
	public boolean bHasRegister;
	public boolean aIsAddress;
	public boolean bIsAddress;
	public boolean aHasOperator;
	public boolean bHasOperator;
	public boolean aHasNonAddition;
	public boolean bHasNonAddition;
	public boolean aHasSimpleStack;
	public boolean bHasSimpleStack;
	public boolean aHasOffsetStack;
	public boolean bHasOffsetStack;
	public int bSize;
	public int aStart;
	public int bStart;
	public int dataStart;
	//Classification
	public int aClass;
	public int bClass;
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
		int i = 0;
		for (LexerToken t : processedTokens) {
			if (t instanceof SpecialOpCodeToken) {
				isSpecial = true;
//				mnemonic = ((SpecialOpCodeToken) t).mnemonic;
				inA = true;
				aStart = i + 2;
				opCodeToken = t;
			} else if (t instanceof BasicOpCodeToken) {
				isBasic = true;
				inA = false;
//				mnemonic = ((BasicOpCodeToken) t).mnemonic;
				bStart = i + 2;
				opCodeToken = t;
			} else if (t instanceof DataToken) {
				isDat = true;
				dataStart = i + 1;
			} else if (t instanceof BValueEndToken) {
				inA = true; //Don't bother checking for other starts or ends
				aStart = i + 2;
			} else if (t instanceof AddressStartToken) {
				if (inA) {
					aIsAddress = true;
				} else {
					bIsAddress = true;
				}
			} else if (t instanceof RegisterToken) {
				if (inA) {
					if (aHasRegister) {
						//TODO Exception
						System.out.println("Error");
					}
					aRegister = ((RegisterToken) t).getRegister();
					aHasRegister = true;
				} else {
					if (bHasRegister) {
						//TODO Exception
						System.out.println("Error");
					}
					bRegister = ((RegisterToken) t).getRegister();
					bHasRegister = true;
				}
			} else if (t instanceof SimpleStackAccessToken) {
				if (inA) {
					aHasSimpleStack = true;
					aAccessor = ((SimpleStackAccessToken)t).accessor;
				} else {
					bHasSimpleStack = true;
					bAccessor = ((SimpleStackAccessToken)t).accessor;
				}
			} else if (t instanceof OffsetStackAccessToken) {
				if (inA) {
					aHasOffsetStack = true;
				} else {
					bHasOffsetStack = true;
				}
			} else if (t instanceof LabelToken) {
				if (!((LabelToken) t).valueSet) {
					unvaluedLabelTokens++;
				}
			} else if (t instanceof OperatorToken || t instanceof GroupStartToken) {
				if (inA) {
					aHasOperator = true;
					if (!"+".equals(t.getText())) {
						aHasNonAddition = true;
					}
				} else {
					bHasOperator = true;
					if (!"+".equals(t.getText())) {
						bHasNonAddition = true;
					}
				}
			} else if (t instanceof UnaryOperatorToken) {
				if (inA) {
					aHasOperator = true;
					aHasNonAddition = true;
				} else {
					bHasOperator = true;
					bHasNonAddition = true;
				}
			}
			i++;
		}
		
		//classify();
		if (isSpecial || isBasic) {
			if (aHasRegister && !aIsAddress && !aHasOperator) {
				aClass = VALUE_REGISTER;
				int idx = Assembly.REGISTERS.indexOf(aRegister);
				if (idx == -1) {
					if ("SP".equals(aRegister)) {
						aVal = 0x1b;
					} else if ("PC".equals(aRegister)) {
						aVal = 0x1c;
					} else { //EX
						aVal = 0x1d;
					}
				} else {
					aVal = (char) idx;
				}
				aSet = true;
			} else if (aHasRegister && aIsAddress) {
				int idx = Assembly.REGISTERS.indexOf(aRegister);
				if (aHasOperator) {
					if (idx == -1) {
						if ("SP".equals(aRegister)) {
							aClass = VALUE_OFFSET_STACK;
							aVal = 0x1a;
						} else {
							//TODO Exception (PC/EX)
							System.out.println("Error");
						}
					} else {
						aClass = VALUE_REGISTER_OFFSET_MEMORY;
						aVal = (char) (0x10 + idx);
					}
				} else {
					aClass = VALUE_REGISTER_MEMORY;
					if (idx == -1) {
						//TODO Exception (PC/EX) (SP ruled out by lexer behavior)
						System.out.println("Error");
					}
					aVal = (char) (0x08 + idx);
				}
				aSet = true;
			} else if (aHasSimpleStack) {
				aClass = VALUE_SIMPLE_STACK;
				if ("POP".equals(aAccessor) || "[SP++]".equals(aAccessor)) {
					aVal = 0x18;
				} else { //[SP]/PEEK
					aVal = 0x19;
				}
				aSet = true;
			} else if (aHasOffsetStack) {
				aClass = VALUE_OFFSET_STACK;
				aVal = 0x1a;
				aSet = true;
			} else if (aIsAddress) {
				aClass = VALUE_LITERAL_ADDRESS;
				aVal = 0x1e;
				aSet = true;
			} else if (!aIsAddress && !aHasSimpleStack && !aHasOffsetStack && !aHasRegister) {
				aClass = VALUE_LITERAL;
			} else {
				System.out.println(1);
			}
	
			if (isSpecial) { 
				opCode = (char) OpCodes.special.getId(((SpecialOpCodeToken)opCodeToken).mnemonic);
				switch (aClass) { //Early sizing
				case VALUE_REGISTER:
				case VALUE_REGISTER_MEMORY:
				case VALUE_SIMPLE_STACK:
					size = 1;
					sized = true;
					break;
				case VALUE_LITERAL_ADDRESS:
				case VALUE_OFFSET_STACK:
				case VALUE_REGISTER_OFFSET_MEMORY:
					size = 2;
					sized = true;
				}
			} else {
				opCode = (char) OpCodes.basic.getId(((BasicOpCodeToken)opCodeToken).mnemonic);
				if (bHasRegister && !bIsAddress && !bHasOperator) {
					bClass = VALUE_REGISTER;
					int idx = Assembly.REGISTERS.indexOf(bRegister);
					if (idx == -1) {
						if ("SP".equals(bRegister)) {
							bVal = 0x1b;
						} else if ("PC".equals(bRegister)) {
							bVal = 0x1c;
						} else { //EX
							bVal = 0x1d;
						}
					} else {
						bVal = (char) idx;
					}
					bSet = true;
				} else if (bHasRegister && bIsAddress) {
					int idx = Assembly.REGISTERS.indexOf(bRegister);
					if (bHasOperator) {
						if (idx == -1) {
							if ("SP".equals(bRegister)) {
								bClass = VALUE_OFFSET_STACK;
								bVal = 0x1a;
							} else {
								//TODO Exception (PC/EX)
								System.out.println("Error");
							}
						} else {
							bClass = VALUE_REGISTER_OFFSET_MEMORY;
							bVal = (char) (0x10 + idx);
						}
					} else {
						bClass = VALUE_REGISTER_MEMORY;
						if (idx == -1) {
							//TODO Exception (PC/EX) (SP ruled out by lexer behavior)
							System.out.println("Error");
						}
						bVal = (char) (0x08 + idx);
					}
					bSet = true;
				} else if (bHasSimpleStack) {
					bClass = VALUE_SIMPLE_STACK;
					if ("PUSH".equals(bAccessor) || "[--SP]".equals(bAccessor)) {
						bVal = 0x18;
					} else { //[SP]/PEEK
						bVal = 0x19;
					}
					bSet = true;
				} else if (bHasOffsetStack) {
					bClass = VALUE_OFFSET_STACK;
					bVal = 0x1a;
					bSet = true;
				} else if (bIsAddress) {
					bClass = VALUE_LITERAL_ADDRESS;
					bVal = 0x1e;
					bSet = true;
				} else {
					bClass = VALUE_LITERAL;
					bVal = 0x1f;
					bSet = true;
				}
				switch (aClass) { //Early sizing
				case VALUE_REGISTER:
				case VALUE_REGISTER_MEMORY:
				case VALUE_SIMPLE_STACK:
					switch (bClass) {
					case VALUE_REGISTER:
					case VALUE_REGISTER_MEMORY:
					case VALUE_SIMPLE_STACK:
						size = 1;
						sized = true;
						break;
					case VALUE_LITERAL_ADDRESS:
					case VALUE_OFFSET_STACK:
					case VALUE_REGISTER_OFFSET_MEMORY:
					case VALUE_LITERAL:
						bSize = 1;
						size = 2;
						sized = true;
					}
					break;
				case VALUE_LITERAL_ADDRESS:
				case VALUE_OFFSET_STACK:
				case VALUE_REGISTER_OFFSET_MEMORY:
					switch (bClass) {
					case VALUE_REGISTER:
					case VALUE_REGISTER_MEMORY:
					case VALUE_SIMPLE_STACK:
						size = 2;
						sized = true;
						break;
					case VALUE_LITERAL_ADDRESS:
					case VALUE_OFFSET_STACK:
					case VALUE_REGISTER_OFFSET_MEMORY:
					case VALUE_LITERAL:
						bSize = 1;
						size = 3;
						sized = true;
					}
					break;
				case VALUE_LITERAL:
					switch (bClass) {
					case VALUE_REGISTER:
					case VALUE_REGISTER_MEMORY:
					case VALUE_SIMPLE_STACK:
						bSize = 0;
						break;
					case VALUE_LITERAL_ADDRESS:
					case VALUE_OFFSET_STACK:
					case VALUE_REGISTER_OFFSET_MEMORY:
					case VALUE_LITERAL:
						bSize = 1;
					}
				}
			}
		} else if (!isDat) {
			sized = true;
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
