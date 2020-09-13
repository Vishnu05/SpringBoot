package com.crud.crud.RestController;


import com.crud.crud.Entity.Employee;
import com.crud.crud.Service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRest {

    private ServiceDAO serviceDAO;

    @Autowired
    private EmployeeRest(ServiceDAO employeeDAO) {
        this.serviceDAO = employeeDAO;
    }

    // getting all the employee details
    @GetMapping("/employee")
    public List<Employee> findall() {
        return serviceDAO.findAll();
    }

    // getting employee by employeeId
    @GetMapping("/employee/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = serviceDAO.findById(employeeId);

        System.out.println("The employee employeeId is : " + employee + " : " + employeeId);

        // if the employee not found throwing the error. employee not found
        if (employee == null) {
            throw new NullPointerException("Employee not found !!!" + employeeId);
            //return employee;
        } else {
            return employee;
        }
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {

        // forcing the employeeId to set 0, or else it is updating the existing record, this is good way
        employee.setId(0);

        serviceDAO.createEmployee(employee);

        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployeeByID(@RequestBody Employee employee) {

        serviceDAO.createEmployee(employee);

        return employee;
    }

//    @DeleteMapping("employee/${employeeId}")
//    public String deleteEmployeeByID(@PathVariable int employeeId) {
//
//        Employee employee = serviceDAO.findById(employeeId);
//
//        if (employee == null) {
//            throw new RuntimeException("Employee doesn't exist in our database " + employeeId );
//        }
//        serviceDAO.deleteEmployee(employeeId);
//
//        return "Employee has been deleted " + employee;
//    }

    // i don't know what is wrong with this annotation, it gives method method not supported
    //@DeleteMapping("/employees/{employeeId}")
    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = serviceDAO.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        serviceDAO.deleteEmployee(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}