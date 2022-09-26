package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLogginAspect {
	
	// Advises

	// @Before advice
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDAOPackageExceptGetterSetter()")
	public void runBeforeMethod(JoinPoint joinPoint) {

		System.out.println("\n===>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method:"+methodSignature);
		
		// display the method argument
		Object[] args = joinPoint.getArgs();
		
		for(Object arg: args) {
			System.out.println(arg);
			
			if(arg instanceof Account) {
				// downcast and print account specific stuff
				Account account = (Account)arg;
				
				System.out.println("Account name:"+account.getName());
				System.out.println("Level name:"+account.getLevel());
			}
				
		}
		
	}

}
