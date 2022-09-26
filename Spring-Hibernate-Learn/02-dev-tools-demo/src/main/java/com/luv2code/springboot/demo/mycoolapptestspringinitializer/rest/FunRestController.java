package com.luv2code.springboot.demo.mycoolapptestspringinitializer.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello world. Time on server is:" + LocalDateTime.now();
	}
	
	@GetMapping("/test")
	public String testNewEndPoint() {
		return "New End Point:" + LocalDateTime.now();
	}
}
