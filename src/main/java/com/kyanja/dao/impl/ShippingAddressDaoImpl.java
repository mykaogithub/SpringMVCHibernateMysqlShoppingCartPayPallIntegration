package com.kyanja.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyanja.dao.IShippingAdressDao;
import com.kyanja.model.ShippingAddress;


@Repository
public class ShippingAddressDaoImpl implements IShippingAdressDao{

	
	
	@Autowired
	private SessionFactory sf;
	
	
	public List<ShippingAddress> findAllShippingAddress() {
		
		List<ShippingAddress> shippingAdressList = (List<ShippingAddress>) sf.getCurrentSession().createQuery("from ShippingAddress").list();
		return shippingAdressList;
	}

	@Override
	public Long addShippingAddress(ShippingAddress address) {

		sf.getCurrentSession().saveOrUpdate(address);
		
		return address.getId();
	}

}
