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
	
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		resp.setStatus(404); // default if someone sends a malformed request.

		final String URL = req.getRequestURI().replace(BaseURL, "");

		System.out.println(URL);

		String[] sections = URL.split("/");

		System.out.println(sections);

		switch (URL) {
		case "accounts":
			accController.getAllAccounts(resp);
		 break;
		case "login":
			if (req.getMethod().equals("post")) {
				uController.login(req, resp);
			}
		case "logout":		
			if (req.getMethod().equals("post")) {
				uController.logout(req, resp);
			}
		}
	}
}
