package com.fssa.stockmanagementapp.exception;

public class UserDAOException extends RuntimeException {
    public UserDAOException(String message) {
        super(message);
    }

    public UserDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
