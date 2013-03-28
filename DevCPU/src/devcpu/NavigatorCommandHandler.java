package devcpu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import devcpu.assembler.Assembly;
import devcpu.assembler.exceptions.AbstractAssemblyException;
import devcpu.emulation.DefaultControllableDCPU;
import devcpu.emulation.FloppyDisk;
import devcpu.views.DeviceManagerLabelProvider;

public class NavigatorCommandHandler implements IHandler {
	private static final String ASSEMBLE_TO_FLOPPY = "AssembleToFloppy";
	private static final String ASSEMBLE_TO_DCPU = "AssembleToDCPU";
	private static final String WRITE_TO_FLOPPY = "WriteToFloppy";
	private static final String WRITE_TO_DCPU = "WriteToDCPU";

	LinkedHashSet<IHandlerListener> listeners = new LinkedHashSet<IHandlerListener>();

	@Override
	public void addHandlerListener(IHandlerListener listener) {
		listeners.add(listener);
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (event.getCommand().getId().equals(ASSEMBLE_TO_FLOPPY)) {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof IFile) {
					final IFile file = (IFile) firstElement;
					ArrayList<FloppyDisk> disks = Activator.getShip().getFloppyManager().getAvailableDisks();
					for (FloppyDisk disk : new ArrayList<FloppyDisk>(disks)) {
						if (disk.isWriteProtected()) {
							disks.remove(disk);
						}
					}
					final ElementListSelectionDialog listDialog = new ElementListSelectionDialog(HandlerUtil.getActiveShell(event), new DeviceManagerLabelProvider()); //$NON-NLS-1$
					listDialog.setElements(disks.toArray());
					listDialog.setEmptyListMessage("There aren't any unprotected floppies available that aren't currently inserted in a floppy drive.");
					listDialog.setEmptySelectionMessage("Select a floppy disk");
					listDialog.setMessage("Choose the floppy disk on which to assemble the file.\nExisting disk contents will be zeroed prior to assembly.");
					// listDialog.setMultipleSelection(false); //TODO consider allowing multiple selection. Why the hell not?
					listDialog.setTitle("Assemble to Floppy");
					int open = listDialog.open();
					if (open == ListSelectionDialog.OK) {
						Object[] res = listDialog.getResult();
						for (Object o : res) {
							if (o instanceof FloppyDisk) {
								final FloppyDisk disk = (FloppyDisk) o;
								Job job = new Job("Assemble " + file.getName()) {
									protected IStatus run(IProgressMonitor monitor) {
										monitor.beginTask("Assembling " + file.getName() + "...", IProgressMonitor.UNKNOWN);
										try {
											IOConsoleOutputStream os = Activator.getConsole().newOutputStream();
											long start = System.nanoTime();
											Assembly a = new Assembly(file);
											a.assemble(disk);
											long stop = System.nanoTime();
											os.write(file.getName() + " (" + a.getLineCount() + " lines in " + a.getFileCount() + " files) was loaded and assembled to " + disk.getID() + " in " + (int)((stop-start)/1e6f) + " milliseconds using " + a.getPasses() + " sizing passes. Assembled size is " + a.getSize() + " words. Assembly reports " + a.getMissedShortLiteralEstimate() + " missed opportunities for short literals. " + a.getAssembledShortLiteralCount() + " values were optimized to short literals (" + 100*a.getAssembledShortLiteralCount() / ((float)(a.getAssembledShortLiteralCount() + a.getMissedShortLiteralEstimate())) + "% of possible).\n");
										} catch (AbstractAssemblyException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (UnknownFunctionException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (UnparsableExpressionException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (CoreException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										monitor.done();
										return Status.OK_STATUS;
									}
								};
								job.setUser(true);
								job.schedule();
							}
						}
					}
				}
			}
		} else if (event.getCommand().getId().equals(ASSEMBLE_TO_DCPU)) {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof IFile) {
					final IFile file = (IFile) firstElement;
					ArrayList<DefaultControllableDCPU> dcpus = Activator.getShip().getDCPUManager().getDCPUs();
					final ElementListSelectionDialog listDialog = new ElementListSelectionDialog(HandlerUtil.getActiveShell(event), new DeviceManagerLabelProvider()); //$NON-NLS-1$
					listDialog.setElements(dcpus.toArray());
					listDialog.setEmptyListMessage("There aren't any DCPUs available.");
					listDialog.setEmptySelectionMessage("Select a DCPU");
					listDialog.setMessage("Choose the DCPU on which to assemble the file.\nExisting memory contents will be zeroed prior to assembly.");
					// listDialog.setMultipleSelection(false); //TODO consider allowing multiple selection. Why the hell not?
					listDialog.setTitle("Assemble to DCPU");
					int open = listDialog.open();
					if (open == ListSelectionDialog.OK) {
						Object[] res = listDialog.getResult();
						for (Object o : res) {
							if (o instanceof DefaultControllableDCPU) {
								final DefaultControllableDCPU dcpu = (DefaultControllableDCPU) o;
								Job job = new Job("Assemble " + file.getName()) {
									protected IStatus run(IProgressMonitor monitor) {
										monitor.beginTask("Assembling " + file.getName() + "...", IProgressMonitor.UNKNOWN);
										try {
											IOConsoleOutputStream os = Activator.getConsole().newOutputStream();
											long start = System.nanoTime();
											Assembly a = new Assembly(file);
											a.assemble(dcpu);
											long stop = System.nanoTime();
											os.write(file.getName() + " (" + a.getLineCount() + " lines in " + a.getFileCount() + " files) was loaded and assembled to " + dcpu.getID() + "'s RAM in " + (int)((stop-start)/1e6f) + " milliseconds using " + a.getPasses() + " sizing passes. Assembled size is " + a.getSize() + " words. Assembly reports " + a.getMissedShortLiteralEstimate() + " missed opportunities for short literals. " + a.getAssembledShortLiteralCount() + " values were optimized to short literals (" + 100*a.getAssembledShortLiteralCount() / ((float)(a.getAssembledShortLiteralCount() + a.getMissedShortLiteralEstimate())) + "% of possible).\n");
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (AbstractAssemblyException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (UnknownFunctionException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (UnparsableExpressionException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (CoreException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										monitor.done();
										return Status.OK_STATUS;
									}
								};
								job.setUser(true);
								job.schedule();
							}
						}
					}
				}
			}
		} else if (event.getCommand().getId().equals(WRITE_TO_FLOPPY)) {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof IFile) {
					IFile file = (IFile) firstElement;
					ArrayList<FloppyDisk> disks = Activator.getShip().getFloppyManager().getAvailableDisks();
					for (FloppyDisk disk : new ArrayList<FloppyDisk>(disks)) {
						if (disk.isWriteProtected()) {
							disks.remove(disk);
						}
					}
					final ElementListSelectionDialog listDialog = new ElementListSelectionDialog(HandlerUtil.getActiveShell(event), new DeviceManagerLabelProvider()); //$NON-NLS-1$
					listDialog.setElements(disks.toArray());
					listDialog.setEmptyListMessage("There aren't any unprotected floppies available that aren't currently inserted in a floppy drive.");
					listDialog.setEmptySelectionMessage("Select a floppy disk");
					listDialog.setMessage("Choose the floppy disk on which to write the file.\nExisting disk contents will be zeroed prior to writing.");
					// listDialog.setMultipleSelection(false); //TODO consider allowing multiple selection. Why the hell not?
					listDialog.setTitle("Write to Floppy");
					int open = listDialog.open();
					if (open == ListSelectionDialog.OK) {
						Object[] res = listDialog.getResult();
						for (Object o : res) {
							if (o instanceof FloppyDisk) {
								try {
									((FloppyDisk) o).load(file.getRawLocation().makeAbsolute().toFile());
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		} else if (event.getCommand().getId().equals(WRITE_TO_DCPU)) {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof IFile) {
					IFile file = (IFile) firstElement;
					ArrayList<DefaultControllableDCPU> dcpus = Activator.getShip().getDCPUManager().getDCPUs();
					final ElementListSelectionDialog listDialog = new ElementListSelectionDialog(HandlerUtil.getActiveShell(event), new DeviceManagerLabelProvider()); //$NON-NLS-1$
					listDialog.setElements(dcpus.toArray());
					listDialog.setEmptyListMessage("There aren't any DCPUs available.");
					listDialog.setEmptySelectionMessage("Select a DCPU");
					listDialog.setMessage("Choose the DCPU on which to write the file.\nExisting memory contents will be zeroed prior to writing.");
					// listDialog.setMultipleSelection(false); //TODO consider allowing multiple selection. Why the hell not?
					listDialog.setTitle("Write to DCPU");
					int open = listDialog.open();
					if (open == ListSelectionDialog.OK) {
						Object[] res = listDialog.getResult();
						for (Object o : res) {
							if (o instanceof DefaultControllableDCPU) {
								try {
									((DefaultControllableDCPU) o).load(file.getRawLocation().makeAbsolute().toFile());
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener listener) {
		listeners.remove(listener);
	}
}
