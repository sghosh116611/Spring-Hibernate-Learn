package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) throws Exception {

		// load the spring configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the method to find the accounts
		List<Account> myAccounts = theAccountDAO.findAccounts(false);
		
		// display the accounts
		System.out.println("\n\n Main program: AfterReturningDemoApp");
		System.out.println("---------");
		
		System.out.println(myAccounts);

		// close the spring context
		context.close();

	}

}
