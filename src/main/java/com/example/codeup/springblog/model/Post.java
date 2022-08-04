package com.example.codeup.springblog.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.w3c.dom.Text;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Post(String title) {
        this.id = id;
        this.title = title;
        this.body = body;

    }
    public Post(long id, String s, String s1) {
    }
    public Post() {
    }

    public Post(String title, String body) {
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

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
