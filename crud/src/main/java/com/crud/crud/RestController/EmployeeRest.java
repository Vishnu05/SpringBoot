package com.crud.crud.RestController;


import com.crud.crud.Entity.Employee;
import com.crud.crud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRest {

    // dao
    private EmployeeService employeeService;

    //constructor injection
    @Autowired
    private EmployeeRest(EmployeeService employeeService1) {
        this.employeeService = employeeService1;
    }

    // getting all the employee details
    @GetMapping("/employee")
    public List<Employee> findall() {
        return employeeService.findAll();
    }

    @GetMapping("${id}")
    public String getEmployeeId(){
        return "";
    }

}
