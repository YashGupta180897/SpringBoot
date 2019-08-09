package com.springboot.controller;

import com.springboot.Service.EmployeeService;
import com.springboot.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by yash.gupta on 7/29/2019.
 */
@RestController
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
        public List<Employee> getAllEmployees()
        {
            return employeeService.getAllEmployees();

        }

    @GetMapping("/employees/search")
    public ResponseEntity<Employee> getEmployee(@RequestParam(value="firstName") String firstName,
                                @RequestParam(value="project",required = false) String project)
    {
        if(firstName.equals("111"))
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else if(firstName.equals("222"))
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else if(firstName.equals("333"))
        {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        else if(firstName.matches(".*\\d.*"))
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else if(project==null )
        {
            return new ResponseEntity<>(employeeService.getEmployee(firstName), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(employeeService.getEmployee(firstName,project), HttpStatus.OK);
        }
    }

    @RequestMapping(value="/employees/{id}",method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable int id)
    {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST,value="/employees/post")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        int flag = 0;
        if (employee.getEmpId() == 0 || employee.getEndDate() == null || employee.getFirstName() == null)
            flag = 1;
        if (flag == 0) {
            employeeService.addEmployee(employee);
            return new ResponseEntity<>("Employee details added",HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>("Oops, Field is missing",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value="/employees/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
        return "Employee removed";
    }

    @DeleteMapping(value="/employess/delete")
    public ResponseEntity<String> deleteEmployeeById(@RequestParam(required = true) int empid) {
        if (empid == 111)
            return new ResponseEntity<String>("Empid does not exist", HttpStatus.BAD_REQUEST);
        else if(empid == 222)
            return new ResponseEntity<String>("Empid does not exist",HttpStatus.INTERNAL_SERVER_ERROR);

        else {
            employeeService.deleteEmployee(empid);
            return new ResponseEntity<>("Employee removed", HttpStatus.OK);
        }
    }


}
