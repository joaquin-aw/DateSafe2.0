package com.example.datesafe;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class PicturesMatch extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        findViewById(R.id.makeProfileButton).setOnClickListener(v -> {
            Intent intent = new Intent(PicturesMatch.this, CreateProfile.class);
            startActivity(intent);
        });
    }
}
