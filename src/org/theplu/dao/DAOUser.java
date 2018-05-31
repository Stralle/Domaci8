package org.theplu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.theplu.entities.Users;

public class DAOUser extends DAOAbstractDatabase<Users> implements IDAOUser {

	public DAOUser() {
		super(Users.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkUser(String user) {
	 Connection connection = createConnection();

        if(connection == null)
            return false;

        try{
            PreparedStatement st = connection.prepareStatement(String.format("SELECT * FROM %s WHERE %s = \"%s\"", this.clazz.getSimpleName(), Users.USER_NAME, user));

            ResultSet rs = st.executeQuery();

            Boolean status = rs.next();

            closeStat(st);
            closeResultSet(rs);

            return status;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return false;
	}

	@Override
	public boolean login(Users user) {
	 Connection connection = createConnection();

        if(connection == null)
            return false;

        try{
            PreparedStatement st = connection.prepareStatement(String.format("SELECT * FROM %s WHERE %s = \"%s\" AND %s = \"%s\"",
                    this.clazz.getSimpleName(), Users.USER_NAME, user.getName(), Users.USER_PASS, user.getPass()));

            ResultSet rs = st.executeQuery();

            Boolean status = rs.next();

            closeStat(st);
            closeResultSet(rs);

            return status;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return false;
	}

}
