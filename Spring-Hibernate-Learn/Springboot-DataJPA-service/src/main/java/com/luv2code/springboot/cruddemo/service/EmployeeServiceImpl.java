package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int Id) {
		Optional<Employee> result = employeeRepository.findById(Id);
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("No employee id found:"+Id);
		}
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int Id) {
		employeeRepository.deleteById(Id);
	}

}
