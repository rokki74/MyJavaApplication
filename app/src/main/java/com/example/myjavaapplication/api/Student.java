package com.example.myjavaapplication.api;

import java.time.OffsetDateTime;

public class Student {
    private String admission_number;
    private String name; //name
    private int class_id; //grade

    private String stream;

    private OffsetDateTime created_at;

    private OffsetDateTime updated_at;

    private int position;

    // Constructor
    public Student(String admission_number, String name, int class_id, String stream, OffsetDateTime created_at, OffsetDateTime updated_at, int position) {
        this.admission_number = admission_number;
        this.name = name;
        this.class_id = class_id;
        this.stream = stream;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.position = position;
    }

    // Getters
    public String getAdmission_number() {

        return admission_number;
    }

    public String getName() {
        return name;
    }

    public int getClass_id() {

        return class_id;
    }

    public String getStream() {

        return stream;
    }

    public OffsetDateTime getCreated_at() {  ;
        return created_at;
    }

    public OffsetDateTime getUpdated_at() {
        return updated_at;
    }

    public int getPosition() {
        return position;
    }
}
