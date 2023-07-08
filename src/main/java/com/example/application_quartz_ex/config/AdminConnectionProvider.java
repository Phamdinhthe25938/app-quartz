package com.example.application_quartz_ex.config;

import org.quartz.utils.ConnectionProvider;
import org.springframework.boot.jdbc.DataSourceBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminConnectionProvider implements ConnectionProvider {

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
      connection.commit();
    }
  }

  @Override
  public void initialize() throws SQLException {
    url = System.getenv("url");
    username = System.getenv("user");
    password = System.getenv("password");
    connection = DataSourceBuilder.create()
            .url(url)
            .username(username)
            .password(password)
            .driverClassName(System.getenv("driver"))
            .build().getConnection();
  }
}
