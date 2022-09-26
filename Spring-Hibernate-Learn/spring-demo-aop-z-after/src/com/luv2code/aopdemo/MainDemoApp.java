package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// load the spring configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get the bean for membership DAO
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

		// call the business method
		Account account = new Account();
		account.setName("Jitu");
		account.setLevel("Test");
		theAccountDAO.addAccount(account,true);
		
		//do it again
		System.out.println("\nDoing it again");
		
		theAccountDAO.addAccount(account,true);
		theAccountDAO.doWork();
		
		// call the accountDAo getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		
		// call the business method for membership DAO
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();

		// close the spring context
		context.close();

	}

}












