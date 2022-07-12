package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.pojo.Employee;

public interface EmployeeServiceInterface {

	boolean addNewEmployee(Employee emp);

	boolean updateEmployee(Employee emp);

	boolean deleteEmployee(int employeeId);

	Employee getEmployeeByEmployeeId(int employeeId);

	List<Employee> getAllEmployees();
}
