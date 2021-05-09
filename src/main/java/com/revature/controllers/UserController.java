package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;
import com.revature.model.UserDTO;

public class UserController {
	
	private static ObjectMapper om = new ObjectMapper();

	
	public static void login (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
			UserDTO u = new UserDTO();
			
			BufferedReader reader = req.getReader();  // <-- read text from char stream. 

			StringBuilder sb = new StringBuilder(); // <-- stringbuilder object

			String line = reader.readLine();   // <- tells it to read the next line. "where to start and end"

			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}

			String body = new String(sb);
			
			User u = om.readValue(body, User.class);
			//next the userDTO should be passed to the service layer to check if the credentials are accurate. 
			
			
			PrintWriter out = resp.getWriter();
			
			
			
			if(u.username.equals("tom") && u.password.equals("jerry")) {
				//Create a session so we remember our user/client in the future. 
				HttpSession ses = req.getSession(); //cookie is created here and put in the response. 
				ses.setAttribute("username", u.username); //Here we save the username in the session for use later. 
				
				rd = req.getRequestDispatcher("success");
				rd.forward(req, resp);
			} else {
				rd = req.getRequestDispatcher("index.html");
				rd.include(req, resp);
				out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
			}
			
			//resp.setStatus(200); //Tomcat will do this by default if it finds a servlet method to handle the request. 
			
		
	}


