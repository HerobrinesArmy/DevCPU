package devcpu.launch;

import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IMemoryBlockRetrieval;
import org.eclipse.debug.core.model.MemoryByte;
import org.eclipse.debug.ui.memory.IMemoryBlockTablePresentation;

import devcpu.emulation.DefaultControllableDCPU;

public class DCPUMemoryBlock extends DebugElement implements IMemoryBlock {

	private String expression;
	private DefaultControllableDCPU dcpu;

	private boolean enabled = true;
//	private BigInteger baseAddress;

	private ArrayList<Object> connections = new ArrayList<Object>();
	private DCPUDebugTarget target;
		
	public DCPUMemoryBlock(DefaultControllableDCPU dcpu, DCPUDebugTarget target) {
		super(target);
		this.dcpu = dcpu;
		this.target = target;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getBigBaseAddress()
	 */
	public BigInteger getBigBaseAddress() throws DebugException {
		System.out.println("DCPUMemoryBlock getBigBaseAddress");
		return BigInteger.valueOf(0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#supportBaseAddressModification()
	 */
	public boolean supportBaseAddressModification() throws DebugException {
		System.out.println("DCPUMemoryBlock supportBAM");
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#setBaseAddress(java.math.BigInteger)
	 */
	public void setBaseAddress(BigInteger address) throws DebugException {
		System.out.println("DCPUMemoryBlock SetBAM");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getBytesFromOffset(long, long)
	 */
	synchronized public MemoryByte[] getBytesFromOffset(BigInteger offset, long length) throws DebugException {
		System.out.println("DCPUMemoryBlock getBytesFromOffset");
		return getBytesFromAddress(offset, length);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getBytesFromAddress(java.math.BigInteger, long)
	 */
	public MemoryByte[] getBytesFromAddress(BigInteger address, long length) throws DebugException {
		System.out.println("DCPUMemoryBlock getBytesFromAddress");
		
		try {
			MemoryByte[] bytes = new MemoryByte[(int)length * 2];
			int lengthCnt = (int)length;
			int i=0;
			
			// asks engine to get bytes from address
			MemoryByte[] dcpuBytes =  dcpu.getBytesFromAddress(address.intValue(), lengthCnt);
			System.arraycopy(dcpuBytes, 0, bytes, i, dcpuBytes.length);
			
			// if engine did not return enough memory, pad with dummy memory
			for (int j=i+dcpuBytes.length; j<bytes.length;j++)
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
		System.out.println("DCPUMemoryBlock connect");
		
		if (!connections.contains(object)) {
			connections.add(object);
		}
		
		if (connections.size() == 1) {
			enable();
		}
	}
	
	/**
	 * Enable this memory block
	 */
	private void enable()
	{
		enabled = true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#disconnect(java.lang.Object)
	 */
	public void disconnect(Object object) {
		System.out.println("DCPUMemoryBlock disconnect from " + object + " (" + object.getClass().getCanonicalName()+ ")");
		
		if (connections.contains(object)) {
			connections.remove(object);
		}
		
		if (connections.size() == 0) {
			disable();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getConnected()
	 */
	public Object[] getConnections() {
		return connections.toArray();
	}
	
	/**
	 * Disable this memory block
	 */
	private void disable()
	{
		enabled = false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getStartAddress()
	 */
	public long getStartAddress() {
		System.out.println("DCPUMemoryBlock getStartAddress");
		return 0;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getLength()
	 */
	public long getLength() {
		System.out.println("DCPUMemoryBlock getLength");
		return 64;//65536*2;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#getBytes()
	 */
	public byte[] getBytes() throws DebugException {
		System.out.println("DCPUMemoryBlock getBytes!!!!!!!!!!!!!!");
		return new byte[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#supportsValueModification()
	 */
	public boolean supportsValueModification() {
		System.out.println("DCPUMemoryBlock supportsVM");
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#setValue(long, byte[])
	 */
	public void setValue(BigInteger offset, byte[] bytes) throws DebugException {
		System.out.println("DCPUMemoryBlock setValue!!");
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
		return target;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return target.getLaunch();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		//XXX Asked for ILabelDecorator, IPersistableDebugElement, IModelProxyFactory, IAsynchronousContentAdapter, IMemoryBlockTablePresentation
//		if (adapter.equals(IAsynchronousContentAdapter.class)) {
//			return new MemoryBlockContentAdapter();
//		}
		if (adapter.equals(IMemoryBlockTablePresentation.class)) {
			return DCPUModelPresentation.getDCPUModelPresentation();
		}
//		if (adapter.equals(IPersistableDebugElement.class)) {
//			
//		}
//		if (adapter.equals(IModelProxyFactory.class)) {
//			return new DefaultModelProxyFactory(); //TODO
//		}
		if (adapter.equals(IMemoryBlockRetrieval.class)) {
			return getDebugTarget();
		}
		System.out.println("DCPUMemoryBlock getAdapter " + adapter.getCanonicalName());
		//TODO
//		if (adapter.equals(IMemoryBlockRetrievalExtension.class))
//			return getDebugTarget();	
//
//		if (adapter == IColorProvider.class)
//		{
//			return DCPUModelPresentation.getDCPUModelPresentation();
//		}
		return target.getAdapter(adapter);//super.getAdapter(adapter);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getExpression()
	 */
	public String getExpression() {
		return expression;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#dispose()
	 */
	public void dispose() throws DebugException {		
		target.removeMemoryBlock(this);
		System.out.println("DCPUMemoryBlock dispose");
	}

	/**
	 * @return is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/* (non-Javadoc)
	 * @see com.ibm.debug.extended.ui.IMemoryBlockExtension#getMemoryBlockRetrieval()
	 */
	public IMemoryBlockRetrieval getMemoryBlockRetrieval() {
		return target;
	}

	/* (non-Javadoc)
	 * @see com.ibm.debug.extended.ui.IMemoryBlockExtension#isMemoryChangesManaged()
	 */
	public boolean supportsChangeManagement() {
		//TODO
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
		return BigInteger.valueOf(0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getMemoryBlockEndAddress()
	 */
	public BigInteger getMemoryBlockEndAddress() throws DebugException {
		return BigInteger.valueOf(65535);//TODO or 128?
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlock#setValue(long, byte[])
	 */
	public void setValue(long offset, byte[] bytes) throws DebugException {
		System.out.println("DCPUMemoryBlock setValue!!!!!!!!!!");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockExtension#getBigLength()
	 */
	public BigInteger getBigLength() throws DebugException{
		System.out.println("DCPUMemoryBlock getBigLength");
		return BigInteger.valueOf(65536);
	}
}
