package exp4j_int_custom;

/**
 * this classed is used to create custom functions for exp4j<br/>
 * <br/>
 * <b>Example</b><br/>
 * <code><pre>{@code}	
 * CustomFunction fooFunc = new CustomFunction("foo") {
 * 		public int applyFunction(int value) {
 * 			return value*Math.E;
 * 		}
 * };
 * int varX=12d;
 * Calculable calc = new ExpressionBuilder("foo(x)").withCustomFunction(fooFunc).withVariable("x",varX).build();
 * assertTrue(calc.calculate() == Math.E * varX);
 * }</pre></code>
 * 
 * @author frank asseg
 * 
 */
public abstract class CustomFunction {
	final int argc;

	final String name;

	/**
	 * create a new single value input CustomFunction with a set name
	 * 
	 * @param value
	 *            the name of the function (e.g. foo)
	 */
	protected CustomFunction(String name) throws InvalidCustomFunctionException {
		this.argc = 1;
		this.name = name;
		int firstChar = (int) name.charAt(0);
		if ((firstChar < 65 || firstChar > 90) && (firstChar < 97 || firstChar > 122)) {
			throw new InvalidCustomFunctionException("functions have to start with a lowercase or uppercase character");
		}
	}

	/**
	 * create a new single value input CustomFunction with a set name
	 * 
	 * @param value
	 *            the name of the function (e.g. foo)
	 */
	protected CustomFunction(String name, int argumentCount) throws InvalidCustomFunctionException {
		this.argc = argumentCount;
		this.name = name;
	}

	public int getArgumentCount(){
		return argc;
	}
	
	public abstract int applyFunction(int... args);
}
