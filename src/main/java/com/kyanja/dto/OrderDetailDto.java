package com.kyanja.dto;

import com.kyanja.model.OrderDetail;

public class OrderDetailDto {
	
	private long id;

	private String productName;

	private float subtotal;

	private float shipping;

	private float tax;

	private float total;

	private int quantityOrdered;

	private float priceEach;

	private String orderLineNumber;

	private OrderDto orderDto;
	

	


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

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	

	public String getPriceEach() {
		return String.format("%.3f", priceEach);
	}
	
	

	public void setPriceEach(float priceEach) {
		this.priceEach = priceEach;
	}



	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}

	
	
	



	public OrderDetailDto() {
		super();
	}

	public OrderDetailDto(String productName, float subtotal, float shipping, float tax, float total) {
		super();
		this.productName = productName;
		this.subtotal = subtotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
	}
	
	 /**
     * Create OrderDetailDto from OrderDetail
     */
	
	OrderDetailDto createOrderDetailDto(OrderDetail orderDetail) {
		
		
		
		
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		
		orderDetailDto.setProductName(orderDetail.getProductName());
		
		orderDetailDto.setOrderLineNumber(orderDetail.getOrderLineNumber());
		
		orderDetailDto.setQuantityOrdered(orderDetail.getQuantityOrdered());
		
		orderDetailDto.setSubtotal(Float.parseFloat(orderDetail.getSubtotal()));
		
		orderDetailDto.setShipping(Float.parseFloat(orderDetail.getShipping()));
		
		orderDetailDto.setTax(Float.parseFloat(orderDetail.getTax()));
		
		orderDetailDto.setTotal(Float.parseFloat(orderDetail.getTotal()));
		
		orderDetailDto.setId(orderDetail.getId());
		
	
		
		return orderDetailDto ;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(String orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}


	
	
}
