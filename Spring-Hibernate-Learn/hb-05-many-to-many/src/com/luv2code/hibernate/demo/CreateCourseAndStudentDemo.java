package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start transaction
			session.beginTransaction();

			//create a course
			Course course = new Course("Pacman");
			
			//save the course
			System.out.println("Save the course");
			session.save(course);
			System.out.println("\nSaved the course "+ course);
			
			//create the Students
			Student student1 = new Student("John","Doe","john@gmail.com");
			Student student2 = new Student("Mary","Public","mary@gmail.com");
			
			//save students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the students
			System.out.println("\nSave the student");
			session.save(student1);
			session.save(student2);
			System.out.println("\nSaved the student "+ student1 + "," + student2);
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
