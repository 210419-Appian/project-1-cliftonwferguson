package com.revature.daos;

import java.util.List;

import com.revature.model.Role;

public interface RoleDAO {
	public List<Role> findAll();
	public Role findById(int user_id);
	public Role findByString(String role);
}
