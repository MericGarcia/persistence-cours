package fr.keyconsulting.formation.control.app;

import fr.keyconsulting.formation.control.IController;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.model.ICalcul;

public interface IApplicationCtrl extends IController {
	
	public void start(String[] progArgs);
	
	public ICalculCtrl createNewCalcul(String operandA, String operatorSymbol, String operandB);
	
	public ICalculCtrl createNewCalcul();
	
	public void addCalcul(ICalcul operation);
	
}
