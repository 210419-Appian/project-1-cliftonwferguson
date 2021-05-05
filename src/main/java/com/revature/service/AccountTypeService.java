package com.revature.service;

import java.util.List;

import com.revature.daos.AccountTypeDAO;
import com.revature.daos.AccountTypeDAOImpl;
import com.revature.model.AccountType;

public class AccountTypeService {
	
	private AccountTypeDAO asDao = new AccountTypeDAOImpl();
	
	public List<AccountType> getAllAccountTypes() {
		
	    List<AccountType> list = asDao.findAll();
	    
	    return list;
		
	}

}
