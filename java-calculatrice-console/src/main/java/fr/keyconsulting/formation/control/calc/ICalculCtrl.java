package fr.keyconsulting.formation.control.calc;

import java.util.Set;

import fr.keyconsulting.formation.control.IController;
import fr.keyconsulting.formation.model.ICalcul;

public interface ICalculCtrl extends IController, ICalcul {
	
	public void setLeftOperand(String text);
	public void setOperator(String text);
	public void setRightOperand(String text);
	public Set<String> getAllOperators();

}
