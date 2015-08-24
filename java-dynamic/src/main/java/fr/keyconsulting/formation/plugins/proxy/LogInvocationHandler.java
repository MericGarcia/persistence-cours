package fr.keyconsulting.formation.plugins.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import fr.keyconsulting.formation.plugins.IPlugin;

public class LogInvocationHandler implements InvocationHandler {
	
	private IPlugin plugin;	

	public LogInvocationHandler(IPlugin plugin) {
		super();
		this.plugin = plugin;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("> method '" + method.getName() + "' called on '" + plugin.getClass().getSimpleName() + "' with args: " + args);
		return method.invoke(plugin, args);
	}

}
