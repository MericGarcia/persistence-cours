package fr.keyconsulting.formation.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import fr.keyconsulting.formation.model.PIB;
import fr.keyconsulting.formation.model.Pays;
import fr.keyconsulting.formation.model.Population;
import fr.keyconsulting.formation.util.JfxUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class Controller implements Initializable {

	@FXML
	private TextField code;

	@FXML
	private TextField population;

	@FXML
	private TextField pib;

	@FXML
	private TableView<Pays> tableView;

	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Pays, String> btnCol = new TableColumn<>();
		btnCol.setMinWidth(140);
		tableView.getColumns().add(btnCol);
		btnCol.setCellFactory(new ButtonCellFactory("Delete",80));
		tableView.setItems(FXCollections.observableArrayList());
	}

	public void run(ActionEvent event) {
		FilteredList<Pays> paysList = tableView.getItems().filtered(p -> p.getNom().equals(code.getText()));
		Pays pays;
		if(paysList.size() > 0){
			pays = paysList.get(0);
			pays.getPopulationHistory().add(new Population(Integer.valueOf(population.getText()), LocalDateTime.now()));
			pays.getPibHistory().add(new PIB(new BigDecimal(pib.getText()), LocalDateTime.now()));
			
		}else{
			pays = new Pays(code.getText(), Integer.valueOf(population.getText()), new BigDecimal(pib.getText()));
			tableView.getItems().add(pays);
		}

		JfxUtils.refreshTableView(tableView);
	};

	private final class ButtonCellFactory implements Callback<TableColumn<Pays, String>, TableCell<Pays, String>> {

		int width;
		String text;
		
		public ButtonCellFactory(String text,int width) {
			this.width = width;
			this.text = text;
		}
		
		@Override
		public TableCell<Pays, String> call(final TableColumn<Pays, String> param) {

			final TableCell<Pays, String> cell = new TableCell<Pays, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					if (!empty) {
						final Button button = new Button(text);
						button.setMinWidth(width);
						button.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								param.getTableView().getItems().remove(getIndex());
							}

						});
						setGraphic(button);
						setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
					} else {
						setGraphic(null);
					}

				}
			};
			return cell;
		}
	}
}