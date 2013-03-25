package devcpu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import devcpu.views.MappedView;

public class ViewMapper {
	private static final ViewMapper mapper = new ViewMapper();
	
	private static final LinkedHashMap<Object, ArrayList<MappedView<?>>> viewMap  = new LinkedHashMap<Object, ArrayList<MappedView<?>>>();
	private static final LinkedHashMap<MappedView<?>, Object> objectMap = new LinkedHashMap<MappedView<?>, Object>();
	private static final LinkedHashSet<MappedView<?>> unmappedViews = new LinkedHashSet<MappedView<?>>();
	private static int viewCounter;
	
	public static ViewMapper get() {
		return mapper;
	}

	@SuppressWarnings("unchecked")
	public static <T> MappedView<T> getFirstView(T o) {
		if (o != null) {
			ArrayList<MappedView<?>> views = viewMap.get(o);
			if (views != null) {
				if (views.size() > 0) {
					return (MappedView<T>) views.get(0);
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> MappedView<T> createMappedView(T o, String viewId) throws Exception {
		try {
			IViewPart v = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(viewId, String.valueOf(++viewCounter), IWorkbenchPage.VIEW_CREATE);
			if (v instanceof MappedView) {
				if (((MappedView<T>)v).mapTo(o)) {
					map((MappedView<T>) v, o);
					return (MappedView<T>) v;
				}
				throw new Exception("Object " + o + " could not be mapped to " + v);
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> void unmap(MappedView<T> view, Object o) {
		viewMap.get(o).remove(view);
		objectMap.remove(view);
		unmappedViews.add(view);
	}
	
	public static <T> void map(MappedView<T> view, Object o) {
		unmappedViews.remove(view);
		if (!viewMap.containsKey(o)) {
			viewMap.put(o, new ArrayList<MappedView<?>>());
		}
		viewMap.get(o).add(view);
		objectMap.put(view, o);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<MappedView<T>> getAllViews(T o) {
		ArrayList<MappedView<T>> list = new ArrayList<MappedView<T>>();
		if (viewMap.containsKey(o)) {
			for (MappedView<?> view : viewMap.get(o)) {
				list.add((MappedView<T>) view);
			}
		}
		return list;
	}
}
