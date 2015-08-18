package fr.keyconsulting.formation.view.app;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fr.keyconsulting.formation.controller.app.IApplicationCtrl;
import fr.keyconsulting.formation.presentation.IPresentation;
import fr.keyconsulting.formation.view.util.JfxUtils;

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
