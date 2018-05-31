package org.theplu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.theplu.entities.Recipes;

public class DAORecipe extends DAOAbstractDatabase<Recipes> implements IDAORecipe {

	public DAORecipe() {
		super(Recipes.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Recipes> findByName(String name) {
		Connection conn = createConnection();

        if (conn == null)
            return null;

        try {
            PreparedStatement st = conn.prepareStatement(String.format("SELECT * from %s WHERE %s LIKE \"%s\"", this.clazz.getSimpleName(), Recipes.REC_NAME, name));
            ResultSet rs = st.executeQuery();
            List<Recipes> list = new ArrayList<Recipes>();
            while (rs.next())
                list.add(readFromResultSet(rs));
            closeStat(st);
            closeResultSet(rs);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return null;
	}

	@Override
	public List<Recipes> getHundreds(int hundred) {
		Connection conn = createConnection();

        if (conn == null)
            return null;

        try {
            int offset = 100 * hundred;

            PreparedStatement st = conn.prepareStatement(String.format("SELECT * FROM %s LIMIT 100 OFFSET %d", this.clazz.getSimpleName(), offset));

            ResultSet rs = st.executeQuery();

            List<Recipes> list = new ArrayList<Recipes>();

            while (rs.next())
                list.add(readFromResultSet(rs));

            closeStat(st);
            closeResultSet(rs);

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return null;
	}

}
