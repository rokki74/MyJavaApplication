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
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
            //recyclerView = findViewById(R.id.recyclerView);
            //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            //recyclerView.setLayoutManager(layoutManager);

            recyclerView = findViewById(R.id.recyclerView);
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            Gson gson = new Gson();
            Intent intent = getIntent();
            String jsonStudents = intent.getStringExtra("studentListJson");
            List<Student> studentList = gson.fromJson(jsonStudents, new TypeToken<List<Student>>(){}.getType());

            // Create a new empty list (optional, if needed for position assignment)
            List<Student> studentsWithPositions = new ArrayList<>();

            // Parse JSON data and assign positions
            try {
                JSONArray jsonArray = new JSONArray(jsonStudents);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String admission_number = jsonObject.getString("admission_number");
                    String name = jsonObject.getString("name");
                    int class_id = jsonObject.getInt("class_id");
                    String stream = jsonObject.getString("stream");
                    //OffsetDateTime created_at = jsonObject.getOffsetDateTime("created_at");
                   // OffsetDateTime updated_at = jsonObject.getOffsetDateTime("updated_at");

                    // Parse created_at and updated_at using Gson
                    Gson customisedgson = new GsonBuilder()
                            .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeDeserializer())
                            .create();
                    OffsetDateTime created_at = customisedgson.fromJson(jsonObject.getString("created_at"), OffsetDateTime.class);
                    OffsetDateTime updated_at = customisedgson.fromJson(jsonObject.getString("updated_at"), OffsetDateTime.class);

                    // Create a new Student object with position
                    Student student = new Student(admission_number, name, class_id, stream, created_at,updated_at, + 1);
                    studentsWithPositions.add(student); // Add to the new list (optional)
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Update studentList if using a new list (optional)
            if (!studentsWithPositions.isEmpty()) {
                studentList = studentsWithPositions;
            }

            adapter = new StudentAdapter(studentList);
            recyclerView.setAdapter(adapter);
        }
}