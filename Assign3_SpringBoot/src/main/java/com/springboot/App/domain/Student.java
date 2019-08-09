package com.springboot.App.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 * Created by yash.gupta on 7/31/2019.
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private int id;
    @NotNull(message = "Name cannot be null")
    @Column(name = "name")
    private String name;

    public Student()
    {

    }
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
