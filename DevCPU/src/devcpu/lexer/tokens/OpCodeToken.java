package devcpu.lexer.tokens;

public interface OpCodeToken {
	public void setAValueNextWord(boolean nextWord);
	public void setBValueNextWord(boolean nextWord);
	public boolean isNextWordA();
	public boolean isNextWordB();
}
