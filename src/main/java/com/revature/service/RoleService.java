package com.revature.service;

import java.util.List;

import com.revature.daos.RoleDAO;
import com.revature.daos.RoleDAOImpl;
import com.revature.model.Role;

public class RoleService {
	
	private RoleDAO rDao = new RoleDAOImpl();
     
	 public List<Role>  getAllRoles() {
		 
		 List<Role> list = rDao.findAll();
		 
		 
		return list;
	 }
}
