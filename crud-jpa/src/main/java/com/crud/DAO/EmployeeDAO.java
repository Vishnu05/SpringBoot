package com.crud.DAO;

import com.crud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
    Employee findById(int id);
    void createEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
