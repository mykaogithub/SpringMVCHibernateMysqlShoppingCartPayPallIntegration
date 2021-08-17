package com.kyanja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.dao.IOrderDetailDao;
import com.kyanja.model.OrderDetail;
import com.kyanja.service.IOrderDetailService;

@Service
@Transactional
public class OrderDetailServiceImpl implements IOrderDetailService{
	
	@Autowired
	IOrderDetailDao dao;

	public Long createOrderDetailsByOrder(OrderDetail o, Long idOrder) {
		
		return dao.createOrderDetailsByOrder(o, idOrder);
	}

	@Override
	public Long addOrderDetails(OrderDetail o) {
		
		return dao.addOrderDetails(o);
	}

	@Override
	public List<OrderDetail> findAllOrderDetails() {
		
		return dao.findAllOrderDetails();
	}

	@Override
	public void updateOrderDetail(OrderDetail o) {
	
		
		dao.updateOrderDetail(o);
		
	}

	@Override
	public void deleteOrderDetail(Long id) {

		dao.deleteOrderDetail(id);
		
	}

	@Override
	public OrderDetail findOrderDetailById(long id) {
		// TODO Auto-generated method stub
		return dao.findOrderDetailById(id);
	}

	

}
