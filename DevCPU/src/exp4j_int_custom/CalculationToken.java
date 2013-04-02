package exp4j_int_custom;

import java.util.Map;
import java.util.Stack;

abstract class CalculationToken extends Token {

	CalculationToken(String value) {
		super(value);
	}

	abstract void mutateStackForCalculation(Stack<Integer> stack, Map<String, Integer> variableValues);

}