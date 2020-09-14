package com.crud.DAO;

import com.crud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// spring data jpa, <Entity class, Primary id type>
//@RepositoryRestResource(path = "/members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
