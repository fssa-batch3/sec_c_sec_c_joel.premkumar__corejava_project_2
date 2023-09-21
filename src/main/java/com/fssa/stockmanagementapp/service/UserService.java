package com.fssa.stockmanagementapp.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.stockmanagementapp.dao.UserDAO;
import com.fssa.stockmanagementapp.exception.DAOException;
import com.fssa.stockmanagementapp.exception.ServiceException;
import com.fssa.stockmanagementapp.exception.UserDAOException;
import com.fssa.stockmanagementapp.exception.UserServiceException;
import com.fssa.stockmanagementapp.exception.ValidatorException;
import com.fssa.stockmanagementapp.model.User;
import com.fssa.stockmanagementapp.validator.UserValidator;

public class UserService {
   

 

    public  void addUser(User user) throws UserServiceException, ValidatorException {
        try {
            if (UserValidator.validate(user)) {
                UserDAO.addUser(user);
            } 
        } catch (UserDAOException  e) {
            throw new UserServiceException("Error adding user", e);
        }
    }

    public static void updateUser(User user) throws UserServiceException, ValidatorException {
        try {
            if (UserValidator.validate(user)) {
                UserDAO.updateUser(user);
            } 
        } catch (UserDAOException  e) {
            throw new UserServiceException("Error updating user", e);
        }
    }

    public static void deleteUser(int user_id) throws UserServiceException {
        try {
            UserDAO.deleteUser(user_id);
        } catch (UserDAOException e) {
            throw new UserServiceException("Error deleting user", e);
        }
    }

    public static List<User> getAllUsers() throws UserServiceException {
        try {
            return UserDAO.getAllUsers();
        } catch (UserDAOException e) {
            throw new UserServiceException("Error retrieving users", e);
        }
    }

    public static User getUserByEmail(String email) throws UserServiceException {
        try {
            return UserDAO.getUserByEmail(email);
        } catch (UserDAOException e) {
            throw new UserServiceException("Error getting user by email", e);
        }
    }
    
    public boolean logInCustomer( String email, String password) throws UserServiceException {
		
			try {
				if (UserValidator.validateEmailId(email) && UserValidator.validatePassword(password)) {
					return UserDAO.logInCustomer(email, password);
				}
			} catch (UserDAOException | ValidatorException e) {
				e.printStackTrace();
			}
		
		return false;
	}


}
