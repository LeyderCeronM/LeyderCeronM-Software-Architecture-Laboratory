package com.fernandomulato.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fernandomulato.repository.IDatabaseConnection;

public class ClsSQLiteConnection implements IDatabaseConnection {
  private static final String URL = "jdbc:sqlite:database.db";

  public ClsSQLiteConnection() {}
  
  @Override
  public Connection connect() throws SQLException {
    return DriverManager.getConnection(URL);
  }
}
