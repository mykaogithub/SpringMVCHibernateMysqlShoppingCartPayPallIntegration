package com.kyanja.dao;

import java.util.List;

import com.kyanja.model.Cart;
import com.kyanja.model.Customer;
import com.kyanja.model.Order;
import com.kyanja.model.OrderDetail;

public interface IOrderDao {
	
	List<Order> findAllOrders();

	String addOrder(Order o);

	void updateOrder(Order o);

	void deleteOrder (String orderNumber);

	Order findOrderById(String orderNumber);
	
	String createOrderByCustomer(Order o, Long idCustomer);
	
	public Order saveRegisterOrder(Cart cart, Customer customer);
	
	Customer findCustomerByOrderId(String orderNumber);
	
	OrderDetail findOrderDetailByOrderId(String orderNumber);

}
