package fr.keyconsulting.formation.model;

import java.util.HashMap;
import java.util.Set;

public abstract class Operators {
	
	private static HashMap<String,Operator> operators = new HashMap();
	
	static{
		Operator plus = new PlusOperator();
		operators.put(plus.getCode(),plus);
		Operator minus = new MinusOperator();
		operators.put(minus.getCode(),minus);
		Operator multiply = new MultiplyOperator();
		operators.put(multiply.getCode(),multiply);
		Operator divide = new DivideOperator();
		operators.put(divide.getCode(),divide);
	}
	
	public static Set<String> all(){
		return operators.keySet();
	}  
	
	public static Operator of(String opAsString){
		return operators.get(opAsString);
	}

}
