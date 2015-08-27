package fr.keyconsulting.formation.factory;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.app.ViewApplicationCtrl;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.control.calc.ViewCalculCtrl;

public class GUIControllersFactory extends AFactory {
	
	public static void init() throws InstantiationException, IllegalAccessException {
		AFactory.register(GUIControllersFactory.class);
	}
	
	@Override
	public IApplicationCtrl createApplication() {
		return new ViewApplicationCtrl();		
	}
	
	@Override
	public ICalculCtrl createCalcul(IApplicationCtrl parent) {
		return new ViewCalculCtrl(parent);
	}

}
