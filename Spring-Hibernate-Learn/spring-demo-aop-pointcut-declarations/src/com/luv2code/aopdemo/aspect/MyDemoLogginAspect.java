package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// Pointcut declaration
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("forDAOPackage() && !(setter() || getter())")
	public void forDAOPackageExceptGetterSetter() {}
	
	// Advises

	// @Before advice
	@Before("forDAOPackageExceptGetterSetter()")
	public void runBeforeMethod() {

		System.out.println("\n===>>> Executing @Before advice on method");
		
	}
	
	@Before("forDAOPackageExceptGetterSetter()")
	public void performAPIAnalytics() {
		
		System.out.println("\n====>>> Performing API analytics ");
		
	}

}
