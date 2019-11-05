package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetPersonalMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userId=2;
		User getPersonal=ferService.getPersonal(userId);
				if(getPersonal!=null){
					System.out.println("successfully.......");
				}else {
					System.out.println("failed...");
				}



	}

}
