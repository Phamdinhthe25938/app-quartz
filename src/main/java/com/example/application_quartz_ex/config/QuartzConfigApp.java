//package com.example.application_quartz_ex.config;
//
//import com.example.application_quartz_ex.job.CsvProcessingJob;
//import com.example.application_quartz_ex.utils.JobConstant;
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfigApp {
//    @Bean
//    public JobDetail csvProcessingJobDetail() {
//        return JobBuilder.newJob(CsvProcessingJob.class)
//                .withIdentity(JobConstant.Name.NAME_JOB_EXECUTE_FILE_CSV)
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger csvProcessingJobTrigger() {
////        // time run is 10s per
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
//                .simpleSchedule()
//                .withIntervalInSeconds(10)
//                .repeatForever();
//
//        return TriggerBuilder.newTrigger()
//                .forJob(csvProcessingJobDetail())
//                .withIdentity(JobConstant.Trigger.TRIGGER_JOB_EXECUTE_FILE_CSV)
//                .withSchedule(scheduleBuilder)
//                .build();
//
//    }
//}
