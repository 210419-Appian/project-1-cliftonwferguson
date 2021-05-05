package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.AccountStatus;
import com.revature.utils.ConnectionUtil;

public class AccountStatusDAOImpl implements AccountStatusDAO {
	
   /**
    *  CREATE TABLE accountstatus (
    status_id Integer PRIMARY KEY,
    status varchar(30) NOT NULL UNIQUE 
 );
    */

	@Override
	public List<AccountStatus> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accountstatus;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

		List<AccountStatus> list = new ArrayList<> ();
		
		   while (result.next()) {
			   AccountStatus status = new AccountStatus();
			      status.setStatusId(result.getInt("status_id"));
			      status.setStatus(result.getString("status"));
			      list.add(status);
			 }
		   return list;
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		return null;
	}

	@Override
	public AccountStatus findByStatus(String AccountStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
