package fr.keyconsulting.formation.control.calc;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.model.Operand;
import fr.keyconsulting.formation.model.Operator;
import fr.keyconsulting.formation.model.Operators;
import fr.keyconsulting.formation.model.Result;
import fr.keyconsulting.formation.presentation.IPresentation;
import fr.keyconsulting.formation.view.calc.CalculView;

public class ViewCalculCtrl extends Calcul implements ICalculCtrl {

	private static final long serialVersionUID = 1L;
	
	private IApplicationCtrl parent;
	
	private CalculView calcView;

	public ViewCalculCtrl(IApplicationCtrl parent) {
		this(parent, null, null, null);
	}

	public ViewCalculCtrl(IApplicationCtrl parent, Operand leftOperand, Operator operator, Operand rightOperand) {
		super(leftOperand, operator, rightOperand);
		this.calcView = new CalculView(this);
		this.parent = parent;
	}
	
	@Override
	public Result execute() {
		Result result = super.execute();
		parent.addCalcul(this);
		return result;
	}

	@Override
	public IPresentation getPresentation() {
		return calcView;
	}

	@Override
	public void handleException(Exception err) {
		calcView.displayError("Une erreur est survenue", "Impossible de réaliser l'opération.", err);
	}

	@Override
	public void setLeftOperand(String operandAsText) {
		super.setLeftOperand(new Operand(operandAsText));		
	}

	@Override
	public void setOperator(String opAsString) {
		super.setOperator(Operators.of(opAsString));		
	}

	@Override
	public void setRightOperand(String operandAsText) {
		super.setRightOperand(new Operand(operandAsText));		
	}

}
