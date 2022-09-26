package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers(int sortField) {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		String fieldName = "";

		// determine the sort field
		switch (sortField) {
		case SortUtils.FIRST_NAME:
			fieldName = "firstName";
			break;
		case SortUtils.LAST_NAME:
			fieldName = "lastName";
			break;
		case SortUtils.EMAIL:
			fieldName = "email";
			break;
		default:
			fieldName = "lastName";

		}

		// create a query
		String queryString = "from Customer order by " + fieldName;
		Query<Customer> query = session.createQuery(queryString, Customer.class);

		// execute query and get the result
		List<Customer> customers = query.getResultList();

		// return the customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// save the customer
		session.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current session
		Session session = sessionFactory.getCurrentSession();

		// get the customer
		Customer theCustomer = session.get(Customer.class, theId);

		// return the customer
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current session
		Session session = sessionFactory.getCurrentSession();

		// delete the customer
		Query theQuery = session.createQuery("delete from Customer where id=:theId");
		theQuery.setParameter("theId", theId);

		theQuery.executeUpdate();

	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {

		// get the current session
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = null;

		// only search if search by name is not empty
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = session
					.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName");
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			theQuery = session.createQuery("from Customer");
		}

		// execute query and get the result list
		List<Customer> customerList = theQuery.getResultList();

		// return result
		return customerList;
	}

}
