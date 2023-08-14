package com.example.mvc_spring_demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.mvc_spring_demo.models.Address;


public interface AddressRepository extends CrudRepository<Address, Long>{

List<Address> findById(String id);

}
