package com.springboot.App.controller;

import com.springboot.App.domain.Student;
import com.springboot.App.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/all")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @PostMapping(value="/add")
    public List<Student> addStudent(@Valid @RequestBody Student student)
    {
        studentService.addStudent(student);
        return studentService.getAllStudents();
    }

    @GetMapping(value="/{id}")
    public Optional<Student> getStudent(@PathVariable int id)
    {
        return studentService.getStudent(id);
    }


    @PutMapping(value="/update")
    public String updateStudent(@RequestBody Student student)
    {
        studentService.updateStudent(student);
        return "Student details updated";
    }

    @GetMapping(value="/keyword/{name}")
    public List<Student> getAllByKeyword(@PathVariable String name)
    {
        return studentService.getAllByKeyword(name);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable int id)
    {
        studentService.deleteById(id);
        return "Record deleted";
    }
}
