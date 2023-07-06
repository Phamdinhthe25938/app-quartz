package com.example.application_quartz_ex.step;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Repository;

@Repository("StepExecuteJob")
public interface StepExecuteJob extends RunJob{
  Scheduler schedule() throws Exception;
  Trigger trigger() throws Exception;
  JobDetail jobDetail() throws Exception;
}
