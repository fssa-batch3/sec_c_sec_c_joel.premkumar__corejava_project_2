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

public class StockDao {

	Logger logger = new Logger();

	public boolean addStock(Stock stock) throws StockDAOException {

		final String query = "INSERT INTO stock (stockName ,isin,descrip,price,expire_date_time) VALUES(? , ? , ?, ?, ?)";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				LocalDateTime now = LocalDateTime.now();
				LocalDateTime expireDateTime = now.plusYears(2);

				pst.setString(1, stock.getName());
				pst.setString(2, stock.getIsin());
				pst.setString(3, stock.getDescription());
				pst.setDouble(4, stock.getPrice());
				pst.setTimestamp(5, java.sql.Timestamp.valueOf(expireDateTime));

				int row = pst.executeUpdate();
				return row > 0;

			}

		} catch (SQLException e) {

			throw new StockDAOException(StockDAOErrors.INSERT_ERROR + " " + e.getMessage());
		}

	}

	public boolean updateStock(int id, String name, String isin, double price, String desc) throws StockDAOException {

		String query = "UPDATE stock SET stockName = ?, isin= ?, price = ? , descrip = ? WHERE id = ?";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, name);
				pst.setString(2, isin);
				pst.setDouble(3, price);
				pst.setString(4, desc);
				pst.setInt(5, id);
				int row = pst.executeUpdate();
				logger.info("Stock Updated Successfully");
				return row > 0;

			}
		} catch (SQLException e) {

			throw new StockDAOException(StockDAOErrors.UPDATE_ERROR + " " + e.getMessage());

		}
	}

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
						stock.setCreationDateTime(rs.getTimestamp("creation_date_time").toLocalDateTime());
						stock.setExpireDateTime(rs.getTimestamp("expire_date_time").toLocalDateTime());

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
						stock.setExpireDateTime(rs.getTimestamp("expire_date_time").toLocalDateTime());

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
