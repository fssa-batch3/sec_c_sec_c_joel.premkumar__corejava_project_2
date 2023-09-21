package com.fssa.stockmangementapp.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.stockmanagementapp.exception.ValidatorException;
import com.fssa.stockmanagementapp.model.History;
import com.fssa.stockmanagementapp.validator.HistoryValidator;

public class HistoryValidatorTest {

    @Test
    public void testValidHistory() {
        // Create a valid History object
        History history = new History();
        history.setUserId(1);
        history.setStockName("AAPL");
        history.setQuantity(10);
        history.setInr(5000.0);
        history.setUsd(70.0);
        // Set a valid Timestamp for purchasedDate (you can use java.sql.Timestamp)
        history.setPurchasedDate(new java.sql.Timestamp(System.currentTimeMillis()));

        // Validate the History object
        try {
            HistoryValidator.validate(history);
            // If no exception is thrown, the validation is successful
        } catch (ValidatorException e) {
            fail("Validation failed: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidUserId() {
        // Create a History object with an invalid userId
        History history = new History();
        history.setUserId(-1); // Invalid userId

        // Validate the History object and expect a ValidatorException
        try {
            HistoryValidator.validate(history);
            fail("Validation should fail for invalid userId");
        } catch (ValidatorException e) {
            assertEquals("Invalid userId", e.getMessage());
        }
    }

    @Test
    public void testInvalidStockName() {
        // Create a History object with an invalid stockName
        History history = new History();
        history.setUserId(-1);
        history.setStockName(""); // Invalid stockName (empty)

        // Validate the History object and expect a ValidatorException
        try {
            HistoryValidator.validate(history);
            fail("Validation should fail for invalid stockName");
        } catch (ValidatorException e) {
            assertEquals("Invalid stockName", e.getMessage());
        }
    }

    // Add similar test methods for other fields like quantity, inr, usd, and purchasedDate
}
