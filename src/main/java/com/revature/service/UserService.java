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
	   UserDAOImpl udao = new UserDAOImpl();
	   UserDTO userdto = new UserDTO();
	   UserService userser = new UserService();
		
		if (udao.findByName(userdto.getUsername()).getPassword() == userdto.getPassword()) {
			
		return true;
			
 		} else {
			return false;
		}
		
		
		
   }
   

}
