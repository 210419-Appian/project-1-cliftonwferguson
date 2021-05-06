package com.revature.daos;

import java.io.IOException;
import java.util.List;

import com.revature.model.User;

public interface UserDAO {
    
	public List<User> findAll();
	public User findByName(String user);
	public boolean addUser(User user);
	public List<User> findByAccount();
	public User findById(int id);
	
	
}
