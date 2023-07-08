package com.example.application_quartz_ex.job;

import com.example.application_quartz_ex.job_detail.AdminJobDetail;
import com.example.application_quartz_ex.step.RunJob;
import com.example.application_quartz_ex.step.StepExecuteJob;
import com.example.application_quartz_ex.utils.JobConstant;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

@Component("AdminExecuteJob")
public class AdminExecuteJob implements StepExecuteJob {
    @Override
    public Scheduler schedule() throws Exception {
        Properties properties = new Properties();
        // load config schedule
        FileInputStream fis = new FileInputStream("src/main/resources/admin_config/JobAdmin.properties");
        properties.load(fis);
        SchedulerFactory schedulerFactory = new StdSchedulerFactory(properties);
        return schedulerFactory.getScheduler();
    }

    @Override
    public Trigger trigger() throws Exception {
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger-job-admin", "admin")
                .startNow()
                .build();
    }

    @Override
    public JobDetail jobDetail() throws Exception {
        JobDataMap jobDataMap = new JobDataMap(
                Map.of("name", "the", "age", 18)
        );
        return JobBuilder.newJob(AdminJobDetail.class)
                .withIdentity("admin-job", "admin")
                .withDescription("this is job execute info admin")
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
                    Map.of("name", "the", "age", 18)
            );

            JobDetail jobDetail = JobBuilder.newJob(AdminJobDetail.class)
                    .withIdentity("admin-job", "admin")
                    .withDescription("this is job execute info admin")
                    .usingJobData(jobDataMap)
                    .storeDurably()
                    .requestRecovery()
                    .build();

            schedule().scheduleJob(jobDetail, trigger());

        } catch (Exception e) {
            System.out.println("Exception when run job admin");
        }
    }
}
