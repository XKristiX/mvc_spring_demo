package com.example.mvc_spring_demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.mvc_spring_demo.models.Address;
import com.example.mvc_spring_demo.models.Employee;
import com.example.mvc_spring_demo.repositories.AddressRepository;
import com.example.mvc_spring_demo.repositories.EmployeeRepository;

@SpringBootApplication
public class MvcSpringDemoApplication {
	//autowired dependency allows us to utilize this dependency using spring dependency
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(MvcSpringDemoApplication.class, args);
	}

	@Bean
	public String running(){
		//created the entity to save the table ... row in table
		Employee employee = new Employee("Kristi");
		Employee employee2 = new Employee("Mayhem");
		Employee employee3 = new Employee("Magic");
		
		System.out.println("Here is the count before saving " + employeeRepository.count());
		//= to insert into employee ([columns]) values([values])
		employeeRepository.save(employee);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		//select * from employee where name = 'Milo';
		List<Employee> result = employeeRepository.findByName("Milo");
		
		System.out.println("Here is the count after saving " + employeeRepository.count());
		//factory repository method to delete records by id
		employeeRepository.deleteById(1L);

		//= select * from employee
		System.out.println("Actual contents of table " + employeeRepository.findAll());

		//update existing row
		//grab entity by id
		//update entity
		//save entity

		Optional<Employee> foundByID = employeeRepository.findById(2L);
	if (foundByID.isPresent()) {
		Employee emp = foundByID.get();
		emp.setName("Hammies");
		employeeRepository.save(emp);
	}

Address address = new Address("444 Main St", "Miami", "FL");

	// addressRepository.save(address);

	// List<Address> resultAddress = 
	addressRepository.save(address);


	// Optional<Address> foundByID = addressRepository.findById(1L);
	// if (foundByID.isPresent()) {
	// 	Address addr = foundByID.get();
	// 	addr.setAddress("Hammies House", null, null);
	// 	addressRepository.save(addr);
	// }

		return "running";
	}
	


}
	

