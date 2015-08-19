package fr.keyconsulting.formation.factory;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;

public abstract class AFactory {
	
	private static AFactory instance;
	
	public static synchronized <F extends AFactory> 
		void register(Class<F> factoryClass) throws InstantiationException, IllegalAccessException {
		instance = factoryClass.newInstance();
	}
	
	public static synchronized AFactory getInstance() {
		if(instance == null) {
			throw new IllegalArgumentException("No instance initialized. Call register() method first.");
		}
		return instance;
	}
	
	public abstract IApplicationCtrl createApplication();
	
	public abstract ICalculCtrl createCalcul(IApplicationCtrl parent);

}
