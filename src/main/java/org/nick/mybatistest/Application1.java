package org.nick.mybatistest;

import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.nick.mybatistest.dao.BlogMapper1;
import org.nick.mybatistest.dao.DbConnect;
import org.nick.mybatistest.entity.Blog;

public class Application1 {
    public static void main(String[] args) {

        SqlSession session = DbConnect.getSqlSection();
        try {
            //创建链接
            BlogMapper1 mapper = session.getMapper(BlogMapper1.class);
            //读
            Blog blog = mapper.selectBlog(101);
            System.out.println("blog:"+new Gson().toJson(blog));
            //写
            Blog blog1 = new Blog("李四111");
            mapper.add(blog1);
            //关闭链接
            session.commit();

        } finally {
            session.close();
        }
    }
}
