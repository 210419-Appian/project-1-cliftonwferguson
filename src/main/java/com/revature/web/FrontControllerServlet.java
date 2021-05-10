package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.controllers.AccountController;
import com.revature.controllers.UserController;
import com.revature.model.User;
import com.revature.model.UserDTO;

public class FrontControllerServlet extends HttpServlet {

	private String BaseURL = null;
	private AccountController accController = new AccountController();
	private UserController uController = new UserController();

	@Override
	public void init(ServletConfig config) throws ServletException {
		BaseURL = config.getInitParameter("BaseURL");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	   doGet(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		resp.setStatus(404); // default if someone sends a malformed request.

		final String URL = req.getRequestURI().replace(BaseURL, "");

		System.out.println(URL);

		String[] sections = URL.split("/");

		System.out.println(sections);

		switch (sections[0]) {
		case "login":            //working, adding a cookie
			if (req.getMethod().equals("POST")) {
				uController.login(req, resp);
			}
		case "logout":		   //not working
			if (req.getMethod().equals("POST")) {
				uController.logout(req, resp);
			}
		
		case "getaccountbyid":   // working
			if (req.getMethod().equals("GET")) {
				int id = Integer.parseInt(sections[1]);
				uController.getAccount(resp, id);
			}
		case "users":
			if (req.getMethod().equals("GET")) {
				uController.getAllUsers(resp);
			}
		case "getuserbyid":
			if (req.getMethod().equals("GET")) {
			int id = Integer.parseInt(sections[1]);
			    uController.getUserbyid(resp, id);
			}
		case "newuser":
			if (req.getMethod().equals("POST")) {
				uController.register(req, resp);
			}
		case "getallaccounts":  //not working
			if (req.getMethod().equals("GET")) {
				accController.getAllAccounts(resp);
				//accController.getAllAccounts(resp);
			}
		case "newaccount":
			if (req.getMethod().equals("POST")) {
				accController.addAccount(req, resp);
			}
		case "withdraw" :
			if (req.getMethod().equals("PUT")) {
				accController.withdraw(req, resp);
			}
		}
	}
}
