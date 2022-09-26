package com.luv2code.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class FetchJoinDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start transaction
			session.beginTransaction();

			// get the instructor from the db
			int theId = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);

			query.setParameter("theInstructorId", theId);

			Instructor instructor = query.getSingleResult();

			System.out.println(" luv2Code: Instructor:" + instructor);

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			// get course for the instructor
			System.out.println(" luv2Code:Courses:" + instructor.getCourses());

			System.out.println(" luv2Code: Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
