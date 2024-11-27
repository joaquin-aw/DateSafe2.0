package com.example.datesafe;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Swipe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findViewById(R.id.like_button).setOnClickListener(v -> {
            Intent intent = new Intent(Swipe.this, WarningMan.class);
            startActivity(intent);
        });

    }
}
