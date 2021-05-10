package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.AccountDAOImple;
import com.revature.daos.UserDAOImpl;
import com.revature.model.Account;
import com.revature.model.BalanceDTO;
import com.revature.model.Message;
import com.revature.model.User;
import com.revature.service.AccountService;

public class AccountController {
  
	private static AccountService accService = new AccountService();
	private static ObjectMapper om = new ObjectMapper();
	private static PrintWriter out;
	private static UserDAOImpl uDao = new UserDAOImpl();
	private static String s = new String();
	private static AccountDAOImple aDao = new AccountDAOImple();
	
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
	

	public void withdraw (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession ses = req.getSession();
		
		s = (String) ses.getAttribute("username");
		
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		BalanceDTO bDto = om.readValue(body, BalanceDTO.class);

		out = resp.getWriter();
		
		User user = uDao.findByName(s);
		
		
		Account accountwd = aDao.findById(bDto.accountId);
		if (accountwd == null) {
			Message m = new Message();
			m.setMessage("Invalid Account Identification");
			out.print(om.writeValueAsString(m));
			resp.setStatus(400);
		}
		
	  if ((user.getRole().getRoleId() == 1) || user.getUserId() == accountwd.getUser().getUserId()) {
		  
		  if (accService.withdraw(bDto, s)) {
			  Message m = new Message();
			  m.setMessage(bDto.balance + " has been withdrawn from your accout.");
			  out.print(om.writeValueAsString(m));
			  resp.setStatus(201);
		  } else {
			  Message m = new Message();
			  m.setMessage("You are not allowed to perform this action.");
			  PrintWriter out = resp.getWriter();
			  out.print(om.writeValueAsString(m));
			  resp.setStatus(401);
		  }
	  }
	  
	}
	

	
	
}
