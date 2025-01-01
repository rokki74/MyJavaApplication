package com.example.myjavaapplication.api;

public class Teacher {
    private int userId; //id
    private int id; //name
    private String title; //grade

    private String completed;

    private int position;

    // Constructor
    public Teacher(int userId, int id, String title, String completed, int position) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.position = position;
    }

    // Getters
    public int getId() {

        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {

        return title;
    }

    public String getCompleted() {

        return completed;
    }

    public int getPosition() {

        return position;
    }
}

