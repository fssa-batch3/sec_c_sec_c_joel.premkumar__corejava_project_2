package com.fssa.stockmanagementapp.exception;

import java.io.Serial;

public class InvalidStockDataException extends Exception {

    @Serial
    private static final long serialVersionUID = -8105491977357554060L;

    // Calling each super constructor for each of the types
    public InvalidStockDataException(String msg) {
        super(msg);
    }

    public InvalidStockDataException(Throwable te) {
        super(te);
    }

    public InvalidStockDataException(String msg, Throwable te) {
        super(msg, te);
    }

}
