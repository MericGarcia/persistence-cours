package fr.keyconsulting.formation;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.factory.AFactory;
import fr.keyconsulting.formation.factory.AViewsFactory;
import fr.keyconsulting.formation.factory.FxViewsFactory;
import fr.keyconsulting.formation.factory.GUIControllersFactory;

public class Main {
 
    public static void main(String[] args) throws Exception {
    	AFactory.register(GUIControllersFactory.class);
    	AViewsFactory.register(FxViewsFactory.class);
    	IApplicationCtrl appCtrl = AFactory.getInstance().createApplication();
    	appCtrl.start(args);
    }

}