package com.revature.daos;

import java.sql.Connection;
import java.util.List;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	/**
	 * user_id SERIAL PRIMARY KEY,
	   user_name varchar(30) NOT NULL UNIQUE,
	   pass_word varchar(15) NOT null,
	   first_name varchar(15) NOT null,
	   last_name varchar(15) NOT NULL,
	   email varchar(30) NOT NULL,
	   user_role varchar(30) REFERENCES roles(user_role)
	 */
	
	 /**
	  * private int userId;
	    private String username;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private Role role;
	  */
			

	@Override
	public List<User> findAll() {
		//try(Connection conn = ConnectionUtil.getConnection()) {
			
		//	String sql = "SElect * FROM user_table;";
	//	}
		return null;
	}

	@Override
	public User findByName(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
