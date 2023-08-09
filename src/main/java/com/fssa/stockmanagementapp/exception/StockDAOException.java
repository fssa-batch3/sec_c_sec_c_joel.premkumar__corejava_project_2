package com.fssa.stockmanagementapp.exception;

import java.io.Serial;

public class StockDAOException extends  Exception {

    @Serial
    private static final long serialVersionUID = -8105491977357554060L;

    // Calling each super constructor for each of the types
    public StockDAOException(String msg) {
        super(msg);
    }

    public StockDAOException(Throwable te) {
        super(te);
    }

    public StockDAOException(String msg, Throwable te) {
        super(msg, te);
    }
}
