package com.fssa.stockmanagementapp.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.stockmanagementapp.errors.ValidatorErrors;
import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import com.fssa.stockmanagementapp.model.Stock;

public class StockValidator {

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

    public boolean validateName(String name) throws InvalidStockDataException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_NULL_NAME);
        }
        String regex = "^[a-zA-Z]{1,50}+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(name);
        boolean isMatch = match.matches();
        if (!isMatch) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_NAME);
        }
        return true;

    }


    public boolean validateIsin(String isin) throws InvalidStockDataException {
        if (isin == null || isin.trim().equals("")) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_ISIN);
        }
        return true;
    }

    public boolean validatedescription(String description) throws InvalidStockDataException {

        if (description == null || description.trim().equals("")) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_DESC);
        }
        return true;
    }

    public boolean validatedPrice(double price) throws InvalidStockDataException {

        if (price <= 10) {
            throw new InvalidStockDataException(ValidatorErrors.INVALID_PRICE);
        }
        return true;
    }




}
