package com.springboot.App.repository;

import com.springboot.App.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yash.gupta on 7/31/2019.
 */
public interface StudentCourseRepository extends JpaRepository<StudentCourse,Integer> {



     List<StudentCourse> findAllByCourseId(int id);

    List<StudentCourse> findAllByStudentId(int id);
}
