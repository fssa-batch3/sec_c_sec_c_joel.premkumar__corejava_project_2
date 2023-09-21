package com.fssa.stockmanagementapp.exception;

public class UserServiceException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 9007329742235761057L;

	public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}