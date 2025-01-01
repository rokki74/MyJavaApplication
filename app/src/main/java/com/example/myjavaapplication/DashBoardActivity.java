package com.example.myjavaapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;

import com.example.myjavaapplication.api.ApiClient;
import com.example.myjavaapplication.api.ApiInterface;
import com.example.myjavaapplication.api.Student;
import com.example.myjavaapplication.api.Teacher;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity {

    private ProgressBar progressBar;


    private void getStudents() {

        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<List<Student>> call = apiInterface.getStudents();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Student>> call, Response<List<Student>> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);   // Dismiss progress dialog on failure
                    List<Student> students = response.body();
                    // Process the list of students

                    Gson gson = new Gson();
                    String jsonStudents = gson.toJson(students);
                    Intent intent = new Intent(DashBoardActivity.this, StudentListActivity.class);
                    intent.putExtra("studentListJson", jsonStudents);
                    startActivity(intent);

                    // Print the received JSON response to Logcat
                    Log.d("NetworkResponse", "Received Response: " + response.body().toString());

                    for (Student student : students) {
                        Log.d("DashBoardActivity", "Student: " + student.getAdmission_number() + ", Grade: " + student.getName());
                    }
                    Toast.makeText(DashBoardActivity.this, "Students fetched successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("DashBoardActivity", "Error: " + response.code());
                    Toast.makeText(DashBoardActivity.this, "Error fetching students", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<Student>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);   // Dismiss progressBar on failure
                Log.e("DashBoardActivity", "Failure: " + t.getMessage());
                Toast.makeText(DashBoardActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getTeachers() {

        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<List<Teacher>> call = apiInterface.getTeachers();

        call.enqueue(new Callback<List<Teacher>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Teacher>> call, Response<List<Teacher>> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);   // Dismiss progress dialog on failure
                    List<Teacher> teachers = response.body();
                    // Process the list of teachers

                    Gson gson = new Gson();
                    String jsonTeachers = gson.toJson(teachers);
                    Intent intent = new Intent(DashBoardActivity.this, TeacherListActivity.class);
                    intent.putExtra("teacherListJson", jsonTeachers);
                    startActivity(intent);

                    // Print the received JSON response to Logcat
                    Log.d("NetworkResponse", "Received Response: " + response.body().toString());

                    for (Teacher teacher : teachers) {
                        Log.d("DashBoardActivity", "Student: " + teacher.getTitle() + ", Grade: " + teacher.getCompleted());
                    }
                    Toast.makeText(DashBoardActivity.this, "Teachers fetched successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("DashBoardActivity", "Error: " + response.code());
                    Toast.makeText(DashBoardActivity.this, "Error fetching teachers", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<Teacher>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);   // Dismiss progressBar on failure
                Log.e("DashBoardActivity", "Failure: " + t.getMessage());
                Toast.makeText(DashBoardActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        progressBar = findViewById(R.id.progressBar);

        // Register all the ImageButtons with their appropriate IDs
        ImageButton backB = (ImageButton) findViewById(R.id.backB);
        ImageButton logOutB = (ImageButton) findViewById(R.id.logOutB);
        ImageButton profileB = (ImageButton) findViewById(R.id.profileB);

        // Register all the Buttons with their appropriate IDs
        Button todoB = (Button) findViewById(R.id.todoB);
        Button editProfileB = (Button) findViewById(R.id.editProfileB);

        // Register all the card views with their appropriate IDs
        CardView teachersCard = (CardView) findViewById(R.id.teachersCard);
        CardView learnersCard = (CardView) findViewById(R.id.learnersCard);
        CardView learnCard = (CardView) findViewById(R.id.learnCard);
        CardView interestsCard = (CardView) findViewById(R.id.interestsCard);
        CardView helpCard = (CardView) findViewById(R.id.helpCard);
        CardView settingsCard = (CardView) findViewById(R.id.settingsCard);

        // Handle each of the image buttons with the OnClickListener
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Back Button", Toast.LENGTH_SHORT).show();
            }
        });
        logOutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Logout Button", Toast.LENGTH_SHORT).show();
            }
        });
        profileB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Profile Image", Toast.LENGTH_SHORT).show();
            }
        });

         //Handle each of the buttons with the OnClickListener

        todoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getStudents();
            }
        });

        editProfileB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Editing Profile", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle each of the cards with the OnClickListener
        teachersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Acessing the Teachers", Toast.LENGTH_SHORT).show();
                getTeachers();
            }
        });
        learnersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Accessing the learners", Toast.LENGTH_SHORT).show();
                getStudents();
            }
        });
        learnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Learn Programming", Toast.LENGTH_SHORT).show();
            }
        });
        interestsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Filter your Interests", Toast.LENGTH_SHORT).show();
            }
        });
        helpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Anything Help you want?", Toast.LENGTH_SHORT).show();
            }
        });
        settingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Change the settings", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
