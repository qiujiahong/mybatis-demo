package org.nick.mybatistest.dao;

import org.apache.ibatis.annotations.*;
import org.nick.mybatistest.entity.Blog;

public interface BlogMapper1 {
    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);

    @Insert("INSERT INTO blog( name, url) VALUES(#{blog.name}, #{blog.url})")
    @Options(useGeneratedKeys = true, keyProperty = "blog.id")
    void add(@Param("blog") Blog blog);


    @Update("update blog set name=#{name},url=#{url} where id=#{id}")
    void update(Blog blog);

    @Delete("delete from blog where id=#{id}")
    @Options(useGeneratedKeys = true)
    Long deleteById(Long id);

}
