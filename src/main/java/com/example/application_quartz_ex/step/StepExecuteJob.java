package com.example.application_quartz_ex.step;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.stereotype.Repository;

@Repository("StepExecuteJob")
public interface StepExecuteJob {
  Scheduler schedule() throws Exception;
  Trigger trigger() throws Exception;
  JobDetail jobDetail() throws Exception;
}