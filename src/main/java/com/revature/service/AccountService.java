package com.revature.service;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImple;
import com.revature.model.Account;

public class AccountService {
	
	private AccountDAO acDao = new AccountDAOImple();
	
	public List<Account> getAllAccounts() {
		List<Account> list = acDao.findAll();
		return list;
	}
	
	public Account getoneAccount(int id) {
		return acDao.findById(id);
	}
    
	public List<Account> getAllByStatus(int id) {
		return acDao.findByStatusId(id);
	}
	
	public List<Account> getAllByUser(int id) {
		return acDao.findByUserId(id);
	}
	
	public boolean addAccount(Account account) {
		return acDao.addAccount(account);
	}
	
}
