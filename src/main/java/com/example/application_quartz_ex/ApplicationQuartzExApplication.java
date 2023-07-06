package com.example.application_quartz_ex;

//import com.example.application_quartz_ex.service.MutilDataSourceService;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileInputStream;
import java.util.Properties;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
@EnableScheduling
public class ApplicationQuartzExApplication {


  public static void main(String[] args) {
    SpringApplication.run(ApplicationQuartzExApplication.class, args);
  }

}
