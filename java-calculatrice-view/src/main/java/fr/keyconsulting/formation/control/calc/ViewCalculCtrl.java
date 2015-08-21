package fr.keyconsulting.formation.control.calc;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.factory.AViewsFactory;
import fr.keyconsulting.formation.presentation.IPresentation;
import fr.keyconsulting.formation.view.calc.CalculView;

public class ViewCalculCtrl extends ACalculCtrl {

	private static final long serialVersionUID = 1L;
	
	private CalculView calcView;

	public ViewCalculCtrl(IApplicationCtrl parent) {		
		super(parent);
		//TODO init the calcView here
		//this.calcView = AViewsFactory.getInstance().createCalculView(this);
	}

	@Override
	public IPresentation getPresentation() {
		return calcView;
	}

	@Override
	public void handleException(Exception err) {
		super.handleException(err);
		calcView.displayError("Une erreur est survenue", "Impossible de réaliser l'opération.", err);
	}

}
