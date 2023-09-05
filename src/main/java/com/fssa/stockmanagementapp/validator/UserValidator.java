package com.fssa.stockmanagementapp.validator;

public class UserValidator {
	
	public static boolean validatefullName(String fullName) throws ValidatorException {

		if (fullName == null) {

			throw new ValidatorException(CustomerValidatorError.INVALID_NULL_FIRST_NAME);
		}

		else if ("".equals(fullName.trim())) {

			throw new ValidatorException(CustomerValidatorError.INVALID_EMPTY_FIRST_NAME);
		}

		else if (fullName.trim().length() >= LENGTH_OF_FIRST_NAME) {

			throw new ValidatorException(CustomerValidatorError.INVALID_LENGTH_FIRST_NAME);
		}

		String regexfullName = "^[A-Za-z\\s]+$";
		Pattern pattern = Pattern.compile(regexfullName); // compiles the given pattern
		Matcher matcher = pattern.matcher(fullName); // matcher matches the given string with compiled pattern
		boolean isMatch = matcher.matches(); // give final output as true or false
		if (!isMatch) {

			throw new ValidatorException(CustomerValidatorError.INVALID_NAME);
		}
		return true;

	}
}
