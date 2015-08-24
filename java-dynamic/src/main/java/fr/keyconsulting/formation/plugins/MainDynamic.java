package fr.keyconsulting.formation.plugins;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import fr.keyconsulting.formation.plugins.dynamic.PluginClassLoader;

public class MainDynamic {
	
	public static void main(String... args) throws Exception {
		Properties appProps = new Properties();
		try( InputStream is = Main.class.getResourceAsStream("/application.properties") ) {			
			appProps.load(is);
		}
		
		String implClassName = appProps.getProperty("plugin.impl.class");
		
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		
		Class<?> clazz = contextClassLoader.loadClass(implClassName);
		IPlugin plugin = (IPlugin) clazz.newInstance();			
		executePlugin(plugin);
		
		File binFolder = new File(Main.class.getResource("/").getFile());
		
		System.out.println("Entrer 'yes' when ready");
		Scanner input = new Scanner(System.in);
		input.next();
		input.close();
				
		clazz = new PluginClassLoader(contextClassLoader, binFolder).loadClass(implClassName);
		
		IPlugin reloadedPlugin = (IPlugin) clazz.newInstance();			
		executePlugin(reloadedPlugin);
		
		System.out.println(plugin.getClass());
		System.out.println(reloadedPlugin.getClass());
		System.out.println("reloaded instance of himself: " + plugin.getClass().isInstance(reloadedPlugin));
		System.out.println("plugin instance of IPlugin: " + IPlugin.class.isInstance(plugin));
		System.out.println("reloadedPlugin instance of IPlugin: " + IPlugin.class.isInstance(reloadedPlugin));
		
		System.out.println("Ok.");
	}

	private static void executePlugin(IPlugin plugin) {
		System.out.println(plugin.getName() + ": ");
		plugin.doSomething();
	}

}
