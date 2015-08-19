package fr.keyconsulting.formation.control.app;

import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.control.calc.ViewCalculCtrl;
import fr.keyconsulting.formation.model.ICalcul;
import fr.keyconsulting.formation.model.Operand;
import fr.keyconsulting.formation.model.Operators;
import fr.keyconsulting.formation.presentation.IPresentation;
import fr.keyconsulting.formation.view.app.ApplicationView;
import fr.keyconsulting.formation.view.app.FxApplication;

public class ViewApplicationCtrl implements IApplicationCtrl {
	
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
	public ICalculCtrl createNewCalcul(String operandA, String operatorSymbol, String operandB) {
		ICalculCtrl calc = new ViewCalculCtrl(this, new Operand(operandA), Operators.of(operatorSymbol), new Operand(operandB));
		return calc;		
	}
	
	@Override
	public ICalculCtrl createNewCalcul() {
		ICalculCtrl calc = new ViewCalculCtrl(this);
		return calc;		
	}	
	
	@Override
	public void addCalcul(ICalcul operation) {
		appView.addNewCalcul(operation);
	}

	@Override
	public void handleException(Exception err) {
		err.printStackTrace();
		appView.displayError("Une erreur est survenue", "Impossible de créer une nouvelle opération.", err);		
	}

}
