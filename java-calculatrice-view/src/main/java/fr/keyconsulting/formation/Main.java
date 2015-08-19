package fr.keyconsulting.formation;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.factory.AFactory;
import fr.keyconsulting.formation.factory.ViewFactory;

public class Main {
 
    public static void main(String[] args) throws Exception {
    	AFactory.register(ViewFactory.class);
    	IApplicationCtrl appCtrl = AFactory.getInstance().createApplication();
    	appCtrl.start(args);
    }

}