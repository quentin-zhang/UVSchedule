package com.uv.services;

import com.uv.entity.*;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MSSQLService {
    private final static Logger logger = LoggerFactory.getLogger(MSSQLService.class);

    //所有企业昨天的活跃用户数
    public void insertYesterdayActiveUserCount(List<CPEPActiveUserCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        for (CPEPActiveUserCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertActiveUser", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //所有企业昨天的活跃用户数
    public void insertYesterdayPVCount(List<CPEPPVCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        for (CPEPPVCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertPV", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //各个企业昨天的异常数
    public void insertYesterdayEXCount(List<CPEPExceptionCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        for (CPEPExceptionCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertException", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }


    //各个企业上月的活跃用户数
    public void insertMonthActiveUserCount(List<CPEPActiveUserCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        for (CPEPActiveUserCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertMonthActiveUser", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //各个企业上月PV
    public void insertMonthPVCount(List<CPEPPVCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        for (CPEPPVCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertMonthPV", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //所有企业上月异常
    public void insertMonthEXCount(List<CPEPExceptionCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        for (CPEPExceptionCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertMonthException", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }


    //所有企业昨天总活
    public void insertYesterdaySumActiveUserCount(List<CPEPActiveUserCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        try {
            for (CPEPActiveUserCount uc : auCountList) {
                uc.setCollectTime(startTime);
                session.insert("insertActiveUserSUM", uc);
            }
            session.commit();
        } catch (PersistenceException e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭SqlSession对象
            MyBatisUtil.closeSqlSession(session);
        }

    }

    //所有企业昨天总PV
    public void insertYesterdaySumPVCount(List<CPEPPVCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        try {
            for (CPEPPVCount uc : auCountList) {
                uc.setCollectTime(startTime);
                session.insert("insertPVSUM", uc);
            }
            session.commit();
        } catch (PersistenceException e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭SqlSession对象
            MyBatisUtil.closeSqlSession(session);
        }

    }

    //所有企业昨天总异常
    public void insertYesterdaySumEXCount(List<CPEPExceptionCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        try {
            for (CPEPExceptionCount uc : auCountList) {
                uc.setCollectTime(startTime);
                session.insert("insertExceptionSUM", uc);
            }
            session.commit();
        } catch (PersistenceException e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭SqlSession对象
            MyBatisUtil.closeSqlSession(session);
        }
    }


    //所有超时异常数
    public void insertYesterdayTimeoutEXCount(List<CPTimeOutExceptionPerDay> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        try {
            for (CPTimeOutExceptionPerDay uc : auCountList) {
                uc.setCollectTime(startTime);
                session.insert("insertTimeoutExceptionSUM", uc);
            }
            session.commit();
        } catch (PersistenceException e) {
            logger.error(e.getMessage());
        } finally {
            // 关闭SqlSession对象
            MyBatisUtil.closeSqlSession(session);
        }

    }

    //近30天所有用户与PV数
    public void insertCPUserPV(List<CPUserPV> auCountList) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getBatchSqlSession();
        session.delete("deleteCPUserPV");
        for (CPUserPV uc : auCountList) {
            session.insert("insertCPUserPV", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //直接插入
    public void insertDirect(String sql) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSimpleSqlSession();
        session.insert("insertDirect", sql);
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }
}
