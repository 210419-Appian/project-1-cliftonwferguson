package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.model.User;
import com.revature.model.UserDTO;

public class UserService {
   private UserDAO uDAO = new UserDAOImpl();
   
   public List<User> showUsers() {
	   return uDAO.findAll();
   }
   
   public User getoneUser(int id) {
		return uDAO.findById(id);
	}
   
   public boolean addUser(User user) {
		return uDAO.addUser(user);
	}
   
   public User findByName(String user) { 
	   
	   return uDAO.findByName(user);
   }
   
   public boolean loginVerification(UserDTO u) {
	   
	   User user = uDAO.findByName(u.username);
	   
		
		if ((user.getPassword() != null) && (u.password.equals(user.getPassword()))) {
			
		return true;
			
 		} else {
			return false;
		}
		
		
		
   }
   

}
