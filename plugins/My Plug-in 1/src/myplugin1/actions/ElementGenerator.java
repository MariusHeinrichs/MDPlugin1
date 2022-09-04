package myplugin1.actions;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.ModelElementsManager;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.uml.Finder;
import com.nomagic.uml2.ext.jmi.helpers.CoreHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.*;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.impl.ElementsFactory;

public class ElementGenerator {

    private final Project project;

    private final ElementsFactory factory;

    private final ModelElementsManager manager;

    public ElementGenerator() {
        this.project = Application.getInstance().getProject();
        this.factory = project.getElementsFactory();
        this.manager = ModelElementsManager.getInstance();
    }

    public void execute(Package parentPackage) throws ReadOnlyElementException {
        try{
            SessionManager.getInstance().createSession(project, "Creating a single Element");
            createModelElement(parentPackage);
            SessionManager.getInstance().closeSession(project);
        } catch (Exception e) {
            Application.getInstance().getGUILog().showMessage("Exception occured: " + e.getMessage());
            SessionManager.getInstance().cancelSession(project);
        }
    }

    private void createModelElement(Package parentPackage) throws ReadOnlyElementException {
        Class firstClass = createClass(parentPackage, "First class");

        addProperty(firstClass);
        addOperation(firstClass);
    }

    private Class createClass(Package parentPackage, String name) throws ReadOnlyElementException {
        Class mdClass = factory.createClassInstance();
        mdClass.setName(name);
        manager.addElement(mdClass, parentPackage);

        return mdClass;
    }

    private void addProperty(Class mdClass) throws ReadOnlyElementException {
        Type stringType = Finder.byQualifiedName().find(project, "UML Standard Profile::UML2 Metamodel::PrimitiveTypes::String");

        Property property = factory.createPropertyInstance();
        property.setName("myProperty");
        property.setType(stringType);
        CoreHelper.setMultiplicity(0, 1, property);

        manager.addElement(property, mdClass);
    }

    private void addOperation(Class mdClass) throws ReadOnlyElementException {
        Operation operation = factory.createOperationInstance();
        operation.setName("myOperation");
        manager.addElement(operation, mdClass);
    }
}
