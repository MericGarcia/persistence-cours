package fr.keyconsulting.formation.view.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class FxApplication extends Application {
	
	private static ApplicationView appCurrentView;
	
	public static void launch(ApplicationView appView, String[] args) {
		appCurrentView = appView;
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		appCurrentView.init(primaryStage);		
	}

}
