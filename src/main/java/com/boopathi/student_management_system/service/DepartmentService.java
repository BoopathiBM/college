package com.boopathi.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boopathi.student_management_system.model.Department;
import com.boopathi.student_management_system.repo.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();        
    }

    public Optional<Department> getDepartmentById(int id){
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(Department department){
       
        return departmentRepository.save(department);
    }
    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }

    @Transactional
    public Department updateDepartment(int id, Department updatedDepartment) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existingDepartment.setDeptname(updatedDepartment.getDeptname());

        existingDepartment.getStudents().forEach(student -> student.setDept(existingDepartment));
        existingDepartment.getStaff().forEach(Staff -> Staff.setDept(existingDepartment));

        return departmentRepository.save(existingDepartment);
    }

   


}
