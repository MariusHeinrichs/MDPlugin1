package myplugin1.actions;

import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.ui.browser.Tree;

public class BrowserCreateElementConfiguration implements BrowserContextAMConfigurator {

    private final BrowserActionCreateElement browserAction;

    public BrowserCreateElementConfiguration(BrowserActionCreateElement browserAction) {
        this.browserAction = browserAction;
    }

    @Override
    public void configure(ActionsManager actionsManager, Tree tree) {
        MDActionsCategory category = new MDActionsCategory("", "");
        category.addAction(browserAction);
        actionsManager.addCategory(category);
    }

    @Override
    public int getPriority() {
        return LOW_PRIORITY;
    }
}