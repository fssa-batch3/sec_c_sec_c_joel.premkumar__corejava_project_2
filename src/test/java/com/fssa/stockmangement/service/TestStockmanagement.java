package com.fssa.stockmangement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.stockmanagement.dao.StockDao;
import com.fssa.stockmanagement.service.StockService;
import com.fssa.stockmanagementapp.model.Stock;
import com.fssa.stockmanagementapp.validator.StockValidator;

public class TestStockmanagement {

//	@Test
//	public void testValidService() throws Exception  {
//
//		StockService StockService = getStockService();
//		
//		Stock stock= getStock();
//		
//		Assertions.assertTrue(StockService.addStock(stock));
//
//	} 
//	@Test
//	public static Stock getStock() {
//		Stock stock= new Stock(4, "apple", "US-000402625-0", "the stock is good", 30.0, LocalDate.now(),
//				LocalTime.now(), LocalDate.now(), LocalTime.now());
//		
//		return stock;
//	}
//	@Test
//	public static StockService getStockService() {
//
//		StockValidator stockValidator = new StockValidator();
//
//		StockDao stockDao = new StockDao();
//
//
//		return stockService;
//
//	}

	Stock st = new Stock(5, "zoho", "US-000402625-0", "the stock is good", 30000.0, LocalDate.now(), LocalTime.now(),
			LocalDate.now(), LocalTime.now());

	@Test
	public void addStock() throws Exception{
		
		
		StockService.addStock(st);
	}
	@Test
	public void updateStock() throws Exception {

		StockService.updateStock("apple", "US-000402625-0", 1400.0);
	}

	@Test
	public void deleteStock() throws Exception {

		StockService.deleteStock("zoho");
	}
}
