package devcpu.editors.dasm;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;

public class DASMDocumentSetupParticipant implements IDocumentSetupParticipant {
	@Override
	public void setup(IDocument document) {
		IDocumentPartitioner partitioner= new devcpu.editors.dasm.DASMPartitioner(); // FastPartitioner(DASMInsanePartitionScanner.get(), DASMInsanePartitionScanner.DASM_PARTITION_TYPES);
		partitioner.connect(document);
	}
}
