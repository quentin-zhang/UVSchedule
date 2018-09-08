package com.uv.services;

import com.uv.entity.CPEPActiveUserCount;
import com.uv.entity.CPEPExceptionCount;
import com.uv.entity.CPEPPVCount;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MSSQLService {
    //所有企业昨天的活跃用户数
    public void insertYesterdayActiveUserCount(List<CPEPActiveUserCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
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
        SqlSession session = MyBatisUtil.getSqlSession();
        for (CPEPPVCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertPV", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //所有企业昨天的异常数
    public void insertYesterdayEXCount(List<CPEPExceptionCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        for (CPEPExceptionCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertException", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }











    //所有企业上月的活跃用户数
    public void insertMonthActiveUserCount(List<CPEPActiveUserCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        for (CPEPActiveUserCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertMonthActiveUser", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //所有企业上月PV
    public void insertMonthPVCount(List<CPEPPVCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
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
        SqlSession session = MyBatisUtil.getSqlSession();
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
        SqlSession session = MyBatisUtil.getSqlSession();
        for (CPEPActiveUserCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertActiveUserSUM", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //所有企业昨天总PV
    public void insertYesterdaySumPVCount(List<CPEPPVCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        for (CPEPPVCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertPVSUM", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }

    //所有企业昨天总异常
    public void insertYesterdaySumEXCount(List<CPEPExceptionCount> auCountList, String startTime) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        for (CPEPExceptionCount uc : auCountList) {
            uc.setCollectTime(startTime);
            session.insert("insertExceptionSUM", uc);
        }
        session.commit();
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }
}
