package com.example.datesafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CreateProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        Button uploadPhotosButton = findViewById(R.id.uploadPhotosButton);
        Button doneButton = findViewById(R.id.doneButton);

        uploadPhotosButton.setOnClickListener(v -> {
            // Handle photo upload
        });

        doneButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this, Swipe.class);
            startActivity(intent);
        });
    }
}
