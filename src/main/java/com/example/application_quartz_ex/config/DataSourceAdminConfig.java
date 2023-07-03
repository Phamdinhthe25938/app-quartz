package com.example.application_quartz_ex.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "datasourceadmin")
public class DataSourceAdminConfig {

  @Value("${datasourceadmin.url}")
  private String url;

  @Value("${datasourceadmin.username}")
  private String username;

  @Value("${datasourceadmin.password}")
  private String password;

  @Bean(name = "dataSourceAdmin")
  public DataSource dataSourceAdmin() {
    return DataSourceBuilder.create()
        .url(url)
        .username(username)
        .password(password)
        .driverClassName("com.mysql.cj.jdbc.Driver")
        .build();
  }
}
