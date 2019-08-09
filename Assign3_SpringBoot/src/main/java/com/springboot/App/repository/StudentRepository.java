package com.springboot.App.repository;

import com.springboot.App.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yash.gupta on 7/31/2019.
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {


    List<Student> findAllByNameContaining(String name);


}
