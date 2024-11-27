package com.example.datesafe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        // Get the ImageView and apply the animation
        ImageView loadingImage = findViewById(R.id.loadingImage);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        loadingImage.startAnimation(rotateAnimation);

        // Wait for 5 seconds before transitioning to the next screen
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(LoadingActivity.this, PicturesMatch.class);
            startActivity(intent);
            finish();
        }, 5000);
    }
}
