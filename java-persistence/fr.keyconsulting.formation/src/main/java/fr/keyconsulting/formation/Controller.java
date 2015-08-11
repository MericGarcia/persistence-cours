package fr.keyconsulting.formation;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import fr.keyconsulting.formation.model.Pays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
		
	}
	
	public void run(ActionEvent event){
		items.add(new Pays(code.getText(),Integer.valueOf(population.getText()), new BigDecimal(pib.getText()) ));
		tableView.setItems(items);
	};
 

    
}