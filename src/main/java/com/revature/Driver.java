package com.revature;

import java.util.List;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.service.RoleService;
import com.revature.service.UserService;

public class Driver {
	
	private static RoleService rService = new RoleService();
	private static UserService uService = new UserService();

	public static void main(String[] args) {
		List<Role> list = rService.getAllRoles();
		
		for(Role r : list)
			System.out.println(r);
		System.out.println("=======================");
		
		List<User> uList = uService.showUsers();
		System.out.println(uList);

	}

}
