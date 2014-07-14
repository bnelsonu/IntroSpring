package com.packt.webstore.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	
	private List <Customer> listOfCustomers = new ArrayList <Customer> ();

	public InMemoryCustomerRepository() {
	
		Customer customer1 = new Customer("C1","Brian Nelson");
		customer1.setAddress("Tres Ríos, Cartago, Costa Rica");
		customer1.setNoOfOrdersMade(3);
		
		Customer customer2 = new Customer("C2","Ricardo Nelson");
		customer2.setAddress("Turrialba, Cartago , Costa Rica");
		customer2.setNoOfOrdersMade(3);
		
		listOfCustomers.add(customer1);
		listOfCustomers.add(customer2);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return listOfCustomers;
	}
}