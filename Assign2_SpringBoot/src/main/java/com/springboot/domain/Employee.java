package com.springboot.domain;

//import org.springframework.lang.NotNull;

//import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

/**
 * Created by yash.gupta on 7/29/2019.
 */
public class Employee {


    private String firstName;
    //@NonNull
    private String lastName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String project;
    //@NotEmpty(message = "ID is mandatory")
    private int empId;

    public Employee()
    {

    }

    public Employee( int empId,String firstName, String lastName, LocalDate startDate, LocalDate endDate, String project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.project = project;
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
