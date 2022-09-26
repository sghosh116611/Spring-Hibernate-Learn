package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			//get new session object and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update student object
			System.out.println("\nGetting student with id:"+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Deleting student...:"+myStudent);
			session.delete(myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			// New Code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Delete students");
			
			session.createQuery("delete from Student s where id = 2").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			factory.close();
		}
		
	}

}
