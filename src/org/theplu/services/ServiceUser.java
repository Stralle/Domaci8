package org.theplu.services;

import org.theplu.dao.IDAOUser;
import org.theplu.entities.Users;

public class ServiceUser extends ServiceAbstract<Users, IDAOUser> implements IServiceUser {

	public ServiceUser(IDAOUser dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(Users user) {
		return this.dao.login(user);
	}

	@Override
	public boolean register(Users user) {
		// TODO Auto-generated method stub
		if(this.dao.checkUser(user.getName())) {
			return false;
		}
		super.add(user);
		return true;
	}

}
