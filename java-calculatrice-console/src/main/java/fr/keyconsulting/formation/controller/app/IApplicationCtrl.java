package fr.keyconsulting.formation.controller.app;

import fr.keyconsulting.formation.controller.IController;
import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.model.Result;

public interface IApplicationCtrl extends IController {
	
	public void start(String[] progArgs);
	
	public Calcul createNewCalcul(String operandA, String operatorSymbol, String operandB);
	
	public Result compute(Calcul operation);

}
