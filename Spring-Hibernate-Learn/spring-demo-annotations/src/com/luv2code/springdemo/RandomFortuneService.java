package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	String fortunes[] = {"Happy","Sad","Confused"};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(fortunes.length);
		
		return "Today is your "+fortunes[index]+" day!";
	}

}
