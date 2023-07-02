package com.example.application_quartz_ex.job;

import com.example.application_quartz_ex.model.Student;
import com.example.application_quartz_ex.utils.JobConstant;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileReader;
import java.util.List;

@Component
public class CsvProcessingJob implements Job {

    @Resource
    private Scheduler scheduler;

    private final static Logger LOGGER = LoggerFactory.getLogger(CsvProcessingJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            FileReader fileReader = new FileReader("../application_quartz_ex/data_student.csv");

            CSVReader csvReader = new   CSVReader(fileReader);

            CsvToBean<Student> dataRead = new CsvToBeanBuilder<Student>(csvReader)
                    .withType(Student.class)
                    .build();

            List<Student> dataStudent = dataRead.parse();

            dataStudent.forEach(student -> {
                LOGGER.info("Student info : " + student.toString());
            });

        } catch (Exception e) {
            LOGGER.info("Exception read file  : " + e.getMessage());
        }
    }

    public void runJobProcessFileCsv() throws SchedulerException {
        // create job detail
        JobDetail jobDetail = JobBuilder.newJob(CsvProcessingJob.class)
                .withIdentity(JobConstant.Name.NAME_JOB_EXECUTE_FILE_CSV)
                .build();

        // create trigger to run with time is time now
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(JobConstant.Trigger.TRIGGER_JOB_EXECUTE_FILE_CSV)
                .startNow()
                .build();
        // registry job and trigger with scheduler
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
