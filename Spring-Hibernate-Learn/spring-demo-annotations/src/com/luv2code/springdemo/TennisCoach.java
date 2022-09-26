package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	TennisCoach() {
		System.out.println("TennisCoach: Inside default constructor");
	}

	/*
	 * @Autowired TennisCoach(FortuneService theFortuneService){ fortuneService =
	 * theFortuneService; }
	 */

	// define setter method
	/*
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println("TennisCoach: Inside setFortuneService method");
	 * fortuneService = theFortuneService; }
	 */
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService theFortuneService) {
	 * System.out.println("TennisCoach: Inside doSomeCrazyStuff method");
	 * fortuneService = theFortuneService; }
	 */

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your back hand volley";
	}

	@Override
	public String getDailyFortune() {
		return "Hi "+this.getEmail()+".Welcome to "+this.getTeam()+"."+ fortuneService.getFortune();
	}
	
	@PostConstruct
	public void doSommeCrazyStuff() {
		System.out.println("Init method");
	}
	
	@PreDestroy
	public void doSomeDestroyStuff() {
		System.out.println("Destroy method");
	}

}
