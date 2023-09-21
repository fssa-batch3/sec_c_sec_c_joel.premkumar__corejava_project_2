package com.fssa.stockmanagementapp.errors;

public final class ValidatorErrors {
	
	public static final String INVALID_NULL = "Object can't be Null";
	public static final String INVALID_NULL_NAME = "Name can't be Null or Empty";
	public static final String INVALID_NAME = "Name should match the pattern";
	public static final String INVALID_ISIN = "ISIN is not valid";
	public static final String  INVALID_DESC= "Description is invalid";
	public static final String INVALID_PRICE = "price is not valid";
	public static final String INVALID_ID = "Id is not valid";
	public static final String  INVALID_DATE_NULL= "Date can't be null";
	public static final String  INVALID_DATE= "Invalid  date";
	public static final String INVALID_TIME_NULL = "Time can't be null";
	public static final String INVALID_TIME = "Invalid time";
	public static final String INVALID_USERNAME_NULL = "Username can't be Null";
	public static final String INVALID_USERNAME = "Name Should match the patter";
	public static final String INVALID_EMAIL_NULL = "Email can't be Null";
	public static final String INVALID_EMAIL_PATTERN = "Email Should Match the Pattern";
    public static final String INVALID_PHONE_LENGTH = "Phone number must be 10 Numbers";
    public static final String INVALID_PASSWORD_NULL = "Password can't be Null or Empty";
    public static final String INVALID_PASSWORD_PATTERN = "Password Should Match The Pattern";
	public static final String INVALID_USER_ID = "UserId Can't be Null or Empty";
	public static final String INVALID_STOCK_NAME = "Stock Name Can't be Null or Empty";
	public static final String INVALID_QUANTITY = "Stock Quantity Can't be Empty";
	public static final String INVALID_INR = "Stock INR Price Can't be Empty";
	public static final String INVALID_USD = "Stock USD Price Can't be Empty";
	public static final String INVALID_PURCHASED_DATE = "Stock Purchased Date Should be there";
	private ValidatorErrors(){


	}

}
