package com.example.myjavaapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.loginButton);

        //creating an event listener for loginButton
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if (user.equals("kiprono")&& pass.equals("kiprono")) {
                    Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this,"Invalid Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


