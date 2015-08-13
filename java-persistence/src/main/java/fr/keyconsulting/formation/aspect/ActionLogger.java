package fr.keyconsulting.formation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class ActionLogger {
	
  @Around("execution(* *(..))")
  public Object around(ProceedingJoinPoint point) {
    long start = System.currentTimeMillis();
    Object result = null;
	try {
		result = point.proceed();
	} catch (Throwable e) {
		e.printStackTrace();
	}
    long elapsed =  System.currentTimeMillis() - start;
    System.out.println(
      MethodSignature.class.cast(point.getSignature()).getMethod().getName() + " - Time : " + elapsed    
    );
    return result;
  }
  
}