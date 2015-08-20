package fr.keyconsulting.formation.control.calc;

import java.util.Set;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.model.Operand;
import fr.keyconsulting.formation.model.Operators;
import fr.keyconsulting.formation.model.Result;
import fr.keyconsulting.formation.presentation.IPresentation;

public abstract class ACalculCtrl extends Calcul implements ICalculCtrl {
	
	private static final long serialVersionUID = 1L;
	
	private IApplicationCtrl parent;
	
	public ACalculCtrl(IApplicationCtrl parent) {
		super();
		this.parent = parent;
	}

	@Override
	public Result execute() {
		Result result = super.execute();
		parent.addCalcul(this); //notify parent ctrl
		return result;
	}

	public abstract IPresentation getPresentation();

	@Override
	public void handleException(Exception err) {
		err.printStackTrace();
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
	
	@Override
	public Set<String> getAllOperators() {
		return Operators.all();
	}

}
