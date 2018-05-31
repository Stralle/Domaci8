package org.theplu.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.theplu.dao.DAOUser;
import org.theplu.entities.Users;
import org.theplu.services.IServiceUser;
import org.theplu.services.ServiceUser;


@Stateless
@LocalBean
@Path("/user")
public class ControllerUser {

	private IServiceUser service;
	
	public ControllerUser() {
		this.service = new ServiceUser(new DAOUser());
	}

    @GET
    @Produces("text/json")
    public List<Users> getAll(){
        return this.service.getAll();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/register")
    public boolean register(Users user){
        return this.service.register(user); //add
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public boolean login(Users user){
        return this.service.login(user);
    }

	
	
}
