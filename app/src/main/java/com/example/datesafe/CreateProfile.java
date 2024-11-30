package com.example.datesafe;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

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
        profileImageView = findViewById(R.id.profileImageView);  // Assuming you have an ImageView to display the selected image

        uploadPhotosButton.setOnClickListener(v -> {
            // Check if we have permission to read selected media (Android 14+)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                // On Android 14+, permission check for the new photo picker
                if (ContextCompat.checkSelfPermission(CreateProfile.this, android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED)
                        == PackageManager.PERMISSION_GRANTED) {
                    openPhotoPicker();
                } else {
                    // Request the new photo picker permission
                    ActivityCompat.requestPermissions(CreateProfile.this,
                            new String[]{android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED},
                            REQUEST_PERMISSION);
                }
            } else {
                // For devices below Android 14, use the traditional image picker
                if (ContextCompat.checkSelfPermission(CreateProfile.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED) {
                    openImagePicker();
                } else {
                    ActivityCompat.requestPermissions(CreateProfile.this,
                            new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                            REQUEST_PERMISSION);
                }
            }
        });

        doneButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this, SwitchModes.class);
            startActivity(intent);
        });
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

    // Handle the result of the photo picker
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            // Display the selected image in the ImageView
            profileImageView.setImageURI(imageUri);
        }
    }

    // Handle the result of the permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with the image picker
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    openPhotoPicker();
                } else {
                    openImagePicker();
                }
            } else {
                // Permission denied, you can show a message to the user
            }
        }
    }
}

