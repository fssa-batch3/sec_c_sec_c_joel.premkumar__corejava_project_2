package com.fssa.stockmanagementapp.service;

import java.util.List;

import com.fssa.stockmanagementapp.dao.HistoryDao;
import com.fssa.stockmanagementapp.exception.InvalidStockDataException;
import com.fssa.stockmanagementapp.exception.StockDAOException;
import com.fssa.stockmanagementapp.model.History;


public class HistoryService {
	
	public static boolean addhistory(int userId , String stockName , int qty , double inr , double usd) throws InvalidStockDataException, StockDAOException {

	

			return HistoryDao.addhistory(userId, stockName, qty,  inr,usd);
		
	
	}
	
	public static List<History> GethistoryByUser(int userId ) throws InvalidStockDataException, StockDAOException {

		

		return HistoryDao.GethistoryByUser(userId);
	

}

}
