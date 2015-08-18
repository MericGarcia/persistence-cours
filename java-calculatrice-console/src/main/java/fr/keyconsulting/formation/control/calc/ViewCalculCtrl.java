package fr.keyconsulting.formation.control.calc;

import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.model.Operand;
import fr.keyconsulting.formation.model.Operator;
import fr.keyconsulting.formation.presentation.IPresentation;

public class ViewCalculCtrl extends Calcul implements ICalculCtrl {

	private static final long serialVersionUID = 1L;	

	public ViewCalculCtrl() {
		super();
	}

	public ViewCalculCtrl(Operand leftOperand, Operator operator, Operand rightOperand) {
		super(leftOperand, operator, rightOperand);
	}

	@Override
	public IPresentation getPresentation() {
		// TODO Auto-generated method stub
		return null;
	}

}
