package com.edu.EmployeeApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.EmployeeApplication.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {




}
