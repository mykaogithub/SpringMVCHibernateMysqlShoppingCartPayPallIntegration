package com.kyanja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.dao.ICustomerDao;
import com.kyanja.model.Customer;
import com.kyanja.service.ICustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerDao dao;

	@Override
	public List<Customer> findAllCustomers() {
	
		return dao.findAllCustomers();
	}

	@Override
	public Long addCustomer(Customer c) {
		
		return dao.addCustomer(c);
	}

	@Override
	public void updateCustomer(Customer c) {
	
		dao.updateCustomer(c);
		
	}

	@Override
	public void deleteCustomer(Long id) {
		
		dao.deleteCustomer(id);
		
	}

	@Override
	public Customer findCustomerById(Long id) {
		
		return dao.findCustomerById(id);
	}

}
