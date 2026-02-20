package com.fernandomulato.repository;

import java.sql.Connection;
import java.sql.SQLException;


public interface IDatabaseConnection  {
  Connection connect()  throws SQLException;
}
