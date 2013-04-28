package devcpu.launch;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IMemoryBlockRetrieval;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStep;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;

import devcpu.assembler.Assembly;
import devcpu.emulation.DefaultControllableDCPU;

public class DCPUDebugTarget extends DebugElement implements IDebugTarget, IMemoryBlockRetrieval, IStep {
	boolean terminated = false;
	boolean connected = false;
	
	protected ILaunch launch;
	protected ArrayList<DCPUMemoryBlock> memoryBlocks = new ArrayList<DCPUMemoryBlock>();
	protected IThread thread;
	private DefaultControllableDCPU dcpu;
	private IProcess process;
	
	private LinkedHashSet<DCPUBreakpoint> breakpoints = new LinkedHashSet<DCPUBreakpoint>();
	private boolean stepping;
	
	/**
	 * Creates DCPUDebugTarget
	 * @param launch the launch this debug target belongs to
	 * @param dcpu 
	 */
	public DCPUDebugTarget(ILaunch launch, DefaultControllableDCPU dcpu) {
		super(null);
		this.launch = launch;
		this.dcpu = dcpu;
		this.process = new DCPUProcess(this);
		this.thread = new DCPUThread(this);
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
		try {
			memoryBlocks.add((DCPUMemoryBlock) getMemoryBlock(0, 65536*2));
		} catch (DebugException e) {
			e.printStackTrace();
		}
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
		DebugPlugin.getDefault().getMemoryBlockManager().addMemoryBlocks(memoryBlocks.toArray(new IMemoryBlock[0]));
		this.connected = true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getProcess()
	 */
	public IProcess getProcess() {
		return process;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
	 */
	public boolean hasThreads() throws DebugException {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		if (breakpoint instanceof DCPUBreakpoint) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return launch;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return !terminated;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return terminated;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		dcpu.stop();
		terminated = true;
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return dcpu.isSuspended() && !terminated;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return !dcpu.isSuspended() && !terminated;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return dcpu.isSuspended();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		dcpu.resume();
		fireEvent(new DebugEvent(this, DebugEvent.RESUME));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		dcpu.suspend();
		fireEvent(new DebugEvent(thread, DebugEvent.SUSPEND));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public void breakpointAdded(IBreakpoint breakpoint) {
		if (breakpoint instanceof DCPUBreakpoint) {
			breakpoints.add((DCPUBreakpoint) breakpoint);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (breakpoint instanceof DCPUBreakpoint) {
			breakpoints.remove((DCPUBreakpoint) breakpoint);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		//TODO
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	public boolean canDisconnect() {
		return connected;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	public void disconnect() throws DebugException {
		connected = false;
		//TODO
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	public boolean isDisconnected() {
		return !connected;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
	 */
	public boolean supportsStorageRetrieval() {
		return true;
	}	

	/**
	 * Remove the memory block from this debug session.
	 * @param memBlk
	 */
	public void removeMemoryBlock(IMemoryBlock memBlk)
	{
		memoryBlocks.remove(memBlk);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		//TODO FIXME XXX
		return new DCPUMemoryBlock(dcpu, this);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getAdapter(Class adapter) {
		//XXX hit in debug perspective for IModelProxyFactory2, IModelProxyFactory, IElementLabelProvider, IDebugModelProvider, ILaunch, ISourceDisplay, IMemoryBlockRetrieval, IElementMememntoProvider, IElementContentProvider, IColumnPresentationFactory, IAddMemoryBlocksTarget, IViewerInputProvider, ITerminateHandler, IStepIntoHandler, IStepFiltersHandler, ISuspendHandler, IDropToFrameHandler, IRestartHandler, IStepReturnHandler, IStepOverHandler, IResumeHandler, IDisconnectHandler, IModelSelectionPolicyFactory, IViewActionProvider
		if (adapter == ILaunch.class) {
			return getLaunch();
		} else if (adapter == IMemoryBlockRetrieval.class) {
			return this;
		} else if (adapter == ILabelProvider.class) {
			return DCPUModelPresentation.getDCPUModelPresentation();
		} else if (adapter == IContentProvider.class) {
			return DCPUModelPresentation.getDCPUModelPresentation();
		} else if (adapter.isAssignableFrom(DCPUModelPresentation.class)) {
			return DCPUModelPresentation.getDCPUModelPresentation();
		}
		System.out.println("DCPUDebugTarget getAdapter " + adapter.getCanonicalName());
		return super.getAdapter(adapter);
	}

	public IThread[] getThreads() throws DebugException {
			return new IThread[]{thread};
	}

	public String getName() {
		return "Debug Target: " + dcpu.getID();
	}

	public String getModelIdentifier() {
		return "devcpu.debugmodel";
	}
//
//	/* (non-Javadoc)
//	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrievalExtension#getExtendedMemoryBlock(java.lang.String, java.lang.Object)
//	 */
//	public IMemoryBlockExtension getExtendedMemoryBlock(String expression, Object context) {
//		//XXX hit upon adding memory view
//		DCPUMemoryBlock memoryBlock =  new DCPUMemoryBlock(dcpu, this);//TODO
//		memoryBlocks.add(memoryBlock);
//		return memoryBlock;
//	}

	public char getRegisterValue(DCPURegister register) {
		//TODO This is stupid.
		String r = register.getName();
		int i = Assembly.REGISTERS.indexOf(r);
		if (i >= 0) {
			return dcpu.registers[i];
		}
		if ("PC".equals(r)) {
			return dcpu.pc;
		}
		if ("SP".equals(r)) {
			return dcpu.sp;
		}
		if ("EX".equals(r)) {
			return dcpu.ex;
		}
		if ("IA".equals(r)) {
			return dcpu.ia;
		}
		return 0;
	}

	public DefaultControllableDCPU getDCPU() {
		return dcpu;
	}

	@Override
	public boolean canStepInto() {
		return false;
	}

	@Override
	public boolean canStepOver() {
		return connected && !stepping && !terminated && (dcpu.isSuspended() || !dcpu.isRunning());
	}

	@Override
	public boolean canStepReturn() {
		return false;
	}

	@Override
	public boolean isStepping() {
		return stepping;
	}

	@Override
	public void stepInto() throws DebugException {
	}

	@Override
	public void stepOver() throws DebugException {
		stepping = true;
		dcpu.step();
		stepping = false;
		fireEvent(new DebugEvent(this, DebugEvent.STEP_OVER));
	}

	@Override
	public void stepReturn() throws DebugException {
	}
}
