package com.revature
;

import java.util.List;

import com.revature.model.AccountStatus;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.service.AccountStatusService;
import com.revature.service.RoleService;
import com.revature.service.UserService;

public class Driver {
	
	private static RoleService rService = new RoleService();
	private static UserService uService = new UserService();
	private static AccountStatusService asService = new AccountStatusService();

	public static void main(String[] args) {
		List<Role> list = rService.getAllRoles();
		
		for(Role r : list)
			System.out.println(r);
		System.out.println("=======================");
		
		List<User> uList = uService.showUsers();
		
		for(User u : uList)
		System.out.println(u);
		System.out.println("==========================");
		
		List<AccountStatus> aslist = asService.getAllStatus();
          
		for (AccountStatus as : aslist)
			System.out.println(as);
	}

}
