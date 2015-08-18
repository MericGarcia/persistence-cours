package fr.keyconsulting.formation.controller.app;

import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.model.Operand;
import fr.keyconsulting.formation.model.Operators;
import fr.keyconsulting.formation.model.Result;
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
	public Calcul createNewCalcul(String operandA, String operatorSymbol, String operandB) {
		Calcul calc = new Calcul(new Operand(operandA), Operators.of(operatorSymbol),	new Operand(operandB));
		return calc;		
	}
	
	@Override
	public Result compute(Calcul operation) {
		return operation.execute();
	}

}
