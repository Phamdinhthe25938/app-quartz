package com.example.application_quartz_ex.job_detail;

import org.quartz.*;
import org.springframework.stereotype.Component;

@Component
public class AdminJobDetail implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

    String name = jobDataMap.getString("name");
    int age = jobDataMap.getInt("age");

    System.out.println("Info admin : name is " + name + " age " + age);
  }
}
