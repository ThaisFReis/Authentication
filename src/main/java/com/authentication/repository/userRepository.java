package com.authentication.repository;

import com.authentication.database.db;
import com.authentication.model.userModel;

import java.sql.*;


public class userRepository {
    public static void createUser(userModel user) throws SQLException {
        try (Connection conn = db.getConnection()) {
            String query = "INSERT INTO users (email, name, password) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        }
    }

    public static userModel getUserByEmail(String email) throws SQLException {
        try (Connection conn = db.getConnection()) {
            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                userModel user = new userModel();
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
                return user;
            }
        }
        return null;
    }

    public static userModel updateUser(userModel user) throws SQLException {
        try (Connection conn = db.getConnection()) {
            String query = "UPDATE users SET email = ?, name = ?, password = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
            return user;
        }
    }

    public static void deleteUser(int id) throws SQLException {
        try (Connection conn = db.getConnection()) {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static userModel getAllUsers() {
        try (Connection conn = db.getConnection()) {
            String query = "SELECT * FROM users";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            userModel user = new userModel();
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static userModel getUserById(int id) {
        try (Connection conn = db.getConnection()) {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            userModel user = new userModel();
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}