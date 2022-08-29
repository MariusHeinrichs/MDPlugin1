package myplugin1.actions;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import java.awt.event.ActionEvent;

public class MainMenuAction extends MDAction {

    public MainMenuAction(String id, String name){
        super(id, name, null, null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getGUILog().showMessage("Hello world");
    }
}
