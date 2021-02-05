package com.crud.crud.DAO;

import com.crud.crud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
    Employee findById(int id);
    void createEmployee(Employee employee);
    void deleteEmployeeById(int id);
    Employee searchByEmail(String email);
}
