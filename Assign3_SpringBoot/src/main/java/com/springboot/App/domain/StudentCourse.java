package com.springboot.App.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by yash.gupta on 7/31/2019.
 */
@Entity

public class StudentCourse {


    @Id
    private int Id;
    private Timestamp dateTime;
    private float marks;

    @NotNull
    @JoinColumn(name = "student_id",referencedColumnName = "student_id",insertable = false,updatable = false)
    @ManyToOne
    private Student student;

    @NotNull
    @JoinColumn(name = "course_id",referencedColumnName = "course_id",insertable = false,updatable = false)
    @ManyToOne
    private Course course;



    public StudentCourse()
    {

    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public StudentCourse(int id, Timestamp dateTime, float marks, Student student, Course course) {
        Id = id;
        this.dateTime = dateTime;
        this.marks = marks;
        this.student = student;
        this.course = course;
    }
}
