package fr.keyconsulting.formation.model;

import java.time.LocalDateTime;

public interface ICalcul {
	
	public String getCalculAsString();
	
	public Result execute();

	public Operand getLeftOperand();

	public Operand getRightOperand();

	public Operator getOperator();

	public LocalDateTime getTime();

}
