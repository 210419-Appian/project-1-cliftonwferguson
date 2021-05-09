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
	
//	public void getAllAccounts(HttpServletRequest req, HttpServletResponse resp) throws IOException {
////		if(req.getSession(false)==null) {
////	    	   return;
////	       }
//	       HttpSession ses = req.getSession();
//	       String s = (String) ses.getAttribute("username");
//	       System.out.println(s);
//	       UserDAOImpl uDao = new UserDAOImpl();
//	       User u = uDao.findByName(s);
//	       System.out.println("this is line 36 " + u.toString());
//	       if (u.getRole().getRoleId() == 1) {
//	    
//	    			List<Account> list = accService.getAllAccounts(); 
//	    			
//	    			String json = om.writeValueAsString(list);
//	    			System.out.println(json);
//	    			PrintWriter pw = resp.getWriter();
//	    			pw.print(json);
//	    			resp.setStatus(200);
//	    		
//	   		} else {
//	   			Message m = new Message();
//	   			  m.setMessage("Invalid User");
//	   			  pw.print(om.writeValueAsString(m));
//	   			  resp.setStatus(400);
//	   		}
//	        
//	       }
//	       
	

	public void logout (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Message m = new Message();
		if(req.getSession(false)==null) {
			return;
		}
		HttpSession ses = req.getSession();
		
		if (ses != null) {
			ses.invalidate();
			
			m.setMessage("You have successfully logged out" + ses.getAttribute("username"));
			PrintWriter out = resp.getWriter();
			out.print(om.writeValueAsString(m));
			resp.setStatus(200);
			return;
		}
		m.setMessage("There was no user logged into the session");
		PrintWriter out = resp.getWriter();
		out.print(om.writeValueAsString(m));
		resp.setStatus(400);
	}
	
	public void login (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserDAOImpl udao = new UserDAOImpl();
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
			//next the userDTO should be passed to the service layer to check if the credentials are accurate. 
			//System.out.println(userdto.toString());
			PrintWriter out = resp.getWriter();
			
			if (userser.loginVerification(userdto)) {
				out.print(om.writeValueAsString(udao.findByName(userdto.username)));
				HttpSession ses = req.getSession();
				System.out.println(userdto.toString());
				ses.setAttribute("username", userdto.username);
				resp.setStatus(200);
			} else {
				Message m = new Message();
				m.setMessage("Invalid Credentials");
				out.print(om.writeValueAsString(m));
				resp.setStatus(400);
			}
			
		   
			
			}
		
	
	}
	


