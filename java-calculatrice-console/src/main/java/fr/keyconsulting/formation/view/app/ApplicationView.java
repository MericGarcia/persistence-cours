package fr.keyconsulting.formation.view.app;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import fr.keyconsulting.formation.controller.app.IApplicationCtrl;
import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.model.Operand;
import fr.keyconsulting.formation.model.Operators;
import fr.keyconsulting.formation.presentation.IPresentation;
import fr.keyconsulting.formation.view.DateTimeCellFactory;
import fr.keyconsulting.formation.view.util.JfxUtils;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ApplicationView implements IPresentation  {
	
	private Scene scene;
	
	private IApplicationCtrl ctrl;	

	public ApplicationView(IApplicationCtrl ctrl) {
		super();
		this.ctrl = ctrl;
        this.scene = null;
	}
	
	@Override
	public Class<?> getImplementationClass() {
		return Scene.class;
	}
	
	public void init(Stage primaryStage) {
        primaryStage.setWidth(1024);
        primaryStage.setHeight(968);
        primaryStage.setTitle("KC JavaFX");

    	primaryStage.setScene(getScene());
    	
        primaryStage.show();	
	}
	
	public Scene getScene() {
		if( this.scene == null ) {
			scene = buildScene();
		}
		return this.scene;
	}
	
	private Scene buildScene() {
        Scene scene = new Scene((Parent) JfxUtils.loadFxml("/fr/keyconsulting/formation/fxml/vue.fxml", ctrl), 1024, 968);
        scene.getStylesheets().add("/fr/keyconsulting/formation/css/style.css");
        return scene;
	}

}
