package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		
		FERService ferService = new FERServiceImpl();
		
		
		User user = new User();
		
		user.setFirstName("RS");
		user.setMiddleName("Sri");
		user.setLastName("Raja");
		user.setEmail("admin@rs.com"); 
		user.setUsername("admin");
		user.setPassword("test123");
		
		user.setMobile("334324234");
		
		boolean isRegister = ferService.registration(user);
		
		if(isRegister) {
			System.out.println("Records inserted successfully..");
		}else {
			System.out.println("no record inserted");
		}
		
	}
}
