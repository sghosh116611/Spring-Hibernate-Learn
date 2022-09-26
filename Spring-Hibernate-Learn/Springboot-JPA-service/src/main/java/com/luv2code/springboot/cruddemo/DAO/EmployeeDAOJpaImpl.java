package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import javax.websocket.Session;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employees = query.getResultList();
		
		return employees;
		
	}

	@Override
	public Employee findById(int Id) {
		Employee employee = entityManager.find(Employee.class, Id);
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		entityManager.merge(employee);

	}

	@Override
	public void deleteById(int Id) {
		Query query = entityManager.createQuery("delete from Employee where id:employeeId");
		query.setParameter("employeeId", Id);
		query.executeUpdate();
	}

}
