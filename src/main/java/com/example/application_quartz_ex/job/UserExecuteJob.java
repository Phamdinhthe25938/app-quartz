package com.example.application_quartz_ex.job;

import com.example.application_quartz_ex.job_detail.AdminJobDetail;
import com.example.application_quartz_ex.job_detail.UserJobDetail;
import com.example.application_quartz_ex.step.RunJob;
import com.example.application_quartz_ex.step.StepExecuteJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

@Component("UserExecuteJob")
public class UserExecuteJob implements StepExecuteJob, RunJob {
  @Override
  public Scheduler schedule() throws Exception {
    Properties properties = new Properties();
    // load config schedule
    FileInputStream fis = new FileInputStream("src/main/resources/admin_config/JobUser.properties");
    properties.load(fis);
    SchedulerFactory schedulerFactory = new StdSchedulerFactory(properties);
    return schedulerFactory.getScheduler();
  }

  @Override
  public Trigger trigger() throws Exception {
    return TriggerBuilder.newTrigger()
        .withIdentity("trigger-job-user", "user")
        .modifiedByCalendar("user-calender")
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
  public void execute() {
    try {
      Scheduler scheduler = schedule();
      scheduler.scheduleJob(jobDetail(), trigger());
    } catch (Exception e) {
      System.out.println("Exception when run job user");
    }
  }
}
