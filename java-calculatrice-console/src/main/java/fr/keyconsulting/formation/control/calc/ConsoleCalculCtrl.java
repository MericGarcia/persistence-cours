package fr.keyconsulting.formation.control.calc;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.presentation.IPresentation;

public class ConsoleCalculCtrl extends ACalculCtrl {

	private static final long serialVersionUID = 1L;

	public ConsoleCalculCtrl(IApplicationCtrl parent) {
		super(parent);
	}

	@Override
	public IPresentation getPresentation() {
		return null; // No presentation object, this is a console app.
	}

}
