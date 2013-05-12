package devcpu.assembler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import devcpu.util.CountingLineReader;

public class DASMLineLoader implements LineLoader {
	private Assembly assembly;

	public DASMLineLoader(Assembly assembly) {
		this.assembly = assembly;
	}

	public List<RawLine> readLines(final AssemblyDocument document) {
		ArrayList<RawLine> lines = new ArrayList<RawLine>();
		// TODO Don't include in assembly time the time spent prompting user to save
		/*UIJob promptJob = new UIJob("Promp to save changes") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				return IDE.saveAllEditors(new IResource[] {document.getFile()}, true) ? Status.OK_STATUS : Status.CANCEL_STATUS;
			}

			@Override
			public boolean belongsTo(Object family) {
				return DASMLineLoader.this.equals(family);
			}
		};
		promptJob.schedule();
		try {
			UIJob.getJobManager().join(this, null);
		} catch (OperationCanceledException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		CountingLineReader isr;
		try {
			isr = new CountingLineReader(new InputStreamReader(document.getFile().getContents(true)));
			String lineText = null;
			int n = 0;
			while ((lineText = isr.readLine()) != null) {
				RawLine line = new RawLine(document, ++n, isr.getLastLineOffset(), lineText);
				lines.add(line);
			}
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public Assembly getAssembly() {
		return assembly;
	}
}
