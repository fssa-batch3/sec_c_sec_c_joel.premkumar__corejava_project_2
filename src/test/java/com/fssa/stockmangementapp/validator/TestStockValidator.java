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
    Stock validStocks = new Stock("apple", "US-000402625-0", "the stock is good", 30.0, LocalDate.now(),
            LocalTime.now(), LocalDate.now(), LocalTime.now().plusHours(1));

    Stock inValidStocks = new Stock(null, null, null, -3, LocalDate.now().minusDays(1),
            LocalTime.now(), LocalDate.now().minusDays(1), LocalTime.now());

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

    @Test
    public void testValidateCreationDate() throws InvalidStockDataException {
        validStocks.setCreateDate(validStocks.getCreateDate());

        Assertions.assertTrue(validator.validateCreationDate(validStocks.getCreateDate()));
    }

    @Test
    public void testNullValidateDate() {
        try {
            validator.validateCreationDate(null);
//			Assertions.fail("Test case failed");
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_DATE_NULL, e.getMessage());
        }
    }

    @Test
    public void testInValidateDate() {
        try {
            validator.validateCreationDate(inValidStocks.getCreateDate());
//			Assertions.fail("Test case failed");
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_DATE, e.getMessage());
        }
    }

    @Test
    public void testValidateExpireDate() throws InvalidStockDataException {
        validStocks.setExpireDate(validStocks.getExpireDate());
        Assertions.assertTrue(validator.validateExpireDate(validStocks.getExpireDate()));
    }

    @Test
    public void testNullValidateExpireDate() {
        try {
            validator.validateExpireDate(null);
//			Assertions.fail("Test case failed");
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_DATE_NULL, e.getMessage());
        }
    }

    @Test
    public void testInValidateExpireDate() {
        try {
            validator.validateExpireDate(inValidStocks.getExpireDate());
//			Assertions.fail("Test case failed");
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_DATE, e.getMessage());
        }
    }

    @Test
    public void testValidCreationTime() throws InvalidStockDataException {

        Assertions.assertTrue(validator.validCreationTime(validStocks.getCreatedTime()));
    }


    @Test
    public void testInvalidCreationTimeNull() {

        try {

            validator.validCreationTime(null);
            Assertions.fail("Test case failed");
        } catch (InvalidStockDataException e) {

            Assertions.assertEquals(ValidatorErrors.INVALID_TIME_NULL, e.getMessage());
        }
    }


    @Test
    public void testValidExprieTime() throws InvalidStockDataException {

        Assertions.assertTrue(validator.validExprieTime(validStocks.getExpireTime(), validStocks.getCreatedTime(), validStocks.getExpireDate(), validStocks.getCreateDate()));
    }

    @Test
    public void testInvalidExpireTimeNull() {

        try {

            validator.validExprieTime(null, validStocks.getCreatedTime(), validStocks.getExpireDate(), validStocks.getCreateDate());
            Assertions.fail("Test case failed");
        } catch (InvalidStockDataException e) {

            Assertions.assertEquals(ValidatorErrors.INVALID_TIME_NULL, e.getMessage());
        }

    }

    @Test
    public void testInvalidExpireTime() {

        try {

            validator.validExprieTime(inValidStocks.getExpireTime(), inValidStocks.getCreatedTime(), inValidStocks.getExpireDate(), inValidStocks.getCreateDate());
            Assertions.fail("Test case failed");
        } catch (InvalidStockDataException e) {

            Assertions.assertEquals(ValidatorErrors.INVALID_TIME, e.getMessage());
        }

    }

}
