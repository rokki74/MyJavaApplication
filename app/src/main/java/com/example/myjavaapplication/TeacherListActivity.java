package com.example.myjavaapplication;
import com.example.myjavaapplication.api.Teacher;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeacherListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);
        //recyclerView = findViewById(R.id.recyclerView);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new Gson();
        Intent intent = getIntent();
        String jsonTeachers = intent.getStringExtra("teacherListJson");
        List<Teacher> teacherList = gson.fromJson(jsonTeachers, new TypeToken<List<Teacher>>(){}.getType());

        // Create a new empty list (optional, if needed for position assignment)
        List<Teacher> teachersWithPositions = new ArrayList<>();

        // Parse JSON data and assign positions
        try {
            JSONArray jsonArray = new JSONArray(jsonTeachers);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                String completed = jsonObject.getString("completed");
                int id = jsonObject.getInt("id");
                int userId = jsonObject.getInt("userId");

                // Create a new Student object with position
                Teacher teacher = new Teacher(userId, id, title, completed, i + 1);
                teachersWithPositions.add(teacher); // Add to the new list (optional)
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Update studentList if using a new list (optional)
        if (!teachersWithPositions.isEmpty()) {
            teacherList = teachersWithPositions;
        }

        adapter = new TeacherAdapter(teacherList);
        recyclerView.setAdapter(adapter);
    }
}
