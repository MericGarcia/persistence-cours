package fr.keyconsulting.formation.control.app;

import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.factory.AFactory;
import fr.keyconsulting.formation.model.ICalcul;
import fr.keyconsulting.formation.presentation.IPresentation;

public abstract class AApplicationCtrl implements IApplicationCtrl {

	
	public abstract IPresentation getPresentation();
	
	public abstract void start(String[] progArgs) ;

	@Override
	public void handleException(Exception err) {
		err.printStackTrace();		
	}

	@Override
	public ICalculCtrl createNewCalcul() {
		return AFactory.getInstance().createCalcul(this); //call the factory to create a new partner
	}

	public abstract void addCalcul(ICalcul operation);

}
