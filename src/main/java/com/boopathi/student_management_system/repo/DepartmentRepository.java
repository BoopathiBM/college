package com.boopathi.student_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boopathi.student_management_system.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
