package org.nick.mybatistest.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nick.mybatistest.entity.Blog;

public interface BlogMapper1 {
    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);

    @Insert("INSERT INTO blog( name, url) VALUES(#{blog.name}, #{blog.url})")
    @Options(useGeneratedKeys = true, keyProperty = "blog.id")
    void add(@Param("blog") Blog blog);

}
