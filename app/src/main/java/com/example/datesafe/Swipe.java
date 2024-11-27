package com.example.datesafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Swipe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findViewById(R.id.like_button).setOnClickListener(v -> {
            // Show the Toast message
            Toast.makeText(Swipe.this, "Like has been sent to the user!", Toast.LENGTH_SHORT).show();

            // Navigate to the next activity
            Intent intent = new Intent(Swipe.this, WarningMan.class);
            startActivity(intent);
        });
    }
}

