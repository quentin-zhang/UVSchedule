package com.csp.uvschedule;

import com.uv.jobs.MyJob;
import com.uv.jobs.SampleJob;
import com.uv.services.AliESService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


@SpringBootApplication
@ComponentScan(basePackages={"com.uv.services","com.uv.jobs"})
public class UvscheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UvscheduleApplication.class, args);
    }

    @Autowired
    SampleJob service1;

    @Autowired
    MyJob myJob;

    @Bean
    public Scheduler ScheduleBuilder() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        // define the job and tie it to our MyJob class
//        JobDetail job = newJob(SampleJob.class)
//                .withIdentity("myJob", "group1")
//                .build();
//
//        // Trigger the job to run now, and then repeat every 40 seconds
//        Trigger  trigger = newTrigger()
//                .withIdentity("trigger3", "group1")
//                    .withSchedule(cronSchedule("30 22 19 * * ?"))
//                .forJob("myJob", "group1")
//                .build();
//
//        // Tell quartz to schedule the job using our trigger
//        scheduler.scheduleJob(job, trigger);
//        scheduler.start();
//        System.out.println("binding success");
//
//        SampleJob service = new SampleJob();
//        try {
//            service.execute(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        myJob.yesterdayPVCountPost();
        return scheduler;
    }
}
