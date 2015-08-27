package fr.keyconsulting.formation.factory;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.view.app.ApplicationView;
import fr.keyconsulting.formation.view.calc.CalculView;

public abstract class AViewsFactory {
	
	private static AViewsFactory instance;
	
	public static synchronized <F extends AViewsFactory> 
		void register(Class<F> factoryClass) throws InstantiationException, IllegalAccessException {
		instance = factoryClass.newInstance();
	}
	
	public static synchronized AViewsFactory getInstance() {
		if(instance == null) {
			throw new IllegalArgumentException("No instance initialized. Call register() method first.");
		}
		return instance;
	}
	
	public abstract ApplicationView createApplicationView(IApplicationCtrl ctrl);
	
	public abstract CalculView createCalculView(ICalculCtrl ctrl);

}
