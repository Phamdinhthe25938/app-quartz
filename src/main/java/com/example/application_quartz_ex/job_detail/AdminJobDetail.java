package com.example.application_quartz_ex.job_detail;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AdminJobDetail implements Job {

    Logger logger = LoggerFactory.getLogger(AdminJobDetail.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Start job detail admin job");
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        String name = jobDataMap.getString("name");
        int age = jobDataMap.getInt("age");

        logger.info("Info admin : name is " + name + " age " + age);

        try {
            jobExecutionContext.getScheduler().shutdown();
        } catch (Exception e) {
            logger.error("Exception when shutdown jon admin :" + e.getMessage());
        }
    }
}
