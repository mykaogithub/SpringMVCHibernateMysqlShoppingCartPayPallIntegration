package com.kyanja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.dao.IOrderDao;
import com.kyanja.model.Customer;
import com.kyanja.model.Order;
import com.kyanja.model.OrderDetail;
import com.kyanja.service.IOrderService;


@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	IOrderDao dao;

	@Transactional
	public List<Order> findAllOrders() {
		
		return dao.findAllOrders();
	}

	@Transactional
	public String addOrder(Order o) {
	
		return dao.addOrder(o);
	}

	@Transactional
	public void updateOrder(Order o) {
		 dao.updateOrder(o);
		
	}


	@Transactional
	public void deleteOrder(String orderNumber) {
		
		dao.deleteOrder(orderNumber);
		
	}



	@Transactional
	public Order findOrderById(String orderNumber) {
		
		System.out.println("findOrderById called===================================");
		
		System.out.println("id sent ==================================="+orderNumber);
		
		return dao.findOrderById(orderNumber);
	}


	 @Transactional
	public String createOrderByCustomer(Order o, Long idCustomer) {
		
		return dao.createOrderByCustomer(o, idCustomer);
	}

	@Override
	public Customer findCustomerByOrderId(String orderNumber) {
	
		return dao.findCustomerByOrderId(orderNumber);
	}

	@Override
	public OrderDetail findOrderDetailByOrderId(String orderNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
