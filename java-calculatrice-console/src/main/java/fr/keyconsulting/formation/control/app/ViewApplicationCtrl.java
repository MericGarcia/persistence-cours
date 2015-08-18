package fr.keyconsulting.formation.control.app;

import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.control.calc.ViewCalculCtrl;
import fr.keyconsulting.formation.model.ICalcul;
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
	public ICalculCtrl createNewCalcul(String operandA, String operatorSymbol, String operandB) {
		ICalculCtrl calc = new ViewCalculCtrl(new Operand(operandA), Operators.of(operatorSymbol), new Operand(operandB));
		return calc;		
	}
	
	@Override
	public Result compute(ICalcul operation) {
		return operation.execute();
	}

	@Override
	public void handleException(Exception err) {
		err.printStackTrace();
		appView.displayError("Une erreur est survenue", "Impossible de réaliser l'opération.", err);		
	}

}
