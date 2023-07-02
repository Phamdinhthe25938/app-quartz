package com.example.application_quartz_ex.service;

import com.example.application_quartz_ex.job.CsvProcessingJob;
import com.example.application_quartz_ex.job.DataMapJob;
import com.example.application_quartz_ex.utils.JobConstant;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuartzService {

    @Resource
    private Scheduler scheduler;

    @Resource
    private CsvProcessingJob csvProcessingJob;

    @Resource
    private DataMapJob dataMapJob;

    private final static Logger LOGGER = LoggerFactory.getLogger(QuartzService.class);

    public void runJob() {
        try {
            LOGGER.info("Start job execute file csv ");
//            scheduler.triggerJob(JobKey.jobKey(JobConstant.Name.NAME_JOB_EXECUTE_FILE_CSV));
            csvProcessingJob.runJobProcessFileCsv();
            LOGGER.info("Start job execute data map ");
//            scheduler.triggerJob(JobKey.jobKey(JobConstant.Name.NAME_JOB_EXECUTE_DATA_MAP));
            dataMapJob.runJobDataMap();
        } catch (Exception e) {
            LOGGER.error("Exception trigger job by key {} {}", e, e.getMessage());
        }
    }
}
