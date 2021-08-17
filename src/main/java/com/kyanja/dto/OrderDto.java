package com.kyanja.dto;

import java.util.List;

import com.kyanja.model.Order;
import com.kyanja.model.OrderDetail;

public class OrderDto {
	
	private String orderNumber;
	
	private double orderAmount;
	
	private CustomerDto customerDto;
	
	private List<OrderDetailDto> orderDetailDtos;

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

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}
	
	 /**
     * Create OrderDto from Order
     */
	
	public OrderDto createOrderDto (Order order) {
		
		
		
		OrderDto orderDto  = new OrderDto();
		orderDto.setOrderNumber(order.getOrderNumber());
		orderDto.setOrderAmount(order.getOrderAmount());
	

		return orderDto ;
		
		
	}

	public List<OrderDetailDto> getOrderDetailDtos() {
		return orderDetailDtos;
	}

	public void setOrderDetailDtos(List<OrderDetailDto> orderDetailDtos) {
		this.orderDetailDtos = orderDetailDtos;
	}

	

}
