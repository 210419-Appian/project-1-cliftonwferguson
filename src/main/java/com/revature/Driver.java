package com.revature;

import java.util.List;

import com.revature.model.Role;
import com.revature.service.RoleService;

public class Driver {
	
	private static RoleService rService = new RoleService();

	public static void main(String[] args) {
		List<Role> list = rService.getAllRoles();
		
		for(Role r : list)
			System.out.println(r);
		

	}

}
