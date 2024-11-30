package com.example.datesafe;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class CreateProfile extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_PERMISSION = 2;
    private ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        Button uploadPhotosButton = findViewById(R.id.uploadPhotosButton);
        Button doneButton = findViewById(R.id.doneButton);
        profileImageView = findViewById(R.id.profileImageView);  // Assuming you have an ImageView to display the selected image

        uploadPhotosButton.setOnClickListener(v -> {
            // Check if we have permission to read external storage
            if (ContextCompat.checkSelfPermission(CreateProfile.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with the image picker
                openImagePicker();
            } else {
                // Permission not granted, request permission
                ActivityCompat.requestPermissions(CreateProfile.this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PERMISSION);
            }
        });

        doneButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateProfile.this, SwitchModes.class);
            startActivity(intent);
        });
    }

    // Open image picker after permission is granted
    private void openImagePicker() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            // For Android 14+, use the new photo picker
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        } else {
            // For earlier Android versions, use the old method
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        }
    }

    // Handle the result of the image picker
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            // Display the selected image in ImageView
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
                openImagePicker();
            } else {
                // Permission denied, you can show a message to the user
            }
        }
    }
}
