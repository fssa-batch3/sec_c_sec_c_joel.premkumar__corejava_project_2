package com.fssa.stockmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fssa.stockmanagementapp.errors.StockDAOErrors;
import com.fssa.stockmanagementapp.exception.StockDAOException;
import com.fssa.stockmanagementapp.model.Stock;
import com.fssa.stockmanagementapp.util.ConnectionUtil;
import com.fssa.stockmanagementapp.util.Logger;

/**
 * The StockDao class handles database operations related to stocks.
 */
public class StockDao {

    private Logger logger = new Logger();

    /**
     * Adds a new stock to the database.
     *
     * @param stock The stock object to be added.
     * @return True if the stock was added successfully, otherwise false.
     * @throws StockDAOException If there was an error during the database operation.
     */
    public boolean addStock(Stock stock) throws StockDAOException {

        final String query = "INSERT INTO stock (stockName ,isin,descrip,price,user_id) VALUES(? , ? , ?, ?, ?)";

        try (Connection con = ConnectionUtil.getConnection()) {

            try (PreparedStatement pst = con.prepareStatement(query)) {

                LocalDateTime now = LocalDateTime.now();
                LocalDateTime expireDateTime = now.plusYears(2);

                pst.setString(1, stock.getName());
                pst.setString(2, stock.getIsin());
                pst.setString(3, stock.getDescription());
                pst.setDouble(4, stock.getPrice());
                 pst.setInt(5, stock.getUserId());

                int row = pst.executeUpdate();
                return row > 0;

            }

        } catch (SQLException e) {

            throw new StockDAOException(StockDAOErrors.INSERT_ERROR + " " + e.getMessage());
        }

    }

    /**
     * Updates an existing stock in the database.
     *
     * @param id    The ID of the stock to be updated.
     * @param name  The new name of the stock.
     * @param isin  The new ISIN of the stock.
     * @param price The new price of the stock.
     * @param desc  The new description of the stock.
     * @return True if the stock was updated successfully, otherwise false.
     * @throws StockDAOException If there was an error during the database operation.
     */
    public boolean updateStock(Stock stock,int id) throws StockDAOException {

        String query = "UPDATE stock SET stockName = ?, isin= ?, price = ? , descrip = ? WHERE id = ?";
        try (Connection con = ConnectionUtil.getConnection()) {

            try (PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, stock.getName());
                pst.setString(2, stock.getIsin());
                pst.setDouble(3, stock.getPrice());
                pst.setString(4, stock.getDescription());
                pst.setInt(5, id);
                int row = pst.executeUpdate();
                logger.info("Stock Updated Successfully");
                return row > 0;

            }
        } catch (SQLException e) {

            throw new StockDAOException(StockDAOErrors.UPDATE_ERROR + " " + e.getMessage());

        }
    }

    /**
     * Deletes a stock from the database by its ID.
     *
     * @param id The ID of the stock to be deleted.
     * @return True if the stock was deleted successfully, otherwise false.
     * @throws StockDAOException If there was an error during the database operation.
     */
    public boolean deleteStock(int id) throws StockDAOException {

        String query = "DELETE FROM stock WHERE id = ?";
        int rows;
        try (Connection con = ConnectionUtil.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(query)) {

                pst.setInt(1, id);
                rows = pst.executeUpdate();

                if (rows == 0) {
                    throw new StockDAOException(StockDAOErrors.DELETE_ERROR);
                }
            }
        } catch (SQLException e) {

            throw new StockDAOException(StockDAOErrors.DELETE_ERROR);
        }

        logger.info("Stock Deleted Successfully.");
        return rows > 0;
    }

    /**
     * Retrieves a list of all stocks from the database.
     *
     * @return A list of Stock objects representing all stocks in the database.
     * @throws StockDAOException If there was an error during the database operation.
     */
    public List<Stock> readAllStock(int userId) throws StockDAOException {
    	

        List<Stock> stockList = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {
        	String query = "SELECT id, user_id, stockName, isin, descrip, price, creation_date_time FROM stock WHERE user_id = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {	
            	pst.setInt(1,userId);
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {

                        Stock stock = new Stock();
                        stock.setId(rs.getInt("id"));
                        stock.setName(rs.getString("stockName"));
                        stock.setIsin(rs.getString("isin"));
                        stock.setDescription(rs.getString("descrip"));
                        stock.setPrice(rs.getDouble("price"));
                        stock.setCreationDateTime(rs.getTimestamp("creation_date_time").toLocalDateTime());
                        stock.setUserId(rs.getInt("user_id"));
                        
                        stockList.add(stock);

                    }
                }
            }
        } catch (SQLException e) {
            throw new StockDAOException(StockDAOErrors.READ_ERROR + " " + e.getMessage());

        }

        logger.info("All stocks read successfully.");
        return stockList;
    }

    /**
     * Finds a stock by its name in the database.
     *
     * @param name The name of the stock to search for.
     * @return The Stock object if found, otherwise an empty Stock object.
     * @throws StockDAOException If there was an error during the database operation.
     */
    public Stock findStockByName(String name) throws StockDAOException {

        Stock stock = new Stock();
        String query = "SELECT * FROM stock WHERE stockName = ?";
        try (Connection con = ConnectionUtil.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, name);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {

                        stock.setId(rs.getInt("id"));
                        stock.setName(rs.getString("stockName"));
                        stock.setIsin(rs.getString("isin"));
                        stock.setDescription(rs.getString("descrip"));
                        stock.setPrice(rs.getDouble("price"));
                        stock.setCreationDateTime(rs.getTimestamp("creation_date_time").toLocalDateTime());
                      

                        return stock;

                    }
                }

            }

        } catch (SQLException e) {

            throw new StockDAOException(StockDAOErrors.READ_BY_NAME_ERROR + " " + e.getMessage());
        }

        logger.info("Stock read by name successfully.");
        return stock;

    }

}
