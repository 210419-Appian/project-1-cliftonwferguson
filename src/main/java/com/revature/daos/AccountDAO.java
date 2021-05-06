package com.revature.daos;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {

	public List<Account> findAll();
	boolean addAccount(Account account);
	public boolean updateAccount(Account account);
	public Account findById(int id);
	public List<Account> findByStatusId(int id);
	public List<Account> findByUserId(int id);
	
}
