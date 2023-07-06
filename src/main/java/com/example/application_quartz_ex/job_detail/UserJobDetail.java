package com.example.application_quartz_ex.job_detail;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class UserJobDetail implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

    String name = jobDataMap.getString("name");
    int age = jobDataMap.getInt("age");

    System.out.println("Info user : name is " + name + " age " + age);
  }
}
