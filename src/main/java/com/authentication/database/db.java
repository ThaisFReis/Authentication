package com.authentication.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    public static void main(String[] args) {
       try{
           // Conecta ao banco de dados
           String url = "jdbc:postgresql://localhost:5432/authentication";
           String user = "postgres";
           String password = "123";
           Connection conn = DriverManager.getConnection(url, user, password);
           System.out.println("Conectado ao banco de dados!");
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }

    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/authentication";
            String user = "postgres";
            String password = "123";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}