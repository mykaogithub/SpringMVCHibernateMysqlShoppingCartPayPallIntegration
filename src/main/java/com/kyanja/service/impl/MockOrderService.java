package com.kyanja.service.impl;


import org.springframework.stereotype.Service;

import com.kyanja.model.Order;
import com.kyanja.model.OrderDetail;
import com.kyanja.model.ShippingAddress;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockOrderService {

    public Order getOrderByCode(final String code) {

        return order(code);

    }

    private Order order(String code) {
    	
    	Order o = new Order();
    	o.setOrderDetails(entries());
    	o.setShippingDetail(address());
    	o.setOrderNumber(code);
        return o;
    }

    private ShippingAddress address() {
    	
    	ShippingAddress adress = new ShippingAddress();
    	adress.setCity("Paris");
    	adress.setPostalCode("75000");
    	adress.setState("France");
    	adress.setLine1( "Gabriel Peri");
        return adress;
    }

    private List<OrderDetail> entries() {
        return new ArrayList<OrderDetail>() {
        	
        	
            {
            	
            	OrderDetail o1 = new OrderDetail();
            	o1.setProductName("Apple IPhone X");
            	o1.setQuantityOrdered(1);
            	o1.setPriceEach(500);
            	add(o1);
            	
            	OrderDetail o2 = new OrderDetail();
            	o2.setProductName("Samsung Galaxy s8");
            	o2.setQuantityOrdered(2);
            	o2.setPriceEach(400);
            	add(o2);
            	

            }
        };
    }
}
