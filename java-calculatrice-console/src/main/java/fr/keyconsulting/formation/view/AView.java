package fr.keyconsulting.formation.view;

import fr.keyconsulting.formation.control.IController;

public class AView <C extends IController> {
	
	private C controller;	

	public AView() {
		super();
	}

	public C getController() {
		return controller;
	}

	public void setController(C controller) {
		this.controller = controller;
	}

}
