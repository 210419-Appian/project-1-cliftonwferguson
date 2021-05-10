package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private static AccountTypeDAO atDoa = new AccountTypeDAOImpl();
	private static UserDAO uDao = new UserDAOImpl();
	
	
	/*
	 *  CREATE TABLE account (
        account_id SERIAL PRIMARY KEY,
        balance double precision NOT NULL,
        account_status_id INTEGER REFERENCES accountstatus(status_id), // First create the find by Id method in account status dao.
        account_type INTEGER REFERENCES accounttype(type_id),  // Next, create the find by id method in the account type dao.
        user_id integer REFERENCES user_table(user_id) //finally, create the find by id method in the user dao.
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
	public boolean updateAccount(Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			// There is no chance for sql injection with just an integer so this is safe.
			String sql = "UPDATE account " + "SET balance = ?, " + "account_status_id = ?, " + "account_type = ?, " + "user_id = ? " + "WHERE account_id = ?;";
					

			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setDouble(++index, account.getBalance());
			if(account.getStatusId() != null) {   //<-- If I don't specify the status of a new account, it should default to pending. 
				   statement.setInt(++index, account.getStatusId().getStatusId());	
				} else {
					
				}
				if(account.getType() != null) { // <-- If I don't specify the type of new account, it should default to checking.
					statement.setInt(++index, account.getType().getTypeId());
				} else {
					
				}
				if(account.getUser() != null) { //<--  If I don't specify the owner of the account, it should default to admin as a system check.
					statement.setInt(++index, account.getUser().getUserId());
				} else { 
					
				}
				    statement.setInt(++index, account.getAccountId());
				statement.execute();
				return true;
				
			  } catch (SQLException e) {
					e.printStackTrace();
			  }
			return false;
	}
	
	@Override
	public boolean addAccount(Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//There is no chance for sql injection with just an integer so this is safe. 
			String sql = "INSERT INTO account (balance, account_status_id, account_type, user_id)"
					+ "	VALUES (?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, account.getBalance());
			if(account.getStatusId() != null) {   //<-- If I don't specify the status of a new account, it should default to pending. 
			   statement.setInt(++index, account.getStatusId().getStatusId());	
			} else {
				statement.setInt(++index, 1);
			}
			if(account.getType() != null) { // <-- If I don't specify the type of new account, it should default to checking.
				statement.setInt(++index, account.getType().getTypeId());
			} else {
				statement.setInt(++index, 1);
			}
			if(account.getUser() != null) { //<--  If I don't specify the owner of the account, it should default to admin as a system check.
				statement.setInt(++index, account.getUser().getUserId());
			} else { 
				statement.setInt(++index, 1);
			}
			
			statement.execute();
			return true;
			
		  } catch (SQLException e) {
				e.printStackTrace();
		  }
		return false;
	}
	
	@Override
	public List<Account> findByUserId(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account WHERE user_id = "+id+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account uid = new Account(
						result.getInt("account_id"),
						result.getDouble("balance"),
						null, // account_status_id INTEGER REFERENCES accountstatus(status_id),
						null, // account_type varchar(30) REFERENCES accounttype(type),
						null // user_id integer REFERENCES user_table(user_id)
						);
				int accStatus = result.getInt("account_status_id");
				  uid.setStatusId(accDao.findById(accStatus));
				int at = result.getInt("account_type");
				 uid.setType(atDoa.findById(at));
				int ui = result.getInt("user_id");
				 uid.setUser(uDao.findById(ui));
				 list.add(uid);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<Account> findByStatusId(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account WHERE account_status_id = "+id+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account as = new Account(
						result.getInt("account_id"),
						result.getDouble("balance"),
						null, // account_status_id INTEGER REFERENCES accountstatus(status_id),
						null, // account_type varchar(30) REFERENCES accounttype(type),
						null // user_id integer REFERENCES user_table(user_id)
						);
				int accStatus = result.getInt("account_status_id");
				  as.setStatusId(accDao.findById(accStatus));
				int at = result.getInt("account_type");
				 as.setType(atDoa.findById(at));
				int ui = result.getInt("user_id");
				 as.setUser(uDao.findById(ui));
				 list.add(as);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

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
						null, // account_type varchar(30) REFERENCES accounttype(type),
						null // user_id integer REFERENCES user_table(user_id)
						);
				int accStatus = result.getInt("account_status_id");
				  ac.setStatusId(accDao.findById(accStatus));
				int at = result.getInt("account_type");
				 ac.setType(atDoa.findById(at));
				int ui = result.getInt("user_id");
				 ac.setUser(uDao.findById(ui));
				list.add(ac);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	@Override
	public Account findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account WHERE account_id = "+id+";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			Account ac = null;

			while (result.next()) {
				 ac = new Account(
						result.getInt("account_id"),
						result.getDouble("balance"),
						null, // account_status_id INTEGER REFERENCES accountstatus(status_id),
						null, // account_type varchar(30) REFERENCES accounttype(type),
						null // user_id integer REFERENCES user_table(user_id)
						);
				int accStatus = result.getInt("account_status_id");
				  ac.setStatusId(accDao.findById(accStatus));
				int at = result.getInt("account_type");
				 ac.setType(atDoa.findById(at));
				int ui = result.getInt("user_id");
				 ac.setUser(uDao.findById(ui));
			}

			return ac;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	


}
