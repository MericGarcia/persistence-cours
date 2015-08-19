package fr.keyconsulting.formation.factory;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;

public abstract class AFactory {
	
	private static AFactory instance;

	
	public static synchronized void init(FactoryType factoryType) {
		if(FactoryType.CONSOLE.equals(factoryType)) {
			instance = new ConsoleFactory();			
		} else {
			instance = new ViewFactory();			
		}		
	}
	
	public static synchronized AFactory getInstance() {
		if(instance == null) {
			throw new IllegalArgumentException("No instance initialized. Call init() method first.");
		}
		return instance;
	}
	
	public abstract IApplicationCtrl createApplication();
	
	public abstract ICalculCtrl createCalcul(IApplicationCtrl parent);
	
	public static enum FactoryType {
		CONSOLE,
		JavaFX
	}
}
