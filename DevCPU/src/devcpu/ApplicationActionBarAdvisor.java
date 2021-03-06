package devcpu;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction exitAction;
	private MenuManager showViewMenuMgr;
	private IContributionItem showViewItem;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(final IWorkbenchWindow window) {
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);

		showViewMenuMgr = new MenuManager("Show View", "showView");
		showViewItem = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
		MenuManager editMenu = new MenuManager("&Edit", IWorkbenchActionConstants.M_EDIT);
		final MenuManager windowMenu = new MenuManager("&Window", IWorkbenchActionConstants.M_WINDOW);
		windowMenu.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				windowMenu.add(showViewMenuMgr);
			}
		});
		windowMenu.setRemoveAllWhenShown(true);
		showViewMenuMgr.add(showViewItem);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(windowMenu);
		fileMenu.add(exitAction);
	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		 IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
		 coolBar.add(new ToolBarContributionItem(toolbar, "main"));
	}
}
