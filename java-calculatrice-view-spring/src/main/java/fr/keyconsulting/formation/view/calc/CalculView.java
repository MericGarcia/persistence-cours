package fr.keyconsulting.formation.view.calc;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.view.AFxView;
import fr.keyconsulting.formation.view.util.JFXUtils;

public class CalculView extends AFxView<ICalculCtrl, FxController>  {
	
	private Pane pane;
	
	public CalculView(ICalculCtrl ctrl) {
		super();
		this.pane = null;
		setController(ctrl);
	}

	@Override
	public Class<?> getImplementationClass() {		
		return Pane.class;
	}
	
	@Override
	protected Node getFxComponent() {
		return getPane();
	}
	
	public Pane getPane() {
		if( this.pane == null ) {
			pane = buildPane();
		}
		return this.pane;
	}
	
	private Pane buildPane() {
		Pane rootNode = JFXUtils.loadFxml("/fr/keyconsulting/formation/fxml/calcView.fxml", this);
        return rootNode;
	}

}
