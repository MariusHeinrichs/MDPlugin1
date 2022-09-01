package myplugin1.actions;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.actions.DefaultDiagramAction;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.ui.ScalableImageIcon;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;

public class DiagramAction extends DefaultDiagramAction {

    public DiagramAction(String id, String name) {
        super(id, name, null, null);

        URL url = getClass().getResource("../../icons/coffee-icon.png");
        setSmallIcon(new ScalableImageIcon(url));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        List<PresentationElement> presentationElements = getSelected();

        if(presentationElements != null && presentationElements.size() > 0) {
            PresentationElement presentationElement = presentationElements.get(0);
            String name = presentationElement.getElement().getHumanName();

            Application.getInstance().getGUILog().showMessage("Selected element; " + name);
        }
    }
}
