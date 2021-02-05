package com.crud.crud.DAO;

import com.crud.crud.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Transactional
public class EmployeeImplements implements EmployeeDAO {


    private EntityManager entityManager;

//     creating a session, for whole class, which one will be better each method or the whole class
//    private  Session createSession = entityManager.unwrap(Session.class);

    // autowired is not necessary one, in later spring
    @Autowired
    public EmployeeImplements(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // creating session
        Session createSession = entityManager.unwrap(Session.class);
        System.out.println("Current session of the hibernate " + createSession);

        // querying the data
        Query<Employee> theQuery = createSession.createSQLQuery("select * from Employee");


        // getting all the list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {

        Session createSession = entityManager.unwrap(Session.class);

        // get the employee by id
        Employee employee = createSession.get(Employee.class, id);

        // using sql query, it throws error need to check
//        Query query = createSession.createSQLQuery("select * from employee where id =:id");
//        System.out.println("Sql query will return this " + query);
//        query.setParameter("id", id);

        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {

        // getting current hibernate session
        Session createSession = entityManager.unwrap(Session.class);

        // if the employee id = 0 save/ or else it will update
        createSession.saveOrUpdate(employee);

    }

    @Override
    public void deleteEmployeeById(int id) {

      /*  // getting current hibernate session
        Session createSession = entityManager.unwrap(Session.class);

        // native hibernate query to delete a particular record
        Query query = createSession.createQuery("delete from Employee where id=:employeeId ");
       // Query query = createSession.createSQLQuery("delete from employee where id =: id ");

         query.setParameter("employeeId", id);

        query.executeUpdate();
*/
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id);

        theQuery.executeUpdate();


    }

    @Override
    public Employee searchByEmail(String email) {

        // getting the session
        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("from Employee where email = email");
//
//        System.out.println("Query results" + query);
        Employee employee = session.get(Employee.class, email);

        return employee;
    }
}
