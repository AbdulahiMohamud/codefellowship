package com.abdul_Codefellowship.codefellowship.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    private String text;
    private Date createdAt;



    @ManyToOne
    AppUser userPosts;

    public Post() {
    }

    public Post(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(AppUser userPosts) {
        this.userPosts = userPosts;
    }
}
