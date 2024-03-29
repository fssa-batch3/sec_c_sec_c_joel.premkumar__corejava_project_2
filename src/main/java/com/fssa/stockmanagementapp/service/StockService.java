package com.fssa.stockmanagementapp.service;

import java.util.List;

import com.fssa.stockmanagementapp.dao.StockDao;
import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import com.fssa.stockmanagementapp.exception.StockDAOException;
import com.fssa.stockmanagementapp.model.Stock;
import com.fssa.stockmanagementapp.validator.StockValidator;

public class StockService {

	StockValidator stockValidator = new StockValidator();
	StockDao dao = new StockDao();

	public boolean addStock(Stock stock) throws InvalidStockDataException, StockDAOException {

		if (stockValidator.validate(stock)) {

			return dao.addStock(stock);
		}
		return false;
	}

	public boolean updateStock(Stock stock,int id)
			throws InvalidStockDataException, StockDAOException {


			return dao.updateStock(stock,id);

			
		}

	public Stock readByName(String name) throws InvalidStockDataException, StockDAOException {

		Stock stock = null;

		if (stockValidator.validateName(name)) {

			stock = dao.findStockByName(name);
		}

		return stock;
	}

	public List<Stock> readAllStocks(int userId) throws StockDAOException {

		return dao.readAllStock(userId);

	}

	public boolean deleteStock(int id) throws StockDAOException {

		return dao.deleteStock(id);

	}
}