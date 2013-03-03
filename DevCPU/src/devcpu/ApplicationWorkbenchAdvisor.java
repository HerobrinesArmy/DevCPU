package devcpu;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.ide.application.IDEWorkbenchAdvisor;

public class ApplicationWorkbenchAdvisor extends IDEWorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "DevCPU.perspective";

	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
	
	public IAdaptable getDefaultPageInput() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		return workspace.getRoot();
	}
	
//	@Override
//	public void initialize(IWorkbenchConfigurer configurer) {
//		super.initialize(configurer);
////		IDE.registerAdapters();
////		Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);
////
////		//FIXME
////    declareWorkbenchImage(configurer, ideBundle, IDE.SharedImages.IMG_OBJ_PROJECT, "icons/project_open.gif", true);
////    declareWorkbenchImage(configurer, ideBundle, IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, "icons/project_closed.gif", true);
//	}
	
//	private void declareWorkbenchImage(IWorkbenchConfigurer configurer_p, Bundle ideBundle, String symbolicName, String path, boolean shared)  
//	{
//	    URL url = ideBundle.getEntry(path);
//	    ImageDescriptor desc = ImageDescriptor.createFromURL(url);
//	    configurer_p.declareImage(symbolicName, desc, shared);
//	}
//	
//	private void declareWorkbenchImage(Bundle ideBundle, String symbolicName,
//			String path, boolean shared) {
//		URL url = Platform.find(ideBundle, new Path(path));
//		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
//		getWorkbenchConfigurer().declareImage(symbolicName, desc, shared);
//	}
//	
//	@Override
//	public void preStartup() {
//		super.preStartup();
////		IDE.registerAdapters();
////		declareWorkbenchImages();
//	}
//	
//	private void declareWorkbenchImages() {
//		final String ICONS_PATH = "$nl$/icons/full/";//$NON-NLS-1$
//		final String PATH_ELOCALTOOL = ICONS_PATH + "elcl16/"; //Enabled toolbar icons.//$NON-NLS-1$
//		final String PATH_ETOOL = ICONS_PATH + "etool16/"; //Enabled toolbar icons.//$NON-NLS-1$
//		final String PATH_DTOOL = ICONS_PATH + "dtool16/"; //Disabled toolbar icons.//$NON-NLS-1$
//		final String PATH_OBJECT = ICONS_PATH + "obj16/"; //Model object icons//$NON-NLS-1$
//		final String PATH_WIZBAN = ICONS_PATH + "wizban/"; //Wizard icons//$NON-NLS-1$
//
//		Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);
//
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_ETOOL_BUILD_EXEC, PATH_ETOOL
//						+ "build_exec.gif", false); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_ETOOL_BUILD_EXEC_HOVER,
//				PATH_ETOOL + "build_exec.gif", false); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_ETOOL_BUILD_EXEC_DISABLED,
//				PATH_DTOOL + "build_exec.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_ETOOL_SEARCH_SRC, PATH_ETOOL
//						+ "search_src.gif", false); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_ETOOL_SEARCH_SRC_HOVER,
//				PATH_ETOOL + "search_src.gif", false); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_ETOOL_SEARCH_SRC_DISABLED,
//				PATH_DTOOL + "search_src.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_ETOOL_NEXT_NAV, PATH_ETOOL
//						+ "next_nav.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_ETOOL_PREVIOUS_NAV, PATH_ETOOL
//						+ "prev_nav.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_WIZBAN_NEWPRJ_WIZ, PATH_WIZBAN
//						+ "newprj_wiz.gif", false); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_WIZBAN_NEWFOLDER_WIZ,
//				PATH_WIZBAN + "newfolder_wiz.gif", false); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_WIZBAN_NEWFILE_WIZ, PATH_WIZBAN
//						+ "newfile_wiz.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_WIZBAN_IMPORTDIR_WIZ,
//				PATH_WIZBAN + "importdir_wiz.gif", false); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_WIZBAN_IMPORTZIP_WIZ,
//				PATH_WIZBAN + "importzip_wiz.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_WIZBAN_EXPORTDIR_WIZ,
//				PATH_WIZBAN + "exportdir_wiz.gif", false); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_WIZBAN_EXPORTZIP_WIZ,
//				PATH_WIZBAN + "exportzip_wiz.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle,
//
//		IDEInternalWorkbenchImages.IMG_WIZBAN_RESOURCEWORKINGSET_WIZ,
//				PATH_WIZBAN + "workset_wiz.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_DLGBAN_SAVEAS_DLG, PATH_WIZBAN
//						+ "saveas_wiz.gif", false); //$NON-NLS-1$
//
//		declareWorkbenchImage(ideBundle, IDE.SharedImages.IMG_OBJ_PROJECT,
//				PATH_OBJECT + "prj_obj.gif", true); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, PATH_OBJECT
//						+ "cprj_obj.gif", true); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle, IDE.SharedImages.IMG_OPEN_MARKER,
//				PATH_ELOCALTOOL + "gotoobj_tsk.gif", true); //$NON-NLS-1$
//
//		// task objects
//
//		//declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_HPRIO_TSK, PATH_OBJECT+"hprio_tsk.gif");
//
//		//declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_MPRIO_TSK, PATH_OBJECT+"mprio_tsk.gif");
//
//		//declareRegistryImage(IDEInternalWorkbenchImages.IMG_OBJS_LPRIO_TSK, PATH_OBJECT+"lprio_tsk.gif");
//
//		declareWorkbenchImage(ideBundle, IDE.SharedImages.IMG_OBJS_TASK_TSK,
//				PATH_OBJECT + "taskmrk_tsk.gif", true); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle, IDE.SharedImages.IMG_OBJS_BKMRK_TSK,
//				PATH_OBJECT + "bkmrk_tsk.gif", true); //$NON-NLS-1$
//
//		String string = IDEInternalWorkbenchImages.IMG_OBJS_COMPLETE_TSK;
//		declareWorkbenchImage(ideBundle, string, PATH_OBJECT
//				+ "complete_tsk.gif", true); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_OBJS_INCOMPLETE_TSK, PATH_OBJECT
//						+ "incomplete_tsk.gif", true); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_OBJS_WELCOME_ITEM, PATH_OBJECT
//						+ "welcome_item.gif", true); //$NON-NLS-1$
//		declareWorkbenchImage(ideBundle,
//				IDEInternalWorkbenchImages.IMG_OBJS_WELCOME_BANNER, PATH_OBJECT
//						+ "welcome_banner.gif", true); //$NON-NLS-1$
//	}
}
