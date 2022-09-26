package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach cricketCoach = context.getBean("myCricketCoach", Coach.class);

		// call methods on the bean
		
		/*--------*/
		// IoC
		System.out.println(theCoach.getDailyWorkout());
		 
		/*--------*/
		
		// DI
		
		//Constructor Injection
		System.out.println(theCoach.getFortuneService());
		
		//Setter Injection
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getFortuneService());
		
		/*--------*/
		
		// close the context
		context.close();
		
		/*--------*/

	}

}
