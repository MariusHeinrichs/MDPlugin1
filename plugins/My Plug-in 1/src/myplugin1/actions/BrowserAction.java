package myplugin1.actions;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.magicdraw.uml.BaseElement;

import java.awt.event.ActionEvent;

public class BrowserAction extends DefaultBrowserAction {

    public BrowserAction(String id, String name) {
        super(id, name, null, null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Tree tree = getTree();

        Node selectedNode = tree.getSelectedNode();

        if(selectedNode != null){
            if(selectedNode.getUserObject() instanceof BaseElement) {
                BaseElement element = (BaseElement) selectedNode.getUserObject();
                Application.getInstance().getGUILog().showMessage("Selected node: " + element.getHumanName());
            }
        }
    }
}
