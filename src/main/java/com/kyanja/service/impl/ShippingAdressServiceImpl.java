package com.kyanja.service.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.dao.IShippingAdressDao;
import com.kyanja.model.ShippingAddress;
import com.kyanja.service.IShippingAdressService;

@Service
@Transactional
public class ShippingAdressServiceImpl implements IShippingAdressService{
	
	@Autowired
	IShippingAdressDao dao;

	@Override
	public List<ShippingAddress> findAllShippingAddress() {
		
		return dao.findAllShippingAddress();
	}

	@Override
	public Long addShippingAddress(ShippingAddress address) {
		
		return dao.addShippingAddress(address);
	}
	
	

}
