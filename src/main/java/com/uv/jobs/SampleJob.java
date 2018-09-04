package com.uv.jobs;

import com.uv.entity.CPEPActiveUserCount;
import com.uv.services.AliESService;
import com.uv.services.MSSQLService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class SampleJob implements Job {
    public SampleJob(){

    }
    @Autowired
    AliESService aliESService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        yesterdayActiveUserCountPost();
        yesterdayPVCountPost();
    }

    private void yesterdayActiveUserCountPost()
    {
        List<CPEPActiveUserCount> yesterdayCount = getYesterdayActiveUserCount();
        insertYesterdayCount(yesterdayCount);
    }

    public void yesterdayPVCountPost()
    {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();

        try {
            aliESService = new AliESService();
            aliESService.gePVCount(yesterdayStr,todayStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<CPEPActiveUserCount> getYesterdayActiveUserCount()
    {
        List<CPEPActiveUserCount> auCount = new ArrayList<CPEPActiveUserCount>();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();

        try {
             auCount = aliESService.getActiveUserCount(yesterdayStr,todayStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auCount;
    }

    private void insertYesterdayCount( List<CPEPActiveUserCount> count)
    {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();
        MSSQLService service = new MSSQLService();
        service.insertYesterdayActiveUserCount(count,yesterdayStr);
    }
}
