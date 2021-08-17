package com.kyanja.dao;

import com.kyanja.model.Role;
import com.kyanja.model.User;

public interface IUserDao {
	
	
	
	   public void addUser(User u);
	   public void grantRole(Role r,Long userID);

}
