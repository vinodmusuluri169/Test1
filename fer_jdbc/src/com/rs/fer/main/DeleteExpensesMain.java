
package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpensesMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int expenseId=3;
		boolean deleteexpenses = ferService.deleteExpense(expenseId);
		
		if(deleteexpenses) {
			System.out.println("Records edited successfully.."); 
		  }else {
		 System.out.println("no matched record found ");
			
		}


	}

	
	

	}


