package com.edu.EmployeeApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.EmployeeApplication.entity.Employee;
import com.edu.EmployeeApplication.repository.EmployeeRepository;

import exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository employeerepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeerepository) {
		super();
		this.employeerepository = employeerepository;
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeerepository.save(employee);	
	}
	@Override
	
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
        return employeerepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {  // 101
		   //thorw          throws
		Employee employee= new Employee();
		employee = employeerepository.findById(id).orElseThrow(
			()-> new ResourceNotFoundException("Employee","id",id));
		return employee;
	}
   @Override
	public Employee updateEmployee(long id, Employee employee) {  //id=101
		
		Employee emp= new Employee();
		emp = employeerepository.findById(id).orElseThrow(
			()-> new ResourceNotFoundException("Employee","id",id));
	
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		emp.setContactNo(employee.getContactNo());
		emp.setDesignation(employee.getDesignation());

	
		employeerepository.save(emp);

        return emp;	
	}
    @Override
	public String deleteEmployee(long id) {

          Employee employee = new Employee();
          employee = employeerepository.findById(id).orElseThrow(
      			()-> new ResourceNotFoundException("Employee","id",id));
  		employeerepository.deleteById(id);
  		return "Record is deleted successfully";
	}
	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		return employeerepository.getEmployeeByFirstName(firstName);
	}
	
    
    @Override
	public List<Employee> getEmployeeByLastName(String lastName) {
		return employeerepository.findByLastName(lastName);
	}
    @Override
   public List<Employee> getEmployeeByFullName(String firstName, String lastName) {
        return employeerepository.getEmployeeByFullName(firstName,lastName);
    }
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void employeeList() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub
	}





	//@Override//
	//public Employee addEmployee(Employee employee) {//
		// TODO Auto-generated method stub//
	//	return null;//
	}


		