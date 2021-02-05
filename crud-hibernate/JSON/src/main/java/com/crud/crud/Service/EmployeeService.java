package com.crud.crud.Service;

import com.crud.crud.DAO.EmployeeDAO;
import com.crud.crud.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@ComponentScan

@Service
public class EmployeeService implements ServiceDAO {

    // autowiring the dao
    private EmployeeDAO employeeDAO;

    // constructor injection
    /**
     * got error while setting to private, BeanCreationError, after changing it
     * worked
     */
    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
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
        employeeDAO.deleteEmployeeById(id);
    }

    @Override
    public Employee searchByEmail(String email) {
        return employeeDAO.searchByEmail(email);
    }
}
