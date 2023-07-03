package com.example.application_quartz_ex.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public class MutilDataSourceService {


  @Resource(name = "dataSourceUser")
  private DataSource dataSourceUser;

  @Resource(name = "dataSourceAdmin")
  private DataSource dataSourceAdmin;


  public void searchUser(String name) throws SQLException {
    String query = "SELECT id, name FROM user WHERE name = ?";
    long id ;
    String nameUser ;
    try (Connection connection = dataSourceUser.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, name);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          id = resultSet.getLong("id");
          nameUser = resultSet.getString("name");
          System.out.println("Data user : id = " + id + ", name = " + nameUser);
        }
      }
    }
  }
  public void searchAdmin(String name) throws SQLException {
    String query = "SELECT id, name FROM admin WHERE name = ?";
    Long id ;
    String nameAdmin ;
    try (Connection connection = dataSourceAdmin.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, name);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          id = resultSet.getLong("id");
          nameAdmin = resultSet.getString("name");
          System.out.println("Data user : id = " + id + ", name = " + nameAdmin);
        }
      }
    }
  }
}
