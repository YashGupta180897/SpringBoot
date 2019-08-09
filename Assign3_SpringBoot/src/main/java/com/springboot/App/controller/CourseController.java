package com.springboot.App.controller;

import com.springboot.App.domain.Course;
import com.springboot.App.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by yash.gupta on 7/31/2019.
 */

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourse()
    {
        return courseService.getAllCourse();
    }

    @PostMapping
    public List<Course> addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
        return courseService.getAllCourse();
    }

    @GetMapping(value = "/{course_id}")
    public Optional<Course> getCourse(@PathVariable int course_id)
    {
       return courseService.getCourse(course_id);
    }

    @PutMapping(value="/update")
    public String updateCourse(@RequestBody Course course)
    {
        courseService.updateCourse(course);
        return "Processed";
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id)
    {
       courseService.deleteById(id);
    }
}
