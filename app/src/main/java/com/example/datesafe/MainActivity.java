package com.example.datesafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    private TextView appTitle;
    private ImageView heartIcon;
    private Button loginButton;
    private Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Set the layout to activity_main.xml

        // Initialize the UI elements
        appTitle = findViewById(R.id.appTitle);
        heartIcon = findViewById(R.id.heartIcon);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);

        // Set up the behavior for buttons
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Login button click
                // Add your login functionality here (e.g., navigate to login screen)
                // For now, we just print a message
                System.out.println("Login Button Clicked");
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Create Account button click
                // Add your account creation functionality here (e.g., navigate to registration screen)
                // For now, we just print a message
                System.out.println("Create Account Button Clicked");
            }
        });
    }
}



