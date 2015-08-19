package fr.keyconsulting.formation.control.app;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.model.ICalcul;
import fr.keyconsulting.formation.model.Result;
import fr.keyconsulting.formation.presentation.IPresentation;

public class ConsoleApplicationCtrl extends AApplicationCtrl {

	private PrintStream output;
	private Scanner input;
	private DateTimeFormatter formatter;
	private List<ICalcul> operations;

	public ConsoleApplicationCtrl() {
		super();
		this.operations = new LinkedList<ICalcul>();
		this.output = System.out;
		this.input = new Scanner(System.in);
		this.formatter = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm:ss");
	}

	@Override
	public IPresentation getPresentation() {
		return null; // No presentation object, this is a console app.
	}

	@Override
	public void start(String[] progArgs) {
		output.println("-- 'Calculatrice' program:");
		boolean exit = false;
		do {
			try {
				exit = oneUerInteraction();
			} catch (Exception e) {
				handleException(e);
			}
		} while (!exit);
		printOut("bye.");
		output.println("Ok.");
	}

	@Override
	public void addCalcul(ICalcul operation) {
		operations.add(operation);
		printOut("add: " + asString(operation));
	}

	protected boolean oneUerInteraction() {
		output.print("? ");
		String cmd = input.next();
		boolean exit = "exit".equals(cmd);
		if (!exit) {
			if ("add".equals(cmd)) {
				ICalcul calcul = readNewCalcul();
				Result result = calcul.execute();
				printOut("= " + result.getValue());
			}
			else if ("list".equals(cmd)) {
				printAll(operations);
			}
			else if ("clear".equals(cmd)) {
				operations.clear();
			} else {
				printErr("Unkwonw command: " + cmd);
				printOut("Valid commands are: 'add', 'list', 'clear', and 'exit'");
			}
		}
		return exit;
	}

	protected ICalcul readNewCalcul() {
		ICalculCtrl calcul = createNewCalcul();

		printOut("operand 1:");
		String left = input.next();
		calcul.setLeftOperand(left);

		printOut("which operator (+, -, /, x):");
		String operator = input.next();
		calcul.setOperator(operator);

		printOut("operand 2:");
		String right = input.next();
		calcul.setRightOperand(right);

		return calcul;
	}

	protected void printOut(String msg) {
		output.println("> " + msg);
	}

	protected void printErr(String msg) {
		output.println("! " + msg);
	}
	
	private void printAll(List<ICalcul> operations) {
		if(operations.isEmpty()) {
			printOut("operations: {}");
		} else {
			printOut("operations: {");
			Iterator<ICalcul> it = operations.iterator();
			for(;;) {
				ICalcul calc = it.next();	
				String lineStr = "  " + asString(calc);
				if( it.hasNext() ) {
					printOut(lineStr+ ", ");
				} else {
					printOut(lineStr);
					break;
				}					
			}
			printOut("}");
		}		
	}
	
	private String asString(ICalcul operation) {
		String dateStr = operation.getTime().format(formatter);
		return operation.getCalculAsString() + " @" + dateStr;
	}
}
