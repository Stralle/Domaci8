package org.theplu.dao;

import org.theplu.entities.Users;

public interface IDAOUser extends IDAOAbstract<Users>{
	boolean checkUser(String user);
	boolean login(Users user);
}
