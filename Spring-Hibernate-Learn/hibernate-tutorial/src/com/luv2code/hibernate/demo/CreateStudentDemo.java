package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student POJO
			System.out.println("Creating the student");
			Student student = new Student("Paul","Ghosh","ghoshsoumojit53@gmail.com");
			//Start transaction
			session.beginTransaction();
			//Save the student object
			System.out.println("Saving the student object");
			session.save(student);
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			factory.close();
		}
		
	}

}
