package com.example.datesafe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Set the layout to activity_main.xml
        Log.d("MainActivity", "onCreate called");
        // Initialize the UI elements
        Button loginButton = findViewById(R.id.loginButton);
        Button createAccount = findViewById(R.id.createAccountButton);
        Log.d("MainActivity", "Buttons initialized: " + (loginButton != null && createAccount != null));

        Log.d("MainActivity", "UI elements initialized");
        // Set up the behavior for buttons
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Login functionality here

            }
        });

        createAccount.setOnClickListener(view -> {
            Log.d("MainActivity", "Create Account Button Clicked");
            Intent intent = new Intent(MainActivity.this, GovernmentId.class);
            startActivity(intent);
        });
    }
}



