package com.fssa.stockmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.stockmanagementapp.errors.StockDAOErrors;
import com.fssa.stockmanagementapp.exception.StockDAOException;
import com.fssa.stockmanagementapp.model.Stock;
import com.fssa.stockmanagementapp.util.ConnectionUtil;
import com.fssa.stockmanagementapp.util.Logger;

public class StockDao {

    Logger logger = new Logger();

    public boolean addStock(Stock stock) throws StockDAOException {

        final String query = "INSERT INTO stock (stockName ,isin,descrip,price,createDate,expireDate,createTime,expriedTime) VALUES(? , ? , ?, ?, ?,?,?,?)";

        try (Connection con = ConnectionUtil.getConnection()) {

            try (PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, stock.getName());
                pst.setString(2, stock.getIsin());
                pst.setString(3, stock.getDescription());
                pst.setDouble(4, stock.getPrice());
                pst.setDate(5, java.sql.Date.valueOf(stock.getCreateDate()));
                pst.setDate(6, java.sql.Date.valueOf(stock.getExpireDate()));
                pst.setTime(7, java.sql.Time.valueOf(stock.getCreatedTime()));
                pst.setTime(8, java.sql.Time.valueOf(stock.getExpireTime()));

                int row = pst.executeUpdate();
                logger.info("Stock Added Successfully.");
                return (row > 0) ? true : false;

            }

        } catch (SQLException e) {

            throw new StockDAOException(StockDAOErrors.INSERT_ERROR + " " + e.getMessage());
        }


    }

    public boolean updateStock(String name, String isin, double price) throws StockDAOException {

        String query = "UPDATE stock SET  isin= ?, price = ? WHERE stockName = ?;";
        try (Connection con = ConnectionUtil.getConnection()) {

            try (PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, isin);
                pst.setDouble(2, price);
                pst.setString(3, name);

                int row = pst.executeUpdate();
                logger.info("Stock Updated Successfully");
                return (row > 0) ? true : false;

            }
        } catch (SQLException e) {

            throw new StockDAOException(StockDAOErrors.UPDATE_ERROR + " " + e.getMessage());

        }
    }

    public boolean deleteStock(int id) throws StockDAOException {

        String query = "DELETE FROM stock WHERE id = ?";
        int rows;
        try (Connection con = ConnectionUtil.getConnection()) {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);
            rows = pst.executeUpdate();

            if (rows == 0) {
                throw new StockDAOException(StockDAOErrors.DELETE_ERROR);
            }
        } catch (SQLException e) {

            throw new StockDAOException(StockDAOErrors.DELETE_ERROR);
        }

        logger.info("Stock Deleted Successfully.");
        return (rows > 0) ? true : false;
    }

    public List<Stock> readAllStock() throws StockDAOException {

        List<Stock> stockList = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM stock";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery(query)) {
                    while (rs.next()) {

                        Stock stock = new Stock();
                        stock.setId(rs.getInt("id"));
                        stock.setName(rs.getString("stockName"));
                        stock.setIsin(rs.getString("isin"));
                        stock.setDescription(rs.getString("descrip"));
                        stock.setPrice(rs.getDouble("price"));
                        stock.setCreateDate(rs.getDate("createDate").toLocalDate());
                        stock.setCreatedTime(rs.getTime("createTime").toLocalTime());
                        stock.setExpireDate(rs.getDate("expireDate").toLocalDate());
                        stock.setExpireTime(rs.getTime("expriedTime").toLocalTime());
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

    public Stock findStockByName(String name) throws StockDAOException {

        Stock stock = null;
        String query = "SELECT * FROM stock WHERE stockName = ?";
        try (Connection con = ConnectionUtil.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, name);

                try (ResultSet result = pst.executeQuery()) {
                    while (result.next()) {

                        stock = new Stock();

                        stock.setName(result.getString("stockName"));
                        stock.setIsin(result.getString("isin"));
                        stock.setDescription(result.getString("descrip"));
                        stock.setPrice(result.getDouble("price"));
                        stock.setCreateDate(result.getDate("createDate").toLocalDate());
                        stock.setCreatedTime(result.getTime("createTime").toLocalTime());
                        stock.setExpireDate(result.getDate("expireDate").toLocalDate());
                        stock.setExpireTime(result.getTime("expriedTime").toLocalTime());
                        stock.setIsin(result.getString("isin"));
                        stock.setPrice(result.getDouble("price"));

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
