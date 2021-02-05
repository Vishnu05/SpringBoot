package com.crud.crud.Entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;

@Entity
@Table(name = "employee")
//@JacksonXmlRootElement(localName = "Employee")
public class Employee {

    @Id
   // @JacksonXmlProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @JacksonXmlProperty
    @Column(name = "first_name")
    private String firstName;

//    @JacksonXmlProperty
    @Column(name = "last_name")
    private String lastName;

  //  @JacksonXmlProperty
    @Column(unique = true, name = "email")
    private String email;

    // no arg, hibernate constructor
    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
