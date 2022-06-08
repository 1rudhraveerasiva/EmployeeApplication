package com.edu.EmployeeApplication.service;

import java.util.List;

import com.edu.EmployeeApplication.entity.Department;
import com.edu.EmployeeApplication.entity.Employee;

public interface DepartmentService {


	List<Department> getDepartmentList();

	Department saveDepartment(Department department);

	Department getDepartmentId(long id);

	Department updateDepartment(long id, Department department);

	String deleteDepartment(long id);


}
