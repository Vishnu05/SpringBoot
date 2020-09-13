package com.crud.DAO;

import com.crud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// spring data jpa, <Entity class, Primary id type>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
