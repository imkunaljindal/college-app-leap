package com.example.collegemanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int id) {
        return null;
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }
}
