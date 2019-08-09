package com.springboot.App.domain;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yash.gupta on 7/31/2019.
 */

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_id")
    private int id;
    @Column(name = "name")
    private String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Course()
    {

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
