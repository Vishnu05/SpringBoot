package com.crud.DAO;

import com.crud.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeJPAImplements implements EmployeeDAO {

    private EntityManager entityManager;

    // constructor DI injection
    @Autowired
    public EmployeeJPAImplements(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // jpa query to get all the details
        Query query = entityManager.createQuery("from Employee");

        List<Employee> employee = query.getResultList();

        return employee;
    }

    @Override
    public Employee findById(int id) {

        // get the employee
        Employee employee = entityManager.find(Employee.class, id);

        // return employee
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {

        // if the id = 0, save else update the current record
        Employee employee1 = entityManager.merge(employee);

        // no idea why we are setting up
        employee1.setId(employee1.getId());

    }

    @Override
    public void deleteEmployeeById(int id) {

        // hibernate query to delete a particular id
        Query query = entityManager.createQuery("delete  from Employee where id = :employeeId");

        // setting the id, (position, value)
        query.setParameter("employeeId", id);

        //executing the update
        query.executeUpdate();

    }
}
