package com.boopathi.student_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boopathi.student_management_system.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
