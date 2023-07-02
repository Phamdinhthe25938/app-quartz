package com.example.application_quartz_ex.config;
import com.example.application_quartz_ex.job.CsvProcessingJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfigApp {
    @Bean
    public JobDetail csvProcessingJobDetail() {
        return JobBuilder.newJob(CsvProcessingJob.class)
                .withIdentity("csvProcessingJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger csvProcessingJobTrigger() {
//        // time run is 10s per
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(10)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(csvProcessingJobDetail())
                .withIdentity("csvProcessingJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();

    }
}
