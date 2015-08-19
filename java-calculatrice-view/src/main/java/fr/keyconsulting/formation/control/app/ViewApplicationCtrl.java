package fr.keyconsulting.formation.control.app;

import fr.keyconsulting.formation.model.ICalcul;
import fr.keyconsulting.formation.presentation.IPresentation;
import fr.keyconsulting.formation.view.app.ApplicationView;
import fr.keyconsulting.formation.view.app.FxApplication;

public class ViewApplicationCtrl extends AApplicationCtrl {
	
	private ApplicationView appView;
	
	public ViewApplicationCtrl() {
		super();
		appView = new ApplicationView(this);
	}

	@Override
	public void start(String[] progArgs) {
		FxApplication.launch(appView, progArgs);		
	}
	
	@Override
	public IPresentation getPresentation() {
		return appView;
	}
	
	@Override
	public void addCalcul(ICalcul operation) {
		appView.addNewCalcul(operation);
	}

	@Override
	public void handleException(Exception err) {
		super.handleException(err);
		appView.displayError("Une erreur est survenue", "Impossible de créer une nouvelle opération.", err);		
	}

}
