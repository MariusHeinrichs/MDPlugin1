package myplugin1.actions;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;

import java.awt.event.ActionEvent;

public class BrowserActionCreateElement extends DefaultBrowserAction {

    public BrowserActionCreateElement(String id, String name) {
        super(id, name, null, null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Tree tree = getTree();

        Node selectedNode = tree.getSelectedNode();

        if(selectedNode != null){
            if(selectedNode.getUserObject() instanceof Package) {
                Package parentPackage = (Package) selectedNode.getUserObject();
                ElementGenerator generator = new ElementGenerator();
                Application.getInstance().getGUILog().showMessage("Creating single Example Class in: " + parentPackage.getHumanName());
                try {
                    generator.execute(parentPackage);
                } catch (ReadOnlyElementException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
