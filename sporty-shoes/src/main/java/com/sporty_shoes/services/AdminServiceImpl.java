package com.sporty_shoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty_shoes.entities.Admin;
import com.sporty_shoes.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Admin addAdmin(Admin admin) {
		adminRepo.save(admin);
		return admin;
	}

	@Override
	public String adminLogin(Admin admin) {
		String email = admin.getEmail();
		String pass = admin.getPassword();
		String msg = "❌ Invalid Login Credentials. Please try again";

		Admin a = adminRepo.findByEmail(email);
		String passwordFromDb = a.getPassword();

		if ((passwordFromDb != null) && (pass.equals(passwordFromDb))) {
			msg = "Welocome Admin 👨‍";
		}
		return msg;
	}

	@Override
	public String adminChangePassword(Admin admin) {
		String email = admin.getEmail();
		String newPass = admin.getPassword();

		Admin a = adminRepo.findByEmail(email);
		String msg = "❌ Unable to change password";

		if (a != null) {
			a.setPassword(newPass);
			adminRepo.save(a);
			msg = "✔️ Password Changed Sucessfully";
		}

		return msg;
	}
}
