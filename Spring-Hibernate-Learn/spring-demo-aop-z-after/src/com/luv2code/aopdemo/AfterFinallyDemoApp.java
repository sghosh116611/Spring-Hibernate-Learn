package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// load the spring configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the method to find the accounts
		List<Account> myAccounts = null;
		try {
			// add boolean flag to simulate exception
			boolean flag = false;
			myAccounts = theAccountDAO.findAccounts(flag);
		} catch (Exception e) {
			System.out.println("\n\nMain program.. caught exception!");
		}

		// display the accounts
		System.out.println("\n\n Main program: AfterFinallyDemoApp");
		System.out.println("---------");

		System.out.println(myAccounts);

		// close the spring context
		context.close();

	}

}
