package com.example.yonhapnews.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class News {

    String title;
    String link;
    String comments;
    Timestamp pub_data;
    String category;
    String description;
    String content;
    Timestamp reg_date;

    public News(String title,String content) throws SQLException {
        this.title = title;
        this.content = content;
    }

    public News(ResultSet rs) throws SQLException {
        this.title = rs.getString(1);
        this.link = rs.getString(2);
        this.comments = rs.getString(3);
        this.pub_data = rs.getTimestamp(4);
        this.category = rs.getString(5);
        this.description = rs.getString(6);
        this.content = rs.getString(7);
        this.reg_date = rs.getTimestamp(8);
    }

    public News() {

    }

    public News(String title, String link, String comments, Timestamp pub_data, String category, String description, String content, Timestamp reg_date) {
        this.title = title;
        this.link = link;
        this.comments = comments;
        this.pub_data = pub_data;
        this.category = category;
        this.description = description;
        this.content = content;
        this.reg_date = reg_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getPub_data() {
        return pub_data;
    }

    public void setPub_data(Timestamp pub_data) {
        this.pub_data = pub_data;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReg_date() {
        return reg_date;
    }

    public void setReg_date(Timestamp reg_date) {
        this.reg_date = reg_date;
    }
}
