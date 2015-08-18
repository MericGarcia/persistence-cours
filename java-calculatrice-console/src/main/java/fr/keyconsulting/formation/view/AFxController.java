package fr.keyconsulting.formation.view;

import fr.keyconsulting.formation.control.IController;

public class AFxController<C extends IController> {
	
	private C controller;	

	public AFxController() {
		super();
	}

	public C getController() {
		return controller;
	}

	public void setController(C controller) {
		this.controller = controller;
	}

}
