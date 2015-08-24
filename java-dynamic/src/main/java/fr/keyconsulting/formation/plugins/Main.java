package fr.keyconsulting.formation.plugins;

import java.io.InputStream;
import java.util.Properties;

public class Main {
	
	public static void main(String... args) throws Exception {
		Properties appProps = new Properties();
		try( InputStream is = Main.class.getResourceAsStream("/application.properties") ) {			
			appProps.load(is);
		}
		
		String implClassName = appProps.getProperty("plugin.impl.class");
		
		Class<?> clazz = Class.forName(implClassName);
		IPlugin plugin = (IPlugin) clazz.newInstance();		
		
		System.out.println(plugin.getName() + ": ");
		plugin.doSomething();
		System.out.println("Ok.");		
	}	

}
