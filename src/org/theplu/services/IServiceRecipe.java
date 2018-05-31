package org.theplu.services;

import java.util.List;

import org.theplu.entities.Recipes;

public interface IServiceRecipe extends IServiceAbstract<Recipes> {

	List<Recipes> findByName(String name);
	
	List<Recipes> getHundreds(int hundred);
	
}
