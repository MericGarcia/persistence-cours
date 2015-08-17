package fr.keyconsulting.formation.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {
	
	private static Logger LOGGER = Logger.getLogger(LogAspect.class);

	@Before(" call(* fr.keyconsulting..*.*(..))" + "&& !within( fr.keyconsulting.formation.aspect..*)")
	public void beforePrintlnCall() {
		LOGGER.info("About to make call");
	}

	@After(" call(* fr.keyconsulting..*.*(..)) " + "&&  !within( fr.keyconsulting.formation.aspect..*)")
	public void afterPrintlnCall() {
		LOGGER.info("Just made call");
	}

}
