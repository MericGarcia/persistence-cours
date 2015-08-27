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
import fr.keyconsulting.formation.view.AFxView;

public class JFXUtils {
	
	/**
	 * This loads some Java FX nodes from file and links all the controllers and view to themselves.
	 * Generic types used are these ones :
	 * - C the applicative controller
	 * - F the JavaFX controller
	 * - V the abstract View (who call this loading). 
	 * This View got a pointer to C which has to be to be set to the, just loaded, F.
	 * The F has to be set on V.
	 * 
	 * In brief, after the loading :  View { C ctrl, F fxCtrl }, FxCtrl { C ctrl, N[] nodes... }
	 * 
	 * @param fxml
	 * 		path to FXML file
	 * @param view
	 * 		the View which call this loading
	 * @return
	 * 		the loaded FX root Node
	 */
	public static <C extends IController, F extends AFxController<C>, V extends AFxView<C, F>, N extends Node> N loadFxml(String fxml, V view) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(JFXUtils.class.getResource(fxml));
			N root = loader.load(Main.class.getResource(fxml).openStream());

			// Init the FX controller here
			F fxCtrl = loader.getController();
			fxCtrl.setController(view.getController()); // link FX ctrl to applicative one
			view.setFxController(fxCtrl);	// link abstract view with the, new loaded, FX ctrl

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