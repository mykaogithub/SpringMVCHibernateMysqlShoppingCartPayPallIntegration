package com.kyanja.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyanja.dao.IOrderDetailDao;
import com.kyanja.model.Customer;
import com.kyanja.model.Order;
import com.kyanja.model.OrderDetail;

@Repository
public class OrderDetailDaoImpl implements IOrderDetailDao {

	@Autowired
	private SessionFactory sf;
	private String queryString;

	@Override
	public Long createOrderDetailsByOrder(OrderDetail orderDetail, Long idOrder) {

		Order order = (Order) sf.getCurrentSession().load(Order.class, idOrder);

		orderDetail.setOrder(order);

		sf.getCurrentSession().saveOrUpdate(orderDetail);

		return orderDetail.getId();
	}

	@Override
	public Long addOrderDetails(OrderDetail o) {

		sf.getCurrentSession().saveOrUpdate(o);

		return o.getId();
	}

	@Override
	public List<OrderDetail> findAllOrderDetails() {

		String queryString = "from OrderDetail";
		List<OrderDetail> orderDetailsList = sf.getCurrentSession().createQuery(queryString).list();
		return orderDetailsList;

	}

	@Override
	public void updateOrderDetail(OrderDetail o) {
		
		 sf.getCurrentSession().update(o);

	}

	@Override
	public void deleteOrderDetail(Long id) {


		OrderDetail o = (OrderDetail) sf.getCurrentSession().load(OrderDetail.class, id);
		
		if(o !=null) {
			
			sf.getCurrentSession().delete(o);
		}

	}

	@Override
	public OrderDetail findOrderDetailById(long id) {

		OrderDetail orderDetail = null;
		
		Session session = sf.getCurrentSession();
		
		try {
			
			orderDetail = (OrderDetail) session
					.createQuery("select o from OrderDetail o WHERE o.id =:id")
					.setParameter("id", id).getSingleResult();
			
		} catch (Exception e) {
			
			System.err.println(e);
		}
		return orderDetail;
	}

}
