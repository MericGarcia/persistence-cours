package fr.keyconsulting.formation.plugins.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibInterceptor implements MethodInterceptor {
	
	private Object realObject;	

	public CglibInterceptor(Object realObject) {
		super();
		this.realObject = realObject;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("> method '" + method.getName() + "' called on '" + realObject.getClass().getSimpleName() + "' with args: " + args);
		return method.invoke(realObject, args);
	}

}
