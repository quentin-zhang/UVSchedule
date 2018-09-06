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

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class EveryMonthJob implements Job {
    private AliESService aliESService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getMergedJobDataMap();
        aliESService = (AliESService) map.get("aliESService");
        this.doJob();
    }

    private void doJob() {
        //上月活跃用户数
        yesterdayActiveUserCountPost();
        //上月PV数
        yesterdayPVCountPost();
        //上月异常数
        yesterdayExceptionCountPost();
    }

    /*上月活跃用户数*/
    private void yesterdayActiveUserCountPost() {
        List<CPEPActiveUserCount> auCount = new ArrayList<CPEPActiveUserCount>();
        LocalDate startDate = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        String startDateStr = startDate.format(DateTimeFormatter.ISO_DATE).toString();
        String endDateStr = endDate.format(DateTimeFormatter.ISO_DATE).toString();

        try {
            auCount = aliESService.getActiveUserCount(startDateStr, endDateStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MSSQLService service = new MSSQLService();
        service.insertMonthActiveUserCount(auCount, startDateStr);
    }

    /*上月PV数获取*/
    public void yesterdayPVCountPost() {
        LocalDate startDate = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        String startDateStr = startDate.format(DateTimeFormatter.ISO_DATE).toString();
        String endDateStr = endDate.format(DateTimeFormatter.ISO_DATE).toString();
        List<CPEPPVCount> pvCount = new ArrayList<CPEPPVCount>();
        try {
            pvCount = aliESService.gePVCount(startDateStr, endDateStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MSSQLService service = new MSSQLService();
        service.insertMonthPVCount(pvCount, startDateStr);
    }

    /*上月异常数获取*/
    public void yesterdayExceptionCountPost() {
        List<CPEPExceptionCount> auCount = new ArrayList<CPEPExceptionCount>();
        LocalDate startDate = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        String startDateStr = startDate.format(DateTimeFormatter.ISO_DATE).toString();
        String endDateStr = endDate.format(DateTimeFormatter.ISO_DATE).toString();

        try {
            auCount = aliESService.getExceptionCount(startDateStr, endDateStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MSSQLService service = new MSSQLService();
        service.insertMonthEXCount(auCount, startDateStr);
    }
}
