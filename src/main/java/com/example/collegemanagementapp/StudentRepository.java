package com.example.collegemanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer, Student> studentDb = new HashMap<>();
    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getId())){
            return "Student already registered";
        }
        studentDb.put(student.getId(),student);
        return "Student registered successfully!!";
    }

    public Student getStudent(int id) {
        if(studentDb.containsKey(id)){
            return studentDb.get(id);
        }
        return null;
    }

    public Student getStudentByName(String name) {
        for(Integer id: studentDb.keySet()){
            if(studentDb.get(id).getName().equals(name)){
                return studentDb.get(id);
            }
        }
        return null;
    }
}
