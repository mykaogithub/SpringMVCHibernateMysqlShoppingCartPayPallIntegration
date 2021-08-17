package com.kyanja.dao;

import java.util.List;

import com.kyanja.model.ShippingAddress;

public interface IShippingAdressDao {
	
	List<ShippingAddress> findAllShippingAddress();

	Long addShippingAddress(ShippingAddress address);

}
