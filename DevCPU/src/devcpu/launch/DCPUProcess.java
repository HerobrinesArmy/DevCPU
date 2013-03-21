package devcpu.launch;

import java.util.LinkedHashMap;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class DCPUProcess implements IProcess {
	private DCPUDebugTarget target;
	private LinkedHashMap<String,String> attributes = new LinkedHashMap<String, String>();

	public DCPUProcess(DCPUDebugTarget debugTarget) {
		this.target = debugTarget;
	}

	@Override
	public Object getAdapter(Class adapter) {
		return target.getAdapter(adapter);
	}

	@Override
	public boolean canTerminate() {
		return target.canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return target.isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		target.terminate();
	}

	@Override
	public String getLabel() {
		return "Process: " + target.getDCPU().getID();
	}

	@Override
	public ILaunch getLaunch() {
		return target.getLaunch();
	}

	@Override
	public IStreamsProxy getStreamsProxy() {
		//TODO
		return null;
	}

	@Override
	public void setAttribute(String key, String value) {
		attributes.put(key, value);
	}

	@Override
	public String getAttribute(String key) {
		return attributes.get(key);
	}

	@Override
	public int getExitValue() {
		// TODO Auto-generated method stub
		return 0;
	}
}
