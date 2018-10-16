package com.uv.schedule;


import com.uv.jobs.EveryDayAM2Job;
import com.uv.jobs.EveryMonthJob;
import com.uv.jobs.MyJob;
import com.uv.other.ZipFileTest;
import com.uv.services.AliConfig;
import com.uv.services.AliESService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EverydayAM2Scheduler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AliConfig aliConfig;

    @Autowired
    AliESService aliESService;

    @Autowired
    EveryDayAM2Job service1;

    @Autowired
    MyJob myJob;

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(){
        ZipFileTest test = new ZipFileTest();
        test.parseWorker();
        logger.info("dayTrigger starting");
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(jobDetailFactoryBean().getObject());
        stFactory.setStartDelay(3000);
        stFactory.setName("mytrigger");
        stFactory.setGroup("mygroup");
        stFactory.setCronExpression("0 0 4 * * ?");
        return stFactory;
    }

    @Bean
    public CronTriggerFactoryBean monthTriggerFactoryBean(){
        logger.info("monthTrigger starting");
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(monthJobFactoryBean().getObject());
        stFactory.setStartDelay(3000);
        stFactory.setName("monthTrigger");
        stFactory.setGroup("monthGroup");
        stFactory.setCronExpression("0 0 5 1 * ?");
        return stFactory;
    }

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(EveryDayAM2Job.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("aliESService", aliESService);
        factory.setJobDataAsMap(map);
        factory.setGroup("mygroup");
        factory.setName("myjob");
        factory.setDurability(true);
        return factory;
    }

    @Bean
    public JobDetailFactoryBean monthJobFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(EveryMonthJob.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("aliESService", aliESService);
        factory.setJobDataAsMap(map);
        factory.setGroup("monthGroup");
        factory.setName("monthJob");
        factory.setDurability(true);
        return factory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setTriggers(cronTriggerFactoryBean().getObject(),monthTriggerFactoryBean().getObject());
        scheduler.start();
        logger.info("scheduler started ");
        return scheduler;
    }

}

