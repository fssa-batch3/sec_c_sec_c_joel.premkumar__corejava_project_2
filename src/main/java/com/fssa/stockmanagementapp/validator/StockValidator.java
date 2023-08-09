package com.fssa.stockmanagementapp.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.stockmanagementapp.errors.stockValidatorErrors;
import com.fssa.stockmanagementapp.model.Stock;

public class StockValidator {

	public static boolean validate(Stock stock) throws Exception {
		if (stock == null) {
			throw new Exception(stockValidatorErrors.INVALID_NULL);
		}

		validateName(stock.getName());
		validatedescription(stock.getDescription());
		validateIsin(stock.getIsin());
		validatedPrice(stock.getPrice());
		validateCreationDate(stock.getCreateDate());
		validateExpireDate(stock.getExpireDate());
		return true;

	}

	public static boolean validateName(String name) throws Exception {
		if (name == null || name.trim().equals("")) {
			throw new Exception(stockValidatorErrors.INVALID_NULL_NAME);
		}
		String regex = "^[a-zA-Z]{1,50}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(name);
		boolean isMatch = match.matches();
		if (!isMatch) {
			throw new Exception(stockValidatorErrors.INVALID_NAME);
		}
		return true;

	}
	 
	public static boolean validateId(int id) throws Exception {
		if (id < 0) {
			throw new Exception(stockValidatorErrors.INVALID_ID);
		}
		return true;
	}

	public static boolean validateIsin(String isin) throws Exception {
		if (isin == null || isin.trim().equals("")) {
			throw new Exception(stockValidatorErrors.INVALID_ISIN);
		}
		return true;
	}

	public static boolean validatedescription(String description) throws Exception {

		if (description == null || description.trim().equals("")) {
			throw new Exception(stockValidatorErrors.INVALID_DESC);
		}
		return true;
	}

	public static boolean validatedPrice(double price) throws Exception {

		if (price < 10) {
			throw new Exception(stockValidatorErrors.INVALID_PRICE);
		}
		return true;
	}

	public static boolean validateCreationDate(LocalDate date) throws Exception {

		LocalDate today = LocalDate.now();
		if (date == null) {
			throw new Exception(stockValidatorErrors.INVALID_DATE_NULL);
		} else if (date.isAfter(today)) {
			throw new Exception(stockValidatorErrors.INVALID_DATE);
		}
		return true;
	}

	public static boolean validateExpireDate(LocalDate date) throws Exception {

		LocalDate today = LocalDate.now();
		if (date == null) {
			throw new Exception(stockValidatorErrors.INVALID_DATE_NULL);
		} else if (date.isBefore(today)) {
			throw new Exception(stockValidatorErrors.INVALID_DATE);
		}
		return true;
	}

}
