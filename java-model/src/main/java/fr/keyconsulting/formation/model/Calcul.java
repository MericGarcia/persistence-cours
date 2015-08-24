package fr.keyconsulting.formation.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
public class Calcul implements Serializable, ICalcul {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade=CascadeType.ALL)
	@Attribute
	Operand leftOperand;
    
	@OneToOne(cascade=CascadeType.ALL)
	@Attribute
	Operand rightOperand;

	@OneToOne(cascade=CascadeType.ALL)
	@Attribute
	Operator operator;

	@Attribute
	LocalDateTime time;

	public Calcul() {
		this(null, null, null);
	}

	public Calcul(Operand leftOperand, Operator operator, Operand rightOperand) {
		this(leftOperand, operator, rightOperand, LocalDateTime.now());
	}

	public Calcul(Operand leftOperand, Operator operator, Operand rightOperand, LocalDateTime time) {
		super();
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
		this.time = time;
	}

	public Result execute() {		
		if(operator == null) {
			throw new IllegalStateException("No operator specified");
		}
		Result result = new Result(operator.operate(leftOperand, rightOperand));
		time = LocalDateTime.now();
		return result;
	}

    public long getId() {
		return id;
	}
    
	@XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
	public LocalDateTime getTime() {
		return time;
	}

	public String getCalculAsString() {
		StringJoiner sj = new StringJoiner(" ");
		sj.add(leftOperand.getValue().toString());
		sj.add(operator.getCode());
		sj.add(rightOperand.getValue().toString());
		return sj.toString();
	}

	public Operand getLeftOperand() {
		return leftOperand;
	}

	public void setLeftOperand(Operand leftOperand) {
		this.leftOperand = leftOperand;
	}

	public Operand getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(Operand rightOperand) {
		this.rightOperand = rightOperand;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}	

}
