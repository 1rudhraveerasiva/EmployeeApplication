package com.edu.EmployeeApplication.service;

import java.util.List;

import com.edu.EmployeeApplication.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	 void employeeList();

	void updateEmployee();

	void deleteEmployee();

	List<Employee> getEmployeeList();

	Employee getEmployeeById(long id);

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(long id, Employee employee);

	String deleteEmployee(long id);
}
