package com.milen.model.vo;

import java.io.Serializable;
import java.util.Date;

public class CommentVO implements Serializable {

    private String content;

    private String username;

    private Date date;

    public CommentVO() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                '}';
    }
}
