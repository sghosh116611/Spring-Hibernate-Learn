package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//Start transaction
			session.beginTransaction();
			
			//Query the students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display the students
			displayStudents(theStudents);
			
			//query students : lastName="Doe" 
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").list();
			
			//display students
			System.out.println("\nStudents whose last name is Doe");
			displayStudents(theStudents);
			
			//query students : lastName="Doe" or fisrtName="Sneha"
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName='Sneha'").list();
			
			//display students
			System.out.println("\nStudents whose last name is Doe or first name of Sneha");
			displayStudents(theStudents);
			
			//query students : email like %gmail.com"
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			
			//display students
			System.out.println("\nStudents whose email like %gmail.com");
			displayStudents(theStudents);
			
			//commit transaction
			System.out.println("Done");
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student : theStudents)
			System.out.println(student);
	}

}
