package fr.keyconsulting.formation.view.app;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.presentation.IPresentation;
import fr.keyconsulting.formation.view.util.JFXUtils;

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
	
	public void displayError(String errHeader, String errDesc, Exception ex) {
		Alert alertBox = JFXUtils.getErrorDialog(errHeader, errDesc, ex);
		alertBox.showAndWait();		
	}
	
	private Scene buildScene() {
        Scene scene = new Scene((Parent) JFXUtils.loadFxml("/fr/keyconsulting/formation/fxml/vue.fxml", ctrl), 1024, 968);
        scene.getStylesheets().add("/fr/keyconsulting/formation/css/style.css");
        return scene;
	}

}
