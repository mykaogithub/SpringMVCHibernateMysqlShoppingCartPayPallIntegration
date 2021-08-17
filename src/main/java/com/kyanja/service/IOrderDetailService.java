package com.kyanja.service;

import java.util.List;

import com.kyanja.model.OrderDetail;

public interface IOrderDetailService {

	Long createOrderDetailsByOrder(OrderDetail o, Long idOrder);

	Long addOrderDetails(OrderDetail o);

	List<OrderDetail> findAllOrderDetails();

	void updateOrderDetail(OrderDetail o);

	void deleteOrderDetail(Long id);

	public OrderDetail findOrderDetailById(long id);

}
