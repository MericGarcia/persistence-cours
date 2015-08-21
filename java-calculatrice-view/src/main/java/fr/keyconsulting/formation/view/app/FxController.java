package fr.keyconsulting.formation.view.app;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.model.ICalcul;
import fr.keyconsulting.formation.view.AFxController;
import fr.keyconsulting.formation.view.DateTimeCellFactory;

public class FxController extends AFxController<IApplicationCtrl> implements Initializable {
	
	@FXML
	private TableView<ICalcul> tableView;

	@FXML
	private TableColumn<ICalcul, LocalDateTime> time;
	
	@FXML
	private StackPane operation;

	public void initialize(URL location, ResourceBundle resources) {
		tableView.setItems(FXCollections.observableArrayList());
		time.setCellFactory(new DateTimeCellFactory<ICalcul>());
	}

	public void newOperation(ActionEvent event) {
		ICalculCtrl operationCtrl = getController().createNewCalcul();
		//TODO : add Calcul FX Pane into the operation StackPane 
		/**
		Pane newOperationPane = (Pane) operationCtrl.getPresentation().asGUICompoment();
		this.operation.getChildren().clear();
		this.operation.getChildren().addAll(newOperationPane);
		*/
	}
	
	public void addCalcul(ICalcul calc) {
		tableView.getItems().add(calc);
	}
}
