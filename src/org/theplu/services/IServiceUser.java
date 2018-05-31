package org.theplu.services;

import org.theplu.entities.Users;

public interface IServiceUser extends IServiceAbstract<Users> {
	
	boolean login(Users user);
	
	boolean register(Users user);
	
}
