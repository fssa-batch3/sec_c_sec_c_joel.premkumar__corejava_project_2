package com.fssa.stockmanagementapp.validator;

import java.sql.Timestamp;
import java.util.regex.Pattern;
import com.fssa.stockmanagementapp.errors.ValidatorErrors;
import com.fssa.stockmanagementapp.exception.ValidatorException;
import com.fssa.stockmanagementapp.model.History;

public class HistoryValidator {

    public static void validate(History history) throws ValidatorException {
        if (history == null) {
            throw new ValidatorException(ValidatorErrors.INVALID_NULL);
        }

        validateUserId(history.getUserId());
        validateStockName(history.getStockName());
        validateQuantity(history.getQuantity());
        validateInr(history.getInr());
        validateUsd(history.getUsd());
        validatePurchasedDate(history.getPurchasedDate());
    }

    public static void validateUserId(int userId) throws ValidatorException {
        if (userId <= 0) {
            throw new ValidatorException(ValidatorErrors.INVALID_USER_ID);
        }
    }

    public static void validateStockName(String stockName) throws ValidatorException {
        if (stockName == null || stockName.trim().isEmpty()) {
            throw new ValidatorException(ValidatorErrors.INVALID_STOCK_NAME);
        }
        // You can add additional stock name validation logic here if needed.
    }

    public static void validateQuantity(int quantity) throws ValidatorException {
        if (quantity <= 0) {
            throw new ValidatorException(ValidatorErrors.INVALID_QUANTITY);
        }
    }

    public static void validateInr(double inr) throws ValidatorException {
        if (inr <= 0) {
            throw new ValidatorException(ValidatorErrors.INVALID_INR);
        }
    }

    public static void validateUsd(double usd) throws ValidatorException {
        if (usd <= 0) {
            throw new ValidatorException(ValidatorErrors.INVALID_USD);
        }
    }

    public static void validatePurchasedDate(Timestamp purchasedDate) throws ValidatorException {
        if (purchasedDate == null) {
            throw new ValidatorException(ValidatorErrors.INVALID_PURCHASED_DATE);
        }
    }
}

