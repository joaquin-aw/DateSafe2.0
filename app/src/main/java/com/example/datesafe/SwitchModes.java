package com.example.datesafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SwitchModes extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_modes);

        Button eventButton = findViewById(R.id.eventModeButton);
        Button swipeButton = findViewById(R.id.swipeModeButton);


        swipeButton.setOnClickListener(v -> {
            Intent intent = new Intent(SwitchModes.this, Swipe.class);
            startActivity(intent);
        });
    }
}
