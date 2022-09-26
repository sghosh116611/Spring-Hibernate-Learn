package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLogginAspect {
	
	// Advises

	// @Before advice
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDAOPackageExceptGetterSetter()")
	public void runBeforeMethod() {

		System.out.println("\n===>>> Executing @Before advice on method");
		
	}

}
