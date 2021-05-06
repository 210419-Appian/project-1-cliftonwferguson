package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.AccountType;
import com.revature.utils.ConnectionUtil;

public class AccountTypeDAOImpl implements AccountTypeDAO{
	
	
	/*
	 * CREATE TABLE accounttype (
       type_id integer PRIMARY KEY,
       type varchar(30) NOT NULL unique
       );
	 */
	 
  
	@Override
	public AccountType findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounttype WHERE type_id = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			AccountType acounttype = new AccountType();
			
			while (result.next()) {
				acounttype.setTypeId(result.getInt("type_id"));
				acounttype.setType(result.getString("type"));
			}
			return acounttype;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
		
		
	}
	
	
	@Override
	public List<AccountType> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounttype;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);
			
			List<AccountType> list = new ArrayList<>();
			
			while (result.next()) {
				AccountType acType = new AccountType();
				acType.setTypeId(result.getInt("type_id"));
				acType.setType(result.getString("type"));
				
				list.add(acType);
			}
			return list;
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	

	

}
