package com.fernandomulato.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class clsDatabaseConnection {
  private static final String URL = "jdbc:sqlite:database.db";

  public static Connection connect() throws SQLException {

    return DriverManager.getConnection(URL);
  }
}
