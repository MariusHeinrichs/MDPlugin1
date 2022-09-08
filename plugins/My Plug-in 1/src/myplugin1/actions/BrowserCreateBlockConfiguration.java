package myplugin1.actions;

import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.ui.browser.Tree;

public class BrowserCreateBlockConfiguration implements BrowserContextAMConfigurator {
    private final BrowserActionCreateBlock browserAction;

    public BrowserCreateBlockConfiguration(BrowserActionCreateBlock browserAction) {
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
