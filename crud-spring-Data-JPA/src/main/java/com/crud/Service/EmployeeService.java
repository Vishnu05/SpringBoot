package com.crud.Service;

import com.crud.DAO.EmployeeRepository;
import com.crud.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@ComponentScan

@Service
public class EmployeeService implements ServiceDAO {

    // autowiring the dao
    private EmployeeRepository employeeRepository;

    // constructor injection

    /**
     * got error while setting to private, BeanCreationError, after changing it worked
     */
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Transactional will create and commit for each and every transaction
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        // java 8 feature
        Optional<Employee> byId = employeeRepository.findById(id);

        Employee employee = null;

        // checking if the id is present or not
        if (byId.isPresent()) {
            employee = byId.get();
        } else {
            throw new RuntimeException("I didn't find any id like that in our db ");
        }

        // returning the id, object
        return employee;
    }

    /*public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }*/

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);

    }


    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
