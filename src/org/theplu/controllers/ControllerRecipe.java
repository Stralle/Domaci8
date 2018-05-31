package org.theplu.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.theplu.dao.DAORecipe;
import org.theplu.entities.Recipes;
import org.theplu.services.IServiceRecipe;
import org.theplu.services.ServiceRecipe;

@Stateless
@LocalBean
@Path("/recipe")
public class ControllerRecipe {

	private IServiceRecipe service;
	
	public ControllerRecipe(){
		this.service = new ServiceRecipe(new DAORecipe());
	}
	
    @GET
    @Produces("text/json")
	public List<Recipes> getAll(){
		return this.service.getAll();
	}
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public boolean add(Recipes recipes){
    	return this.service.add(recipes);
    }
    
    @GET
    @Path("/search/name/{name}")
    @Produces("application/json")
    public List<Recipes> findByName(@PathParam("name") String name) {
        return service.findByName(name);
    }
   
    @GET
    @Path("/search/{hundred}")
    @Produces("application/json")
    public List<Recipes> getHundreds(@PathParam("hundred") int hundred) {
        return this.service.getHundreds(hundred);
    }
    
}
