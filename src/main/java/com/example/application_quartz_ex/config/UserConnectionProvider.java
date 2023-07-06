package com.example.application_quartz_ex.config;

import org.quartz.utils.ConnectionProvider;
import org.springframework.boot.jdbc.DataSourceBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserConnectionProvider implements ConnectionProvider {

  private Connection connection;
  private String url;
  private String username;
  private String password;

  @Override
  public Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {

      connection = DriverManager.getConnection(url, username, password);
    }
    return connection;
  }

  @Override
  public void shutdown() throws SQLException {
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }
  }

  @Override
  public void initialize() throws SQLException {
    url = "jdbc:mysql://localhost:3306/quartz_database";
    username = "root";
    password = "25092002";
    connection = DataSourceBuilder.create()
        .url(url)
        .username(username)
        .password(password)
        .driverClassName("com.mysql.cj.jdbc.Driver")
        .build().getConnection();
  }
}
