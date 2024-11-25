package com.example.datesafe;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Swipe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_screen);

        findViewById(R.id.startSwipingButton).setOnClickListener(v -> {
            // Handle swiping action (e.g., navigate to a new activity or fragment)
        });
    }
}
