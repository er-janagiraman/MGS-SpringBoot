package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.pojo.Employee;
import com.mindgate.main.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String ADD_EMPLOYEE = "INSERT INTO employee_details VALUES (?,?,?)";
	private static final String GET_ALL_DATA = "SELECT * FROM employee_details";
	private static final String GET_EMPLOYEE_BY_EMPLOYEE_ID = "SELECT * FROM employee_details WHERE employee_id=?";
	private static final String DELETE_EMPLOYEE = "DELETE employee_details WHERE employee_id = ?";
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details SET name=?,salary=? WHERE employee_id=?";

	@Override
	public boolean addNewEmployee(Employee emp) {
		Object args[] = { emp.getEmployeeId(), emp.getName(), emp.getSalary() };
		int count = jdbc.update(ADD_EMPLOYEE, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		Object args[] = { emp.getName(), emp.getSalary(), emp.getEmployeeId() };
		int count = jdbc.update(UPDATE_EMPLOYEE, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Object args[] = { employeeId };
		int count = jdbc.update(DELETE_EMPLOYEE, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		Object args[] = { employeeId };
		return jdbc.queryForObject(GET_EMPLOYEE_BY_EMPLOYEE_ID, new EmployeeRowMapper(), args);
	}

	@Override
	public List<Employee> getAllEmployees() {
//		EmployeeRowMapper er =new  EmployeeRowMapper();
//		List<Employee> allEmp = jdbc.query(GET_ALL_DATA, er);
//		return allEmp;
		return jdbc.query(GET_ALL_DATA, new EmployeeRowMapper());
	}

}
