package com.fssa.stockmanagementapp.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.stockmanagementapp.errors.StockValidatorErrors;
import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import com.fssa.stockmanagementapp.model.Stock;

public class StockValidator {

    public boolean validate(Stock stock) throws InvalidStockDataException {
        if (stock == null) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_NULL);
        }

        validateName(stock.getName());
        validatedescription(stock.getDescription());
        validateIsin(stock.getIsin());
        validatedPrice(stock.getPrice());
        validateCreationDate(stock.getCreateDate());
        validateExpireDate(stock.getExpireDate());
        validCreationTime(stock.getCreatedTime());
        validExprieTime(stock.getExpireTime(), stock.getCreatedTime(), stock.getExpireDate(), stock.getCreateDate());
        return true;

    }

    public boolean validateName(String name) throws InvalidStockDataException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_NULL_NAME);
        }
        String regex = "^[a-zA-Z]{1,50}+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(name);
        boolean isMatch = match.matches();
        if (!isMatch) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_NAME);
        }
        return true;

    }


    public boolean validateIsin(String isin) throws InvalidStockDataException {
        if (isin == null || isin.trim().equals("")) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_ISIN);
        }
        return true;
    }

    public boolean validatedescription(String description) throws InvalidStockDataException {

        if (description == null || description.trim().equals("")) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_DESC);
        }
        return true;
    }

    public boolean validatedPrice(double price) throws InvalidStockDataException {

        if (price <= 10) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_PRICE);
        }
        return true;
    }

    public boolean validateCreationDate(LocalDate date) throws InvalidStockDataException {
        if (date == null) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_DATE_NULL);
        } else if (!date.isEqual(LocalDate.now())) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_DATE);
        }
        return true;
    }


    public boolean validCreationTime(LocalTime time) throws InvalidStockDataException {

        if (time == null) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_TIME_NULL);
        }
        if (time.isBefore(LocalTime.MIN) || time.isAfter(LocalTime.MAX)) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_TIME);
        }

        return true;

    }

    public boolean validateExpireDate(LocalDate date) throws InvalidStockDataException {

        LocalDate today = LocalDate.now();
        if (date == null) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_DATE_NULL);
        } else if (date.isBefore(today)) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_DATE);
        }
        return true;
    }

    public boolean validExprieTime(LocalTime expireTime, LocalTime creationTime, LocalDate expireDate, LocalDate creationDate) throws InvalidStockDataException {

        if (expireTime == null) {
            throw new InvalidStockDataException(StockValidatorErrors.INVALID_TIME_NULL);
        } else if (expireTime.equals(creationTime)) {

            throw new InvalidStockDataException(StockValidatorErrors.INVALID_TIME);
        } else if (expireDate.equals(creationDate) && expireTime.isBefore(creationTime)) {

            throw new InvalidStockDataException(StockValidatorErrors.INVALID_TIME);
        }


        return true;
    }


}
