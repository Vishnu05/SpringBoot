package com.swagger.docs.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    private ConcurrentMap<String, String> obj = new ConcurrentHashMap<>();

    @GetMapping("employee/{username}")
    public Object getEmployee(@PathVariable String username) {


        return obj.get(username);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return new ArrayList(obj.values());
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {

        obj.put(employee.getUsername(), String.valueOf(employee));
        return employee;
    }
}
