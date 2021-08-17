package com.kyanja.dao;

import java.util.List;

import com.kyanja.model.Customer;



public interface ICustomerDao {
	
	List<Customer> findAllCustomers();

	Long addCustomer(Customer c);

	void updateCustomer(Customer c);

	void deleteCustomer (Long id);

	Customer findCustomerById(Long id);

}
