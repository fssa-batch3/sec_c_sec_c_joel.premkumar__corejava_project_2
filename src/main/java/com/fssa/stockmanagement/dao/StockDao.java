package com.fssa.stockmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.fssa.stockmanagementapp.model.Stock;

public class StockDao {

	public static boolean addStock(Stock stock) throws SQLException {

		final String query = "INSERT INTO stock (stockName ,isin,descrip,price,createDate,expireDate) VALUES(? , ? , ?, ?, ?,?);";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, stock.getName());
				pst.setString(2, stock.getIsin());
				pst.setString(3, stock.getDescription());

				pst.setDouble(4, stock.getPrice());

				pst.setDate(5, java.sql.Date.valueOf(stock.getCreateDate()));

				pst.setDate(6, java.sql.Date.valueOf(stock.getExpireDate()));

				int row = pst.executeUpdate();
				System.out.println("Stock Added Successfully");

				return (row > 0) ? true : false;

			}

		}
	}

	public static boolean readStock() throws SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM stock";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet rs = statement.executeQuery(query)) {
					while (rs.next()) {
						System.out.println("stockName: " + rs.getString(1));
						System.out.println("isin: " + rs.getString(2));
						System.out.println("descrip: " + rs.getString(3));
						System.out.println("price: " + rs.getDouble(4));
						System.out.println("createDate: " + rs.getDate(5));
						System.out.println("expireDate: " + rs.getDate(6));
						System.out.println("\n");

					}
					return true;
				}
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);

		}

	}

	public static boolean updateStock(String name, String isin, double price) throws SQLException {

		String query = "UPDATE stock SET  isin= ?, price = ? WHERE stock_name = ?;";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, isin);
				pst.setDouble(2, price);
				pst.setString(3, name);

				int row = pst.executeUpdate();
				System.out.println("Stock Updated Successfully");
				return (row > 0) ? true : false;

			}
		}
	}

	public static Stock findStockByName(String name) throws SQLException {

		Stock stock = null;
		String query = "SELECT * FROM stock WHERE stock_name = ?";
		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, name);

				try (ResultSet result = pst.executeQuery()) {
					while (result.next()) {
						stock = new Stock();
						stock.setId(result.getInt("id"));
						stock.setName(result.getString("stockName"));
						stock.setIsin(result.getString("isin"));
						stock.setDescription(result.getString("descrip"));
						stock.setPrice(result.getDouble("price"));
						stock.setCreateDate(result.getDate("createDate").toLocalDate());
						stock.setExpireDate(result.getDate("expireDate").toLocalDate());

						System.out.println(result.getString("isin"));
						System.out.println(result.getDouble("price"));

					}
				}

			}
			return stock;
		}

	}

	public static boolean deleteStock(String name) throws Exception {

		String query = "DELETE FROM stock WHERE stock_name = ?";
		int rows;
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, name);
			rows = pst.executeUpdate();

			if (rows == 0) {
				throw new Exception("Deleted");
			}
		}

		System.out.println("Stock Deleted Successfully");
		return (rows > 0) ? true : false;
	}

	public static boolean readStockAll(String name) throws SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM stock WHERE name = '" + name + "'";

			try (Statement st = connection.createStatement()) {

				st.addBatch(name);

				try (ResultSet rs = st.executeQuery(query)) {

					while (rs.next()) {
						System.out.println("stockName: " + rs.getString("stockName"));
						System.out.println("isin: " + rs.getString("isin"));
						System.out.println("descrip: " + rs.getString("descrip"));
						System.out.println("price: " + rs.getDouble("price"));
						System.out.println("createDate: " + rs.getDate("createDate"));
						System.out.println("expireDate: " + rs.getDate("expireDate"));
						System.out.println();

					}

				}

			}

		} catch (SQLException ex) {
			throw new SQLException(ex);

		}
		return true;

	}

	public static void main(String[] args) throws Exception {

		Stock st = new Stock(1, "ZOHO", "US-000402625-0", "the stock is good", 30.0, LocalDate.of(2003, 3, 03),
				LocalDate.of(2003, 12, 16));
//		findStockByName("Apple");
		addStock(st);

	}
}
