package fr.keyconsulting.formation.factory;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.view.app.ApplicationView;
import fr.keyconsulting.formation.view.calc.CalculView;

public class FxViewsFactory extends AViewsFactory {
	
	public static AViewsFactory initInstance() throws InstantiationException, IllegalAccessException {
		AViewsFactory.register(FxViewsFactory.class);
		return AViewsFactory.getInstance();
	}

	@Override
	public ApplicationView createApplicationView(IApplicationCtrl ctrl) {
		return new ApplicationView(ctrl);
	}

	@Override
	public CalculView createCalculView(ICalculCtrl ctrl) {
		return new CalculView(ctrl);
	}

}
