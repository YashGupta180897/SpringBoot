package com.springboot.App.service;

import com.springboot.App.domain.Student;
import com.springboot.App.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by yash.gupta on 8/1/2019.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> getStudent(int id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllByKeyword(String name) {
        return studentRepository.findAllByNameContaining(name);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
