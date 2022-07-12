package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.pojo.Employee;
import com.mindgate.main.repository.EmployeeRepositoryInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	 EmployeeRepositoryInterface  employeeRepository;

	@Override
	public boolean addNewEmployee(Employee emp) {
	
		return employeeRepository.addNewEmployee(emp);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		
		return employeeRepository.updateEmployee(emp);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.getAllEmployees();
	}

}
