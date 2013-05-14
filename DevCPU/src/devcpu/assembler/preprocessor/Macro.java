package devcpu.assembler.preprocessor;

import java.util.ArrayList;

public class Macro {
	public String name;
	public ArrayList<String> lines = new ArrayList<String>();
	public ArrayList<String> params = new ArrayList<String>();
	
	public Macro(String name, String params) {
		this.name = name;
		if (params != null) {
			for (String param : params.trim().split("\\s*\\,\\s*")) {
				this.params.add(param);
			}
		}
	}
}
