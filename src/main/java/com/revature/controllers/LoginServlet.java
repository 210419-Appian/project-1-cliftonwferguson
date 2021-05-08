package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.model.UserDTO;

public class LoginServlet extends HttpServlet{
   User userparam = new User();
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDTO u = new UserDTO();
		
		u.username = req.getParameter("userId");  // the get parameter is coming from the html.
		u.password = req.getParameter("password");
		
		RequestDispatcher rd = null;
		PrintWriter out = resp.getWriter();
		
		if(u.username.equals(userparam.getUsername()) || u.username.equals(userparam.getPassword()) && u.username.equals(userparam.getPassword())) {
			HttpSession ses = req.getSession();
			ses.setAttribute("username", u.username);
			
			rd = req.getRequestDispatcher("success");
			rd.forward(req, resp);
		}else {
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
			out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
		}
	}
	
}
