package com.rs.fer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userId=1;
		String currentPassword="123";
		String newPassword="sunil123";
		boolean resetPassword=ferService.resetPassword( userId, currentPassword, newPassword);
		if(resetPassword) {
		  System.out.println("Records updated successfully..");
		  }else {
		  System.out.println("no matched record found.."); } 
			}

}
