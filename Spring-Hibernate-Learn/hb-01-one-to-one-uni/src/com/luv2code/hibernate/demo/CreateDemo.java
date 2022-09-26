package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			//create the objects
			/*
			 * Instructor instructor = new Instructor("Jitu", "Ghosh", "jitu@gmail.com");
			 * 
			 * InstructorDetail instructorDetail = new
			 * InstructorDetail("http://www.xyz.com/youtube","luv2Code");
			 * 
			 * instructor.setInstructorDetail(instructorDetail);
			 */
			
			Instructor  instructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.xyz.com/madhu","luv2CodeMadhu");
			
			instructor.setInstructorDetail(instructorDetail);
			
			// Start transaction
			session.beginTransaction();
			
			// Save the instructor object
			System.out.println("Saving the instructor:");
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
