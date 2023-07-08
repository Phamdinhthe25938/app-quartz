package com.example.application_quartz_ex.job;

import com.example.application_quartz_ex.job_detail.AdminJobDetail;
import com.example.application_quartz_ex.job_detail.UserJobDetail;
import com.example.application_quartz_ex.step.RunJob;
import com.example.application_quartz_ex.step.StepExecuteJob;
import org.apache.commons.lang3.time.DateUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

@Component("UserExecuteJob")
public class UserExecuteJob implements StepExecuteJob {
    @Override
    public Scheduler schedule() throws Exception {
        Properties properties = new Properties();
        // load config schedule
        FileInputStream fis = new FileInputStream("src/main/resources/user_config/JobUser.properties");
        properties.load(fis);
        SchedulerFactory schedulerFactory = new StdSchedulerFactory(properties);
        return schedulerFactory.getScheduler();
    }

    @Override
    public Trigger trigger() throws Exception {
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger-job-user", "user")
                .startNow()
                .build();
    }

    @Override
    public JobDetail jobDetail() throws Exception {

        JobDataMap jobDataMap = new JobDataMap(
                Map.of("name", "nam", "age", 20)
        );

        return JobBuilder.newJob(UserJobDetail.class)
                .withIdentity("user-job", "user")
                .withDescription("this is job execute info user")
                .usingJobData(jobDataMap)
                .storeDurably()
                .requestRecovery()
                .build();
    }

    @Override
    public void run() {
        try {
            schedule().start();

            JobDataMap jobDataMap = new JobDataMap(
                    Map.of("name", "nam", "age", 20)
            );

            JobDetail jobDetail = JobBuilder.newJob(UserJobDetail.class)
                    .withIdentity("user-job", "user")
                    .withDescription("this is job execute info user")
                    .usingJobData(jobDataMap)
                    .storeDurably()
                    .requestRecovery()
                    .build();
            schedule().scheduleJob(jobDetail, trigger());

        } catch (Exception e) {
            System.out.println("Exception when run job user :" + e.getMessage());
        }
    }
}
