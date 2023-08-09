package com.fssa.stockmanagement.service;

import java.sql.SQLException;

import com.fssa.stockmanagement.dao.StockDao;
import com.fssa.stockmanagementapp.model.Stock;
import com.fssa.stockmanagementapp.validator.StockValidator;

public class StockService {
	
	public StockValidator stockValidator;
	public StockDao stockDao;
	

	public StockService(StockValidator stockValidator, StockDao stockDao) {
		
		this.stockValidator = stockValidator;
		this.stockDao = stockDao;
	} 
	

	public static boolean addStock(Stock stock) throws Exception {

		if (StockValidator.validate(stock)) {

			boolean result = StockDao.addStock(stock);
			return result;
		}
		return false;  
	}

	public static boolean updateStock(String name, String isin, double price) throws Exception {

		if (StockValidator.validateName(name) && StockValidator.validateIsin(isin)
				&& StockValidator.validatedPrice(price)) {
 
			return StockDao.updateStock(name, isin, price);

		}
		return false;
	}

	public static boolean readStock() throws SQLException {

		return StockDao.readStock();

	}

	public static boolean deleteStock(String name) throws Exception {

		if (StockValidator.validateName(name)) {
			return StockDao.deleteStock(name);
		}
		return false;
	}
}
