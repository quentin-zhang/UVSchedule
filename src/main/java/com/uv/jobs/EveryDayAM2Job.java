package com.uv.jobs;

import com.uv.entity.*;
import com.uv.services.AliESService;
import com.uv.services.MSSQLService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class EveryDayAM2Job implements Job {
    private AliESService aliESService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getMergedJobDataMap();
        aliESService = (AliESService) map.get("aliESService");
        this.doJob();
    }

    private void doJob() {
        //昨日活跃用户数
        yesterdayActiveUserCountPost();
        //昨日PV数
        yesterdayPVCountPost();
        //昨日异常数
        yesterdayExceptionCountPost();
        //昨日超时异常总数
        yesterdayTimeoutExceptionCountPost();
        //近30天用户与PV
        near30dayCPUserPV();
    }

    /*昨日活跃用户数*/
    private void yesterdayActiveUserCountPost() {
        try {
            List<CPEPActiveUserCount> auCount = new ArrayList<CPEPActiveUserCount>();
            LocalDateTime yesterday = LocalDate.now().minusDays(1).atStartOfDay();
            LocalDateTime today = LocalDate.now().atStartOfDay();
            String yesterdayStr = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            String todayStr = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            auCount = aliESService.getActiveUserCount(yesterdayStr, todayStr);
            MSSQLService service = new MSSQLService();
            service.insertYesterdayActiveUserCount(auCount, yesterdayStr);

            //汇总活跃用户数
            int totalCount = this.allActiveUserCount(auCount);
            List<CPEPActiveUserCount> sumList = new ArrayList<CPEPActiveUserCount>();
            CPEPActiveUserCount sumOne = new CPEPActiveUserCount();
            sumOne.setCollectTime(yesterdayStr);
            sumOne.setUserCount(totalCount);
            sumList.add(sumOne);
            service.insertYesterdaySumActiveUserCount(sumList,yesterdayStr);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*昨日PV数获取*/
    public void yesterdayPVCountPost() {
        try {
            LocalDateTime yesterday = LocalDate.now().minusDays(1).atStartOfDay();
            LocalDateTime today = LocalDate.now().atStartOfDay();
            String yesterdayStr = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            String todayStr = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            List<CPEPPVCount> pvCount = new ArrayList<CPEPPVCount>();
            pvCount = aliESService.gePVCount(yesterdayStr, todayStr);
            MSSQLService service = new MSSQLService();
            service.insertYesterdayPVCount(pvCount, yesterdayStr);

            //汇总PV数
            int totalCount = this.allPVCount(pvCount);
            List<CPEPPVCount> sumList = new ArrayList<CPEPPVCount>();
            CPEPPVCount sumOne = new CPEPPVCount();
            sumOne.setCollectTime(yesterdayStr);
            sumOne.setPvCount(totalCount);
            sumList.add(sumOne);
            service.insertYesterdaySumPVCount(sumList,yesterdayStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*昨日异常数获取*/
    public void yesterdayExceptionCountPost() {
        try {
            List<CPEPExceptionCount> auCount = new ArrayList<CPEPExceptionCount>();
            LocalDateTime yesterday = LocalDate.now().minusDays(1).atStartOfDay();
            LocalDateTime today = LocalDate.now().atStartOfDay();
            String yesterdayStr = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            String todayStr = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            auCount = aliESService.getExceptionCount(yesterdayStr, todayStr);
            MSSQLService service = new MSSQLService();
            service.insertYesterdayEXCount(auCount, yesterdayStr);

            //汇总异常数
            int totalCount = this.allEXCount(auCount);
            List<CPEPExceptionCount> sumList = new ArrayList<CPEPExceptionCount>();
            CPEPExceptionCount sumOne = new CPEPExceptionCount();
            sumOne.setCollectTime(yesterdayStr);
            sumOne.setExCount(totalCount);
            sumList.add(sumOne);
            service.insertYesterdaySumEXCount(sumList,yesterdayStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*昨日超时异常总数获取*/
    public void yesterdayTimeoutExceptionCountPost() {
        try {
            ConditionCount auCount = new ConditionCount();
            List<CPTimeOutExceptionPerDay> auCountList = new ArrayList<CPTimeOutExceptionPerDay>();
            LocalDateTime yesterday = LocalDate.now().minusDays(1).atStartOfDay();
            LocalDateTime today = LocalDate.now().atStartOfDay();
            String yesterdayStr = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            String todayStr = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            logger.info("yesterdaystr is : " + yesterdayStr);
            logger.info("todayStr is : " + todayStr);
            auCount = aliESService.getTimeoutExceptionCount(yesterdayStr, todayStr);

            CPTimeOutExceptionPerDay one = new CPTimeOutExceptionPerDay();
            one.setCollectTime(yesterdayStr);
            one.setExCount(Integer.valueOf(auCount.getTotal()));
            auCountList.add(one);
            MSSQLService service = new MSSQLService();
            service.insertYesterdayTimeoutEXCount(auCountList, yesterdayStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*昨日活跃用户总数*/
    private int allActiveUserCount(List<CPEPActiveUserCount> auCount) {
        int totalCount = 0;
        try {
            for (CPEPActiveUserCount au : auCount) {
                totalCount += au.getUserCount();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalCount;
    }

    /*昨日活跃用户总数*/
    private int allPVCount(List<CPEPPVCount> auCount) {
        int totalCount = 0;
        try {
            for (CPEPPVCount au : auCount) {
                totalCount += au.getPvCount();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalCount;
    }

    /*昨日活跃用户总数*/
    private int allEXCount(List<CPEPExceptionCount> auCount) {
        int totalCount = 0;
        try {
            for (CPEPExceptionCount au : auCount) {
                totalCount += au.getExCount();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalCount;
    }

    /*昨日超时异常总数获取*/
    public void near30dayCPUserPV() {
        logger.info("begin to batch insert CPUserPV");
        try {
            List<CPUserPV> auCount = new ArrayList<CPUserPV>();
            LocalDateTime yesterday = LocalDate.now().minusDays(30).atStartOfDay();
            LocalDateTime today = LocalDate.now().atStartOfDay();
            String yesterdayStr = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            String todayStr = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            auCount = aliESService.getCPUserPV(yesterdayStr, todayStr);
            MSSQLService service = new MSSQLService();
            service.insertCPUserPV(auCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("end batch insert CPUserPV");
    }
}
