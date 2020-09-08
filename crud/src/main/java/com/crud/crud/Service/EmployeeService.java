package com.crud.crud.Service;

import com.crud.crud.DAO.EmployeeDAO;
import com.crud.crud.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeService implements EmployeeDAO {

    // autowiring the dao
    EmployeeDAO employeeDAO;

    // constructor injection
    @Autowired
    private EmployeeService(EmployeeDAO employeeDAO) {

        /**
         * when we have same name as object and parameter name also same, it is mandatory to use
         * this, so object will be assigned
         */
        this.employeeDAO = employeeDAO;
    }

    // Transactional will create and commit for each and every transaction
    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
