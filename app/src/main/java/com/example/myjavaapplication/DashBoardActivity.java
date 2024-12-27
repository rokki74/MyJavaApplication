package com.example.myjavaapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;

import com.example.myjavaapplication.api.ApiClient;
import com.example.myjavaapplication.api.ApiInterface;
import com.example.myjavaapplication.api.Student;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity {

    private void getStudents() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<List<Student>> call = apiInterface.getStudents();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Student>> call, Response<List<Student>> response) {
                if (response.isSuccessful()) {
                    List<Student> students = response.body();
                    // Process the list of students
//                    ArrayList<Student> studentArrayList = new ArrayList<>(students);
//
//                    Intent intent = new Intent(DashBoardActivity.this, StudentListActivity.class);
//                    intent.putParcelableArrayListExtra("studentList", studentArrayList);
//                    startActivity(intent);

                    Gson gson = new Gson();
                    String jsonStudents = gson.toJson(students);
                    Intent intent = new Intent(DashBoardActivity.this, StudentListActivity.class);
                    intent.putExtra("studentListJson", jsonStudents);
                    startActivity(intent);

                    // Print the received JSON response to Logcat
                    Log.d("NetworkResponse", "Received Response: " + response.body().toString());

                    for (Student student : students) {
                        Log.d("DashBoardActivity", "Student: " + student.getTitle() + ", Grade: " + student.getCompleted());
                    }
                    Toast.makeText(DashBoardActivity.this, "Students fetched successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("DashBoardActivity", "Error: " + response.code());
                    Toast.makeText(DashBoardActivity.this, "Error fetching students", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<Student>> call, Throwable t) {
                Log.e("DashBoardActivity", "Failure: " + t.getMessage());
                Toast.makeText(DashBoardActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Register all the ImageButtons with their appropriate IDs
        ImageButton backB = (ImageButton) findViewById(R.id.backB);
        ImageButton logOutB = (ImageButton) findViewById(R.id.logOutB);
        ImageButton profileB = (ImageButton) findViewById(R.id.profileB);

        // Register all the Buttons with their appropriate IDs
        Button todoB = (Button) findViewById(R.id.todoB);
        Button editProfileB = (Button) findViewById(R.id.editProfileB);

        // Register all the card views with their appropriate IDs
        CardView contributeCard = (CardView) findViewById(R.id.contributeCard);
        CardView practiceCard = (CardView) findViewById(R.id.practiceCard);
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
        contributeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Contribute Articles", Toast.LENGTH_SHORT).show();
            }
        });
        practiceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashBoardActivity.this, "Practice Programming", Toast.LENGTH_SHORT).show();
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
