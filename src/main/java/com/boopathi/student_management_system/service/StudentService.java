package com.boopathi.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boopathi.student_management_system.model.Student;
import com.boopathi.student_management_system.repo.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
        
    }

    public Optional<Student> getStudentById(int id){
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student updateStudent(int id,Student updatedStudent){

        Student student = studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setDept(updatedStudent.getDept());
        return studentRepository.save(student);

    }

}
