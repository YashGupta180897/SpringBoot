package com.springboot.App.service;

import com.springboot.App.domain.Course;
import com.springboot.App.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by yash.gupta on 8/1/2019.
 */

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getAllCourse() {
       return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public Optional<Course> getCourse(int course_id) {
        return courseRepository.findById(course_id);

    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }
}
