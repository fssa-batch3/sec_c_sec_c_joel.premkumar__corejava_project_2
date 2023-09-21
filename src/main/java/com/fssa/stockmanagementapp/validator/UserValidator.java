package com.fssa.stockmanagementapp.validator;

import java.util.regex.Pattern;

import com.fssa.stockmanagementapp.errors.ValidatorErrors;
import com.fssa.stockmanagementapp.exception.ValidatorException;
import com.fssa.stockmanagementapp.model.User;

public class UserValidator {

    public static boolean validate(User user) throws ValidatorException {

        if (user == null) {
            throw new ValidatorException(ValidatorErrors.INVALID_NULL);
        }

        validateFullName(user.getFullName());
        validateEmailId(user.getEmailId());
        validatePhoneNumber(user.getPhoneNumber());
        validatePassword(user.getPassword());

        return true;
    }

    public static boolean validateFullName(String fullName) throws ValidatorException {

        if (fullName == null || fullName.trim().isEmpty()) {
            throw new ValidatorException(ValidatorErrors.INVALID_NULL_NAME);
        }

        String regex = "^[A-Za-z\\s]{3,255}$";
        if (!Pattern.matches(regex, fullName)) {
            throw new ValidatorException(ValidatorErrors.INVALID_NAME);
        }

        return true;
    }

    public static boolean validateEmailId(String emailId) throws ValidatorException {

        if (emailId == null || emailId.trim().isEmpty()) {
            throw new ValidatorException(ValidatorErrors.INVALID_EMAIL_NULL);
        }

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(regex, emailId)) {
            throw new ValidatorException(ValidatorErrors.INVALID_EMAIL_PATTERN);
        }

        return true;
    }

    public static boolean validatePhoneNumber(long phoneNumber) throws ValidatorException {

        String phoneNumberStr = String.valueOf(phoneNumber);
        
        if (phoneNumberStr.length() != 10 || phoneNumberStr == null) {
            throw new ValidatorException(ValidatorErrors.INVALID_PHONE_LENGTH);
        }

        return true;
    }

    public static boolean validatePassword(String password) throws ValidatorException {

        if (password == null || password.isEmpty()) {
            throw new ValidatorException(ValidatorErrors.INVALID_PASSWORD_NULL);
        }

//        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,}$";
//        if (!Pattern.matches(regex, password)) {
//            throw new ValidatorException(ValidatorErrors.INVALID_PASSWORD_PATTERN);
//        }

        return true;
    }
}

