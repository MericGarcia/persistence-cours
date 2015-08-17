package fr.keyconsulting.formation.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.sun.prism.paint.Color;

import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.model.Operand;
import fr.keyconsulting.formation.model.Operators;
import fr.keyconsulting.formation.persistence.FilePersistenceService;
import fr.keyconsulting.formation.persistence.ORMPersistenceService;
import fr.keyconsulting.formation.service.PersistenceService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

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
	
	private PersistenceService persister;

	public void initialize(URL location, ResourceBundle resources) {
		operator.setItems(FXCollections.observableArrayList(Operators.all()));
		persister = new ORMPersistenceService();
		tableView.setItems(FXCollections.observableArrayList(persister.load()));
		time.setCellFactory(new DateTimeCellFactory<Calcul>());
	}

	public void run(ActionEvent event) {
		Calcul calcul = new Calcul(new Operand(leftOperand.getText()), Operators.of(operator.getValue()),
				new Operand(rightOperand.getText()));
		tableView.getItems().add(calcul);
		persister.persist(calcul);
		result.setText(calcul.execute().getValue().toPlainString());
	}

}