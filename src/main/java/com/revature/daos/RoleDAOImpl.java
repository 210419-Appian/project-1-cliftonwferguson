package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Role;
import com.revature.utils.ConnectionUtil;

public class RoleDAOImpl implements RoleDAO{

	@Override
	public List<Role> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "Select * FROM roles;";
			
            Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Role> list = new ArrayList<>();
			
			/**
			 * role_id integer PRIMARY KEY,
               user_role varchar(30) NOT NULL unique
			 */
			
			/**
			 * private int roleId;
	           private String role;
			 */
			
			while (result.next()) {
				Role role = new Role();
				role.setRoleId(result.getInt("role_id"));
				role.setRole(result.getString("user_role"));
				
				list.add(role);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
