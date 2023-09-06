package com.fssa.stockmangementapp.service;

import java.util.List;

import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import com.fssa.stockmanagementapp.exception.StockDAOException;
import com.fssa.stockmanagementapp.util.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.stockmanagementapp.service.StockService;
import com.fssa.stockmanagementapp.model.Stock;

 class TestStockmanagement {

	StockService service = new StockService();

	Logger logger = new Logger();

	public Stock getStock() {
		Stock stock = new Stock("GDPL", "US-65776985-0", "MediaTek Dimensity  Stock", 8800.0);

		return stock;
	}  

	@Test
	void testAddStock() throws InvalidStockDataException, StockDAOException {

		Assertions.assertTrue(service.addStock(getStock()));
		logger.info("Stock Added Successfully.");
	}

	@Test
	void testReadAll() throws StockDAOException {

		List<Stock> list = service.readAllStocks();

		Assertions.assertFalse(list.isEmpty());

		for (Stock ele : list) {

			logger.info(ele);
		}
	}

	@Test
	void testReadByName() throws StockDAOException, InvalidStockDataException {

		Stock stock = service.readByName("TSLA");
		Assertions.assertNotNull(stock);
		logger.info(stock);

	}

	@Test
	void testDeleteStock() throws StockDAOException {

		Assertions.assertTrue(service.deleteStock(32));
	}

	@Test
	void testUpdateStock() throws StockDAOException, InvalidStockDataException {

		Assertions.assertTrue(service.updateStock(2, "AAPL", "US0378731005", 198.87, "Apple Inc. is a technology company that designs and manufactures consumer electronics and software. They are most well known for the iPhone, iPad, and Mac computers."));
	}

}
