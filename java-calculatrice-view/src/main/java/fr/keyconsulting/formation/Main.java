package fr.keyconsulting.formation;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.factory.AFactory;
import fr.keyconsulting.formation.factory.AViewsFactory;
import fr.keyconsulting.formation.factory.FxViewFactory;
import fr.keyconsulting.formation.factory.ViewFactory;

public class Main {
 
    public static void main(String[] args) throws Exception {
    	AFactory.register(ViewFactory.class);
    	AViewsFactory.register(FxViewFactory.class);
    	IApplicationCtrl appCtrl = AFactory.getInstance().createApplication();
    	appCtrl.start(args);
    }

}