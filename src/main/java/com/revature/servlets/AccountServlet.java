package com.revature.servlets;

import java.io.BufferedReader;
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
	 
	 
	 // The doGet method is used to request data from a specified resource.  
	 // This servlet is accepting the request for info through the req as an HTTP request.  It's then sending the programmed response. 
	 // In this case, 
	 
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //Gets my accounts from the db  This is calling the AccountService to access the getAllAccounts method. 
		 List<Account> list = acService.getAllAccounts();
		 //req.getMethod(); // <--- returns the method type
		 
		 //Convert Java Object into a JSON string that can be written to the body of an HTTP response.  JSON is agnostic and useful for the browser to 
		 // read anything that we send it. 
		 String json = om.writeValueAsString(list); // <- This takes my Account List and turns it into a JSON. "JSON converts objects to a string".
		 System.out.println(json);  // <-- This will print out the string object we created above with the object mapper object.
		 PrintWriter pw = resp.getWriter();  // <-- A writer that writes specifically to my response object. 
		 pw.print(json); //<-- telling the printwriter to write the json object to my response object. 
		 resp.setStatus(200); // <--- (200 - okay) Once the other code lines have run successfully, this will send a message back to 
		 resp.setContentType("application/json"); // <-- It basically tells the client (the webbrowser) what content type it is so that it knows what to do with it.
		 
	 }
	 
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // StringBuilder is used as this is singlethread.  This will take in the object and create a StringBuilder object with all accounts in one line.
		 StringBuilder sb = new StringBuilder();
		 
		 //The request object has a built in method to return an object that can read the body line by line.
		 //It as a curser system so we will have to create a while loop for Java to understand it. First we need to tell the curser where to start reading.
		 BufferedReader reader = req.getReader();  // <-- will be able to read the StringBuilder object
		 
		 String line = reader.readLine(); // <-- this will tell the curser to start at line one.  It will read the first line then move the curser up to the next line.
		 
		 while (line != null) { // <--read through each line to the end.  The null is the end. 
		   sb.append(line);  //<-- build line by line onto a single string. 
		 line = reader.readLine();
		 } // < --- The while loop is all so the object mapper can read the body.
		 String body = new String(sb);  // < -- create a string out of the string builder object.
		 // Jackson will convert the json that is in the body to a java object we tell it to.
		 Account ac = om.readValue(body, Account.class);  //<--- This is taking the "body" string created above and using the object mapper "om" to insert the 
		                                                  // posted values into the account class.
		 
		 if (acService.addAccount(ac)) {
			 resp.setStatus(201);
		 }else {
			 resp.setStatus(400);
		 }
	 } 
	 
	 
	 
}
