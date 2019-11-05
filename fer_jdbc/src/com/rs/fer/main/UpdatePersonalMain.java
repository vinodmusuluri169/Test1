package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdatePersonalMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		User user=new User();
		user.setFirstName("sarita");
		user.setMiddleName("sri");
		user.setLastName("komati");
		user.setEmail("sarita@12");
		user.setUsername("sarita");
		user.setPassword("sarita123");
		user.setMobile("334322234");
		user.setId(4);

		Address address=new Address();
		address.setId(1);
		address.setLineOne("gfg");
		address.setLineTwo("fgj");
		address.setCity("vij");
		address.setState("AP");
		address.setZip("122452");
		address.setCountry("india");
				
		user.setAddress(address);
		boolean updatePersonal=ferService.updatePersonal(user);
		if(updatePersonal) {
			System.out.println("successfully..");
		}else {
			System.out.println("failed...");
		}



	}

}
