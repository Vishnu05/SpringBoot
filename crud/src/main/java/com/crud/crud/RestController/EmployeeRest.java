package com.crud.crud.RestController;


import com.crud.crud.DAO.EmployeeDAO;
import com.crud.crud.Entity.Employee;
//import com.crud.crud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRest {


    private EmployeeDAO employeeDAO;



    @Autowired
    private EmployeeRest(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // getting all the employee details
    @GetMapping("/employee")
    public List<Employee> findall() {
        return employeeDAO.findAll();
    }


}
