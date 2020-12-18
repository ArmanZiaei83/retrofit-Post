package com.example.retrofit_post;

public class Post {

    //Values Initialized.
    private int userId;
    private String title;
    private Integer id;
    private String body;

    //Constructor :
    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
    //Getters :

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
