package fr.keyconsulting.formation.view.app;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.model.Operators;
import fr.keyconsulting.formation.model.Result;
import fr.keyconsulting.formation.view.AFxController;
import fr.keyconsulting.formation.view.DateTimeCellFactory;

public class FxController extends AFxController<IApplicationCtrl>implements Initializable {
	
	@FXML
	private TextField leftOperand;

	@FXML
	private ChoiceBox<String> operator;

	@FXML
	private TextField rightOperand;

	@FXML
	private TextArea result;

	@FXML
	private TableView<Calcul> tableView;

	@FXML
	private TableColumn<Calcul, LocalDateTime> time;

	public void initialize(URL location, ResourceBundle resources) {
		operator.setItems(FXCollections.observableArrayList(Operators.all()));
		tableView.setItems(FXCollections.observableArrayList());
		time.setCellFactory(new DateTimeCellFactory<Calcul>());
	}

	public void run(ActionEvent event) {
		try {
			Calcul calcul = getController().createNewCalcul(leftOperand.getText(), operator.getValue(), rightOperand.getText());
			tableView.getItems().add(calcul);
			Result resultValue = getController().compute(calcul);
			result.setText(resultValue.getValue().toPlainString());
		} catch (Exception e) {
			getController().handleException(e);
		}
	}
}
