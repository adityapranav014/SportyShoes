package com.sporty_shoes.services;

import com.sporty_shoes.entities.Admin;

public interface AdminService {

	public Admin addAdmin(Admin admin);

	public String adminLogin(Admin admin);

	public String adminChangePassword(Admin admin);

}
