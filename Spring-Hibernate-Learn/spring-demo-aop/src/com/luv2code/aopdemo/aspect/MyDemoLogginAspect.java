package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// advices

	// @Before advice
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void runBeforeMethod() {

		System.out.println("\n===>>> Executing @Before advice on method");
		
	}

}
