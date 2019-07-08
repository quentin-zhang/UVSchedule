package com.uv.services;


import com.uv.entity.CPEPActiveUserCount;
import com.uv.entity.CPEPExceptionCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CloudPlusService {
    @Autowired
    private AliESService aliESService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void insertSumActiveUserCount(String yesterdayStr,String todayStr)
    {
        try{
            //汇总活跃用户数
            MSSQLService service = new MSSQLService();
            int totalCount = aliESService.GetYesterdayActiveUserCount(yesterdayStr,todayStr);
            List<CPEPActiveUserCount> sumList = new ArrayList<CPEPActiveUserCount>();
            CPEPActiveUserCount sumOne = new CPEPActiveUserCount();
            logger.info(yesterdayStr + "'s active user count is : " + totalCount);
            sumOne.setCollectTime(yesterdayStr);
            sumOne.setUserCount(totalCount);
            sumList.add(sumOne);
            service.insertYesterdaySumActiveUserCount(sumList,yesterdayStr);
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
        }
    }

    public void insertSumExceptionCount(String yesterdayStr,String todayStr) throws IOException {
        MSSQLService service = new MSSQLService();
        int totalCount = aliESService.GetYesterdayExceptionCount(yesterdayStr,todayStr);
        logger.info("yesterday 's cp exception count is : " + totalCount);
        List<CPEPExceptionCount> sumList = new ArrayList<CPEPExceptionCount>();
        CPEPExceptionCount sumOne = new CPEPExceptionCount();
        sumOne.setCollectTime(yesterdayStr);
        sumOne.setExCount(totalCount);
        sumList.add(sumOne);
        service.insertYesterdaySumEXCount(sumList,yesterdayStr);
    }
}
