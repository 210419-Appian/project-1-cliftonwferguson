package com.revature
;

import java.util.List;

import com.revature.model.AccountStatus;
import com.revature.model.AccountType;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.service.AccountStatusService;
import com.revature.service.AccountTypeService;
import com.revature.service.RoleService;
import com.revature.service.UserService;

public class Driver {
	
	private static RoleService rService = new RoleService();
	private static UserService uService = new UserService();
	private static AccountStatusService asService = new AccountStatusService();
	private static AccountTypeService atService = new AccountTypeService();

	public static void main(String[] args) {
		
		System.out.println("All Roles");
		System.out.println(" ");
		
		List<Role> list = rService.getAllRoles();
		
		for(Role r : list)
			System.out.println(r);
		
		System.out.println("=======================");
		
		System.out.println("All Users with Role Object");
		System.out.println(" ");
		
		List<User> uList = uService.showUsers();
		
		for(User u : uList)
		System.out.println(u);
		
		System.out.println("==========================");
		
		System.out.println("All Account Status");
		System.out.println(" ");
		
		List<AccountStatus> aslist = asService.getAllStatus();
          
		for (AccountStatus as : aslist)
			System.out.println(as);
		
		 System.out.println("=========================");
		 
		 System.out.println("All Account Types");
		 System.out.println(" ");
		 
		 List<AccountType> atlist = atService.getAllAccountTypes();
		 
		 for (AccountType at : atlist)
			 System.out.println(at);
	}

}
