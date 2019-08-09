package com.springboot.App.controller;

import com.springboot.App.domain.StudentCourse;

import com.springboot.App.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by yash.gupta on 7/31/2019.
 */
@RestController
@RequestMapping("/studentCourses")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("/all")
    private List<StudentCourse> getAllStudentCourses()
    {
        return studentCourseService.getAllStudentCourses();
    }

    @GetMapping("/{id}")
    private Optional<StudentCourse> getStudentCourse(@PathVariable int id)
    {
        return studentCourseService.getStudentCourse(id);
    }

    @GetMapping("/course/{id}")
    private List<StudentCourse> getByCourseId(@PathVariable int id)
    {
        return studentCourseService.getByCourseId(id);
    }

    @GetMapping("/student/{id}")
    private List<StudentCourse> getByStudentId(@PathVariable int id)
    {
        return studentCourseService.getByStudentId(id);
    }

    @GetMapping("/course/{id}/maxMarks")
    private StudentCourse getMaxMarksByCourseId(@PathVariable int id)
    {
        return studentCourseService.getMaxMarksByCourseId(id);
    }

    @GetMapping("/course/{id}/avgMarks")
    private StringBuilder getAvgMarksByCourseId(@PathVariable int id)
    {
        return studentCourseService.getAvgMarksByCourseId(id);
    }

    @GetMapping("/student/{id}/maxMarks")
    private StudentCourse getMaxMarksByStudentId(@PathVariable int id)
    {
        return studentCourseService.getMaxMatksByStudentId(id);
    }

    @GetMapping("/student/{id}/latestMarks")
    private StudentCourse getLatestMarksByStudentId(@PathVariable int id)
    {


        return studentCourseService.getLatestMarksByStudentId(id);
    }

}
