package com.uv.services;


import com.uv.entity.CPEPActiveUserCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
