package devcpu.assembler.expression;

import java.util.ArrayList;
import java.util.List;

import devcpu.lexer.tokens.GroupEndToken;
import devcpu.lexer.tokens.GroupStartToken;
import devcpu.lexer.tokens.LabelToken;
import devcpu.lexer.tokens.LexerToken;
import devcpu.lexer.tokens.LiteralToken;
import devcpu.lexer.tokens.OffsetStackAccessToken;
import devcpu.lexer.tokens.OperatorToken;
import devcpu.lexer.tokens.PickValueEndToken;
import devcpu.lexer.tokens.PickValueStartToken;
import devcpu.lexer.tokens.RegisterToken;
import devcpu.lexer.tokens.SimpleStackAccessToken;
import devcpu.lexer.tokens.UnaryOperatorToken;

public class Group implements Operand {
	private ArrayList<Value> values = new ArrayList<Value>();
	public boolean unresolvableLabel; //Only for use by Assembly.sizeExpressionA()
	
	public Group (LexerToken[] tokens, int i, Class<? extends LexerToken> terminator) {
		LexerToken token = null;
		while (!terminator.isInstance(token = tokens[++i])) {
			if (token instanceof GroupStartToken) {
				Group group = new Group(tokens,i,GroupEndToken.class);
				if (group.unresolvableLabel) {
					this.unresolvableLabel = true;
					return;
				}
				values.add(group);
				while (!(tokens[++i] instanceof GroupEndToken)) {}
			} else if (token instanceof PickValueStartToken) {
				values.add(new PickValue(tokens, i, PickValueEndToken.class));
				while (!(tokens[++i] instanceof PickValueEndToken)) {}
			} else if (token instanceof LabelToken) {
				if (!((LabelToken) token).valueSet) {
					this.unresolvableLabel = true;
					return;
				}
				values.add(new Literal(token,((LabelToken)token).value));
			} else if (token instanceof RegisterToken) {
				values.add(new Register((RegisterToken)token));
			} else if (token instanceof LiteralToken) {
				values.add(new Literal(token, ((LiteralToken)token).getValue()));
			} else if (token instanceof OperatorToken) {
				values.add(new Operator(token));
			} else if (token instanceof UnaryOperatorToken) {
				values.add(new UnaryOperator(token));
			} else if (token instanceof SimpleStackAccessToken) {
				values.add(new SimpleStackAccessor((SimpleStackAccessToken) token));
			} else if (token instanceof OffsetStackAccessToken) {
				//I suppose I don't actually have to do anything with this. Better check to make sure this doesn't need 
				//special handling in the case where there's a hard-to-resolve label used ( [sp+the_label] )
			} else {
				System.out.println("ERMAHGERD YER FERGERT ERBERT " + token.getClass().getCanonicalName());
			}
		}
	}
	
	public List<Value> getValues() {
		return values;
	}

	@Override
	public boolean containsRegister() {
		for (Value value : values) {
			if (value instanceof Operand) {
				if (((Operand)value).containsRegister()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Register> getRegisters() {
		List<Register> list = new ArrayList<Register>();
		for (Value value : values) {
			if (value instanceof Group) {
				list.addAll(((Group)value).getRegisters());
			} else if (value instanceof Register) {
				list.add((Register) value);
			}
		}
		return list;
	}

	public boolean isExpression() {
		if (values.size() != 1) {
			return true;
		} else if (values.get(0) instanceof Group) {
			return true;
		}
		return false;
	}

	public String getExpression() {
		String expression = "(";
		for (Value value : values) {
			expression += value.getExpression();
		}
		return expression + ")";
	}

	public boolean hasSimpleStackAccessor() {
		for (Value value : values) {
			if (value instanceof Group) {
				if (((Group) value).hasSimpleStackAccessor()) {
					return true;
				}
			} else if (value instanceof SimpleStackAccessor) {
				return true;
			}
		}
		return false;
	}
	
	public SimpleStackAccessor getSimpleStackAccessor() {
		for (Value value : values) {
			if (value instanceof Group) {
				SimpleStackAccessor accessor = ((Group) value).getSimpleStackAccessor();
				if (accessor != null) {
					return accessor;
				}
			} else if (value instanceof SimpleStackAccessor) {
				return (SimpleStackAccessor) value;
			}
		}
		return null;
	}

	public boolean scanForRegistersInUnaryOperations() {
		Value lastValue = null;
		for (Value value : values) {
			if (lastValue instanceof UnaryOperator) {
				if (value instanceof Register) {
					return true;
				} else if (value instanceof Group) {
					if (((Group) value).containsRegister()) {
						return true;
					}
				}
			}
			if (value instanceof Group) {
				if (((Group) value).scanForRegistersInUnaryOperations()) {
					return true;
				}
			}
			lastValue = value;
		}
		return false;
	}

	public boolean scanForRegistersBeingSubtracted() {
		Value lastValue = null;
		for (Value value : values) {
			if (lastValue instanceof Operator) {
				if (((Operator)lastValue).getOperator().equals("-")) {
					if (value instanceof Register) {
						return true;
					} else if (value instanceof Group) {
						if (((Group) value).containsRegister()) {
							return true;
						}
					}
				}
			}
			if (value instanceof Group) {
				if (((Group) value).scanForRegistersBeingSubtracted()) {
					return true;
				}
			}
			lastValue = value;
		}
		return false;
	}

	public boolean scanForRegistersInDisallowedOperations() {
		Value lastValue = null;
		for (Value value : values) {
			if (lastValue instanceof Operator) {
				if (!((Operator)lastValue).getOperator().equals("+")) {
					if (value instanceof Register) {
						return true;
					} else if (value instanceof Group) {
						if (((Group) value).containsRegister()) {
							return true;
						}
					}
				}
			}
			if (value instanceof Group) {
				if (((Group) value).scanForRegistersInDisallowedOperations()) {
					return true;
				}
			}
			if (value instanceof Operator) {
				if (!((Operator) value).getOperator().equals("+") && !((Operator) value).getOperator().equals("-")) {
					if (lastValue instanceof Register) {
						return true;
					} else if (lastValue instanceof Group) {
						if (((Group) lastValue).containsRegister()) {
							return true;
						}
					}
				}
			}
			lastValue = value;
		}
		return false;
	}

	public boolean hasPickValue() {
		for (Value value : values) {
			if (value instanceof PickValue) {
				return true; //Note: Lexer behavior guarantees pick only occurs as the first value
			}
		}
		return false;
	}
}
