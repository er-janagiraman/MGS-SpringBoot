package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.pojo.Employee;
import com.mindgate.main.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface employeeService;
	
	@RequestMapping(value="addEmployee",method = RequestMethod.POST)
	public boolean addNewEmployee(@RequestBody Employee emp) {

		return employeeService.addNewEmployee(emp);
	}
	
	@RequestMapping(value="updateEmployee",method = RequestMethod.PUT)
	public boolean updateEmployee(@RequestBody Employee emp) {

		return employeeService.updateEmployee(emp);
	}
	
	@RequestMapping(value="delete/{employeeId}",method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable int employeeId) {

		return employeeService.deleteEmployee(employeeId);
	}
	
	@RequestMapping(value="getdata/{employeeId}",method = RequestMethod.GET)
	public Employee getEmployeeByEmployeeId(@PathVariable int employeeId) {

		return employeeService.getEmployeeByEmployeeId(employeeId);
	}
	
	@RequestMapping(value="getAllData" , method=RequestMethod.GET)
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();
	}
}
