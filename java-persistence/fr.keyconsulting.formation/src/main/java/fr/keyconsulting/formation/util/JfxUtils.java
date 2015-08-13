package fr.keyconsulting.formation.util;

import java.io.IOException;

import fr.keyconsulting.formation.Main;
import fr.keyconsulting.formation.model.Pays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableView;

public class JfxUtils {
	 
    public static Node loadFxml(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(JfxUtils.class.getResource(fxml));
            Node root = (Node) loader.load(Main.class.getResource(fxml).openStream());
            return root;
        } catch (IOException e) {
            throw new IllegalStateException("cannot load FXML screen", e);
        }
    }
    
    /*
     * Dirty ...
     * 
     * */
    public static void refreshTableView(TableView<Pays> table){
    	table.getColumns().get(0).setVisible(false);
    	table.getColumns().get(0).setVisible(true);
    }
    
}