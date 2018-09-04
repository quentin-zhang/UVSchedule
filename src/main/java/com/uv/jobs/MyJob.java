package com.uv.jobs;

import com.uv.entity.CPEPExceptionCount;
import com.uv.entity.CPEPPVCount;
import com.uv.services.AliESService;
import com.uv.services.MSSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MyJob {
    @Autowired
    AliESService aliESService;
    @Autowired
    MSSQLService mssqlService;

    public void yesterdayPVCountPost()
    {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();

        try {
            List<CPEPExceptionCount> pvCount = aliESService.getExceptionCount(yesterdayStr,todayStr);
            mssqlService.insertYesterdayEXCount(pvCount,yesterdayStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPVCount()
    {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        String yesterdayStr = yesterday.format(DateTimeFormatter.ISO_DATE).toString();
        String todayStr = today.format(DateTimeFormatter.ISO_DATE).toString();

        try {
            List<CPEPPVCount> pvCount = aliESService.gePVCount(yesterdayStr,todayStr);
            mssqlService.insertYesterdayPVCount(pvCount,yesterdayStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
