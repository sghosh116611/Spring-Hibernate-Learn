package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean from configuration file
		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if these are same beans
		boolean result = (theCoach == alphaCoach);

		System.out.println("\n Pointing to the same object:" + result);
		System.out.println("\n Memory location for theCoach:" + theCoach);
		System.out.println("\n Memory location for alphaCoach:" + alphaCoach);

		// close context
		context.close();

	}

}
