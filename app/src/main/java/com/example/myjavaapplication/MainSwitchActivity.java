package com.example.myjavaapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;

public class MainSwitchActivity extends AppCompatActivity {

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
                Toast.makeText(MainSwitchActivity.this, "Back Button", Toast.LENGTH_SHORT).show();
            }
        });
        logOutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Logout Button", Toast.LENGTH_SHORT).show();
            }
        });
        profileB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Profile Image", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle each of the buttons with the OnClickListener
        todoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "TODO LIST", Toast.LENGTH_SHORT).show();
            }
        });
        editProfileB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Editing Profile", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle each of the cards with the OnClickListener
        contributeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Contribute Articles", Toast.LENGTH_SHORT).show();
            }
        });
        practiceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Practice Programming", Toast.LENGTH_SHORT).show();
            }
        });
        learnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Learn Programming", Toast.LENGTH_SHORT).show();
            }
        });
        interestsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Filter your Interests", Toast.LENGTH_SHORT).show();
            }
        });
        helpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Anything Help you want?", Toast.LENGTH_SHORT).show();
            }
        });
        settingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSwitchActivity.this, "Change the settings", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

