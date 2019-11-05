package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ExpenseReportMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int eId=1;
		String type="book";
		String fromDate="30/7/2019";
		String toDate="30/8/2020";
		List<Expense> expenseReport=ferService.expenseReport( type, fromDate, toDate);
		

		



	}

}

