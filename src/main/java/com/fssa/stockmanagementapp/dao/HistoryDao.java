package com.fssa.stockmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.stockmanagementapp.errors.StockDAOErrors;
import com.fssa.stockmanagementapp.exception.StockDAOException;
import com.fssa.stockmanagementapp.model.History;
import com.fssa.stockmanagementapp.util.ConnectionUtil;

public class HistoryDao {
	  public static boolean addhistory(int userId , String stockName , int quantity , double inr , double usd) throws StockDAOException {

	        final String query = "INSERT INTO history ( user_id, stock_name, quantity, inr, usd) VALUES(? , ? , ?, ?, ?)";

	        try (Connection con = ConnectionUtil.getConnection()) {

	            try (PreparedStatement pst = con.prepareStatement(query)) {

	               

	                pst.setInt(1, userId);
	                pst.setString(2, stockName);
	                pst.setInt(3, quantity);
	                pst.setDouble(4, inr);
	                pst.setDouble(5, usd);

	                int row = pst.executeUpdate();
	                return row > 0;

	            }

	        } catch (SQLException e) {

	            throw new StockDAOException(StockDAOErrors.INSERT_ERROR + " " + e.getMessage());
	        }

	    }
	  
	  public static List<History> GethistoryByUser(int userId) throws StockDAOException {
		  List<History> historyList = new ArrayList<>();
	        final String query = "SELECT * FROM history WHERE user_id = ?";

	        try (Connection con = ConnectionUtil.getConnection()) {

	            try (PreparedStatement pst = con.prepareStatement(query)) {

	               

	                pst.setInt(1, userId);
	              
	                ResultSet rs = pst.executeQuery();
	                
	                while(rs.next()){
	                	History history = new History(); 
	                	history.setStockName(rs.getString("stock_name"));
	                	history.setQuantity(rs.getInt("quantity"));
	                	history.setInr(rs.getDouble("inr"));
	                	history.setUsd(rs.getDouble("usd"));
	                	history.setPurchasedDate(rs.getTimestamp("purshased_date"));
	                	history.setUserId(userId);
	                	historyList.add(history);
	                	
		               };
		               
		               return historyList;

	            
	            }
	        } catch (SQLException e) {

	            throw new StockDAOException(StockDAOErrors.INSERT_ERROR + " " + e.getMessage());
	        }

	    }




}
