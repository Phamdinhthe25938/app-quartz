package com.example.application_quartz_ex.job_detail;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserJobDetail implements Job {
    Logger logger = LoggerFactory.getLogger(UserJobDetail.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.info("logger job detail user ");
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        String name = jobDataMap.getString("name");
        int age = jobDataMap.getInt("age");

        logger.info("Info user : name is " + name + " age " + age);
        try {
            jobExecutionContext.getScheduler().shutdown();
        } catch (Exception e) {
            logger.error("Exception when shutdown jon user :" + e.getMessage());
        }
    }
}
