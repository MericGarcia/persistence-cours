package fr.keyconsulting.formation.view.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import fr.keyconsulting.formation.Main;
import fr.keyconsulting.formation.control.IController;
import fr.keyconsulting.formation.view.AFxController;

public class JFXUtils {
	 
    public static <C extends IController, N extends Node> N loadFxml(String fxml, C standardCtrl) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(JFXUtils.class.getResource(fxml));
            N root = loader.load(Main.class.getResource(fxml).openStream());
            
            //Init the standard app controller here
            AFxController<C> fxCtrl = loader.getController();
            fxCtrl.setController(standardCtrl);
            
            return root;
        } catch (Exception e) {
            throw new IllegalStateException("Cannot load FXML screen from: " + fxml, e);
        }
    }
    
	public static Alert getErrorDialog(String errHeader, String errDesc, Exception ex) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erreur");
		alert.setHeaderText(errHeader);
		alert.setContentText(errDesc);

		// Create expandable Exception.
		String exceptionText = stackTraceToString(ex);
		Label label = new Label("Détails de l'erreur :");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		return alert;				
	}

	public static String stackTraceToString(Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String exceptionText = sw.toString();
		return exceptionText;
	}
    
}