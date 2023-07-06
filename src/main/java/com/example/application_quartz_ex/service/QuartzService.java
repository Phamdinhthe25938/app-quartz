package com.example.application_quartz_ex.service;
import com.example.application_quartz_ex.step.RunJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuartzService {

    @Resource(name = "AdminExecuteJob")
    private RunJob runJobAdmin;
    @Resource(name = "UserExecuteJob")
    private RunJob runJobUser;
    private final static Logger LOGGER = LoggerFactory.getLogger(QuartzService.class);

    public void runJob() {
        try {
            LOGGER.info("Start run job :");

            runJobAdmin.run();
            runJobUser.run();

        } catch (Exception e) {
            LOGGER.error("Exception trigger job by key {} {}", e, e.getMessage());
        }
    }
}
