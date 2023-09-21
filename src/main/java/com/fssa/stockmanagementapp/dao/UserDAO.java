package com.fssa.stockmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.stockmanagementapp.exception.UserDAOException;
import com.fssa.stockmanagementapp.model.User;
import com.fssa.stockmanagementapp.util.ConnectionUtil;

public class UserDAO {

	public static void addUser(User user) throws UserDAOException {
		String sql = "INSERT INTO users (user_name, email, phone_number, password) VALUES (?, ?, ?, ?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, user.getFullName());
			statement.setString(2, user.getEmailId());
			statement.setLong(3, user.getPhoneNumber());
			statement.setString(4, user.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new UserDAOException("Error adding user", e);
		}
	}

	public static void updateUser(User user) throws UserDAOException {
		String sql = "UPDATE users SET user_name = ?, email = ?, phone_number = ?, password = ? WHERE user_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, user.getFullName());
			statement.setString(2, user.getEmailId());
			statement.setLong(3, user.getPhoneNumber());
			statement.setString(4, user.getPassword());
			statement.setInt(5, user.getUser_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new UserDAOException("Error updating user", e);
		}
	}

	public static void deleteUser(int user_id) throws UserDAOException {
		String sql = "DELETE FROM users WHERE user_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, user_id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new UserDAOException("Error deleting user", e);
		}
	}

	public static List<User> getAllUsers() throws UserDAOException {
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				int user_id = resultSet.getInt("user_id");
				String user_name = resultSet.getString("user_name");
				String email = resultSet.getString("email");
				Long phone_number = resultSet.getLong("phone_number");
				String password = resultSet.getString("password");
				User user = new User(user_id, user_name, email, phone_number, password);
				users.add(user);
			}
		} catch (SQLException e) {
			throw new UserDAOException("Error retrieving users", e);
		}
		return users;
	}

	public static User getUserByEmail(String email) throws UserDAOException {
		String sql = "SELECT * FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, email);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int user_id = resultSet.getInt("user_id");
					String user_name = resultSet.getString("user_name");
					String userEmail = resultSet.getString("email");
					Long phone_number = resultSet.getLong("phone_number");
					String password = resultSet.getString("password");
					return new User(user_id, user_name, userEmail, phone_number, password);
				}
			}
		} catch (SQLException e) {
			throw new UserDAOException("Error getting user by email", e);
		}
		return null;
	}

	public static boolean logInCustomer(String email, String password) throws UserDAOException {
		final String query = "SELECT email,password FROM users WHERE email = ? ";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, email);
				System.out.println(email);
				System.out.println(password);
				System.out.println(pst);
				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) { // && rs.getString("email").equals(email)
						// && rs.getString("password").equals(password))
						System.out.println("true");
						return true;
					}

				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new UserDAOException("login fail");
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println(logInCustomer("aakash@gmail.com", "Aakash@123"));
	}
}
