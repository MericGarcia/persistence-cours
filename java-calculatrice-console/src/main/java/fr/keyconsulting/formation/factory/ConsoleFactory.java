package fr.keyconsulting.formation.factory;

import fr.keyconsulting.formation.control.app.ConsoleApplicationCtrl;
import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.calc.ConsoleCalculCtrl;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;

public class ConsoleFactory extends AFactory {

	@Override
	public IApplicationCtrl createApplication() {
		return new ConsoleApplicationCtrl();
	}

	@Override
	public ICalculCtrl createCalcul(IApplicationCtrl parent) {
		return new ConsoleCalculCtrl(parent);
	}

}
