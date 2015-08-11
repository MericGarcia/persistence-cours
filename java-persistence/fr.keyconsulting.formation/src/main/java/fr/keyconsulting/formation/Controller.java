package fr.keyconsulting.formation;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import fr.keyconsulting.formation.model.Pays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

	final ObservableList<Pays> items = FXCollections.observableArrayList();;

	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<Pays, String> btnCol = new TableColumn();
		btnCol.setMinWidth(140);
		tableView.getColumns().add(btnCol);
		btnCol.setCellFactory(new Callback<TableColumn<Pays, String>, TableCell<Pays, String>>() {

			@Override
			public TableCell call(final TableColumn param) {

				final TableCell cell = new TableCell() {

					@Override
					public void updateItem(Object item, boolean empty) {
						super.updateItem(item, empty);
						final Button button = new Button("Delete");
						button.setMinWidth(130);
						button.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								param.getTableView().getItems().remove(getIndex());
							}
	                       
	                            
						});
						setGraphic(button);
						setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

					}
				};
				return cell;
			}
		});
	}

	public void run(ActionEvent event) {
		items.add(new Pays(code.getText(), Integer.valueOf(population.getText()), new BigDecimal(pib.getText())));
		tableView.setItems(items);
	};

	public void del(ActionEvent event) {
		items.remove(event.getSource());
		tableView.setItems(items);
	};

}