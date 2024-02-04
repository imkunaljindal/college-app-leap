package com.example.collegemanagementapp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer, Student> studentDb = new HashMap<>();

    @PostMapping("/student/add")
    public String addStudent(@RequestBody Student student){
        if(studentDb.containsKey(student.getId())){
            return "Student already registered";
        }
        studentDb.put(student.getId(),student);
        return "Student registered successfully!!";
    }

    @GetMapping("/student/get")
    public Student getStudent(@RequestParam("id") int id){
        return studentDb.get(id);
    }

    @GetMapping("/student/get/{name}/{q}")
    public Student getStudentByName(@PathVariable("name") String name,
                                    @PathVariable("q") int age){

        for(Integer x: studentDb.keySet()){
            if(studentDb.get(x).getName().equals(name)){
                studentDb.get(x).setAge(age);
                return studentDb.get(x);
            }
        }

        return null;
    }
}
