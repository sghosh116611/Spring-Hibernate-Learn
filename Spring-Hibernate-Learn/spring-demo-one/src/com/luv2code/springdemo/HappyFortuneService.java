package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	private String fortunes[] = {"Happy","Sad","Confused"};
	@Override
	public String getFortune() {
		return "Today is your "+ fortunes[new Random().nextInt(fortunes.length)] +" day.";
	}

}
