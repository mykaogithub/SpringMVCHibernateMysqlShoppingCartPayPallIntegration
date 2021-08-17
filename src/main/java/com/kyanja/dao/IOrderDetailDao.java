package com.kyanja.dao;

import java.util.List;

import com.kyanja.model.OrderDetail;


public interface IOrderDetailDao {
	
	Long createOrderDetailsByOrder(OrderDetail o, Long idOrder);
	
	Long addOrderDetails(OrderDetail o);
	
	List<OrderDetail> findAllOrderDetails();
	
	void updateOrderDetail(OrderDetail o);

	void deleteOrderDetail (Long id);

	OrderDetail findOrderDetailById(long id);

}
