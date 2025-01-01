package com.example.myjavaapplication.api;


import android.telecom.Call;
import java.util.List;
import retrofit2.http.GET;

public interface ApiInterface2 {
    @GET("/todos")
    retrofit2.Call<List<Student>> getStudents();
}
