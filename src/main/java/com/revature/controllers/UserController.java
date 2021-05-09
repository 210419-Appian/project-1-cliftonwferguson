package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.model.Message;
import com.revature.model.UserDTO;
import com.revature.service.UserService;

public class UserController {
	private static ObjectMapper om = new ObjectMapper();

	
	public static void login (HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
			
			PrintWriter out = resp.getWriter();
			
			if (userser.loginVerification(userdto)) {
				out.print(om.writeValueAsString(udao.findByName(userdto.username)));
				HttpSession ses = req.getSession();
				ses.setAttribute("username", userdto.username);
				resp.setStatus(200);
			} else {
				Message m = new Message();
				m.setMessage("Invalid Credentials");
				out.print(om.writeValueAsString(m));
				resp.setStatus(400);
			}
			
			
		
			//resp.setStatus(200); //Tomcat will do this by default if it finds a servlet method to handle the request. 
			
	}	
	}


