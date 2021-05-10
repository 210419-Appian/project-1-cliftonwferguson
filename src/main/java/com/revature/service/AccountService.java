package com.revature.service;

import java.io.IOException;
import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImple;
import com.revature.model.Account;
import com.revature.model.AccountStatus;
import com.revature.model.AccountType;
import com.revature.model.BalanceDTO;
import com.revature.model.User;

public class AccountService {
	
	private AccountDAOImple acDao = new AccountDAOImple();
	private static BalanceDTO bDto = new BalanceDTO();
	
	public boolean withdraw(BalanceDTO bDto, String s) {
		
		Account account = acDao.findById(bDto.accountId);
		
		if (account == null) {
			return false;
		}
		System.out.println(account);
		if (bDto.amount < account.getBalance()) {
			account.setBalance(account.getBalance() - bDto.amount);
			System.out.println(account.getBalance());
			acDao.updateAccount(account);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deposit(BalanceDTO bDto, String s) {
		
	Account account = acDao.findById(bDto.accountId);
		
		if (account == null) {
			return false;
		}
		System.out.println(account);
		
			account.setBalance(account.getBalance() + bDto.amount);
			System.out.println(account.getBalance());
			acDao.updateAccount(account);
			return true;
		
		}
	
	
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
