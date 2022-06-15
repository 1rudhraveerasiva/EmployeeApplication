package com.edu.EmployeeApplication.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.EmployeeApplication.entity.Employee;
import com.edu.EmployeeApplication.repository.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void saveEmployeeTest() {
	
	Employee employee = employeeRepository.save(new Employee(6,"106","rudh","ramya","rudh@gmail.com","987435465","student"));
    Assertions.assertThat(employee.getId()).isGreaterThan(0);
}
	
	@Test 
	public void getEmployeeTest() {
		Employee employee = employeeRepository.findById(6L).get();
		Assertions.assertThat(employee.getId()).isEqualTo(6L);
	}
	
	@Test
	public void getEmployeeListTest() {
		List<Employee> employees = employeeRepository.findAll();
		
		Assertions.assertThat(employees.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateEmployeeTest() {
		Employee employee = employeeRepository.findById(0L).get();
		employee.setEmail("ram@gmail.com");
		Employee updated = employeeRepository.save(employee);
		
		Assertions.assertThat(updated.getEmail()).isEqualTo("ram@gmail.com");
	}
	
	@Test
	public void deleteEmployeeTest() {
	Employee emp = employeeRepository.findById(4L).get();
		employeeRepository.delete(emp);
		//4L
		Employee employee = null;
		Optional<Employee> emp1 = employeeRepository.findByEmail("priya@gmail.com");
	    if(emp1.isPresent()) {
	    employee = emp1.get(); //null
	    }
	    
	    Assertions.assertThat(employee).isNull();
	    
	}
}
