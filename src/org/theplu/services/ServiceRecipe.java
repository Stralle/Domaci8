package org.theplu.services;

import java.util.List;

import org.theplu.dao.IDAORecipe;
import org.theplu.entities.Recipes;

public class ServiceRecipe extends ServiceAbstract<Recipes, IDAORecipe> implements IServiceRecipe {

	public ServiceRecipe(IDAORecipe dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Recipes> findByName(String name) {
		return this.dao.findByName(name);
	}

	@Override
	public List<Recipes> getHundreds(int hundred) {
		return this.dao.getHundreds(hundred);
	}

}
