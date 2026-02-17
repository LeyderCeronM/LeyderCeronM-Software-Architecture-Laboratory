package com.fernandomulato.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

public class uTestDatabaseConnection {

  @Test
    void testShouldConnectToDatabase() throws Exception {
        Connection conn = clsDatabaseConnection.connect();
        assertNotNull(conn);
        conn.close();
    }
}
