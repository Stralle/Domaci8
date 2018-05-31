package org.theplu.dao;

import java.util.List;

import org.theplu.entities.Recipes;

public interface IDAORecipe extends IDAOAbstract<Recipes> {
	List<Recipes> findByName(String name);

    List<Recipes> getHundreds(int hundred);
}
