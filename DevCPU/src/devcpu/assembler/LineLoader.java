package devcpu.assembler;

import java.util.List;

public interface LineLoader {
	public List<RawLine> readLines(AssemblyDocument document);
}
