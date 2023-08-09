package com.fssa.stockmangement.validator;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.stockmanagementapp.errors.stockValidatorErrors;
import com.fssa.stockmanagementapp.model.Stock;
import com.fssa.stockmanagementapp.validator.StockValidator;

public class TestStockValidator {

	Stock validStocks = new Stock(4, "apple", "US-000402625-0", "the stock is good", 30.0, LocalDate.now(),
			LocalTime.now(), LocalDate.now(), LocalTime.now());
	
	Stock inValidStocks = new Stock(-3, null, null, null, -3, LocalDate.now(),
			LocalTime.now(), LocalDate.now(), LocalTime.now());

	@Test
	public void testValidate() throws Exception {

		Assertions.assertTrue(StockValidator.validate(validStocks));
	}

	@Test
	public void testInvalid() {
		try {
			StockValidator.validate(null);
		} catch (Exception e) {
			Assertions.assertEquals(stockValidatorErrors.INVALID_NULL, e.getMessage());
		}

	}

	
	@Test
	public void testValidateId() throws Exception {
		
		validStocks.setId(validStocks.getId());
		Assertions.assertTrue(StockValidator.validateId(validStocks.getId()));
	}
	
	@Test
	public void testInvalidId() {

		try {

			boolean valid = StockValidator.validateId(inValidStocks.getId());
			Assertions.fail("Validation error");

		} catch (Exception e) {

			Assertions.assertEquals(stockValidatorErrors.INVALID_ID, e.getMessage());
		}
	} 
	
	@Test
	public void testValidateName() throws Exception {
		validStocks.setName(validStocks.getName());
		Assertions.assertTrue(StockValidator.validateName(validStocks.getName()));
	}

	@Test
	public void testNullName() {
		try {
			StockValidator.validateName(inValidStocks.getName());
		} catch (Exception e) {
			Assertions.assertEquals(stockValidatorErrors.INVALID_NULL_NAME, e.getMessage());

		}
	}

	@Test
	public void testInvalidName() {
		try {
			StockValidator.validateName("KJDK6@*OEJ09");

		} catch (Exception e) {
			Assertions.assertEquals(stockValidatorErrors.INVALID_NAME, e.getMessage());
		}
	}

	@Test
	public void testvalidIsin() throws Exception {
		validStocks.setIsin(validStocks.getIsin());
		Assertions.assertTrue(StockValidator.validateIsin(validStocks.getIsin()));
	}

	@Test
	public void testInvalidIsin() {

		try {

			boolean valid = StockValidator.validateIsin(null);
			Assertions.fail("Validation error");

		} catch (Exception e) {

			Assertions.assertEquals(stockValidatorErrors.INVALID_ISIN, e.getMessage());
		}
	}

	@Test
	public void testvalidDesc() throws Exception {
		validStocks.setDescription(validStocks.getDescription());
		Assertions.assertTrue(StockValidator.validatedescription(validStocks.getDescription()));
	}

	@Test
	public void testInvalidDesc() {

		try {

			boolean valid = StockValidator.validatedescription(null);
			Assertions.fail("Validation error");

		} catch (Exception e) {

			Assertions.assertEquals(stockValidatorErrors.INVALID_DESC, e.getMessage());
		}
	}
	
	@Test
	public void testvalidPrice() throws Exception {
		validStocks.setPrice(validStocks.getPrice());
		Assertions.assertTrue(StockValidator.validatedPrice(100));
				
	}

	@Test
	public void testInvalidPrice() {

		try {

			boolean valid = StockValidator.validatedPrice(0);
			Assertions.fail("Validation error");

		} catch (Exception e) {

			Assertions.assertEquals(stockValidatorErrors.INVALID_PRICE, e.getMessage());
		}
	} 
	
	@Test
	public void testValidateCreationDate() throws Exception {
		validStocks.setCreateDate(validStocks.getCreateDate());

		Assertions.assertTrue(StockValidator.validateCreationDate(validStocks.getCreateDate()));
	}

	@Test
	public void testNullValidateDate() {
		try {
			StockValidator.validateCreationDate(null);
//			Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(stockValidatorErrors.INVALID_DATE_NULL, e.getMessage());
		}
	}

	@Test
	public void testInValidateDate() {
		try {
			StockValidator.validateCreationDate(inValidStocks.getCreateDate());
//			Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(stockValidatorErrors.INVALID_DATE, e.getMessage());
		}
	}
	 
	@Test
	public void testValidateExpireDate() throws Exception {
		validStocks.setExpireDate(validStocks.getExpireDate());
		Assertions.assertTrue(StockValidator.validateExpireDate(validStocks.getExpireDate()));
	}

	@Test
	public void testNullValidateExpireDate() {
		try {
			StockValidator.validateExpireDate(null);
//			Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(stockValidatorErrors.INVALID_DATE_NULL, e.getMessage());
		}
	}

	@Test
	public void testInValidateExpireDate() {
		try {
			StockValidator.validateExpireDate(inValidStocks.getExpireDate());
//			Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(stockValidatorErrors.INVALID_DATE, e.getMessage());
		}
	}

}
