package com.edu.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.EmployeeApplication.entity.Department;
import com.edu.EmployeeApplication.entity.Employee;
import com.edu.EmployeeApplication.repository.DepartmentRepository;

import exception.ResourceNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentrepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentrepository.save(department);
	}

	@Override
	public List<Department> getDepartmentList() {
		return departmentrepository.findAll();
	
	}

	@Override
	public Department getDepartmentId(long id) {  
		Optional<Department> department = departmentrepository.findById(id);
		if(department.isPresent())
			return department.get();
		else
			throw new ResourceNotFoundException("Department","id" ,id);
	}

	@Override
	public Department updateDepartment(long id, Department department) {
		
		Department dept = departmentrepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Department", "id", id));
		
		dept.setDepartmentId(department.getDepartmentId());
		dept.setDepartmentName(department.getDepartmentName());
		dept.setLocation(department.getLocation());
		dept.setHodId(department.getHodId());
		departmentrepository.save(dept);
		return dept;
	}

	@Override
	public String deleteDepartment(long id) {
		Department dept = departmentrepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Department", "id", id));
		departmentrepository.deleteById(id);
		return "record is deleted successfully";
	}

	
}

	