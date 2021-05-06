package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.AccountStatus;
import com.revature.model.AccountType;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

public class AccountDAOImple implements AccountDAO{
	
	private static AccountStatusDAO accDao = new AccountStatusDAOImpl();
	
	/*
	 *  CREATE TABLE account (
        account_id SERIAL PRIMARY KEY,
        balance double precision NOT NULL,
        account_status_id INTEGER REFERENCES accountstatus(status_id), // First create the find by Id method in account status dao
        account_type varchar(30) REFERENCES accounttype(type),
        user_id integer REFERENCES user_table(user_id)
  )
	 */
	
	/*
	 * public class Account {
      private int accountId;
      private double balance;
      private AccountStatus statusId;
      private AccountType type;
      private User user;
	 */

	@Override
	public List<Account> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account;";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);
			
			List<Account> list = new ArrayList<>();
			
			while (result.next()) {
				Account ac = new Account(
						result.getInt("account_id"),
						result.getDouble("balance"),
						null, // account_status_id INTEGER REFERENCES accountstatus(status_id),
						null,
						null
						);
				int accStatus = result.getInt("account_status_id");
				  ac.setStatusId(accDao.findById(accStatus));
				list.add(ac);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	

	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}