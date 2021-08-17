package com.kyanja.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "order_invoice")
public class Invoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "invoice-generator")
	@GenericGenerator(name = "invoice-generator", parameters = @Parameter(name = "prefix", value = "INV000000"), strategy = "com.kyanja.utils.dao.MyCustomInvoiceGenerator")
	@Column(name = "invoice_id")
	private String invoiceNumber;

   

	@Column(name = "AMOUNT_DUE", precision = 2)
	private double amountDue;

	@Column(name = "DATE_RAISED")
	private Date orderRaisedDt;

	@Column(name = "DATE_SETTLED")
	private Date orderSettledDt;

	@Column(name = "DATE_CANCELLED")
	private Date orderCancelledDt;

	@Version
	@Column(name = "LAST_UPDATED_TIME")
	private Date updatedTime;
	@OneToOne(optional = false)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "invoice")
	private List<OrderDetail> orderDetails;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Invoice() {
		super();
	}



	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public Date getOrderRaisedDt() {
		return orderRaisedDt;
	}

	public void setOrderRaisedDt(Date orderRaisedDt) {
		this.orderRaisedDt = orderRaisedDt;
	}

	public Date getOrderSettledDt() {
		return orderSettledDt;
	}

	public void setOrderSettledDt(Date orderSettledDt) {
		this.orderSettledDt = orderSettledDt;
	}

	public Date getOrderCancelledDt() {
		return orderCancelledDt;
	}

	public void setOrderCancelledDt(Date orderCancelledDt) {
		this.orderCancelledDt = orderCancelledDt;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Invoice(String invoiceNumber, double amountDue, Date orderRaisedDt, Date orderSettledDt,
			Date orderCancelledDt, Date updatedTime, Order order, Customer customer, List<OrderDetail> orderDetails) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.amountDue = amountDue;
		this.orderRaisedDt = orderRaisedDt;
		this.orderSettledDt = orderSettledDt;
		this.orderCancelledDt = orderCancelledDt;
		this.updatedTime = updatedTime;
		this.order = order;
		this.customer = customer;
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceNumber=" + invoiceNumber + ", amountDue=" + amountDue + ", orderRaisedDt="
				+ orderRaisedDt + ", orderSettledDt=" + orderSettledDt + ", orderCancelledDt=" + orderCancelledDt
				+ ", updatedTime=" + updatedTime + ", order=" + order + ", customer=" + customer + ", orderDetails="
				+ orderDetails + "]";
	}
	
	
	




	
    


}
