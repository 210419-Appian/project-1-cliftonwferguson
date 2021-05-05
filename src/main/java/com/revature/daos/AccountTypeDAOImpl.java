package com.revature.daos;

import java.sql.Connection;
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
