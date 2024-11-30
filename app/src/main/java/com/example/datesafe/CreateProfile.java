package com.example.datesafe;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class CreateProfile extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_PERMISSION = 2;
    private static final int REQUEST_IMAGE_PICK = 3;
    private ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        Button uploadPhotosButton = findViewById(R.id.uploadPhotosButton);
        Button doneButton = findViewById(R.id.doneButton);
        profileImageView = findViewById(R.id.profileImageView);

        // Handle click event for upload photos button
        uploadPhotosButton.setOnClickListener(v -> checkPermissions());

        // Handle click event for done button (just navigate to next activity)
        doneButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this, SwitchModes.class);
            startActivity(intent);
        });
    }

    // Check permissions based on Android version
    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {  // Android 14+
            if (ContextCompat.checkSelfPermission(CreateProfile.this, android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED)
                    != PackageManager.PERMISSION_GRANTED) {
                // Request permission for accessing selected visual media
                ActivityCompat.requestPermissions(CreateProfile.this,
                        new String[]{android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED},
                        REQUEST_PERMISSION);
            } else {
                // Permission already granted, proceed with photo picker
                openPhotoPicker();
            }
        } else {
            // For devices below Android 14, use traditional permission check
            if (ContextCompat.checkSelfPermission(CreateProfile.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                // Request permission for reading external storage
                ActivityCompat.requestPermissions(CreateProfile.this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PERMISSION);
            } else {
                // Permission already granted, proceed with image picker
                openImagePicker();
            }
        }
    }

    // Open the new photo picker for Android 14+ users
    private void openPhotoPicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    // Open the traditional image picker for devices below Android 14
    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    // Handle the result of the photo picker or traditional image picker
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            // Display the selected image in ImageView
            profileImageView.setImageURI(imageUri);
        } else {
            Toast.makeText(this, "Image selection failed!", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle the result of the permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with opening the photo picker
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    openPhotoPicker();
                } else {
                    openImagePicker();
                }
            } else {
                // Permission denied, show message to user
                Toast.makeText(this, "Permission denied, cannot access photos.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
