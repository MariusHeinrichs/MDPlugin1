package myplugin1;

import com.jidesoft.dialog.JideOptionPane;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;
import myplugin1.actions.*;


public class MyPlugin1 extends Plugin
{
	public static boolean initialized = false;
	public static boolean closed = false;
	
	@Override
	public void init()
	{
		initialized = true;
		createMainMenuAction();
		createBrowserAction();
		createDiagramAction();
		Application.getInstance().getGUILog().showMessage("My Plug-in 1 initialized.");
	}

	@Override
	public boolean close()
	{
		closed = true;
		Application.getInstance().getGUILog().showMessage("My Plug-in 1 closed.");
		return true;
	}

	@Override
	public boolean isSupported()
	{
		return true;
	}

	private void createMainMenuAction() {
		MainMenuAction action = new MainMenuAction("MyPlugin1MainMenuAction", "My Plugin 1 Main Menu Action");
		MainMenuConfiguration configurator = new MainMenuConfiguration(action);
		ActionsConfiguratorsManager.getInstance().addMainMenuConfigurator(configurator);
	}
	private void createBrowserAction() {
		BrowserAction action = new BrowserAction("MyPlugin1BrowserAction", "My Plugin 1 Browser Action");
		BrowserConfiguration configurator = new BrowserConfiguration(action);
		ActionsConfiguratorsManager.getInstance().addContainmentBrowserContextConfigurator(configurator);
	}

	private void createDiagramAction(){
		DiagramAction action = new DiagramAction("MyPlugin1DiagramAction", "My Plugin 1 Browser Action");
		DiagramConfiguration configurator = new DiagramConfiguration(action);
		ActionsConfiguratorsManager.getInstance().addAnyDiagramCommandBarConfigurator(configurator);
	}
}