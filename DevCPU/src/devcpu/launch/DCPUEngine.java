package devcpu.launch;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.MemoryByte;

public class DCPUEngine {
	Random fRandom = new Random();
	byte[] fMemory;
	Hashtable memoryBlockTable;
	Hashtable expressionAddressTable = new Hashtable();
	Hashtable threadTable = new Hashtable();
	Hashtable stackframeTable = new Hashtable();
	
	Random random = new Random();
	
	/**
	 * Allow debug adapters to get memory from an address
	 * @param address
	 * @param length
	 * @return memory byte from an address
	 * @throws RuntimeException
	 */
	synchronized public MemoryByte[] getBytesFromAddress( BigInteger address, long length)
	throws RuntimeException {
		
		if (memoryBlockTable == null)
		{	
			// create new memoryBlock table
			memoryBlockTable = new Hashtable();
			byte[] bytes = new byte[(int)length*getAddressableSize()];
			BigInteger addressKey = address;
			
			random.nextBytes(bytes);
			
			for (int i=0; i<bytes.length; i=i+getAddressableSize())
			{
				addressKey = addressKey.add(BigInteger.valueOf(1));

				MemoryByte[] byteUnit = new MemoryByte[getAddressableSize()];
				for (int j=0; j<getAddressableSize(); j++)
				{
					MemoryByte oneByte = new MemoryByte(bytes[i+j]);
					oneByte.setBigEndian(isBigEndian(addressKey));
					oneByte.setWritable(isWritable(addressKey));
					oneByte.setReadable(isReadable(addressKey));
					byteUnit[j] = oneByte;
				}
				DCPUMemoryUnit unit = new DCPUMemoryUnit(byteUnit);
				memoryBlockTable.put(addressKey, unit);
			}
		}
			
		MemoryByte[] returnBytes = new MemoryByte[(int)length * getAddressableSize()];	
		BigInteger addressKey;
		
		for (int i=0; i<returnBytes.length; i=i+getAddressableSize())
		{	
			addressKey = address.add(BigInteger.valueOf(i/getAddressableSize()));
			DCPUMemoryUnit temp = ((DCPUMemoryUnit)memoryBlockTable.get(addressKey));
			
			// if memoryBlock does not already exist in the table, generate a value
			if (temp == null)
			{
				byte[] x = new byte[getAddressableSize()];
				random.nextBytes(x);
				byte flag = 0;
				flag |= MemoryByte.READABLE;
				flag |= MemoryByte.ENDIANESS_KNOWN;
				flag |= MemoryByte.WRITABLE;
				
				MemoryByte[] byteUnit = new MemoryByte[getAddressableSize()];
				for (int j=0; j<getAddressableSize(); j++)
				{
					MemoryByte oneByte = new MemoryByte(x[j], flag);
					byteUnit[j] = oneByte;
					byteUnit[j].setBigEndian(isBigEndian(addressKey));
					byteUnit[j].setWritable(isWritable(addressKey));
					byteUnit[j].setReadable(isReadable(addressKey));
					returnBytes[i+j] = oneByte;
				}
				DCPUMemoryUnit unit = new DCPUMemoryUnit(byteUnit);
				memoryBlockTable.put(addressKey, unit);
				
			}
			else
			{
				MemoryByte[] bytes = temp.getBytes();
				
				for (int j=0; j<bytes.length; j++)
				{
					MemoryByte oneByte = new MemoryByte(bytes[j].getValue(), bytes[j].getFlags());
					returnBytes[i+j] = oneByte;
					returnBytes[i+j].setBigEndian(isBigEndian(addressKey));
					returnBytes[i+j].setWritable(isWritable(addressKey));
				}
			}
		}
		
		return returnBytes;
	}
	
	/**
	 * Run the debuggee
	 */
	public void resume()
	{
		changeValue();
	}

	/**
	 * Convenience function to cause changes in a memoryBlock block.
	 * Changes could result from running the program, changing a variable, etc.
	 */
	synchronized public void changeValue()
	{	
		if (memoryBlockTable == null)
				return;
		
		Enumeration enumeration = memoryBlockTable.keys();
		long randomChange = random.nextInt(37);
		
		while (randomChange <= 5)
			randomChange = random.nextInt(37);
		
		while (enumeration.hasMoreElements())
		{
			BigInteger key = (BigInteger)enumeration.nextElement();
			if (key.remainder(BigInteger.valueOf(randomChange)).equals(BigInteger.valueOf(0)))
			{
				byte[] x = new byte[getAddressableSize()];
				random.nextBytes(x);

				MemoryByte unitBytes[] = new MemoryByte[getAddressableSize()];
				for (int i=0; i<x.length; i++)
				{
					MemoryByte oneByte = new MemoryByte();
					oneByte.setValue(x[i]);
					oneByte.setReadable(true);
					oneByte.setChanged(true);
					oneByte.setHistoryKnown(true);
					oneByte.setBigEndian(isBigEndian(key));
					oneByte.setWritable(isWritable(key));
					oneByte.setReadable(isReadable(key));
					unitBytes[i] = oneByte;
				}
				
				DCPUMemoryUnit unit = new DCPUMemoryUnit(unitBytes);
				
				memoryBlockTable.put(key, unit);			
			}
			else
			{
				DCPUMemoryUnit unit = (DCPUMemoryUnit) memoryBlockTable.get(key);
				
				MemoryByte[] bytes = unit.getBytes();
				
				for (int i=0; i<bytes.length; i++)
				{
					bytes[i].setChanged(false);
					bytes[i].setHistoryKnown(true);
				}
				
				unit.setBytes(bytes);
				
				memoryBlockTable.put(key, unit);		
			}
		}
	}

	/**
	 * Simulates evaluation of an expression. Given an expression, return ad address
	 * @param expression
	 * @param evalContext
	 * @return the address the expression is evaluated to
	 */
	public BigInteger evaluateExpression(String expression, Object evalContext)
	{
		BigInteger expAddress = (BigInteger)expressionAddressTable.get(expression);
		if(expAddress == null)
		{	
			int address = random.nextInt();
			
			// make sure number is positive
			if (address < 0)
				address = address * -1;
			
			expAddress = BigInteger.valueOf(address);
			expressionAddressTable.put(expression, expAddress);
		}		
		return expAddress;
	}
	
	/**
	 * Simulates checking if storage retrieval is supported
	 * @return if the engine supports storage retrieval
	 */
	public boolean supportsStorageRetrieval()
	{
		return true;
	}

	
	/**
	 * Simulates modifying memory using BigInteger as the address
	 * @param address
	 * @param bytes
	 * @throws RuntimeException
	 */
	public void setValue(BigInteger address, byte[] bytes) throws RuntimeException
	{
		BigInteger convertedAddress = address;
		
		for (int i=0; i<bytes.length; i=i+getAddressableSize())
		{
			DCPUMemoryUnit unit = (DCPUMemoryUnit)memoryBlockTable.get(convertedAddress);
			
			MemoryByte[] unitBytes = unit.getBytes();
			for (int j=0; j<unitBytes.length; j++)
			{
				unitBytes[j].setValue(bytes[i+j]);
				unitBytes[j].setChanged(true);
				unitBytes[j].setHistoryKnown(true);
			}
			convertedAddress = convertedAddress.add(BigInteger.valueOf(1));
		}		
	}
	
	/**
	 * @return addrssablesize of the debuggee
	 */
	public int getAddressableSize()
	{
		return 1;
	}
	
	/**
	 * @param address
	 * @return true if the debuggee is big endian, false otherwise
	 */
	public boolean isBigEndian(BigInteger address)
	{
		// simulate mixed endianess in a memory block
		// memory before the boundary address is little endian
		// memory after the boundaress is big endian
		BigInteger boundary = new BigInteger("12345678", 16);
		if (address.compareTo(boundary) > 0)
			return true;
		return false;
	}
	
	/**
	 * @param address
	 * @return true if the address is writable, false otherwise
	 * Readonly segment:  0xab123456 to 0xab123556
	 */
	public boolean isWritable(BigInteger address)
	{
		BigInteger boundary = new BigInteger("ab123456", 16);
		BigInteger boundaryEnd = new BigInteger("ab123556", 16);
		if (address.compareTo(boundary) > 0 && address.compareTo(boundaryEnd)<0)
			return false;
		
		boundary = new BigInteger("cd123456", 16);
		boundaryEnd = new BigInteger("cd123576", 16);
		if (address.compareTo(boundary) > 0 && address.compareTo(boundaryEnd)<0)
			return false;
		
		return true;
		
	}
	
	/**
	 * @param address
	 * @return
	 */
	public boolean isReadable(BigInteger address) {
		BigInteger boundary = new BigInteger("cd123456", 16);
		BigInteger boundaryEnd = new BigInteger("cd123576", 16);
		if (address.compareTo(boundary) > 0 && address.compareTo(boundaryEnd)<0)
			return false;
		return true;
	}
	
	/**
	 * @param target
	 * @return
	 */
	public DCPUThread[] getThreads(DCPUDebugTarget target)
	{
		Object thread = threadTable.get(target);
		if (thread == null)
		{
			thread = new DCPUThread(target);
			threadTable.put(target, thread);
		}
		return new DCPUThread[]{(DCPUThread)thread};
	}
	
	/**
	 * @param thread
	 * @return
	 */
	public DCPUStackFrame[] getStackframes(DCPUThread thread)
	{
		Object stackframes = stackframeTable.get(thread);
		if (stackframes == null)
		{
			stackframes = createStackframes(thread);
			stackframeTable.put(thread, stackframes);
		}
		return (DCPUStackFrame[])stackframes;
	}
	
	/**
	 * 
	 */
	private DCPUStackFrame[] createStackframes(DCPUThread thread) {
		DCPUStackFrame[] stackframes = new DCPUStackFrame[2];
		stackframes[0] = new DCPUStackFrame(thread, "Frame1");
		stackframes[1] = new DCPUStackFrame(thread, "Frame2");
		return stackframes;
	}
	
	/**
	 * @param mb
	 * @return true if memory block is to support base address modification, false otherwise
	 */
	public boolean suppostsBaseAddressModification(DCPUMemoryBlock mb)
	{
		return false;
	}
	
	/**
	 * Sets the base address of this memory block
	 * @param mb the memory block to change base address
	 * @param address the new base address of the memory block
	 */
	public void setBaseAddress(DCPUMemoryBlock mb, BigInteger address) throws CoreException
	{		
	}
	
	/**
	 * @param mb
	 * @return true if this memory block supports value modification, false otherwise
	 * @throws CoreException
	 */
	public boolean supportsValueModification(DCPUMemoryBlock mb)
	{
		return true;
	}
	
	/**
	 * @return address size of the debuggee
	 * @throws CoreException
	 */
	public int getAddressSize() throws CoreException
	{
		return 4;
	}
}

