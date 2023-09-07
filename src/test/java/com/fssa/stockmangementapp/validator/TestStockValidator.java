package com.fssa.stockmangementapp.validator;

import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.stockmanagementapp.errors.ValidatorErrors;
import com.fssa.stockmanagementapp.model.Stock;
import com.fssa.stockmanagementapp.validator.StockValidator;

/**
 * This class contains unit tests for the StockValidator class.
 */
public class TestStockValidator { 
	
    public static final double VALID_PRICE = 100;
    public static final double INVALID_PRICE = 0;

    StockValidator validator = new StockValidator();
    Stock validStocks = new Stock("apple", "US5949181045", "the stock is good", 130.0);

    Stock inValidStocks = new Stock(null, null, null, -3);

    /**
     * Test the validate method of the StockValidator class with valid data.
     *
     * @throws Exception if an unexpected exception occurs.
     */
    @Test
    void testValidate() throws Exception {
        Assertions.assertTrue(validator.validate(validStocks));
    }

    /**
     * Test the validate method of the StockValidator class with null data.
     */
    @Test
    void testInvalid() {
        try {
            validator.validate(null);
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_NULL, e.getMessage());
        }
    }

    /**
     * Test the validateName method of the StockValidator class with valid name.
     *
     * @throws InvalidStockDataException if stock data is invalid.
     */
    @Test
    void testValidateName() throws InvalidStockDataException {
        validStocks.setName(validStocks.getName());
        Assertions.assertTrue(validator.validateName(validStocks.getName()));
    }

    /**
     * Test the validateName method of the StockValidator class with null name.
     */
    @Test
    void testNullName() {
        try {
            validator.validateName(inValidStocks.getName());
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_NULL_NAME, e.getMessage());
        }
    }

    /**
     * Test the validateName method of the StockValidator class with invalid name.
     */
    @Test
    void testInvalidName() {
        try {
            validator.validateName("KJDK6@*OEJ09");
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_NAME, e.getMessage());
        }
    }

    /**
     * Test the validateIsin method of the StockValidator class with valid ISIN.
     *
     * @throws InvalidStockDataException if stock data is invalid.
     */
    @Test
    void testvalidIsin() throws InvalidStockDataException {
        validStocks.setIsin(validStocks.getIsin());
        Assertions.assertTrue(validator.validateIsin(validStocks.getIsin()));
    }

    /**
     * Test the validateIsin method of the StockValidator class with null ISIN.
     */
    @Test
    void testInvalidIsin() {
        try {
            boolean valid = validator.validateIsin(null);
            Assertions.fail("Validation error"); 
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_ISIN, e.getMessage());
        }
    }

    /**
     * Test the validatedescription method of the StockValidator class with valid description.
     *
     * @throws InvalidStockDataException if stock data is invalid.
     */
    @Test
    void testvalidDesc() throws InvalidStockDataException {
        validStocks.setDescription(validStocks.getDescription());
        Assertions.assertTrue(validator.validatedescription(validStocks.getDescription()));
    }

    /**
     * Test the validatedescription method of the StockValidator class with null description.
     */
    @Test 
    void testInvalidDesc() {
        try {
            boolean valid = validator.validatedescription(null);
            Assertions.fail("Validation error");
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_DESC, e.getMessage());
        }
    }

    /**
     * Test the validatedPrice method of the StockValidator class with valid price.
     *
     * @throws InvalidStockDataException if stock data is invalid.
     */
    @Test
    void testvalidPrice() throws InvalidStockDataException {
        validStocks.setPrice(validStocks.getPrice());
        Assertions.assertTrue(validator.validatedPrice(VALID_PRICE));
    }

    /**
     * Test the validatedPrice method of the StockValidator class with invalid price.
     */
    @Test
    void testInvalidPrice() {
        try {
            boolean valid = validator.validatedPrice(INVALID_PRICE);
            Assertions.fail("Validation error");
        } catch (InvalidStockDataException e) {
            Assertions.assertEquals(ValidatorErrors.INVALID_PRICE, e.getMessage());
        }
    }
}
