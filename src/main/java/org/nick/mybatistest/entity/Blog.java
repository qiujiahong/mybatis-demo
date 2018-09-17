package org.nick.mybatistest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private int id;
    private String name;
    private String url;

    public Blog(String name) {
        this.name = name;
    }

    public Blog(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
