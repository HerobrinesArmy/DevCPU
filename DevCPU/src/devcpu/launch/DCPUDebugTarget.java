package devcpu.launch;

import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IMemoryBlockExtension;
import org.eclipse.debug.core.model.IMemoryBlockRetrievalExtension;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;

import devcpu.emulation.DefaultControllableDCPU;

public class DCPUDebugTarget extends DebugElement implements IDebugTarget, IMemoryBlockRetrievalExtension {
	boolean fTerminate = false;
	boolean fSuspend = true;
	
	protected ILaunch fLaunch;
	protected DCPUEngine engine;// = new DCPUEngine();
	protected ArrayList fMemoryBlocks = new ArrayList();
	protected IThread fThread;
	protected boolean fBusy;
	private DefaultControllableDCPU dcpu;
	
	
	/**
	 * Creates SampleDebugTarget
	 * @param launch the launch this debug target belongs to
	 * @param dcpu 
	 */
	public DCPUDebugTarget(ILaunch launch, DefaultControllableDCPU dcpu) {
		super(null);
		fLaunch = launch;
		this.dcpu = dcpu;
		this.engine = new DCPUEngine(dcpu);
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
		System.out.println("DCPUDebugTarget");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getProcess()
	 */
	public IProcess getProcess() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
	 */
	public boolean hasThreads() throws DebugException {
		//XXX hit in debug perspective
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		
		return false; //TODO
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		//XXX hit in debug perspective
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		//XXX hit in debug perspective
		return fLaunch;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		//XXX hit in debug perspective
		return !fTerminate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		//XXX hit
		return fTerminate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
	//XXX hit upon exit
		fTerminate = true;
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return fSuspend && !fTerminate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		//XXX hit in debug perspective
		return !fSuspend && !fTerminate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		//XXX hit in debug perspective
		return fSuspend;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		fSuspend = false;
		engine.resume();
		fireEvent(new DebugEvent(this, DebugEvent.RESUME));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		fSuspend = true;		
		fireEvent(new DebugEvent(getEngine().getThreads(this)[0], DebugEvent.SUSPEND));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public void breakpointAdded(IBreakpoint breakpoint) {
		//TODO
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		//TODO
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
		//XXX hit in debug perspective
		//TODO
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	public void disconnect() throws DebugException {
		

	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	public boolean isDisconnected() {
		//XXX hit
		
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
	 */
	public boolean supportsStorageRetrieval() {
		//XXX hit in debug perspective from MemoryViewUtil
		return true;
	}	
	
	/**
	 * @return the debug engine
	 */
	public DCPUEngine getEngine()
	{
		return engine;
	}

	/**
	 * Remove the memory block from this debug session.
	 * @param memBlk
	 */
	public void removeMemoryBlock(IMemoryBlock memBlk)
	{
		fMemoryBlocks.remove(memBlk);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		 System.out.println("ERMAHGERD, ERM NERT ERMPLERMERNTERD!");
		return null;
	}

	public Object getAdapter(Class adapter) {
		//XXX hit in debug perspective for IModelProxyFactory2, IModelProxyFactory, IElementLabelProvider, IDebugModelProvider, ILaunch, ISourceDisplay, IMemoryBlockRetrieval, IElementMememntoProvider, IElementContentProvider, IColumnPresentationFactory, IAddMemoryBlocksTarget, IViewerInputProvider, ITerminateHandler, IStepIntoHandler, IStepFiltersHandler, ISuspendHandler, IDropToFrameHandler, IRestartHandler, IStepReturnHandler, IStepOverHandler, IResumeHandler, IDisconnectHandler, IModelSelectionPolicyFactory, IViewActionProvider
		
		if (adapter == ILaunch.class)
			return getLaunch();
		
		return super.getAdapter(adapter);
	}

	public IThread[] getThreads() throws DebugException {
		//XXX hit in debug perspective
//		if (isTerminated())
			return new IThread[0];
		
//		return getEngine().getThreads(this);
	}

	public String getName() throws DebugException {
		//XXX hit in debug perspective
		return "[Debug Target:] " + dcpu.getID();
	}

	public String getModelIdentifier() {
		//XXX hit in debug perspective
		return "example.debug.memoryview";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrievalExtension#getExtendedMemoryBlock(java.lang.String, java.lang.Object)
	 */
	public IMemoryBlockExtension getExtendedMemoryBlock(String expression, Object context) throws DebugException {

		//XXX hit upon adding memory view
		// ask debug engine for an address
		BigInteger address = new BigInteger(expression);// getEngine().evaluateExpression(expression, context);
		
		// if address can be evaluated to an address, create memory block
		if (address != null)
		{
			IMemoryBlockExtension memoryBlock =  new DCPUMemoryBlock(dcpu);//TODO
			fMemoryBlocks.add(memoryBlock);
			
			return memoryBlock;
		}
		// otherwise throw debug exception
		IStatus status = new Status(IStatus.ERROR, "example.debug.memoryview", 0, "Expression cannot be evaluated to an address", null);
		DebugException exception = new DebugException(status);
		throw exception;
	}
}
