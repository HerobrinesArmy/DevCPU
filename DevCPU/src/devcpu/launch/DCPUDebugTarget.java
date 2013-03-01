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

public class DCPUDebugTarget extends DebugElement implements IDebugTarget, IMemoryBlockRetrievalExtension {
	boolean fTerminate = false;
	boolean fSuspend = true;
	
	protected ILaunch fLaunch;
	protected DCPUEngine fEngine = new DCPUEngine();
	protected ArrayList fMemoryBlocks = new ArrayList();
	protected IThread fThread;
	protected boolean fBusy;
	
	
	/**
	 * Creates SampleDebugTarget
	 * @param launch the launch this debug target belongs to
	 */
	public DCPUDebugTarget(ILaunch launch) {
		super(null);
		fLaunch = launch;
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
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
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		
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
		return fLaunch;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return !fTerminate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return fTerminate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
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
		return !fSuspend && !fTerminate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return fSuspend;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		fSuspend = false;
		fEngine.resume();
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
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	public boolean canDisconnect() {
		
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
		
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
	 */
	public boolean supportsStorageRetrieval() {	
		return true;
	}	
	
	/**
	 * @return the debug engine
	 */
	public DCPUEngine getEngine()
	{
		return fEngine;
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
		 
		return null;
	}

	public Object getAdapter(Class adapter) {
		
		if (adapter == ILaunch.class)
			return getLaunch();
		
		return super.getAdapter(adapter);
	}

	public IThread[] getThreads() throws DebugException {
		if (isTerminated())
			return new IThread[0];
		
		return getEngine().getThreads(this);
	}

	public String getName() throws DebugException {
		return "[Debug Target:] Silly Program";
	}

	public String getModelIdentifier() {
		return "example.debug.memoryview";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrievalExtension#getExtendedMemoryBlock(java.lang.String, java.lang.Object)
	 */
	public IMemoryBlockExtension getExtendedMemoryBlock(String expression, Object context) throws DebugException {
		
		// ask debug engine for an address
		BigInteger address = getEngine().evaluateExpression(expression, context);
		
		// if address can be evaluated to an address, create memory block
		if (address != null)
		{
			IMemoryBlockExtension memoryBlock =  new DCPUMemoryBlock(this, expression, address);
			fMemoryBlocks.add(memoryBlock);
			
			return memoryBlock;
		}
		// otherwise throw debug exception
		IStatus status = new Status(IStatus.ERROR, "example.debug.memoryview", 0, "Expression cannot be evaluated to an address", null);
		DebugException exception = new DebugException(status);
		throw exception;
	}
}
