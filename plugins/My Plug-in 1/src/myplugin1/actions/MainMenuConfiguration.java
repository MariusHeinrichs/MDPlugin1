package myplugin1.actions;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsID;

import java.util.List;

public class MainMenuConfiguration implements AMConfigurator {

    private final MainMenuAction mainMenuAction;

    public MainMenuConfiguration(MainMenuAction action) {
        this.mainMenuAction = action;
    }

    @Override
    public void configure(ActionsManager actionsManager) {
        NMAction newProjectAction = actionsManager.getActionFor(ActionsID.NEW_PROJECT);

        if(newProjectAction != null) {
            ActionsCategory category = (ActionsCategory) actionsManager.getActionParent(newProjectAction);
            List<NMAction> actionsInCategory = category.getActions();
            actionsInCategory.add(mainMenuAction);
            category.setActions(actionsInCategory);
        }
    }
}
