package com.revature.service;


import java.util.List;

import com.revature.daos.AccountStatusDAO;
import com.revature.daos.AccountStatusDAOImpl;
import com.revature.model.AccountStatus;


public class AccountStatusService {
       
	public AccountStatusDAO asDao = new AccountStatusDAOImpl();
	
	 public List<AccountStatus> getAllStatus(){
		 List<AccountStatus> list = asDao.findAll();
		 
		 return list;
	 }
	
}
