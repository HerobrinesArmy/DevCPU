package devcpu.ast;

public class DefaultNode implements Node {
	private String text;
	private CodeLocator locator;

	public DefaultNode (String text, CodeLocator locator) {
		this.text = text;
		this.locator = locator;
	}
	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public CodeLocator getCodeLocator() {
		return locator;
	}
}
