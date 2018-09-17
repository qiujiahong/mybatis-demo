package org.nick.mybatistest;

import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.nick.mybatistest.dao.DbConnect;
import org.nick.mybatistest.entity.Blog;

public class Application {

    public static void main(String[] args) {

        SqlSession session = DbConnect.getSqlSection();
        try {
            //读
            Blog blog = (Blog) session.selectOne("org.nick.mybatistest.BlogMapper.selectBlog", 101);
            System.out.println("blog:"+new Gson().toJson(blog));
            //插入
            session.insert("org.nick.mybatistest.BlogMapper.insertBlog",new Blog("张三"));
            session.commit();
//            session.close();
            //更新
            session.update("org.nick.mybatistest.BlogMapper.updateBlog",new Blog(101,"wangwu","http:..."));
            session.commit();
            session.close();

            System.out.println("test");

        } finally {
            session.close();
        }
    }
}
