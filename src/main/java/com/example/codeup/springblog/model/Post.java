package com.example.codeup.springblog.model;

public class Post {

    private String title;
    private String body;

    public Post(String title) {
        this.title = title;

    }

    public Post(long id, String s, String s1) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
