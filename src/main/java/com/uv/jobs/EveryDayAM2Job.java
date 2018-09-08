package com.uv.jobs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uv.entity.CPEPActiveUserCount;
import com.uv.entity.CPEPExceptionCount;
import com.uv.entity.CPEPPVCount;
import com.uv.services.AliESService;
import com.uv.services.MSSQLService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class EveryDayAM2Job implements Job {
    private AliESService aliESService;

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
    }

    /*昨日活跃用户数*/
    private void yesterdayActiveUserCountPost() {
        try {
            List<CPEPActiveUserCount> auCount = new ArrayList<CPEPActiveUserCount>();
            LocalDate yesterday = LocalDate.now().minusDays(1);
            LocalDate today = LocalDate.now();
            String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
            String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();
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
            LocalDate yesterday = LocalDate.now().minusDays(1);
            LocalDate today = LocalDate.now();
            String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
            String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();
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
            LocalDate yesterday = LocalDate.now().minusDays(1);
            LocalDate today = LocalDate.now();
            String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
            String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();
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
}
