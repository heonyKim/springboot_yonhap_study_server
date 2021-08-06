package com.example.yonhapnews.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class News {

    String title;
    String link;
    String comments;
    Timestamp pub_date;
    String category;
    String description;
    String content;
    Timestamp reg_date;

    public News(String title,String content) throws SQLException {
        this.title = title;
        this.content = content;
    }

    public News(ResultSet rs) throws SQLException {
        this.title = rs.getString("title");
        this.link = rs.getString("link");
        this.comments = rs.getString("comments");
        this.pub_date = rs.getTimestamp("pub_date");
        this.category = rs.getString("category");
        this.description = rs.getString("description");
        this.content = rs.getString("content");
        this.reg_date = rs.getTimestamp("reg_date");
    }

}
