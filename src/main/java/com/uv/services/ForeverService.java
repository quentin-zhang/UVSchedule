package com.uv.services;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForeverService {
    private final static Logger logger = LoggerFactory.getLogger(ForeverService.class);
    //直接插入
    public static void insertDirect(String sql) {
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSimpleSqlSession();
        try
        {
            session.insert("insertDirect", sql);
            session.commit();
        }
        catch (Exception ex)
        {
            logger.error(ex.toString());
        }
        // 关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);
    }
}
