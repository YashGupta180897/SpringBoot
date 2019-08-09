package com.springboot.App.repository;

import com.springboot.App.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yash.gupta on 7/31/2019.
 */
public interface CourseRepository extends JpaRepository<Course,Integer> {


}
