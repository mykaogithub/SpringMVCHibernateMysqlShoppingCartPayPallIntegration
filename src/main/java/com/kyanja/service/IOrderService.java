package com.kyanja.service;

import java.util.List;

import com.kyanja.model.Customer;
import com.kyanja.model.Order;
import com.kyanja.model.OrderDetail;

public interface IOrderService {
	
	List<Order> findAllOrders();

	String addOrder(Order o);

	void updateOrder(Order o);

	void deleteOrder (String orderNumber);

	Order findOrderById(String orderNumber);
	
	String createOrderByCustomer(Order o, Long idCustomer);
	
	Customer findCustomerByOrderId(String orderNumber);
	
	OrderDetail findOrderDetailByOrderId(String orderNumber);

}
