package fr.keyconsulting.formation.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import fr.keyconsulting.formation.control.app.IApplicationCtrl;
import fr.keyconsulting.formation.control.app.ViewApplicationCtrl;
import fr.keyconsulting.formation.control.calc.ICalculCtrl;
import fr.keyconsulting.formation.control.calc.ViewCalculCtrl;

public class GUIControllersFactory extends AFactory implements ApplicationContextAware {
	
	private ApplicationContext applicationContext = null;
	
	public static AFactory initInstance() throws InstantiationException, IllegalAccessException {
		AFactory.register(GUIControllersFactory.class);
		return AFactory.getInstance();
	}
	
	@Override
	public IApplicationCtrl createApplication() {
		return applicationContext.getBean(IApplicationCtrl.class);	
	}
	
	@Override
	public ICalculCtrl createCalcul(IApplicationCtrl parent) {
		ICalculCtrl calc = (ICalculCtrl) applicationContext.getBean("calcul", parent);
		return calc;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;		
	}

}
