package devcpu.views;

import org.eclipse.ui.part.ViewPart;

import devcpu.ViewMapper;

public abstract class MappedView<T> extends ViewPart {
	
	public abstract boolean mapTo(T o);
	
	public abstract T getMappedObject();
	
	protected void unmap(T o) {
		ViewMapper.unmap(this, o);
	}
	
	protected void map(T o) {
		ViewMapper.map(this, o);
		mapTo(o);
	}
}
