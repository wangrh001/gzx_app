package com.bangnd.batch.framework;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class JobInvokerController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job testJob;

    //每20秒执行一次
    @Scheduled(cron = "0 0/20 *  * * * ")
    public void handle() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(testJob, jobParameters);
    }
}