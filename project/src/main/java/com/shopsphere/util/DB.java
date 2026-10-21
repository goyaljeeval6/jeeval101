package com.shopsphere.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public final class DB {
  private static final String URL = System.getenv().getOrDefault("SHOPSPHERE_DB_URL", "jdbc:mysql://localhost:3306/shopsphere?useSSL=false&serverTimezone=UTC");
  private static final String USER = System.getenv().getOrDefault("SHOPSPHERE_DB_USER", "root");
  private static final String PASS = System.getenv().getOrDefault("SHOPSPHERE_DB_PASSWORD", "change_me");
  private DB() {}
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASS);
  }
}
