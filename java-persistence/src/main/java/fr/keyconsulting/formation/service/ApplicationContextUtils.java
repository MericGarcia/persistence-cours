package fr.keyconsulting.formation.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {
	
	private static ApplicationContext ctx;

	private static final String PERSISTENCE_SERVICE = "persistenceService";

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		ctx = appContext;

	}

	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	public static PersistenceService getPersistenceService() {
		return (PersistenceService)ctx.getBean(PERSISTENCE_SERVICE);
	}

}