package fr.keyconsulting.formation;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.factory.AFactory;
import fr.keyconsulting.formation.factory.AFactory.FactoryType;

public class Main {
 
    public static void main(String[] args) {
    	AFactory.init(FactoryType.CONSOLE);
    	IApplicationCtrl appCtrl = AFactory.getInstance().createApplication();
    	appCtrl.start(args);
    }

}