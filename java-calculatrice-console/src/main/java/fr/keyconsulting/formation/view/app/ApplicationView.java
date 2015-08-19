package fr.keyconsulting.formation.view.app;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.model.ICalcul;
import fr.keyconsulting.formation.view.AView;
import fr.keyconsulting.formation.view.util.JFXUtils;

public class ApplicationView extends AView<IApplicationCtrl, FxController>  {
	
	private Scene scene;
	
	public ApplicationView(IApplicationCtrl ctrl) {
		super();
		setController(ctrl);
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
	
	public void addNewCalcul(ICalcul calc) {
		getFxController().addCalcul(calc);		
	}
	
	@Override
	public Node getFxComponent() {
		return getScene().getRoot();
	}
	
	private Scene buildScene() {
		Parent rootNode = JFXUtils.loadFxml("/fr/keyconsulting/formation/fxml/appView.fxml", this);
        Scene scene = new Scene(rootNode, 1024, 968);
        scene.getStylesheets().add("/fr/keyconsulting/formation/css/style.css");
        return scene;
	}

}
