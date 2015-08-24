package fr.keyconsulting.formation.plugins;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Properties;

import fr.keyconsulting.formation.plugins.proxy.LogInvocationHandler;

public class MainProxy {
	
	public static void main(String... args) throws Exception {
		Properties appProps = new Properties();
		try( InputStream is = Main.class.getResourceAsStream("/application.properties") ) {			
			appProps.load(is);
		}
		
		String implClassName = appProps.getProperty("plugin.impl.class");
		
		Class<?> clazz = Class.forName(implClassName);
		IPlugin plugin = (IPlugin) clazz.newInstance();		
		
		IPlugin proxy = getProxy(plugin);
		
		System.out.println(proxy.getName() + ": ");
		proxy.doSomething();
		System.out.println("Ok.");		
	}

	private static IPlugin getProxy(IPlugin plugin) {
		Class<?>[] interfaces = new Class<?>[] {IPlugin.class};
		return (IPlugin) Proxy.newProxyInstance(IPlugin.class.getClassLoader(), interfaces, new LogInvocationHandler(plugin));
	}

}
