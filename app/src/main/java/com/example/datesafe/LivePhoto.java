package com.example.datesafe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LivePhoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_photo); // Set the layout to activity_main.xml
        Log.d("LivePhoto", "onCreate called");
        // Initialize the UI elements
        Button takePhotoButton = findViewById(R.id.takePhotoButton);

        // Set up the behavior for buttons
        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Login functionality here

            }
        });

    }
}
