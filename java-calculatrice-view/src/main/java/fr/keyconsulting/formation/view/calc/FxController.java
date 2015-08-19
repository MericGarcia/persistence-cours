package fr.keyconsulting.formation.view.calc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.model.Operators;
import fr.keyconsulting.formation.model.Result;
import fr.keyconsulting.formation.view.AFxController;

public class FxController extends AFxController<ICalculCtrl> implements Initializable {

	@FXML
	private TextField leftOperand;

	@FXML
	private ChoiceBox<String> operator;

	@FXML
	private TextField rightOperand;

	@FXML
	private TextArea result;

	public void initialize(URL location, ResourceBundle resources) {
		operator.setItems(FXCollections.observableArrayList(Operators.all()));
	}

	public void compute(ActionEvent event) {
		try {
			getController().setLeftOperand(leftOperand.getText());
			getController().setOperator(operator.getValue());
			getController().setRightOperand(rightOperand.getText());
			Result resultValue = getController().execute();
			result.setText(resultValue.getValue().toPlainString());
		} catch (Exception e) {
			getController().handleException(e);
		}
	}

}
