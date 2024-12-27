package com.example.myjavaapplication;
import com.google.gson.Gson;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myjavaapplication.StudentAdapter;
import com.example.myjavaapplication.api.Student;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new Gson();
        Intent intent = getIntent();
        String jsonStudents = getIntent().getStringExtra("studentListJson");
        List<Student> studentList = gson.fromJson(jsonStudents, new TypeToken<List<Student>>(){}.getType());

        adapter = new StudentAdapter(studentList);
        recyclerView.setAdapter(adapter);
    }
}