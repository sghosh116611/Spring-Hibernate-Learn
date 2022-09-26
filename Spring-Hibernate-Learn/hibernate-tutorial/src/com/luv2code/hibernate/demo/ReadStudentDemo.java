package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student POJO
			System.out.println("Creating the student");
			Student student = new Student("Sneha","Bubu","bubusneha@gmail.com");
			//Start transaction
			session.beginTransaction();
			//Save the student object
			System.out.println("Saving the student object");
			session.save(student);
			//commit transaction
			session.getTransaction().commit();
			
			// New Code
			
			//get new session object and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student object
			System.out.println("\nGetting student with id:"+student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get complete:"+myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			factory.close();
		}
		
	}

}
