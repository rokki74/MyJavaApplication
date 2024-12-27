package com.example.myjavaapplication.api;

public class Student {
    private int userId; //id
    private int id; //name
    private String title; //grade

    private String completed;

    // Constructor
    public Student(int userId, int id, String title, String completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
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
}
