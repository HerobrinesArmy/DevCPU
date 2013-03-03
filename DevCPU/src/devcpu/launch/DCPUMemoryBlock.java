package devcpu.launch;

import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlockExtension;
import org.eclipse.debug.core.model.IMemoryBlockRetrieval;
import org.eclipse.debug.core.model.IMemoryBlockRetrievalExtension;
import org.eclipse.debug.core.model.MemoryByte;
import org.eclipse.jface.viewers.IColorProvider;

import devcpu.emulation.DefaultControllableDCPU;

public class DCPUMemoryBlock implements IMemoryBlockExtension {//extends DebugElement implements IMemoryBlockExtension {

	private String fExpression;
	private DefaultControllableDCPU fDebugTarget;

	private boolean isEnabled = true;
	private BigInteger fBaseAddress;

	private ArrayList fConnections = new ArrayList();
		
	public DCPUMemoryBlock(DefaultControllableDCPU dcpu) {
		this.fDebugTarget = dcpu;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getBigBaseAddress()
	 */
	public BigInteger getBigBaseAddress() throws DebugException {
//		fBaseAddress = fDebugTarget.getEngine().evaluateExpression(fExpression, null);
		return new BigInteger("0");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#supportBaseAddressModification()
	 */
	public boolean supportBaseAddressModification() throws DebugException {			
		return false;//fDebugTarget.getEngine().suppostsBaseAddressModification(this);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#setBaseAddress(java.math.BigInteger)
	 */
	public void setBaseAddress(BigInteger address) throws DebugException {			
//		try {
//			fDebugTarget.getEngine().setBaseAddress(this, address);
//		} catch (CoreException e) {
//			throw new DebugException(e.getStatus());
//		}			
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getBytesFromOffset(long, long)
	 */
	synchronized public MemoryByte[] getBytesFromOffset(BigInteger offset, long length)
		throws DebugException {
//		BigInteger address = fBaseAddress.subtract(offset);
		return getBytesFromAddress(offset, length);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getBytesFromAddress(java.math.BigInteger, long)
	 */
	public MemoryByte[] getBytesFromAddress(BigInteger address, long length)
		throws DebugException {
		
		try {
			MemoryByte[] bytes = new MemoryByte[(int)length * 2];
			BigInteger addressCnt = address;
			int lengthCnt = (int)length;
			int i=0;
			
			// asks engine to get bytes from address
			MemoryByte[] engineBytes =  fDebugTarget.getBytesFromAddress(address.intValue(), lengthCnt);
			System.arraycopy(engineBytes, 0, bytes, i, engineBytes.length);
			
			// if engine did not return enough memory, pad with dummy memory
			for (int j=i+engineBytes.length; j<bytes.length;j++)
			{
				MemoryByte mb = new MemoryByte((byte)0);
				mb.setReadable(false);
				mb.setWritable(false);
				mb.setBigEndian(true);//fDebugTarget.getEngine().isBigEndian(address.add(BigInteger.valueOf(j))));
				bytes[j] = mb;
			}
			
			return bytes;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#connect(java.lang.Object)
	 */
	public void connect(Object object) {
		
		if (!fConnections.contains(object))
			fConnections.add(object);
		
		if (fConnections.size() == 1)
			enable();		
	}
	
	/**
	 * Enable this memory block
	 */
	private void enable()
	{
		isEnabled = true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#disconnect(java.lang.Object)
	 */
	public void disconnect(Object object) {
			
		if (fConnections.contains(object))
			fConnections.remove(object);
		
		if (fConnections.size() == 0)
			disable();	
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getConnected()
	 */
	public Object[] getConnections() {				
		return fConnections.toArray();		
	}
	
	/**
	 * Disable this memory block
	 */
	private void disable()
	{
		isEnabled = false;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getStartAddress()
	 */
	public long getStartAddress() {
		// no need to implement this method as it belongs to IMemoryBlock
		return 0;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getLength()
	 */
	public long getLength() {
		// no need to implement this method as it belongs to IMemoryBlock
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getBytes()
	 */
	public byte[] getBytes() throws DebugException {
		// no need to implement this method as it belongs to IMemoryBlock
		return new byte[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#supportsValueModification()
	 */
	public boolean supportsValueModification() {
		return true;//fDebugTarget.getEngine().supportsValueModification(this);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#setValue(long, byte[])
	 */
	public void setValue(BigInteger offset, byte[] bytes) throws DebugException {
		//TODO
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return getDebugTarget().getModelIdentifier();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return fDebugTarget;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return fDebugTarget.getLaunch();
	}


	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		
		if (adapter.equals(IMemoryBlockRetrievalExtension.class))
			return getDebugTarget();	

		if (adapter == IColorProvider.class)
		{
			return DCPUModelPresentation.getDCPUModelPresentation();
		}

		return null;//super.getAdapter(adapter);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getExpression()
	 */
	public String getExpression() {
		return  fExpression;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#dispose()
	 */
	public void dispose() throws DebugException {		
		// remove this memory block from debug target
//		fDebugTarget.removeMemoryBlock(this);
	}

	/**
	 * @return is enabled
	 */
	public boolean isEnabled() {
		return isEnabled;
	}

	/* (non-Javadoc)
	 * @see com.ibm.debug.extended.ui.IMemoryBlockExtension#getMemoryBlockRetrieval()
	 */
	public IMemoryBlockRetrieval getMemoryBlockRetrieval() {
		return getDebugTarget();
	}

//	/**
//	 * 
//	 */
//	private void fireContentChangeEvent()
//	{
//		DebugEvent evt = new DebugEvent(this, DebugEvent.CHANGE);
//		//fireEvent(evt);	
//	}

	/* (non-Javadoc)
	 * @see com.ibm.debug.extended.ui.IMemoryBlockExtension#isMemoryChangesManaged()
	 */
	public boolean supportsChangeManagement() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getAddressableSize()
	 */
	public int getAddressableSize() throws DebugException {
		return 2;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getAddressSize()
	 */
	public int getAddressSize() throws DebugException {
		return 2;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getMemoryBlockStartAddress()
	 */
	public BigInteger getMemoryBlockStartAddress() throws DebugException {
		
//		if (true)
//		return fBaseAddress.subtract(BigInteger.valueOf(250));
		// Return null by default.  
		// Null is acceptable if default start address is to be used.
		// Default is 0.
		return BigInteger.valueOf(0);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getMemoryBlockEndAddress()
	 */
	public BigInteger getMemoryBlockEndAddress() throws DebugException {
		
//		if (true)
//			return fBaseAddress.add(BigInteger.valueOf(250));
		// Return null by default.
		// Null is accpetable if default end address is to be used.
		// Default end address is calculated based on address size.
		return BigInteger.valueOf(65535);//TODO or 128?
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#setValue(long, byte[])
	 */
	public void setValue(long offset, byte[] bytes) throws DebugException {
		// do not need to implement for IMemoryBlockExtension
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getBigLength()
	 */
	public BigInteger getBigLength() throws DebugException{
		// return -1 by default and default length is calculated
		return BigInteger.valueOf(-1);
	}
}
