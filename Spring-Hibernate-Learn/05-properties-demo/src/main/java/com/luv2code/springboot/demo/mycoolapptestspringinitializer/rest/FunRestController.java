package com.luv2code.springboot.demo.mycoolapptestspringinitializer.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world. Time on server is:" + LocalDateTime.now();
	}
	
	@GetMapping("/test")
	public String testNewEndPoint() {
		return "New End Point:" + LocalDateTime.now();
	}
	
	@GetMapping("/teampInfo")
	public String getTeamInfo() {
		return coachName + " " + teamName;
	}
}
