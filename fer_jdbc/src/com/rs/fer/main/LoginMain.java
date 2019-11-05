
package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.DBUtil;

public class LoginMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();	
		User user =new User();
		user.setUsername("Divya");
		user.setPassword("Divya123");
		boolean isLogin = ferService.login(user.getUsername(),user.getPassword());
		if(isLogin) {
			System.out.println("Records fetched successfully..");
		}else {
			System.out.println("no matched records..");
		}
		
	

		
				

		
		
	}
}
