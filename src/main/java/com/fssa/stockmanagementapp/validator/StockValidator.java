package com.fssa.stockmanagementapp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.stockmanagementapp.errors.ValidatorErrors;
import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import com.fssa.stockmanagementapp.model.Stock;

/**
 * The StockValidator class is responsible for validating stock data.
 */
public class StockValidator {

    /**
     * The minimum price allowed for a stock.
     */
    public static final int MINIMUM_PRICE = 10;

    /**
     * Validates the given stock object.
     *
     * @param stock The stock object to validate.
     * @return true if the stock is valid, false otherwise.
     * @throws InvalidStockDataException if the stock data is invalid.
     */
    public boolean validate(Stock stock) throws InvalidStockDataException {
        if (stock == null) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_NULL);
        }

        validateName(stock.getName());
        validatedescription(stock.getDescription());
        validateIsin(stock.getIsin());
        validatedPrice(stock.getPrice());
        return true;
    }

    /**
     * Validates the stock name.
     *
     * @param name The name of the stock to validate.
     * @return true if the name is valid, false otherwise.
     * @throws InvalidStockDataException if the name is invalid.
     */
    public boolean validateName(String name) throws InvalidStockDataException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_NULL_NAME);
        }
        // Pattern for a name with 1 to 50 characters, allowing letters, digits, and spaces
        String regex = "^[\\p{L}0-9\\s]{1,5}+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(name);
        boolean isMatch = match.matches();
        if (!isMatch) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_NAME);
        }
        return true;
    }

    /**
     * Validates the stock ISIN.
     *
     * @param isin The ISIN of the stock to validate.
     * @return true if the ISIN is valid, false otherwise.
     * @throws InvalidStockDataException if the ISIN is invalid.
     */
    public boolean validateIsin(String isin) throws InvalidStockDataException {
        if (isin == null || isin.trim().equals("")) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_ISIN);
        }
        // Pattern for a valid ISIN (International Securities Identification Number)
        String regex = "^[A-Z]{2}[A-Z0-9]{9}[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(isin);
        boolean isMatch = match.matches();
        if (!isMatch) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_ISIN);
        }
        return true;
    }

    /**
     * Validates the stock description.
     *
     * @param description The description of the stock to validate.
     * @return true if the description is valid, false otherwise.
     * @throws InvalidStockDataException if the description is invalid.
     */
    public boolean validatedescription(String description) throws InvalidStockDataException {
        if (description == null || description.trim().equals("")) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_DESC);
        }
        // Pattern for a description with 1 to 100 characters, allowing letters, digits, and spaces
        String regex = "^[\\p{L}0-9\\s]{1,500}+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(description);
        boolean isMatch = match.matches();
        if (!isMatch) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_DESC);
        }
        return true;
    }

    /**
     * Validates the stock price.
     *
     * @param price The price of the stock to validate.
     * @return true if the price is valid, false otherwise.
     * @throws InvalidStockDataException if the price is invalid.
     */
    public boolean validatedPrice(double price) throws InvalidStockDataException {
        if (price < MINIMUM_PRICE) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_PRICE);
        }
        return true;
    }
}
