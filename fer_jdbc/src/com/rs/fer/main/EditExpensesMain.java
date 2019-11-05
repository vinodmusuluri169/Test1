package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpensesMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense editexpenses=new Expense();
		editexpenses.setId(2);
		editexpenses.setType("iphone");
		editexpenses.setDate("30/6/2019");
		editexpenses.setPrice(50000);
		editexpenses.setByWhom("Sunil");
		editexpenses.setNumberOfItems(1);
		editexpenses.setUserId(2);
		boolean editeexpenses = ferService.editExpense(editexpenses);
		  
		  if(editeexpenses) {
		  System.out.println("Records edited successfully.."); 
		  }else {
		 System.out.println("no matched record found "); } 	}



}
