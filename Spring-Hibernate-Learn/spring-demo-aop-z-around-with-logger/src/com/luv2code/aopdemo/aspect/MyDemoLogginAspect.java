package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	// Logger

	private Logger logger = Logger.getLogger(MyDemoLogginAspect.class.getName());

	// Advises

	// @Before advice
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDAOPackageExceptGetterSetter()")
	public void runBeforeMethod(JoinPoint joinPoint) {

		logger.info("\n===>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		logger.info("Method:" + methodSignature);

		// display the method argument
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			logger.info(arg.toString());

			if (arg instanceof Account) {
				// downcast and print account specific stuff
				Account account = (Account) arg;

				logger.info("Account name:" + account.getName());
				logger.info("Level name:" + account.getLevel());
			}

		}

	}

	// AfterReturning Advice
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

		// print method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n========>>Executing @AfterReturning advice on method:" + method);

		logger.info("\n====>> result is:" + result);

		// post-processing the data

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		logger.info("\n====>> result is:" + result);

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
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExec")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExec) {

		// print the method
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n========>>Executing @AfterThrowing advice on method:" + method);

		// log the exception
		logger.info("\n========>>Exception is:" + theExec);
	}

	// AfterFinally Advises
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

		// print the method
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n========>>Executing @After (finally) advice on method:" + method);

	}

	// Around Advises
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {

		// print the method
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n========>>Executing @After (finally) advice on method:" + method);

		// get the begin timeStamp
		long beginTimeStamp = System.currentTimeMillis();

		// execute the method
		Object result = joinPoint.proceed();

		// get end timeStamp
		long endTimeStamp = System.currentTimeMillis();

		// compute the duration and display it
		long duration = endTimeStamp - beginTimeStamp;
		logger.info("\n======>>>Duration:" + duration / 1000.0 + "seconds");

		return result;

	}

}
