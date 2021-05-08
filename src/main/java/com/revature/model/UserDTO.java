package com.revature.model;

public class UserDTO {

	 //Temporary object to store information until I grab the entire object from the database.
	
	 
	public String username;
	public String password;
	
	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserDTO() {
		super();
	}
	
}
