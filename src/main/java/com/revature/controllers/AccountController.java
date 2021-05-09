package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class AccountController {
  
	private AccountService accService = new AccountService();
	private ObjectMapper om = new ObjectMapper();
	 
	public void getAllAccounts(HttpServletResponse resp) throws IOException {
		// Gets my avengers from the db.
		List<Account> list = accService.getAllAccounts(); 
		
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
		}

}
