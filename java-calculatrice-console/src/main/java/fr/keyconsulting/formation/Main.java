package fr.keyconsulting.formation;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.app.ViewApplicationCtrl;

public class Main {
 
    public static void main(String[] args) {
    	IApplicationCtrl appCtrl = new ViewApplicationCtrl();
    	appCtrl.start(args);
    }

}