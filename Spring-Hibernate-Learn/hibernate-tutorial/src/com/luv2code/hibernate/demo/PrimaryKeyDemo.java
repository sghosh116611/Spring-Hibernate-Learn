package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create 3 student POJOs
			System.out.println("Creating 3 student objects");
			Student student1 = new Student("John","Doe","johndoe@gmail.com");
			Student student2 = new Student("Mary","Public","marypublic@gmail.com");
			Student student3 = new Student("Ramo","Sen","ramosen@gmail.com");
			//Start transaction
			session.beginTransaction();
			//Save the student object
			System.out.println("Saving the student object");
			session.save(student1);
			session.save(student2);
			session.save(student3);
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
