package com.fernandomulato.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fernandomulato.model.ClsUser;
import com.fernandomulato.repository.IDatabaseConnection;
import com.fernandomulato.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClsSQLiteUserRepository implements IUserRepository {
  private final IDatabaseConnection databaseConnection;

  @Override
  public ClsUser opSave(ClsUser prmUser) {
    String sql = """
        INSERT INTO TBL_USER(user_username, user_email, user_password, user_role, user_profession)
        VALUES (?, ?, ?, ?, ?)
        """;

    try (Connection conn = databaseConnection.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

      pstmt.setString(1, prmUser.getAttUsername());
      pstmt.setString(2, prmUser.getAttEmail());
      pstmt.setString(3, prmUser.getAttPassword());
      pstmt.setString(4, prmUser.getAttRole());
      pstmt.setString(5, prmUser.getAttProfession());

      int rowsAffected = pstmt.executeUpdate();

      if (rowsAffected > 0) {
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
          prmUser.setAttId(rs.getLong(1));
        }
        return prmUser;
      }

      return null;

    } catch (SQLException e) {
      throw new RuntimeException("Error saving user", e);
    }
  }

  @Override
  public boolean opDelete(long prmId) {

    String sql = "DELETE FROM TBL_USER WHERE user_id = ?";

    try (Connection conn = databaseConnection.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

      pstmt.setLong(1, prmId);

      int rowsAffected = pstmt.executeUpdate();

      return rowsAffected > 0;

    } catch (SQLException e) {
      throw new RuntimeException("Error deleting user", e);
    }
  }

  @Override
  public boolean opUpdate(ClsUser prmUser) {

    String sql = """
        UPDATE TBL_USER
        SET user_username = ?,
            user_email = ?,
            user_password = ?,
            user_role = ?,
            user_profession = ?
        WHERE user_id = ?
        """;

    try (Connection conn = databaseConnection.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

      pstmt.setString(1, prmUser.getAttUsername());
      pstmt.setString(2, prmUser.getAttEmail());
      pstmt.setString(3, prmUser.getAttPassword());
      pstmt.setString(4, prmUser.getAttRole());
      pstmt.setString(5, prmUser.getAttProfession());
      pstmt.setLong(6, prmUser.getAttId());

      int rowsAffected = pstmt.executeUpdate();

      return rowsAffected > 0;

    } catch (SQLException e) {
      throw new RuntimeException("Error updating user", e);
    }
  }

  @Override
  public ClsUser opGet(long prmId) {

    String sql = "SELECT * FROM TBL_USER WHERE user_id = ?";

    try (Connection conn = databaseConnection.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

      pstmt.setLong(1, prmId);

      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        return new ClsUser(
            rs.getLong("user_id"),
            rs.getString("user_username"),
            rs.getString("user_email"),
            rs.getString("user_password"),
            rs.getString("user_role"),
            rs.getString("user_profession"));
      }

      return null;

    } catch (SQLException e) {
      throw new RuntimeException("Error getting user", e);
    }
  }
}
