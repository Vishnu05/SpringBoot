package com.crud.crud.RestController;


import com.crud.crud.Entity.Employee;
import com.crud.crud.Service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

@CrossOrigin(maxAge = 3600)
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

    @GetMapping("/react")
    public String state(){
        return "This is for React State";
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

        // throw exception if the user doesn't exits in database
        if (tempEmployee == null) {
//            throw new RuntimeException("Employee id not found - " + employeeId);
            return "Employee not found in our database : " + employeeId;
        }


        serviceDAO.deleteEmployee(employeeId);

        return "Deleted employee id - " + employeeId;
    }

    @GetMapping("/employee/email")
    public Employee searchByEmail(@PathVariable String email) throws Exception {
        Employee employee = serviceDAO.searchByEmail(email);
        System.out.println("email searching " + employee);

        if (employee == null) {
            throw new Exception("email id doesn't exists in our db ");
        } else {
            return employee;
        }
    }

    @GetMapping(value = "/file/upload/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String files(@RequestParam("file") MultipartFile file) throws Exception {

//        BufferedReader bufferedReader = new BufferedReader();
        BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Vishnu Thamizharasan\\Desktop\\ex.txt"));
        String line = bf.readLine();
        System.out.println("With buffered " + line);
        return "";
    }
}