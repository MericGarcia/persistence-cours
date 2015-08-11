package fr.keyconsulting.formation;

import fr.keyconsulting.formation.util.JfxUtils;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(1024);
        primaryStage.setHeight(968);
        primaryStage.setTitle("KC JavaFX");
    	primaryStage.setScene(new Scene((Parent) JfxUtils.loadFxml("/fr/keyconsulting/formation/fxml/vue.fxml"), 1024, 968));
        primaryStage.show();
    }

}