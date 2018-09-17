package org.nick.mybatistest.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * 链接数据库
 */
public class DbConnect {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static String resource = "mybatis-config.xml";

    private static synchronized void get(){
        if(sqlSessionFactory == null){
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                Configuration configuration = sqlSessionFactory.getConfiguration();
                configuration.addMapper(BlogMapper1.class);
            } catch (
            IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static SqlSession  getSqlSection(){
        get();
        SqlSession session = sqlSessionFactory.openSession();
        return  session;
    }

}
