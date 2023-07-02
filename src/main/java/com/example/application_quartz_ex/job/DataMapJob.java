package com.example.application_quartz_ex.job;

import com.example.application_quartz_ex.utils.JobConstant;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DataMapJob implements Job {

    @Resource
    private Scheduler scheduler;

    private final static Logger LOGGER = LoggerFactory.getLogger(DataMapJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String message = jobDataMap.getString("message");

        LOGGER.info("Data message when job data map run :" + message);
    }

    public void runJobDataMap() throws SchedulerException {
        // create job detail
        JobDetail jobDetail = JobBuilder.newJob(DataMapJob.class)
                .withIdentity(JobConstant.Name.NAME_JOB_EXECUTE_DATA_MAP)
                .build();

        JobDataMap jobDataMap = jobDetail.getJobDataMap();

        jobDataMap.put("message", "Hi you ! Nice to meet you !");

        // create trigger to run with time is time now
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(JobConstant.Trigger.TRIGGER_JOB_EXECUTE_DATA_MAP)
                .startNow()
                .build();

        // registry job and trigger with scheduler
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
