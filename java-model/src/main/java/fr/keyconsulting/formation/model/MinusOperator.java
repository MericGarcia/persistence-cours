package fr.keyconsulting.formation.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class MinusOperator extends Operator {

	private static final String MINUS = "-";

	@Override
	public BigDecimal operate(Operand leftOperand, Operand rightOperand) {
		return leftOperand.getValue().subtract(rightOperand.getValue());
	}
	
	@Override
	public String getCode() {
		return MINUS;
	}

}
