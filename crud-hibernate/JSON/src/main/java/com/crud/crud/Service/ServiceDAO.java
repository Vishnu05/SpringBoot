package com.crud.crud.Service;

import com.crud.crud.Entity.Employee;

import java.util.List;

public interface ServiceDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void createEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee searchByEmail(String email);
}
