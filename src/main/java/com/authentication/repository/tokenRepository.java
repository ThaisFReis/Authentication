package com.authentication.repository;

import com.authentication.database.db;
import com.authentication.model.tokenModel;
import com.authentication.model.userModel;

import java.sql.*;

public class tokenRepository {
    public static void createToken(tokenModel token, userModel user) throws Exception {
        Connection conn = db.getConnection();
        String sql = "INSERT INTO tokens (token, user_id, created_at) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, token.getToken());
        stmt.setInt(2, user.getId());
        stmt.setTimestamp(3, Timestamp.valueOf(token.getCreatedAt()));
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static tokenModel getTokenByUserId(int id) throws Exception {
        Connection conn = db.getConnection();
        String sql = "SELECT * FROM tokens WHERE user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            tokenModel token = new tokenModel();
            token.setId(result.getInt("id"));
            token.setToken(result.getString("token"));
            token.setCreatedAt(result.getTimestamp("created_at").toLocalDateTime());
            return token;
        }
        return null;
    }

    public static void deleteToken(int id) throws Exception {
        Connection conn = db.getConnection();
        String sql = "DELETE FROM tokens WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        conn.close();
    }

    public static tokenModel getTokenByToken(String token) throws Exception {
        Connection conn = db.getConnection();
        String sql = "SELECT * FROM tokens WHERE token = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, token);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            tokenModel newToken = new tokenModel();
            newToken.setId(result.getInt("id"));
            newToken.setToken(result.getString("token"));
            newToken.setCreatedAt(result.getTimestamp("created_at").toLocalDateTime());
            return newToken;
        }
        return null;
    }
}
