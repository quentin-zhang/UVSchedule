package com.uv.other;

import com.uv.services.CloudPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SingleBootstrap {
    @Autowired
    CloudPlusService cloudPlusService;

    public void execute() throws IOException {
        getDateMap("2019-06-12 00:00:00","2019-07-03 00:00:00");
    }

    private void getDateMap(String startDate , String endDate) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endDate, formatter);
        while(endTime.isAfter(startTime))
        {
            String yesterdayStr = startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
            String todayStr = startTime.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
//            cloudPlusService.insertSumActiveUserCount(yesterdayStr, todayStr);
            cloudPlusService.insertSumExceptionCount(yesterdayStr,todayStr);
            startTime = startTime.plusDays(1);
        }
    }


}
