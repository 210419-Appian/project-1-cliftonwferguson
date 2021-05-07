package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	private static RoleDAO rDAO = new RoleDAOImpl();
	
	/**
	 *   user_table
	 *    user_id SERIAL PRIMARY KEY,
   user_name varchar(30) NOT NULL UNIQUE,
   pass_word varchar(15) NOT null,
   first_name varchar(15) NOT null,
   last_name varchar(15) NOT NULL,
   email varchar(30) NOT NULL,
   user_role INTEGER REFERENCES roles(role_id)
	 */
	
	 /**
	  * private int userId;
	    private String username;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private Role role;
	 *  
	  */
	
	@Override
	public boolean addUser(User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//There is no chance for sql injection with just an integer so this is safe. 
			String sql = "INSERT INTO user_table (user_name, pass_word, first_name, last_name, email, user_role)"
					+ "	VALUES (?, ?, ?, ?, ?, ?);";

			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, user.getUsername());
			statement.setString(++index, user.getPassword());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getEmail());
			if(user.getRole() != null) {
				statement.setInt(++index, user.getRole().getRoleId());
			} else {
				statement.setInt(++index, 3);
			}
			
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public User findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user_table WHERE user_id = "+id+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			User u = null;

			while (result.next()) {
				u = new User(
						result.getInt("user_id"), 
						result.getString("user_name"), 
						result.getString("pass_word"), 
						result.getString("first_name"), 
						result.getString("last_name"), 
						result.getString("email"),
						null
						);
				int uUser = result.getInt("user_role");
				
					u.setRole(rDAO.findById(uUser));
				
			}

			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
			

	@Override
	public List<User> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SElECT * FROM user_table;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<User> list = new ArrayList<>();
			
			while (result.next()) {
				User user = new User(
				result.getInt("user_id"),
				result.getString("user_name"),
				result.getString("pass_word"),
				result.getString("first_name"),
				result.getString("last_name"),
				result.getString("email"),
				null
			);
				int uUser = result.getInt("user_role");
				
					user.setRole(rDAO.findById(uUser));
				
				list.add(user);
				}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByName(String user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<User> findByAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
