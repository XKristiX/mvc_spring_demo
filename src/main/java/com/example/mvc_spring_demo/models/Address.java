package com.example.mvc_spring_demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String streetNumberAndName;

    @Column
    private String city;

    @Column
    private String state;

    public Address(){
    }

    public Address(String streetNumberAndName, String city, String state) {
        this.streetNumberAndName = streetNumberAndName;
        this.city = city;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetNumberAndName() {
        return streetNumberAndName;
    }

    public void setStreetNumberAndName(String streetNumberAndName) {
        this.streetNumberAndName = streetNumberAndName;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

public void setAddress(String streetNumberAndName, String city, String state) {
    this.streetNumberAndName = streetNumberAndName;
    this.city = city;
    this.state = state;
}

@Override
    public String toString() {
        return "Address [id=" + id + ", streetNumberAndName=" + streetNumberAndName + ", city=" + city + ", state=" + state + "]";
    }
}
