package com.kyanja.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer_orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(generator = "order-generator")
	@GenericGenerator(name = "order-generator", parameters = @Parameter(name = "prefix", value = "ORD000000"), strategy = "com.kyanja.utils.dao.MyCustomOrderGenerator")
	@Column(name = "order_id")
	private String orderNumber;
	

	
	private Cart cart;

	private Date purchaseDate;



	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	private ShippingAddress shippingDetail;




	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;


     
     @Column(name = "TOTAL_PRICE", precision = 2)
     private double totPrice;
     
     @Column(name = "OREDER_DESC")
     private String orderDesc;
     
     @Column(name = "ORDER_DATE")  
     private Date orderDt;

     @OneToOne(optional=false,cascade=CascadeType.ALL, 
     mappedBy="order",targetEntity=Invoice.class)
     private Invoice invoice;  
     
     @Version
     @Column(name = "LAST_UPDATED_TIME")
     private Date updatedTime;

	
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShippingAddress getShippingDetail() {
		return shippingDetail;
	}

	public void setShippingDetail(ShippingAddress shippingDetail) {
		this.shippingDetail = shippingDetail;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	




	private double orderAmount;
	private OrderStatus orderStatus;

	// Copy Constructor
	public Order(Order order) {
		this(order.getOrderNumber(), order.getOrderAmount(), order.getOrderStatus());
	}

	public Order(String orderNumber, double orderAmount, OrderStatus orderStatus) {
		this.orderNumber = orderNumber;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
	}

	@Override
	public Order clone() {
		try {
			return (Order) super.clone();
		} catch (CloneNotSupportedException e) {
			return new Order(this.orderNumber, this.orderAmount, this.orderStatus);
		}
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order() {

	}







	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", cart=" + cart + ", purchaseDate=" + purchaseDate + ", customer="
				+ customer + ", shippingDetail=" + shippingDetail + ", orderDetails=" + orderDetails + ", invoice="
				+ invoice + ", orderAmount=" + orderAmount + ", orderStatus=" + orderStatus + "]";
	}

	public Order(String orderNumber, Cart cart, Date purchaseDate, Customer customer, ShippingAddress shippingDetail,
			List<OrderDetail> orderDetails, Invoice invoice, double orderAmount, OrderStatus orderStatus) {
		super();
		this.orderNumber = orderNumber;
		this.cart = cart;
		this.purchaseDate = purchaseDate;
		this.customer = customer;
		this.shippingDetail = shippingDetail;
		this.orderDetails = orderDetails;
		this.invoice = invoice;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
	}



	public double getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(double totPrice) {
		this.totPrice = totPrice;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Date getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(Date orderDt) {
		this.orderDt = orderDt;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}


 

	public Double getTotalPrice() {
        return getOrderDetails().stream().mapToDouble(OrderDetail::getSubtotalInDouble).sum();
    }

       
       
	    public Integer getTotalQuantity() {
	        return getOrderDetails().stream().mapToInt(OrderDetail::getQuantityOrdered).sum();
	    }
	
	 
	   

}
