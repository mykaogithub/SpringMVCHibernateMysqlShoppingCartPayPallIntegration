package com.kyanja.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderDetail_id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;

	private String productName;
	private float subtotal;
	private float shipping;
	private float tax;
	private float total;
	private int quantityOrdered;
	private float priceEach;
	

	private String orderLineNumber;

	public OrderDetail(String productName, String subtotal, String shipping, String tax, String total) {
		this.productName = productName;
		this.subtotal = Float.parseFloat(subtotal);
		this.shipping = Float.parseFloat(shipping);
		this.tax = Float.parseFloat(tax);
		this.total = Float.parseFloat(total);
	}

	public String getProductName() {
		return productName;
	}

	public String getSubtotal() {
		return String.format("%.3f", subtotal);
	}

	public String getShipping() {
		return String.format("%.3f", shipping);
	}

	public String getTax() {
		return String.format("%.3f", tax);
	}

	public String getTotal() {
		return String.format("%.3f", total);
	}

	public OrderDetail() {
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public void setShipping(float shipping) {
		this.shipping = shipping;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order + ", productName=" + productName + ", subtotal=" + subtotal
				+ ", shipping=" + shipping + ", tax=" + tax + ", total=" + total + ", quantityOrdered="
				+ quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public OrderDetail(Order order, String productName, float subtotal, float shipping, float tax, float total) {
		super();
		this.order = order;
		this.productName = productName;
		this.subtotal = subtotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
	}

	public OrderDetail(Order order, String productName, String subtotal, String shipping, String tax, String total) {
		this.order = order;
		this.productName = productName;
		this.subtotal = Float.parseFloat(subtotal);
		this.shipping = Float.parseFloat(shipping);
		this.tax = Float.parseFloat(tax);
		this.total = Float.parseFloat(total);
	}

	public String getPriceEach() {
		return String.format("%.3f", priceEach);
	}

	public void setPriceEach(float priceEach) {
		this.priceEach = priceEach;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public String getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(String orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public OrderDetail(long id, Order order, String productName, float subtotal, float shipping, float tax, float total,
			int quantityOrdered, float priceEach, String orderLineNumber) {
		super();
		this.id = id;
		this.order = order;
		this.productName = productName;
		this.subtotal = subtotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Double getSubtotalInDouble() {
		return getFloatAsDouble(subtotal);
	}
	
	public float getSubtotalInfloat() {
		return subtotal;
	}
	
	public static Double getFloatAsDouble(Float fValue) {
	    return Double.valueOf(fValue.toString());
	}

	private Double priceEachAsDouble = getPriceEachAsDouble();
	
	public Double getPriceEachAsDouble() {
		return getFloatAsDouble(priceEach);
	}

	public void setPriceEachAsDouble(Double priceEachAsDouble) {
		this.priceEachAsDouble = priceEachAsDouble;
	}



	
}
