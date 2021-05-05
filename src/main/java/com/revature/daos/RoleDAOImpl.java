package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Role;
import com.revature.model.User;
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

	@Override
	public Role findById(int role_id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM roles WHERE role_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, role_id);
			
			ResultSet result = statement.executeQuery();
			
			Role role = new Role();
			
			while (result.next() ) {
				role.setRoleId(result.getInt("role_id"));
				role.setRole(result.getString("user_role"));
			}
			
			return role;
		}catch (SQLException e) {
			e.printStackTrace();
		
		}
		return null;
	}

	@Override
	public List<Role> findByString(String role) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM roles WHERE user_role = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, role);

			ResultSet result = statement.executeQuery();
			
			Role role1  = new Role();

			while (result.next()) {
				role1.setRoleId(result.getInt("role_id"));
				role1.setRole(result.getString("user_role"));
			}
            System.out.println(role1);
			return (List<Role>) role1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
