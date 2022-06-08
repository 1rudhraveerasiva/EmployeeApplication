package com.edu.EmployeeApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.EmployeeApplication.entity.Department;
import com.edu.EmployeeApplication.entity.Employee;
import com.edu.EmployeeApplication.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
@Autowired
DepartmentService departmentService;

@PostMapping
public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
	return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
}
@GetMapping
public List<Department> getDepartmentList(){
	return departmentService.getDepartmentList();
}
@GetMapping("/{id}")
public Department getDepartmentById(@PathVariable("id") long id) {
	return departmentService.getDepartmentId(id);
	
}
@PutMapping("/{id}")
public Department updateDepartment(@PathVariable("id") long id, @RequestBody Department department) {
	return departmentService.updateDepartment(id,department); 
}
@DeleteMapping("/{id}")
public ResponseEntity deleteDepartment(@PathVariable("id") long id, @RequestBody Department department) {
return new ResponseEntity<String>(departmentService.deleteDepartment(id),HttpStatus.OK);
}
}



