package com.fssa.stockmangementapp.validator;

import org.junit.jupiter.api.Test;

import com.fssa.stockmanagementapp.dao.UserDAO;
import com.fssa.stockmanagementapp.exception.UserServiceException;
import com.fssa.stockmanagementapp.exception.ValidatorException;
import com.fssa.stockmanagementapp.model.User;
import com.fssa.stockmanagementapp.service.UserService;

public class TestUserService {

	UserDAO dao = new UserDAO();
	UserService service = new UserService();
	@Test
	void addUser() throws UserServiceException, ValidatorException {
		User u1 = new User();

		u1.setFullName("Naresh");
		u1.setEmailId("joe@gmail.com");
		u1.setPhoneNumber(8940169934L);
		u1.setPassword("Naresh");

		
service.addUser(u1);		
	}
}
