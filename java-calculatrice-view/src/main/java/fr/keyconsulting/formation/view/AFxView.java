package fr.keyconsulting.formation.view;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import fr.keyconsulting.formation.control.IController;
import fr.keyconsulting.formation.presentation.IPresentation;
import fr.keyconsulting.formation.view.util.JFXUtils;

public abstract class AFxView<C extends IController, F extends AFxController<C>> extends AFxController<C> implements IPresentation {
	
	private F fxController;

	public F getFxController() {
		return fxController;
	}

	public void setFxController(F fxController) {
		this.fxController = fxController;
	}
	
	public void displayError(String errHeader, String errDesc, Exception ex) {
		Alert alertBox = JFXUtils.getErrorDialog(errHeader, errDesc, ex);
		alertBox.showAndWait();		
	}
	
	@Override
	public <T> T asGUICompoment() {
		return uncheckedCast(getFxComponent());
	}

	protected abstract Node getFxComponent();	

	@SuppressWarnings("unchecked")
	private <T> T uncheckedCast(Object obj) {
		return (T) obj;
	}

}
