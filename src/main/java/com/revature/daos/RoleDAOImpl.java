package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Role;
import com.revature.utils.ConnectionUtil;

public class RoleDAOImpl implements roleDAO{

	@Override
	public List<Role> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "Select * FROM roles;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Role> list = new ArrayList<>();
			
			while (result.next()) {
				Role role = new Role();
			}
		}
		return null;
	}

}
