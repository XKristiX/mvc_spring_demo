package com.example.mvc_spring_demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//this is designating this class as a blueprint for the employee table

@Entity
public class Employee {
    
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

//need to have a default constructor around so that jpa can do its thing
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }

}
