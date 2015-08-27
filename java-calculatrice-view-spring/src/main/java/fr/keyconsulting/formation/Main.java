package fr.keyconsulting.formation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.factory.AFactory;

public class Main {
 
    public static void main(String[] args) throws Exception {
    
    	/*
    	AFactory.register(GUIControllersFactory.class);
    	AViewsFactory.register(FxViewsFactory.class);
    	IApplicationCtrl appCtrl = AFactory.getInstance().createApplication();
    	*/
    	
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/application-context.xml");
    	IApplicationCtrl appCtrl = applicationContext.getBean("ctrlFactory", AFactory.class).createApplication();
    	appCtrl.start(args);
    }

}