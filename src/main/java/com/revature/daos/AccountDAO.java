package com.revature.daos;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {

	public List<Account> findAll();
	Account findByName(String name);
	boolean addAccount(Account account);
	public boolean updateAccount(Account account);
}
