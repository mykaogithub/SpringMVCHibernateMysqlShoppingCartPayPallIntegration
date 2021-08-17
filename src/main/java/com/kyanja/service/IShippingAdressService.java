package com.kyanja.service;

import java.util.List;

import com.kyanja.model.ShippingAddress;

public interface IShippingAdressService {
	
	
	List<ShippingAddress> findAllShippingAddress();

	Long addShippingAddress(ShippingAddress address);

}
