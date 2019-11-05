package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int Userid=1;
		List<Expense> expense =ferService.getExpenses(Userid);
		

	}

}
