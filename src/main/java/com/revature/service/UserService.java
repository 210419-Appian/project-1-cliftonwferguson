package com.revature.service;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.model.User;

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

}
