package devcpu;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;

import devcpu.views.KeyboardView;
import devcpu.views.LEM1802View;
import devcpu.views.SPED3View;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of the
 * actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    // Actions - important to allocate these only in makeActions, and then use them
    // in the fill methods.  This ensures that the actions aren't recreated
    // when fillActionBars is called with FILL_PROXY.
    private IWorkbenchAction exitAction;
		private IAction lem1802Action;
		private OpenViewAction sped3Action;
//    private OpenViewAction openViewAction;
//    private Action messagePopupAction;
		private OpenViewAction keyboardAction;
private MenuManager showViewMenuMgr;
private IContributionItem showViewItem;
    

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }
    
    protected void makeActions(final IWorkbenchWindow window) {
        // Creates the actions and registers them.
        // Registering is needed to ensure that key bindings work.
        // The corresponding commands keybindings are defined in the plugin.xml file.
        // Registering also provides automatic disposal of the actions when
        // the window is closed.

        exitAction = ActionFactory.QUIT.create(window);
        register(exitAction);
        
        lem1802Action = new OpenViewAction(window, "LEM1802", LEM1802View.ID);
        lem1802Action.setAccelerator(0);
        register(lem1802Action);
        
        sped3Action = new OpenViewAction(window, "SPED-3", SPED3View.ID);
        sped3Action.setAccelerator(0);
        register(sped3Action);
        
        keyboardAction = new OpenViewAction(window, "Generic Keyboard", KeyboardView.ID);
        keyboardAction.setAccelerator(0);
        register(keyboardAction);
        
        showViewMenuMgr = new MenuManager("Show View", "showView"); 
        showViewItem = 
        ContributionItemFactory.VIEWS_SHORTLIST.create(window); 

//        messagePopupAction = new MessagePopupAction("Open Message", window);
//        register(messagePopupAction);
    }
    
    protected void fillMenuBar(IMenuManager menuBar) {
        MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
        MenuManager windowMenu = new MenuManager("&Window", IWorkbenchActionConstants.M_WINDOW);
        showViewMenuMgr.add(showViewItem); 
        windowMenu.add(showViewMenuMgr); 
//        MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
        
        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        // Add a group marker indicating where action set menus will appear.
//        menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
//        menuBar.add(helpMenu);
        
        // File
//        fileMenu.add(new Separator());
//        fileMenu.add(messagePopupAction);
//        fileMenu.add(openViewAction);
        fileMenu.add(new Separator());
        fileMenu.add(exitAction);
        
        // Window
        MenuManager createViewMenu = new MenuManager("&Add Panel", "CreateView");
        createViewMenu.add(new Action("placeholder"){});
        createViewMenu.setRemoveAllWhenShown(true);
        createViewMenu.addMenuListener(new IMenuListener() {
					@Override public void menuAboutToShow(IMenuManager manager) {
						manager.add(keyboardAction);
						manager.add(lem1802Action);
						if (SPED3View.view == null) {
							manager.add(sped3Action);
						}
					}
				});
        windowMenu.add(createViewMenu);
    }
    
    protected void fillCoolBar(ICoolBarManager coolBar) {
//        IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
//        coolBar.add(new ToolBarContributionItem(toolbar, "main"));   
//        toolbar.add(openViewAction);
//        toolbar.add(messagePopupAction);
    }
}
