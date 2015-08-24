package fr.keyconsulting.formation.plugins;

import java.io.InputStream;
import java.util.Properties;

import fr.keyconsulting.formation.plugins.proxy.CglibInterceptor;
import net.sf.cglib.proxy.Enhancer;

public class MainCglib {

	public static void main(String... args) throws Exception {
		Properties appProps = new Properties();
		try (InputStream is = Main.class
				.getResourceAsStream("/application.properties")) {
			appProps.load(is);
		}

		String implClassName = appProps.getProperty("plugin.impl.class");

		Class<?> clazz = Class.forName(implClassName);
		IPlugin plugin = (IPlugin) clazz.newInstance();

		IPlugin proxy = getCglibProxy(plugin);

		System.out.println(proxy.getName() + ": ");
		proxy.doSomething();
		System.out.println("Ok.");
	}

	private static IPlugin getCglibProxy(Object obj) {
		Enhancer e = new Enhancer();
		e.setSuperclass(IPlugin.class);
		e.setCallback(new CglibInterceptor(obj));
		return (IPlugin) e.create();
	}

}
