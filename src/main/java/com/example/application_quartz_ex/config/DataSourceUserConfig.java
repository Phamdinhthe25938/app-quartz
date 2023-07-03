package com.example.application_quartz_ex.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "datasourceuser")
public class DataSourceUserConfig {

  @Value("${datasourceuser.url}")
  private String url;

  @Value("${datasourceuser.username}")
  private String username;

  @Value("${datasourceuser.password}")
  private String password;

  @Bean(name = "dataSourceUser")
  public DataSource dataSourceUser() {
    return DataSourceBuilder.create()
        .url(url)
        .username(username)
        .password(password)
        .driverClassName("com.mysql.cj.jdbc.Driver")
        .build();
  }
}
