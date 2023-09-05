package com.fssa.stockmangementapp.validator;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.stockmanagementapp.errors.ValidatorErrors;
import com.fssa.stockmanagementapp.model.Stock;
import com.fssa.stockmanagementapp.validator.StockValidator;

public class TestStockValidator {

	StockValidator validator = new StockValidator();
	Stock validStocks = new Stock("apple", "US-000402625-0", "the stock is good", 30.0);

	Stock inValidStocks = new Stock(null, null, null, -3);

	@Test
	public void testValidate() throws Exception {

		Assertions.assertTrue(validator.validate(validStocks));
	}

	@Test
	public void testInvalid() {
		try {
			validator.validate(null);
		} catch (InvalidStockDataException e) {
			Assertions.assertEquals(ValidatorErrors.INVALID_NULL, e.getMessage());
		}

	}

	@Test
	public void testValidateName() throws InvalidStockDataException {
		validStocks.setName(validStocks.getName());
		Assertions.assertTrue(validator.validateName(validStocks.getName()));
	}

	@Test
	public void testNullName() {
		try {
			validator.validateName(inValidStocks.getName());
		} catch (InvalidStockDataException e) {
			Assertions.assertEquals(ValidatorErrors.INVALID_NULL_NAME, e.getMessage());

		}
	}

	@Test
	public void testInvalidName() {
		try {
			validator.validateName("KJDK6@*OEJ09");

		} catch (InvalidStockDataException e) {
			Assertions.assertEquals(ValidatorErrors.INVALID_NAME, e.getMessage());
		}
	}

	@Test
	public void testvalidIsin() throws InvalidStockDataException {
		validStocks.setIsin(validStocks.getIsin());
		Assertions.assertTrue(validator.validateIsin(validStocks.getIsin()));
	}

	@Test
	public void testInvalidIsin() {

		try {

			boolean valid = validator.validateIsin(null);
			Assertions.fail("Validation error");

		} catch (InvalidStockDataException e) {

			Assertions.assertEquals(ValidatorErrors.INVALID_ISIN, e.getMessage());
		}
	}

	@Test
	public void testvalidDesc() throws InvalidStockDataException {
		validStocks.setDescription(validStocks.getDescription());
		Assertions.assertTrue(validator.validatedescription(validStocks.getDescription()));
	}

	@Test
	public void testInvalidDesc() {

		try {

			boolean valid = validator.validatedescription(null);
			Assertions.fail("Validation error");

		} catch (InvalidStockDataException e) {

			Assertions.assertEquals(ValidatorErrors.INVALID_DESC, e.getMessage());
		}
	}

	@Test
	public void testvalidPrice() throws InvalidStockDataException {
		validStocks.setPrice(validStocks.getPrice());
		Assertions.assertTrue(validator.validatedPrice(100));

	}

	@Test
	public void testInvalidPrice() {

		try {

			boolean valid = validator.validatedPrice(0);
			Assertions.fail("Validation error");

		} catch (InvalidStockDataException e) {

			Assertions.assertEquals(ValidatorErrors.INVALID_PRICE, e.getMessage());
		}
	}

}
