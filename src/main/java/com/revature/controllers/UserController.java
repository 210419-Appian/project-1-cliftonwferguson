package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.RoleDAOImpl;
import com.revature.daos.UserDAOImpl;
import com.revature.model.Account;
import com.revature.model.Message;
import com.revature.model.User;
import com.revature.model.UserDTO;
import com.revature.service.AccountService;
import com.revature.service.UserService;

public class UserController {
	private static PrintWriter pw;
	private static ObjectMapper om = new ObjectMapper();
	String s = new String();
	static AccountService accService = new AccountService();
	static UserService uService = new UserService();
	
	public void register (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		User user = om.readValue(body, User.class);

		if (uService.addUser(user)) {
			resp.setStatus(201);
		} else {
			resp.setStatus(406);
		}
  
//			
	}
	
	public void getAllUsers(HttpServletResponse resp) throws IOException {
		List<User> list = uService.showUsers();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}
	
	public void getUserbyid(HttpServletResponse resp, int id) throws IOException {

		User u = uService.getoneUser(id);

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(u);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}
	
	public void getAccount(HttpServletResponse resp, int id) throws IOException {

		Account account = accService.getoneAccount(id);

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(account);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	

	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 System.out.println("this is the logout meth");
		Message m = new Message();
		if(req.getSession(false)==null) {
			return;
		}
		HttpSession ses = req.getSession();
		
		if (ses != null) {
			
			m.setMessage("You have successfully logged out " + ses.getAttribute("username"));
			PrintWriter out = resp.getWriter();
			out.print(om.writeValueAsString(m));
			resp.setStatus(200);
			ses.invalidate();
			return;
		}
		m.setMessage("There was no user logged into the session");
		PrintWriter out = resp.getWriter();
		out.print(om.writeValueAsString(m));
		resp.setStatus(400);
	}
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		   System.out.println("This is login method");
		UserDAOImpl udao = new UserDAOImpl(); // params comming from postman
		UserDTO userdto = new UserDTO();
		UserService userser = new UserService();
			
			BufferedReader reader = req.getReader();  // <-- read text from char stream.    from 28 to 41 are the postman cred, it puts it into an object java gets.
                                                                                             // from 47 to 49, I am printing the object to postman.  posting the resp
			StringBuilder sb = new StringBuilder(); // <-- stringbuilder object                //48 and 49 is saving the dto into the session.

			String line = reader.readLine();   // <- tells it to read the next line. "where to start and end"

			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}

			String body = new String(sb);
			
			 userdto = om.readValue(body, UserDTO.class);
			
			PrintWriter out = resp.getWriter();
			    System.out.println("This is before login ver");
			if (userser.loginVerification(userdto)) {
				System.out.println("after login ver");
				out.print(om.writeValueAsString(udao.findByName(userdto.username)));
				HttpSession ses = req.getSession();
				ses.setAttribute("username", userdto.username);
				Message m = new Message();
					m.setMessage("You have logged in.");
				out.print(om.writeValueAsString(m));
				resp.setStatus(200);
			} else {
				Message m = new Message();
				m.setMessage("Invalid Credentials");
				out.print(om.writeValueAsString(m));
				resp.setStatus(400);
			}
			
		   
			
	 }
		
	
	}
	


