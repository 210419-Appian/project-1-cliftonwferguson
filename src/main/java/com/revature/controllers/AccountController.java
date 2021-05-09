package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class AccountController {
  
	private AccountService accService = new AccountService();
	private ObjectMapper om = new ObjectMapper();
	
	public void addAccount (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Account account = om.readValue(body, Account.class);
		
		if(accService.addAccount(account)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(406);
		}
	}
	
	public void getAllAccounts(HttpServletResponse resp) throws IOException {
		// Gets my avengers from the db.
		List<Account> list = accService.getAllAccounts(); 
		
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
		}
    
	public void getAccount(HttpServletResponse resp, int id) throws IOException {

		Account acc = accService.getoneAccount(id);

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(acc);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}
	


	
	
}
