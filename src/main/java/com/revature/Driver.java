package com.revature
;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.AccountStatus;
import com.revature.model.AccountType;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.AccountStatusService;
import com.revature.service.AccountTypeService;
import com.revature.service.RoleService;
import com.revature.service.UserService;

public class Driver {
	
	private static RoleService rService = new RoleService();
	private static UserService uService = new UserService();
	private static AccountStatusService asService = new AccountStatusService();
	private static AccountTypeService atService = new AccountTypeService();
    private static AccountService acService = new AccountService();
	
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
		 
		 System.out.println("========================");
		 
		 System.out.println("All Accounts");
		 System.out.println(" ");
		 
		 List<Account> aclist = acService.getAllAccounts();
		 
		 for(Account ac : aclist)
			 System.out.println(ac);
		 
		 System.out.println("==================");
		 
		 System.out.println("Find Account by id");
		 System.out.println(" ");
		 
		 Account account1 = acService.getoneAccount(2);
		 System.out.println(account1);
		 
		 System.out.println("======================");
		 
		 System.out.println("Find User by id");
		 System.out.println(" ");
		 
		 User user1 = uService.getoneUser(2);
		 System.out.println(user1);
		 
		 System.out.println("======================");
		 
		 System.out.println("Find Account by Status id");
		 System.out.println(" ");
		 
		 List<Account> acStatus2 = acService.getAllByStatus(2);
		 
		 System.out.println("Status id 2");
		 for (Account as2 : acStatus2)
			 System.out.println(as2);
		    System.out.println(" ");
		    
		 List<Account> acStatus1 = acService.getAllByStatus(1);
		 
		 System.out.println("Status id 1");
		 for (Account as1 : acStatus1)
			 System.out.println(as1);
		 
	}

}
