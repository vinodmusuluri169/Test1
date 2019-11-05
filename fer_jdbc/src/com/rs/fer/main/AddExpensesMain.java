package com.rs.fer.main;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpensesMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense addexpenses=new Expense();
		addexpenses.setId(3);
		addexpenses.setType("iphone");
		addexpenses.setDate("30/6/2019");
		addexpenses.setPrice(50000);
		addexpenses.setByWhom("Sunil");
		addexpenses.setNumberOfItems(1);
		addexpenses.setUserId(2);
		boolean isaddexpenses = ferService.addExpense(addexpenses);

		  if(isaddexpenses) {
		  System.out.println("Records inserted successfully..");
		  }else {
		  System.out.println("no record inserted"); }
		 }
}