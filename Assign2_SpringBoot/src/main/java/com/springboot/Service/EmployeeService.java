package com.springboot.Service;

import com.springboot.domain.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by yash.gupta on 7/29/2019.
 */
@Service
public class EmployeeService {

    private List<Employee> employees=new ArrayList<Employee>(Arrays.asList
            (new Employee(175,"Yash","Gupta",LocalDate.of(2018,11,07),LocalDate.of(2018,04,07),"Spring boot"),
            new Employee(171,"Pratik","Kamble",LocalDate.of(2019,04,06),LocalDate.of(2019,07,06),"Python"),
            new Employee(176,"Roshan","Patil",LocalDate.of(2018,03,30),LocalDate.of(2018,07,12),"Shell Scripting"),
            new Employee(172,"Rishabh","Sakhare",LocalDate.of(2018,02,11),LocalDate.of(2018,04,04),"Selenium Testing"),
            new Employee(173,"Shreyas","Ghuge",LocalDate.of(2018,01,11),LocalDate.of(2018,07,04),"Android Development"),
                    new Employee(174,"Yash","Rangarajan",LocalDate.of(2019,01,11),LocalDate.of(2019,07,04),"Android Development")));

    public List<Employee> getAllEmployees()
    {
        return employees;
    }

    public Employee getEmployee(String first)
    {
        return employees.stream().filter(e -> e.getFirstName().equals(first)).findFirst().get();
    }

    public Employee getEmployee(String first,String project)
    {
        return employees.stream().filter(e -> e.getFirstName().equals(first) && e.getProject().equals(project)).findFirst().get();
    }

    public Employee getEmployee(int empId)
    {
        return employees.stream().filter(e-> e.getEmpId()==empId).findFirst().get();
    }

    public void addEmployee(Employee emp)
    {
        employees.add(emp);
    }

    public void deleteEmployee(int id)
    {
        employees.removeIf(e -> e.getEmpId()==id);
    }

}
