package com.uv.jobs;

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
        List<CPEPActiveUserCount> auCount = new ArrayList<CPEPActiveUserCount>();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();

        try {
            auCount = aliESService.getActiveUserCount(yesterdayStr, todayStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MSSQLService service = new MSSQLService();
        service.insertYesterdayActiveUserCount(auCount, yesterdayStr);
    }

    /*昨日PV数获取*/
    public void yesterdayPVCountPost() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();
        List<CPEPPVCount> pvCount = new ArrayList<CPEPPVCount>();
        try {
            pvCount = aliESService.gePVCount(yesterdayStr, todayStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MSSQLService service = new MSSQLService();
        service.insertYesterdayPVCount(pvCount, yesterdayStr);
    }

    /*昨日异常数获取*/
    public void yesterdayExceptionCountPost() {
        List<CPEPExceptionCount> auCount = new ArrayList<CPEPExceptionCount>();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();

        try {
            auCount = aliESService.getExceptionCount(yesterdayStr, todayStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MSSQLService service = new MSSQLService();
        service.insertYesterdayEXCount(auCount, yesterdayStr);
    }
}
