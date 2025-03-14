package com.boopathi.student_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boopathi.student_management_system.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
