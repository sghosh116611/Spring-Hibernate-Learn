package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

		System.out.println("Method:" + methodSignature);

		// display the method argument
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			System.out.println(arg);

			if (arg instanceof Account) {
				// downcast and print account specific stuff
				Account account = (Account) arg;

				System.out.println("Account name:" + account.getName());
				System.out.println("Level name:" + account.getLevel());
			}

		}

	}

	// AfterReturning Advice
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

		// print method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n========>>Executing @AfterReturning advice on method:" + method);

		System.out.println("\n====>> result is:" + result);

		// post-processing the data

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n====>> result is:" + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop throught the accounts
		for (Account account : result) {
			
			// get the uppercase version
			String accountNameUpperCase = account.getName().toUpperCase();

			// update the name
			account.setName(accountNameUpperCase);
		}

	}
	
	// AfterThrowing Advises
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing= "theExec")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExec) {
		
		// print the method
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n========>>Executing @@AfterThrowing advice on method:" + method);

		
		// log the exception
		System.out.println("\n========>>Exception is:" + theExec);
	}

}
