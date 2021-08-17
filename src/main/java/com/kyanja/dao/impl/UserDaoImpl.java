package com.kyanja.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyanja.dao.IUserDao;
import com.kyanja.model.Role;
import com.kyanja.model.User;

@Repository
public class UserDaoImpl implements IUserDao{
	
	
	@Autowired
	private SessionFactory sf;
	
	

	@Override
	public void addUser(User u) {
		
		sf.getCurrentSession().saveOrUpdate(u);

	
		
	}

	@Override
	public void grantRole(Role r, Long userID) {
	
		User u=    sf.getCurrentSession().get(User.class, userID);
		u.getRoles().add(r);
		sf.getCurrentSession().saveOrUpdate(r);
		
	}

}
