package com.kyanja.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyanja.dao.ICustomerDao;
import com.kyanja.model.Customer;
import com.kyanja.model.Product;

@Repository
public class CustomerDaoImpl implements ICustomerDao{
	
	
	
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllCustomers() {

		Session session = sf.getCurrentSession();

	
		try {

		
			
			@SuppressWarnings("unchecked")
			List<Customer> customers = session.createQuery("from Customer").list();
			
			
			
			

		
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return session.createQuery("from Customer").list();

		
	}

	@Override
	public Long addCustomer(Customer c) {
		
		sf.getCurrentSession().saveOrUpdate(c);
		 
		 return c.getId();
	}

	@Override
	public void updateCustomer(Customer c) {
		
		sf.getCurrentSession().update(c);
		
	}

	@Override
	public void deleteCustomer(Long id) {
	
		Product product = (Product) sf.getCurrentSession().load(Product.class, id);

		if (product != null) {

			sf.getCurrentSession().delete(product);
		}
		
	}

	@Override
	public Customer findCustomerById(Long id) {
		

		Customer customer = (Customer) sf.getCurrentSession().get(Customer.class, id);
		
		return customer;
	}

}
