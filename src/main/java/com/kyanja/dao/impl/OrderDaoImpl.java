package com.kyanja.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.FetchMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.dao.IOrderDao;
import com.kyanja.model.Cart;
import com.kyanja.model.Customer;
import com.kyanja.model.Items;
import com.kyanja.model.Order;
import com.kyanja.model.OrderDetail;

@Repository
public class OrderDaoImpl implements IOrderDao {

	/* Get the class name to be printed on */
	private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Order> findAllOrders() {

		return sf.getCurrentSession().createQuery("from Order ").list();
	}

	@Override
	public String addOrder(Order o) {

		sf.getCurrentSession().saveOrUpdate(o);

		return o.getOrderNumber();
	}

	@Override
	public void updateOrder(Order o) {

		sf.getCurrentSession().update(o);
	}

	@Override
	public void deleteOrder(String orderNumber) {

		Order o = (Order) sf.getCurrentSession().load(Order.class, orderNumber);

		if (o != null) {

			sf.getCurrentSession().delete(o);
		}
	}

	public Order findOrderById(String orderNumber) {

		System.out.println("findOrderById in dao layer called==================================");
		System.out.println("orderNumber in dao layer called==================================" + orderNumber);

		Session session = sf.getCurrentSession();

		Order order = null;

		try {

			order = (Order) session
					.createQuery("select o from Order o JOIN FETCH o.customer c WHERE o.orderNumber =:orderNumber")
					.setParameter("orderNumber", orderNumber).getSingleResult();

			System.out.println("customer firstname order==========================================="
					+ order.getCustomer().getFirstName());

		} catch (Exception e) {
			e.printStackTrace();

		}

		return order;

	}

	@Override
	public String createOrderByCustomer(Order o, Long idCustomer) {

		Customer customer = (Customer) sf.getCurrentSession().load(Customer.class, idCustomer);

		if (customer != null) {

			o.setCustomer(customer);
		}

		sf.getCurrentSession().saveOrUpdate(o);

		return o.getOrderNumber();
	}

	@Override
	public Order saveRegisterOrder(Cart cart, Customer customer) {

		sf.getCurrentSession().saveOrUpdate(customer);

		Order order = new Order();
		order.setPurchaseDate(new Date());
		order.setCart((Cart) cart.getItems());

		for (Items item : cart.getItems()) {

			sf.getCurrentSession().saveOrUpdate(item);

		}

		sf.getCurrentSession().saveOrUpdate(order);
		return order;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
	public Customer findCustomerByOrderId(String orderNumber) {

		System.out.println("findCustomerByOrderId in dao layer called==================================");
		System.out.println("orderNumber in dao layer called==================================" + orderNumber);

		Order order = null;

		Customer customer = null;

		Session session = sf.getCurrentSession();

		try {

			order = (Order) session
					.createQuery("select o from Order o JOIN FETCH o.customer c WHERE o.orderNumber =:orderNumber")
					.setParameter("orderNumber", orderNumber).getSingleResult();

			customer = order.getCustomer();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return customer;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
	public OrderDetail findOrderDetailByOrderId(String orderNumber) {
		System.out.println("findOrderDetailByOrderId in dao layer called==================================");
		System.out.println("orderNumber in dao layer called==================================" + orderNumber);
		Order order = null;

		Customer customer = null;

		List<OrderDetail> orderDetails = null;

		Session session = sf.getCurrentSession();

		try {

			order = (Order) session.createQuery(
					"select o from Order o JOIN FETCH o.orderDetail orderDetails WHERE o.orderNumber =:orderNumber")
					.setParameter("orderNumber", orderNumber).getSingleResult();

			orderDetails = order.getOrderDetails();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
