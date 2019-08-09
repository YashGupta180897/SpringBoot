package com.springboot.App.service;

import com.springboot.App.domain.StudentCourse;
import com.springboot.App.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * Created by yash.gupta on 8/1/2019.
 */
@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseRepository.findAll();
    }

    public Optional<StudentCourse> getStudentCourse(int id) {
        return studentCourseRepository.findById(id);
    }

    public List<StudentCourse> getByCourseId(int id) {

        return studentCourseRepository.findAllByCourseId(id);
    }

    public StudentCourse getMaxMarksByCourseId(int id)
    {
        List<StudentCourse> l1=studentCourseRepository.findAllByCourseId(id);
        float maxMarks=0;
        int index=0;
        for(int i=0;i<l1.size();i++)
        {
            if(maxMarks<l1.get(i).getMarks())
            {
                maxMarks=l1.get(i).getMarks();
                index=i;
            }
        }
        return l1.get(index);
    }


    public List<StudentCourse> getByStudentId(int id) {
        return studentCourseRepository.findAllByStudentId(id);
    }


    public StringBuilder getAvgMarksByCourseId(int id) {
        float avg=0;
        List<StudentCourse> l1=studentCourseRepository.findAllByCourseId(id);
        for(int i=0;i<l1.size();i++)
        {
            avg+=l1.get(i).getMarks();
        }
        avg/=l1.size();
        StringBuilder sb=new StringBuilder();
        sb.append(avg);
        sb.append("\t");
        sb.append(l1.get(0).getCourse().getName());
        return sb;
    }


    public StudentCourse getMaxMatksByStudentId(int id) {
        List<StudentCourse> l1=studentCourseRepository.findAllByStudentId(id);
        float maxMarks=0;
        int index=0;
        for(int i=0;i<l1.size();i++)
        {
            if(maxMarks<l1.get(i).getMarks())
            {
                maxMarks=l1.get(i).getMarks();
                index=i;
            }
        }
        return l1.get(index);
    }

    public StudentCourse getLatestMarksByStudentId(int id) {
        List<StudentCourse> l1=studentCourseRepository.findAllByStudentId(id);
        Timestamp latest=new Timestamp(1000-01-01);
        int index=0;
        for(int i=0;i<l1.size();i++)
        {
            if(latest.after(l1.get(i).getDateTime()))
            {
                latest=l1.get(i).getDateTime();
                index=i;
            }
        }
        return l1.get(index);
    }
}
