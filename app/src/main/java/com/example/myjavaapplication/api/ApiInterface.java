package com.example.myjavaapplication.api;


import android.telecom.Call;
import java.util.List;
import retrofit2.http.GET;

public interface ApiInterface {
    //http://192.168.43.75:3000/api/students
    @GET("/api/students")
    retrofit2.Call<List<Student>> getStudents();

    @GET("/api/teachers")
    retrofit2.Call<List<Teacher>> getTeachers();
}