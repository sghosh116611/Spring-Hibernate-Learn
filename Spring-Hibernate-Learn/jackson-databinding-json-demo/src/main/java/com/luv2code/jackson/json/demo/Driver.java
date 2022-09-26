package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			// create the object mapper
			ObjectMapper objectMapper = new ObjectMapper();

			// convert json to POJO
			Student student = objectMapper.readValue(new File("data/sample-full.json"), Student.class);

			// print the values
			System.out.println(">>First Name:"+student.getFirstName());
			System.out.println(">>Last Name:"+student.getLastName());
			
			System.out.println(">>Address Street:"+student.getAddress().getStreet());
			System.out.println(">>Address city:"+student.getAddress().getCity());
			
			System.out.println(">>>Languages:");
			for(String language: student.getLanguages()) {
				System.out.println(language);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
