package fr.keyconsulting.formation.view.util;

import java.io.IOException;

import fr.keyconsulting.formation.Main;
import fr.keyconsulting.formation.controller.app.IApplicationCtrl;
import fr.keyconsulting.formation.view.app.FxController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class JfxUtils {
	 
    public static Node loadFxml(String fxml, IApplicationCtrl ctrl) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(JfxUtils.class.getResource(fxml));
            Node root = (Node) loader.load(Main.class.getResource(fxml).openStream());
            FxController fxCtrl = loader.getController();
            fxCtrl.setController(ctrl);
            return root;
        } catch (IOException e) {
            throw new IllegalStateException("cannot load FXML screen", e);
        }
    }
    
}