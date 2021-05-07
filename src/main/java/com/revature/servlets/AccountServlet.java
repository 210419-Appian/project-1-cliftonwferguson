package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class AccountServlet extends HttpServlet {

	 private AccountService acService = new AccountService();
	 private ObjectMapper om = new ObjectMapper();
	 
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //Gets my accounts from the db
		 List<Account> list = acService.getAllAccounts();
		 
		 //Convert Java Object into a JSON string that can be written to the body of an HTTP response
		 String json = om.writeValueAsString(list);
		 System.out.println(json);
		 PrintWriter pw = resp.getWriter();
		 pw.print(json);
		 
	 }
	 
}
