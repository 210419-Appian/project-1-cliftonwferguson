package com.revature.daos;

import java.util.List;

import com.revature.model.AccountStatus;

public interface AccountStatusDAO {

	List<AccountStatus> findAll();
	AccountStatus findByStatus(String AccountStatus);
	
	
}
